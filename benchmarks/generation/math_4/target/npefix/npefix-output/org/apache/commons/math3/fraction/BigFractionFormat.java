package org.apache.commons.math3.fraction;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathParseException;

public class BigFractionFormat extends AbstractFormat implements Serializable {
    private static final long serialVersionUID = -2932167925527338976L;

    public BigFractionFormat() {
        ConstructorContext _bcornu_methode_context291 = new ConstructorContext(BigFractionFormat.class, 50, 1654, 1822);
        try {
        } finally {
            _bcornu_methode_context291.methodEnd();
        }
    }

    public BigFractionFormat(final NumberFormat format) {
        super(format);
        ConstructorContext _bcornu_methode_context292 = new ConstructorContext(BigFractionFormat.class, 58, 1829, 2126);
        try {
        } finally {
            _bcornu_methode_context292.methodEnd();
        }
    }

    public BigFractionFormat(final NumberFormat numeratorFormat, final NumberFormat denominatorFormat) {
        super(numeratorFormat, denominatorFormat);
        ConstructorContext _bcornu_methode_context293 = new ConstructorContext(BigFractionFormat.class, 68, 2133, 2619);
        try {
        } finally {
            _bcornu_methode_context293.methodEnd();
        }
    }

    public static Locale[] getAvailableLocales() {
        MethodContext _bcornu_methode_context1313 = new MethodContext(Locale[].class, 78, 2626, 2926);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionFormat.serialVersionUID", 78, 2626, 2926);
            return NumberFormat.getAvailableLocales();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Locale[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1313.methodEnd();
        }
    }

