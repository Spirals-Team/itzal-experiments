package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.commons.math3.util.CompositeFormat;

public class Vector3DFormat extends VectorFormat<Euclidean3D> {
    public Vector3DFormat() {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context48 = new ConstructorContext(Vector3DFormat.class, 53, 2321, 2684);
        try {
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context48.methodEnd();
        }
    }

    public Vector3DFormat(final NumberFormat format) {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, format);
        ConstructorContext _bcornu_methode_context49 = new ConstructorContext(Vector3DFormat.class, 62, 2691, 2961);
        try {
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }

    public Vector3DFormat(final String prefix, final String suffix, final String separator) {
        super(prefix, suffix, separator, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context50 = new ConstructorContext(Vector3DFormat.class, 72, 2968, 3448);
        try {
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    public Vector3DFormat(final String prefix, final String suffix, final String separator, final NumberFormat format) {
        super(prefix, suffix, separator, format);
        ConstructorContext _bcornu_methode_context51 = new ConstructorContext(Vector3DFormat.class, 85, 3455, 4013);
        try {
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }

    public static Vector3DFormat getInstance() {
        MethodContext _bcornu_methode_context198 = new MethodContext(Vector3DFormat.class, 94, 4020, 4247);
        try {
            return Vector3DFormat.getInstance(Locale.getDefault());
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3DFormat) (CallChecker.isToCatch(_bcornu_return_t, Vector3DFormat.class)));
        } finally {
            _bcornu_methode_context198.methodEnd();
        }
    }

    public static Vector3DFormat getInstance(final Locale locale) {
        MethodContext _bcornu_methode_context199 = new MethodContext(Vector3DFormat.class, 103, 4254, 4614);
        try {
            CallChecker.varInit(locale, "locale", 103, 4254, 4614);
            return new Vector3DFormat(CompositeFormat.getDefaultNumberFormat(locale));
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3DFormat) (CallChecker.isToCatch(_bcornu_return_t, Vector3DFormat.class)));
        } finally {
            _bcornu_methode_context199.methodEnd();
        }
    }

    @Override
    public StringBuffer format(final Vector<Euclidean3D> vector, final StringBuffer toAppendTo, final FieldPosition pos) {
        MethodContext _bcornu_methode_context200 = new MethodContext(StringBuffer.class, 116, 4621, 5262);
        try {
            CallChecker.varInit(this, "this", 116, 4621, 5262);
            CallChecker.varInit(pos, "pos", 116, 4621, 5262);
            CallChecker.varInit(toAppendTo, "toAppendTo", 116, 4621, 5262);
            CallChecker.varInit(vector, "vector", 116, 4621, 5262);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (vector)), "v3", 118, 5146, 5183);
            return format(toAppendTo, pos, v3.getX(), v3.getY(), v3.getZ());
        } catch (RuntimeException _bcornu_return_t) {
            return ((StringBuffer) (CallChecker.isToCatch(_bcornu_return_t, StringBuffer.class)));
        } finally {
            _bcornu_methode_context200.methodEnd();
        }
    }

    @Override
    public Vector3D parse(final String source) throws MathParseException {
        MethodContext _bcornu_methode_context201 = new MethodContext(Vector3D.class, 130, 5269, 6000);
        try {
            CallChecker.varInit(this, "this", 130, 5269, 6000);
            CallChecker.varInit(source, "source", 130, 5269, 6000);
            ParsePosition parsePosition = CallChecker.varInit(new ParsePosition(0), "parsePosition", 131, 5631, 5681);
            Vector3D result = CallChecker.varInit(parse(source, parsePosition), "result", 132, 5691, 5737);
            if ((parsePosition.getIndex()) == 0) {
                throw new MathParseException(source, parsePosition.getErrorIndex(), Vector3D.class);
            }
            return result;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context201.methodEnd();
        }
    }

    @Override
    public Vector3D parse(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context202 = new MethodContext(Vector3D.class, 148, 6007, 6531);
        try {
            CallChecker.varInit(this, "this", 148, 6007, 6531);
            CallChecker.varInit(pos, "pos", 148, 6007, 6531);
            CallChecker.varInit(source, "source", 148, 6007, 6531);
            final double[] coordinates = CallChecker.varInit(parseCoordinates(3, source, pos), "coordinates", 149, 6317, 6378);
            if (coordinates == null) {
                return null;
            }
            return new Vector3D(coordinates[0], coordinates[1], coordinates[2]);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context202.methodEnd();
        }
    }
}

