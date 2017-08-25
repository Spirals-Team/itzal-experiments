package org.apache.commons.math3.geometry.euclidean.oned;

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
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.CompositeFormat;

public class Vector1DFormat extends VectorFormat<Euclidean1D> {
    public Vector1DFormat() {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context884 = new ConstructorContext(Vector1DFormat.class, 54, 2238, 2601);
        try {
        } finally {
            _bcornu_methode_context884.methodEnd();
        }
    }

    public Vector1DFormat(final NumberFormat format) {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, format);
        ConstructorContext _bcornu_methode_context885 = new ConstructorContext(Vector1DFormat.class, 63, 2608, 2878);
        try {
        } finally {
            _bcornu_methode_context885.methodEnd();
        }
    }

    public Vector1DFormat(final String prefix, final String suffix) {
        super(prefix, suffix, VectorFormat.DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context886 = new ConstructorContext(Vector1DFormat.class, 72, 2885, 3255);
        try {
        } finally {
            _bcornu_methode_context886.methodEnd();
        }
    }

    public Vector1DFormat(final String prefix, final String suffix, final NumberFormat format) {
        super(prefix, suffix, VectorFormat.DEFAULT_SEPARATOR, format);
        ConstructorContext _bcornu_methode_context887 = new ConstructorContext(Vector1DFormat.class, 83, 3262, 3735);
        try {
        } finally {
            _bcornu_methode_context887.methodEnd();
        }
    }

    public static Vector1DFormat getInstance() {
        MethodContext _bcornu_methode_context3944 = new MethodContext(Vector1DFormat.class, 92, 3742, 3969);
        try {
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 92, 3742, 3969);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 92, 3742, 3969);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 92, 3742, 3969);
            return Vector1DFormat.getInstance(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1DFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3944.methodEnd();
        }
    }

    public static Vector1DFormat getInstance(final Locale locale) {
        MethodContext _bcornu_methode_context3945 = new MethodContext(Vector1DFormat.class, 101, 3976, 4336);
        try {
            CallChecker.varInit(locale, "locale", 101, 3976, 4336);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 101, 3976, 4336);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 101, 3976, 4336);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 101, 3976, 4336);
            return new Vector1DFormat(CompositeFormat.getDefaultNumberFormat(locale));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1DFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3945.methodEnd();
        }
    }

    @Override
    public StringBuffer format(final Vector<Euclidean1D> vector, final StringBuffer toAppendTo, final FieldPosition pos) {
        MethodContext _bcornu_methode_context3946 = new MethodContext(StringBuffer.class, 107, 4343, 4634);
        try {
            CallChecker.varInit(this, "this", 107, 4343, 4634);
            CallChecker.varInit(pos, "pos", 107, 4343, 4634);
            CallChecker.varInit(toAppendTo, "toAppendTo", 107, 4343, 4634);
            CallChecker.varInit(vector, "vector", 107, 4343, 4634);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 107, 4343, 4634);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 107, 4343, 4634);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 107, 4343, 4634);
            final Vector1D p1 = CallChecker.varInit(((Vector1D) (vector)), "p1", 109, 4540, 4577);
            if (CallChecker.beforeDeref(p1, Vector1D.class, 110, 4618, 4619)) {
                return format(toAppendTo, pos, CallChecker.isCalled(p1, Vector1D.class, 110, 4618, 4619).getX());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3946.methodEnd();
        }
    }

    @Override
    public Vector1D parse(final String source) throws MathParseException {
        MethodContext _bcornu_methode_context3947 = new MethodContext(Vector1D.class, 115, 4641, 5128);
        try {
            CallChecker.varInit(this, "this", 115, 4641, 5128);
            CallChecker.varInit(source, "source", 115, 4641, 5128);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 115, 4641, 5128);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 115, 4641, 5128);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 115, 4641, 5128);
            ParsePosition parsePosition = CallChecker.varInit(new ParsePosition(0), "parsePosition", 116, 4759, 4809);
            Vector1D result = CallChecker.varInit(parse(source, parsePosition), "result", 117, 4819, 4865);
            if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 118, 4879, 4891)) {
                parsePosition = CallChecker.beforeCalled(parsePosition, ParsePosition.class, 118, 4879, 4891);
                if ((CallChecker.isCalled(parsePosition, ParsePosition.class, 118, 4879, 4891).getIndex()) == 0) {
                    if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 120, 5002, 5014)) {
                        parsePosition = CallChecker.beforeCalled(parsePosition, ParsePosition.class, 120, 5002, 5014);
                        throw new MathParseException(source, CallChecker.isCalled(parsePosition, ParsePosition.class, 120, 5002, 5014).getErrorIndex(), Vector1D.class);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3947.methodEnd();
        }
    }

    @Override
    public Vector1D parse(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context3948 = new MethodContext(Vector1D.class, 128, 5135, 5434);
        try {
            CallChecker.varInit(this, "this", 128, 5135, 5434);
            CallChecker.varInit(pos, "pos", 128, 5135, 5434);
            CallChecker.varInit(source, "source", 128, 5135, 5434);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 128, 5135, 5434);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 128, 5135, 5434);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 128, 5135, 5434);
            final double[] coordinates = CallChecker.varInit(parseCoordinates(1, source, pos), "coordinates", 129, 5252, 5313);
            if (coordinates == null) {
                return null;
            }
            return new Vector1D(coordinates[0]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3948.methodEnd();
        }
    }
}

