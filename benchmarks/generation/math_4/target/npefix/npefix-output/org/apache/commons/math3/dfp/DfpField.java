package org.apache.commons.math3.dfp;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

public class DfpField implements Field<Dfp> {
    public enum RoundingMode {
ROUND_DOWN, ROUND_UP, ROUND_HALF_UP, ROUND_HALF_DOWN, ROUND_HALF_EVEN, ROUND_HALF_ODD, ROUND_CEIL, ROUND_FLOOR;    }

    public static final int FLAG_INVALID = 1;

    public static final int FLAG_DIV_ZERO = 2;

    public static final int FLAG_OVERFLOW = 4;

    public static final int FLAG_UNDERFLOW = 8;

    public static final int FLAG_INEXACT = 16;

    private static String sqr2String;

    private static String sqr2ReciprocalString;

    private static String sqr3String;

    private static String sqr3ReciprocalString;

    private static String piString;

    private static String eString;

    private static String ln2String;

    private static String ln5String;

    private static String ln10String;

    private final int radixDigits;

    private final Dfp zero;

    private final Dfp one;

    private final Dfp two;

    private final Dfp sqr2;

    private final Dfp[] sqr2Split;

    private final Dfp sqr2Reciprocal;

    private final Dfp sqr3;

    private final Dfp sqr3Reciprocal;

    private final Dfp pi;

    private final Dfp[] piSplit;

    private final Dfp e;

    private final Dfp[] eSplit;

    private final Dfp ln2;

    private final Dfp[] ln2Split;

    private final Dfp ln5;

    private final Dfp[] ln5Split;

    private final Dfp ln10;

    private DfpField.RoundingMode rMode;

    private int ieeeFlags;

    public DfpField(final int decimalDigits) {
        this(decimalDigits, true);
        ConstructorContext _bcornu_methode_context1054 = new ConstructorContext(DfpField.class, 176, 5330, 5833);
        try {
        } finally {
            _bcornu_methode_context1054.methodEnd();
        }
    }

    private DfpField(final int decimalDigits, final boolean computeConstants) {
        ConstructorContext _bcornu_methode_context1055 = new ConstructorContext(DfpField.class, 191, 5840, 8845);
        try {
            if (decimalDigits < 13) {
                this.radixDigits = 4;
                CallChecker.varAssign(this.radixDigits, "this.radixDigits", 193, 6535, 6604);
            }else {
                this.radixDigits = (decimalDigits + 3) / 4;
                CallChecker.varAssign(this.radixDigits, "this.radixDigits", 193, 6535, 6604);
            }
            this.rMode = DfpField.RoundingMode.ROUND_HALF_EVEN;
            CallChecker.varAssign(this.rMode, "this.rMode", 194, 6614, 6661);
            this.ieeeFlags = 0;
            CallChecker.varAssign(this.ieeeFlags, "this.ieeeFlags", 195, 6671, 6691);
            this.zero = new Dfp(this, 0);
            CallChecker.varAssign(this.zero, "this.zero", 196, 6701, 6736);
            this.one = new Dfp(this, 1);
            CallChecker.varAssign(this.one, "this.one", 197, 6746, 6781);
            this.two = new Dfp(this, 2);
            CallChecker.varAssign(this.two, "this.two", 198, 6791, 6826);
            if (computeConstants) {
                synchronized(DfpField.class) {
                    if (decimalDigits < 67) {
                        DfpField.computeStringConstants(200);
                    }else {
                        DfpField.computeStringConstants((3 * decimalDigits));
                    }
                    sqr2 = new Dfp(this, DfpField.sqr2String);
                    CallChecker.varAssign(this.sqr2, "this.sqr2", 211, 7467, 7509);
                    sqr2Split = split(DfpField.sqr2String);
                    CallChecker.varAssign(this.sqr2Split, "this.sqr2Split", 212, 7527, 7561);
                    sqr2Reciprocal = new Dfp(this, DfpField.sqr2ReciprocalString);
                    CallChecker.varAssign(this.sqr2Reciprocal, "this.sqr2Reciprocal", 213, 7579, 7631);
                    sqr3 = new Dfp(this, DfpField.sqr3String);
                    CallChecker.varAssign(this.sqr3, "this.sqr3", 214, 7649, 7691);
                    sqr3Reciprocal = new Dfp(this, DfpField.sqr3ReciprocalString);
                    CallChecker.varAssign(this.sqr3Reciprocal, "this.sqr3Reciprocal", 215, 7709, 7761);
                    pi = new Dfp(this, DfpField.piString);
                    CallChecker.varAssign(this.pi, "this.pi", 216, 7779, 7819);
                    piSplit = split(DfpField.piString);
                    CallChecker.varAssign(this.piSplit, "this.piSplit", 217, 7837, 7869);
                    e = new Dfp(this, DfpField.eString);
                    CallChecker.varAssign(this.e, "this.e", 218, 7887, 7926);
                    eSplit = split(DfpField.eString);
                    CallChecker.varAssign(this.eSplit, "this.eSplit", 219, 7944, 7975);
                    ln2 = new Dfp(this, DfpField.ln2String);
                    CallChecker.varAssign(this.ln2, "this.ln2", 220, 7993, 8034);
                    ln2Split = split(DfpField.ln2String);
                    CallChecker.varAssign(this.ln2Split, "this.ln2Split", 221, 8052, 8085);
                    ln5 = new Dfp(this, DfpField.ln5String);
                    CallChecker.varAssign(this.ln5, "this.ln5", 222, 8103, 8144);
                    ln5Split = split(DfpField.ln5String);
                    CallChecker.varAssign(this.ln5Split, "this.ln5Split", 223, 8162, 8195);
                    ln10 = new Dfp(this, DfpField.ln10String);
                    CallChecker.varAssign(this.ln10, "this.ln10", 224, 8213, 8255);
                }
            }else {
                sqr2 = null;
                CallChecker.varAssign(this.sqr2, "this.sqr2", 229, 8352, 8373);
                sqr2Split = null;
                CallChecker.varAssign(this.sqr2Split, "this.sqr2Split", 230, 8387, 8408);
                sqr2Reciprocal = null;
                CallChecker.varAssign(this.sqr2Reciprocal, "this.sqr2Reciprocal", 231, 8422, 8443);
                sqr3 = null;
                CallChecker.varAssign(this.sqr3, "this.sqr3", 232, 8457, 8478);
                sqr3Reciprocal = null;
                CallChecker.varAssign(this.sqr3Reciprocal, "this.sqr3Reciprocal", 233, 8492, 8513);
                pi = null;
                CallChecker.varAssign(this.pi, "this.pi", 234, 8527, 8548);
                piSplit = null;
                CallChecker.varAssign(this.piSplit, "this.piSplit", 235, 8562, 8583);
                e = null;
                CallChecker.varAssign(this.e, "this.e", 236, 8597, 8618);
                eSplit = null;
                CallChecker.varAssign(this.eSplit, "this.eSplit", 237, 8632, 8653);
                ln2 = null;
                CallChecker.varAssign(this.ln2, "this.ln2", 238, 8667, 8688);
                ln2Split = null;
                CallChecker.varAssign(this.ln2Split, "this.ln2Split", 239, 8702, 8723);
                ln5 = null;
                CallChecker.varAssign(this.ln5, "this.ln5", 240, 8737, 8758);
                ln5Split = null;
                CallChecker.varAssign(this.ln5Split, "this.ln5Split", 241, 8772, 8793);
                ln10 = null;
                CallChecker.varAssign(this.ln10, "this.ln10", 242, 8807, 8828);
            }
        } finally {
            _bcornu_methode_context1055.methodEnd();
        }
    }