    public static String formatBigFraction(final BigFraction f) {
        MethodContext _bcornu_methode_context1314 = new MethodContext(String.class, 89, 2933, 3273);
        try {
            CallChecker.varInit(f, "f", 89, 2933, 3273);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionFormat.serialVersionUID", 89, 2933, 3273);
            final BigFractionFormat npe_invocation_var126 = BigFractionFormat.getImproperInstance();
            if (CallChecker.beforeDeref(npe_invocation_var126, BigFractionFormat.class, 90, 3236, 3256)) {
                return CallChecker.isCalled(npe_invocation_var126, BigFractionFormat.class, 90, 3236, 3256).format(f);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1314.methodEnd();
        }
    }

    public static BigFractionFormat getImproperInstance() {
        MethodContext _bcornu_methode_context1315 = new MethodContext(BigFractionFormat.class, 97, 3280, 3522);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionFormat.serialVersionUID", 97, 3280, 3522);
            return BigFractionFormat.getImproperInstance(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFractionFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1315.methodEnd();
        }
    }

    public static BigFractionFormat getImproperInstance(final Locale locale) {
        MethodContext _bcornu_methode_context1316 = new MethodContext(BigFractionFormat.class, 106, 3529, 3883);
        try {
            CallChecker.varInit(locale, "locale", 106, 3529, 3883);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionFormat.serialVersionUID", 106, 3529, 3883);
            return new BigFractionFormat(AbstractFormat.getDefaultNumberFormat(locale));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFractionFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1316.methodEnd();
        }
    }

    public static BigFractionFormat getProperInstance() {
        MethodContext _bcornu_methode_context1317 = new MethodContext(BigFractionFormat.class, 114, 3890, 4128);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionFormat.serialVersionUID", 114, 3890, 4128);
            return BigFractionFormat.getProperInstance(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFractionFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1317.methodEnd();
        }
    }

    public static BigFractionFormat getProperInstance(final Locale locale) {
        MethodContext _bcornu_methode_context1318 = new MethodContext(BigFractionFormat.class, 123, 4135, 4493);
        try {
            CallChecker.varInit(locale, "locale", 123, 4135, 4493);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionFormat.serialVersionUID", 123, 4135, 4493);
            return new ProperBigFractionFormat(AbstractFormat.getDefaultNumberFormat(locale));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFractionFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1318.methodEnd();
        }
    }

    public StringBuffer format(final BigFraction BigFraction, final StringBuffer toAppendTo, final FieldPosition pos) {
        MethodContext _bcornu_methode_context1319 = new MethodContext(StringBuffer.class, 137, 4500, 5363);
        try {
            CallChecker.varInit(this, "this", 137, 4500, 5363);
            CallChecker.varInit(pos, "pos", 137, 4500, 5363);
            CallChecker.varInit(toAppendTo, "toAppendTo", 137, 4500, 5363);
            CallChecker.varInit(BigFraction, "BigFraction", 137, 4500, 5363);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionFormat.serialVersionUID", 137, 4500, 5363);
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 140, 5078, 5080)) {
                CallChecker.isCalled(pos, FieldPosition.class, 140, 5078, 5080).setBeginIndex(0);
            }
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 141, 5108, 5110)) {
                CallChecker.isCalled(pos, FieldPosition.class, 141, 5108, 5110).setEndIndex(0);
            }
            if (CallChecker.beforeDeref(BigFraction, BigFraction.class, 143, 5165, 5175)) {
                final NumberFormat npe_invocation_var127 = getNumeratorFormat();
                if (CallChecker.beforeDeref(npe_invocation_var127, NumberFormat.class, 143, 5137, 5156)) {
                    CallChecker.isCalled(npe_invocation_var127, NumberFormat.class, 143, 5137, 5156).format(CallChecker.isCalled(BigFraction, BigFraction.class, 143, 5165, 5175).getNumerator(), toAppendTo, pos);
                }
            }
            if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 144, 5219, 5228)) {
                CallChecker.isCalled(toAppendTo, StringBuffer.class, 144, 5219, 5228).append(" / ");
            }
            if (CallChecker.beforeDeref(BigFraction, BigFraction.class, 145, 5283, 5293)) {
                final NumberFormat npe_invocation_var128 = getDenominatorFormat();
                if (CallChecker.beforeDeref(npe_invocation_var128, NumberFormat.class, 145, 5253, 5274)) {
                    CallChecker.isCalled(npe_invocation_var128, NumberFormat.class, 145, 5253, 5274).format(CallChecker.isCalled(BigFraction, BigFraction.class, 145, 5283, 5293).getDenominator(), toAppendTo, pos);
                }
            }
            return toAppendTo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1319.methodEnd();
        }
    }

    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        MethodContext _bcornu_methode_context1320 = new MethodContext(StringBuffer.class, 165, 5370, 6877);
        try {
            CallChecker.varInit(this, "this", 165, 5370, 6877);
            CallChecker.varInit(pos, "pos", 165, 5370, 6877);
            CallChecker.varInit(toAppendTo, "toAppendTo", 165, 5370, 6877);
            CallChecker.varInit(obj, "obj", 165, 5370, 6877);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionFormat.serialVersionUID", 165, 5370, 6877);
            StringBuffer ret = CallChecker.init(StringBuffer.class);
            if (obj instanceof BigFraction) {
                ret = format(((BigFraction) (obj)), toAppendTo, pos);
                CallChecker.varAssign(ret, "ret", 170, 6387, 6435);
            }else
                if (obj instanceof BigInteger) {
                    ret = format(new BigFraction(((BigInteger) (obj))), toAppendTo, pos);
                    CallChecker.varAssign(ret, "ret", 172, 6497, 6561);
                }else
                    if (obj instanceof Number) {
                        if (CallChecker.beforeDeref(obj, Object.class, 174, 6658, 6660)) {
                            ret = format(new BigFraction(CallChecker.isCalled(((Number) (obj)), Number.class, 174, 6658, 6660).doubleValue()), toAppendTo, pos);
                            CallChecker.varAssign(ret, "ret", 174, 6619, 6720);
                        }
                    }else {
                        throw new org.apache.commons.math3.exception.MathIllegalArgumentException(org.apache.commons.math3.exception.util.LocalizedFormats.CANNOT_FORMAT_OBJECT_TO_FRACTION);
                    }
                
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1320.methodEnd();
        }
    }

    @Override
    public BigFraction parse(final String source) throws MathParseException {
        MethodContext _bcornu_methode_context1321 = new MethodContext(BigFraction.class, 191, 6884, 7574);
        try {
            CallChecker.varInit(this, "this", 191, 6884, 7574);
            CallChecker.varInit(source, "source", 191, 6884, 7574);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionFormat.serialVersionUID", 191, 6884, 7574);
            final ParsePosition parsePosition = CallChecker.varInit(new ParsePosition(0), "parsePosition", 192, 7269, 7325);
            final BigFraction result = CallChecker.varInit(parse(source, parsePosition), "result", 193, 7335, 7390);
            if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 194, 7404, 7416)) {
                if ((CallChecker.isCalled(parsePosition, ParsePosition.class, 194, 7404, 7416).getIndex()) == 0) {
                    if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 195, 7486, 7498)) {
                        throw new MathParseException(source, CallChecker.isCalled(parsePosition, ParsePosition.class, 195, 7486, 7498).getErrorIndex(), BigFraction.class);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1321.methodEnd();
        }
    }

    @Override
    public BigFraction parse(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context1322 = new MethodContext(BigFraction.class, 208, 7581, 9546);
        try {
            CallChecker.varInit(this, "this", 208, 7581, 9546);
            CallChecker.varInit(pos, "pos", 208, 7581, 9546);
            CallChecker.varInit(source, "source", 208, 7581, 9546);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionFormat.serialVersionUID", 208, 7581, 9546);
            final int initialIndex = CallChecker.varInit(((int) (CallChecker.isCalled(pos, ParsePosition.class, 209, 8008, 8010).getIndex())), "initialIndex", 209, 7983, 8022);
            AbstractFormat.parseAndIgnoreWhitespace(source, pos);
            final BigInteger num = CallChecker.varInit(parseNextBigInteger(source, pos), "num", 215, 8109, 8191);
            if (num == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 220, 8381, 8383)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 220, 8381, 8383).setIndex(initialIndex);
                }
                return null;
            }
            final int startIndex = CallChecker.varInit(((int) (CallChecker.isCalled(pos, ParsePosition.class, 225, 8497, 8499).getIndex())), "startIndex", 225, 8453, 8511);
            final char c = CallChecker.varInit(((char) (AbstractFormat.parseNextCharacter(source, pos))), "c", 226, 8521, 8567);
            switch (c) {
                case 0 :
                    return new BigFraction(num);
                case '/' :
                    break;
                default :
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 239, 8971, 8973)) {
                        CallChecker.isCalled(pos, ParsePosition.class, 239, 8971, 8973).setIndex(initialIndex);
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 240, 9011, 9013)) {
                        CallChecker.isCalled(pos, ParsePosition.class, 240, 9011, 9013).setErrorIndex(startIndex);
                    }else
                        throw new AbnormalExecutionError();
                    
                    return null;
            }
            AbstractFormat.parseAndIgnoreWhitespace(source, pos);
            final BigInteger den = CallChecker.varInit(parseNextBigInteger(source, pos), "den", 248, 9162, 9246);
            if (den == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 253, 9436, 9438)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 253, 9436, 9438).setIndex(initialIndex);
                }
                return null;
            }
            return new BigFraction(num, den);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1322.methodEnd();
        }
    }

    protected BigInteger parseNextBigInteger(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context1323 = new MethodContext(BigInteger.class, 267, 9553, 10501);
        try {
            CallChecker.varInit(this, "this", 267, 9553, 10501);
            CallChecker.varInit(pos, "pos", 267, 9553, 10501);
            CallChecker.varInit(source, "source", 267, 9553, 10501);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.BigFractionFormat.serialVersionUID", 267, 9553, 10501);
            final int start = CallChecker.varInit(((int) (CallChecker.isCalled(pos, ParsePosition.class, 270, 10011, 10013).getIndex())), "start", 270, 9993, 10025);
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(source, String.class, 271, 10047, 10052)) {
                if ((CallChecker.isCalled(source, String.class, 271, 10047, 10052).charAt(start)) == '-') {
                    end = start + 1;
                    CallChecker.varAssign(end, "end", 271, 10046, 10096);
                }else {
                    end = start;
                    CallChecker.varAssign(end, "end", 271, 10046, 10096);
                }
            }
            while ((end < (CallChecker.isCalled(source, String.class, 272, 10121, 10126).length())) && (Character.isDigit(CallChecker.isCalled(source, String.class, 273, 10174, 10179).charAt(end)))) {
                ++end;
            } 
            TryContext _bcornu_try_context_22 = new TryContext(22, BigFractionFormat.class, "java.lang.NumberFormatException");
            try {
                BigInteger n = CallChecker.init(BigInteger.class);
                if (CallChecker.beforeDeref(source, String.class, 278, 10287, 10292)) {
                    n = new BigInteger(CallChecker.isCalled(source, String.class, 278, 10287, 10292).substring(start, end));
                    CallChecker.varAssign(n, "n", 278, 10287, 10292);
                }
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 279, 10331, 10333)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 279, 10331, 10333).setIndex(end);
                }
                return n;
            } catch (NumberFormatException nfe) {
                _bcornu_try_context_22.catchStart(22);
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 282, 10433, 10435)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 282, 10433, 10435).setErrorIndex(start);
                }
                return null;
            } finally {
                _bcornu_try_context_22.finallyStart(22);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigInteger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1323.methodEnd();
        }
    }
}

