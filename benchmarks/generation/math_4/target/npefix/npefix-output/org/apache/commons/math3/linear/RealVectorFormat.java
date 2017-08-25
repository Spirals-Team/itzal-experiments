package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.util.CompositeFormat;

public class RealVectorFormat {
    private static final String DEFAULT_PREFIX = "{";

    private static final String DEFAULT_SUFFIX = "}";

    private static final String DEFAULT_SEPARATOR = "; ";

    private final String prefix;

    private final String suffix;

    private final String separator;

    private final String trimmedPrefix;

    private final String trimmedSuffix;

    private final String trimmedSeparator;

    private final NumberFormat format;

    public RealVectorFormat() {
        this(RealVectorFormat.DEFAULT_PREFIX, RealVectorFormat.DEFAULT_SUFFIX, RealVectorFormat.DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context999 = new ConstructorContext(RealVectorFormat.class, 72, 2661, 3024);
        try {
        } finally {
            _bcornu_methode_context999.methodEnd();
        }
    }

    public RealVectorFormat(final NumberFormat format) {
        this(RealVectorFormat.DEFAULT_PREFIX, RealVectorFormat.DEFAULT_SUFFIX, RealVectorFormat.DEFAULT_SEPARATOR, format);
        ConstructorContext _bcornu_methode_context1000 = new ConstructorContext(RealVectorFormat.class, 81, 3031, 3302);
        try {
        } finally {
            _bcornu_methode_context1000.methodEnd();
        }
    }

    public RealVectorFormat(final String prefix, final String suffix, final String separator) {
        this(prefix, suffix, separator, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context1001 = new ConstructorContext(RealVectorFormat.class, 91, 3309, 3806);
        try {
        } finally {
            _bcornu_methode_context1001.methodEnd();
        }
    }

    public RealVectorFormat(final String prefix, final String suffix, final String separator, final NumberFormat format) {
        ConstructorContext _bcornu_methode_context1002 = new ConstructorContext(RealVectorFormat.class, 105, 3813, 4598);
        try {
            this.prefix = prefix;
            CallChecker.varAssign(this.prefix, "this.prefix", 107, 4330, 4355);
            this.suffix = suffix;
            CallChecker.varAssign(this.suffix, "this.suffix", 108, 4365, 4390);
            this.separator = separator;
            CallChecker.varAssign(this.separator, "this.separator", 109, 4400, 4428);
            trimmedPrefix = CallChecker.isCalled(prefix, String.class, 110, 4457, 4462).trim();
            CallChecker.varAssign(this.trimmedPrefix, "this.trimmedPrefix", 110, 4438, 4470);
            trimmedSuffix = CallChecker.isCalled(suffix, String.class, 111, 4499, 4504).trim();
            CallChecker.varAssign(this.trimmedSuffix, "this.trimmedSuffix", 111, 4480, 4512);
            trimmedSeparator = CallChecker.isCalled(separator, String.class, 112, 4541, 4549).trim();
            CallChecker.varAssign(this.trimmedSeparator, "this.trimmedSeparator", 112, 4522, 4557);
            this.format = format;
            CallChecker.varAssign(this.format, "this.format", 113, 4567, 4592);
        } finally {
            _bcornu_methode_context1002.methodEnd();
        }
    }

    public static Locale[] getAvailableLocales() {
        MethodContext _bcornu_methode_context4431 = new MethodContext(Locale[].class, 121, 4605, 4920);
        try {
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SEPARATOR", 121, 4605, 4920);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SUFFIX", 121, 4605, 4920);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_PREFIX", 121, 4605, 4920);
            return NumberFormat.getAvailableLocales();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Locale[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4431.methodEnd();
        }
    }

    public String getPrefix() {
        MethodContext _bcornu_methode_context4432 = new MethodContext(String.class, 129, 4927, 5058);
        try {
            CallChecker.varInit(this, "this", 129, 4927, 5058);
            CallChecker.varInit(this.format, "format", 129, 4927, 5058);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 129, 4927, 5058);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 129, 4927, 5058);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 129, 4927, 5058);
            CallChecker.varInit(this.separator, "separator", 129, 4927, 5058);
            CallChecker.varInit(this.suffix, "suffix", 129, 4927, 5058);
            CallChecker.varInit(this.prefix, "prefix", 129, 4927, 5058);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SEPARATOR", 129, 4927, 5058);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SUFFIX", 129, 4927, 5058);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_PREFIX", 129, 4927, 5058);
            return prefix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4432.methodEnd();
        }
    }

    public String getSuffix() {
        MethodContext _bcornu_methode_context4433 = new MethodContext(String.class, 137, 5065, 5196);
        try {
            CallChecker.varInit(this, "this", 137, 5065, 5196);
            CallChecker.varInit(this.format, "format", 137, 5065, 5196);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 137, 5065, 5196);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 137, 5065, 5196);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 137, 5065, 5196);
            CallChecker.varInit(this.separator, "separator", 137, 5065, 5196);
            CallChecker.varInit(this.suffix, "suffix", 137, 5065, 5196);
            CallChecker.varInit(this.prefix, "prefix", 137, 5065, 5196);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SEPARATOR", 137, 5065, 5196);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SUFFIX", 137, 5065, 5196);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_PREFIX", 137, 5065, 5196);
            return suffix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4433.methodEnd();
        }
    }

    public String getSeparator() {
        MethodContext _bcornu_methode_context4434 = new MethodContext(String.class, 145, 5203, 5365);
        try {
            CallChecker.varInit(this, "this", 145, 5203, 5365);
            CallChecker.varInit(this.format, "format", 145, 5203, 5365);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 145, 5203, 5365);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 145, 5203, 5365);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 145, 5203, 5365);
            CallChecker.varInit(this.separator, "separator", 145, 5203, 5365);
            CallChecker.varInit(this.suffix, "suffix", 145, 5203, 5365);
            CallChecker.varInit(this.prefix, "prefix", 145, 5203, 5365);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SEPARATOR", 145, 5203, 5365);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SUFFIX", 145, 5203, 5365);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_PREFIX", 145, 5203, 5365);
            return separator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4434.methodEnd();
        }
    }

    public NumberFormat getFormat() {
        MethodContext _bcornu_methode_context4435 = new MethodContext(NumberFormat.class, 153, 5372, 5517);
        try {
            CallChecker.varInit(this, "this", 153, 5372, 5517);
            CallChecker.varInit(this.format, "format", 153, 5372, 5517);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 153, 5372, 5517);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 153, 5372, 5517);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 153, 5372, 5517);
            CallChecker.varInit(this.separator, "separator", 153, 5372, 5517);
            CallChecker.varInit(this.suffix, "suffix", 153, 5372, 5517);
            CallChecker.varInit(this.prefix, "prefix", 153, 5372, 5517);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SEPARATOR", 153, 5372, 5517);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SUFFIX", 153, 5372, 5517);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_PREFIX", 153, 5372, 5517);
            return format;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4435.methodEnd();
        }
    }

    public static RealVectorFormat getInstance() {
        MethodContext _bcornu_methode_context4436 = new MethodContext(RealVectorFormat.class, 161, 5524, 5757);
        try {
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SEPARATOR", 161, 5524, 5757);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SUFFIX", 161, 5524, 5757);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_PREFIX", 161, 5524, 5757);
            return RealVectorFormat.getInstance(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVectorFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4436.methodEnd();
        }
    }

    public static RealVectorFormat getInstance(final Locale locale) {
        MethodContext _bcornu_methode_context4437 = new MethodContext(RealVectorFormat.class, 170, 5764, 6132);
        try {
            CallChecker.varInit(locale, "locale", 170, 5764, 6132);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SEPARATOR", 170, 5764, 6132);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SUFFIX", 170, 5764, 6132);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_PREFIX", 170, 5764, 6132);
            return new RealVectorFormat(CompositeFormat.getDefaultNumberFormat(locale));
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVectorFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4437.methodEnd();
        }
    }

    public String format(RealVector v) {
        MethodContext _bcornu_methode_context4438 = new MethodContext(String.class, 180, 6139, 6443);
        try {
            CallChecker.varInit(this, "this", 180, 6139, 6443);
            CallChecker.varInit(v, "v", 180, 6139, 6443);
            CallChecker.varInit(this.format, "format", 180, 6139, 6443);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 180, 6139, 6443);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 180, 6139, 6443);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 180, 6139, 6443);
            CallChecker.varInit(this.separator, "separator", 180, 6139, 6443);
            CallChecker.varInit(this.suffix, "suffix", 180, 6139, 6443);
            CallChecker.varInit(this.prefix, "prefix", 180, 6139, 6443);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SEPARATOR", 180, 6139, 6443);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SUFFIX", 180, 6139, 6443);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_PREFIX", 180, 6139, 6443);
            final StringBuffer npe_invocation_var932 = format(v, new StringBuffer(), new FieldPosition(0));
            if (CallChecker.beforeDeref(npe_invocation_var932, StringBuffer.class, 181, 6375, 6425)) {
                return CallChecker.isCalled(npe_invocation_var932, StringBuffer.class, 181, 6375, 6425).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4438.methodEnd();
        }
    }

    public StringBuffer format(RealVector vector, StringBuffer toAppendTo, FieldPosition pos) {
        MethodContext _bcornu_methode_context4439 = new MethodContext(StringBuffer.class, 192, 6450, 7411);
        try {
            CallChecker.varInit(this, "this", 192, 6450, 7411);
            CallChecker.varInit(pos, "pos", 192, 6450, 7411);
            CallChecker.varInit(toAppendTo, "toAppendTo", 192, 6450, 7411);
            CallChecker.varInit(vector, "vector", 192, 6450, 7411);
            CallChecker.varInit(this.format, "format", 192, 6450, 7411);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 192, 6450, 7411);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 192, 6450, 7411);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 192, 6450, 7411);
            CallChecker.varInit(this.separator, "separator", 192, 6450, 7411);
            CallChecker.varInit(this.suffix, "suffix", 192, 6450, 7411);
            CallChecker.varInit(this.prefix, "prefix", 192, 6450, 7411);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SEPARATOR", 192, 6450, 7411);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SUFFIX", 192, 6450, 7411);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_PREFIX", 192, 6450, 7411);
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 195, 6937, 6939)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 195, 6937, 6939);
                CallChecker.isCalled(pos, FieldPosition.class, 195, 6937, 6939).setBeginIndex(0);
            }
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 196, 6967, 6969)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 196, 6967, 6969);
                CallChecker.isCalled(pos, FieldPosition.class, 196, 6967, 6969).setEndIndex(0);
            }
            if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 199, 7021, 7030)) {
                toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 199, 7021, 7030);
                CallChecker.isCalled(toAppendTo, StringBuffer.class, 199, 7021, 7030).append(prefix);
            }
            vector = CallChecker.beforeCalled(vector, RealVector.class, 202, 7106, 7111);
            for (int i = 0; i < (CallChecker.isCalled(vector, RealVector.class, 202, 7106, 7111).getDimension()); ++i) {
                if (i > 0) {
                    if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 204, 7177, 7186)) {
                        toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 204, 7177, 7186);
                        CallChecker.isCalled(toAppendTo, StringBuffer.class, 204, 7177, 7186).append(separator);
                    }
                }
                if (CallChecker.beforeDeref(vector, RealVector.class, 206, 7262, 7267)) {
                    vector = CallChecker.beforeCalled(vector, RealVector.class, 206, 7262, 7267);
                    CompositeFormat.formatDouble(CallChecker.isCalled(vector, RealVector.class, 206, 7262, 7267).getEntry(i), format, toAppendTo, pos);
                }
            }
            if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 210, 7352, 7361)) {
                toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 210, 7352, 7361);
                CallChecker.isCalled(toAppendTo, StringBuffer.class, 210, 7352, 7361).append(suffix);
            }
            return toAppendTo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4439.methodEnd();
        }
    }

    public ArrayRealVector parse(String source) {
        MethodContext _bcornu_methode_context4440 = new MethodContext(ArrayRealVector.class, 223, 7418, 8143);
        try {
            CallChecker.varInit(this, "this", 223, 7418, 8143);
            CallChecker.varInit(source, "source", 223, 7418, 8143);
            CallChecker.varInit(this.format, "format", 223, 7418, 8143);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 223, 7418, 8143);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 223, 7418, 8143);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 223, 7418, 8143);
            CallChecker.varInit(this.separator, "separator", 223, 7418, 8143);
            CallChecker.varInit(this.suffix, "suffix", 223, 7418, 8143);
            CallChecker.varInit(this.prefix, "prefix", 223, 7418, 8143);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SEPARATOR", 223, 7418, 8143);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SUFFIX", 223, 7418, 8143);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_PREFIX", 223, 7418, 8143);
            final ParsePosition parsePosition = CallChecker.varInit(new ParsePosition(0), "parsePosition", 224, 7748, 7804);
            final ArrayRealVector result = CallChecker.varInit(parse(source, parsePosition), "result", 225, 7814, 7873);
            if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 226, 7887, 7899)) {
                if ((CallChecker.isCalled(parsePosition, ParsePosition.class, 226, 7887, 7899).getIndex()) == 0) {
                    if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 228, 8010, 8022)) {
                        throw new MathParseException(source, CallChecker.isCalled(parsePosition, ParsePosition.class, 228, 8010, 8022).getErrorIndex(), ArrayRealVector.class);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4440.methodEnd();
        }
    }

    public ArrayRealVector parse(String source, ParsePosition pos) {
        MethodContext _bcornu_methode_context4441 = new MethodContext(ArrayRealVector.class, 241, 8150, 10069);
        try {
            CallChecker.varInit(this, "this", 241, 8150, 10069);
            CallChecker.varInit(pos, "pos", 241, 8150, 10069);
            CallChecker.varInit(source, "source", 241, 8150, 10069);
            CallChecker.varInit(this.format, "format", 241, 8150, 10069);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 241, 8150, 10069);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 241, 8150, 10069);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 241, 8150, 10069);
            CallChecker.varInit(this.separator, "separator", 241, 8150, 10069);
            CallChecker.varInit(this.suffix, "suffix", 241, 8150, 10069);
            CallChecker.varInit(this.prefix, "prefix", 241, 8150, 10069);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SEPARATOR", 241, 8150, 10069);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_SUFFIX", 241, 8150, 10069);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealVectorFormat.DEFAULT_PREFIX", 241, 8150, 10069);
            int initialIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 242, 8467, 8469)) {
                pos = CallChecker.beforeCalled(pos, ParsePosition.class, 242, 8467, 8469);
                initialIndex = CallChecker.isCalled(pos, ParsePosition.class, 242, 8467, 8469).getIndex();
                CallChecker.varAssign(initialIndex, "initialIndex", 242, 8467, 8469);
            }
            CompositeFormat.parseAndIgnoreWhitespace(source, pos);
            if (!(CompositeFormat.parseFixedstring(source, trimmedPrefix, pos))) {
                return null;
            }
            List<Number> components = CallChecker.varInit(new ArrayList<Number>(), "components", 251, 8720, 8769);
            for (boolean loop = true; loop;) {
                if (CallChecker.beforeDeref(components, List.class, 254, 8831, 8840)) {
                    components = CallChecker.beforeCalled(components, List.class, 254, 8831, 8840);
                    if (!(CallChecker.isCalled(components, List.class, 254, 8831, 8840).isEmpty())) {
                        CompositeFormat.parseAndIgnoreWhitespace(source, pos);
                        if (!(CompositeFormat.parseFixedstring(source, trimmedSeparator, pos))) {
                            loop = false;
                            CallChecker.varAssign(loop, "loop", 257, 9034, 9046);
                        }
                    }
                }
                if (loop) {
                    CompositeFormat.parseAndIgnoreWhitespace(source, pos);
                    Number component = CallChecker.varInit(CompositeFormat.parseNumber(source, format, pos), "component", 263, 9192, 9259);
                    if (component != null) {
                        if (CallChecker.beforeDeref(components, List.class, 265, 9322, 9331)) {
                            components = CallChecker.beforeCalled(components, List.class, 265, 9322, 9331);
                            CallChecker.isCalled(components, List.class, 265, 9322, 9331).add(component);
                        }
                    }else {
                        if (CallChecker.beforeDeref(pos, ParsePosition.class, 269, 9519, 9521)) {
                            pos = CallChecker.beforeCalled(pos, ParsePosition.class, 269, 9519, 9521);
                            CallChecker.isCalled(pos, ParsePosition.class, 269, 9519, 9521).setIndex(initialIndex);
                        }
                        return null;
                    }
                }
            }
            CompositeFormat.parseAndIgnoreWhitespace(source, pos);
            if (!(CompositeFormat.parseFixedstring(source, trimmedSuffix, pos))) {
                return null;
            }
            double[] data = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(components, List.class, 283, 9883, 9892)) {
                components = CallChecker.beforeCalled(components, List.class, 283, 9883, 9892);
                data = new double[CallChecker.isCalled(components, List.class, 283, 9883, 9892).size()];
                CallChecker.varAssign(data, "data", 283, 9883, 9892);
            }
            data = CallChecker.beforeCalled(data, double[].class, 284, 9931, 9934);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 284, 9931, 9934).length); ++i) {
                if (CallChecker.beforeDeref(data, double[].class, 285, 9963, 9966)) {
                    if (CallChecker.beforeDeref(components, List.class, 285, 9973, 9982)) {
                        components = CallChecker.beforeCalled(components, List.class, 285, 9973, 9982);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(components, List.class, 285, 9973, 9982).get(i), Number.class, 285, 9973, 9989)) {
                            data = CallChecker.beforeCalled(data, double[].class, 285, 9963, 9966);
                            components = CallChecker.beforeCalled(components, List.class, 285, 9973, 9982);
                            CallChecker.isCalled(data, double[].class, 285, 9963, 9966)[i] = CallChecker.isCalled(CallChecker.isCalled(components, List.class, 285, 9973, 9982).get(i), Number.class, 285, 9973, 9989).doubleValue();
                            CallChecker.varAssign(CallChecker.isCalled(data, double[].class, 285, 9963, 9966)[i], "CallChecker.isCalled(data, double[].class, 285, 9963, 9966)[i]", 285, 9963, 10004);
                        }
                    }
                }
            }
            return new ArrayRealVector(data, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4441.methodEnd();
        }
    }
}

