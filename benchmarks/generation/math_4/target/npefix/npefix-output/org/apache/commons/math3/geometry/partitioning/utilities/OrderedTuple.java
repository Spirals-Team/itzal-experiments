package org.apache.commons.math3.geometry.partitioning.utilities;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;

public class OrderedTuple implements Comparable<OrderedTuple> {
    private static final long SIGN_MASK = -9223372036854775808L;

    private static final long EXPONENT_MASK = 9218868437227405312L;

    private static final long MANTISSA_MASK = 4503599627370495L;

    private static final long IMPLICIT_ONE = 4503599627370496L;

    private double[] components;

    private int offset;

    private int lsb;

    private long[] encoding;

    private boolean posInf;

    private boolean negInf;

    private boolean nan;

    public OrderedTuple(final double... components) {
        ConstructorContext _bcornu_methode_context261 = new ConstructorContext(OrderedTuple.class, 132, 5484, 6971);
        try {
            if (CallChecker.beforeDeref(components, double[].class, 133, 5679, 5688)) {
                this.components = CallChecker.isCalled(components, double[].class, 133, 5679, 5688).clone();
                CallChecker.varAssign(this.components, "this.components", 133, 5661, 5697);
            }
            int msb = CallChecker.varInit(((int) (Integer.MIN_VALUE)), "msb", 134, 5707, 5734);
            lsb = Integer.MAX_VALUE;
            CallChecker.varAssign(this.lsb, "this.lsb", 135, 5744, 5771);
            posInf = false;
            CallChecker.varAssign(this.posInf, "this.posInf", 136, 5781, 5796);
            negInf = false;
            CallChecker.varAssign(this.negInf, "this.negInf", 137, 5806, 5821);
            nan = false;
            CallChecker.varAssign(this.nan, "this.nan", 138, 5831, 5846);
            for (int i = 0; i < (CallChecker.isCalled(components, double[].class, 139, 5876, 5885).length); ++i) {
                if (CallChecker.beforeDeref(components, double[].class, 140, 5936, 5945)) {
                    if (Double.isInfinite(CallChecker.isCalled(components, double[].class, 140, 5936, 5945)[i])) {
                        if (CallChecker.beforeDeref(components, double[].class, 141, 5974, 5983)) {
                            if ((CallChecker.isCalled(components, double[].class, 141, 5974, 5983)[i]) < 0) {
                                negInf = true;
                                CallChecker.varAssign(this.negInf, "this.negInf", 142, 6015, 6028);
                            }else {
                                posInf = true;
                                CallChecker.varAssign(this.posInf, "this.posInf", 144, 6075, 6088);
                            }
                        }
                    }else
                        if (CallChecker.beforeDeref(components, double[].class, 146, 6144, 6153)) {
                            if (Double.isNaN(CallChecker.isCalled(components, double[].class, 146, 6144, 6153)[i])) {
                                nan = true;
                                CallChecker.varAssign(this.nan, "this.nan", 147, 6178, 6188);
                            }else {
                                final long b = CallChecker.varInit(((long) (Double.doubleToLongBits(CallChecker.isCalled(components, double[].class, 149, 6266, 6275)[i]))), "b", 149, 6227, 6280);
                                final long m = CallChecker.varInit(((long) (OrderedTuple.mantissa(b))), "m", 150, 6298, 6324);
                                if (m != 0) {
                                    final int e = CallChecker.varInit(((int) (OrderedTuple.exponent(b))), "e", 152, 6376, 6401);
                                    msb = org.apache.commons.math3.util.FastMath.max(msb, (e + (OrderedTuple.computeMSB(m))));
                                    CallChecker.varAssign(msb, "msb", 153, 6423, 6465);
                                    lsb = org.apache.commons.math3.util.FastMath.min(lsb, (e + (OrderedTuple.computeLSB(m))));
                                    CallChecker.varAssign(this.lsb, "this.lsb", 154, 6487, 6529);
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if ((posInf) && (negInf)) {
                posInf = false;
                CallChecker.varAssign(this.posInf, "this.posInf", 161, 6669, 6683);
                negInf = false;
                CallChecker.varAssign(this.negInf, "this.negInf", 162, 6697, 6711);
                nan = true;
                CallChecker.varAssign(this.nan, "this.nan", 163, 6725, 6738);
            }
            if ((lsb) <= msb) {
                encode((msb + 16));
            }else {
                encoding = new long[]{ 0L };
                CallChecker.varAssign(this.encoding, "this.encoding", 170, 6896, 6954);
            }
        } finally {
            _bcornu_methode_context261.methodEnd();
        }
    }

    private void encode(final int minOffset) {
        MethodContext _bcornu_methode_context1134 = new MethodContext(void.class, 181, 6978, 8363);
        try {
            CallChecker.varInit(this, "this", 181, 6978, 8363);
            CallChecker.varInit(minOffset, "minOffset", 181, 6978, 8363);
            CallChecker.varInit(this.nan, "nan", 181, 6978, 8363);
            CallChecker.varInit(this.negInf, "negInf", 181, 6978, 8363);
            CallChecker.varInit(this.posInf, "posInf", 181, 6978, 8363);
            CallChecker.varInit(this.encoding, "encoding", 181, 6978, 8363);
            CallChecker.varInit(this.lsb, "lsb", 181, 6978, 8363);
            CallChecker.varInit(this.offset, "offset", 181, 6978, 8363);
            CallChecker.varInit(this.components, "components", 181, 6978, 8363);
            CallChecker.varInit(IMPLICIT_ONE, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.IMPLICIT_ONE", 181, 6978, 8363);
            CallChecker.varInit(MANTISSA_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.MANTISSA_MASK", 181, 6978, 8363);
            CallChecker.varInit(EXPONENT_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.EXPONENT_MASK", 181, 6978, 8363);
            CallChecker.varInit(SIGN_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.SIGN_MASK", 181, 6978, 8363);
            offset = minOffset + 31;
            CallChecker.varAssign(this.offset, "this.offset", 184, 7265, 7289);
            offset -= (offset) % 32;
            CallChecker.varAssign(this.offset, "this.offset", 185, 7299, 7320);
            if ((((encoding) != null) && ((encoding.length) == 1)) && ((encoding[0]) == 0L)) {
                return ;
            }
            final int neededBits = CallChecker.varInit(((int) (((this.offset) + 1) - (this.lsb))), "neededBits", 194, 7492, 7681);
            final int neededLongs = CallChecker.varInit(((int) ((neededBits + 62) / 63)), "neededLongs", 195, 7691, 7737);
            if (CallChecker.beforeDeref(components, double[].class, 196, 7767, 7776)) {
                components = CallChecker.beforeCalled(components, double[].class, 196, 7767, 7776);
                encoding = new long[(CallChecker.isCalled(components, double[].class, 196, 7767, 7776).length) * neededLongs];
                CallChecker.varAssign(this.encoding, "this.encoding", 196, 7747, 7799);
            }
            int eIndex = CallChecker.varInit(((int) (0)), "eIndex", 199, 7854, 7869);
            int shift = CallChecker.varInit(((int) (62)), "shift", 200, 7879, 7895);
            long word = CallChecker.varInit(((long) (0L)), "word", 201, 7905, 7923);
            encoding = CallChecker.beforeCalled(encoding, long[].class, 202, 7963, 7970);
            for (int k = offset; eIndex < (CallChecker.isCalled(encoding, long[].class, 202, 7963, 7970).length); --k) {
                components = CallChecker.beforeCalled(components, double[].class, 203, 8029, 8038);
                for (int vIndex = 0; vIndex < (CallChecker.isCalled(components, double[].class, 203, 8029, 8038).length); ++vIndex) {
                    if ((getBit(vIndex, k)) != 0) {
                        word |= 1L << shift;
                        CallChecker.varAssign(word, "word", 205, 8126, 8147);
                    }
                    if ((shift--) == 0) {
                        if (CallChecker.beforeDeref(encoding, long[].class, 208, 8223, 8230)) {
                            encoding = CallChecker.beforeCalled(encoding, long[].class, 208, 8223, 8230);
                            CallChecker.isCalled(encoding, long[].class, 208, 8223, 8230)[(eIndex++)] = word;
                            CallChecker.varAssign(CallChecker.isCalled(this.encoding, long[].class, 208, 8223, 8230)[(eIndex - 1)], "CallChecker.isCalled(this.encoding, long[].class, 208, 8223, 8230)[(eIndex - 1)]", 208, 8223, 8248);
                        }
                        word = 0L;
                        CallChecker.varAssign(word, "word", 209, 8270, 8282);
                        shift = 62;
                        CallChecker.varAssign(shift, "shift", 210, 8304, 8314);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1134.methodEnd();
        }
    }

    public int compareTo(final OrderedTuple ot) {
        MethodContext _bcornu_methode_context1135 = new MethodContext(int.class, 247, 8370, 10991);
        try {
            CallChecker.varInit(this, "this", 247, 8370, 10991);
            CallChecker.varInit(ot, "ot", 247, 8370, 10991);
            CallChecker.varInit(this.nan, "nan", 247, 8370, 10991);
            CallChecker.varInit(this.negInf, "negInf", 247, 8370, 10991);
            CallChecker.varInit(this.posInf, "posInf", 247, 8370, 10991);
            CallChecker.varInit(this.encoding, "encoding", 247, 8370, 10991);
            CallChecker.varInit(this.lsb, "lsb", 247, 8370, 10991);
            CallChecker.varInit(this.offset, "offset", 247, 8370, 10991);
            CallChecker.varInit(this.components, "components", 247, 8370, 10991);
            CallChecker.varInit(IMPLICIT_ONE, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.IMPLICIT_ONE", 247, 8370, 10991);
            CallChecker.varInit(MANTISSA_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.MANTISSA_MASK", 247, 8370, 10991);
            CallChecker.varInit(EXPONENT_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.EXPONENT_MASK", 247, 8370, 10991);
            CallChecker.varInit(SIGN_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.SIGN_MASK", 247, 8370, 10991);
            if (CallChecker.beforeDeref(components, double[].class, 248, 9765, 9774)) {
                if (CallChecker.beforeDeref(ot, OrderedTuple.class, 248, 9786, 9787)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ot, OrderedTuple.class, 248, 9786, 9787).components, double[].class, 248, 9786, 9798)) {
                        components = CallChecker.beforeCalled(components, double[].class, 248, 9765, 9774);
                        CallChecker.isCalled(ot, OrderedTuple.class, 248, 9786, 9787).components = CallChecker.beforeCalled(CallChecker.isCalled(ot, OrderedTuple.class, 248, 9786, 9787).components, double[].class, 248, 9786, 9798);
                        if ((CallChecker.isCalled(components, double[].class, 248, 9765, 9774).length) == (CallChecker.isCalled(CallChecker.isCalled(ot, OrderedTuple.class, 248, 9786, 9787).components, double[].class, 248, 9786, 9798).length)) {
                            if (nan) {
                                return +1;
                            }else
                                if (CallChecker.beforeDeref(ot, OrderedTuple.class, 251, 9883, 9884)) {
                                    if (CallChecker.isCalled(ot, OrderedTuple.class, 251, 9883, 9884).nan) {
                                        return -1;
                                    }else
                                        if (CallChecker.beforeDeref(ot, OrderedTuple.class, 253, 9953, 9954)) {
                                            if ((negInf) || (CallChecker.isCalled(ot, OrderedTuple.class, 253, 9953, 9954).posInf)) {
                                                return -1;
                                            }else
                                                if (CallChecker.beforeDeref(ot, OrderedTuple.class, 255, 10026, 10027)) {
                                                    if ((posInf) || (CallChecker.isCalled(ot, OrderedTuple.class, 255, 10026, 10027).negInf)) {
                                                        return +1;
                                                    }else {
                                                        if (CallChecker.beforeDeref(ot, OrderedTuple.class, 259, 10117, 10118)) {
                                                            if ((offset) < (CallChecker.isCalled(ot, OrderedTuple.class, 259, 10117, 10118).offset)) {
                                                                if (CallChecker.beforeDeref(ot, OrderedTuple.class, 260, 10157, 10158)) {
                                                                    encode(CallChecker.isCalled(ot, OrderedTuple.class, 260, 10157, 10158).offset);
                                                                }
                                                            }else
                                                                if (CallChecker.beforeDeref(ot, OrderedTuple.class, 261, 10205, 10206)) {
                                                                    if ((offset) > (CallChecker.isCalled(ot, OrderedTuple.class, 261, 10205, 10206).offset)) {
                                                                        if (CallChecker.beforeDeref(ot, OrderedTuple.class, 262, 10238, 10239)) {
                                                                            CallChecker.isCalled(ot, OrderedTuple.class, 262, 10238, 10239).encode(offset);
                                                                        }
                                                                    }
                                                                }
                                                            
                                                        }
                                                        encoding = CallChecker.beforeCalled(encoding, long[].class, 265, 10323, 10330);
                                                        CallChecker.isCalled(ot, OrderedTuple.class, 265, 10340, 10341).encoding = CallChecker.beforeCalled(CallChecker.isCalled(ot, OrderedTuple.class, 265, 10340, 10341).encoding, long[].class, 265, 10340, 10350);
                                                        final int limit = CallChecker.varInit(((int) (org.apache.commons.math3.util.FastMath.min(CallChecker.isCalled(this.encoding, long[].class, 265, 10323, 10330).length, CallChecker.isCalled(CallChecker.isCalled(ot, OrderedTuple.class, 265, 10340, 10341).encoding, long[].class, 265, 10340, 10350).length))), "limit", 265, 10292, 10359);
                                                        for (int i = 0; i < limit; ++i) {
                                                            if (CallChecker.beforeDeref(encoding, long[].class, 267, 10435, 10442)) {
                                                                if (CallChecker.beforeDeref(ot, OrderedTuple.class, 267, 10449, 10450)) {
                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ot, OrderedTuple.class, 267, 10449, 10450).encoding, long[].class, 267, 10449, 10459)) {
                                                                        encoding = CallChecker.beforeCalled(encoding, long[].class, 267, 10435, 10442);
                                                                        CallChecker.isCalled(ot, OrderedTuple.class, 267, 10449, 10450).encoding = CallChecker.beforeCalled(CallChecker.isCalled(ot, OrderedTuple.class, 267, 10449, 10450).encoding, long[].class, 267, 10449, 10459);
                                                                        if ((CallChecker.isCalled(encoding, long[].class, 267, 10435, 10442)[i]) < (CallChecker.isCalled(CallChecker.isCalled(ot, OrderedTuple.class, 267, 10449, 10450).encoding, long[].class, 267, 10449, 10459)[i])) {
                                                                            return -1;
                                                                        }else
                                                                            if (CallChecker.beforeDeref(encoding, long[].class, 269, 10533, 10540)) {
                                                                                if (CallChecker.beforeDeref(ot, OrderedTuple.class, 269, 10547, 10548)) {
                                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ot, OrderedTuple.class, 269, 10547, 10548).encoding, long[].class, 269, 10547, 10557)) {
                                                                                        encoding = CallChecker.beforeCalled(encoding, long[].class, 269, 10533, 10540);
                                                                                        CallChecker.isCalled(ot, OrderedTuple.class, 269, 10547, 10548).encoding = CallChecker.beforeCalled(CallChecker.isCalled(ot, OrderedTuple.class, 269, 10547, 10548).encoding, long[].class, 269, 10547, 10557);
                                                                                        if ((CallChecker.isCalled(encoding, long[].class, 269, 10533, 10540)[i]) > (CallChecker.isCalled(CallChecker.isCalled(ot, OrderedTuple.class, 269, 10547, 10548).encoding, long[].class, 269, 10547, 10557)[i])) {
                                                                                            return +1;
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
                                                            
                                                        }
                                                        if (CallChecker.beforeDeref(encoding, long[].class, 274, 10661, 10668)) {
                                                            if (CallChecker.beforeDeref(ot, OrderedTuple.class, 274, 10679, 10680)) {
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ot, OrderedTuple.class, 274, 10679, 10680).encoding, long[].class, 274, 10679, 10689)) {
                                                                    encoding = CallChecker.beforeCalled(encoding, long[].class, 274, 10661, 10668);
                                                                    CallChecker.isCalled(ot, OrderedTuple.class, 274, 10679, 10680).encoding = CallChecker.beforeCalled(CallChecker.isCalled(ot, OrderedTuple.class, 274, 10679, 10680).encoding, long[].class, 274, 10679, 10689);
                                                                    if ((CallChecker.isCalled(encoding, long[].class, 274, 10661, 10668).length) < (CallChecker.isCalled(CallChecker.isCalled(ot, OrderedTuple.class, 274, 10679, 10680).encoding, long[].class, 274, 10679, 10689).length)) {
                                                                        return -1;
                                                                    }else
                                                                        if (CallChecker.beforeDeref(encoding, long[].class, 276, 10759, 10766)) {
                                                                            if (CallChecker.beforeDeref(ot, OrderedTuple.class, 276, 10777, 10778)) {
                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ot, OrderedTuple.class, 276, 10777, 10778).encoding, long[].class, 276, 10777, 10787)) {
                                                                                    encoding = CallChecker.beforeCalled(encoding, long[].class, 276, 10759, 10766);
                                                                                    CallChecker.isCalled(ot, OrderedTuple.class, 276, 10777, 10778).encoding = CallChecker.beforeCalled(CallChecker.isCalled(ot, OrderedTuple.class, 276, 10777, 10778).encoding, long[].class, 276, 10777, 10787);
                                                                                    if ((CallChecker.isCalled(encoding, long[].class, 276, 10759, 10766).length) > (CallChecker.isCalled(CallChecker.isCalled(ot, OrderedTuple.class, 276, 10777, 10778).encoding, long[].class, 276, 10777, 10787).length)) {
                                                                                        return +1;
                                                                                    }else {
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
                                                        
                                                    }
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            
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
            
            if (CallChecker.beforeDeref(ot, OrderedTuple.class, 285, 10964, 10965)) {
                components = CallChecker.beforeCalled(components, double[].class, 285, 10944, 10953);
                CallChecker.isCalled(ot, OrderedTuple.class, 285, 10964, 10965).components = CallChecker.beforeCalled(CallChecker.isCalled(ot, OrderedTuple.class, 285, 10964, 10965).components, double[].class, 285, 10964, 10976);
                return (CallChecker.isCalled(components, double[].class, 285, 10944, 10953).length) - (CallChecker.isCalled(CallChecker.isCalled(ot, OrderedTuple.class, 285, 10964, 10965).components, double[].class, 285, 10964, 10976).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1135.methodEnd();
        }
    }

    @Override
    public boolean equals(final Object other) {
        MethodContext _bcornu_methode_context1136 = new MethodContext(boolean.class, 291, 10998, 11301);
        try {
            CallChecker.varInit(this, "this", 291, 10998, 11301);
            CallChecker.varInit(other, "other", 291, 10998, 11301);
            CallChecker.varInit(this.nan, "nan", 291, 10998, 11301);
            CallChecker.varInit(this.negInf, "negInf", 291, 10998, 11301);
            CallChecker.varInit(this.posInf, "posInf", 291, 10998, 11301);
            CallChecker.varInit(this.encoding, "encoding", 291, 10998, 11301);
            CallChecker.varInit(this.lsb, "lsb", 291, 10998, 11301);
            CallChecker.varInit(this.offset, "offset", 291, 10998, 11301);
            CallChecker.varInit(this.components, "components", 291, 10998, 11301);
            CallChecker.varInit(IMPLICIT_ONE, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.IMPLICIT_ONE", 291, 10998, 11301);
            CallChecker.varInit(MANTISSA_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.MANTISSA_MASK", 291, 10998, 11301);
            CallChecker.varInit(EXPONENT_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.EXPONENT_MASK", 291, 10998, 11301);
            CallChecker.varInit(SIGN_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.SIGN_MASK", 291, 10998, 11301);
            if ((this) == other) {
                return true;
            }else
                if (other instanceof OrderedTuple) {
                    return (compareTo(((OrderedTuple) (other)))) == 0;
                }else {
                    return false;
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1136.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1137 = new MethodContext(int.class, 303, 11308, 12069);
        try {
            CallChecker.varInit(this, "this", 303, 11308, 12069);
            CallChecker.varInit(this.nan, "nan", 303, 11308, 12069);
            CallChecker.varInit(this.negInf, "negInf", 303, 11308, 12069);
            CallChecker.varInit(this.posInf, "posInf", 303, 11308, 12069);
            CallChecker.varInit(this.encoding, "encoding", 303, 11308, 12069);
            CallChecker.varInit(this.lsb, "lsb", 303, 11308, 12069);
            CallChecker.varInit(this.offset, "offset", 303, 11308, 12069);
            CallChecker.varInit(this.components, "components", 303, 11308, 12069);
            CallChecker.varInit(IMPLICIT_ONE, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.IMPLICIT_ONE", 303, 11308, 12069);
            CallChecker.varInit(MANTISSA_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.MANTISSA_MASK", 303, 11308, 12069);
            CallChecker.varInit(EXPONENT_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.EXPONENT_MASK", 303, 11308, 12069);
            CallChecker.varInit(SIGN_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.SIGN_MASK", 303, 11308, 12069);
            final int multiplier = CallChecker.varInit(((int) (37)), "multiplier", 305, 11379, 11466);
            final int trueHash = CallChecker.varInit(((int) (97)), "trueHash", 306, 11476, 11501);
            final int falseHash = CallChecker.varInit(((int) (71)), "falseHash", 307, 11511, 11536);
            int hash = CallChecker.varInit(((int) (Arrays.hashCode(this.components))), "hash", 312, 11715, 11753);
            hash = (hash * multiplier) + (offset);
            CallChecker.varAssign(hash, "hash", 313, 11763, 11796);
            hash = (hash * multiplier) + (lsb);
            CallChecker.varAssign(hash, "hash", 314, 11806, 11836);
            if (posInf) {
                hash = (hash * multiplier) + trueHash;
                CallChecker.varAssign(hash, "hash", 315, 11846, 11904);
            }else {
                hash = (hash * multiplier) + falseHash;
                CallChecker.varAssign(hash, "hash", 315, 11846, 11904);
            }
            if (negInf) {
                hash = (hash * multiplier) + trueHash;
                CallChecker.varAssign(hash, "hash", 316, 11914, 11972);
            }else {
                hash = (hash * multiplier) + falseHash;
                CallChecker.varAssign(hash, "hash", 316, 11914, 11972);
            }
            if (nan) {
                hash = (hash * multiplier) + trueHash;
                CallChecker.varAssign(hash, "hash", 317, 11982, 12040);
            }else {
                hash = (hash * multiplier) + falseHash;
                CallChecker.varAssign(hash, "hash", 317, 11982, 12040);
            }
            return hash;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1137.methodEnd();
        }
    }

    public double[] getComponents() {
        MethodContext _bcornu_methode_context1138 = new MethodContext(double[].class, 326, 12076, 12245);
        try {
            CallChecker.varInit(this, "this", 326, 12076, 12245);
            CallChecker.varInit(this.nan, "nan", 326, 12076, 12245);
            CallChecker.varInit(this.negInf, "negInf", 326, 12076, 12245);
            CallChecker.varInit(this.posInf, "posInf", 326, 12076, 12245);
            CallChecker.varInit(this.encoding, "encoding", 326, 12076, 12245);
            CallChecker.varInit(this.lsb, "lsb", 326, 12076, 12245);
            CallChecker.varInit(this.offset, "offset", 326, 12076, 12245);
            CallChecker.varInit(this.components, "components", 326, 12076, 12245);
            CallChecker.varInit(IMPLICIT_ONE, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.IMPLICIT_ONE", 326, 12076, 12245);
            CallChecker.varInit(MANTISSA_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.MANTISSA_MASK", 326, 12076, 12245);
            CallChecker.varInit(EXPONENT_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.EXPONENT_MASK", 326, 12076, 12245);
            CallChecker.varInit(SIGN_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.SIGN_MASK", 326, 12076, 12245);
            if (CallChecker.beforeDeref(components, double[].class, 327, 12221, 12230)) {
                components = CallChecker.beforeCalled(components, double[].class, 327, 12221, 12230);
                return CallChecker.isCalled(components, double[].class, 327, 12221, 12230).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1138.methodEnd();
        }
    }

    private static long sign(final long bits) {
        MethodContext _bcornu_methode_context1139 = new MethodContext(long.class, 334, 12252, 12513);
        try {
            CallChecker.varInit(bits, "bits", 334, 12252, 12513);
            CallChecker.varInit(IMPLICIT_ONE, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.IMPLICIT_ONE", 334, 12252, 12513);
            CallChecker.varInit(MANTISSA_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.MANTISSA_MASK", 334, 12252, 12513);
            CallChecker.varInit(EXPONENT_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.EXPONENT_MASK", 334, 12252, 12513);
            CallChecker.varInit(SIGN_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.SIGN_MASK", 334, 12252, 12513);
            return bits & (OrderedTuple.SIGN_MASK);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1139.methodEnd();
        }
    }

    private static int exponent(final long bits) {
        MethodContext _bcornu_methode_context1140 = new MethodContext(int.class, 342, 12520, 12776);
        try {
            CallChecker.varInit(bits, "bits", 342, 12520, 12776);
            CallChecker.varInit(IMPLICIT_ONE, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.IMPLICIT_ONE", 342, 12520, 12776);
            CallChecker.varInit(MANTISSA_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.MANTISSA_MASK", 342, 12520, 12776);
            CallChecker.varInit(EXPONENT_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.EXPONENT_MASK", 342, 12520, 12776);
            CallChecker.varInit(SIGN_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.SIGN_MASK", 342, 12520, 12776);
            return ((int) ((bits & (OrderedTuple.EXPONENT_MASK)) >> 52)) - 1075;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1140.methodEnd();
        }
    }

    private static long mantissa(final long bits) {
        MethodContext _bcornu_methode_context1141 = new MethodContext(long.class, 350, 12783, 13174);
        try {
            CallChecker.varInit(bits, "bits", 350, 12783, 13174);
            CallChecker.varInit(IMPLICIT_ONE, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.IMPLICIT_ONE", 350, 12783, 13174);
            CallChecker.varInit(MANTISSA_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.MANTISSA_MASK", 350, 12783, 13174);
            CallChecker.varInit(EXPONENT_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.EXPONENT_MASK", 350, 12783, 13174);
            CallChecker.varInit(SIGN_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.SIGN_MASK", 350, 12783, 13174);
            if ((bits & (OrderedTuple.EXPONENT_MASK)) == 0) {
                return (bits & (OrderedTuple.MANTISSA_MASK)) << 1;
            }else {
                return (OrderedTuple.IMPLICIT_ONE) | (bits & (OrderedTuple.MANTISSA_MASK));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1141.methodEnd();
        }
    }

    private static int computeMSB(final long l) {
        MethodContext _bcornu_methode_context1142 = new MethodContext(int.class, 362, 13181, 13830);
        try {
            CallChecker.varInit(l, "l", 362, 13181, 13830);
            CallChecker.varInit(IMPLICIT_ONE, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.IMPLICIT_ONE", 362, 13181, 13830);
            CallChecker.varInit(MANTISSA_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.MANTISSA_MASK", 362, 13181, 13830);
            CallChecker.varInit(EXPONENT_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.EXPONENT_MASK", 362, 13181, 13830);
            CallChecker.varInit(SIGN_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.SIGN_MASK", 362, 13181, 13830);
            long ll = CallChecker.varInit(((long) (l)), "ll", 364, 13486, 13497);
            long mask = CallChecker.varInit(((long) (4294967295L)), "mask", 365, 13507, 13531);
            int scale = CallChecker.varInit(((int) (32)), "scale", 366, 13541, 13556);
            int msb = CallChecker.varInit(((int) (0)), "msb", 367, 13566, 13580);
            while (scale != 0) {
                if ((ll & mask) != ll) {
                    msb |= scale;
                    CallChecker.varAssign(msb, "msb", 371, 13665, 13677);
                    ll = ll >> scale;
                    CallChecker.varAssign(ll, "ll", 372, 13695, 13711);
                }
                scale = scale >> 1;
                CallChecker.varAssign(scale, "scale", 374, 13739, 13757);
                mask = mask >> scale;
                CallChecker.varAssign(mask, "mask", 375, 13771, 13792);
            } 
            return msb;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1142.methodEnd();
        }
    }

    private static int computeLSB(final long l) {
        MethodContext _bcornu_methode_context1143 = new MethodContext(int.class, 388, 13837, 14498);
        try {
            CallChecker.varInit(l, "l", 388, 13837, 14498);
            CallChecker.varInit(IMPLICIT_ONE, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.IMPLICIT_ONE", 388, 13837, 14498);
            CallChecker.varInit(MANTISSA_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.MANTISSA_MASK", 388, 13837, 14498);
            CallChecker.varInit(EXPONENT_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.EXPONENT_MASK", 388, 13837, 14498);
            CallChecker.varInit(SIGN_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.SIGN_MASK", 388, 13837, 14498);
            long ll = CallChecker.varInit(((long) (l)), "ll", 390, 14146, 14157);
            long mask = CallChecker.varInit(((long) (-4294967296L)), "mask", 391, 14167, 14199);
            int scale = CallChecker.varInit(((int) (32)), "scale", 392, 14209, 14224);
            int lsb = CallChecker.varInit(((int) (0)), "lsb", 393, 14234, 14248);
            while (scale != 0) {
                if ((ll & mask) == ll) {
                    lsb |= scale;
                    CallChecker.varAssign(lsb, "lsb", 397, 14333, 14345);
                    ll = ll >> scale;
                    CallChecker.varAssign(ll, "ll", 398, 14363, 14379);
                }
                scale = scale >> 1;
                CallChecker.varAssign(scale, "scale", 400, 14407, 14425);
                mask = mask >> scale;
                CallChecker.varAssign(mask, "mask", 401, 14439, 14460);
            } 
            return lsb;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1143.methodEnd();
        }
    }

    private int getBit(final int i, final int k) {
        MethodContext _bcornu_methode_context1144 = new MethodContext(int.class, 414, 14505, 15285);
        try {
            CallChecker.varInit(this, "this", 414, 14505, 15285);
            CallChecker.varInit(k, "k", 414, 14505, 15285);
            CallChecker.varInit(i, "i", 414, 14505, 15285);
            CallChecker.varInit(this.nan, "nan", 414, 14505, 15285);
            CallChecker.varInit(this.negInf, "negInf", 414, 14505, 15285);
            CallChecker.varInit(this.posInf, "posInf", 414, 14505, 15285);
            CallChecker.varInit(this.encoding, "encoding", 414, 14505, 15285);
            CallChecker.varInit(this.lsb, "lsb", 414, 14505, 15285);
            CallChecker.varInit(this.offset, "offset", 414, 14505, 15285);
            CallChecker.varInit(this.components, "components", 414, 14505, 15285);
            CallChecker.varInit(IMPLICIT_ONE, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.IMPLICIT_ONE", 414, 14505, 15285);
            CallChecker.varInit(MANTISSA_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.MANTISSA_MASK", 414, 14505, 15285);
            CallChecker.varInit(EXPONENT_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.EXPONENT_MASK", 414, 14505, 15285);
            CallChecker.varInit(SIGN_MASK, "org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple.SIGN_MASK", 414, 14505, 15285);
            components = CallChecker.beforeCalled(components, double[].class, 415, 14844, 14853);
            final long bits = CallChecker.varInit(((long) (Double.doubleToLongBits(CallChecker.isCalled(this.components, double[].class, 415, 14844, 14853)[i]))), "bits", 415, 14802, 14858);
            final int e = CallChecker.varInit(((int) (OrderedTuple.exponent(bits))), "e", 416, 14868, 14896);
            if ((k < e) || (k > (offset))) {
                return 0;
            }else
                if (k == (offset)) {
                    if ((OrderedTuple.sign(bits)) == 0L) {
                        return 1;
                    }else {
                        return 0;
                    }
                }else
                    if (k > (e + 52)) {
                        if ((OrderedTuple.sign(bits)) == 0L) {
                            return 0;
                        }else {
                            return 1;
                        }
                    }else {
                        long m = CallChecker.init(long.class);
                        if ((OrderedTuple.sign(bits)) == 0L) {
                            m = OrderedTuple.mantissa(bits);
                            CallChecker.varAssign(m, "m", 424, 15166, 15218);
                        }else {
                            m = -(OrderedTuple.mantissa(bits));
                            CallChecker.varAssign(m, "m", 424, 15166, 15218);
                        }
                        return ((int) ((m >> (k - e)) & 1L));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1144.methodEnd();
        }
    }
}

