package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public final class MathUtils {
    public static final double TWO_PI = 2 * (FastMath.PI);

    private MathUtils() {
        ConstructorContext _bcornu_methode_context1080 = new ConstructorContext(MathUtils.class, 47, 1466, 1546);
        try {
        } finally {
            _bcornu_methode_context1080.methodEnd();
        }
    }

    public static int hash(double value) {
        MethodContext _bcornu_methode_context4814 = new MethodContext(int.class, 56, 1554, 1810);
        try {
            CallChecker.varInit(value, "value", 56, 1554, 1810);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 56, 1554, 1810);
            if (CallChecker.beforeDeref(new Double(value), Double.class, 57, 1776, 1792)) {
                return CallChecker.isCalled(new Double(value), Double.class, 57, 1776, 1792).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4814.methodEnd();
        }
    }

    public static int hash(double[] value) {
        MethodContext _bcornu_methode_context4815 = new MethodContext(int.class, 67, 1817, 2101);
        try {
            CallChecker.varInit(value, "value", 67, 1817, 2101);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 67, 1817, 2101);
            return Arrays.hashCode(value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4815.methodEnd();
        }
    }

    public static double normalizeAngle(double a, double center) {
        MethodContext _bcornu_methode_context4816 = new MethodContext(double.class, 90, 2108, 3281);
        try {
            CallChecker.varInit(center, "center", 90, 2108, 3281);
            CallChecker.varInit(a, "a", 90, 2108, 3281);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 90, 2108, 3281);
            return a - ((MathUtils.TWO_PI) * (FastMath.floor((((a + (FastMath.PI)) - center) / (MathUtils.TWO_PI)))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4816.methodEnd();
        }
    }

    public static double reduce(double a, double period, double offset) {
        MethodContext _bcornu_methode_context4817 = new MethodContext(double.class, 110, 3288, 4130);
        try {
            CallChecker.varInit(offset, "offset", 110, 3288, 4130);
            CallChecker.varInit(period, "period", 110, 3288, 4130);
            CallChecker.varInit(a, "a", 110, 3288, 4130);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 110, 3288, 4130);
            final double p = CallChecker.varInit(((double) (FastMath.abs(period))), "p", 113, 4021, 4058);
            return (a - (p * (FastMath.floor(((a - offset) / p))))) - offset;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4817.methodEnd();
        }
    }

    public static byte copySign(byte magnitude, byte sign) throws MathArithmeticException {
        MethodContext _bcornu_methode_context4818 = new MethodContext(byte.class, 127, 4137, 5037);
        try {
            CallChecker.varInit(sign, "sign", 127, 4137, 5037);
            CallChecker.varInit(magnitude, "magnitude", 127, 4137, 5037);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 127, 4137, 5037);
            if (((magnitude >= 0) && (sign >= 0)) || ((magnitude < 0) && (sign < 0))) {
                return magnitude;
            }else
                if ((sign >= 0) && (magnitude == (Byte.MIN_VALUE))) {
                    throw new MathArithmeticException(LocalizedFormats.OVERFLOW);
                }else {
                    return ((byte) (-magnitude));
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Byte) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4818.methodEnd();
        }
    }

    public static short copySign(short magnitude, short sign) throws MathArithmeticException {
        MethodContext _bcornu_methode_context4819 = new MethodContext(short.class, 150, 5044, 5954);
        try {
            CallChecker.varInit(sign, "sign", 150, 5044, 5954);
            CallChecker.varInit(magnitude, "magnitude", 150, 5044, 5954);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 150, 5044, 5954);
            if (((magnitude >= 0) && (sign >= 0)) || ((magnitude < 0) && (sign < 0))) {
                return magnitude;
            }else
                if ((sign >= 0) && (magnitude == (Short.MIN_VALUE))) {
                    throw new MathArithmeticException(LocalizedFormats.OVERFLOW);
                }else {
                    return ((short) (-magnitude));
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Short) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4819.methodEnd();
        }
    }

    public static int copySign(int magnitude, int sign) throws MathArithmeticException {
        MethodContext _bcornu_methode_context4820 = new MethodContext(int.class, 173, 5961, 6861);
        try {
            CallChecker.varInit(sign, "sign", 173, 5961, 6861);
            CallChecker.varInit(magnitude, "magnitude", 173, 5961, 6861);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 173, 5961, 6861);
            if (((magnitude >= 0) && (sign >= 0)) || ((magnitude < 0) && (sign < 0))) {
                return magnitude;
            }else
                if ((sign >= 0) && (magnitude == (Integer.MIN_VALUE))) {
                    throw new MathArithmeticException(LocalizedFormats.OVERFLOW);
                }else {
                    return -magnitude;
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4820.methodEnd();
        }
    }

    public static long copySign(long magnitude, long sign) throws MathArithmeticException {
        MethodContext _bcornu_methode_context4821 = new MethodContext(long.class, 196, 6868, 7761);
        try {
            CallChecker.varInit(sign, "sign", 196, 6868, 7761);
            CallChecker.varInit(magnitude, "magnitude", 196, 6868, 7761);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 196, 6868, 7761);
            if (((magnitude >= 0) && (sign >= 0)) || ((magnitude < 0) && (sign < 0))) {
                return magnitude;
            }else
                if ((sign >= 0) && (magnitude == (Long.MIN_VALUE))) {
                    throw new MathArithmeticException(LocalizedFormats.OVERFLOW);
                }else {
                    return -magnitude;
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4821.methodEnd();
        }
    }

    public static void checkFinite(final double x) throws NotFiniteNumberException {
        MethodContext _bcornu_methode_context4822 = new MethodContext(void.class, 215, 7767, 8163);
        try {
            CallChecker.varInit(x, "x", 215, 7767, 8163);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 215, 7767, 8163);
            if ((Double.isInfinite(x)) || (Double.isNaN(x))) {
                throw new NotFiniteNumberException(x);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4822.methodEnd();
        }
    }

    public static void checkFinite(final double[] val) throws NotFiniteNumberException {
        MethodContext _bcornu_methode_context4823 = new MethodContext(void.class, 229, 8170, 8732);
        try {
            CallChecker.varInit(val, "val", 229, 8170, 8732);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 229, 8170, 8732);
            for (int i = 0; i < (CallChecker.isCalled(val, double[].class, 231, 8499, 8501).length); i++) {
                final double x = CallChecker.varInit(((double) (CallChecker.isCalled(val, double[].class, 232, 8547, 8549)[i])), "x", 232, 8530, 8553);
                if ((Double.isInfinite(x)) || (Double.isNaN(x))) {
                    throw new NotFiniteNumberException(LocalizedFormats.ARRAY_ELEMENT, x, i);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4823.methodEnd();
        }
    }

    public static void checkNotNull(Object o, Localizable pattern, Object... args) throws NullArgumentException {
        MethodContext _bcornu_methode_context4824 = new MethodContext(void.class, 247, 8739, 9315);
        try {
            CallChecker.varInit(args, "args", 247, 8739, 9315);
            CallChecker.varInit(pattern, "pattern", 247, 8739, 9315);
            CallChecker.varInit(o, "o", 247, 8739, 9315);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 247, 8739, 9315);
            if (o == null) {
                throw new NullArgumentException(pattern, args);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4824.methodEnd();
        }
    }

    public static void checkNotNull(Object o) throws NullArgumentException {
        MethodContext _bcornu_methode_context4825 = new MethodContext(void.class, 262, 9322, 9659);
        try {
            CallChecker.varInit(o, "o", 262, 9322, 9659);
            CallChecker.varInit(TWO_PI, "org.apache.commons.math3.util.MathUtils.TWO_PI", 262, 9322, 9659);
            if (o == null) {
                throw new NullArgumentException();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4825.methodEnd();
        }
    }
}

