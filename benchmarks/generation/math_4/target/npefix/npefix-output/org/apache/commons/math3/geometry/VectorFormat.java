package org.apache.commons.math3.geometry;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.util.CompositeFormat;

public abstract class VectorFormat<S extends Space> {
    public static final String DEFAULT_PREFIX = "{";

    public static final String DEFAULT_SUFFIX = "}";

    public static final String DEFAULT_SEPARATOR = "; ";

    private final String prefix;

    private final String suffix;

    private final String separator;

    private final String trimmedPrefix;

    private final String trimmedSuffix;

    private final String trimmedSeparator;

    private final NumberFormat format;

    protected VectorFormat() {
        this(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context498 = new ConstructorContext(VectorFormat.class, 83, 2918, 3280);
        try {
        } finally {
            _bcornu_methode_context498.methodEnd();
        }
    }

    protected VectorFormat(final NumberFormat format) {
        this(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, format);
        ConstructorContext _bcornu_methode_context499 = new ConstructorContext(VectorFormat.class, 92, 3287, 3557);
        try {
        } finally {
            _bcornu_methode_context499.methodEnd();
        }
    }

    protected VectorFormat(final String prefix, final String suffix, final String separator) {
        this(prefix, suffix, separator, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context500 = new ConstructorContext(VectorFormat.class, 102, 3564, 4045);
        try {
        } finally {
            _bcornu_methode_context500.methodEnd();
        }
    }

    protected VectorFormat(final String prefix, final String suffix, final String separator, final NumberFormat format) {
        ConstructorContext _bcornu_methode_context501 = new ConstructorContext(VectorFormat.class, 115, 4052, 4834);
        try {
            this.prefix = prefix;
            CallChecker.varAssign(this.prefix, "this.prefix", 117, 4566, 4591);
            this.suffix = suffix;
            CallChecker.varAssign(this.suffix, "this.suffix", 118, 4601, 4626);
            this.separator = separator;
            CallChecker.varAssign(this.separator, "this.separator", 119, 4636, 4664);
            trimmedPrefix = CallChecker.isCalled(prefix, String.class, 120, 4693, 4698).trim();
            CallChecker.varAssign(this.trimmedPrefix, "this.trimmedPrefix", 120, 4674, 4706);
            trimmedSuffix = CallChecker.isCalled(suffix, String.class, 121, 4735, 4740).trim();
            CallChecker.varAssign(this.trimmedSuffix, "this.trimmedSuffix", 121, 4716, 4748);
            trimmedSeparator = CallChecker.isCalled(separator, String.class, 122, 4777, 4785).trim();
            CallChecker.varAssign(this.trimmedSeparator, "this.trimmedSeparator", 122, 4758, 4793);
            this.format = format;
            CallChecker.varAssign(this.format, "this.format", 123, 4803, 4828);
        } finally {
            _bcornu_methode_context501.methodEnd();
        }
    }

    public static Locale[] getAvailableLocales() {
        MethodContext _bcornu_methode_context2266 = new MethodContext(Locale[].class, 131, 4841, 5157);
        try {
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 131, 4841, 5157);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 131, 4841, 5157);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 131, 4841, 5157);
            return NumberFormat.getAvailableLocales();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Locale[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2266.methodEnd();
        }
    }

