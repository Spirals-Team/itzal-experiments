package org.apache.commons.math3.complex;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.CompositeFormat;

public class ComplexFormat {
    private static final String DEFAULT_IMAGINARY_CHARACTER = "i";

    private final String imaginaryCharacter;

    private final NumberFormat imaginaryFormat;

    private final NumberFormat realFormat;

    public ComplexFormat() {
        ConstructorContext _bcornu_methode_context681 = new ConstructorContext(ComplexFormat.class, 54, 2033, 2398);
        try {
            this.imaginaryCharacter = ComplexFormat.DEFAULT_IMAGINARY_CHARACTER;
            CallChecker.varAssign(this.imaginaryCharacter, "this.imaginaryCharacter", 55, 2223, 2276);
            this.imaginaryFormat = CompositeFormat.getDefaultNumberFormat();
            CallChecker.varAssign(this.imaginaryFormat, "this.imaginaryFormat", 56, 2286, 2349);
            this.realFormat = imaginaryFormat;
            CallChecker.varAssign(this.realFormat, "this.realFormat", 57, 2359, 2392);
        } finally {
            _bcornu_methode_context681.methodEnd();
        }
    }

    public ComplexFormat(NumberFormat format) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context682 = new ConstructorContext(ComplexFormat.class, 66, 2405, 3000);
        try {
            if (format == null) {
                throw new NullArgumentException(LocalizedFormats.IMAGINARY_FORMAT);
            }
            this.imaginaryCharacter = ComplexFormat.DEFAULT_IMAGINARY_CHARACTER;
            CallChecker.varAssign(this.imaginaryCharacter, "this.imaginaryCharacter", 70, 2868, 2921);
            this.imaginaryFormat = format;
            CallChecker.varAssign(this.imaginaryFormat, "this.imaginaryFormat", 71, 2931, 2960);
            this.realFormat = format;
            CallChecker.varAssign(this.realFormat, "this.realFormat", 72, 2970, 2994);
        } finally {
            _bcornu_methode_context682.methodEnd();
        }
    }

    public ComplexFormat(NumberFormat realFormat, NumberFormat imaginaryFormat) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context683 = new ConstructorContext(ComplexFormat.class, 83, 3007, 3962);
        try {
            if (imaginaryFormat == null) {
                throw new NullArgumentException(LocalizedFormats.IMAGINARY_FORMAT);
            }
            if (realFormat == null) {
                throw new NullArgumentException(LocalizedFormats.REAL_FORMAT);
            }
            this.imaginaryCharacter = ComplexFormat.DEFAULT_IMAGINARY_CHARACTER;
            CallChecker.varAssign(this.imaginaryCharacter, "this.imaginaryCharacter", 92, 3817, 3870);
            this.imaginaryFormat = imaginaryFormat;
            CallChecker.varAssign(this.imaginaryFormat, "this.imaginaryFormat", 93, 3880, 3918);
            this.realFormat = realFormat;
            CallChecker.varAssign(this.realFormat, "this.realFormat", 94, 3928, 3956);
        } finally {
            _bcornu_methode_context683.methodEnd();
        }
    }

    public ComplexFormat(String imaginaryCharacter) throws NoDataException, NullArgumentException {
        this(imaginaryCharacter, CompositeFormat.getDefaultNumberFormat());
        ConstructorContext _bcornu_methode_context684 = new ConstructorContext(ComplexFormat.class, 106, 3969, 4546);
        try {
        } finally {
            _bcornu_methode_context684.methodEnd();
        }
    }

    public ComplexFormat(String imaginaryCharacter, NumberFormat format) throws NoDataException, NullArgumentException {
        this(imaginaryCharacter, format, format);
        ConstructorContext _bcornu_methode_context685 = new ConstructorContext(ComplexFormat.class, 122, 4553, 5268);
        try {
        } finally {
            _bcornu_methode_context685.methodEnd();
        }
    }

    public ComplexFormat(String imaginaryCharacter, NumberFormat realFormat, NumberFormat imaginaryFormat) throws NoDataException, NullArgumentException {
        ConstructorContext _bcornu_methode_context686 = new ConstructorContext(ComplexFormat.class, 142, 5275, 6801);
        try {
            if (imaginaryCharacter == null) {
                throw new NullArgumentException();
            }
            if ((imaginaryCharacter.length()) == 0) {
                throw new NoDataException();
            }
            if (imaginaryFormat == null) {
                throw new NullArgumentException(LocalizedFormats.IMAGINARY_FORMAT);
            }
            if (realFormat == null) {
                throw new NullArgumentException(LocalizedFormats.REAL_FORMAT);
            }
            this.imaginaryCharacter = imaginaryCharacter;
            CallChecker.varAssign(this.imaginaryCharacter, "this.imaginaryCharacter", 159, 6665, 6709);
            this.imaginaryFormat = imaginaryFormat;
            CallChecker.varAssign(this.imaginaryFormat, "this.imaginaryFormat", 160, 6719, 6757);
            this.realFormat = realFormat;
            CallChecker.varAssign(this.realFormat, "this.realFormat", 161, 6767, 6795);
        } finally {
            _bcornu_methode_context686.methodEnd();
        }
    }

    public static Locale[] getAvailableLocales() {
        MethodContext _bcornu_methode_context3007 = new MethodContext(Locale[].class, 169, 6808, 7114);
        try {
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 169, 6808, 7114);
            return NumberFormat.getAvailableLocales();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Locale[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3007.methodEnd();
        }
    }

    public String format(Complex c) {
        MethodContext _bcornu_methode_context3008 = new MethodContext(String.class, 179, 7121, 7444);
        try {
            CallChecker.varInit(this, "this", 179, 7121, 7444);
            CallChecker.varInit(c, "c", 179, 7121, 7444);
            CallChecker.varInit(this.realFormat, "realFormat", 179, 7121, 7444);
            CallChecker.varInit(this.imaginaryFormat, "imaginaryFormat", 179, 7121, 7444);
            CallChecker.varInit(this.imaginaryCharacter, "imaginaryCharacter", 179, 7121, 7444);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 179, 7121, 7444);
            final StringBuffer npe_invocation_var772 = format(c, new StringBuffer(), new FieldPosition(0));
            if (CallChecker.beforeDeref(npe_invocation_var772, StringBuffer.class, 180, 7376, 7426)) {
                return CallChecker.isCalled(npe_invocation_var772, StringBuffer.class, 180, 7376, 7426).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3008.methodEnd();
        }
    }

    public String format(Double c) {
        MethodContext _bcornu_methode_context3009 = new MethodContext(String.class, 189, 7451, 7759);
        try {
            CallChecker.varInit(this, "this", 189, 7451, 7759);
            CallChecker.varInit(c, "c", 189, 7451, 7759);
            CallChecker.varInit(this.realFormat, "realFormat", 189, 7451, 7759);
            CallChecker.varInit(this.imaginaryFormat, "imaginaryFormat", 189, 7451, 7759);
            CallChecker.varInit(this.imaginaryCharacter, "imaginaryCharacter", 189, 7451, 7759);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 189, 7451, 7759);
            final StringBuffer npe_invocation_var773 = format(new Complex(c, 0), new StringBuffer(), new FieldPosition(0));
            if (CallChecker.beforeDeref(npe_invocation_var773, StringBuffer.class, 190, 7675, 7741)) {
                return CallChecker.isCalled(npe_invocation_var773, StringBuffer.class, 190, 7675, 7741).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3009.methodEnd();
        }
    }

    public StringBuffer format(Complex complex, StringBuffer toAppendTo, FieldPosition pos) {
        MethodContext _bcornu_methode_context3010 = new MethodContext(StringBuffer.class, 202, 7766, 9093);
        try {
            CallChecker.varInit(this, "this", 202, 7766, 9093);
            CallChecker.varInit(pos, "pos", 202, 7766, 9093);
            CallChecker.varInit(toAppendTo, "toAppendTo", 202, 7766, 9093);
            CallChecker.varInit(complex, "complex", 202, 7766, 9093);
            CallChecker.varInit(this.realFormat, "realFormat", 202, 7766, 9093);
            CallChecker.varInit(this.imaginaryFormat, "imaginaryFormat", 202, 7766, 9093);
            CallChecker.varInit(this.imaginaryCharacter, "imaginaryCharacter", 202, 7766, 9093);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 202, 7766, 9093);
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 204, 8255, 8257)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 204, 8255, 8257);
                CallChecker.isCalled(pos, FieldPosition.class, 204, 8255, 8257).setBeginIndex(0);
            }
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 205, 8285, 8287)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 205, 8285, 8287);
                CallChecker.isCalled(pos, FieldPosition.class, 205, 8285, 8287).setEndIndex(0);
            }
            double re = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(complex, Complex.class, 208, 8349, 8355)) {
                complex = CallChecker.beforeCalled(complex, Complex.class, 208, 8349, 8355);
                re = CallChecker.isCalled(complex, Complex.class, 208, 8349, 8355).getReal();
                CallChecker.varAssign(re, "re", 208, 8349, 8355);
            }
            CompositeFormat.formatDouble(re, getRealFormat(), toAppendTo, pos);
            double im = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(complex, Complex.class, 212, 8502, 8508)) {
                complex = CallChecker.beforeCalled(complex, Complex.class, 212, 8502, 8508);
                im = CallChecker.isCalled(complex, Complex.class, 212, 8502, 8508).getImaginary();
                CallChecker.varAssign(im, "im", 212, 8502, 8508);
            }
            StringBuffer imAppendTo = CallChecker.init(StringBuffer.class);
            if (im < 0.0) {
                if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 215, 8595, 8604)) {
                    toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 215, 8595, 8604);
                    CallChecker.isCalled(toAppendTo, StringBuffer.class, 215, 8595, 8604).append(" - ");
                }
                imAppendTo = formatImaginary((-im), new StringBuffer(), pos);
                CallChecker.varAssign(imAppendTo, "imAppendTo", 216, 8633, 8691);
                if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 217, 8705, 8714)) {
                    toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 217, 8705, 8714);
                    CallChecker.isCalled(toAppendTo, StringBuffer.class, 217, 8705, 8714).append(imAppendTo);
                }
                if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 218, 8748, 8757)) {
                    toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 218, 8748, 8757);
                    CallChecker.isCalled(toAppendTo, StringBuffer.class, 218, 8748, 8757).append(getImaginaryCharacter());
                }
            }else
                if ((im > 0.0) || (Double.isNaN(im))) {
                    if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 220, 8855, 8864)) {
                        toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 220, 8855, 8864);
                        CallChecker.isCalled(toAppendTo, StringBuffer.class, 220, 8855, 8864).append(" + ");
                    }
                    imAppendTo = formatImaginary(im, new StringBuffer(), pos);
                    CallChecker.varAssign(imAppendTo, "imAppendTo", 221, 8893, 8950);
                    if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 222, 8964, 8973)) {
                        toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 222, 8964, 8973);
                        CallChecker.isCalled(toAppendTo, StringBuffer.class, 222, 8964, 8973).append(imAppendTo);
                    }
                    if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 223, 9007, 9016)) {
                        toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 223, 9007, 9016);
                        CallChecker.isCalled(toAppendTo, StringBuffer.class, 223, 9007, 9016).append(getImaginaryCharacter());
                    }
                }
            
            return toAppendTo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3010.methodEnd();
        }
    }

    private StringBuffer formatImaginary(double absIm, StringBuffer toAppendTo, FieldPosition pos) {
        MethodContext _bcornu_methode_context3011 = new MethodContext(StringBuffer.class, 238, 9100, 9993);
        try {
            CallChecker.varInit(this, "this", 238, 9100, 9993);
            CallChecker.varInit(pos, "pos", 238, 9100, 9993);
            CallChecker.varInit(toAppendTo, "toAppendTo", 238, 9100, 9993);
            CallChecker.varInit(absIm, "absIm", 238, 9100, 9993);
            CallChecker.varInit(this.realFormat, "realFormat", 238, 9100, 9993);
            CallChecker.varInit(this.imaginaryFormat, "imaginaryFormat", 238, 9100, 9993);
            CallChecker.varInit(this.imaginaryCharacter, "imaginaryCharacter", 238, 9100, 9993);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 238, 9100, 9993);
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 241, 9667, 9669)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 241, 9667, 9669);
                CallChecker.isCalled(pos, FieldPosition.class, 241, 9667, 9669).setBeginIndex(0);
            }
            if (CallChecker.beforeDeref(pos, FieldPosition.class, 242, 9697, 9699)) {
                pos = CallChecker.beforeCalled(pos, FieldPosition.class, 242, 9697, 9699);
                CallChecker.isCalled(pos, FieldPosition.class, 242, 9697, 9699).setEndIndex(0);
            }
            CompositeFormat.formatDouble(absIm, getImaginaryFormat(), toAppendTo, pos);
            if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 245, 9814, 9823)) {
                toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 245, 9814, 9823);
                if (CallChecker.beforeDeref(CallChecker.isCalled(toAppendTo, StringBuffer.class, 245, 9814, 9823).toString(), String.class, 245, 9814, 9834)) {
                    toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 245, 9814, 9823);
                    if (CallChecker.isCalled(CallChecker.isCalled(toAppendTo, StringBuffer.class, 245, 9814, 9823).toString(), String.class, 245, 9814, 9834).equals("1")) {
                        if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 247, 9926, 9935)) {
                            toAppendTo = CallChecker.beforeCalled(toAppendTo, StringBuffer.class, 247, 9926, 9935);
                            CallChecker.isCalled(toAppendTo, StringBuffer.class, 247, 9926, 9935).setLength(0);
                        }
                    }
                }
            }
            return toAppendTo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3011.methodEnd();
        }
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3012 = new MethodContext(StringBuffer.class, 266, 10000, 11392);
        try {
            CallChecker.varInit(this, "this", 266, 10000, 11392);
            CallChecker.varInit(pos, "pos", 266, 10000, 11392);
            CallChecker.varInit(toAppendTo, "toAppendTo", 266, 10000, 11392);
            CallChecker.varInit(obj, "obj", 266, 10000, 11392);
            CallChecker.varInit(this.realFormat, "realFormat", 266, 10000, 11392);
            CallChecker.varInit(this.imaginaryFormat, "imaginaryFormat", 266, 10000, 11392);
            CallChecker.varInit(this.imaginaryCharacter, "imaginaryCharacter", 266, 10000, 11392);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 266, 10000, 11392);
            StringBuffer ret = CallChecker.varInit(null, "ret", 270, 10878, 10901);
            if (obj instanceof Complex) {
                ret = format(((Complex) (obj)), toAppendTo, pos);
                CallChecker.varAssign(ret, "ret", 273, 10954, 10998);
            }else
                if (obj instanceof Number) {
                    if (CallChecker.beforeDeref(obj, Object.class, 275, 11090, 11092)) {
                        obj = CallChecker.beforeCalled(obj, Number.class, 275, 11090, 11092);
                        ret = format(new Complex(CallChecker.isCalled(((Number) (obj)), Number.class, 275, 11090, 11092).doubleValue(), 0.0), toAppendTo, pos);
                        CallChecker.varAssign(ret, "ret", 275, 11056, 11157);
                    }
                }else {
                    if (CallChecker.beforeDeref(obj, Object.class, 279, 11330, 11332)) {
                        obj = CallChecker.beforeCalled(obj, Object.class, 279, 11330, 11332);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(obj, Object.class, 279, 11330, 11332).getClass(), Class.class, 279, 11330, 11343)) {
                            obj = CallChecker.beforeCalled(obj, Object.class, 279, 11330, 11332);
                            throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_FORMAT_INSTANCE_AS_COMPLEX, CallChecker.isCalled(CallChecker.isCalled(obj, Object.class, 279, 11330, 11332).getClass(), Class.class, 279, 11330, 11343).getName());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3012.methodEnd();
        }
    }

    public String getImaginaryCharacter() {
        MethodContext _bcornu_methode_context3013 = new MethodContext(String.class, 289, 11399, 11571);
        try {
            CallChecker.varInit(this, "this", 289, 11399, 11571);
            CallChecker.varInit(this.realFormat, "realFormat", 289, 11399, 11571);
            CallChecker.varInit(this.imaginaryFormat, "imaginaryFormat", 289, 11399, 11571);
            CallChecker.varInit(this.imaginaryCharacter, "imaginaryCharacter", 289, 11399, 11571);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 289, 11399, 11571);
            return imaginaryCharacter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3013.methodEnd();
        }
    }

    public NumberFormat getImaginaryFormat() {
        MethodContext _bcornu_methode_context3014 = new MethodContext(NumberFormat.class, 297, 11578, 11744);
        try {
            CallChecker.varInit(this, "this", 297, 11578, 11744);
            CallChecker.varInit(this.realFormat, "realFormat", 297, 11578, 11744);
            CallChecker.varInit(this.imaginaryFormat, "imaginaryFormat", 297, 11578, 11744);
            CallChecker.varInit(this.imaginaryCharacter, "imaginaryCharacter", 297, 11578, 11744);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 297, 11578, 11744);
            return imaginaryFormat;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3014.methodEnd();
        }
    }

    public static ComplexFormat getInstance() {
        MethodContext _bcornu_methode_context3015 = new MethodContext(ComplexFormat.class, 305, 11751, 11973);
        try {
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 305, 11751, 11973);
            return ComplexFormat.getInstance(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((ComplexFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3015.methodEnd();
        }
    }

    public static ComplexFormat getInstance(Locale locale) {
        MethodContext _bcornu_methode_context3016 = new MethodContext(ComplexFormat.class, 314, 11980, 12356);
        try {
            CallChecker.varInit(locale, "locale", 314, 11980, 12356);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 314, 11980, 12356);
            NumberFormat f = CallChecker.varInit(CompositeFormat.getDefaultNumberFormat(locale), "f", 315, 12250, 12313);
            return new ComplexFormat(f);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ComplexFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3016.methodEnd();
        }
    }

    public static ComplexFormat getInstance(String imaginaryCharacter, Locale locale) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context3017 = new MethodContext(ComplexFormat.class, 329, 12363, 13073);
        try {
            CallChecker.varInit(locale, "locale", 329, 12363, 13073);
            CallChecker.varInit(imaginaryCharacter, "imaginaryCharacter", 329, 12363, 13073);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 329, 12363, 13073);
            NumberFormat f = CallChecker.varInit(CompositeFormat.getDefaultNumberFormat(locale), "f", 331, 12947, 13010);
            return new ComplexFormat(imaginaryCharacter, f);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ComplexFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3017.methodEnd();
        }
    }

    public NumberFormat getRealFormat() {
        MethodContext _bcornu_methode_context3018 = new MethodContext(NumberFormat.class, 339, 13080, 13226);
        try {
            CallChecker.varInit(this, "this", 339, 13080, 13226);
            CallChecker.varInit(this.realFormat, "realFormat", 339, 13080, 13226);
            CallChecker.varInit(this.imaginaryFormat, "imaginaryFormat", 339, 13080, 13226);
            CallChecker.varInit(this.imaginaryCharacter, "imaginaryCharacter", 339, 13080, 13226);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 339, 13080, 13226);
            return realFormat;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3018.methodEnd();
        }
    }

    public Complex parse(String source) throws MathParseException {
        MethodContext _bcornu_methode_context3019 = new MethodContext(Complex.class, 351, 13233, 13947);
        try {
            CallChecker.varInit(this, "this", 351, 13233, 13947);
            CallChecker.varInit(source, "source", 351, 13233, 13947);
            CallChecker.varInit(this.realFormat, "realFormat", 351, 13233, 13947);
            CallChecker.varInit(this.imaginaryFormat, "imaginaryFormat", 351, 13233, 13947);
            CallChecker.varInit(this.imaginaryCharacter, "imaginaryCharacter", 351, 13233, 13947);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 351, 13233, 13947);
            ParsePosition parsePosition = CallChecker.varInit(new ParsePosition(0), "parsePosition", 352, 13580, 13630);
            Complex result = CallChecker.varInit(parse(source, parsePosition), "result", 353, 13640, 13685);
            if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 354, 13699, 13711)) {
                parsePosition = CallChecker.beforeCalled(parsePosition, ParsePosition.class, 354, 13699, 13711);
                if ((CallChecker.isCalled(parsePosition, ParsePosition.class, 354, 13699, 13711).getIndex()) == 0) {
                    if (CallChecker.beforeDeref(parsePosition, ParsePosition.class, 356, 13822, 13834)) {
                        parsePosition = CallChecker.beforeCalled(parsePosition, ParsePosition.class, 356, 13822, 13834);
                        throw new MathParseException(source, CallChecker.isCalled(parsePosition, ParsePosition.class, 356, 13822, 13834).getErrorIndex(), Complex.class);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3019.methodEnd();
        }
    }

    public Complex parse(String source, ParsePosition pos) {
        MethodContext _bcornu_methode_context3020 = new MethodContext(Complex.class, 369, 13954, 16044);
        try {
            CallChecker.varInit(this, "this", 369, 13954, 16044);
            CallChecker.varInit(pos, "pos", 369, 13954, 16044);
            CallChecker.varInit(source, "source", 369, 13954, 16044);
            CallChecker.varInit(this.realFormat, "realFormat", 369, 13954, 16044);
            CallChecker.varInit(this.imaginaryFormat, "imaginaryFormat", 369, 13954, 16044);
            CallChecker.varInit(this.imaginaryCharacter, "imaginaryCharacter", 369, 13954, 16044);
            CallChecker.varInit(DEFAULT_IMAGINARY_CHARACTER, "org.apache.commons.math3.complex.ComplexFormat.DEFAULT_IMAGINARY_CHARACTER", 369, 13954, 16044);
            int initialIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 370, 14261, 14263)) {
                pos = CallChecker.beforeCalled(pos, ParsePosition.class, 370, 14261, 14263);
                initialIndex = CallChecker.isCalled(pos, ParsePosition.class, 370, 14261, 14263).getIndex();
                CallChecker.varAssign(initialIndex, "initialIndex", 370, 14261, 14263);
            }
            CompositeFormat.parseAndIgnoreWhitespace(source, pos);
            Number re = CallChecker.varInit(CompositeFormat.parseNumber(source, getRealFormat(), pos), "re", 376, 14400, 14469);
            if (re == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 380, 14620, 14622)) {
                    pos = CallChecker.beforeCalled(pos, ParsePosition.class, 380, 14620, 14622);
                    CallChecker.isCalled(pos, ParsePosition.class, 380, 14620, 14622).setIndex(initialIndex);
                }
                return null;
            }
            int startIndex = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 385, 14731, 14733)) {
                pos = CallChecker.beforeCalled(pos, ParsePosition.class, 385, 14731, 14733);
                startIndex = CallChecker.isCalled(pos, ParsePosition.class, 385, 14731, 14733).getIndex();
                CallChecker.varAssign(startIndex, "startIndex", 385, 14731, 14733);
            }
            char c = CallChecker.varInit(((char) (CompositeFormat.parseNextCharacter(source, pos))), "c", 386, 14755, 14811);
            int sign = CallChecker.varInit(((int) (0)), "sign", 387, 14821, 14833);
            switch (c) {
                case 0 :
                    return new Complex(re.doubleValue(), 0.0);
                case '-' :
                    sign = -1;
                    CallChecker.varAssign(sign, "sign", 394, 15029, 15038);
                    break;
                case '+' :
                    sign = 1;
                    CallChecker.varAssign(sign, "sign", 397, 15090, 15098);
                    break;
                default :
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 403, 15285, 15287)) {
                        pos = CallChecker.beforeCalled(pos, ParsePosition.class, 403, 15285, 15287);
                        CallChecker.isCalled(pos, ParsePosition.class, 403, 15285, 15287).setIndex(initialIndex);
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(pos, ParsePosition.class, 404, 15325, 15327)) {
                        pos = CallChecker.beforeCalled(pos, ParsePosition.class, 404, 15325, 15327);
                        CallChecker.isCalled(pos, ParsePosition.class, 404, 15325, 15327).setErrorIndex(startIndex);
                    }else
                        throw new AbnormalExecutionError();
                    
                    return null;
            }
            CompositeFormat.parseAndIgnoreWhitespace(source, pos);
            Number im = CallChecker.varInit(CompositeFormat.parseNumber(source, getRealFormat(), pos), "im", 412, 15519, 15588);
            if (im == null) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 416, 15744, 15746)) {
                    pos = CallChecker.beforeCalled(pos, ParsePosition.class, 416, 15744, 15746);
                    CallChecker.isCalled(pos, ParsePosition.class, 416, 15744, 15746).setIndex(initialIndex);
                }
                return null;
            }
            if (!(CompositeFormat.parseFixedstring(source, getImaginaryCharacter(), pos))) {
                return null;
            }
            return new Complex(re.doubleValue(), ((im.doubleValue()) * sign));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3020.methodEnd();
        }
    }
}

