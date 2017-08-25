package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;

public class Decimal64 extends Number implements Comparable<Decimal64> , RealFieldElement<Decimal64> {
    public static final Decimal64 ZERO;

    public static final Decimal64 ONE;

    public static final Decimal64 NEGATIVE_INFINITY;

    public static final Decimal64 POSITIVE_INFINITY;

    public static final Decimal64 NAN;

    private static final long serialVersionUID = 20120227L;

    static {
        ZERO = new Decimal64(0.0);
        CallChecker.varAssign(ZERO, "Decimal64.ZERO", 59, 2102, 2126);
        ONE = new Decimal64(1.0);
        CallChecker.varAssign(ONE, "Decimal64.ONE", 60, 2136, 2159);
        NEGATIVE_INFINITY = new Decimal64(Double.NEGATIVE_INFINITY);
        CallChecker.varAssign(NEGATIVE_INFINITY, "Decimal64.NEGATIVE_INFINITY", 61, 2169, 2228);
        POSITIVE_INFINITY = new Decimal64(Double.POSITIVE_INFINITY);
        CallChecker.varAssign(POSITIVE_INFINITY, "Decimal64.POSITIVE_INFINITY", 62, 2238, 2297);
        NAN = new Decimal64(Double.NaN);
        CallChecker.varAssign(NAN, "Decimal64.NAN", 63, 2307, 2338);
    }

    private final double value;

    public Decimal64(final double x) {
        ConstructorContext _bcornu_methode_context1204 = new ConstructorContext(Decimal64.class, 74, 2446, 2656);
        try {
            this.value = x;
            CallChecker.varAssign(this.value, "this.value", 75, 2636, 2650);
        } finally {
            _bcornu_methode_context1204.methodEnd();
        }
    }

