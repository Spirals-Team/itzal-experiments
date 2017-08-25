package org.apache.commons.math3.fraction;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathParseException;

public class FractionFormat extends AbstractFormat {
    private static final long serialVersionUID = 3008655719530972611L;

    public FractionFormat() {
        ConstructorContext _bcornu_methode_context56 = new ConstructorContext(FractionFormat.class, 46, 1551, 1716);
        try {
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }

    public FractionFormat(final NumberFormat format) {
        super(format);
        ConstructorContext _bcornu_methode_context57 = new ConstructorContext(FractionFormat.class, 54, 1723, 2017);
        try {
        } finally {
            _bcornu_methode_context57.methodEnd();
        }
    }

    public FractionFormat(final NumberFormat numeratorFormat, final NumberFormat denominatorFormat) {
        super(numeratorFormat, denominatorFormat);
        ConstructorContext _bcornu_methode_context58 = new ConstructorContext(FractionFormat.class, 64, 2024, 2504);
        try {
        } finally {
            _bcornu_methode_context58.methodEnd();
        }
    }

    public static Locale[] getAvailableLocales() {
        MethodContext _bcornu_methode_context227 = new MethodContext(Locale[].class, 74, 2511, 2811);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionFormat.serialVersionUID", 74, 2511, 2811);
            return NumberFormat.getAvailableLocales();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Locale[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context227.methodEnd();
        }
    }

    public static String formatFraction(Fraction f) {
        MethodContext _bcornu_methode_context228 = new MethodContext(String.class, 85, 2818, 3134);
        try {
            CallChecker.varInit(f, "f", 85, 2818, 3134);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionFormat.serialVersionUID", 85, 2818, 3134);
            final FractionFormat npe_invocation_var27 = FractionFormat.getImproperInstance();
            if (CallChecker.beforeDeref(npe_invocation_var27, FractionFormat.class, 86, 3097, 3117)) {
                return CallChecker.isCalled(npe_invocation_var27, FractionFormat.class, 86, 3097, 3117).format(f);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context228.methodEnd();
        }
    }

    public static FractionFormat getImproperInstance() {
        MethodContext _bcornu_methode_context229 = new MethodContext(FractionFormat.class, 93, 3141, 3380);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionFormat.serialVersionUID", 93, 3141, 3380);
            return FractionFormat.getImproperInstance(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((FractionFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context229.methodEnd();
        }
    }

    public static FractionFormat getImproperInstance(final Locale locale) {
        MethodContext _bcornu_methode_context230 = new MethodContext(FractionFormat.class, 102, 3387, 3735);
        try {
            CallChecker.varInit(locale, "locale", 102, 3387, 3735);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionFormat.serialVersionUID", 102, 3387, 3735);
            return new FractionFormat(AbstractFormat.getDefaultNumberFormat(locale));
        } catch (ForceReturn _bcornu_return_t) {
            return ((FractionFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context230.methodEnd();
        }
    }

    public static FractionFormat getProperInstance() {
        MethodContext _bcornu_methode_context231 = new MethodContext(FractionFormat.class, 110, 3742, 3977);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionFormat.serialVersionUID", 110, 3742, 3977);
            return FractionFormat.getProperInstance(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((FractionFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context231.methodEnd();
        }
    }

    public static FractionFormat getProperInstance(final Locale locale) {
        MethodContext _bcornu_methode_context232 = new MethodContext(FractionFormat.class, 119, 3984, 4336);
        try {
            CallChecker.varInit(locale, "locale", 119, 3984, 4336);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionFormat.serialVersionUID", 119, 3984, 4336);
            return new ProperFractionFormat(AbstractFormat.getDefaultNumberFormat(locale));
        } catch (ForceReturn _bcornu_return_t) {
            return ((FractionFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context232.methodEnd();
        }
    }

    protected static NumberFormat getDefaultNumberFormat() {
        MethodContext _bcornu_methode_context233 = new MethodContext(NumberFormat.class, 129, 4343, 4758);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionFormat.serialVersionUID", 129, 4343, 4758);
            return AbstractFormat.getDefaultNumberFormat(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context233.methodEnd();
        }
    }

    public StringBuffer format(final Fraction fraction, final StringBuffer toAppendTo, final FieldPosition pos) {
        MethodContext _bcornu_methode_context234 = new MethodContext(StringBuffer.class, 143, 4765, 5619);
        try {
            CallChecker.varInit(this, "this", 143, 4765, 5619);
            CallChecker.varInit(pos, "pos", 143, 4765, 5619);
            CallChecker.varInit(toAppendTo, "toAppendTo", 143, 4765, 5619);
            CallChecker.varInit(fraction, "fraction", 143, 4765, 5619);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionFormat.serialVersionUID", 143, 4765, 5619);
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 146, 5328, 5330)) {
                CallChecker.isCalled(pos, FieldPosition.class, 146, 5328, 5330).setBeginIndex(0);
            }
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 147, 5358, 5360)) {
                CallChecker.isCalled(pos, FieldPosition.class, 147, 5358, 5360).setEndIndex(0);
            }
            if (CallChecker.beforeDeref(fraction, Fraction.class, 149, 5415, 5422)) {
                final NumberFormat npe_invocation_var28 = getNumeratorFormat();
                if (CallChecker.beforeDeref(npe_invocation_var28, NumberFormat.class, 149, 5387, 5406)) {
                    CallChecker.isCalled(npe_invocation_var28, NumberFormat.class, 149, 5387, 5406).format(CallChecker.isCalled(fraction, Fraction.class, 149, 5415, 5422).getNumerator(), toAppendTo, pos);
                }
            }
            if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 150, 5466, 5475)) {
                CallChecker.isCalled(toAppendTo, StringBuffer.class, 150, 5466, 5475).append(" / ");
            }
            if (CallChecker.beforeDeref(fraction, Fraction.class, 151, 5530, 5537)) {
                final NumberFormat npe_invocation_var29 = getDenominatorFormat();
                if (CallChecker.beforeDeref(npe_invocation_var29, NumberFormat.class, 151, 5500, 5521)) {
                    CallChecker.isCalled(npe_invocation_var29, NumberFormat.class, 151, 5500, 5521).format(CallChecker.isCalled(fraction, Fraction.class, 151, 5530, 5537).getDenominator(), toAppendTo, pos);
                }
            }
            return toAppendTo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context234.methodEnd();
        }
    }

    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) throws MathIllegalArgumentException, FractionConversionException {
        MethodContext _bcornu_methode_context235 = new MethodContext(StringBuffer.class, 172, 5626, 7097);
        try {
            CallChecker.varInit(this, "this", 172, 5626, 7097);
            CallChecker.varInit(pos, "pos", 172, 5626, 7097);
            CallChecker.varInit(toAppendTo, "toAppendTo", 172, 5626, 7097);
            CallChecker.varInit(obj, "obj", 172, 5626, 7097);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionFormat.serialVersionUID", 172, 5626, 7097);
            StringBuffer ret = CallChecker.varInit(null, "ret", 175, 6687, 6710);
            if (obj instanceof Fraction) {
                ret = format(((Fraction) (obj)), toAppendTo, pos);
                CallChecker.varAssign(ret, "ret", 178, 6764, 6809);
            }else
                if (obj instanceof Number) {
                    if (CallChecker.beforeDeref(obj, Object.class, 180, 6903, 6905)) {
                        ret = format(new Fraction(CallChecker.isCalled(((Number) (obj)), Number.class, 180, 6903, 6905).doubleValue()), toAppendTo, pos);
                        CallChecker.varAssign(ret, "ret", 180, 6867, 6940);
                    }
                }else {
                    throw new MathIllegalArgumentException(org.apache.commons.math3.exception.util.LocalizedFormats.CANNOT_FORMAT_OBJECT_TO_FRACTION);
                }
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context235.methodEnd();
        }
    }

    @Override
    public Fraction parse(final String source) throws MathParseException {
        MethodContext _bcornu_methode_context236 = new MethodContext(Fraction.class, 196, 7104, 7779);
        try {
            CallChecker.varInit(this, "this", 196, 7104, 7779);
            CallChecker.varInit(source, "source", 196, 7104, 7779);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionFormat.serialVersionUID", 196, 7104, 7779);
            final ParsePosition parsePosition = CallChecker.varInit(new ParsePosition(0), "parsePosition", 197, 7480, 7536);
            final Fraction result = CallChecker.varInit(parse(source, parsePosition), "result", 198, 7546, 7598);
            if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 199, 7612, 7624)) {
                if ((CallChecker.isCalled(parsePosition, ParsePosition.class, 199, 7612, 7624).getIndex()) == 0) {
                    if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 200, 7694, 7706)) {
                        throw new MathParseException(source, CallChecker.isCalled(parsePosition, ParsePosition.class, 200, 7694, 7706).getErrorIndex(), Fraction.class);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context236.methodEnd();
        }
    }

    @Override
    public Fraction parse(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context237 = new MethodContext(Fraction.class, 213, 7786, 9775);
        try {
            CallChecker.varInit(this, "this", 213, 7786, 9775);
            CallChecker.varInit(pos, "pos", 213, 7786, 9775);
            CallChecker.varInit(source, "source", 213, 7786, 9775);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.FractionFormat.serialVersionUID", 213, 7786, 9775);
            final int initialIndex = CallChecker.varInit(((int) (CallChecker.isCalled(pos, ParsePosition.class, 214, 8202, 8204).getIndex())), "initialIndex", 214, 8177, 8216);
            AbstractFormat.parseAndIgnoreWhitespace(source, pos);
            final Number num = CallChecker.varInit(CallChecker.isCalled(getNumeratorFormat(), NumberFormat.class, 220, 8349, 8368).parse(source, pos), "num", 220, 8303, 8388);
            if (num == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 225, 8578, 8580)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 225, 8578, 8580).setIndex(initialIndex);
                }
                return null;
            }
            final int startIndex = CallChecker.varInit(((int) (CallChecker.isCalled(pos, ParsePosition.class, 230, 8694, 8696).getIndex())), "startIndex", 230, 8650, 8708);
            final char c = CallChecker.varInit(((char) (AbstractFormat.parseNextCharacter(source, pos))), "c", 231, 8718, 8764);
            switch (c) {
                case 0 :
                    return new Fraction(num.intValue(), 1);
                case '/' :
                    break;
                default :
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 244, 9176, 9178)) {
                        CallChecker.isCalled(pos, ParsePosition.class, 244, 9176, 9178).setIndex(initialIndex);
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 245, 9216, 9218)) {
                        CallChecker.isCalled(pos, ParsePosition.class, 245, 9216, 9218).setErrorIndex(startIndex);
                    }else
                        throw new AbnormalExecutionError();
                    
                    return null;
            }
            AbstractFormat.parseAndIgnoreWhitespace(source, pos);
            final Number den = CallChecker.varInit(CallChecker.isCalled(getDenominatorFormat(), NumberFormat.class, 253, 9415, 9436).parse(source, pos), "den", 253, 9367, 9456);
            if (den == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 258, 9646, 9648)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 258, 9646, 9648).setIndex(initialIndex);
                }
                return null;
            }
            return new Fraction(num.intValue(), den.intValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context237.methodEnd();
        }
    }
}

