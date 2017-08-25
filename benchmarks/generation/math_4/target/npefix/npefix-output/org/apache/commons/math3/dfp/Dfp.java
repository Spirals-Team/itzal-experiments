package org.apache.commons.math3.dfp;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_CEIL;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_DOWN;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_FLOOR;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_HALF_DOWN;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_HALF_EVEN;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_HALF_ODD;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_HALF_UP;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_UP;

public class Dfp implements RealFieldElement<Dfp> {
    public static final int RADIX = 10000;

    public static final int MIN_EXP = -32767;

    public static final int MAX_EXP = 32768;

    public static final int ERR_SCALE = 32760;

    public static final byte FINITE = 0;

    public static final byte INFINITE = 1;

    public static final byte SNAN = 2;

    public static final byte QNAN = 3;

    private static final String NAN_STRING = "NaN";

    private static final String POS_INFINITY_STRING = "Infinity";

    private static final String NEG_INFINITY_STRING = "-Infinity";

    private static final String ADD_TRAP = "add";

    private static final String MULTIPLY_TRAP = "multiply";

    private static final String DIVIDE_TRAP = "divide";

    private static final String SQRT_TRAP = "sqrt";

    private static final String ALIGN_TRAP = "align";

    private static final String TRUNC_TRAP = "trunc";

    private static final String NEXT_AFTER_TRAP = "nextAfter";

    private static final String LESS_THAN_TRAP = "lessThan";

    private static final String GREATER_THAN_TRAP = "greaterThan";

    private static final String NEW_INSTANCE_TRAP = "newInstance";

    protected int[] mant;

    protected byte sign;

    protected int exp;

    protected byte nans;

    private final DfpField field;

    protected Dfp(final DfpField field) {
        ConstructorContext _bcornu_methode_context899 = new ConstructorContext(Dfp.class, 183, 7132, 7421);
        try {
            if (CallChecker.beforeDeref(field, DfpField.class, 184, 7306, 7310)) {
                mant = new int[CallChecker.isCalled(field, DfpField.class, 184, 7306, 7310).getRadixDigits()];
                CallChecker.varAssign(this.mant, "this.mant", 184, 7291, 7329);
            }
            sign = 1;
            CallChecker.varAssign(this.sign, "this.sign", 185, 7339, 7347);
            exp = 0;
            CallChecker.varAssign(this.exp, "this.exp", 186, 7357, 7364);
            nans = Dfp.FINITE;
            CallChecker.varAssign(this.nans, "this.nans", 187, 7374, 7387);
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 188, 7397, 7415);
        } finally {
            _bcornu_methode_context899.methodEnd();
        }
    }

    protected Dfp(final DfpField field, byte x) {
        this(field, ((long) (x)));
        ConstructorContext _bcornu_methode_context900 = new ConstructorContext(Dfp.class, 195, 7428, 7668);
        try {
        } finally {
            _bcornu_methode_context900.methodEnd();
        }
    }

    protected Dfp(final DfpField field, int x) {
        this(field, ((long) (x)));
        ConstructorContext _bcornu_methode_context901 = new ConstructorContext(Dfp.class, 203, 7675, 7914);
        try {
        } finally {
            _bcornu_methode_context901.methodEnd();
        }
    }

    protected Dfp(final DfpField field, long x) {
        ConstructorContext _bcornu_methode_context902 = new ConstructorContext(Dfp.class, 211, 7921, 9253);
        try {
            if (CallChecker.beforeDeref(field, DfpField.class, 214, 8180, 8184)) {
                mant = new int[CallChecker.isCalled(field, DfpField.class, 214, 8180, 8184).getRadixDigits()];
                CallChecker.varAssign(this.mant, "this.mant", 214, 8165, 8203);
            }
            nans = Dfp.FINITE;
            CallChecker.varAssign(this.nans, "this.nans", 215, 8213, 8226);
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 216, 8236, 8254);
            boolean isLongMin = CallChecker.varInit(((boolean) (false)), "isLongMin", 218, 8265, 8290);
            if (x == (Long.MIN_VALUE)) {
                isLongMin = true;
                CallChecker.varAssign(isLongMin, "isLongMin", 222, 8474, 8490);
                ++x;
            }
            if (x < 0) {
                sign = -1;
                CallChecker.varAssign(this.sign, "this.sign", 228, 8577, 8586);
                x = -x;
                CallChecker.varAssign(x, "x", 229, 8600, 8606);
            }else {
                sign = 1;
                CallChecker.varAssign(this.sign, "this.sign", 231, 8637, 8645);
            }
            exp = 0;
            CallChecker.varAssign(this.exp, "this.exp", 234, 8666, 8673);
            while (x != 0) {
                if (CallChecker.beforeDeref(mant, int[].class, 236, 8735, 8738)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 236, 8760, 8763)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 236, 8735, 8738);
                        mant = CallChecker.beforeCalled(mant, int[].class, 236, 8760, 8763);
                        System.arraycopy(mant, ((CallChecker.isCalled(mant, int[].class, 236, 8735, 8738).length) - (exp)), mant, (((CallChecker.isCalled(mant, int[].class, 236, 8760, 8763).length) - 1) - (exp)), exp);
                    }
                }
                if (CallChecker.beforeDeref(mant, int[].class, 237, 8806, 8809)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 237, 8801, 8804)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 237, 8806, 8809);
                        mant = CallChecker.beforeCalled(mant, int[].class, 237, 8801, 8804);
                        CallChecker.isCalled(mant, int[].class, 237, 8801, 8804)[((CallChecker.isCalled(mant, int[].class, 237, 8806, 8809).length) - 1)] = ((int) (x % (Dfp.RADIX)));
                        CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 237, 8801, 8804)[((CallChecker.isCalled(this.mant, int[].class, 237, 8806, 8809).length) - 1)], "CallChecker.isCalled(this.mant, int[].class, 237, 8801, 8804)[((CallChecker.isCalled(this.mant, int[].class, 237, 8806, 8809).length) - 1)]", 237, 8801, 8842);
                    }
                }
                x /= Dfp.RADIX;
                CallChecker.varAssign(x, "x", 238, 8856, 8866);
                (exp)++;
            } 
            if (isLongMin) {
                mant = CallChecker.beforeCalled(mant, int[].class, 245, 9089, 9092);
                for (int i = 0; i < ((CallChecker.isCalled(mant, int[].class, 245, 9089, 9092).length) - 1); i++) {
                    if (CallChecker.beforeDeref(mant, int[].class, 246, 9133, 9136)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 246, 9133, 9136);
                        if ((CallChecker.isCalled(mant, int[].class, 246, 9133, 9136)[i]) != 0) {
                            if (CallChecker.beforeDeref(mant, int[].class, 247, 9169, 9172)) {
                                mant = CallChecker.beforeCalled(mant, int[].class, 247, 9169, 9172);
                                (CallChecker.isCalled(mant, int[].class, 247, 9169, 9172)[i])++;
                            }
                            break;
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context902.methodEnd();
        }
    }

    protected Dfp(final DfpField field, double x) {
        ConstructorContext _bcornu_methode_context903 = new ConstructorContext(Dfp.class, 258, 9260, 11211);
        try {
            if (CallChecker.beforeDeref(field, DfpField.class, 261, 9523, 9527)) {
                mant = new int[CallChecker.isCalled(field, DfpField.class, 261, 9523, 9527).getRadixDigits()];
                CallChecker.varAssign(this.mant, "this.mant", 261, 9508, 9546);
            }
            sign = 1;
            CallChecker.varAssign(this.sign, "this.sign", 262, 9556, 9564);
            exp = 0;
            CallChecker.varAssign(this.exp, "this.exp", 263, 9574, 9581);
            nans = Dfp.FINITE;
            CallChecker.varAssign(this.nans, "this.nans", 264, 9591, 9604);
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 265, 9614, 9632);
            long bits = CallChecker.varInit(((long) (Double.doubleToLongBits(x))), "bits", 267, 9643, 9681);
            long mantissa = CallChecker.varInit(((long) (bits & 4503599627370495L)), "mantissa", 268, 9691, 9733);
            int exponent = CallChecker.varInit(((int) (((int) ((bits & 9218868437227405312L) >> 52)) - 1023)), "exponent", 269, 9743, 9807);
            if (exponent == (-1023)) {
                if (x == 0) {
                    if ((bits & -9223372036854775808L) != 0) {
                        sign = -1;
                        CallChecker.varAssign(this.sign, "this.sign", 276, 10030, 10039);
                    }
                    return ;
                }
                exponent++;
                while ((mantissa & 4503599627370496L) == 0) {
                    exponent--;
                    mantissa <<= 1;
                    CallChecker.varAssign(mantissa, "mantissa", 286, 10274, 10288);
                } 
                mantissa &= 4503599627370495L;
                CallChecker.varAssign(mantissa, "mantissa", 288, 10316, 10347);
            }
            if (exponent == 1024) {
                if (x != x) {
                    sign = ((byte) (1));
                    CallChecker.varAssign(this.sign, "this.sign", 294, 10465, 10480);
                    nans = Dfp.QNAN;
                    CallChecker.varAssign(this.nans, "this.nans", 295, 10498, 10509);
                }else
                    if (x < 0) {
                        sign = ((byte) (-1));
                        CallChecker.varAssign(this.sign, "this.sign", 297, 10559, 10575);
                        nans = Dfp.INFINITE;
                        CallChecker.varAssign(this.nans, "this.nans", 298, 10593, 10608);
                    }else {
                        sign = ((byte) (1));
                        CallChecker.varAssign(this.sign, "this.sign", 300, 10647, 10662);
                        nans = Dfp.INFINITE;
                        CallChecker.varAssign(this.nans, "this.nans", 301, 10680, 10695);
                    }
                
                return ;
            }
            Dfp xdfp = CallChecker.varInit(new Dfp(field, mantissa), "xdfp", 306, 10750, 10785);
            if (CallChecker.beforeDeref(xdfp, Dfp.class, 307, 10802, 10805)) {
                if (CallChecker.beforeDeref(field, DfpField.class, 307, 10853, 10857)) {
                    xdfp = CallChecker.beforeCalled(xdfp, Dfp.class, 307, 10802, 10805);
                    final Dfp npe_invocation_var845 = CallChecker.isCalled(xdfp, Dfp.class, 307, 10802, 10805).divide(new Dfp(field, 4503599627370496L));
                    if (CallChecker.beforeDeref(npe_invocation_var845, Dfp.class, 307, 10802, 10847)) {
                        xdfp = CallChecker.isCalled(npe_invocation_var845, Dfp.class, 307, 10802, 10847).add(CallChecker.isCalled(field, DfpField.class, 307, 10853, 10857).getOne());
                        CallChecker.varAssign(xdfp, "xdfp", 307, 10795, 10868);
                    }
                }
            }
            if (CallChecker.beforeDeref(field, DfpField.class, 308, 10944, 10948)) {
                if (CallChecker.beforeDeref(xdfp, Dfp.class, 308, 10918, 10921)) {
                    xdfp = CallChecker.beforeCalled(xdfp, Dfp.class, 308, 10918, 10921);
                    xdfp = CallChecker.isCalled(xdfp, Dfp.class, 308, 10918, 10921).multiply(DfpMath.pow(CallChecker.isCalled(field, DfpField.class, 308, 10944, 10948).getTwo(), exponent));
                    CallChecker.varAssign(xdfp, "xdfp", 308, 10911, 10970);
                }
            }
            if ((bits & -9223372036854775808L) != 0) {
                if (CallChecker.beforeDeref(xdfp, Dfp.class, 311, 11041, 11044)) {
                    xdfp = CallChecker.beforeCalled(xdfp, Dfp.class, 311, 11041, 11044);
                    xdfp = CallChecker.isCalled(xdfp, Dfp.class, 311, 11041, 11044).negate();
                    CallChecker.varAssign(xdfp, "xdfp", 311, 11034, 11054);
                }
            }
            if (CallChecker.beforeDeref(xdfp, Dfp.class, 314, 11092, 11095)) {
                if (CallChecker.beforeDeref(mant, int[].class, 314, 11115, 11118)) {
                    xdfp = CallChecker.beforeCalled(xdfp, Dfp.class, 314, 11092, 11095);
                    mant = CallChecker.beforeCalled(mant, int[].class, 314, 11115, 11118);
                    System.arraycopy(CallChecker.isCalled(xdfp, Dfp.class, 314, 11092, 11095).mant, 0, mant, 0, CallChecker.isCalled(mant, int[].class, 314, 11115, 11118).length);
                }
            }
            if (CallChecker.beforeDeref(xdfp, Dfp.class, 315, 11144, 11147)) {
                xdfp = CallChecker.beforeCalled(xdfp, Dfp.class, 315, 11144, 11147);
                sign = CallChecker.isCalled(xdfp, Dfp.class, 315, 11144, 11147).sign;
                CallChecker.varAssign(this.sign, "this.sign", 315, 11137, 11153);
            }
            if (CallChecker.beforeDeref(xdfp, Dfp.class, 316, 11170, 11173)) {
                xdfp = CallChecker.beforeCalled(xdfp, Dfp.class, 316, 11170, 11173);
                exp = CallChecker.isCalled(xdfp, Dfp.class, 316, 11170, 11173).exp;
                CallChecker.varAssign(this.exp, "this.exp", 316, 11163, 11178);
            }
            if (CallChecker.beforeDeref(xdfp, Dfp.class, 317, 11195, 11198)) {
                xdfp = CallChecker.beforeCalled(xdfp, Dfp.class, 317, 11195, 11198);
                nans = CallChecker.isCalled(xdfp, Dfp.class, 317, 11195, 11198).nans;
                CallChecker.varAssign(this.nans, "this.nans", 317, 11188, 11204);
            }
        } finally {
            _bcornu_methode_context903.methodEnd();
        }
    }

    public Dfp(final Dfp d) {
        ConstructorContext _bcornu_methode_context904 = new ConstructorContext(Dfp.class, 324, 11218, 11443);
        try {
            if (CallChecker.beforeDeref(d, Dfp.class, 325, 11327, 11327)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(d, Dfp.class, 325, 11327, 11327).mant, int[].class, 325, 11327, 11332)) {
                    CallChecker.isCalled(d, Dfp.class, 325, 11327, 11327).mant = CallChecker.beforeCalled(CallChecker.isCalled(d, Dfp.class, 325, 11327, 11327).mant, int[].class, 325, 11327, 11332);
                    mant = CallChecker.isCalled(CallChecker.isCalled(d, Dfp.class, 325, 11327, 11327).mant, int[].class, 325, 11327, 11332).clone();
                    CallChecker.varAssign(this.mant, "this.mant", 325, 11319, 11341);
                }
            }
            if (CallChecker.beforeDeref(d, Dfp.class, 326, 11359, 11359)) {
                sign = CallChecker.isCalled(d, Dfp.class, 326, 11359, 11359).sign;
                CallChecker.varAssign(this.sign, "this.sign", 326, 11351, 11365);
            }
            if (CallChecker.beforeDeref(d, Dfp.class, 327, 11383, 11383)) {
                exp = CallChecker.isCalled(d, Dfp.class, 327, 11383, 11383).exp;
                CallChecker.varAssign(this.exp, "this.exp", 327, 11375, 11388);
            }
            if (CallChecker.beforeDeref(d, Dfp.class, 328, 11406, 11406)) {
                nans = CallChecker.isCalled(d, Dfp.class, 328, 11406, 11406).nans;
                CallChecker.varAssign(this.nans, "this.nans", 328, 11398, 11412);
            }
            field = CallChecker.isCalled(d, Dfp.class, 329, 11430, 11430).field;
            CallChecker.varAssign(this.field, "this.field", 329, 11422, 11437);
        } finally {
            _bcornu_methode_context904.methodEnd();
        }
    }

    protected Dfp(final DfpField field, final String s) {
        ConstructorContext _bcornu_methode_context905 = new ConstructorContext(Dfp.class, 336, 11450, 17117);
        try {
            if (CallChecker.beforeDeref(field, DfpField.class, 339, 11734, 11738)) {
                mant = new int[CallChecker.isCalled(field, DfpField.class, 339, 11734, 11738).getRadixDigits()];
                CallChecker.varAssign(this.mant, "this.mant", 339, 11719, 11757);
            }
            sign = 1;
            CallChecker.varAssign(this.sign, "this.sign", 340, 11767, 11775);
            exp = 0;
            CallChecker.varAssign(this.exp, "this.exp", 341, 11785, 11792);
            nans = Dfp.FINITE;
            CallChecker.varAssign(this.nans, "this.nans", 342, 11802, 11815);
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 343, 11825, 11843);
            boolean decimalFound = CallChecker.varInit(((boolean) (false)), "decimalFound", 345, 11854, 11882);
            final int rsize = CallChecker.varInit(((int) (4)), "rsize", 346, 11892, 11911);
            final int offset = CallChecker.varInit(((int) (4)), "offset", 347, 11958, 11978);
            final char[] striped = CallChecker.varInit(new char[((getRadixDigits()) * rsize) + (offset * 2)], "striped", 348, 12021, 12091);
            if (CallChecker.beforeDeref(s, String.class, 351, 12142, 12142)) {
                if (CallChecker.isCalled(s, String.class, 351, 12142, 12142).equals(Dfp.POS_INFINITY_STRING)) {
                    sign = ((byte) (1));
                    CallChecker.varAssign(this.sign, "this.sign", 352, 12187, 12202);
                    nans = Dfp.INFINITE;
                    CallChecker.varAssign(this.nans, "this.nans", 353, 12216, 12231);
                    return ;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(s, String.class, 357, 12276, 12276)) {
                if (CallChecker.isCalled(s, String.class, 357, 12276, 12276).equals(Dfp.NEG_INFINITY_STRING)) {
                    sign = ((byte) (-1));
                    CallChecker.varAssign(this.sign, "this.sign", 358, 12321, 12337);
                    nans = Dfp.INFINITE;
                    CallChecker.varAssign(this.nans, "this.nans", 359, 12351, 12366);
                    return ;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(s, String.class, 363, 12411, 12411)) {
                if (CallChecker.isCalled(s, String.class, 363, 12411, 12411).equals(Dfp.NAN_STRING)) {
                    sign = ((byte) (1));
                    CallChecker.varAssign(this.sign, "this.sign", 364, 12447, 12462);
                    nans = Dfp.QNAN;
                    CallChecker.varAssign(this.nans, "this.nans", 365, 12476, 12487);
                    return ;
                }
            }else
                throw new AbnormalExecutionError();
            
            int p = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(s, String.class, 370, 12577, 12577)) {
                p = CallChecker.isCalled(s, String.class, 370, 12577, 12577).indexOf("e");
                CallChecker.varAssign(p, "p", 370, 12577, 12577);
            }
            if (p == (-1)) {
                if (CallChecker.beforeDeref(s, String.class, 372, 12651, 12651)) {
                    p = CallChecker.isCalled(s, String.class, 372, 12651, 12651).indexOf("E");
                    CallChecker.varAssign(p, "p", 372, 12647, 12665);
                }
            }
            String fpdecimal = CallChecker.init(String.class);
            int sciexp = CallChecker.varInit(((int) (0)), "sciexp", 376, 12718, 12732);
            if (p != (-1)) {
                if (CallChecker.beforeDeref(s, String.class, 379, 12816, 12816)) {
                    fpdecimal = CallChecker.isCalled(s, String.class, 379, 12816, 12816).substring(0, p);
                    CallChecker.varAssign(fpdecimal, "fpdecimal", 379, 12804, 12833);
                }
                String fpexp = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(s, String.class, 380, 12862, 12862)) {
                    fpexp = CallChecker.isCalled(s, String.class, 380, 12862, 12862).substring((p + 1));
                    CallChecker.varAssign(fpexp, "fpexp", 380, 12862, 12862);
                }
                boolean negative = CallChecker.varInit(((boolean) (false)), "negative", 381, 12892, 12916);
                fpexp = CallChecker.beforeCalled(fpexp, String.class, 383, 12947, 12951);
                for (int i = 0; i < (CallChecker.isCalled(fpexp, String.class, 383, 12947, 12951).length()); i++) {
                    if (CallChecker.beforeDeref(fpexp, String.class, 385, 13002, 13006)) {
                        fpexp = CallChecker.beforeCalled(fpexp, String.class, 385, 13002, 13006);
                        if ((CallChecker.isCalled(fpexp, String.class, 385, 13002, 13006).charAt(i)) == '-') {
                            negative = true;
                            CallChecker.varAssign(negative, "negative", 387, 13064, 13079);
                            continue;
                        }
                    }
                    if (CallChecker.beforeDeref(fpexp, String.class, 390, 13149, 13153)) {
                        if (CallChecker.beforeDeref(fpexp, String.class, 390, 13175, 13179)) {
                            fpexp = CallChecker.beforeCalled(fpexp, String.class, 390, 13149, 13153);
                            fpexp = CallChecker.beforeCalled(fpexp, String.class, 390, 13175, 13179);
                            if (((CallChecker.isCalled(fpexp, String.class, 390, 13149, 13153).charAt(i)) >= '0') && ((CallChecker.isCalled(fpexp, String.class, 390, 13175, 13179).charAt(i)) <= '9')) {
                                if (CallChecker.beforeDeref(fpexp, String.class, 391, 13244, 13248)) {
                                    fpexp = CallChecker.beforeCalled(fpexp, String.class, 391, 13244, 13248);
                                    sciexp = ((sciexp * 10) + (CallChecker.isCalled(fpexp, String.class, 391, 13244, 13248).charAt(i))) - '0';
                                    CallChecker.varAssign(sciexp, "sciexp", 391, 13221, 13265);
                                }
                            }
                        }
                    }
                }
                if (negative) {
                    sciexp = -sciexp;
                    CallChecker.varAssign(sciexp, "sciexp", 396, 13344, 13360);
                }
            }else {
                fpdecimal = s;
                CallChecker.varAssign(fpdecimal, "fpdecimal", 400, 13432, 13445);
            }
            if (CallChecker.beforeDeref(fpdecimal, String.class, 404, 13540, 13548)) {
                fpdecimal = CallChecker.beforeCalled(fpdecimal, String.class, 404, 13540, 13548);
                if ((CallChecker.isCalled(fpdecimal, String.class, 404, 13540, 13548).indexOf("-")) != (-1)) {
                    sign = -1;
                    CallChecker.varAssign(this.sign, "this.sign", 405, 13585, 13594);
                }
            }
            p = 0;
            CallChecker.varAssign(p, "p", 409, 13707, 13712);
            int decimalPos = CallChecker.varInit(((int) (0)), "decimalPos", 412, 13768, 13786);
            for (; ;) {
                if (CallChecker.beforeDeref(fpdecimal, String.class, 414, 13823, 13831)) {
                    if (CallChecker.beforeDeref(fpdecimal, String.class, 414, 13853, 13861)) {
                        fpdecimal = CallChecker.beforeCalled(fpdecimal, String.class, 414, 13823, 13831);
                        fpdecimal = CallChecker.beforeCalled(fpdecimal, String.class, 414, 13853, 13861);
                        if (((CallChecker.isCalled(fpdecimal, String.class, 414, 13823, 13831).charAt(p)) >= '1') && ((CallChecker.isCalled(fpdecimal, String.class, 414, 13853, 13861).charAt(p)) <= '9')) {
                            break;
                        }
                    }
                }
                if (CallChecker.beforeDeref(fpdecimal, String.class, 418, 13953, 13961)) {
                    fpdecimal = CallChecker.beforeCalled(fpdecimal, String.class, 418, 13953, 13961);
                    if (decimalFound && ((CallChecker.isCalled(fpdecimal, String.class, 418, 13953, 13961).charAt(p)) == '0')) {
                        decimalPos--;
                    }
                }
                if (CallChecker.beforeDeref(fpdecimal, String.class, 422, 14044, 14052)) {
                    fpdecimal = CallChecker.beforeCalled(fpdecimal, String.class, 422, 14044, 14052);
                    if ((CallChecker.isCalled(fpdecimal, String.class, 422, 14044, 14052).charAt(p)) == '.') {
                        decimalFound = true;
                        CallChecker.varAssign(decimalFound, "decimalFound", 423, 14090, 14109);
                    }
                }
                p++;
                if (CallChecker.beforeDeref(fpdecimal, String.class, 428, 14165, 14173)) {
                    fpdecimal = CallChecker.beforeCalled(fpdecimal, String.class, 428, 14165, 14173);
                    if (p == (CallChecker.isCalled(fpdecimal, String.class, 428, 14165, 14173).length())) {
                        break;
                    }
                }
            }
            int q = CallChecker.varInit(((int) (offset)), "q", 434, 14284, 14298);
            if (CallChecker.beforeDeref(striped, char[].class, 435, 14308, 14314)) {
                CallChecker.isCalled(striped, char[].class, 435, 14308, 14314)[0] = '0';
                CallChecker.varAssign(CallChecker.isCalled(striped, char[].class, 435, 14308, 14314)[0], "CallChecker.isCalled(striped, char[].class, 435, 14308, 14314)[0]", 435, 14308, 14324);
            }
            if (CallChecker.beforeDeref(striped, char[].class, 436, 14334, 14340)) {
                CallChecker.isCalled(striped, char[].class, 436, 14334, 14340)[1] = '0';
                CallChecker.varAssign(CallChecker.isCalled(striped, char[].class, 436, 14334, 14340)[1], "CallChecker.isCalled(striped, char[].class, 436, 14334, 14340)[1]", 436, 14334, 14350);
            }
            if (CallChecker.beforeDeref(striped, char[].class, 437, 14360, 14366)) {
                CallChecker.isCalled(striped, char[].class, 437, 14360, 14366)[2] = '0';
                CallChecker.varAssign(CallChecker.isCalled(striped, char[].class, 437, 14360, 14366)[2], "CallChecker.isCalled(striped, char[].class, 437, 14360, 14366)[2]", 437, 14360, 14376);
            }
            if (CallChecker.beforeDeref(striped, char[].class, 438, 14386, 14392)) {
                CallChecker.isCalled(striped, char[].class, 438, 14386, 14392)[3] = '0';
                CallChecker.varAssign(CallChecker.isCalled(striped, char[].class, 438, 14386, 14392)[3], "CallChecker.isCalled(striped, char[].class, 438, 14386, 14392)[3]", 438, 14386, 14402);
            }
            int significantDigits = CallChecker.varInit(((int) (0)), "significantDigits", 439, 14412, 14435);
            for (; ;) {
                if (CallChecker.beforeDeref(fpdecimal, String.class, 441, 14477, 14485)) {
                    fpdecimal = CallChecker.beforeCalled(fpdecimal, String.class, 441, 14477, 14485);
                    if (p == (CallChecker.isCalled(fpdecimal, String.class, 441, 14477, 14485).length())) {
                        break;
                    }
                }
                if (CallChecker.beforeDeref(mant, int[].class, 446, 14618, 14621)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 446, 14618, 14621);
                    if (q == ((((CallChecker.isCalled(mant, int[].class, 446, 14618, 14621).length) * rsize) + offset) + 1)) {
                        break;
                    }
                }
                if (CallChecker.beforeDeref(fpdecimal, String.class, 450, 14702, 14710)) {
                    fpdecimal = CallChecker.beforeCalled(fpdecimal, String.class, 450, 14702, 14710);
                    if ((CallChecker.isCalled(fpdecimal, String.class, 450, 14702, 14710).charAt(p)) == '.') {
                        decimalFound = true;
                        CallChecker.varAssign(decimalFound, "decimalFound", 451, 14748, 14767);
                        decimalPos = significantDigits;
                        CallChecker.varAssign(decimalPos, "decimalPos", 452, 14785, 14815);
                        p++;
                        continue;
                    }
                }
                if (CallChecker.beforeDeref(fpdecimal, String.class, 457, 14895, 14903)) {
                    if (CallChecker.beforeDeref(fpdecimal, String.class, 457, 14924, 14932)) {
                        fpdecimal = CallChecker.beforeCalled(fpdecimal, String.class, 457, 14895, 14903);
                        fpdecimal = CallChecker.beforeCalled(fpdecimal, String.class, 457, 14924, 14932);
                        if (((CallChecker.isCalled(fpdecimal, String.class, 457, 14895, 14903).charAt(p)) < '0') || ((CallChecker.isCalled(fpdecimal, String.class, 457, 14924, 14932).charAt(p)) > '9')) {
                            p++;
                            continue;
                        }
                    }
                }
                if (CallChecker.beforeDeref(striped, char[].class, 462, 15027, 15033)) {
                    if (CallChecker.beforeDeref(fpdecimal, String.class, 462, 15040, 15048)) {
                        fpdecimal = CallChecker.beforeCalled(fpdecimal, String.class, 462, 15040, 15048);
                        CallChecker.isCalled(striped, char[].class, 462, 15027, 15033)[q] = CallChecker.isCalled(fpdecimal, String.class, 462, 15040, 15048).charAt(p);
                        CallChecker.varAssign(CallChecker.isCalled(striped, char[].class, 462, 15027, 15033)[q], "CallChecker.isCalled(striped, char[].class, 462, 15027, 15033)[q]", 462, 15027, 15059);
                    }
                }
                q++;
                p++;
                significantDigits++;
            }
            if (decimalFound && (q != offset)) {
                for (; ;) {
                    q--;
                    if (q == offset) {
                        break;
                    }
                    if (CallChecker.beforeDeref(striped, char[].class, 476, 15406, 15412)) {
                        if ((CallChecker.isCalled(striped, char[].class, 476, 15406, 15412)[q]) == '0') {
                            significantDigits--;
                        }else {
                            break;
                        }
                    }
                }
            }
            if (decimalFound && (significantDigits == 0)) {
                decimalPos = 0;
                CallChecker.varAssign(decimalPos, "decimalPos", 486, 15679, 15693);
            }
            if (!decimalFound) {
                decimalPos = q - offset;
                CallChecker.varAssign(decimalPos, "decimalPos", 491, 15813, 15834);
            }
            q = offset;
            CallChecker.varAssign(q, "q", 495, 15912, 15922);
            p = (significantDigits - 1) + offset;
            CallChecker.varAssign(p, "p", 496, 15970, 16000);
            while (p > q) {
                if (CallChecker.beforeDeref(striped, char[].class, 499, 16043, 16049)) {
                    if ((CallChecker.isCalled(striped, char[].class, 499, 16043, 16049)[p]) != '0') {
                        break;
                    }
                }
                p--;
            } 
            int i = CallChecker.varInit(((int) ((((rsize * 100) - decimalPos) - (sciexp % rsize)) % rsize)), "i", 506, 16197, 16258);
            q -= i;
            CallChecker.varAssign(q, "q", 507, 16268, 16274);
            decimalPos += i;
            CallChecker.varAssign(decimalPos, "decimalPos", 508, 16284, 16299);
            mant = CallChecker.beforeCalled(mant, int[].class, 511, 16410, 16413);
            while ((p - q) < ((CallChecker.isCalled(mant, int[].class, 511, 16410, 16413).length) * rsize)) {
                for (i = 0; i < rsize; i++) {
                    CallChecker.varAssign(i, "i", 512, 16451, 16455);
                    if (CallChecker.beforeDeref(striped, char[].class, 513, 16492, 16498)) {
                        CallChecker.isCalled(striped, char[].class, 513, 16492, 16498)[(++p)] = '0';
                        CallChecker.varAssign(CallChecker.isCalled(striped, char[].class, 513, 16492, 16498)[p], "CallChecker.isCalled(striped, char[].class, 513, 16492, 16498)[p]", 513, 16492, 16510);
                    }
                }
            } 
            mant = CallChecker.beforeCalled(mant, int[].class, 519, 16668, 16671);
            for (i = (CallChecker.isCalled(mant, int[].class, 519, 16668, 16671).length) - 1; i >= 0; i--) {
                CallChecker.varAssign(i, "i", 519, 16664, 16682);
                if (CallChecker.beforeDeref(mant, int[].class, 520, 16712, 16715)) {
                    if (CallChecker.beforeDeref(striped, char[].class, 520, 16723, 16729)) {
                        if (CallChecker.beforeDeref(striped, char[].class, 521, 16775, 16781)) {
                            if (CallChecker.beforeDeref(striped, char[].class, 522, 16827, 16833)) {
                                if (CallChecker.beforeDeref(striped, char[].class, 523, 16879, 16885)) {
                                    mant = CallChecker.beforeCalled(mant, int[].class, 520, 16712, 16715);
                                    CallChecker.isCalled(mant, int[].class, 520, 16712, 16715)[i] = (((((CallChecker.isCalled(striped, char[].class, 520, 16723, 16729)[q]) - '0') * 1000) + (((CallChecker.isCalled(striped, char[].class, 521, 16775, 16781)[(q + 1)]) - '0') * 100)) + (((CallChecker.isCalled(striped, char[].class, 522, 16827, 16833)[(q + 2)]) - '0') * 10)) + ((CallChecker.isCalled(striped, char[].class, 523, 16879, 16885)[(q + 3)]) - '0');
                                    CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 520, 16712, 16715)[i], "CallChecker.isCalled(this.mant, int[].class, 520, 16712, 16715)[i]", 520, 16712, 16898);
                                }
                            }
                        }
                    }
                }
                q += 4;
                CallChecker.varAssign(q, "q", 524, 16912, 16918);
            }
            exp = (decimalPos + sciexp) / rsize;
            CallChecker.varAssign(this.exp, "this.exp", 528, 16940, 16973);
            if (CallChecker.beforeDeref(striped, char[].class, 530, 16992, 16998)) {
                if (q < (CallChecker.isCalled(striped, char[].class, 530, 16992, 16998).length)) {
                    if (CallChecker.beforeDeref(striped, char[].class, 532, 17077, 17083)) {
                        round((((CallChecker.isCalled(striped, char[].class, 532, 17077, 17083)[q]) - '0') * 1000));
                    }
                }
            }
        } finally {
            _bcornu_methode_context905.methodEnd();
        }
    }

    protected Dfp(final DfpField field, final byte sign, final byte nans) {
        ConstructorContext _bcornu_methode_context906 = new ConstructorContext(Dfp.class, 543, 17124, 17640);
        try {
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 544, 17476, 17494);
            if (CallChecker.beforeDeref(field, DfpField.class, 545, 17527, 17531)) {
                this.mant = new int[CallChecker.isCalled(field, DfpField.class, 545, 17527, 17531).getRadixDigits()];
                CallChecker.varAssign(this.mant, "this.mant", 545, 17504, 17550);
            }
            this.sign = sign;
            CallChecker.varAssign(this.sign, "this.sign", 546, 17560, 17579);
            this.exp = 0;
            CallChecker.varAssign(this.exp, "this.exp", 547, 17589, 17605);
            this.nans = nans;
            CallChecker.varAssign(this.nans, "this.nans", 548, 17615, 17634);
        } finally {
            _bcornu_methode_context906.methodEnd();
        }
    }

    public Dfp newInstance() {
        MethodContext _bcornu_methode_context4010 = new MethodContext(Dfp.class, 555, 17647, 17898);
        try {
            CallChecker.varInit(this, "this", 555, 17647, 17898);
            CallChecker.varInit(this.field, "field", 555, 17647, 17898);
            CallChecker.varInit(this.nans, "nans", 555, 17647, 17898);
            CallChecker.varInit(this.exp, "exp", 555, 17647, 17898);
            CallChecker.varInit(this.sign, "sign", 555, 17647, 17898);
            CallChecker.varInit(this.mant, "mant", 555, 17647, 17898);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 555, 17647, 17898);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 555, 17647, 17898);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 555, 17647, 17898);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 555, 17647, 17898);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 555, 17647, 17898);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 555, 17647, 17898);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 555, 17647, 17898);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 555, 17647, 17898);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 555, 17647, 17898);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 555, 17647, 17898);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 555, 17647, 17898);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 555, 17647, 17898);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 555, 17647, 17898);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 555, 17647, 17898);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 555, 17647, 17898);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 555, 17647, 17898);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 555, 17647, 17898);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 555, 17647, 17898);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 555, 17647, 17898);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 555, 17647, 17898);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 555, 17647, 17898);
            return new Dfp(getField());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4010.methodEnd();
        }
    }

    public Dfp newInstance(final byte x) {
        MethodContext _bcornu_methode_context4011 = new MethodContext(Dfp.class, 563, 17905, 18132);
        try {
            CallChecker.varInit(this, "this", 563, 17905, 18132);
            CallChecker.varInit(x, "x", 563, 17905, 18132);
            CallChecker.varInit(this.field, "field", 563, 17905, 18132);
            CallChecker.varInit(this.nans, "nans", 563, 17905, 18132);
            CallChecker.varInit(this.exp, "exp", 563, 17905, 18132);
            CallChecker.varInit(this.sign, "sign", 563, 17905, 18132);
            CallChecker.varInit(this.mant, "mant", 563, 17905, 18132);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 563, 17905, 18132);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 563, 17905, 18132);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 563, 17905, 18132);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 563, 17905, 18132);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 563, 17905, 18132);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 563, 17905, 18132);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 563, 17905, 18132);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 563, 17905, 18132);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 563, 17905, 18132);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 563, 17905, 18132);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 563, 17905, 18132);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 563, 17905, 18132);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 563, 17905, 18132);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 563, 17905, 18132);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 563, 17905, 18132);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 563, 17905, 18132);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 563, 17905, 18132);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 563, 17905, 18132);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 563, 17905, 18132);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 563, 17905, 18132);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 563, 17905, 18132);
            return new Dfp(getField(), x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4011.methodEnd();
        }
    }

    public Dfp newInstance(final int x) {
        MethodContext _bcornu_methode_context4012 = new MethodContext(Dfp.class, 571, 18139, 18365);
        try {
            CallChecker.varInit(this, "this", 571, 18139, 18365);
            CallChecker.varInit(x, "x", 571, 18139, 18365);
            CallChecker.varInit(this.field, "field", 571, 18139, 18365);
            CallChecker.varInit(this.nans, "nans", 571, 18139, 18365);
            CallChecker.varInit(this.exp, "exp", 571, 18139, 18365);
            CallChecker.varInit(this.sign, "sign", 571, 18139, 18365);
            CallChecker.varInit(this.mant, "mant", 571, 18139, 18365);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 571, 18139, 18365);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 571, 18139, 18365);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 571, 18139, 18365);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 571, 18139, 18365);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 571, 18139, 18365);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 571, 18139, 18365);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 571, 18139, 18365);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 571, 18139, 18365);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 571, 18139, 18365);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 571, 18139, 18365);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 571, 18139, 18365);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 571, 18139, 18365);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 571, 18139, 18365);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 571, 18139, 18365);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 571, 18139, 18365);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 571, 18139, 18365);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 571, 18139, 18365);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 571, 18139, 18365);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 571, 18139, 18365);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 571, 18139, 18365);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 571, 18139, 18365);
            return new Dfp(getField(), x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4012.methodEnd();
        }
    }

    public Dfp newInstance(final long x) {
        MethodContext _bcornu_methode_context4013 = new MethodContext(Dfp.class, 579, 18372, 18599);
        try {
            CallChecker.varInit(this, "this", 579, 18372, 18599);
            CallChecker.varInit(x, "x", 579, 18372, 18599);
            CallChecker.varInit(this.field, "field", 579, 18372, 18599);
            CallChecker.varInit(this.nans, "nans", 579, 18372, 18599);
            CallChecker.varInit(this.exp, "exp", 579, 18372, 18599);
            CallChecker.varInit(this.sign, "sign", 579, 18372, 18599);
            CallChecker.varInit(this.mant, "mant", 579, 18372, 18599);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 579, 18372, 18599);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 579, 18372, 18599);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 579, 18372, 18599);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 579, 18372, 18599);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 579, 18372, 18599);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 579, 18372, 18599);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 579, 18372, 18599);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 579, 18372, 18599);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 579, 18372, 18599);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 579, 18372, 18599);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 579, 18372, 18599);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 579, 18372, 18599);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 579, 18372, 18599);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 579, 18372, 18599);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 579, 18372, 18599);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 579, 18372, 18599);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 579, 18372, 18599);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 579, 18372, 18599);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 579, 18372, 18599);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 579, 18372, 18599);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 579, 18372, 18599);
            return new Dfp(getField(), x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4013.methodEnd();
        }
    }

    public Dfp newInstance(final double x) {
        MethodContext _bcornu_methode_context4014 = new MethodContext(Dfp.class, 587, 18606, 18837);
        try {
            CallChecker.varInit(this, "this", 587, 18606, 18837);
            CallChecker.varInit(x, "x", 587, 18606, 18837);
            CallChecker.varInit(this.field, "field", 587, 18606, 18837);
            CallChecker.varInit(this.nans, "nans", 587, 18606, 18837);
            CallChecker.varInit(this.exp, "exp", 587, 18606, 18837);
            CallChecker.varInit(this.sign, "sign", 587, 18606, 18837);
            CallChecker.varInit(this.mant, "mant", 587, 18606, 18837);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 587, 18606, 18837);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 587, 18606, 18837);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 587, 18606, 18837);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 587, 18606, 18837);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 587, 18606, 18837);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 587, 18606, 18837);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 587, 18606, 18837);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 587, 18606, 18837);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 587, 18606, 18837);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 587, 18606, 18837);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 587, 18606, 18837);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 587, 18606, 18837);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 587, 18606, 18837);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 587, 18606, 18837);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 587, 18606, 18837);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 587, 18606, 18837);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 587, 18606, 18837);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 587, 18606, 18837);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 587, 18606, 18837);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 587, 18606, 18837);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 587, 18606, 18837);
            return new Dfp(getField(), x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4014.methodEnd();
        }
    }

    public Dfp newInstance(final Dfp d) {
        MethodContext _bcornu_methode_context4015 = new MethodContext(Dfp.class, 596, 18844, 19518);
        try {
            CallChecker.varInit(this, "this", 596, 18844, 19518);
            CallChecker.varInit(d, "d", 596, 18844, 19518);
            CallChecker.varInit(this.field, "field", 596, 18844, 19518);
            CallChecker.varInit(this.nans, "nans", 596, 18844, 19518);
            CallChecker.varInit(this.exp, "exp", 596, 18844, 19518);
            CallChecker.varInit(this.sign, "sign", 596, 18844, 19518);
            CallChecker.varInit(this.mant, "mant", 596, 18844, 19518);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 596, 18844, 19518);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 596, 18844, 19518);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 596, 18844, 19518);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 596, 18844, 19518);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 596, 18844, 19518);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 596, 18844, 19518);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 596, 18844, 19518);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 596, 18844, 19518);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 596, 18844, 19518);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 596, 18844, 19518);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 596, 18844, 19518);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 596, 18844, 19518);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 596, 18844, 19518);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 596, 18844, 19518);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 596, 18844, 19518);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 596, 18844, 19518);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 596, 18844, 19518);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 596, 18844, 19518);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 596, 18844, 19518);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 596, 18844, 19518);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 596, 18844, 19518);
            if (CallChecker.beforeDeref(field, DfpField.class, 599, 19195, 19199)) {
                if (CallChecker.beforeDeref(d, Dfp.class, 599, 19221, 19221)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(d, Dfp.class, 599, 19221, 19221).field, DfpField.class, 599, 19221, 19227)) {
                        if ((CallChecker.isCalled(field, DfpField.class, 599, 19195, 19199).getRadixDigits()) != (CallChecker.isCalled(CallChecker.isCalled(d, Dfp.class, 599, 19221, 19221).field, DfpField.class, 599, 19221, 19227).getRadixDigits())) {
                            if (CallChecker.beforeDeref(field, DfpField.class, 600, 19261, 19265)) {
                                CallChecker.isCalled(field, DfpField.class, 600, 19261, 19265).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                            final Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 601, 19320, 19361);
                            if (CallChecker.beforeDeref(result, Dfp.class, 602, 19375, 19380)) {
                                CallChecker.isCalled(result, Dfp.class, 602, 19375, 19380).nans = Dfp.QNAN;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 602, 19375, 19380).nans, "CallChecker.isCalled(result, Dfp.class, 602, 19375, 19380).nans", 602, 19375, 19393);
                            }
                            return dotrap(DfpField.FLAG_INVALID, Dfp.NEW_INSTANCE_TRAP, d, result);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return new Dfp(d);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4015.methodEnd();
        }
    }

    public Dfp newInstance(final String s) {
        MethodContext _bcornu_methode_context4016 = new MethodContext(Dfp.class, 615, 19525, 19865);
        try {
            CallChecker.varInit(this, "this", 615, 19525, 19865);
            CallChecker.varInit(s, "s", 615, 19525, 19865);
            CallChecker.varInit(this.field, "field", 615, 19525, 19865);
            CallChecker.varInit(this.nans, "nans", 615, 19525, 19865);
            CallChecker.varInit(this.exp, "exp", 615, 19525, 19865);
            CallChecker.varInit(this.sign, "sign", 615, 19525, 19865);
            CallChecker.varInit(this.mant, "mant", 615, 19525, 19865);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 615, 19525, 19865);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 615, 19525, 19865);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 615, 19525, 19865);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 615, 19525, 19865);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 615, 19525, 19865);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 615, 19525, 19865);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 615, 19525, 19865);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 615, 19525, 19865);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 615, 19525, 19865);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 615, 19525, 19865);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 615, 19525, 19865);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 615, 19525, 19865);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 615, 19525, 19865);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 615, 19525, 19865);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 615, 19525, 19865);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 615, 19525, 19865);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 615, 19525, 19865);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 615, 19525, 19865);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 615, 19525, 19865);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 615, 19525, 19865);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 615, 19525, 19865);
            return new Dfp(field, s);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4016.methodEnd();
        }
    }

    public Dfp newInstance(final byte sig, final byte code) {
        MethodContext _bcornu_methode_context4017 = new MethodContext(Dfp.class, 625, 19872, 20242);
        try {
            CallChecker.varInit(this, "this", 625, 19872, 20242);
            CallChecker.varInit(code, "code", 625, 19872, 20242);
            CallChecker.varInit(sig, "sig", 625, 19872, 20242);
            CallChecker.varInit(this.field, "field", 625, 19872, 20242);
            CallChecker.varInit(this.nans, "nans", 625, 19872, 20242);
            CallChecker.varInit(this.exp, "exp", 625, 19872, 20242);
            CallChecker.varInit(this.sign, "sign", 625, 19872, 20242);
            CallChecker.varInit(this.mant, "mant", 625, 19872, 20242);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 625, 19872, 20242);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 625, 19872, 20242);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 625, 19872, 20242);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 625, 19872, 20242);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 625, 19872, 20242);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 625, 19872, 20242);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 625, 19872, 20242);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 625, 19872, 20242);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 625, 19872, 20242);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 625, 19872, 20242);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 625, 19872, 20242);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 625, 19872, 20242);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 625, 19872, 20242);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 625, 19872, 20242);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 625, 19872, 20242);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 625, 19872, 20242);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 625, 19872, 20242);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 625, 19872, 20242);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 625, 19872, 20242);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 625, 19872, 20242);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 625, 19872, 20242);
            if (CallChecker.beforeDeref(field, DfpField.class, 626, 20213, 20217)) {
                return CallChecker.isCalled(field, DfpField.class, 626, 20213, 20217).newDfp(sig, code);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4017.methodEnd();
        }
    }

    public DfpField getField() {
        MethodContext _bcornu_methode_context4018 = new MethodContext(DfpField.class, 636, 20249, 20680);
        try {
            CallChecker.varInit(this, "this", 636, 20249, 20680);
            CallChecker.varInit(this.field, "field", 636, 20249, 20680);
            CallChecker.varInit(this.nans, "nans", 636, 20249, 20680);
            CallChecker.varInit(this.exp, "exp", 636, 20249, 20680);
            CallChecker.varInit(this.sign, "sign", 636, 20249, 20680);
            CallChecker.varInit(this.mant, "mant", 636, 20249, 20680);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 636, 20249, 20680);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 636, 20249, 20680);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 636, 20249, 20680);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 636, 20249, 20680);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 636, 20249, 20680);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 636, 20249, 20680);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 636, 20249, 20680);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 636, 20249, 20680);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 636, 20249, 20680);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 636, 20249, 20680);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 636, 20249, 20680);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 636, 20249, 20680);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 636, 20249, 20680);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 636, 20249, 20680);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 636, 20249, 20680);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 636, 20249, 20680);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 636, 20249, 20680);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 636, 20249, 20680);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 636, 20249, 20680);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 636, 20249, 20680);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 636, 20249, 20680);
            return field;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DfpField) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4018.methodEnd();
        }
    }

    public int getRadixDigits() {
        MethodContext _bcornu_methode_context4019 = new MethodContext(int.class, 643, 20687, 20862);
        try {
            CallChecker.varInit(this, "this", 643, 20687, 20862);
            CallChecker.varInit(this.field, "field", 643, 20687, 20862);
            CallChecker.varInit(this.nans, "nans", 643, 20687, 20862);
            CallChecker.varInit(this.exp, "exp", 643, 20687, 20862);
            CallChecker.varInit(this.sign, "sign", 643, 20687, 20862);
            CallChecker.varInit(this.mant, "mant", 643, 20687, 20862);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 643, 20687, 20862);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 643, 20687, 20862);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 643, 20687, 20862);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 643, 20687, 20862);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 643, 20687, 20862);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 643, 20687, 20862);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 643, 20687, 20862);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 643, 20687, 20862);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 643, 20687, 20862);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 643, 20687, 20862);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 643, 20687, 20862);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 643, 20687, 20862);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 643, 20687, 20862);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 643, 20687, 20862);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 643, 20687, 20862);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 643, 20687, 20862);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 643, 20687, 20862);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 643, 20687, 20862);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 643, 20687, 20862);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 643, 20687, 20862);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 643, 20687, 20862);
            if (CallChecker.beforeDeref(field, DfpField.class, 644, 20834, 20838)) {
                return CallChecker.isCalled(field, DfpField.class, 644, 20834, 20838).getRadixDigits();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4019.methodEnd();
        }
    }

    public Dfp getZero() {
        MethodContext _bcornu_methode_context4020 = new MethodContext(Dfp.class, 650, 20869, 21001);
        try {
            CallChecker.varInit(this, "this", 650, 20869, 21001);
            CallChecker.varInit(this.field, "field", 650, 20869, 21001);
            CallChecker.varInit(this.nans, "nans", 650, 20869, 21001);
            CallChecker.varInit(this.exp, "exp", 650, 20869, 21001);
            CallChecker.varInit(this.sign, "sign", 650, 20869, 21001);
            CallChecker.varInit(this.mant, "mant", 650, 20869, 21001);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 650, 20869, 21001);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 650, 20869, 21001);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 650, 20869, 21001);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 650, 20869, 21001);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 650, 20869, 21001);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 650, 20869, 21001);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 650, 20869, 21001);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 650, 20869, 21001);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 650, 20869, 21001);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 650, 20869, 21001);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 650, 20869, 21001);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 650, 20869, 21001);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 650, 20869, 21001);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 650, 20869, 21001);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 650, 20869, 21001);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 650, 20869, 21001);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 650, 20869, 21001);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 650, 20869, 21001);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 650, 20869, 21001);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 650, 20869, 21001);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 650, 20869, 21001);
            if (CallChecker.beforeDeref(field, DfpField.class, 651, 20980, 20984)) {
                return CallChecker.isCalled(field, DfpField.class, 651, 20980, 20984).getZero();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4020.methodEnd();
        }
    }

    public Dfp getOne() {
        MethodContext _bcornu_methode_context4021 = new MethodContext(Dfp.class, 657, 21008, 21137);
        try {
            CallChecker.varInit(this, "this", 657, 21008, 21137);
            CallChecker.varInit(this.field, "field", 657, 21008, 21137);
            CallChecker.varInit(this.nans, "nans", 657, 21008, 21137);
            CallChecker.varInit(this.exp, "exp", 657, 21008, 21137);
            CallChecker.varInit(this.sign, "sign", 657, 21008, 21137);
            CallChecker.varInit(this.mant, "mant", 657, 21008, 21137);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 657, 21008, 21137);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 657, 21008, 21137);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 657, 21008, 21137);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 657, 21008, 21137);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 657, 21008, 21137);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 657, 21008, 21137);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 657, 21008, 21137);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 657, 21008, 21137);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 657, 21008, 21137);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 657, 21008, 21137);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 657, 21008, 21137);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 657, 21008, 21137);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 657, 21008, 21137);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 657, 21008, 21137);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 657, 21008, 21137);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 657, 21008, 21137);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 657, 21008, 21137);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 657, 21008, 21137);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 657, 21008, 21137);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 657, 21008, 21137);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 657, 21008, 21137);
            if (CallChecker.beforeDeref(field, DfpField.class, 658, 21117, 21121)) {
                return CallChecker.isCalled(field, DfpField.class, 658, 21117, 21121).getOne();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4021.methodEnd();
        }
    }

    public Dfp getTwo() {
        MethodContext _bcornu_methode_context4022 = new MethodContext(Dfp.class, 664, 21144, 21273);
        try {
            CallChecker.varInit(this, "this", 664, 21144, 21273);
            CallChecker.varInit(this.field, "field", 664, 21144, 21273);
            CallChecker.varInit(this.nans, "nans", 664, 21144, 21273);
            CallChecker.varInit(this.exp, "exp", 664, 21144, 21273);
            CallChecker.varInit(this.sign, "sign", 664, 21144, 21273);
            CallChecker.varInit(this.mant, "mant", 664, 21144, 21273);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 664, 21144, 21273);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 664, 21144, 21273);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 664, 21144, 21273);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 664, 21144, 21273);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 664, 21144, 21273);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 664, 21144, 21273);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 664, 21144, 21273);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 664, 21144, 21273);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 664, 21144, 21273);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 664, 21144, 21273);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 664, 21144, 21273);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 664, 21144, 21273);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 664, 21144, 21273);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 664, 21144, 21273);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 664, 21144, 21273);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 664, 21144, 21273);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 664, 21144, 21273);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 664, 21144, 21273);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 664, 21144, 21273);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 664, 21144, 21273);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 664, 21144, 21273);
            if (CallChecker.beforeDeref(field, DfpField.class, 665, 21253, 21257)) {
                return CallChecker.isCalled(field, DfpField.class, 665, 21253, 21257).getTwo();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4022.methodEnd();
        }
    }

    protected void shiftLeft() {
        MethodContext _bcornu_methode_context4023 = new MethodContext(void.class, 670, 21280, 21524);
        try {
            CallChecker.varInit(this, "this", 670, 21280, 21524);
            CallChecker.varInit(this.field, "field", 670, 21280, 21524);
            CallChecker.varInit(this.nans, "nans", 670, 21280, 21524);
            CallChecker.varInit(this.exp, "exp", 670, 21280, 21524);
            CallChecker.varInit(this.sign, "sign", 670, 21280, 21524);
            CallChecker.varInit(this.mant, "mant", 670, 21280, 21524);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 670, 21280, 21524);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 670, 21280, 21524);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 670, 21280, 21524);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 670, 21280, 21524);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 670, 21280, 21524);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 670, 21280, 21524);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 670, 21280, 21524);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 670, 21280, 21524);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 670, 21280, 21524);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 670, 21280, 21524);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 670, 21280, 21524);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 670, 21280, 21524);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 670, 21280, 21524);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 670, 21280, 21524);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 670, 21280, 21524);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 670, 21280, 21524);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 670, 21280, 21524);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 670, 21280, 21524);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 670, 21280, 21524);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 670, 21280, 21524);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 670, 21280, 21524);
            mant = CallChecker.beforeCalled(mant, int[].class, 671, 21410, 21413);
            for (int i = (CallChecker.isCalled(mant, int[].class, 671, 21410, 21413).length) - 1; i > 0; i--) {
                if (CallChecker.beforeDeref(mant, int[].class, 672, 21453, 21456)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 672, 21463, 21466)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 672, 21453, 21456);
                        mant = CallChecker.beforeCalled(mant, int[].class, 672, 21463, 21466);
                        CallChecker.isCalled(mant, int[].class, 672, 21453, 21456)[i] = CallChecker.isCalled(mant, int[].class, 672, 21463, 21466)[(i - 1)];
                        CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 672, 21453, 21456)[i], "CallChecker.isCalled(this.mant, int[].class, 672, 21453, 21456)[i]", 672, 21453, 21472);
                    }
                }
            }
            if (CallChecker.beforeDeref(mant, int[].class, 674, 21492, 21495)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 674, 21492, 21495);
                CallChecker.isCalled(mant, int[].class, 674, 21492, 21495)[0] = 0;
                CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 674, 21492, 21495)[0], "CallChecker.isCalled(this.mant, int[].class, 674, 21492, 21495)[0]", 674, 21492, 21503);
            }
            (exp)--;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4023.methodEnd();
        }
    }

    protected void shiftRight() {
        MethodContext _bcornu_methode_context4024 = new MethodContext(void.class, 682, 21531, 21892);
        try {
            CallChecker.varInit(this, "this", 682, 21531, 21892);
            CallChecker.varInit(this.field, "field", 682, 21531, 21892);
            CallChecker.varInit(this.nans, "nans", 682, 21531, 21892);
            CallChecker.varInit(this.exp, "exp", 682, 21531, 21892);
            CallChecker.varInit(this.sign, "sign", 682, 21531, 21892);
            CallChecker.varInit(this.mant, "mant", 682, 21531, 21892);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 682, 21531, 21892);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 682, 21531, 21892);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 682, 21531, 21892);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 682, 21531, 21892);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 682, 21531, 21892);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 682, 21531, 21892);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 682, 21531, 21892);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 682, 21531, 21892);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 682, 21531, 21892);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 682, 21531, 21892);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 682, 21531, 21892);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 682, 21531, 21892);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 682, 21531, 21892);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 682, 21531, 21892);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 682, 21531, 21892);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 682, 21531, 21892);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 682, 21531, 21892);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 682, 21531, 21892);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 682, 21531, 21892);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 682, 21531, 21892);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 682, 21531, 21892);
            mant = CallChecker.beforeCalled(mant, int[].class, 683, 21771, 21774);
            for (int i = 0; i < ((CallChecker.isCalled(mant, int[].class, 683, 21771, 21774).length) - 1); i++) {
                if (CallChecker.beforeDeref(mant, int[].class, 684, 21807, 21810)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 684, 21817, 21820)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 684, 21807, 21810);
                        mant = CallChecker.beforeCalled(mant, int[].class, 684, 21817, 21820);
                        CallChecker.isCalled(mant, int[].class, 684, 21807, 21810)[i] = CallChecker.isCalled(mant, int[].class, 684, 21817, 21820)[(i + 1)];
                        CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 684, 21807, 21810)[i], "CallChecker.isCalled(this.mant, int[].class, 684, 21807, 21810)[i]", 684, 21807, 21826);
                    }
                }
            }
            if (CallChecker.beforeDeref(mant, int[].class, 686, 21851, 21854)) {
                if (CallChecker.beforeDeref(mant, int[].class, 686, 21846, 21849)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 686, 21851, 21854);
                    mant = CallChecker.beforeCalled(mant, int[].class, 686, 21846, 21849);
                    CallChecker.isCalled(mant, int[].class, 686, 21846, 21849)[((CallChecker.isCalled(mant, int[].class, 686, 21851, 21854).length) - 1)] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 686, 21846, 21849)[((CallChecker.isCalled(this.mant, int[].class, 686, 21851, 21854).length) - 1)], "CallChecker.isCalled(this.mant, int[].class, 686, 21846, 21849)[((CallChecker.isCalled(this.mant, int[].class, 686, 21851, 21854).length) - 1)]", 686, 21846, 21871);
                }
            }
            (exp)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4024.methodEnd();
        }
    }

    protected int align(int e) {
        MethodContext _bcornu_methode_context4025 = new MethodContext(int.class, 698, 21899, 23581);
        try {
            CallChecker.varInit(this, "this", 698, 21899, 23581);
            CallChecker.varInit(e, "e", 698, 21899, 23581);
            CallChecker.varInit(this.field, "field", 698, 21899, 23581);
            CallChecker.varInit(this.nans, "nans", 698, 21899, 23581);
            CallChecker.varInit(this.exp, "exp", 698, 21899, 23581);
            CallChecker.varInit(this.sign, "sign", 698, 21899, 23581);
            CallChecker.varInit(this.mant, "mant", 698, 21899, 23581);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 698, 21899, 23581);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 698, 21899, 23581);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 698, 21899, 23581);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 698, 21899, 23581);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 698, 21899, 23581);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 698, 21899, 23581);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 698, 21899, 23581);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 698, 21899, 23581);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 698, 21899, 23581);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 698, 21899, 23581);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 698, 21899, 23581);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 698, 21899, 23581);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 698, 21899, 23581);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 698, 21899, 23581);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 698, 21899, 23581);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 698, 21899, 23581);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 698, 21899, 23581);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 698, 21899, 23581);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 698, 21899, 23581);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 698, 21899, 23581);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 698, 21899, 23581);
            int lostdigit = CallChecker.varInit(((int) (0)), "lostdigit", 699, 22344, 22361);
            boolean inexact = CallChecker.varInit(((boolean) (false)), "inexact", 700, 22371, 22394);
            int diff = CallChecker.varInit(((int) ((this.exp) - e)), "diff", 702, 22405, 22423);
            int adiff = CallChecker.varInit(((int) (diff)), "adiff", 704, 22434, 22450);
            if (adiff < 0) {
                adiff = -adiff;
                CallChecker.varAssign(adiff, "adiff", 706, 22489, 22503);
            }
            if (diff == 0) {
                return 0;
            }
            if (CallChecker.beforeDeref(mant, int[].class, 713, 22595, 22598)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 713, 22595, 22598);
                if (adiff > ((CallChecker.isCalled(mant, int[].class, 713, 22595, 22598).length) + 1)) {
                    Arrays.fill(mant, 0);
                    exp = e;
                    CallChecker.varAssign(this.exp, "this.exp", 716, 22689, 22696);
                    if (CallChecker.beforeDeref(field, DfpField.class, 718, 22711, 22715)) {
                        CallChecker.isCalled(field, DfpField.class, 718, 22711, 22715).setIEEEFlagsBits(DfpField.FLAG_INEXACT);
                    }
                    dotrap(DfpField.FLAG_INEXACT, Dfp.ALIGN_TRAP, this, this);
                    return 0;
                }
            }else
                throw new AbnormalExecutionError();
            
            for (int i = 0; i < adiff; i++) {
                if (diff < 0) {
                    if (lostdigit != 0) {
                        inexact = true;
                        CallChecker.varAssign(inexact, "inexact", 731, 23212, 23226);
                    }
                    if (CallChecker.beforeDeref(mant, int[].class, 734, 23275, 23278)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 734, 23275, 23278);
                        lostdigit = CallChecker.isCalled(mant, int[].class, 734, 23275, 23278)[0];
                        CallChecker.varAssign(lostdigit, "lostdigit", 734, 23263, 23282);
                    }
                    shiftRight();
                }else {
                    shiftLeft();
                }
            }
            if (inexact) {
                if (CallChecker.beforeDeref(field, DfpField.class, 743, 23425, 23429)) {
                    CallChecker.isCalled(field, DfpField.class, 743, 23425, 23429).setIEEEFlagsBits(DfpField.FLAG_INEXACT);
                }
                dotrap(DfpField.FLAG_INEXACT, Dfp.ALIGN_TRAP, this, this);
            }
            return lostdigit;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4025.methodEnd();
        }
    }

    public boolean lessThan(final Dfp x) {
        MethodContext _bcornu_methode_context4026 = new MethodContext(boolean.class, 755, 23588, 24523);
        try {
            CallChecker.varInit(this, "this", 755, 23588, 24523);
            CallChecker.varInit(x, "x", 755, 23588, 24523);
            CallChecker.varInit(this.field, "field", 755, 23588, 24523);
            CallChecker.varInit(this.nans, "nans", 755, 23588, 24523);
            CallChecker.varInit(this.exp, "exp", 755, 23588, 24523);
            CallChecker.varInit(this.sign, "sign", 755, 23588, 24523);
            CallChecker.varInit(this.mant, "mant", 755, 23588, 24523);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 755, 23588, 24523);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 755, 23588, 24523);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 755, 23588, 24523);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 755, 23588, 24523);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 755, 23588, 24523);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 755, 23588, 24523);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 755, 23588, 24523);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 755, 23588, 24523);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 755, 23588, 24523);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 755, 23588, 24523);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 755, 23588, 24523);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 755, 23588, 24523);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 755, 23588, 24523);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 755, 23588, 24523);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 755, 23588, 24523);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 755, 23588, 24523);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 755, 23588, 24523);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 755, 23588, 24523);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 755, 23588, 24523);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 755, 23588, 24523);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 755, 23588, 24523);
            if (CallChecker.beforeDeref(field, DfpField.class, 758, 23889, 23893)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 758, 23915, 23915)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 758, 23915, 23915).field, DfpField.class, 758, 23915, 23921)) {
                        if ((CallChecker.isCalled(field, DfpField.class, 758, 23889, 23893).getRadixDigits()) != (CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 758, 23915, 23915).field, DfpField.class, 758, 23915, 23921).getRadixDigits())) {
                            if (CallChecker.beforeDeref(field, DfpField.class, 759, 23955, 23959)) {
                                CallChecker.isCalled(field, DfpField.class, 759, 23955, 23959).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                            final Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 760, 24014, 24055);
                            if (CallChecker.beforeDeref(result, Dfp.class, 761, 24069, 24074)) {
                                CallChecker.isCalled(result, Dfp.class, 761, 24069, 24074).nans = Dfp.QNAN;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 761, 24069, 24074).nans, "CallChecker.isCalled(result, Dfp.class, 761, 24069, 24074).nans", 761, 24069, 24087);
                            }
                            dotrap(DfpField.FLAG_INVALID, Dfp.LESS_THAN_TRAP, x, result);
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, Dfp.class, 767, 24287, 24287)) {
                if ((isNaN()) || (CallChecker.isCalled(x, Dfp.class, 767, 24287, 24287).isNaN())) {
                    if (CallChecker.beforeDeref(field, DfpField.class, 768, 24312, 24316)) {
                        CallChecker.isCalled(field, DfpField.class, 768, 24312, 24316).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                    }
                    dotrap(DfpField.FLAG_INVALID, Dfp.LESS_THAN_TRAP, x, newInstance(getZero()));
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            return (Dfp.compare(this, x)) < 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4026.methodEnd();
        }
    }

    public boolean greaterThan(final Dfp x) {
        MethodContext _bcornu_methode_context4027 = new MethodContext(boolean.class, 780, 24530, 25480);
        try {
            CallChecker.varInit(this, "this", 780, 24530, 25480);
            CallChecker.varInit(x, "x", 780, 24530, 25480);
            CallChecker.varInit(this.field, "field", 780, 24530, 25480);
            CallChecker.varInit(this.nans, "nans", 780, 24530, 25480);
            CallChecker.varInit(this.exp, "exp", 780, 24530, 25480);
            CallChecker.varInit(this.sign, "sign", 780, 24530, 25480);
            CallChecker.varInit(this.mant, "mant", 780, 24530, 25480);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 780, 24530, 25480);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 780, 24530, 25480);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 780, 24530, 25480);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 780, 24530, 25480);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 780, 24530, 25480);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 780, 24530, 25480);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 780, 24530, 25480);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 780, 24530, 25480);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 780, 24530, 25480);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 780, 24530, 25480);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 780, 24530, 25480);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 780, 24530, 25480);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 780, 24530, 25480);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 780, 24530, 25480);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 780, 24530, 25480);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 780, 24530, 25480);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 780, 24530, 25480);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 780, 24530, 25480);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 780, 24530, 25480);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 780, 24530, 25480);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 780, 24530, 25480);
            if (CallChecker.beforeDeref(field, DfpField.class, 783, 24840, 24844)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 783, 24866, 24866)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 783, 24866, 24866).field, DfpField.class, 783, 24866, 24872)) {
                        if ((CallChecker.isCalled(field, DfpField.class, 783, 24840, 24844).getRadixDigits()) != (CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 783, 24866, 24866).field, DfpField.class, 783, 24866, 24872).getRadixDigits())) {
                            if (CallChecker.beforeDeref(field, DfpField.class, 784, 24906, 24910)) {
                                CallChecker.isCalled(field, DfpField.class, 784, 24906, 24910).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                            final Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 785, 24965, 25006);
                            if (CallChecker.beforeDeref(result, Dfp.class, 786, 25020, 25025)) {
                                CallChecker.isCalled(result, Dfp.class, 786, 25020, 25025).nans = Dfp.QNAN;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 786, 25020, 25025).nans, "CallChecker.isCalled(result, Dfp.class, 786, 25020, 25025).nans", 786, 25020, 25038);
                            }
                            dotrap(DfpField.FLAG_INVALID, Dfp.GREATER_THAN_TRAP, x, result);
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, Dfp.class, 792, 25241, 25241)) {
                if ((isNaN()) || (CallChecker.isCalled(x, Dfp.class, 792, 25241, 25241).isNaN())) {
                    if (CallChecker.beforeDeref(field, DfpField.class, 793, 25266, 25270)) {
                        CallChecker.isCalled(field, DfpField.class, 793, 25266, 25270).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                    }
                    dotrap(DfpField.FLAG_INVALID, Dfp.GREATER_THAN_TRAP, x, newInstance(getZero()));
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            return (Dfp.compare(this, x)) > 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4027.methodEnd();
        }
    }

    public boolean negativeOrNull() {
        MethodContext _bcornu_methode_context4028 = new MethodContext(boolean.class, 804, 25487, 25963);
        try {
            CallChecker.varInit(this, "this", 804, 25487, 25963);
            CallChecker.varInit(this.field, "field", 804, 25487, 25963);
            CallChecker.varInit(this.nans, "nans", 804, 25487, 25963);
            CallChecker.varInit(this.exp, "exp", 804, 25487, 25963);
            CallChecker.varInit(this.sign, "sign", 804, 25487, 25963);
            CallChecker.varInit(this.mant, "mant", 804, 25487, 25963);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 804, 25487, 25963);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 804, 25487, 25963);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 804, 25487, 25963);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 804, 25487, 25963);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 804, 25487, 25963);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 804, 25487, 25963);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 804, 25487, 25963);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 804, 25487, 25963);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 804, 25487, 25963);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 804, 25487, 25963);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 804, 25487, 25963);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 804, 25487, 25963);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 804, 25487, 25963);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 804, 25487, 25963);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 804, 25487, 25963);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 804, 25487, 25963);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 804, 25487, 25963);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 804, 25487, 25963);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 804, 25487, 25963);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 804, 25487, 25963);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 804, 25487, 25963);
            if (isNaN()) {
                if (CallChecker.beforeDeref(field, DfpField.class, 807, 25707, 25711)) {
                    CallChecker.isCalled(field, DfpField.class, 807, 25707, 25711).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                }
                dotrap(DfpField.FLAG_INVALID, Dfp.LESS_THAN_TRAP, this, newInstance(getZero()));
                return false;
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 812, 25916, 25919);
            mant = CallChecker.beforeCalled(mant, int[].class, 812, 25911, 25914);
            return ((sign) < 0) || (((CallChecker.isCalled(mant, int[].class, 812, 25911, 25914)[((CallChecker.isCalled(mant, int[].class, 812, 25916, 25919).length) - 1)]) == 0) && (!(isInfinite())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4028.methodEnd();
        }
    }

    public boolean strictlyNegative() {
        MethodContext _bcornu_methode_context4029 = new MethodContext(boolean.class, 819, 25970, 26444);
        try {
            CallChecker.varInit(this, "this", 819, 25970, 26444);
            CallChecker.varInit(this.field, "field", 819, 25970, 26444);
            CallChecker.varInit(this.nans, "nans", 819, 25970, 26444);
            CallChecker.varInit(this.exp, "exp", 819, 25970, 26444);
            CallChecker.varInit(this.sign, "sign", 819, 25970, 26444);
            CallChecker.varInit(this.mant, "mant", 819, 25970, 26444);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 819, 25970, 26444);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 819, 25970, 26444);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 819, 25970, 26444);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 819, 25970, 26444);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 819, 25970, 26444);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 819, 25970, 26444);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 819, 25970, 26444);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 819, 25970, 26444);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 819, 25970, 26444);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 819, 25970, 26444);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 819, 25970, 26444);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 819, 25970, 26444);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 819, 25970, 26444);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 819, 25970, 26444);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 819, 25970, 26444);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 819, 25970, 26444);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 819, 25970, 26444);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 819, 25970, 26444);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 819, 25970, 26444);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 819, 25970, 26444);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 819, 25970, 26444);
            if (isNaN()) {
                if (CallChecker.beforeDeref(field, DfpField.class, 822, 26189, 26193)) {
                    CallChecker.isCalled(field, DfpField.class, 822, 26189, 26193).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                }
                dotrap(DfpField.FLAG_INVALID, Dfp.LESS_THAN_TRAP, this, newInstance(getZero()));
                return false;
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 827, 26398, 26401);
            mant = CallChecker.beforeCalled(mant, int[].class, 827, 26393, 26396);
            return ((sign) < 0) && (((CallChecker.isCalled(mant, int[].class, 827, 26393, 26396)[((CallChecker.isCalled(mant, int[].class, 827, 26398, 26401).length) - 1)]) != 0) || (isInfinite()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4029.methodEnd();
        }
    }

    public boolean positiveOrNull() {
        MethodContext _bcornu_methode_context4030 = new MethodContext(boolean.class, 834, 26451, 26933);
        try {
            CallChecker.varInit(this, "this", 834, 26451, 26933);
            CallChecker.varInit(this.field, "field", 834, 26451, 26933);
            CallChecker.varInit(this.nans, "nans", 834, 26451, 26933);
            CallChecker.varInit(this.exp, "exp", 834, 26451, 26933);
            CallChecker.varInit(this.sign, "sign", 834, 26451, 26933);
            CallChecker.varInit(this.mant, "mant", 834, 26451, 26933);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 834, 26451, 26933);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 834, 26451, 26933);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 834, 26451, 26933);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 834, 26451, 26933);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 834, 26451, 26933);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 834, 26451, 26933);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 834, 26451, 26933);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 834, 26451, 26933);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 834, 26451, 26933);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 834, 26451, 26933);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 834, 26451, 26933);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 834, 26451, 26933);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 834, 26451, 26933);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 834, 26451, 26933);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 834, 26451, 26933);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 834, 26451, 26933);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 834, 26451, 26933);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 834, 26451, 26933);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 834, 26451, 26933);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 834, 26451, 26933);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 834, 26451, 26933);
            if (isNaN()) {
                if (CallChecker.beforeDeref(field, DfpField.class, 837, 26677, 26681)) {
                    CallChecker.isCalled(field, DfpField.class, 837, 26677, 26681).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                }
                dotrap(DfpField.FLAG_INVALID, Dfp.LESS_THAN_TRAP, this, newInstance(getZero()));
                return false;
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 842, 26886, 26889);
            mant = CallChecker.beforeCalled(mant, int[].class, 842, 26881, 26884);
            return ((sign) > 0) || (((CallChecker.isCalled(mant, int[].class, 842, 26881, 26884)[((CallChecker.isCalled(mant, int[].class, 842, 26886, 26889).length) - 1)]) == 0) && (!(isInfinite())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4030.methodEnd();
        }
    }

    public boolean strictlyPositive() {
        MethodContext _bcornu_methode_context4031 = new MethodContext(boolean.class, 849, 26940, 27420);
        try {
            CallChecker.varInit(this, "this", 849, 26940, 27420);
            CallChecker.varInit(this.field, "field", 849, 26940, 27420);
            CallChecker.varInit(this.nans, "nans", 849, 26940, 27420);
            CallChecker.varInit(this.exp, "exp", 849, 26940, 27420);
            CallChecker.varInit(this.sign, "sign", 849, 26940, 27420);
            CallChecker.varInit(this.mant, "mant", 849, 26940, 27420);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 849, 26940, 27420);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 849, 26940, 27420);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 849, 26940, 27420);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 849, 26940, 27420);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 849, 26940, 27420);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 849, 26940, 27420);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 849, 26940, 27420);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 849, 26940, 27420);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 849, 26940, 27420);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 849, 26940, 27420);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 849, 26940, 27420);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 849, 26940, 27420);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 849, 26940, 27420);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 849, 26940, 27420);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 849, 26940, 27420);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 849, 26940, 27420);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 849, 26940, 27420);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 849, 26940, 27420);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 849, 26940, 27420);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 849, 26940, 27420);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 849, 26940, 27420);
            if (isNaN()) {
                if (CallChecker.beforeDeref(field, DfpField.class, 852, 27165, 27169)) {
                    CallChecker.isCalled(field, DfpField.class, 852, 27165, 27169).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                }
                dotrap(DfpField.FLAG_INVALID, Dfp.LESS_THAN_TRAP, this, newInstance(getZero()));
                return false;
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 857, 27374, 27377);
            mant = CallChecker.beforeCalled(mant, int[].class, 857, 27369, 27372);
            return ((sign) > 0) && (((CallChecker.isCalled(mant, int[].class, 857, 27369, 27372)[((CallChecker.isCalled(mant, int[].class, 857, 27374, 27377).length) - 1)]) != 0) || (isInfinite()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4031.methodEnd();
        }
    }

    public Dfp abs() {
        MethodContext _bcornu_methode_context4032 = new MethodContext(Dfp.class, 865, 27427, 27650);
        try {
            CallChecker.varInit(this, "this", 865, 27427, 27650);
            CallChecker.varInit(this.field, "field", 865, 27427, 27650);
            CallChecker.varInit(this.nans, "nans", 865, 27427, 27650);
            CallChecker.varInit(this.exp, "exp", 865, 27427, 27650);
            CallChecker.varInit(this.sign, "sign", 865, 27427, 27650);
            CallChecker.varInit(this.mant, "mant", 865, 27427, 27650);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 865, 27427, 27650);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 865, 27427, 27650);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 865, 27427, 27650);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 865, 27427, 27650);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 865, 27427, 27650);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 865, 27427, 27650);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 865, 27427, 27650);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 865, 27427, 27650);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 865, 27427, 27650);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 865, 27427, 27650);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 865, 27427, 27650);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 865, 27427, 27650);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 865, 27427, 27650);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 865, 27427, 27650);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 865, 27427, 27650);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 865, 27427, 27650);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 865, 27427, 27650);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 865, 27427, 27650);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 865, 27427, 27650);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 865, 27427, 27650);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 865, 27427, 27650);
            Dfp result = CallChecker.varInit(newInstance(this), "result", 866, 27566, 27596);
            if (CallChecker.beforeDeref(result, Dfp.class, 867, 27606, 27611)) {
                result = CallChecker.beforeCalled(result, Dfp.class, 867, 27606, 27611);
                CallChecker.isCalled(result, Dfp.class, 867, 27606, 27611).sign = 1;
                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 867, 27606, 27611).sign, "CallChecker.isCalled(result, Dfp.class, 867, 27606, 27611).sign", 867, 27606, 27621);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4032.methodEnd();
        }
    }

    public boolean isInfinite() {
        MethodContext _bcornu_methode_context4033 = new MethodContext(boolean.class, 874, 27657, 27815);
        try {
            CallChecker.varInit(this, "this", 874, 27657, 27815);
            CallChecker.varInit(this.field, "field", 874, 27657, 27815);
            CallChecker.varInit(this.nans, "nans", 874, 27657, 27815);
            CallChecker.varInit(this.exp, "exp", 874, 27657, 27815);
            CallChecker.varInit(this.sign, "sign", 874, 27657, 27815);
            CallChecker.varInit(this.mant, "mant", 874, 27657, 27815);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 874, 27657, 27815);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 874, 27657, 27815);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 874, 27657, 27815);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 874, 27657, 27815);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 874, 27657, 27815);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 874, 27657, 27815);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 874, 27657, 27815);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 874, 27657, 27815);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 874, 27657, 27815);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 874, 27657, 27815);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 874, 27657, 27815);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 874, 27657, 27815);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 874, 27657, 27815);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 874, 27657, 27815);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 874, 27657, 27815);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 874, 27657, 27815);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 874, 27657, 27815);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 874, 27657, 27815);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 874, 27657, 27815);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 874, 27657, 27815);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 874, 27657, 27815);
            return (nans) == (Dfp.INFINITE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4033.methodEnd();
        }
    }

    public boolean isNaN() {
        MethodContext _bcornu_methode_context4034 = new MethodContext(boolean.class, 881, 27822, 27999);
        try {
            CallChecker.varInit(this, "this", 881, 27822, 27999);
            CallChecker.varInit(this.field, "field", 881, 27822, 27999);
            CallChecker.varInit(this.nans, "nans", 881, 27822, 27999);
            CallChecker.varInit(this.exp, "exp", 881, 27822, 27999);
            CallChecker.varInit(this.sign, "sign", 881, 27822, 27999);
            CallChecker.varInit(this.mant, "mant", 881, 27822, 27999);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 881, 27822, 27999);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 881, 27822, 27999);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 881, 27822, 27999);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 881, 27822, 27999);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 881, 27822, 27999);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 881, 27822, 27999);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 881, 27822, 27999);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 881, 27822, 27999);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 881, 27822, 27999);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 881, 27822, 27999);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 881, 27822, 27999);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 881, 27822, 27999);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 881, 27822, 27999);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 881, 27822, 27999);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 881, 27822, 27999);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 881, 27822, 27999);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 881, 27822, 27999);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 881, 27822, 27999);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 881, 27822, 27999);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 881, 27822, 27999);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 881, 27822, 27999);
            return ((nans) == (Dfp.QNAN)) || ((nans) == (Dfp.SNAN));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4034.methodEnd();
        }
    }

    public boolean isZero() {
        MethodContext _bcornu_methode_context4035 = new MethodContext(boolean.class, 888, 28006, 28409);
        try {
            CallChecker.varInit(this, "this", 888, 28006, 28409);
            CallChecker.varInit(this.field, "field", 888, 28006, 28409);
            CallChecker.varInit(this.nans, "nans", 888, 28006, 28409);
            CallChecker.varInit(this.exp, "exp", 888, 28006, 28409);
            CallChecker.varInit(this.sign, "sign", 888, 28006, 28409);
            CallChecker.varInit(this.mant, "mant", 888, 28006, 28409);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 888, 28006, 28409);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 888, 28006, 28409);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 888, 28006, 28409);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 888, 28006, 28409);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 888, 28006, 28409);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 888, 28006, 28409);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 888, 28006, 28409);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 888, 28006, 28409);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 888, 28006, 28409);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 888, 28006, 28409);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 888, 28006, 28409);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 888, 28006, 28409);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 888, 28006, 28409);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 888, 28006, 28409);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 888, 28006, 28409);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 888, 28006, 28409);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 888, 28006, 28409);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 888, 28006, 28409);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 888, 28006, 28409);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 888, 28006, 28409);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 888, 28006, 28409);
            if (isNaN()) {
                if (CallChecker.beforeDeref(field, DfpField.class, 891, 28169, 28173)) {
                    CallChecker.isCalled(field, DfpField.class, 891, 28169, 28173).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                }
                dotrap(DfpField.FLAG_INVALID, Dfp.LESS_THAN_TRAP, this, newInstance(getZero()));
                return false;
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 896, 28363, 28366);
            mant = CallChecker.beforeCalled(mant, int[].class, 896, 28358, 28361);
            return ((CallChecker.isCalled(mant, int[].class, 896, 28358, 28361)[((CallChecker.isCalled(mant, int[].class, 896, 28363, 28366).length) - 1)]) == 0) && (!(isInfinite()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4035.methodEnd();
        }
    }

    @Override
    public boolean equals(final Object other) {
        MethodContext _bcornu_methode_context4036 = new MethodContext(boolean.class, 905, 28416, 28954);
        try {
            CallChecker.varInit(this, "this", 905, 28416, 28954);
            CallChecker.varInit(other, "other", 905, 28416, 28954);
            CallChecker.varInit(this.field, "field", 905, 28416, 28954);
            CallChecker.varInit(this.nans, "nans", 905, 28416, 28954);
            CallChecker.varInit(this.exp, "exp", 905, 28416, 28954);
            CallChecker.varInit(this.sign, "sign", 905, 28416, 28954);
            CallChecker.varInit(this.mant, "mant", 905, 28416, 28954);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 905, 28416, 28954);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 905, 28416, 28954);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 905, 28416, 28954);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 905, 28416, 28954);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 905, 28416, 28954);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 905, 28416, 28954);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 905, 28416, 28954);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 905, 28416, 28954);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 905, 28416, 28954);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 905, 28416, 28954);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 905, 28416, 28954);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 905, 28416, 28954);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 905, 28416, 28954);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 905, 28416, 28954);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 905, 28416, 28954);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 905, 28416, 28954);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 905, 28416, 28954);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 905, 28416, 28954);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 905, 28416, 28954);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 905, 28416, 28954);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 905, 28416, 28954);
            if (other instanceof Dfp) {
                final Dfp x = CallChecker.varInit(((Dfp) (other)), "x", 908, 28708, 28733);
                if (CallChecker.beforeDeref(x, Dfp.class, 909, 28762, 28762)) {
                    if (CallChecker.beforeDeref(field, DfpField.class, 909, 28775, 28779)) {
                        if (CallChecker.beforeDeref(x, Dfp.class, 909, 28801, 28801)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 909, 28801, 28801).field, DfpField.class, 909, 28801, 28807)) {
                                if (((isNaN()) || (CallChecker.isCalled(x, Dfp.class, 909, 28762, 28762).isNaN())) || ((CallChecker.isCalled(field, DfpField.class, 909, 28775, 28779).getRadixDigits()) != (CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 909, 28801, 28801).field, DfpField.class, 909, 28801, 28807).getRadixDigits()))) {
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
                
                return (Dfp.compare(this, x)) == 0;
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4036.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context4037 = new MethodContext(int.class, 925, 28961, 29187);
        try {
            CallChecker.varInit(this, "this", 925, 28961, 29187);
            CallChecker.varInit(this.field, "field", 925, 28961, 29187);
            CallChecker.varInit(this.nans, "nans", 925, 28961, 29187);
            CallChecker.varInit(this.exp, "exp", 925, 28961, 29187);
            CallChecker.varInit(this.sign, "sign", 925, 28961, 29187);
            CallChecker.varInit(this.mant, "mant", 925, 28961, 29187);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 925, 28961, 29187);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 925, 28961, 29187);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 925, 28961, 29187);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 925, 28961, 29187);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 925, 28961, 29187);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 925, 28961, 29187);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 925, 28961, 29187);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 925, 28961, 29187);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 925, 28961, 29187);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 925, 28961, 29187);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 925, 28961, 29187);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 925, 28961, 29187);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 925, 28961, 29187);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 925, 28961, 29187);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 925, 28961, 29187);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 925, 28961, 29187);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 925, 28961, 29187);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 925, 28961, 29187);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 925, 28961, 29187);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 925, 28961, 29187);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 925, 28961, 29187);
            return (((17 + ((sign) << 8)) + ((nans) << 16)) + (exp)) + (Arrays.hashCode(mant));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4037.methodEnd();
        }
    }

    public boolean unequal(final Dfp x) {
        MethodContext _bcornu_methode_context4038 = new MethodContext(boolean.class, 933, 29194, 29598);
        try {
            CallChecker.varInit(this, "this", 933, 29194, 29598);
            CallChecker.varInit(x, "x", 933, 29194, 29598);
            CallChecker.varInit(this.field, "field", 933, 29194, 29598);
            CallChecker.varInit(this.nans, "nans", 933, 29194, 29598);
            CallChecker.varInit(this.exp, "exp", 933, 29194, 29598);
            CallChecker.varInit(this.sign, "sign", 933, 29194, 29598);
            CallChecker.varInit(this.mant, "mant", 933, 29194, 29598);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 933, 29194, 29598);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 933, 29194, 29598);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 933, 29194, 29598);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 933, 29194, 29598);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 933, 29194, 29598);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 933, 29194, 29598);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 933, 29194, 29598);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 933, 29194, 29598);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 933, 29194, 29598);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 933, 29194, 29598);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 933, 29194, 29598);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 933, 29194, 29598);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 933, 29194, 29598);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 933, 29194, 29598);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 933, 29194, 29598);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 933, 29194, 29598);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 933, 29194, 29598);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 933, 29194, 29598);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 933, 29194, 29598);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 933, 29194, 29598);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 933, 29194, 29598);
            if (CallChecker.beforeDeref(x, Dfp.class, 934, 29444, 29444)) {
                if (CallChecker.beforeDeref(field, DfpField.class, 934, 29457, 29461)) {
                    if (CallChecker.beforeDeref(x, Dfp.class, 934, 29483, 29483)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 934, 29483, 29483).field, DfpField.class, 934, 29483, 29489)) {
                            if (((isNaN()) || (CallChecker.isCalled(x, Dfp.class, 934, 29444, 29444).isNaN())) || ((CallChecker.isCalled(field, DfpField.class, 934, 29457, 29461).getRadixDigits()) != (CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 934, 29483, 29483).field, DfpField.class, 934, 29483, 29489).getRadixDigits()))) {
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
            
            return (greaterThan(x)) || (lessThan(x));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4038.methodEnd();
        }
    }

    private static int compare(final Dfp a, final Dfp b) {
        MethodContext _bcornu_methode_context4039 = new MethodContext(int.class, 947, 29605, 31223);
        try {
            CallChecker.varInit(b, "b", 947, 29605, 31223);
            CallChecker.varInit(a, "a", 947, 29605, 31223);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 947, 29605, 31223);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 947, 29605, 31223);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 947, 29605, 31223);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 947, 29605, 31223);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 947, 29605, 31223);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 947, 29605, 31223);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 947, 29605, 31223);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 947, 29605, 31223);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 947, 29605, 31223);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 947, 29605, 31223);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 947, 29605, 31223);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 947, 29605, 31223);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 947, 29605, 31223);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 947, 29605, 31223);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 947, 29605, 31223);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 947, 29605, 31223);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 947, 29605, 31223);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 947, 29605, 31223);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 947, 29605, 31223);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 947, 29605, 31223);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 947, 29605, 31223);
            if (CallChecker.beforeDeref(a, Dfp.class, 949, 29978, 29978)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 949, 29985, 29985)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp.class, 949, 29985, 29985).mant, int[].class, 949, 29985, 29990)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp.class, 949, 29978, 29978).mant, int[].class, 949, 29978, 29983)) {
                            if (CallChecker.beforeDeref(b, Dfp.class, 949, 30012, 30012)) {
                                if (CallChecker.beforeDeref(b, Dfp.class, 949, 30019, 30019)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(b, Dfp.class, 949, 30019, 30019).mant, int[].class, 949, 30019, 30024)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(b, Dfp.class, 949, 30012, 30012).mant, int[].class, 949, 30012, 30017)) {
                                            if (CallChecker.beforeDeref(a, Dfp.class, 950, 30058, 30058)) {
                                                if (CallChecker.beforeDeref(b, Dfp.class, 950, 30078, 30078)) {
                                                    CallChecker.isCalled(a, Dfp.class, 949, 29985, 29985).mant = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp.class, 949, 29985, 29985).mant, int[].class, 949, 29985, 29990);
                                                    CallChecker.isCalled(a, Dfp.class, 949, 29978, 29978).mant = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp.class, 949, 29978, 29978).mant, int[].class, 949, 29978, 29983);
                                                    CallChecker.isCalled(b, Dfp.class, 949, 30019, 30019).mant = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp.class, 949, 30019, 30019).mant, int[].class, 949, 30019, 30024);
                                                    CallChecker.isCalled(b, Dfp.class, 949, 30012, 30012).mant = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp.class, 949, 30012, 30012).mant, int[].class, 949, 30012, 30017);
                                                    if (((((CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 949, 29978, 29978).mant, int[].class, 949, 29978, 29983)[((CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 949, 29985, 29985).mant, int[].class, 949, 29985, 29990).length) - 1)]) == 0) && ((CallChecker.isCalled(CallChecker.isCalled(b, Dfp.class, 949, 30012, 30012).mant, int[].class, 949, 30012, 30017)[((CallChecker.isCalled(CallChecker.isCalled(b, Dfp.class, 949, 30019, 30019).mant, int[].class, 949, 30019, 30024).length) - 1)]) == 0)) && ((CallChecker.isCalled(a, Dfp.class, 950, 30058, 30058).nans) == (Dfp.FINITE))) && ((CallChecker.isCalled(b, Dfp.class, 950, 30078, 30078).nans) == (Dfp.FINITE))) {
                                                        return 0;
                                                    }
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(a, Dfp.class, 954, 30143, 30143)) {
                if (CallChecker.beforeDeref(b, Dfp.class, 954, 30153, 30153)) {
                    if ((CallChecker.isCalled(a, Dfp.class, 954, 30143, 30143).sign) != (CallChecker.isCalled(b, Dfp.class, 954, 30153, 30153).sign)) {
                        if (CallChecker.beforeDeref(a, Dfp.class, 955, 30179, 30179)) {
                            if ((CallChecker.isCalled(a, Dfp.class, 955, 30179, 30179).sign) == (-1)) {
                                return -1;
                            }else {
                                return 1;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(a, Dfp.class, 963, 30342, 30342)) {
                if (CallChecker.beforeDeref(b, Dfp.class, 963, 30364, 30364)) {
                    if (((CallChecker.isCalled(a, Dfp.class, 963, 30342, 30342).nans) == (Dfp.INFINITE)) && ((CallChecker.isCalled(b, Dfp.class, 963, 30364, 30364).nans) == (Dfp.FINITE))) {
                        if (CallChecker.beforeDeref(a, Dfp.class, 964, 30403, 30403)) {
                            return CallChecker.isCalled(a, Dfp.class, 964, 30403, 30403).sign;
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(a, Dfp.class, 967, 30434, 30434)) {
                if (CallChecker.beforeDeref(b, Dfp.class, 967, 30454, 30454)) {
                    if (((CallChecker.isCalled(a, Dfp.class, 967, 30434, 30434).nans) == (Dfp.FINITE)) && ((CallChecker.isCalled(b, Dfp.class, 967, 30454, 30454).nans) == (Dfp.INFINITE))) {
                        if (CallChecker.beforeDeref(b, Dfp.class, 968, 30496, 30496)) {
                            return -(CallChecker.isCalled(b, Dfp.class, 968, 30496, 30496).sign);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(a, Dfp.class, 971, 30527, 30527)) {
                if (CallChecker.beforeDeref(b, Dfp.class, 971, 30549, 30549)) {
                    if (((CallChecker.isCalled(a, Dfp.class, 971, 30527, 30527).nans) == (Dfp.INFINITE)) && ((CallChecker.isCalled(b, Dfp.class, 971, 30549, 30549).nans) == (Dfp.INFINITE))) {
                        return 0;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(b, Dfp.class, 976, 30694, 30694)) {
                if (CallChecker.beforeDeref(b, Dfp.class, 976, 30701, 30701)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(b, Dfp.class, 976, 30701, 30701).mant, int[].class, 976, 30701, 30706)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(b, Dfp.class, 976, 30694, 30694).mant, int[].class, 976, 30694, 30699)) {
                            if (CallChecker.beforeDeref(a, Dfp.class, 976, 30726, 30726)) {
                                if (CallChecker.beforeDeref(b, Dfp.class, 976, 30733, 30733)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(b, Dfp.class, 976, 30733, 30733).mant, int[].class, 976, 30733, 30738)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp.class, 976, 30726, 30726).mant, int[].class, 976, 30726, 30731)) {
                                            CallChecker.isCalled(b, Dfp.class, 976, 30701, 30701).mant = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp.class, 976, 30701, 30701).mant, int[].class, 976, 30701, 30706);
                                            CallChecker.isCalled(b, Dfp.class, 976, 30694, 30694).mant = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp.class, 976, 30694, 30694).mant, int[].class, 976, 30694, 30699);
                                            CallChecker.isCalled(b, Dfp.class, 976, 30733, 30733).mant = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp.class, 976, 30733, 30733).mant, int[].class, 976, 30733, 30738);
                                            CallChecker.isCalled(a, Dfp.class, 976, 30726, 30726).mant = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp.class, 976, 30726, 30726).mant, int[].class, 976, 30726, 30731);
                                            if (((CallChecker.isCalled(CallChecker.isCalled(b, Dfp.class, 976, 30694, 30694).mant, int[].class, 976, 30694, 30699)[((CallChecker.isCalled(CallChecker.isCalled(b, Dfp.class, 976, 30701, 30701).mant, int[].class, 976, 30701, 30706).length) - 1)]) != 0) && ((CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 976, 30726, 30726).mant, int[].class, 976, 30726, 30731)[((CallChecker.isCalled(CallChecker.isCalled(b, Dfp.class, 976, 30733, 30733).mant, int[].class, 976, 30733, 30738).length) - 1)]) != 0)) {
                                                if (CallChecker.beforeDeref(a, Dfp.class, 977, 30774, 30774)) {
                                                    if (CallChecker.beforeDeref(b, Dfp.class, 977, 30782, 30782)) {
                                                        if ((CallChecker.isCalled(a, Dfp.class, 977, 30774, 30774).exp) < (CallChecker.isCalled(b, Dfp.class, 977, 30782, 30782).exp)) {
                                                            if (CallChecker.beforeDeref(a, Dfp.class, 978, 30815, 30815)) {
                                                                return -(CallChecker.isCalled(a, Dfp.class, 978, 30815, 30815).sign);
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                if (CallChecker.beforeDeref(a, Dfp.class, 981, 30854, 30854)) {
                                                    if (CallChecker.beforeDeref(b, Dfp.class, 981, 30862, 30862)) {
                                                        if ((CallChecker.isCalled(a, Dfp.class, 981, 30854, 30854).exp) > (CallChecker.isCalled(b, Dfp.class, 981, 30862, 30862).exp)) {
                                                            if (CallChecker.beforeDeref(a, Dfp.class, 982, 30894, 30894)) {
                                                                return CallChecker.isCalled(a, Dfp.class, 982, 30894, 30894).sign;
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            CallChecker.isCalled(a, Dfp.class, 987, 30981, 30981).mant = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp.class, 987, 30981, 30981).mant, int[].class, 987, 30981, 30986);
            for (int i = (CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 987, 30981, 30981).mant, int[].class, 987, 30981, 30986).length) - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(a, Dfp.class, 988, 31031, 31031)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp.class, 988, 31031, 31031).mant, int[].class, 988, 31031, 31036)) {
                        if (CallChecker.beforeDeref(b, Dfp.class, 988, 31043, 31043)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(b, Dfp.class, 988, 31043, 31043).mant, int[].class, 988, 31043, 31048)) {
                                CallChecker.isCalled(a, Dfp.class, 988, 31031, 31031).mant = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp.class, 988, 31031, 31031).mant, int[].class, 988, 31031, 31036);
                                CallChecker.isCalled(b, Dfp.class, 988, 31043, 31043).mant = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp.class, 988, 31043, 31043).mant, int[].class, 988, 31043, 31048);
                                if ((CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 988, 31031, 31031).mant, int[].class, 988, 31031, 31036)[i]) > (CallChecker.isCalled(CallChecker.isCalled(b, Dfp.class, 988, 31043, 31043).mant, int[].class, 988, 31043, 31048)[i])) {
                                    if (CallChecker.beforeDeref(a, Dfp.class, 989, 31079, 31079)) {
                                        return CallChecker.isCalled(a, Dfp.class, 989, 31079, 31079).sign;
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(a, Dfp.class, 992, 31118, 31118)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp.class, 992, 31118, 31118).mant, int[].class, 992, 31118, 31123)) {
                        if (CallChecker.beforeDeref(b, Dfp.class, 992, 31130, 31130)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(b, Dfp.class, 992, 31130, 31130).mant, int[].class, 992, 31130, 31135)) {
                                CallChecker.isCalled(a, Dfp.class, 992, 31118, 31118).mant = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp.class, 992, 31118, 31118).mant, int[].class, 992, 31118, 31123);
                                CallChecker.isCalled(b, Dfp.class, 992, 31130, 31130).mant = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp.class, 992, 31130, 31130).mant, int[].class, 992, 31130, 31135);
                                if ((CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 992, 31118, 31118).mant, int[].class, 992, 31118, 31123)[i]) < (CallChecker.isCalled(CallChecker.isCalled(b, Dfp.class, 992, 31130, 31130).mant, int[].class, 992, 31130, 31135)[i])) {
                                    if (CallChecker.beforeDeref(a, Dfp.class, 993, 31167, 31167)) {
                                        return -(CallChecker.isCalled(a, Dfp.class, 993, 31167, 31167).sign);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4039.methodEnd();
        }
    }

    public Dfp rint() {
        MethodContext _bcornu_methode_context4040 = new MethodContext(Dfp.class, 1007, 31230, 31553);
        try {
            CallChecker.varInit(this, "this", 1007, 31230, 31553);
            CallChecker.varInit(this.field, "field", 1007, 31230, 31553);
            CallChecker.varInit(this.nans, "nans", 1007, 31230, 31553);
            CallChecker.varInit(this.exp, "exp", 1007, 31230, 31553);
            CallChecker.varInit(this.sign, "sign", 1007, 31230, 31553);
            CallChecker.varInit(this.mant, "mant", 1007, 31230, 31553);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1007, 31230, 31553);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1007, 31230, 31553);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1007, 31230, 31553);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1007, 31230, 31553);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1007, 31230, 31553);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1007, 31230, 31553);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1007, 31230, 31553);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1007, 31230, 31553);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1007, 31230, 31553);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1007, 31230, 31553);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1007, 31230, 31553);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1007, 31230, 31553);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1007, 31230, 31553);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1007, 31230, 31553);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1007, 31230, 31553);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1007, 31230, 31553);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1007, 31230, 31553);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1007, 31230, 31553);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1007, 31230, 31553);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1007, 31230, 31553);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1007, 31230, 31553);
            return trunc(ROUND_HALF_EVEN);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4040.methodEnd();
        }
    }

    public Dfp floor() {
        MethodContext _bcornu_methode_context4041 = new MethodContext(Dfp.class, 1016, 31560, 31793);
        try {
            CallChecker.varInit(this, "this", 1016, 31560, 31793);
            CallChecker.varInit(this.field, "field", 1016, 31560, 31793);
            CallChecker.varInit(this.nans, "nans", 1016, 31560, 31793);
            CallChecker.varInit(this.exp, "exp", 1016, 31560, 31793);
            CallChecker.varInit(this.sign, "sign", 1016, 31560, 31793);
            CallChecker.varInit(this.mant, "mant", 1016, 31560, 31793);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1016, 31560, 31793);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1016, 31560, 31793);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1016, 31560, 31793);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1016, 31560, 31793);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1016, 31560, 31793);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1016, 31560, 31793);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1016, 31560, 31793);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1016, 31560, 31793);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1016, 31560, 31793);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1016, 31560, 31793);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1016, 31560, 31793);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1016, 31560, 31793);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1016, 31560, 31793);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1016, 31560, 31793);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1016, 31560, 31793);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1016, 31560, 31793);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1016, 31560, 31793);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1016, 31560, 31793);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1016, 31560, 31793);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1016, 31560, 31793);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1016, 31560, 31793);
            return trunc(ROUND_FLOOR);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4041.methodEnd();
        }
    }

    public Dfp ceil() {
        MethodContext _bcornu_methode_context4042 = new MethodContext(Dfp.class, 1025, 31800, 32030);
        try {
            CallChecker.varInit(this, "this", 1025, 31800, 32030);
            CallChecker.varInit(this.field, "field", 1025, 31800, 32030);
            CallChecker.varInit(this.nans, "nans", 1025, 31800, 32030);
            CallChecker.varInit(this.exp, "exp", 1025, 31800, 32030);
            CallChecker.varInit(this.sign, "sign", 1025, 31800, 32030);
            CallChecker.varInit(this.mant, "mant", 1025, 31800, 32030);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1025, 31800, 32030);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1025, 31800, 32030);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1025, 31800, 32030);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1025, 31800, 32030);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1025, 31800, 32030);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1025, 31800, 32030);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1025, 31800, 32030);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1025, 31800, 32030);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1025, 31800, 32030);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1025, 31800, 32030);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1025, 31800, 32030);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1025, 31800, 32030);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1025, 31800, 32030);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1025, 31800, 32030);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1025, 31800, 32030);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1025, 31800, 32030);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1025, 31800, 32030);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1025, 31800, 32030);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1025, 31800, 32030);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1025, 31800, 32030);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1025, 31800, 32030);
            return trunc(ROUND_CEIL);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4042.methodEnd();
        }
    }

    public Dfp remainder(final Dfp d) {
        MethodContext _bcornu_methode_context4043 = new MethodContext(Dfp.class, 1034, 32037, 32526);
        try {
            CallChecker.varInit(this, "this", 1034, 32037, 32526);
            CallChecker.varInit(d, "d", 1034, 32037, 32526);
            CallChecker.varInit(this.field, "field", 1034, 32037, 32526);
            CallChecker.varInit(this.nans, "nans", 1034, 32037, 32526);
            CallChecker.varInit(this.exp, "exp", 1034, 32037, 32526);
            CallChecker.varInit(this.sign, "sign", 1034, 32037, 32526);
            CallChecker.varInit(this.mant, "mant", 1034, 32037, 32526);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1034, 32037, 32526);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1034, 32037, 32526);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1034, 32037, 32526);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1034, 32037, 32526);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1034, 32037, 32526);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1034, 32037, 32526);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1034, 32037, 32526);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1034, 32037, 32526);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1034, 32037, 32526);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1034, 32037, 32526);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1034, 32037, 32526);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1034, 32037, 32526);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1034, 32037, 32526);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1034, 32037, 32526);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1034, 32037, 32526);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1034, 32037, 32526);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1034, 32037, 32526);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1034, 32037, 32526);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1034, 32037, 32526);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1034, 32037, 32526);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1034, 32037, 32526);
            final Dfp result = CallChecker.varInit(this.subtract(CallChecker.isCalled(CallChecker.isCalled(this.divide(d), Dfp.class, 1036, 32280, 32293).rint(), Dfp.class, 1036, 32280, 32300).multiply(d)), "result", 1036, 32247, 32314);
            if (CallChecker.beforeDeref(result, Dfp.class, 1039, 32420, 32425)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1039, 32432, 32435)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1039, 32420, 32425).mant, int[].class, 1039, 32420, 32430)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 1039, 32432, 32435);
                        CallChecker.isCalled(result, Dfp.class, 1039, 32420, 32425).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1039, 32420, 32425).mant, int[].class, 1039, 32420, 32430);
                        if ((CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1039, 32420, 32425).mant, int[].class, 1039, 32420, 32430)[((CallChecker.isCalled(mant, int[].class, 1039, 32432, 32435).length) - 1)]) == 0) {
                            if (CallChecker.beforeDeref(result, Dfp.class, 1040, 32467, 32472)) {
                                CallChecker.isCalled(result, Dfp.class, 1040, 32467, 32472).sign = sign;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1040, 32467, 32472).sign, "CallChecker.isCalled(result, Dfp.class, 1040, 32467, 32472).sign", 1040, 32467, 32485);
                            }
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4043.methodEnd();
        }
    }

    protected Dfp trunc(final DfpField.RoundingMode rmode) {
        MethodContext _bcornu_methode_context4044 = new MethodContext(Dfp.class, 1051, 32533, 35609);
        try {
            CallChecker.varInit(this, "this", 1051, 32533, 35609);
            CallChecker.varInit(rmode, "rmode", 1051, 32533, 35609);
            CallChecker.varInit(this.field, "field", 1051, 32533, 35609);
            CallChecker.varInit(this.nans, "nans", 1051, 32533, 35609);
            CallChecker.varInit(this.exp, "exp", 1051, 32533, 35609);
            CallChecker.varInit(this.sign, "sign", 1051, 32533, 35609);
            CallChecker.varInit(this.mant, "mant", 1051, 32533, 35609);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1051, 32533, 35609);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1051, 32533, 35609);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1051, 32533, 35609);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1051, 32533, 35609);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1051, 32533, 35609);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1051, 32533, 35609);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1051, 32533, 35609);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1051, 32533, 35609);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1051, 32533, 35609);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1051, 32533, 35609);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1051, 32533, 35609);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1051, 32533, 35609);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1051, 32533, 35609);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1051, 32533, 35609);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1051, 32533, 35609);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1051, 32533, 35609);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1051, 32533, 35609);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1051, 32533, 35609);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1051, 32533, 35609);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1051, 32533, 35609);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1051, 32533, 35609);
            boolean changed = CallChecker.varInit(((boolean) (false)), "changed", 1052, 32744, 32767);
            if (isNaN()) {
                return newInstance(this);
            }
            if ((nans) == (Dfp.INFINITE)) {
                return newInstance(this);
            }
            if (CallChecker.beforeDeref(mant, int[].class, 1062, 32940, 32943)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1062, 32935, 32938)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1062, 32940, 32943);
                    mant = CallChecker.beforeCalled(mant, int[].class, 1062, 32935, 32938);
                    if ((CallChecker.isCalled(mant, int[].class, 1062, 32935, 32938)[((CallChecker.isCalled(mant, int[].class, 1062, 32940, 32943).length) - 1)]) == 0) {
                        return newInstance(this);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if ((exp) < 0) {
                if (CallChecker.beforeDeref(field, DfpField.class, 1070, 33165, 33169)) {
                    CallChecker.isCalled(field, DfpField.class, 1070, 33165, 33169).setIEEEFlagsBits(DfpField.FLAG_INEXACT);
                }
                Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 1071, 33224, 33259);
                result = dotrap(DfpField.FLAG_INEXACT, Dfp.TRUNC_TRAP, this, result);
                CallChecker.varAssign(result, "result", 1072, 33273, 33337);
                return result;
            }
            if (CallChecker.beforeDeref(mant, int[].class, 1080, 33577, 33580)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 1080, 33577, 33580);
                if ((exp) >= (CallChecker.isCalled(mant, int[].class, 1080, 33577, 33580).length)) {
                    return newInstance(this);
                }
            }else
                throw new AbnormalExecutionError();
            
            Dfp result = CallChecker.varInit(newInstance(this), "result", 1087, 33776, 33806);
            mant = CallChecker.beforeCalled(mant, int[].class, 1088, 33836, 33839);
            result = CallChecker.beforeCalled(result, Dfp.class, 1088, 33848, 33853);
            for (int i = 0; i < ((CallChecker.isCalled(mant, int[].class, 1088, 33836, 33839).length) - (CallChecker.isCalled(result, Dfp.class, 1088, 33848, 33853).exp)); i++) {
                if (CallChecker.beforeDeref(result, Dfp.class, 1089, 33890, 33895)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1089, 33890, 33895);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1089, 33890, 33895).mant, int[].class, 1089, 33890, 33900)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1089, 33890, 33895);
                        CallChecker.isCalled(result, Dfp.class, 1089, 33890, 33895).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1089, 33890, 33895).mant, int[].class, 1089, 33890, 33900);
                        changed |= (CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1089, 33890, 33895).mant, int[].class, 1089, 33890, 33900)[i]) != 0;
                        CallChecker.varAssign(changed, "changed", 1089, 33879, 33909);
                    }
                }
                if (CallChecker.beforeDeref(result, Dfp.class, 1090, 33923, 33928)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1090, 33923, 33928);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1090, 33923, 33928).mant, int[].class, 1090, 33923, 33933)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1090, 33923, 33928);
                        CallChecker.isCalled(result, Dfp.class, 1090, 33923, 33928).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1090, 33923, 33928).mant, int[].class, 1090, 33923, 33933);
                        CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1090, 33923, 33928).mant, int[].class, 1090, 33923, 33933)[i] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1090, 33923, 33928).mant, int[].class, 1090, 33923, 33933)[i], "CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1090, 33923, 33928).mant, int[].class, 1090, 33923, 33933)[i]", 1090, 33923, 33941);
                    }
                }
            }
            if (changed) {
                switch (rmode) {
                    case ROUND_FLOOR :
                        if (CallChecker.beforeDeref(result, Dfp.class, 1096, 34064, 34069)) {
                            result = CallChecker.beforeCalled(result, Dfp.class, 1096, 34064, 34069);
                            if ((CallChecker.isCalled(result, Dfp.class, 1096, 34064, 34069).sign) == (-1)) {
                                if (CallChecker.beforeDeref(result, Dfp.class, 1098, 34188, 34193)) {
                                    result = CallChecker.beforeCalled(result, Dfp.class, 1098, 34188, 34193);
                                    result = CallChecker.isCalled(result, Dfp.class, 1098, 34188, 34193).add(newInstance((-1)));
                                    CallChecker.varAssign(result, "result", 1098, 34179, 34215);
                                }
                            }
                        }
                        break;
                    case ROUND_CEIL :
                        if (CallChecker.beforeDeref(result, Dfp.class, 1103, 34324, 34329)) {
                            result = CallChecker.beforeCalled(result, Dfp.class, 1103, 34324, 34329);
                            if ((CallChecker.isCalled(result, Dfp.class, 1103, 34324, 34329).sign) == 1) {
                                if (CallChecker.beforeDeref(result, Dfp.class, 1105, 34447, 34452)) {
                                    result = CallChecker.beforeCalled(result, Dfp.class, 1105, 34447, 34452);
                                    result = CallChecker.isCalled(result, Dfp.class, 1105, 34447, 34452).add(getOne());
                                    CallChecker.varAssign(result, "result", 1105, 34438, 34467);
                                }
                            }
                        }
                        break;
                    case ROUND_HALF_EVEN :
                    default :
                        final Dfp half = CallChecker.varInit(newInstance("0.5"), "half", 1111, 34602, 34637);
                        Dfp a = CallChecker.varInit(subtract(result), "a", 1112, 34659, 34683);
                        if (CallChecker.beforeDeref(a, Dfp.class, 1113, 34744, 34744)) {
                            a = CallChecker.beforeCalled(a, Dfp.class, 1113, 34744, 34744);
                            CallChecker.isCalled(a, Dfp.class, 1113, 34744, 34744).sign = 1;
                            CallChecker.varAssign(CallChecker.isCalled(a, Dfp.class, 1113, 34744, 34744).sign, "CallChecker.isCalled(a, Dfp.class, 1113, 34744, 34744).sign", 1113, 34744, 34754);
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(a, Dfp.class, 1114, 34820, 34820)) {
                            a = CallChecker.beforeCalled(a, Dfp.class, 1114, 34820, 34820);
                            if (CallChecker.isCalled(a, Dfp.class, 1114, 34820, 34820).greaterThan(half)) {
                                a = newInstance(getOne());
                                CallChecker.varAssign(a, "a", 1115, 34867, 34892);
                                if (CallChecker.beforeDeref(a, Dfp.class, 1116, 34918, 34918)) {
                                    a = CallChecker.beforeCalled(a, Dfp.class, 1116, 34918, 34918);
                                    CallChecker.isCalled(a, Dfp.class, 1116, 34918, 34918).sign = sign;
                                    CallChecker.varAssign(CallChecker.isCalled(a, Dfp.class, 1116, 34918, 34918).sign, "CallChecker.isCalled(a, Dfp.class, 1116, 34918, 34918).sign", 1116, 34918, 34931);
                                }
                                if (CallChecker.beforeDeref(result, Dfp.class, 1117, 34966, 34971)) {
                                    result = CallChecker.beforeCalled(result, Dfp.class, 1117, 34966, 34971);
                                    result = CallChecker.isCalled(result, Dfp.class, 1117, 34966, 34971).add(a);
                                    CallChecker.varAssign(result, "result", 1117, 34957, 34979);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(a, Dfp.class, 1121, 35102, 35102)) {
                            if (CallChecker.beforeDeref(result, Dfp.class, 1121, 35120, 35125)) {
                                if (CallChecker.beforeDeref(result, Dfp.class, 1121, 35139, 35144)) {
                                    if (CallChecker.beforeDeref(mant, int[].class, 1121, 35151, 35154)) {
                                        if (CallChecker.beforeDeref(result, Dfp.class, 1121, 35163, 35168)) {
                                            result = CallChecker.beforeCalled(result, Dfp.class, 1121, 35139, 35144);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1121, 35139, 35144).mant, int[].class, 1121, 35139, 35149)) {
                                                a = CallChecker.beforeCalled(a, Dfp.class, 1121, 35102, 35102);
                                                result = CallChecker.beforeCalled(result, Dfp.class, 1121, 35120, 35125);
                                                result = CallChecker.beforeCalled(result, Dfp.class, 1121, 35139, 35144);
                                                mant = CallChecker.beforeCalled(mant, int[].class, 1121, 35151, 35154);
                                                result = CallChecker.beforeCalled(result, Dfp.class, 1121, 35163, 35168);
                                                CallChecker.isCalled(result, Dfp.class, 1121, 35139, 35144).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1121, 35139, 35144).mant, int[].class, 1121, 35139, 35149);
                                                if (((CallChecker.isCalled(a, Dfp.class, 1121, 35102, 35102).equals(half)) && ((CallChecker.isCalled(result, Dfp.class, 1121, 35120, 35125).exp) > 0)) && (((CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1121, 35139, 35144).mant, int[].class, 1121, 35139, 35149)[((CallChecker.isCalled(mant, int[].class, 1121, 35151, 35154).length) - (CallChecker.isCalled(result, Dfp.class, 1121, 35163, 35168).exp))]) & 1) != 0)) {
                                                    a = newInstance(getOne());
                                                    CallChecker.varAssign(a, "a", 1122, 35210, 35235);
                                                    if (CallChecker.beforeDeref(a, Dfp.class, 1123, 35261, 35261)) {
                                                        a = CallChecker.beforeCalled(a, Dfp.class, 1123, 35261, 35261);
                                                        CallChecker.isCalled(a, Dfp.class, 1123, 35261, 35261).sign = sign;
                                                        CallChecker.varAssign(CallChecker.isCalled(a, Dfp.class, 1123, 35261, 35261).sign, "CallChecker.isCalled(a, Dfp.class, 1123, 35261, 35261).sign", 1123, 35261, 35274);
                                                    }
                                                    if (CallChecker.beforeDeref(result, Dfp.class, 1124, 35309, 35314)) {
                                                        result = CallChecker.beforeCalled(result, Dfp.class, 1124, 35309, 35314);
                                                        result = CallChecker.isCalled(result, Dfp.class, 1124, 35309, 35314).add(a);
                                                        CallChecker.varAssign(result, "result", 1124, 35300, 35322);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                }
                if (CallChecker.beforeDeref(field, DfpField.class, 1129, 35400, 35404)) {
                    CallChecker.isCalled(field, DfpField.class, 1129, 35400, 35404).setIEEEFlagsBits(DfpField.FLAG_INEXACT);
                }
                result = dotrap(DfpField.FLAG_INEXACT, Dfp.TRUNC_TRAP, this, result);
                CallChecker.varAssign(result, "result", 1130, 35478, 35542);
                return result;
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4044.methodEnd();
        }
    }

    public int intValue() {
        MethodContext _bcornu_methode_context4045 = new MethodContext(int.class, 1141, 35616, 36344);
        try {
            CallChecker.varInit(this, "this", 1141, 35616, 36344);
            CallChecker.varInit(this.field, "field", 1141, 35616, 36344);
            CallChecker.varInit(this.nans, "nans", 1141, 35616, 36344);
            CallChecker.varInit(this.exp, "exp", 1141, 35616, 36344);
            CallChecker.varInit(this.sign, "sign", 1141, 35616, 36344);
            CallChecker.varInit(this.mant, "mant", 1141, 35616, 36344);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1141, 35616, 36344);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1141, 35616, 36344);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1141, 35616, 36344);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1141, 35616, 36344);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1141, 35616, 36344);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1141, 35616, 36344);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1141, 35616, 36344);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1141, 35616, 36344);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1141, 35616, 36344);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1141, 35616, 36344);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1141, 35616, 36344);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1141, 35616, 36344);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1141, 35616, 36344);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1141, 35616, 36344);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1141, 35616, 36344);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1141, 35616, 36344);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1141, 35616, 36344);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1141, 35616, 36344);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1141, 35616, 36344);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1141, 35616, 36344);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1141, 35616, 36344);
            Dfp rounded = CallChecker.init(Dfp.class);
            int result = CallChecker.varInit(((int) (0)), "result", 1143, 35852, 35866);
            rounded = rint();
            CallChecker.varAssign(rounded, "rounded", 1145, 35877, 35893);
            if (CallChecker.beforeDeref(rounded, Dfp.class, 1147, 35908, 35914)) {
                rounded = CallChecker.beforeCalled(rounded, Dfp.class, 1147, 35908, 35914);
                if (CallChecker.isCalled(rounded, Dfp.class, 1147, 35908, 35914).greaterThan(newInstance(2147483647))) {
                    return 2147483647;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(rounded, Dfp.class, 1151, 36010, 36016)) {
                rounded = CallChecker.beforeCalled(rounded, Dfp.class, 1151, 36010, 36016);
                if (CallChecker.isCalled(rounded, Dfp.class, 1151, 36010, 36016).lessThan(newInstance(-2147483648))) {
                    return -2147483648;
                }
            }else
                throw new AbnormalExecutionError();
            
            mant = CallChecker.beforeCalled(mant, int[].class, 1155, 36120, 36123);
            mant = CallChecker.beforeCalled(mant, int[].class, 1155, 36142, 36145);
            rounded = CallChecker.beforeCalled(rounded, Dfp.class, 1155, 36156, 36162);
            for (int i = (CallChecker.isCalled(mant, int[].class, 1155, 36120, 36123).length) - 1; i >= ((CallChecker.isCalled(mant, int[].class, 1155, 36142, 36145).length) - (CallChecker.isCalled(rounded, Dfp.class, 1155, 36156, 36162).exp)); i--) {
                if (CallChecker.beforeDeref(rounded, Dfp.class, 1156, 36214, 36220)) {
                    rounded = CallChecker.beforeCalled(rounded, Dfp.class, 1156, 36214, 36220);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(rounded, Dfp.class, 1156, 36214, 36220).mant, int[].class, 1156, 36214, 36225)) {
                        rounded = CallChecker.beforeCalled(rounded, Dfp.class, 1156, 36214, 36220);
                        CallChecker.isCalled(rounded, Dfp.class, 1156, 36214, 36220).mant = CallChecker.beforeCalled(CallChecker.isCalled(rounded, Dfp.class, 1156, 36214, 36220).mant, int[].class, 1156, 36214, 36225);
                        result = (result * (Dfp.RADIX)) + (CallChecker.isCalled(CallChecker.isCalled(rounded, Dfp.class, 1156, 36214, 36220).mant, int[].class, 1156, 36214, 36225)[i]);
                        CallChecker.varAssign(result, "result", 1156, 36188, 36229);
                    }
                }
            }
            if (CallChecker.beforeDeref(rounded, Dfp.class, 1159, 36254, 36260)) {
                rounded = CallChecker.beforeCalled(rounded, Dfp.class, 1159, 36254, 36260);
                if ((CallChecker.isCalled(rounded, Dfp.class, 1159, 36254, 36260).sign) == (-1)) {
                    result = -result;
                    CallChecker.varAssign(result, "result", 1160, 36288, 36304);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4045.methodEnd();
        }
    }

    public int log10K() {
        MethodContext _bcornu_methode_context4046 = new MethodContext(int.class, 1171, 36351, 36645);
        try {
            CallChecker.varInit(this, "this", 1171, 36351, 36645);
            CallChecker.varInit(this.field, "field", 1171, 36351, 36645);
            CallChecker.varInit(this.nans, "nans", 1171, 36351, 36645);
            CallChecker.varInit(this.exp, "exp", 1171, 36351, 36645);
            CallChecker.varInit(this.sign, "sign", 1171, 36351, 36645);
            CallChecker.varInit(this.mant, "mant", 1171, 36351, 36645);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1171, 36351, 36645);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1171, 36351, 36645);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1171, 36351, 36645);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1171, 36351, 36645);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1171, 36351, 36645);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1171, 36351, 36645);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1171, 36351, 36645);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1171, 36351, 36645);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1171, 36351, 36645);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1171, 36351, 36645);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1171, 36351, 36645);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1171, 36351, 36645);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1171, 36351, 36645);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1171, 36351, 36645);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1171, 36351, 36645);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1171, 36351, 36645);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1171, 36351, 36645);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1171, 36351, 36645);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1171, 36351, 36645);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1171, 36351, 36645);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1171, 36351, 36645);
            return (exp) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4046.methodEnd();
        }
    }

    public Dfp power10K(final int e) {
        MethodContext _bcornu_methode_context4047 = new MethodContext(Dfp.class, 1179, 36652, 36885);
        try {
            CallChecker.varInit(this, "this", 1179, 36652, 36885);
            CallChecker.varInit(e, "e", 1179, 36652, 36885);
            CallChecker.varInit(this.field, "field", 1179, 36652, 36885);
            CallChecker.varInit(this.nans, "nans", 1179, 36652, 36885);
            CallChecker.varInit(this.exp, "exp", 1179, 36652, 36885);
            CallChecker.varInit(this.sign, "sign", 1179, 36652, 36885);
            CallChecker.varInit(this.mant, "mant", 1179, 36652, 36885);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1179, 36652, 36885);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1179, 36652, 36885);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1179, 36652, 36885);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1179, 36652, 36885);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1179, 36652, 36885);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1179, 36652, 36885);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1179, 36652, 36885);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1179, 36652, 36885);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1179, 36652, 36885);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1179, 36652, 36885);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1179, 36652, 36885);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1179, 36652, 36885);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1179, 36652, 36885);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1179, 36652, 36885);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1179, 36652, 36885);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1179, 36652, 36885);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1179, 36652, 36885);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1179, 36652, 36885);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1179, 36652, 36885);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1179, 36652, 36885);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1179, 36652, 36885);
            Dfp d = CallChecker.varInit(newInstance(getOne()), "d", 1180, 36809, 36838);
            if (CallChecker.beforeDeref(d, Dfp.class, 1181, 36848, 36848)) {
                d = CallChecker.beforeCalled(d, Dfp.class, 1181, 36848, 36848);
                CallChecker.isCalled(d, Dfp.class, 1181, 36848, 36848).exp = e + 1;
                CallChecker.varAssign(CallChecker.isCalled(d, Dfp.class, 1181, 36848, 36848).exp, "CallChecker.isCalled(d, Dfp.class, 1181, 36848, 36848).exp", 1181, 36848, 36861);
            }
            return d;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4047.methodEnd();
        }
    }

    public int intLog10() {
        MethodContext _bcornu_methode_context4048 = new MethodContext(int.class, 1189, 36892, 37360);
        try {
            CallChecker.varInit(this, "this", 1189, 36892, 37360);
            CallChecker.varInit(this.field, "field", 1189, 36892, 37360);
            CallChecker.varInit(this.nans, "nans", 1189, 36892, 37360);
            CallChecker.varInit(this.exp, "exp", 1189, 36892, 37360);
            CallChecker.varInit(this.sign, "sign", 1189, 36892, 37360);
            CallChecker.varInit(this.mant, "mant", 1189, 36892, 37360);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1189, 36892, 37360);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1189, 36892, 37360);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1189, 36892, 37360);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1189, 36892, 37360);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1189, 36892, 37360);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1189, 36892, 37360);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1189, 36892, 37360);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1189, 36892, 37360);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1189, 36892, 37360);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1189, 36892, 37360);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1189, 36892, 37360);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1189, 36892, 37360);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1189, 36892, 37360);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1189, 36892, 37360);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1189, 36892, 37360);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1189, 36892, 37360);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1189, 36892, 37360);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1189, 36892, 37360);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1189, 36892, 37360);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1189, 36892, 37360);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1189, 36892, 37360);
            if (CallChecker.beforeDeref(mant, int[].class, 1190, 37096, 37099)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1190, 37091, 37094)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1190, 37096, 37099);
                    mant = CallChecker.beforeCalled(mant, int[].class, 1190, 37091, 37094);
                    if ((CallChecker.isCalled(mant, int[].class, 1190, 37091, 37094)[((CallChecker.isCalled(mant, int[].class, 1190, 37096, 37099).length) - 1)]) > 1000) {
                        return ((exp) * 4) - 1;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(mant, int[].class, 1193, 37180, 37183)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1193, 37175, 37178)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1193, 37180, 37183);
                    mant = CallChecker.beforeCalled(mant, int[].class, 1193, 37175, 37178);
                    if ((CallChecker.isCalled(mant, int[].class, 1193, 37175, 37178)[((CallChecker.isCalled(mant, int[].class, 1193, 37180, 37183).length) - 1)]) > 100) {
                        return ((exp) * 4) - 2;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(mant, int[].class, 1196, 37263, 37266)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1196, 37258, 37261)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1196, 37263, 37266);
                    mant = CallChecker.beforeCalled(mant, int[].class, 1196, 37258, 37261);
                    if ((CallChecker.isCalled(mant, int[].class, 1196, 37258, 37261)[((CallChecker.isCalled(mant, int[].class, 1196, 37263, 37266).length) - 1)]) > 10) {
                        return ((exp) * 4) - 3;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return ((exp) * 4) - 4;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4048.methodEnd();
        }
    }

    public Dfp power10(final int e) {
        MethodContext _bcornu_methode_context4049 = new MethodContext(Dfp.class, 1206, 37367, 37995);
        try {
            CallChecker.varInit(this, "this", 1206, 37367, 37995);
            CallChecker.varInit(e, "e", 1206, 37367, 37995);
            CallChecker.varInit(this.field, "field", 1206, 37367, 37995);
            CallChecker.varInit(this.nans, "nans", 1206, 37367, 37995);
            CallChecker.varInit(this.exp, "exp", 1206, 37367, 37995);
            CallChecker.varInit(this.sign, "sign", 1206, 37367, 37995);
            CallChecker.varInit(this.mant, "mant", 1206, 37367, 37995);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1206, 37367, 37995);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1206, 37367, 37995);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1206, 37367, 37995);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1206, 37367, 37995);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1206, 37367, 37995);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1206, 37367, 37995);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1206, 37367, 37995);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1206, 37367, 37995);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1206, 37367, 37995);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1206, 37367, 37995);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1206, 37367, 37995);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1206, 37367, 37995);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1206, 37367, 37995);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1206, 37367, 37995);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1206, 37367, 37995);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1206, 37367, 37995);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1206, 37367, 37995);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1206, 37367, 37995);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1206, 37367, 37995);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1206, 37367, 37995);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1206, 37367, 37995);
            Dfp d = CallChecker.varInit(newInstance(getOne()), "d", 1207, 37520, 37549);
            if (e >= 0) {
                if (CallChecker.beforeDeref(d, Dfp.class, 1210, 37586, 37586)) {
                    d = CallChecker.beforeCalled(d, Dfp.class, 1210, 37586, 37586);
                    CallChecker.isCalled(d, Dfp.class, 1210, 37586, 37586).exp = (e / 4) + 1;
                    CallChecker.varAssign(CallChecker.isCalled(d, Dfp.class, 1210, 37586, 37586).exp, "CallChecker.isCalled(d, Dfp.class, 1210, 37586, 37586).exp", 1210, 37586, 37603);
                }
            }else {
                if (CallChecker.beforeDeref(d, Dfp.class, 1212, 37634, 37634)) {
                    d = CallChecker.beforeCalled(d, Dfp.class, 1212, 37634, 37634);
                    CallChecker.isCalled(d, Dfp.class, 1212, 37634, 37634).exp = (e + 1) / 4;
                    CallChecker.varAssign(CallChecker.isCalled(d, Dfp.class, 1212, 37634, 37634).exp, "CallChecker.isCalled(d, Dfp.class, 1212, 37634, 37634).exp", 1212, 37634, 37653);
                }
            }
            switch (((e % 4) + 4) % 4) {
                case 0 :
                    break;
                case 1 :
                    if (CallChecker.beforeDeref(d, Dfp.class, 1219, 37784, 37784)) {
                        d = CallChecker.beforeCalled(d, Dfp.class, 1219, 37784, 37784);
                        d = CallChecker.isCalled(d, Dfp.class, 1219, 37784, 37784).multiply(10);
                        CallChecker.varAssign(d, "d", 1219, 37780, 37798);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                case 2 :
                    if (CallChecker.beforeDeref(d, Dfp.class, 1222, 37863, 37863)) {
                        d = CallChecker.beforeCalled(d, Dfp.class, 1222, 37863, 37863);
                        d = CallChecker.isCalled(d, Dfp.class, 1222, 37863, 37863).multiply(100);
                        CallChecker.varAssign(d, "d", 1222, 37859, 37878);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                default :
                    if (CallChecker.beforeDeref(d, Dfp.class, 1225, 37944, 37944)) {
                        d = CallChecker.beforeCalled(d, Dfp.class, 1225, 37944, 37944);
                        d = CallChecker.isCalled(d, Dfp.class, 1225, 37944, 37944).multiply(1000);
                        CallChecker.varAssign(d, "d", 1225, 37940, 37960);
                    }else
                        throw new AbnormalExecutionError();
                    
            }
            return d;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4049.methodEnd();
        }
    }

    protected int complement(int extra) {
        MethodContext _bcornu_methode_context4050 = new MethodContext(int.class, 1237, 38002, 38664);
        try {
            CallChecker.varInit(this, "this", 1237, 38002, 38664);
            CallChecker.varInit(extra, "extra", 1237, 38002, 38664);
            CallChecker.varInit(this.field, "field", 1237, 38002, 38664);
            CallChecker.varInit(this.nans, "nans", 1237, 38002, 38664);
            CallChecker.varInit(this.exp, "exp", 1237, 38002, 38664);
            CallChecker.varInit(this.sign, "sign", 1237, 38002, 38664);
            CallChecker.varInit(this.mant, "mant", 1237, 38002, 38664);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1237, 38002, 38664);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1237, 38002, 38664);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1237, 38002, 38664);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1237, 38002, 38664);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1237, 38002, 38664);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1237, 38002, 38664);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1237, 38002, 38664);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1237, 38002, 38664);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1237, 38002, 38664);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1237, 38002, 38664);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1237, 38002, 38664);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1237, 38002, 38664);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1237, 38002, 38664);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1237, 38002, 38664);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1237, 38002, 38664);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1237, 38002, 38664);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1237, 38002, 38664);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1237, 38002, 38664);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1237, 38002, 38664);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1237, 38002, 38664);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1237, 38002, 38664);
            extra = (Dfp.RADIX) - extra;
            CallChecker.varAssign(extra, "extra", 1239, 38286, 38305);
            mant = CallChecker.beforeCalled(mant, int[].class, 1240, 38335, 38338);
            for (int i = 0; i < (CallChecker.isCalled(mant, int[].class, 1240, 38335, 38338).length); i++) {
                if (CallChecker.beforeDeref(mant, int[].class, 1241, 38367, 38370)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1241, 38383, 38386)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 1241, 38367, 38370);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1241, 38383, 38386);
                        CallChecker.isCalled(mant, int[].class, 1241, 38367, 38370)[i] = ((Dfp.RADIX) - (CallChecker.isCalled(mant, int[].class, 1241, 38383, 38386)[i])) - 1;
                        CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 1241, 38367, 38370)[i], "CallChecker.isCalled(this.mant, int[].class, 1241, 38367, 38370)[i]", 1241, 38367, 38392);
                    }
                }
            }
            int rh = CallChecker.varInit(((int) (extra / (Dfp.RADIX))), "rh", 1244, 38413, 38435);
            extra = extra - (rh * (Dfp.RADIX));
            CallChecker.varAssign(extra, "extra", 1245, 38445, 38471);
            mant = CallChecker.beforeCalled(mant, int[].class, 1246, 38501, 38504);
            for (int i = 0; i < (CallChecker.isCalled(mant, int[].class, 1246, 38501, 38504).length); i++) {
                mant = CallChecker.beforeCalled(mant, int[].class, 1247, 38547, 38550);
                final int r = CallChecker.varInit(((int) ((CallChecker.isCalled(this.mant, int[].class, 1247, 38547, 38550)[i]) + rh)), "r", 1247, 38533, 38559);
                rh = r / (Dfp.RADIX);
                CallChecker.varAssign(rh, "rh", 1248, 38573, 38587);
                if (CallChecker.beforeDeref(mant, int[].class, 1249, 38601, 38604)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1249, 38601, 38604);
                    CallChecker.isCalled(mant, int[].class, 1249, 38601, 38604)[i] = r - (rh * (Dfp.RADIX));
                    CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 1249, 38601, 38604)[i], "CallChecker.isCalled(this.mant, int[].class, 1249, 38601, 38604)[i]", 1249, 38601, 38625);
                }
            }
            return extra;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4050.methodEnd();
        }
    }

    public Dfp add(final Dfp x) {
        MethodContext _bcornu_methode_context4051 = new MethodContext(Dfp.class, 1259, 38671, 43258);
        try {
            CallChecker.varInit(this, "this", 1259, 38671, 43258);
            CallChecker.varInit(x, "x", 1259, 38671, 43258);
            CallChecker.varInit(this.field, "field", 1259, 38671, 43258);
            CallChecker.varInit(this.nans, "nans", 1259, 38671, 43258);
            CallChecker.varInit(this.exp, "exp", 1259, 38671, 43258);
            CallChecker.varInit(this.sign, "sign", 1259, 38671, 43258);
            CallChecker.varInit(this.mant, "mant", 1259, 38671, 43258);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1259, 38671, 43258);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1259, 38671, 43258);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1259, 38671, 43258);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1259, 38671, 43258);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1259, 38671, 43258);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1259, 38671, 43258);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1259, 38671, 43258);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1259, 38671, 43258);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1259, 38671, 43258);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1259, 38671, 43258);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1259, 38671, 43258);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1259, 38671, 43258);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1259, 38671, 43258);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1259, 38671, 43258);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1259, 38671, 43258);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1259, 38671, 43258);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1259, 38671, 43258);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1259, 38671, 43258);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1259, 38671, 43258);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1259, 38671, 43258);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1259, 38671, 43258);
            if (CallChecker.beforeDeref(field, DfpField.class, 1262, 38874, 38878)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 1262, 38900, 38900)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 1262, 38900, 38900).field, DfpField.class, 1262, 38900, 38906)) {
                        if ((CallChecker.isCalled(field, DfpField.class, 1262, 38874, 38878).getRadixDigits()) != (CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 1262, 38900, 38900).field, DfpField.class, 1262, 38900, 38906).getRadixDigits())) {
                            if (CallChecker.beforeDeref(field, DfpField.class, 1263, 38940, 38944)) {
                                CallChecker.isCalled(field, DfpField.class, 1263, 38940, 38944).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                            final Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 1264, 38999, 39040);
                            if (CallChecker.beforeDeref(result, Dfp.class, 1265, 39054, 39059)) {
                                CallChecker.isCalled(result, Dfp.class, 1265, 39054, 39059).nans = Dfp.QNAN;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1265, 39054, 39059).nans, "CallChecker.isCalled(result, Dfp.class, 1265, 39054, 39059).nans", 1265, 39054, 39072);
                            }
                            return dotrap(DfpField.FLAG_INVALID, Dfp.ADD_TRAP, x, result);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, Dfp.class, 1270, 39221, 39221)) {
                if (((nans) != (Dfp.FINITE)) || ((CallChecker.isCalled(x, Dfp.class, 1270, 39221, 39221).nans) != (Dfp.FINITE))) {
                    if (isNaN()) {
                        return this;
                    }
                    if (CallChecker.beforeDeref(x, Dfp.class, 1275, 39328, 39328)) {
                        if (CallChecker.isCalled(x, Dfp.class, 1275, 39328, 39328).isNaN()) {
                            return x;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(x, Dfp.class, 1279, 39418, 39418)) {
                        if (((nans) == (Dfp.INFINITE)) && ((CallChecker.isCalled(x, Dfp.class, 1279, 39418, 39418).nans) == (Dfp.FINITE))) {
                            return this;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(x, Dfp.class, 1283, 39498, 39498)) {
                        if (((CallChecker.isCalled(x, Dfp.class, 1283, 39498, 39498).nans) == (Dfp.INFINITE)) && ((nans) == (Dfp.FINITE))) {
                            return x;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(x, Dfp.class, 1287, 39595, 39595)) {
                        if (CallChecker.beforeDeref(x, Dfp.class, 1287, 39645, 39645)) {
                            if ((((CallChecker.isCalled(x, Dfp.class, 1287, 39595, 39595).nans) == (Dfp.INFINITE)) && ((nans) == (Dfp.INFINITE))) && ((sign) == (CallChecker.isCalled(x, Dfp.class, 1287, 39645, 39645).sign))) {
                                return x;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(x, Dfp.class, 1291, 39712, 39712)) {
                        if (CallChecker.beforeDeref(x, Dfp.class, 1291, 39762, 39762)) {
                            if ((((CallChecker.isCalled(x, Dfp.class, 1291, 39712, 39712).nans) == (Dfp.INFINITE)) && ((nans) == (Dfp.INFINITE))) && ((sign) != (CallChecker.isCalled(x, Dfp.class, 1291, 39762, 39762).sign))) {
                                if (CallChecker.beforeDeref(field, DfpField.class, 1292, 39788, 39792)) {
                                    CallChecker.isCalled(field, DfpField.class, 1292, 39788, 39792).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                                }
                                Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 1293, 39851, 39886);
                                if (CallChecker.beforeDeref(result, Dfp.class, 1294, 39904, 39909)) {
                                    result = CallChecker.beforeCalled(result, Dfp.class, 1294, 39904, 39909);
                                    CallChecker.isCalled(result, Dfp.class, 1294, 39904, 39909).nans = Dfp.QNAN;
                                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1294, 39904, 39909).nans, "CallChecker.isCalled(result, Dfp.class, 1294, 39904, 39909).nans", 1294, 39904, 39922);
                                }
                                result = dotrap(DfpField.FLAG_INVALID, Dfp.ADD_TRAP, x, result);
                                CallChecker.varAssign(result, "result", 1295, 39940, 39999);
                                return result;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            Dfp a = CallChecker.varInit(newInstance(this), "a", 1301, 40101, 40126);
            Dfp b = CallChecker.varInit(newInstance(x), "b", 1302, 40136, 40158);
            Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 1305, 40212, 40247);
            a = CallChecker.beforeCalled(a, Dfp.class, 1308, 40342, 40342);
            final byte asign = CallChecker.varInit(((byte) (CallChecker.isCalled(a, Dfp.class, 1308, 40342, 40342).sign)), "asign", 1308, 40258, 40348);
            b = CallChecker.beforeCalled(b, Dfp.class, 1309, 40377, 40377);
            final byte bsign = CallChecker.varInit(((byte) (CallChecker.isCalled(b, Dfp.class, 1309, 40377, 40377).sign)), "bsign", 1309, 40358, 40383);
            if (CallChecker.beforeDeref(a, Dfp.class, 1311, 40394, 40394)) {
                a = CallChecker.beforeCalled(a, Dfp.class, 1311, 40394, 40394);
                CallChecker.isCalled(a, Dfp.class, 1311, 40394, 40394).sign = 1;
                CallChecker.varAssign(CallChecker.isCalled(a, Dfp.class, 1311, 40394, 40394).sign, "CallChecker.isCalled(a, Dfp.class, 1311, 40394, 40394).sign", 1311, 40394, 40404);
            }
            if (CallChecker.beforeDeref(b, Dfp.class, 1312, 40414, 40414)) {
                b = CallChecker.beforeCalled(b, Dfp.class, 1312, 40414, 40414);
                CallChecker.isCalled(b, Dfp.class, 1312, 40414, 40414).sign = 1;
                CallChecker.varAssign(CallChecker.isCalled(b, Dfp.class, 1312, 40414, 40414).sign, "CallChecker.isCalled(b, Dfp.class, 1312, 40414, 40414).sign", 1312, 40414, 40424);
            }
            byte rsign = CallChecker.varInit(((byte) (bsign)), "rsign", 1315, 40512, 40530);
            if ((Dfp.compare(a, b)) > 0) {
                rsign = asign;
                CallChecker.varAssign(rsign, "rsign", 1317, 40577, 40590);
            }
            if (CallChecker.beforeDeref(b, Dfp.class, 1323, 40825, 40825)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1323, 40832, 40835)) {
                    b = CallChecker.beforeCalled(b, Dfp.class, 1323, 40825, 40825);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(b, Dfp.class, 1323, 40825, 40825).mant, int[].class, 1323, 40825, 40830)) {
                        b = CallChecker.beforeCalled(b, Dfp.class, 1323, 40825, 40825);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1323, 40832, 40835);
                        CallChecker.isCalled(b, Dfp.class, 1323, 40825, 40825).mant = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp.class, 1323, 40825, 40825).mant, int[].class, 1323, 40825, 40830);
                        if ((CallChecker.isCalled(CallChecker.isCalled(b, Dfp.class, 1323, 40825, 40825).mant, int[].class, 1323, 40825, 40830)[((CallChecker.isCalled(mant, int[].class, 1323, 40832, 40835).length) - 1)]) == 0) {
                            if (CallChecker.beforeDeref(b, Dfp.class, 1324, 40867, 40867)) {
                                if (CallChecker.beforeDeref(a, Dfp.class, 1324, 40875, 40875)) {
                                    b = CallChecker.beforeCalled(b, Dfp.class, 1324, 40867, 40867);
                                    a = CallChecker.beforeCalled(a, Dfp.class, 1324, 40875, 40875);
                                    CallChecker.isCalled(b, Dfp.class, 1324, 40867, 40867).exp = CallChecker.isCalled(a, Dfp.class, 1324, 40875, 40875).exp;
                                    CallChecker.varAssign(CallChecker.isCalled(b, Dfp.class, 1324, 40867, 40867).exp, "CallChecker.isCalled(b, Dfp.class, 1324, 40867, 40867).exp", 1324, 40867, 40880);
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(a, Dfp.class, 1327, 40905, 40905)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1327, 40912, 40915)) {
                    a = CallChecker.beforeCalled(a, Dfp.class, 1327, 40905, 40905);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp.class, 1327, 40905, 40905).mant, int[].class, 1327, 40905, 40910)) {
                        a = CallChecker.beforeCalled(a, Dfp.class, 1327, 40905, 40905);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1327, 40912, 40915);
                        CallChecker.isCalled(a, Dfp.class, 1327, 40905, 40905).mant = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp.class, 1327, 40905, 40905).mant, int[].class, 1327, 40905, 40910);
                        if ((CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 1327, 40905, 40905).mant, int[].class, 1327, 40905, 40910)[((CallChecker.isCalled(mant, int[].class, 1327, 40912, 40915).length) - 1)]) == 0) {
                            if (CallChecker.beforeDeref(a, Dfp.class, 1328, 40947, 40947)) {
                                if (CallChecker.beforeDeref(b, Dfp.class, 1328, 40955, 40955)) {
                                    a = CallChecker.beforeCalled(a, Dfp.class, 1328, 40947, 40947);
                                    b = CallChecker.beforeCalled(b, Dfp.class, 1328, 40955, 40955);
                                    CallChecker.isCalled(a, Dfp.class, 1328, 40947, 40947).exp = CallChecker.isCalled(b, Dfp.class, 1328, 40955, 40955).exp;
                                    CallChecker.varAssign(CallChecker.isCalled(a, Dfp.class, 1328, 40947, 40947).exp, "CallChecker.isCalled(a, Dfp.class, 1328, 40947, 40947).exp", 1328, 40947, 40960);
                                }
                            }
                        }
                    }
                }
            }
            int aextradigit = CallChecker.varInit(((int) (0)), "aextradigit", 1332, 41034, 41053);
            int bextradigit = CallChecker.varInit(((int) (0)), "bextradigit", 1333, 41063, 41082);
            if (CallChecker.beforeDeref(a, Dfp.class, 1334, 41096, 41096)) {
                if (CallChecker.beforeDeref(b, Dfp.class, 1334, 41104, 41104)) {
                    a = CallChecker.beforeCalled(a, Dfp.class, 1334, 41096, 41096);
                    b = CallChecker.beforeCalled(b, Dfp.class, 1334, 41104, 41104);
                    if ((CallChecker.isCalled(a, Dfp.class, 1334, 41096, 41096).exp) < (CallChecker.isCalled(b, Dfp.class, 1334, 41104, 41104).exp)) {
                        if (CallChecker.beforeDeref(b, Dfp.class, 1335, 41147, 41147)) {
                            if (CallChecker.beforeDeref(a, Dfp.class, 1335, 41139, 41139)) {
                                b = CallChecker.beforeCalled(b, Dfp.class, 1335, 41147, 41147);
                                a = CallChecker.beforeCalled(a, Dfp.class, 1335, 41139, 41139);
                                aextradigit = CallChecker.isCalled(a, Dfp.class, 1335, 41139, 41139).align(CallChecker.isCalled(b, Dfp.class, 1335, 41147, 41147).exp);
                                CallChecker.varAssign(aextradigit, "aextradigit", 1335, 41125, 41153);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(a, Dfp.class, 1337, 41206, 41206)) {
                            if (CallChecker.beforeDeref(b, Dfp.class, 1337, 41198, 41198)) {
                                a = CallChecker.beforeCalled(a, Dfp.class, 1337, 41206, 41206);
                                b = CallChecker.beforeCalled(b, Dfp.class, 1337, 41198, 41198);
                                bextradigit = CallChecker.isCalled(b, Dfp.class, 1337, 41198, 41198).align(CallChecker.isCalled(a, Dfp.class, 1337, 41206, 41206).exp);
                                CallChecker.varAssign(bextradigit, "bextradigit", 1337, 41184, 41212);
                            }
                        }
                    }
                }
            }
            if (asign != bsign) {
                if (asign == rsign) {
                    if (CallChecker.beforeDeref(b, Dfp.class, 1343, 41394, 41394)) {
                        b = CallChecker.beforeCalled(b, Dfp.class, 1343, 41394, 41394);
                        bextradigit = CallChecker.isCalled(b, Dfp.class, 1343, 41394, 41394).complement(bextradigit);
                        CallChecker.varAssign(bextradigit, "bextradigit", 1343, 41380, 41419);
                    }
                }else {
                    if (CallChecker.beforeDeref(a, Dfp.class, 1345, 41472, 41472)) {
                        a = CallChecker.beforeCalled(a, Dfp.class, 1345, 41472, 41472);
                        aextradigit = CallChecker.isCalled(a, Dfp.class, 1345, 41472, 41472).complement(aextradigit);
                        CallChecker.varAssign(aextradigit, "aextradigit", 1345, 41458, 41497);
                    }
                }
            }
            int rh = CallChecker.varInit(((int) (0)), "rh", 1350, 41564, 41574);
            mant = CallChecker.beforeCalled(mant, int[].class, 1351, 41626, 41629);
            for (int i = 0; i < (CallChecker.isCalled(mant, int[].class, 1351, 41626, 41629).length); i++) {
                a = CallChecker.beforeCalled(a, Dfp.class, 1352, 41672, 41672);
                CallChecker.isCalled(a, Dfp.class, 1352, 41672, 41672).mant = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp.class, 1352, 41672, 41672).mant, int[].class, 1352, 41672, 41677);
                b = CallChecker.beforeCalled(b, Dfp.class, 1352, 41682, 41682);
                CallChecker.isCalled(b, Dfp.class, 1352, 41682, 41682).mant = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp.class, 1352, 41682, 41682).mant, int[].class, 1352, 41682, 41687);
                final int r = CallChecker.varInit(((int) (((CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 1352, 41672, 41672).mant, int[].class, 1352, 41672, 41677)[i]) + (CallChecker.isCalled(CallChecker.isCalled(b, Dfp.class, 1352, 41682, 41682).mant, int[].class, 1352, 41682, 41687)[i])) + rh)), "r", 1352, 41658, 41694);
                rh = r / (Dfp.RADIX);
                CallChecker.varAssign(rh, "rh", 1353, 41708, 41722);
                if (CallChecker.beforeDeref(result, Dfp.class, 1354, 41736, 41741)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1354, 41736, 41741);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1354, 41736, 41741).mant, int[].class, 1354, 41736, 41746)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1354, 41736, 41741);
                        CallChecker.isCalled(result, Dfp.class, 1354, 41736, 41741).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1354, 41736, 41741).mant, int[].class, 1354, 41736, 41746);
                        CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1354, 41736, 41741).mant, int[].class, 1354, 41736, 41746)[i] = r - (rh * (Dfp.RADIX));
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1354, 41736, 41741).mant, int[].class, 1354, 41736, 41746)[i], "CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1354, 41736, 41741).mant, int[].class, 1354, 41736, 41746)[i]", 1354, 41736, 41767);
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 1356, 41787, 41792)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 1356, 41800, 41800)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1356, 41787, 41792);
                    a = CallChecker.beforeCalled(a, Dfp.class, 1356, 41800, 41800);
                    CallChecker.isCalled(result, Dfp.class, 1356, 41787, 41792).exp = CallChecker.isCalled(a, Dfp.class, 1356, 41800, 41800).exp;
                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1356, 41787, 41792).exp, "CallChecker.isCalled(result, Dfp.class, 1356, 41787, 41792).exp", 1356, 41787, 41805);
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 1357, 41815, 41820)) {
                result = CallChecker.beforeCalled(result, Dfp.class, 1357, 41815, 41820);
                CallChecker.isCalled(result, Dfp.class, 1357, 41815, 41820).sign = rsign;
                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1357, 41815, 41820).sign, "CallChecker.isCalled(result, Dfp.class, 1357, 41815, 41820).sign", 1357, 41815, 41834);
            }
            if ((rh != 0) && (asign == bsign)) {
                result = CallChecker.beforeCalled(result, Dfp.class, 1363, 42029, 42034);
                CallChecker.isCalled(result, Dfp.class, 1363, 42029, 42034).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1363, 42029, 42034).mant, int[].class, 1363, 42029, 42039);
                final int lostdigit = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1363, 42029, 42034).mant, int[].class, 1363, 42029, 42039)[0])), "lostdigit", 1363, 42007, 42043);
                if (CallChecker.beforeDeref(result, Dfp.class, 1364, 42057, 42062)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1364, 42057, 42062);
                    CallChecker.isCalled(result, Dfp.class, 1364, 42057, 42062).shiftRight();
                }
                if (CallChecker.beforeDeref(result, Dfp.class, 1365, 42090, 42095)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1365, 42102, 42105)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1365, 42090, 42095);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1365, 42090, 42095).mant, int[].class, 1365, 42090, 42100)) {
                            result = CallChecker.beforeCalled(result, Dfp.class, 1365, 42090, 42095);
                            mant = CallChecker.beforeCalled(mant, int[].class, 1365, 42102, 42105);
                            CallChecker.isCalled(result, Dfp.class, 1365, 42090, 42095).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1365, 42090, 42095).mant, int[].class, 1365, 42090, 42100);
                            CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1365, 42090, 42095).mant, int[].class, 1365, 42090, 42100)[((CallChecker.isCalled(mant, int[].class, 1365, 42102, 42105).length) - 1)] = rh;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1365, 42090, 42095).mant, int[].class, 1365, 42090, 42100)[((CallChecker.isCalled(this.mant, int[].class, 1365, 42102, 42105).length) - 1)], "CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1365, 42090, 42095).mant, int[].class, 1365, 42090, 42100)[((CallChecker.isCalled(this.mant, int[].class, 1365, 42102, 42105).length) - 1)]", 1365, 42090, 42121);
                        }
                    }
                }
                result = CallChecker.beforeCalled(result, Dfp.class, 1366, 42152, 42157);
                final int excp = CallChecker.varInit(((int) (CallChecker.isCalled(result, Dfp.class, 1366, 42152, 42157).round(lostdigit))), "excp", 1366, 42135, 42175);
                if (excp != 0) {
                    result = dotrap(excp, Dfp.ADD_TRAP, x, result);
                    CallChecker.varAssign(result, "result", 1368, 42222, 42264);
                }
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 1373, 42354, 42357);
            for (int i = 0; i < (CallChecker.isCalled(mant, int[].class, 1373, 42354, 42357).length); i++) {
                if (CallChecker.beforeDeref(result, Dfp.class, 1374, 42390, 42395)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1374, 42402, 42405)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1374, 42390, 42395);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1374, 42390, 42395).mant, int[].class, 1374, 42390, 42400)) {
                            result = CallChecker.beforeCalled(result, Dfp.class, 1374, 42390, 42395);
                            mant = CallChecker.beforeCalled(mant, int[].class, 1374, 42402, 42405);
                            CallChecker.isCalled(result, Dfp.class, 1374, 42390, 42395).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1374, 42390, 42395).mant, int[].class, 1374, 42390, 42400);
                            if ((CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1374, 42390, 42395).mant, int[].class, 1374, 42390, 42400)[((CallChecker.isCalled(mant, int[].class, 1374, 42402, 42405).length) - 1)]) != 0) {
                                break;
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(result, Dfp.class, 1377, 42474, 42479)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1377, 42474, 42479);
                    CallChecker.isCalled(result, Dfp.class, 1377, 42474, 42479).shiftLeft();
                }
                if (i == 0) {
                    if (CallChecker.beforeDeref(result, Dfp.class, 1379, 42536, 42541)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1379, 42536, 42541);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1379, 42536, 42541).mant, int[].class, 1379, 42536, 42546)) {
                            result = CallChecker.beforeCalled(result, Dfp.class, 1379, 42536, 42541);
                            CallChecker.isCalled(result, Dfp.class, 1379, 42536, 42541).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1379, 42536, 42541).mant, int[].class, 1379, 42536, 42546);
                            CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1379, 42536, 42541).mant, int[].class, 1379, 42536, 42546)[0] = aextradigit + bextradigit;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1379, 42536, 42541).mant, int[].class, 1379, 42536, 42546)[0], "CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1379, 42536, 42541).mant, int[].class, 1379, 42536, 42546)[0]", 1379, 42536, 42576);
                        }
                    }
                    aextradigit = 0;
                    CallChecker.varAssign(aextradigit, "aextradigit", 1380, 42594, 42609);
                    bextradigit = 0;
                    CallChecker.varAssign(bextradigit, "bextradigit", 1381, 42627, 42642);
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 1386, 42761, 42766)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1386, 42773, 42776)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1386, 42761, 42766);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1386, 42761, 42766).mant, int[].class, 1386, 42761, 42771)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1386, 42761, 42766);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1386, 42773, 42776);
                        CallChecker.isCalled(result, Dfp.class, 1386, 42761, 42766).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1386, 42761, 42766).mant, int[].class, 1386, 42761, 42771);
                        if ((CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1386, 42761, 42766).mant, int[].class, 1386, 42761, 42771)[((CallChecker.isCalled(mant, int[].class, 1386, 42773, 42776).length) - 1)]) == 0) {
                            if (CallChecker.beforeDeref(result, Dfp.class, 1387, 42808, 42813)) {
                                result = CallChecker.beforeCalled(result, Dfp.class, 1387, 42808, 42813);
                                CallChecker.isCalled(result, Dfp.class, 1387, 42808, 42813).exp = 0;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1387, 42808, 42813).exp, "CallChecker.isCalled(result, Dfp.class, 1387, 42808, 42813).exp", 1387, 42808, 42822);
                            }
                            if (asign != bsign) {
                                if (CallChecker.beforeDeref(result, Dfp.class, 1391, 42943, 42948)) {
                                    result = CallChecker.beforeCalled(result, Dfp.class, 1391, 42943, 42948);
                                    CallChecker.isCalled(result, Dfp.class, 1391, 42943, 42948).sign = 1;
                                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1391, 42943, 42948).sign, "CallChecker.isCalled(result, Dfp.class, 1391, 42943, 42948).sign", 1391, 42943, 42958);
                                }
                            }
                        }
                    }
                }
            }
            result = CallChecker.beforeCalled(result, Dfp.class, 1396, 43098, 43103);
            final int excp = CallChecker.varInit(((int) (CallChecker.isCalled(result, Dfp.class, 1396, 43098, 43103).round((aextradigit + bextradigit)))), "excp", 1396, 43027, 43137);
            if (excp != 0) {
                result = dotrap(excp, Dfp.ADD_TRAP, x, result);
                CallChecker.varAssign(result, "result", 1398, 43176, 43218);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4051.methodEnd();
        }
    }

    public Dfp negate() {
        MethodContext _bcornu_methode_context4052 = new MethodContext(Dfp.class, 1407, 43265, 43515);
        try {
            CallChecker.varInit(this, "this", 1407, 43265, 43515);
            CallChecker.varInit(this.field, "field", 1407, 43265, 43515);
            CallChecker.varInit(this.nans, "nans", 1407, 43265, 43515);
            CallChecker.varInit(this.exp, "exp", 1407, 43265, 43515);
            CallChecker.varInit(this.sign, "sign", 1407, 43265, 43515);
            CallChecker.varInit(this.mant, "mant", 1407, 43265, 43515);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1407, 43265, 43515);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1407, 43265, 43515);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1407, 43265, 43515);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1407, 43265, 43515);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1407, 43265, 43515);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1407, 43265, 43515);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1407, 43265, 43515);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1407, 43265, 43515);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1407, 43265, 43515);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1407, 43265, 43515);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1407, 43265, 43515);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1407, 43265, 43515);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1407, 43265, 43515);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1407, 43265, 43515);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1407, 43265, 43515);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1407, 43265, 43515);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1407, 43265, 43515);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1407, 43265, 43515);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1407, 43265, 43515);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1407, 43265, 43515);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1407, 43265, 43515);
            Dfp result = CallChecker.varInit(newInstance(this), "result", 1408, 43412, 43442);
            if (CallChecker.beforeDeref(result, Dfp.class, 1409, 43452, 43457)) {
                if (CallChecker.beforeDeref(result, Dfp.class, 1409, 43475, 43480)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1409, 43452, 43457);
                    result = CallChecker.beforeCalled(result, Dfp.class, 1409, 43475, 43480);
                    CallChecker.isCalled(result, Dfp.class, 1409, 43452, 43457).sign = ((byte) (-(CallChecker.isCalled(result, Dfp.class, 1409, 43475, 43480).sign)));
                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1409, 43452, 43457).sign, "CallChecker.isCalled(result, Dfp.class, 1409, 43452, 43457).sign", 1409, 43452, 43486);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4052.methodEnd();
        }
    }

    public Dfp subtract(final Dfp x) {
        MethodContext _bcornu_methode_context4053 = new MethodContext(Dfp.class, 1417, 43522, 43706);
        try {
            CallChecker.varInit(this, "this", 1417, 43522, 43706);
            CallChecker.varInit(x, "x", 1417, 43522, 43706);
            CallChecker.varInit(this.field, "field", 1417, 43522, 43706);
            CallChecker.varInit(this.nans, "nans", 1417, 43522, 43706);
            CallChecker.varInit(this.exp, "exp", 1417, 43522, 43706);
            CallChecker.varInit(this.sign, "sign", 1417, 43522, 43706);
            CallChecker.varInit(this.mant, "mant", 1417, 43522, 43706);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1417, 43522, 43706);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1417, 43522, 43706);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1417, 43522, 43706);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1417, 43522, 43706);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1417, 43522, 43706);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1417, 43522, 43706);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1417, 43522, 43706);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1417, 43522, 43706);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1417, 43522, 43706);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1417, 43522, 43706);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1417, 43522, 43706);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1417, 43522, 43706);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1417, 43522, 43706);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1417, 43522, 43706);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1417, 43522, 43706);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1417, 43522, 43706);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1417, 43522, 43706);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1417, 43522, 43706);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1417, 43522, 43706);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1417, 43522, 43706);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1417, 43522, 43706);
            if (CallChecker.beforeDeref(x, Dfp.class, 1418, 43689, 43689)) {
                return add(CallChecker.isCalled(x, Dfp.class, 1418, 43689, 43689).negate());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4053.methodEnd();
        }
    }

    protected int round(int n) {
        MethodContext _bcornu_methode_context4054 = new MethodContext(int.class, 1425, 43713, 45910);
        try {
            CallChecker.varInit(this, "this", 1425, 43713, 45910);
            CallChecker.varInit(n, "n", 1425, 43713, 45910);
            CallChecker.varInit(this.field, "field", 1425, 43713, 45910);
            CallChecker.varInit(this.nans, "nans", 1425, 43713, 45910);
            CallChecker.varInit(this.exp, "exp", 1425, 43713, 45910);
            CallChecker.varInit(this.sign, "sign", 1425, 43713, 45910);
            CallChecker.varInit(this.mant, "mant", 1425, 43713, 45910);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1425, 43713, 45910);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1425, 43713, 45910);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1425, 43713, 45910);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1425, 43713, 45910);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1425, 43713, 45910);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1425, 43713, 45910);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1425, 43713, 45910);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1425, 43713, 45910);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1425, 43713, 45910);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1425, 43713, 45910);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1425, 43713, 45910);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1425, 43713, 45910);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1425, 43713, 45910);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1425, 43713, 45910);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1425, 43713, 45910);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1425, 43713, 45910);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1425, 43713, 45910);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1425, 43713, 45910);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1425, 43713, 45910);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1425, 43713, 45910);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1425, 43713, 45910);
            boolean inc = CallChecker.varInit(((boolean) (false)), "inc", 1426, 43907, 43926);
            if (CallChecker.beforeDeref(field, DfpField.class, 1427, 43944, 43948)) {
                switch (CallChecker.isCalled(field, DfpField.class, 1427, 43944, 43948).getRoundingMode()) {
                    case ROUND_DOWN :
                        inc = false;
                        CallChecker.varAssign(inc, "inc", 1429, 44016, 44027);
                        break;
                    case ROUND_UP :
                        inc = n != 0;
                        CallChecker.varAssign(inc, "inc", 1433, 44096, 44108);
                        break;
                    case ROUND_HALF_UP :
                        inc = n >= 5000;
                        CallChecker.varAssign(inc, "inc", 1437, 44208, 44223);
                        break;
                    case ROUND_HALF_DOWN :
                        inc = n > 5000;
                        CallChecker.varAssign(inc, "inc", 1441, 44317, 44331);
                        break;
                    case ROUND_HALF_EVEN :
                        if (CallChecker.beforeDeref(mant, int[].class, 1445, 44460, 44463)) {
                            mant = CallChecker.beforeCalled(mant, int[].class, 1445, 44460, 44463);
                            inc = (n > 5000) || ((n == 5000) && (((CallChecker.isCalled(mant, int[].class, 1445, 44460, 44463)[0]) & 1) == 1));
                            CallChecker.varAssign(inc, "inc", 1445, 44427, 44478);
                        }else
                            throw new AbnormalExecutionError();
                        
                        break;
                    case ROUND_HALF_ODD :
                        if (CallChecker.beforeDeref(mant, int[].class, 1449, 44606, 44609)) {
                            mant = CallChecker.beforeCalled(mant, int[].class, 1449, 44606, 44609);
                            inc = (n > 5000) || ((n == 5000) && (((CallChecker.isCalled(mant, int[].class, 1449, 44606, 44609)[0]) & 1) == 0));
                            CallChecker.varAssign(inc, "inc", 1449, 44573, 44624);
                        }else
                            throw new AbnormalExecutionError();
                        
                        break;
                    case ROUND_CEIL :
                        inc = ((sign) == 1) && (n != 0);
                        CallChecker.varAssign(inc, "inc", 1453, 44714, 44739);
                        break;
                    case ROUND_FLOOR :
                    default :
                        inc = ((sign) == (-1)) && (n != 0);
                        CallChecker.varAssign(inc, "inc", 1458, 44847, 44873);
                        break;
                }
            }
            if (inc) {
                int rh = CallChecker.varInit(((int) (1)), "rh", 1464, 44994, 45004);
                mant = CallChecker.beforeCalled(mant, int[].class, 1465, 45038, 45041);
                for (int i = 0; i < (CallChecker.isCalled(mant, int[].class, 1465, 45038, 45041).length); i++) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1466, 45088, 45091);
                    final int r = CallChecker.varInit(((int) ((CallChecker.isCalled(this.mant, int[].class, 1466, 45088, 45091)[i]) + rh)), "r", 1466, 45074, 45100);
                    rh = r / (Dfp.RADIX);
                    CallChecker.varAssign(rh, "rh", 1467, 45118, 45132);
                    if (CallChecker.beforeDeref(mant, int[].class, 1468, 45150, 45153)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 1468, 45150, 45153);
                        CallChecker.isCalled(mant, int[].class, 1468, 45150, 45153)[i] = r - (rh * (Dfp.RADIX));
                        CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 1468, 45150, 45153)[i], "CallChecker.isCalled(this.mant, int[].class, 1468, 45150, 45153)[i]", 1468, 45150, 45174);
                    }
                }
                if (rh != 0) {
                    shiftRight();
                    if (CallChecker.beforeDeref(mant, int[].class, 1473, 45269, 45272)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 1473, 45264, 45267)) {
                            mant = CallChecker.beforeCalled(mant, int[].class, 1473, 45269, 45272);
                            mant = CallChecker.beforeCalled(mant, int[].class, 1473, 45264, 45267);
                            CallChecker.isCalled(mant, int[].class, 1473, 45264, 45267)[((CallChecker.isCalled(mant, int[].class, 1473, 45269, 45272).length) - 1)] = rh;
                            CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 1473, 45264, 45267)[((CallChecker.isCalled(this.mant, int[].class, 1473, 45269, 45272).length) - 1)], "CallChecker.isCalled(this.mant, int[].class, 1473, 45264, 45267)[((CallChecker.isCalled(this.mant, int[].class, 1473, 45269, 45272).length) - 1)]", 1473, 45264, 45288);
                        }
                    }
                }
            }
            if ((exp) < (Dfp.MIN_EXP)) {
                if (CallChecker.beforeDeref(field, DfpField.class, 1480, 45459, 45463)) {
                    CallChecker.isCalled(field, DfpField.class, 1480, 45459, 45463).setIEEEFlagsBits(DfpField.FLAG_UNDERFLOW);
                }
                return DfpField.FLAG_UNDERFLOW;
            }
            if ((exp) > (Dfp.MAX_EXP)) {
                if (CallChecker.beforeDeref(field, DfpField.class, 1486, 45628, 45632)) {
                    CallChecker.isCalled(field, DfpField.class, 1486, 45628, 45632).setIEEEFlagsBits(DfpField.FLAG_OVERFLOW);
                }
                return DfpField.FLAG_OVERFLOW;
            }
            if (n != 0) {
                if (CallChecker.beforeDeref(field, DfpField.class, 1492, 45787, 45791)) {
                    CallChecker.isCalled(field, DfpField.class, 1492, 45787, 45791).setIEEEFlagsBits(DfpField.FLAG_INEXACT);
                }
                return DfpField.FLAG_INEXACT;
            }
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4054.methodEnd();
        }
    }

    public Dfp multiply(final Dfp x) {
        MethodContext _bcornu_methode_context4055 = new MethodContext(Dfp.class, 1504, 45917, 49424);
        try {
            CallChecker.varInit(this, "this", 1504, 45917, 49424);
            CallChecker.varInit(x, "x", 1504, 45917, 49424);
            CallChecker.varInit(this.field, "field", 1504, 45917, 49424);
            CallChecker.varInit(this.nans, "nans", 1504, 45917, 49424);
            CallChecker.varInit(this.exp, "exp", 1504, 45917, 49424);
            CallChecker.varInit(this.sign, "sign", 1504, 45917, 49424);
            CallChecker.varInit(this.mant, "mant", 1504, 45917, 49424);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1504, 45917, 49424);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1504, 45917, 49424);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1504, 45917, 49424);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1504, 45917, 49424);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1504, 45917, 49424);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1504, 45917, 49424);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1504, 45917, 49424);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1504, 45917, 49424);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1504, 45917, 49424);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1504, 45917, 49424);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1504, 45917, 49424);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1504, 45917, 49424);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1504, 45917, 49424);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1504, 45917, 49424);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1504, 45917, 49424);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1504, 45917, 49424);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1504, 45917, 49424);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1504, 45917, 49424);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1504, 45917, 49424);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1504, 45917, 49424);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1504, 45917, 49424);
            if (CallChecker.beforeDeref(field, DfpField.class, 1507, 46133, 46137)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 1507, 46159, 46159)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 1507, 46159, 46159).field, DfpField.class, 1507, 46159, 46165)) {
                        if ((CallChecker.isCalled(field, DfpField.class, 1507, 46133, 46137).getRadixDigits()) != (CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 1507, 46159, 46159).field, DfpField.class, 1507, 46159, 46165).getRadixDigits())) {
                            if (CallChecker.beforeDeref(field, DfpField.class, 1508, 46199, 46203)) {
                                CallChecker.isCalled(field, DfpField.class, 1508, 46199, 46203).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                            final Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 1509, 46258, 46299);
                            if (CallChecker.beforeDeref(result, Dfp.class, 1510, 46313, 46318)) {
                                CallChecker.isCalled(result, Dfp.class, 1510, 46313, 46318).nans = Dfp.QNAN;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1510, 46313, 46318).nans, "CallChecker.isCalled(result, Dfp.class, 1510, 46313, 46318).nans", 1510, 46313, 46331);
                            }
                            return dotrap(DfpField.FLAG_INVALID, Dfp.MULTIPLY_TRAP, x, result);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 1514, 46428, 46463);
            if (CallChecker.beforeDeref(x, Dfp.class, 1517, 46531, 46531)) {
                if (((nans) != (Dfp.FINITE)) || ((CallChecker.isCalled(x, Dfp.class, 1517, 46531, 46531).nans) != (Dfp.FINITE))) {
                    if (isNaN()) {
                        return this;
                    }
                    if (CallChecker.beforeDeref(x, Dfp.class, 1522, 46638, 46638)) {
                        if (CallChecker.isCalled(x, Dfp.class, 1522, 46638, 46638).isNaN()) {
                            return x;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(x, Dfp.class, 1526, 46728, 46728)) {
                        if (CallChecker.beforeDeref(x, Dfp.class, 1526, 46748, 46748)) {
                            if (CallChecker.beforeDeref(mant, int[].class, 1526, 46755, 46758)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 1526, 46748, 46748).mant, int[].class, 1526, 46748, 46753)) {
                                    mant = CallChecker.beforeCalled(mant, int[].class, 1526, 46755, 46758);
                                    CallChecker.isCalled(x, Dfp.class, 1526, 46748, 46748).mant = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp.class, 1526, 46748, 46748).mant, int[].class, 1526, 46748, 46753);
                                    if ((((nans) == (Dfp.INFINITE)) && ((CallChecker.isCalled(x, Dfp.class, 1526, 46728, 46728).nans) == (Dfp.FINITE))) && ((CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 1526, 46748, 46748).mant, int[].class, 1526, 46748, 46753)[((CallChecker.isCalled(mant, int[].class, 1526, 46755, 46758).length) - 1)]) != 0)) {
                                        result = newInstance(this);
                                        CallChecker.varAssign(result, "result", 1527, 46794, 46820);
                                        if (CallChecker.beforeDeref(result, Dfp.class, 1528, 46838, 46843)) {
                                            if (CallChecker.beforeDeref(x, Dfp.class, 1528, 46867, 46867)) {
                                                result = CallChecker.beforeCalled(result, Dfp.class, 1528, 46838, 46843);
                                                CallChecker.isCalled(result, Dfp.class, 1528, 46838, 46843).sign = ((byte) ((sign) * (CallChecker.isCalled(x, Dfp.class, 1528, 46867, 46867).sign)));
                                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1528, 46838, 46843).sign, "CallChecker.isCalled(result, Dfp.class, 1528, 46838, 46843).sign", 1528, 46838, 46874);
                                            }
                                        }
                                        return result;
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(x, Dfp.class, 1532, 46938, 46938)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 1532, 46983, 46986)) {
                            if (CallChecker.beforeDeref(mant, int[].class, 1532, 46978, 46981)) {
                                mant = CallChecker.beforeCalled(mant, int[].class, 1532, 46983, 46986);
                                mant = CallChecker.beforeCalled(mant, int[].class, 1532, 46978, 46981);
                                if ((((CallChecker.isCalled(x, Dfp.class, 1532, 46938, 46938).nans) == (Dfp.INFINITE)) && ((nans) == (Dfp.FINITE))) && ((CallChecker.isCalled(mant, int[].class, 1532, 46978, 46981)[((CallChecker.isCalled(mant, int[].class, 1532, 46983, 46986).length) - 1)]) != 0)) {
                                    result = newInstance(x);
                                    CallChecker.varAssign(result, "result", 1533, 47022, 47045);
                                    if (CallChecker.beforeDeref(result, Dfp.class, 1534, 47063, 47068)) {
                                        if (CallChecker.beforeDeref(x, Dfp.class, 1534, 47092, 47092)) {
                                            result = CallChecker.beforeCalled(result, Dfp.class, 1534, 47063, 47068);
                                            CallChecker.isCalled(result, Dfp.class, 1534, 47063, 47068).sign = ((byte) ((sign) * (CallChecker.isCalled(x, Dfp.class, 1534, 47092, 47092).sign)));
                                            CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1534, 47063, 47068).sign, "CallChecker.isCalled(result, Dfp.class, 1534, 47063, 47068).sign", 1534, 47063, 47099);
                                        }
                                    }
                                    return result;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(x, Dfp.class, 1538, 47163, 47163)) {
                        if (((CallChecker.isCalled(x, Dfp.class, 1538, 47163, 47163).nans) == (Dfp.INFINITE)) && ((nans) == (Dfp.INFINITE))) {
                            result = newInstance(this);
                            CallChecker.varAssign(result, "result", 1539, 47221, 47247);
                            if (CallChecker.beforeDeref(result, Dfp.class, 1540, 47265, 47270)) {
                                if (CallChecker.beforeDeref(x, Dfp.class, 1540, 47294, 47294)) {
                                    result = CallChecker.beforeCalled(result, Dfp.class, 1540, 47265, 47270);
                                    CallChecker.isCalled(result, Dfp.class, 1540, 47265, 47270).sign = ((byte) ((sign) * (CallChecker.isCalled(x, Dfp.class, 1540, 47294, 47294).sign)));
                                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1540, 47265, 47270).sign, "CallChecker.isCalled(result, Dfp.class, 1540, 47265, 47270).sign", 1540, 47265, 47301);
                                }
                            }
                            return result;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(x, Dfp.class, 1544, 47367, 47367)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 1544, 47412, 47415)) {
                            if (CallChecker.beforeDeref(mant, int[].class, 1544, 47407, 47410)) {
                                if (CallChecker.beforeDeref(x, Dfp.class, 1545, 47477, 47477)) {
                                    if (CallChecker.beforeDeref(x, Dfp.class, 1545, 47497, 47497)) {
                                        if (CallChecker.beforeDeref(mant, int[].class, 1545, 47504, 47507)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 1545, 47497, 47497).mant, int[].class, 1545, 47497, 47502)) {
                                                mant = CallChecker.beforeCalled(mant, int[].class, 1544, 47412, 47415);
                                                mant = CallChecker.beforeCalled(mant, int[].class, 1544, 47407, 47410);
                                                mant = CallChecker.beforeCalled(mant, int[].class, 1545, 47504, 47507);
                                                CallChecker.isCalled(x, Dfp.class, 1545, 47497, 47497).mant = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp.class, 1545, 47497, 47497).mant, int[].class, 1545, 47497, 47502);
                                                if (((((CallChecker.isCalled(x, Dfp.class, 1544, 47367, 47367).nans) == (Dfp.INFINITE)) && ((nans) == (Dfp.FINITE))) && ((CallChecker.isCalled(mant, int[].class, 1544, 47407, 47410)[((CallChecker.isCalled(mant, int[].class, 1544, 47412, 47415).length) - 1)]) == 0)) || ((((nans) == (Dfp.INFINITE)) && ((CallChecker.isCalled(x, Dfp.class, 1545, 47477, 47477).nans) == (Dfp.FINITE))) && ((CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 1545, 47497, 47497).mant, int[].class, 1545, 47497, 47502)[((CallChecker.isCalled(mant, int[].class, 1545, 47504, 47507).length) - 1)]) == 0))) {
                                                    if (CallChecker.beforeDeref(field, DfpField.class, 1546, 47545, 47549)) {
                                                        CallChecker.isCalled(field, DfpField.class, 1546, 47545, 47549).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                                                    }
                                                    result = newInstance(getZero());
                                                    CallChecker.varAssign(result, "result", 1547, 47608, 47639);
                                                    if (CallChecker.beforeDeref(result, Dfp.class, 1548, 47657, 47662)) {
                                                        result = CallChecker.beforeCalled(result, Dfp.class, 1548, 47657, 47662);
                                                        CallChecker.isCalled(result, Dfp.class, 1548, 47657, 47662).nans = Dfp.QNAN;
                                                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1548, 47657, 47662).nans, "CallChecker.isCalled(result, Dfp.class, 1548, 47657, 47662).nans", 1548, 47657, 47675);
                                                    }
                                                    result = dotrap(DfpField.FLAG_INVALID, Dfp.MULTIPLY_TRAP, x, result);
                                                    CallChecker.varAssign(result, "result", 1549, 47693, 47757);
                                                    return result;
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            int[] product = CallChecker.init(int[].class);
            if (CallChecker.beforeDeref(mant, int[].class, 1554, 47847, 47850)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 1554, 47847, 47850);
                product = new int[(CallChecker.isCalled(mant, int[].class, 1554, 47847, 47850).length) * 2];
                CallChecker.varAssign(product, "product", 1554, 47847, 47850);
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 1556, 47939, 47942);
            for (int i = 0; i < (CallChecker.isCalled(mant, int[].class, 1556, 47939, 47942).length); i++) {
                int rh = CallChecker.varInit(((int) (0)), "rh", 1557, 47971, 47981);
                mant = CallChecker.beforeCalled(mant, int[].class, 1558, 48031, 48034);
                for (int j = 0; j < (CallChecker.isCalled(mant, int[].class, 1558, 48031, 48034).length); j++) {
                    int r = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(mant, int[].class, 1559, 48075, 48078)) {
                        if (CallChecker.beforeDeref(x, Dfp.class, 1559, 48085, 48085)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 1559, 48085, 48085).mant, int[].class, 1559, 48085, 48090)) {
                                mant = CallChecker.beforeCalled(mant, int[].class, 1559, 48075, 48078);
                                CallChecker.isCalled(x, Dfp.class, 1559, 48085, 48085).mant = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp.class, 1559, 48085, 48085).mant, int[].class, 1559, 48085, 48090);
                                r = (CallChecker.isCalled(mant, int[].class, 1559, 48075, 48078)[i]) * (CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 1559, 48085, 48085).mant, int[].class, 1559, 48085, 48090)[j]);
                                CallChecker.varAssign(r, "r", 1559, 48075, 48078);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(product, int[].class, 1560, 48148, 48154)) {
                        product = CallChecker.beforeCalled(product, int[].class, 1560, 48148, 48154);
                        r = (r + (CallChecker.isCalled(product, int[].class, 1560, 48148, 48154)[(i + j)])) + rh;
                        CallChecker.varAssign(r, "r", 1560, 48140, 48165);
                    }
                    rh = r / (Dfp.RADIX);
                    CallChecker.varAssign(rh, "rh", 1562, 48227, 48241);
                    if (CallChecker.beforeDeref(product, int[].class, 1563, 48259, 48265)) {
                        product = CallChecker.beforeCalled(product, int[].class, 1563, 48259, 48265);
                        CallChecker.isCalled(product, int[].class, 1563, 48259, 48265)[(i + j)] = r - (rh * (Dfp.RADIX));
                        CallChecker.varAssign(CallChecker.isCalled(product, int[].class, 1563, 48259, 48265)[(i + j)], "CallChecker.isCalled(product, int[].class, 1563, 48259, 48265)[(i + j)]", 1563, 48259, 48288);
                    }
                }
                if (CallChecker.beforeDeref(mant, int[].class, 1565, 48326, 48329)) {
                    if (CallChecker.beforeDeref(product, int[].class, 1565, 48316, 48322)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 1565, 48326, 48329);
                        product = CallChecker.beforeCalled(product, int[].class, 1565, 48316, 48322);
                        CallChecker.isCalled(product, int[].class, 1565, 48316, 48322)[(i + (CallChecker.isCalled(mant, int[].class, 1565, 48326, 48329).length))] = rh;
                        CallChecker.varAssign(CallChecker.isCalled(product, int[].class, 1565, 48316, 48322)[(i + (CallChecker.isCalled(this.mant, int[].class, 1565, 48326, 48329).length))], "CallChecker.isCalled(product, int[].class, 1565, 48316, 48322)[(i + (CallChecker.isCalled(this.mant, int[].class, 1565, 48326, 48329).length))]", 1565, 48316, 48343);
                    }
                }
            }
            int md = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(mant, int[].class, 1569, 48408, 48411)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 1569, 48408, 48411);
                md = ((CallChecker.isCalled(mant, int[].class, 1569, 48408, 48411).length) * 2) - 1;
                CallChecker.varAssign(md, "md", 1569, 48408, 48411);
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 1570, 48486, 48489);
            for (int i = ((CallChecker.isCalled(mant, int[].class, 1570, 48486, 48489).length) * 2) - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(product, int[].class, 1571, 48538, 48544)) {
                    product = CallChecker.beforeCalled(product, int[].class, 1571, 48538, 48544);
                    if ((CallChecker.isCalled(product, int[].class, 1571, 48538, 48544)[i]) != 0) {
                        md = i;
                        CallChecker.varAssign(md, "md", 1572, 48573, 48579);
                        break;
                    }
                }
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 1578, 48700, 48703);
            for (int i = 0; i < (CallChecker.isCalled(mant, int[].class, 1578, 48700, 48703).length); i++) {
                if (CallChecker.beforeDeref(result, Dfp.class, 1579, 48732, 48737)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1579, 48744, 48747)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1579, 48732, 48737);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1579, 48732, 48737).mant, int[].class, 1579, 48732, 48742)) {
                            if (CallChecker.beforeDeref(product, int[].class, 1579, 48767, 48773)) {
                                result = CallChecker.beforeCalled(result, Dfp.class, 1579, 48732, 48737);
                                mant = CallChecker.beforeCalled(mant, int[].class, 1579, 48744, 48747);
                                CallChecker.isCalled(result, Dfp.class, 1579, 48732, 48737).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1579, 48732, 48737).mant, int[].class, 1579, 48732, 48742);
                                product = CallChecker.beforeCalled(product, int[].class, 1579, 48767, 48773);
                                CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1579, 48732, 48737).mant, int[].class, 1579, 48732, 48742)[(((CallChecker.isCalled(mant, int[].class, 1579, 48744, 48747).length) - i) - 1)] = CallChecker.isCalled(product, int[].class, 1579, 48767, 48773)[(md - i)];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1579, 48732, 48737).mant, int[].class, 1579, 48732, 48742)[(((CallChecker.isCalled(this.mant, int[].class, 1579, 48744, 48747).length) - i) - 1)], "CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1579, 48732, 48737).mant, int[].class, 1579, 48732, 48742)[(((CallChecker.isCalled(this.mant, int[].class, 1579, 48744, 48747).length) - i) - 1)]", 1579, 48732, 48782);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 1583, 48834, 48839)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 1583, 48853, 48853)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1583, 48870, 48873)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1583, 48834, 48839);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1583, 48870, 48873);
                        CallChecker.isCalled(result, Dfp.class, 1583, 48834, 48839).exp = ((((exp) + (CallChecker.isCalled(x, Dfp.class, 1583, 48853, 48853).exp)) + md) - (2 * (CallChecker.isCalled(mant, int[].class, 1583, 48870, 48873).length))) + 1;
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1583, 48834, 48839).exp, "CallChecker.isCalled(result, Dfp.class, 1583, 48834, 48839).exp", 1583, 48834, 48885);
                    }
                }
            }
            if (CallChecker.beforeDeref(x, Dfp.class, 1584, 48925, 48925)) {
                if ((sign) == (CallChecker.isCalled(x, Dfp.class, 1584, 48925, 48925).sign)) {
                    if (CallChecker.beforeDeref(result, Dfp.class, 1584, 48895, 48900)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1584, 48895, 48900);
                        CallChecker.isCalled(result, Dfp.class, 1584, 48895, 48900).sign = ((byte) (1));
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1584, 48895, 48900).sign, "CallChecker.isCalled(result, Dfp.class, 1584, 48895, 48900).sign", 1584, 48895, 48938);
                    }
                }else {
                    if (CallChecker.beforeDeref(result, Dfp.class, 1584, 48895, 48900)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1584, 48895, 48900);
                        CallChecker.isCalled(result, Dfp.class, 1584, 48895, 48900).sign = ((byte) (-1));
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1584, 48895, 48900).sign, "CallChecker.isCalled(result, Dfp.class, 1584, 48895, 48900).sign", 1584, 48895, 48938);
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 1586, 48953, 48958)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1586, 48965, 48968)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1586, 48953, 48958);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1586, 48953, 48958).mant, int[].class, 1586, 48953, 48963)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1586, 48953, 48958);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1586, 48965, 48968);
                        CallChecker.isCalled(result, Dfp.class, 1586, 48953, 48958).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1586, 48953, 48958).mant, int[].class, 1586, 48953, 48963);
                        if ((CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1586, 48953, 48958).mant, int[].class, 1586, 48953, 48963)[((CallChecker.isCalled(mant, int[].class, 1586, 48965, 48968).length) - 1)]) == 0) {
                            if (CallChecker.beforeDeref(result, Dfp.class, 1588, 49050, 49055)) {
                                result = CallChecker.beforeCalled(result, Dfp.class, 1588, 49050, 49055);
                                CallChecker.isCalled(result, Dfp.class, 1588, 49050, 49055).exp = 0;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1588, 49050, 49055).exp, "CallChecker.isCalled(result, Dfp.class, 1588, 49050, 49055).exp", 1588, 49050, 49064);
                            }
                        }
                    }
                }
            }
            int excp = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(mant, int[].class, 1592, 49119, 49122)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 1592, 49119, 49122);
                if (md > ((CallChecker.isCalled(mant, int[].class, 1592, 49119, 49122).length) - 1)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1593, 49180, 49183)) {
                        if (CallChecker.beforeDeref(product, int[].class, 1593, 49169, 49175)) {
                            if (CallChecker.beforeDeref(result, Dfp.class, 1593, 49156, 49161)) {
                                mant = CallChecker.beforeCalled(mant, int[].class, 1593, 49180, 49183);
                                product = CallChecker.beforeCalled(product, int[].class, 1593, 49169, 49175);
                                result = CallChecker.beforeCalled(result, Dfp.class, 1593, 49156, 49161);
                                excp = CallChecker.isCalled(result, Dfp.class, 1593, 49156, 49161).round(CallChecker.isCalled(product, int[].class, 1593, 49169, 49175)[(md - (CallChecker.isCalled(mant, int[].class, 1593, 49180, 49183).length))]);
                                CallChecker.varAssign(excp, "excp", 1593, 49149, 49193);
                            }
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(result, Dfp.class, 1595, 49231, 49236)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1595, 49231, 49236);
                        excp = CallChecker.isCalled(result, Dfp.class, 1595, 49231, 49236).round(0);
                        CallChecker.varAssign(excp, "excp", 1595, 49224, 49246);
                    }
                }
            }
            if (excp != 0) {
                result = dotrap(excp, Dfp.MULTIPLY_TRAP, x, result);
                CallChecker.varAssign(result, "result", 1599, 49336, 49383);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4055.methodEnd();
        }
    }

    public Dfp multiply(final int x) {
        MethodContext _bcornu_methode_context4056 = new MethodContext(Dfp.class, 1610, 49431, 49730);
        try {
            CallChecker.varInit(this, "this", 1610, 49431, 49730);
            CallChecker.varInit(x, "x", 1610, 49431, 49730);
            CallChecker.varInit(this.field, "field", 1610, 49431, 49730);
            CallChecker.varInit(this.nans, "nans", 1610, 49431, 49730);
            CallChecker.varInit(this.exp, "exp", 1610, 49431, 49730);
            CallChecker.varInit(this.sign, "sign", 1610, 49431, 49730);
            CallChecker.varInit(this.mant, "mant", 1610, 49431, 49730);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1610, 49431, 49730);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1610, 49431, 49730);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1610, 49431, 49730);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1610, 49431, 49730);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1610, 49431, 49730);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1610, 49431, 49730);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1610, 49431, 49730);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1610, 49431, 49730);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1610, 49431, 49730);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1610, 49431, 49730);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1610, 49431, 49730);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1610, 49431, 49730);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1610, 49431, 49730);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1610, 49431, 49730);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1610, 49431, 49730);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1610, 49431, 49730);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1610, 49431, 49730);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1610, 49431, 49730);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1610, 49431, 49730);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1610, 49431, 49730);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1610, 49431, 49730);
            if ((x >= 0) && (x < (Dfp.RADIX))) {
                return multiplyFast(x);
            }else {
                return multiply(newInstance(x));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4056.methodEnd();
        }
    }

    private Dfp multiplyFast(final int x) {
        MethodContext _bcornu_methode_context4057 = new MethodContext(Dfp.class, 1623, 49737, 51629);
        try {
            CallChecker.varInit(this, "this", 1623, 49737, 51629);
            CallChecker.varInit(x, "x", 1623, 49737, 51629);
            CallChecker.varInit(this.field, "field", 1623, 49737, 51629);
            CallChecker.varInit(this.nans, "nans", 1623, 49737, 51629);
            CallChecker.varInit(this.exp, "exp", 1623, 49737, 51629);
            CallChecker.varInit(this.sign, "sign", 1623, 49737, 51629);
            CallChecker.varInit(this.mant, "mant", 1623, 49737, 51629);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1623, 49737, 51629);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1623, 49737, 51629);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1623, 49737, 51629);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1623, 49737, 51629);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1623, 49737, 51629);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1623, 49737, 51629);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1623, 49737, 51629);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1623, 49737, 51629);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1623, 49737, 51629);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1623, 49737, 51629);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1623, 49737, 51629);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1623, 49737, 51629);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1623, 49737, 51629);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1623, 49737, 51629);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1623, 49737, 51629);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1623, 49737, 51629);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1623, 49737, 51629);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1623, 49737, 51629);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1623, 49737, 51629);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1623, 49737, 51629);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1623, 49737, 51629);
            Dfp result = CallChecker.varInit(newInstance(this), "result", 1624, 49973, 50003);
            if ((nans) != (Dfp.FINITE)) {
                if (isNaN()) {
                    return this;
                }
                if (((nans) == (Dfp.INFINITE)) && (x != 0)) {
                    result = newInstance(this);
                    CallChecker.varAssign(result, "result", 1633, 50204, 50230);
                    return result;
                }
                if (((nans) == (Dfp.INFINITE)) && (x == 0)) {
                    if (CallChecker.beforeDeref(field, DfpField.class, 1638, 50340, 50344)) {
                        CallChecker.isCalled(field, DfpField.class, 1638, 50340, 50344).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                    }
                    result = newInstance(getZero());
                    CallChecker.varAssign(result, "result", 1639, 50403, 50434);
                    if (CallChecker.beforeDeref(result, Dfp.class, 1640, 50452, 50457)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1640, 50452, 50457);
                        CallChecker.isCalled(result, Dfp.class, 1640, 50452, 50457).nans = Dfp.QNAN;
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1640, 50452, 50457).nans, "CallChecker.isCalled(result, Dfp.class, 1640, 50452, 50457).nans", 1640, 50452, 50470);
                    }
                    result = dotrap(DfpField.FLAG_INVALID, Dfp.MULTIPLY_TRAP, newInstance(getZero()), result);
                    CallChecker.varAssign(result, "result", 1641, 50488, 50573);
                    return result;
                }
            }
            if ((x < 0) || (x >= (Dfp.RADIX))) {
                if (CallChecker.beforeDeref(field, DfpField.class, 1648, 50706, 50710)) {
                    CallChecker.isCalled(field, DfpField.class, 1648, 50706, 50710).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                }
                result = newInstance(getZero());
                CallChecker.varAssign(result, "result", 1649, 50765, 50796);
                if (CallChecker.beforeDeref(result, Dfp.class, 1650, 50810, 50815)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1650, 50810, 50815);
                    CallChecker.isCalled(result, Dfp.class, 1650, 50810, 50815).nans = Dfp.QNAN;
                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1650, 50810, 50815).nans, "CallChecker.isCalled(result, Dfp.class, 1650, 50810, 50815).nans", 1650, 50810, 50828);
                }
                result = dotrap(DfpField.FLAG_INVALID, Dfp.MULTIPLY_TRAP, result, result);
                CallChecker.varAssign(result, "result", 1651, 50842, 50911);
                return result;
            }
            int rh = CallChecker.varInit(((int) (0)), "rh", 1655, 50959, 50969);
            mant = CallChecker.beforeCalled(mant, int[].class, 1656, 50999, 51002);
            for (int i = 0; i < (CallChecker.isCalled(mant, int[].class, 1656, 50999, 51002).length); i++) {
                mant = CallChecker.beforeCalled(mant, int[].class, 1657, 51045, 51048);
                final int r = CallChecker.varInit(((int) (((CallChecker.isCalled(this.mant, int[].class, 1657, 51045, 51048)[i]) * x) + rh)), "r", 1657, 51031, 51061);
                rh = r / (Dfp.RADIX);
                CallChecker.varAssign(rh, "rh", 1658, 51075, 51089);
                if (CallChecker.beforeDeref(result, Dfp.class, 1659, 51103, 51108)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1659, 51103, 51108);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1659, 51103, 51108).mant, int[].class, 1659, 51103, 51113)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1659, 51103, 51108);
                        CallChecker.isCalled(result, Dfp.class, 1659, 51103, 51108).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1659, 51103, 51108).mant, int[].class, 1659, 51103, 51113);
                        CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1659, 51103, 51108).mant, int[].class, 1659, 51103, 51113)[i] = r - (rh * (Dfp.RADIX));
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1659, 51103, 51108).mant, int[].class, 1659, 51103, 51113)[i], "CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1659, 51103, 51108).mant, int[].class, 1659, 51103, 51113)[i]", 1659, 51103, 51134);
                    }
                }
            }
            int lostdigit = CallChecker.varInit(((int) (0)), "lostdigit", 1662, 51155, 51172);
            if (rh != 0) {
                if (CallChecker.beforeDeref(result, Dfp.class, 1664, 51221, 51226)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1664, 51221, 51226);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1664, 51221, 51226).mant, int[].class, 1664, 51221, 51231)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1664, 51221, 51226);
                        CallChecker.isCalled(result, Dfp.class, 1664, 51221, 51226).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1664, 51221, 51226).mant, int[].class, 1664, 51221, 51231);
                        lostdigit = CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1664, 51221, 51226).mant, int[].class, 1664, 51221, 51231)[0];
                        CallChecker.varAssign(lostdigit, "lostdigit", 1664, 51209, 51235);
                    }
                }
                if (CallChecker.beforeDeref(result, Dfp.class, 1665, 51249, 51254)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1665, 51249, 51254);
                    CallChecker.isCalled(result, Dfp.class, 1665, 51249, 51254).shiftRight();
                }
                if (CallChecker.beforeDeref(result, Dfp.class, 1666, 51282, 51287)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1666, 51294, 51297)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1666, 51282, 51287);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1666, 51282, 51287).mant, int[].class, 1666, 51282, 51292)) {
                            result = CallChecker.beforeCalled(result, Dfp.class, 1666, 51282, 51287);
                            mant = CallChecker.beforeCalled(mant, int[].class, 1666, 51294, 51297);
                            CallChecker.isCalled(result, Dfp.class, 1666, 51282, 51287).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1666, 51282, 51287).mant, int[].class, 1666, 51282, 51292);
                            CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1666, 51282, 51287).mant, int[].class, 1666, 51282, 51292)[((CallChecker.isCalled(mant, int[].class, 1666, 51294, 51297).length) - 1)] = rh;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1666, 51282, 51287).mant, int[].class, 1666, 51282, 51292)[((CallChecker.isCalled(this.mant, int[].class, 1666, 51294, 51297).length) - 1)], "CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1666, 51282, 51287).mant, int[].class, 1666, 51282, 51292)[((CallChecker.isCalled(this.mant, int[].class, 1666, 51294, 51297).length) - 1)]", 1666, 51282, 51313);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 1669, 51338, 51343)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1669, 51350, 51353)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1669, 51338, 51343);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1669, 51338, 51343).mant, int[].class, 1669, 51338, 51348)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1669, 51338, 51343);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1669, 51350, 51353);
                        CallChecker.isCalled(result, Dfp.class, 1669, 51338, 51343).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1669, 51338, 51343).mant, int[].class, 1669, 51338, 51348);
                        if ((CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1669, 51338, 51343).mant, int[].class, 1669, 51338, 51348)[((CallChecker.isCalled(mant, int[].class, 1669, 51350, 51353).length) - 1)]) == 0) {
                            if (CallChecker.beforeDeref(result, Dfp.class, 1670, 51423, 51428)) {
                                result = CallChecker.beforeCalled(result, Dfp.class, 1670, 51423, 51428);
                                CallChecker.isCalled(result, Dfp.class, 1670, 51423, 51428).exp = 0;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1670, 51423, 51428).exp, "CallChecker.isCalled(result, Dfp.class, 1670, 51423, 51428).exp", 1670, 51423, 51437);
                            }
                        }
                    }
                }
            }
            result = CallChecker.beforeCalled(result, Dfp.class, 1673, 51475, 51480);
            final int excp = CallChecker.varInit(((int) (CallChecker.isCalled(result, Dfp.class, 1673, 51475, 51480).round(lostdigit))), "excp", 1673, 51458, 51498);
            if (excp != 0) {
                result = dotrap(excp, Dfp.MULTIPLY_TRAP, result, result);
                CallChecker.varAssign(result, "result", 1675, 51537, 51589);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4057.methodEnd();
        }
    }

    public Dfp divide(Dfp divisor) {
        MethodContext _bcornu_methode_context4058 = new MethodContext(Dfp.class, 1685, 51636, 59183);
        try {
            CallChecker.varInit(this, "this", 1685, 51636, 59183);
            CallChecker.varInit(divisor, "divisor", 1685, 51636, 59183);
            CallChecker.varInit(this.field, "field", 1685, 51636, 59183);
            CallChecker.varInit(this.nans, "nans", 1685, 51636, 59183);
            CallChecker.varInit(this.exp, "exp", 1685, 51636, 59183);
            CallChecker.varInit(this.sign, "sign", 1685, 51636, 59183);
            CallChecker.varInit(this.mant, "mant", 1685, 51636, 59183);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1685, 51636, 59183);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1685, 51636, 59183);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1685, 51636, 59183);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1685, 51636, 59183);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1685, 51636, 59183);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1685, 51636, 59183);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1685, 51636, 59183);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1685, 51636, 59183);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1685, 51636, 59183);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1685, 51636, 59183);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1685, 51636, 59183);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1685, 51636, 59183);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1685, 51636, 59183);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1685, 51636, 59183);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1685, 51636, 59183);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1685, 51636, 59183);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1685, 51636, 59183);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1685, 51636, 59183);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1685, 51636, 59183);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1685, 51636, 59183);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1685, 51636, 59183);
            int[] dividend = CallChecker.init(int[].class);
            int[] quotient = CallChecker.init(int[].class);
            int[] remainder = CallChecker.init(int[].class);
            int qd = CallChecker.init(int.class);
            int nsqd = CallChecker.init(int.class);
            int trial = CallChecker.varInit(((int) (0)), "trial", 1691, 52063, 52074);
            int minadj = CallChecker.init(int.class);
            boolean trialgood = CallChecker.init(boolean.class);
            int md = CallChecker.varInit(((int) (0)), "md", 1694, 52223, 52231);
            int excp = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(field, DfpField.class, 1698, 52384, 52388)) {
                if (CallChecker.beforeDeref(divisor, Dfp.class, 1698, 52410, 52416)) {
                    divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1698, 52410, 52416);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(divisor, Dfp.class, 1698, 52410, 52416).field, DfpField.class, 1698, 52410, 52422)) {
                        divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1698, 52410, 52416);
                        if ((CallChecker.isCalled(field, DfpField.class, 1698, 52384, 52388).getRadixDigits()) != (CallChecker.isCalled(CallChecker.isCalled(divisor, Dfp.class, 1698, 52410, 52416).field, DfpField.class, 1698, 52410, 52422).getRadixDigits())) {
                            if (CallChecker.beforeDeref(field, DfpField.class, 1699, 52456, 52460)) {
                                CallChecker.isCalled(field, DfpField.class, 1699, 52456, 52460).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                            final Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 1700, 52515, 52556);
                            if (CallChecker.beforeDeref(result, Dfp.class, 1701, 52570, 52575)) {
                                CallChecker.isCalled(result, Dfp.class, 1701, 52570, 52575).nans = Dfp.QNAN;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1701, 52570, 52575).nans, "CallChecker.isCalled(result, Dfp.class, 1701, 52570, 52575).nans", 1701, 52570, 52588);
                            }
                            return dotrap(DfpField.FLAG_INVALID, Dfp.DIVIDE_TRAP, divisor, result);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 1705, 52689, 52724);
            if (CallChecker.beforeDeref(divisor, Dfp.class, 1708, 52792, 52798)) {
                divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1708, 52792, 52798);
                if (((nans) != (Dfp.FINITE)) || ((CallChecker.isCalled(divisor, Dfp.class, 1708, 52792, 52798).nans) != (Dfp.FINITE))) {
                    if (isNaN()) {
                        return this;
                    }
                    if (CallChecker.beforeDeref(divisor, Dfp.class, 1713, 52905, 52911)) {
                        divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1713, 52905, 52911);
                        if (CallChecker.isCalled(divisor, Dfp.class, 1713, 52905, 52911).isNaN()) {
                            return divisor;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(divisor, Dfp.class, 1717, 53007, 53013)) {
                        divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1717, 53007, 53013);
                        if (((nans) == (Dfp.INFINITE)) && ((CallChecker.isCalled(divisor, Dfp.class, 1717, 53007, 53013).nans) == (Dfp.FINITE))) {
                            result = newInstance(this);
                            CallChecker.varAssign(result, "result", 1718, 53049, 53075);
                            if (CallChecker.beforeDeref(result, Dfp.class, 1719, 53093, 53098)) {
                                if (CallChecker.beforeDeref(divisor, Dfp.class, 1719, 53122, 53128)) {
                                    result = CallChecker.beforeCalled(result, Dfp.class, 1719, 53093, 53098);
                                    divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1719, 53122, 53128);
                                    CallChecker.isCalled(result, Dfp.class, 1719, 53093, 53098).sign = ((byte) ((sign) * (CallChecker.isCalled(divisor, Dfp.class, 1719, 53122, 53128).sign)));
                                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1719, 53093, 53098).sign, "CallChecker.isCalled(result, Dfp.class, 1719, 53093, 53098).sign", 1719, 53093, 53135);
                                }
                            }
                            return result;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(divisor, Dfp.class, 1723, 53199, 53205)) {
                        divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1723, 53199, 53205);
                        if (((CallChecker.isCalled(divisor, Dfp.class, 1723, 53199, 53205).nans) == (Dfp.INFINITE)) && ((nans) == (Dfp.FINITE))) {
                            result = newInstance(getZero());
                            CallChecker.varAssign(result, "result", 1724, 53261, 53292);
                            if (CallChecker.beforeDeref(result, Dfp.class, 1725, 53310, 53315)) {
                                if (CallChecker.beforeDeref(divisor, Dfp.class, 1725, 53339, 53345)) {
                                    result = CallChecker.beforeCalled(result, Dfp.class, 1725, 53310, 53315);
                                    divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1725, 53339, 53345);
                                    CallChecker.isCalled(result, Dfp.class, 1725, 53310, 53315).sign = ((byte) ((sign) * (CallChecker.isCalled(divisor, Dfp.class, 1725, 53339, 53345).sign)));
                                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1725, 53310, 53315).sign, "CallChecker.isCalled(result, Dfp.class, 1725, 53310, 53315).sign", 1725, 53310, 53352);
                                }
                            }
                            return result;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(divisor, Dfp.class, 1729, 53416, 53422)) {
                        divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1729, 53416, 53422);
                        if (((CallChecker.isCalled(divisor, Dfp.class, 1729, 53416, 53422).nans) == (Dfp.INFINITE)) && ((nans) == (Dfp.INFINITE))) {
                            if (CallChecker.beforeDeref(field, DfpField.class, 1730, 53480, 53484)) {
                                CallChecker.isCalled(field, DfpField.class, 1730, 53480, 53484).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                            result = newInstance(getZero());
                            CallChecker.varAssign(result, "result", 1731, 53543, 53574);
                            if (CallChecker.beforeDeref(result, Dfp.class, 1732, 53592, 53597)) {
                                result = CallChecker.beforeCalled(result, Dfp.class, 1732, 53592, 53597);
                                CallChecker.isCalled(result, Dfp.class, 1732, 53592, 53597).nans = Dfp.QNAN;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1732, 53592, 53597).nans, "CallChecker.isCalled(result, Dfp.class, 1732, 53592, 53597).nans", 1732, 53592, 53610);
                            }
                            result = dotrap(DfpField.FLAG_INVALID, Dfp.DIVIDE_TRAP, divisor, result);
                            CallChecker.varAssign(result, "result", 1733, 53628, 53696);
                            return result;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(divisor, Dfp.class, 1739, 53804, 53810)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1739, 53817, 53820)) {
                    divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1739, 53804, 53810);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(divisor, Dfp.class, 1739, 53804, 53810).mant, int[].class, 1739, 53804, 53815)) {
                        divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1739, 53804, 53810);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1739, 53817, 53820);
                        CallChecker.isCalled(divisor, Dfp.class, 1739, 53804, 53810).mant = CallChecker.beforeCalled(CallChecker.isCalled(divisor, Dfp.class, 1739, 53804, 53810).mant, int[].class, 1739, 53804, 53815);
                        if ((CallChecker.isCalled(CallChecker.isCalled(divisor, Dfp.class, 1739, 53804, 53810).mant, int[].class, 1739, 53804, 53815)[((CallChecker.isCalled(mant, int[].class, 1739, 53817, 53820).length) - 1)]) == 0) {
                            if (CallChecker.beforeDeref(field, DfpField.class, 1740, 53852, 53856)) {
                                CallChecker.isCalled(field, DfpField.class, 1740, 53852, 53856).setIEEEFlagsBits(DfpField.FLAG_DIV_ZERO);
                            }
                            result = newInstance(getZero());
                            CallChecker.varAssign(result, "result", 1741, 53912, 53943);
                            if (CallChecker.beforeDeref(result, Dfp.class, 1742, 53957, 53962)) {
                                if (CallChecker.beforeDeref(divisor, Dfp.class, 1742, 53986, 53992)) {
                                    result = CallChecker.beforeCalled(result, Dfp.class, 1742, 53957, 53962);
                                    divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1742, 53986, 53992);
                                    CallChecker.isCalled(result, Dfp.class, 1742, 53957, 53962).sign = ((byte) ((sign) * (CallChecker.isCalled(divisor, Dfp.class, 1742, 53986, 53992).sign)));
                                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1742, 53957, 53962).sign, "CallChecker.isCalled(result, Dfp.class, 1742, 53957, 53962).sign", 1742, 53957, 53999);
                                }
                            }
                            if (CallChecker.beforeDeref(result, Dfp.class, 1743, 54013, 54018)) {
                                result = CallChecker.beforeCalled(result, Dfp.class, 1743, 54013, 54018);
                                CallChecker.isCalled(result, Dfp.class, 1743, 54013, 54018).nans = Dfp.INFINITE;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1743, 54013, 54018).nans, "CallChecker.isCalled(result, Dfp.class, 1743, 54013, 54018).nans", 1743, 54013, 54035);
                            }
                            result = dotrap(DfpField.FLAG_DIV_ZERO, Dfp.DIVIDE_TRAP, divisor, result);
                            CallChecker.varAssign(result, "result", 1744, 54049, 54118);
                            return result;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(mant, int[].class, 1748, 54185, 54188)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 1748, 54185, 54188);
                dividend = new int[(CallChecker.isCalled(mant, int[].class, 1748, 54185, 54188).length) + 1];
                CallChecker.varAssign(dividend, "dividend", 1748, 54166, 54199);
            }
            if (CallChecker.beforeDeref(mant, int[].class, 1749, 54255, 54258)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 1749, 54255, 54258);
                quotient = new int[(CallChecker.isCalled(mant, int[].class, 1749, 54255, 54258).length) + 2];
                CallChecker.varAssign(quotient, "quotient", 1749, 54236, 54269);
            }
            if (CallChecker.beforeDeref(mant, int[].class, 1750, 54358, 54361)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 1750, 54358, 54361);
                remainder = new int[(CallChecker.isCalled(mant, int[].class, 1750, 54358, 54361).length) + 1];
                CallChecker.varAssign(remainder, "remainder", 1750, 54338, 54372);
            }
            if (CallChecker.beforeDeref(mant, int[].class, 1754, 54480, 54483)) {
                if (CallChecker.beforeDeref(dividend, int[].class, 1754, 54471, 54478)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1754, 54480, 54483);
                    dividend = CallChecker.beforeCalled(dividend, int[].class, 1754, 54471, 54478);
                    CallChecker.isCalled(dividend, int[].class, 1754, 54471, 54478)[CallChecker.isCalled(mant, int[].class, 1754, 54480, 54483).length] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(dividend, int[].class, 1754, 54471, 54478)[CallChecker.isCalled(this.mant, int[].class, 1754, 54480, 54483).length], "CallChecker.isCalled(dividend, int[].class, 1754, 54471, 54478)[CallChecker.isCalled(this.mant, int[].class, 1754, 54480, 54483).length]", 1754, 54471, 54496);
                }
            }
            if (CallChecker.beforeDeref(mant, int[].class, 1755, 54515, 54518)) {
                if (CallChecker.beforeDeref(quotient, int[].class, 1755, 54506, 54513)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1755, 54515, 54518);
                    quotient = CallChecker.beforeCalled(quotient, int[].class, 1755, 54506, 54513);
                    CallChecker.isCalled(quotient, int[].class, 1755, 54506, 54513)[CallChecker.isCalled(mant, int[].class, 1755, 54515, 54518).length] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(quotient, int[].class, 1755, 54506, 54513)[CallChecker.isCalled(this.mant, int[].class, 1755, 54515, 54518).length], "CallChecker.isCalled(quotient, int[].class, 1755, 54506, 54513)[CallChecker.isCalled(this.mant, int[].class, 1755, 54515, 54518).length]", 1755, 54506, 54531);
                }
            }
            if (CallChecker.beforeDeref(mant, int[].class, 1756, 54550, 54553)) {
                if (CallChecker.beforeDeref(quotient, int[].class, 1756, 54541, 54548)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1756, 54550, 54553);
                    quotient = CallChecker.beforeCalled(quotient, int[].class, 1756, 54541, 54548);
                    CallChecker.isCalled(quotient, int[].class, 1756, 54541, 54548)[((CallChecker.isCalled(mant, int[].class, 1756, 54550, 54553).length) + 1)] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(quotient, int[].class, 1756, 54541, 54548)[((CallChecker.isCalled(this.mant, int[].class, 1756, 54550, 54553).length) + 1)], "CallChecker.isCalled(quotient, int[].class, 1756, 54541, 54548)[((CallChecker.isCalled(this.mant, int[].class, 1756, 54550, 54553).length) + 1)]", 1756, 54541, 54568);
                }
            }
            if (CallChecker.beforeDeref(mant, int[].class, 1757, 54588, 54591)) {
                if (CallChecker.beforeDeref(remainder, int[].class, 1757, 54578, 54586)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1757, 54588, 54591);
                    remainder = CallChecker.beforeCalled(remainder, int[].class, 1757, 54578, 54586);
                    CallChecker.isCalled(remainder, int[].class, 1757, 54578, 54586)[CallChecker.isCalled(mant, int[].class, 1757, 54588, 54591).length] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(remainder, int[].class, 1757, 54578, 54586)[CallChecker.isCalled(this.mant, int[].class, 1757, 54588, 54591).length], "CallChecker.isCalled(remainder, int[].class, 1757, 54578, 54586)[CallChecker.isCalled(this.mant, int[].class, 1757, 54588, 54591).length]", 1757, 54578, 54604);
                }
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 1762, 54737, 54740);
            for (int i = 0; i < (CallChecker.isCalled(mant, int[].class, 1762, 54737, 54740).length); i++) {
                if (CallChecker.beforeDeref(dividend, int[].class, 1763, 54769, 54776)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1763, 54783, 54786)) {
                        dividend = CallChecker.beforeCalled(dividend, int[].class, 1763, 54769, 54776);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1763, 54783, 54786);
                        CallChecker.isCalled(dividend, int[].class, 1763, 54769, 54776)[i] = CallChecker.isCalled(mant, int[].class, 1763, 54783, 54786)[i];
                        CallChecker.varAssign(CallChecker.isCalled(dividend, int[].class, 1763, 54769, 54776)[i], "CallChecker.isCalled(dividend, int[].class, 1763, 54769, 54776)[i]", 1763, 54769, 54790);
                    }
                }
                if (CallChecker.beforeDeref(quotient, int[].class, 1764, 54804, 54811)) {
                    quotient = CallChecker.beforeCalled(quotient, int[].class, 1764, 54804, 54811);
                    CallChecker.isCalled(quotient, int[].class, 1764, 54804, 54811)[i] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(quotient, int[].class, 1764, 54804, 54811)[i], "CallChecker.isCalled(quotient, int[].class, 1764, 54804, 54811)[i]", 1764, 54804, 54819);
                }
                if (CallChecker.beforeDeref(remainder, int[].class, 1765, 54833, 54841)) {
                    remainder = CallChecker.beforeCalled(remainder, int[].class, 1765, 54833, 54841);
                    CallChecker.isCalled(remainder, int[].class, 1765, 54833, 54841)[i] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(remainder, int[].class, 1765, 54833, 54841)[i], "CallChecker.isCalled(remainder, int[].class, 1765, 54833, 54841)[i]", 1765, 54833, 54849);
                }
            }
            nsqd = 0;
            CallChecker.varAssign(nsqd, "nsqd", 1769, 54921, 54929);
            mant = CallChecker.beforeCalled(mant, int[].class, 1770, 54949, 54952);
            for (qd = (CallChecker.isCalled(mant, int[].class, 1770, 54949, 54952).length) + 1; qd >= 0; qd--) {
                CallChecker.varAssign(qd, "qd", 1770, 54944, 54961);
                mant = CallChecker.beforeCalled(mant, int[].class, 1774, 55135, 55138);
                dividend = CallChecker.beforeCalled(dividend, int[].class, 1774, 55126, 55133);
                mant = CallChecker.beforeCalled(mant, int[].class, 1774, 55163, 55166);
                dividend = CallChecker.beforeCalled(dividend, int[].class, 1774, 55154, 55161);
                final int divMsb = CallChecker.varInit(((int) (((CallChecker.isCalled(dividend, int[].class, 1774, 55126, 55133)[CallChecker.isCalled(this.mant, int[].class, 1774, 55135, 55138).length]) * (Dfp.RADIX)) + (CallChecker.isCalled(dividend, int[].class, 1774, 55154, 55161)[((CallChecker.isCalled(this.mant, int[].class, 1774, 55163, 55166).length) - 1)]))), "divMsb", 1774, 54993, 55177);
                int min = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(divisor, Dfp.class, 1775, 55217, 55223)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1775, 55230, 55233)) {
                        divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1775, 55217, 55223);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(divisor, Dfp.class, 1775, 55217, 55223).mant, int[].class, 1775, 55217, 55228)) {
                            divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1775, 55217, 55223);
                            mant = CallChecker.beforeCalled(mant, int[].class, 1775, 55230, 55233);
                            CallChecker.isCalled(divisor, Dfp.class, 1775, 55217, 55223).mant = CallChecker.beforeCalled(CallChecker.isCalled(divisor, Dfp.class, 1775, 55217, 55223).mant, int[].class, 1775, 55217, 55228);
                            min = divMsb / ((CallChecker.isCalled(CallChecker.isCalled(divisor, Dfp.class, 1775, 55217, 55223).mant, int[].class, 1775, 55217, 55228)[((CallChecker.isCalled(mant, int[].class, 1775, 55230, 55233).length) - 1)]) + 1);
                            CallChecker.varAssign(min, "min", 1775, 55217, 55223);
                        }
                    }
                }
                int max = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(divisor, Dfp.class, 1776, 55286, 55292)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1776, 55299, 55302)) {
                        divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1776, 55286, 55292);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(divisor, Dfp.class, 1776, 55286, 55292).mant, int[].class, 1776, 55286, 55297)) {
                            divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1776, 55286, 55292);
                            mant = CallChecker.beforeCalled(mant, int[].class, 1776, 55299, 55302);
                            CallChecker.isCalled(divisor, Dfp.class, 1776, 55286, 55292).mant = CallChecker.beforeCalled(CallChecker.isCalled(divisor, Dfp.class, 1776, 55286, 55292).mant, int[].class, 1776, 55286, 55297);
                            max = (divMsb + 1) / (CallChecker.isCalled(CallChecker.isCalled(divisor, Dfp.class, 1776, 55286, 55292).mant, int[].class, 1776, 55286, 55297)[((CallChecker.isCalled(mant, int[].class, 1776, 55299, 55302).length) - 1)]);
                            CallChecker.varAssign(max, "max", 1776, 55286, 55292);
                        }
                    }
                }
                trialgood = false;
                CallChecker.varAssign(trialgood, "trialgood", 1778, 55328, 55345);
                while (!trialgood) {
                    trial = (min + max) / 2;
                    CallChecker.varAssign(trial, "trial", 1781, 55428, 55447);
                    int rh = CallChecker.varInit(((int) (0)), "rh", 1784, 55531, 55541);
                    mant = CallChecker.beforeCalled(mant, int[].class, 1785, 55579, 55582);
                    for (int i = 0; i < ((CallChecker.isCalled(mant, int[].class, 1785, 55579, 55582).length) + 1); i++) {
                        int dm = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(mant, int[].class, 1786, 55635, 55638)) {
                            mant = CallChecker.beforeCalled(mant, int[].class, 1786, 55635, 55638);
                            if (i < (CallChecker.isCalled(mant, int[].class, 1786, 55635, 55638).length)) {
                                if (CallChecker.beforeDeref(divisor, Dfp.class, 1786, 55648, 55654)) {
                                    divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1786, 55648, 55654);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(divisor, Dfp.class, 1786, 55648, 55654).mant, int[].class, 1786, 55648, 55659)) {
                                        divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1786, 55648, 55654);
                                        CallChecker.isCalled(divisor, Dfp.class, 1786, 55648, 55654).mant = CallChecker.beforeCalled(CallChecker.isCalled(divisor, Dfp.class, 1786, 55648, 55654).mant, int[].class, 1786, 55648, 55659);
                                        dm = CallChecker.isCalled(CallChecker.isCalled(divisor, Dfp.class, 1786, 55648, 55654).mant, int[].class, 1786, 55648, 55659)[i];
                                        CallChecker.varAssign(dm, "dm", 1786, 55632, 55664);
                                    }
                                }
                            }else {
                                dm = 0;
                                CallChecker.varAssign(dm, "dm", 1786, 55632, 55664);
                            }
                        }
                        final int r = CallChecker.varInit(((int) ((dm * trial) + rh)), "r", 1787, 55687, 55718);
                        rh = r / (Dfp.RADIX);
                        CallChecker.varAssign(rh, "rh", 1788, 55740, 55754);
                        if (CallChecker.beforeDeref(remainder, int[].class, 1789, 55776, 55784)) {
                            remainder = CallChecker.beforeCalled(remainder, int[].class, 1789, 55776, 55784);
                            CallChecker.isCalled(remainder, int[].class, 1789, 55776, 55784)[i] = r - (rh * (Dfp.RADIX));
                            CallChecker.varAssign(CallChecker.isCalled(remainder, int[].class, 1789, 55776, 55784)[i], "CallChecker.isCalled(remainder, int[].class, 1789, 55776, 55784)[i]", 1789, 55776, 55805);
                        }
                    }
                    rh = 1;
                    CallChecker.varAssign(rh, "rh", 1793, 55905, 55911);
                    mant = CallChecker.beforeCalled(mant, int[].class, 1794, 55985, 55988);
                    for (int i = 0; i < ((CallChecker.isCalled(mant, int[].class, 1794, 55985, 55988).length) + 1); i++) {
                        remainder = CallChecker.beforeCalled(remainder, int[].class, 1795, 56056, 56064);
                        dividend = CallChecker.beforeCalled(dividend, int[].class, 1795, 56072, 56079);
                        final int r = CallChecker.varInit(((int) (((((Dfp.RADIX) - 1) - (CallChecker.isCalled(remainder, int[].class, 1795, 56056, 56064)[i])) + (CallChecker.isCalled(dividend, int[].class, 1795, 56072, 56079)[i])) + rh)), "r", 1795, 56029, 56088);
                        rh = r / (Dfp.RADIX);
                        CallChecker.varAssign(rh, "rh", 1796, 56110, 56124);
                        if (CallChecker.beforeDeref(remainder, int[].class, 1797, 56146, 56154)) {
                            remainder = CallChecker.beforeCalled(remainder, int[].class, 1797, 56146, 56154);
                            CallChecker.isCalled(remainder, int[].class, 1797, 56146, 56154)[i] = r - (rh * (Dfp.RADIX));
                            CallChecker.varAssign(CallChecker.isCalled(remainder, int[].class, 1797, 56146, 56154)[i], "CallChecker.isCalled(remainder, int[].class, 1797, 56146, 56154)[i]", 1797, 56146, 56175);
                        }
                    }
                    if (rh == 0) {
                        max = trial - 1;
                        CallChecker.varAssign(max, "max", 1803, 56362, 56375);
                        continue;
                    }
                    if (CallChecker.beforeDeref(mant, int[].class, 1808, 56540, 56543)) {
                        if (CallChecker.beforeDeref(remainder, int[].class, 1808, 56530, 56538)) {
                            if (CallChecker.beforeDeref(mant, int[].class, 1808, 56572, 56575)) {
                                if (CallChecker.beforeDeref(remainder, int[].class, 1808, 56562, 56570)) {
                                    mant = CallChecker.beforeCalled(mant, int[].class, 1808, 56540, 56543);
                                    remainder = CallChecker.beforeCalled(remainder, int[].class, 1808, 56530, 56538);
                                    mant = CallChecker.beforeCalled(mant, int[].class, 1808, 56572, 56575);
                                    remainder = CallChecker.beforeCalled(remainder, int[].class, 1808, 56562, 56570);
                                    minadj = ((CallChecker.isCalled(remainder, int[].class, 1808, 56530, 56538)[CallChecker.isCalled(mant, int[].class, 1808, 56540, 56543).length]) * (Dfp.RADIX)) + (CallChecker.isCalled(remainder, int[].class, 1808, 56562, 56570)[((CallChecker.isCalled(mant, int[].class, 1808, 56572, 56575).length) - 1)]);
                                    CallChecker.varAssign(minadj, "minadj", 1808, 56520, 56586);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(divisor, Dfp.class, 1809, 56623, 56629)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 1809, 56636, 56639)) {
                            divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1809, 56623, 56629);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(divisor, Dfp.class, 1809, 56623, 56629).mant, int[].class, 1809, 56623, 56634)) {
                                divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1809, 56623, 56629);
                                mant = CallChecker.beforeCalled(mant, int[].class, 1809, 56636, 56639);
                                CallChecker.isCalled(divisor, Dfp.class, 1809, 56623, 56629).mant = CallChecker.beforeCalled(CallChecker.isCalled(divisor, Dfp.class, 1809, 56623, 56629).mant, int[].class, 1809, 56623, 56634);
                                minadj = minadj / ((CallChecker.isCalled(CallChecker.isCalled(divisor, Dfp.class, 1809, 56623, 56629).mant, int[].class, 1809, 56623, 56634)[((CallChecker.isCalled(mant, int[].class, 1809, 56636, 56639).length) - 1)]) + 1);
                                CallChecker.varAssign(minadj, "minadj", 1809, 56604, 56653);
                            }
                        }
                    }
                    if (minadj >= 2) {
                        min = trial + minadj;
                        CallChecker.varAssign(min, "min", 1812, 56711, 56729);
                        continue;
                    }
                    trialgood = false;
                    CallChecker.varAssign(trialgood, "trialgood", 1818, 56958, 56975);
                    mant = CallChecker.beforeCalled(mant, int[].class, 1819, 57023, 57026);
                    for (int i = (CallChecker.isCalled(mant, int[].class, 1819, 57023, 57026).length) - 1; i >= 0; i--) {
                        if (CallChecker.beforeDeref(divisor, Dfp.class, 1820, 57079, 57085)) {
                            divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1820, 57079, 57085);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(divisor, Dfp.class, 1820, 57079, 57085).mant, int[].class, 1820, 57079, 57090)) {
                                if (CallChecker.beforeDeref(remainder, int[].class, 1820, 57097, 57105)) {
                                    divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1820, 57079, 57085);
                                    CallChecker.isCalled(divisor, Dfp.class, 1820, 57079, 57085).mant = CallChecker.beforeCalled(CallChecker.isCalled(divisor, Dfp.class, 1820, 57079, 57085).mant, int[].class, 1820, 57079, 57090);
                                    remainder = CallChecker.beforeCalled(remainder, int[].class, 1820, 57097, 57105);
                                    if ((CallChecker.isCalled(CallChecker.isCalled(divisor, Dfp.class, 1820, 57079, 57085).mant, int[].class, 1820, 57079, 57090)[i]) > (CallChecker.isCalled(remainder, int[].class, 1820, 57097, 57105)[i])) {
                                        trialgood = true;
                                        CallChecker.varAssign(trialgood, "trialgood", 1821, 57137, 57153);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(divisor, Dfp.class, 1823, 57201, 57207)) {
                            divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1823, 57201, 57207);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(divisor, Dfp.class, 1823, 57201, 57207).mant, int[].class, 1823, 57201, 57212)) {
                                if (CallChecker.beforeDeref(remainder, int[].class, 1823, 57219, 57227)) {
                                    divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1823, 57201, 57207);
                                    CallChecker.isCalled(divisor, Dfp.class, 1823, 57201, 57207).mant = CallChecker.beforeCalled(CallChecker.isCalled(divisor, Dfp.class, 1823, 57201, 57207).mant, int[].class, 1823, 57201, 57212);
                                    remainder = CallChecker.beforeCalled(remainder, int[].class, 1823, 57219, 57227);
                                    if ((CallChecker.isCalled(CallChecker.isCalled(divisor, Dfp.class, 1823, 57201, 57207).mant, int[].class, 1823, 57201, 57212)[i]) < (CallChecker.isCalled(remainder, int[].class, 1823, 57219, 57227)[i])) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(mant, int[].class, 1828, 57337, 57340)) {
                        if (CallChecker.beforeDeref(remainder, int[].class, 1828, 57327, 57335)) {
                            mant = CallChecker.beforeCalled(mant, int[].class, 1828, 57337, 57340);
                            remainder = CallChecker.beforeCalled(remainder, int[].class, 1828, 57327, 57335);
                            if ((CallChecker.isCalled(remainder, int[].class, 1828, 57327, 57335)[CallChecker.isCalled(mant, int[].class, 1828, 57337, 57340).length]) != 0) {
                                trialgood = false;
                                CallChecker.varAssign(trialgood, "trialgood", 1829, 57378, 57395);
                            }
                        }
                    }
                    if (trialgood == false) {
                        min = trial + 1;
                        CallChecker.varAssign(min, "min", 1833, 57478, 57491);
                    }
                } 
                if (CallChecker.beforeDeref(quotient, int[].class, 1838, 57579, 57586)) {
                    quotient = CallChecker.beforeCalled(quotient, int[].class, 1838, 57579, 57586);
                    CallChecker.isCalled(quotient, int[].class, 1838, 57579, 57586)[qd] = trial;
                    CallChecker.varAssign(CallChecker.isCalled(quotient, int[].class, 1838, 57579, 57586)[qd], "CallChecker.isCalled(quotient, int[].class, 1838, 57579, 57586)[qd]", 1838, 57579, 57599);
                }
                if ((trial != 0) || (nsqd != 0)) {
                    nsqd++;
                }
                if (CallChecker.beforeDeref(field, DfpField.class, 1843, 57699, 57703)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1843, 57770, 57773)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 1843, 57770, 57773);
                        if (((CallChecker.isCalled(field, DfpField.class, 1843, 57699, 57703).getRoundingMode()) == (ROUND_DOWN)) && (nsqd == (CallChecker.isCalled(mant, int[].class, 1843, 57770, 57773).length))) {
                            break;
                        }
                    }
                }
                if (CallChecker.beforeDeref(mant, int[].class, 1848, 57894, 57897)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1848, 57894, 57897);
                    if (nsqd > (CallChecker.isCalled(mant, int[].class, 1848, 57894, 57897).length)) {
                        break;
                    }
                }
                if (CallChecker.beforeDeref(dividend, int[].class, 1854, 58075, 58082)) {
                    dividend = CallChecker.beforeCalled(dividend, int[].class, 1854, 58075, 58082);
                    CallChecker.isCalled(dividend, int[].class, 1854, 58075, 58082)[0] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(dividend, int[].class, 1854, 58075, 58082)[0], "CallChecker.isCalled(dividend, int[].class, 1854, 58075, 58082)[0]", 1854, 58075, 58090);
                }
                mant = CallChecker.beforeCalled(mant, int[].class, 1855, 58124, 58127);
                for (int i = 0; i < (CallChecker.isCalled(mant, int[].class, 1855, 58124, 58127).length); i++) {
                    if (CallChecker.beforeDeref(dividend, int[].class, 1856, 58160, 58167)) {
                        if (CallChecker.beforeDeref(remainder, int[].class, 1856, 58178, 58186)) {
                            dividend = CallChecker.beforeCalled(dividend, int[].class, 1856, 58160, 58167);
                            remainder = CallChecker.beforeCalled(remainder, int[].class, 1856, 58178, 58186);
                            CallChecker.isCalled(dividend, int[].class, 1856, 58160, 58167)[(i + 1)] = CallChecker.isCalled(remainder, int[].class, 1856, 58178, 58186)[i];
                            CallChecker.varAssign(CallChecker.isCalled(dividend, int[].class, 1856, 58160, 58167)[(i + 1)], "CallChecker.isCalled(dividend, int[].class, 1856, 58160, 58167)[(i + 1)]", 1856, 58160, 58190);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(mant, int[].class, 1861, 58268, 58271)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 1861, 58268, 58271);
                md = CallChecker.isCalled(mant, int[].class, 1861, 58268, 58271).length;
                CallChecker.varAssign(md, "md", 1861, 58263, 58279);
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 1862, 58314, 58317);
            for (int i = (CallChecker.isCalled(mant, int[].class, 1862, 58314, 58317).length) + 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(quotient, int[].class, 1863, 58362, 58369)) {
                    quotient = CallChecker.beforeCalled(quotient, int[].class, 1863, 58362, 58369);
                    if ((CallChecker.isCalled(quotient, int[].class, 1863, 58362, 58369)[i]) != 0) {
                        md = i;
                        CallChecker.varAssign(md, "md", 1864, 58398, 58404);
                        break;
                    }
                }
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 1870, 58524, 58527);
            for (int i = 0; i < (CallChecker.isCalled(mant, int[].class, 1870, 58524, 58527).length); i++) {
                if (CallChecker.beforeDeref(result, Dfp.class, 1871, 58556, 58561)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1871, 58568, 58571)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1871, 58556, 58561);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1871, 58556, 58561).mant, int[].class, 1871, 58556, 58566)) {
                            if (CallChecker.beforeDeref(quotient, int[].class, 1871, 58587, 58594)) {
                                result = CallChecker.beforeCalled(result, Dfp.class, 1871, 58556, 58561);
                                mant = CallChecker.beforeCalled(mant, int[].class, 1871, 58568, 58571);
                                CallChecker.isCalled(result, Dfp.class, 1871, 58556, 58561).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1871, 58556, 58561).mant, int[].class, 1871, 58556, 58566);
                                quotient = CallChecker.beforeCalled(quotient, int[].class, 1871, 58587, 58594);
                                CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1871, 58556, 58561).mant, int[].class, 1871, 58556, 58566)[(((CallChecker.isCalled(mant, int[].class, 1871, 58568, 58571).length) - i) - 1)] = CallChecker.isCalled(quotient, int[].class, 1871, 58587, 58594)[(md - i)];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1871, 58556, 58561).mant, int[].class, 1871, 58556, 58566)[(((CallChecker.isCalled(this.mant, int[].class, 1871, 58568, 58571).length) - i) - 1)], "CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1871, 58556, 58561).mant, int[].class, 1871, 58556, 58566)[(((CallChecker.isCalled(this.mant, int[].class, 1871, 58568, 58571).length) - i) - 1)]", 1871, 58556, 58601);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 1875, 58656, 58661)) {
                if (CallChecker.beforeDeref(divisor, Dfp.class, 1875, 58675, 58681)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1875, 58694, 58697)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1875, 58656, 58661);
                        divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1875, 58675, 58681);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1875, 58694, 58697);
                        CallChecker.isCalled(result, Dfp.class, 1875, 58656, 58661).exp = (((exp) - (CallChecker.isCalled(divisor, Dfp.class, 1875, 58675, 58681).exp)) + md) - (CallChecker.isCalled(mant, int[].class, 1875, 58694, 58697).length);
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1875, 58656, 58661).exp, "CallChecker.isCalled(result, Dfp.class, 1875, 58656, 58661).exp", 1875, 58656, 58705);
                    }
                }
            }
            if (CallChecker.beforeDeref(divisor, Dfp.class, 1876, 58746, 58752)) {
                divisor = CallChecker.beforeCalled(divisor, Dfp.class, 1876, 58746, 58752);
                if ((sign) == (CallChecker.isCalled(divisor, Dfp.class, 1876, 58746, 58752).sign)) {
                    if (CallChecker.beforeDeref(result, Dfp.class, 1876, 58715, 58720)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1876, 58715, 58720);
                        CallChecker.isCalled(result, Dfp.class, 1876, 58715, 58720).sign = ((byte) (1));
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1876, 58715, 58720).sign, "CallChecker.isCalled(result, Dfp.class, 1876, 58715, 58720).sign", 1876, 58715, 58769);
                    }
                }else {
                    if (CallChecker.beforeDeref(result, Dfp.class, 1876, 58715, 58720)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1876, 58715, 58720);
                        CallChecker.isCalled(result, Dfp.class, 1876, 58715, 58720).sign = ((byte) (-1));
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1876, 58715, 58720).sign, "CallChecker.isCalled(result, Dfp.class, 1876, 58715, 58720).sign", 1876, 58715, 58769);
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 1878, 58784, 58789)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1878, 58796, 58799)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1878, 58784, 58789);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1878, 58784, 58789).mant, int[].class, 1878, 58784, 58794)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1878, 58784, 58789);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1878, 58796, 58799);
                        CallChecker.isCalled(result, Dfp.class, 1878, 58784, 58789).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1878, 58784, 58789).mant, int[].class, 1878, 58784, 58794);
                        if ((CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1878, 58784, 58789).mant, int[].class, 1878, 58784, 58794)[((CallChecker.isCalled(mant, int[].class, 1878, 58796, 58799).length) - 1)]) == 0) {
                            if (CallChecker.beforeDeref(result, Dfp.class, 1879, 58869, 58874)) {
                                result = CallChecker.beforeCalled(result, Dfp.class, 1879, 58869, 58874);
                                CallChecker.isCalled(result, Dfp.class, 1879, 58869, 58874).exp = 0;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1879, 58869, 58874).exp, "CallChecker.isCalled(result, Dfp.class, 1879, 58869, 58874).exp", 1879, 58869, 58883);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(mant, int[].class, 1882, 58914, 58917)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 1882, 58914, 58917);
                if (md > ((CallChecker.isCalled(mant, int[].class, 1882, 58914, 58917).length) - 1)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 1883, 58976, 58979)) {
                        if (CallChecker.beforeDeref(quotient, int[].class, 1883, 58964, 58971)) {
                            if (CallChecker.beforeDeref(result, Dfp.class, 1883, 58951, 58956)) {
                                mant = CallChecker.beforeCalled(mant, int[].class, 1883, 58976, 58979);
                                quotient = CallChecker.beforeCalled(quotient, int[].class, 1883, 58964, 58971);
                                result = CallChecker.beforeCalled(result, Dfp.class, 1883, 58951, 58956);
                                excp = CallChecker.isCalled(result, Dfp.class, 1883, 58951, 58956).round(CallChecker.isCalled(quotient, int[].class, 1883, 58964, 58971)[(md - (CallChecker.isCalled(mant, int[].class, 1883, 58976, 58979).length))]);
                                CallChecker.varAssign(excp, "excp", 1883, 58944, 58989);
                            }
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(result, Dfp.class, 1885, 59027, 59032)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1885, 59027, 59032);
                        excp = CallChecker.isCalled(result, Dfp.class, 1885, 59027, 59032).round(0);
                        CallChecker.varAssign(excp, "excp", 1885, 59020, 59042);
                    }
                }
            }
            if (excp != 0) {
                result = dotrap(excp, Dfp.DIVIDE_TRAP, divisor, result);
                CallChecker.varAssign(result, "result", 1889, 59092, 59143);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4058.methodEnd();
        }
    }

    public Dfp divide(int divisor) {
        MethodContext _bcornu_methode_context4059 = new MethodContext(Dfp.class, 1900, 59190, 61172);
        try {
            CallChecker.varInit(this, "this", 1900, 59190, 61172);
            CallChecker.varInit(divisor, "divisor", 1900, 59190, 61172);
            CallChecker.varInit(this.field, "field", 1900, 59190, 61172);
            CallChecker.varInit(this.nans, "nans", 1900, 59190, 61172);
            CallChecker.varInit(this.exp, "exp", 1900, 59190, 61172);
            CallChecker.varInit(this.sign, "sign", 1900, 59190, 61172);
            CallChecker.varInit(this.mant, "mant", 1900, 59190, 61172);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1900, 59190, 61172);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1900, 59190, 61172);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1900, 59190, 61172);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1900, 59190, 61172);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1900, 59190, 61172);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1900, 59190, 61172);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1900, 59190, 61172);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1900, 59190, 61172);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1900, 59190, 61172);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1900, 59190, 61172);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1900, 59190, 61172);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1900, 59190, 61172);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1900, 59190, 61172);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1900, 59190, 61172);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1900, 59190, 61172);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1900, 59190, 61172);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1900, 59190, 61172);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1900, 59190, 61172);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1900, 59190, 61172);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1900, 59190, 61172);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1900, 59190, 61172);
            if ((nans) != (Dfp.FINITE)) {
                if (isNaN()) {
                    return this;
                }
                if ((nans) == (Dfp.INFINITE)) {
                    return newInstance(this);
                }
            }
            if (divisor == 0) {
                if (CallChecker.beforeDeref(field, DfpField.class, 1915, 59746, 59750)) {
                    CallChecker.isCalled(field, DfpField.class, 1915, 59746, 59750).setIEEEFlagsBits(DfpField.FLAG_DIV_ZERO);
                }
                Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 1916, 59806, 59841);
                if (CallChecker.beforeDeref(result, Dfp.class, 1917, 59855, 59860)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1917, 59855, 59860);
                    CallChecker.isCalled(result, Dfp.class, 1917, 59855, 59860).sign = sign;
                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1917, 59855, 59860).sign, "CallChecker.isCalled(result, Dfp.class, 1917, 59855, 59860).sign", 1917, 59855, 59873);
                }
                if (CallChecker.beforeDeref(result, Dfp.class, 1918, 59887, 59892)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1918, 59887, 59892);
                    CallChecker.isCalled(result, Dfp.class, 1918, 59887, 59892).nans = Dfp.INFINITE;
                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1918, 59887, 59892).nans, "CallChecker.isCalled(result, Dfp.class, 1918, 59887, 59892).nans", 1918, 59887, 59909);
                }
                result = dotrap(DfpField.FLAG_DIV_ZERO, Dfp.DIVIDE_TRAP, getZero(), result);
                CallChecker.varAssign(result, "result", 1919, 59923, 59994);
                return result;
            }
            if ((divisor < 0) || (divisor >= (Dfp.RADIX))) {
                if (CallChecker.beforeDeref(field, DfpField.class, 1925, 60124, 60128)) {
                    CallChecker.isCalled(field, DfpField.class, 1925, 60124, 60128).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                }
                Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 1926, 60183, 60218);
                if (CallChecker.beforeDeref(result, Dfp.class, 1927, 60232, 60237)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1927, 60232, 60237);
                    CallChecker.isCalled(result, Dfp.class, 1927, 60232, 60237).nans = Dfp.QNAN;
                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 1927, 60232, 60237).nans, "CallChecker.isCalled(result, Dfp.class, 1927, 60232, 60237).nans", 1927, 60232, 60250);
                }
                result = dotrap(DfpField.FLAG_INVALID, Dfp.DIVIDE_TRAP, result, result);
                CallChecker.varAssign(result, "result", 1928, 60264, 60331);
                return result;
            }
            Dfp result = CallChecker.varInit(newInstance(this), "result", 1932, 60379, 60409);
            int rl = CallChecker.varInit(((int) (0)), "rl", 1934, 60420, 60430);
            mant = CallChecker.beforeCalled(mant, int[].class, 1935, 60453, 60456);
            for (int i = (CallChecker.isCalled(mant, int[].class, 1935, 60453, 60456).length) - 1; i >= 0; i--) {
                result = CallChecker.beforeCalled(result, Dfp.class, 1936, 60520, 60525);
                CallChecker.isCalled(result, Dfp.class, 1936, 60520, 60525).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1936, 60520, 60525).mant, int[].class, 1936, 60520, 60530);
                final int r = CallChecker.varInit(((int) ((rl * (Dfp.RADIX)) + (CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1936, 60520, 60525).mant, int[].class, 1936, 60520, 60530)[i]))), "r", 1936, 60495, 60534);
                final int rh = CallChecker.varInit(((int) (r / divisor)), "rh", 1937, 60548, 60574);
                rl = r - (rh * divisor);
                CallChecker.varAssign(rl, "rl", 1938, 60588, 60609);
                if (CallChecker.beforeDeref(result, Dfp.class, 1939, 60623, 60628)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1939, 60623, 60628);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1939, 60623, 60628).mant, int[].class, 1939, 60623, 60633)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1939, 60623, 60628);
                        CallChecker.isCalled(result, Dfp.class, 1939, 60623, 60628).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1939, 60623, 60628).mant, int[].class, 1939, 60623, 60633);
                        CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1939, 60623, 60628).mant, int[].class, 1939, 60623, 60633)[i] = rh;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1939, 60623, 60628).mant, int[].class, 1939, 60623, 60633)[i], "CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1939, 60623, 60628).mant, int[].class, 1939, 60623, 60633)[i]", 1939, 60623, 60642);
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 1942, 60667, 60672)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1942, 60679, 60682)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 1942, 60667, 60672);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1942, 60667, 60672).mant, int[].class, 1942, 60667, 60677)) {
                        result = CallChecker.beforeCalled(result, Dfp.class, 1942, 60667, 60672);
                        mant = CallChecker.beforeCalled(mant, int[].class, 1942, 60679, 60682);
                        CallChecker.isCalled(result, Dfp.class, 1942, 60667, 60672).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1942, 60667, 60672).mant, int[].class, 1942, 60667, 60677);
                        if ((CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1942, 60667, 60672).mant, int[].class, 1942, 60667, 60677)[((CallChecker.isCalled(mant, int[].class, 1942, 60679, 60682).length) - 1)]) == 0) {
                            if (CallChecker.beforeDeref(result, Dfp.class, 1944, 60739, 60744)) {
                                result = CallChecker.beforeCalled(result, Dfp.class, 1944, 60739, 60744);
                                CallChecker.isCalled(result, Dfp.class, 1944, 60739, 60744).shiftLeft();
                            }
                            final int r = CallChecker.varInit(((int) (rl * (Dfp.RADIX))), "r", 1945, 60771, 60795);
                            final int rh = CallChecker.varInit(((int) (r / divisor)), "rh", 1946, 60856, 60882);
                            rl = r - (rh * divisor);
                            CallChecker.varAssign(rl, "rl", 1947, 60896, 60917);
                            if (CallChecker.beforeDeref(result, Dfp.class, 1948, 60931, 60936)) {
                                result = CallChecker.beforeCalled(result, Dfp.class, 1948, 60931, 60936);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp.class, 1948, 60931, 60936).mant, int[].class, 1948, 60931, 60941)) {
                                    result = CallChecker.beforeCalled(result, Dfp.class, 1948, 60931, 60936);
                                    CallChecker.isCalled(result, Dfp.class, 1948, 60931, 60936).mant = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp.class, 1948, 60931, 60936).mant, int[].class, 1948, 60931, 60941);
                                    CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1948, 60931, 60936).mant, int[].class, 1948, 60931, 60941)[0] = rh;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1948, 60931, 60936).mant, int[].class, 1948, 60931, 60941)[0], "CallChecker.isCalled(CallChecker.isCalled(result, Dfp.class, 1948, 60931, 60936).mant, int[].class, 1948, 60931, 60941)[0]", 1948, 60931, 60950);
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            result = CallChecker.beforeCalled(result, Dfp.class, 1951, 60988, 60993);
            final int excp = CallChecker.varInit(((int) (CallChecker.isCalled(result, Dfp.class, 1951, 60988, 60993).round(((rl * (Dfp.RADIX)) / divisor)))), "excp", 1951, 60971, 61022);
            if (excp != 0) {
                result = dotrap(excp, Dfp.DIVIDE_TRAP, result, result);
                CallChecker.varAssign(result, "result", 1953, 61081, 61131);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4059.methodEnd();
        }
    }

    public Dfp reciprocal() {
        MethodContext _bcornu_methode_context4060 = new MethodContext(Dfp.class, 1961, 61179, 61278);
        try {
            CallChecker.varInit(this, "this", 1961, 61179, 61278);
            CallChecker.varInit(this.field, "field", 1961, 61179, 61278);
            CallChecker.varInit(this.nans, "nans", 1961, 61179, 61278);
            CallChecker.varInit(this.exp, "exp", 1961, 61179, 61278);
            CallChecker.varInit(this.sign, "sign", 1961, 61179, 61278);
            CallChecker.varInit(this.mant, "mant", 1961, 61179, 61278);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1961, 61179, 61278);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1961, 61179, 61278);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1961, 61179, 61278);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1961, 61179, 61278);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1961, 61179, 61278);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1961, 61179, 61278);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1961, 61179, 61278);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1961, 61179, 61278);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1961, 61179, 61278);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1961, 61179, 61278);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1961, 61179, 61278);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1961, 61179, 61278);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1961, 61179, 61278);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1961, 61179, 61278);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1961, 61179, 61278);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1961, 61179, 61278);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1961, 61179, 61278);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1961, 61179, 61278);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1961, 61179, 61278);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1961, 61179, 61278);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1961, 61179, 61278);
            if (CallChecker.beforeDeref(field, DfpField.class, 1962, 61245, 61249)) {
                final Dfp npe_invocation_var846 = CallChecker.isCalled(field, DfpField.class, 1962, 61245, 61249).getOne();
                if (CallChecker.beforeDeref(npe_invocation_var846, Dfp.class, 1962, 61245, 61258)) {
                    return CallChecker.isCalled(npe_invocation_var846, Dfp.class, 1962, 61245, 61258).divide(this);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4060.methodEnd();
        }
    }

    public Dfp sqrt() {
        MethodContext _bcornu_methode_context4061 = new MethodContext(Dfp.class, 1969, 61285, 63935);
        try {
            CallChecker.varInit(this, "this", 1969, 61285, 63935);
            CallChecker.varInit(this.field, "field", 1969, 61285, 63935);
            CallChecker.varInit(this.nans, "nans", 1969, 61285, 63935);
            CallChecker.varInit(this.exp, "exp", 1969, 61285, 63935);
            CallChecker.varInit(this.sign, "sign", 1969, 61285, 63935);
            CallChecker.varInit(this.mant, "mant", 1969, 61285, 63935);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 1969, 61285, 63935);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 1969, 61285, 63935);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 1969, 61285, 63935);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 1969, 61285, 63935);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 1969, 61285, 63935);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 1969, 61285, 63935);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 1969, 61285, 63935);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 1969, 61285, 63935);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 1969, 61285, 63935);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 1969, 61285, 63935);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 1969, 61285, 63935);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 1969, 61285, 63935);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 1969, 61285, 63935);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 1969, 61285, 63935);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 1969, 61285, 63935);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 1969, 61285, 63935);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 1969, 61285, 63935);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 1969, 61285, 63935);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 1969, 61285, 63935);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 1969, 61285, 63935);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 1969, 61285, 63935);
            if (CallChecker.beforeDeref(mant, int[].class, 1972, 61478, 61481)) {
                if (CallChecker.beforeDeref(mant, int[].class, 1972, 61473, 61476)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 1972, 61478, 61481);
                    mant = CallChecker.beforeCalled(mant, int[].class, 1972, 61473, 61476);
                    if (((nans) == (Dfp.FINITE)) && ((CallChecker.isCalled(mant, int[].class, 1972, 61473, 61476)[((CallChecker.isCalled(mant, int[].class, 1972, 61478, 61481).length) - 1)]) == 0)) {
                        return newInstance(this);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if ((nans) != (Dfp.FINITE)) {
                if (((nans) == (Dfp.INFINITE)) && ((sign) == 1)) {
                    return newInstance(this);
                }
                if ((nans) == (Dfp.QNAN)) {
                    return newInstance(this);
                }
                if ((nans) == (Dfp.SNAN)) {
                    Dfp result = CallChecker.init(Dfp.class);
                    if (CallChecker.beforeDeref(field, DfpField.class, 1990, 61915, 61919)) {
                        CallChecker.isCalled(field, DfpField.class, 1990, 61915, 61919).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                    }
                    result = newInstance(this);
                    CallChecker.varAssign(result, "result", 1991, 61978, 62004);
                    result = dotrap(DfpField.FLAG_INVALID, Dfp.SQRT_TRAP, null, result);
                    CallChecker.varAssign(result, "result", 1992, 62022, 62085);
                    return result;
                }
            }
            if ((sign) == (-1)) {
                Dfp result = CallChecker.init(Dfp.class);
                if (CallChecker.beforeDeref(field, DfpField.class, 2001, 62233, 62237)) {
                    CallChecker.isCalled(field, DfpField.class, 2001, 62233, 62237).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                }
                result = newInstance(this);
                CallChecker.varAssign(result, "result", 2002, 62292, 62318);
                if (CallChecker.beforeDeref(result, Dfp.class, 2003, 62332, 62337)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 2003, 62332, 62337);
                    CallChecker.isCalled(result, Dfp.class, 2003, 62332, 62337).nans = Dfp.QNAN;
                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 2003, 62332, 62337).nans, "CallChecker.isCalled(result, Dfp.class, 2003, 62332, 62337).nans", 2003, 62332, 62350);
                }
                result = dotrap(DfpField.FLAG_INVALID, Dfp.SQRT_TRAP, null, result);
                CallChecker.varAssign(result, "result", 2004, 62364, 62427);
                return result;
            }
            Dfp x = CallChecker.varInit(newInstance(this), "x", 2008, 62475, 62500);
            if (CallChecker.beforeDeref(x, Dfp.class, 2011, 62592, 62592)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 2011, 62606, 62606)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 2011, 62592, 62592);
                    x = CallChecker.beforeCalled(x, Dfp.class, 2011, 62606, 62606);
                    if (((CallChecker.isCalled(x, Dfp.class, 2011, 62592, 62592).exp) < (-1)) || ((CallChecker.isCalled(x, Dfp.class, 2011, 62606, 62606).exp) > 1)) {
                        if (CallChecker.beforeDeref(x, Dfp.class, 2012, 62631, 62631)) {
                            x = CallChecker.beforeCalled(x, Dfp.class, 2012, 62631, 62631);
                            CallChecker.isCalled(x, Dfp.class, 2012, 62631, 62631).exp = (this.exp) / 2;
                            CallChecker.varAssign(CallChecker.isCalled(x, Dfp.class, 2012, 62631, 62631).exp, "CallChecker.isCalled(x, Dfp.class, 2012, 62631, 62631).exp", 2012, 62631, 62651);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(x, Dfp.class, 2016, 62725, 62725)) {
                if (CallChecker.beforeDeref(mant, int[].class, 2016, 62732, 62735)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 2016, 62725, 62725);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 2016, 62725, 62725).mant, int[].class, 2016, 62725, 62730)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 2016, 62725, 62725);
                        mant = CallChecker.beforeCalled(mant, int[].class, 2016, 62732, 62735);
                        CallChecker.isCalled(x, Dfp.class, 2016, 62725, 62725).mant = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp.class, 2016, 62725, 62725).mant, int[].class, 2016, 62725, 62730);
                        switch ((CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2016, 62725, 62725).mant, int[].class, 2016, 62725, 62730)[((CallChecker.isCalled(mant, int[].class, 2016, 62732, 62735).length) - 1)]) / 2000) {
                            case 0 :
                                if (CallChecker.beforeDeref(x, Dfp.class, 2018, 62793, 62793)) {
                                    if (CallChecker.beforeDeref(mant, int[].class, 2018, 62800, 62803)) {
                                        x = CallChecker.beforeCalled(x, Dfp.class, 2018, 62793, 62793);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 2018, 62793, 62793).mant, int[].class, 2018, 62793, 62798)) {
                                            if (CallChecker.beforeDeref(x, Dfp.class, 2018, 62817, 62817)) {
                                                if (CallChecker.beforeDeref(mant, int[].class, 2018, 62824, 62827)) {
                                                    x = CallChecker.beforeCalled(x, Dfp.class, 2018, 62817, 62817);
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 2018, 62817, 62817).mant, int[].class, 2018, 62817, 62822)) {
                                                        x = CallChecker.beforeCalled(x, Dfp.class, 2018, 62793, 62793);
                                                        mant = CallChecker.beforeCalled(mant, int[].class, 2018, 62800, 62803);
                                                        CallChecker.isCalled(x, Dfp.class, 2018, 62793, 62793).mant = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp.class, 2018, 62793, 62793).mant, int[].class, 2018, 62793, 62798);
                                                        x = CallChecker.beforeCalled(x, Dfp.class, 2018, 62817, 62817);
                                                        mant = CallChecker.beforeCalled(mant, int[].class, 2018, 62824, 62827);
                                                        CallChecker.isCalled(x, Dfp.class, 2018, 62817, 62817).mant = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp.class, 2018, 62817, 62817).mant, int[].class, 2018, 62817, 62822);
                                                        CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2018, 62793, 62793).mant, int[].class, 2018, 62793, 62798)[((CallChecker.isCalled(mant, int[].class, 2018, 62800, 62803).length) - 1)] = ((CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2018, 62817, 62817).mant, int[].class, 2018, 62817, 62822)[((CallChecker.isCalled(mant, int[].class, 2018, 62824, 62827).length) - 1)]) / 2) + 1;
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2018, 62793, 62793).mant, int[].class, 2018, 62793, 62798)[((CallChecker.isCalled(this.mant, int[].class, 2018, 62800, 62803).length) - 1)], "CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2018, 62793, 62793).mant, int[].class, 2018, 62793, 62798)[((CallChecker.isCalled(this.mant, int[].class, 2018, 62800, 62803).length) - 1)]", 2018, 62793, 62842);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                                break;
                            case 2 :
                                if (CallChecker.beforeDeref(x, Dfp.class, 2021, 62903, 62903)) {
                                    if (CallChecker.beforeDeref(mant, int[].class, 2021, 62910, 62913)) {
                                        x = CallChecker.beforeCalled(x, Dfp.class, 2021, 62903, 62903);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 2021, 62903, 62903).mant, int[].class, 2021, 62903, 62908)) {
                                            x = CallChecker.beforeCalled(x, Dfp.class, 2021, 62903, 62903);
                                            mant = CallChecker.beforeCalled(mant, int[].class, 2021, 62910, 62913);
                                            CallChecker.isCalled(x, Dfp.class, 2021, 62903, 62903).mant = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp.class, 2021, 62903, 62903).mant, int[].class, 2021, 62903, 62908);
                                            CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2021, 62903, 62903).mant, int[].class, 2021, 62903, 62908)[((CallChecker.isCalled(mant, int[].class, 2021, 62910, 62913).length) - 1)] = 1500;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2021, 62903, 62903).mant, int[].class, 2021, 62903, 62908)[((CallChecker.isCalled(this.mant, int[].class, 2021, 62910, 62913).length) - 1)], "CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2021, 62903, 62903).mant, int[].class, 2021, 62903, 62908)[((CallChecker.isCalled(this.mant, int[].class, 2021, 62910, 62913).length) - 1)]", 2021, 62903, 62931);
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                                break;
                            case 3 :
                                if (CallChecker.beforeDeref(x, Dfp.class, 2024, 62992, 62992)) {
                                    if (CallChecker.beforeDeref(mant, int[].class, 2024, 62999, 63002)) {
                                        x = CallChecker.beforeCalled(x, Dfp.class, 2024, 62992, 62992);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 2024, 62992, 62992).mant, int[].class, 2024, 62992, 62997)) {
                                            x = CallChecker.beforeCalled(x, Dfp.class, 2024, 62992, 62992);
                                            mant = CallChecker.beforeCalled(mant, int[].class, 2024, 62999, 63002);
                                            CallChecker.isCalled(x, Dfp.class, 2024, 62992, 62992).mant = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp.class, 2024, 62992, 62992).mant, int[].class, 2024, 62992, 62997);
                                            CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2024, 62992, 62992).mant, int[].class, 2024, 62992, 62997)[((CallChecker.isCalled(mant, int[].class, 2024, 62999, 63002).length) - 1)] = 2200;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2024, 62992, 62992).mant, int[].class, 2024, 62992, 62997)[((CallChecker.isCalled(this.mant, int[].class, 2024, 62999, 63002).length) - 1)], "CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2024, 62992, 62992).mant, int[].class, 2024, 62992, 62997)[((CallChecker.isCalled(this.mant, int[].class, 2024, 62999, 63002).length) - 1)]", 2024, 62992, 63020);
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                                break;
                            default :
                                if (CallChecker.beforeDeref(x, Dfp.class, 2027, 63082, 63082)) {
                                    if (CallChecker.beforeDeref(mant, int[].class, 2027, 63089, 63092)) {
                                        x = CallChecker.beforeCalled(x, Dfp.class, 2027, 63082, 63082);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 2027, 63082, 63082).mant, int[].class, 2027, 63082, 63087)) {
                                            x = CallChecker.beforeCalled(x, Dfp.class, 2027, 63082, 63082);
                                            mant = CallChecker.beforeCalled(mant, int[].class, 2027, 63089, 63092);
                                            CallChecker.isCalled(x, Dfp.class, 2027, 63082, 63082).mant = CallChecker.beforeCalled(CallChecker.isCalled(x, Dfp.class, 2027, 63082, 63082).mant, int[].class, 2027, 63082, 63087);
                                            CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2027, 63082, 63082).mant, int[].class, 2027, 63082, 63087)[((CallChecker.isCalled(mant, int[].class, 2027, 63089, 63092).length) - 1)] = 3000;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2027, 63082, 63082).mant, int[].class, 2027, 63082, 63087)[((CallChecker.isCalled(this.mant, int[].class, 2027, 63089, 63092).length) - 1)], "CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2027, 63082, 63082).mant, int[].class, 2027, 63082, 63087)[((CallChecker.isCalled(this.mant, int[].class, 2027, 63089, 63092).length) - 1)]", 2027, 63082, 63110);
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                        }
                    }
                }
            }
            Dfp dx = CallChecker.varInit(newInstance(x), "dx", 2030, 63131, 63154);
            Dfp px = CallChecker.varInit(getZero(), "px", 2035, 63284, 63303);
            Dfp ppx = CallChecker.varInit(getZero(), "ppx", 2036, 63313, 63332);
            x = CallChecker.beforeCalled(x, Dfp.class, 2037, 63349, 63349);
            while (CallChecker.isCalled(x, Dfp.class, 2037, 63349, 63349).unequal(px)) {
                dx = newInstance(x);
                CallChecker.varAssign(dx, "dx", 2038, 63378, 63397);
                if (CallChecker.beforeDeref(dx, Dfp.class, 2039, 63411, 63412)) {
                    dx = CallChecker.beforeCalled(dx, Dfp.class, 2039, 63411, 63412);
                    CallChecker.isCalled(dx, Dfp.class, 2039, 63411, 63412).sign = -1;
                    CallChecker.varAssign(CallChecker.isCalled(dx, Dfp.class, 2039, 63411, 63412).sign, "CallChecker.isCalled(dx, Dfp.class, 2039, 63411, 63412).sign", 2039, 63411, 63423);
                }
                if (CallChecker.beforeDeref(dx, Dfp.class, 2040, 63442, 63443)) {
                    dx = CallChecker.beforeCalled(dx, Dfp.class, 2040, 63442, 63443);
                    dx = CallChecker.isCalled(dx, Dfp.class, 2040, 63442, 63443).add(this.divide(x));
                    CallChecker.varAssign(dx, "dx", 2040, 63437, 63464);
                }
                if (CallChecker.beforeDeref(dx, Dfp.class, 2041, 63483, 63484)) {
                    dx = CallChecker.beforeCalled(dx, Dfp.class, 2041, 63483, 63484);
                    dx = CallChecker.isCalled(dx, Dfp.class, 2041, 63483, 63484).divide(2);
                    CallChecker.varAssign(dx, "dx", 2041, 63478, 63495);
                }
                ppx = px;
                CallChecker.varAssign(ppx, "ppx", 2042, 63509, 63517);
                px = x;
                CallChecker.varAssign(px, "px", 2043, 63531, 63537);
                if (CallChecker.beforeDeref(x, Dfp.class, 2044, 63555, 63555)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 2044, 63555, 63555);
                    x = CallChecker.isCalled(x, Dfp.class, 2044, 63555, 63555).add(dx);
                    CallChecker.varAssign(x, "x", 2044, 63551, 63564);
                }
                if (CallChecker.beforeDeref(x, Dfp.class, 2046, 63583, 63583)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 2046, 63583, 63583);
                    if (CallChecker.isCalled(x, Dfp.class, 2046, 63583, 63583).equals(ppx)) {
                        break;
                    }
                }
                if (CallChecker.beforeDeref(dx, Dfp.class, 2053, 63833, 63834)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 2053, 63841, 63844)) {
                        dx = CallChecker.beforeCalled(dx, Dfp.class, 2053, 63833, 63834);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(dx, Dfp.class, 2053, 63833, 63834).mant, int[].class, 2053, 63833, 63839)) {
                            dx = CallChecker.beforeCalled(dx, Dfp.class, 2053, 63833, 63834);
                            mant = CallChecker.beforeCalled(mant, int[].class, 2053, 63841, 63844);
                            CallChecker.isCalled(dx, Dfp.class, 2053, 63833, 63834).mant = CallChecker.beforeCalled(CallChecker.isCalled(dx, Dfp.class, 2053, 63833, 63834).mant, int[].class, 2053, 63833, 63839);
                            if ((CallChecker.isCalled(CallChecker.isCalled(dx, Dfp.class, 2053, 63833, 63834).mant, int[].class, 2053, 63833, 63839)[((CallChecker.isCalled(mant, int[].class, 2053, 63841, 63844).length) - 1)]) == 0) {
                                break;
                            }
                        }
                    }
                }
            } 
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4061.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context4062 = new MethodContext(String.class, 2066, 63942, 64490);
        try {
            CallChecker.varInit(this, "this", 2066, 63942, 64490);
            CallChecker.varInit(this.field, "field", 2066, 63942, 64490);
            CallChecker.varInit(this.nans, "nans", 2066, 63942, 64490);
            CallChecker.varInit(this.exp, "exp", 2066, 63942, 64490);
            CallChecker.varInit(this.sign, "sign", 2066, 63942, 64490);
            CallChecker.varInit(this.mant, "mant", 2066, 63942, 64490);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2066, 63942, 64490);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2066, 63942, 64490);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2066, 63942, 64490);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2066, 63942, 64490);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2066, 63942, 64490);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2066, 63942, 64490);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2066, 63942, 64490);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2066, 63942, 64490);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2066, 63942, 64490);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2066, 63942, 64490);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2066, 63942, 64490);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2066, 63942, 64490);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2066, 63942, 64490);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2066, 63942, 64490);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2066, 63942, 64490);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2066, 63942, 64490);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2066, 63942, 64490);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2066, 63942, 64490);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2066, 63942, 64490);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2066, 63942, 64490);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2066, 63942, 64490);
            if ((nans) != (Dfp.FINITE)) {
                if ((nans) == (Dfp.INFINITE)) {
                    if ((sign) < 0) {
                        return Dfp.NEG_INFINITY_STRING;
                    }else {
                        return Dfp.POS_INFINITY_STRING;
                    }
                }else {
                    return Dfp.NAN_STRING;
                }
            }
            if (CallChecker.beforeDeref(mant, int[].class, 2076, 64388, 64391)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 2076, 64388, 64391);
                if (((exp) > (CallChecker.isCalled(mant, int[].class, 2076, 64388, 64391).length)) || ((exp) < (-1))) {
                    return dfp2sci();
                }
            }else
                throw new AbnormalExecutionError();
            
            return dfp2string();
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4062.methodEnd();
        }
    }

    protected String dfp2sci() {
        MethodContext _bcornu_methode_context4063 = new MethodContext(String.class, 2087, 64497, 66662);
        try {
            CallChecker.varInit(this, "this", 2087, 64497, 66662);
            CallChecker.varInit(this.field, "field", 2087, 64497, 66662);
            CallChecker.varInit(this.nans, "nans", 2087, 64497, 66662);
            CallChecker.varInit(this.exp, "exp", 2087, 64497, 66662);
            CallChecker.varInit(this.sign, "sign", 2087, 64497, 66662);
            CallChecker.varInit(this.mant, "mant", 2087, 64497, 66662);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2087, 64497, 66662);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2087, 64497, 66662);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2087, 64497, 66662);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2087, 64497, 66662);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2087, 64497, 66662);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2087, 64497, 66662);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2087, 64497, 66662);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2087, 64497, 66662);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2087, 64497, 66662);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2087, 64497, 66662);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2087, 64497, 66662);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2087, 64497, 66662);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2087, 64497, 66662);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2087, 64497, 66662);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2087, 64497, 66662);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2087, 64497, 66662);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2087, 64497, 66662);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2087, 64497, 66662);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2087, 64497, 66662);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2087, 64497, 66662);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2087, 64497, 66662);
            char[] rawdigits = CallChecker.init(char[].class);
            if (CallChecker.beforeDeref(mant, int[].class, 2088, 64716, 64719)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 2088, 64716, 64719);
                rawdigits = new char[(CallChecker.isCalled(mant, int[].class, 2088, 64716, 64719).length) * 4];
                CallChecker.varAssign(rawdigits, "rawdigits", 2088, 64716, 64719);
            }
            char[] outputbuffer = CallChecker.init(char[].class);
            if (CallChecker.beforeDeref(mant, int[].class, 2089, 64773, 64776)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 2089, 64773, 64776);
                outputbuffer = new char[((CallChecker.isCalled(mant, int[].class, 2089, 64773, 64776).length) * 4) + 20];
                CallChecker.varAssign(outputbuffer, "outputbuffer", 2089, 64773, 64776);
            }
            int p = CallChecker.init(int.class);
            int q = CallChecker.init(int.class);
            int e = CallChecker.init(int.class);
            int ae = CallChecker.init(int.class);
            int shf = CallChecker.init(int.class);
            p = 0;
            CallChecker.varAssign(p, "p", 2097, 64913, 64918);
            mant = CallChecker.beforeCalled(mant, int[].class, 2098, 64941, 64944);
            for (int i = (CallChecker.isCalled(mant, int[].class, 2098, 64941, 64944).length) - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(rawdigits, char[].class, 2099, 64985, 64993)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 2099, 65011, 65014)) {
                        rawdigits = CallChecker.beforeCalled(rawdigits, char[].class, 2099, 64985, 64993);
                        mant = CallChecker.beforeCalled(mant, int[].class, 2099, 65011, 65014);
                        CallChecker.isCalled(rawdigits, char[].class, 2099, 64985, 64993)[(p++)] = ((char) (((CallChecker.isCalled(mant, int[].class, 2099, 65011, 65014)[i]) / 1000) + '0'));
                        CallChecker.varAssign(CallChecker.isCalled(rawdigits, char[].class, 2099, 64985, 64993)[(p - 1)], "CallChecker.isCalled(rawdigits, char[].class, 2099, 64985, 64993)[(p - 1)]", 2099, 64985, 65033);
                    }
                }
                if (CallChecker.beforeDeref(rawdigits, char[].class, 2100, 65047, 65055)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 2100, 65074, 65077)) {
                        rawdigits = CallChecker.beforeCalled(rawdigits, char[].class, 2100, 65047, 65055);
                        mant = CallChecker.beforeCalled(mant, int[].class, 2100, 65074, 65077);
                        CallChecker.isCalled(rawdigits, char[].class, 2100, 65047, 65055)[(p++)] = ((char) ((((CallChecker.isCalled(mant, int[].class, 2100, 65074, 65077)[i]) / 100) % 10) + '0'));
                        CallChecker.varAssign(CallChecker.isCalled(rawdigits, char[].class, 2100, 65047, 65055)[(p - 1)], "CallChecker.isCalled(rawdigits, char[].class, 2100, 65047, 65055)[(p - 1)]", 2100, 65047, 65100);
                    }
                }
                if (CallChecker.beforeDeref(rawdigits, char[].class, 2101, 65114, 65122)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 2101, 65141, 65144)) {
                        rawdigits = CallChecker.beforeCalled(rawdigits, char[].class, 2101, 65114, 65122);
                        mant = CallChecker.beforeCalled(mant, int[].class, 2101, 65141, 65144);
                        CallChecker.isCalled(rawdigits, char[].class, 2101, 65114, 65122)[(p++)] = ((char) ((((CallChecker.isCalled(mant, int[].class, 2101, 65141, 65144)[i]) / 10) % 10) + '0'));
                        CallChecker.varAssign(CallChecker.isCalled(rawdigits, char[].class, 2101, 65114, 65122)[(p - 1)], "CallChecker.isCalled(rawdigits, char[].class, 2101, 65114, 65122)[(p - 1)]", 2101, 65114, 65167);
                    }
                }
                if (CallChecker.beforeDeref(rawdigits, char[].class, 2102, 65181, 65189)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 2102, 65208, 65211)) {
                        rawdigits = CallChecker.beforeCalled(rawdigits, char[].class, 2102, 65181, 65189);
                        mant = CallChecker.beforeCalled(mant, int[].class, 2102, 65208, 65211);
                        CallChecker.isCalled(rawdigits, char[].class, 2102, 65181, 65189)[(p++)] = ((char) (((CallChecker.isCalled(mant, int[].class, 2102, 65208, 65211)[i]) % 10) + '0'));
                        CallChecker.varAssign(CallChecker.isCalled(rawdigits, char[].class, 2102, 65181, 65189)[(p - 1)], "CallChecker.isCalled(rawdigits, char[].class, 2102, 65181, 65189)[(p - 1)]", 2102, 65181, 65229);
                    }
                }
            }
            rawdigits = CallChecker.beforeCalled(rawdigits, char[].class, 2106, 65305, 65313);
            for (p = 0; p < (CallChecker.isCalled(rawdigits, char[].class, 2106, 65305, 65313).length); p++) {
                CallChecker.varAssign(p, "p", 2106, 65294, 65298);
                if (CallChecker.beforeDeref(rawdigits, char[].class, 2107, 65346, 65354)) {
                    rawdigits = CallChecker.beforeCalled(rawdigits, char[].class, 2107, 65346, 65354);
                    if ((CallChecker.isCalled(rawdigits, char[].class, 2107, 65346, 65354)[p]) != '0') {
                        break;
                    }
                }
            }
            shf = p;
            CallChecker.varAssign(shf, "shf", 2111, 65424, 65431);
            q = 0;
            CallChecker.varAssign(q, "q", 2114, 65475, 65480);
            if ((sign) == (-1)) {
                if (CallChecker.beforeDeref(outputbuffer, char[].class, 2116, 65520, 65531)) {
                    outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2116, 65520, 65531);
                    CallChecker.isCalled(outputbuffer, char[].class, 2116, 65520, 65531)[(q++)] = '-';
                    CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2116, 65520, 65531)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2116, 65520, 65531)[(q - 1)]", 2116, 65520, 65543);
                }
            }
            if (CallChecker.beforeDeref(rawdigits, char[].class, 2119, 65573, 65581)) {
                rawdigits = CallChecker.beforeCalled(rawdigits, char[].class, 2119, 65573, 65581);
                if (p != (CallChecker.isCalled(rawdigits, char[].class, 2119, 65573, 65581).length)) {
                    if (CallChecker.beforeDeref(outputbuffer, char[].class, 2121, 65649, 65660)) {
                        if (CallChecker.beforeDeref(rawdigits, char[].class, 2121, 65669, 65677)) {
                            outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2121, 65649, 65660);
                            rawdigits = CallChecker.beforeCalled(rawdigits, char[].class, 2121, 65669, 65677);
                            CallChecker.isCalled(outputbuffer, char[].class, 2121, 65649, 65660)[(q++)] = CallChecker.isCalled(rawdigits, char[].class, 2121, 65669, 65677)[(p++)];
                            CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2121, 65649, 65660)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2121, 65649, 65660)[(q - 1)]", 2121, 65649, 65683);
                        }
                    }
                    if (CallChecker.beforeDeref(outputbuffer, char[].class, 2122, 65697, 65708)) {
                        outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2122, 65697, 65708);
                        CallChecker.isCalled(outputbuffer, char[].class, 2122, 65697, 65708)[(q++)] = '.';
                        CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2122, 65697, 65708)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2122, 65697, 65708)[(q - 1)]", 2122, 65697, 65720);
                    }
                    rawdigits = CallChecker.beforeCalled(rawdigits, char[].class, 2124, 65744, 65752);
                    while (p < (CallChecker.isCalled(rawdigits, char[].class, 2124, 65744, 65752).length)) {
                        if (CallChecker.beforeDeref(outputbuffer, char[].class, 2125, 65780, 65791)) {
                            if (CallChecker.beforeDeref(rawdigits, char[].class, 2125, 65800, 65808)) {
                                outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2125, 65780, 65791);
                                rawdigits = CallChecker.beforeCalled(rawdigits, char[].class, 2125, 65800, 65808);
                                CallChecker.isCalled(outputbuffer, char[].class, 2125, 65780, 65791)[(q++)] = CallChecker.isCalled(rawdigits, char[].class, 2125, 65800, 65808)[(p++)];
                                CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2125, 65780, 65791)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2125, 65780, 65791)[(q - 1)]", 2125, 65780, 65814);
                            }
                        }
                    } 
                }else {
                    if (CallChecker.beforeDeref(outputbuffer, char[].class, 2128, 65859, 65870)) {
                        outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2128, 65859, 65870);
                        CallChecker.isCalled(outputbuffer, char[].class, 2128, 65859, 65870)[(q++)] = '0';
                        CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2128, 65859, 65870)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2128, 65859, 65870)[(q - 1)]", 2128, 65859, 65882);
                    }
                    if (CallChecker.beforeDeref(outputbuffer, char[].class, 2129, 65896, 65907)) {
                        outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2129, 65896, 65907);
                        CallChecker.isCalled(outputbuffer, char[].class, 2129, 65896, 65907)[(q++)] = '.';
                        CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2129, 65896, 65907)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2129, 65896, 65907)[(q - 1)]", 2129, 65896, 65919);
                    }
                    if (CallChecker.beforeDeref(outputbuffer, char[].class, 2130, 65933, 65944)) {
                        outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2130, 65933, 65944);
                        CallChecker.isCalled(outputbuffer, char[].class, 2130, 65933, 65944)[(q++)] = '0';
                        CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2130, 65933, 65944)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2130, 65933, 65944)[(q - 1)]", 2130, 65933, 65956);
                    }
                    if (CallChecker.beforeDeref(outputbuffer, char[].class, 2131, 65970, 65981)) {
                        outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2131, 65970, 65981);
                        CallChecker.isCalled(outputbuffer, char[].class, 2131, 65970, 65981)[(q++)] = 'e';
                        CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2131, 65970, 65981)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2131, 65970, 65981)[(q - 1)]", 2131, 65970, 65993);
                    }
                    if (CallChecker.beforeDeref(outputbuffer, char[].class, 2132, 66007, 66018)) {
                        outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2132, 66007, 66018);
                        CallChecker.isCalled(outputbuffer, char[].class, 2132, 66007, 66018)[(q++)] = '0';
                        CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2132, 66007, 66018)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2132, 66007, 66018)[(q - 1)]", 2132, 66007, 66030);
                    }
                    return new String(outputbuffer, 0, 5);
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(outputbuffer, char[].class, 2136, 66102, 66113)) {
                outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2136, 66102, 66113);
                CallChecker.isCalled(outputbuffer, char[].class, 2136, 66102, 66113)[(q++)] = 'e';
                CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2136, 66102, 66113)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2136, 66102, 66113)[(q - 1)]", 2136, 66102, 66125);
            }
            e = (((exp) * 4) - shf) - 1;
            CallChecker.varAssign(e, "e", 2140, 66177, 66198);
            ae = e;
            CallChecker.varAssign(ae, "ae", 2141, 66208, 66214);
            if (e < 0) {
                ae = -e;
                CallChecker.varAssign(ae, "ae", 2143, 66249, 66256);
            }
            for (p = 1000000000; p > ae; p /= 10) {
                CallChecker.varAssign(p, "p", 2147, 66352, 66358);
                CallChecker.varAssign(p, "p", 2147, 66328, 66341);
            }
            if (e < 0) {
                if (CallChecker.beforeDeref(outputbuffer, char[].class, 2152, 66436, 66447)) {
                    outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2152, 66436, 66447);
                    CallChecker.isCalled(outputbuffer, char[].class, 2152, 66436, 66447)[(q++)] = '-';
                    CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2152, 66436, 66447)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2152, 66436, 66447)[(q - 1)]", 2152, 66436, 66459);
                }
            }
            while (p > 0) {
                if (CallChecker.beforeDeref(outputbuffer, char[].class, 2156, 66508, 66519)) {
                    outputbuffer = CallChecker.beforeCalled(outputbuffer, char[].class, 2156, 66508, 66519);
                    CallChecker.isCalled(outputbuffer, char[].class, 2156, 66508, 66519)[(q++)] = ((char) ((ae / p) + '0'));
                    CallChecker.varAssign(CallChecker.isCalled(outputbuffer, char[].class, 2156, 66508, 66519)[(q - 1)], "CallChecker.isCalled(outputbuffer, char[].class, 2156, 66508, 66519)[(q - 1)]", 2156, 66508, 66548);
                }
                ae = ae % p;
                CallChecker.varAssign(ae, "ae", 2157, 66562, 66573);
                p = p / 10;
                CallChecker.varAssign(p, "p", 2158, 66587, 66597);
            } 
            return new String(outputbuffer, 0, q);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4063.methodEnd();
        }
    }

    protected String dfp2string() {
        MethodContext _bcornu_methode_context4064 = new MethodContext(String.class, 2168, 66669, 68453);
        try {
            CallChecker.varInit(this, "this", 2168, 66669, 68453);
            CallChecker.varInit(this.field, "field", 2168, 66669, 68453);
            CallChecker.varInit(this.nans, "nans", 2168, 66669, 68453);
            CallChecker.varInit(this.exp, "exp", 2168, 66669, 68453);
            CallChecker.varInit(this.sign, "sign", 2168, 66669, 68453);
            CallChecker.varInit(this.mant, "mant", 2168, 66669, 68453);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2168, 66669, 68453);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2168, 66669, 68453);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2168, 66669, 68453);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2168, 66669, 68453);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2168, 66669, 68453);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2168, 66669, 68453);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2168, 66669, 68453);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2168, 66669, 68453);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2168, 66669, 68453);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2168, 66669, 68453);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2168, 66669, 68453);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2168, 66669, 68453);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2168, 66669, 68453);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2168, 66669, 68453);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2168, 66669, 68453);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2168, 66669, 68453);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2168, 66669, 68453);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2168, 66669, 68453);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2168, 66669, 68453);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2168, 66669, 68453);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2168, 66669, 68453);
            char[] buffer = CallChecker.init(char[].class);
            if (CallChecker.beforeDeref(mant, int[].class, 2169, 66877, 66880)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 2169, 66877, 66880);
                buffer = new char[((CallChecker.isCalled(mant, int[].class, 2169, 66877, 66880).length) * 4) + 20];
                CallChecker.varAssign(buffer, "buffer", 2169, 66877, 66880);
            }
            int p = CallChecker.varInit(((int) (1)), "p", 2170, 66906, 66915);
            int q = CallChecker.init(int.class);
            int e = CallChecker.varInit(((int) (this.exp)), "e", 2172, 66940, 66951);
            boolean pointInserted = CallChecker.varInit(((boolean) (false)), "pointInserted", 2173, 66961, 66990);
            if (CallChecker.beforeDeref(buffer, char[].class, 2175, 67001, 67006)) {
                buffer = CallChecker.beforeCalled(buffer, char[].class, 2175, 67001, 67006);
                CallChecker.isCalled(buffer, char[].class, 2175, 67001, 67006)[0] = ' ';
                CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2175, 67001, 67006)[0], "CallChecker.isCalled(buffer, char[].class, 2175, 67001, 67006)[0]", 2175, 67001, 67016);
            }
            if (e <= 0) {
                if (CallChecker.beforeDeref(buffer, char[].class, 2178, 67053, 67058)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2178, 67053, 67058);
                    CallChecker.isCalled(buffer, char[].class, 2178, 67053, 67058)[(p++)] = '0';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2178, 67053, 67058)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2178, 67053, 67058)[(p - 1)]", 2178, 67053, 67070);
                }
                if (CallChecker.beforeDeref(buffer, char[].class, 2179, 67084, 67089)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2179, 67084, 67089);
                    CallChecker.isCalled(buffer, char[].class, 2179, 67084, 67089)[(p++)] = '.';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2179, 67084, 67089)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2179, 67084, 67089)[(p - 1)]", 2179, 67084, 67101);
                }
                pointInserted = true;
                CallChecker.varAssign(pointInserted, "pointInserted", 2180, 67115, 67135);
            }
            while (e < 0) {
                if (CallChecker.beforeDeref(buffer, char[].class, 2184, 67184, 67189)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2184, 67184, 67189);
                    CallChecker.isCalled(buffer, char[].class, 2184, 67184, 67189)[(p++)] = '0';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2184, 67184, 67189)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2184, 67184, 67189)[(p - 1)]", 2184, 67184, 67201);
                }
                if (CallChecker.beforeDeref(buffer, char[].class, 2185, 67215, 67220)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2185, 67215, 67220);
                    CallChecker.isCalled(buffer, char[].class, 2185, 67215, 67220)[(p++)] = '0';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2185, 67215, 67220)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2185, 67215, 67220)[(p - 1)]", 2185, 67215, 67232);
                }
                if (CallChecker.beforeDeref(buffer, char[].class, 2186, 67246, 67251)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2186, 67246, 67251);
                    CallChecker.isCalled(buffer, char[].class, 2186, 67246, 67251)[(p++)] = '0';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2186, 67246, 67251)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2186, 67246, 67251)[(p - 1)]", 2186, 67246, 67263);
                }
                if (CallChecker.beforeDeref(buffer, char[].class, 2187, 67277, 67282)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2187, 67277, 67282);
                    CallChecker.isCalled(buffer, char[].class, 2187, 67277, 67282)[(p++)] = '0';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2187, 67277, 67282)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2187, 67277, 67282)[(p - 1)]", 2187, 67277, 67294);
                }
                e++;
            } 
            mant = CallChecker.beforeCalled(mant, int[].class, 2191, 67345, 67348);
            for (int i = (CallChecker.isCalled(mant, int[].class, 2191, 67345, 67348).length) - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(buffer, char[].class, 2192, 67389, 67394)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 2192, 67412, 67415)) {
                        buffer = CallChecker.beforeCalled(buffer, char[].class, 2192, 67389, 67394);
                        mant = CallChecker.beforeCalled(mant, int[].class, 2192, 67412, 67415);
                        CallChecker.isCalled(buffer, char[].class, 2192, 67389, 67394)[(p++)] = ((char) (((CallChecker.isCalled(mant, int[].class, 2192, 67412, 67415)[i]) / 1000) + '0'));
                        CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2192, 67389, 67394)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2192, 67389, 67394)[(p - 1)]", 2192, 67389, 67434);
                    }
                }
                if (CallChecker.beforeDeref(buffer, char[].class, 2193, 67448, 67453)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 2193, 67472, 67475)) {
                        buffer = CallChecker.beforeCalled(buffer, char[].class, 2193, 67448, 67453);
                        mant = CallChecker.beforeCalled(mant, int[].class, 2193, 67472, 67475);
                        CallChecker.isCalled(buffer, char[].class, 2193, 67448, 67453)[(p++)] = ((char) ((((CallChecker.isCalled(mant, int[].class, 2193, 67472, 67475)[i]) / 100) % 10) + '0'));
                        CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2193, 67448, 67453)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2193, 67448, 67453)[(p - 1)]", 2193, 67448, 67499);
                    }
                }
                if (CallChecker.beforeDeref(buffer, char[].class, 2194, 67513, 67518)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 2194, 67537, 67540)) {
                        buffer = CallChecker.beforeCalled(buffer, char[].class, 2194, 67513, 67518);
                        mant = CallChecker.beforeCalled(mant, int[].class, 2194, 67537, 67540);
                        CallChecker.isCalled(buffer, char[].class, 2194, 67513, 67518)[(p++)] = ((char) ((((CallChecker.isCalled(mant, int[].class, 2194, 67537, 67540)[i]) / 10) % 10) + '0'));
                        CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2194, 67513, 67518)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2194, 67513, 67518)[(p - 1)]", 2194, 67513, 67563);
                    }
                }
                if (CallChecker.beforeDeref(buffer, char[].class, 2195, 67577, 67582)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 2195, 67601, 67604)) {
                        buffer = CallChecker.beforeCalled(buffer, char[].class, 2195, 67577, 67582);
                        mant = CallChecker.beforeCalled(mant, int[].class, 2195, 67601, 67604);
                        CallChecker.isCalled(buffer, char[].class, 2195, 67577, 67582)[(p++)] = ((char) (((CallChecker.isCalled(mant, int[].class, 2195, 67601, 67604)[i]) % 10) + '0'));
                        CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2195, 67577, 67582)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2195, 67577, 67582)[(p - 1)]", 2195, 67577, 67622);
                    }
                }
                if ((--e) == 0) {
                    if (CallChecker.beforeDeref(buffer, char[].class, 2197, 67668, 67673)) {
                        buffer = CallChecker.beforeCalled(buffer, char[].class, 2197, 67668, 67673);
                        CallChecker.isCalled(buffer, char[].class, 2197, 67668, 67673)[(p++)] = '.';
                        CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2197, 67668, 67673)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2197, 67668, 67673)[(p - 1)]", 2197, 67668, 67685);
                    }
                    pointInserted = true;
                    CallChecker.varAssign(pointInserted, "pointInserted", 2198, 67703, 67723);
                }
            }
            while (e > 0) {
                if (CallChecker.beforeDeref(buffer, char[].class, 2203, 67786, 67791)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2203, 67786, 67791);
                    CallChecker.isCalled(buffer, char[].class, 2203, 67786, 67791)[(p++)] = '0';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2203, 67786, 67791)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2203, 67786, 67791)[(p - 1)]", 2203, 67786, 67803);
                }
                if (CallChecker.beforeDeref(buffer, char[].class, 2204, 67817, 67822)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2204, 67817, 67822);
                    CallChecker.isCalled(buffer, char[].class, 2204, 67817, 67822)[(p++)] = '0';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2204, 67817, 67822)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2204, 67817, 67822)[(p - 1)]", 2204, 67817, 67834);
                }
                if (CallChecker.beforeDeref(buffer, char[].class, 2205, 67848, 67853)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2205, 67848, 67853);
                    CallChecker.isCalled(buffer, char[].class, 2205, 67848, 67853)[(p++)] = '0';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2205, 67848, 67853)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2205, 67848, 67853)[(p - 1)]", 2205, 67848, 67865);
                }
                if (CallChecker.beforeDeref(buffer, char[].class, 2206, 67879, 67884)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2206, 67879, 67884);
                    CallChecker.isCalled(buffer, char[].class, 2206, 67879, 67884)[(p++)] = '0';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2206, 67879, 67884)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2206, 67879, 67884)[(p - 1)]", 2206, 67879, 67896);
                }
                e--;
            } 
            if (!pointInserted) {
                if (CallChecker.beforeDeref(buffer, char[].class, 2212, 68013, 68018)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2212, 68013, 68018);
                    CallChecker.isCalled(buffer, char[].class, 2212, 68013, 68018)[(p++)] = '.';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2212, 68013, 68018)[(p - 1)], "CallChecker.isCalled(buffer, char[].class, 2212, 68013, 68018)[(p - 1)]", 2212, 68013, 68030);
                }
            }
            q = 1;
            CallChecker.varAssign(q, "q", 2216, 68085, 68090);
            buffer = CallChecker.beforeCalled(buffer, char[].class, 2217, 68107, 68112);
            while ((CallChecker.isCalled(buffer, char[].class, 2217, 68107, 68112)[q]) == '0') {
                q++;
            } 
            if (CallChecker.beforeDeref(buffer, char[].class, 2220, 68166, 68171)) {
                buffer = CallChecker.beforeCalled(buffer, char[].class, 2220, 68166, 68171);
                if ((CallChecker.isCalled(buffer, char[].class, 2220, 68166, 68171)[q]) == '.') {
                    q--;
                }
            }
            buffer = CallChecker.beforeCalled(buffer, char[].class, 2225, 68264, 68269);
            while ((CallChecker.isCalled(buffer, char[].class, 2225, 68264, 68269)[(p - 1)]) == '0') {
                p--;
            } 
            if ((sign) < 0) {
                if (CallChecker.beforeDeref(buffer, char[].class, 2231, 68373, 68378)) {
                    buffer = CallChecker.beforeCalled(buffer, char[].class, 2231, 68373, 68378);
                    CallChecker.isCalled(buffer, char[].class, 2231, 68373, 68378)[(--q)] = '-';
                    CallChecker.varAssign(CallChecker.isCalled(buffer, char[].class, 2231, 68373, 68378)[q], "CallChecker.isCalled(buffer, char[].class, 2231, 68373, 68378)[q]", 2231, 68373, 68390);
                }
            }
            return new String(buffer, q, (p - q));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4064.methodEnd();
        }
    }

    public Dfp dotrap(int type, String what, Dfp oper, Dfp result) {
        MethodContext _bcornu_methode_context4065 = new MethodContext(Dfp.class, 2245, 68460, 70720);
        try {
            CallChecker.varInit(this, "this", 2245, 68460, 70720);
            CallChecker.varInit(result, "result", 2245, 68460, 70720);
            CallChecker.varInit(oper, "oper", 2245, 68460, 70720);
            CallChecker.varInit(what, "what", 2245, 68460, 70720);
            CallChecker.varInit(type, "type", 2245, 68460, 70720);
            CallChecker.varInit(this.field, "field", 2245, 68460, 70720);
            CallChecker.varInit(this.nans, "nans", 2245, 68460, 70720);
            CallChecker.varInit(this.exp, "exp", 2245, 68460, 70720);
            CallChecker.varInit(this.sign, "sign", 2245, 68460, 70720);
            CallChecker.varInit(this.mant, "mant", 2245, 68460, 70720);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2245, 68460, 70720);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2245, 68460, 70720);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2245, 68460, 70720);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2245, 68460, 70720);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2245, 68460, 70720);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2245, 68460, 70720);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2245, 68460, 70720);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2245, 68460, 70720);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2245, 68460, 70720);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2245, 68460, 70720);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2245, 68460, 70720);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2245, 68460, 70720);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2245, 68460, 70720);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2245, 68460, 70720);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2245, 68460, 70720);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2245, 68460, 70720);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2245, 68460, 70720);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2245, 68460, 70720);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2245, 68460, 70720);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2245, 68460, 70720);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2245, 68460, 70720);
            Dfp def = CallChecker.varInit(result, "def", 2246, 68880, 68896);
            switch (type) {
                case DfpField.FLAG_INVALID :
                    def = newInstance(getZero());
                    CallChecker.varAssign(def, "def", 2250, 68979, 69007);
                    if (CallChecker.beforeDeref(def, Dfp.class, 2251, 69025, 69027)) {
                        if (CallChecker.beforeDeref(result, Dfp.class, 2251, 69036, 69041)) {
                            def = CallChecker.beforeCalled(def, Dfp.class, 2251, 69025, 69027);
                            result = CallChecker.beforeCalled(result, Dfp.class, 2251, 69036, 69041);
                            CallChecker.isCalled(def, Dfp.class, 2251, 69025, 69027).sign = CallChecker.isCalled(result, Dfp.class, 2251, 69036, 69041).sign;
                            CallChecker.varAssign(CallChecker.isCalled(def, Dfp.class, 2251, 69025, 69027).sign, "CallChecker.isCalled(def, Dfp.class, 2251, 69025, 69027).sign", 2251, 69025, 69047);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(def, Dfp.class, 2252, 69065, 69067)) {
                        def = CallChecker.beforeCalled(def, Dfp.class, 2252, 69065, 69067);
                        CallChecker.isCalled(def, Dfp.class, 2252, 69065, 69067).nans = Dfp.QNAN;
                        CallChecker.varAssign(CallChecker.isCalled(def, Dfp.class, 2252, 69065, 69067).nans, "CallChecker.isCalled(def, Dfp.class, 2252, 69065, 69067).nans", 2252, 69065, 69080);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                case DfpField.FLAG_DIV_ZERO :
                    if (CallChecker.beforeDeref(mant, int[].class, 2256, 69190, 69193)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 2256, 69185, 69188)) {
                            mant = CallChecker.beforeCalled(mant, int[].class, 2256, 69190, 69193);
                            mant = CallChecker.beforeCalled(mant, int[].class, 2256, 69185, 69188);
                            if (((nans) == (Dfp.FINITE)) && ((CallChecker.isCalled(mant, int[].class, 2256, 69185, 69188)[((CallChecker.isCalled(mant, int[].class, 2256, 69190, 69193).length) - 1)]) != 0)) {
                                def = newInstance(getZero());
                                CallChecker.varAssign(def, "def", 2258, 69293, 69321);
                                if (CallChecker.beforeDeref(def, Dfp.class, 2259, 69343, 69345)) {
                                    if (CallChecker.beforeDeref(oper, Dfp.class, 2259, 69366, 69369)) {
                                        def = CallChecker.beforeCalled(def, Dfp.class, 2259, 69343, 69345);
                                        oper = CallChecker.beforeCalled(oper, Dfp.class, 2259, 69366, 69369);
                                        CallChecker.isCalled(def, Dfp.class, 2259, 69343, 69345).sign = ((byte) ((sign) * (CallChecker.isCalled(oper, Dfp.class, 2259, 69366, 69369).sign)));
                                        CallChecker.varAssign(CallChecker.isCalled(def, Dfp.class, 2259, 69343, 69345).sign, "CallChecker.isCalled(def, Dfp.class, 2259, 69343, 69345).sign", 2259, 69343, 69376);
                                    }
                                }
                                if (CallChecker.beforeDeref(def, Dfp.class, 2260, 69398, 69400)) {
                                    def = CallChecker.beforeCalled(def, Dfp.class, 2260, 69398, 69400);
                                    CallChecker.isCalled(def, Dfp.class, 2260, 69398, 69400).nans = Dfp.INFINITE;
                                    CallChecker.varAssign(CallChecker.isCalled(def, Dfp.class, 2260, 69398, 69400).nans, "CallChecker.isCalled(def, Dfp.class, 2260, 69398, 69400).nans", 2260, 69398, 69417);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(mant, int[].class, 2263, 69481, 69484)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 2263, 69476, 69479)) {
                            mant = CallChecker.beforeCalled(mant, int[].class, 2263, 69481, 69484);
                            mant = CallChecker.beforeCalled(mant, int[].class, 2263, 69476, 69479);
                            if (((nans) == (Dfp.FINITE)) && ((CallChecker.isCalled(mant, int[].class, 2263, 69476, 69479)[((CallChecker.isCalled(mant, int[].class, 2263, 69481, 69484).length) - 1)]) == 0)) {
                                def = newInstance(getZero());
                                CallChecker.varAssign(def, "def", 2265, 69552, 69580);
                                if (CallChecker.beforeDeref(def, Dfp.class, 2266, 69602, 69604)) {
                                    def = CallChecker.beforeCalled(def, Dfp.class, 2266, 69602, 69604);
                                    CallChecker.isCalled(def, Dfp.class, 2266, 69602, 69604).nans = Dfp.QNAN;
                                    CallChecker.varAssign(CallChecker.isCalled(def, Dfp.class, 2266, 69602, 69604).nans, "CallChecker.isCalled(def, Dfp.class, 2266, 69602, 69604).nans", 2266, 69602, 69617);
                                }
                            }
                        }
                    }
                    if (((nans) == (Dfp.INFINITE)) || ((nans) == (Dfp.QNAN))) {
                        def = newInstance(getZero());
                        CallChecker.varAssign(def, "def", 2270, 69714, 69742);
                        if (CallChecker.beforeDeref(def, Dfp.class, 2271, 69764, 69766)) {
                            def = CallChecker.beforeCalled(def, Dfp.class, 2271, 69764, 69766);
                            CallChecker.isCalled(def, Dfp.class, 2271, 69764, 69766).nans = Dfp.QNAN;
                            CallChecker.varAssign(CallChecker.isCalled(def, Dfp.class, 2271, 69764, 69766).nans, "CallChecker.isCalled(def, Dfp.class, 2271, 69764, 69766).nans", 2271, 69764, 69779);
                        }
                    }
                    if (((nans) == (Dfp.INFINITE)) || ((nans) == (Dfp.SNAN))) {
                        def = newInstance(getZero());
                        CallChecker.varAssign(def, "def", 2275, 69876, 69904);
                        if (CallChecker.beforeDeref(def, Dfp.class, 2276, 69926, 69928)) {
                            def = CallChecker.beforeCalled(def, Dfp.class, 2276, 69926, 69928);
                            CallChecker.isCalled(def, Dfp.class, 2276, 69926, 69928).nans = Dfp.QNAN;
                            CallChecker.varAssign(CallChecker.isCalled(def, Dfp.class, 2276, 69926, 69928).nans, "CallChecker.isCalled(def, Dfp.class, 2276, 69926, 69928).nans", 2276, 69926, 69941);
                        }
                    }
                    break;
                case DfpField.FLAG_UNDERFLOW :
                    if (CallChecker.beforeDeref(result, Dfp.class, 2281, 70049, 70054)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 2281, 70060, 70063)) {
                            result = CallChecker.beforeCalled(result, Dfp.class, 2281, 70049, 70054);
                            mant = CallChecker.beforeCalled(mant, int[].class, 2281, 70060, 70063);
                            if (((CallChecker.isCalled(result, Dfp.class, 2281, 70049, 70054).exp) + (CallChecker.isCalled(mant, int[].class, 2281, 70060, 70063).length)) < (Dfp.MIN_EXP)) {
                                def = newInstance(getZero());
                                CallChecker.varAssign(def, "def", 2282, 70106, 70134);
                                if (CallChecker.beforeDeref(def, Dfp.class, 2283, 70156, 70158)) {
                                    if (CallChecker.beforeDeref(result, Dfp.class, 2283, 70167, 70172)) {
                                        def = CallChecker.beforeCalled(def, Dfp.class, 2283, 70156, 70158);
                                        result = CallChecker.beforeCalled(result, Dfp.class, 2283, 70167, 70172);
                                        CallChecker.isCalled(def, Dfp.class, 2283, 70156, 70158).sign = CallChecker.isCalled(result, Dfp.class, 2283, 70167, 70172).sign;
                                        CallChecker.varAssign(CallChecker.isCalled(def, Dfp.class, 2283, 70156, 70158).sign, "CallChecker.isCalled(def, Dfp.class, 2283, 70156, 70158).sign", 2283, 70156, 70178);
                                    }
                                }
                            }else {
                                def = newInstance(result);
                                CallChecker.varAssign(def, "def", 2285, 70225, 70250);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(result, Dfp.class, 2287, 70308, 70313)) {
                        if (CallChecker.beforeDeref(result, Dfp.class, 2287, 70321, 70326)) {
                            result = CallChecker.beforeCalled(result, Dfp.class, 2287, 70308, 70313);
                            result = CallChecker.beforeCalled(result, Dfp.class, 2287, 70321, 70326);
                            CallChecker.isCalled(result, Dfp.class, 2287, 70308, 70313).exp = (CallChecker.isCalled(result, Dfp.class, 2287, 70321, 70326).exp) + (Dfp.ERR_SCALE);
                            CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 2287, 70308, 70313).exp, "CallChecker.isCalled(result, Dfp.class, 2287, 70308, 70313).exp", 2287, 70308, 70343);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                case DfpField.FLAG_OVERFLOW :
                    if (CallChecker.beforeDeref(result, Dfp.class, 2291, 70426, 70431)) {
                        if (CallChecker.beforeDeref(result, Dfp.class, 2291, 70439, 70444)) {
                            result = CallChecker.beforeCalled(result, Dfp.class, 2291, 70426, 70431);
                            result = CallChecker.beforeCalled(result, Dfp.class, 2291, 70439, 70444);
                            CallChecker.isCalled(result, Dfp.class, 2291, 70426, 70431).exp = (CallChecker.isCalled(result, Dfp.class, 2291, 70439, 70444).exp) - (Dfp.ERR_SCALE);
                            CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 2291, 70426, 70431).exp, "CallChecker.isCalled(result, Dfp.class, 2291, 70426, 70431).exp", 2291, 70426, 70461);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    def = newInstance(getZero());
                    CallChecker.varAssign(def, "def", 2292, 70479, 70507);
                    if (CallChecker.beforeDeref(def, Dfp.class, 2293, 70525, 70527)) {
                        if (CallChecker.beforeDeref(result, Dfp.class, 2293, 70536, 70541)) {
                            def = CallChecker.beforeCalled(def, Dfp.class, 2293, 70525, 70527);
                            result = CallChecker.beforeCalled(result, Dfp.class, 2293, 70536, 70541);
                            CallChecker.isCalled(def, Dfp.class, 2293, 70525, 70527).sign = CallChecker.isCalled(result, Dfp.class, 2293, 70536, 70541).sign;
                            CallChecker.varAssign(CallChecker.isCalled(def, Dfp.class, 2293, 70525, 70527).sign, "CallChecker.isCalled(def, Dfp.class, 2293, 70525, 70527).sign", 2293, 70525, 70547);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(def, Dfp.class, 2294, 70565, 70567)) {
                        def = CallChecker.beforeCalled(def, Dfp.class, 2294, 70565, 70567);
                        CallChecker.isCalled(def, Dfp.class, 2294, 70565, 70567).nans = Dfp.INFINITE;
                        CallChecker.varAssign(CallChecker.isCalled(def, Dfp.class, 2294, 70565, 70567).nans, "CallChecker.isCalled(def, Dfp.class, 2294, 70565, 70567).nans", 2294, 70565, 70584);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                default :
                    def = result;
                    CallChecker.varAssign(def, "def", 2297, 70631, 70643);
                    break;
            }
            return trap(type, what, oper, def, result);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4065.methodEnd();
        }
    }

    protected Dfp trap(int type, String what, Dfp oper, Dfp def, Dfp result) {
        MethodContext _bcornu_methode_context4066 = new MethodContext(Dfp.class, 2315, 70727, 71404);
        try {
            CallChecker.varInit(this, "this", 2315, 70727, 71404);
            CallChecker.varInit(result, "result", 2315, 70727, 71404);
            CallChecker.varInit(def, "def", 2315, 70727, 71404);
            CallChecker.varInit(oper, "oper", 2315, 70727, 71404);
            CallChecker.varInit(what, "what", 2315, 70727, 71404);
            CallChecker.varInit(type, "type", 2315, 70727, 71404);
            CallChecker.varInit(this.field, "field", 2315, 70727, 71404);
            CallChecker.varInit(this.nans, "nans", 2315, 70727, 71404);
            CallChecker.varInit(this.exp, "exp", 2315, 70727, 71404);
            CallChecker.varInit(this.sign, "sign", 2315, 70727, 71404);
            CallChecker.varInit(this.mant, "mant", 2315, 70727, 71404);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2315, 70727, 71404);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2315, 70727, 71404);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2315, 70727, 71404);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2315, 70727, 71404);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2315, 70727, 71404);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2315, 70727, 71404);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2315, 70727, 71404);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2315, 70727, 71404);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2315, 70727, 71404);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2315, 70727, 71404);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2315, 70727, 71404);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2315, 70727, 71404);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2315, 70727, 71404);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2315, 70727, 71404);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2315, 70727, 71404);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2315, 70727, 71404);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2315, 70727, 71404);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2315, 70727, 71404);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2315, 70727, 71404);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2315, 70727, 71404);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2315, 70727, 71404);
            return def;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4066.methodEnd();
        }
    }

    public int classify() {
        MethodContext _bcornu_methode_context4067 = new MethodContext(int.class, 2322, 71411, 71566);
        try {
            CallChecker.varInit(this, "this", 2322, 71411, 71566);
            CallChecker.varInit(this.field, "field", 2322, 71411, 71566);
            CallChecker.varInit(this.nans, "nans", 2322, 71411, 71566);
            CallChecker.varInit(this.exp, "exp", 2322, 71411, 71566);
            CallChecker.varInit(this.sign, "sign", 2322, 71411, 71566);
            CallChecker.varInit(this.mant, "mant", 2322, 71411, 71566);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2322, 71411, 71566);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2322, 71411, 71566);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2322, 71411, 71566);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2322, 71411, 71566);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2322, 71411, 71566);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2322, 71411, 71566);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2322, 71411, 71566);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2322, 71411, 71566);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2322, 71411, 71566);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2322, 71411, 71566);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2322, 71411, 71566);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2322, 71411, 71566);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2322, 71411, 71566);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2322, 71411, 71566);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2322, 71411, 71566);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2322, 71411, 71566);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2322, 71411, 71566);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2322, 71411, 71566);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2322, 71411, 71566);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2322, 71411, 71566);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2322, 71411, 71566);
            return nans;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4067.methodEnd();
        }
    }

    public static Dfp copysign(final Dfp x, final Dfp y) {
        MethodContext _bcornu_methode_context4068 = new MethodContext(Dfp.class, 2332, 71573, 72008);
        try {
            CallChecker.varInit(y, "y", 2332, 71573, 72008);
            CallChecker.varInit(x, "x", 2332, 71573, 72008);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2332, 71573, 72008);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2332, 71573, 72008);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2332, 71573, 72008);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2332, 71573, 72008);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2332, 71573, 72008);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2332, 71573, 72008);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2332, 71573, 72008);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2332, 71573, 72008);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2332, 71573, 72008);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2332, 71573, 72008);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2332, 71573, 72008);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2332, 71573, 72008);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2332, 71573, 72008);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2332, 71573, 72008);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2332, 71573, 72008);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2332, 71573, 72008);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2332, 71573, 72008);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2332, 71573, 72008);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2332, 71573, 72008);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2332, 71573, 72008);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2332, 71573, 72008);
            Dfp result = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(x, Dfp.class, 2333, 71933, 71933)) {
                result = CallChecker.isCalled(x, Dfp.class, 2333, 71933, 71933).newInstance(x);
                CallChecker.varAssign(result, "result", 2333, 71933, 71933);
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 2334, 71959, 71964)) {
                if (CallChecker.beforeDeref(y, Dfp.class, 2334, 71973, 71973)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 2334, 71959, 71964);
                    CallChecker.isCalled(result, Dfp.class, 2334, 71959, 71964).sign = CallChecker.isCalled(y, Dfp.class, 2334, 71973, 71973).sign;
                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 2334, 71959, 71964).sign, "CallChecker.isCalled(result, Dfp.class, 2334, 71959, 71964).sign", 2334, 71959, 71979);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4068.methodEnd();
        }
    }

    public Dfp nextAfter(final Dfp x) {
        MethodContext _bcornu_methode_context4069 = new MethodContext(Dfp.class, 2343, 72015, 74190);
        try {
            CallChecker.varInit(this, "this", 2343, 72015, 74190);
            CallChecker.varInit(x, "x", 2343, 72015, 74190);
            CallChecker.varInit(this.field, "field", 2343, 72015, 74190);
            CallChecker.varInit(this.nans, "nans", 2343, 72015, 74190);
            CallChecker.varInit(this.exp, "exp", 2343, 72015, 74190);
            CallChecker.varInit(this.sign, "sign", 2343, 72015, 74190);
            CallChecker.varInit(this.mant, "mant", 2343, 72015, 74190);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2343, 72015, 74190);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2343, 72015, 74190);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2343, 72015, 74190);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2343, 72015, 74190);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2343, 72015, 74190);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2343, 72015, 74190);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2343, 72015, 74190);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2343, 72015, 74190);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2343, 72015, 74190);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2343, 72015, 74190);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2343, 72015, 74190);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2343, 72015, 74190);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2343, 72015, 74190);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2343, 72015, 74190);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2343, 72015, 74190);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2343, 72015, 74190);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2343, 72015, 74190);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2343, 72015, 74190);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2343, 72015, 74190);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2343, 72015, 74190);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2343, 72015, 74190);
            if (CallChecker.beforeDeref(field, DfpField.class, 2346, 72371, 72375)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 2346, 72397, 72397)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(x, Dfp.class, 2346, 72397, 72397).field, DfpField.class, 2346, 72397, 72403)) {
                        if ((CallChecker.isCalled(field, DfpField.class, 2346, 72371, 72375).getRadixDigits()) != (CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2346, 72397, 72397).field, DfpField.class, 2346, 72397, 72403).getRadixDigits())) {
                            if (CallChecker.beforeDeref(field, DfpField.class, 2347, 72437, 72441)) {
                                CallChecker.isCalled(field, DfpField.class, 2347, 72437, 72441).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                            final Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 2348, 72496, 72537);
                            if (CallChecker.beforeDeref(result, Dfp.class, 2349, 72551, 72556)) {
                                CallChecker.isCalled(result, Dfp.class, 2349, 72551, 72556).nans = Dfp.QNAN;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 2349, 72551, 72556).nans, "CallChecker.isCalled(result, Dfp.class, 2349, 72551, 72556).nans", 2349, 72551, 72569);
                            }
                            return dotrap(DfpField.FLAG_INVALID, Dfp.NEXT_AFTER_TRAP, x, result);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            boolean up = CallChecker.varInit(((boolean) (false)), "up", 2354, 72705, 72723);
            if (this.lessThan(x)) {
                up = true;
                CallChecker.varAssign(up, "up", 2356, 72769, 72778);
            }
            if ((Dfp.compare(this, x)) == 0) {
                return newInstance(x);
            }
            if (lessThan(getZero())) {
                up = !up;
                CallChecker.varAssign(up, "up", 2364, 72921, 72929);
            }
            Dfp inc = CallChecker.init(Dfp.class);
            Dfp result = CallChecker.init(Dfp.class);
            if (up) {
                inc = newInstance(getOne());
                CallChecker.varAssign(inc, "inc", 2370, 73015, 73042);
                if (CallChecker.beforeDeref(inc, Dfp.class, 2371, 73056, 73058)) {
                    if (CallChecker.beforeDeref(mant, int[].class, 2371, 73075, 73078)) {
                        inc = CallChecker.beforeCalled(inc, Dfp.class, 2371, 73056, 73058);
                        mant = CallChecker.beforeCalled(mant, int[].class, 2371, 73075, 73078);
                        CallChecker.isCalled(inc, Dfp.class, 2371, 73056, 73058).exp = ((this.exp) - (CallChecker.isCalled(mant, int[].class, 2371, 73075, 73078).length)) + 1;
                        CallChecker.varAssign(CallChecker.isCalled(inc, Dfp.class, 2371, 73056, 73058).exp, "CallChecker.isCalled(inc, Dfp.class, 2371, 73056, 73058).exp", 2371, 73056, 73088);
                    }
                }
                if (CallChecker.beforeDeref(inc, Dfp.class, 2372, 73102, 73104)) {
                    inc = CallChecker.beforeCalled(inc, Dfp.class, 2372, 73102, 73104);
                    CallChecker.isCalled(inc, Dfp.class, 2372, 73102, 73104).sign = this.sign;
                    CallChecker.varAssign(CallChecker.isCalled(inc, Dfp.class, 2372, 73102, 73104).sign, "CallChecker.isCalled(inc, Dfp.class, 2372, 73102, 73104).sign", 2372, 73102, 73122);
                }
                if (this.equals(getZero())) {
                    if (CallChecker.beforeDeref(inc, Dfp.class, 2375, 73183, 73185)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 2375, 73201, 73204)) {
                            inc = CallChecker.beforeCalled(inc, Dfp.class, 2375, 73183, 73185);
                            mant = CallChecker.beforeCalled(mant, int[].class, 2375, 73201, 73204);
                            CallChecker.isCalled(inc, Dfp.class, 2375, 73183, 73185).exp = (Dfp.MIN_EXP) - (CallChecker.isCalled(mant, int[].class, 2375, 73201, 73204).length);
                            CallChecker.varAssign(CallChecker.isCalled(inc, Dfp.class, 2375, 73183, 73185).exp, "CallChecker.isCalled(inc, Dfp.class, 2375, 73183, 73185).exp", 2375, 73183, 73212);
                        }
                    }
                }
                result = add(inc);
                CallChecker.varAssign(result, "result", 2378, 73241, 73258);
            }else {
                inc = newInstance(getOne());
                CallChecker.varAssign(inc, "inc", 2380, 73289, 73316);
                if (CallChecker.beforeDeref(inc, Dfp.class, 2381, 73330, 73332)) {
                    inc = CallChecker.beforeCalled(inc, Dfp.class, 2381, 73330, 73332);
                    CallChecker.isCalled(inc, Dfp.class, 2381, 73330, 73332).exp = this.exp;
                    CallChecker.varAssign(CallChecker.isCalled(inc, Dfp.class, 2381, 73330, 73332).exp, "CallChecker.isCalled(inc, Dfp.class, 2381, 73330, 73332).exp", 2381, 73330, 73348);
                }
                if (CallChecker.beforeDeref(inc, Dfp.class, 2382, 73362, 73364)) {
                    inc = CallChecker.beforeCalled(inc, Dfp.class, 2382, 73362, 73364);
                    CallChecker.isCalled(inc, Dfp.class, 2382, 73362, 73364).sign = this.sign;
                    CallChecker.varAssign(CallChecker.isCalled(inc, Dfp.class, 2382, 73362, 73364).sign, "CallChecker.isCalled(inc, Dfp.class, 2382, 73362, 73364).sign", 2382, 73362, 73382);
                }
                if (this.equals(inc)) {
                    if (CallChecker.beforeDeref(inc, Dfp.class, 2385, 73437, 73439)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 2385, 73456, 73459)) {
                            inc = CallChecker.beforeCalled(inc, Dfp.class, 2385, 73437, 73439);
                            mant = CallChecker.beforeCalled(mant, int[].class, 2385, 73456, 73459);
                            CallChecker.isCalled(inc, Dfp.class, 2385, 73437, 73439).exp = (this.exp) - (CallChecker.isCalled(mant, int[].class, 2385, 73456, 73459).length);
                            CallChecker.varAssign(CallChecker.isCalled(inc, Dfp.class, 2385, 73437, 73439).exp, "CallChecker.isCalled(inc, Dfp.class, 2385, 73437, 73439).exp", 2385, 73437, 73467);
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(inc, Dfp.class, 2387, 73506, 73508)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 2387, 73525, 73528)) {
                            inc = CallChecker.beforeCalled(inc, Dfp.class, 2387, 73506, 73508);
                            mant = CallChecker.beforeCalled(mant, int[].class, 2387, 73525, 73528);
                            CallChecker.isCalled(inc, Dfp.class, 2387, 73506, 73508).exp = ((this.exp) - (CallChecker.isCalled(mant, int[].class, 2387, 73525, 73528).length)) + 1;
                            CallChecker.varAssign(CallChecker.isCalled(inc, Dfp.class, 2387, 73506, 73508).exp, "CallChecker.isCalled(inc, Dfp.class, 2387, 73506, 73508).exp", 2387, 73506, 73538);
                        }
                    }
                }
                if (this.equals(getZero())) {
                    if (CallChecker.beforeDeref(inc, Dfp.class, 2391, 73613, 73615)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 2391, 73631, 73634)) {
                            inc = CallChecker.beforeCalled(inc, Dfp.class, 2391, 73613, 73615);
                            mant = CallChecker.beforeCalled(mant, int[].class, 2391, 73631, 73634);
                            CallChecker.isCalled(inc, Dfp.class, 2391, 73613, 73615).exp = (Dfp.MIN_EXP) - (CallChecker.isCalled(mant, int[].class, 2391, 73631, 73634).length);
                            CallChecker.varAssign(CallChecker.isCalled(inc, Dfp.class, 2391, 73613, 73615).exp, "CallChecker.isCalled(inc, Dfp.class, 2391, 73613, 73615).exp", 2391, 73613, 73642);
                        }
                    }
                }
                result = this.subtract(inc);
                CallChecker.varAssign(result, "result", 2394, 73671, 73698);
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 2397, 73723, 73728)) {
                result = CallChecker.beforeCalled(result, Dfp.class, 2397, 73723, 73728);
                if (((CallChecker.isCalled(result, Dfp.class, 2397, 73723, 73728).classify()) == (Dfp.INFINITE)) && ((this.classify()) != (Dfp.INFINITE))) {
                    if (CallChecker.beforeDeref(field, DfpField.class, 2398, 73799, 73803)) {
                        CallChecker.isCalled(field, DfpField.class, 2398, 73799, 73803).setIEEEFlagsBits(DfpField.FLAG_INEXACT);
                    }
                    result = dotrap(DfpField.FLAG_INEXACT, Dfp.NEXT_AFTER_TRAP, x, result);
                    CallChecker.varAssign(result, "result", 2399, 73858, 73924);
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 2402, 73949, 73954)) {
                result = CallChecker.beforeCalled(result, Dfp.class, 2402, 73949, 73954);
                if ((CallChecker.isCalled(result, Dfp.class, 2402, 73949, 73954).equals(getZero())) && ((this.equals(getZero())) == false)) {
                    if (CallChecker.beforeDeref(field, DfpField.class, 2403, 74024, 74028)) {
                        CallChecker.isCalled(field, DfpField.class, 2403, 74024, 74028).setIEEEFlagsBits(DfpField.FLAG_INEXACT);
                    }
                    result = dotrap(DfpField.FLAG_INEXACT, Dfp.NEXT_AFTER_TRAP, x, result);
                    CallChecker.varAssign(result, "result", 2404, 74083, 74149);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4069.methodEnd();
        }
    }

    public double toDouble() {
        MethodContext _bcornu_methode_context4070 = new MethodContext(double.class, 2415, 74197, 76532);
        try {
            CallChecker.varInit(this, "this", 2415, 74197, 76532);
            CallChecker.varInit(this.field, "field", 2415, 74197, 76532);
            CallChecker.varInit(this.nans, "nans", 2415, 74197, 76532);
            CallChecker.varInit(this.exp, "exp", 2415, 74197, 76532);
            CallChecker.varInit(this.sign, "sign", 2415, 74197, 76532);
            CallChecker.varInit(this.mant, "mant", 2415, 74197, 76532);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2415, 74197, 76532);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2415, 74197, 76532);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2415, 74197, 76532);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2415, 74197, 76532);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2415, 74197, 76532);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2415, 74197, 76532);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2415, 74197, 76532);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2415, 74197, 76532);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2415, 74197, 76532);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2415, 74197, 76532);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2415, 74197, 76532);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2415, 74197, 76532);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2415, 74197, 76532);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2415, 74197, 76532);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2415, 74197, 76532);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2415, 74197, 76532);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2415, 74197, 76532);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2415, 74197, 76532);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2415, 74197, 76532);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2415, 74197, 76532);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2415, 74197, 76532);
            if (isInfinite()) {
                if (lessThan(getZero())) {
                    return Double.NEGATIVE_INFINITY;
                }else {
                    return Double.POSITIVE_INFINITY;
                }
            }
            if (isNaN()) {
                return Double.NaN;
            }
            Dfp y = CallChecker.varInit(this, "y", 2429, 74641, 74653);
            boolean negate = CallChecker.varInit(((boolean) (false)), "negate", 2430, 74663, 74685);
            int cmp0 = CallChecker.varInit(((int) (Dfp.compare(this, getZero()))), "cmp0", 2431, 74695, 74730);
            if (cmp0 == 0) {
                if ((sign) < 0) {
                    return -0.0;
                }else {
                    return +0.0;
                }
            }else
                if (cmp0 < 0) {
                    y = negate();
                    CallChecker.varAssign(y, "y", 2435, 74843, 74855);
                    negate = true;
                    CallChecker.varAssign(negate, "negate", 2436, 74869, 74882);
                }
            
            int exponent = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(y, Dfp.class, 2441, 75062, 75062)) {
                y = CallChecker.beforeCalled(y, Dfp.class, 2441, 75062, 75062);
                exponent = ((int) ((CallChecker.isCalled(y, Dfp.class, 2441, 75062, 75062).intLog10()) * 3.32));
                CallChecker.varAssign(exponent, "exponent", 2441, 75062, 75062);
            }
            if (exponent < 0) {
                exponent--;
            }
            Dfp tempDfp = CallChecker.varInit(DfpMath.pow(getTwo(), exponent), "tempDfp", 2446, 75155, 75200);
            tempDfp = CallChecker.beforeCalled(tempDfp, Dfp.class, 2447, 75217, 75223);
            tempDfp = CallChecker.beforeCalled(tempDfp, Dfp.class, 2447, 75240, 75246);
            while ((CallChecker.isCalled(tempDfp, Dfp.class, 2447, 75217, 75223).lessThan(y)) || (CallChecker.isCalled(tempDfp, Dfp.class, 2447, 75240, 75246).equals(y))) {
                if (CallChecker.beforeDeref(tempDfp, Dfp.class, 2448, 75283, 75289)) {
                    tempDfp = CallChecker.beforeCalled(tempDfp, Dfp.class, 2448, 75283, 75289);
                    tempDfp = CallChecker.isCalled(tempDfp, Dfp.class, 2448, 75283, 75289).multiply(2);
                    CallChecker.varAssign(tempDfp, "tempDfp", 2448, 75273, 75302);
                }
                exponent++;
            } 
            exponent--;
            if (CallChecker.beforeDeref(y, Dfp.class, 2455, 75433, 75433)) {
                y = CallChecker.beforeCalled(y, Dfp.class, 2455, 75433, 75433);
                y = CallChecker.isCalled(y, Dfp.class, 2455, 75433, 75433).divide(DfpMath.pow(getTwo(), exponent));
                CallChecker.varAssign(y, "y", 2455, 75429, 75474);
            }
            if (exponent > (-1023)) {
                if (CallChecker.beforeDeref(y, Dfp.class, 2457, 75524, 75524)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 2457, 75524, 75524);
                    y = CallChecker.isCalled(y, Dfp.class, 2457, 75524, 75524).subtract(getOne());
                    CallChecker.varAssign(y, "y", 2457, 75520, 75544);
                }
            }
            if (exponent < (-1074)) {
                return 0;
            }
            if (exponent > 1023) {
                if (negate) {
                    return Double.NEGATIVE_INFINITY;
                }else {
                    return Double.POSITIVE_INFINITY;
                }
            }
            if (CallChecker.beforeDeref(y, Dfp.class, 2469, 75758, 75758)) {
                y = CallChecker.beforeCalled(y, Dfp.class, 2469, 75758, 75758);
                final Dfp npe_invocation_var847 = CallChecker.isCalled(y, Dfp.class, 2469, 75758, 75758).multiply(newInstance(4503599627370496L));
                if (CallChecker.beforeDeref(npe_invocation_var847, Dfp.class, 2469, 75758, 75799)) {
                    y = CallChecker.isCalled(npe_invocation_var847, Dfp.class, 2469, 75758, 75799).rint();
                    CallChecker.varAssign(y, "y", 2469, 75754, 75807);
                }
            }
            String str = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(y, Dfp.class, 2470, 75830, 75830)) {
                y = CallChecker.beforeCalled(y, Dfp.class, 2470, 75830, 75830);
                str = CallChecker.isCalled(y, Dfp.class, 2470, 75830, 75830).toString();
                CallChecker.varAssign(str, "str", 2470, 75830, 75830);
            }
            if (CallChecker.beforeDeref(str, String.class, 2471, 75875, 75877)) {
                if (CallChecker.beforeDeref(str, String.class, 2471, 75858, 75860)) {
                    str = CallChecker.beforeCalled(str, String.class, 2471, 75875, 75877);
                    str = CallChecker.beforeCalled(str, String.class, 2471, 75858, 75860);
                    str = CallChecker.isCalled(str, String.class, 2471, 75858, 75860).substring(0, ((CallChecker.isCalled(str, String.class, 2471, 75875, 75877).length()) - 1));
                    CallChecker.varAssign(str, "str", 2471, 75852, 75890);
                }
            }
            long mantissa = CallChecker.varInit(((long) (Long.parseLong(str))), "mantissa", 2472, 75900, 75935);
            if (mantissa == 4503599627370496L) {
                mantissa = 0;
                CallChecker.varAssign(mantissa, "mantissa", 2476, 76069, 76081);
                exponent++;
            }
            if (exponent <= (-1023)) {
                exponent--;
            }
            while (exponent < (-1023)) {
                exponent++;
                mantissa >>>= 1;
                CallChecker.varAssign(mantissa, "mantissa", 2487, 76318, 76333);
            } 
            long bits = CallChecker.varInit(((long) (mantissa | ((exponent + 1023L) << 52))), "bits", 2490, 76354, 76403);
            double x = CallChecker.varInit(((double) (Double.longBitsToDouble(bits))), "x", 2491, 76413, 76453);
            if (negate) {
                x = -x;
                CallChecker.varAssign(x, "x", 2494, 76490, 76496);
            }
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4070.methodEnd();
        }
    }

    public double[] toSplitDouble() {
        MethodContext _bcornu_methode_context4071 = new MethodContext(double[].class, 2505, 76539, 76987);
        try {
            CallChecker.varInit(this, "this", 2505, 76539, 76987);
            CallChecker.varInit(this.field, "field", 2505, 76539, 76987);
            CallChecker.varInit(this.nans, "nans", 2505, 76539, 76987);
            CallChecker.varInit(this.exp, "exp", 2505, 76539, 76987);
            CallChecker.varInit(this.sign, "sign", 2505, 76539, 76987);
            CallChecker.varInit(this.mant, "mant", 2505, 76539, 76987);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2505, 76539, 76987);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2505, 76539, 76987);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2505, 76539, 76987);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2505, 76539, 76987);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2505, 76539, 76987);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2505, 76539, 76987);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2505, 76539, 76987);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2505, 76539, 76987);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2505, 76539, 76987);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2505, 76539, 76987);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2505, 76539, 76987);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2505, 76539, 76987);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2505, 76539, 76987);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2505, 76539, 76987);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2505, 76539, 76987);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2505, 76539, 76987);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2505, 76539, 76987);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2505, 76539, 76987);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2505, 76539, 76987);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2505, 76539, 76987);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2505, 76539, 76987);
            double[] split = CallChecker.varInit(new double[2], "split", 2506, 76735, 76765);
            long mask = CallChecker.varInit(((long) (-1073741824L)), "mask", 2507, 76775, 76806);
            if (CallChecker.beforeDeref(split, double[].class, 2509, 76817, 76821)) {
                split = CallChecker.beforeCalled(split, double[].class, 2509, 76817, 76821);
                CallChecker.isCalled(split, double[].class, 2509, 76817, 76821)[0] = Double.longBitsToDouble(((Double.doubleToLongBits(toDouble())) & mask));
                CallChecker.varAssign(CallChecker.isCalled(split, double[].class, 2509, 76817, 76821)[0], "CallChecker.isCalled(split, double[].class, 2509, 76817, 76821)[0]", 2509, 76817, 76895);
            }
            if (CallChecker.beforeDeref(split, double[].class, 2510, 76905, 76909)) {
                if (CallChecker.beforeDeref(split, double[].class, 2510, 76937, 76941)) {
                    split = CallChecker.beforeCalled(split, double[].class, 2510, 76937, 76941);
                    final Dfp npe_invocation_var848 = subtract(newInstance(CallChecker.isCalled(split, double[].class, 2510, 76937, 76941)[0]));
                    if (CallChecker.beforeDeref(npe_invocation_var848, Dfp.class, 2510, 76916, 76946)) {
                        split = CallChecker.beforeCalled(split, double[].class, 2510, 76905, 76909);
                        CallChecker.isCalled(split, double[].class, 2510, 76905, 76909)[1] = CallChecker.isCalled(npe_invocation_var848, Dfp.class, 2510, 76916, 76946).toDouble();
                        CallChecker.varAssign(CallChecker.isCalled(split, double[].class, 2510, 76905, 76909)[1], "CallChecker.isCalled(split, double[].class, 2510, 76905, 76909)[1]", 2510, 76905, 76958);
                    }
                }
            }
            return split;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4071.methodEnd();
        }
    }

    public double getReal() {
        MethodContext _bcornu_methode_context4072 = new MethodContext(double.class, 2518, 76994, 77099);
        try {
            CallChecker.varInit(this, "this", 2518, 76994, 77099);
            CallChecker.varInit(this.field, "field", 2518, 76994, 77099);
            CallChecker.varInit(this.nans, "nans", 2518, 76994, 77099);
            CallChecker.varInit(this.exp, "exp", 2518, 76994, 77099);
            CallChecker.varInit(this.sign, "sign", 2518, 76994, 77099);
            CallChecker.varInit(this.mant, "mant", 2518, 76994, 77099);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2518, 76994, 77099);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2518, 76994, 77099);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2518, 76994, 77099);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2518, 76994, 77099);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2518, 76994, 77099);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2518, 76994, 77099);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2518, 76994, 77099);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2518, 76994, 77099);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2518, 76994, 77099);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2518, 76994, 77099);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2518, 76994, 77099);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2518, 76994, 77099);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2518, 76994, 77099);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2518, 76994, 77099);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2518, 76994, 77099);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2518, 76994, 77099);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2518, 76994, 77099);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2518, 76994, 77099);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2518, 76994, 77099);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2518, 76994, 77099);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2518, 76994, 77099);
            return toDouble();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4072.methodEnd();
        }
    }

    public Dfp add(final double a) {
        MethodContext _bcornu_methode_context4073 = new MethodContext(Dfp.class, 2525, 77106, 77227);
        try {
            CallChecker.varInit(this, "this", 2525, 77106, 77227);
            CallChecker.varInit(a, "a", 2525, 77106, 77227);
            CallChecker.varInit(this.field, "field", 2525, 77106, 77227);
            CallChecker.varInit(this.nans, "nans", 2525, 77106, 77227);
            CallChecker.varInit(this.exp, "exp", 2525, 77106, 77227);
            CallChecker.varInit(this.sign, "sign", 2525, 77106, 77227);
            CallChecker.varInit(this.mant, "mant", 2525, 77106, 77227);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2525, 77106, 77227);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2525, 77106, 77227);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2525, 77106, 77227);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2525, 77106, 77227);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2525, 77106, 77227);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2525, 77106, 77227);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2525, 77106, 77227);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2525, 77106, 77227);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2525, 77106, 77227);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2525, 77106, 77227);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2525, 77106, 77227);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2525, 77106, 77227);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2525, 77106, 77227);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2525, 77106, 77227);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2525, 77106, 77227);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2525, 77106, 77227);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2525, 77106, 77227);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2525, 77106, 77227);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2525, 77106, 77227);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2525, 77106, 77227);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2525, 77106, 77227);
            return add(newInstance(a));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4073.methodEnd();
        }
    }

    public Dfp subtract(final double a) {
        MethodContext _bcornu_methode_context4074 = new MethodContext(Dfp.class, 2532, 77234, 77365);
        try {
            CallChecker.varInit(this, "this", 2532, 77234, 77365);
            CallChecker.varInit(a, "a", 2532, 77234, 77365);
            CallChecker.varInit(this.field, "field", 2532, 77234, 77365);
            CallChecker.varInit(this.nans, "nans", 2532, 77234, 77365);
            CallChecker.varInit(this.exp, "exp", 2532, 77234, 77365);
            CallChecker.varInit(this.sign, "sign", 2532, 77234, 77365);
            CallChecker.varInit(this.mant, "mant", 2532, 77234, 77365);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2532, 77234, 77365);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2532, 77234, 77365);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2532, 77234, 77365);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2532, 77234, 77365);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2532, 77234, 77365);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2532, 77234, 77365);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2532, 77234, 77365);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2532, 77234, 77365);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2532, 77234, 77365);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2532, 77234, 77365);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2532, 77234, 77365);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2532, 77234, 77365);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2532, 77234, 77365);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2532, 77234, 77365);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2532, 77234, 77365);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2532, 77234, 77365);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2532, 77234, 77365);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2532, 77234, 77365);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2532, 77234, 77365);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2532, 77234, 77365);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2532, 77234, 77365);
            return subtract(newInstance(a));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4074.methodEnd();
        }
    }

    public Dfp multiply(final double a) {
        MethodContext _bcornu_methode_context4075 = new MethodContext(Dfp.class, 2539, 77372, 77503);
        try {
            CallChecker.varInit(this, "this", 2539, 77372, 77503);
            CallChecker.varInit(a, "a", 2539, 77372, 77503);
            CallChecker.varInit(this.field, "field", 2539, 77372, 77503);
            CallChecker.varInit(this.nans, "nans", 2539, 77372, 77503);
            CallChecker.varInit(this.exp, "exp", 2539, 77372, 77503);
            CallChecker.varInit(this.sign, "sign", 2539, 77372, 77503);
            CallChecker.varInit(this.mant, "mant", 2539, 77372, 77503);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2539, 77372, 77503);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2539, 77372, 77503);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2539, 77372, 77503);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2539, 77372, 77503);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2539, 77372, 77503);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2539, 77372, 77503);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2539, 77372, 77503);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2539, 77372, 77503);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2539, 77372, 77503);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2539, 77372, 77503);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2539, 77372, 77503);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2539, 77372, 77503);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2539, 77372, 77503);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2539, 77372, 77503);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2539, 77372, 77503);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2539, 77372, 77503);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2539, 77372, 77503);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2539, 77372, 77503);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2539, 77372, 77503);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2539, 77372, 77503);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2539, 77372, 77503);
            return multiply(newInstance(a));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4075.methodEnd();
        }
    }

    public Dfp divide(final double a) {
        MethodContext _bcornu_methode_context4076 = new MethodContext(Dfp.class, 2546, 77510, 77637);
        try {
            CallChecker.varInit(this, "this", 2546, 77510, 77637);
            CallChecker.varInit(a, "a", 2546, 77510, 77637);
            CallChecker.varInit(this.field, "field", 2546, 77510, 77637);
            CallChecker.varInit(this.nans, "nans", 2546, 77510, 77637);
            CallChecker.varInit(this.exp, "exp", 2546, 77510, 77637);
            CallChecker.varInit(this.sign, "sign", 2546, 77510, 77637);
            CallChecker.varInit(this.mant, "mant", 2546, 77510, 77637);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2546, 77510, 77637);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2546, 77510, 77637);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2546, 77510, 77637);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2546, 77510, 77637);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2546, 77510, 77637);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2546, 77510, 77637);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2546, 77510, 77637);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2546, 77510, 77637);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2546, 77510, 77637);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2546, 77510, 77637);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2546, 77510, 77637);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2546, 77510, 77637);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2546, 77510, 77637);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2546, 77510, 77637);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2546, 77510, 77637);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2546, 77510, 77637);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2546, 77510, 77637);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2546, 77510, 77637);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2546, 77510, 77637);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2546, 77510, 77637);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2546, 77510, 77637);
            return divide(newInstance(a));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4076.methodEnd();
        }
    }

    public Dfp remainder(final double a) {
        MethodContext _bcornu_methode_context4077 = new MethodContext(Dfp.class, 2553, 77644, 77777);
        try {
            CallChecker.varInit(this, "this", 2553, 77644, 77777);
            CallChecker.varInit(a, "a", 2553, 77644, 77777);
            CallChecker.varInit(this.field, "field", 2553, 77644, 77777);
            CallChecker.varInit(this.nans, "nans", 2553, 77644, 77777);
            CallChecker.varInit(this.exp, "exp", 2553, 77644, 77777);
            CallChecker.varInit(this.sign, "sign", 2553, 77644, 77777);
            CallChecker.varInit(this.mant, "mant", 2553, 77644, 77777);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2553, 77644, 77777);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2553, 77644, 77777);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2553, 77644, 77777);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2553, 77644, 77777);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2553, 77644, 77777);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2553, 77644, 77777);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2553, 77644, 77777);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2553, 77644, 77777);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2553, 77644, 77777);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2553, 77644, 77777);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2553, 77644, 77777);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2553, 77644, 77777);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2553, 77644, 77777);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2553, 77644, 77777);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2553, 77644, 77777);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2553, 77644, 77777);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2553, 77644, 77777);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2553, 77644, 77777);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2553, 77644, 77777);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2553, 77644, 77777);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2553, 77644, 77777);
            return remainder(newInstance(a));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4077.methodEnd();
        }
    }

    public long round() {
        MethodContext _bcornu_methode_context4078 = new MethodContext(long.class, 2560, 77784, 77901);
        try {
            CallChecker.varInit(this, "this", 2560, 77784, 77901);
            CallChecker.varInit(this.field, "field", 2560, 77784, 77901);
            CallChecker.varInit(this.nans, "nans", 2560, 77784, 77901);
            CallChecker.varInit(this.exp, "exp", 2560, 77784, 77901);
            CallChecker.varInit(this.sign, "sign", 2560, 77784, 77901);
            CallChecker.varInit(this.mant, "mant", 2560, 77784, 77901);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2560, 77784, 77901);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2560, 77784, 77901);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2560, 77784, 77901);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2560, 77784, 77901);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2560, 77784, 77901);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2560, 77784, 77901);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2560, 77784, 77901);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2560, 77784, 77901);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2560, 77784, 77901);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2560, 77784, 77901);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2560, 77784, 77901);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2560, 77784, 77901);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2560, 77784, 77901);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2560, 77784, 77901);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2560, 77784, 77901);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2560, 77784, 77901);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2560, 77784, 77901);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2560, 77784, 77901);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2560, 77784, 77901);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2560, 77784, 77901);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2560, 77784, 77901);
            return FastMath.round(toDouble());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4078.methodEnd();
        }
    }

    public Dfp signum() {
        MethodContext _bcornu_methode_context4079 = new MethodContext(Dfp.class, 2567, 77908, 78121);
        try {
            CallChecker.varInit(this, "this", 2567, 77908, 78121);
            CallChecker.varInit(this.field, "field", 2567, 77908, 78121);
            CallChecker.varInit(this.nans, "nans", 2567, 77908, 78121);
            CallChecker.varInit(this.exp, "exp", 2567, 77908, 78121);
            CallChecker.varInit(this.sign, "sign", 2567, 77908, 78121);
            CallChecker.varInit(this.mant, "mant", 2567, 77908, 78121);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2567, 77908, 78121);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2567, 77908, 78121);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2567, 77908, 78121);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2567, 77908, 78121);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2567, 77908, 78121);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2567, 77908, 78121);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2567, 77908, 78121);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2567, 77908, 78121);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2567, 77908, 78121);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2567, 77908, 78121);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2567, 77908, 78121);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2567, 77908, 78121);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2567, 77908, 78121);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2567, 77908, 78121);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2567, 77908, 78121);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2567, 77908, 78121);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2567, 77908, 78121);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2567, 77908, 78121);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2567, 77908, 78121);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2567, 77908, 78121);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2567, 77908, 78121);
            if ((isNaN()) || (isZero())) {
                return this;
            }else {
                return newInstance(((sign) > 0 ? +1 : -1));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4079.methodEnd();
        }
    }

    public Dfp copySign(final Dfp s) {
        MethodContext _bcornu_methode_context4080 = new MethodContext(Dfp.class, 2578, 78128, 78382);
        try {
            CallChecker.varInit(this, "this", 2578, 78128, 78382);
            CallChecker.varInit(s, "s", 2578, 78128, 78382);
            CallChecker.varInit(this.field, "field", 2578, 78128, 78382);
            CallChecker.varInit(this.nans, "nans", 2578, 78128, 78382);
            CallChecker.varInit(this.exp, "exp", 2578, 78128, 78382);
            CallChecker.varInit(this.sign, "sign", 2578, 78128, 78382);
            CallChecker.varInit(this.mant, "mant", 2578, 78128, 78382);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2578, 78128, 78382);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2578, 78128, 78382);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2578, 78128, 78382);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2578, 78128, 78382);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2578, 78128, 78382);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2578, 78128, 78382);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2578, 78128, 78382);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2578, 78128, 78382);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2578, 78128, 78382);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2578, 78128, 78382);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2578, 78128, 78382);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2578, 78128, 78382);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2578, 78128, 78382);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2578, 78128, 78382);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2578, 78128, 78382);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2578, 78128, 78382);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2578, 78128, 78382);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2578, 78128, 78382);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2578, 78128, 78382);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2578, 78128, 78382);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2578, 78128, 78382);
            if (CallChecker.beforeDeref(s, Dfp.class, 2579, 78237, 78237)) {
                if (CallChecker.beforeDeref(s, Dfp.class, 2579, 78266, 78266)) {
                    if ((((sign) >= 0) && ((CallChecker.isCalled(s, Dfp.class, 2579, 78237, 78237).sign) >= 0)) || (((sign) < 0) && ((CallChecker.isCalled(s, Dfp.class, 2579, 78266, 78266).sign) < 0))) {
                        return this;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return negate();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4080.methodEnd();
        }
    }

    public Dfp copySign(final double s) {
        MethodContext _bcornu_methode_context4081 = new MethodContext(Dfp.class, 2588, 78389, 78684);
        try {
            CallChecker.varInit(this, "this", 2588, 78389, 78684);
            CallChecker.varInit(s, "s", 2588, 78389, 78684);
            CallChecker.varInit(this.field, "field", 2588, 78389, 78684);
            CallChecker.varInit(this.nans, "nans", 2588, 78389, 78684);
            CallChecker.varInit(this.exp, "exp", 2588, 78389, 78684);
            CallChecker.varInit(this.sign, "sign", 2588, 78389, 78684);
            CallChecker.varInit(this.mant, "mant", 2588, 78389, 78684);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2588, 78389, 78684);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2588, 78389, 78684);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2588, 78389, 78684);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2588, 78389, 78684);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2588, 78389, 78684);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2588, 78389, 78684);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2588, 78389, 78684);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2588, 78389, 78684);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2588, 78389, 78684);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2588, 78389, 78684);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2588, 78389, 78684);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2588, 78389, 78684);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2588, 78389, 78684);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2588, 78389, 78684);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2588, 78389, 78684);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2588, 78389, 78684);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2588, 78389, 78684);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2588, 78389, 78684);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2588, 78389, 78684);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2588, 78389, 78684);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2588, 78389, 78684);
            long sb = CallChecker.varInit(((long) (Double.doubleToLongBits(s))), "sb", 2589, 78483, 78519);
            if ((((sign) >= 0) && (sb >= 0)) || (((sign) < 0) && (sb < 0))) {
                return this;
            }
            return negate();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4081.methodEnd();
        }
    }

    public Dfp scalb(final int n) {
        MethodContext _bcornu_methode_context4082 = new MethodContext(Dfp.class, 2599, 78691, 78826);
        try {
            CallChecker.varInit(this, "this", 2599, 78691, 78826);
            CallChecker.varInit(n, "n", 2599, 78691, 78826);
            CallChecker.varInit(this.field, "field", 2599, 78691, 78826);
            CallChecker.varInit(this.nans, "nans", 2599, 78691, 78826);
            CallChecker.varInit(this.exp, "exp", 2599, 78691, 78826);
            CallChecker.varInit(this.sign, "sign", 2599, 78691, 78826);
            CallChecker.varInit(this.mant, "mant", 2599, 78691, 78826);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2599, 78691, 78826);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2599, 78691, 78826);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2599, 78691, 78826);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2599, 78691, 78826);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2599, 78691, 78826);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2599, 78691, 78826);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2599, 78691, 78826);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2599, 78691, 78826);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2599, 78691, 78826);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2599, 78691, 78826);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2599, 78691, 78826);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2599, 78691, 78826);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2599, 78691, 78826);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2599, 78691, 78826);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2599, 78691, 78826);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2599, 78691, 78826);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2599, 78691, 78826);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2599, 78691, 78826);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2599, 78691, 78826);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2599, 78691, 78826);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2599, 78691, 78826);
            return multiply(DfpMath.pow(getTwo(), n));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4082.methodEnd();
        }
    }

    public Dfp hypot(final Dfp y) {
        MethodContext _bcornu_methode_context4083 = new MethodContext(Dfp.class, 2606, 78833, 78974);
        try {
            CallChecker.varInit(this, "this", 2606, 78833, 78974);
            CallChecker.varInit(y, "y", 2606, 78833, 78974);
            CallChecker.varInit(this.field, "field", 2606, 78833, 78974);
            CallChecker.varInit(this.nans, "nans", 2606, 78833, 78974);
            CallChecker.varInit(this.exp, "exp", 2606, 78833, 78974);
            CallChecker.varInit(this.sign, "sign", 2606, 78833, 78974);
            CallChecker.varInit(this.mant, "mant", 2606, 78833, 78974);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2606, 78833, 78974);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2606, 78833, 78974);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2606, 78833, 78974);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2606, 78833, 78974);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2606, 78833, 78974);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2606, 78833, 78974);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2606, 78833, 78974);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2606, 78833, 78974);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2606, 78833, 78974);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2606, 78833, 78974);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2606, 78833, 78974);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2606, 78833, 78974);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2606, 78833, 78974);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2606, 78833, 78974);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2606, 78833, 78974);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2606, 78833, 78974);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2606, 78833, 78974);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2606, 78833, 78974);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2606, 78833, 78974);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2606, 78833, 78974);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2606, 78833, 78974);
            if (CallChecker.beforeDeref(y, Dfp.class, 2607, 78947, 78947)) {
                final Dfp npe_invocation_var849 = multiply(this);
                if (CallChecker.beforeDeref(npe_invocation_var849, Dfp.class, 2607, 78928, 78941)) {
                    final Dfp npe_invocation_var850 = CallChecker.isCalled(npe_invocation_var849, Dfp.class, 2607, 78928, 78941).add(CallChecker.isCalled(y, Dfp.class, 2607, 78947, 78947).multiply(y));
                    if (CallChecker.beforeDeref(npe_invocation_var850, Dfp.class, 2607, 78928, 78960)) {
                        return CallChecker.isCalled(npe_invocation_var850, Dfp.class, 2607, 78928, 78960).sqrt();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4083.methodEnd();
        }
    }

    public Dfp cbrt() {
        MethodContext _bcornu_methode_context4084 = new MethodContext(Dfp.class, 2613, 78981, 79078);
        try {
            CallChecker.varInit(this, "this", 2613, 78981, 79078);
            CallChecker.varInit(this.field, "field", 2613, 78981, 79078);
            CallChecker.varInit(this.nans, "nans", 2613, 78981, 79078);
            CallChecker.varInit(this.exp, "exp", 2613, 78981, 79078);
            CallChecker.varInit(this.sign, "sign", 2613, 78981, 79078);
            CallChecker.varInit(this.mant, "mant", 2613, 78981, 79078);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2613, 78981, 79078);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2613, 78981, 79078);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2613, 78981, 79078);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2613, 78981, 79078);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2613, 78981, 79078);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2613, 78981, 79078);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2613, 78981, 79078);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2613, 78981, 79078);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2613, 78981, 79078);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2613, 78981, 79078);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2613, 78981, 79078);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2613, 78981, 79078);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2613, 78981, 79078);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2613, 78981, 79078);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2613, 78981, 79078);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2613, 78981, 79078);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2613, 78981, 79078);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2613, 78981, 79078);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2613, 78981, 79078);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2613, 78981, 79078);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2613, 78981, 79078);
            return rootN(3);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4084.methodEnd();
        }
    }

    public Dfp rootN(final int n) {
        MethodContext _bcornu_methode_context4085 = new MethodContext(Dfp.class, 2620, 79085, 79320);
        try {
            CallChecker.varInit(this, "this", 2620, 79085, 79320);
            CallChecker.varInit(n, "n", 2620, 79085, 79320);
            CallChecker.varInit(this.field, "field", 2620, 79085, 79320);
            CallChecker.varInit(this.nans, "nans", 2620, 79085, 79320);
            CallChecker.varInit(this.exp, "exp", 2620, 79085, 79320);
            CallChecker.varInit(this.sign, "sign", 2620, 79085, 79320);
            CallChecker.varInit(this.mant, "mant", 2620, 79085, 79320);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2620, 79085, 79320);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2620, 79085, 79320);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2620, 79085, 79320);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2620, 79085, 79320);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2620, 79085, 79320);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2620, 79085, 79320);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2620, 79085, 79320);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2620, 79085, 79320);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2620, 79085, 79320);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2620, 79085, 79320);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2620, 79085, 79320);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2620, 79085, 79320);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2620, 79085, 79320);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2620, 79085, 79320);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2620, 79085, 79320);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2620, 79085, 79320);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2620, 79085, 79320);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2620, 79085, 79320);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2620, 79085, 79320);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2620, 79085, 79320);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2620, 79085, 79320);
            if ((sign) >= 0) {
                final Dfp npe_invocation_var851 = getOne();
                if (CallChecker.beforeDeref(npe_invocation_var851, Dfp.class, 2622, 79227, 79234)) {
                    return DfpMath.pow(this, CallChecker.isCalled(npe_invocation_var851, Dfp.class, 2622, 79227, 79234).divide(n));
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                final Dfp npe_invocation_var852 = getOne();
                if (CallChecker.beforeDeref(npe_invocation_var852, Dfp.class, 2623, 79286, 79293)) {
                    final Dfp npe_invocation_var853 = DfpMath.pow(negate(), CallChecker.isCalled(npe_invocation_var852, Dfp.class, 2623, 79286, 79293).divide(n));
                    if (CallChecker.beforeDeref(npe_invocation_var853, Dfp.class, 2623, 79264, 79304)) {
                        return CallChecker.isCalled(npe_invocation_var853, Dfp.class, 2623, 79264, 79304).negate();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4085.methodEnd();
        }
    }

    public Dfp pow(final double p) {
        MethodContext _bcornu_methode_context4086 = new MethodContext(Dfp.class, 2629, 79327, 79462);
        try {
            CallChecker.varInit(this, "this", 2629, 79327, 79462);
            CallChecker.varInit(p, "p", 2629, 79327, 79462);
            CallChecker.varInit(this.field, "field", 2629, 79327, 79462);
            CallChecker.varInit(this.nans, "nans", 2629, 79327, 79462);
            CallChecker.varInit(this.exp, "exp", 2629, 79327, 79462);
            CallChecker.varInit(this.sign, "sign", 2629, 79327, 79462);
            CallChecker.varInit(this.mant, "mant", 2629, 79327, 79462);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2629, 79327, 79462);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2629, 79327, 79462);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2629, 79327, 79462);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2629, 79327, 79462);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2629, 79327, 79462);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2629, 79327, 79462);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2629, 79327, 79462);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2629, 79327, 79462);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2629, 79327, 79462);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2629, 79327, 79462);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2629, 79327, 79462);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2629, 79327, 79462);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2629, 79327, 79462);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2629, 79327, 79462);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2629, 79327, 79462);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2629, 79327, 79462);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2629, 79327, 79462);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2629, 79327, 79462);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2629, 79327, 79462);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2629, 79327, 79462);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2629, 79327, 79462);
            return DfpMath.pow(this, newInstance(p));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4086.methodEnd();
        }
    }

    public Dfp pow(final int n) {
        MethodContext _bcornu_methode_context4087 = new MethodContext(Dfp.class, 2636, 79469, 79588);
        try {
            CallChecker.varInit(this, "this", 2636, 79469, 79588);
            CallChecker.varInit(n, "n", 2636, 79469, 79588);
            CallChecker.varInit(this.field, "field", 2636, 79469, 79588);
            CallChecker.varInit(this.nans, "nans", 2636, 79469, 79588);
            CallChecker.varInit(this.exp, "exp", 2636, 79469, 79588);
            CallChecker.varInit(this.sign, "sign", 2636, 79469, 79588);
            CallChecker.varInit(this.mant, "mant", 2636, 79469, 79588);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2636, 79469, 79588);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2636, 79469, 79588);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2636, 79469, 79588);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2636, 79469, 79588);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2636, 79469, 79588);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2636, 79469, 79588);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2636, 79469, 79588);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2636, 79469, 79588);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2636, 79469, 79588);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2636, 79469, 79588);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2636, 79469, 79588);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2636, 79469, 79588);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2636, 79469, 79588);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2636, 79469, 79588);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2636, 79469, 79588);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2636, 79469, 79588);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2636, 79469, 79588);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2636, 79469, 79588);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2636, 79469, 79588);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2636, 79469, 79588);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2636, 79469, 79588);
            return DfpMath.pow(this, n);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4087.methodEnd();
        }
    }

    public Dfp pow(final Dfp e) {
        MethodContext _bcornu_methode_context4088 = new MethodContext(Dfp.class, 2643, 79595, 79714);
        try {
            CallChecker.varInit(this, "this", 2643, 79595, 79714);
            CallChecker.varInit(e, "e", 2643, 79595, 79714);
            CallChecker.varInit(this.field, "field", 2643, 79595, 79714);
            CallChecker.varInit(this.nans, "nans", 2643, 79595, 79714);
            CallChecker.varInit(this.exp, "exp", 2643, 79595, 79714);
            CallChecker.varInit(this.sign, "sign", 2643, 79595, 79714);
            CallChecker.varInit(this.mant, "mant", 2643, 79595, 79714);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2643, 79595, 79714);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2643, 79595, 79714);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2643, 79595, 79714);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2643, 79595, 79714);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2643, 79595, 79714);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2643, 79595, 79714);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2643, 79595, 79714);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2643, 79595, 79714);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2643, 79595, 79714);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2643, 79595, 79714);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2643, 79595, 79714);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2643, 79595, 79714);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2643, 79595, 79714);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2643, 79595, 79714);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2643, 79595, 79714);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2643, 79595, 79714);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2643, 79595, 79714);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2643, 79595, 79714);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2643, 79595, 79714);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2643, 79595, 79714);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2643, 79595, 79714);
            return DfpMath.pow(this, e);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4088.methodEnd();
        }
    }

    public Dfp exp() {
        MethodContext _bcornu_methode_context4089 = new MethodContext(Dfp.class, 2650, 79721, 79826);
        try {
            CallChecker.varInit(this, "this", 2650, 79721, 79826);
            CallChecker.varInit(this.field, "field", 2650, 79721, 79826);
            CallChecker.varInit(this.nans, "nans", 2650, 79721, 79826);
            CallChecker.varInit(this.exp, "exp", 2650, 79721, 79826);
            CallChecker.varInit(this.sign, "sign", 2650, 79721, 79826);
            CallChecker.varInit(this.mant, "mant", 2650, 79721, 79826);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2650, 79721, 79826);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2650, 79721, 79826);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2650, 79721, 79826);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2650, 79721, 79826);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2650, 79721, 79826);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2650, 79721, 79826);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2650, 79721, 79826);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2650, 79721, 79826);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2650, 79721, 79826);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2650, 79721, 79826);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2650, 79721, 79826);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2650, 79721, 79826);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2650, 79721, 79826);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2650, 79721, 79826);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2650, 79721, 79826);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2650, 79721, 79826);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2650, 79721, 79826);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2650, 79721, 79826);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2650, 79721, 79826);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2650, 79721, 79826);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2650, 79721, 79826);
            return DfpMath.exp(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4089.methodEnd();
        }
    }

    public Dfp expm1() {
        MethodContext _bcornu_methode_context4090 = new MethodContext(Dfp.class, 2657, 79833, 79959);
        try {
            CallChecker.varInit(this, "this", 2657, 79833, 79959);
            CallChecker.varInit(this.field, "field", 2657, 79833, 79959);
            CallChecker.varInit(this.nans, "nans", 2657, 79833, 79959);
            CallChecker.varInit(this.exp, "exp", 2657, 79833, 79959);
            CallChecker.varInit(this.sign, "sign", 2657, 79833, 79959);
            CallChecker.varInit(this.mant, "mant", 2657, 79833, 79959);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2657, 79833, 79959);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2657, 79833, 79959);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2657, 79833, 79959);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2657, 79833, 79959);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2657, 79833, 79959);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2657, 79833, 79959);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2657, 79833, 79959);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2657, 79833, 79959);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2657, 79833, 79959);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2657, 79833, 79959);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2657, 79833, 79959);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2657, 79833, 79959);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2657, 79833, 79959);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2657, 79833, 79959);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2657, 79833, 79959);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2657, 79833, 79959);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2657, 79833, 79959);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2657, 79833, 79959);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2657, 79833, 79959);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2657, 79833, 79959);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2657, 79833, 79959);
            final Dfp npe_invocation_var854 = DfpMath.exp(this);
            if (CallChecker.beforeDeref(npe_invocation_var854, Dfp.class, 2658, 79917, 79933)) {
                return CallChecker.isCalled(npe_invocation_var854, Dfp.class, 2658, 79917, 79933).subtract(getOne());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4090.methodEnd();
        }
    }

    public Dfp log() {
        MethodContext _bcornu_methode_context4091 = new MethodContext(Dfp.class, 2664, 79966, 80071);
        try {
            CallChecker.varInit(this, "this", 2664, 79966, 80071);
            CallChecker.varInit(this.field, "field", 2664, 79966, 80071);
            CallChecker.varInit(this.nans, "nans", 2664, 79966, 80071);
            CallChecker.varInit(this.exp, "exp", 2664, 79966, 80071);
            CallChecker.varInit(this.sign, "sign", 2664, 79966, 80071);
            CallChecker.varInit(this.mant, "mant", 2664, 79966, 80071);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2664, 79966, 80071);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2664, 79966, 80071);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2664, 79966, 80071);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2664, 79966, 80071);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2664, 79966, 80071);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2664, 79966, 80071);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2664, 79966, 80071);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2664, 79966, 80071);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2664, 79966, 80071);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2664, 79966, 80071);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2664, 79966, 80071);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2664, 79966, 80071);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2664, 79966, 80071);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2664, 79966, 80071);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2664, 79966, 80071);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2664, 79966, 80071);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2664, 79966, 80071);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2664, 79966, 80071);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2664, 79966, 80071);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2664, 79966, 80071);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2664, 79966, 80071);
            return DfpMath.log(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4091.methodEnd();
        }
    }

    public Dfp log1p() {
        MethodContext _bcornu_methode_context4092 = new MethodContext(Dfp.class, 2671, 80078, 80199);
        try {
            CallChecker.varInit(this, "this", 2671, 80078, 80199);
            CallChecker.varInit(this.field, "field", 2671, 80078, 80199);
            CallChecker.varInit(this.nans, "nans", 2671, 80078, 80199);
            CallChecker.varInit(this.exp, "exp", 2671, 80078, 80199);
            CallChecker.varInit(this.sign, "sign", 2671, 80078, 80199);
            CallChecker.varInit(this.mant, "mant", 2671, 80078, 80199);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2671, 80078, 80199);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2671, 80078, 80199);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2671, 80078, 80199);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2671, 80078, 80199);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2671, 80078, 80199);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2671, 80078, 80199);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2671, 80078, 80199);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2671, 80078, 80199);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2671, 80078, 80199);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2671, 80078, 80199);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2671, 80078, 80199);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2671, 80078, 80199);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2671, 80078, 80199);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2671, 80078, 80199);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2671, 80078, 80199);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2671, 80078, 80199);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2671, 80078, 80199);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2671, 80078, 80199);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2671, 80078, 80199);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2671, 80078, 80199);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2671, 80078, 80199);
            return DfpMath.log(this.add(getOne()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4092.methodEnd();
        }
    }

    @Deprecated
    public int log10() {
        MethodContext _bcornu_methode_context4093 = new MethodContext(int.class, 2682, 80202, 80603);
        try {
            CallChecker.varInit(this, "this", 2682, 80202, 80603);
            CallChecker.varInit(this.field, "field", 2682, 80202, 80603);
            CallChecker.varInit(this.nans, "nans", 2682, 80202, 80603);
            CallChecker.varInit(this.exp, "exp", 2682, 80202, 80603);
            CallChecker.varInit(this.sign, "sign", 2682, 80202, 80603);
            CallChecker.varInit(this.mant, "mant", 2682, 80202, 80603);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2682, 80202, 80603);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2682, 80202, 80603);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2682, 80202, 80603);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2682, 80202, 80603);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2682, 80202, 80603);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2682, 80202, 80603);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2682, 80202, 80603);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2682, 80202, 80603);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2682, 80202, 80603);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2682, 80202, 80603);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2682, 80202, 80603);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2682, 80202, 80603);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2682, 80202, 80603);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2682, 80202, 80603);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2682, 80202, 80603);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2682, 80202, 80603);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2682, 80202, 80603);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2682, 80202, 80603);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2682, 80202, 80603);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2682, 80202, 80603);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2682, 80202, 80603);
            return intLog10();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4093.methodEnd();
        }
    }

    public Dfp cos() {
        MethodContext _bcornu_methode_context4094 = new MethodContext(Dfp.class, 2697, 80606, 80944);
        try {
            CallChecker.varInit(this, "this", 2697, 80606, 80944);
            CallChecker.varInit(this.field, "field", 2697, 80606, 80944);
            CallChecker.varInit(this.nans, "nans", 2697, 80606, 80944);
            CallChecker.varInit(this.exp, "exp", 2697, 80606, 80944);
            CallChecker.varInit(this.sign, "sign", 2697, 80606, 80944);
            CallChecker.varInit(this.mant, "mant", 2697, 80606, 80944);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2697, 80606, 80944);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2697, 80606, 80944);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2697, 80606, 80944);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2697, 80606, 80944);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2697, 80606, 80944);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2697, 80606, 80944);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2697, 80606, 80944);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2697, 80606, 80944);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2697, 80606, 80944);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2697, 80606, 80944);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2697, 80606, 80944);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2697, 80606, 80944);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2697, 80606, 80944);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2697, 80606, 80944);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2697, 80606, 80944);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2697, 80606, 80944);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2697, 80606, 80944);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2697, 80606, 80944);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2697, 80606, 80944);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2697, 80606, 80944);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2697, 80606, 80944);
            return DfpMath.cos(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4094.methodEnd();
        }
    }

    public Dfp sin() {
        MethodContext _bcornu_methode_context4095 = new MethodContext(Dfp.class, 2704, 80951, 81056);
        try {
            CallChecker.varInit(this, "this", 2704, 80951, 81056);
            CallChecker.varInit(this.field, "field", 2704, 80951, 81056);
            CallChecker.varInit(this.nans, "nans", 2704, 80951, 81056);
            CallChecker.varInit(this.exp, "exp", 2704, 80951, 81056);
            CallChecker.varInit(this.sign, "sign", 2704, 80951, 81056);
            CallChecker.varInit(this.mant, "mant", 2704, 80951, 81056);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2704, 80951, 81056);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2704, 80951, 81056);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2704, 80951, 81056);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2704, 80951, 81056);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2704, 80951, 81056);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2704, 80951, 81056);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2704, 80951, 81056);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2704, 80951, 81056);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2704, 80951, 81056);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2704, 80951, 81056);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2704, 80951, 81056);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2704, 80951, 81056);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2704, 80951, 81056);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2704, 80951, 81056);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2704, 80951, 81056);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2704, 80951, 81056);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2704, 80951, 81056);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2704, 80951, 81056);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2704, 80951, 81056);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2704, 80951, 81056);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2704, 80951, 81056);
            return DfpMath.sin(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4095.methodEnd();
        }
    }

    public Dfp tan() {
        MethodContext _bcornu_methode_context4096 = new MethodContext(Dfp.class, 2711, 81063, 81168);
        try {
            CallChecker.varInit(this, "this", 2711, 81063, 81168);
            CallChecker.varInit(this.field, "field", 2711, 81063, 81168);
            CallChecker.varInit(this.nans, "nans", 2711, 81063, 81168);
            CallChecker.varInit(this.exp, "exp", 2711, 81063, 81168);
            CallChecker.varInit(this.sign, "sign", 2711, 81063, 81168);
            CallChecker.varInit(this.mant, "mant", 2711, 81063, 81168);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2711, 81063, 81168);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2711, 81063, 81168);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2711, 81063, 81168);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2711, 81063, 81168);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2711, 81063, 81168);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2711, 81063, 81168);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2711, 81063, 81168);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2711, 81063, 81168);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2711, 81063, 81168);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2711, 81063, 81168);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2711, 81063, 81168);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2711, 81063, 81168);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2711, 81063, 81168);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2711, 81063, 81168);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2711, 81063, 81168);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2711, 81063, 81168);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2711, 81063, 81168);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2711, 81063, 81168);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2711, 81063, 81168);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2711, 81063, 81168);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2711, 81063, 81168);
            return DfpMath.tan(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4096.methodEnd();
        }
    }

    public Dfp acos() {
        MethodContext _bcornu_methode_context4097 = new MethodContext(Dfp.class, 2718, 81175, 81282);
        try {
            CallChecker.varInit(this, "this", 2718, 81175, 81282);
            CallChecker.varInit(this.field, "field", 2718, 81175, 81282);
            CallChecker.varInit(this.nans, "nans", 2718, 81175, 81282);
            CallChecker.varInit(this.exp, "exp", 2718, 81175, 81282);
            CallChecker.varInit(this.sign, "sign", 2718, 81175, 81282);
            CallChecker.varInit(this.mant, "mant", 2718, 81175, 81282);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2718, 81175, 81282);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2718, 81175, 81282);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2718, 81175, 81282);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2718, 81175, 81282);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2718, 81175, 81282);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2718, 81175, 81282);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2718, 81175, 81282);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2718, 81175, 81282);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2718, 81175, 81282);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2718, 81175, 81282);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2718, 81175, 81282);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2718, 81175, 81282);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2718, 81175, 81282);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2718, 81175, 81282);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2718, 81175, 81282);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2718, 81175, 81282);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2718, 81175, 81282);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2718, 81175, 81282);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2718, 81175, 81282);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2718, 81175, 81282);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2718, 81175, 81282);
            return DfpMath.acos(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4097.methodEnd();
        }
    }

    public Dfp asin() {
        MethodContext _bcornu_methode_context4098 = new MethodContext(Dfp.class, 2725, 81289, 81396);
        try {
            CallChecker.varInit(this, "this", 2725, 81289, 81396);
            CallChecker.varInit(this.field, "field", 2725, 81289, 81396);
            CallChecker.varInit(this.nans, "nans", 2725, 81289, 81396);
            CallChecker.varInit(this.exp, "exp", 2725, 81289, 81396);
            CallChecker.varInit(this.sign, "sign", 2725, 81289, 81396);
            CallChecker.varInit(this.mant, "mant", 2725, 81289, 81396);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2725, 81289, 81396);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2725, 81289, 81396);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2725, 81289, 81396);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2725, 81289, 81396);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2725, 81289, 81396);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2725, 81289, 81396);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2725, 81289, 81396);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2725, 81289, 81396);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2725, 81289, 81396);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2725, 81289, 81396);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2725, 81289, 81396);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2725, 81289, 81396);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2725, 81289, 81396);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2725, 81289, 81396);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2725, 81289, 81396);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2725, 81289, 81396);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2725, 81289, 81396);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2725, 81289, 81396);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2725, 81289, 81396);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2725, 81289, 81396);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2725, 81289, 81396);
            return DfpMath.asin(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4098.methodEnd();
        }
    }

    public Dfp atan() {
        MethodContext _bcornu_methode_context4099 = new MethodContext(Dfp.class, 2732, 81403, 81510);
        try {
            CallChecker.varInit(this, "this", 2732, 81403, 81510);
            CallChecker.varInit(this.field, "field", 2732, 81403, 81510);
            CallChecker.varInit(this.nans, "nans", 2732, 81403, 81510);
            CallChecker.varInit(this.exp, "exp", 2732, 81403, 81510);
            CallChecker.varInit(this.sign, "sign", 2732, 81403, 81510);
            CallChecker.varInit(this.mant, "mant", 2732, 81403, 81510);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2732, 81403, 81510);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2732, 81403, 81510);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2732, 81403, 81510);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2732, 81403, 81510);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2732, 81403, 81510);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2732, 81403, 81510);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2732, 81403, 81510);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2732, 81403, 81510);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2732, 81403, 81510);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2732, 81403, 81510);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2732, 81403, 81510);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2732, 81403, 81510);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2732, 81403, 81510);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2732, 81403, 81510);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2732, 81403, 81510);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2732, 81403, 81510);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2732, 81403, 81510);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2732, 81403, 81510);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2732, 81403, 81510);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2732, 81403, 81510);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2732, 81403, 81510);
            return DfpMath.atan(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4099.methodEnd();
        }
    }

    public Dfp atan2(final Dfp x) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4100 = new MethodContext(Dfp.class, 2739, 81517, 82195);
        try {
            CallChecker.varInit(this, "this", 2739, 81517, 82195);
            CallChecker.varInit(x, "x", 2739, 81517, 82195);
            CallChecker.varInit(this.field, "field", 2739, 81517, 82195);
            CallChecker.varInit(this.nans, "nans", 2739, 81517, 82195);
            CallChecker.varInit(this.exp, "exp", 2739, 81517, 82195);
            CallChecker.varInit(this.sign, "sign", 2739, 81517, 82195);
            CallChecker.varInit(this.mant, "mant", 2739, 81517, 82195);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2739, 81517, 82195);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2739, 81517, 82195);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2739, 81517, 82195);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2739, 81517, 82195);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2739, 81517, 82195);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2739, 81517, 82195);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2739, 81517, 82195);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2739, 81517, 82195);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2739, 81517, 82195);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2739, 81517, 82195);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2739, 81517, 82195);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2739, 81517, 82195);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2739, 81517, 82195);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2739, 81517, 82195);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2739, 81517, 82195);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2739, 81517, 82195);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2739, 81517, 82195);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2739, 81517, 82195);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2739, 81517, 82195);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2739, 81517, 82195);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2739, 81517, 82195);
            final Dfp r = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 2743, 81699, 81699).multiply(x), Dfp.class, 2743, 81699, 81711).add(multiply(this)), Dfp.class, 2743, 81699, 81731).sqrt(), "r", 2743, 81648, 81739);
            if (CallChecker.beforeDeref(x, Dfp.class, 2745, 81754, 81754)) {
                if ((CallChecker.isCalled(x, Dfp.class, 2745, 81754, 81754).sign) >= 0) {
                    if (CallChecker.beforeDeref(r, Dfp.class, 2748, 81871, 81871)) {
                        final Dfp npe_invocation_var855 = divide(CallChecker.isCalled(r, Dfp.class, 2748, 81871, 81871).add(x));
                        if (CallChecker.beforeDeref(npe_invocation_var855, Dfp.class, 2748, 81864, 81879)) {
                            final Dfp npe_invocation_var856 = getTwo();
                            if (CallChecker.beforeDeref(npe_invocation_var856, Dfp.class, 2748, 81846, 81853)) {
                                return CallChecker.isCalled(npe_invocation_var856, Dfp.class, 2748, 81846, 81853).multiply(CallChecker.isCalled(npe_invocation_var855, Dfp.class, 2748, 81864, 81879).atan());
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    final Dfp tmp = CallChecker.varInit(CallChecker.isCalled(getTwo(), Dfp.class, 2753, 82003, 82010).multiply(CallChecker.isCalled(divide(CallChecker.isCalled(r, Dfp.class, 2753, 82028, 82028).subtract(x)), Dfp.class, 2753, 82021, 82041).atan()), "tmp", 2753, 81921, 82050);
                    final Dfp pmPi = CallChecker.varInit(newInstance(((CallChecker.isCalled(tmp, Dfp.class, 2754, 82094, 82096).sign) <= 0 ? -(FastMath.PI) : FastMath.PI)), "pmPi", 2754, 82064, 82138);
                    if (CallChecker.beforeDeref(pmPi, Dfp.class, 2755, 82159, 82162)) {
                        return CallChecker.isCalled(pmPi, Dfp.class, 2755, 82159, 82162).subtract(tmp);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4100.methodEnd();
        }
    }

    public Dfp cosh() {
        MethodContext _bcornu_methode_context4101 = new MethodContext(Dfp.class, 2764, 82202, 82345);
        try {
            CallChecker.varInit(this, "this", 2764, 82202, 82345);
            CallChecker.varInit(this.field, "field", 2764, 82202, 82345);
            CallChecker.varInit(this.nans, "nans", 2764, 82202, 82345);
            CallChecker.varInit(this.exp, "exp", 2764, 82202, 82345);
            CallChecker.varInit(this.sign, "sign", 2764, 82202, 82345);
            CallChecker.varInit(this.mant, "mant", 2764, 82202, 82345);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2764, 82202, 82345);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2764, 82202, 82345);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2764, 82202, 82345);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2764, 82202, 82345);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2764, 82202, 82345);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2764, 82202, 82345);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2764, 82202, 82345);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2764, 82202, 82345);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2764, 82202, 82345);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2764, 82202, 82345);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2764, 82202, 82345);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2764, 82202, 82345);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2764, 82202, 82345);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2764, 82202, 82345);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2764, 82202, 82345);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2764, 82202, 82345);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2764, 82202, 82345);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2764, 82202, 82345);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2764, 82202, 82345);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2764, 82202, 82345);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2764, 82202, 82345);
            final Dfp npe_invocation_var857 = DfpMath.exp(this);
            if (CallChecker.beforeDeref(npe_invocation_var857, Dfp.class, 2765, 82285, 82301)) {
                final Dfp npe_invocation_var858 = CallChecker.isCalled(npe_invocation_var857, Dfp.class, 2765, 82285, 82301).add(DfpMath.exp(negate()));
                if (CallChecker.beforeDeref(npe_invocation_var858, Dfp.class, 2765, 82285, 82328)) {
                    return CallChecker.isCalled(npe_invocation_var858, Dfp.class, 2765, 82285, 82328).divide(2);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4101.methodEnd();
        }
    }

    public Dfp sinh() {
        MethodContext _bcornu_methode_context4102 = new MethodContext(Dfp.class, 2771, 82352, 82500);
        try {
            CallChecker.varInit(this, "this", 2771, 82352, 82500);
            CallChecker.varInit(this.field, "field", 2771, 82352, 82500);
            CallChecker.varInit(this.nans, "nans", 2771, 82352, 82500);
            CallChecker.varInit(this.exp, "exp", 2771, 82352, 82500);
            CallChecker.varInit(this.sign, "sign", 2771, 82352, 82500);
            CallChecker.varInit(this.mant, "mant", 2771, 82352, 82500);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2771, 82352, 82500);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2771, 82352, 82500);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2771, 82352, 82500);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2771, 82352, 82500);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2771, 82352, 82500);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2771, 82352, 82500);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2771, 82352, 82500);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2771, 82352, 82500);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2771, 82352, 82500);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2771, 82352, 82500);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2771, 82352, 82500);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2771, 82352, 82500);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2771, 82352, 82500);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2771, 82352, 82500);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2771, 82352, 82500);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2771, 82352, 82500);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2771, 82352, 82500);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2771, 82352, 82500);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2771, 82352, 82500);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2771, 82352, 82500);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2771, 82352, 82500);
            final Dfp npe_invocation_var859 = DfpMath.exp(this);
            if (CallChecker.beforeDeref(npe_invocation_var859, Dfp.class, 2772, 82435, 82451)) {
                final Dfp npe_invocation_var860 = CallChecker.isCalled(npe_invocation_var859, Dfp.class, 2772, 82435, 82451).subtract(DfpMath.exp(negate()));
                if (CallChecker.beforeDeref(npe_invocation_var860, Dfp.class, 2772, 82435, 82483)) {
                    return CallChecker.isCalled(npe_invocation_var860, Dfp.class, 2772, 82435, 82483).divide(2);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4102.methodEnd();
        }
    }

    public Dfp tanh() {
        MethodContext _bcornu_methode_context4103 = new MethodContext(Dfp.class, 2778, 82507, 82740);
        try {
            CallChecker.varInit(this, "this", 2778, 82507, 82740);
            CallChecker.varInit(this.field, "field", 2778, 82507, 82740);
            CallChecker.varInit(this.nans, "nans", 2778, 82507, 82740);
            CallChecker.varInit(this.exp, "exp", 2778, 82507, 82740);
            CallChecker.varInit(this.sign, "sign", 2778, 82507, 82740);
            CallChecker.varInit(this.mant, "mant", 2778, 82507, 82740);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2778, 82507, 82740);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2778, 82507, 82740);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2778, 82507, 82740);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2778, 82507, 82740);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2778, 82507, 82740);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2778, 82507, 82740);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2778, 82507, 82740);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2778, 82507, 82740);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2778, 82507, 82740);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2778, 82507, 82740);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2778, 82507, 82740);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2778, 82507, 82740);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2778, 82507, 82740);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2778, 82507, 82740);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2778, 82507, 82740);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2778, 82507, 82740);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2778, 82507, 82740);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2778, 82507, 82740);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2778, 82507, 82740);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2778, 82507, 82740);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2778, 82507, 82740);
            final Dfp ePlus = CallChecker.varInit(DfpMath.exp(this), "ePlus", 2779, 82583, 82619);
            final Dfp eMinus = CallChecker.varInit(DfpMath.exp(negate()), "eMinus", 2780, 82629, 82669);
            if (CallChecker.beforeDeref(ePlus, Dfp.class, 2781, 82686, 82690)) {
                if (CallChecker.beforeDeref(ePlus, Dfp.class, 2781, 82716, 82720)) {
                    final Dfp npe_invocation_var861 = CallChecker.isCalled(ePlus, Dfp.class, 2781, 82686, 82690).subtract(eMinus);
                    if (CallChecker.beforeDeref(npe_invocation_var861, Dfp.class, 2781, 82686, 82707)) {
                        return CallChecker.isCalled(npe_invocation_var861, Dfp.class, 2781, 82686, 82707).divide(CallChecker.isCalled(ePlus, Dfp.class, 2781, 82716, 82720).add(eMinus));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4103.methodEnd();
        }
    }

    public Dfp acosh() {
        MethodContext _bcornu_methode_context4104 = new MethodContext(Dfp.class, 2787, 82747, 82893);
        try {
            CallChecker.varInit(this, "this", 2787, 82747, 82893);
            CallChecker.varInit(this.field, "field", 2787, 82747, 82893);
            CallChecker.varInit(this.nans, "nans", 2787, 82747, 82893);
            CallChecker.varInit(this.exp, "exp", 2787, 82747, 82893);
            CallChecker.varInit(this.sign, "sign", 2787, 82747, 82893);
            CallChecker.varInit(this.mant, "mant", 2787, 82747, 82893);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2787, 82747, 82893);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2787, 82747, 82893);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2787, 82747, 82893);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2787, 82747, 82893);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2787, 82747, 82893);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2787, 82747, 82893);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2787, 82747, 82893);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2787, 82747, 82893);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2787, 82747, 82893);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2787, 82747, 82893);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2787, 82747, 82893);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2787, 82747, 82893);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2787, 82747, 82893);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2787, 82747, 82893);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2787, 82747, 82893);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2787, 82747, 82893);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2787, 82747, 82893);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2787, 82747, 82893);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2787, 82747, 82893);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2787, 82747, 82893);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2787, 82747, 82893);
            final Dfp npe_invocation_var862 = multiply(this);
            if (CallChecker.beforeDeref(npe_invocation_var862, Dfp.class, 2788, 82831, 82844)) {
                final Dfp npe_invocation_var863 = CallChecker.isCalled(npe_invocation_var862, Dfp.class, 2788, 82831, 82844).subtract(getOne());
                if (CallChecker.beforeDeref(npe_invocation_var863, Dfp.class, 2788, 82831, 82863)) {
                    final Dfp npe_invocation_var864 = CallChecker.isCalled(npe_invocation_var863, Dfp.class, 2788, 82831, 82863).sqrt();
                    if (CallChecker.beforeDeref(npe_invocation_var864, Dfp.class, 2788, 82831, 82870)) {
                        final Dfp npe_invocation_var865 = CallChecker.isCalled(npe_invocation_var864, Dfp.class, 2788, 82831, 82870).add(this);
                        if (CallChecker.beforeDeref(npe_invocation_var865, Dfp.class, 2788, 82831, 82880)) {
                            return CallChecker.isCalled(npe_invocation_var865, Dfp.class, 2788, 82831, 82880).log();
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4104.methodEnd();
        }
    }

    public Dfp asinh() {
        MethodContext _bcornu_methode_context4105 = new MethodContext(Dfp.class, 2794, 82900, 83041);
        try {
            CallChecker.varInit(this, "this", 2794, 82900, 83041);
            CallChecker.varInit(this.field, "field", 2794, 82900, 83041);
            CallChecker.varInit(this.nans, "nans", 2794, 82900, 83041);
            CallChecker.varInit(this.exp, "exp", 2794, 82900, 83041);
            CallChecker.varInit(this.sign, "sign", 2794, 82900, 83041);
            CallChecker.varInit(this.mant, "mant", 2794, 82900, 83041);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2794, 82900, 83041);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2794, 82900, 83041);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2794, 82900, 83041);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2794, 82900, 83041);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2794, 82900, 83041);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2794, 82900, 83041);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2794, 82900, 83041);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2794, 82900, 83041);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2794, 82900, 83041);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2794, 82900, 83041);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2794, 82900, 83041);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2794, 82900, 83041);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2794, 82900, 83041);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2794, 82900, 83041);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2794, 82900, 83041);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2794, 82900, 83041);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2794, 82900, 83041);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2794, 82900, 83041);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2794, 82900, 83041);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2794, 82900, 83041);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2794, 82900, 83041);
            final Dfp npe_invocation_var866 = multiply(this);
            if (CallChecker.beforeDeref(npe_invocation_var866, Dfp.class, 2795, 82984, 82997)) {
                final Dfp npe_invocation_var867 = CallChecker.isCalled(npe_invocation_var866, Dfp.class, 2795, 82984, 82997).add(getOne());
                if (CallChecker.beforeDeref(npe_invocation_var867, Dfp.class, 2795, 82984, 83011)) {
                    final Dfp npe_invocation_var868 = CallChecker.isCalled(npe_invocation_var867, Dfp.class, 2795, 82984, 83011).sqrt();
                    if (CallChecker.beforeDeref(npe_invocation_var868, Dfp.class, 2795, 82984, 83018)) {
                        final Dfp npe_invocation_var869 = CallChecker.isCalled(npe_invocation_var868, Dfp.class, 2795, 82984, 83018).add(this);
                        if (CallChecker.beforeDeref(npe_invocation_var869, Dfp.class, 2795, 82984, 83028)) {
                            return CallChecker.isCalled(npe_invocation_var869, Dfp.class, 2795, 82984, 83028).log();
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4105.methodEnd();
        }
    }

    public Dfp atanh() {
        MethodContext _bcornu_methode_context4106 = new MethodContext(Dfp.class, 2801, 83048, 83204);
        try {
            CallChecker.varInit(this, "this", 2801, 83048, 83204);
            CallChecker.varInit(this.field, "field", 2801, 83048, 83204);
            CallChecker.varInit(this.nans, "nans", 2801, 83048, 83204);
            CallChecker.varInit(this.exp, "exp", 2801, 83048, 83204);
            CallChecker.varInit(this.sign, "sign", 2801, 83048, 83204);
            CallChecker.varInit(this.mant, "mant", 2801, 83048, 83204);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2801, 83048, 83204);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2801, 83048, 83204);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2801, 83048, 83204);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2801, 83048, 83204);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2801, 83048, 83204);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2801, 83048, 83204);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2801, 83048, 83204);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2801, 83048, 83204);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2801, 83048, 83204);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2801, 83048, 83204);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2801, 83048, 83204);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2801, 83048, 83204);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2801, 83048, 83204);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2801, 83048, 83204);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2801, 83048, 83204);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2801, 83048, 83204);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2801, 83048, 83204);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2801, 83048, 83204);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2801, 83048, 83204);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2801, 83048, 83204);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2801, 83048, 83204);
            final Dfp npe_invocation_var870 = getOne();
            if (CallChecker.beforeDeref(npe_invocation_var870, Dfp.class, 2802, 83132, 83139)) {
                final Dfp npe_invocation_var871 = getOne();
                if (CallChecker.beforeDeref(npe_invocation_var871, Dfp.class, 2802, 83158, 83165)) {
                    final Dfp npe_invocation_var872 = CallChecker.isCalled(npe_invocation_var870, Dfp.class, 2802, 83132, 83139).add(this);
                    if (CallChecker.beforeDeref(npe_invocation_var872, Dfp.class, 2802, 83132, 83149)) {
                        final Dfp npe_invocation_var873 = CallChecker.isCalled(npe_invocation_var872, Dfp.class, 2802, 83132, 83149).divide(CallChecker.isCalled(npe_invocation_var871, Dfp.class, 2802, 83158, 83165).subtract(this));
                        if (CallChecker.beforeDeref(npe_invocation_var873, Dfp.class, 2802, 83132, 83181)) {
                            final Dfp npe_invocation_var874 = CallChecker.isCalled(npe_invocation_var873, Dfp.class, 2802, 83132, 83181).log();
                            if (CallChecker.beforeDeref(npe_invocation_var874, Dfp.class, 2802, 83132, 83187)) {
                                return CallChecker.isCalled(npe_invocation_var874, Dfp.class, 2802, 83132, 83187).divide(2);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4106.methodEnd();
        }
    }

    public Dfp linearCombination(final Dfp[] a, final Dfp[] b) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4107 = new MethodContext(Dfp.class, 2808, 83211, 83626);
        try {
            CallChecker.varInit(this, "this", 2808, 83211, 83626);
            CallChecker.varInit(b, "b", 2808, 83211, 83626);
            CallChecker.varInit(a, "a", 2808, 83211, 83626);
            CallChecker.varInit(this.field, "field", 2808, 83211, 83626);
            CallChecker.varInit(this.nans, "nans", 2808, 83211, 83626);
            CallChecker.varInit(this.exp, "exp", 2808, 83211, 83626);
            CallChecker.varInit(this.sign, "sign", 2808, 83211, 83626);
            CallChecker.varInit(this.mant, "mant", 2808, 83211, 83626);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2808, 83211, 83626);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2808, 83211, 83626);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2808, 83211, 83626);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2808, 83211, 83626);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2808, 83211, 83626);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2808, 83211, 83626);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2808, 83211, 83626);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2808, 83211, 83626);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2808, 83211, 83626);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2808, 83211, 83626);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2808, 83211, 83626);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2808, 83211, 83626);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2808, 83211, 83626);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2808, 83211, 83626);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2808, 83211, 83626);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2808, 83211, 83626);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2808, 83211, 83626);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2808, 83211, 83626);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2808, 83211, 83626);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2808, 83211, 83626);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2808, 83211, 83626);
            if (CallChecker.beforeDeref(a, Dfp[].class, 2810, 83374, 83374)) {
                if (CallChecker.beforeDeref(b, Dfp[].class, 2810, 83386, 83386)) {
                    if ((CallChecker.isCalled(a, Dfp[].class, 2810, 83374, 83374).length) != (CallChecker.isCalled(b, Dfp[].class, 2810, 83386, 83386).length)) {
                        if (CallChecker.beforeDeref(a, Dfp[].class, 2811, 83447, 83447)) {
                            if (CallChecker.beforeDeref(b, Dfp[].class, 2811, 83457, 83457)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(a, Dfp[].class, 2811, 83447, 83447).length, CallChecker.isCalled(b, Dfp[].class, 2811, 83457, 83457).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            Dfp r = CallChecker.varInit(getZero(), "r", 2813, 83486, 83503);
            for (int i = 0; i < (CallChecker.isCalled(a, Dfp[].class, 2814, 83533, 83533).length); ++i) {
                if (CallChecker.beforeDeref(a, Dfp[].class, 2815, 83572, 83572)) {
                    if (CallChecker.beforeDeref(b, Dfp[].class, 2815, 83586, 83586)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 2815, 83572, 83572)[i], Dfp.class, 2815, 83572, 83575)) {
                            if (CallChecker.beforeDeref(r, Dfp.class, 2815, 83566, 83566)) {
                                CallChecker.isCalled(a, Dfp[].class, 2815, 83572, 83572)[i] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 2815, 83572, 83572)[i], Dfp.class, 2815, 83572, 83575);
                                r = CallChecker.beforeCalled(r, Dfp.class, 2815, 83566, 83566);
                                r = CallChecker.isCalled(r, Dfp.class, 2815, 83566, 83566).add(CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 2815, 83572, 83572)[i], Dfp.class, 2815, 83572, 83575).multiply(CallChecker.isCalled(b, Dfp[].class, 2815, 83586, 83586)[i]));
                                CallChecker.varAssign(r, "r", 2815, 83562, 83592);
                            }
                        }
                    }
                }
            }
            return r;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4107.methodEnd();
        }
    }

    public Dfp linearCombination(final double[] a, final Dfp[] b) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4108 = new MethodContext(Dfp.class, 2823, 83633, 84051);
        try {
            CallChecker.varInit(this, "this", 2823, 83633, 84051);
            CallChecker.varInit(b, "b", 2823, 83633, 84051);
            CallChecker.varInit(a, "a", 2823, 83633, 84051);
            CallChecker.varInit(this.field, "field", 2823, 83633, 84051);
            CallChecker.varInit(this.nans, "nans", 2823, 83633, 84051);
            CallChecker.varInit(this.exp, "exp", 2823, 83633, 84051);
            CallChecker.varInit(this.sign, "sign", 2823, 83633, 84051);
            CallChecker.varInit(this.mant, "mant", 2823, 83633, 84051);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2823, 83633, 84051);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2823, 83633, 84051);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2823, 83633, 84051);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2823, 83633, 84051);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2823, 83633, 84051);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2823, 83633, 84051);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2823, 83633, 84051);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2823, 83633, 84051);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2823, 83633, 84051);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2823, 83633, 84051);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2823, 83633, 84051);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2823, 83633, 84051);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2823, 83633, 84051);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2823, 83633, 84051);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2823, 83633, 84051);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2823, 83633, 84051);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2823, 83633, 84051);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2823, 83633, 84051);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2823, 83633, 84051);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2823, 83633, 84051);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2823, 83633, 84051);
            if (CallChecker.beforeDeref(a, double[].class, 2825, 83799, 83799)) {
                if (CallChecker.beforeDeref(b, Dfp[].class, 2825, 83811, 83811)) {
                    if ((CallChecker.isCalled(a, double[].class, 2825, 83799, 83799).length) != (CallChecker.isCalled(b, Dfp[].class, 2825, 83811, 83811).length)) {
                        if (CallChecker.beforeDeref(a, double[].class, 2826, 83872, 83872)) {
                            if (CallChecker.beforeDeref(b, Dfp[].class, 2826, 83882, 83882)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(a, double[].class, 2826, 83872, 83872).length, CallChecker.isCalled(b, Dfp[].class, 2826, 83882, 83882).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            Dfp r = CallChecker.varInit(getZero(), "r", 2828, 83911, 83928);
            for (int i = 0; i < (CallChecker.isCalled(a, double[].class, 2829, 83958, 83958).length); ++i) {
                if (CallChecker.beforeDeref(b, Dfp[].class, 2830, 83997, 83997)) {
                    if (CallChecker.beforeDeref(a, double[].class, 2830, 84011, 84011)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(b, Dfp[].class, 2830, 83997, 83997)[i], Dfp.class, 2830, 83997, 84000)) {
                            if (CallChecker.beforeDeref(r, Dfp.class, 2830, 83991, 83991)) {
                                CallChecker.isCalled(b, Dfp[].class, 2830, 83997, 83997)[i] = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp[].class, 2830, 83997, 83997)[i], Dfp.class, 2830, 83997, 84000);
                                r = CallChecker.beforeCalled(r, Dfp.class, 2830, 83991, 83991);
                                r = CallChecker.isCalled(r, Dfp.class, 2830, 83991, 83991).add(CallChecker.isCalled(CallChecker.isCalled(b, Dfp[].class, 2830, 83997, 83997)[i], Dfp.class, 2830, 83997, 84000).multiply(CallChecker.isCalled(a, double[].class, 2830, 84011, 84011)[i]));
                                CallChecker.varAssign(r, "r", 2830, 83987, 84017);
                            }
                        }
                    }
                }
            }
            return r;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4108.methodEnd();
        }
    }

    public Dfp linearCombination(final Dfp a1, final Dfp b1, final Dfp a2, final Dfp b2) {
        MethodContext _bcornu_methode_context4109 = new MethodContext(Dfp.class, 2838, 84058, 84250);
        try {
            CallChecker.varInit(this, "this", 2838, 84058, 84250);
            CallChecker.varInit(b2, "b2", 2838, 84058, 84250);
            CallChecker.varInit(a2, "a2", 2838, 84058, 84250);
            CallChecker.varInit(b1, "b1", 2838, 84058, 84250);
            CallChecker.varInit(a1, "a1", 2838, 84058, 84250);
            CallChecker.varInit(this.field, "field", 2838, 84058, 84250);
            CallChecker.varInit(this.nans, "nans", 2838, 84058, 84250);
            CallChecker.varInit(this.exp, "exp", 2838, 84058, 84250);
            CallChecker.varInit(this.sign, "sign", 2838, 84058, 84250);
            CallChecker.varInit(this.mant, "mant", 2838, 84058, 84250);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2838, 84058, 84250);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2838, 84058, 84250);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2838, 84058, 84250);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2838, 84058, 84250);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2838, 84058, 84250);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2838, 84058, 84250);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2838, 84058, 84250);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2838, 84058, 84250);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2838, 84058, 84250);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2838, 84058, 84250);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2838, 84058, 84250);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2838, 84058, 84250);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2838, 84058, 84250);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2838, 84058, 84250);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2838, 84058, 84250);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2838, 84058, 84250);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2838, 84058, 84250);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2838, 84058, 84250);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2838, 84058, 84250);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2838, 84058, 84250);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2838, 84058, 84250);
            if (CallChecker.beforeDeref(a1, Dfp.class, 2839, 84208, 84209)) {
                if (CallChecker.beforeDeref(a2, Dfp.class, 2839, 84228, 84229)) {
                    final Dfp npe_invocation_var875 = CallChecker.isCalled(a1, Dfp.class, 2839, 84208, 84209).multiply(b1);
                    if (CallChecker.beforeDeref(npe_invocation_var875, Dfp.class, 2839, 84208, 84222)) {
                        return CallChecker.isCalled(npe_invocation_var875, Dfp.class, 2839, 84208, 84222).add(CallChecker.isCalled(a2, Dfp.class, 2839, 84228, 84229).multiply(b2));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4109.methodEnd();
        }
    }

    public Dfp linearCombination(final double a1, final Dfp b1, final double a2, final Dfp b2) {
        MethodContext _bcornu_methode_context4110 = new MethodContext(Dfp.class, 2845, 84257, 84455);
        try {
            CallChecker.varInit(this, "this", 2845, 84257, 84455);
            CallChecker.varInit(b2, "b2", 2845, 84257, 84455);
            CallChecker.varInit(a2, "a2", 2845, 84257, 84455);
            CallChecker.varInit(b1, "b1", 2845, 84257, 84455);
            CallChecker.varInit(a1, "a1", 2845, 84257, 84455);
            CallChecker.varInit(this.field, "field", 2845, 84257, 84455);
            CallChecker.varInit(this.nans, "nans", 2845, 84257, 84455);
            CallChecker.varInit(this.exp, "exp", 2845, 84257, 84455);
            CallChecker.varInit(this.sign, "sign", 2845, 84257, 84455);
            CallChecker.varInit(this.mant, "mant", 2845, 84257, 84455);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2845, 84257, 84455);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2845, 84257, 84455);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2845, 84257, 84455);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2845, 84257, 84455);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2845, 84257, 84455);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2845, 84257, 84455);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2845, 84257, 84455);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2845, 84257, 84455);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2845, 84257, 84455);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2845, 84257, 84455);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2845, 84257, 84455);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2845, 84257, 84455);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2845, 84257, 84455);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2845, 84257, 84455);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2845, 84257, 84455);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2845, 84257, 84455);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2845, 84257, 84455);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2845, 84257, 84455);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2845, 84257, 84455);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2845, 84257, 84455);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2845, 84257, 84455);
            if (CallChecker.beforeDeref(b1, Dfp.class, 2846, 84413, 84414)) {
                if (CallChecker.beforeDeref(b2, Dfp.class, 2846, 84433, 84434)) {
                    final Dfp npe_invocation_var876 = CallChecker.isCalled(b1, Dfp.class, 2846, 84413, 84414).multiply(a1);
                    if (CallChecker.beforeDeref(npe_invocation_var876, Dfp.class, 2846, 84413, 84427)) {
                        return CallChecker.isCalled(npe_invocation_var876, Dfp.class, 2846, 84413, 84427).add(CallChecker.isCalled(b2, Dfp.class, 2846, 84433, 84434).multiply(a2));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4110.methodEnd();
        }
    }

    public Dfp linearCombination(final Dfp a1, final Dfp b1, final Dfp a2, final Dfp b2, final Dfp a3, final Dfp b3) {
        MethodContext _bcornu_methode_context4111 = new MethodContext(Dfp.class, 2852, 84462, 84769);
        try {
            CallChecker.varInit(this, "this", 2852, 84462, 84769);
            CallChecker.varInit(b3, "b3", 2852, 84462, 84769);
            CallChecker.varInit(a3, "a3", 2852, 84462, 84769);
            CallChecker.varInit(b2, "b2", 2852, 84462, 84769);
            CallChecker.varInit(a2, "a2", 2852, 84462, 84769);
            CallChecker.varInit(b1, "b1", 2852, 84462, 84769);
            CallChecker.varInit(a1, "a1", 2852, 84462, 84769);
            CallChecker.varInit(this.field, "field", 2852, 84462, 84769);
            CallChecker.varInit(this.nans, "nans", 2852, 84462, 84769);
            CallChecker.varInit(this.exp, "exp", 2852, 84462, 84769);
            CallChecker.varInit(this.sign, "sign", 2852, 84462, 84769);
            CallChecker.varInit(this.mant, "mant", 2852, 84462, 84769);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2852, 84462, 84769);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2852, 84462, 84769);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2852, 84462, 84769);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2852, 84462, 84769);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2852, 84462, 84769);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2852, 84462, 84769);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2852, 84462, 84769);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2852, 84462, 84769);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2852, 84462, 84769);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2852, 84462, 84769);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2852, 84462, 84769);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2852, 84462, 84769);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2852, 84462, 84769);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2852, 84462, 84769);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2852, 84462, 84769);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2852, 84462, 84769);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2852, 84462, 84769);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2852, 84462, 84769);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2852, 84462, 84769);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2852, 84462, 84769);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2852, 84462, 84769);
            if (CallChecker.beforeDeref(a1, Dfp.class, 2855, 84706, 84707)) {
                if (CallChecker.beforeDeref(a2, Dfp.class, 2855, 84726, 84727)) {
                    final Dfp npe_invocation_var877 = CallChecker.isCalled(a1, Dfp.class, 2855, 84706, 84707).multiply(b1);
                    if (CallChecker.beforeDeref(npe_invocation_var877, Dfp.class, 2855, 84706, 84720)) {
                        if (CallChecker.beforeDeref(a3, Dfp.class, 2855, 84747, 84748)) {
                            final Dfp npe_invocation_var878 = CallChecker.isCalled(npe_invocation_var877, Dfp.class, 2855, 84706, 84720).add(CallChecker.isCalled(a2, Dfp.class, 2855, 84726, 84727).multiply(b2));
                            if (CallChecker.beforeDeref(npe_invocation_var878, Dfp.class, 2855, 84706, 84741)) {
                                return CallChecker.isCalled(npe_invocation_var878, Dfp.class, 2855, 84706, 84741).add(CallChecker.isCalled(a3, Dfp.class, 2855, 84747, 84748).multiply(b3));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4111.methodEnd();
        }
    }

    public Dfp linearCombination(final double a1, final Dfp b1, final double a2, final Dfp b2, final double a3, final Dfp b3) {
        MethodContext _bcornu_methode_context4112 = new MethodContext(Dfp.class, 2861, 84776, 85092);
        try {
            CallChecker.varInit(this, "this", 2861, 84776, 85092);
            CallChecker.varInit(b3, "b3", 2861, 84776, 85092);
            CallChecker.varInit(a3, "a3", 2861, 84776, 85092);
            CallChecker.varInit(b2, "b2", 2861, 84776, 85092);
            CallChecker.varInit(a2, "a2", 2861, 84776, 85092);
            CallChecker.varInit(b1, "b1", 2861, 84776, 85092);
            CallChecker.varInit(a1, "a1", 2861, 84776, 85092);
            CallChecker.varInit(this.field, "field", 2861, 84776, 85092);
            CallChecker.varInit(this.nans, "nans", 2861, 84776, 85092);
            CallChecker.varInit(this.exp, "exp", 2861, 84776, 85092);
            CallChecker.varInit(this.sign, "sign", 2861, 84776, 85092);
            CallChecker.varInit(this.mant, "mant", 2861, 84776, 85092);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2861, 84776, 85092);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2861, 84776, 85092);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2861, 84776, 85092);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2861, 84776, 85092);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2861, 84776, 85092);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2861, 84776, 85092);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2861, 84776, 85092);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2861, 84776, 85092);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2861, 84776, 85092);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2861, 84776, 85092);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2861, 84776, 85092);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2861, 84776, 85092);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2861, 84776, 85092);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2861, 84776, 85092);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2861, 84776, 85092);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2861, 84776, 85092);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2861, 84776, 85092);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2861, 84776, 85092);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2861, 84776, 85092);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2861, 84776, 85092);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2861, 84776, 85092);
            if (CallChecker.beforeDeref(b1, Dfp.class, 2864, 85029, 85030)) {
                if (CallChecker.beforeDeref(b2, Dfp.class, 2864, 85049, 85050)) {
                    final Dfp npe_invocation_var879 = CallChecker.isCalled(b1, Dfp.class, 2864, 85029, 85030).multiply(a1);
                    if (CallChecker.beforeDeref(npe_invocation_var879, Dfp.class, 2864, 85029, 85043)) {
                        if (CallChecker.beforeDeref(b3, Dfp.class, 2864, 85070, 85071)) {
                            final Dfp npe_invocation_var880 = CallChecker.isCalled(npe_invocation_var879, Dfp.class, 2864, 85029, 85043).add(CallChecker.isCalled(b2, Dfp.class, 2864, 85049, 85050).multiply(a2));
                            if (CallChecker.beforeDeref(npe_invocation_var880, Dfp.class, 2864, 85029, 85064)) {
                                return CallChecker.isCalled(npe_invocation_var880, Dfp.class, 2864, 85029, 85064).add(CallChecker.isCalled(b3, Dfp.class, 2864, 85070, 85071).multiply(a3));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4112.methodEnd();
        }
    }

    public Dfp linearCombination(final Dfp a1, final Dfp b1, final Dfp a2, final Dfp b2, final Dfp a3, final Dfp b3, final Dfp a4, final Dfp b4) {
        MethodContext _bcornu_methode_context4113 = new MethodContext(Dfp.class, 2870, 85099, 85422);
        try {
            CallChecker.varInit(this, "this", 2870, 85099, 85422);
            CallChecker.varInit(b4, "b4", 2870, 85099, 85422);
            CallChecker.varInit(a4, "a4", 2870, 85099, 85422);
            CallChecker.varInit(b3, "b3", 2870, 85099, 85422);
            CallChecker.varInit(a3, "a3", 2870, 85099, 85422);
            CallChecker.varInit(b2, "b2", 2870, 85099, 85422);
            CallChecker.varInit(a2, "a2", 2870, 85099, 85422);
            CallChecker.varInit(b1, "b1", 2870, 85099, 85422);
            CallChecker.varInit(a1, "a1", 2870, 85099, 85422);
            CallChecker.varInit(this.field, "field", 2870, 85099, 85422);
            CallChecker.varInit(this.nans, "nans", 2870, 85099, 85422);
            CallChecker.varInit(this.exp, "exp", 2870, 85099, 85422);
            CallChecker.varInit(this.sign, "sign", 2870, 85099, 85422);
            CallChecker.varInit(this.mant, "mant", 2870, 85099, 85422);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2870, 85099, 85422);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2870, 85099, 85422);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2870, 85099, 85422);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2870, 85099, 85422);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2870, 85099, 85422);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2870, 85099, 85422);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2870, 85099, 85422);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2870, 85099, 85422);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2870, 85099, 85422);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2870, 85099, 85422);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2870, 85099, 85422);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2870, 85099, 85422);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2870, 85099, 85422);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2870, 85099, 85422);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2870, 85099, 85422);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2870, 85099, 85422);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2870, 85099, 85422);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2870, 85099, 85422);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2870, 85099, 85422);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2870, 85099, 85422);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2870, 85099, 85422);
            if (CallChecker.beforeDeref(a1, Dfp.class, 2872, 85338, 85339)) {
                if (CallChecker.beforeDeref(a2, Dfp.class, 2872, 85358, 85359)) {
                    final Dfp npe_invocation_var881 = CallChecker.isCalled(a1, Dfp.class, 2872, 85338, 85339).multiply(b1);
                    if (CallChecker.beforeDeref(npe_invocation_var881, Dfp.class, 2872, 85338, 85352)) {
                        if (CallChecker.beforeDeref(a3, Dfp.class, 2872, 85379, 85380)) {
                            final Dfp npe_invocation_var882 = CallChecker.isCalled(npe_invocation_var881, Dfp.class, 2872, 85338, 85352).add(CallChecker.isCalled(a2, Dfp.class, 2872, 85358, 85359).multiply(b2));
                            if (CallChecker.beforeDeref(npe_invocation_var882, Dfp.class, 2872, 85338, 85373)) {
                                if (CallChecker.beforeDeref(a4, Dfp.class, 2872, 85400, 85401)) {
                                    final Dfp npe_invocation_var883 = CallChecker.isCalled(npe_invocation_var882, Dfp.class, 2872, 85338, 85373).add(CallChecker.isCalled(a3, Dfp.class, 2872, 85379, 85380).multiply(b3));
                                    if (CallChecker.beforeDeref(npe_invocation_var883, Dfp.class, 2872, 85338, 85394)) {
                                        return CallChecker.isCalled(npe_invocation_var883, Dfp.class, 2872, 85338, 85394).add(CallChecker.isCalled(a4, Dfp.class, 2872, 85400, 85401).multiply(b4));
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4113.methodEnd();
        }
    }

    public Dfp linearCombination(final double a1, final Dfp b1, final double a2, final Dfp b2, final double a3, final Dfp b3, final double a4, final Dfp b4) {
        MethodContext _bcornu_methode_context4114 = new MethodContext(Dfp.class, 2878, 85429, 85764);
        try {
            CallChecker.varInit(this, "this", 2878, 85429, 85764);
            CallChecker.varInit(b4, "b4", 2878, 85429, 85764);
            CallChecker.varInit(a4, "a4", 2878, 85429, 85764);
            CallChecker.varInit(b3, "b3", 2878, 85429, 85764);
            CallChecker.varInit(a3, "a3", 2878, 85429, 85764);
            CallChecker.varInit(b2, "b2", 2878, 85429, 85764);
            CallChecker.varInit(a2, "a2", 2878, 85429, 85764);
            CallChecker.varInit(b1, "b1", 2878, 85429, 85764);
            CallChecker.varInit(a1, "a1", 2878, 85429, 85764);
            CallChecker.varInit(this.field, "field", 2878, 85429, 85764);
            CallChecker.varInit(this.nans, "nans", 2878, 85429, 85764);
            CallChecker.varInit(this.exp, "exp", 2878, 85429, 85764);
            CallChecker.varInit(this.sign, "sign", 2878, 85429, 85764);
            CallChecker.varInit(this.mant, "mant", 2878, 85429, 85764);
            CallChecker.varInit(NEW_INSTANCE_TRAP, "org.apache.commons.math3.dfp.Dfp.NEW_INSTANCE_TRAP", 2878, 85429, 85764);
            CallChecker.varInit(GREATER_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.GREATER_THAN_TRAP", 2878, 85429, 85764);
            CallChecker.varInit(LESS_THAN_TRAP, "org.apache.commons.math3.dfp.Dfp.LESS_THAN_TRAP", 2878, 85429, 85764);
            CallChecker.varInit(NEXT_AFTER_TRAP, "org.apache.commons.math3.dfp.Dfp.NEXT_AFTER_TRAP", 2878, 85429, 85764);
            CallChecker.varInit(TRUNC_TRAP, "org.apache.commons.math3.dfp.Dfp.TRUNC_TRAP", 2878, 85429, 85764);
            CallChecker.varInit(ALIGN_TRAP, "org.apache.commons.math3.dfp.Dfp.ALIGN_TRAP", 2878, 85429, 85764);
            CallChecker.varInit(SQRT_TRAP, "org.apache.commons.math3.dfp.Dfp.SQRT_TRAP", 2878, 85429, 85764);
            CallChecker.varInit(DIVIDE_TRAP, "org.apache.commons.math3.dfp.Dfp.DIVIDE_TRAP", 2878, 85429, 85764);
            CallChecker.varInit(MULTIPLY_TRAP, "org.apache.commons.math3.dfp.Dfp.MULTIPLY_TRAP", 2878, 85429, 85764);
            CallChecker.varInit(ADD_TRAP, "org.apache.commons.math3.dfp.Dfp.ADD_TRAP", 2878, 85429, 85764);
            CallChecker.varInit(NEG_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.NEG_INFINITY_STRING", 2878, 85429, 85764);
            CallChecker.varInit(POS_INFINITY_STRING, "org.apache.commons.math3.dfp.Dfp.POS_INFINITY_STRING", 2878, 85429, 85764);
            CallChecker.varInit(NAN_STRING, "org.apache.commons.math3.dfp.Dfp.NAN_STRING", 2878, 85429, 85764);
            CallChecker.varInit(QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 2878, 85429, 85764);
            CallChecker.varInit(SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 2878, 85429, 85764);
            CallChecker.varInit(INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 2878, 85429, 85764);
            CallChecker.varInit(FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 2878, 85429, 85764);
            CallChecker.varInit(ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 2878, 85429, 85764);
            CallChecker.varInit(MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 2878, 85429, 85764);
            CallChecker.varInit(MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 2878, 85429, 85764);
            CallChecker.varInit(RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 2878, 85429, 85764);
            if (CallChecker.beforeDeref(b1, Dfp.class, 2880, 85680, 85681)) {
                if (CallChecker.beforeDeref(b2, Dfp.class, 2880, 85700, 85701)) {
                    final Dfp npe_invocation_var884 = CallChecker.isCalled(b1, Dfp.class, 2880, 85680, 85681).multiply(a1);
                    if (CallChecker.beforeDeref(npe_invocation_var884, Dfp.class, 2880, 85680, 85694)) {
                        if (CallChecker.beforeDeref(b3, Dfp.class, 2880, 85721, 85722)) {
                            final Dfp npe_invocation_var885 = CallChecker.isCalled(npe_invocation_var884, Dfp.class, 2880, 85680, 85694).add(CallChecker.isCalled(b2, Dfp.class, 2880, 85700, 85701).multiply(a2));
                            if (CallChecker.beforeDeref(npe_invocation_var885, Dfp.class, 2880, 85680, 85715)) {
                                if (CallChecker.beforeDeref(b4, Dfp.class, 2880, 85742, 85743)) {
                                    final Dfp npe_invocation_var886 = CallChecker.isCalled(npe_invocation_var885, Dfp.class, 2880, 85680, 85715).add(CallChecker.isCalled(b3, Dfp.class, 2880, 85721, 85722).multiply(a3));
                                    if (CallChecker.beforeDeref(npe_invocation_var886, Dfp.class, 2880, 85680, 85736)) {
                                        return CallChecker.isCalled(npe_invocation_var886, Dfp.class, 2880, 85680, 85736).add(CallChecker.isCalled(b4, Dfp.class, 2880, 85742, 85743).multiply(a4));
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4114.methodEnd();
        }
    }
}

