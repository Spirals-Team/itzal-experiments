package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class BigReal implements Serializable , Comparable<BigReal> , FieldElement<BigReal> {
    public static final BigReal ZERO = new BigReal(BigDecimal.ZERO);

    public static final BigReal ONE = new BigReal(BigDecimal.ONE);

    private static final long serialVersionUID = 4984534880991310382L;

    private final BigDecimal d;

    private RoundingMode roundingMode = RoundingMode.HALF_UP;

    private int scale = 64;

    public BigReal(BigDecimal val) {
        ConstructorContext _bcornu_methode_context1168 = new ConstructorContext(BigReal.class, 63, 2100, 2248);
        try {
            d = val;
            CallChecker.varAssign(this.d, "this.d", 64, 2234, 2242);
        } finally {
            _bcornu_methode_context1168.methodEnd();
        }
    }

    public BigReal(BigInteger val) {
        ConstructorContext _bcornu_methode_context1169 = new ConstructorContext(BigReal.class, 70, 2255, 2418);
        try {
            d = new BigDecimal(val);
            CallChecker.varAssign(this.d, "this.d", 71, 2389, 2412);
        } finally {
            _bcornu_methode_context1169.methodEnd();
        }
    }

    public BigReal(BigInteger unscaledVal, int scale) {
        ConstructorContext _bcornu_methode_context1170 = new ConstructorContext(BigReal.class, 78, 2425, 2666);
        try {
            d = new BigDecimal(unscaledVal, scale);
            CallChecker.varAssign(this.d, "this.d", 79, 2622, 2660);
        } finally {
            _bcornu_methode_context1170.methodEnd();
        }
    }

    public BigReal(BigInteger unscaledVal, int scale, MathContext mc) {
        ConstructorContext _bcornu_methode_context1171 = new ConstructorContext(BigReal.class, 87, 2673, 2959);
        try {
            d = new BigDecimal(unscaledVal, scale, mc);
            CallChecker.varAssign(this.d, "this.d", 88, 2911, 2953);
        } finally {
            _bcornu_methode_context1171.methodEnd();
        }
    }

    public BigReal(BigInteger val, MathContext mc) {
        ConstructorContext _bcornu_methode_context1172 = new ConstructorContext(BigReal.class, 95, 2966, 3181);
        try {
            d = new BigDecimal(val, mc);
            CallChecker.varAssign(this.d, "this.d", 96, 3148, 3175);
        } finally {
            _bcornu_methode_context1172.methodEnd();
        }
    }

    public BigReal(char[] in) {
        ConstructorContext _bcornu_methode_context1173 = new ConstructorContext(BigReal.class, 102, 3188, 3375);
        try {
            d = new BigDecimal(in);
            CallChecker.varAssign(this.d, "this.d", 103, 3347, 3369);
        } finally {
            _bcornu_methode_context1173.methodEnd();
        }
    }

    public BigReal(char[] in, int offset, int len) {
        ConstructorContext _bcornu_methode_context1174 = new ConstructorContext(BigReal.class, 111, 3382, 3720);
        try {
            d = new BigDecimal(in, offset, len);
            CallChecker.varAssign(this.d, "this.d", 112, 3679, 3714);
        } finally {
            _bcornu_methode_context1174.methodEnd();
        }
    }

    public BigReal(char[] in, int offset, int len, MathContext mc) {
        ConstructorContext _bcornu_methode_context1175 = new ConstructorContext(BigReal.class, 121, 3727, 4117);
        try {
            d = new BigDecimal(in, offset, len, mc);
            CallChecker.varAssign(this.d, "this.d", 122, 4072, 4111);
        } finally {
            _bcornu_methode_context1175.methodEnd();
        }
    }

    public BigReal(char[] in, MathContext mc) {
        ConstructorContext _bcornu_methode_context1176 = new ConstructorContext(BigReal.class, 129, 4124, 4363);
        try {
            d = new BigDecimal(in, mc);
            CallChecker.varAssign(this.d, "this.d", 130, 4331, 4357);
        } finally {
            _bcornu_methode_context1176.methodEnd();
        }
    }

    public BigReal(double val) {
        ConstructorContext _bcornu_methode_context1177 = new ConstructorContext(BigReal.class, 136, 4370, 4525);
        try {
            d = new BigDecimal(val);
            CallChecker.varAssign(this.d, "this.d", 137, 4496, 4519);
        } finally {
            _bcornu_methode_context1177.methodEnd();
        }
    }

    public BigReal(double val, MathContext mc) {
        ConstructorContext _bcornu_methode_context1178 = new ConstructorContext(BigReal.class, 144, 4532, 4739);
        try {
            d = new BigDecimal(val, mc);
            CallChecker.varAssign(this.d, "this.d", 145, 4706, 4733);
        } finally {
            _bcornu_methode_context1178.methodEnd();
        }
    }

    public BigReal(int val) {
        ConstructorContext _bcornu_methode_context1179 = new ConstructorContext(BigReal.class, 151, 4746, 4896);
        try {
            d = new BigDecimal(val);
            CallChecker.varAssign(this.d, "this.d", 152, 4867, 4890);
        } finally {
            _bcornu_methode_context1179.methodEnd();
        }
    }

    public BigReal(int val, MathContext mc) {
        ConstructorContext _bcornu_methode_context1180 = new ConstructorContext(BigReal.class, 159, 4903, 5105);
        try {
            d = new BigDecimal(val, mc);
            CallChecker.varAssign(this.d, "this.d", 160, 5072, 5099);
        } finally {
            _bcornu_methode_context1180.methodEnd();
        }
    }

    public BigReal(long val) {
        ConstructorContext _bcornu_methode_context1181 = new ConstructorContext(BigReal.class, 166, 5112, 5263);
        try {
            d = new BigDecimal(val);
            CallChecker.varAssign(this.d, "this.d", 167, 5234, 5257);
        } finally {
            _bcornu_methode_context1181.methodEnd();
        }
    }

    public BigReal(long val, MathContext mc) {
        ConstructorContext _bcornu_methode_context1182 = new ConstructorContext(BigReal.class, 174, 5270, 5473);
        try {
            d = new BigDecimal(val, mc);
            CallChecker.varAssign(this.d, "this.d", 175, 5440, 5467);
        } finally {
            _bcornu_methode_context1182.methodEnd();
        }
    }

    public BigReal(String val) {
        ConstructorContext _bcornu_methode_context1183 = new ConstructorContext(BigReal.class, 181, 5480, 5666);
        try {
            d = new BigDecimal(val);
            CallChecker.varAssign(this.d, "this.d", 182, 5637, 5660);
        } finally {
            _bcornu_methode_context1183.methodEnd();
        }
    }

    public BigReal(String val, MathContext mc) {
        ConstructorContext _bcornu_methode_context1184 = new ConstructorContext(BigReal.class, 189, 5673, 5912);
        try {
            d = new BigDecimal(val, mc);
            CallChecker.varAssign(this.d, "this.d", 190, 5879, 5906);
        } finally {
            _bcornu_methode_context1184.methodEnd();
        }
    }

    public RoundingMode getRoundingMode() {
        MethodContext _bcornu_methode_context5266 = new MethodContext(RoundingMode.class, 199, 5919, 6166);
        try {
            CallChecker.varInit(this, "this", 199, 5919, 6166);
            CallChecker.varInit(this.scale, "scale", 199, 5919, 6166);
            CallChecker.varInit(this.roundingMode, "roundingMode", 199, 5919, 6166);
            CallChecker.varInit(this.d, "d", 199, 5919, 6166);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 199, 5919, 6166);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 199, 5919, 6166);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 199, 5919, 6166);
            return roundingMode;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RoundingMode) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5266.methodEnd();
        }
    }

    public void setRoundingMode(RoundingMode roundingMode) {
        MethodContext _bcornu_methode_context5267 = new MethodContext(void.class, 208, 6173, 6427);
        try {
            CallChecker.varInit(this, "this", 208, 6173, 6427);
            CallChecker.varInit(roundingMode, "roundingMode", 208, 6173, 6427);
            CallChecker.varInit(this.scale, "scale", 208, 6173, 6427);
            CallChecker.varInit(this.roundingMode, "roundingMode", 208, 6173, 6427);
            CallChecker.varInit(this.d, "d", 208, 6173, 6427);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 208, 6173, 6427);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 208, 6173, 6427);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 208, 6173, 6427);
            this.roundingMode = roundingMode;
            CallChecker.varAssign(this.roundingMode, "this.roundingMode", 209, 6389, 6421);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5267.methodEnd();
        }
    }

    public int getScale() {
        MethodContext _bcornu_methode_context5268 = new MethodContext(int.class, 218, 6434, 6616);
        try {
            CallChecker.varInit(this, "this", 218, 6434, 6616);
            CallChecker.varInit(this.scale, "scale", 218, 6434, 6616);
            CallChecker.varInit(this.roundingMode, "roundingMode", 218, 6434, 6616);
            CallChecker.varInit(this.d, "d", 218, 6434, 6616);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 218, 6434, 6616);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 218, 6434, 6616);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 218, 6434, 6616);
            return scale;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5268.methodEnd();
        }
    }

    public void setScale(int scale) {
        MethodContext _bcornu_methode_context5269 = new MethodContext(void.class, 227, 6623, 6821);
        try {
            CallChecker.varInit(this, "this", 227, 6623, 6821);
            CallChecker.varInit(scale, "scale", 227, 6623, 6821);
            CallChecker.varInit(this.scale, "scale", 227, 6623, 6821);
            CallChecker.varInit(this.roundingMode, "roundingMode", 227, 6623, 6821);
            CallChecker.varInit(this.d, "d", 227, 6623, 6821);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 227, 6623, 6821);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 227, 6623, 6821);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 227, 6623, 6821);
            this.scale = scale;
            CallChecker.varAssign(this.scale, "this.scale", 228, 6797, 6815);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5269.methodEnd();
        }
    }

    public BigReal add(BigReal a) {
        MethodContext _bcornu_methode_context5270 = new MethodContext(BigReal.class, 232, 6828, 6929);
        try {
            CallChecker.varInit(this, "this", 232, 6828, 6929);
            CallChecker.varInit(a, "a", 232, 6828, 6929);
            CallChecker.varInit(this.scale, "scale", 232, 6828, 6929);
            CallChecker.varInit(this.roundingMode, "roundingMode", 232, 6828, 6929);
            CallChecker.varInit(this.d, "d", 232, 6828, 6929);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 232, 6828, 6929);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 232, 6828, 6929);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 232, 6828, 6929);
            if (CallChecker.beforeDeref(a, BigReal.class, 233, 6918, 6918)) {
                if (CallChecker.beforeDeref(d, BigDecimal.class, 233, 6912, 6912)) {
                    a = CallChecker.beforeCalled(a, BigReal.class, 233, 6918, 6918);
                    return new BigReal(CallChecker.isCalled(d, BigDecimal.class, 233, 6912, 6912).add(CallChecker.isCalled(a, BigReal.class, 233, 6918, 6918).d));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigReal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5270.methodEnd();
        }
    }

    public BigReal subtract(BigReal a) {
        MethodContext _bcornu_methode_context5271 = new MethodContext(BigReal.class, 237, 6936, 7047);
        try {
            CallChecker.varInit(this, "this", 237, 6936, 7047);
            CallChecker.varInit(a, "a", 237, 6936, 7047);
            CallChecker.varInit(this.scale, "scale", 237, 6936, 7047);
            CallChecker.varInit(this.roundingMode, "roundingMode", 237, 6936, 7047);
            CallChecker.varInit(this.d, "d", 237, 6936, 7047);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 237, 6936, 7047);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 237, 6936, 7047);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 237, 6936, 7047);
            if (CallChecker.beforeDeref(a, BigReal.class, 238, 7036, 7036)) {
                if (CallChecker.beforeDeref(d, BigDecimal.class, 238, 7025, 7025)) {
                    a = CallChecker.beforeCalled(a, BigReal.class, 238, 7036, 7036);
                    return new BigReal(CallChecker.isCalled(d, BigDecimal.class, 238, 7025, 7025).subtract(CallChecker.isCalled(a, BigReal.class, 238, 7036, 7036).d));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigReal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5271.methodEnd();
        }
    }

    public BigReal negate() {
        MethodContext _bcornu_methode_context5272 = new MethodContext(BigReal.class, 242, 7054, 7149);
        try {
            CallChecker.varInit(this, "this", 242, 7054, 7149);
            CallChecker.varInit(this.scale, "scale", 242, 7054, 7149);
            CallChecker.varInit(this.roundingMode, "roundingMode", 242, 7054, 7149);
            CallChecker.varInit(this.d, "d", 242, 7054, 7149);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 242, 7054, 7149);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 242, 7054, 7149);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 242, 7054, 7149);
            if (CallChecker.beforeDeref(d, BigDecimal.class, 243, 7132, 7132)) {
                return new BigReal(CallChecker.isCalled(d, BigDecimal.class, 243, 7132, 7132).negate());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigReal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5272.methodEnd();
        }
    }

    public BigReal divide(BigReal a) throws MathArithmeticException {
        MethodContext _bcornu_methode_context5273 = new MethodContext(BigReal.class, 251, 7156, 7590);
        try {
            CallChecker.varInit(this, "this", 251, 7156, 7590);
            CallChecker.varInit(a, "a", 251, 7156, 7590);
            CallChecker.varInit(this.scale, "scale", 251, 7156, 7590);
            CallChecker.varInit(this.roundingMode, "roundingMode", 251, 7156, 7590);
            CallChecker.varInit(this.d, "d", 251, 7156, 7590);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 251, 7156, 7590);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 251, 7156, 7590);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 251, 7156, 7590);
            TryContext _bcornu_try_context_104 = new TryContext(104, BigReal.class, "java.lang.ArithmeticException");
            try {
                if (CallChecker.beforeDeref(a, BigReal.class, 253, 7380, 7380)) {
                    if (CallChecker.beforeDeref(d, BigDecimal.class, 253, 7371, 7371)) {
                        a = CallChecker.beforeCalled(a, BigReal.class, 253, 7380, 7380);
                        return new BigReal(CallChecker.isCalled(d, BigDecimal.class, 253, 7371, 7371).divide(CallChecker.isCalled(a, BigReal.class, 253, 7380, 7380).d, scale, roundingMode));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ArithmeticException e) {
                _bcornu_try_context_104.catchStart(104);
                throw new MathArithmeticException(LocalizedFormats.ZERO_NOT_ALLOWED);
            } finally {
                _bcornu_try_context_104.finallyStart(104);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigReal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5273.methodEnd();
        }
    }

    public BigReal reciprocal() throws MathArithmeticException {
        MethodContext _bcornu_methode_context5274 = new MethodContext(BigReal.class, 265, 7597, 8040);
        try {
            CallChecker.varInit(this, "this", 265, 7597, 8040);
            CallChecker.varInit(this.scale, "scale", 265, 7597, 8040);
            CallChecker.varInit(this.roundingMode, "roundingMode", 265, 7597, 8040);
            CallChecker.varInit(this.d, "d", 265, 7597, 8040);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 265, 7597, 8040);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 265, 7597, 8040);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 265, 7597, 8040);
            TryContext _bcornu_try_context_105 = new TryContext(105, BigReal.class, "java.lang.ArithmeticException");
            try {
                if (CallChecker.beforeDeref(BigDecimal.ONE, BigDecimal.class, 267, 7810, 7823)) {
                    return new BigReal(CallChecker.isCalled(BigDecimal.ONE, BigDecimal.class, 267, 7810, 7823).divide(d, scale, roundingMode));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ArithmeticException e) {
                _bcornu_try_context_105.catchStart(105);
                throw new MathArithmeticException(LocalizedFormats.ZERO_NOT_ALLOWED);
            } finally {
                _bcornu_try_context_105.finallyStart(105);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigReal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5274.methodEnd();
        }
    }

    public BigReal multiply(BigReal a) {
        MethodContext _bcornu_methode_context5275 = new MethodContext(BigReal.class, 275, 8047, 8158);
        try {
            CallChecker.varInit(this, "this", 275, 8047, 8158);
            CallChecker.varInit(a, "a", 275, 8047, 8158);
            CallChecker.varInit(this.scale, "scale", 275, 8047, 8158);
            CallChecker.varInit(this.roundingMode, "roundingMode", 275, 8047, 8158);
            CallChecker.varInit(this.d, "d", 275, 8047, 8158);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 275, 8047, 8158);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 275, 8047, 8158);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 275, 8047, 8158);
            if (CallChecker.beforeDeref(a, BigReal.class, 276, 8147, 8147)) {
                if (CallChecker.beforeDeref(d, BigDecimal.class, 276, 8136, 8136)) {
                    a = CallChecker.beforeCalled(a, BigReal.class, 276, 8147, 8147);
                    return new BigReal(CallChecker.isCalled(d, BigDecimal.class, 276, 8136, 8136).multiply(CallChecker.isCalled(a, BigReal.class, 276, 8147, 8147).d));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigReal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5275.methodEnd();
        }
    }

    public BigReal multiply(final int n) {
        MethodContext _bcornu_methode_context5276 = new MethodContext(BigReal.class, 280, 8165, 8292);
        try {
            CallChecker.varInit(this, "this", 280, 8165, 8292);
            CallChecker.varInit(n, "n", 280, 8165, 8292);
            CallChecker.varInit(this.scale, "scale", 280, 8165, 8292);
            CallChecker.varInit(this.roundingMode, "roundingMode", 280, 8165, 8292);
            CallChecker.varInit(this.d, "d", 280, 8165, 8292);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 280, 8165, 8292);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 280, 8165, 8292);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 280, 8165, 8292);
            if (CallChecker.beforeDeref(d, BigDecimal.class, 281, 8256, 8256)) {
                return new BigReal(CallChecker.isCalled(d, BigDecimal.class, 281, 8256, 8256).multiply(new BigDecimal(n)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigReal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5276.methodEnd();
        }
    }

    public int compareTo(BigReal a) {
        MethodContext _bcornu_methode_context5277 = new MethodContext(int.class, 285, 8299, 8395);
        try {
            CallChecker.varInit(this, "this", 285, 8299, 8395);
            CallChecker.varInit(a, "a", 285, 8299, 8395);
            CallChecker.varInit(this.scale, "scale", 285, 8299, 8395);
            CallChecker.varInit(this.roundingMode, "roundingMode", 285, 8299, 8395);
            CallChecker.varInit(this.d, "d", 285, 8299, 8395);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 285, 8299, 8395);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 285, 8299, 8395);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 285, 8299, 8395);
            if (CallChecker.beforeDeref(a, BigReal.class, 286, 8385, 8385)) {
                if (CallChecker.beforeDeref(d, BigDecimal.class, 286, 8373, 8373)) {
                    a = CallChecker.beforeCalled(a, BigReal.class, 286, 8385, 8385);
                    return CallChecker.isCalled(d, BigDecimal.class, 286, 8373, 8373).compareTo(CallChecker.isCalled(a, BigReal.class, 286, 8385, 8385).d);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5277.methodEnd();
        }
    }

    public double doubleValue() {
        MethodContext _bcornu_methode_context5278 = new MethodContext(double.class, 292, 8402, 8594);
        try {
            CallChecker.varInit(this, "this", 292, 8402, 8594);
            CallChecker.varInit(this.scale, "scale", 292, 8402, 8594);
            CallChecker.varInit(this.roundingMode, "roundingMode", 292, 8402, 8594);
            CallChecker.varInit(this.d, "d", 292, 8402, 8594);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 292, 8402, 8594);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 292, 8402, 8594);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 292, 8402, 8594);
            if (CallChecker.beforeDeref(d, BigDecimal.class, 293, 8573, 8573)) {
                return CallChecker.isCalled(d, BigDecimal.class, 293, 8573, 8573).doubleValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5278.methodEnd();
        }
    }

    public BigDecimal bigDecimalValue() {
        MethodContext _bcornu_methode_context5279 = new MethodContext(BigDecimal.class, 299, 8601, 8795);
        try {
            CallChecker.varInit(this, "this", 299, 8601, 8795);
            CallChecker.varInit(this.scale, "scale", 299, 8601, 8795);
            CallChecker.varInit(this.roundingMode, "roundingMode", 299, 8601, 8795);
            CallChecker.varInit(this.d, "d", 299, 8601, 8795);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 299, 8601, 8795);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 299, 8601, 8795);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 299, 8601, 8795);
            return d;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BigDecimal) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5279.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context5280 = new MethodContext(boolean.class, 305, 8802, 9068);
        try {
            CallChecker.varInit(this, "this", 305, 8802, 9068);
            CallChecker.varInit(other, "other", 305, 8802, 9068);
            CallChecker.varInit(this.scale, "scale", 305, 8802, 9068);
            CallChecker.varInit(this.roundingMode, "roundingMode", 305, 8802, 9068);
            CallChecker.varInit(this.d, "d", 305, 8802, 9068);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 305, 8802, 9068);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 305, 8802, 9068);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 305, 8802, 9068);
            if ((this) == other) {
                return true;
            }
            if (other instanceof BigReal) {
                if (CallChecker.beforeDeref(other, Object.class, 311, 9021, 9025)) {
                    if (CallChecker.beforeDeref(d, BigDecimal.class, 311, 9001, 9001)) {
                        other = CallChecker.beforeCalled(other, BigReal.class, 311, 9021, 9025);
                        return CallChecker.isCalled(d, BigDecimal.class, 311, 9001, 9001).equals(CallChecker.isCalled(((BigReal) (other)), BigReal.class, 311, 9021, 9025).d);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5280.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context5281 = new MethodContext(int.class, 318, 9075, 9171);
        try {
            CallChecker.varInit(this, "this", 318, 9075, 9171);
            CallChecker.varInit(this.scale, "scale", 318, 9075, 9171);
            CallChecker.varInit(this.roundingMode, "roundingMode", 318, 9075, 9171);
            CallChecker.varInit(this.d, "d", 318, 9075, 9171);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 318, 9075, 9171);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 318, 9075, 9171);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 318, 9075, 9171);
            if (CallChecker.beforeDeref(d, BigDecimal.class, 319, 9153, 9153)) {
                return CallChecker.isCalled(d, BigDecimal.class, 319, 9153, 9153).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5281.methodEnd();
        }
    }

    public Field<BigReal> getField() {
        MethodContext _bcornu_methode_context5282 = new MethodContext(Field.class, 323, 9178, 9285);
        try {
            CallChecker.varInit(this, "this", 323, 9178, 9285);
            CallChecker.varInit(this.scale, "scale", 323, 9178, 9285);
            CallChecker.varInit(this.roundingMode, "roundingMode", 323, 9178, 9285);
            CallChecker.varInit(this.d, "d", 323, 9178, 9285);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.BigReal.serialVersionUID", 323, 9178, 9285);
            CallChecker.varInit(ONE, "org.apache.commons.math3.util.BigReal.ONE", 323, 9178, 9285);
            CallChecker.varInit(ZERO, "org.apache.commons.math3.util.BigReal.ZERO", 323, 9178, 9285);
            return BigRealField.getInstance();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Field<BigReal>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5282.methodEnd();
        }
    }
}

