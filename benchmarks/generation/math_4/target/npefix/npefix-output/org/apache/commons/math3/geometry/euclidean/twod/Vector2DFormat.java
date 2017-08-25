package org.apache.commons.math3.geometry.euclidean.twod;

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

public class Vector2DFormat extends VectorFormat<Euclidean2D> {
    public Vector2DFormat() {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context295 = new ConstructorContext(Vector2DFormat.class, 54, 2270, 2633);
        try {
        } finally {
            _bcornu_methode_context295.methodEnd();
        }
    }

    public Vector2DFormat(final NumberFormat format) {
        super(VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, VectorFormat.DEFAULT_SEPARATOR, format);
        ConstructorContext _bcornu_methode_context296 = new ConstructorContext(Vector2DFormat.class, 63, 2640, 2910);
        try {
        } finally {
            _bcornu_methode_context296.methodEnd();
        }
    }

    public Vector2DFormat(final String prefix, final String suffix, final String separator) {
        super(prefix, suffix, separator, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context297 = new ConstructorContext(Vector2DFormat.class, 73, 2917, 3397);
        try {
        } finally {
            _bcornu_methode_context297.methodEnd();
        }
    }

    public Vector2DFormat(final String prefix, final String suffix, final String separator, final NumberFormat format) {
        super(prefix, suffix, separator, format);
        ConstructorContext _bcornu_methode_context298 = new ConstructorContext(Vector2DFormat.class, 86, 3404, 3962);
        try {
        } finally {
            _bcornu_methode_context298.methodEnd();
        }
    }

    public static Vector2DFormat getInstance() {
        MethodContext _bcornu_methode_context1328 = new MethodContext(Vector2DFormat.class, 95, 3969, 4196);
        try {
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 95, 3969, 4196);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 95, 3969, 4196);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 95, 3969, 4196);
            return Vector2DFormat.getInstance(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2DFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1328.methodEnd();
        }
    }

    public static Vector2DFormat getInstance(final Locale locale) {
        MethodContext _bcornu_methode_context1329 = new MethodContext(Vector2DFormat.class, 104, 4203, 4563);
        try {
            CallChecker.varInit(locale, "locale", 104, 4203, 4563);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 104, 4203, 4563);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 104, 4203, 4563);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 104, 4203, 4563);
            return new Vector2DFormat(CompositeFormat.getDefaultNumberFormat(locale));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2DFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1329.methodEnd();
        }
    }

    @Override
    public StringBuffer format(final Vector<Euclidean2D> vector, final StringBuffer toAppendTo, final FieldPosition pos) {
        MethodContext _bcornu_methode_context1330 = new MethodContext(StringBuffer.class, 110, 4570, 4872);
        try {
            CallChecker.varInit(this, "this", 110, 4570, 4872);
            CallChecker.varInit(pos, "pos", 110, 4570, 4872);
            CallChecker.varInit(toAppendTo, "toAppendTo", 110, 4570, 4872);
            CallChecker.varInit(vector, "vector", 110, 4570, 4872);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 110, 4570, 4872);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 110, 4570, 4872);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 110, 4570, 4872);
            final Vector2D p2 = CallChecker.varInit(((Vector2D) (vector)), "p2", 112, 4767, 4804);
            if (CallChecker.beforeDeref(p2, Vector2D.class, 113, 4845, 4846)) {
                if (CallChecker.beforeDeref(p2, Vector2D.class, 113, 4856, 4857)) {
                    return format(toAppendTo, pos, CallChecker.isCalled(p2, Vector2D.class, 113, 4845, 4846).getX(), CallChecker.isCalled(p2, Vector2D.class, 113, 4856, 4857).getY());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1330.methodEnd();
        }
    }

    @Override
    public Vector2D parse(final String source) throws MathParseException {
        MethodContext _bcornu_methode_context1331 = new MethodContext(Vector2D.class, 118, 4879, 5366);
        try {
            CallChecker.varInit(this, "this", 118, 4879, 5366);
            CallChecker.varInit(source, "source", 118, 4879, 5366);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 118, 4879, 5366);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 118, 4879, 5366);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 118, 4879, 5366);
            ParsePosition parsePosition = CallChecker.varInit(new ParsePosition(0), "parsePosition", 119, 4997, 5047);
            Vector2D result = CallChecker.varInit(parse(source, parsePosition), "result", 120, 5057, 5103);
            if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 121, 5117, 5129)) {
                parsePosition = CallChecker.beforeCalled(parsePosition, ParsePosition.class, 121, 5117, 5129);
                if ((CallChecker.isCalled(parsePosition, ParsePosition.class, 121, 5117, 5129).getIndex()) == 0) {
                    if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 123, 5240, 5252)) {
                        parsePosition = CallChecker.beforeCalled(parsePosition, ParsePosition.class, 123, 5240, 5252);
                        throw new MathParseException(source, CallChecker.isCalled(parsePosition, ParsePosition.class, 123, 5240, 5252).getErrorIndex(), Vector2D.class);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1331.methodEnd();
        }
    }

    @Override
    public Vector2D parse(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context1332 = new MethodContext(Vector2D.class, 131, 5373, 5688);
        try {
            CallChecker.varInit(this, "this", 131, 5373, 5688);
            CallChecker.varInit(pos, "pos", 131, 5373, 5688);
            CallChecker.varInit(source, "source", 131, 5373, 5688);
            CallChecker.varInit(VectorFormat.DEFAULT_SEPARATOR, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SEPARATOR", 131, 5373, 5688);
            CallChecker.varInit(VectorFormat.DEFAULT_SUFFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_SUFFIX", 131, 5373, 5688);
            CallChecker.varInit(VectorFormat.DEFAULT_PREFIX, "org.apache.commons.math3.geometry.VectorFormat.DEFAULT_PREFIX", 131, 5373, 5688);
            final double[] coordinates = CallChecker.varInit(parseCoordinates(2, source, pos), "coordinates", 132, 5490, 5551);
            if (coordinates == null) {
                return null;
            }
            return new Vector2D(coordinates[0], coordinates[1]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1332.methodEnd();
        }
    }
}

