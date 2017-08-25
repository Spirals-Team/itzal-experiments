package org.apache.commons.math3.fraction;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

public class ProperFractionFormat extends FractionFormat {
    private static final long serialVersionUID = 760934726031766749L;

    private NumberFormat wholeFormat;

    public ProperFractionFormat() {
        this(FractionFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context658 = new ConstructorContext(ProperFractionFormat.class, 50, 1773, 1989);
        try {
        } finally {
            _bcornu_methode_context658.methodEnd();
        }
    }

    public ProperFractionFormat(NumberFormat format) {
        this(format, ((NumberFormat) (CallChecker.isCalled(format, NumberFormat.class, 61, 2315, 2320).clone())), ((NumberFormat) (CallChecker.isCalled(format, NumberFormat.class, 61, 2345, 2350).clone())));
        ConstructorContext _bcornu_methode_context659 = new ConstructorContext(ProperFractionFormat.class, 60, 1996, 2366);
        try {
        } finally {
            _bcornu_methode_context659.methodEnd();
        }
    }

    public ProperFractionFormat(NumberFormat wholeFormat, NumberFormat numeratorFormat, NumberFormat denominatorFormat) {
        super(numeratorFormat, denominatorFormat);
        ConstructorContext _bcornu_methode_context660 = new ConstructorContext(ProperFractionFormat.class, 71, 2373, 2953);
        try {
            setWholeFormat(wholeFormat);
        } finally {
            _bcornu_methode_context660.methodEnd();
        }
    }

    @Override
    public StringBuffer format(Fraction fraction, StringBuffer toAppendTo, FieldPosition pos) {
        MethodContext _bcornu_methode_context2929 = new MethodContext(StringBuffer.class, 90, 2960, 4058);
        try {
            CallChecker.varInit(this, "this", 90, 2960, 4058);
            CallChecker.varInit(pos, "pos", 90, 2960, 4058);
            CallChecker.varInit(toAppendTo, "toAppendTo", 90, 2960, 4058);
            CallChecker.varInit(fraction, "fraction", 90, 2960, 4058);
            CallChecker.varInit(this.wholeFormat, "wholeFormat", 90, 2960, 4058);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.ProperFractionFormat.serialVersionUID", 90, 2960, 4058);
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 93, 3498, 3500)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 93, 3498, 3500);
                CallChecker.isCalled(pos, FieldPosition.class, 93, 3498, 3500).setBeginIndex(0);
            }
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 94, 3528, 3530)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 94, 3528, 3530);
                CallChecker.isCalled(pos, FieldPosition.class, 94, 3528, 3530).setEndIndex(0);
            }
            int num = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(fraction, Fraction.class, 96, 3567, 3574)) {
                fraction = CallChecker.beforeCalled(fraction, Fraction.class, 96, 3567, 3574);
                num = CallChecker.isCalled(fraction, Fraction.class, 96, 3567, 3574).getNumerator();
                CallChecker.varAssign(num, "num", 96, 3567, 3574);
            }
            int den = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(fraction, Fraction.class, 97, 3610, 3617)) {
                fraction = CallChecker.beforeCalled(fraction, Fraction.class, 97, 3610, 3617);
                den = CallChecker.isCalled(fraction, Fraction.class, 97, 3610, 3617).getDenominator();
                CallChecker.varAssign(den, "den", 97, 3610, 3617);
            }
            int whole = CallChecker.varInit(((int) (num / den)), "whole", 98, 3645, 3666);
            num = num % den;
            CallChecker.varAssign(num, "num", 99, 3676, 3691);
            if (whole != 0) {
                final NumberFormat npe_invocation_var764 = getWholeFormat();
                if (CallChecker.beforeDeref(npe_invocation_var764, NumberFormat.class, 102, 3732, 3747)) {
                    CallChecker.isCalled(npe_invocation_var764, NumberFormat.class, 102, 3732, 3747).format(whole, toAppendTo, pos);
                }
                if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 103, 3793, 3802)) {
                    toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 103, 3793, 3802);
                    CallChecker.isCalled(toAppendTo, StringBuffer.class, 103, 3793, 3802).append(' ');
                }
                num = Math.abs(num);
                CallChecker.varAssign(num, "num", 104, 3829, 3848);
            }
            final NumberFormat npe_invocation_var765 = getNumeratorFormat();
            if (CallChecker.beforeDeref(npe_invocation_var765, NumberFormat.class, 106, 3868, 3887)) {
                CallChecker.isCalled(npe_invocation_var765, NumberFormat.class, 106, 3868, 3887).format(num, toAppendTo, pos);
            }
            if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 107, 3927, 3936)) {
                toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 107, 3927, 3936);
                CallChecker.isCalled(toAppendTo, StringBuffer.class, 107, 3927, 3936).append(" / ");
            }
            final NumberFormat npe_invocation_var766 = getDenominatorFormat();
            if (CallChecker.beforeDeref(npe_invocation_var766, NumberFormat.class, 108, 3961, 3982)) {
                CallChecker.isCalled(npe_invocation_var766, NumberFormat.class, 108, 3961, 3982).format(den, toAppendTo, pos);
            }
            return toAppendTo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2929.methodEnd();
        }
    }

    public NumberFormat getWholeFormat() {
        MethodContext _bcornu_methode_context2930 = new MethodContext(NumberFormat.class, 118, 4065, 4217);
        try {
            CallChecker.varInit(this, "this", 118, 4065, 4217);
            CallChecker.varInit(this.wholeFormat, "wholeFormat", 118, 4065, 4217);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.ProperFractionFormat.serialVersionUID", 118, 4065, 4217);
            return wholeFormat;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2930.methodEnd();
        }
    }

    @Override
    public Fraction parse(String source, ParsePosition pos) {
        MethodContext _bcornu_methode_context2931 = new MethodContext(Fraction.class, 135, 4224, 7412);
        try {
            CallChecker.varInit(this, "this", 135, 4224, 7412);
            CallChecker.varInit(pos, "pos", 135, 4224, 7412);
            CallChecker.varInit(source, "source", 135, 4224, 7412);
            CallChecker.varInit(this.wholeFormat, "wholeFormat", 135, 4224, 7412);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.ProperFractionFormat.serialVersionUID", 135, 4224, 7412);
            Fraction ret = CallChecker.varInit(super.parse(source, pos), "ret", 137, 4862, 4901);
            if (ret != null) {
                return ret;
            }
            int initialIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 142, 4992, 4994)) {
                pos = CallChecker.beforeCalled(pos, ParsePosition.class, 142, 4992, 4994);
                initialIndex = CallChecker.isCalled(pos, ParsePosition.class, 142, 4992, 4994).getIndex();
                CallChecker.varAssign(initialIndex, "initialIndex", 142, 4992, 4994);
            }
            AbstractFormat.parseAndIgnoreWhitespace(source, pos);
            final NumberFormat npe_invocation_var767 = getWholeFormat();
            Number whole = CallChecker.init(Number.class);
            if (CallChecker.beforeDeref(npe_invocation_var767, NumberFormat.class, 148, 5131, 5146)) {
                whole = CallChecker.isCalled(npe_invocation_var767, NumberFormat.class, 148, 5131, 5146).parse(source, pos);
                CallChecker.varAssign(whole, "whole", 148, 5131, 5146);
            }
            if (whole == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 153, 5358, 5360)) {
                    pos = CallChecker.beforeCalled(pos, ParsePosition.class, 153, 5358, 5360);
                    CallChecker.isCalled(pos, ParsePosition.class, 153, 5358, 5360).setIndex(initialIndex);
                }
                return null;
            }
            AbstractFormat.parseAndIgnoreWhitespace(source, pos);
            final NumberFormat npe_invocation_var768 = getNumeratorFormat();
            Number num = CallChecker.init(Number.class);
            if (CallChecker.beforeDeref(npe_invocation_var768, NumberFormat.class, 161, 5546, 5565)) {
                num = CallChecker.isCalled(npe_invocation_var768, NumberFormat.class, 161, 5546, 5565).parse(source, pos);
                CallChecker.varAssign(num, "num", 161, 5546, 5565);
            }
            if (num == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 166, 5775, 5777)) {
                    pos = CallChecker.beforeCalled(pos, ParsePosition.class, 166, 5775, 5777);
                    CallChecker.isCalled(pos, ParsePosition.class, 166, 5775, 5777).setIndex(initialIndex);
                }
                return null;
            }
            if ((num.intValue()) < 0) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 172, 5950, 5952)) {
                    pos = CallChecker.beforeCalled(pos, ParsePosition.class, 172, 5950, 5952);
                    CallChecker.isCalled(pos, ParsePosition.class, 172, 5950, 5952).setIndex(initialIndex);
                }
                return null;
            }
            int startIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 177, 6060, 6062)) {
                pos = CallChecker.beforeCalled(pos, ParsePosition.class, 177, 6060, 6062);
                startIndex = CallChecker.isCalled(pos, ParsePosition.class, 177, 6060, 6062).getIndex();
                CallChecker.varAssign(startIndex, "startIndex", 177, 6060, 6062);
            }
            char c = CallChecker.varInit(((char) (AbstractFormat.parseNextCharacter(source, pos))), "c", 178, 6084, 6124);
            switch (c) {
                case 0 :
                    return new Fraction(num.intValue(), 1);
                case '/' :
                    break;
                default :
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 191, 6536, 6538)) {
                        pos = CallChecker.beforeCalled(pos, ParsePosition.class, 191, 6536, 6538);
                        CallChecker.isCalled(pos, ParsePosition.class, 191, 6536, 6538).setIndex(initialIndex);
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 192, 6576, 6578)) {
                        pos = CallChecker.beforeCalled(pos, ParsePosition.class, 192, 6576, 6578);
                        CallChecker.isCalled(pos, ParsePosition.class, 192, 6576, 6578).setErrorIndex(startIndex);
                    }else
                        throw new AbnormalExecutionError();
                    
                    return null;
            }
            AbstractFormat.parseAndIgnoreWhitespace(source, pos);
            final NumberFormat npe_invocation_var769 = getDenominatorFormat();
            Number den = CallChecker.init(Number.class);
            if (CallChecker.beforeDeref(npe_invocation_var769, NumberFormat.class, 200, 6769, 6790)) {
                den = CallChecker.isCalled(npe_invocation_var769, NumberFormat.class, 200, 6769, 6790).parse(source, pos);
                CallChecker.varAssign(den, "den", 200, 6769, 6790);
            }
            if (den == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 205, 7000, 7002)) {
                    pos = CallChecker.beforeCalled(pos, ParsePosition.class, 205, 7000, 7002);
                    CallChecker.isCalled(pos, ParsePosition.class, 205, 7000, 7002).setIndex(initialIndex);
                }
                return null;
            }
            if ((den.intValue()) < 0) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 211, 7162, 7164)) {
                    pos = CallChecker.beforeCalled(pos, ParsePosition.class, 211, 7162, 7164);
                    CallChecker.isCalled(pos, ParsePosition.class, 211, 7162, 7164).setIndex(initialIndex);
                }
                return null;
            }
            int w = CallChecker.varInit(((int) (whole.intValue())), "w", 215, 7234, 7258);
            int n = CallChecker.varInit(((int) (num.intValue())), "n", 216, 7268, 7290);
            int d = CallChecker.varInit(((int) (den.intValue())), "d", 217, 7300, 7322);
            return new Fraction(((((Math.abs(w)) * d) + n) * (MathUtils.copySign(1, w))), d);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Fraction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2931.methodEnd();
        }
    }

    public void setWholeFormat(NumberFormat format) {
        MethodContext _bcornu_methode_context2932 = new MethodContext(void.class, 226, 7419, 7793);
        try {
            CallChecker.varInit(this, "this", 226, 7419, 7793);
            CallChecker.varInit(format, "format", 226, 7419, 7793);
            CallChecker.varInit(this.wholeFormat, "wholeFormat", 226, 7419, 7793);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.ProperFractionFormat.serialVersionUID", 226, 7419, 7793);
            if (format == null) {
                throw new NullArgumentException(LocalizedFormats.WHOLE_FORMAT);
            }
            this.wholeFormat = format;
            CallChecker.varAssign(this.wholeFormat, "this.wholeFormat", 230, 7762, 7787);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2932.methodEnd();
        }
    }
}