    public Field<Decimal64> getField() {
        MethodContext _bcornu_methode_context5404 = new MethodContext(Field.class, 83, 2663, 2838);
        try {
            CallChecker.varInit(this, "this", 83, 2663, 2838);
            CallChecker.varInit(this.value, "value", 83, 2663, 2838);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 83, 2663, 2838);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 83, 2663, 2838);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 83, 2663, 2838);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 83, 2663, 2838);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 83, 2663, 2838);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 83, 2663, 2838);
            return Decimal64Field.getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Field<Decimal64>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5404.methodEnd();
        }
    }

    public Decimal64 add(final Decimal64 a) {
        MethodContext _bcornu_methode_context5405 = new MethodContext(Decimal64.class, 94, 2845, 3134);
        try {
            CallChecker.varInit(this, "this", 94, 2845, 3134);
            CallChecker.varInit(a, "a", 94, 2845, 3134);
            CallChecker.varInit(this.value, "value", 94, 2845, 3134);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 94, 2845, 3134);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 94, 2845, 3134);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 94, 2845, 3134);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 94, 2845, 3134);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 94, 2845, 3134);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 94, 2845, 3134);
            return new Decimal64(((this.value) + (CallChecker.isCalled(a, Decimal64.class, 95, 3120, 3120).value)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5405.methodEnd();
        }
    }

    public Decimal64 subtract(final Decimal64 a) {
        MethodContext _bcornu_methode_context5406 = new MethodContext(Decimal64.class, 105, 3141, 3440);
        try {
            CallChecker.varInit(this, "this", 105, 3141, 3440);
            CallChecker.varInit(a, "a", 105, 3141, 3440);
            CallChecker.varInit(this.value, "value", 105, 3141, 3440);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 105, 3141, 3440);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 105, 3141, 3440);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 105, 3141, 3440);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 105, 3141, 3440);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 105, 3141, 3440);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 105, 3141, 3440);
            return new Decimal64(((this.value) - (CallChecker.isCalled(a, Decimal64.class, 106, 3426, 3426).value)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5406.methodEnd();
        }
    }

    public Decimal64 negate() {
        MethodContext _bcornu_methode_context5407 = new MethodContext(Decimal64.class, 115, 3447, 3691);
        try {
            CallChecker.varInit(this, "this", 115, 3447, 3691);
            CallChecker.varInit(this.value, "value", 115, 3447, 3691);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 115, 3447, 3691);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 115, 3447, 3691);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 115, 3447, 3691);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 115, 3447, 3691);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 115, 3447, 3691);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 115, 3447, 3691);
            return new Decimal64((-(this.value)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5407.methodEnd();
        }
    }

    public Decimal64 multiply(final Decimal64 a) {
        MethodContext _bcornu_methode_context5408 = new MethodContext(Decimal64.class, 126, 3698, 3997);
        try {
            CallChecker.varInit(this, "this", 126, 3698, 3997);
            CallChecker.varInit(a, "a", 126, 3698, 3997);
            CallChecker.varInit(this.value, "value", 126, 3698, 3997);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 126, 3698, 3997);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 126, 3698, 3997);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 126, 3698, 3997);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 126, 3698, 3997);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 126, 3698, 3997);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 126, 3698, 3997);
            return new Decimal64(((this.value) * (CallChecker.isCalled(a, Decimal64.class, 127, 3983, 3983).value)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5408.methodEnd();
        }
    }

    public Decimal64 multiply(final int n) {
        MethodContext _bcornu_methode_context5409 = new MethodContext(Decimal64.class, 136, 4004, 4270);
        try {
            CallChecker.varInit(this, "this", 136, 4004, 4270);
            CallChecker.varInit(n, "n", 136, 4004, 4270);
            CallChecker.varInit(this.value, "value", 136, 4004, 4270);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 136, 4004, 4270);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 136, 4004, 4270);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 136, 4004, 4270);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 136, 4004, 4270);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 136, 4004, 4270);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 136, 4004, 4270);
            return new Decimal64((n * (this.value)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5409.methodEnd();
        }
    }

    public Decimal64 divide(final Decimal64 a) {
        MethodContext _bcornu_methode_context5410 = new MethodContext(Decimal64.class, 148, 4277, 4579);
        try {
            CallChecker.varInit(this, "this", 148, 4277, 4579);
            CallChecker.varInit(a, "a", 148, 4277, 4579);
            CallChecker.varInit(this.value, "value", 148, 4277, 4579);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 148, 4277, 4579);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 148, 4277, 4579);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 148, 4277, 4579);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 148, 4277, 4579);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 148, 4277, 4579);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 148, 4277, 4579);
            return new Decimal64(((this.value) / (CallChecker.isCalled(a, Decimal64.class, 149, 4565, 4565).value)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5410.methodEnd();
        }
    }

    public Decimal64 reciprocal() {
        MethodContext _bcornu_methode_context5411 = new MethodContext(Decimal64.class, 159, 4586, 4855);
        try {
            CallChecker.varInit(this, "this", 159, 4586, 4855);
            CallChecker.varInit(this.value, "value", 159, 4586, 4855);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 159, 4586, 4855);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 159, 4586, 4855);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 159, 4586, 4855);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 159, 4586, 4855);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 159, 4586, 4855);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 159, 4586, 4855);
            return new Decimal64((1.0 / (this.value)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5411.methodEnd();
        }
    }

    @Override
    public byte byteValue() {
        MethodContext _bcornu_methode_context5412 = new MethodContext(byte.class, 173, 4862, 5111);
        try {
            CallChecker.varInit(this, "this", 173, 4862, 5111);
            CallChecker.varInit(this.value, "value", 173, 4862, 5111);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 173, 4862, 5111);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 173, 4862, 5111);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 173, 4862, 5111);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 173, 4862, 5111);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 173, 4862, 5111);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 173, 4862, 5111);
            return ((byte) (value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Byte) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5412.methodEnd();
        }
    }

    @Override
    public short shortValue() {
        MethodContext _bcornu_methode_context5413 = new MethodContext(short.class, 183, 5118, 5309);
        try {
            CallChecker.varInit(this, "this", 183, 5118, 5309);
            CallChecker.varInit(this.value, "value", 183, 5118, 5309);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 183, 5118, 5309);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 183, 5118, 5309);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 183, 5118, 5309);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 183, 5118, 5309);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 183, 5118, 5309);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 183, 5118, 5309);
            return ((short) (value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Short) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5413.methodEnd();
        }
    }

    @Override
    public int intValue() {
        MethodContext _bcornu_methode_context5414 = new MethodContext(int.class, 193, 5316, 5499);
        try {
            CallChecker.varInit(this, "this", 193, 5316, 5499);
            CallChecker.varInit(this.value, "value", 193, 5316, 5499);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 193, 5316, 5499);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 193, 5316, 5499);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 193, 5316, 5499);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 193, 5316, 5499);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 193, 5316, 5499);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 193, 5316, 5499);
            return ((int) (value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5414.methodEnd();
        }
    }

    @Override
    public long longValue() {
        MethodContext _bcornu_methode_context5415 = new MethodContext(long.class, 203, 5506, 5693);
        try {
            CallChecker.varInit(this, "this", 203, 5506, 5693);
            CallChecker.varInit(this.value, "value", 203, 5506, 5693);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 203, 5506, 5693);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 203, 5506, 5693);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 203, 5506, 5693);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 203, 5506, 5693);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 203, 5506, 5693);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 203, 5506, 5693);
            return ((long) (value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5415.methodEnd();
        }
    }

    @Override
    public float floatValue() {
        MethodContext _bcornu_methode_context5416 = new MethodContext(float.class, 213, 5700, 5891);
        try {
            CallChecker.varInit(this, "this", 213, 5700, 5891);
            CallChecker.varInit(this.value, "value", 213, 5700, 5891);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 213, 5700, 5891);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 213, 5700, 5891);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 213, 5700, 5891);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 213, 5700, 5891);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 213, 5700, 5891);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 213, 5700, 5891);
            return ((float) (value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5416.methodEnd();
        }
    }

    @Override
    public double doubleValue() {
        MethodContext _bcornu_methode_context5417 = new MethodContext(double.class, 219, 5898, 5993);
        try {
            CallChecker.varInit(this, "this", 219, 5898, 5993);
            CallChecker.varInit(this.value, "value", 219, 5898, 5993);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 219, 5898, 5993);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 219, 5898, 5993);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 219, 5898, 5993);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 219, 5898, 5993);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 219, 5898, 5993);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 219, 5898, 5993);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5417.methodEnd();
        }
    }

    public int compareTo(final Decimal64 o) {
        MethodContext _bcornu_methode_context5418 = new MethodContext(int.class, 236, 6000, 6419);
        try {
            CallChecker.varInit(this, "this", 236, 6000, 6419);
            CallChecker.varInit(o, "o", 236, 6000, 6419);
            CallChecker.varInit(this.value, "value", 236, 6000, 6419);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 236, 6000, 6419);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 236, 6000, 6419);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 236, 6000, 6419);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 236, 6000, 6419);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 236, 6000, 6419);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 236, 6000, 6419);
            if (CallChecker.beforeDeref(o, Decimal64.class, 237, 6405, 6405)) {
                return Double.compare(this.value, CallChecker.isCalled(o, Decimal64.class, 237, 6405, 6405).value);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5418.methodEnd();
        }
    }

    @Override
    public boolean equals(final Object obj) {
        MethodContext _bcornu_methode_context5419 = new MethodContext(boolean.class, 246, 6426, 6814);
        try {
            CallChecker.varInit(this, "this", 246, 6426, 6814);
            CallChecker.varInit(obj, "obj", 246, 6426, 6814);
            CallChecker.varInit(this.value, "value", 246, 6426, 6814);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 246, 6426, 6814);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 246, 6426, 6814);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 246, 6426, 6814);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 246, 6426, 6814);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 246, 6426, 6814);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 246, 6426, 6814);
            if (obj instanceof Decimal64) {
                final Decimal64 that = CallChecker.varInit(((Decimal64) (obj)), "that", 248, 6622, 6660);
                if (CallChecker.beforeDeref(that, Decimal64.class, 250, 6765, 6768)) {
                    return (Double.doubleToLongBits(this.value)) == (Double.doubleToLongBits(CallChecker.isCalled(that, Decimal64.class, 250, 6765, 6768).value));
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5419.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context5420 = new MethodContext(int.class, 264, 6821, 7149);
        try {
            CallChecker.varInit(this, "this", 264, 6821, 7149);
            CallChecker.varInit(this.value, "value", 264, 6821, 7149);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 264, 6821, 7149);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 264, 6821, 7149);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 264, 6821, 7149);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 264, 6821, 7149);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 264, 6821, 7149);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 264, 6821, 7149);
            long v = CallChecker.varInit(((long) (Double.doubleToLongBits(this.value))), "v", 265, 7065, 7104);
            return ((int) (v ^ (v >>> 32)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5420.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context5421 = new MethodContext(String.class, 278, 7156, 7425);
        try {
            CallChecker.varInit(this, "this", 278, 7156, 7425);
            CallChecker.varInit(this.value, "value", 278, 7156, 7425);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 278, 7156, 7425);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 278, 7156, 7425);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 278, 7156, 7425);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 278, 7156, 7425);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 278, 7156, 7425);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 278, 7156, 7425);
            return Double.toString(value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5421.methodEnd();
        }
    }

    public boolean isInfinite() {
        MethodContext _bcornu_methode_context5422 = new MethodContext(boolean.class, 292, 7432, 7813);
        try {
            CallChecker.varInit(this, "this", 292, 7432, 7813);
            CallChecker.varInit(this.value, "value", 292, 7432, 7813);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 292, 7432, 7813);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 292, 7432, 7813);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 292, 7432, 7813);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 292, 7432, 7813);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 292, 7432, 7813);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 292, 7432, 7813);
            return Double.isInfinite(value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5422.methodEnd();
        }
    }

    public boolean isNaN() {
        MethodContext _bcornu_methode_context5423 = new MethodContext(boolean.class, 302, 7820, 8090);
        try {
            CallChecker.varInit(this, "this", 302, 7820, 8090);
            CallChecker.varInit(this.value, "value", 302, 7820, 8090);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 302, 7820, 8090);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 302, 7820, 8090);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 302, 7820, 8090);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 302, 7820, 8090);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 302, 7820, 8090);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 302, 7820, 8090);
            return Double.isNaN(value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5423.methodEnd();
        }
    }

    public double getReal() {
        MethodContext _bcornu_methode_context5424 = new MethodContext(double.class, 309, 8097, 8197);
        try {
            CallChecker.varInit(this, "this", 309, 8097, 8197);
            CallChecker.varInit(this.value, "value", 309, 8097, 8197);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 309, 8097, 8197);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 309, 8097, 8197);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 309, 8097, 8197);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 309, 8097, 8197);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 309, 8097, 8197);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 309, 8097, 8197);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5424.methodEnd();
        }
    }

    public Decimal64 add(final double a) {
        MethodContext _bcornu_methode_context5425 = new MethodContext(Decimal64.class, 316, 8204, 8336);
        try {
            CallChecker.varInit(this, "this", 316, 8204, 8336);
            CallChecker.varInit(a, "a", 316, 8204, 8336);
            CallChecker.varInit(this.value, "value", 316, 8204, 8336);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 316, 8204, 8336);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 316, 8204, 8336);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 316, 8204, 8336);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 316, 8204, 8336);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 316, 8204, 8336);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 316, 8204, 8336);
            return new Decimal64(((value) + a));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5425.methodEnd();
        }
    }

    public Decimal64 subtract(final double a) {
        MethodContext _bcornu_methode_context5426 = new MethodContext(Decimal64.class, 323, 8343, 8480);
        try {
            CallChecker.varInit(this, "this", 323, 8343, 8480);
            CallChecker.varInit(a, "a", 323, 8343, 8480);
            CallChecker.varInit(this.value, "value", 323, 8343, 8480);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 323, 8343, 8480);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 323, 8343, 8480);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 323, 8343, 8480);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 323, 8343, 8480);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 323, 8343, 8480);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 323, 8343, 8480);
            return new Decimal64(((value) - a));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5426.methodEnd();
        }
    }

    public Decimal64 multiply(final double a) {
        MethodContext _bcornu_methode_context5427 = new MethodContext(Decimal64.class, 330, 8487, 8624);
        try {
            CallChecker.varInit(this, "this", 330, 8487, 8624);
            CallChecker.varInit(a, "a", 330, 8487, 8624);
            CallChecker.varInit(this.value, "value", 330, 8487, 8624);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 330, 8487, 8624);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 330, 8487, 8624);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 330, 8487, 8624);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 330, 8487, 8624);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 330, 8487, 8624);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 330, 8487, 8624);
            return new Decimal64(((value) * a));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5427.methodEnd();
        }
    }

    public Decimal64 divide(final double a) {
        MethodContext _bcornu_methode_context5428 = new MethodContext(Decimal64.class, 337, 8631, 8766);
        try {
            CallChecker.varInit(this, "this", 337, 8631, 8766);
            CallChecker.varInit(a, "a", 337, 8631, 8766);
            CallChecker.varInit(this.value, "value", 337, 8631, 8766);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 337, 8631, 8766);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 337, 8631, 8766);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 337, 8631, 8766);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 337, 8631, 8766);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 337, 8631, 8766);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 337, 8631, 8766);
            return new Decimal64(((value) / a));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5428.methodEnd();
        }
    }

    public Decimal64 remainder(final double a) {
        MethodContext _bcornu_methode_context5429 = new MethodContext(Decimal64.class, 344, 8773, 8934);
        try {
            CallChecker.varInit(this, "this", 344, 8773, 8934);
            CallChecker.varInit(a, "a", 344, 8773, 8934);
            CallChecker.varInit(this.value, "value", 344, 8773, 8934);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 344, 8773, 8934);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 344, 8773, 8934);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 344, 8773, 8934);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 344, 8773, 8934);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 344, 8773, 8934);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 344, 8773, 8934);
            return new Decimal64(FastMath.IEEEremainder(value, a));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5429.methodEnd();
        }
    }

    public Decimal64 remainder(final Decimal64 a) {
        MethodContext _bcornu_methode_context5430 = new MethodContext(Decimal64.class, 351, 8941, 9111);
        try {
            CallChecker.varInit(this, "this", 351, 8941, 9111);
            CallChecker.varInit(a, "a", 351, 8941, 9111);
            CallChecker.varInit(this.value, "value", 351, 8941, 9111);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 351, 8941, 9111);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 351, 8941, 9111);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 351, 8941, 9111);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 351, 8941, 9111);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 351, 8941, 9111);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 351, 8941, 9111);
            if (CallChecker.beforeDeref(a, Decimal64.class, 352, 9096, 9096)) {
                return new Decimal64(FastMath.IEEEremainder(value, CallChecker.isCalled(a, Decimal64.class, 352, 9096, 9096).value));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5430.methodEnd();
        }
    }

    public Decimal64 abs() {
        MethodContext _bcornu_methode_context5431 = new MethodContext(Decimal64.class, 358, 9118, 9246);
        try {
            CallChecker.varInit(this, "this", 358, 9118, 9246);
            CallChecker.varInit(this.value, "value", 358, 9118, 9246);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 358, 9118, 9246);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 358, 9118, 9246);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 358, 9118, 9246);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 358, 9118, 9246);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 358, 9118, 9246);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 358, 9118, 9246);
            return new Decimal64(FastMath.abs(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5431.methodEnd();
        }
    }

    public Decimal64 ceil() {
        MethodContext _bcornu_methode_context5432 = new MethodContext(Decimal64.class, 365, 9253, 9383);
        try {
            CallChecker.varInit(this, "this", 365, 9253, 9383);
            CallChecker.varInit(this.value, "value", 365, 9253, 9383);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 365, 9253, 9383);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 365, 9253, 9383);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 365, 9253, 9383);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 365, 9253, 9383);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 365, 9253, 9383);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 365, 9253, 9383);
            return new Decimal64(FastMath.ceil(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5432.methodEnd();
        }
    }

    public Decimal64 floor() {
        MethodContext _bcornu_methode_context5433 = new MethodContext(Decimal64.class, 372, 9390, 9522);
        try {
            CallChecker.varInit(this, "this", 372, 9390, 9522);
            CallChecker.varInit(this.value, "value", 372, 9390, 9522);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 372, 9390, 9522);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 372, 9390, 9522);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 372, 9390, 9522);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 372, 9390, 9522);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 372, 9390, 9522);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 372, 9390, 9522);
            return new Decimal64(FastMath.floor(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5433.methodEnd();
        }
    }

    public Decimal64 rint() {
        MethodContext _bcornu_methode_context5434 = new MethodContext(Decimal64.class, 379, 9529, 9659);
        try {
            CallChecker.varInit(this, "this", 379, 9529, 9659);
            CallChecker.varInit(this.value, "value", 379, 9529, 9659);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 379, 9529, 9659);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 379, 9529, 9659);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 379, 9529, 9659);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 379, 9529, 9659);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 379, 9529, 9659);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 379, 9529, 9659);
            return new Decimal64(FastMath.rint(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5434.methodEnd();
        }
    }

    public long round() {
        MethodContext _bcornu_methode_context5435 = new MethodContext(long.class, 386, 9666, 9778);
        try {
            CallChecker.varInit(this, "this", 386, 9666, 9778);
            CallChecker.varInit(this.value, "value", 386, 9666, 9778);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 386, 9666, 9778);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 386, 9666, 9778);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 386, 9666, 9778);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 386, 9666, 9778);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 386, 9666, 9778);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 386, 9666, 9778);
            return FastMath.round(value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5435.methodEnd();
        }
    }

    public Decimal64 signum() {
        MethodContext _bcornu_methode_context5436 = new MethodContext(Decimal64.class, 393, 9785, 9919);
        try {
            CallChecker.varInit(this, "this", 393, 9785, 9919);
            CallChecker.varInit(this.value, "value", 393, 9785, 9919);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 393, 9785, 9919);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 393, 9785, 9919);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 393, 9785, 9919);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 393, 9785, 9919);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 393, 9785, 9919);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 393, 9785, 9919);
            return new Decimal64(FastMath.signum(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5436.methodEnd();
        }
    }

    public Decimal64 copySign(final Decimal64 sign) {
        MethodContext _bcornu_methode_context5437 = new MethodContext(Decimal64.class, 400, 9926, 10096);
        try {
            CallChecker.varInit(this, "this", 400, 9926, 10096);
            CallChecker.varInit(sign, "sign", 400, 9926, 10096);
            CallChecker.varInit(this.value, "value", 400, 9926, 10096);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 400, 9926, 10096);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 400, 9926, 10096);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 400, 9926, 10096);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 400, 9926, 10096);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 400, 9926, 10096);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 400, 9926, 10096);
            if (CallChecker.beforeDeref(sign, Decimal64.class, 401, 10078, 10081)) {
                return new Decimal64(FastMath.copySign(value, CallChecker.isCalled(sign, Decimal64.class, 401, 10078, 10081).value));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5437.methodEnd();
        }
    }

    public Decimal64 copySign(final double sign) {
        MethodContext _bcornu_methode_context5438 = new MethodContext(Decimal64.class, 407, 10103, 10264);
        try {
            CallChecker.varInit(this, "this", 407, 10103, 10264);
            CallChecker.varInit(sign, "sign", 407, 10103, 10264);
            CallChecker.varInit(this.value, "value", 407, 10103, 10264);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 407, 10103, 10264);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 407, 10103, 10264);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 407, 10103, 10264);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 407, 10103, 10264);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 407, 10103, 10264);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 407, 10103, 10264);
            return new Decimal64(FastMath.copySign(value, sign));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5438.methodEnd();
        }
    }

    public Decimal64 scalb(final int n) {
        MethodContext _bcornu_methode_context5439 = new MethodContext(Decimal64.class, 414, 10271, 10417);
        try {
            CallChecker.varInit(this, "this", 414, 10271, 10417);
            CallChecker.varInit(n, "n", 414, 10271, 10417);
            CallChecker.varInit(this.value, "value", 414, 10271, 10417);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 414, 10271, 10417);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 414, 10271, 10417);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 414, 10271, 10417);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 414, 10271, 10417);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 414, 10271, 10417);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 414, 10271, 10417);
            return new Decimal64(FastMath.scalb(value, n));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5439.methodEnd();
        }
    }

    public Decimal64 hypot(final Decimal64 y) {
        MethodContext _bcornu_methode_context5440 = new MethodContext(Decimal64.class, 421, 10424, 10582);
        try {
            CallChecker.varInit(this, "this", 421, 10424, 10582);
            CallChecker.varInit(y, "y", 421, 10424, 10582);
            CallChecker.varInit(this.value, "value", 421, 10424, 10582);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 421, 10424, 10582);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 421, 10424, 10582);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 421, 10424, 10582);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 421, 10424, 10582);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 421, 10424, 10582);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 421, 10424, 10582);
            if (CallChecker.beforeDeref(y, Decimal64.class, 422, 10567, 10567)) {
                return new Decimal64(FastMath.hypot(value, CallChecker.isCalled(y, Decimal64.class, 422, 10567, 10567).value));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5440.methodEnd();
        }
    }

    public Decimal64 sqrt() {
        MethodContext _bcornu_methode_context5441 = new MethodContext(Decimal64.class, 428, 10589, 10719);
        try {
            CallChecker.varInit(this, "this", 428, 10589, 10719);
            CallChecker.varInit(this.value, "value", 428, 10589, 10719);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 428, 10589, 10719);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 428, 10589, 10719);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 428, 10589, 10719);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 428, 10589, 10719);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 428, 10589, 10719);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 428, 10589, 10719);
            return new Decimal64(FastMath.sqrt(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5441.methodEnd();
        }
    }

    public Decimal64 cbrt() {
        MethodContext _bcornu_methode_context5442 = new MethodContext(Decimal64.class, 435, 10726, 10856);
        try {
            CallChecker.varInit(this, "this", 435, 10726, 10856);
            CallChecker.varInit(this.value, "value", 435, 10726, 10856);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 435, 10726, 10856);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 435, 10726, 10856);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 435, 10726, 10856);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 435, 10726, 10856);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 435, 10726, 10856);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 435, 10726, 10856);
            return new Decimal64(FastMath.cbrt(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5442.methodEnd();
        }
    }

    public Decimal64 rootN(final int n) {
        MethodContext _bcornu_methode_context5443 = new MethodContext(Decimal64.class, 442, 10863, 11135);
        try {
            CallChecker.varInit(this, "this", 442, 10863, 11135);
            CallChecker.varInit(n, "n", 442, 10863, 11135);
            CallChecker.varInit(this.value, "value", 442, 10863, 11135);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 442, 10863, 11135);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 442, 10863, 11135);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 442, 10863, 11135);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 442, 10863, 11135);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 442, 10863, 11135);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 442, 10863, 11135);
            if ((value) < 0) {
                return new Decimal64((-(FastMath.pow((-(value)), (1.0 / n)))));
            }else {
                return new Decimal64(FastMath.pow(value, (1.0 / n)));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5443.methodEnd();
        }
    }

    public Decimal64 pow(final double p) {
        MethodContext _bcornu_methode_context5444 = new MethodContext(Decimal64.class, 453, 11142, 11287);
        try {
            CallChecker.varInit(this, "this", 453, 11142, 11287);
            CallChecker.varInit(p, "p", 453, 11142, 11287);
            CallChecker.varInit(this.value, "value", 453, 11142, 11287);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 453, 11142, 11287);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 453, 11142, 11287);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 453, 11142, 11287);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 453, 11142, 11287);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 453, 11142, 11287);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 453, 11142, 11287);
            return new Decimal64(FastMath.pow(value, p));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5444.methodEnd();
        }
    }

    public Decimal64 pow(final int n) {
        MethodContext _bcornu_methode_context5445 = new MethodContext(Decimal64.class, 460, 11294, 11436);
        try {
            CallChecker.varInit(this, "this", 460, 11294, 11436);
            CallChecker.varInit(n, "n", 460, 11294, 11436);
            CallChecker.varInit(this.value, "value", 460, 11294, 11436);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 460, 11294, 11436);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 460, 11294, 11436);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 460, 11294, 11436);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 460, 11294, 11436);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 460, 11294, 11436);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 460, 11294, 11436);
            return new Decimal64(FastMath.pow(value, n));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5445.methodEnd();
        }
    }

    public Decimal64 pow(final Decimal64 e) {
        MethodContext _bcornu_methode_context5446 = new MethodContext(Decimal64.class, 467, 11443, 11597);
        try {
            CallChecker.varInit(this, "this", 467, 11443, 11597);
            CallChecker.varInit(e, "e", 467, 11443, 11597);
            CallChecker.varInit(this.value, "value", 467, 11443, 11597);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 467, 11443, 11597);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 467, 11443, 11597);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 467, 11443, 11597);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 467, 11443, 11597);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 467, 11443, 11597);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 467, 11443, 11597);
            if (CallChecker.beforeDeref(e, Decimal64.class, 468, 11582, 11582)) {
                return new Decimal64(FastMath.pow(value, CallChecker.isCalled(e, Decimal64.class, 468, 11582, 11582).value));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5446.methodEnd();
        }
    }

    public Decimal64 exp() {
        MethodContext _bcornu_methode_context5447 = new MethodContext(Decimal64.class, 474, 11604, 11732);
        try {
            CallChecker.varInit(this, "this", 474, 11604, 11732);
            CallChecker.varInit(this.value, "value", 474, 11604, 11732);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 474, 11604, 11732);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 474, 11604, 11732);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 474, 11604, 11732);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 474, 11604, 11732);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 474, 11604, 11732);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 474, 11604, 11732);
            return new Decimal64(FastMath.exp(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5447.methodEnd();
        }
    }

    public Decimal64 expm1() {
        MethodContext _bcornu_methode_context5448 = new MethodContext(Decimal64.class, 481, 11739, 11871);
        try {
            CallChecker.varInit(this, "this", 481, 11739, 11871);
            CallChecker.varInit(this.value, "value", 481, 11739, 11871);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 481, 11739, 11871);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 481, 11739, 11871);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 481, 11739, 11871);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 481, 11739, 11871);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 481, 11739, 11871);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 481, 11739, 11871);
            return new Decimal64(FastMath.expm1(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5448.methodEnd();
        }
    }

    public Decimal64 log() {
        MethodContext _bcornu_methode_context5449 = new MethodContext(Decimal64.class, 488, 11878, 12006);
        try {
            CallChecker.varInit(this, "this", 488, 11878, 12006);
            CallChecker.varInit(this.value, "value", 488, 11878, 12006);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 488, 11878, 12006);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 488, 11878, 12006);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 488, 11878, 12006);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 488, 11878, 12006);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 488, 11878, 12006);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 488, 11878, 12006);
            return new Decimal64(FastMath.log(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5449.methodEnd();
        }
    }

    public Decimal64 log1p() {
        MethodContext _bcornu_methode_context5450 = new MethodContext(Decimal64.class, 495, 12013, 12145);
        try {
            CallChecker.varInit(this, "this", 495, 12013, 12145);
            CallChecker.varInit(this.value, "value", 495, 12013, 12145);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 495, 12013, 12145);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 495, 12013, 12145);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 495, 12013, 12145);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 495, 12013, 12145);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 495, 12013, 12145);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 495, 12013, 12145);
            return new Decimal64(FastMath.log1p(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5450.methodEnd();
        }
    }

    public Decimal64 log10() {
        MethodContext _bcornu_methode_context5451 = new MethodContext(Decimal64.class, 503, 12152, 12338);
        try {
            CallChecker.varInit(this, "this", 503, 12152, 12338);
            CallChecker.varInit(this.value, "value", 503, 12152, 12338);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 503, 12152, 12338);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 503, 12152, 12338);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 503, 12152, 12338);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 503, 12152, 12338);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 503, 12152, 12338);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 503, 12152, 12338);
            return new Decimal64(FastMath.log10(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5451.methodEnd();
        }
    }

    public Decimal64 cos() {
        MethodContext _bcornu_methode_context5452 = new MethodContext(Decimal64.class, 510, 12345, 12473);
        try {
            CallChecker.varInit(this, "this", 510, 12345, 12473);
            CallChecker.varInit(this.value, "value", 510, 12345, 12473);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 510, 12345, 12473);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 510, 12345, 12473);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 510, 12345, 12473);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 510, 12345, 12473);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 510, 12345, 12473);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 510, 12345, 12473);
            return new Decimal64(FastMath.cos(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5452.methodEnd();
        }
    }

    public Decimal64 sin() {
        MethodContext _bcornu_methode_context5453 = new MethodContext(Decimal64.class, 517, 12480, 12608);
        try {
            CallChecker.varInit(this, "this", 517, 12480, 12608);
            CallChecker.varInit(this.value, "value", 517, 12480, 12608);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 517, 12480, 12608);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 517, 12480, 12608);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 517, 12480, 12608);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 517, 12480, 12608);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 517, 12480, 12608);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 517, 12480, 12608);
            return new Decimal64(FastMath.sin(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5453.methodEnd();
        }
    }

    public Decimal64 tan() {
        MethodContext _bcornu_methode_context5454 = new MethodContext(Decimal64.class, 524, 12615, 12743);
        try {
            CallChecker.varInit(this, "this", 524, 12615, 12743);
            CallChecker.varInit(this.value, "value", 524, 12615, 12743);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 524, 12615, 12743);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 524, 12615, 12743);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 524, 12615, 12743);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 524, 12615, 12743);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 524, 12615, 12743);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 524, 12615, 12743);
            return new Decimal64(FastMath.tan(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5454.methodEnd();
        }
    }

    public Decimal64 acos() {
        MethodContext _bcornu_methode_context5455 = new MethodContext(Decimal64.class, 531, 12750, 12880);
        try {
            CallChecker.varInit(this, "this", 531, 12750, 12880);
            CallChecker.varInit(this.value, "value", 531, 12750, 12880);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 531, 12750, 12880);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 531, 12750, 12880);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 531, 12750, 12880);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 531, 12750, 12880);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 531, 12750, 12880);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 531, 12750, 12880);
            return new Decimal64(FastMath.acos(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5455.methodEnd();
        }
    }

    public Decimal64 asin() {
        MethodContext _bcornu_methode_context5456 = new MethodContext(Decimal64.class, 538, 12887, 13017);
        try {
            CallChecker.varInit(this, "this", 538, 12887, 13017);
            CallChecker.varInit(this.value, "value", 538, 12887, 13017);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 538, 12887, 13017);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 538, 12887, 13017);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 538, 12887, 13017);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 538, 12887, 13017);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 538, 12887, 13017);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 538, 12887, 13017);
            return new Decimal64(FastMath.asin(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5456.methodEnd();
        }
    }

    public Decimal64 atan() {
        MethodContext _bcornu_methode_context5457 = new MethodContext(Decimal64.class, 545, 13024, 13154);
        try {
            CallChecker.varInit(this, "this", 545, 13024, 13154);
            CallChecker.varInit(this.value, "value", 545, 13024, 13154);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 545, 13024, 13154);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 545, 13024, 13154);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 545, 13024, 13154);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 545, 13024, 13154);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 545, 13024, 13154);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 545, 13024, 13154);
            return new Decimal64(FastMath.atan(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5457.methodEnd();
        }
    }

    public Decimal64 atan2(final Decimal64 x) {
        MethodContext _bcornu_methode_context5458 = new MethodContext(Decimal64.class, 552, 13161, 13319);
        try {
            CallChecker.varInit(this, "this", 552, 13161, 13319);
            CallChecker.varInit(x, "x", 552, 13161, 13319);
            CallChecker.varInit(this.value, "value", 552, 13161, 13319);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 552, 13161, 13319);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 552, 13161, 13319);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 552, 13161, 13319);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 552, 13161, 13319);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 552, 13161, 13319);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 552, 13161, 13319);
            if (CallChecker.beforeDeref(x, Decimal64.class, 553, 13304, 13304)) {
                return new Decimal64(FastMath.atan2(value, CallChecker.isCalled(x, Decimal64.class, 553, 13304, 13304).value));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5458.methodEnd();
        }
    }

    public Decimal64 cosh() {
        MethodContext _bcornu_methode_context5459 = new MethodContext(Decimal64.class, 559, 13326, 13456);
        try {
            CallChecker.varInit(this, "this", 559, 13326, 13456);
            CallChecker.varInit(this.value, "value", 559, 13326, 13456);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 559, 13326, 13456);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 559, 13326, 13456);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 559, 13326, 13456);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 559, 13326, 13456);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 559, 13326, 13456);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 559, 13326, 13456);
            return new Decimal64(FastMath.cosh(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5459.methodEnd();
        }
    }

    public Decimal64 sinh() {
        MethodContext _bcornu_methode_context5460 = new MethodContext(Decimal64.class, 566, 13463, 13593);
        try {
            CallChecker.varInit(this, "this", 566, 13463, 13593);
            CallChecker.varInit(this.value, "value", 566, 13463, 13593);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 566, 13463, 13593);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 566, 13463, 13593);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 566, 13463, 13593);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 566, 13463, 13593);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 566, 13463, 13593);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 566, 13463, 13593);
            return new Decimal64(FastMath.sinh(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5460.methodEnd();
        }
    }

    public Decimal64 tanh() {
        MethodContext _bcornu_methode_context5461 = new MethodContext(Decimal64.class, 573, 13600, 13730);
        try {
            CallChecker.varInit(this, "this", 573, 13600, 13730);
            CallChecker.varInit(this.value, "value", 573, 13600, 13730);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 573, 13600, 13730);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 573, 13600, 13730);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 573, 13600, 13730);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 573, 13600, 13730);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 573, 13600, 13730);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 573, 13600, 13730);
            return new Decimal64(FastMath.tanh(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5461.methodEnd();
        }
    }

    public Decimal64 acosh() {
        MethodContext _bcornu_methode_context5462 = new MethodContext(Decimal64.class, 580, 13737, 13869);
        try {
            CallChecker.varInit(this, "this", 580, 13737, 13869);
            CallChecker.varInit(this.value, "value", 580, 13737, 13869);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 580, 13737, 13869);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 580, 13737, 13869);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 580, 13737, 13869);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 580, 13737, 13869);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 580, 13737, 13869);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 580, 13737, 13869);
            return new Decimal64(FastMath.acosh(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5462.methodEnd();
        }
    }

    public Decimal64 asinh() {
        MethodContext _bcornu_methode_context5463 = new MethodContext(Decimal64.class, 587, 13876, 14008);
        try {
            CallChecker.varInit(this, "this", 587, 13876, 14008);
            CallChecker.varInit(this.value, "value", 587, 13876, 14008);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 587, 13876, 14008);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 587, 13876, 14008);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 587, 13876, 14008);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 587, 13876, 14008);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 587, 13876, 14008);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 587, 13876, 14008);
            return new Decimal64(FastMath.asinh(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5463.methodEnd();
        }
    }

    public Decimal64 atanh() {
        MethodContext _bcornu_methode_context5464 = new MethodContext(Decimal64.class, 594, 14015, 14147);
        try {
            CallChecker.varInit(this, "this", 594, 14015, 14147);
            CallChecker.varInit(this.value, "value", 594, 14015, 14147);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 594, 14015, 14147);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 594, 14015, 14147);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 594, 14015, 14147);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 594, 14015, 14147);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 594, 14015, 14147);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 594, 14015, 14147);
            return new Decimal64(FastMath.atanh(value));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5464.methodEnd();
        }
    }

    public Decimal64 linearCombination(final Decimal64[] a, final Decimal64[] b) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5465 = new MethodContext(Decimal64.class, 601, 14154, 14760);
        try {
            CallChecker.varInit(this, "this", 601, 14154, 14760);
            CallChecker.varInit(b, "b", 601, 14154, 14760);
            CallChecker.varInit(a, "a", 601, 14154, 14760);
            CallChecker.varInit(this.value, "value", 601, 14154, 14760);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 601, 14154, 14760);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 601, 14154, 14760);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 601, 14154, 14760);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 601, 14154, 14760);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 601, 14154, 14760);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 601, 14154, 14760);
            if (CallChecker.beforeDeref(a, Decimal64[].class, 603, 14335, 14335)) {
                if (CallChecker.beforeDeref(b, Decimal64[].class, 603, 14347, 14347)) {
                    if ((CallChecker.isCalled(a, Decimal64[].class, 603, 14335, 14335).length) != (CallChecker.isCalled(b, Decimal64[].class, 603, 14347, 14347).length)) {
                        if (CallChecker.beforeDeref(a, Decimal64[].class, 604, 14408, 14408)) {
                            if (CallChecker.beforeDeref(b, Decimal64[].class, 604, 14418, 14418)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(a, Decimal64[].class, 604, 14408, 14408).length, CallChecker.isCalled(b, Decimal64[].class, 604, 14418, 14418).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final double[] aDouble = CallChecker.varInit(new double[CallChecker.isCalled(a, Decimal64[].class, 606, 14483, 14483).length], "aDouble", 606, 14447, 14492);
            final double[] bDouble = CallChecker.varInit(new double[CallChecker.isCalled(b, Decimal64[].class, 607, 14538, 14538).length], "bDouble", 607, 14502, 14547);
            for (int i = 0; i < (CallChecker.isCalled(a, Decimal64[].class, 608, 14577, 14577).length); ++i) {
                if (CallChecker.beforeDeref(aDouble, double[].class, 609, 14606, 14612)) {
                    if (CallChecker.beforeDeref(a, Decimal64[].class, 609, 14619, 14619)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(a, Decimal64[].class, 609, 14619, 14619)[i], Decimal64.class, 609, 14619, 14622)) {
                            CallChecker.isCalled(a, Decimal64[].class, 609, 14619, 14619)[i] = CallChecker.beforeCalled(CallChecker.isCalled(a, Decimal64[].class, 609, 14619, 14619)[i], Decimal64.class, 609, 14619, 14622);
                            CallChecker.isCalled(aDouble, double[].class, 609, 14606, 14612)[i] = CallChecker.isCalled(CallChecker.isCalled(a, Decimal64[].class, 609, 14619, 14619)[i], Decimal64.class, 609, 14619, 14622).value;
                            CallChecker.varAssign(CallChecker.isCalled(aDouble, double[].class, 609, 14606, 14612)[i], "CallChecker.isCalled(aDouble, double[].class, 609, 14606, 14612)[i]", 609, 14606, 14629);
                        }
                    }
                }
                if (CallChecker.beforeDeref(bDouble, double[].class, 610, 14643, 14649)) {
                    if (CallChecker.beforeDeref(b, Decimal64[].class, 610, 14656, 14656)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(b, Decimal64[].class, 610, 14656, 14656)[i], Decimal64.class, 610, 14656, 14659)) {
                            CallChecker.isCalled(b, Decimal64[].class, 610, 14656, 14656)[i] = CallChecker.beforeCalled(CallChecker.isCalled(b, Decimal64[].class, 610, 14656, 14656)[i], Decimal64.class, 610, 14656, 14659);
                            CallChecker.isCalled(bDouble, double[].class, 610, 14643, 14649)[i] = CallChecker.isCalled(CallChecker.isCalled(b, Decimal64[].class, 610, 14656, 14656)[i], Decimal64.class, 610, 14656, 14659).value;
                            CallChecker.varAssign(CallChecker.isCalled(bDouble, double[].class, 610, 14643, 14649)[i], "CallChecker.isCalled(bDouble, double[].class, 610, 14643, 14649)[i]", 610, 14643, 14666);
                        }
                    }
                }
            }
            return new Decimal64(MathArrays.linearCombination(aDouble, bDouble));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5465.methodEnd();
        }
    }

    public Decimal64 linearCombination(final double[] a, final Decimal64[] b) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5466 = new MethodContext(Decimal64.class, 618, 14767, 15272);
        try {
            CallChecker.varInit(this, "this", 618, 14767, 15272);
            CallChecker.varInit(b, "b", 618, 14767, 15272);
            CallChecker.varInit(a, "a", 618, 14767, 15272);
            CallChecker.varInit(this.value, "value", 618, 14767, 15272);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 618, 14767, 15272);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 618, 14767, 15272);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 618, 14767, 15272);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 618, 14767, 15272);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 618, 14767, 15272);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 618, 14767, 15272);
            if (CallChecker.beforeDeref(a, double[].class, 620, 14945, 14945)) {
                if (CallChecker.beforeDeref(b, Decimal64[].class, 620, 14957, 14957)) {
                    if ((CallChecker.isCalled(a, double[].class, 620, 14945, 14945).length) != (CallChecker.isCalled(b, Decimal64[].class, 620, 14957, 14957).length)) {
                        if (CallChecker.beforeDeref(a, double[].class, 621, 15018, 15018)) {
                            if (CallChecker.beforeDeref(b, Decimal64[].class, 621, 15028, 15028)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(a, double[].class, 621, 15018, 15018).length, CallChecker.isCalled(b, Decimal64[].class, 621, 15028, 15028).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final double[] bDouble = CallChecker.varInit(new double[CallChecker.isCalled(b, Decimal64[].class, 623, 15093, 15093).length], "bDouble", 623, 15057, 15102);
            for (int i = 0; i < (CallChecker.isCalled(a, double[].class, 624, 15132, 15132).length); ++i) {
                if (CallChecker.beforeDeref(bDouble, double[].class, 625, 15161, 15167)) {
                    if (CallChecker.beforeDeref(b, Decimal64[].class, 625, 15174, 15174)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(b, Decimal64[].class, 625, 15174, 15174)[i], Decimal64.class, 625, 15174, 15177)) {
                            CallChecker.isCalled(b, Decimal64[].class, 625, 15174, 15174)[i] = CallChecker.beforeCalled(CallChecker.isCalled(b, Decimal64[].class, 625, 15174, 15174)[i], Decimal64.class, 625, 15174, 15177);
                            CallChecker.isCalled(bDouble, double[].class, 625, 15161, 15167)[i] = CallChecker.isCalled(CallChecker.isCalled(b, Decimal64[].class, 625, 15174, 15174)[i], Decimal64.class, 625, 15174, 15177).value;
                            CallChecker.varAssign(CallChecker.isCalled(bDouble, double[].class, 625, 15161, 15167)[i], "CallChecker.isCalled(bDouble, double[].class, 625, 15161, 15167)[i]", 625, 15161, 15184);
                        }
                    }
                }
            }
            return new Decimal64(MathArrays.linearCombination(a, bDouble));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5466.methodEnd();
        }
    }

    public Decimal64 linearCombination(final Decimal64 a1, final Decimal64 b1, final Decimal64 a2, final Decimal64 b2) {
        MethodContext _bcornu_methode_context5467 = new MethodContext(Decimal64.class, 633, 15279, 15645);
        try {
            CallChecker.varInit(this, "this", 633, 15279, 15645);
            CallChecker.varInit(b2, "b2", 633, 15279, 15645);
            CallChecker.varInit(a2, "a2", 633, 15279, 15645);
            CallChecker.varInit(b1, "b1", 633, 15279, 15645);
            CallChecker.varInit(a1, "a1", 633, 15279, 15645);
            CallChecker.varInit(this.value, "value", 633, 15279, 15645);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 633, 15279, 15645);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 633, 15279, 15645);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 633, 15279, 15645);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 633, 15279, 15645);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 633, 15279, 15645);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 633, 15279, 15645);
            if (CallChecker.beforeDeref(a1, Decimal64.class, 635, 15541, 15542)) {
                if (CallChecker.beforeDeref(b1, Decimal64.class, 635, 15551, 15552)) {
                    if (CallChecker.beforeDeref(a2, Decimal64.class, 636, 15619, 15620)) {
                        if (CallChecker.beforeDeref(b2, Decimal64.class, 636, 15629, 15630)) {
                            return new Decimal64(MathArrays.linearCombination(CallChecker.isCalled(a1, Decimal64.class, 635, 15541, 15542).value, CallChecker.isCalled(b1, Decimal64.class, 635, 15551, 15552).value, CallChecker.isCalled(a2, Decimal64.class, 636, 15619, 15620).value, CallChecker.isCalled(b2, Decimal64.class, 636, 15629, 15630).value));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5467.methodEnd();
        }
    }

    public Decimal64 linearCombination(final double a1, final Decimal64 b1, final double a2, final Decimal64 b2) {
        MethodContext _bcornu_methode_context5468 = new MethodContext(Decimal64.class, 642, 15652, 16000);
        try {
            CallChecker.varInit(this, "this", 642, 15652, 16000);
            CallChecker.varInit(b2, "b2", 642, 15652, 16000);
            CallChecker.varInit(a2, "a2", 642, 15652, 16000);
            CallChecker.varInit(b1, "b1", 642, 15652, 16000);
            CallChecker.varInit(a1, "a1", 642, 15652, 16000);
            CallChecker.varInit(this.value, "value", 642, 15652, 16000);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 642, 15652, 16000);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 642, 15652, 16000);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 642, 15652, 16000);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 642, 15652, 16000);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 642, 15652, 16000);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 642, 15652, 16000);
            if (CallChecker.beforeDeref(b1, Decimal64.class, 644, 15912, 15913)) {
                if (CallChecker.beforeDeref(b2, Decimal64.class, 645, 15984, 15985)) {
                    return new Decimal64(MathArrays.linearCombination(a1, CallChecker.isCalled(b1, Decimal64.class, 644, 15912, 15913).value, a2, CallChecker.isCalled(b2, Decimal64.class, 645, 15984, 15985).value));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5468.methodEnd();
        }
    }

    public Decimal64 linearCombination(final Decimal64 a1, final Decimal64 b1, final Decimal64 a2, final Decimal64 b2, final Decimal64 a3, final Decimal64 b3) {
        MethodContext _bcornu_methode_context5469 = new MethodContext(Decimal64.class, 651, 16007, 16530);
        try {
            CallChecker.varInit(this, "this", 651, 16007, 16530);
            CallChecker.varInit(b3, "b3", 651, 16007, 16530);
            CallChecker.varInit(a3, "a3", 651, 16007, 16530);
            CallChecker.varInit(b2, "b2", 651, 16007, 16530);
            CallChecker.varInit(a2, "a2", 651, 16007, 16530);
            CallChecker.varInit(b1, "b1", 651, 16007, 16530);
            CallChecker.varInit(a1, "a1", 651, 16007, 16530);
            CallChecker.varInit(this.value, "value", 651, 16007, 16530);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 651, 16007, 16530);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 651, 16007, 16530);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 651, 16007, 16530);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 651, 16007, 16530);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 651, 16007, 16530);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 651, 16007, 16530);
            if (CallChecker.beforeDeref(a1, Decimal64.class, 654, 16348, 16349)) {
                if (CallChecker.beforeDeref(b1, Decimal64.class, 654, 16358, 16359)) {
                    if (CallChecker.beforeDeref(a2, Decimal64.class, 655, 16426, 16427)) {
                        if (CallChecker.beforeDeref(b2, Decimal64.class, 655, 16436, 16437)) {
                            if (CallChecker.beforeDeref(a3, Decimal64.class, 656, 16504, 16505)) {
                                if (CallChecker.beforeDeref(b3, Decimal64.class, 656, 16514, 16515)) {
                                    return new Decimal64(MathArrays.linearCombination(CallChecker.isCalled(a1, Decimal64.class, 654, 16348, 16349).value, CallChecker.isCalled(b1, Decimal64.class, 654, 16358, 16359).value, CallChecker.isCalled(a2, Decimal64.class, 655, 16426, 16427).value, CallChecker.isCalled(b2, Decimal64.class, 655, 16436, 16437).value, CallChecker.isCalled(a3, Decimal64.class, 656, 16504, 16505).value, CallChecker.isCalled(b3, Decimal64.class, 656, 16514, 16515).value));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5469.methodEnd();
        }
    }

    public Decimal64 linearCombination(final double a1, final Decimal64 b1, final double a2, final Decimal64 b2, final double a3, final Decimal64 b3) {
        MethodContext _bcornu_methode_context5470 = new MethodContext(Decimal64.class, 662, 16537, 17033);
        try {
            CallChecker.varInit(this, "this", 662, 16537, 17033);
            CallChecker.varInit(b3, "b3", 662, 16537, 17033);
            CallChecker.varInit(a3, "a3", 662, 16537, 17033);
            CallChecker.varInit(b2, "b2", 662, 16537, 17033);
            CallChecker.varInit(a2, "a2", 662, 16537, 17033);
            CallChecker.varInit(b1, "b1", 662, 16537, 17033);
            CallChecker.varInit(a1, "a1", 662, 16537, 17033);
            CallChecker.varInit(this.value, "value", 662, 16537, 17033);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 662, 16537, 17033);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 662, 16537, 17033);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 662, 16537, 17033);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 662, 16537, 17033);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 662, 16537, 17033);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 662, 16537, 17033);
            if (CallChecker.beforeDeref(b1, Decimal64.class, 665, 16873, 16874)) {
                if (CallChecker.beforeDeref(b2, Decimal64.class, 666, 16945, 16946)) {
                    if (CallChecker.beforeDeref(b3, Decimal64.class, 667, 17017, 17018)) {
                        return new Decimal64(MathArrays.linearCombination(a1, CallChecker.isCalled(b1, Decimal64.class, 665, 16873, 16874).value, a2, CallChecker.isCalled(b2, Decimal64.class, 666, 16945, 16946).value, a3, CallChecker.isCalled(b3, Decimal64.class, 667, 17017, 17018).value));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5470.methodEnd();
        }
    }

    public Decimal64 linearCombination(final Decimal64 a1, final Decimal64 b1, final Decimal64 a2, final Decimal64 b2, final Decimal64 a3, final Decimal64 b3, final Decimal64 a4, final Decimal64 b4) {
        MethodContext _bcornu_methode_context5471 = new MethodContext(Decimal64.class, 673, 17040, 17720);
        try {
            CallChecker.varInit(this, "this", 673, 17040, 17720);
            CallChecker.varInit(b4, "b4", 673, 17040, 17720);
            CallChecker.varInit(a4, "a4", 673, 17040, 17720);
            CallChecker.varInit(b3, "b3", 673, 17040, 17720);
            CallChecker.varInit(a3, "a3", 673, 17040, 17720);
            CallChecker.varInit(b2, "b2", 673, 17040, 17720);
            CallChecker.varInit(a2, "a2", 673, 17040, 17720);
            CallChecker.varInit(b1, "b1", 673, 17040, 17720);
            CallChecker.varInit(a1, "a1", 673, 17040, 17720);
            CallChecker.varInit(this.value, "value", 673, 17040, 17720);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 673, 17040, 17720);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 673, 17040, 17720);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 673, 17040, 17720);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 673, 17040, 17720);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 673, 17040, 17720);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 673, 17040, 17720);
            if (CallChecker.beforeDeref(a1, Decimal64.class, 677, 17460, 17461)) {
                if (CallChecker.beforeDeref(b1, Decimal64.class, 677, 17470, 17471)) {
                    if (CallChecker.beforeDeref(a2, Decimal64.class, 678, 17538, 17539)) {
                        if (CallChecker.beforeDeref(b2, Decimal64.class, 678, 17548, 17549)) {
                            if (CallChecker.beforeDeref(a3, Decimal64.class, 679, 17616, 17617)) {
                                if (CallChecker.beforeDeref(b3, Decimal64.class, 679, 17626, 17627)) {
                                    if (CallChecker.beforeDeref(a4, Decimal64.class, 680, 17694, 17695)) {
                                        if (CallChecker.beforeDeref(b4, Decimal64.class, 680, 17704, 17705)) {
                                            return new Decimal64(MathArrays.linearCombination(CallChecker.isCalled(a1, Decimal64.class, 677, 17460, 17461).value, CallChecker.isCalled(b1, Decimal64.class, 677, 17470, 17471).value, CallChecker.isCalled(a2, Decimal64.class, 678, 17538, 17539).value, CallChecker.isCalled(b2, Decimal64.class, 678, 17548, 17549).value, CallChecker.isCalled(a3, Decimal64.class, 679, 17616, 17617).value, CallChecker.isCalled(b3, Decimal64.class, 679, 17626, 17627).value, CallChecker.isCalled(a4, Decimal64.class, 680, 17694, 17695).value, CallChecker.isCalled(b4, Decimal64.class, 680, 17704, 17705).value));
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5471.methodEnd();
        }
    }

    public Decimal64 linearCombination(final double a1, final Decimal64 b1, final double a2, final Decimal64 b2, final double a3, final Decimal64 b3, final double a4, final Decimal64 b4) {
        MethodContext _bcornu_methode_context5472 = new MethodContext(Decimal64.class, 686, 17727, 18371);
        try {
            CallChecker.varInit(this, "this", 686, 17727, 18371);
            CallChecker.varInit(b4, "b4", 686, 17727, 18371);
            CallChecker.varInit(a4, "a4", 686, 17727, 18371);
            CallChecker.varInit(b3, "b3", 686, 17727, 18371);
            CallChecker.varInit(a3, "a3", 686, 17727, 18371);
            CallChecker.varInit(b2, "b2", 686, 17727, 18371);
            CallChecker.varInit(a2, "a2", 686, 17727, 18371);
            CallChecker.varInit(b1, "b1", 686, 17727, 18371);
            CallChecker.varInit(a1, "a1", 686, 17727, 18371);
            CallChecker.varInit(this.value, "value", 686, 17727, 18371);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.Decimal64.serialVersionUID", 686, 17727, 18371);
            CallChecker.varInit(NAN, "org.apache.commons.math3.util.Decimal64.NAN", 686, 17727, 18371);
            CallChecker.varInit(POSITIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.POSITIVE_INFINITY", 686, 17727, 18371);
            CallChecker.varInit(NEGATIVE_INFINITY, "org.apache.commons.math3.util.Decimal64.NEGATIVE_INFINITY", 686, 17727, 18371);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.Decimal64.ONE", 686, 17727, 18371);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.Decimal64.ZERO", 686, 17727, 18371);
            if (CallChecker.beforeDeref(b1, Decimal64.class, 690, 18139, 18140)) {
                if (CallChecker.beforeDeref(b2, Decimal64.class, 691, 18211, 18212)) {
                    if (CallChecker.beforeDeref(b3, Decimal64.class, 692, 18283, 18284)) {
                        if (CallChecker.beforeDeref(b4, Decimal64.class, 693, 18355, 18356)) {
                            return new Decimal64(MathArrays.linearCombination(a1, CallChecker.isCalled(b1, Decimal64.class, 690, 18139, 18140).value, a2, CallChecker.isCalled(b2, Decimal64.class, 691, 18211, 18212).value, a3, CallChecker.isCalled(b3, Decimal64.class, 692, 18283, 18284).value, a4, CallChecker.isCalled(b4, Decimal64.class, 693, 18355, 18356).value));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Decimal64) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5472.methodEnd();
        }
    }
}

