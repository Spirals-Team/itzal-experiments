package org.apache.commons.math3.fraction;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public abstract class AbstractFormat extends NumberFormat implements Serializable {
    private static final long serialVersionUID = -6981118387974191891L;

    private NumberFormat denominatorFormat;

    private NumberFormat numeratorFormat;

    protected AbstractFormat() {
        this(AbstractFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context1098 = new ConstructorContext(AbstractFormat.class, 49, 1640, 1848);
        try {
        } finally {
            _bcornu_methode_context1098.methodEnd();
        }
    }

    protected AbstractFormat(final NumberFormat format) {
        this(format, ((NumberFormat) (CallChecker.isCalled(format, NumberFormat.class, 59, 2161, 2166).clone())));
        ConstructorContext _bcornu_methode_context1099 = new ConstructorContext(AbstractFormat.class, 58, 1855, 2182);
        try {
        } finally {
            _bcornu_methode_context1099.methodEnd();
        }
    }

    protected AbstractFormat(final NumberFormat numeratorFormat, final NumberFormat denominatorFormat) {
        ConstructorContext _bcornu_methode_context1100 = new ConstructorContext(AbstractFormat.class, 68, 2189, 2726);
        try {
            this.numeratorFormat = numeratorFormat;
            CallChecker.varAssign(this.numeratorFormat, "this.numeratorFormat", 70, 2628, 2668);
            this.denominatorFormat = denominatorFormat;
            CallChecker.varAssign(this.denominatorFormat, "this.denominatorFormat", 71, 2678, 2720);
        } finally {
            _bcornu_methode_context1100.methodEnd();
        }
    }

    protected static NumberFormat getDefaultNumberFormat() {
        MethodContext _bcornu_methode_context4901 = new MethodContext(NumberFormat.class, 80, 2733, 3149);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.AbstractFormat.serialVersionUID", 80, 2733, 3149);
            return AbstractFormat.getDefaultNumberFormat(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4901.methodEnd();
        }
    }

    protected static NumberFormat getDefaultNumberFormat(final Locale locale) {
        MethodContext _bcornu_methode_context4902 = new MethodContext(NumberFormat.class, 91, 3156, 3790);
        try {
            CallChecker.varInit(locale, "locale", 91, 3156, 3790);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.AbstractFormat.serialVersionUID", 91, 3156, 3790);
            final NumberFormat nf = CallChecker.varInit(NumberFormat.getNumberInstance(locale), "nf", 92, 3625, 3687);
            if (CallChecker.beforeDeref(nf, NumberFormat.class, 93, 3697, 3698)) {
                CallChecker.isCalled(nf, NumberFormat.class, 93, 3697, 3698).setMaximumFractionDigits(0);
            }
            if (CallChecker.beforeDeref(nf, NumberFormat.class, 94, 3737, 3738)) {
                CallChecker.isCalled(nf, NumberFormat.class, 94, 3737, 3738).setParseIntegerOnly(true);
            }
            return nf;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4902.methodEnd();
        }
    }

    public NumberFormat getDenominatorFormat() {
        MethodContext _bcornu_methode_context4903 = new MethodContext(NumberFormat.class, 102, 3797, 3973);
        try {
            CallChecker.varInit(this, "this", 102, 3797, 3973);
            CallChecker.varInit(this.numeratorFormat, "numeratorFormat", 102, 3797, 3973);
            CallChecker.varInit(this.denominatorFormat, "denominatorFormat", 102, 3797, 3973);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.AbstractFormat.serialVersionUID", 102, 3797, 3973);
            return denominatorFormat;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4903.methodEnd();
        }
    }

    public NumberFormat getNumeratorFormat() {
        MethodContext _bcornu_methode_context4904 = new MethodContext(NumberFormat.class, 110, 3980, 4148);
        try {
            CallChecker.varInit(this, "this", 110, 3980, 4148);
            CallChecker.varInit(this.numeratorFormat, "numeratorFormat", 110, 3980, 4148);
            CallChecker.varInit(this.denominatorFormat, "denominatorFormat", 110, 3980, 4148);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.AbstractFormat.serialVersionUID", 110, 3980, 4148);
            return numeratorFormat;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4904.methodEnd();
        }
    }

    public void setDenominatorFormat(final NumberFormat format) {
        MethodContext _bcornu_methode_context4905 = new MethodContext(void.class, 119, 4155, 4565);
        try {
            CallChecker.varInit(this, "this", 119, 4155, 4565);
            CallChecker.varInit(format, "format", 119, 4155, 4565);
            CallChecker.varInit(this.numeratorFormat, "numeratorFormat", 119, 4155, 4565);
            CallChecker.varInit(this.denominatorFormat, "denominatorFormat", 119, 4155, 4565);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.AbstractFormat.serialVersionUID", 119, 4155, 4565);
            if (format == null) {
                throw new NullArgumentException(LocalizedFormats.DENOMINATOR_FORMAT);
            }
            this.denominatorFormat = format;
            CallChecker.varAssign(this.denominatorFormat, "this.denominatorFormat", 123, 4528, 4559);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4905.methodEnd();
        }
    }

    public void setNumeratorFormat(final NumberFormat format) {
        MethodContext _bcornu_methode_context4906 = new MethodContext(void.class, 131, 4572, 4972);
        try {
            CallChecker.varInit(this, "this", 131, 4572, 4972);
            CallChecker.varInit(format, "format", 131, 4572, 4972);
            CallChecker.varInit(this.numeratorFormat, "numeratorFormat", 131, 4572, 4972);
            CallChecker.varInit(this.denominatorFormat, "denominatorFormat", 131, 4572, 4972);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.AbstractFormat.serialVersionUID", 131, 4572, 4972);
            if (format == null) {
                throw new NullArgumentException(LocalizedFormats.NUMERATOR_FORMAT);
            }
            this.numeratorFormat = format;
            CallChecker.varAssign(this.numeratorFormat, "this.numeratorFormat", 135, 4937, 4966);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4906.methodEnd();
        }
    }

    protected static void parseAndIgnoreWhitespace(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context4907 = new MethodContext(void.class, 144, 4979, 5493);
        try {
            CallChecker.varInit(pos, "pos", 144, 4979, 5493);
            CallChecker.varInit(source, "source", 144, 4979, 5493);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.AbstractFormat.serialVersionUID", 144, 4979, 5493);
            AbstractFormat.parseNextCharacter(source, pos);
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 147, 5468, 5470)) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 147, 5455, 5457)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 147, 5455, 5457).setIndex(((CallChecker.isCalled(pos, ParsePosition.class, 147, 5468, 5470).getIndex()) - 1));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4907.methodEnd();
        }
    }

    protected static char parseNextCharacter(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context4908 = new MethodContext(char.class, 156, 5500, 6286);
        try {
            CallChecker.varInit(pos, "pos", 156, 5500, 6286);
            CallChecker.varInit(source, "source", 156, 5500, 6286);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.AbstractFormat.serialVersionUID", 156, 5500, 6286);
            int index = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 158, 5890, 5892)) {
                index = CallChecker.isCalled(pos, ParsePosition.class, 158, 5890, 5892).getIndex();
                CallChecker.varAssign(index, "index", 158, 5890, 5892);
            }
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(source, String.class, 159, 5929, 5934).length())), "n", 159, 5915, 5944);
            char ret = CallChecker.varInit(((char) (0)), "ret", 160, 5955, 5967);
            if (index < n) {
                char c = CallChecker.init(char.class);
                do {
                    if (CallChecker.beforeDeref(source, String.class, 165, 6056, 6061)) {
                        c = CallChecker.isCalled(source, String.class, 165, 6056, 6061).charAt((index++));
                        CallChecker.varAssign(c, "c", 165, 6052, 6078);
                    }
                } while ((Character.isWhitespace(c)) && (index < n) );
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 167, 6156, 6158)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 167, 6156, 6158).setIndex(index);
                }
                if (index < n) {
                    ret = c;
                    CallChecker.varAssign(ret, "ret", 170, 6225, 6232);
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Character) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4908.methodEnd();
        }
    }

    @Override
    public StringBuffer format(final double value, final StringBuffer buffer, final FieldPosition position) {
        MethodContext _bcornu_methode_context4909 = new MethodContext(StringBuffer.class, 188, 6293, 6951);
        try {
            CallChecker.varInit(this, "this", 188, 6293, 6951);
            CallChecker.varInit(position, "position", 188, 6293, 6951);
            CallChecker.varInit(buffer, "buffer", 188, 6293, 6951);
            CallChecker.varInit(value, "value", 188, 6293, 6951);
            CallChecker.varInit(this.numeratorFormat, "numeratorFormat", 188, 6293, 6951);
            CallChecker.varInit(this.denominatorFormat, "denominatorFormat", 188, 6293, 6951);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.AbstractFormat.serialVersionUID", 188, 6293, 6951);
            return format(Double.valueOf(value), buffer, position);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4909.methodEnd();
        }
    }

    @Override
    public StringBuffer format(final long value, final StringBuffer buffer, final FieldPosition position) {
        MethodContext _bcornu_methode_context4910 = new MethodContext(StringBuffer.class, 205, 6959, 7609);
        try {
            CallChecker.varInit(this, "this", 205, 6959, 7609);
            CallChecker.varInit(position, "position", 205, 6959, 7609);
            CallChecker.varInit(buffer, "buffer", 205, 6959, 7609);
            CallChecker.varInit(value, "value", 205, 6959, 7609);
            CallChecker.varInit(this.numeratorFormat, "numeratorFormat", 205, 6959, 7609);
            CallChecker.varInit(this.denominatorFormat, "denominatorFormat", 205, 6959, 7609);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.fraction.AbstractFormat.serialVersionUID", 205, 6959, 7609);
            return format(Long.valueOf(value), buffer, position);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4910.methodEnd();
        }
    }
}

