package org.apache.commons.collections.map;

import org.apache.commons.collections.list.UnmodifiableList;
import java.util.Set;
import java.io.Serializable;
import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.OrderedMap;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;
import org.apache.commons.collections.iterators.AbstractUntypedIteratorDecorator;
import java.util.AbstractSet;
import org.apache.commons.collections.keyvalue.AbstractMapEntry;
import java.util.AbstractList;
import org.apache.commons.collections.keyvalue.AbstractKeyValue;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;

public class ListOrderedMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable , OrderedMap<K, V> {
    private static final long serialVersionUID = 2728177751851003750L;

    protected final List<K> insertOrder = new ArrayList<K>();

    public static <K, V> OrderedMap<K, V> decorate(Map<K, V> map) {
        MethodContext _bcornu_methode_context2141 = new MethodContext(OrderedMap.class);
        try {
            CallChecker.varInit(map, "map", 99, 4026, 4393);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 99, 4026, 4393);
            return new ListOrderedMap<K, V>(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2141.methodEnd();
        }
    }

    public ListOrderedMap() {
        this(new HashMap<K, V>());
        MethodContext _bcornu_methode_context408 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context408.methodEnd();
        }
    }

    protected ListOrderedMap(Map<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context409 = new MethodContext(null);
        try {
            final Map<K, V> npe_invocation_var403 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var403, Map.class, 122, 4985, 4995)) {
                if (CallChecker.beforeDeref(insertOrder, List.class, 122, 4966, 4976)) {
                    CallChecker.isCalled(insertOrder, List.class, 122, 4966, 4976).addAll(CallChecker.isCalled(npe_invocation_var403, Map.class, 122, 4985, 4995).keySet());
                }
            }
        } finally {
            _bcornu_methode_context409.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2142 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 133, 5019, 5410);
            CallChecker.varInit(out, "out", 133, 5019, 5410);
            CallChecker.varInit(this.map, "map", 133, 5019, 5410);
            CallChecker.varInit(this.insertOrder, "insertOrder", 133, 5019, 5410);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 133, 5019, 5410);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 134, 5350, 5352)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 134, 5350, 5352);
                CallChecker.isCalled(out, ObjectOutputStream.class, 134, 5350, 5352).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 135, 5384, 5386)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 135, 5384, 5386);
                CallChecker.isCalled(out, ObjectOutputStream.class, 135, 5384, 5386).writeObject(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2142.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2143 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 147, 5417, 5892);
            CallChecker.varInit(in, "in", 147, 5417, 5892);
            CallChecker.varInit(this.map, "map", 147, 5417, 5892);
            CallChecker.varInit(this.insertOrder, "insertOrder", 147, 5417, 5892);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 147, 5417, 5892);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 148, 5814, 5815)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 148, 5814, 5815);
                CallChecker.isCalled(in, ObjectInputStream.class, 148, 5814, 5815).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 149, 5864, 5865)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 149, 5864, 5865);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 149, 5864, 5865).readObject()));
                CallChecker.varAssign(this.map, "this.map", 149, 5846, 5879);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2143.methodEnd();
        }
    }

    @Override
    public OrderedMapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context2144 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 155, 5899, 6126);
            CallChecker.varInit(this.map, "map", 155, 5899, 6126);
            CallChecker.varInit(this.insertOrder, "insertOrder", 155, 5899, 6126);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 155, 5899, 6126);
            return new ListOrderedMap.ListOrderedMapIterator<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2144.methodEnd();
        }
    }

    public K firstKey() {
        if ((size()) == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        if (CallChecker.beforeDeref(insertOrder, List.class, 169, 6457, 6467)) {
            return insertOrder.get(0);
        }else
            throw new AbnormalExecutionError();
        
    }

    public K lastKey() {
        if ((size()) == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        if (CallChecker.beforeDeref(insertOrder, List.class, 182, 6809, 6819)) {
            return insertOrder.get(((size()) - 1));
        }else
            throw new AbnormalExecutionError();
        
    }

    public K nextKey(Object key) {
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(insertOrder, List.class, 193, 7171, 7181)) {
            index = CallChecker.isCalled(insertOrder, List.class, 193, 7171, 7181).indexOf(key);
            CallChecker.varAssign(index, "index", 193, 7171, 7181);
        }
        if ((index >= 0) && (index < ((size()) - 1))) {
            if (CallChecker.beforeDeref(insertOrder, List.class, 195, 7264, 7274)) {
                return insertOrder.get((index + 1));
            }else
                throw new AbnormalExecutionError();
            
        }
        return null;
    }

    public K previousKey(Object key) {
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(insertOrder, List.class, 208, 7664, 7674)) {
            index = CallChecker.isCalled(insertOrder, List.class, 208, 7664, 7674).indexOf(key);
            CallChecker.varAssign(index, "index", 208, 7664, 7674);
        }
        if (index > 0) {
            if (CallChecker.beforeDeref(insertOrder, List.class, 210, 7734, 7744)) {
                return insertOrder.get((index - 1));
            }else
                throw new AbnormalExecutionError();
            
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        final Map<K, V> npe_invocation_var404 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var404, Map.class, 218, 7939, 7949)) {
            if (CallChecker.isCalled(npe_invocation_var404, Map.class, 218, 7939, 7949).containsKey(key)) {
                final Map<K, V> npe_invocation_var405 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var405, Map.class, 220, 8036, 8046)) {
                    return npe_invocation_var405.put(key, value);
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                final Map<K, V> npe_invocation_var406 = decorated();
                V result = CallChecker.init(null);
                if (CallChecker.beforeDeref(npe_invocation_var406, Map.class, 223, 8159, 8169)) {
                    result = npe_invocation_var406.put(key, value);
                    CallChecker.varAssign(result, "result", 223, 8159, 8169);
                }
                if (CallChecker.beforeDeref(insertOrder, List.class, 224, 8200, 8210)) {
                    CallChecker.isCalled(insertOrder, List.class, 224, 8200, 8210).add(key);
                }
                return result;
            }
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context2150 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 230, 8270, 8480);
            CallChecker.varInit(map, "map", 230, 8270, 8480);
            CallChecker.varInit(this.map, "map", 230, 8270, 8480);
            CallChecker.varInit(this.insertOrder, "insertOrder", 230, 8270, 8480);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 230, 8270, 8480);
            map = CallChecker.beforeCalled(map, Map.class, 231, 8397, 8399);
            for (Map.Entry<? extends K, ? extends V> entry : CallChecker.isCalled(map, Map.class, 231, 8397, 8399).entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 232, 8431, 8435)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 232, 8447, 8451)) {
                        put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2150.methodEnd();
        }
    }

    public void putAll(int index, Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context2151 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 243, 8487, 8964);
            CallChecker.varInit(map, "map", 243, 8487, 8964);
            CallChecker.varInit(index, "index", 243, 8487, 8964);
            CallChecker.varInit(this.map, "map", 243, 8487, 8964);
            CallChecker.varInit(this.insertOrder, "insertOrder", 243, 8487, 8964);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 243, 8487, 8964);
            map = CallChecker.beforeCalled(map, Map.class, 244, 8853, 8855);
            for (Map.Entry<? extends K, ? extends V> entry : CallChecker.isCalled(map, Map.class, 244, 8853, 8855).entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 245, 8894, 8898)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 245, 8910, 8914)) {
                        put(index, entry.getKey(), entry.getValue());
                    }
                }
                index++;
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2151.methodEnd();
        }
    }

    @Override
    public V remove(Object key) {
        final Map<K, V> npe_invocation_var407 = decorated();
        V result = CallChecker.init(null);
        if (CallChecker.beforeDeref(npe_invocation_var407, Map.class, 252, 9034, 9044)) {
            result = npe_invocation_var407.remove(key);
            CallChecker.varAssign(result, "result", 252, 9034, 9044);
        }
        if (CallChecker.beforeDeref(insertOrder, List.class, 253, 9067, 9077)) {
            CallChecker.isCalled(insertOrder, List.class, 253, 9067, 9077).remove(key);
        }
        return result;
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2153 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 258, 9126, 9224);
            CallChecker.varInit(this.map, "map", 258, 9126, 9224);
            CallChecker.varInit(this.insertOrder, "insertOrder", 258, 9126, 9224);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 258, 9126, 9224);
            final Map<K, V> npe_invocation_var408 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var408, Map.class, 259, 9170, 9180)) {
                CallChecker.isCalled(npe_invocation_var408, Map.class, 259, 9170, 9180).clear();
            }
            if (CallChecker.beforeDeref(insertOrder, List.class, 260, 9199, 9209)) {
                CallChecker.isCalled(insertOrder, List.class, 260, 9199, 9209).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2153.methodEnd();
        }
    }

    @Override
    public Set<K> keySet() {
        MethodContext _bcornu_methode_context2154 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 273, 9231, 9632);
            CallChecker.varInit(this.map, "map", 273, 9231, 9632);
            CallChecker.varInit(this.insertOrder, "insertOrder", 273, 9231, 9632);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 273, 9231, 9632);
            return new ListOrderedMap.KeySetView<K>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2154.methodEnd();
        }
    }

    public List<K> keyList() {
        MethodContext _bcornu_methode_context2155 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 287, 9639, 10029);
            CallChecker.varInit(this.map, "map", 287, 9639, 10029);
            CallChecker.varInit(this.insertOrder, "insertOrder", 287, 9639, 10029);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 287, 9639, 10029);
            return UnmodifiableList.decorate(insertOrder);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2155.methodEnd();
        }
    }

    @Override
    public Collection<V> values() {
        MethodContext _bcornu_methode_context2156 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 303, 10036, 10491);
            CallChecker.varInit(this.map, "map", 303, 10036, 10491);
            CallChecker.varInit(this.insertOrder, "insertOrder", 303, 10036, 10491);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 303, 10036, 10491);
            return new ListOrderedMap.ValuesView<V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2156.methodEnd();
        }
    }

    public List<V> valueList() {
        MethodContext _bcornu_methode_context2157 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 317, 10498, 10921);
            CallChecker.varInit(this.map, "map", 317, 10498, 10921);
            CallChecker.varInit(this.insertOrder, "insertOrder", 317, 10498, 10921);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 317, 10498, 10921);
            return new ListOrderedMap.ValuesView<V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2157.methodEnd();
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context2158 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 329, 10928, 11259);
            CallChecker.varInit(this.map, "map", 329, 10928, 11259);
            CallChecker.varInit(this.insertOrder, "insertOrder", 329, 10928, 11259);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 329, 10928, 11259);
            return new ListOrderedMap.EntrySetView<K, V>(this, this.insertOrder);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2158.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context2159 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 340, 11266, 12115);
            CallChecker.varInit(this.map, "map", 340, 11266, 12115);
            CallChecker.varInit(this.insertOrder, "insertOrder", 340, 11266, 12115);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 340, 11266, 12115);
            if (isEmpty()) {
                return "{}";
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(), "buf", 344, 11548, 11587);
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 345, 11597, 11599)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 345, 11597, 11599);
                CallChecker.isCalled(buf, StringBuilder.class, 345, 11597, 11599).append('{');
            }
            boolean first = CallChecker.varInit(((boolean) (true)), "first", 346, 11622, 11642);
            for (Map.Entry<K, V> entry : entrySet()) {
                K key = CallChecker.init(null);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 348, 11715, 11719)) {
                    key = entry.getKey();
                    CallChecker.varAssign(key, "key", 348, 11715, 11719);
                }
                V value = CallChecker.init(null);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 349, 11753, 11757)) {
                    value = entry.getValue();
                    CallChecker.varAssign(value, "value", 349, 11753, 11757);
                }
                if (first) {
                    first = false;
                    CallChecker.varAssign(first, "first", 351, 11812, 11825);
                }else {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 353, 11864, 11866)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 353, 11864, 11866);
                        CallChecker.isCalled(buf, StringBuilder.class, 353, 11864, 11866).append(", ");
                    }
                }
                if (key == (this)) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 355, 11908, 11910)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 355, 11908, 11910);
                        CallChecker.isCalled(buf, StringBuilder.class, 355, 11908, 11910).append("(this Map)");
                    }
                }else {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 355, 11908, 11910)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 355, 11908, 11910);
                        CallChecker.isCalled(buf, StringBuilder.class, 355, 11908, 11910).append(key);
                    }
                }
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 356, 11966, 11968)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 356, 11966, 11968);
                    CallChecker.isCalled(buf, StringBuilder.class, 356, 11966, 11968).append('=');
                }
                if (value == (this)) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 357, 11995, 11997)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 357, 11995, 11997);
                        CallChecker.isCalled(buf, StringBuilder.class, 357, 11995, 11997).append("(this Map)");
                    }
                }else {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 357, 11995, 11997)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 357, 11995, 11997);
                        CallChecker.isCalled(buf, StringBuilder.class, 357, 11995, 11997).append(value);
                    }
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 359, 12063, 12065)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 359, 12063, 12065);
                CallChecker.isCalled(buf, StringBuilder.class, 359, 12063, 12065).append('}');
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 360, 12095, 12097)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 360, 12095, 12097);
                return CallChecker.isCalled(buf, StringBuilder.class, 360, 12095, 12097).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2159.methodEnd();
        }
    }

    public K get(int index) {
        if (CallChecker.beforeDeref(insertOrder, List.class, 372, 12463, 12473)) {
            return insertOrder.get(index);
        }else
            throw new AbnormalExecutionError();
        
    }

    public V getValue(int index) {
        if (CallChecker.beforeDeref(insertOrder, List.class, 383, 12776, 12786)) {
            return get(insertOrder.get(index));
        }else
            throw new AbnormalExecutionError();
        
    }

    public int indexOf(Object key) {
        MethodContext _bcornu_methode_context2162 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 392, 12816, 13055);
            CallChecker.varInit(key, "key", 392, 12816, 13055);
            CallChecker.varInit(this.map, "map", 392, 12816, 13055);
            CallChecker.varInit(this.insertOrder, "insertOrder", 392, 12816, 13055);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 392, 12816, 13055);
            if (CallChecker.beforeDeref(insertOrder, List.class, 393, 13025, 13035)) {
                return CallChecker.isCalled(insertOrder, List.class, 393, 13025, 13035).indexOf(key);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2162.methodEnd();
        }
    }

    public V setValue(int index, V value) {
        K key = CallChecker.init(null);
        if (CallChecker.beforeDeref(insertOrder, List.class, 405, 13389, 13399)) {
            key = insertOrder.get(index);
            CallChecker.varAssign(key, "key", 405, 13389, 13399);
        }
        return put(key, value);
    }

    public V put(int index, K key, V value) {
        Map<K, V> m = CallChecker.varInit(decorated(), "m", 429, 14382, 14407);
        if (CallChecker.beforeDeref(m, Map.class, 430, 14421, 14421)) {
            m = CallChecker.beforeCalled(m, Map.class, 430, 14421, 14421);
            if (CallChecker.isCalled(m, Map.class, 430, 14421, 14421).containsKey(key)) {
                V result = CallChecker.init(null);
                if (CallChecker.beforeDeref(m, Map.class, 431, 14466, 14466)) {
                    result = m.remove(key);
                    CallChecker.varAssign(result, "result", 431, 14466, 14466);
                }
                int pos = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(insertOrder, List.class, 432, 14503, 14513)) {
                    pos = CallChecker.isCalled(insertOrder, List.class, 432, 14503, 14513).indexOf(key);
                    CallChecker.varAssign(pos, "pos", 432, 14503, 14513);
                }
                if (CallChecker.beforeDeref(insertOrder, List.class, 433, 14541, 14551)) {
                    insertOrder.remove(pos);
                }
                if (pos < index) {
                    index--;
                }
                if (CallChecker.beforeDeref(insertOrder, List.class, 437, 14648, 14658)) {
                    CallChecker.isCalled(insertOrder, List.class, 437, 14648, 14658).add(index, key);
                }
                if (CallChecker.beforeDeref(m, Map.class, 438, 14689, 14689)) {
                    m.put(key, value);
                }
                return result;
            }else {
                if (CallChecker.beforeDeref(insertOrder, List.class, 441, 14764, 14774)) {
                    CallChecker.isCalled(insertOrder, List.class, 441, 14764, 14774).add(index, key);
                }
                if (CallChecker.beforeDeref(m, Map.class, 442, 14805, 14805)) {
                    m.put(key, value);
                }
                return null;
            }
        }else
            throw new AbnormalExecutionError();
        
    }

    public V remove(int index) {
        return remove(get(index));
    }

    public List<K> asList() {
        MethodContext _bcornu_methode_context2166 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 475, 15210, 16051);
            CallChecker.varInit(this.map, "map", 475, 15210, 16051);
            CallChecker.varInit(this.insertOrder, "insertOrder", 475, 15210, 16051);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ListOrderedMap.serialVersionUID", 475, 15210, 16051);
            return keyList();
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2166.methodEnd();
        }
    }

    static class ValuesView<V> extends AbstractList<V> {
        private final ListOrderedMap<Object, V> parent;

        @SuppressWarnings(value = "unchecked")
        ValuesView(ListOrderedMap<?, V> parent) {
            super();
            MethodContext _bcornu_methode_context410 = new MethodContext(null);
            try {
                this.parent = ((ListOrderedMap<Object, V>) (parent));
                CallChecker.varAssign(this.parent, "this.parent", 486, 16368, 16416);
            } finally {
                _bcornu_methode_context410.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context2167 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 490, 16437, 16522);
                CallChecker.varInit(this.parent, "parent", 490, 16437, 16522);
                if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 491, 16494, 16504)) {
                    return CallChecker.isCalled(this.parent, ListOrderedMap.class, 491, 16494, 16504).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2167.methodEnd();
            }
        }

        @Override
        public boolean contains(Object value) {
            MethodContext _bcornu_methode_context2168 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 495, 16533, 16652);
                CallChecker.varInit(value, "value", 495, 16533, 16652);
                CallChecker.varInit(this.parent, "parent", 495, 16533, 16652);
                if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 496, 16610, 16620)) {
                    return CallChecker.isCalled(this.parent, ListOrderedMap.class, 496, 16610, 16620).containsValue(value);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2168.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context2169 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 500, 16663, 16744);
                CallChecker.varInit(this.parent, "parent", 500, 16663, 16744);
                if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 501, 16715, 16725)) {
                    CallChecker.isCalled(this.parent, ListOrderedMap.class, 501, 16715, 16725).clear();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2169.methodEnd();
            }
        }

        @Override
        public Iterator<V> iterator() {
            MethodContext _bcornu_methode_context2171 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 505, 16755, 17053);
                CallChecker.varInit(this.parent, "parent", 505, 16755, 17053);
                if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 506, 16886, 16891)) {
                    final Set<Map.Entry<Object, V>> npe_invocation_var409 = CallChecker.isCalled(parent, ListOrderedMap.class, 506, 16886, 16891).entrySet();
                    if (CallChecker.beforeDeref(npe_invocation_var409, Set.class, 506, 16886, 16902)) {
                        return new AbstractUntypedIteratorDecorator<Map.Entry<Object, V>, V>(CallChecker.isCalled(npe_invocation_var409, Set.class, 506, 16886, 16902).iterator()) {
                            public V next() {
                                final Iterator<Map.Entry<Object, V>> npe_invocation_var410 = getIterator();
                                if (CallChecker.beforeDeref(npe_invocation_var410, Iterator.class, 508, 16979, 16991)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var410, Iterator.class, 508, 16979, 16991).next(), Map.Entry.class, 508, 16979, 16998)) {
                                        return CallChecker.isCalled(npe_invocation_var410, Iterator.class, 508, 16979, 16991).next().getValue();
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        };
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2171.methodEnd();
            }
        }

        @Override
        public V get(int index) {
            if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 515, 17127, 17137)) {
                return this.parent.getValue(index);
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        public V set(int index, V value) {
            if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 520, 17247, 17257)) {
                return this.parent.setValue(index, value);
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        public V remove(int index) {
            if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 525, 17368, 17378)) {
                return this.parent.remove(index);
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    static class KeySetView<K> extends AbstractSet<K> {
        private final ListOrderedMap<K, Object> parent;

        @SuppressWarnings(value = "unchecked")
        KeySetView(ListOrderedMap<K, ?> parent) {
            super();
            MethodContext _bcornu_methode_context411 = new MethodContext(null);
            try {
                this.parent = ((ListOrderedMap<K, Object>) (parent));
                CallChecker.varAssign(this.parent, "this.parent", 536, 17725, 17773);
            } finally {
                _bcornu_methode_context411.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context2175 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 540, 17794, 17879);
                CallChecker.varInit(this.parent, "parent", 540, 17794, 17879);
                if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 541, 17851, 17861)) {
                    return CallChecker.isCalled(this.parent, ListOrderedMap.class, 541, 17851, 17861).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2175.methodEnd();
            }
        }

        @Override
        public boolean contains(Object value) {
            MethodContext _bcornu_methode_context2176 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 545, 17890, 18007);
                CallChecker.varInit(value, "value", 545, 17890, 18007);
                CallChecker.varInit(this.parent, "parent", 545, 17890, 18007);
                if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 546, 17967, 17977)) {
                    return CallChecker.isCalled(this.parent, ListOrderedMap.class, 546, 17967, 17977).containsKey(value);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2176.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context2177 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 550, 18018, 18099);
                CallChecker.varInit(this.parent, "parent", 550, 18018, 18099);
                if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 551, 18070, 18080)) {
                    CallChecker.isCalled(this.parent, ListOrderedMap.class, 551, 18070, 18080).clear();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2177.methodEnd();
            }
        }

        @Override
        public Iterator<K> iterator() {
            MethodContext _bcornu_methode_context2179 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 555, 18110, 18406);
                CallChecker.varInit(this.parent, "parent", 555, 18110, 18406);
                if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 556, 18241, 18246)) {
                    final Set<Map.Entry<K, Object>> npe_invocation_var411 = CallChecker.isCalled(parent, ListOrderedMap.class, 556, 18241, 18246).entrySet();
                    if (CallChecker.beforeDeref(npe_invocation_var411, Set.class, 556, 18241, 18257)) {
                        return new AbstractUntypedIteratorDecorator<Map.Entry<K, Object>, K>(CallChecker.isCalled(npe_invocation_var411, Set.class, 556, 18241, 18257).iterator()) {
                            public K next() {
                                final Iterator<Map.Entry<K, Object>> npe_invocation_var412 = getIterator();
                                if (CallChecker.beforeDeref(npe_invocation_var412, Iterator.class, 558, 18334, 18346)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var412, Iterator.class, 558, 18334, 18346).next(), Map.Entry.class, 558, 18334, 18353)) {
                                        return CallChecker.isCalled(npe_invocation_var412, Iterator.class, 558, 18334, 18346).next().getKey();
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        };
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2179.methodEnd();
            }
        }
    }

    static class EntrySetView<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private final ListOrderedMap<K, V> parent;

        private final List<K> insertOrder;

        private Set<Map.Entry<K, V>> entrySet;

        public EntrySetView(ListOrderedMap<K, V> parent, List<K> insertOrder) {
            super();
            MethodContext _bcornu_methode_context412 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 572, 18827, 18847);
                this.insertOrder = insertOrder;
                CallChecker.varAssign(this.insertOrder, "this.insertOrder", 573, 18861, 18891);
            } finally {
                _bcornu_methode_context412.methodEnd();
            }
        }

        private Set<Map.Entry<K, V>> getEntrySet() {
            MethodContext _bcornu_methode_context2180 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 576, 18912, 19102);
                CallChecker.varInit(this.entrySet, "entrySet", 576, 18912, 19102);
                CallChecker.varInit(this.insertOrder, "insertOrder", 576, 18912, 19102);
                CallChecker.varInit(this.parent, "parent", 576, 18912, 19102);
                if ((entrySet) == null) {
                    if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 578, 19020, 19025)) {
                        final Map<K, V> npe_invocation_var413 = CallChecker.isCalled(parent, ListOrderedMap.class, 578, 19020, 19025).decorated();
                        if (CallChecker.beforeDeref(npe_invocation_var413, Map.class, 578, 19020, 19037)) {
                            entrySet = CallChecker.isCalled(npe_invocation_var413, Map.class, 578, 19020, 19037).entrySet();
                            CallChecker.varAssign(this.entrySet, "this.entrySet", 578, 19009, 19049);
                        }
                    }
                }
                return entrySet;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2180.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context2181 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 584, 19121, 19206);
                CallChecker.varInit(this.entrySet, "entrySet", 584, 19121, 19206);
                CallChecker.varInit(this.insertOrder, "insertOrder", 584, 19121, 19206);
                CallChecker.varInit(this.parent, "parent", 584, 19121, 19206);
                if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 585, 19178, 19188)) {
                    return CallChecker.isCalled(this.parent, ListOrderedMap.class, 585, 19178, 19188).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2181.methodEnd();
            }
        }

        @Override
        public boolean isEmpty() {
            MethodContext _bcornu_methode_context2182 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 588, 19216, 19311);
                CallChecker.varInit(this.entrySet, "entrySet", 588, 19216, 19311);
                CallChecker.varInit(this.insertOrder, "insertOrder", 588, 19216, 19311);
                CallChecker.varInit(this.parent, "parent", 588, 19216, 19311);
                if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 589, 19280, 19290)) {
                    return CallChecker.isCalled(this.parent, ListOrderedMap.class, 589, 19280, 19290).isEmpty();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2182.methodEnd();
            }
        }

        @Override
        public boolean contains(Object obj) {
            MethodContext _bcornu_methode_context2183 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 593, 19322, 19434);
                CallChecker.varInit(obj, "obj", 593, 19322, 19434);
                CallChecker.varInit(this.entrySet, "entrySet", 593, 19322, 19434);
                CallChecker.varInit(this.insertOrder, "insertOrder", 593, 19322, 19434);
                CallChecker.varInit(this.parent, "parent", 593, 19322, 19434);
                final Set<Map.Entry<K, V>> npe_invocation_var414 = getEntrySet();
                if (CallChecker.beforeDeref(npe_invocation_var414, Set.class, 594, 19397, 19409)) {
                    return CallChecker.isCalled(npe_invocation_var414, Set.class, 594, 19397, 19409).contains(obj);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2183.methodEnd();
            }
        }

        @Override
        public boolean containsAll(Collection<?> coll) {
            MethodContext _bcornu_methode_context2184 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 598, 19445, 19572);
                CallChecker.varInit(coll, "coll", 598, 19445, 19572);
                CallChecker.varInit(this.entrySet, "entrySet", 598, 19445, 19572);
                CallChecker.varInit(this.insertOrder, "insertOrder", 598, 19445, 19572);
                CallChecker.varInit(this.parent, "parent", 598, 19445, 19572);
                final Set<Map.Entry<K, V>> npe_invocation_var415 = getEntrySet();
                if (CallChecker.beforeDeref(npe_invocation_var415, Set.class, 599, 19531, 19543)) {
                    return CallChecker.isCalled(npe_invocation_var415, Set.class, 599, 19531, 19543).containsAll(coll);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2184.methodEnd();
            }
        }

        @Override
        @SuppressWarnings(value = "unchecked")
        public boolean remove(Object obj) {
            MethodContext _bcornu_methode_context2185 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 604, 19583, 19996);
                CallChecker.varInit(obj, "obj", 604, 19583, 19996);
                CallChecker.varInit(this.entrySet, "entrySet", 604, 19583, 19996);
                CallChecker.varInit(this.insertOrder, "insertOrder", 604, 19583, 19996);
                CallChecker.varInit(this.parent, "parent", 604, 19583, 19996);
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                final Set<Map.Entry<K, V>> npe_invocation_var416 = getEntrySet();
                if (CallChecker.beforeDeref(npe_invocation_var416, Set.class, 608, 19789, 19801)) {
                    if (CallChecker.isCalled(npe_invocation_var416, Set.class, 608, 19789, 19801).contains(obj)) {
                        Object key = CallChecker.init(Object.class);
                        if (CallChecker.beforeDeref(obj, Object.class, 609, 19868, 19870)) {
                            key = ((Map.Entry<K, V>) (obj)).getKey();
                            CallChecker.varAssign(key, "key", 609, 19868, 19870);
                        }
                        if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 610, 19899, 19904)) {
                            parent.remove(key);
                        }
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2185.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context2186 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 617, 20007, 20088);
                CallChecker.varInit(this.entrySet, "entrySet", 617, 20007, 20088);
                CallChecker.varInit(this.insertOrder, "insertOrder", 617, 20007, 20088);
                CallChecker.varInit(this.parent, "parent", 617, 20007, 20088);
                if (CallChecker.beforeDeref(this.parent, ListOrderedMap.class, 618, 20059, 20069)) {
                    CallChecker.isCalled(this.parent, ListOrderedMap.class, 618, 20059, 20069).clear();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2186.methodEnd();
            }
        }

        @Override
        public boolean equals(Object obj) {
            MethodContext _bcornu_methode_context2187 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 622, 20099, 20281);
                CallChecker.varInit(obj, "obj", 622, 20099, 20281);
                CallChecker.varInit(this.entrySet, "entrySet", 622, 20099, 20281);
                CallChecker.varInit(this.insertOrder, "insertOrder", 622, 20099, 20281);
                CallChecker.varInit(this.parent, "parent", 622, 20099, 20281);
                if (obj == (this)) {
                    return true;
                }
                final Set<Map.Entry<K, V>> npe_invocation_var417 = getEntrySet();
                if (CallChecker.beforeDeref(npe_invocation_var417, Set.class, 626, 20246, 20258)) {
                    return CallChecker.isCalled(npe_invocation_var417, Set.class, 626, 20246, 20258).equals(obj);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2187.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context2188 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 630, 20292, 20387);
                CallChecker.varInit(this.entrySet, "entrySet", 630, 20292, 20387);
                CallChecker.varInit(this.insertOrder, "insertOrder", 630, 20292, 20387);
                CallChecker.varInit(this.parent, "parent", 630, 20292, 20387);
                final Set<Map.Entry<K, V>> npe_invocation_var418 = getEntrySet();
                if (CallChecker.beforeDeref(npe_invocation_var418, Set.class, 631, 20353, 20365)) {
                    return CallChecker.isCalled(npe_invocation_var418, Set.class, 631, 20353, 20365).hashCode();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2188.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context2189 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 635, 20398, 20496);
                CallChecker.varInit(this.entrySet, "entrySet", 635, 20398, 20496);
                CallChecker.varInit(this.insertOrder, "insertOrder", 635, 20398, 20496);
                CallChecker.varInit(this.parent, "parent", 635, 20398, 20496);
                final Set<Map.Entry<K, V>> npe_invocation_var419 = getEntrySet();
                if (CallChecker.beforeDeref(npe_invocation_var419, Set.class, 636, 20462, 20474)) {
                    return CallChecker.isCalled(npe_invocation_var419, Set.class, 636, 20462, 20474).toString();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2189.methodEnd();
            }
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            MethodContext _bcornu_methode_context2190 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 640, 20507, 20650);
                CallChecker.varInit(this.entrySet, "entrySet", 640, 20507, 20650);
                CallChecker.varInit(this.insertOrder, "insertOrder", 640, 20507, 20650);
                CallChecker.varInit(this.parent, "parent", 640, 20507, 20650);
                return new ListOrderedMap.ListOrderedIterator<K, V>(parent, insertOrder);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2190.methodEnd();
            }
        }
    }

    static class ListOrderedIterator<K, V> extends AbstractUntypedIteratorDecorator<K, Map.Entry<K, V>> {
        private final ListOrderedMap<K, V> parent;

        private K last = null;

        ListOrderedIterator(ListOrderedMap<K, V> parent, List<K> insertOrder) {
            super(CallChecker.isCalled(insertOrder, List.class, 651, 21032, 21042).iterator());
            MethodContext _bcornu_methode_context413 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 652, 21069, 21089);
            } finally {
                _bcornu_methode_context413.methodEnd();
            }
        }

        public Map.Entry<K, V> next() {
            MethodContext _bcornu_methode_context2191 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 655, 21110, 21255);
                CallChecker.varInit(this.iterator, "iterator", 655, 21110, 21255);
                CallChecker.varInit(this.last, "last", 655, 21110, 21255);
                CallChecker.varInit(this.parent, "parent", 655, 21110, 21255);
                final Iterator<K> npe_invocation_var420 = getIterator();
                if (CallChecker.beforeDeref(npe_invocation_var420, Iterator.class, 656, 21161, 21173)) {
                    last = npe_invocation_var420.next();
                    CallChecker.varAssign(this.last, "this.last", 656, 21154, 21181);
                }
                return new ListOrderedMap.ListOrderedMapEntry<K, V>(parent, last);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2191.methodEnd();
            }
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context2192 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 661, 21266, 21388);
                CallChecker.varInit(this.iterator, "iterator", 661, 21266, 21388);
                CallChecker.varInit(this.last, "last", 661, 21266, 21388);
                CallChecker.varInit(this.parent, "parent", 661, 21266, 21388);
                super.remove();
                if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 663, 21347, 21352)) {
                    final Map<K, V> npe_invocation_var421 = CallChecker.isCalled(parent, ListOrderedMap.class, 663, 21347, 21352).decorated();
                    if (CallChecker.beforeDeref(npe_invocation_var421, Map.class, 663, 21347, 21364)) {
                        npe_invocation_var421.remove(last);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2192.methodEnd();
            }
        }
    }

    static class ListOrderedMapEntry<K, V> extends AbstractMapEntry<K, V> {
        private final ListOrderedMap<K, V> parent;

        ListOrderedMapEntry(ListOrderedMap<K, V> parent, K key) {
            super(key, null);
            MethodContext _bcornu_methode_context414 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 673, 21711, 21731);
            } finally {
                _bcornu_methode_context414.methodEnd();
            }
        }

        @Override
        public V getValue() {
            if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 678, 21811, 21816)) {
                return parent.get(key);
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        public V setValue(V value) {
            if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 683, 21913, 21918)) {
                final Map<K, V> npe_invocation_var422 = CallChecker.isCalled(parent, ListOrderedMap.class, 683, 21913, 21918).decorated();
                if (CallChecker.beforeDeref(npe_invocation_var422, Map.class, 683, 21913, 21930)) {
                    return npe_invocation_var422.put(key, value);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    static class ListOrderedMapIterator<K, V> implements OrderedMapIterator<K, V> , ResettableIterator<K> {
        private final ListOrderedMap<K, V> parent;

        private ListIterator<K> iterator;

        private K last = null;

        private boolean readable = false;

        ListOrderedMapIterator(ListOrderedMap<K, V> parent) {
            super();
            MethodContext _bcornu_methode_context415 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 696, 22413, 22433);
                if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 697, 22463, 22468)) {
                    parent = CallChecker.beforeCalled(parent, ListOrderedMap.class, 697, 22463, 22468);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, ListOrderedMap.class, 697, 22463, 22468).insertOrder, List.class, 697, 22463, 22480)) {
                        parent = CallChecker.beforeCalled(parent, ListOrderedMap.class, 697, 22463, 22468);
                        this.iterator = CallChecker.isCalled(CallChecker.isCalled(parent, ListOrderedMap.class, 697, 22463, 22468).insertOrder, List.class, 697, 22463, 22480).listIterator();
                        CallChecker.varAssign(this.iterator, "this.iterator", 697, 22447, 22496);
                    }
                }
            } finally {
                _bcornu_methode_context415.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context2195 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 700, 22517, 22591);
                CallChecker.varInit(this.readable, "readable", 700, 22517, 22591);
                CallChecker.varInit(this.last, "last", 700, 22517, 22591);
                CallChecker.varInit(this.iterator, "iterator", 700, 22517, 22591);
                CallChecker.varInit(this.parent, "parent", 700, 22517, 22591);
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 701, 22563, 22570)) {
                    iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 701, 22563, 22570);
                    return CallChecker.isCalled(iterator, ListIterator.class, 701, 22563, 22570).hasNext();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2195.methodEnd();
            }
        }

        public K next() {
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 705, 22639, 22646)) {
                last = iterator.next();
                CallChecker.varAssign(this.last, "this.last", 705, 22632, 22654);
            }
            readable = true;
            CallChecker.varAssign(this.readable, "this.readable", 706, 22668, 22683);
            return last;
        }

        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context2197 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 710, 22737, 22819);
                CallChecker.varInit(this.readable, "readable", 710, 22737, 22819);
                CallChecker.varInit(this.last, "last", 710, 22737, 22819);
                CallChecker.varInit(this.iterator, "iterator", 710, 22737, 22819);
                CallChecker.varInit(this.parent, "parent", 710, 22737, 22819);
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 711, 22787, 22794)) {
                    iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 711, 22787, 22794);
                    return CallChecker.isCalled(iterator, ListIterator.class, 711, 22787, 22794).hasPrevious();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2197.methodEnd();
            }
        }

        public K previous() {
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 715, 22871, 22878)) {
                last = iterator.previous();
                CallChecker.varAssign(this.last, "this.last", 715, 22864, 22890);
            }
            readable = true;
            CallChecker.varAssign(this.readable, "this.readable", 716, 22904, 22919);
            return last;
        }

        public void remove() {
            MethodContext _bcornu_methode_context2199 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 720, 22965, 23228);
                CallChecker.varInit(this.readable, "readable", 720, 22965, 23228);
                CallChecker.varInit(this.last, "last", 720, 22965, 23228);
                CallChecker.varInit(this.iterator, "iterator", 720, 22965, 23228);
                CallChecker.varInit(this.parent, "parent", 720, 22965, 23228);
                if ((readable) == false) {
                    throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
                }
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 724, 23134, 23141)) {
                    iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 724, 23134, 23141);
                    CallChecker.isCalled(iterator, ListIterator.class, 724, 23134, 23141).remove();
                }
                if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 725, 23165, 23170)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, ListOrderedMap.class, 725, 23165, 23170).map, Map.class, 725, 23165, 23174)) {
                        CallChecker.isCalled(parent, ListOrderedMap.class, 725, 23165, 23170).map.remove(last);
                    }
                }
                readable = false;
                CallChecker.varAssign(this.readable, "this.readable", 726, 23202, 23218);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2199.methodEnd();
            }
        }

        public K getKey() {
            if ((readable) == false) {
                throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
            }
            return last;
        }

        public V getValue() {
            if ((readable) == false) {
                throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
            }
            if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 740, 23614, 23619)) {
                return parent.get(last);
            }else
                throw new AbnormalExecutionError();
            
        }

        public V setValue(V value) {
            if ((readable) == false) {
                throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
            }
            if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 747, 23835, 23840)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(parent, ListOrderedMap.class, 747, 23835, 23840).map, Map.class, 747, 23835, 23844)) {
                    return CallChecker.isCalled(parent, ListOrderedMap.class, 747, 23835, 23840).map.put(last, value);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        }

        public void reset() {
            MethodContext _bcornu_methode_context2203 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 750, 23883, 24026);
                CallChecker.varInit(this.readable, "readable", 750, 23883, 24026);
                CallChecker.varInit(this.last, "last", 750, 23883, 24026);
                CallChecker.varInit(this.iterator, "iterator", 750, 23883, 24026);
                CallChecker.varInit(this.parent, "parent", 750, 23883, 24026);
                if (CallChecker.beforeDeref(parent, ListOrderedMap.class, 751, 23928, 23933)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, ListOrderedMap.class, 751, 23928, 23933).insertOrder, List.class, 751, 23928, 23945)) {
                        iterator = CallChecker.isCalled(CallChecker.isCalled(parent, ListOrderedMap.class, 751, 23928, 23933).insertOrder, List.class, 751, 23928, 23945).listIterator();
                        CallChecker.varAssign(this.iterator, "this.iterator", 751, 23917, 23961);
                    }
                }
                last = null;
                CallChecker.varAssign(this.last, "this.last", 752, 23975, 23986);
                readable = false;
                CallChecker.varAssign(this.readable, "this.readable", 753, 24000, 24016);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2203.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context2204 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 757, 24037, 24245);
                CallChecker.varInit(this.readable, "readable", 757, 24037, 24245);
                CallChecker.varInit(this.last, "last", 757, 24037, 24245);
                CallChecker.varInit(this.iterator, "iterator", 757, 24037, 24245);
                CallChecker.varInit(this.parent, "parent", 757, 24037, 24245);
                if ((readable) == true) {
                    return ((("Iterator[" + (getKey())) + "=") + (getValue())) + "]";
                }
                return "Iterator[]";
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2204.methodEnd();
            }
        }
    }
}