    public int getRadixDigits() {
        MethodContext _bcornu_methode_context4646 = new MethodContext(int.class, 250, 8852, 9051);
        try {
            CallChecker.varInit(this, "this", 250, 8852, 9051);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 250, 8852, 9051);
            CallChecker.varInit(this.rMode, "rMode", 250, 8852, 9051);
            CallChecker.varInit(this.ln10, "ln10", 250, 8852, 9051);
            CallChecker.varInit(this.ln5Split, "ln5Split", 250, 8852, 9051);
            CallChecker.varInit(this.ln5, "ln5", 250, 8852, 9051);
            CallChecker.varInit(this.ln2Split, "ln2Split", 250, 8852, 9051);
            CallChecker.varInit(this.ln2, "ln2", 250, 8852, 9051);
            CallChecker.varInit(this.eSplit, "eSplit", 250, 8852, 9051);
            CallChecker.varInit(this.e, "e", 250, 8852, 9051);
            CallChecker.varInit(this.piSplit, "piSplit", 250, 8852, 9051);
            CallChecker.varInit(this.pi, "pi", 250, 8852, 9051);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 250, 8852, 9051);
            CallChecker.varInit(this.sqr3, "sqr3", 250, 8852, 9051);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 250, 8852, 9051);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 250, 8852, 9051);
            CallChecker.varInit(this.sqr2, "sqr2", 250, 8852, 9051);
            CallChecker.varInit(this.two, "two", 250, 8852, 9051);
            CallChecker.varInit(this.one, "one", 250, 8852, 9051);
            CallChecker.varInit(this.zero, "zero", 250, 8852, 9051);
            CallChecker.varInit(this.radixDigits, "radixDigits", 250, 8852, 9051);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 250, 8852, 9051);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 250, 8852, 9051);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 250, 8852, 9051);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 250, 8852, 9051);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 250, 8852, 9051);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 250, 8852, 9051);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 250, 8852, 9051);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 250, 8852, 9051);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 250, 8852, 9051);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 250, 8852, 9051);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 250, 8852, 9051);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 250, 8852, 9051);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 250, 8852, 9051);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 250, 8852, 9051);
            return radixDigits;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4646.methodEnd();
        }
    }

    public void setRoundingMode(final DfpField.RoundingMode mode) {
        MethodContext _bcornu_methode_context4647 = new MethodContext(void.class, 261, 9058, 9483);
        try {
            CallChecker.varInit(this, "this", 261, 9058, 9483);
            CallChecker.varInit(mode, "mode", 261, 9058, 9483);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 261, 9058, 9483);
            CallChecker.varInit(this.rMode, "rMode", 261, 9058, 9483);
            CallChecker.varInit(this.ln10, "ln10", 261, 9058, 9483);
            CallChecker.varInit(this.ln5Split, "ln5Split", 261, 9058, 9483);
            CallChecker.varInit(this.ln5, "ln5", 261, 9058, 9483);
            CallChecker.varInit(this.ln2Split, "ln2Split", 261, 9058, 9483);
            CallChecker.varInit(this.ln2, "ln2", 261, 9058, 9483);
            CallChecker.varInit(this.eSplit, "eSplit", 261, 9058, 9483);
            CallChecker.varInit(this.e, "e", 261, 9058, 9483);
            CallChecker.varInit(this.piSplit, "piSplit", 261, 9058, 9483);
            CallChecker.varInit(this.pi, "pi", 261, 9058, 9483);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 261, 9058, 9483);
            CallChecker.varInit(this.sqr3, "sqr3", 261, 9058, 9483);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 261, 9058, 9483);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 261, 9058, 9483);
            CallChecker.varInit(this.sqr2, "sqr2", 261, 9058, 9483);
            CallChecker.varInit(this.two, "two", 261, 9058, 9483);
            CallChecker.varInit(this.one, "one", 261, 9058, 9483);
            CallChecker.varInit(this.zero, "zero", 261, 9058, 9483);
            CallChecker.varInit(this.radixDigits, "radixDigits", 261, 9058, 9483);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 261, 9058, 9483);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 261, 9058, 9483);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 261, 9058, 9483);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 261, 9058, 9483);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 261, 9058, 9483);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 261, 9058, 9483);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 261, 9058, 9483);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 261, 9058, 9483);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 261, 9058, 9483);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 261, 9058, 9483);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 261, 9058, 9483);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 261, 9058, 9483);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 261, 9058, 9483);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 261, 9058, 9483);
            rMode = mode;
            CallChecker.varAssign(this.rMode, "this.rMode", 262, 9465, 9477);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4647.methodEnd();
        }
    }

    public DfpField.RoundingMode getRoundingMode() {
        MethodContext _bcornu_methode_context4648 = new MethodContext(DfpField.RoundingMode.class, 268, 9490, 9640);
        try {
            CallChecker.varInit(this, "this", 268, 9490, 9640);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 268, 9490, 9640);
            CallChecker.varInit(this.rMode, "rMode", 268, 9490, 9640);
            CallChecker.varInit(this.ln10, "ln10", 268, 9490, 9640);
            CallChecker.varInit(this.ln5Split, "ln5Split", 268, 9490, 9640);
            CallChecker.varInit(this.ln5, "ln5", 268, 9490, 9640);
            CallChecker.varInit(this.ln2Split, "ln2Split", 268, 9490, 9640);
            CallChecker.varInit(this.ln2, "ln2", 268, 9490, 9640);
            CallChecker.varInit(this.eSplit, "eSplit", 268, 9490, 9640);
            CallChecker.varInit(this.e, "e", 268, 9490, 9640);
            CallChecker.varInit(this.piSplit, "piSplit", 268, 9490, 9640);
            CallChecker.varInit(this.pi, "pi", 268, 9490, 9640);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 268, 9490, 9640);
            CallChecker.varInit(this.sqr3, "sqr3", 268, 9490, 9640);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 268, 9490, 9640);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 268, 9490, 9640);
            CallChecker.varInit(this.sqr2, "sqr2", 268, 9490, 9640);
            CallChecker.varInit(this.two, "two", 268, 9490, 9640);
            CallChecker.varInit(this.one, "one", 268, 9490, 9640);
            CallChecker.varInit(this.zero, "zero", 268, 9490, 9640);
            CallChecker.varInit(this.radixDigits, "radixDigits", 268, 9490, 9640);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 268, 9490, 9640);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 268, 9490, 9640);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 268, 9490, 9640);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 268, 9490, 9640);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 268, 9490, 9640);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 268, 9490, 9640);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 268, 9490, 9640);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 268, 9490, 9640);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 268, 9490, 9640);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 268, 9490, 9640);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 268, 9490, 9640);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 268, 9490, 9640);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 268, 9490, 9640);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 268, 9490, 9640);
            return rMode;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DfpField.RoundingMode) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4648.methodEnd();
        }
    }

    public int getIEEEFlags() {
        MethodContext _bcornu_methode_context4649 = new MethodContext(int.class, 283, 9647, 10019);
        try {
            CallChecker.varInit(this, "this", 283, 9647, 10019);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 283, 9647, 10019);
            CallChecker.varInit(this.rMode, "rMode", 283, 9647, 10019);
            CallChecker.varInit(this.ln10, "ln10", 283, 9647, 10019);
            CallChecker.varInit(this.ln5Split, "ln5Split", 283, 9647, 10019);
            CallChecker.varInit(this.ln5, "ln5", 283, 9647, 10019);
            CallChecker.varInit(this.ln2Split, "ln2Split", 283, 9647, 10019);
            CallChecker.varInit(this.ln2, "ln2", 283, 9647, 10019);
            CallChecker.varInit(this.eSplit, "eSplit", 283, 9647, 10019);
            CallChecker.varInit(this.e, "e", 283, 9647, 10019);
            CallChecker.varInit(this.piSplit, "piSplit", 283, 9647, 10019);
            CallChecker.varInit(this.pi, "pi", 283, 9647, 10019);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 283, 9647, 10019);
            CallChecker.varInit(this.sqr3, "sqr3", 283, 9647, 10019);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 283, 9647, 10019);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 283, 9647, 10019);
            CallChecker.varInit(this.sqr2, "sqr2", 283, 9647, 10019);
            CallChecker.varInit(this.two, "two", 283, 9647, 10019);
            CallChecker.varInit(this.one, "one", 283, 9647, 10019);
            CallChecker.varInit(this.zero, "zero", 283, 9647, 10019);
            CallChecker.varInit(this.radixDigits, "radixDigits", 283, 9647, 10019);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 283, 9647, 10019);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 283, 9647, 10019);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 283, 9647, 10019);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 283, 9647, 10019);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 283, 9647, 10019);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 283, 9647, 10019);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 283, 9647, 10019);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 283, 9647, 10019);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 283, 9647, 10019);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 283, 9647, 10019);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 283, 9647, 10019);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 283, 9647, 10019);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 283, 9647, 10019);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 283, 9647, 10019);
            return ieeeFlags;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4649.methodEnd();
        }
    }

    public void clearIEEEFlags() {
        MethodContext _bcornu_methode_context4650 = new MethodContext(void.class, 297, 10026, 10362);
        try {
            CallChecker.varInit(this, "this", 297, 10026, 10362);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 297, 10026, 10362);
            CallChecker.varInit(this.rMode, "rMode", 297, 10026, 10362);
            CallChecker.varInit(this.ln10, "ln10", 297, 10026, 10362);
            CallChecker.varInit(this.ln5Split, "ln5Split", 297, 10026, 10362);
            CallChecker.varInit(this.ln5, "ln5", 297, 10026, 10362);
            CallChecker.varInit(this.ln2Split, "ln2Split", 297, 10026, 10362);
            CallChecker.varInit(this.ln2, "ln2", 297, 10026, 10362);
            CallChecker.varInit(this.eSplit, "eSplit", 297, 10026, 10362);
            CallChecker.varInit(this.e, "e", 297, 10026, 10362);
            CallChecker.varInit(this.piSplit, "piSplit", 297, 10026, 10362);
            CallChecker.varInit(this.pi, "pi", 297, 10026, 10362);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 297, 10026, 10362);
            CallChecker.varInit(this.sqr3, "sqr3", 297, 10026, 10362);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 297, 10026, 10362);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 297, 10026, 10362);
            CallChecker.varInit(this.sqr2, "sqr2", 297, 10026, 10362);
            CallChecker.varInit(this.two, "two", 297, 10026, 10362);
            CallChecker.varInit(this.one, "one", 297, 10026, 10362);
            CallChecker.varInit(this.zero, "zero", 297, 10026, 10362);
            CallChecker.varInit(this.radixDigits, "radixDigits", 297, 10026, 10362);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 297, 10026, 10362);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 297, 10026, 10362);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 297, 10026, 10362);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 297, 10026, 10362);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 297, 10026, 10362);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 297, 10026, 10362);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 297, 10026, 10362);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 297, 10026, 10362);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 297, 10026, 10362);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 297, 10026, 10362);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 297, 10026, 10362);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 297, 10026, 10362);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 297, 10026, 10362);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 297, 10026, 10362);
            ieeeFlags = 0;
            CallChecker.varAssign(this.ieeeFlags, "this.ieeeFlags", 298, 10343, 10356);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4650.methodEnd();
        }
    }

    public void setIEEEFlags(final int flags) {
        MethodContext _bcornu_methode_context4651 = new MethodContext(void.class, 312, 10369, 10848);
        try {
            CallChecker.varInit(this, "this", 312, 10369, 10848);
            CallChecker.varInit(flags, "flags", 312, 10369, 10848);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 312, 10369, 10848);
            CallChecker.varInit(this.rMode, "rMode", 312, 10369, 10848);
            CallChecker.varInit(this.ln10, "ln10", 312, 10369, 10848);
            CallChecker.varInit(this.ln5Split, "ln5Split", 312, 10369, 10848);
            CallChecker.varInit(this.ln5, "ln5", 312, 10369, 10848);
            CallChecker.varInit(this.ln2Split, "ln2Split", 312, 10369, 10848);
            CallChecker.varInit(this.ln2, "ln2", 312, 10369, 10848);
            CallChecker.varInit(this.eSplit, "eSplit", 312, 10369, 10848);
            CallChecker.varInit(this.e, "e", 312, 10369, 10848);
            CallChecker.varInit(this.piSplit, "piSplit", 312, 10369, 10848);
            CallChecker.varInit(this.pi, "pi", 312, 10369, 10848);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 312, 10369, 10848);
            CallChecker.varInit(this.sqr3, "sqr3", 312, 10369, 10848);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 312, 10369, 10848);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 312, 10369, 10848);
            CallChecker.varInit(this.sqr2, "sqr2", 312, 10369, 10848);
            CallChecker.varInit(this.two, "two", 312, 10369, 10848);
            CallChecker.varInit(this.one, "one", 312, 10369, 10848);
            CallChecker.varInit(this.zero, "zero", 312, 10369, 10848);
            CallChecker.varInit(this.radixDigits, "radixDigits", 312, 10369, 10848);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 312, 10369, 10848);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 312, 10369, 10848);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 312, 10369, 10848);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 312, 10369, 10848);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 312, 10369, 10848);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 312, 10369, 10848);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 312, 10369, 10848);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 312, 10369, 10848);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 312, 10369, 10848);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 312, 10369, 10848);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 312, 10369, 10848);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 312, 10369, 10848);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 312, 10369, 10848);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 312, 10369, 10848);
            ieeeFlags = flags & (((((DfpField.FLAG_INVALID) | (DfpField.FLAG_DIV_ZERO)) | (DfpField.FLAG_OVERFLOW)) | (DfpField.FLAG_UNDERFLOW)) | (DfpField.FLAG_INEXACT));
            CallChecker.varAssign(this.ieeeFlags, "this.ieeeFlags", 313, 10744, 10842);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4651.methodEnd();
        }
    }

    public void setIEEEFlagsBits(final int bits) {
        MethodContext _bcornu_methode_context4652 = new MethodContext(void.class, 330, 10855, 11484);
        try {
            CallChecker.varInit(this, "this", 330, 10855, 11484);
            CallChecker.varInit(bits, "bits", 330, 10855, 11484);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 330, 10855, 11484);
            CallChecker.varInit(this.rMode, "rMode", 330, 10855, 11484);
            CallChecker.varInit(this.ln10, "ln10", 330, 10855, 11484);
            CallChecker.varInit(this.ln5Split, "ln5Split", 330, 10855, 11484);
            CallChecker.varInit(this.ln5, "ln5", 330, 10855, 11484);
            CallChecker.varInit(this.ln2Split, "ln2Split", 330, 10855, 11484);
            CallChecker.varInit(this.ln2, "ln2", 330, 10855, 11484);
            CallChecker.varInit(this.eSplit, "eSplit", 330, 10855, 11484);
            CallChecker.varInit(this.e, "e", 330, 10855, 11484);
            CallChecker.varInit(this.piSplit, "piSplit", 330, 10855, 11484);
            CallChecker.varInit(this.pi, "pi", 330, 10855, 11484);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 330, 10855, 11484);
            CallChecker.varInit(this.sqr3, "sqr3", 330, 10855, 11484);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 330, 10855, 11484);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 330, 10855, 11484);
            CallChecker.varInit(this.sqr2, "sqr2", 330, 10855, 11484);
            CallChecker.varInit(this.two, "two", 330, 10855, 11484);
            CallChecker.varInit(this.one, "one", 330, 10855, 11484);
            CallChecker.varInit(this.zero, "zero", 330, 10855, 11484);
            CallChecker.varInit(this.radixDigits, "radixDigits", 330, 10855, 11484);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 330, 10855, 11484);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 330, 10855, 11484);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 330, 10855, 11484);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 330, 10855, 11484);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 330, 10855, 11484);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 330, 10855, 11484);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 330, 10855, 11484);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 330, 10855, 11484);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 330, 10855, 11484);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 330, 10855, 11484);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 330, 10855, 11484);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 330, 10855, 11484);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 330, 10855, 11484);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 330, 10855, 11484);
            ieeeFlags |= bits & (((((DfpField.FLAG_INVALID) | (DfpField.FLAG_DIV_ZERO)) | (DfpField.FLAG_OVERFLOW)) | (DfpField.FLAG_UNDERFLOW)) | (DfpField.FLAG_INEXACT));
            CallChecker.varAssign(this.ieeeFlags, "this.ieeeFlags", 331, 11380, 11478);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4652.methodEnd();
        }
    }

    public Dfp newDfp() {
        MethodContext _bcornu_methode_context4653 = new MethodContext(Dfp.class, 337, 11491, 11653);
        try {
            CallChecker.varInit(this, "this", 337, 11491, 11653);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 337, 11491, 11653);
            CallChecker.varInit(this.rMode, "rMode", 337, 11491, 11653);
            CallChecker.varInit(this.ln10, "ln10", 337, 11491, 11653);
            CallChecker.varInit(this.ln5Split, "ln5Split", 337, 11491, 11653);
            CallChecker.varInit(this.ln5, "ln5", 337, 11491, 11653);
            CallChecker.varInit(this.ln2Split, "ln2Split", 337, 11491, 11653);
            CallChecker.varInit(this.ln2, "ln2", 337, 11491, 11653);
            CallChecker.varInit(this.eSplit, "eSplit", 337, 11491, 11653);
            CallChecker.varInit(this.e, "e", 337, 11491, 11653);
            CallChecker.varInit(this.piSplit, "piSplit", 337, 11491, 11653);
            CallChecker.varInit(this.pi, "pi", 337, 11491, 11653);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 337, 11491, 11653);
            CallChecker.varInit(this.sqr3, "sqr3", 337, 11491, 11653);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 337, 11491, 11653);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 337, 11491, 11653);
            CallChecker.varInit(this.sqr2, "sqr2", 337, 11491, 11653);
            CallChecker.varInit(this.two, "two", 337, 11491, 11653);
            CallChecker.varInit(this.one, "one", 337, 11491, 11653);
            CallChecker.varInit(this.zero, "zero", 337, 11491, 11653);
            CallChecker.varInit(this.radixDigits, "radixDigits", 337, 11491, 11653);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 337, 11491, 11653);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 337, 11491, 11653);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 337, 11491, 11653);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 337, 11491, 11653);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 337, 11491, 11653);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 337, 11491, 11653);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 337, 11491, 11653);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 337, 11491, 11653);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 337, 11491, 11653);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 337, 11491, 11653);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 337, 11491, 11653);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 337, 11491, 11653);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 337, 11491, 11653);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 337, 11491, 11653);
            return new Dfp(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4653.methodEnd();
        }
    }

    public Dfp newDfp(final byte x) {
        MethodContext _bcornu_methode_context4654 = new MethodContext(Dfp.class, 345, 11660, 11891);
        try {
            CallChecker.varInit(this, "this", 345, 11660, 11891);
            CallChecker.varInit(x, "x", 345, 11660, 11891);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 345, 11660, 11891);
            CallChecker.varInit(this.rMode, "rMode", 345, 11660, 11891);
            CallChecker.varInit(this.ln10, "ln10", 345, 11660, 11891);
            CallChecker.varInit(this.ln5Split, "ln5Split", 345, 11660, 11891);
            CallChecker.varInit(this.ln5, "ln5", 345, 11660, 11891);
            CallChecker.varInit(this.ln2Split, "ln2Split", 345, 11660, 11891);
            CallChecker.varInit(this.ln2, "ln2", 345, 11660, 11891);
            CallChecker.varInit(this.eSplit, "eSplit", 345, 11660, 11891);
            CallChecker.varInit(this.e, "e", 345, 11660, 11891);
            CallChecker.varInit(this.piSplit, "piSplit", 345, 11660, 11891);
            CallChecker.varInit(this.pi, "pi", 345, 11660, 11891);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 345, 11660, 11891);
            CallChecker.varInit(this.sqr3, "sqr3", 345, 11660, 11891);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 345, 11660, 11891);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 345, 11660, 11891);
            CallChecker.varInit(this.sqr2, "sqr2", 345, 11660, 11891);
            CallChecker.varInit(this.two, "two", 345, 11660, 11891);
            CallChecker.varInit(this.one, "one", 345, 11660, 11891);
            CallChecker.varInit(this.zero, "zero", 345, 11660, 11891);
            CallChecker.varInit(this.radixDigits, "radixDigits", 345, 11660, 11891);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 345, 11660, 11891);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 345, 11660, 11891);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 345, 11660, 11891);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 345, 11660, 11891);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 345, 11660, 11891);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 345, 11660, 11891);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 345, 11660, 11891);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 345, 11660, 11891);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 345, 11660, 11891);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 345, 11660, 11891);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 345, 11660, 11891);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 345, 11660, 11891);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 345, 11660, 11891);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 345, 11660, 11891);
            return new Dfp(this, x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4654.methodEnd();
        }
    }

    public Dfp newDfp(final int x) {
        MethodContext _bcornu_methode_context4655 = new MethodContext(Dfp.class, 353, 11898, 12128);
        try {
            CallChecker.varInit(this, "this", 353, 11898, 12128);
            CallChecker.varInit(x, "x", 353, 11898, 12128);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 353, 11898, 12128);
            CallChecker.varInit(this.rMode, "rMode", 353, 11898, 12128);
            CallChecker.varInit(this.ln10, "ln10", 353, 11898, 12128);
            CallChecker.varInit(this.ln5Split, "ln5Split", 353, 11898, 12128);
            CallChecker.varInit(this.ln5, "ln5", 353, 11898, 12128);
            CallChecker.varInit(this.ln2Split, "ln2Split", 353, 11898, 12128);
            CallChecker.varInit(this.ln2, "ln2", 353, 11898, 12128);
            CallChecker.varInit(this.eSplit, "eSplit", 353, 11898, 12128);
            CallChecker.varInit(this.e, "e", 353, 11898, 12128);
            CallChecker.varInit(this.piSplit, "piSplit", 353, 11898, 12128);
            CallChecker.varInit(this.pi, "pi", 353, 11898, 12128);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 353, 11898, 12128);
            CallChecker.varInit(this.sqr3, "sqr3", 353, 11898, 12128);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 353, 11898, 12128);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 353, 11898, 12128);
            CallChecker.varInit(this.sqr2, "sqr2", 353, 11898, 12128);
            CallChecker.varInit(this.two, "two", 353, 11898, 12128);
            CallChecker.varInit(this.one, "one", 353, 11898, 12128);
            CallChecker.varInit(this.zero, "zero", 353, 11898, 12128);
            CallChecker.varInit(this.radixDigits, "radixDigits", 353, 11898, 12128);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 353, 11898, 12128);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 353, 11898, 12128);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 353, 11898, 12128);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 353, 11898, 12128);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 353, 11898, 12128);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 353, 11898, 12128);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 353, 11898, 12128);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 353, 11898, 12128);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 353, 11898, 12128);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 353, 11898, 12128);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 353, 11898, 12128);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 353, 11898, 12128);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 353, 11898, 12128);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 353, 11898, 12128);
            return new Dfp(this, x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4655.methodEnd();
        }
    }

    public Dfp newDfp(final long x) {
        MethodContext _bcornu_methode_context4656 = new MethodContext(Dfp.class, 361, 12135, 12366);
        try {
            CallChecker.varInit(this, "this", 361, 12135, 12366);
            CallChecker.varInit(x, "x", 361, 12135, 12366);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 361, 12135, 12366);
            CallChecker.varInit(this.rMode, "rMode", 361, 12135, 12366);
            CallChecker.varInit(this.ln10, "ln10", 361, 12135, 12366);
            CallChecker.varInit(this.ln5Split, "ln5Split", 361, 12135, 12366);
            CallChecker.varInit(this.ln5, "ln5", 361, 12135, 12366);
            CallChecker.varInit(this.ln2Split, "ln2Split", 361, 12135, 12366);
            CallChecker.varInit(this.ln2, "ln2", 361, 12135, 12366);
            CallChecker.varInit(this.eSplit, "eSplit", 361, 12135, 12366);
            CallChecker.varInit(this.e, "e", 361, 12135, 12366);
            CallChecker.varInit(this.piSplit, "piSplit", 361, 12135, 12366);
            CallChecker.varInit(this.pi, "pi", 361, 12135, 12366);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 361, 12135, 12366);
            CallChecker.varInit(this.sqr3, "sqr3", 361, 12135, 12366);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 361, 12135, 12366);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 361, 12135, 12366);
            CallChecker.varInit(this.sqr2, "sqr2", 361, 12135, 12366);
            CallChecker.varInit(this.two, "two", 361, 12135, 12366);
            CallChecker.varInit(this.one, "one", 361, 12135, 12366);
            CallChecker.varInit(this.zero, "zero", 361, 12135, 12366);
            CallChecker.varInit(this.radixDigits, "radixDigits", 361, 12135, 12366);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 361, 12135, 12366);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 361, 12135, 12366);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 361, 12135, 12366);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 361, 12135, 12366);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 361, 12135, 12366);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 361, 12135, 12366);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 361, 12135, 12366);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 361, 12135, 12366);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 361, 12135, 12366);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 361, 12135, 12366);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 361, 12135, 12366);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 361, 12135, 12366);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 361, 12135, 12366);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 361, 12135, 12366);
            return new Dfp(this, x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4656.methodEnd();
        }
    }

    public Dfp newDfp(final double x) {
        MethodContext _bcornu_methode_context4657 = new MethodContext(Dfp.class, 369, 12373, 12608);
        try {
            CallChecker.varInit(this, "this", 369, 12373, 12608);
            CallChecker.varInit(x, "x", 369, 12373, 12608);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 369, 12373, 12608);
            CallChecker.varInit(this.rMode, "rMode", 369, 12373, 12608);
            CallChecker.varInit(this.ln10, "ln10", 369, 12373, 12608);
            CallChecker.varInit(this.ln5Split, "ln5Split", 369, 12373, 12608);
            CallChecker.varInit(this.ln5, "ln5", 369, 12373, 12608);
            CallChecker.varInit(this.ln2Split, "ln2Split", 369, 12373, 12608);
            CallChecker.varInit(this.ln2, "ln2", 369, 12373, 12608);
            CallChecker.varInit(this.eSplit, "eSplit", 369, 12373, 12608);
            CallChecker.varInit(this.e, "e", 369, 12373, 12608);
            CallChecker.varInit(this.piSplit, "piSplit", 369, 12373, 12608);
            CallChecker.varInit(this.pi, "pi", 369, 12373, 12608);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 369, 12373, 12608);
            CallChecker.varInit(this.sqr3, "sqr3", 369, 12373, 12608);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 369, 12373, 12608);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 369, 12373, 12608);
            CallChecker.varInit(this.sqr2, "sqr2", 369, 12373, 12608);
            CallChecker.varInit(this.two, "two", 369, 12373, 12608);
            CallChecker.varInit(this.one, "one", 369, 12373, 12608);
            CallChecker.varInit(this.zero, "zero", 369, 12373, 12608);
            CallChecker.varInit(this.radixDigits, "radixDigits", 369, 12373, 12608);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 369, 12373, 12608);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 369, 12373, 12608);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 369, 12373, 12608);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 369, 12373, 12608);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 369, 12373, 12608);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 369, 12373, 12608);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 369, 12373, 12608);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 369, 12373, 12608);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 369, 12373, 12608);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 369, 12373, 12608);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 369, 12373, 12608);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 369, 12373, 12608);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 369, 12373, 12608);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 369, 12373, 12608);
            return new Dfp(this, x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4657.methodEnd();
        }
    }

    public Dfp newDfp(Dfp d) {
        MethodContext _bcornu_methode_context4658 = new MethodContext(Dfp.class, 377, 12615, 12798);
        try {
            CallChecker.varInit(this, "this", 377, 12615, 12798);
            CallChecker.varInit(d, "d", 377, 12615, 12798);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 377, 12615, 12798);
            CallChecker.varInit(this.rMode, "rMode", 377, 12615, 12798);
            CallChecker.varInit(this.ln10, "ln10", 377, 12615, 12798);
            CallChecker.varInit(this.ln5Split, "ln5Split", 377, 12615, 12798);
            CallChecker.varInit(this.ln5, "ln5", 377, 12615, 12798);
            CallChecker.varInit(this.ln2Split, "ln2Split", 377, 12615, 12798);
            CallChecker.varInit(this.ln2, "ln2", 377, 12615, 12798);
            CallChecker.varInit(this.eSplit, "eSplit", 377, 12615, 12798);
            CallChecker.varInit(this.e, "e", 377, 12615, 12798);
            CallChecker.varInit(this.piSplit, "piSplit", 377, 12615, 12798);
            CallChecker.varInit(this.pi, "pi", 377, 12615, 12798);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 377, 12615, 12798);
            CallChecker.varInit(this.sqr3, "sqr3", 377, 12615, 12798);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 377, 12615, 12798);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 377, 12615, 12798);
            CallChecker.varInit(this.sqr2, "sqr2", 377, 12615, 12798);
            CallChecker.varInit(this.two, "two", 377, 12615, 12798);
            CallChecker.varInit(this.one, "one", 377, 12615, 12798);
            CallChecker.varInit(this.zero, "zero", 377, 12615, 12798);
            CallChecker.varInit(this.radixDigits, "radixDigits", 377, 12615, 12798);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 377, 12615, 12798);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 377, 12615, 12798);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 377, 12615, 12798);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 377, 12615, 12798);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 377, 12615, 12798);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 377, 12615, 12798);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 377, 12615, 12798);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 377, 12615, 12798);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 377, 12615, 12798);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 377, 12615, 12798);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 377, 12615, 12798);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 377, 12615, 12798);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 377, 12615, 12798);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 377, 12615, 12798);
            return new Dfp(d);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4658.methodEnd();
        }
    }

    public Dfp newDfp(final String s) {
        MethodContext _bcornu_methode_context4659 = new MethodContext(Dfp.class, 385, 12805, 13062);
        try {
            CallChecker.varInit(this, "this", 385, 12805, 13062);
            CallChecker.varInit(s, "s", 385, 12805, 13062);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 385, 12805, 13062);
            CallChecker.varInit(this.rMode, "rMode", 385, 12805, 13062);
            CallChecker.varInit(this.ln10, "ln10", 385, 12805, 13062);
            CallChecker.varInit(this.ln5Split, "ln5Split", 385, 12805, 13062);
            CallChecker.varInit(this.ln5, "ln5", 385, 12805, 13062);
            CallChecker.varInit(this.ln2Split, "ln2Split", 385, 12805, 13062);
            CallChecker.varInit(this.ln2, "ln2", 385, 12805, 13062);
            CallChecker.varInit(this.eSplit, "eSplit", 385, 12805, 13062);
            CallChecker.varInit(this.e, "e", 385, 12805, 13062);
            CallChecker.varInit(this.piSplit, "piSplit", 385, 12805, 13062);
            CallChecker.varInit(this.pi, "pi", 385, 12805, 13062);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 385, 12805, 13062);
            CallChecker.varInit(this.sqr3, "sqr3", 385, 12805, 13062);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 385, 12805, 13062);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 385, 12805, 13062);
            CallChecker.varInit(this.sqr2, "sqr2", 385, 12805, 13062);
            CallChecker.varInit(this.two, "two", 385, 12805, 13062);
            CallChecker.varInit(this.one, "one", 385, 12805, 13062);
            CallChecker.varInit(this.zero, "zero", 385, 12805, 13062);
            CallChecker.varInit(this.radixDigits, "radixDigits", 385, 12805, 13062);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 385, 12805, 13062);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 385, 12805, 13062);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 385, 12805, 13062);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 385, 12805, 13062);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 385, 12805, 13062);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 385, 12805, 13062);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 385, 12805, 13062);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 385, 12805, 13062);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 385, 12805, 13062);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 385, 12805, 13062);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 385, 12805, 13062);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 385, 12805, 13062);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 385, 12805, 13062);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 385, 12805, 13062);
            return new Dfp(this, s);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4659.methodEnd();
        }
    }

    public Dfp newDfp(final byte sign, final byte nans) {
        MethodContext _bcornu_methode_context4660 = new MethodContext(Dfp.class, 395, 13069, 13452);
        try {
            CallChecker.varInit(this, "this", 395, 13069, 13452);
            CallChecker.varInit(nans, "nans", 395, 13069, 13452);
            CallChecker.varInit(sign, "sign", 395, 13069, 13452);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 395, 13069, 13452);
            CallChecker.varInit(this.rMode, "rMode", 395, 13069, 13452);
            CallChecker.varInit(this.ln10, "ln10", 395, 13069, 13452);
            CallChecker.varInit(this.ln5Split, "ln5Split", 395, 13069, 13452);
            CallChecker.varInit(this.ln5, "ln5", 395, 13069, 13452);
            CallChecker.varInit(this.ln2Split, "ln2Split", 395, 13069, 13452);
            CallChecker.varInit(this.ln2, "ln2", 395, 13069, 13452);
            CallChecker.varInit(this.eSplit, "eSplit", 395, 13069, 13452);
            CallChecker.varInit(this.e, "e", 395, 13069, 13452);
            CallChecker.varInit(this.piSplit, "piSplit", 395, 13069, 13452);
            CallChecker.varInit(this.pi, "pi", 395, 13069, 13452);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 395, 13069, 13452);
            CallChecker.varInit(this.sqr3, "sqr3", 395, 13069, 13452);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 395, 13069, 13452);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 395, 13069, 13452);
            CallChecker.varInit(this.sqr2, "sqr2", 395, 13069, 13452);
            CallChecker.varInit(this.two, "two", 395, 13069, 13452);
            CallChecker.varInit(this.one, "one", 395, 13069, 13452);
            CallChecker.varInit(this.zero, "zero", 395, 13069, 13452);
            CallChecker.varInit(this.radixDigits, "radixDigits", 395, 13069, 13452);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 395, 13069, 13452);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 395, 13069, 13452);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 395, 13069, 13452);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 395, 13069, 13452);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 395, 13069, 13452);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 395, 13069, 13452);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 395, 13069, 13452);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 395, 13069, 13452);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 395, 13069, 13452);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 395, 13069, 13452);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 395, 13069, 13452);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 395, 13069, 13452);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 395, 13069, 13452);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 395, 13069, 13452);
            return new Dfp(this, sign, nans);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4660.methodEnd();
        }
    }

    public Dfp getZero() {
        MethodContext _bcornu_methode_context4661 = new MethodContext(Dfp.class, 402, 13459, 13585);
        try {
            CallChecker.varInit(this, "this", 402, 13459, 13585);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 402, 13459, 13585);
            CallChecker.varInit(this.rMode, "rMode", 402, 13459, 13585);
            CallChecker.varInit(this.ln10, "ln10", 402, 13459, 13585);
            CallChecker.varInit(this.ln5Split, "ln5Split", 402, 13459, 13585);
            CallChecker.varInit(this.ln5, "ln5", 402, 13459, 13585);
            CallChecker.varInit(this.ln2Split, "ln2Split", 402, 13459, 13585);
            CallChecker.varInit(this.ln2, "ln2", 402, 13459, 13585);
            CallChecker.varInit(this.eSplit, "eSplit", 402, 13459, 13585);
            CallChecker.varInit(this.e, "e", 402, 13459, 13585);
            CallChecker.varInit(this.piSplit, "piSplit", 402, 13459, 13585);
            CallChecker.varInit(this.pi, "pi", 402, 13459, 13585);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 402, 13459, 13585);
            CallChecker.varInit(this.sqr3, "sqr3", 402, 13459, 13585);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 402, 13459, 13585);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 402, 13459, 13585);
            CallChecker.varInit(this.sqr2, "sqr2", 402, 13459, 13585);
            CallChecker.varInit(this.two, "two", 402, 13459, 13585);
            CallChecker.varInit(this.one, "one", 402, 13459, 13585);
            CallChecker.varInit(this.zero, "zero", 402, 13459, 13585);
            CallChecker.varInit(this.radixDigits, "radixDigits", 402, 13459, 13585);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 402, 13459, 13585);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 402, 13459, 13585);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 402, 13459, 13585);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 402, 13459, 13585);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 402, 13459, 13585);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 402, 13459, 13585);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 402, 13459, 13585);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 402, 13459, 13585);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 402, 13459, 13585);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 402, 13459, 13585);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 402, 13459, 13585);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 402, 13459, 13585);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 402, 13459, 13585);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 402, 13459, 13585);
            return zero;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4661.methodEnd();
        }
    }

    public Dfp getOne() {
        MethodContext _bcornu_methode_context4662 = new MethodContext(Dfp.class, 409, 13592, 13716);
        try {
            CallChecker.varInit(this, "this", 409, 13592, 13716);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 409, 13592, 13716);
            CallChecker.varInit(this.rMode, "rMode", 409, 13592, 13716);
            CallChecker.varInit(this.ln10, "ln10", 409, 13592, 13716);
            CallChecker.varInit(this.ln5Split, "ln5Split", 409, 13592, 13716);
            CallChecker.varInit(this.ln5, "ln5", 409, 13592, 13716);
            CallChecker.varInit(this.ln2Split, "ln2Split", 409, 13592, 13716);
            CallChecker.varInit(this.ln2, "ln2", 409, 13592, 13716);
            CallChecker.varInit(this.eSplit, "eSplit", 409, 13592, 13716);
            CallChecker.varInit(this.e, "e", 409, 13592, 13716);
            CallChecker.varInit(this.piSplit, "piSplit", 409, 13592, 13716);
            CallChecker.varInit(this.pi, "pi", 409, 13592, 13716);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 409, 13592, 13716);
            CallChecker.varInit(this.sqr3, "sqr3", 409, 13592, 13716);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 409, 13592, 13716);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 409, 13592, 13716);
            CallChecker.varInit(this.sqr2, "sqr2", 409, 13592, 13716);
            CallChecker.varInit(this.two, "two", 409, 13592, 13716);
            CallChecker.varInit(this.one, "one", 409, 13592, 13716);
            CallChecker.varInit(this.zero, "zero", 409, 13592, 13716);
            CallChecker.varInit(this.radixDigits, "radixDigits", 409, 13592, 13716);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 409, 13592, 13716);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 409, 13592, 13716);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 409, 13592, 13716);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 409, 13592, 13716);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 409, 13592, 13716);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 409, 13592, 13716);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 409, 13592, 13716);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 409, 13592, 13716);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 409, 13592, 13716);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 409, 13592, 13716);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 409, 13592, 13716);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 409, 13592, 13716);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 409, 13592, 13716);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 409, 13592, 13716);
            return one;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4662.methodEnd();
        }
    }

    public Class<? extends FieldElement<Dfp>> getRuntimeClass() {
        MethodContext _bcornu_methode_context4663 = new MethodContext(Class.class, 414, 13723, 13840);
        try {
            CallChecker.varInit(this, "this", 414, 13723, 13840);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 414, 13723, 13840);
            CallChecker.varInit(this.rMode, "rMode", 414, 13723, 13840);
            CallChecker.varInit(this.ln10, "ln10", 414, 13723, 13840);
            CallChecker.varInit(this.ln5Split, "ln5Split", 414, 13723, 13840);
            CallChecker.varInit(this.ln5, "ln5", 414, 13723, 13840);
            CallChecker.varInit(this.ln2Split, "ln2Split", 414, 13723, 13840);
            CallChecker.varInit(this.ln2, "ln2", 414, 13723, 13840);
            CallChecker.varInit(this.eSplit, "eSplit", 414, 13723, 13840);
            CallChecker.varInit(this.e, "e", 414, 13723, 13840);
            CallChecker.varInit(this.piSplit, "piSplit", 414, 13723, 13840);
            CallChecker.varInit(this.pi, "pi", 414, 13723, 13840);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 414, 13723, 13840);
            CallChecker.varInit(this.sqr3, "sqr3", 414, 13723, 13840);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 414, 13723, 13840);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 414, 13723, 13840);
            CallChecker.varInit(this.sqr2, "sqr2", 414, 13723, 13840);
            CallChecker.varInit(this.two, "two", 414, 13723, 13840);
            CallChecker.varInit(this.one, "one", 414, 13723, 13840);
            CallChecker.varInit(this.zero, "zero", 414, 13723, 13840);
            CallChecker.varInit(this.radixDigits, "radixDigits", 414, 13723, 13840);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 414, 13723, 13840);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 414, 13723, 13840);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 414, 13723, 13840);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 414, 13723, 13840);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 414, 13723, 13840);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 414, 13723, 13840);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 414, 13723, 13840);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 414, 13723, 13840);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 414, 13723, 13840);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 414, 13723, 13840);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 414, 13723, 13840);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 414, 13723, 13840);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 414, 13723, 13840);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 414, 13723, 13840);
            return Dfp.class;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<? extends FieldElement<Dfp>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4663.methodEnd();
        }
    }

    public Dfp getTwo() {
        MethodContext _bcornu_methode_context4664 = new MethodContext(Dfp.class, 421, 13847, 13971);
        try {
            CallChecker.varInit(this, "this", 421, 13847, 13971);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 421, 13847, 13971);
            CallChecker.varInit(this.rMode, "rMode", 421, 13847, 13971);
            CallChecker.varInit(this.ln10, "ln10", 421, 13847, 13971);
            CallChecker.varInit(this.ln5Split, "ln5Split", 421, 13847, 13971);
            CallChecker.varInit(this.ln5, "ln5", 421, 13847, 13971);
            CallChecker.varInit(this.ln2Split, "ln2Split", 421, 13847, 13971);
            CallChecker.varInit(this.ln2, "ln2", 421, 13847, 13971);
            CallChecker.varInit(this.eSplit, "eSplit", 421, 13847, 13971);
            CallChecker.varInit(this.e, "e", 421, 13847, 13971);
            CallChecker.varInit(this.piSplit, "piSplit", 421, 13847, 13971);
            CallChecker.varInit(this.pi, "pi", 421, 13847, 13971);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 421, 13847, 13971);
            CallChecker.varInit(this.sqr3, "sqr3", 421, 13847, 13971);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 421, 13847, 13971);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 421, 13847, 13971);
            CallChecker.varInit(this.sqr2, "sqr2", 421, 13847, 13971);
            CallChecker.varInit(this.two, "two", 421, 13847, 13971);
            CallChecker.varInit(this.one, "one", 421, 13847, 13971);
            CallChecker.varInit(this.zero, "zero", 421, 13847, 13971);
            CallChecker.varInit(this.radixDigits, "radixDigits", 421, 13847, 13971);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 421, 13847, 13971);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 421, 13847, 13971);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 421, 13847, 13971);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 421, 13847, 13971);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 421, 13847, 13971);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 421, 13847, 13971);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 421, 13847, 13971);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 421, 13847, 13971);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 421, 13847, 13971);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 421, 13847, 13971);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 421, 13847, 13971);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 421, 13847, 13971);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 421, 13847, 13971);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 421, 13847, 13971);
            return two;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4664.methodEnd();
        }
    }

    public Dfp getSqr2() {
        MethodContext _bcornu_methode_context4665 = new MethodContext(Dfp.class, 428, 13978, 14118);
        try {
            CallChecker.varInit(this, "this", 428, 13978, 14118);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 428, 13978, 14118);
            CallChecker.varInit(this.rMode, "rMode", 428, 13978, 14118);
            CallChecker.varInit(this.ln10, "ln10", 428, 13978, 14118);
            CallChecker.varInit(this.ln5Split, "ln5Split", 428, 13978, 14118);
            CallChecker.varInit(this.ln5, "ln5", 428, 13978, 14118);
            CallChecker.varInit(this.ln2Split, "ln2Split", 428, 13978, 14118);
            CallChecker.varInit(this.ln2, "ln2", 428, 13978, 14118);
            CallChecker.varInit(this.eSplit, "eSplit", 428, 13978, 14118);
            CallChecker.varInit(this.e, "e", 428, 13978, 14118);
            CallChecker.varInit(this.piSplit, "piSplit", 428, 13978, 14118);
            CallChecker.varInit(this.pi, "pi", 428, 13978, 14118);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 428, 13978, 14118);
            CallChecker.varInit(this.sqr3, "sqr3", 428, 13978, 14118);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 428, 13978, 14118);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 428, 13978, 14118);
            CallChecker.varInit(this.sqr2, "sqr2", 428, 13978, 14118);
            CallChecker.varInit(this.two, "two", 428, 13978, 14118);
            CallChecker.varInit(this.one, "one", 428, 13978, 14118);
            CallChecker.varInit(this.zero, "zero", 428, 13978, 14118);
            CallChecker.varInit(this.radixDigits, "radixDigits", 428, 13978, 14118);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 428, 13978, 14118);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 428, 13978, 14118);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 428, 13978, 14118);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 428, 13978, 14118);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 428, 13978, 14118);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 428, 13978, 14118);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 428, 13978, 14118);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 428, 13978, 14118);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 428, 13978, 14118);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 428, 13978, 14118);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 428, 13978, 14118);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 428, 13978, 14118);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 428, 13978, 14118);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 428, 13978, 14118);
            return sqr2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4665.methodEnd();
        }
    }

    public Dfp[] getSqr2Split() {
        MethodContext _bcornu_methode_context4666 = new MethodContext(Dfp[].class, 435, 14125, 14325);
        try {
            CallChecker.varInit(this, "this", 435, 14125, 14325);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 435, 14125, 14325);
            CallChecker.varInit(this.rMode, "rMode", 435, 14125, 14325);
            CallChecker.varInit(this.ln10, "ln10", 435, 14125, 14325);
            CallChecker.varInit(this.ln5Split, "ln5Split", 435, 14125, 14325);
            CallChecker.varInit(this.ln5, "ln5", 435, 14125, 14325);
            CallChecker.varInit(this.ln2Split, "ln2Split", 435, 14125, 14325);
            CallChecker.varInit(this.ln2, "ln2", 435, 14125, 14325);
            CallChecker.varInit(this.eSplit, "eSplit", 435, 14125, 14325);
            CallChecker.varInit(this.e, "e", 435, 14125, 14325);
            CallChecker.varInit(this.piSplit, "piSplit", 435, 14125, 14325);
            CallChecker.varInit(this.pi, "pi", 435, 14125, 14325);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 435, 14125, 14325);
            CallChecker.varInit(this.sqr3, "sqr3", 435, 14125, 14325);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 435, 14125, 14325);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 435, 14125, 14325);
            CallChecker.varInit(this.sqr2, "sqr2", 435, 14125, 14325);
            CallChecker.varInit(this.two, "two", 435, 14125, 14325);
            CallChecker.varInit(this.one, "one", 435, 14125, 14325);
            CallChecker.varInit(this.zero, "zero", 435, 14125, 14325);
            CallChecker.varInit(this.radixDigits, "radixDigits", 435, 14125, 14325);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 435, 14125, 14325);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 435, 14125, 14325);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 435, 14125, 14325);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 435, 14125, 14325);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 435, 14125, 14325);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 435, 14125, 14325);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 435, 14125, 14325);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 435, 14125, 14325);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 435, 14125, 14325);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 435, 14125, 14325);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 435, 14125, 14325);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 435, 14125, 14325);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 435, 14125, 14325);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 435, 14125, 14325);
            if (CallChecker.beforeDeref(sqr2Split, Dfp[].class, 436, 14302, 14310)) {
                return CallChecker.isCalled(sqr2Split, Dfp[].class, 436, 14302, 14310).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4666.methodEnd();
        }
    }

    public Dfp getSqr2Reciprocal() {
        MethodContext _bcornu_methode_context4667 = new MethodContext(Dfp.class, 442, 14332, 14500);
        try {
            CallChecker.varInit(this, "this", 442, 14332, 14500);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 442, 14332, 14500);
            CallChecker.varInit(this.rMode, "rMode", 442, 14332, 14500);
            CallChecker.varInit(this.ln10, "ln10", 442, 14332, 14500);
            CallChecker.varInit(this.ln5Split, "ln5Split", 442, 14332, 14500);
            CallChecker.varInit(this.ln5, "ln5", 442, 14332, 14500);
            CallChecker.varInit(this.ln2Split, "ln2Split", 442, 14332, 14500);
            CallChecker.varInit(this.ln2, "ln2", 442, 14332, 14500);
            CallChecker.varInit(this.eSplit, "eSplit", 442, 14332, 14500);
            CallChecker.varInit(this.e, "e", 442, 14332, 14500);
            CallChecker.varInit(this.piSplit, "piSplit", 442, 14332, 14500);
            CallChecker.varInit(this.pi, "pi", 442, 14332, 14500);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 442, 14332, 14500);
            CallChecker.varInit(this.sqr3, "sqr3", 442, 14332, 14500);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 442, 14332, 14500);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 442, 14332, 14500);
            CallChecker.varInit(this.sqr2, "sqr2", 442, 14332, 14500);
            CallChecker.varInit(this.two, "two", 442, 14332, 14500);
            CallChecker.varInit(this.one, "one", 442, 14332, 14500);
            CallChecker.varInit(this.zero, "zero", 442, 14332, 14500);
            CallChecker.varInit(this.radixDigits, "radixDigits", 442, 14332, 14500);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 442, 14332, 14500);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 442, 14332, 14500);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 442, 14332, 14500);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 442, 14332, 14500);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 442, 14332, 14500);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 442, 14332, 14500);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 442, 14332, 14500);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 442, 14332, 14500);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 442, 14332, 14500);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 442, 14332, 14500);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 442, 14332, 14500);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 442, 14332, 14500);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 442, 14332, 14500);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 442, 14332, 14500);
            return sqr2Reciprocal;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4667.methodEnd();
        }
    }

    public Dfp getSqr3() {
        MethodContext _bcornu_methode_context4668 = new MethodContext(Dfp.class, 449, 14507, 14647);
        try {
            CallChecker.varInit(this, "this", 449, 14507, 14647);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 449, 14507, 14647);
            CallChecker.varInit(this.rMode, "rMode", 449, 14507, 14647);
            CallChecker.varInit(this.ln10, "ln10", 449, 14507, 14647);
            CallChecker.varInit(this.ln5Split, "ln5Split", 449, 14507, 14647);
            CallChecker.varInit(this.ln5, "ln5", 449, 14507, 14647);
            CallChecker.varInit(this.ln2Split, "ln2Split", 449, 14507, 14647);
            CallChecker.varInit(this.ln2, "ln2", 449, 14507, 14647);
            CallChecker.varInit(this.eSplit, "eSplit", 449, 14507, 14647);
            CallChecker.varInit(this.e, "e", 449, 14507, 14647);
            CallChecker.varInit(this.piSplit, "piSplit", 449, 14507, 14647);
            CallChecker.varInit(this.pi, "pi", 449, 14507, 14647);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 449, 14507, 14647);
            CallChecker.varInit(this.sqr3, "sqr3", 449, 14507, 14647);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 449, 14507, 14647);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 449, 14507, 14647);
            CallChecker.varInit(this.sqr2, "sqr2", 449, 14507, 14647);
            CallChecker.varInit(this.two, "two", 449, 14507, 14647);
            CallChecker.varInit(this.one, "one", 449, 14507, 14647);
            CallChecker.varInit(this.zero, "zero", 449, 14507, 14647);
            CallChecker.varInit(this.radixDigits, "radixDigits", 449, 14507, 14647);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 449, 14507, 14647);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 449, 14507, 14647);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 449, 14507, 14647);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 449, 14507, 14647);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 449, 14507, 14647);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 449, 14507, 14647);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 449, 14507, 14647);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 449, 14507, 14647);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 449, 14507, 14647);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 449, 14507, 14647);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 449, 14507, 14647);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 449, 14507, 14647);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 449, 14507, 14647);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 449, 14507, 14647);
            return sqr3;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4668.methodEnd();
        }
    }

    public Dfp getSqr3Reciprocal() {
        MethodContext _bcornu_methode_context4669 = new MethodContext(Dfp.class, 456, 14654, 14822);
        try {
            CallChecker.varInit(this, "this", 456, 14654, 14822);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 456, 14654, 14822);
            CallChecker.varInit(this.rMode, "rMode", 456, 14654, 14822);
            CallChecker.varInit(this.ln10, "ln10", 456, 14654, 14822);
            CallChecker.varInit(this.ln5Split, "ln5Split", 456, 14654, 14822);
            CallChecker.varInit(this.ln5, "ln5", 456, 14654, 14822);
            CallChecker.varInit(this.ln2Split, "ln2Split", 456, 14654, 14822);
            CallChecker.varInit(this.ln2, "ln2", 456, 14654, 14822);
            CallChecker.varInit(this.eSplit, "eSplit", 456, 14654, 14822);
            CallChecker.varInit(this.e, "e", 456, 14654, 14822);
            CallChecker.varInit(this.piSplit, "piSplit", 456, 14654, 14822);
            CallChecker.varInit(this.pi, "pi", 456, 14654, 14822);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 456, 14654, 14822);
            CallChecker.varInit(this.sqr3, "sqr3", 456, 14654, 14822);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 456, 14654, 14822);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 456, 14654, 14822);
            CallChecker.varInit(this.sqr2, "sqr2", 456, 14654, 14822);
            CallChecker.varInit(this.two, "two", 456, 14654, 14822);
            CallChecker.varInit(this.one, "one", 456, 14654, 14822);
            CallChecker.varInit(this.zero, "zero", 456, 14654, 14822);
            CallChecker.varInit(this.radixDigits, "radixDigits", 456, 14654, 14822);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 456, 14654, 14822);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 456, 14654, 14822);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 456, 14654, 14822);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 456, 14654, 14822);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 456, 14654, 14822);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 456, 14654, 14822);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 456, 14654, 14822);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 456, 14654, 14822);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 456, 14654, 14822);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 456, 14654, 14822);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 456, 14654, 14822);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 456, 14654, 14822);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 456, 14654, 14822);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 456, 14654, 14822);
            return sqr3Reciprocal;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4669.methodEnd();
        }
    }

    public Dfp getPi() {
        MethodContext _bcornu_methode_context4670 = new MethodContext(Dfp.class, 463, 14829, 14957);
        try {
            CallChecker.varInit(this, "this", 463, 14829, 14957);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 463, 14829, 14957);
            CallChecker.varInit(this.rMode, "rMode", 463, 14829, 14957);
            CallChecker.varInit(this.ln10, "ln10", 463, 14829, 14957);
            CallChecker.varInit(this.ln5Split, "ln5Split", 463, 14829, 14957);
            CallChecker.varInit(this.ln5, "ln5", 463, 14829, 14957);
            CallChecker.varInit(this.ln2Split, "ln2Split", 463, 14829, 14957);
            CallChecker.varInit(this.ln2, "ln2", 463, 14829, 14957);
            CallChecker.varInit(this.eSplit, "eSplit", 463, 14829, 14957);
            CallChecker.varInit(this.e, "e", 463, 14829, 14957);
            CallChecker.varInit(this.piSplit, "piSplit", 463, 14829, 14957);
            CallChecker.varInit(this.pi, "pi", 463, 14829, 14957);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 463, 14829, 14957);
            CallChecker.varInit(this.sqr3, "sqr3", 463, 14829, 14957);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 463, 14829, 14957);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 463, 14829, 14957);
            CallChecker.varInit(this.sqr2, "sqr2", 463, 14829, 14957);
            CallChecker.varInit(this.two, "two", 463, 14829, 14957);
            CallChecker.varInit(this.one, "one", 463, 14829, 14957);
            CallChecker.varInit(this.zero, "zero", 463, 14829, 14957);
            CallChecker.varInit(this.radixDigits, "radixDigits", 463, 14829, 14957);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 463, 14829, 14957);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 463, 14829, 14957);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 463, 14829, 14957);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 463, 14829, 14957);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 463, 14829, 14957);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 463, 14829, 14957);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 463, 14829, 14957);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 463, 14829, 14957);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 463, 14829, 14957);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 463, 14829, 14957);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 463, 14829, 14957);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 463, 14829, 14957);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 463, 14829, 14957);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 463, 14829, 14957);
            return pi;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4670.methodEnd();
        }
    }

    public Dfp[] getPiSplit() {
        MethodContext _bcornu_methode_context4671 = new MethodContext(Dfp[].class, 470, 14964, 15152);
        try {
            CallChecker.varInit(this, "this", 470, 14964, 15152);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 470, 14964, 15152);
            CallChecker.varInit(this.rMode, "rMode", 470, 14964, 15152);
            CallChecker.varInit(this.ln10, "ln10", 470, 14964, 15152);
            CallChecker.varInit(this.ln5Split, "ln5Split", 470, 14964, 15152);
            CallChecker.varInit(this.ln5, "ln5", 470, 14964, 15152);
            CallChecker.varInit(this.ln2Split, "ln2Split", 470, 14964, 15152);
            CallChecker.varInit(this.ln2, "ln2", 470, 14964, 15152);
            CallChecker.varInit(this.eSplit, "eSplit", 470, 14964, 15152);
            CallChecker.varInit(this.e, "e", 470, 14964, 15152);
            CallChecker.varInit(this.piSplit, "piSplit", 470, 14964, 15152);
            CallChecker.varInit(this.pi, "pi", 470, 14964, 15152);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 470, 14964, 15152);
            CallChecker.varInit(this.sqr3, "sqr3", 470, 14964, 15152);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 470, 14964, 15152);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 470, 14964, 15152);
            CallChecker.varInit(this.sqr2, "sqr2", 470, 14964, 15152);
            CallChecker.varInit(this.two, "two", 470, 14964, 15152);
            CallChecker.varInit(this.one, "one", 470, 14964, 15152);
            CallChecker.varInit(this.zero, "zero", 470, 14964, 15152);
            CallChecker.varInit(this.radixDigits, "radixDigits", 470, 14964, 15152);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 470, 14964, 15152);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 470, 14964, 15152);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 470, 14964, 15152);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 470, 14964, 15152);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 470, 14964, 15152);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 470, 14964, 15152);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 470, 14964, 15152);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 470, 14964, 15152);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 470, 14964, 15152);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 470, 14964, 15152);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 470, 14964, 15152);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 470, 14964, 15152);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 470, 14964, 15152);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 470, 14964, 15152);
            if (CallChecker.beforeDeref(piSplit, Dfp[].class, 471, 15131, 15137)) {
                return CallChecker.isCalled(piSplit, Dfp[].class, 471, 15131, 15137).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4671.methodEnd();
        }
    }

    public Dfp getE() {
        MethodContext _bcornu_methode_context4672 = new MethodContext(Dfp.class, 477, 15159, 15279);
        try {
            CallChecker.varInit(this, "this", 477, 15159, 15279);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 477, 15159, 15279);
            CallChecker.varInit(this.rMode, "rMode", 477, 15159, 15279);
            CallChecker.varInit(this.ln10, "ln10", 477, 15159, 15279);
            CallChecker.varInit(this.ln5Split, "ln5Split", 477, 15159, 15279);
            CallChecker.varInit(this.ln5, "ln5", 477, 15159, 15279);
            CallChecker.varInit(this.ln2Split, "ln2Split", 477, 15159, 15279);
            CallChecker.varInit(this.ln2, "ln2", 477, 15159, 15279);
            CallChecker.varInit(this.eSplit, "eSplit", 477, 15159, 15279);
            CallChecker.varInit(this.e, "e", 477, 15159, 15279);
            CallChecker.varInit(this.piSplit, "piSplit", 477, 15159, 15279);
            CallChecker.varInit(this.pi, "pi", 477, 15159, 15279);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 477, 15159, 15279);
            CallChecker.varInit(this.sqr3, "sqr3", 477, 15159, 15279);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 477, 15159, 15279);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 477, 15159, 15279);
            CallChecker.varInit(this.sqr2, "sqr2", 477, 15159, 15279);
            CallChecker.varInit(this.two, "two", 477, 15159, 15279);
            CallChecker.varInit(this.one, "one", 477, 15159, 15279);
            CallChecker.varInit(this.zero, "zero", 477, 15159, 15279);
            CallChecker.varInit(this.radixDigits, "radixDigits", 477, 15159, 15279);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 477, 15159, 15279);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 477, 15159, 15279);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 477, 15159, 15279);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 477, 15159, 15279);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 477, 15159, 15279);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 477, 15159, 15279);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 477, 15159, 15279);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 477, 15159, 15279);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 477, 15159, 15279);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 477, 15159, 15279);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 477, 15159, 15279);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 477, 15159, 15279);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 477, 15159, 15279);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 477, 15159, 15279);
            return e;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4672.methodEnd();
        }
    }

    public Dfp[] getESplit() {
        MethodContext _bcornu_methode_context4673 = new MethodContext(Dfp[].class, 484, 15286, 15466);
        try {
            CallChecker.varInit(this, "this", 484, 15286, 15466);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 484, 15286, 15466);
            CallChecker.varInit(this.rMode, "rMode", 484, 15286, 15466);
            CallChecker.varInit(this.ln10, "ln10", 484, 15286, 15466);
            CallChecker.varInit(this.ln5Split, "ln5Split", 484, 15286, 15466);
            CallChecker.varInit(this.ln5, "ln5", 484, 15286, 15466);
            CallChecker.varInit(this.ln2Split, "ln2Split", 484, 15286, 15466);
            CallChecker.varInit(this.ln2, "ln2", 484, 15286, 15466);
            CallChecker.varInit(this.eSplit, "eSplit", 484, 15286, 15466);
            CallChecker.varInit(this.e, "e", 484, 15286, 15466);
            CallChecker.varInit(this.piSplit, "piSplit", 484, 15286, 15466);
            CallChecker.varInit(this.pi, "pi", 484, 15286, 15466);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 484, 15286, 15466);
            CallChecker.varInit(this.sqr3, "sqr3", 484, 15286, 15466);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 484, 15286, 15466);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 484, 15286, 15466);
            CallChecker.varInit(this.sqr2, "sqr2", 484, 15286, 15466);
            CallChecker.varInit(this.two, "two", 484, 15286, 15466);
            CallChecker.varInit(this.one, "one", 484, 15286, 15466);
            CallChecker.varInit(this.zero, "zero", 484, 15286, 15466);
            CallChecker.varInit(this.radixDigits, "radixDigits", 484, 15286, 15466);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 484, 15286, 15466);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 484, 15286, 15466);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 484, 15286, 15466);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 484, 15286, 15466);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 484, 15286, 15466);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 484, 15286, 15466);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 484, 15286, 15466);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 484, 15286, 15466);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 484, 15286, 15466);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 484, 15286, 15466);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 484, 15286, 15466);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 484, 15286, 15466);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 484, 15286, 15466);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 484, 15286, 15466);
            if (CallChecker.beforeDeref(eSplit, Dfp[].class, 485, 15446, 15451)) {
                return CallChecker.isCalled(eSplit, Dfp[].class, 485, 15446, 15451).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4673.methodEnd();
        }
    }

    public Dfp getLn2() {
        MethodContext _bcornu_methode_context4674 = new MethodContext(Dfp.class, 491, 15473, 15605);
        try {
            CallChecker.varInit(this, "this", 491, 15473, 15605);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 491, 15473, 15605);
            CallChecker.varInit(this.rMode, "rMode", 491, 15473, 15605);
            CallChecker.varInit(this.ln10, "ln10", 491, 15473, 15605);
            CallChecker.varInit(this.ln5Split, "ln5Split", 491, 15473, 15605);
            CallChecker.varInit(this.ln5, "ln5", 491, 15473, 15605);
            CallChecker.varInit(this.ln2Split, "ln2Split", 491, 15473, 15605);
            CallChecker.varInit(this.ln2, "ln2", 491, 15473, 15605);
            CallChecker.varInit(this.eSplit, "eSplit", 491, 15473, 15605);
            CallChecker.varInit(this.e, "e", 491, 15473, 15605);
            CallChecker.varInit(this.piSplit, "piSplit", 491, 15473, 15605);
            CallChecker.varInit(this.pi, "pi", 491, 15473, 15605);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 491, 15473, 15605);
            CallChecker.varInit(this.sqr3, "sqr3", 491, 15473, 15605);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 491, 15473, 15605);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 491, 15473, 15605);
            CallChecker.varInit(this.sqr2, "sqr2", 491, 15473, 15605);
            CallChecker.varInit(this.two, "two", 491, 15473, 15605);
            CallChecker.varInit(this.one, "one", 491, 15473, 15605);
            CallChecker.varInit(this.zero, "zero", 491, 15473, 15605);
            CallChecker.varInit(this.radixDigits, "radixDigits", 491, 15473, 15605);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 491, 15473, 15605);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 491, 15473, 15605);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 491, 15473, 15605);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 491, 15473, 15605);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 491, 15473, 15605);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 491, 15473, 15605);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 491, 15473, 15605);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 491, 15473, 15605);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 491, 15473, 15605);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 491, 15473, 15605);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 491, 15473, 15605);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 491, 15473, 15605);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 491, 15473, 15605);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 491, 15473, 15605);
            return ln2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4674.methodEnd();
        }
    }

    public Dfp[] getLn2Split() {
        MethodContext _bcornu_methode_context4675 = new MethodContext(Dfp[].class, 498, 15612, 15804);
        try {
            CallChecker.varInit(this, "this", 498, 15612, 15804);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 498, 15612, 15804);
            CallChecker.varInit(this.rMode, "rMode", 498, 15612, 15804);
            CallChecker.varInit(this.ln10, "ln10", 498, 15612, 15804);
            CallChecker.varInit(this.ln5Split, "ln5Split", 498, 15612, 15804);
            CallChecker.varInit(this.ln5, "ln5", 498, 15612, 15804);
            CallChecker.varInit(this.ln2Split, "ln2Split", 498, 15612, 15804);
            CallChecker.varInit(this.ln2, "ln2", 498, 15612, 15804);
            CallChecker.varInit(this.eSplit, "eSplit", 498, 15612, 15804);
            CallChecker.varInit(this.e, "e", 498, 15612, 15804);
            CallChecker.varInit(this.piSplit, "piSplit", 498, 15612, 15804);
            CallChecker.varInit(this.pi, "pi", 498, 15612, 15804);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 498, 15612, 15804);
            CallChecker.varInit(this.sqr3, "sqr3", 498, 15612, 15804);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 498, 15612, 15804);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 498, 15612, 15804);
            CallChecker.varInit(this.sqr2, "sqr2", 498, 15612, 15804);
            CallChecker.varInit(this.two, "two", 498, 15612, 15804);
            CallChecker.varInit(this.one, "one", 498, 15612, 15804);
            CallChecker.varInit(this.zero, "zero", 498, 15612, 15804);
            CallChecker.varInit(this.radixDigits, "radixDigits", 498, 15612, 15804);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 498, 15612, 15804);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 498, 15612, 15804);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 498, 15612, 15804);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 498, 15612, 15804);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 498, 15612, 15804);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 498, 15612, 15804);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 498, 15612, 15804);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 498, 15612, 15804);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 498, 15612, 15804);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 498, 15612, 15804);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 498, 15612, 15804);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 498, 15612, 15804);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 498, 15612, 15804);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 498, 15612, 15804);
            if (CallChecker.beforeDeref(ln2Split, Dfp[].class, 499, 15782, 15789)) {
                return CallChecker.isCalled(ln2Split, Dfp[].class, 499, 15782, 15789).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4675.methodEnd();
        }
    }

    public Dfp getLn5() {
        MethodContext _bcornu_methode_context4676 = new MethodContext(Dfp.class, 505, 15811, 15943);
        try {
            CallChecker.varInit(this, "this", 505, 15811, 15943);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 505, 15811, 15943);
            CallChecker.varInit(this.rMode, "rMode", 505, 15811, 15943);
            CallChecker.varInit(this.ln10, "ln10", 505, 15811, 15943);
            CallChecker.varInit(this.ln5Split, "ln5Split", 505, 15811, 15943);
            CallChecker.varInit(this.ln5, "ln5", 505, 15811, 15943);
            CallChecker.varInit(this.ln2Split, "ln2Split", 505, 15811, 15943);
            CallChecker.varInit(this.ln2, "ln2", 505, 15811, 15943);
            CallChecker.varInit(this.eSplit, "eSplit", 505, 15811, 15943);
            CallChecker.varInit(this.e, "e", 505, 15811, 15943);
            CallChecker.varInit(this.piSplit, "piSplit", 505, 15811, 15943);
            CallChecker.varInit(this.pi, "pi", 505, 15811, 15943);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 505, 15811, 15943);
            CallChecker.varInit(this.sqr3, "sqr3", 505, 15811, 15943);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 505, 15811, 15943);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 505, 15811, 15943);
            CallChecker.varInit(this.sqr2, "sqr2", 505, 15811, 15943);
            CallChecker.varInit(this.two, "two", 505, 15811, 15943);
            CallChecker.varInit(this.one, "one", 505, 15811, 15943);
            CallChecker.varInit(this.zero, "zero", 505, 15811, 15943);
            CallChecker.varInit(this.radixDigits, "radixDigits", 505, 15811, 15943);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 505, 15811, 15943);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 505, 15811, 15943);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 505, 15811, 15943);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 505, 15811, 15943);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 505, 15811, 15943);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 505, 15811, 15943);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 505, 15811, 15943);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 505, 15811, 15943);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 505, 15811, 15943);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 505, 15811, 15943);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 505, 15811, 15943);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 505, 15811, 15943);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 505, 15811, 15943);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 505, 15811, 15943);
            return ln5;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4676.methodEnd();
        }
    }

    public Dfp[] getLn5Split() {
        MethodContext _bcornu_methode_context4677 = new MethodContext(Dfp[].class, 512, 15950, 16142);
        try {
            CallChecker.varInit(this, "this", 512, 15950, 16142);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 512, 15950, 16142);
            CallChecker.varInit(this.rMode, "rMode", 512, 15950, 16142);
            CallChecker.varInit(this.ln10, "ln10", 512, 15950, 16142);
            CallChecker.varInit(this.ln5Split, "ln5Split", 512, 15950, 16142);
            CallChecker.varInit(this.ln5, "ln5", 512, 15950, 16142);
            CallChecker.varInit(this.ln2Split, "ln2Split", 512, 15950, 16142);
            CallChecker.varInit(this.ln2, "ln2", 512, 15950, 16142);
            CallChecker.varInit(this.eSplit, "eSplit", 512, 15950, 16142);
            CallChecker.varInit(this.e, "e", 512, 15950, 16142);
            CallChecker.varInit(this.piSplit, "piSplit", 512, 15950, 16142);
            CallChecker.varInit(this.pi, "pi", 512, 15950, 16142);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 512, 15950, 16142);
            CallChecker.varInit(this.sqr3, "sqr3", 512, 15950, 16142);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 512, 15950, 16142);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 512, 15950, 16142);
            CallChecker.varInit(this.sqr2, "sqr2", 512, 15950, 16142);
            CallChecker.varInit(this.two, "two", 512, 15950, 16142);
            CallChecker.varInit(this.one, "one", 512, 15950, 16142);
            CallChecker.varInit(this.zero, "zero", 512, 15950, 16142);
            CallChecker.varInit(this.radixDigits, "radixDigits", 512, 15950, 16142);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 512, 15950, 16142);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 512, 15950, 16142);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 512, 15950, 16142);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 512, 15950, 16142);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 512, 15950, 16142);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 512, 15950, 16142);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 512, 15950, 16142);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 512, 15950, 16142);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 512, 15950, 16142);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 512, 15950, 16142);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 512, 15950, 16142);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 512, 15950, 16142);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 512, 15950, 16142);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 512, 15950, 16142);
            if (CallChecker.beforeDeref(ln5Split, Dfp[].class, 513, 16120, 16127)) {
                return CallChecker.isCalled(ln5Split, Dfp[].class, 513, 16120, 16127).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4677.methodEnd();
        }
    }

    public Dfp getLn10() {
        MethodContext _bcornu_methode_context4678 = new MethodContext(Dfp.class, 519, 16149, 16285);
        try {
            CallChecker.varInit(this, "this", 519, 16149, 16285);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 519, 16149, 16285);
            CallChecker.varInit(this.rMode, "rMode", 519, 16149, 16285);
            CallChecker.varInit(this.ln10, "ln10", 519, 16149, 16285);
            CallChecker.varInit(this.ln5Split, "ln5Split", 519, 16149, 16285);
            CallChecker.varInit(this.ln5, "ln5", 519, 16149, 16285);
            CallChecker.varInit(this.ln2Split, "ln2Split", 519, 16149, 16285);
            CallChecker.varInit(this.ln2, "ln2", 519, 16149, 16285);
            CallChecker.varInit(this.eSplit, "eSplit", 519, 16149, 16285);
            CallChecker.varInit(this.e, "e", 519, 16149, 16285);
            CallChecker.varInit(this.piSplit, "piSplit", 519, 16149, 16285);
            CallChecker.varInit(this.pi, "pi", 519, 16149, 16285);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 519, 16149, 16285);
            CallChecker.varInit(this.sqr3, "sqr3", 519, 16149, 16285);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 519, 16149, 16285);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 519, 16149, 16285);
            CallChecker.varInit(this.sqr2, "sqr2", 519, 16149, 16285);
            CallChecker.varInit(this.two, "two", 519, 16149, 16285);
            CallChecker.varInit(this.one, "one", 519, 16149, 16285);
            CallChecker.varInit(this.zero, "zero", 519, 16149, 16285);
            CallChecker.varInit(this.radixDigits, "radixDigits", 519, 16149, 16285);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 519, 16149, 16285);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 519, 16149, 16285);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 519, 16149, 16285);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 519, 16149, 16285);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 519, 16149, 16285);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 519, 16149, 16285);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 519, 16149, 16285);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 519, 16149, 16285);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 519, 16149, 16285);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 519, 16149, 16285);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 519, 16149, 16285);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 519, 16149, 16285);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 519, 16149, 16285);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 519, 16149, 16285);
            return ln10;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4678.methodEnd();
        }
    }

    private Dfp[] split(final String a) {
        MethodContext _bcornu_methode_context4679 = new MethodContext(Dfp[].class, 529, 16292, 17583);
        try {
            CallChecker.varInit(this, "this", 529, 16292, 17583);
            CallChecker.varInit(a, "a", 529, 16292, 17583);
            CallChecker.varInit(this.ieeeFlags, "ieeeFlags", 529, 16292, 17583);
            CallChecker.varInit(this.rMode, "rMode", 529, 16292, 17583);
            CallChecker.varInit(this.ln10, "ln10", 529, 16292, 17583);
            CallChecker.varInit(this.ln5Split, "ln5Split", 529, 16292, 17583);
            CallChecker.varInit(this.ln5, "ln5", 529, 16292, 17583);
            CallChecker.varInit(this.ln2Split, "ln2Split", 529, 16292, 17583);
            CallChecker.varInit(this.ln2, "ln2", 529, 16292, 17583);
            CallChecker.varInit(this.eSplit, "eSplit", 529, 16292, 17583);
            CallChecker.varInit(this.e, "e", 529, 16292, 17583);
            CallChecker.varInit(this.piSplit, "piSplit", 529, 16292, 17583);
            CallChecker.varInit(this.pi, "pi", 529, 16292, 17583);
            CallChecker.varInit(this.sqr3Reciprocal, "sqr3Reciprocal", 529, 16292, 17583);
            CallChecker.varInit(this.sqr3, "sqr3", 529, 16292, 17583);
            CallChecker.varInit(this.sqr2Reciprocal, "sqr2Reciprocal", 529, 16292, 17583);
            CallChecker.varInit(this.sqr2Split, "sqr2Split", 529, 16292, 17583);
            CallChecker.varInit(this.sqr2, "sqr2", 529, 16292, 17583);
            CallChecker.varInit(this.two, "two", 529, 16292, 17583);
            CallChecker.varInit(this.one, "one", 529, 16292, 17583);
            CallChecker.varInit(this.zero, "zero", 529, 16292, 17583);
            CallChecker.varInit(this.radixDigits, "radixDigits", 529, 16292, 17583);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 529, 16292, 17583);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 529, 16292, 17583);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 529, 16292, 17583);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 529, 16292, 17583);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 529, 16292, 17583);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 529, 16292, 17583);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 529, 16292, 17583);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 529, 16292, 17583);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 529, 16292, 17583);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 529, 16292, 17583);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 529, 16292, 17583);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 529, 16292, 17583);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 529, 16292, 17583);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 529, 16292, 17583);
            Dfp[] result = CallChecker.varInit(new Dfp[2], "result", 530, 16685, 16710);
            boolean leading = CallChecker.varInit(((boolean) (true)), "leading", 531, 16718, 16740);
            int sp = CallChecker.varInit(((int) (0)), "sp", 532, 16748, 16758);
            int sig = CallChecker.varInit(((int) (0)), "sig", 533, 16766, 16777);
            char[] buf = CallChecker.init(char[].class);
            if (CallChecker.beforeDeref(a, String.class, 535, 16808, 16808)) {
                buf = new char[CallChecker.isCalled(a, String.class, 535, 16808, 16808).length()];
                CallChecker.varAssign(buf, "buf", 535, 16808, 16808);
            }
            buf = CallChecker.beforeCalled(buf, char[].class, 537, 16848, 16850);
            for (int i = 0; i < (CallChecker.isCalled(buf, char[].class, 537, 16848, 16850).length); i++) {
                if (CallChecker.beforeDeref(buf, char[].class, 538, 16875, 16877)) {
                    if (CallChecker.beforeDeref(a, String.class, 538, 16884, 16884)) {
                        buf = CallChecker.beforeCalled(buf, char[].class, 538, 16875, 16877);
                        CallChecker.isCalled(buf, char[].class, 538, 16875, 16877)[i] = CallChecker.isCalled(a, String.class, 538, 16884, 16884).charAt(i);
                        CallChecker.varAssign(CallChecker.isCalled(buf, char[].class, 538, 16875, 16877)[i], "CallChecker.isCalled(buf, char[].class, 538, 16875, 16877)[i]", 538, 16875, 16895);
                    }
                }
                if (CallChecker.beforeDeref(buf, char[].class, 540, 16910, 16912)) {
                    if (CallChecker.beforeDeref(buf, char[].class, 540, 16927, 16929)) {
                        buf = CallChecker.beforeCalled(buf, char[].class, 540, 16910, 16912);
                        buf = CallChecker.beforeCalled(buf, char[].class, 540, 16927, 16929);
                        if (((CallChecker.isCalled(buf, char[].class, 540, 16910, 16912)[i]) >= '1') && ((CallChecker.isCalled(buf, char[].class, 540, 16927, 16929)[i]) <= '9')) {
                            leading = false;
                            CallChecker.varAssign(leading, "leading", 541, 16956, 16971);
                        }
                    }
                }
                if (CallChecker.beforeDeref(buf, char[].class, 544, 16996, 16998)) {
                    buf = CallChecker.beforeCalled(buf, char[].class, 544, 16996, 16998);
                    if ((CallChecker.isCalled(buf, char[].class, 544, 16996, 16998)[i]) == '.') {
                        sig += (400 - sig) % 4;
                        CallChecker.varAssign(sig, "sig", 545, 17023, 17045);
                        leading = false;
                        CallChecker.varAssign(leading, "leading", 546, 17057, 17072);
                    }
                }
                if (sig == (((radixDigits) / 2) * 4)) {
                    sp = i;
                    CallChecker.varAssign(sp, "sp", 550, 17139, 17145);
                    break;
                }
                if (CallChecker.beforeDeref(buf, char[].class, 554, 17187, 17189)) {
                    if (CallChecker.beforeDeref(buf, char[].class, 554, 17204, 17206)) {
                        buf = CallChecker.beforeCalled(buf, char[].class, 554, 17187, 17189);
                        buf = CallChecker.beforeCalled(buf, char[].class, 554, 17204, 17206);
                        if ((((CallChecker.isCalled(buf, char[].class, 554, 17187, 17189)[i]) >= '0') && ((CallChecker.isCalled(buf, char[].class, 554, 17204, 17206)[i]) <= '9')) && (!leading)) {
                            sig++;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp[].class, 559, 17278, 17283)) {
                result = CallChecker.beforeCalled(result, Dfp[].class, 559, 17278, 17283);
                CallChecker.isCalled(result, Dfp[].class, 559, 17278, 17283)[0] = new Dfp(this, new String(buf, 0, sp));
                CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 559, 17278, 17283)[0], "CallChecker.isCalled(result, Dfp[].class, 559, 17278, 17283)[0]", 559, 17278, 17327);
            }
            buf = CallChecker.beforeCalled(buf, char[].class, 561, 17356, 17358);
            for (int i = 0; i < (CallChecker.isCalled(buf, char[].class, 561, 17356, 17358).length); i++) {
                if (CallChecker.beforeDeref(buf, char[].class, 562, 17383, 17385)) {
                    if (CallChecker.beforeDeref(a, String.class, 562, 17392, 17392)) {
                        buf = CallChecker.beforeCalled(buf, char[].class, 562, 17383, 17385);
                        CallChecker.isCalled(buf, char[].class, 562, 17383, 17385)[i] = CallChecker.isCalled(a, String.class, 562, 17392, 17392).charAt(i);
                        CallChecker.varAssign(CallChecker.isCalled(buf, char[].class, 562, 17383, 17385)[i], "CallChecker.isCalled(buf, char[].class, 562, 17383, 17385)[i]", 562, 17383, 17403);
                    }
                }
                if (CallChecker.beforeDeref(buf, char[].class, 563, 17417, 17419)) {
                    if (CallChecker.beforeDeref(buf, char[].class, 563, 17434, 17436)) {
                        buf = CallChecker.beforeCalled(buf, char[].class, 563, 17417, 17419);
                        buf = CallChecker.beforeCalled(buf, char[].class, 563, 17434, 17436);
                        if ((((CallChecker.isCalled(buf, char[].class, 563, 17417, 17419)[i]) >= '0') && ((CallChecker.isCalled(buf, char[].class, 563, 17434, 17436)[i]) <= '9')) && (i < sp)) {
                            if (CallChecker.beforeDeref(buf, char[].class, 564, 17473, 17475)) {
                                buf = CallChecker.beforeCalled(buf, char[].class, 564, 17473, 17475);
                                CallChecker.isCalled(buf, char[].class, 564, 17473, 17475)[i] = '0';
                                CallChecker.varAssign(CallChecker.isCalled(buf, char[].class, 564, 17473, 17475)[i], "CallChecker.isCalled(buf, char[].class, 564, 17473, 17475)[i]", 564, 17473, 17485);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp[].class, 568, 17512, 17517)) {
                result = CallChecker.beforeCalled(result, Dfp[].class, 568, 17512, 17517);
                CallChecker.isCalled(result, Dfp[].class, 568, 17512, 17517)[1] = new Dfp(this, new String(buf));
                CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 568, 17512, 17517)[1], "CallChecker.isCalled(result, Dfp[].class, 568, 17512, 17517)[1]", 568, 17512, 17554);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4679.methodEnd();
        }
    }

    private static void computeStringConstants(final int highPrecisionDecimalDigits) {
        MethodContext _bcornu_methode_context4680 = new MethodContext(void.class, 577, 17590, 19328);
        try {
            CallChecker.varInit(highPrecisionDecimalDigits, "highPrecisionDecimalDigits", 577, 17590, 19328);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 577, 17590, 19328);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 577, 17590, 19328);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 577, 17590, 19328);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 577, 17590, 19328);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 577, 17590, 19328);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 577, 17590, 19328);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 577, 17590, 19328);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 577, 17590, 19328);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 577, 17590, 19328);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 577, 17590, 19328);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 577, 17590, 19328);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 577, 17590, 19328);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 577, 17590, 19328);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 577, 17590, 19328);
            if (((DfpField.sqr2String) == null) || ((DfpField.sqr2String.length()) < (highPrecisionDecimalDigits - 3))) {
                final DfpField highPrecisionField = CallChecker.varInit(new DfpField(highPrecisionDecimalDigits, false), "highPrecisionField", 581, 17936, 18102);
                final Dfp highPrecisionOne = CallChecker.varInit(new Dfp(highPrecisionField, 1), "highPrecisionOne", 582, 18116, 18182);
                final Dfp highPrecisionTwo = CallChecker.varInit(new Dfp(highPrecisionField, 2), "highPrecisionTwo", 583, 18196, 18262);
                final Dfp highPrecisionThree = CallChecker.varInit(new Dfp(highPrecisionField, 3), "highPrecisionThree", 584, 18276, 18342);
                final Dfp highPrecisionSqr2 = CallChecker.varInit(CallChecker.isCalled(highPrecisionTwo, Dfp.class, 586, 18387, 18402).sqrt(), "highPrecisionSqr2", 586, 18357, 18410);
                if (CallChecker.beforeDeref(highPrecisionSqr2, Dfp.class, 587, 18447, 18463)) {
                    DfpField.sqr2String = CallChecker.isCalled(highPrecisionSqr2, Dfp.class, 587, 18447, 18463).toString();
                    CallChecker.varAssign(DfpField.sqr2String, "DfpField.sqr2String", 587, 18424, 18475);
                }
                if (CallChecker.beforeDeref(highPrecisionOne, Dfp.class, 588, 18512, 18527)) {
                    final Dfp npe_invocation_var938 = CallChecker.isCalled(highPrecisionOne, Dfp.class, 588, 18512, 18527).divide(highPrecisionSqr2);
                    if (CallChecker.beforeDeref(npe_invocation_var938, Dfp.class, 588, 18512, 18553)) {
                        DfpField.sqr2ReciprocalString = CallChecker.isCalled(npe_invocation_var938, Dfp.class, 588, 18512, 18553).toString();
                        CallChecker.varAssign(DfpField.sqr2ReciprocalString, "DfpField.sqr2ReciprocalString", 588, 18489, 18565);
                    }
                }
                final Dfp highPrecisionSqr3 = CallChecker.varInit(CallChecker.isCalled(highPrecisionThree, Dfp.class, 590, 18610, 18627).sqrt(), "highPrecisionSqr3", 590, 18580, 18635);
                if (CallChecker.beforeDeref(highPrecisionSqr3, Dfp.class, 591, 18672, 18688)) {
                    DfpField.sqr3String = CallChecker.isCalled(highPrecisionSqr3, Dfp.class, 591, 18672, 18688).toString();
                    CallChecker.varAssign(DfpField.sqr3String, "DfpField.sqr3String", 591, 18649, 18700);
                }
                if (CallChecker.beforeDeref(highPrecisionOne, Dfp.class, 592, 18737, 18752)) {
                    final Dfp npe_invocation_var939 = CallChecker.isCalled(highPrecisionOne, Dfp.class, 592, 18737, 18752).divide(highPrecisionSqr3);
                    if (CallChecker.beforeDeref(npe_invocation_var939, Dfp.class, 592, 18737, 18778)) {
                        DfpField.sqr3ReciprocalString = CallChecker.isCalled(npe_invocation_var939, Dfp.class, 592, 18737, 18778).toString();
                        CallChecker.varAssign(DfpField.sqr3ReciprocalString, "DfpField.sqr3ReciprocalString", 592, 18714, 18790);
                    }
                }
                final Dfp npe_invocation_var940 = DfpField.computePi(highPrecisionOne, highPrecisionTwo, highPrecisionThree);
                if (CallChecker.beforeDeref(npe_invocation_var940, Dfp.class, 594, 18818, 18882)) {
                    DfpField.piString = CallChecker.isCalled(npe_invocation_var940, Dfp.class, 594, 18818, 18882).toString();
                    CallChecker.varAssign(DfpField.piString, "DfpField.piString", 594, 18805, 18894);
                }
                final Dfp npe_invocation_var941 = DfpField.computeExp(highPrecisionOne, highPrecisionOne);
                if (CallChecker.beforeDeref(npe_invocation_var941, Dfp.class, 595, 18921, 18966)) {
                    DfpField.eString = CallChecker.isCalled(npe_invocation_var941, Dfp.class, 595, 18921, 18966).toString();
                    CallChecker.varAssign(DfpField.eString, "DfpField.eString", 595, 18908, 18978);
                }
                final Dfp npe_invocation_var942 = DfpField.computeLn(highPrecisionTwo, highPrecisionOne, highPrecisionTwo);
                if (CallChecker.beforeDeref(npe_invocation_var942, Dfp.class, 596, 19005, 19067)) {
                    DfpField.ln2String = CallChecker.isCalled(npe_invocation_var942, Dfp.class, 596, 19005, 19067).toString();
                    CallChecker.varAssign(DfpField.ln2String, "DfpField.ln2String", 596, 18992, 19079);
                }
                final Dfp npe_invocation_var943 = DfpField.computeLn(new Dfp(highPrecisionField, 5), highPrecisionOne, highPrecisionTwo);
                if (CallChecker.beforeDeref(npe_invocation_var943, Dfp.class, 597, 19106, 19183)) {
                    DfpField.ln5String = CallChecker.isCalled(npe_invocation_var943, Dfp.class, 597, 19106, 19183).toString();
                    CallChecker.varAssign(DfpField.ln5String, "DfpField.ln5String", 597, 19093, 19195);
                }
                final Dfp npe_invocation_var944 = DfpField.computeLn(new Dfp(highPrecisionField, 10), highPrecisionOne, highPrecisionTwo);
                if (CallChecker.beforeDeref(npe_invocation_var944, Dfp.class, 598, 19222, 19299)) {
                    DfpField.ln10String = CallChecker.isCalled(npe_invocation_var944, Dfp.class, 598, 19222, 19299).toString();
                    CallChecker.varAssign(DfpField.ln10String, "DfpField.ln10String", 598, 19209, 19311);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4680.methodEnd();
        }
    }

    private static Dfp computePi(final Dfp one, final Dfp two, final Dfp three) {
        MethodContext _bcornu_methode_context4681 = new MethodContext(Dfp.class, 609, 19335, 21029);
        try {
            CallChecker.varInit(three, "three", 609, 19335, 21029);
            CallChecker.varInit(two, "two", 609, 19335, 21029);
            CallChecker.varInit(one, "one", 609, 19335, 21029);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 609, 19335, 21029);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 609, 19335, 21029);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 609, 19335, 21029);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 609, 19335, 21029);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 609, 19335, 21029);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 609, 19335, 21029);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 609, 19335, 21029);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 609, 19335, 21029);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 609, 19335, 21029);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 609, 19335, 21029);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 609, 19335, 21029);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 609, 19335, 21029);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 609, 19335, 21029);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 609, 19335, 21029);
            Dfp sqrt2 = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(two, Dfp.class, 611, 19720, 19722)) {
                sqrt2 = CallChecker.isCalled(two, Dfp.class, 611, 19720, 19722).sqrt();
                CallChecker.varAssign(sqrt2, "sqrt2", 611, 19720, 19722);
            }
            Dfp yk = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(sqrt2, Dfp.class, 612, 19754, 19758)) {
                sqrt2 = CallChecker.beforeCalled(sqrt2, Dfp.class, 612, 19754, 19758);
                yk = CallChecker.isCalled(sqrt2, Dfp.class, 612, 19754, 19758).subtract(one);
                CallChecker.varAssign(yk, "yk", 612, 19754, 19758);
            }
            Dfp four = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(two, Dfp.class, 613, 19797, 19799)) {
                four = CallChecker.isCalled(two, Dfp.class, 613, 19797, 19799).add(two);
                CallChecker.varAssign(four, "four", 613, 19797, 19799);
            }
            Dfp two2kp3 = CallChecker.varInit(two, "two2kp3", 614, 19819, 19836);
            Dfp ak = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(two, Dfp.class, 615, 19888, 19890)) {
                if (CallChecker.beforeDeref(three, Dfp.class, 615, 19873, 19877)) {
                    if (CallChecker.beforeDeref(two, Dfp.class, 615, 19860, 19862)) {
                        ak = CallChecker.isCalled(two, Dfp.class, 615, 19860, 19862).multiply(CallChecker.isCalled(three, Dfp.class, 615, 19873, 19877).subtract(CallChecker.isCalled(two, Dfp.class, 615, 19888, 19890).multiply(sqrt2)));
                        CallChecker.varAssign(ak, "ak", 615, 19888, 19890);
                    }
                }
            }
            for (int i = 1; i < 20; i++) {
                final Dfp ykM1 = CallChecker.varInit(yk, "ykM1", 624, 20405, 20424);
                yk = CallChecker.beforeCalled(yk, Dfp.class, 626, 20462, 20463);
                final Dfp y2 = CallChecker.varInit(CallChecker.isCalled(yk, Dfp.class, 626, 20462, 20463).multiply(yk), "y2", 626, 20439, 20477);
                final Dfp oneMinusY4 = CallChecker.varInit(CallChecker.isCalled(one, Dfp.class, 627, 20514, 20516).subtract(CallChecker.isCalled(y2, Dfp.class, 627, 20527, 20528).multiply(y2)), "oneMinusY4", 627, 20491, 20543);
                final Dfp s = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(oneMinusY4, Dfp.class, 628, 20580, 20589).sqrt(), Dfp.class, 628, 20580, 20596).sqrt(), "s", 628, 20557, 20604);
                if (CallChecker.beforeDeref(one, Dfp.class, 629, 20623, 20625)) {
                    if (CallChecker.beforeDeref(one, Dfp.class, 629, 20646, 20648)) {
                        final Dfp npe_invocation_var945 = CallChecker.isCalled(one, Dfp.class, 629, 20623, 20625).subtract(s);
                        if (CallChecker.beforeDeref(npe_invocation_var945, Dfp.class, 629, 20623, 20637)) {
                            yk = CallChecker.isCalled(npe_invocation_var945, Dfp.class, 629, 20623, 20637).divide(CallChecker.isCalled(one, Dfp.class, 629, 20646, 20648).add(s));
                            CallChecker.varAssign(yk, "yk", 629, 20618, 20657);
                        }
                    }
                }
                if (CallChecker.beforeDeref(two2kp3, Dfp.class, 631, 20682, 20688)) {
                    two2kp3 = CallChecker.beforeCalled(two2kp3, Dfp.class, 631, 20682, 20688);
                    two2kp3 = CallChecker.isCalled(two2kp3, Dfp.class, 631, 20682, 20688).multiply(four);
                    CallChecker.varAssign(two2kp3, "two2kp3", 631, 20672, 20704);
                }
                final Dfp p = CallChecker.varInit(CallChecker.isCalled(one, Dfp.class, 633, 20733, 20735).add(yk), "p", 633, 20719, 20744);
                final Dfp p2 = CallChecker.varInit(CallChecker.isCalled(p, Dfp.class, 634, 20773, 20773).multiply(p), "p2", 634, 20758, 20786);
                if (CallChecker.beforeDeref(p2, Dfp.class, 635, 20817, 20818)) {
                    if (CallChecker.beforeDeref(ak, Dfp.class, 635, 20805, 20806)) {
                        if (CallChecker.beforeDeref(two2kp3, Dfp.class, 635, 20843, 20849)) {
                            if (CallChecker.beforeDeref(one, Dfp.class, 635, 20873, 20875)) {
                                if (CallChecker.beforeDeref(yk, Dfp.class, 635, 20889, 20890)) {
                                    final Dfp npe_invocation_var946 = CallChecker.isCalled(one, Dfp.class, 635, 20873, 20875).add(yk);
                                    if (CallChecker.beforeDeref(npe_invocation_var946, Dfp.class, 635, 20873, 20883)) {
                                        two2kp3 = CallChecker.beforeCalled(two2kp3, Dfp.class, 635, 20843, 20849);
                                        final Dfp npe_invocation_var947 = CallChecker.isCalled(two2kp3, Dfp.class, 635, 20843, 20849).multiply(yk);
                                        if (CallChecker.beforeDeref(npe_invocation_var947, Dfp.class, 635, 20843, 20862)) {
                                            ak = CallChecker.beforeCalled(ak, Dfp.class, 635, 20805, 20806);
                                            final Dfp npe_invocation_var948 = CallChecker.isCalled(ak, Dfp.class, 635, 20805, 20806).multiply(CallChecker.isCalled(p2, Dfp.class, 635, 20817, 20818).multiply(p2));
                                            if (CallChecker.beforeDeref(npe_invocation_var948, Dfp.class, 635, 20805, 20832)) {
                                                yk = CallChecker.beforeCalled(yk, Dfp.class, 635, 20889, 20890);
                                                ak = CallChecker.isCalled(npe_invocation_var948, Dfp.class, 635, 20805, 20832).subtract(CallChecker.isCalled(npe_invocation_var947, Dfp.class, 635, 20843, 20862).multiply(CallChecker.isCalled(npe_invocation_var946, Dfp.class, 635, 20873, 20883).add(CallChecker.isCalled(yk, Dfp.class, 635, 20889, 20890).multiply(yk))));
                                                CallChecker.varAssign(ak, "ak", 635, 20800, 20907);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(yk, Dfp.class, 637, 20926, 20927)) {
                    yk = CallChecker.beforeCalled(yk, Dfp.class, 637, 20926, 20927);
                    if (CallChecker.isCalled(yk, Dfp.class, 637, 20926, 20927).equals(ykM1)) {
                        break;
                    }
                }
            }
            if (CallChecker.beforeDeref(one, Dfp.class, 642, 21008, 21010)) {
                return CallChecker.isCalled(one, Dfp.class, 642, 21008, 21010).divide(ak);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4681.methodEnd();
        }
    }

    public static Dfp computeExp(final Dfp a, final Dfp one) {
        MethodContext _bcornu_methode_context4682 = new MethodContext(Dfp.class, 651, 21036, 21727);
        try {
            CallChecker.varInit(one, "one", 651, 21036, 21727);
            CallChecker.varInit(a, "a", 651, 21036, 21727);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 651, 21036, 21727);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 651, 21036, 21727);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 651, 21036, 21727);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 651, 21036, 21727);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 651, 21036, 21727);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 651, 21036, 21727);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 651, 21036, 21727);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 651, 21036, 21727);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 651, 21036, 21727);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 651, 21036, 21727);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 651, 21036, 21727);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 651, 21036, 21727);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 651, 21036, 21727);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 651, 21036, 21727);
            Dfp y = CallChecker.varInit(new Dfp(one), "y", 653, 21276, 21297);
            Dfp py = CallChecker.varInit(new Dfp(one), "py", 654, 21307, 21328);
            Dfp f = CallChecker.varInit(new Dfp(one), "f", 655, 21338, 21359);
            Dfp fi = CallChecker.varInit(new Dfp(one), "fi", 656, 21369, 21390);
            Dfp x = CallChecker.varInit(new Dfp(one), "x", 657, 21400, 21421);
            for (int i = 0; i < 10000; i++) {
                if (CallChecker.beforeDeref(x, Dfp.class, 660, 21482, 21482)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 660, 21482, 21482);
                    x = CallChecker.isCalled(x, Dfp.class, 660, 21482, 21482).multiply(a);
                    CallChecker.varAssign(x, "x", 660, 21478, 21495);
                }
                if (CallChecker.beforeDeref(x, Dfp.class, 661, 21519, 21519)) {
                    if (CallChecker.beforeDeref(y, Dfp.class, 661, 21513, 21513)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 661, 21519, 21519);
                        y = CallChecker.beforeCalled(y, Dfp.class, 661, 21513, 21513);
                        y = CallChecker.isCalled(y, Dfp.class, 661, 21513, 21513).add(CallChecker.isCalled(x, Dfp.class, 661, 21519, 21519).divide(f));
                        CallChecker.varAssign(y, "y", 661, 21509, 21531);
                    }
                }
                if (CallChecker.beforeDeref(fi, Dfp.class, 662, 21550, 21551)) {
                    fi = CallChecker.beforeCalled(fi, Dfp.class, 662, 21550, 21551);
                    fi = CallChecker.isCalled(fi, Dfp.class, 662, 21550, 21551).add(one);
                    CallChecker.varAssign(fi, "fi", 662, 21545, 21561);
                }
                if (CallChecker.beforeDeref(f, Dfp.class, 663, 21579, 21579)) {
                    f = CallChecker.beforeCalled(f, Dfp.class, 663, 21579, 21579);
                    f = CallChecker.isCalled(f, Dfp.class, 663, 21579, 21579).multiply(fi);
                    CallChecker.varAssign(f, "f", 663, 21575, 21593);
                }
                if (CallChecker.beforeDeref(y, Dfp.class, 664, 21611, 21611)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 664, 21611, 21611);
                    if (CallChecker.isCalled(y, Dfp.class, 664, 21611, 21611).equals(py)) {
                        break;
                    }
                }
                py = new Dfp(y);
                CallChecker.varAssign(py, "py", 667, 21676, 21691);
            }
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4682.methodEnd();
        }
    }

    public static Dfp computeLn(final Dfp a, final Dfp one, final Dfp two) {
        MethodContext _bcornu_methode_context4683 = new MethodContext(Dfp.class, 734, 21735, 24583);
        try {
            CallChecker.varInit(two, "two", 734, 21735, 24583);
            CallChecker.varInit(one, "one", 734, 21735, 24583);
            CallChecker.varInit(a, "a", 734, 21735, 24583);
            CallChecker.varInit(DfpField.ln10String, "org.apache.commons.math3.dfp.DfpField.ln10String", 734, 21735, 24583);
            CallChecker.varInit(DfpField.ln5String, "org.apache.commons.math3.dfp.DfpField.ln5String", 734, 21735, 24583);
            CallChecker.varInit(DfpField.ln2String, "org.apache.commons.math3.dfp.DfpField.ln2String", 734, 21735, 24583);
            CallChecker.varInit(DfpField.eString, "org.apache.commons.math3.dfp.DfpField.eString", 734, 21735, 24583);
            CallChecker.varInit(DfpField.piString, "org.apache.commons.math3.dfp.DfpField.piString", 734, 21735, 24583);
            CallChecker.varInit(DfpField.sqr3ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr3ReciprocalString", 734, 21735, 24583);
            CallChecker.varInit(DfpField.sqr3String, "org.apache.commons.math3.dfp.DfpField.sqr3String", 734, 21735, 24583);
            CallChecker.varInit(DfpField.sqr2ReciprocalString, "org.apache.commons.math3.dfp.DfpField.sqr2ReciprocalString", 734, 21735, 24583);
            CallChecker.varInit(DfpField.sqr2String, "org.apache.commons.math3.dfp.DfpField.sqr2String", 734, 21735, 24583);
            CallChecker.varInit(FLAG_INEXACT, "org.apache.commons.math3.dfp.DfpField.FLAG_INEXACT", 734, 21735, 24583);
            CallChecker.varInit(FLAG_UNDERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_UNDERFLOW", 734, 21735, 24583);
            CallChecker.varInit(FLAG_OVERFLOW, "org.apache.commons.math3.dfp.DfpField.FLAG_OVERFLOW", 734, 21735, 24583);
            CallChecker.varInit(FLAG_DIV_ZERO, "org.apache.commons.math3.dfp.DfpField.FLAG_DIV_ZERO", 734, 21735, 24583);
            CallChecker.varInit(FLAG_INVALID, "org.apache.commons.math3.dfp.DfpField.FLAG_INVALID", 734, 21735, 24583);
            int den = CallChecker.varInit(((int) (1)), "den", 736, 24065, 24076);
            Dfp x = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(a, Dfp.class, 737, 24108, 24108)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 737, 24094, 24094)) {
                    if (CallChecker.beforeDeref(a, Dfp.class, 737, 24134, 24134)) {
                        final Dfp npe_invocation_var949 = CallChecker.isCalled(a, Dfp.class, 737, 24094, 24094).add(new Dfp(CallChecker.isCalled(a, Dfp.class, 737, 24108, 24108).getField(), (-1)));
                        if (CallChecker.beforeDeref(npe_invocation_var949, Dfp.class, 737, 24094, 24125)) {
                            x = CallChecker.isCalled(npe_invocation_var949, Dfp.class, 737, 24094, 24125).divide(CallChecker.isCalled(a, Dfp.class, 737, 24134, 24134).add(one));
                            CallChecker.varAssign(x, "x", 737, 24108, 24108);
                        }
                    }
                }
            }
            Dfp y = CallChecker.varInit(new Dfp(x), "y", 739, 24156, 24174);
            Dfp num = CallChecker.varInit(new Dfp(x), "num", 740, 24184, 24204);
            Dfp py = CallChecker.varInit(new Dfp(y), "py", 741, 24214, 24233);
            for (int i = 0; i < 10000; i++) {
                if (CallChecker.beforeDeref(num, Dfp.class, 743, 24295, 24297)) {
                    num = CallChecker.beforeCalled(num, Dfp.class, 743, 24295, 24297);
                    num = CallChecker.isCalled(num, Dfp.class, 743, 24295, 24297).multiply(x);
                    CallChecker.varAssign(num, "num", 743, 24289, 24310);
                }
                if (CallChecker.beforeDeref(num, Dfp.class, 744, 24330, 24332)) {
                    num = CallChecker.beforeCalled(num, Dfp.class, 744, 24330, 24332);
                    num = CallChecker.isCalled(num, Dfp.class, 744, 24330, 24332).multiply(x);
                    CallChecker.varAssign(num, "num", 744, 24324, 24345);
                }
                den = den + 2;
                CallChecker.varAssign(den, "den", 745, 24359, 24372);
                Dfp t = CallChecker.init(Dfp.class);
                if (CallChecker.beforeDeref(num, Dfp.class, 746, 24394, 24396)) {
                    num = CallChecker.beforeCalled(num, Dfp.class, 746, 24394, 24396);
                    t = CallChecker.isCalled(num, Dfp.class, 746, 24394, 24396).divide(den);
                    CallChecker.varAssign(t, "t", 746, 24394, 24396);
                }
                if (CallChecker.beforeDeref(y, Dfp.class, 747, 24427, 24427)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 747, 24427, 24427);
                    y = CallChecker.isCalled(y, Dfp.class, 747, 24427, 24427).add(t);
                    CallChecker.varAssign(y, "y", 747, 24423, 24435);
                }
                if (CallChecker.beforeDeref(y, Dfp.class, 748, 24453, 24453)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 748, 24453, 24453);
                    if (CallChecker.isCalled(y, Dfp.class, 748, 24453, 24453).equals(py)) {
                        break;
                    }
                }
                py = new Dfp(y);
                CallChecker.varAssign(py, "py", 751, 24518, 24533);
            }
            if (CallChecker.beforeDeref(y, Dfp.class, 754, 24561, 24561)) {
                y = CallChecker.beforeCalled(y, Dfp.class, 754, 24561, 24561);
                return CallChecker.isCalled(y, Dfp.class, 754, 24561, 24561).multiply(two);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4683.methodEnd();
        }
    }
}

