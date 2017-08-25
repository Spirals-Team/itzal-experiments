package org.apache.commons.math3.fraction;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class ProperBigFractionFormat extends BigFractionFormat {
    private static final long serialVersionUID = -6337346779577272307L;

    private NumberFormat wholeFormat;

    public ProperBigFractionFormat() {
        this(AbstractFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context778 = new ConstructorContext(ProperBigFractionFormat.class, 50, 1765, 1984);
        try {
        } finally {
            _bcornu_methode_context778.methodEnd();
        }
    }

    public ProperBigFractionFormat(final NumberFormat format) {
        this(format, ((NumberFormat) (CallChecker.isCalled(format, NumberFormat.class, 61, 2319, 2324).clone())), ((NumberFormat) (CallChecker.isCalled(format, NumberFormat.class, 61, 2349, 2354).clone())));
        ConstructorContext _bcornu_methode_context779 = new ConstructorContext(ProperBigFractionFormat.class, 60, 1991, 2370);
        try {
        } finally {
            _bcornu_methode_context779.methodEnd();
        }
    }

    public ProperBigFractionFormat(final NumberFormat wholeFormat, final NumberFormat numeratorFormat, final NumberFormat denominatorFormat) {
        super(numeratorFormat, denominatorFormat);
        ConstructorContext _bcornu_methode_context780 = new ConstructorContext(ProperBigFractionFormat.class, 71, 2377, 3020);
        try {
            setWholeFormat(wholeFormat);
        } finally {
            _bcornu_methode_context780.methodEnd();
        }
    }

    @Override
    public StringBuffer format(final BigFraction fraction, final StringBuffer toAppendTo, final FieldPosition pos) {
        MethodContext _bcornu_methode_context3478 = new MethodContext(StringBuffer.class, 89, 3027, 4286);
        try {
            CallChecker.varInit(this, "this", 89, 3027, 4286);
            CallChecker.varInit(pos, "pos", 89, 3027, 4286);
            CallChecker.varInit(toAppendTo, "toAppendTo", 89, 3027, 4286);
            CallChecker.varInit(fraction, "fraction", 89, 3027, 4286);
            CallChecker.varInit(this.wholeFormat, "wholeFormat", 89, 3027, 4286);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.ProperBigFractionFormat.serialVersionUID", 89, 3027, 4286);
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 92, 3611, 3613)) {
                CallChecker.isCalled(pos, FieldPosition.class, 92, 3611, 3613).setBeginIndex(0);
            }
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 93, 3641, 3643)) {
                CallChecker.isCalled(pos, FieldPosition.class, 93, 3641, 3643).setEndIndex(0);
            }
            BigInteger num = CallChecker.init(BigInteger.class);
            if (CallChecker.beforeDeref(fraction, BigFraction.class, 95, 3687, 3694)) {
                num = CallChecker.isCalled(fraction, BigFraction.class, 95, 3687, 3694).getNumerator();
                CallChecker.varAssign(num, "num", 95, 3687, 3694);
            }
            BigInteger den = CallChecker.init(BigInteger.class);
            if (CallChecker.beforeDeref(fraction, BigFraction.class, 96, 3737, 3744)) {
                den = CallChecker.isCalled(fraction, BigFraction.class, 96, 3737, 3744).getDenominator();
                CallChecker.varAssign(den, "den", 96, 3737, 3744);
            }
            BigInteger whole = CallChecker.init(BigInteger.class);
            if (CallChecker.beforeDeref(num, BigInteger.class, 97, 3791, 3793)) {
                num = CallChecker.beforeCalled(num, BigInteger.class, 97, 3791, 3793);
                whole = CallChecker.isCalled(num, BigInteger.class, 97, 3791, 3793).divide(den);
                CallChecker.varAssign(whole, "whole", 97, 3791, 3793);
            }
            if (CallChecker.beforeDeref(num, BigInteger.class, 98, 3822, 3824)) {
                num = CallChecker.beforeCalled(num, BigInteger.class, 98, 3822, 3824);
                num = CallChecker.isCalled(num, BigInteger.class, 98, 3822, 3824).remainder(den);
                CallChecker.varAssign(num, "num", 98, 3816, 3840);
            }
            if (CallChecker.beforeDeref(BigInteger.ZERO, BigInteger.class, 100, 3856, 3870)) {
                if (!(CallChecker.isCalled(BigInteger.ZERO, BigInteger.class, 100, 3856, 3870).equals(whole))) {
                    final NumberFormat npe_invocation_var812 = getWholeFormat();
                    if (CallChecker.beforeDeref(npe_invocation_var812, NumberFormat.class, 101, 3901, 3916)) {
                        CallChecker.isCalled(npe_invocation_var812, NumberFormat.class, 101, 3901, 3916).format(whole, toAppendTo, pos);
                    }
                    if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 102, 3962, 3971)) {
                        CallChecker.isCalled(toAppendTo, StringBuffer.class, 102, 3962, 3971).append(' ');
                    }
                    if (CallChecker.beforeDeref(num, BigInteger.class, 103, 4002, 4004)) {
                        num = CallChecker.beforeCalled(num, BigInteger.class, 103, 4002, 4004);
                        if ((CallChecker.isCalled(num, BigInteger.class, 103, 4002, 4004).compareTo(BigInteger.ZERO)) < 0) {
                            if (CallChecker.beforeDeref(num, BigInteger.class, 104, 4062, 4064)) {
                                num = CallChecker.beforeCalled(num, BigInteger.class, 104, 4062, 4064);
                                num = CallChecker.isCalled(num, BigInteger.class, 104, 4062, 4064).negate();
                                CallChecker.varAssign(num, "num", 104, 4056, 4074);
                            }
                        }
                    }
                }
            }
            final NumberFormat npe_invocation_var813 = getNumeratorFormat();
            if (CallChecker.beforeDeref(npe_invocation_var813, NumberFormat.class, 107, 4108, 4127)) {
                CallChecker.isCalled(npe_invocation_var813, NumberFormat.class, 107, 4108, 4127).format(num, toAppendTo, pos);
            }
            if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 108, 4167, 4176)) {
                CallChecker.isCalled(toAppendTo, StringBuffer.class, 108, 4167, 4176).append(" / ");
            }
            final NumberFormat npe_invocation_var814 = getDenominatorFormat();
            if (CallChecker.beforeDeref(npe_invocation_var814, NumberFormat.class, 109, 4201, 4222)) {
                CallChecker.isCalled(npe_invocation_var814, NumberFormat.class, 109, 4201, 4222).format(den, toAppendTo, pos);
            }
            return toAppendTo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3478.methodEnd();
        }
    }

    public NumberFormat getWholeFormat() {
        MethodContext _bcornu_methode_context3479 = new MethodContext(NumberFormat.class, 118, 4293, 4445);
        try {
            CallChecker.varInit(this, "this", 118, 4293, 4445);
            CallChecker.varInit(this.wholeFormat, "wholeFormat", 118, 4293, 4445);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.ProperBigFractionFormat.serialVersionUID", 118, 4293, 4445);
            return wholeFormat;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3479.methodEnd();
        }
    }

    @Override
    public BigFraction parse(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context3480 = new MethodContext(BigFraction.class, 135, 4452, 7824);
        try {
            CallChecker.varInit(this, "this", 135, 4452, 7824);
            CallChecker.varInit(pos, "pos", 135, 4452, 7824);
            CallChecker.varInit(source, "source", 135, 4452, 7824);
            CallChecker.varInit(this.wholeFormat, "wholeFormat", 135, 4452, 7824);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.ProperBigFractionFormat.serialVersionUID", 135, 4452, 7824);
            BigFraction ret = CallChecker.varInit(super.parse(source, pos), "ret", 137, 5117, 5159);
            if (ret != null) {
                return ret;
            }
            final int initialIndex = CallChecker.varInit(((int) (CallChecker.isCalled(pos, ParsePosition.class, 142, 5256, 5258).getIndex())), "initialIndex", 142, 5231, 5270);
            AbstractFormat.parseAndIgnoreWhitespace(source, pos);
            BigInteger whole = CallChecker.varInit(parseNextBigInteger(source, pos), "whole", 148, 5380, 5431);
            if (whole == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 153, 5623, 5625)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 153, 5623, 5625).setIndex(initialIndex);
                }
                return null;
            }
            AbstractFormat.parseAndIgnoreWhitespace(source, pos);
            BigInteger num = CallChecker.varInit(parseNextBigInteger(source, pos), "num", 161, 5798, 5847);
            if (num == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 166, 6037, 6039)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 166, 6037, 6039).setIndex(initialIndex);
                }
                return null;
            }
            if ((num.compareTo(BigInteger.ZERO)) < 0) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 172, 6228, 6230)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 172, 6228, 6230).setIndex(initialIndex);
                }
                return null;
            }
            final int startIndex = CallChecker.varInit(((int) (CallChecker.isCalled(pos, ParsePosition.class, 177, 6344, 6346).getIndex())), "startIndex", 177, 6300, 6358);
            final char c = CallChecker.varInit(((char) (AbstractFormat.parseNextCharacter(source, pos))), "c", 178, 6368, 6414);
            switch (c) {
                case 0 :
                    return new BigFraction(num);
                case '/' :
                    break;
                default :
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 191, 6818, 6820)) {
                        CallChecker.isCalled(pos, ParsePosition.class, 191, 6818, 6820).setIndex(initialIndex);
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 192, 6858, 6860)) {
                        CallChecker.isCalled(pos, ParsePosition.class, 192, 6858, 6860).setErrorIndex(startIndex);
                    }else
                        throw new AbnormalExecutionError();
                    
                    return null;
            }
            AbstractFormat.parseAndIgnoreWhitespace(source, pos);
            final BigInteger den = CallChecker.varInit(parseNextBigInteger(source, pos), "den", 200, 7009, 7093);
            if (den == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 205, 7283, 7285)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 205, 7283, 7285).setIndex(initialIndex);
                }
                return null;
            }
            if ((den.compareTo(BigInteger.ZERO)) < 0) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 211, 7461, 7463)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 211, 7461, 7463).setIndex(initialIndex);
                }
                return null;
            }
            boolean wholeIsNeg = CallChecker.varInit(((boolean) ((whole.compareTo(BigInteger.ZERO)) < 0)), "wholeIsNeg", 215, 7533, 7590);
            if (wholeIsNeg) {
                whole = whole.negate();
                CallChecker.varAssign(whole, "whole", 217, 7630, 7652);
            }
            whole = CallChecker.beforeCalled(whole, BigInteger.class, 219, 7678, 7682);
            if (CallChecker.beforeDeref(CallChecker.isCalled(whole, BigInteger.class, 219, 7678, 7682).multiply(den), BigInteger.class, 219, 7678, 7696)) {
                num = CallChecker.isCalled(whole.multiply(den), BigInteger.class, 219, 7678, 7696).add(num);
                CallChecker.varAssign(num, "num", 219, 7672, 7706);
            }
            if (wholeIsNeg) {
                num = num.negate();
                CallChecker.varAssign(num, "num", 221, 7746, 7764);
            }
            return new BigFraction(num, den);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigFraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3480.methodEnd();
        }
    }

    public void setWholeFormat(final NumberFormat format) {
        MethodContext _bcornu_methode_context3481 = new MethodContext(void.class, 233, 7831, 8211);
        try {
            CallChecker.varInit(this, "this", 233, 7831, 8211);
            CallChecker.varInit(format, "format", 233, 7831, 8211);
            CallChecker.varInit(this.wholeFormat, "wholeFormat", 233, 7831, 8211);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.ProperBigFractionFormat.serialVersionUID", 233, 7831, 8211);
            if (format == null) {
                throw new NullArgumentException(LocalizedFormats.WHOLE_FORMAT);
            }
            this.wholeFormat = format;
            CallChecker.varAssign(this.wholeFormat, "this.wholeFormat", 237, 8180, 8205);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3481.methodEnd();
        }
    }
}

