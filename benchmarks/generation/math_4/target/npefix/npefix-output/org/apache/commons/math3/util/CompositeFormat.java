package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public class CompositeFormat {
    private CompositeFormat() {
        ConstructorContext _bcornu_methode_context502 = new ConstructorContext(CompositeFormat.class, 34, 1110, 1196);
        try {
        } finally {
            _bcornu_methode_context502.methodEnd();
        }
    }

    public static NumberFormat getDefaultNumberFormat() {
        MethodContext _bcornu_methode_context2277 = new MethodContext(NumberFormat.class, 42, 1203, 1589);
        try {
            return CompositeFormat.getDefaultNumberFormat(Locale.getDefault());
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2277.methodEnd();
        }
    }

    public static NumberFormat getDefaultNumberFormat(final Locale locale) {
        MethodContext _bcornu_methode_context2278 = new MethodContext(NumberFormat.class, 53, 1596, 2173);
        try {
            CallChecker.varInit(locale, "locale", 53, 1596, 2173);
            final NumberFormat nf = CallChecker.varInit(NumberFormat.getInstance(locale), "nf", 54, 2051, 2107);
            if (CallChecker.beforeDeref(nf, NumberFormat.class, 55, 2117, 2118)) {
                CallChecker.isCalled(nf, NumberFormat.class, 55, 2117, 2118).setMaximumFractionDigits(10);
            }
            return nf;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberFormat) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2278.methodEnd();
        }
    }

    public static void parseAndIgnoreWhitespace(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context2279 = new MethodContext(void.class, 66, 2180, 2695);
        try {
            CallChecker.varInit(pos, "pos", 66, 2180, 2695);
            CallChecker.varInit(source, "source", 66, 2180, 2695);
            CompositeFormat.parseNextCharacter(source, pos);
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 69, 2670, 2672)) {
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 69, 2657, 2659)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 69, 2657, 2659).setIndex(((CallChecker.isCalled(pos, ParsePosition.class, 69, 2670, 2672).getIndex()) - 1));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2279.methodEnd();
        }
    }

    public static char parseNextCharacter(final String source, final ParsePosition pos) {
        MethodContext _bcornu_methode_context2280 = new MethodContext(char.class, 79, 2702, 3489);
        try {
            CallChecker.varInit(pos, "pos", 79, 2702, 3489);
            CallChecker.varInit(source, "source", 79, 2702, 3489);
            int index = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 81, 3093, 3095)) {
                index = CallChecker.isCalled(pos, ParsePosition.class, 81, 3093, 3095).getIndex();
                CallChecker.varAssign(index, "index", 81, 3093, 3095);
            }
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(source, String.class, 82, 3132, 3137).length())), "n", 82, 3118, 3147);
            char ret = CallChecker.varInit(((char) (0)), "ret", 83, 3158, 3170);
            if (index < n) {
                char c = CallChecker.init(char.class);
                do {
                    if (CallChecker.beforeDeref(source, String.class, 88, 3259, 3264)) {
                        c = CallChecker.isCalled(source, String.class, 88, 3259, 3264).charAt((index++));
                        CallChecker.varAssign(c, "c", 88, 3255, 3281);
                    }
                } while ((Character.isWhitespace(c)) && (index < n) );
                if (CallChecker.beforeDeref(pos, ParsePosition.class, 90, 3359, 3361)) {
                    CallChecker.isCalled(pos, ParsePosition.class, 90, 3359, 3361).setIndex(index);
                }
                if (index < n) {
                    ret = c;
                    CallChecker.varAssign(ret, "ret", 93, 3428, 3435);
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Character) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2280.methodEnd();
        }
    }

    private static Number parseNumber(final String source, final double value, final ParsePosition pos) {
        MethodContext _bcornu_methode_context2281 = new MethodContext(Number.class, 109, 3496, 4503);
        try {
            CallChecker.varInit(pos, "pos", 109, 3496, 4503);
            CallChecker.varInit(value, "value", 109, 3496, 4503);
            CallChecker.varInit(source, "source", 109, 3496, 4503);
            Number ret = CallChecker.varInit(null, "ret", 111, 3995, 4012);
            StringBuilder sb = CallChecker.varInit(new StringBuilder(), "sb", 113, 4023, 4061);
            if (CallChecker.beforeDeref(sb, StringBuilder.class, 114, 4071, 4072)) {
                sb = CallChecker.beforeCalled(sb, StringBuilder.class, 114, 4071, 4072);
                CallChecker.isCalled(sb, StringBuilder.class, 114, 4071, 4072).append('(');
            }
            if (CallChecker.beforeDeref(sb, StringBuilder.class, 115, 4095, 4096)) {
                sb = CallChecker.beforeCalled(sb, StringBuilder.class, 115, 4095, 4096);
                CallChecker.isCalled(sb, StringBuilder.class, 115, 4095, 4096).append(value);
            }
            if (CallChecker.beforeDeref(sb, StringBuilder.class, 116, 4121, 4122)) {
                sb = CallChecker.beforeCalled(sb, StringBuilder.class, 116, 4121, 4122);
                CallChecker.isCalled(sb, StringBuilder.class, 116, 4121, 4122).append(')');
            }
            sb = CallChecker.beforeCalled(sb, StringBuilder.class, 118, 4160, 4161);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(sb, StringBuilder.class, 118, 4160, 4161).length())), "n", 118, 4146, 4171);
            final int startIndex = CallChecker.varInit(((int) (CallChecker.isCalled(pos, ParsePosition.class, 119, 4204, 4206).getIndex())), "startIndex", 119, 4181, 4218);
            final int endIndex = CallChecker.varInit(((int) (startIndex + n)), "endIndex", 120, 4228, 4263);
            if (CallChecker.beforeDeref(source, String.class, 121, 4288, 4293)) {
                if (CallChecker.beforeDeref(source, String.class, 122, 4319, 4324)) {
                    if (CallChecker.beforeDeref(sb, StringBuilder.class, 122, 4368, 4369)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(source, String.class, 122, 4319, 4324).substring(startIndex, endIndex), String.class, 122, 4319, 4356)) {
                            sb = CallChecker.beforeCalled(sb, StringBuilder.class, 122, 4368, 4369);
                            if ((endIndex < (CallChecker.isCalled(source, String.class, 121, 4288, 4293).length())) && ((CallChecker.isCalled(CallChecker.isCalled(source, String.class, 122, 4319, 4324).substring(startIndex, endIndex), String.class, 122, 4319, 4356).compareTo(CallChecker.isCalled(sb, StringBuilder.class, 122, 4368, 4369).toString())) == 0)) {
                                ret = Double.valueOf(value);
                                CallChecker.varAssign(ret, "ret", 123, 4403, 4430);
                                if (CallChecker.beforeDeref(pos, ParsePosition.class, 124, 4444, 4446)) {
                                    CallChecker.isCalled(pos, ParsePosition.class, 124, 4444, 4446).setIndex(endIndex);
                                }
                            }
                        }
                    }
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Number) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2281.methodEnd();
        }
    }

    public static Number parseNumber(final String source, final NumberFormat format, final ParsePosition pos) {
        MethodContext _bcornu_methode_context2282 = new MethodContext(Number.class, 140, 4510, 5762);
        try {
            CallChecker.varInit(pos, "pos", 140, 4510, 5762);
            CallChecker.varInit(format, "format", 140, 4510, 5762);
            CallChecker.varInit(source, "source", 140, 4510, 5762);
            final int startIndex = CallChecker.varInit(((int) (CallChecker.isCalled(pos, ParsePosition.class, 142, 5140, 5142).getIndex())), "startIndex", 142, 5117, 5154);
            Number number = CallChecker.init(Number.class);
            if (CallChecker.beforeDeref(format, NumberFormat.class, 143, 5180, 5185)) {
                number = CallChecker.isCalled(format, NumberFormat.class, 143, 5180, 5185).parse(source, pos);
                CallChecker.varAssign(number, "number", 143, 5180, 5185);
            }
            final int endIndex = CallChecker.varInit(((int) (CallChecker.isCalled(pos, ParsePosition.class, 144, 5236, 5238).getIndex())), "endIndex", 144, 5215, 5250);
            if (startIndex == endIndex) {
                final double[] special = CallChecker.varInit(new double[]{ Double.NaN , Double.POSITIVE_INFINITY , Double.NEGATIVE_INFINITY }, "special", 149, 5388, 5507);
                for (int i = 0; i < (CallChecker.isCalled(special, double[].class, 152, 5541, 5547).length); ++i) {
                    if (CallChecker.beforeDeref(special, double[].class, 153, 5609, 5615)) {
                        number = CompositeFormat.parseNumber(source, CallChecker.isCalled(special, double[].class, 153, 5609, 5615)[i], pos);
                        CallChecker.varAssign(number, "number", 153, 5580, 5625);
                    }
                    if (number != null) {
                        break;
                    }
                }
            }
            return number;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Number) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2282.methodEnd();
        }
    }

    public static boolean parseFixedstring(final String source, final String expected, final ParsePosition pos) {
        MethodContext _bcornu_methode_context2283 = new MethodContext(boolean.class, 170, 5769, 6792);
        try {
            CallChecker.varInit(pos, "pos", 170, 5769, 6792);
            CallChecker.varInit(expected, "expected", 170, 5769, 6792);
            CallChecker.varInit(source, "source", 170, 5769, 6792);
            final int startIndex = CallChecker.varInit(((int) (CallChecker.isCalled(pos, ParsePosition.class, 174, 6259, 6261).getIndex())), "startIndex", 174, 6236, 6273);
            final int endIndex = CallChecker.varInit(((int) (startIndex + (CallChecker.isCalled(expected, String.class, 175, 6317, 6324).length()))), "endIndex", 175, 6283, 6334);
            if (CallChecker.beforeDeref(source, String.class, 176, 6363, 6368)) {
                if (CallChecker.beforeDeref(source, String.class, 177, 6407, 6412)) {
                    if (CallChecker.beforeDeref(source, String.class, 178, 6440, 6445)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(source, String.class, 178, 6440, 6445).substring(startIndex, endIndex), String.class, 178, 6440, 6477)) {
                            if (((startIndex >= (CallChecker.isCalled(source, String.class, 176, 6363, 6368).length())) || (endIndex > (CallChecker.isCalled(source, String.class, 177, 6407, 6412).length()))) || ((CallChecker.isCalled(CallChecker.isCalled(source, String.class, 178, 6440, 6445).substring(startIndex, endIndex), String.class, 178, 6440, 6477).compareTo(expected)) != 0)) {
                                if (CallChecker.beforeDeref(pos, ParsePosition.class, 180, 6598, 6600)) {
                                    CallChecker.isCalled(pos, ParsePosition.class, 180, 6598, 6600).setIndex(startIndex);
                                }
                                if (CallChecker.beforeDeref(pos, ParsePosition.class, 181, 6636, 6638)) {
                                    CallChecker.isCalled(pos, ParsePosition.class, 181, 6636, 6638).setErrorIndex(startIndex);
                                }
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(pos, ParsePosition.class, 186, 6743, 6745)) {
                CallChecker.isCalled(pos, ParsePosition.class, 186, 6743, 6745).setIndex(endIndex);
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2283.methodEnd();
        }
    }

    public static StringBuffer formatDouble(final double value, final NumberFormat format, final StringBuffer toAppendTo, final FieldPosition pos) {
        MethodContext _bcornu_methode_context2284 = new MethodContext(StringBuffer.class, 207, 6799, 8035);
        try {
            CallChecker.varInit(pos, "pos", 207, 6799, 8035);
            CallChecker.varInit(toAppendTo, "toAppendTo", 207, 6799, 8035);
            CallChecker.varInit(format, "format", 207, 6799, 8035);
            CallChecker.varInit(value, "value", 207, 6799, 8035);
            if ((Double.isNaN(value)) || (Double.isInfinite(value))) {
                if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 211, 7828, 7837)) {
                    CallChecker.isCalled(toAppendTo, StringBuffer.class, 211, 7828, 7837).append('(');
                }
                if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 212, 7864, 7873)) {
                    CallChecker.isCalled(toAppendTo, StringBuffer.class, 212, 7864, 7873).append(value);
                }
                if (CallChecker.beforeDeref(toAppendTo, StringBuffer.class, 213, 7902, 7911)) {
                    CallChecker.isCalled(toAppendTo, StringBuffer.class, 213, 7902, 7911).append(')');
                }
            }else {
                if (CallChecker.beforeDeref(format, NumberFormat.class, 215, 7955, 7960)) {
                    CallChecker.isCalled(format, NumberFormat.class, 215, 7955, 7960).format(value, toAppendTo, pos);
                }
            }
            return toAppendTo;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuffer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2284.methodEnd();
        }
    }
}

