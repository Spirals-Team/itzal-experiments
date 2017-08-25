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

public class RealMatrixFormat {
    private static final String DEFAULT_PREFIX = "{";

    private static final String DEFAULT_SUFFIX = "}";

    private static final String DEFAULT_ROW_PREFIX = "{";

    private static final String DEFAULT_ROW_SUFFIX = "}";

    private static final String DEFAULT_ROW_SEPARATOR = ",";

    private static final String DEFAULT_COLUMN_SEPARATOR = ",";

    private final String prefix;

    private final String suffix;

    private final String rowPrefix;

    private final String rowSuffix;

    private final String rowSeparator;

    private final String columnSeparator;

    private final NumberFormat format;

    public RealMatrixFormat() {
        this(RealMatrixFormat.DEFAULT_PREFIX, RealMatrixFormat.DEFAULT_SUFFIX, RealMatrixFormat.DEFAULT_ROW_PREFIX, RealMatrixFormat.DEFAULT_ROW_SUFFIX, RealMatrixFormat.DEFAULT_ROW_SEPARATOR, RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context1047 = new ConstructorContext(RealMatrixFormat.class, 89, 3556, 4007);
        try {
        } finally {
            _bcornu_methode_context1047.methodEnd();
        }
    }

    public RealMatrixFormat(final NumberFormat format) {
        this(RealMatrixFormat.DEFAULT_PREFIX, RealMatrixFormat.DEFAULT_SUFFIX, RealMatrixFormat.DEFAULT_ROW_PREFIX, RealMatrixFormat.DEFAULT_ROW_SUFFIX, RealMatrixFormat.DEFAULT_ROW_SEPARATOR, RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR, format);
        ConstructorContext _bcornu_methode_context1048 = new ConstructorContext(RealMatrixFormat.class, 98, 4014, 4371);
        try {
        } finally {
            _bcornu_methode_context1048.methodEnd();
        }
    }

    public RealMatrixFormat(final String prefix, final String suffix, final String rowPrefix, final String rowSuffix, final String rowSeparator, final String columnSeparator) {
        this(prefix, suffix, rowPrefix, rowSuffix, rowSeparator, columnSeparator, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context1049 = new ConstructorContext(RealMatrixFormat.class, 112, 4378, 5255);
        try {
        } finally {
            _bcornu_methode_context1049.methodEnd();
        }
    }

    public RealMatrixFormat(final String prefix, final String suffix, final String rowPrefix, final String rowSuffix, final String rowSeparator, final String columnSeparator, final NumberFormat format) {
        ConstructorContext _bcornu_methode_context1050 = new ConstructorContext(RealMatrixFormat.class, 130, 5262, 6546);
        try {
            this.prefix = prefix;
            CallChecker.varAssign(this.prefix, "this.prefix", 134, 6142, 6173);
            this.suffix = suffix;
            CallChecker.varAssign(this.suffix, "this.suffix", 135, 6183, 6214);
            this.rowPrefix = rowPrefix;
            CallChecker.varAssign(this.rowPrefix, "this.rowPrefix", 136, 6224, 6258);
            this.rowSuffix = rowSuffix;
            CallChecker.varAssign(this.rowSuffix, "this.rowSuffix", 137, 6268, 6302);
            this.rowSeparator = rowSeparator;
            CallChecker.varAssign(this.rowSeparator, "this.rowSeparator", 138, 6312, 6349);
            this.columnSeparator = columnSeparator;
            CallChecker.varAssign(this.columnSeparator, "this.columnSeparator", 139, 6359, 6399);
            this.format = format;
            CallChecker.varAssign(this.format, "this.format", 140, 6409, 6440);
            if (CallChecker.beforeDeref(this.format, NumberFormat.class, 142, 6506, 6516)) {
                CallChecker.isCalled(this.format, NumberFormat.class, 142, 6506, 6516).setGroupingUsed(false);
            }
        } finally {
            _bcornu_methode_context1050.methodEnd();
        }
    }

    public static Locale[] getAvailableLocales() {
        MethodContext _bcornu_methode_context4617 = new MethodContext(Locale[].class, 150, 6553, 6868);
        try {
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 150, 6553, 6868);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 150, 6553, 6868);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 150, 6553, 6868);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 150, 6553, 6868);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 150, 6553, 6868);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 150, 6553, 6868);
            return NumberFormat.getAvailableLocales();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Locale[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4617.methodEnd();
        }
    }

    public String getPrefix() {
        MethodContext _bcornu_methode_context4618 = new MethodContext(String.class, 158, 6875, 7006);
        try {
            CallChecker.varInit(this, "this", 158, 6875, 7006);
            CallChecker.varInit(this.format, "format", 158, 6875, 7006);
            CallChecker.varInit(this.columnSeparator, "columnSeparator", 158, 6875, 7006);
            CallChecker.varInit(this.rowSeparator, "rowSeparator", 158, 6875, 7006);
            CallChecker.varInit(this.rowSuffix, "rowSuffix", 158, 6875, 7006);
            CallChecker.varInit(this.rowPrefix, "rowPrefix", 158, 6875, 7006);
            CallChecker.varInit(this.suffix, "suffix", 158, 6875, 7006);
            CallChecker.varInit(this.prefix, "prefix", 158, 6875, 7006);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 158, 6875, 7006);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 158, 6875, 7006);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 158, 6875, 7006);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 158, 6875, 7006);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 158, 6875, 7006);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 158, 6875, 7006);
            return prefix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4618.methodEnd();
        }
    }

    public String getSuffix() {
        MethodContext _bcornu_methode_context4619 = new MethodContext(String.class, 166, 7013, 7144);
        try {
            CallChecker.varInit(this, "this", 166, 7013, 7144);
            CallChecker.varInit(this.format, "format", 166, 7013, 7144);
            CallChecker.varInit(this.columnSeparator, "columnSeparator", 166, 7013, 7144);
            CallChecker.varInit(this.rowSeparator, "rowSeparator", 166, 7013, 7144);
            CallChecker.varInit(this.rowSuffix, "rowSuffix", 166, 7013, 7144);
            CallChecker.varInit(this.rowPrefix, "rowPrefix", 166, 7013, 7144);
            CallChecker.varInit(this.suffix, "suffix", 166, 7013, 7144);
            CallChecker.varInit(this.prefix, "prefix", 166, 7013, 7144);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 166, 7013, 7144);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 166, 7013, 7144);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 166, 7013, 7144);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 166, 7013, 7144);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 166, 7013, 7144);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 166, 7013, 7144);
            return suffix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4619.methodEnd();
        }
    }

    public String getRowPrefix() {
        MethodContext _bcornu_methode_context4620 = new MethodContext(String.class, 174, 7151, 7288);
        try {
            CallChecker.varInit(this, "this", 174, 7151, 7288);
            CallChecker.varInit(this.format, "format", 174, 7151, 7288);
            CallChecker.varInit(this.columnSeparator, "columnSeparator", 174, 7151, 7288);
            CallChecker.varInit(this.rowSeparator, "rowSeparator", 174, 7151, 7288);
            CallChecker.varInit(this.rowSuffix, "rowSuffix", 174, 7151, 7288);
            CallChecker.varInit(this.rowPrefix, "rowPrefix", 174, 7151, 7288);
            CallChecker.varInit(this.suffix, "suffix", 174, 7151, 7288);
            CallChecker.varInit(this.prefix, "prefix", 174, 7151, 7288);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 174, 7151, 7288);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 174, 7151, 7288);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 174, 7151, 7288);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 174, 7151, 7288);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 174, 7151, 7288);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 174, 7151, 7288);
            return rowPrefix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4620.methodEnd();
        }
    }

    public String getRowSuffix() {
        MethodContext _bcornu_methode_context4621 = new MethodContext(String.class, 182, 7295, 7432);
        try {
            CallChecker.varInit(this, "this", 182, 7295, 7432);
            CallChecker.varInit(this.format, "format", 182, 7295, 7432);
            CallChecker.varInit(this.columnSeparator, "columnSeparator", 182, 7295, 7432);
            CallChecker.varInit(this.rowSeparator, "rowSeparator", 182, 7295, 7432);
            CallChecker.varInit(this.rowSuffix, "rowSuffix", 182, 7295, 7432);
            CallChecker.varInit(this.rowPrefix, "rowPrefix", 182, 7295, 7432);
            CallChecker.varInit(this.suffix, "suffix", 182, 7295, 7432);
            CallChecker.varInit(this.prefix, "prefix", 182, 7295, 7432);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 182, 7295, 7432);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 182, 7295, 7432);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 182, 7295, 7432);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 182, 7295, 7432);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 182, 7295, 7432);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 182, 7295, 7432);
            return rowSuffix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4621.methodEnd();
        }
    }

    public String getRowSeparator() {
        MethodContext _bcornu_methode_context4622 = new MethodContext(String.class, 190, 7439, 7624);
        try {
            CallChecker.varInit(this, "this", 190, 7439, 7624);
            CallChecker.varInit(this.format, "format", 190, 7439, 7624);
            CallChecker.varInit(this.columnSeparator, "columnSeparator", 190, 7439, 7624);
            CallChecker.varInit(this.rowSeparator, "rowSeparator", 190, 7439, 7624);
            CallChecker.varInit(this.rowSuffix, "rowSuffix", 190, 7439, 7624);
            CallChecker.varInit(this.rowPrefix, "rowPrefix", 190, 7439, 7624);
            CallChecker.varInit(this.suffix, "suffix", 190, 7439, 7624);
            CallChecker.varInit(this.prefix, "prefix", 190, 7439, 7624);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 190, 7439, 7624);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 190, 7439, 7624);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 190, 7439, 7624);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 190, 7439, 7624);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 190, 7439, 7624);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 190, 7439, 7624);
            return rowSeparator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4622.methodEnd();
        }
    }

    public String getColumnSeparator() {
        MethodContext _bcornu_methode_context4623 = new MethodContext(String.class, 198, 7631, 7824);
        try {
            CallChecker.varInit(this, "this", 198, 7631, 7824);
            CallChecker.varInit(this.format, "format", 198, 7631, 7824);
            CallChecker.varInit(this.columnSeparator, "columnSeparator", 198, 7631, 7824);
            CallChecker.varInit(this.rowSeparator, "rowSeparator", 198, 7631, 7824);
            CallChecker.varInit(this.rowSuffix, "rowSuffix", 198, 7631, 7824);
            CallChecker.varInit(this.rowPrefix, "rowPrefix", 198, 7631, 7824);
            CallChecker.varInit(this.suffix, "suffix", 198, 7631, 7824);
            CallChecker.varInit(this.prefix, "prefix", 198, 7631, 7824);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 198, 7631, 7824);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 198, 7631, 7824);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 198, 7631, 7824);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 198, 7631, 7824);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 198, 7631, 7824);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 198, 7631, 7824);
            return columnSeparator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4623.methodEnd();
        }
    }

    public NumberFormat getFormat() {
        MethodContext _bcornu_methode_context4624 = new MethodContext(NumberFormat.class, 206, 7831, 7976);
        try {
            CallChecker.varInit(this, "this", 206, 7831, 7976);
            CallChecker.varInit(this.format, "format", 206, 7831, 7976);
            CallChecker.varInit(this.columnSeparator, "columnSeparator", 206, 7831, 7976);
            CallChecker.varInit(this.rowSeparator, "rowSeparator", 206, 7831, 7976);
            CallChecker.varInit(this.rowSuffix, "rowSuffix", 206, 7831, 7976);
            CallChecker.varInit(this.rowPrefix, "rowPrefix", 206, 7831, 7976);
            CallChecker.varInit(this.suffix, "suffix", 206, 7831, 7976);
            CallChecker.varInit(this.prefix, "prefix", 206, 7831, 7976);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 206, 7831, 7976);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 206, 7831, 7976);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 206, 7831, 7976);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 206, 7831, 7976);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 206, 7831, 7976);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 206, 7831, 7976);
            return format;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4624.methodEnd();
        }
    }

    public static RealMatrixFormat getInstance() {
        MethodContext _bcornu_methode_context4625 = new MethodContext(RealMatrixFormat.class, 214, 7983, 8216);
        try {
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 214, 7983, 8216);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 214, 7983, 8216);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 214, 7983, 8216);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 214, 7983, 8216);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 214, 7983, 8216);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 214, 7983, 8216);
            return RealMatrixFormat.getInstance(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrixFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4625.methodEnd();
        }
    }

    public static RealMatrixFormat getInstance(final Locale locale) {
        MethodContext _bcornu_methode_context4626 = new MethodContext(RealMatrixFormat.class, 223, 8223, 8591);
        try {
            CallChecker.varInit(locale, "locale", 223, 8223, 8591);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 223, 8223, 8591);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 223, 8223, 8591);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 223, 8223, 8591);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 223, 8223, 8591);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 223, 8223, 8591);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 223, 8223, 8591);
            return new RealMatrixFormat(CompositeFormat.getDefaultNumberFormat(locale));
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrixFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4626.methodEnd();
        }
    }

    public String format(RealMatrix m) {
        MethodContext _bcornu_methode_context4627 = new MethodContext(String.class, 233, 8598, 8902);
        try {
            CallChecker.varInit(this, "this", 233, 8598, 8902);
            CallChecker.varInit(m, "m", 233, 8598, 8902);
            CallChecker.varInit(this.format, "format", 233, 8598, 8902);
            CallChecker.varInit(this.columnSeparator, "columnSeparator", 233, 8598, 8902);
            CallChecker.varInit(this.rowSeparator, "rowSeparator", 233, 8598, 8902);
            CallChecker.varInit(this.rowSuffix, "rowSuffix", 233, 8598, 8902);
            CallChecker.varInit(this.rowPrefix, "rowPrefix", 233, 8598, 8902);
            CallChecker.varInit(this.suffix, "suffix", 233, 8598, 8902);
            CallChecker.varInit(this.prefix, "prefix", 233, 8598, 8902);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 233, 8598, 8902);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 233, 8598, 8902);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 233, 8598, 8902);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 233, 8598, 8902);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 233, 8598, 8902);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 233, 8598, 8902);
            final StringBuffer npe_invocation_var937 = format(m, new StringBuffer(), new FieldPosition(0));
            if (CallChecker.beforeDeref(npe_invocation_var937, StringBuffer.class, 234, 8834, 8884)) {
                return CallChecker.isCalled(npe_invocation_var937, StringBuffer.class, 234, 8834, 8884).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4627.methodEnd();
        }
    }

    public StringBuffer format(RealMatrix matrix, StringBuffer toAppendTo, FieldPosition pos) {
        MethodContext _bcornu_methode_context4628 = new MethodContext(StringBuffer.class, 245, 8909, 10184);
        try {
            CallChecker.varInit(this, "this", 245, 8909, 10184);
            CallChecker.varInit(pos, "pos", 245, 8909, 10184);
            CallChecker.varInit(toAppendTo, "toAppendTo", 245, 8909, 10184);
            CallChecker.varInit(matrix, "matrix", 245, 8909, 10184);
            CallChecker.varInit(this.format, "format", 245, 8909, 10184);
            CallChecker.varInit(this.columnSeparator, "columnSeparator", 245, 8909, 10184);
            CallChecker.varInit(this.rowSeparator, "rowSeparator", 245, 8909, 10184);
            CallChecker.varInit(this.rowSuffix, "rowSuffix", 245, 8909, 10184);
            CallChecker.varInit(this.rowPrefix, "rowPrefix", 245, 8909, 10184);
            CallChecker.varInit(this.suffix, "suffix", 245, 8909, 10184);
            CallChecker.varInit(this.prefix, "prefix", 245, 8909, 10184);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 245, 8909, 10184);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 245, 8909, 10184);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 245, 8909, 10184);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 245, 8909, 10184);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 245, 8909, 10184);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 245, 8909, 10184);
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 248, 9396, 9398)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 248, 9396, 9398);
                CallChecker.isCalled(pos, FieldPosition.class, 248, 9396, 9398).setBeginIndex(0);
            }
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 249, 9426, 9428)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 249, 9426, 9428);
                CallChecker.isCalled(pos, FieldPosition.class, 249, 9426, 9428).setEndIndex(0);
            }
            if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 252, 9480, 9489)) {
                toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 252, 9480, 9489);
                CallChecker.isCalled(toAppendTo, StringBuffer.class, 252, 9480, 9489).append(prefix);
            }
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 255, 9556, 9561);
            final int rows = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 255, 9556, 9561).getRowDimension())), "rows", 255, 9516, 9580);
            for (int i = 0; i < rows; ++i) {
                if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 257, 9635, 9644)) {
                    toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 257, 9635, 9644);
                    CallChecker.isCalled(toAppendTo, StringBuffer.class, 257, 9635, 9644).append(rowPrefix);
                }
                matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 258, 9697, 9702);
                for (int j = 0; j < (CallChecker.isCalled(matrix, RealMatrix.class, 258, 9697, 9702).getColumnDimension()); ++j) {
                    if (j > 0) {
                        if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 260, 9782, 9791)) {
                            toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 260, 9782, 9791);
                            CallChecker.isCalled(toAppendTo, StringBuffer.class, 260, 9782, 9791).append(columnSeparator);
                        }
                    }
                    if (CallChecker.beforeDeref(matrix, RealMatrix.class, 262, 9881, 9886)) {
                        matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 262, 9881, 9886);
                        CompositeFormat.formatDouble(CallChecker.isCalled(matrix, RealMatrix.class, 262, 9881, 9886).getEntry(i, j), format, toAppendTo, pos);
                    }
                }
                if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 264, 9956, 9965)) {
                    toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 264, 9956, 9965);
                    CallChecker.isCalled(toAppendTo, StringBuffer.class, 264, 9956, 9965).append(rowSuffix);
                }
                if (i < (rows - 1)) {
                    if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 266, 10034, 10043)) {
                        toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 266, 10034, 10043);
                        CallChecker.isCalled(toAppendTo, StringBuffer.class, 266, 10034, 10043).append(rowSeparator);
                    }
                }
            }
            if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 271, 10125, 10134)) {
                toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 271, 10125, 10134);
                CallChecker.isCalled(toAppendTo, StringBuffer.class, 271, 10125, 10134).append(suffix);
            }
            return toAppendTo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4628.methodEnd();
        }
    }

    public RealMatrix parse(String source) {
        MethodContext _bcornu_methode_context4629 = new MethodContext(RealMatrix.class, 284, 10191, 10911);
        try {
            CallChecker.varInit(this, "this", 284, 10191, 10911);
            CallChecker.varInit(source, "source", 284, 10191, 10911);
            CallChecker.varInit(this.format, "format", 284, 10191, 10911);
            CallChecker.varInit(this.columnSeparator, "columnSeparator", 284, 10191, 10911);
            CallChecker.varInit(this.rowSeparator, "rowSeparator", 284, 10191, 10911);
            CallChecker.varInit(this.rowSuffix, "rowSuffix", 284, 10191, 10911);
            CallChecker.varInit(this.rowPrefix, "rowPrefix", 284, 10191, 10911);
            CallChecker.varInit(this.suffix, "suffix", 284, 10191, 10911);
            CallChecker.varInit(this.prefix, "prefix", 284, 10191, 10911);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 284, 10191, 10911);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 284, 10191, 10911);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 284, 10191, 10911);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 284, 10191, 10911);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 284, 10191, 10911);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 284, 10191, 10911);
            final ParsePosition parsePosition = CallChecker.varInit(new ParsePosition(0), "parsePosition", 285, 10516, 10572);
            final RealMatrix result = CallChecker.varInit(parse(source, parsePosition), "result", 286, 10582, 10636);
            if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 287, 10650, 10662)) {
                if ((CallChecker.isCalled(parsePosition, ParsePosition.class, 287, 10650, 10662).getIndex()) == 0) {
                    if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 289, 10773, 10785)) {
                        throw new MathParseException(source, CallChecker.isCalled(parsePosition, ParsePosition.class, 289, 10773, 10785).getErrorIndex(), Array2DRowRealMatrix.class);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4629.methodEnd();
        }
    }

    public RealMatrix parse(String source, ParsePosition pos) {
        MethodContext _bcornu_methode_context4630 = new MethodContext(RealMatrix.class, 302, 10918, 14759);
        try {
            CallChecker.varInit(this, "this", 302, 10918, 14759);
            CallChecker.varInit(pos, "pos", 302, 10918, 14759);
            CallChecker.varInit(source, "source", 302, 10918, 14759);
            CallChecker.varInit(this.format, "format", 302, 10918, 14759);
            CallChecker.varInit(this.columnSeparator, "columnSeparator", 302, 10918, 14759);
            CallChecker.varInit(this.rowSeparator, "rowSeparator", 302, 10918, 14759);
            CallChecker.varInit(this.rowSuffix, "rowSuffix", 302, 10918, 14759);
            CallChecker.varInit(this.rowPrefix, "rowPrefix", 302, 10918, 14759);
            CallChecker.varInit(this.suffix, "suffix", 302, 10918, 14759);
            CallChecker.varInit(this.prefix, "prefix", 302, 10918, 14759);
            CallChecker.varInit(DEFAULT_COLUMN_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_COLUMN_SEPARATOR", 302, 10918, 14759);
            CallChecker.varInit(DEFAULT_ROW_SEPARATOR, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SEPARATOR", 302, 10918, 14759);
            CallChecker.varInit(DEFAULT_ROW_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_SUFFIX", 302, 10918, 14759);
            CallChecker.varInit(DEFAULT_ROW_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_ROW_PREFIX", 302, 10918, 14759);
            CallChecker.varInit(DEFAULT_SUFFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_SUFFIX", 302, 10918, 14759);
            CallChecker.varInit(DEFAULT_PREFIX, "org.apache.commons.math3.linear.RealMatrixFormat.DEFAULT_PREFIX", 302, 10918, 14759);
            int initialIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 303, 11230, 11232)) {
                pos = CallChecker.beforeCalled(pos, ParsePosition.class, 303, 11230, 11232);
                initialIndex = CallChecker.isCalled(pos, ParsePosition.class, 303, 11230, 11232).getIndex();
                CallChecker.varAssign(initialIndex, "initialIndex", 303, 11230, 11232);
            }
            final String trimmedPrefix = CallChecker.varInit(CallChecker.isCalled(prefix, String.class, 305, 11284, 11289).trim(), "trimmedPrefix", 305, 11255, 11297);
            final String trimmedSuffix = CallChecker.varInit(CallChecker.isCalled(suffix, String.class, 306, 11336, 11341).trim(), "trimmedSuffix", 306, 11307, 11349);
            final String trimmedRowPrefix = CallChecker.varInit(CallChecker.isCalled(rowPrefix, String.class, 307, 11391, 11399).trim(), "trimmedRowPrefix", 307, 11359, 11407);
            final String trimmedRowSuffix = CallChecker.varInit(CallChecker.isCalled(rowSuffix, String.class, 308, 11449, 11457).trim(), "trimmedRowSuffix", 308, 11417, 11465);
            final String trimmedColumnSeparator = CallChecker.varInit(CallChecker.isCalled(columnSeparator, String.class, 309, 11513, 11527).trim(), "trimmedColumnSeparator", 309, 11475, 11535);
            final String trimmedRowSeparator = CallChecker.varInit(CallChecker.isCalled(rowSeparator, String.class, 310, 11580, 11591).trim(), "trimmedRowSeparator", 310, 11545, 11599);
            CompositeFormat.parseAndIgnoreWhitespace(source, pos);
            if (!(CompositeFormat.parseFixedstring(source, trimmedPrefix, pos))) {
                return null;
            }
            List<List<Number>> matrix = CallChecker.varInit(new ArrayList<List<Number>>(), "matrix", 319, 11838, 11895);
            List<Number> rowComponents = CallChecker.varInit(new ArrayList<Number>(), "rowComponents", 320, 11905, 11957);
            for (boolean loop = true; loop;) {
                if (CallChecker.beforeDeref(rowComponents, List.class, 323, 12019, 12031)) {
                    rowComponents = CallChecker.beforeCalled(rowComponents, List.class, 323, 12019, 12031);
                    if (!(CallChecker.isCalled(rowComponents, List.class, 323, 12019, 12031).isEmpty())) {
                        CompositeFormat.parseAndIgnoreWhitespace(source, pos);
                        if (!(CompositeFormat.parseFixedstring(source, trimmedColumnSeparator, pos))) {
                            if (CallChecker.beforeDeref(trimmedRowSuffix, String.class, 326, 12235, 12250)) {
                                if (((CallChecker.isCalled(trimmedRowSuffix, String.class, 326, 12235, 12250).length()) != 0) && (!(CompositeFormat.parseFixedstring(source, trimmedRowSuffix, pos)))) {
                                    return null;
                                }else {
                                    CompositeFormat.parseAndIgnoreWhitespace(source, pos);
                                    if (CompositeFormat.parseFixedstring(source, trimmedRowSeparator, pos)) {
                                        if (CallChecker.beforeDeref(matrix, List.class, 332, 12632, 12637)) {
                                            matrix = CallChecker.beforeCalled(matrix, List.class, 332, 12632, 12637);
                                            CallChecker.isCalled(matrix, List.class, 332, 12632, 12637).add(rowComponents);
                                        }
                                        rowComponents = new ArrayList<Number>();
                                        CallChecker.varAssign(rowComponents, "rowComponents", 333, 12687, 12726);
                                        continue;
                                    }else {
                                        loop = false;
                                        CallChecker.varAssign(loop, "loop", 336, 12827, 12839);
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else {
                        CompositeFormat.parseAndIgnoreWhitespace(source, pos);
                        if (CallChecker.beforeDeref(trimmedRowPrefix, String.class, 342, 13019, 13034)) {
                            if (((CallChecker.isCalled(trimmedRowPrefix, String.class, 342, 13019, 13034).length()) != 0) && (!(CompositeFormat.parseFixedstring(source, trimmedRowPrefix, pos)))) {
                                return null;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (loop) {
                    CompositeFormat.parseAndIgnoreWhitespace(source, pos);
                    Number component = CallChecker.varInit(CompositeFormat.parseNumber(source, format, pos), "component", 350, 13318, 13385);
                    if (component != null) {
                        if (CallChecker.beforeDeref(rowComponents, List.class, 352, 13448, 13460)) {
                            rowComponents = CallChecker.beforeCalled(rowComponents, List.class, 352, 13448, 13460);
                            CallChecker.isCalled(rowComponents, List.class, 352, 13448, 13460).add(component);
                        }
                    }else {
                        if (CallChecker.beforeDeref(rowComponents, List.class, 354, 13527, 13539)) {
                            rowComponents = CallChecker.beforeCalled(rowComponents, List.class, 354, 13527, 13539);
                            if (CallChecker.isCalled(rowComponents, List.class, 354, 13527, 13539).isEmpty()) {
                                loop = false;
                                CallChecker.varAssign(loop, "loop", 355, 13578, 13590);
                            }else {
                                if (CallChecker.beforeDeref(pos, ParsePosition.class, 359, 13778, 13780)) {
                                    pos = CallChecker.beforeCalled(pos, ParsePosition.class, 359, 13778, 13780);
                                    CallChecker.isCalled(pos, ParsePosition.class, 359, 13778, 13780).setIndex(initialIndex);
                                }
                                return null;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            if (CallChecker.beforeDeref(rowComponents, List.class, 367, 13922, 13934)) {
                rowComponents = CallChecker.beforeCalled(rowComponents, List.class, 367, 13922, 13934);
                if (!(CallChecker.isCalled(rowComponents, List.class, 367, 13922, 13934).isEmpty())) {
                    if (CallChecker.beforeDeref(matrix, List.class, 368, 13961, 13966)) {
                        matrix = CallChecker.beforeCalled(matrix, List.class, 368, 13961, 13966);
                        CallChecker.isCalled(matrix, List.class, 368, 13961, 13966).add(rowComponents);
                    }
                }
            }
            CompositeFormat.parseAndIgnoreWhitespace(source, pos);
            if (!(CompositeFormat.parseFixedstring(source, trimmedSuffix, pos))) {
                return null;
            }
            if (CallChecker.beforeDeref(matrix, List.class, 378, 14251, 14256)) {
                matrix = CallChecker.beforeCalled(matrix, List.class, 378, 14251, 14256);
                if (CallChecker.isCalled(matrix, List.class, 378, 14251, 14256).isEmpty()) {
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 379, 14283, 14285)) {
                        pos = CallChecker.beforeCalled(pos, ParsePosition.class, 379, 14283, 14285);
                        CallChecker.isCalled(pos, ParsePosition.class, 379, 14283, 14285).setIndex(initialIndex);
                    }
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            double[][] data = CallChecker.init(double[][].class);
            if (CallChecker.beforeDeref(matrix, List.class, 384, 14408, 14413)) {
                matrix = CallChecker.beforeCalled(matrix, List.class, 384, 14408, 14413);
                data = new double[CallChecker.isCalled(matrix, List.class, 384, 14408, 14413).size()][];
                CallChecker.varAssign(data, "data", 384, 14408, 14413);
            }
            int row = CallChecker.varInit(((int) (0)), "row", 385, 14434, 14445);
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 386, 14483, 14488)) {
                for (List<Number> rowList : matrix) {
                    if (CallChecker.beforeDeref(data, double[][].class, 387, 14505, 14508)) {
                        if (CallChecker.beforeDeref(rowList, List.class, 387, 14528, 14534)) {
                            data = CallChecker.beforeCalled(data, double[][].class, 387, 14505, 14508);
                            CallChecker.isCalled(data, double[][].class, 387, 14505, 14508)[row] = new double[CallChecker.isCalled(rowList, List.class, 387, 14528, 14534).size()];
                            CallChecker.varAssign(CallChecker.isCalled(data, double[][].class, 387, 14505, 14508)[row], "CallChecker.isCalled(data, double[][].class, 387, 14505, 14508)[row]", 387, 14505, 14543);
                        }
                    }
                    for (int i = 0; i < (CallChecker.isCalled(rowList, List.class, 388, 14577, 14583).size()); i++) {
                        if (CallChecker.beforeDeref(data, double[][].class, 389, 14616, 14619)) {
                            data = CallChecker.beforeCalled(data, double[][].class, 389, 14616, 14619);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 389, 14616, 14619)[row], double[].class, 389, 14616, 14624)) {
                                if (CallChecker.beforeDeref(rowList, List.class, 389, 14631, 14637)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(rowList, List.class, 389, 14631, 14637).get(i), Number.class, 389, 14631, 14644)) {
                                        data = CallChecker.beforeCalled(data, double[][].class, 389, 14616, 14619);
                                        CallChecker.isCalled(data, double[][].class, 389, 14616, 14619)[row] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 389, 14616, 14619)[row], double[].class, 389, 14616, 14624);
                                        CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 389, 14616, 14619)[row], double[].class, 389, 14616, 14624)[i] = CallChecker.isCalled(CallChecker.isCalled(rowList, List.class, 389, 14631, 14637).get(i), Number.class, 389, 14631, 14644).doubleValue();
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 389, 14616, 14619)[row], double[].class, 389, 14616, 14624)[i], "CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 389, 14616, 14619)[row], double[].class, 389, 14616, 14624)[i]", 389, 14616, 14659);
                                    }
                                }
                            }
                        }
                    }
                    row++;
                }
            }
            return MatrixUtils.createRealMatrix(data);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4630.methodEnd();
        }
    }
}

