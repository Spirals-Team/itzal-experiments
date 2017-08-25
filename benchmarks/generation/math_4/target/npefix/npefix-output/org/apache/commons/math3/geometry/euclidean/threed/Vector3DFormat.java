package org.apache.commons.math3.geometry.euclidean.threed;

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

public class Vector3DFormat extends VectorFormat<Euclidean3D> {
    public Vector3DFormat() {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context212 = new ConstructorContext(Vector3DFormat.class, 53, 2267, 2630);
        try {
        } finally {
            _bcornu_methode_context212.methodEnd();
        }
    }

    public Vector3DFormat(final NumberFormat format) {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, format);
        ConstructorContext _bcornu_methode_context213 = new ConstructorContext(Vector3DFormat.class, 62, 2637, 2907);
        try {
        } finally {
            _bcornu_methode_context213.methodEnd();
        }
    }

    public Vector3DFormat(final String prefix, final String suffix, final String separator) {
        super(prefix, suffix, separator, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context214 = new ConstructorContext(Vector3DFormat.class, 72, 2914, 3394);
        try {
        } finally {
            _bcornu_methode_context214.methodEnd();
        }
    }

    public Vector3DFormat(final String prefix, final String suffix, final String separator, final NumberFormat format) {
        super(prefix, suffix, separator, format);
        ConstructorContext _bcornu_methode_context215 = new ConstructorContext(Vector3DFormat.class, 85, 3401, 3959);
        try {
        } finally {
            _bcornu_methode_context215.methodEnd();
        }
    }

    public static Vector3DFormat getInstance() {
        MethodContext _bcornu_methode_context846 = new MethodContext(Vector3DFormat.class, 94, 3966, 4193);
        try {
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 94, 3966, 4193);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 94, 3966, 4193);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 94, 3966, 4193);
            return Vector3DFormat.getInstance(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3DFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context846.methodEnd();
        }
    }

    public static Vector3DFormat getInstance(final Locale locale) {
        MethodContext _bcornu_methode_context847 = new MethodContext(Vector3DFormat.class, 103, 4200, 4560);
        try {
            CallChecker.varInit(locale, "locale", 103, 4200, 4560);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 103, 4200, 4560);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 103, 4200, 4560);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 103, 4200, 4560);
            return new Vector3DFormat(CompositeFormat.getDefaultNumberFormat(locale));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3DFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context847.methodEnd();
        }
    }

    @Override
    public StringBuffer format(final Vector<Euclidean3D> vector, final StringBuffer toAppendTo, final FieldPosition pos) {
        MethodContext _bcornu_methode_context848 = new MethodContext(StringBuffer.class, 116, 4567, 5208);
        try {
            CallChecker.varInit(this, "this", 116, 4567, 5208);
            CallChecker.varInit(pos, "pos", 116, 4567, 5208);
            CallChecker.varInit(toAppendTo, "toAppendTo", 116, 4567, 5208);
            CallChecker.varInit(vector, "vector", 116, 4567, 5208);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 116, 4567, 5208);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 116, 4567, 5208);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 116, 4567, 5208);
            final Vector3D v3 = CallChecker.varInit(((Vector3D) (vector)), "v3", 118, 5092, 5129);
            if (CallChecker.beforeDeref(v3, Vector3D.class, 119, 5170, 5171)) {
                if (CallChecker.beforeDeref(v3, Vector3D.class, 119, 5181, 5182)) {
                    if (CallChecker.beforeDeref(v3, Vector3D.class, 119, 5192, 5193)) {
                        return format(toAppendTo, pos, CallChecker.isCalled(v3, Vector3D.class, 119, 5170, 5171).getX(), CallChecker.isCalled(v3, Vector3D.class, 119, 5181, 5182).getY(), CallChecker.isCalled(v3, Vector3D.class, 119, 5192, 5193).getZ());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context848.methodEnd();
        }
    }

    @Override
    public Vector3D parse(final String source) throws MathParseException {
        MethodContext _bcornu_methode_context849 = new MethodContext(Vector3D.class, 130, 5215, 5946);
        try {
            CallChecker.varInit(this, "this", 130, 5215, 5946);
            CallChecker.varInit(source, "source", 130, 5215, 5946);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 130, 5215, 5946);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 130, 5215, 5946);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 130, 5215, 5946);
            ParsePosition parsePosition = CallChecker.varInit(new ParsePosition(0), "parsePosition", 131, 5577, 5627);
            Vector3D result = CallChecker.varInit(parse(source, parsePosition), "result", 132, 5637, 5683);
            if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 133, 5697, 5709)) {
                parsePosition = CallChecker.beforeCalled(parsePosition, ParsePosition.class, 133, 5697, 5709);
                if ((CallChecker.isCalled(parsePosition, ParsePosition.class, 133, 5697, 5709).getIndex()) == 0) {
                    if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 135, 5820, 5832)) {
                        parsePosition = CallChecker.beforeCalled(parsePosition, ParsePosition.class, 135, 5820, 5832);
                        throw new MathParseException(source, CallChecker.isCalled(parsePosition, ParsePosition.class, 135, 5820, 5832).getErrorIndex(), Vector3D.class);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context849.methodEnd();
        }
    }

    @Override
    public Vector3D parse(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context850 = new MethodContext(Vector3D.class, 148, 5953, 6477);
        try {
            CallChecker.varInit(this, "this", 148, 5953, 6477);
            CallChecker.varInit(pos, "pos", 148, 5953, 6477);
            CallChecker.varInit(source, "source", 148, 5953, 6477);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 148, 5953, 6477);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 148, 5953, 6477);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 148, 5953, 6477);
            final double[] coordinates = CallChecker.varInit(parseCoordinates(3, source, pos), "coordinates", 149, 6263, 6324);
            if (coordinates == null) {
                return null;
            }
            return new Vector3D(coordinates[0], coordinates[1], coordinates[2]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context850.methodEnd();
        }
    }
}

