package org.apache.commons.math3.stat;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

public class Frequency implements Serializable {
    private static class NaturalComparator<T extends Comparable<T>> implements Serializable , Comparator<Comparable<T>> {
        private static final long serialVersionUID = -3852193713161395148L;

        @SuppressWarnings(value = "unchecked")
        public int compare(Comparable<T> o1, Comparable<T> o2) {
            MethodContext _bcornu_methode_context3137 = new MethodContext(int.class, 559, 18083, 18972);
            try {
                CallChecker.varInit(this, "this", 559, 18083, 18972);
                CallChecker.varInit(o2, "o2", 559, 18083, 18972);
                CallChecker.varInit(o1, "o1", 559, 18083, 18972);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.NaturalComparator.serialVersionUID", 559, 18083, 18972);
                if (CallChecker.beforeDeref(o1, Comparable.class, 560, 18942, 18943)) {
                    o1 = CallChecker.beforeCalled(o1, Comparable.class, 560, 18942, 18943);
                    return CallChecker.isCalled(o1, Comparable.class, 560, 18942, 18943).compareTo(((T) (o2)));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3137.methodEnd();
            }
        }
    }

    private static final long serialVersionUID = -3845586908418844111L;

    private final TreeMap<Comparable<?>, Long> freqTable;

    public Frequency() {
        ConstructorContext _bcornu_methode_context711 = new ConstructorContext(Frequency.class, 64, 2453, 2578);
        try {
            freqTable = new TreeMap<Comparable<?>, Long>();
            CallChecker.varAssign(this.freqTable, "this.freqTable", 65, 2526, 2572);
        } finally {
            _bcornu_methode_context711.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public Frequency(Comparator<?> comparator) {
        ConstructorContext _bcornu_methode_context712 = new ConstructorContext(Frequency.class, 74, 2585, 2938);
        try {
            freqTable = new TreeMap<Comparable<?>, Long>(((Comparator<? super Comparable<?>>) (comparator)));
            CallChecker.varAssign(this.freqTable, "this.freqTable", 75, 2840, 2932);
        } finally {
            _bcornu_methode_context712.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context3138 = new MethodContext(String.class, 85, 2945, 3853);
        try {
            CallChecker.varInit(this, "this", 85, 2945, 3853);
            CallChecker.varInit(this.freqTable, "freqTable", 85, 2945, 3853);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 85, 2945, 3853);
            NumberFormat nf = CallChecker.varInit(NumberFormat.getPercentInstance(), "nf", 86, 3134, 3185);
            StringBuilder outBuffer = CallChecker.varInit(new StringBuilder(), "outBuffer", 87, 3195, 3240);
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 88, 3250, 3258)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 88, 3250, 3258);
                CallChecker.isCalled(outBuffer, StringBuilder.class, 88, 3250, 3258).append("Value \t Freq. \t Pct. \t Cum Pct. \n");
            }
            Iterator<Comparable<?>> iter = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(freqTable, TreeMap.class, 89, 3348, 3356)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(freqTable, TreeMap.class, 89, 3348, 3356).keySet(), Set.class, 89, 3348, 3365)) {
                    iter = CallChecker.isCalled(CallChecker.isCalled(freqTable, TreeMap.class, 89, 3348, 3356).keySet(), Set.class, 89, 3348, 3365).iterator();
                    CallChecker.varAssign(iter, "iter", 89, 3348, 3356);
                }
            }
            iter = CallChecker.beforeCalled(iter, Iterator.class, 90, 3394, 3397);
            while (CallChecker.isCalled(iter, Iterator.class, 90, 3394, 3397).hasNext()) {
                Comparable<?> value = CallChecker.init(Comparable.class);
                if (CallChecker.beforeDeref(iter, Iterator.class, 91, 3446, 3449)) {
                    iter = CallChecker.beforeCalled(iter, Iterator.class, 91, 3446, 3449);
                    value = CallChecker.isCalled(iter, Iterator.class, 91, 3446, 3449).next();
                    CallChecker.varAssign(value, "value", 91, 3446, 3449);
                }
                if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 92, 3471, 3479)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 92, 3471, 3479);
                    CallChecker.isCalled(outBuffer, StringBuilder.class, 92, 3471, 3479).append(value);
                }
                if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 93, 3508, 3516)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 93, 3508, 3516);
                    CallChecker.isCalled(outBuffer, StringBuilder.class, 93, 3508, 3516).append('\t');
                }
                if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 94, 3544, 3552)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 94, 3544, 3552);
                    CallChecker.isCalled(outBuffer, StringBuilder.class, 94, 3544, 3552).append(getCount(value));
                }
                if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 95, 3591, 3599)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 95, 3591, 3599);
                    CallChecker.isCalled(outBuffer, StringBuilder.class, 95, 3591, 3599).append('\t');
                }
                if (CallChecker.beforeDeref(nf, NumberFormat.class, 96, 3644, 3645)) {
                    if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 96, 3627, 3635)) {
                        nf = CallChecker.beforeCalled(nf, NumberFormat.class, 96, 3644, 3645);
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 96, 3627, 3635);
                        CallChecker.isCalled(outBuffer, StringBuilder.class, 96, 3627, 3635).append(CallChecker.isCalled(nf, NumberFormat.class, 96, 3644, 3645).format(getPct(value)));
                    }
                }
                if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 97, 3683, 3691)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 97, 3683, 3691);
                    CallChecker.isCalled(outBuffer, StringBuilder.class, 97, 3683, 3691).append('\t');
                }
                if (CallChecker.beforeDeref(nf, NumberFormat.class, 98, 3736, 3737)) {
                    if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 98, 3719, 3727)) {
                        nf = CallChecker.beforeCalled(nf, NumberFormat.class, 98, 3736, 3737);
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 98, 3719, 3727);
                        CallChecker.isCalled(outBuffer, StringBuilder.class, 98, 3719, 3727).append(CallChecker.isCalled(nf, NumberFormat.class, 98, 3736, 3737).format(getCumPct(value)));
                    }
                }
                if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 99, 3778, 3786)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 99, 3778, 3786);
                    CallChecker.isCalled(outBuffer, StringBuilder.class, 99, 3778, 3786).append('\n');
                }
            } 
            if (CallChecker.beforeDeref(outBuffer, StringBuilder.class, 101, 3827, 3835)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuilder.class, 101, 3827, 3835);
                return CallChecker.isCalled(outBuffer, StringBuilder.class, 101, 3827, 3835).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3138.methodEnd();
        }
    }

    public void addValue(Comparable<?> v) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3139 = new MethodContext(void.class, 114, 3860, 4330);
        try {
            CallChecker.varInit(this, "this", 114, 3860, 4330);
            CallChecker.varInit(v, "v", 114, 3860, 4330);
            CallChecker.varInit(this.freqTable, "freqTable", 114, 3860, 4330);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 114, 3860, 4330);
            incrementValue(v, 1);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3139.methodEnd();
        }
    }

    public void incrementValue(Comparable<?> v, long increment) {
        MethodContext _bcornu_methode_context3140 = new MethodContext(void.class, 130, 4337, 5560);
        try {
            CallChecker.varInit(this, "this", 130, 4337, 5560);
            CallChecker.varInit(increment, "increment", 130, 4337, 5560);
            CallChecker.varInit(v, "v", 130, 4337, 5560);
            CallChecker.varInit(this.freqTable, "freqTable", 130, 4337, 5560);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 130, 4337, 5560);
            Comparable<?> obj = CallChecker.varInit(v, "obj", 131, 4857, 4878);
            if (v instanceof Integer) {
                if (CallChecker.beforeDeref(v, Comparable.class, 133, 4958, 4958)) {
                    v = CallChecker.beforeCalled(v, Integer.class, 133, 4958, 4958);
                    obj = Long.valueOf(CallChecker.isCalled(((Integer) (v)), Integer.class, 133, 4958, 4958).longValue());
                    CallChecker.varAssign(obj, "obj", 133, 4928, 4973);
                }
            }
            TryContext _bcornu_try_context_64 = new TryContext(64, Frequency.class, "java.lang.ClassCastException");
            try {
                Long count = CallChecker.init(Long.class);
                if (CallChecker.beforeDeref(freqTable, TreeMap.class, 136, 5024, 5032)) {
                    count = CallChecker.isCalled(freqTable, TreeMap.class, 136, 5024, 5032).get(obj);
                    CallChecker.varAssign(count, "count", 136, 5024, 5032);
                }
                if (count == null) {
                    if (CallChecker.beforeDeref(freqTable, TreeMap.class, 138, 5093, 5101)) {
                        CallChecker.isCalled(freqTable, TreeMap.class, 138, 5093, 5101).put(obj, Long.valueOf(increment));
                    }
                }else {
                    if (CallChecker.beforeDeref(freqTable, TreeMap.class, 140, 5175, 5183)) {
                        CallChecker.isCalled(freqTable, TreeMap.class, 140, 5175, 5183).put(obj, Long.valueOf(((count.longValue()) + increment)));
                    }
                }
            } catch (ClassCastException ex) {
                _bcornu_try_context_64.catchStart(64);
                if (CallChecker.beforeDeref(v, Comparable.class, 146, 5521, 5521)) {
                    v = CallChecker.beforeCalled(v, Comparable.class, 146, 5521, 5521);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(v, Comparable.class, 146, 5521, 5521).getClass(), Class.class, 146, 5521, 5532)) {
                        v = CallChecker.beforeCalled(v, Comparable.class, 146, 5521, 5521);
                        throw new MathIllegalArgumentException(LocalizedFormats.INSTANCES_NOT_COMPARABLE_TO_EXISTING_VALUES, CallChecker.isCalled(CallChecker.isCalled(v, Comparable.class, 146, 5521, 5521).getClass(), Class.class, 146, 5521, 5532).getName());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } finally {
                _bcornu_try_context_64.finallyStart(64);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3140.methodEnd();
        }
    }

    public void addValue(int v) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3141 = new MethodContext(void.class, 157, 5567, 5880);
        try {
            CallChecker.varInit(this, "this", 157, 5567, 5880);
            CallChecker.varInit(v, "v", 157, 5567, 5880);
            CallChecker.varInit(this.freqTable, "freqTable", 157, 5567, 5880);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 157, 5567, 5880);
            addValue(Long.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3141.methodEnd();
        }
    }

    public void addValue(long v) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3142 = new MethodContext(void.class, 168, 5887, 6198);
        try {
            CallChecker.varInit(this, "this", 168, 5887, 6198);
            CallChecker.varInit(v, "v", 168, 5887, 6198);
            CallChecker.varInit(this.freqTable, "freqTable", 168, 5887, 6198);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 168, 5887, 6198);
            addValue(Long.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3142.methodEnd();
        }
    }

    public void addValue(char v) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3143 = new MethodContext(void.class, 179, 6205, 6521);
        try {
            CallChecker.varInit(this, "this", 179, 6205, 6521);
            CallChecker.varInit(v, "v", 179, 6205, 6521);
            CallChecker.varInit(this.freqTable, "freqTable", 179, 6205, 6521);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 179, 6205, 6521);
            addValue(Character.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3143.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context3144 = new MethodContext(void.class, 184, 6528, 6619);
        try {
            CallChecker.varInit(this, "this", 184, 6528, 6619);
            CallChecker.varInit(this.freqTable, "freqTable", 184, 6528, 6619);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 184, 6528, 6619);
            if (CallChecker.beforeDeref(freqTable, TreeMap.class, 185, 6596, 6604)) {
                CallChecker.isCalled(freqTable, TreeMap.class, 185, 6596, 6604).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3144.methodEnd();
        }
    }

    public Iterator<Comparable<?>> valuesIterator() {
        MethodContext _bcornu_methode_context3145 = new MethodContext(Iterator.class, 197, 6626, 7079);
        try {
            CallChecker.varInit(this, "this", 197, 6626, 7079);
            CallChecker.varInit(this.freqTable, "freqTable", 197, 6626, 7079);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 197, 6626, 7079);
            if (CallChecker.beforeDeref(freqTable, TreeMap.class, 198, 7044, 7052)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(freqTable, TreeMap.class, 198, 7044, 7052).keySet(), Set.class, 198, 7044, 7061)) {
                    return CallChecker.isCalled(CallChecker.isCalled(freqTable, TreeMap.class, 198, 7044, 7052).keySet(), Set.class, 198, 7044, 7061).iterator();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<Comparable<?>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3145.methodEnd();
        }
    }

    public Iterator<Map.Entry<Comparable<?>, Long>> entrySetIterator() {
        MethodContext _bcornu_methode_context3146 = new MethodContext(Iterator.class, 214, 7086, 7840);
        try {
            CallChecker.varInit(this, "this", 214, 7086, 7840);
            CallChecker.varInit(this.freqTable, "freqTable", 214, 7086, 7840);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 214, 7086, 7840);
            if (CallChecker.beforeDeref(freqTable, TreeMap.class, 215, 7803, 7811)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(freqTable, TreeMap.class, 215, 7803, 7811).entrySet(), Set.class, 215, 7803, 7822)) {
                    return CallChecker.isCalled(CallChecker.isCalled(freqTable, TreeMap.class, 215, 7803, 7811).entrySet(), Set.class, 215, 7803, 7822).iterator();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<Map.Entry<Comparable<?>, Long>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3146.methodEnd();
        }
    }

    public long getSumFreq() {
        MethodContext _bcornu_methode_context3147 = new MethodContext(long.class, 225, 7847, 8279);
        try {
            CallChecker.varInit(this, "this", 225, 7847, 8279);
            CallChecker.varInit(this.freqTable, "freqTable", 225, 7847, 8279);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 225, 7847, 8279);
            long result = CallChecker.varInit(((long) (0)), "result", 226, 8071, 8086);
            Iterator<Long> iterator = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(freqTable, TreeMap.class, 227, 8122, 8130)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(freqTable, TreeMap.class, 227, 8122, 8130).values(), Collection.class, 227, 8122, 8139)) {
                    iterator = CallChecker.isCalled(CallChecker.isCalled(freqTable, TreeMap.class, 227, 8122, 8130).values(), Collection.class, 227, 8122, 8139).iterator();
                    CallChecker.varAssign(iterator, "iterator", 227, 8122, 8130);
                }
            }
            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 228, 8168, 8175);
            while (CallChecker.isCalled(iterator, Iterator.class, 228, 8168, 8175).hasNext()) {
                if (CallChecker.beforeDeref(iterator, Iterator.class, 229, 8213, 8220)) {
                    iterator = CallChecker.beforeCalled(iterator, Iterator.class, 229, 8213, 8220);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(iterator, Iterator.class, 229, 8213, 8220).next(), Long.class, 229, 8213, 8227)) {
                        iterator = CallChecker.beforeCalled(iterator, Iterator.class, 229, 8213, 8220);
                        result += CallChecker.isCalled(CallChecker.isCalled(iterator, Iterator.class, 229, 8213, 8220).next(), Long.class, 229, 8213, 8227).longValue();
                        CallChecker.varAssign(result, "result", 229, 8203, 8240);
                    }
                }
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3147.methodEnd();
        }
    }

    public long getCount(Comparable<?> v) {
        MethodContext _bcornu_methode_context3148 = new MethodContext(long.class, 241, 8286, 8974);
        try {
            CallChecker.varInit(this, "this", 241, 8286, 8974);
            CallChecker.varInit(v, "v", 241, 8286, 8974);
            CallChecker.varInit(this.freqTable, "freqTable", 241, 8286, 8974);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 241, 8286, 8974);
            if (v instanceof Integer) {
                if (CallChecker.beforeDeref(v, Comparable.class, 243, 8586, 8586)) {
                    v = CallChecker.beforeCalled(v, Integer.class, 243, 8586, 8586);
                    return getCount(CallChecker.isCalled(((Integer) (v)), Integer.class, 243, 8586, 8586).longValue());
                }else
                    throw new AbnormalExecutionError();
                
            }
            long result = CallChecker.varInit(((long) (0)), "result", 245, 8621, 8636);
            TryContext _bcornu_try_context_65 = new TryContext(65, Frequency.class, "java.lang.ClassCastException");
            try {
                Long count = CallChecker.init(Long.class);
                if (CallChecker.beforeDeref(freqTable, TreeMap.class, 247, 8678, 8686)) {
                    count = CallChecker.isCalled(freqTable, TreeMap.class, 247, 8678, 8686).get(v);
                    CallChecker.varAssign(count, "count", 247, 8678, 8686);
                }
                if (count != null) {
                    result = count.longValue();
                    CallChecker.varAssign(result, "result", 249, 8745, 8771);
                }
            } catch (ClassCastException ex) {
                _bcornu_try_context_65.catchStart(65);
            } finally {
                _bcornu_try_context_65.finallyStart(65);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3148.methodEnd();
        }
    }

    public long getCount(int v) {
        MethodContext _bcornu_methode_context3149 = new MethodContext(long.class, 263, 8981, 9193);
        try {
            CallChecker.varInit(this, "this", 263, 8981, 9193);
            CallChecker.varInit(v, "v", 263, 8981, 9193);
            CallChecker.varInit(this.freqTable, "freqTable", 263, 8981, 9193);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 263, 8981, 9193);
            return getCount(Long.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3149.methodEnd();
        }
    }

    public long getCount(long v) {
        MethodContext _bcornu_methode_context3150 = new MethodContext(long.class, 273, 9200, 9413);
        try {
            CallChecker.varInit(this, "this", 273, 9200, 9413);
            CallChecker.varInit(v, "v", 273, 9200, 9413);
            CallChecker.varInit(this.freqTable, "freqTable", 273, 9200, 9413);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 273, 9200, 9413);
            return getCount(Long.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3150.methodEnd();
        }
    }

    public long getCount(char v) {
        MethodContext _bcornu_methode_context3151 = new MethodContext(long.class, 283, 9420, 9638);
        try {
            CallChecker.varInit(this, "this", 283, 9420, 9638);
            CallChecker.varInit(v, "v", 283, 9420, 9638);
            CallChecker.varInit(this.freqTable, "freqTable", 283, 9420, 9638);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 283, 9420, 9638);
            return getCount(Character.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3151.methodEnd();
        }
    }

    public int getUniqueCount() {
        MethodContext _bcornu_methode_context3152 = new MethodContext(int.class, 293, 9645, 9921);
        try {
            CallChecker.varInit(this, "this", 293, 9645, 9921);
            CallChecker.varInit(this.freqTable, "freqTable", 293, 9645, 9921);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 293, 9645, 9921);
            if (CallChecker.beforeDeref(freqTable, TreeMap.class, 294, 9890, 9898)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(freqTable, TreeMap.class, 294, 9890, 9898).keySet(), Set.class, 294, 9890, 9907)) {
                    return CallChecker.isCalled(CallChecker.isCalled(freqTable, TreeMap.class, 294, 9890, 9898).keySet(), Set.class, 294, 9890, 9907).size();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3152.methodEnd();
        }
    }

    public double getPct(Comparable<?> v) {
        MethodContext _bcornu_methode_context3153 = new MethodContext(double.class, 306, 9928, 10436);
        try {
            CallChecker.varInit(this, "this", 306, 9928, 10436);
            CallChecker.varInit(v, "v", 306, 9928, 10436);
            CallChecker.varInit(this.freqTable, "freqTable", 306, 9928, 10436);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 306, 9928, 10436);
            final long sumFreq = CallChecker.varInit(((long) (getSumFreq())), "sumFreq", 307, 10272, 10305);
            if (sumFreq == 0) {
                return Double.NaN;
            }
            return ((double) (getCount(v))) / ((double) (sumFreq));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3153.methodEnd();
        }
    }

    public double getPct(int v) {
        MethodContext _bcornu_methode_context3154 = new MethodContext(double.class, 321, 10443, 10729);
        try {
            CallChecker.varInit(this, "this", 321, 10443, 10729);
            CallChecker.varInit(v, "v", 321, 10443, 10729);
            CallChecker.varInit(this.freqTable, "freqTable", 321, 10443, 10729);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 321, 10443, 10729);
            return getPct(Long.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3154.methodEnd();
        }
    }

    public double getPct(long v) {
        MethodContext _bcornu_methode_context3155 = new MethodContext(double.class, 332, 10736, 11023);
        try {
            CallChecker.varInit(this, "this", 332, 10736, 11023);
            CallChecker.varInit(v, "v", 332, 10736, 11023);
            CallChecker.varInit(this.freqTable, "freqTable", 332, 10736, 11023);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 332, 10736, 11023);
            return getPct(Long.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3155.methodEnd();
        }
    }

    public double getPct(char v) {
        MethodContext _bcornu_methode_context3156 = new MethodContext(double.class, 343, 11030, 11322);
        try {
            CallChecker.varInit(this, "this", 343, 11030, 11322);
            CallChecker.varInit(v, "v", 343, 11030, 11322);
            CallChecker.varInit(this.freqTable, "freqTable", 343, 11030, 11322);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 343, 11030, 11322);
            return getPct(Character.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3156.methodEnd();
        }
    }

    @SuppressWarnings(value = { "rawtypes" , "unchecked" })
    public long getCumFreq(Comparable<?> v) {
        MethodContext _bcornu_methode_context3157 = new MethodContext(long.class, 358, 11329, 13024);
        try {
            CallChecker.varInit(this, "this", 358, 11329, 13024);
            CallChecker.varInit(v, "v", 358, 11329, 13024);
            CallChecker.varInit(this.freqTable, "freqTable", 358, 11329, 13024);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 358, 11329, 13024);
            if ((getSumFreq()) == 0) {
                return 0;
            }
            if (v instanceof Integer) {
                if (CallChecker.beforeDeref(v, Comparable.class, 363, 11921, 11921)) {
                    v = CallChecker.beforeCalled(v, Integer.class, 363, 11921, 11921);
                    return getCumFreq(CallChecker.isCalled(((Integer) (v)), Integer.class, 363, 11921, 11921).longValue());
                }else
                    throw new AbnormalExecutionError();
                
            }
            Comparator<Comparable<?>> c = CallChecker.init(Comparator.class);
            if (CallChecker.beforeDeref(freqTable, TreeMap.class, 365, 12014, 12022)) {
                c = ((Comparator<Comparable<?>>) (CallChecker.isCalled(freqTable, TreeMap.class, 365, 12014, 12022).comparator()));
                CallChecker.varAssign(c, "c", 365, 12014, 12022);
            }
            if (c == null) {
                c = new Frequency.NaturalComparator();
                CallChecker.varAssign(c, "c", 367, 12075, 12102);
            }
            long result = CallChecker.varInit(((long) (0)), "result", 369, 12122, 12137);
            TryContext _bcornu_try_context_66 = new TryContext(66, Frequency.class, "java.lang.ClassCastException");
            try {
                Long value = CallChecker.init(Long.class);
                if (CallChecker.beforeDeref(freqTable, TreeMap.class, 372, 12179, 12187)) {
                    value = CallChecker.isCalled(freqTable, TreeMap.class, 372, 12179, 12187).get(v);
                    CallChecker.varAssign(value, "value", 372, 12179, 12187);
                }
                if (value != null) {
                    result = value.longValue();
                    CallChecker.varAssign(result, "result", 374, 12246, 12272);
                }
            } catch (ClassCastException ex) {
                _bcornu_try_context_66.catchStart(66);
                return result;
            } finally {
                _bcornu_try_context_66.finallyStart(66);
            }
            if (CallChecker.beforeDeref(freqTable, TreeMap.class, 380, 12418, 12426)) {
                if (CallChecker.beforeDeref(c, Comparator.class, 380, 12405, 12405)) {
                    c = CallChecker.beforeCalled(c, Comparator.class, 380, 12405, 12405);
                    if ((CallChecker.isCalled(c, Comparator.class, 380, 12405, 12405).compare(v, CallChecker.isCalled(freqTable, TreeMap.class, 380, 12418, 12426).firstKey())) < 0) {
                        return 0;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(freqTable, TreeMap.class, 384, 12552, 12560)) {
                if (CallChecker.beforeDeref(c, Comparator.class, 384, 12539, 12539)) {
                    c = CallChecker.beforeCalled(c, Comparator.class, 384, 12539, 12539);
                    if ((CallChecker.isCalled(c, Comparator.class, 384, 12539, 12539).compare(v, CallChecker.isCalled(freqTable, TreeMap.class, 384, 12552, 12560).lastKey())) >= 0) {
                        return getSumFreq();
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            Iterator<Comparable<?>> values = CallChecker.varInit(valuesIterator(), "values", 388, 12688, 12737);
            values = CallChecker.beforeCalled(values, Iterator.class, 389, 12754, 12759);
            while (CallChecker.isCalled(values, Iterator.class, 389, 12754, 12759).hasNext()) {
                Comparable<?> nextValue = CallChecker.init(Comparable.class);
                if (CallChecker.beforeDeref(values, Iterator.class, 390, 12812, 12817)) {
                    values = CallChecker.beforeCalled(values, Iterator.class, 390, 12812, 12817);
                    nextValue = CallChecker.isCalled(values, Iterator.class, 390, 12812, 12817).next();
                    CallChecker.varAssign(nextValue, "nextValue", 390, 12812, 12817);
                }
                if (CallChecker.beforeDeref(c, Comparator.class, 391, 12843, 12843)) {
                    c = CallChecker.beforeCalled(c, Comparator.class, 391, 12843, 12843);
                    if ((CallChecker.isCalled(c, Comparator.class, 391, 12843, 12843).compare(v, nextValue)) > 0) {
                        result += getCount(nextValue);
                        CallChecker.varAssign(result, "result", 392, 12890, 12919);
                    }else {
                        return result;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3157.methodEnd();
        }
    }

    public long getCumFreq(int v) {
        MethodContext _bcornu_methode_context3158 = new MethodContext(long.class, 408, 13032, 13371);
        try {
            CallChecker.varInit(this, "this", 408, 13032, 13371);
            CallChecker.varInit(v, "v", 408, 13032, 13371);
            CallChecker.varInit(this.freqTable, "freqTable", 408, 13032, 13371);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 408, 13032, 13371);
            return getCumFreq(Long.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3158.methodEnd();
        }
    }

    public long getCumFreq(long v) {
        MethodContext _bcornu_methode_context3159 = new MethodContext(long.class, 420, 13379, 13719);
        try {
            CallChecker.varInit(this, "this", 420, 13379, 13719);
            CallChecker.varInit(v, "v", 420, 13379, 13719);
            CallChecker.varInit(this.freqTable, "freqTable", 420, 13379, 13719);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 420, 13379, 13719);
            return getCumFreq(Long.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3159.methodEnd();
        }
    }

    public long getCumFreq(char v) {
        MethodContext _bcornu_methode_context3160 = new MethodContext(long.class, 432, 13726, 14071);
        try {
            CallChecker.varInit(this, "this", 432, 13726, 14071);
            CallChecker.varInit(v, "v", 432, 13726, 14071);
            CallChecker.varInit(this.freqTable, "freqTable", 432, 13726, 14071);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 432, 13726, 14071);
            return getCumFreq(Character.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3160.methodEnd();
        }
    }

    public double getCumPct(Comparable<?> v) {
        MethodContext _bcornu_methode_context3161 = new MethodContext(double.class, 449, 14078, 14826);
        try {
            CallChecker.varInit(this, "this", 449, 14078, 14826);
            CallChecker.varInit(v, "v", 449, 14078, 14826);
            CallChecker.varInit(this.freqTable, "freqTable", 449, 14078, 14826);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 449, 14078, 14826);
            final long sumFreq = CallChecker.varInit(((long) (getSumFreq())), "sumFreq", 450, 14660, 14693);
            if (sumFreq == 0) {
                return Double.NaN;
            }
            return ((double) (getCumFreq(v))) / ((double) (sumFreq));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3161.methodEnd();
        }
    }

    public double getCumPct(int v) {
        MethodContext _bcornu_methode_context3162 = new MethodContext(double.class, 466, 14833, 15227);
        try {
            CallChecker.varInit(this, "this", 466, 14833, 15227);
            CallChecker.varInit(v, "v", 466, 14833, 15227);
            CallChecker.varInit(this.freqTable, "freqTable", 466, 14833, 15227);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 466, 14833, 15227);
            return getCumPct(Long.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3162.methodEnd();
        }
    }

    public double getCumPct(long v) {
        MethodContext _bcornu_methode_context3163 = new MethodContext(double.class, 479, 15234, 15629);
        try {
            CallChecker.varInit(this, "this", 479, 15234, 15629);
            CallChecker.varInit(v, "v", 479, 15234, 15629);
            CallChecker.varInit(this.freqTable, "freqTable", 479, 15234, 15629);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 479, 15234, 15629);
            return getCumPct(Long.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3163.methodEnd();
        }
    }

    public double getCumPct(char v) {
        MethodContext _bcornu_methode_context3164 = new MethodContext(double.class, 492, 15636, 16036);
        try {
            CallChecker.varInit(this, "this", 492, 15636, 16036);
            CallChecker.varInit(v, "v", 492, 15636, 16036);
            CallChecker.varInit(this.freqTable, "freqTable", 492, 15636, 16036);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 492, 15636, 16036);
            return getCumPct(Character.valueOf(v));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3164.methodEnd();
        }
    }

    public void merge(final Frequency other) throws NullArgumentException {
        MethodContext _bcornu_methode_context3165 = new MethodContext(void.class, 507, 16043, 16921);
        try {
            CallChecker.varInit(this, "this", 507, 16043, 16921);
            CallChecker.varInit(other, "other", 507, 16043, 16921);
            CallChecker.varInit(this.freqTable, "freqTable", 507, 16043, 16921);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 507, 16043, 16921);
            MathUtils.checkNotNull(other, LocalizedFormats.NULL_NOT_ALLOWED);
            final Iterator<Map.Entry<Comparable<?>, Long>> iter = CallChecker.varInit(CallChecker.isCalled(other, Frequency.class, 510, 16716, 16720).entrySetIterator(), "iter", 510, 16662, 16740);
            while (CallChecker.isCalled(iter, Iterator.class, 511, 16757, 16760).hasNext()) {
                final Map.Entry<Comparable<?>, Long> entry = CallChecker.varInit(CallChecker.isCalled(iter, Iterator.class, 512, 16832, 16835).next(), "entry", 512, 16787, 16843);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 513, 16872, 16876)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 513, 16888, 16892)) {
                        incrementValue(CallChecker.isCalled(entry, Map.Entry.class, 513, 16872, 16876).getKey(), CallChecker.isCalled(entry, Map.Entry.class, 513, 16888, 16892).getValue());
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3165.methodEnd();
        }
    }

    public void merge(final Collection<Frequency> others) throws NullArgumentException {
        MethodContext _bcornu_methode_context3166 = new MethodContext(void.class, 526, 16928, 17568);
        try {
            CallChecker.varInit(this, "this", 526, 16928, 17568);
            CallChecker.varInit(others, "others", 526, 16928, 17568);
            CallChecker.varInit(this.freqTable, "freqTable", 526, 16928, 17568);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 526, 16928, 17568);
            MathUtils.checkNotNull(others, LocalizedFormats.NULL_NOT_ALLOWED);
            if (CallChecker.beforeDeref(others, void.class, 529, 17519, 17524)) {
                for (final Frequency freq : others) {
                    merge(freq);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3166.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context3167 = new MethodContext(int.class, 566, 18985, 19230);
        try {
            CallChecker.varInit(this, "this", 566, 18985, 19230);
            CallChecker.varInit(this.freqTable, "freqTable", 566, 18985, 19230);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 566, 18985, 19230);
            final int prime = CallChecker.varInit(((int) (31)), "prime", 567, 19056, 19076);
            int result = CallChecker.varInit(((int) (1)), "result", 568, 19086, 19100);
            if ((freqTable) == null) {
                result = (prime * result) + 0;
                CallChecker.varAssign(result, "result", 569, 19110, 19201);
            }else {
                result = (prime * result) + (freqTable.hashCode());
                CallChecker.varAssign(result, "result", 569, 19110, 19201);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3167.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context3168 = new MethodContext(boolean.class, 576, 19237, 19734);
        try {
            CallChecker.varInit(this, "this", 576, 19237, 19734);
            CallChecker.varInit(obj, "obj", 576, 19237, 19734);
            CallChecker.varInit(this.freqTable, "freqTable", 576, 19237, 19734);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.Frequency.serialVersionUID", 576, 19237, 19734);
            if ((this) == obj) {
                return true;
            }
            if (!(obj instanceof Frequency)) {
                return false;
            }
            Frequency other = CallChecker.varInit(((Frequency) (obj)), "other", 583, 19461, 19494);
            if ((freqTable) == null) {
                if (CallChecker.beforeDeref(other, Frequency.class, 585, 19545, 19549)) {
                    other = CallChecker.beforeCalled(other, Frequency.class, 585, 19545, 19549);
                    if ((CallChecker.isCalled(other, Frequency.class, 585, 19545, 19549).freqTable) != null) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (CallChecker.beforeDeref(other, Frequency.class, 588, 19653, 19657)) {
                    other = CallChecker.beforeCalled(other, Frequency.class, 588, 19653, 19657);
                    if (!(freqTable.equals(CallChecker.isCalled(other, Frequency.class, 588, 19653, 19657).freqTable))) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3168.methodEnd();
        }
    }
}

