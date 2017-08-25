package org.apache.commons.math3.fraction;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.math.BigInteger;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;

public class Fraction extends Number implements Serializable , Comparable<Fraction> , FieldElement<Fraction> {
    public static final Fraction TWO = new Fraction(2, 1);

    public static final Fraction ONE = new Fraction(1, 1);

    public static final Fraction ZERO = new Fraction(0, 1);

    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);

    public static final Fraction ONE_FIFTH = new Fraction(1, 5);

    public static final Fraction ONE_HALF = new Fraction(1, 2);

    public static final Fraction ONE_QUARTER = new Fraction(1, 4);

    public static final Fraction ONE_THIRD = new Fraction(1, 3);

    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);

    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);

    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);

    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);

    public static final Fraction TWO_THIRDS = new Fraction(2, 3);

    public static final Fraction MINUS_ONE = new Fraction((-1), 1);

    private static final long serialVersionUID = 3698073679419233275L;

    private final int denominator;

    private final int numerator;

    public Fraction(double value) throws FractionConversionException {
        this(value, 1.0E-5, 100);
        ConstructorContext _bcornu_methode_context1086 = new ConstructorContext(Fraction.class, 98, 3247, 3584);
        try {
        } finally {
            _bcornu_methode_context1086.methodEnd();
        }
    }

    public Fraction(double value, double epsilon, int maxIterations) throws FractionConversionException {
        this(value, epsilon, Integer.MAX_VALUE, maxIterations);
        ConstructorContext _bcornu_methode_context1087 = new ConstructorContext(Fraction.class, 118, 3591, 4440);
        try {
        } finally {
            _bcornu_methode_context1087.methodEnd();
        }
    }

    public Fraction(double value, int maxDenominator) throws FractionConversionException {
        this(value, 0, maxDenominator, 100);
        ConstructorContext _bcornu_methode_context1088 = new ConstructorContext(Fraction.class, 138, 4447, 5125);
        try {
        } finally {
            _bcornu_methode_context1088.methodEnd();
        }
    }

    private Fraction(double value, double epsilon, int maxDenominator, int maxIterations) throws FractionConversionException {
        ConstructorContext _bcornu_methode_context1089 = new ConstructorContext(Fraction.class, 175, 5132, 8438);
        try {
            long overflow = CallChecker.varInit(((long) (Integer.MAX_VALUE)), "overflow", 178, 6685, 6718);
            double r0 = CallChecker.varInit(((double) (value)), "r0", 179, 6728, 6745);
            long a0 = CallChecker.varInit(((long) ((long) (FastMath.floor(r0)))), "a0", 180, 6755, 6789);
            if ((FastMath.abs(a0)) > overflow) {
                throw new FractionConversionException(value, a0, 1L);
            }
            if ((FastMath.abs((a0 - value))) < epsilon) {
                this.numerator = ((int) (a0));
                CallChecker.varAssign(this.numerator, "this.numerator", 188, 7068, 7093);
                this.denominator = 1;
                CallChecker.varAssign(this.denominator, "this.denominator", 189, 7107, 7127);
                return ;
            }
            long p0 = CallChecker.varInit(((long) (1)), "p0", 193, 7168, 7179);
            long q0 = CallChecker.varInit(((long) (0)), "q0", 194, 7189, 7200);
            long p1 = CallChecker.varInit(((long) (a0)), "p1", 195, 7210, 7222);
            long q1 = CallChecker.varInit(((long) (1)), "q1", 196, 7232, 7243);
            long p2 = CallChecker.varInit(((long) (0)), "p2", 198, 7254, 7265);
            long q2 = CallChecker.varInit(((long) (1)), "q2", 199, 7275, 7286);
            int n = CallChecker.varInit(((int) (0)), "n", 201, 7297, 7306);
            boolean stop = CallChecker.varInit(((boolean) (false)), "stop", 202, 7316, 7336);
            do {
                ++n;
                double r1 = CallChecker.varInit(((double) (1.0 / (r0 - a0))), "r1", 205, 7380, 7407);
                long a1 = CallChecker.varInit(((long) ((long) (FastMath.floor(r1)))), "a1", 206, 7421, 7455);
                p2 = (a1 * p1) + p0;
                CallChecker.varAssign(p2, "p2", 207, 7469, 7488);
                q2 = (a1 * q1) + q0;
                CallChecker.varAssign(q2, "q2", 208, 7502, 7521);
                if (((FastMath.abs(p2)) > overflow) || ((FastMath.abs(q2)) > overflow)) {
                    throw new FractionConversionException(value, p2, q2);
                }
                double convergent = CallChecker.varInit(((double) (((double) (p2)) / ((double) (q2)))), "convergent", 213, 7702, 7745);
                if (((n < maxIterations) && ((FastMath.abs((convergent - value))) > epsilon)) && (q2 < maxDenominator)) {
                    p0 = p1;
                    CallChecker.varAssign(p0, "p0", 215, 7869, 7876);
                    p1 = p2;
                    CallChecker.varAssign(p1, "p1", 216, 7894, 7901);
                    q0 = q1;
                    CallChecker.varAssign(q0, "q0", 217, 7919, 7926);
                    q1 = q2;
                    CallChecker.varAssign(q1, "q1", 218, 7944, 7951);
                    a0 = a1;
                    CallChecker.varAssign(a0, "a0", 219, 7969, 7976);
                    r0 = r1;
                    CallChecker.varAssign(r0, "r0", 220, 7994, 8001);
                }else {
                    stop = true;
                    CallChecker.varAssign(stop, "stop", 222, 8040, 8051);
                }
            } while (!stop );
            if (n >= maxIterations) {
                throw new FractionConversionException(value, maxIterations);
            }
            if (q2 < maxDenominator) {
                this.numerator = ((int) (p2));
                CallChecker.varAssign(this.numerator, "this.numerator", 231, 8258, 8283);
                this.denominator = ((int) (q2));
                CallChecker.varAssign(this.denominator, "this.denominator", 232, 8297, 8324);
            }else {
                this.numerator = ((int) (p1));
                CallChecker.varAssign(this.numerator, "this.numerator", 234, 8355, 8380);
                this.denominator = ((int) (q1));
                CallChecker.varAssign(this.denominator, "this.denominator", 235, 8394, 8421);
            }
        } finally {
            _bcornu_methode_context1089.methodEnd();
        }
    }

    public Fraction(int num) {
        this(num, 1);
        ConstructorContext _bcornu_methode_context1090 = new ConstructorContext(Fraction.class, 245, 8445, 8617);
        try {
        } finally {
            _bcornu_methode_context1090.methodEnd();
        }
    }

    public Fraction(int num, int den) {
        ConstructorContext _bcornu_methode_context1091 = new ConstructorContext(Fraction.class, 256, 8624, 9835);
        try {
            if (den == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR_IN_FRACTION, num, den);
            }
            if (den < 0) {
                if ((num == (Integer.MIN_VALUE)) || (den == (Integer.MIN_VALUE))) {
                    throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, num, den);
                }
                num = -num;
                CallChecker.varAssign(num, "num", 267, 9400, 9410);
                den = -den;
                CallChecker.varAssign(den, "den", 268, 9424, 9434);
            }
            final int d = CallChecker.varInit(((int) (ArithmeticUtils.gcd(num, den))), "d", 271, 9454, 9573);
            if (d > 1) {
                num /= d;
                CallChecker.varAssign(num, "num", 273, 9608, 9616);
                den /= d;
                CallChecker.varAssign(den, "den", 274, 9630, 9638);
            }
            if (den < 0) {
                num = -num;
                CallChecker.varAssign(num, "num", 279, 9721, 9731);
                den = -den;
                CallChecker.varAssign(den, "den", 280, 9745, 9755);
            }
            this.numerator = num;
            CallChecker.varAssign(this.numerator, "this.numerator", 282, 9775, 9797);
            this.denominator = den;
            CallChecker.varAssign(this.denominator, "this.denominator", 283, 9807, 9829);
        } finally {
            _bcornu_methode_context1091.methodEnd();
        }
    }

    public Fraction abs() {
        MethodContext _bcornu_methode_context4857 = new MethodContext(Fraction.class, 290, 9842, 10124);
        try {
            CallChecker.varInit(this, "this", 290, 9842, 10124);
            CallChecker.varInit(this.numerator, "numerator", 290, 9842, 10124);
            CallChecker.varInit(this.denominator, "denominator", 290, 9842, 10124);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 290, 9842, 10124);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 290, 9842, 10124);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 290, 9842, 10124);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 290, 9842, 10124);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 290, 9842, 10124);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 290, 9842, 10124);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 290, 9842, 10124);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 290, 9842, 10124);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 290, 9842, 10124);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 290, 9842, 10124);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 290, 9842, 10124);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 290, 9842, 10124);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 290, 9842, 10124);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 290, 9842, 10124);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 290, 9842, 10124);
            Fraction ret = CallChecker.init(Fraction.class);
            if ((numerator) >= 0) {
                ret = this;
                CallChecker.varAssign(ret, "ret", 293, 10033, 10043);
            }else {
                ret = negate();
                CallChecker.varAssign(ret, "ret", 295, 10074, 10088);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4857.methodEnd();
        }
    }

    public int compareTo(Fraction object) {
        MethodContext _bcornu_methode_context4858 = new MethodContext(int.class, 306, 10131, 10605);
        try {
            CallChecker.varInit(this, "this", 306, 10131, 10605);
            CallChecker.varInit(object, "object", 306, 10131, 10605);
            CallChecker.varInit(this.numerator, "numerator", 306, 10131, 10605);
            CallChecker.varInit(this.denominator, "denominator", 306, 10131, 10605);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 306, 10131, 10605);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 306, 10131, 10605);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 306, 10131, 10605);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 306, 10131, 10605);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 306, 10131, 10605);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 306, 10131, 10605);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 306, 10131, 10605);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 306, 10131, 10605);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 306, 10131, 10605);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 306, 10131, 10605);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 306, 10131, 10605);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 306, 10131, 10605);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 306, 10131, 10605);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 306, 10131, 10605);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 306, 10131, 10605);
            long nOd = CallChecker.init(long.class);
            if (CallChecker.beforeDeref(object, Fraction.class, 307, 10463, 10468)) {
                object = CallChecker.beforeCalled(object, Fraction.class, 307, 10463, 10468);
                nOd = ((long) (numerator)) * (CallChecker.isCalled(object, Fraction.class, 307, 10463, 10468).denominator);
                CallChecker.varAssign(nOd, "nOd", 307, 10463, 10468);
            }
            long dOn = CallChecker.init(long.class);
            if (CallChecker.beforeDeref(object, Fraction.class, 308, 10525, 10530)) {
                object = CallChecker.beforeCalled(object, Fraction.class, 308, 10525, 10530);
                dOn = ((long) (denominator)) * (CallChecker.isCalled(object, Fraction.class, 308, 10525, 10530).numerator);
                CallChecker.varAssign(dOn, "dOn", 308, 10525, 10530);
            }
            if (nOd < dOn) {
                return -1;
            }else {
                return nOd > dOn ? +1 : 0;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4858.methodEnd();
        }
    }

    @Override
    public double doubleValue() {
        MethodContext _bcornu_methode_context4859 = new MethodContext(double.class, 318, 10612, 10905);
        try {
            CallChecker.varInit(this, "this", 318, 10612, 10905);
            CallChecker.varInit(this.numerator, "numerator", 318, 10612, 10905);
            CallChecker.varInit(this.denominator, "denominator", 318, 10612, 10905);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 318, 10612, 10905);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 318, 10612, 10905);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 318, 10612, 10905);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 318, 10612, 10905);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 318, 10612, 10905);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 318, 10612, 10905);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 318, 10612, 10905);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 318, 10612, 10905);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 318, 10612, 10905);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 318, 10612, 10905);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 318, 10612, 10905);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 318, 10612, 10905);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 318, 10612, 10905);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 318, 10612, 10905);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 318, 10612, 10905);
            return ((double) (numerator)) / ((double) (denominator));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4859.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context4860 = new MethodContext(boolean.class, 332, 10912, 11850);
        try {
            CallChecker.varInit(this, "this", 332, 10912, 11850);
            CallChecker.varInit(other, "other", 332, 10912, 11850);
            CallChecker.varInit(this.numerator, "numerator", 332, 10912, 11850);
            CallChecker.varInit(this.denominator, "denominator", 332, 10912, 11850);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 332, 10912, 11850);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 332, 10912, 11850);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 332, 10912, 11850);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 332, 10912, 11850);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 332, 10912, 11850);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 332, 10912, 11850);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 332, 10912, 11850);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 332, 10912, 11850);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 332, 10912, 11850);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 332, 10912, 11850);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 332, 10912, 11850);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 332, 10912, 11850);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 332, 10912, 11850);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 332, 10912, 11850);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 332, 10912, 11850);
            if ((this) == other) {
                return true;
            }
            if (other instanceof Fraction) {
                Fraction rhs = CallChecker.varInit(((Fraction) (other)), "rhs", 339, 11681, 11711);
                rhs = CallChecker.beforeCalled(rhs, Fraction.class, 340, 11746, 11748);
                rhs = CallChecker.beforeCalled(rhs, Fraction.class, 341, 11796, 11798);
                return ((numerator) == (CallChecker.isCalled(rhs, Fraction.class, 340, 11746, 11748).numerator)) && ((denominator) == (CallChecker.isCalled(rhs, Fraction.class, 341, 11796, 11798).denominator));
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4860.methodEnd();
        }
    }

    @Override
    public float floatValue() {
        MethodContext _bcornu_methode_context4861 = new MethodContext(float.class, 352, 11857, 12127);
        try {
            CallChecker.varInit(this, "this", 352, 11857, 12127);
            CallChecker.varInit(this.numerator, "numerator", 352, 11857, 12127);
            CallChecker.varInit(this.denominator, "denominator", 352, 11857, 12127);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 352, 11857, 12127);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 352, 11857, 12127);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 352, 11857, 12127);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 352, 11857, 12127);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 352, 11857, 12127);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 352, 11857, 12127);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 352, 11857, 12127);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 352, 11857, 12127);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 352, 11857, 12127);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 352, 11857, 12127);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 352, 11857, 12127);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 352, 11857, 12127);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 352, 11857, 12127);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 352, 11857, 12127);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 352, 11857, 12127);
            return ((float) (doubleValue()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4861.methodEnd();
        }
    }

    public int getDenominator() {
        MethodContext _bcornu_methode_context4862 = new MethodContext(int.class, 360, 12134, 12275);
        try {
            CallChecker.varInit(this, "this", 360, 12134, 12275);
            CallChecker.varInit(this.numerator, "numerator", 360, 12134, 12275);
            CallChecker.varInit(this.denominator, "denominator", 360, 12134, 12275);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 360, 12134, 12275);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 360, 12134, 12275);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 360, 12134, 12275);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 360, 12134, 12275);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 360, 12134, 12275);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 360, 12134, 12275);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 360, 12134, 12275);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 360, 12134, 12275);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 360, 12134, 12275);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 360, 12134, 12275);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 360, 12134, 12275);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 360, 12134, 12275);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 360, 12134, 12275);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 360, 12134, 12275);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 360, 12134, 12275);
            return denominator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4862.methodEnd();
        }
    }

    public int getNumerator() {
        MethodContext _bcornu_methode_context4863 = new MethodContext(int.class, 368, 12282, 12415);
        try {
            CallChecker.varInit(this, "this", 368, 12282, 12415);
            CallChecker.varInit(this.numerator, "numerator", 368, 12282, 12415);
            CallChecker.varInit(this.denominator, "denominator", 368, 12282, 12415);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 368, 12282, 12415);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 368, 12282, 12415);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 368, 12282, 12415);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 368, 12282, 12415);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 368, 12282, 12415);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 368, 12282, 12415);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 368, 12282, 12415);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 368, 12282, 12415);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 368, 12282, 12415);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 368, 12282, 12415);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 368, 12282, 12415);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 368, 12282, 12415);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 368, 12282, 12415);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 368, 12282, 12415);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 368, 12282, 12415);
            return numerator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4863.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context4864 = new MethodContext(int.class, 377, 12422, 12627);
        try {
            CallChecker.varInit(this, "this", 377, 12422, 12627);
            CallChecker.varInit(this.numerator, "numerator", 377, 12422, 12627);
            CallChecker.varInit(this.denominator, "denominator", 377, 12422, 12627);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 377, 12422, 12627);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 377, 12422, 12627);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 377, 12422, 12627);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 377, 12422, 12627);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 377, 12422, 12627);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 377, 12422, 12627);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 377, 12422, 12627);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 377, 12422, 12627);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 377, 12422, 12627);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 377, 12422, 12627);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 377, 12422, 12627);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 377, 12422, 12627);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 377, 12422, 12627);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 377, 12422, 12627);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 377, 12422, 12627);
            return (37 * ((37 * 17) + (numerator))) + (denominator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4864.methodEnd();
        }
    }

    @Override
    public int intValue() {
        MethodContext _bcornu_methode_context4865 = new MethodContext(int.class, 387, 12634, 12877);
        try {
            CallChecker.varInit(this, "this", 387, 12634, 12877);
            CallChecker.varInit(this.numerator, "numerator", 387, 12634, 12877);
            CallChecker.varInit(this.denominator, "denominator", 387, 12634, 12877);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 387, 12634, 12877);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 387, 12634, 12877);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 387, 12634, 12877);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 387, 12634, 12877);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 387, 12634, 12877);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 387, 12634, 12877);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 387, 12634, 12877);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 387, 12634, 12877);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 387, 12634, 12877);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 387, 12634, 12877);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 387, 12634, 12877);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 387, 12634, 12877);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 387, 12634, 12877);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 387, 12634, 12877);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 387, 12634, 12877);
            return ((int) (doubleValue()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4865.methodEnd();
        }
    }

    @Override
    public long longValue() {
        MethodContext _bcornu_methode_context4866 = new MethodContext(long.class, 397, 12884, 13130);
        try {
            CallChecker.varInit(this, "this", 397, 12884, 13130);
            CallChecker.varInit(this.numerator, "numerator", 397, 12884, 13130);
            CallChecker.varInit(this.denominator, "denominator", 397, 12884, 13130);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 397, 12884, 13130);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 397, 12884, 13130);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 397, 12884, 13130);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 397, 12884, 13130);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 397, 12884, 13130);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 397, 12884, 13130);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 397, 12884, 13130);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 397, 12884, 13130);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 397, 12884, 13130);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 397, 12884, 13130);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 397, 12884, 13130);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 397, 12884, 13130);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 397, 12884, 13130);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 397, 12884, 13130);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 397, 12884, 13130);
            return ((long) (doubleValue()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4866.methodEnd();
        }
    }

    public Fraction negate() {
        MethodContext _bcornu_methode_context4867 = new MethodContext(Fraction.class, 405, 13137, 13501);
        try {
            CallChecker.varInit(this, "this", 405, 13137, 13501);
            CallChecker.varInit(this.numerator, "numerator", 405, 13137, 13501);
            CallChecker.varInit(this.denominator, "denominator", 405, 13137, 13501);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 405, 13137, 13501);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 405, 13137, 13501);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 405, 13137, 13501);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 405, 13137, 13501);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 405, 13137, 13501);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 405, 13137, 13501);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 405, 13137, 13501);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 405, 13137, 13501);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 405, 13137, 13501);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 405, 13137, 13501);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 405, 13137, 13501);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 405, 13137, 13501);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 405, 13137, 13501);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 405, 13137, 13501);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 405, 13137, 13501);
            if ((numerator) == (Integer.MIN_VALUE)) {
                throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, numerator, denominator);
            }
            return new Fraction((-(numerator)), denominator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4867.methodEnd();
        }
    }

    public Fraction reciprocal() {
        MethodContext _bcornu_methode_context4868 = new MethodContext(Fraction.class, 416, 13508, 13710);
        try {
            CallChecker.varInit(this, "this", 416, 13508, 13710);
            CallChecker.varInit(this.numerator, "numerator", 416, 13508, 13710);
            CallChecker.varInit(this.denominator, "denominator", 416, 13508, 13710);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 416, 13508, 13710);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 416, 13508, 13710);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 416, 13508, 13710);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 416, 13508, 13710);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 416, 13508, 13710);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 416, 13508, 13710);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 416, 13508, 13710);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 416, 13508, 13710);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 416, 13508, 13710);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 416, 13508, 13710);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 416, 13508, 13710);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 416, 13508, 13710);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 416, 13508, 13710);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 416, 13508, 13710);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 416, 13508, 13710);
            return new Fraction(denominator, numerator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4868.methodEnd();
        }
    }

    public Fraction add(Fraction fraction) {
        MethodContext _bcornu_methode_context4869 = new MethodContext(Fraction.class, 430, 13717, 14304);
        try {
            CallChecker.varInit(this, "this", 430, 13717, 14304);
            CallChecker.varInit(fraction, "fraction", 430, 13717, 14304);
            CallChecker.varInit(this.numerator, "numerator", 430, 13717, 14304);
            CallChecker.varInit(this.denominator, "denominator", 430, 13717, 14304);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 430, 13717, 14304);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 430, 13717, 14304);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 430, 13717, 14304);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 430, 13717, 14304);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 430, 13717, 14304);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 430, 13717, 14304);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 430, 13717, 14304);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 430, 13717, 14304);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 430, 13717, 14304);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 430, 13717, 14304);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 430, 13717, 14304);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 430, 13717, 14304);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 430, 13717, 14304);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 430, 13717, 14304);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 430, 13717, 14304);
            return addSub(fraction, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4869.methodEnd();
        }
    }

    public Fraction add(final int i) {
        MethodContext _bcornu_methode_context4870 = new MethodContext(Fraction.class, 439, 14311, 14545);
        try {
            CallChecker.varInit(this, "this", 439, 14311, 14545);
            CallChecker.varInit(i, "i", 439, 14311, 14545);
            CallChecker.varInit(this.numerator, "numerator", 439, 14311, 14545);
            CallChecker.varInit(this.denominator, "denominator", 439, 14311, 14545);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 439, 14311, 14545);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 439, 14311, 14545);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 439, 14311, 14545);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 439, 14311, 14545);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 439, 14311, 14545);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 439, 14311, 14545);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 439, 14311, 14545);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 439, 14311, 14545);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 439, 14311, 14545);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 439, 14311, 14545);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 439, 14311, 14545);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 439, 14311, 14545);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 439, 14311, 14545);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 439, 14311, 14545);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 439, 14311, 14545);
            return new Fraction(((numerator) + (i * (denominator))), denominator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4870.methodEnd();
        }
    }

    public Fraction subtract(Fraction fraction) {
        MethodContext _bcornu_methode_context4871 = new MethodContext(Fraction.class, 453, 14552, 15151);
        try {
            CallChecker.varInit(this, "this", 453, 14552, 15151);
            CallChecker.varInit(fraction, "fraction", 453, 14552, 15151);
            CallChecker.varInit(this.numerator, "numerator", 453, 14552, 15151);
            CallChecker.varInit(this.denominator, "denominator", 453, 14552, 15151);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 453, 14552, 15151);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 453, 14552, 15151);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 453, 14552, 15151);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 453, 14552, 15151);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 453, 14552, 15151);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 453, 14552, 15151);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 453, 14552, 15151);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 453, 14552, 15151);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 453, 14552, 15151);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 453, 14552, 15151);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 453, 14552, 15151);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 453, 14552, 15151);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 453, 14552, 15151);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 453, 14552, 15151);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 453, 14552, 15151);
            return addSub(fraction, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4871.methodEnd();
        }
    }

    public Fraction subtract(final int i) {
        MethodContext _bcornu_methode_context4872 = new MethodContext(Fraction.class, 462, 15158, 15409);
        try {
            CallChecker.varInit(this, "this", 462, 15158, 15409);
            CallChecker.varInit(i, "i", 462, 15158, 15409);
            CallChecker.varInit(this.numerator, "numerator", 462, 15158, 15409);
            CallChecker.varInit(this.denominator, "denominator", 462, 15158, 15409);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 462, 15158, 15409);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 462, 15158, 15409);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 462, 15158, 15409);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 462, 15158, 15409);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 462, 15158, 15409);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 462, 15158, 15409);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 462, 15158, 15409);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 462, 15158, 15409);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 462, 15158, 15409);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 462, 15158, 15409);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 462, 15158, 15409);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 462, 15158, 15409);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 462, 15158, 15409);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 462, 15158, 15409);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 462, 15158, 15409);
            return new Fraction(((numerator) - (i * (denominator))), denominator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4872.methodEnd();
        }
    }

    private Fraction addSub(Fraction fraction, boolean isAdd) {
        MethodContext _bcornu_methode_context4873 = new MethodContext(Fraction.class, 476, 15416, 18107);
        try {
            CallChecker.varInit(this, "this", 476, 15416, 18107);
            CallChecker.varInit(isAdd, "isAdd", 476, 15416, 18107);
            CallChecker.varInit(fraction, "fraction", 476, 15416, 18107);
            CallChecker.varInit(this.numerator, "numerator", 476, 15416, 18107);
            CallChecker.varInit(this.denominator, "denominator", 476, 15416, 18107);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 476, 15416, 18107);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 476, 15416, 18107);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 476, 15416, 18107);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 476, 15416, 18107);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 476, 15416, 18107);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 476, 15416, 18107);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 476, 15416, 18107);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 476, 15416, 18107);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 476, 15416, 18107);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 476, 15416, 18107);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 476, 15416, 18107);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 476, 15416, 18107);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 476, 15416, 18107);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 476, 15416, 18107);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 476, 15416, 18107);
            if (fraction == null) {
                throw new NullArgumentException(LocalizedFormats.FRACTION);
            }
            if ((numerator) == 0) {
                if (isAdd) {
                    return fraction;
                }else {
                    return fraction.negate();
                }
            }
            if ((fraction.numerator) == 0) {
                return this;
            }
            int d1 = CallChecker.varInit(((int) (ArithmeticUtils.gcd(this.denominator, fraction.denominator))), "d1", 489, 16404, 16467);
            if (d1 == 1) {
                int uvp = CallChecker.varInit(((int) (ArithmeticUtils.mulAndCheck(this.numerator, fraction.denominator))), "uvp", 492, 16552, 16622);
                int upv = CallChecker.varInit(((int) (ArithmeticUtils.mulAndCheck(fraction.numerator, this.denominator))), "upv", 493, 16636, 16706);
                return new Fraction((isAdd ? ArithmeticUtils.addAndCheck(uvp, upv) : ArithmeticUtils.subAndCheck(uvp, upv)), ArithmeticUtils.mulAndCheck(denominator, fraction.denominator));
            }
            BigInteger uvp = CallChecker.init(BigInteger.class);
            if (CallChecker.beforeDeref(BigInteger.valueOf(numerator), BigInteger.class, 502, 17147, 17175)) {
                uvp = CallChecker.isCalled(BigInteger.valueOf(numerator), BigInteger.class, 502, 17147, 17175).multiply(BigInteger.valueOf(((fraction.denominator) / d1)));
                CallChecker.varAssign(uvp, "uvp", 502, 17147, 17175);
            }
            BigInteger upv = CallChecker.init(BigInteger.class);
            fraction = CallChecker.beforeCalled(fraction, Fraction.class, 504, 17285, 17292);
            if (CallChecker.beforeDeref(BigInteger.valueOf(CallChecker.isCalled(fraction, Fraction.class, 504, 17285, 17292).numerator), BigInteger.class, 504, 17266, 17303)) {
                upv = CallChecker.isCalled(BigInteger.valueOf(fraction.numerator), BigInteger.class, 504, 17266, 17303).multiply(BigInteger.valueOf(((denominator) / d1)));
                CallChecker.varAssign(upv, "upv", 504, 17266, 17303);
            }
            BigInteger t = CallChecker.init(BigInteger.class);
            if (isAdd) {
                if (CallChecker.beforeDeref(uvp, BigInteger.class, 506, 17391, 17393)) {
                    uvp = CallChecker.beforeCalled(uvp, BigInteger.class, 506, 17391, 17393);
                    t = CallChecker.isCalled(uvp, BigInteger.class, 506, 17391, 17393).add(upv);
                    CallChecker.varAssign(t, "t", 506, 17383, 17422);
                }
            }else {
                if (CallChecker.beforeDeref(uvp, BigInteger.class, 506, 17406, 17408)) {
                    uvp = CallChecker.beforeCalled(uvp, BigInteger.class, 506, 17406, 17408);
                    t = CallChecker.isCalled(uvp, BigInteger.class, 506, 17406, 17408).subtract(upv);
                    CallChecker.varAssign(t, "t", 506, 17383, 17422);
                }
            }
            int tmodd1 = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(t, BigInteger.class, 509, 17547, 17547)) {
                t = CallChecker.beforeCalled(t, BigInteger.class, 509, 17547, 17547);
                if (CallChecker.beforeDeref(CallChecker.isCalled(t, BigInteger.class, 509, 17547, 17547).mod(BigInteger.valueOf(d1)), BigInteger.class, 509, 17547, 17575)) {
                    t = CallChecker.beforeCalled(t, BigInteger.class, 509, 17547, 17547);
                    tmodd1 = CallChecker.isCalled(CallChecker.isCalled(t, BigInteger.class, 509, 17547, 17547).mod(BigInteger.valueOf(d1)), BigInteger.class, 509, 17547, 17575).intValue();
                    CallChecker.varAssign(tmodd1, "tmodd1", 509, 17547, 17547);
                }
            }
            int d2 = CallChecker.init(int.class);
            if (tmodd1 == 0) {
                d2 = d1;
                CallChecker.varAssign(d2, "d2", 510, 17606, 17651);
            }else {
                d2 = ArithmeticUtils.gcd(tmodd1, d1);
                CallChecker.varAssign(d2, "d2", 510, 17606, 17651);
            }
            BigInteger w = CallChecker.init(BigInteger.class);
            if (CallChecker.beforeDeref(t, BigInteger.class, 513, 17723, 17723)) {
                t = CallChecker.beforeCalled(t, BigInteger.class, 513, 17723, 17723);
                w = CallChecker.isCalled(t, BigInteger.class, 513, 17723, 17723).divide(BigInteger.valueOf(d2));
                CallChecker.varAssign(w, "w", 513, 17723, 17723);
            }
            if (CallChecker.beforeDeref(w, BigInteger.class, 514, 17769, 17769)) {
                w = CallChecker.beforeCalled(w, BigInteger.class, 514, 17769, 17769);
                if ((CallChecker.isCalled(w, BigInteger.class, 514, 17769, 17769).bitLength()) > 31) {
                    throw new MathArithmeticException(LocalizedFormats.NUMERATOR_OVERFLOW_AFTER_MULTIPLY, w);
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(w, BigInteger.class, 518, 17978, 17978)) {
                w = CallChecker.beforeCalled(w, BigInteger.class, 518, 17978, 17978);
                return new Fraction(CallChecker.isCalled(w, BigInteger.class, 518, 17978, 17978).intValue(), ArithmeticUtils.mulAndCheck(((denominator) / d1), ((fraction.denominator) / d2)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4873.methodEnd();
        }
    }

    public Fraction multiply(Fraction fraction) {
        MethodContext _bcornu_methode_context4874 = new MethodContext(Fraction.class, 533, 18114, 19276);
        try {
            CallChecker.varInit(this, "this", 533, 18114, 19276);
            CallChecker.varInit(fraction, "fraction", 533, 18114, 19276);
            CallChecker.varInit(this.numerator, "numerator", 533, 18114, 19276);
            CallChecker.varInit(this.denominator, "denominator", 533, 18114, 19276);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 533, 18114, 19276);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 533, 18114, 19276);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 533, 18114, 19276);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 533, 18114, 19276);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 533, 18114, 19276);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 533, 18114, 19276);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 533, 18114, 19276);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 533, 18114, 19276);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 533, 18114, 19276);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 533, 18114, 19276);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 533, 18114, 19276);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 533, 18114, 19276);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 533, 18114, 19276);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 533, 18114, 19276);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 533, 18114, 19276);
            if (fraction == null) {
                throw new NullArgumentException(LocalizedFormats.FRACTION);
            }
            if (((numerator) == 0) || ((fraction.numerator) == 0)) {
                return Fraction.ZERO;
            }
            int d1 = CallChecker.varInit(((int) (ArithmeticUtils.gcd(this.numerator, fraction.denominator))), "d1", 542, 18942, 19003);
            int d2 = CallChecker.varInit(((int) (ArithmeticUtils.gcd(fraction.numerator, this.denominator))), "d2", 543, 19013, 19074);
            return Fraction.getReducedFraction(ArithmeticUtils.mulAndCheck(((numerator) / d1), ((fraction.numerator) / d2)), ArithmeticUtils.mulAndCheck(((denominator) / d2), ((fraction.denominator) / d1)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4874.methodEnd();
        }
    }

    public Fraction multiply(final int i) {
        MethodContext _bcornu_methode_context4875 = new MethodContext(Fraction.class, 554, 19283, 19521);
        try {
            CallChecker.varInit(this, "this", 554, 19283, 19521);
            CallChecker.varInit(i, "i", 554, 19283, 19521);
            CallChecker.varInit(this.numerator, "numerator", 554, 19283, 19521);
            CallChecker.varInit(this.denominator, "denominator", 554, 19283, 19521);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 554, 19283, 19521);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 554, 19283, 19521);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 554, 19283, 19521);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 554, 19283, 19521);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 554, 19283, 19521);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 554, 19283, 19521);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 554, 19283, 19521);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 554, 19283, 19521);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 554, 19283, 19521);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 554, 19283, 19521);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 554, 19283, 19521);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 554, 19283, 19521);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 554, 19283, 19521);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 554, 19283, 19521);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 554, 19283, 19521);
            return new Fraction(((numerator) * i), denominator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4875.methodEnd();
        }
    }

    public Fraction divide(Fraction fraction) {
        MethodContext _bcornu_methode_context4876 = new MethodContext(Fraction.class, 568, 19528, 20466);
        try {
            CallChecker.varInit(this, "this", 568, 19528, 20466);
            CallChecker.varInit(fraction, "fraction", 568, 19528, 20466);
            CallChecker.varInit(this.numerator, "numerator", 568, 19528, 20466);
            CallChecker.varInit(this.denominator, "denominator", 568, 19528, 20466);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 568, 19528, 20466);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 568, 19528, 20466);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 568, 19528, 20466);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 568, 19528, 20466);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 568, 19528, 20466);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 568, 19528, 20466);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 568, 19528, 20466);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 568, 19528, 20466);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 568, 19528, 20466);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 568, 19528, 20466);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 568, 19528, 20466);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 568, 19528, 20466);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 568, 19528, 20466);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 568, 19528, 20466);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 568, 19528, 20466);
            if (fraction == null) {
                throw new NullArgumentException(LocalizedFormats.FRACTION);
            }
            if ((fraction.numerator) == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_FRACTION_TO_DIVIDE_BY, fraction.numerator, fraction.denominator);
            }
            return multiply(fraction.reciprocal());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4876.methodEnd();
        }
    }

    public Fraction divide(final int i) {
        MethodContext _bcornu_methode_context4877 = new MethodContext(Fraction.class, 584, 20473, 20705);
        try {
            CallChecker.varInit(this, "this", 584, 20473, 20705);
            CallChecker.varInit(i, "i", 584, 20473, 20705);
            CallChecker.varInit(this.numerator, "numerator", 584, 20473, 20705);
            CallChecker.varInit(this.denominator, "denominator", 584, 20473, 20705);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 584, 20473, 20705);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 584, 20473, 20705);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 584, 20473, 20705);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 584, 20473, 20705);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 584, 20473, 20705);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 584, 20473, 20705);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 584, 20473, 20705);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 584, 20473, 20705);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 584, 20473, 20705);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 584, 20473, 20705);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 584, 20473, 20705);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 584, 20473, 20705);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 584, 20473, 20705);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 584, 20473, 20705);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 584, 20473, 20705);
            return new Fraction(numerator, ((denominator) * i));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4877.methodEnd();
        }
    }

    public double percentageValue() {
        MethodContext _bcornu_methode_context4878 = new MethodContext(double.class, 596, 20712, 21046);
        try {
            CallChecker.varInit(this, "this", 596, 20712, 21046);
            CallChecker.varInit(this.numerator, "numerator", 596, 20712, 21046);
            CallChecker.varInit(this.denominator, "denominator", 596, 20712, 21046);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 596, 20712, 21046);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 596, 20712, 21046);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 596, 20712, 21046);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 596, 20712, 21046);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 596, 20712, 21046);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 596, 20712, 21046);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 596, 20712, 21046);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 596, 20712, 21046);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 596, 20712, 21046);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 596, 20712, 21046);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 596, 20712, 21046);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 596, 20712, 21046);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 596, 20712, 21046);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 596, 20712, 21046);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 596, 20712, 21046);
            return 100 * (doubleValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4878.methodEnd();
        }
    }

    public static Fraction getReducedFraction(int numerator, int denominator) {
        MethodContext _bcornu_methode_context4879 = new MethodContext(Fraction.class, 611, 21053, 22713);
        try {
            CallChecker.varInit(denominator, "denominator", 611, 21053, 22713);
            CallChecker.varInit(numerator, "numerator", 611, 21053, 22713);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 611, 21053, 22713);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 611, 21053, 22713);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 611, 21053, 22713);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 611, 21053, 22713);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 611, 21053, 22713);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 611, 21053, 22713);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 611, 21053, 22713);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 611, 21053, 22713);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 611, 21053, 22713);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 611, 21053, 22713);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 611, 21053, 22713);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 611, 21053, 22713);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 611, 21053, 22713);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 611, 21053, 22713);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 611, 21053, 22713);
            if (denominator == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR_IN_FRACTION, numerator, denominator);
            }
            if (numerator == 0) {
                return Fraction.ZERO;
            }
            if ((denominator == (Integer.MIN_VALUE)) && ((numerator & 1) == 0)) {
                numerator /= 2;
                CallChecker.varAssign(numerator, "numerator", 621, 22072, 22084);
                denominator /= 2;
                CallChecker.varAssign(denominator, "denominator", 621, 22086, 22100);
            }
            if (denominator < 0) {
                if ((numerator == (Integer.MIN_VALUE)) || (denominator == (Integer.MIN_VALUE))) {
                    throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_FRACTION, numerator, denominator);
                }
                numerator = -numerator;
                CallChecker.varAssign(numerator, "numerator", 629, 22435, 22457);
                denominator = -denominator;
                CallChecker.varAssign(denominator, "denominator", 630, 22471, 22497);
            }
            int gcd = CallChecker.varInit(((int) (ArithmeticUtils.gcd(numerator, denominator))), "gcd", 633, 22547, 22600);
            numerator /= gcd;
            CallChecker.varAssign(numerator, "numerator", 634, 22610, 22626);
            denominator /= gcd;
            CallChecker.varAssign(denominator, "denominator", 635, 22636, 22654);
            return new Fraction(numerator, denominator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4879.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context4880 = new MethodContext(String.class, 649, 22720, 23296);
        try {
            CallChecker.varInit(this, "this", 649, 22720, 23296);
            CallChecker.varInit(this.numerator, "numerator", 649, 22720, 23296);
            CallChecker.varInit(this.denominator, "denominator", 649, 22720, 23296);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 649, 22720, 23296);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 649, 22720, 23296);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 649, 22720, 23296);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 649, 22720, 23296);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 649, 22720, 23296);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 649, 22720, 23296);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 649, 22720, 23296);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 649, 22720, 23296);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 649, 22720, 23296);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 649, 22720, 23296);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 649, 22720, 23296);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 649, 22720, 23296);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 649, 22720, 23296);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 649, 22720, 23296);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 649, 22720, 23296);
            String str = CallChecker.varInit(null, "str", 650, 23036, 23053);
            if ((denominator) == 1) {
                str = Integer.toString(numerator);
                CallChecker.varAssign(str, "str", 652, 23099, 23132);
            }else
                if ((numerator) == 0) {
                    str = "0";
                    CallChecker.varAssign(str, "str", 654, 23183, 23192);
                }else {
                    str = ((numerator) + " / ") + (denominator);
                    CallChecker.varAssign(str, "str", 656, 23223, 23260);
                }
            
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4880.methodEnd();
        }
    }

    public FractionField getField() {
        MethodContext _bcornu_methode_context4881 = new MethodContext(FractionField.class, 662, 23303, 23410);
        try {
            CallChecker.varInit(this, "this", 662, 23303, 23410);
            CallChecker.varInit(this.numerator, "numerator", 662, 23303, 23410);
            CallChecker.varInit(this.denominator, "denominator", 662, 23303, 23410);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.Fraction.serialVersionUID", 662, 23303, 23410);
            CallChecker.varInit(MINUS_ONE, "org.apache.commons.math3.fraction.Fraction.MINUS_ONE", 662, 23303, 23410);
            CallChecker.varInit(TWO_THIRDS, "org.apache.commons.math3.fraction.Fraction.TWO_THIRDS", 662, 23303, 23410);
            CallChecker.varInit(TWO_QUARTERS, "org.apache.commons.math3.fraction.Fraction.TWO_QUARTERS", 662, 23303, 23410);
            CallChecker.varInit(TWO_FIFTHS, "org.apache.commons.math3.fraction.Fraction.TWO_FIFTHS", 662, 23303, 23410);
            CallChecker.varInit(THREE_QUARTERS, "org.apache.commons.math3.fraction.Fraction.THREE_QUARTERS", 662, 23303, 23410);
            CallChecker.varInit(THREE_FIFTHS, "org.apache.commons.math3.fraction.Fraction.THREE_FIFTHS", 662, 23303, 23410);
            CallChecker.varInit(ONE_THIRD, "org.apache.commons.math3.fraction.Fraction.ONE_THIRD", 662, 23303, 23410);
            CallChecker.varInit(ONE_QUARTER, "org.apache.commons.math3.fraction.Fraction.ONE_QUARTER", 662, 23303, 23410);
            CallChecker.varInit(ONE_HALF, "org.apache.commons.math3.fraction.Fraction.ONE_HALF", 662, 23303, 23410);
            CallChecker.varInit(ONE_FIFTH, "org.apache.commons.math3.fraction.Fraction.ONE_FIFTH", 662, 23303, 23410);
            CallChecker.varInit(FOUR_FIFTHS, "org.apache.commons.math3.fraction.Fraction.FOUR_FIFTHS", 662, 23303, 23410);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.fraction.Fraction.ZERO", 662, 23303, 23410);
            CallChecker.varInit(ONE, "org.apache.commons.math3.fraction.Fraction.ONE", 662, 23303, 23410);
            CallChecker.varInit(TWO, "org.apache.commons.math3.fraction.Fraction.TWO", 662, 23303, 23410);
            return FractionField.getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((FractionField) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4881.methodEnd();
        }
    }
}

