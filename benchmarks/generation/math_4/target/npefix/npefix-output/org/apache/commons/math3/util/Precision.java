package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.math.BigDecimal;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class Precision {
    public static final double EPSILON;

    public static final double SAFE_MIN;

    private static final long EXPONENT_OFFSET = 1023L;

    private static final long SGN_MASK = -9223372036854775808L;

    private static final int SGN_MASK_FLOAT = -2147483648;

    static {
        EPSILON = Double.longBitsToDouble((((Precision.EXPONENT_OFFSET) - 53L) << 52));
        CallChecker.varAssign(EPSILON, "Precision.EPSILON", 70, 2505, 2569);
        SAFE_MIN = Double.longBitsToDouble((((Precision.EXPONENT_OFFSET) - 1022L) << 52));
        CallChecker.varAssign(SAFE_MIN, "Precision.SAFE_MIN", 77, 2762, 2829);
    }

    private Precision() {
        ConstructorContext _bcornu_methode_context874 = new ConstructorContext(Precision.class, 83, 2842, 2907);
        try {
        } finally {
            _bcornu_methode_context874.methodEnd();
        }
    }

    public static int compareTo(double x, double y, double eps) {
        MethodContext _bcornu_methode_context3896 = new MethodContext(int.class, 95, 2914, 3655);
        try {
            CallChecker.varInit(eps, "eps", 95, 2914, 3655);
            CallChecker.varInit(y, "y", 95, 2914, 3655);
            CallChecker.varInit(x, "x", 95, 2914, 3655);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 95, 2914, 3655);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 95, 2914, 3655);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 95, 2914, 3655);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 95, 2914, 3655);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 95, 2914, 3655);
            if (Precision.equals(x, y, eps)) {
                return 0;
            }else
                if (x < y) {
                    return -1;
                }
            
            return 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3896.methodEnd();
        }
    }

    public static int compareTo(final double x, final double y, final int maxUlps) {
        MethodContext _bcornu_methode_context3897 = new MethodContext(int.class, 121, 3662, 4810);
        try {
            CallChecker.varInit(maxUlps, "maxUlps", 121, 3662, 4810);
            CallChecker.varInit(y, "y", 121, 3662, 4810);
            CallChecker.varInit(x, "x", 121, 3662, 4810);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 121, 3662, 4810);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 121, 3662, 4810);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 121, 3662, 4810);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 121, 3662, 4810);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 121, 3662, 4810);
            if (Precision.equals(x, y, maxUlps)) {
                return 0;
            }else
                if (x < y) {
                    return -1;
                }
            
            return 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3897.methodEnd();
        }
    }

    public static boolean equals(float x, float y) {
        MethodContext _bcornu_methode_context3898 = new MethodContext(boolean.class, 138, 4817, 5145);
        try {
            CallChecker.varInit(y, "y", 138, 4817, 5145);
            CallChecker.varInit(x, "x", 138, 4817, 5145);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 138, 4817, 5145);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 138, 4817, 5145);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 138, 4817, 5145);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 138, 4817, 5145);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 138, 4817, 5145);
            return Precision.equals(x, y, 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3898.methodEnd();
        }
    }

    public static boolean equalsIncludingNaN(float x, float y) {
        MethodContext _bcornu_methode_context3899 = new MethodContext(boolean.class, 151, 5152, 5604);
        try {
            CallChecker.varInit(y, "y", 151, 5152, 5604);
            CallChecker.varInit(x, "x", 151, 5152, 5604);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 151, 5152, 5604);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 151, 5152, 5604);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 151, 5152, 5604);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 151, 5152, 5604);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 151, 5152, 5604);
            return ((Float.isNaN(x)) && (Float.isNaN(y))) || (Precision.equals(x, y, 1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3899.methodEnd();
        }
    }

    public static boolean equals(float x, float y, float eps) {
        MethodContext _bcornu_methode_context3900 = new MethodContext(boolean.class, 165, 5611, 6080);
        try {
            CallChecker.varInit(eps, "eps", 165, 5611, 6080);
            CallChecker.varInit(y, "y", 165, 5611, 6080);
            CallChecker.varInit(x, "x", 165, 5611, 6080);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 165, 5611, 6080);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 165, 5611, 6080);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 165, 5611, 6080);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 165, 5611, 6080);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 165, 5611, 6080);
            return (Precision.equals(x, y, 1)) || ((FastMath.abs((y - x))) <= eps);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3900.methodEnd();
        }
    }

    public static boolean equalsIncludingNaN(float x, float y, float eps) {
        MethodContext _bcornu_methode_context3901 = new MethodContext(boolean.class, 180, 6087, 6614);
        try {
            CallChecker.varInit(eps, "eps", 180, 6087, 6614);
            CallChecker.varInit(y, "y", 180, 6087, 6614);
            CallChecker.varInit(x, "x", 180, 6087, 6614);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 180, 6087, 6614);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 180, 6087, 6614);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 180, 6087, 6614);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 180, 6087, 6614);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 180, 6087, 6614);
            return (Precision.equalsIncludingNaN(x, y)) || ((FastMath.abs((y - x))) <= eps);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3901.methodEnd();
        }
    }

    public static boolean equals(float x, float y, int maxUlps) {
        MethodContext _bcornu_methode_context3902 = new MethodContext(boolean.class, 202, 6621, 7933);
        try {
            CallChecker.varInit(maxUlps, "maxUlps", 202, 6621, 7933);
            CallChecker.varInit(y, "y", 202, 6621, 7933);
            CallChecker.varInit(x, "x", 202, 6621, 7933);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 202, 6621, 7933);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 202, 6621, 7933);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 202, 6621, 7933);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 202, 6621, 7933);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 202, 6621, 7933);
            int xInt = CallChecker.varInit(((int) (Float.floatToIntBits(x))), "xInt", 203, 7489, 7523);
            int yInt = CallChecker.varInit(((int) (Float.floatToIntBits(y))), "yInt", 204, 7533, 7567);
            if (xInt < 0) {
                xInt = (Precision.SGN_MASK_FLOAT) - xInt;
                CallChecker.varAssign(xInt, "xInt", 208, 7679, 7707);
            }
            if (yInt < 0) {
                yInt = (Precision.SGN_MASK_FLOAT) - yInt;
                CallChecker.varAssign(yInt, "yInt", 211, 7755, 7783);
            }
            final boolean isEqual = CallChecker.varInit(((boolean) ((FastMath.abs((xInt - yInt))) <= maxUlps)), "isEqual", 214, 7804, 7864);
            return (isEqual && (!(Float.isNaN(x)))) && (!(Float.isNaN(y)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3902.methodEnd();
        }
    }

    public static boolean equalsIncludingNaN(float x, float y, int maxUlps) {
        MethodContext _bcornu_methode_context3903 = new MethodContext(boolean.class, 231, 7940, 8617);
        try {
            CallChecker.varInit(maxUlps, "maxUlps", 231, 7940, 8617);
            CallChecker.varInit(y, "y", 231, 7940, 8617);
            CallChecker.varInit(x, "x", 231, 7940, 8617);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 231, 7940, 8617);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 231, 7940, 8617);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 231, 7940, 8617);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 231, 7940, 8617);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 231, 7940, 8617);
            return ((Float.isNaN(x)) && (Float.isNaN(y))) || (Precision.equals(x, y, maxUlps));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3903.methodEnd();
        }
    }

    public static boolean equals(double x, double y) {
        MethodContext _bcornu_methode_context3904 = new MethodContext(boolean.class, 243, 8624, 8956);
        try {
            CallChecker.varInit(y, "y", 243, 8624, 8956);
            CallChecker.varInit(x, "x", 243, 8624, 8956);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 243, 8624, 8956);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 243, 8624, 8956);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 243, 8624, 8956);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 243, 8624, 8956);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 243, 8624, 8956);
            return Precision.equals(x, y, 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3904.methodEnd();
        }
    }

    public static boolean equalsIncludingNaN(double x, double y) {
        MethodContext _bcornu_methode_context3905 = new MethodContext(boolean.class, 256, 8963, 9421);
        try {
            CallChecker.varInit(y, "y", 256, 8963, 9421);
            CallChecker.varInit(x, "x", 256, 8963, 9421);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 256, 8963, 9421);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 256, 8963, 9421);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 256, 8963, 9421);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 256, 8963, 9421);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 256, 8963, 9421);
            return ((Double.isNaN(x)) && (Double.isNaN(y))) || (Precision.equals(x, y, 1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3905.methodEnd();
        }
    }

    public static boolean equals(double x, double y, double eps) {
        MethodContext _bcornu_methode_context3906 = new MethodContext(boolean.class, 271, 9428, 10002);
        try {
            CallChecker.varInit(eps, "eps", 271, 9428, 10002);
            CallChecker.varInit(y, "y", 271, 9428, 10002);
            CallChecker.varInit(x, "x", 271, 9428, 10002);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 271, 9428, 10002);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 271, 9428, 10002);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 271, 9428, 10002);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 271, 9428, 10002);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 271, 9428, 10002);
            return (Precision.equals(x, y, 1)) || ((FastMath.abs((y - x))) <= eps);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3906.methodEnd();
        }
    }

    public static boolean equalsWithRelativeTolerance(double x, double y, double eps) {
        MethodContext _bcornu_methode_context3907 = new MethodContext(boolean.class, 287, 10009, 10835);
        try {
            CallChecker.varInit(eps, "eps", 287, 10009, 10835);
            CallChecker.varInit(y, "y", 287, 10009, 10835);
            CallChecker.varInit(x, "x", 287, 10009, 10835);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 287, 10009, 10835);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 287, 10009, 10835);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 287, 10009, 10835);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 287, 10009, 10835);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 287, 10009, 10835);
            if (Precision.equals(x, y, 1)) {
                return true;
            }
            final double absoluteMax = CallChecker.varInit(((double) (FastMath.max(FastMath.abs(x), FastMath.abs(y)))), "absoluteMax", 292, 10634, 10707);
            final double relativeDifference = CallChecker.varInit(((double) (FastMath.abs(((x - y) / absoluteMax)))), "relativeDifference", 293, 10717, 10786);
            return relativeDifference <= eps;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3907.methodEnd();
        }
    }

    public static boolean equalsIncludingNaN(double x, double y, double eps) {
        MethodContext _bcornu_methode_context3908 = new MethodContext(boolean.class, 309, 10842, 11372);
        try {
            CallChecker.varInit(eps, "eps", 309, 10842, 11372);
            CallChecker.varInit(y, "y", 309, 10842, 11372);
            CallChecker.varInit(x, "x", 309, 10842, 11372);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 309, 10842, 11372);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 309, 10842, 11372);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 309, 10842, 11372);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 309, 10842, 11372);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 309, 10842, 11372);
            return (Precision.equalsIncludingNaN(x, y)) || ((FastMath.abs((y - x))) <= eps);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3908.methodEnd();
        }
    }

    public static boolean equals(double x, double y, int maxUlps) {
        MethodContext _bcornu_methode_context3909 = new MethodContext(boolean.class, 330, 11379, 12673);
        try {
            CallChecker.varInit(maxUlps, "maxUlps", 330, 11379, 12673);
            CallChecker.varInit(y, "y", 330, 11379, 12673);
            CallChecker.varInit(x, "x", 330, 11379, 12673);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 330, 11379, 12673);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 330, 11379, 12673);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 330, 11379, 12673);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 330, 11379, 12673);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 330, 11379, 12673);
            long xInt = CallChecker.varInit(((long) (Double.doubleToLongBits(x))), "xInt", 331, 12231, 12269);
            long yInt = CallChecker.varInit(((long) (Double.doubleToLongBits(y))), "yInt", 332, 12279, 12317);
            if (xInt < 0) {
                xInt = (Precision.SGN_MASK) - xInt;
                CallChecker.varAssign(xInt, "xInt", 336, 12429, 12451);
            }
            if (yInt < 0) {
                yInt = (Precision.SGN_MASK) - yInt;
                CallChecker.varAssign(yInt, "yInt", 339, 12499, 12521);
            }
            final boolean isEqual = CallChecker.varInit(((boolean) ((FastMath.abs((xInt - yInt))) <= maxUlps)), "isEqual", 342, 12542, 12602);
            return (isEqual && (!(Double.isNaN(x)))) && (!(Double.isNaN(y)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3909.methodEnd();
        }
    }

    public static boolean equalsIncludingNaN(double x, double y, int maxUlps) {
        MethodContext _bcornu_methode_context3910 = new MethodContext(boolean.class, 359, 12680, 13363);
        try {
            CallChecker.varInit(maxUlps, "maxUlps", 359, 12680, 13363);
            CallChecker.varInit(y, "y", 359, 12680, 13363);
            CallChecker.varInit(x, "x", 359, 12680, 13363);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 359, 12680, 13363);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 359, 12680, 13363);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 359, 12680, 13363);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 359, 12680, 13363);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 359, 12680, 13363);
            return ((Double.isNaN(x)) && (Double.isNaN(y))) || (Precision.equals(x, y, maxUlps));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3910.methodEnd();
        }
    }

    public static double round(double x, int scale) {
        MethodContext _bcornu_methode_context3911 = new MethodContext(double.class, 372, 13370, 13872);
        try {
            CallChecker.varInit(scale, "scale", 372, 13370, 13872);
            CallChecker.varInit(x, "x", 372, 13370, 13872);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 372, 13370, 13872);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 372, 13370, 13872);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 372, 13370, 13872);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 372, 13370, 13872);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 372, 13370, 13872);
            return Precision.round(x, scale, BigDecimal.ROUND_HALF_UP);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3911.methodEnd();
        }
    }

    public static double round(double x, int scale, int roundingMethod) {
        MethodContext _bcornu_methode_context3912 = new MethodContext(double.class, 393, 13879, 15226);
        try {
            CallChecker.varInit(roundingMethod, "roundingMethod", 393, 13879, 15226);
            CallChecker.varInit(scale, "scale", 393, 13879, 15226);
            CallChecker.varInit(x, "x", 393, 13879, 15226);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 393, 13879, 15226);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 393, 13879, 15226);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 393, 13879, 15226);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 393, 13879, 15226);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 393, 13879, 15226);
            TryContext _bcornu_try_context_87 = new TryContext(87, Precision.class, "java.lang.NumberFormatException");
            try {
                if (CallChecker.beforeDeref(new BigDecimal(Double.toString(x)), BigDecimal.class, 395, 14888, 14941)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(new BigDecimal(Double.toString(x)), BigDecimal.class, 395, 14888, 14941).setScale(scale, roundingMethod), BigDecimal.class, 395, 14887, 14994)) {
                        return CallChecker.isCalled(CallChecker.isCalled(new BigDecimal(Double.toString(x)), BigDecimal.class, 395, 14888, 14941).setScale(scale, roundingMethod), BigDecimal.class, 395, 14887, 14994).doubleValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (NumberFormatException ex) {
                _bcornu_try_context_87.catchStart(87);
                if (Double.isInfinite(x)) {
                    return x;
                }else {
                    return Double.NaN;
                }
            } finally {
                _bcornu_try_context_87.finallyStart(87);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3912.methodEnd();
        }
    }

    public static float round(float x, int scale) {
        MethodContext _bcornu_methode_context3913 = new MethodContext(float.class, 417, 15233, 15733);
        try {
            CallChecker.varInit(scale, "scale", 417, 15233, 15733);
            CallChecker.varInit(x, "x", 417, 15233, 15733);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 417, 15233, 15733);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 417, 15233, 15733);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 417, 15233, 15733);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 417, 15233, 15733);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 417, 15233, 15733);
            return Precision.round(x, scale, BigDecimal.ROUND_HALF_UP);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3913.methodEnd();
        }
    }

    public static float round(float x, int scale, int roundingMethod) throws MathArithmeticException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3914 = new MethodContext(float.class, 434, 15740, 16785);
        try {
            CallChecker.varInit(roundingMethod, "roundingMethod", 434, 15740, 16785);
            CallChecker.varInit(scale, "scale", 434, 15740, 16785);
            CallChecker.varInit(x, "x", 434, 15740, 16785);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 434, 15740, 16785);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 434, 15740, 16785);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 434, 15740, 16785);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 434, 15740, 16785);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 434, 15740, 16785);
            final float sign = CallChecker.varInit(((float) (FastMath.copySign(1.0F, x))), "sign", 436, 16583, 16626);
            final float factor = CallChecker.varInit(((float) (((float) (FastMath.pow(10.0F, scale))) * sign)), "factor", 437, 16636, 16698);
            return ((float) (Precision.roundUnscaled((x * factor), sign, roundingMethod))) / factor;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3914.methodEnd();
        }
    }

    private static double roundUnscaled(double unscaled, double sign, int roundingMethod) throws MathArithmeticException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3915 = new MethodContext(double.class, 454, 16792, 21380);
        try {
            CallChecker.varInit(roundingMethod, "roundingMethod", 454, 16792, 21380);
            CallChecker.varInit(sign, "sign", 454, 16792, 21380);
            CallChecker.varInit(unscaled, "unscaled", 454, 16792, 21380);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 454, 16792, 21380);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 454, 16792, 21380);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 454, 16792, 21380);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 454, 16792, 21380);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 454, 16792, 21380);
            switch (roundingMethod) {
                case BigDecimal.ROUND_CEILING :
                    if (sign == (-1)) {
                        unscaled = FastMath.floor(FastMath.nextAfter(unscaled, Double.NEGATIVE_INFINITY));
                        CallChecker.varAssign(unscaled, "unscaled", 461, 17847, 17928);
                    }else {
                        unscaled = FastMath.ceil(FastMath.nextAfter(unscaled, Double.POSITIVE_INFINITY));
                        CallChecker.varAssign(unscaled, "unscaled", 463, 17967, 18047);
                    }
                    break;
                case BigDecimal.ROUND_DOWN :
                    unscaled = FastMath.floor(FastMath.nextAfter(unscaled, Double.NEGATIVE_INFINITY));
                    CallChecker.varAssign(unscaled, "unscaled", 467, 18131, 18212);
                    break;
                case BigDecimal.ROUND_FLOOR :
                    if (sign == (-1)) {
                        unscaled = FastMath.ceil(FastMath.nextAfter(unscaled, Double.POSITIVE_INFINITY));
                        CallChecker.varAssign(unscaled, "unscaled", 471, 18317, 18397);
                    }else {
                        unscaled = FastMath.floor(FastMath.nextAfter(unscaled, Double.NEGATIVE_INFINITY));
                        CallChecker.varAssign(unscaled, "unscaled", 473, 18436, 18517);
                    }
                    break;
                case BigDecimal.ROUND_HALF_DOWN :
                    {
                        unscaled = FastMath.nextAfter(unscaled, Double.NEGATIVE_INFINITY);
                        CallChecker.varAssign(unscaled, "unscaled", 477, 18608, 18673);
                        double fraction = CallChecker.varInit(((double) (unscaled - (FastMath.floor(unscaled)))), "fraction", 478, 18687, 18740);
                        if (fraction > 0.5) {
                            unscaled = FastMath.ceil(unscaled);
                            CallChecker.varAssign(unscaled, "unscaled", 480, 18792, 18826);
                        }else {
                            unscaled = FastMath.floor(unscaled);
                            CallChecker.varAssign(unscaled, "unscaled", 482, 18865, 18900);
                        }
                        break;
                    }
                case BigDecimal.ROUND_HALF_EVEN :
                    {
                        double fraction = CallChecker.varInit(((double) (unscaled - (FastMath.floor(unscaled)))), "fraction", 487, 19001, 19054);
                        if (fraction > 0.5) {
                            unscaled = FastMath.ceil(unscaled);
                            CallChecker.varAssign(unscaled, "unscaled", 489, 19106, 19140);
                        }else
                            if (fraction < 0.5) {
                                unscaled = FastMath.floor(unscaled);
                                CallChecker.varAssign(unscaled, "unscaled", 491, 19199, 19234);
                            }else {
                                if (((FastMath.floor(unscaled)) / 2.0) == (FastMath.floor(((Math.floor(unscaled)) / 2.0)))) {
                                    unscaled = FastMath.floor(unscaled);
                                    CallChecker.varAssign(unscaled, "unscaled", 496, 19501, 19536);
                                }else {
                                    unscaled = FastMath.ceil(unscaled);
                                    CallChecker.varAssign(unscaled, "unscaled", 498, 19590, 19624);
                                }
                            }
                        
                        break;
                    }
                case BigDecimal.ROUND_HALF_UP :
                    {
                        unscaled = FastMath.nextAfter(unscaled, Double.POSITIVE_INFINITY);
                        CallChecker.varAssign(unscaled, "unscaled", 504, 19741, 19806);
                        double fraction = CallChecker.varInit(((double) (unscaled - (FastMath.floor(unscaled)))), "fraction", 505, 19820, 19873);
                        if (fraction >= 0.5) {
                            unscaled = FastMath.ceil(unscaled);
                            CallChecker.varAssign(unscaled, "unscaled", 507, 19926, 19960);
                        }else {
                            unscaled = FastMath.floor(unscaled);
                            CallChecker.varAssign(unscaled, "unscaled", 509, 19999, 20034);
                        }
                        break;
                    }
                case BigDecimal.ROUND_UNNECESSARY :
                    if (unscaled != (FastMath.floor(unscaled))) {
                        throw new MathArithmeticException();
                    }
                    break;
                case BigDecimal.ROUND_UP :
                    unscaled = FastMath.ceil(FastMath.nextAfter(unscaled, Double.POSITIVE_INFINITY));
                    CallChecker.varAssign(unscaled, "unscaled", 519, 20312, 20393);
                    break;
                default :
                    throw new MathIllegalArgumentException(LocalizedFormats.INVALID_ROUNDING_METHOD, roundingMethod, "ROUND_CEILING", BigDecimal.ROUND_CEILING, "ROUND_DOWN", BigDecimal.ROUND_DOWN, "ROUND_FLOOR", BigDecimal.ROUND_FLOOR, "ROUND_HALF_DOWN", BigDecimal.ROUND_HALF_DOWN, "ROUND_HALF_EVEN", BigDecimal.ROUND_HALF_EVEN, "ROUND_HALF_UP", BigDecimal.ROUND_HALF_UP, "ROUND_UNNECESSARY", BigDecimal.ROUND_UNNECESSARY, "ROUND_UP", BigDecimal.ROUND_UP);
            }
            return unscaled;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3915.methodEnd();
        }
    }

    public static double representableDelta(double x, double originalDelta) {
        MethodContext _bcornu_methode_context3916 = new MethodContext(double.class, 551, 21388, 22064);
        try {
            CallChecker.varInit(originalDelta, "originalDelta", 551, 21388, 22064);
            CallChecker.varInit(x, "x", 551, 21388, 22064);
            CallChecker.varInit(SGN_MASK_FLOAT, "org.apache.commons.math3.util.Precision.SGN_MASK_FLOAT", 551, 21388, 22064);
            CallChecker.varInit(SGN_MASK, "org.apache.commons.math3.util.Precision.SGN_MASK", 551, 21388, 22064);
            CallChecker.varInit(EXPONENT_OFFSET, "org.apache.commons.math3.util.Precision.EXPONENT_OFFSET", 551, 21388, 22064);
            CallChecker.varInit(SAFE_MIN, "org.apache.commons.math3.util.Precision.SAFE_MIN", 551, 21388, 22064);
            CallChecker.varInit(EPSILON, "org.apache.commons.math3.util.Precision.EPSILON", 551, 21388, 22064);
            return (x + originalDelta) - x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3916.methodEnd();
        }
    }
}