    public String getPrefix() {
        MethodContext _bcornu_methode_context2267 = new MethodContext(String.class, 139, 5164, 5295);
        try {
            CallChecker.varInit(this, "this", 139, 5164, 5295);
            CallChecker.varInit(this.format, "format", 139, 5164, 5295);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 139, 5164, 5295);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 139, 5164, 5295);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 139, 5164, 5295);
            CallChecker.varInit(this.separator, "separator", 139, 5164, 5295);
            CallChecker.varInit(this.suffix, "suffix", 139, 5164, 5295);
            CallChecker.varInit(this.prefix, "prefix", 139, 5164, 5295);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 139, 5164, 5295);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 139, 5164, 5295);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 139, 5164, 5295);
            return prefix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2267.methodEnd();
        }
    }

    public String getSuffix() {
        MethodContext _bcornu_methode_context2268 = new MethodContext(String.class, 147, 5302, 5433);
        try {
            CallChecker.varInit(this, "this", 147, 5302, 5433);
            CallChecker.varInit(this.format, "format", 147, 5302, 5433);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 147, 5302, 5433);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 147, 5302, 5433);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 147, 5302, 5433);
            CallChecker.varInit(this.separator, "separator", 147, 5302, 5433);
            CallChecker.varInit(this.suffix, "suffix", 147, 5302, 5433);
            CallChecker.varInit(this.prefix, "prefix", 147, 5302, 5433);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 147, 5302, 5433);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 147, 5302, 5433);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 147, 5302, 5433);
            return suffix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2268.methodEnd();
        }
    }

    public String getSeparator() {
        MethodContext _bcornu_methode_context2269 = new MethodContext(String.class, 155, 5440, 5602);
        try {
            CallChecker.varInit(this, "this", 155, 5440, 5602);
            CallChecker.varInit(this.format, "format", 155, 5440, 5602);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 155, 5440, 5602);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 155, 5440, 5602);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 155, 5440, 5602);
            CallChecker.varInit(this.separator, "separator", 155, 5440, 5602);
            CallChecker.varInit(this.suffix, "suffix", 155, 5440, 5602);
            CallChecker.varInit(this.prefix, "prefix", 155, 5440, 5602);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 155, 5440, 5602);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 155, 5440, 5602);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 155, 5440, 5602);
            return separator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2269.methodEnd();
        }
    }

    public NumberFormat getFormat() {
        MethodContext _bcornu_methode_context2270 = new MethodContext(NumberFormat.class, 163, 5609, 5754);
        try {
            CallChecker.varInit(this, "this", 163, 5609, 5754);
            CallChecker.varInit(this.format, "format", 163, 5609, 5754);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 163, 5609, 5754);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 163, 5609, 5754);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 163, 5609, 5754);
            CallChecker.varInit(this.separator, "separator", 163, 5609, 5754);
            CallChecker.varInit(this.suffix, "suffix", 163, 5609, 5754);
            CallChecker.varInit(this.prefix, "prefix", 163, 5609, 5754);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 163, 5609, 5754);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 163, 5609, 5754);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 163, 5609, 5754);
            return format;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2270.methodEnd();
        }
    }

    public String format(Vector<S> vector) {
        MethodContext _bcornu_methode_context2271 = new MethodContext(String.class, 172, 5761, 6044);
        try {
            CallChecker.varInit(this, "this", 172, 5761, 6044);
            CallChecker.varInit(vector, "vector", 172, 5761, 6044);
            CallChecker.varInit(this.format, "format", 172, 5761, 6044);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 172, 5761, 6044);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 172, 5761, 6044);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 172, 5761, 6044);
            CallChecker.varInit(this.separator, "separator", 172, 5761, 6044);
            CallChecker.varInit(this.suffix, "suffix", 172, 5761, 6044);
            CallChecker.varInit(this.prefix, "prefix", 172, 5761, 6044);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 172, 5761, 6044);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 172, 5761, 6044);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 172, 5761, 6044);
            final StringBuffer npe_invocation_var632 = format(vector, new StringBuffer(), new FieldPosition(0));
            if (CallChecker.beforeDeref(npe_invocation_var632, StringBuffer.class, 173, 5971, 6026)) {
                return CallChecker.isCalled(npe_invocation_var632, StringBuffer.class, 173, 5971, 6026).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2271.methodEnd();
        }
    }

    public abstract StringBuffer format(Vector<S> vector, StringBuffer toAppendTo, FieldPosition pos);

    protected StringBuffer format(StringBuffer toAppendTo, FieldPosition pos, double... coordinates) {
        MethodContext _bcornu_methode_context2273 = new MethodContext(StringBuffer.class, 195, 6546, 7540);
        try {
            CallChecker.varInit(this, "this", 195, 6546, 7540);
            CallChecker.varInit(coordinates, "coordinates", 195, 6546, 7540);
            CallChecker.varInit(pos, "pos", 195, 6546, 7540);
            CallChecker.varInit(toAppendTo, "toAppendTo", 195, 6546, 7540);
            CallChecker.varInit(this.format, "format", 195, 6546, 7540);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 195, 6546, 7540);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 195, 6546, 7540);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 195, 6546, 7540);
            CallChecker.varInit(this.separator, "separator", 195, 6546, 7540);
            CallChecker.varInit(this.suffix, "suffix", 195, 6546, 7540);
            CallChecker.varInit(this.prefix, "prefix", 195, 6546, 7540);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 195, 6546, 7540);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 195, 6546, 7540);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 195, 6546, 7540);
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 198, 7072, 7074)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 198, 7072, 7074);
                CallChecker.isCalled(pos, FieldPosition.class, 198, 7072, 7074).setBeginIndex(0);
            }
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 199, 7102, 7104)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 199, 7102, 7104);
                CallChecker.isCalled(pos, FieldPosition.class, 199, 7102, 7104).setEndIndex(0);
            }
            if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 202, 7156, 7165)) {
                toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 202, 7156, 7165);
                CallChecker.isCalled(toAppendTo, StringBuffer.class, 202, 7156, 7165).append(prefix);
            }
            coordinates = CallChecker.beforeCalled(coordinates, double[].class, 205, 7241, 7251);
            for (int i = 0; i < (CallChecker.isCalled(coordinates, double[].class, 205, 7241, 7251).length); ++i) {
                if (i > 0) {
                    if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 207, 7309, 7318)) {
                        toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 207, 7309, 7318);
                        CallChecker.isCalled(toAppendTo, StringBuffer.class, 207, 7309, 7318).append(separator);
                    }
                }
                if (CallChecker.beforeDeref(coordinates, double[].class, 209, 7394, 7404)) {
                    coordinates = CallChecker.beforeCalled(coordinates, double[].class, 209, 7394, 7404);
                    CompositeFormat.formatDouble(CallChecker.isCalled(coordinates, double[].class, 209, 7394, 7404)[i], format, toAppendTo, pos);
                }
            }
            if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 213, 7480, 7489)) {
                toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 213, 7480, 7489);
                CallChecker.isCalled(toAppendTo, StringBuffer.class, 213, 7480, 7489).append(suffix);
            }
            return toAppendTo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2273.methodEnd();
        }
    }

    public abstract Vector<S> parse(String source) throws MathParseException;

    public abstract Vector<S> parse(String source, ParsePosition pos);

    protected double[] parseCoordinates(int dimension, String source, ParsePosition pos) {
        MethodContext _bcornu_methode_context2276 = new MethodContext(double[].class, 243, 8178, 9887);
        try {
            CallChecker.varInit(this, "this", 243, 8178, 9887);
            CallChecker.varInit(pos, "pos", 243, 8178, 9887);
            CallChecker.varInit(source, "source", 243, 8178, 9887);
            CallChecker.varInit(dimension, "dimension", 243, 8178, 9887);
            CallChecker.varInit(this.format, "format", 243, 8178, 9887);
            CallChecker.varInit(this.trimmedSeparator, "trimmedSeparator", 243, 8178, 9887);
            CallChecker.varInit(this.trimmedSuffix, "trimmedSuffix", 243, 8178, 9887);
            CallChecker.varInit(this.trimmedPrefix, "trimmedPrefix", 243, 8178, 9887);
            CallChecker.varInit(this.separator, "separator", 243, 8178, 9887);
            CallChecker.varInit(this.suffix, "suffix", 243, 8178, 9887);
            CallChecker.varInit(this.prefix, "prefix", 243, 8178, 9887);
            CallChecker.varInit(DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 243, 8178, 9887);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 243, 8178, 9887);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 243, 8178, 9887);
            int initialIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 245, 8540, 8542)) {
                pos = CallChecker.beforeCalled(pos, ParsePosition.class, 245, 8540, 8542);
                initialIndex = CallChecker.isCalled(pos, ParsePosition.class, 245, 8540, 8542).getIndex();
                CallChecker.varAssign(initialIndex, "initialIndex", 245, 8540, 8542);
            }
            double[] coordinates = CallChecker.varInit(new double[dimension], "coordinates", 246, 8564, 8608);
            CompositeFormat.parseAndIgnoreWhitespace(source, pos);
            if (!(CompositeFormat.parseFixedstring(source, trimmedPrefix, pos))) {
                return null;
            }
            for (int i = 0; i < dimension; ++i) {
                CompositeFormat.parseAndIgnoreWhitespace(source, pos);
                if ((i > 0) && (!(CompositeFormat.parseFixedstring(source, trimmedSeparator, pos)))) {
                    return null;
                }
                CompositeFormat.parseAndIgnoreWhitespace(source, pos);
                Number c = CallChecker.varInit(CompositeFormat.parseNumber(source, format, pos), "c", 268, 9268, 9327);
                if (c == null) {
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 272, 9492, 9494)) {
                        pos = CallChecker.beforeCalled(pos, ParsePosition.class, 272, 9492, 9494);
                        CallChecker.isCalled(pos, ParsePosition.class, 272, 9492, 9494).setIndex(initialIndex);
                    }
                    return null;
                }
                if (CallChecker.beforeDeref(coordinates, double[].class, 277, 9608, 9618)) {
                    coordinates = CallChecker.beforeCalled(coordinates, double[].class, 277, 9608, 9618);
                    CallChecker.isCalled(coordinates, double[].class, 277, 9608, 9618)[i] = c.doubleValue();
                    CallChecker.varAssign(CallChecker.isCalled(coordinates, double[].class, 277, 9608, 9618)[i], "CallChecker.isCalled(coordinates, double[].class, 277, 9608, 9618)[i]", 277, 9608, 9640);
                }
            }
            CompositeFormat.parseAndIgnoreWhitespace(source, pos);
            if (!(CompositeFormat.parseFixedstring(source, trimmedSuffix, pos))) {
                return null;
            }
            return coordinates;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2276.methodEnd();
        }
    }
}

