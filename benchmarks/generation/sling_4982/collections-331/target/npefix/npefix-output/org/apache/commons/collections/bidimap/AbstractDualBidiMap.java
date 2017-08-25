package org.apache.commons.collections.bidimap;

import java.util.Set;
import org.apache.commons.collections.ResettableIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.MapIterator;
import java.util.Map;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections.BidiMap;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public abstract class AbstractDualBidiMap<K, V> implements BidiMap<K, V> {
    protected transient Map<K, V> normalMap;

    protected transient Map<V, K> reverseMap;

    protected transient BidiMap<V, K> inverseBidiMap = null;

    protected transient Set<K> keySet = null;

    protected transient Collection<V> values = null;

    protected transient Set<Map.Entry<K, V>> entrySet = null;

    protected AbstractDualBidiMap() {
        super();
        MethodContext _bcornu_methode_context346 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context346.methodEnd();
        }
    }

    protected AbstractDualBidiMap(Map<K, V> normalMap, Map<V, K> reverseMap) {
        super();
        MethodContext _bcornu_methode_context347 = new MethodContext(null);
        try {
            this.normalMap = normalMap;
            CallChecker.varAssign(this.normalMap, "this.normalMap", 104, 3369, 3395);
            this.reverseMap = reverseMap;
            CallChecker.varAssign(this.reverseMap, "this.reverseMap", 105, 3405, 3433);
        } finally {
            _bcornu_methode_context347.methodEnd();
        }
    }

    protected AbstractDualBidiMap(Map<K, V> normalMap, Map<V, K> reverseMap, BidiMap<V, K> inverseBidiMap) {
        super();
        MethodContext _bcornu_methode_context348 = new MethodContext(null);
        try {
            this.normalMap = normalMap;
            CallChecker.varAssign(this.normalMap, "this.normalMap", 118, 3881, 3907);
            this.reverseMap = reverseMap;
            CallChecker.varAssign(this.reverseMap, "this.reverseMap", 119, 3917, 3945);
            this.inverseBidiMap = inverseBidiMap;
            CallChecker.varAssign(this.inverseBidiMap, "this.inverseBidiMap", 120, 3955, 3991);
        } finally {
            _bcornu_methode_context348.methodEnd();
        }
    }

    protected abstract BidiMap<V, K> createBidiMap(Map<V, K> normalMap, Map<K, V> reverseMap, BidiMap<K, V> inverseMap);

    public V get(Object key) {
        if (CallChecker.beforeDeref(normalMap, Map.class, 136, 4543, 4551)) {
            return normalMap.get(key);
        }else
            throw new AbnormalExecutionError();
        
    }

    public int size() {
        MethodContext _bcornu_methode_context1776 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 139, 4574, 4631);
            CallChecker.varInit(this.entrySet, "entrySet", 139, 4574, 4631);
            CallChecker.varInit(this.values, "values", 139, 4574, 4631);
            CallChecker.varInit(this.keySet, "keySet", 139, 4574, 4631);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 139, 4574, 4631);
            CallChecker.varInit(this.reverseMap, "reverseMap", 139, 4574, 4631);
            CallChecker.varInit(this.normalMap, "normalMap", 139, 4574, 4631);
            if (CallChecker.beforeDeref(normalMap, Map.class, 140, 4609, 4617)) {
                normalMap = CallChecker.beforeCalled(normalMap, Map.class, 140, 4609, 4617);
                return CallChecker.isCalled(normalMap, Map.class, 140, 4609, 4617).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1776.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1777 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 143, 4638, 4705);
            CallChecker.varInit(this.entrySet, "entrySet", 143, 4638, 4705);
            CallChecker.varInit(this.values, "values", 143, 4638, 4705);
            CallChecker.varInit(this.keySet, "keySet", 143, 4638, 4705);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 143, 4638, 4705);
            CallChecker.varInit(this.reverseMap, "reverseMap", 143, 4638, 4705);
            CallChecker.varInit(this.normalMap, "normalMap", 143, 4638, 4705);
            if (CallChecker.beforeDeref(normalMap, Map.class, 144, 4680, 4688)) {
                normalMap = CallChecker.beforeCalled(normalMap, Map.class, 144, 4680, 4688);
                return CallChecker.isCalled(normalMap, Map.class, 144, 4680, 4688).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1777.methodEnd();
        }
    }

    public boolean containsKey(Object key) {
        MethodContext _bcornu_methode_context1778 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 147, 4712, 4800);
            CallChecker.varInit(key, "key", 147, 4712, 4800);
            CallChecker.varInit(this.entrySet, "entrySet", 147, 4712, 4800);
            CallChecker.varInit(this.values, "values", 147, 4712, 4800);
            CallChecker.varInit(this.keySet, "keySet", 147, 4712, 4800);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 147, 4712, 4800);
            CallChecker.varInit(this.reverseMap, "reverseMap", 147, 4712, 4800);
            CallChecker.varInit(this.normalMap, "normalMap", 147, 4712, 4800);
            if (CallChecker.beforeDeref(normalMap, Map.class, 148, 4768, 4776)) {
                normalMap = CallChecker.beforeCalled(normalMap, Map.class, 148, 4768, 4776);
                return CallChecker.isCalled(normalMap, Map.class, 148, 4768, 4776).containsKey(key);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1778.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1779 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 152, 4807, 4899);
            CallChecker.varInit(obj, "obj", 152, 4807, 4899);
            CallChecker.varInit(this.entrySet, "entrySet", 152, 4807, 4899);
            CallChecker.varInit(this.values, "values", 152, 4807, 4899);
            CallChecker.varInit(this.keySet, "keySet", 152, 4807, 4899);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 152, 4807, 4899);
            CallChecker.varInit(this.reverseMap, "reverseMap", 152, 4807, 4899);
            CallChecker.varInit(this.normalMap, "normalMap", 152, 4807, 4899);
            if (CallChecker.beforeDeref(normalMap, Map.class, 153, 4872, 4880)) {
                normalMap = CallChecker.beforeCalled(normalMap, Map.class, 153, 4872, 4880);
                return CallChecker.isCalled(normalMap, Map.class, 153, 4872, 4880).equals(obj);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1779.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1780 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 157, 4906, 4985);
            CallChecker.varInit(this.entrySet, "entrySet", 157, 4906, 4985);
            CallChecker.varInit(this.values, "values", 157, 4906, 4985);
            CallChecker.varInit(this.keySet, "keySet", 157, 4906, 4985);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 157, 4906, 4985);
            CallChecker.varInit(this.reverseMap, "reverseMap", 157, 4906, 4985);
            CallChecker.varInit(this.normalMap, "normalMap", 157, 4906, 4985);
            if (CallChecker.beforeDeref(normalMap, Map.class, 158, 4959, 4967)) {
                normalMap = CallChecker.beforeCalled(normalMap, Map.class, 158, 4959, 4967);
                return CallChecker.isCalled(normalMap, Map.class, 158, 4959, 4967).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1780.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1781 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 162, 4992, 5074);
            CallChecker.varInit(this.entrySet, "entrySet", 162, 4992, 5074);
            CallChecker.varInit(this.values, "values", 162, 4992, 5074);
            CallChecker.varInit(this.keySet, "keySet", 162, 4992, 5074);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 162, 4992, 5074);
            CallChecker.varInit(this.reverseMap, "reverseMap", 162, 4992, 5074);
            CallChecker.varInit(this.normalMap, "normalMap", 162, 4992, 5074);
            if (CallChecker.beforeDeref(normalMap, Map.class, 163, 5048, 5056)) {
                normalMap = CallChecker.beforeCalled(normalMap, Map.class, 163, 5048, 5056);
                return CallChecker.isCalled(normalMap, Map.class, 163, 5048, 5056).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1781.methodEnd();
        }
    }

    public V put(K key, V value) {
        if (CallChecker.beforeDeref(normalMap, Map.class, 169, 5225, 5233)) {
            normalMap = CallChecker.beforeCalled(normalMap, Map.class, 169, 5225, 5233);
            if (CallChecker.isCalled(normalMap, Map.class, 169, 5225, 5233).containsKey(key)) {
                if (CallChecker.beforeDeref(normalMap, Map.class, 170, 5285, 5293)) {
                    if (CallChecker.beforeDeref(reverseMap, Map.class, 170, 5267, 5276)) {
                        reverseMap.remove(normalMap.get(key));
                    }
                }
            }
        }
        if (CallChecker.beforeDeref(reverseMap, Map.class, 172, 5328, 5337)) {
            reverseMap = CallChecker.beforeCalled(reverseMap, Map.class, 172, 5328, 5337);
            if (CallChecker.isCalled(reverseMap, Map.class, 172, 5328, 5337).containsKey(value)) {
                if (CallChecker.beforeDeref(reverseMap, Map.class, 173, 5390, 5399)) {
                    if (CallChecker.beforeDeref(normalMap, Map.class, 173, 5373, 5381)) {
                        normalMap.remove(reverseMap.get(value));
                    }
                }
            }
        }
        final V obj = CallChecker.varInit(normalMap.put(key, value), "obj", 175, 5432, 5471);
        if (CallChecker.beforeDeref(reverseMap, Map.class, 176, 5481, 5490)) {
            reverseMap.put(value, key);
        }
        return obj;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context1783 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 180, 5540, 5736);
            CallChecker.varInit(map, "map", 180, 5540, 5736);
            CallChecker.varInit(this.entrySet, "entrySet", 180, 5540, 5736);
            CallChecker.varInit(this.values, "values", 180, 5540, 5736);
            CallChecker.varInit(this.keySet, "keySet", 180, 5540, 5736);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 180, 5540, 5736);
            CallChecker.varInit(this.reverseMap, "reverseMap", 180, 5540, 5736);
            CallChecker.varInit(this.normalMap, "normalMap", 180, 5540, 5736);
            map = CallChecker.beforeCalled(map, Map.class, 181, 5653, 5655);
            for (Map.Entry<? extends K, ? extends V> entry : CallChecker.isCalled(map, Map.class, 181, 5653, 5655).entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 182, 5687, 5691)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 182, 5703, 5707)) {
                        put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1783.methodEnd();
        }
    }

    public V remove(Object key) {
        V value = CallChecker.varInit(null, "value", 187, 5781, 5795);
        if (CallChecker.beforeDeref(normalMap, Map.class, 188, 5809, 5817)) {
            normalMap = CallChecker.beforeCalled(normalMap, Map.class, 188, 5809, 5817);
            if (CallChecker.isCalled(normalMap, Map.class, 188, 5809, 5817).containsKey(key)) {
                if (CallChecker.beforeDeref(normalMap, Map.class, 189, 5859, 5867)) {
                    value = normalMap.remove(key);
                    CallChecker.varAssign(value, "value", 189, 5851, 5880);
                }
                if (CallChecker.beforeDeref(reverseMap, Map.class, 190, 5894, 5903)) {
                    reverseMap.remove(value);
                }
            }
        }
        return value;
    }

    public void clear() {
        MethodContext _bcornu_methode_context1785 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 195, 5963, 6044);
            CallChecker.varInit(this.entrySet, "entrySet", 195, 5963, 6044);
            CallChecker.varInit(this.values, "values", 195, 5963, 6044);
            CallChecker.varInit(this.keySet, "keySet", 195, 5963, 6044);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 195, 5963, 6044);
            CallChecker.varInit(this.reverseMap, "reverseMap", 195, 5963, 6044);
            CallChecker.varInit(this.normalMap, "normalMap", 195, 5963, 6044);
            if (CallChecker.beforeDeref(normalMap, Map.class, 196, 5993, 6001)) {
                normalMap = CallChecker.beforeCalled(normalMap, Map.class, 196, 5993, 6001);
                CallChecker.isCalled(normalMap, Map.class, 196, 5993, 6001).clear();
            }
            if (CallChecker.beforeDeref(reverseMap, Map.class, 197, 6020, 6029)) {
                reverseMap = CallChecker.beforeCalled(reverseMap, Map.class, 197, 6020, 6029);
                CallChecker.isCalled(reverseMap, Map.class, 197, 6020, 6029).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1785.methodEnd();
        }
    }

    public boolean containsValue(Object value) {
        MethodContext _bcornu_methode_context1786 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 200, 6051, 6146);
            CallChecker.varInit(value, "value", 200, 6051, 6146);
            CallChecker.varInit(this.entrySet, "entrySet", 200, 6051, 6146);
            CallChecker.varInit(this.values, "values", 200, 6051, 6146);
            CallChecker.varInit(this.keySet, "keySet", 200, 6051, 6146);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 200, 6051, 6146);
            CallChecker.varInit(this.reverseMap, "reverseMap", 200, 6051, 6146);
            CallChecker.varInit(this.normalMap, "normalMap", 200, 6051, 6146);
            if (CallChecker.beforeDeref(reverseMap, Map.class, 201, 6111, 6120)) {
                reverseMap = CallChecker.beforeCalled(reverseMap, Map.class, 201, 6111, 6120);
                return CallChecker.isCalled(reverseMap, Map.class, 201, 6111, 6120).containsKey(value);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1786.methodEnd();
        }
    }

    public MapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context1787 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 217, 6153, 6796);
            CallChecker.varInit(this.entrySet, "entrySet", 217, 6153, 6796);
            CallChecker.varInit(this.values, "values", 217, 6153, 6796);
            CallChecker.varInit(this.keySet, "keySet", 217, 6153, 6796);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 217, 6153, 6796);
            CallChecker.varInit(this.reverseMap, "reverseMap", 217, 6153, 6796);
            CallChecker.varInit(this.normalMap, "normalMap", 217, 6153, 6796);
            return new AbstractDualBidiMap.BidiMapIterator<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1787.methodEnd();
        }
    }

    public K getKey(Object value) {
        if (CallChecker.beforeDeref(reverseMap, Map.class, 222, 6850, 6859)) {
            return reverseMap.get(value);
        }else
            throw new AbnormalExecutionError();
        
    }

    public K removeValue(Object value) {
        K key = CallChecker.varInit(null, "key", 226, 6929, 6941);
        if (CallChecker.beforeDeref(reverseMap, Map.class, 227, 6955, 6964)) {
            reverseMap = CallChecker.beforeCalled(reverseMap, Map.class, 227, 6955, 6964);
            if (CallChecker.isCalled(reverseMap, Map.class, 227, 6955, 6964).containsKey(value)) {
                if (CallChecker.beforeDeref(reverseMap, Map.class, 228, 7006, 7015)) {
                    key = reverseMap.remove(value);
                    CallChecker.varAssign(key, "key", 228, 7000, 7030);
                }
                if (CallChecker.beforeDeref(normalMap, Map.class, 229, 7044, 7052)) {
                    normalMap.remove(key);
                }
            }
        }
        return key;
    }

    public BidiMap<V, K> inverseBidiMap() {
        MethodContext _bcornu_methode_context1790 = new MethodContext(BidiMap.class);
        try {
            CallChecker.varInit(this, "this", 234, 7108, 7304);
            CallChecker.varInit(this.entrySet, "entrySet", 234, 7108, 7304);
            CallChecker.varInit(this.values, "values", 234, 7108, 7304);
            CallChecker.varInit(this.keySet, "keySet", 234, 7108, 7304);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 234, 7108, 7304);
            CallChecker.varInit(this.reverseMap, "reverseMap", 234, 7108, 7304);
            CallChecker.varInit(this.normalMap, "normalMap", 234, 7108, 7304);
            if ((inverseBidiMap) == null) {
                inverseBidiMap = createBidiMap(reverseMap, normalMap, this);
                CallChecker.varAssign(this.inverseBidiMap, "this.inverseBidiMap", 236, 7198, 7257);
            }
            return inverseBidiMap;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1790.methodEnd();
        }
    }

    public Set<K> keySet() {
        MethodContext _bcornu_methode_context1791 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 250, 7311, 7744);
            CallChecker.varInit(this.entrySet, "entrySet", 250, 7311, 7744);
            CallChecker.varInit(this.values, "values", 250, 7311, 7744);
            CallChecker.varInit(this.keySet, "keySet", 250, 7311, 7744);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 250, 7311, 7744);
            CallChecker.varInit(this.reverseMap, "reverseMap", 250, 7311, 7744);
            CallChecker.varInit(this.normalMap, "normalMap", 250, 7311, 7744);
            if ((keySet) == null) {
                keySet = new AbstractDualBidiMap.KeySet<K>(this);
                CallChecker.varAssign(this.keySet, "this.keySet", 252, 7677, 7705);
            }
            return keySet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1791.methodEnd();
        }
    }

    protected Iterator<K> createKeySetIterator(Iterator<K> iterator) {
        MethodContext _bcornu_methode_context1792 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 264, 7751, 8101);
            CallChecker.varInit(iterator, "iterator", 264, 7751, 8101);
            CallChecker.varInit(this.entrySet, "entrySet", 264, 7751, 8101);
            CallChecker.varInit(this.values, "values", 264, 7751, 8101);
            CallChecker.varInit(this.keySet, "keySet", 264, 7751, 8101);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 264, 7751, 8101);
            CallChecker.varInit(this.reverseMap, "reverseMap", 264, 7751, 8101);
            CallChecker.varInit(this.normalMap, "normalMap", 264, 7751, 8101);
            return new AbstractDualBidiMap.KeySetIterator<K>(iterator, this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1792.methodEnd();
        }
    }

    public Collection<V> values() {
        MethodContext _bcornu_methode_context1793 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 275, 8108, 8453);
            CallChecker.varInit(this.entrySet, "entrySet", 275, 8108, 8453);
            CallChecker.varInit(this.values, "values", 275, 8108, 8453);
            CallChecker.varInit(this.keySet, "keySet", 275, 8108, 8453);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 275, 8108, 8453);
            CallChecker.varInit(this.reverseMap, "reverseMap", 275, 8108, 8453);
            CallChecker.varInit(this.normalMap, "normalMap", 275, 8108, 8453);
            if ((values) == null) {
                values = new AbstractDualBidiMap.Values<V>(this);
                CallChecker.varAssign(this.values, "this.values", 277, 8386, 8414);
            }
            return values;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1793.methodEnd();
        }
    }

    protected Iterator<V> createValuesIterator(Iterator<V> iterator) {
        MethodContext _bcornu_methode_context1794 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 289, 8460, 8809);
            CallChecker.varInit(iterator, "iterator", 289, 8460, 8809);
            CallChecker.varInit(this.entrySet, "entrySet", 289, 8460, 8809);
            CallChecker.varInit(this.values, "values", 289, 8460, 8809);
            CallChecker.varInit(this.keySet, "keySet", 289, 8460, 8809);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 289, 8460, 8809);
            CallChecker.varInit(this.reverseMap, "reverseMap", 289, 8460, 8809);
            CallChecker.varInit(this.normalMap, "normalMap", 289, 8460, 8809);
            return new AbstractDualBidiMap.ValuesIterator<V>(iterator, this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1794.methodEnd();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context1795 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 304, 8816, 9416);
            CallChecker.varInit(this.entrySet, "entrySet", 304, 8816, 9416);
            CallChecker.varInit(this.values, "values", 304, 8816, 9416);
            CallChecker.varInit(this.keySet, "keySet", 304, 8816, 9416);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 304, 8816, 9416);
            CallChecker.varInit(this.reverseMap, "reverseMap", 304, 8816, 9416);
            CallChecker.varInit(this.normalMap, "normalMap", 304, 8816, 9416);
            if ((entrySet) == null) {
                entrySet = new AbstractDualBidiMap.EntrySet<K, V>(this);
                CallChecker.varAssign(this.entrySet, "this.entrySet", 306, 9340, 9375);
            }
            return entrySet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1795.methodEnd();
        }
    }

    protected Iterator<Map.Entry<K, V>> createEntrySetIterator(Iterator<Map.Entry<K, V>> iterator) {
        MethodContext _bcornu_methode_context1796 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 318, 9423, 9813);
            CallChecker.varInit(iterator, "iterator", 318, 9423, 9813);
            CallChecker.varInit(this.entrySet, "entrySet", 318, 9423, 9813);
            CallChecker.varInit(this.values, "values", 318, 9423, 9813);
            CallChecker.varInit(this.keySet, "keySet", 318, 9423, 9813);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 318, 9423, 9813);
            CallChecker.varInit(this.reverseMap, "reverseMap", 318, 9423, 9813);
            CallChecker.varInit(this.normalMap, "normalMap", 318, 9423, 9813);
            return new AbstractDualBidiMap.EntrySetIterator<K, V>(iterator, this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1796.methodEnd();
        }
    }

    @SuppressWarnings(value = "serial")
    protected abstract static class View<K, V, E> extends AbstractCollectionDecorator<E> {
        protected final AbstractDualBidiMap<K, V> parent;

        protected View(Collection<E> coll, AbstractDualBidiMap<K, V> parent) {
            super(coll);
            MethodContext _bcornu_methode_context349 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 340, 10453, 10473);
            } finally {
                _bcornu_methode_context349.methodEnd();
            }
        }

        @Override
        public boolean removeAll(Collection<?> coll) {
            MethodContext _bcornu_methode_context1797 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 344, 10494, 10958);
                CallChecker.varInit(coll, "coll", 344, 10494, 10958);
                CallChecker.varInit(this.collection, "collection", 344, 10494, 10958);
                CallChecker.varInit(this.parent, "parent", 344, 10494, 10958);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 345, 10575, 10580)) {
                    if (CallChecker.beforeDeref(coll, Collection.class, 345, 10595, 10598)) {
                        coll = CallChecker.beforeCalled(coll, Collection.class, 345, 10595, 10598);
                        if ((CallChecker.isCalled(parent, AbstractDualBidiMap.class, 345, 10575, 10580).isEmpty()) || (CallChecker.isCalled(coll, Collection.class, 345, 10595, 10598).isEmpty())) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                boolean modified = CallChecker.varInit(((boolean) (false)), "modified", 348, 10669, 10693);
                Iterator<E> it = CallChecker.varInit(iterator(), "it", 349, 10707, 10734);
                it = CallChecker.beforeCalled(it, Iterator.class, 350, 10755, 10756);
                while (CallChecker.isCalled(it, Iterator.class, 350, 10755, 10756).hasNext()) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 351, 10805, 10806)) {
                        if (CallChecker.beforeDeref(coll, Collection.class, 351, 10791, 10794)) {
                            coll = CallChecker.beforeCalled(coll, Collection.class, 351, 10791, 10794);
                            if (CallChecker.isCalled(coll, Collection.class, 351, 10791, 10794).contains(it.next())) {
                                if (CallChecker.beforeDeref(it, Iterator.class, 352, 10839, 10840)) {
                                    it = CallChecker.beforeCalled(it, Iterator.class, 352, 10839, 10840);
                                    CallChecker.isCalled(it, Iterator.class, 352, 10839, 10840).remove();
                                }
                                modified = true;
                                CallChecker.varAssign(modified, "modified", 353, 10872, 10887);
                            }
                        }
                    }
                } 
                return modified;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1797.methodEnd();
            }
        }

        @Override
        public boolean retainAll(Collection<?> coll) {
            MethodContext _bcornu_methode_context1798 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 360, 10969, 11533);
                CallChecker.varInit(coll, "coll", 360, 10969, 11533);
                CallChecker.varInit(this.collection, "collection", 360, 10969, 11533);
                CallChecker.varInit(this.parent, "parent", 360, 10969, 11533);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 361, 11050, 11055)) {
                    if (CallChecker.isCalled(parent, AbstractDualBidiMap.class, 361, 11050, 11055).isEmpty()) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(coll, Collection.class, 364, 11130, 11133)) {
                    coll = CallChecker.beforeCalled(coll, Collection.class, 364, 11130, 11133);
                    if (CallChecker.isCalled(coll, Collection.class, 364, 11130, 11133).isEmpty()) {
                        if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 365, 11164, 11169)) {
                            CallChecker.isCalled(parent, AbstractDualBidiMap.class, 365, 11164, 11169).clear();
                        }
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                boolean modified = CallChecker.varInit(((boolean) (false)), "modified", 368, 11235, 11259);
                Iterator<E> it = CallChecker.varInit(iterator(), "it", 369, 11273, 11300);
                it = CallChecker.beforeCalled(it, Iterator.class, 370, 11321, 11322);
                while (CallChecker.isCalled(it, Iterator.class, 370, 11321, 11322).hasNext()) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 371, 11371, 11372)) {
                        if (CallChecker.beforeDeref(coll, Collection.class, 371, 11357, 11360)) {
                            coll = CallChecker.beforeCalled(coll, Collection.class, 371, 11357, 11360);
                            if ((CallChecker.isCalled(coll, Collection.class, 371, 11357, 11360).contains(it.next())) == false) {
                                if (CallChecker.beforeDeref(it, Iterator.class, 372, 11414, 11415)) {
                                    it = CallChecker.beforeCalled(it, Iterator.class, 372, 11414, 11415);
                                    CallChecker.isCalled(it, Iterator.class, 372, 11414, 11415).remove();
                                }
                                modified = true;
                                CallChecker.varAssign(modified, "modified", 373, 11447, 11462);
                            }
                        }
                    }
                } 
                return modified;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1798.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context1799 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 380, 11544, 11620);
                CallChecker.varInit(this.collection, "collection", 380, 11544, 11620);
                CallChecker.varInit(this.parent, "parent", 380, 11544, 11620);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 381, 11596, 11601)) {
                    CallChecker.isCalled(parent, AbstractDualBidiMap.class, 381, 11596, 11601).clear();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1799.methodEnd();
            }
        }
    }

    protected static class KeySet<K> extends AbstractDualBidiMap.View<K, Object, K> implements Set<K> {
        private static final long serialVersionUID = -7107935777385040694L;

        @SuppressWarnings(value = "unchecked")
        protected KeySet(AbstractDualBidiMap<K, ?> parent) {
            super(CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 401, 12196, 12201).normalMap, Map.class, 401, 12196, 12211).keySet(), ((AbstractDualBidiMap<K, Object>) (parent)));
            MethodContext _bcornu_methode_context350 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context350.methodEnd();
            }
        }

        @Override
        public Iterator<K> iterator() {
            MethodContext _bcornu_methode_context1800 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 405, 12284, 12408);
                CallChecker.varInit(this.collection, "collection", 405, 12284, 12408);
                CallChecker.varInit(this.parent, "parent", 405, 12284, 12408);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.AbstractDualBidiMap.KeySet.serialVersionUID", 405, 12284, 12408);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 406, 12353, 12358)) {
                    return CallChecker.isCalled(parent, AbstractDualBidiMap.class, 406, 12353, 12358).createKeySetIterator(super.iterator());
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1800.methodEnd();
            }
        }

        @Override
        public boolean contains(Object key) {
            MethodContext _bcornu_methode_context1801 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 410, 12419, 12537);
                CallChecker.varInit(key, "key", 410, 12419, 12537);
                CallChecker.varInit(this.collection, "collection", 410, 12419, 12537);
                CallChecker.varInit(this.parent, "parent", 410, 12419, 12537);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.AbstractDualBidiMap.KeySet.serialVersionUID", 410, 12419, 12537);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 411, 12494, 12499)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 411, 12494, 12499).normalMap, Map.class, 411, 12494, 12509)) {
                        return CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 411, 12494, 12499).normalMap, Map.class, 411, 12494, 12509).containsKey(key);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1801.methodEnd();
            }
        }

        @Override
        public boolean remove(Object key) {
            MethodContext _bcornu_methode_context1802 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 415, 12548, 12842);
                CallChecker.varInit(key, "key", 415, 12548, 12842);
                CallChecker.varInit(this.collection, "collection", 415, 12548, 12842);
                CallChecker.varInit(this.parent, "parent", 415, 12548, 12842);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.AbstractDualBidiMap.KeySet.serialVersionUID", 415, 12548, 12842);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 416, 12618, 12623)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 416, 12618, 12623).normalMap, Map.class, 416, 12618, 12633)) {
                        if (CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 416, 12618, 12623).normalMap, Map.class, 416, 12618, 12633).containsKey(key)) {
                            Object value = CallChecker.init(Object.class);
                            if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 417, 12686, 12691)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 417, 12686, 12691).normalMap, Map.class, 417, 12686, 12701)) {
                                    value = CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 417, 12686, 12691).normalMap, Map.class, 417, 12686, 12701).remove(key);
                                    CallChecker.varAssign(value, "value", 417, 12686, 12691);
                                }
                            }
                            if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 418, 12732, 12737)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 418, 12732, 12737).reverseMap, Map.class, 418, 12732, 12748)) {
                                    CallChecker.isCalled(parent, AbstractDualBidiMap.class, 418, 12732, 12737).reverseMap.remove(value);
                                }
                            }
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1802.methodEnd();
            }
        }
    }

    protected static class KeySetIterator<K> extends AbstractIteratorDecorator<K> {
        protected final AbstractDualBidiMap<K, ?> parent;

        protected K lastKey = null;

        protected boolean canRemove = false;

        protected KeySetIterator(Iterator<K> iterator, AbstractDualBidiMap<K, ?> parent) {
            super(iterator);
            MethodContext _bcornu_methode_context351 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 446, 13522, 13542);
            } finally {
                _bcornu_methode_context351.methodEnd();
            }
        }

        @Override
        public K next() {
            lastKey = super.next();
            CallChecker.varAssign(this.lastKey, "this.lastKey", 451, 13611, 13633);
            canRemove = true;
            CallChecker.varAssign(this.canRemove, "this.canRemove", 452, 13647, 13663);
            return lastKey;
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context1804 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 457, 13712, 14110);
                CallChecker.varInit(this.iterator, "iterator", 457, 13712, 14110);
                CallChecker.varInit(this.canRemove, "canRemove", 457, 13712, 14110);
                CallChecker.varInit(this.lastKey, "lastKey", 457, 13712, 14110);
                CallChecker.varInit(this.parent, "parent", 457, 13712, 14110);
                if ((canRemove) == false) {
                    throw new IllegalStateException("Iterator remove() can only be called once after next()");
                }
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 461, 13939, 13944)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 461, 13939, 13944).normalMap, Map.class, 461, 13939, 13954)) {
                        value = CallChecker.isCalled(parent, AbstractDualBidiMap.class, 461, 13939, 13944).normalMap.get(lastKey);
                        CallChecker.varAssign(value, "value", 461, 13939, 13944);
                    }
                }
                super.remove();
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 463, 14010, 14015)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 463, 14010, 14015).reverseMap, Map.class, 463, 14010, 14026)) {
                        CallChecker.isCalled(parent, AbstractDualBidiMap.class, 463, 14010, 14015).reverseMap.remove(value);
                    }
                }
                lastKey = null;
                CallChecker.varAssign(this.lastKey, "this.lastKey", 464, 14055, 14069);
                canRemove = false;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 465, 14083, 14100);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1804.methodEnd();
            }
        }
    }

    protected static class Values<V> extends AbstractDualBidiMap.View<Object, V, V> implements Set<V> {
        private static final long serialVersionUID = 4023777119829639864L;

        @SuppressWarnings(value = "unchecked")
        protected Values(AbstractDualBidiMap<?, V> parent) {
            super(CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 485, 14685, 14690).normalMap, Map.class, 485, 14685, 14700).values(), ((AbstractDualBidiMap<Object, V>) (parent)));
            MethodContext _bcornu_methode_context352 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context352.methodEnd();
            }
        }

        @Override
        public Iterator<V> iterator() {
            MethodContext _bcornu_methode_context1805 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 489, 14773, 14897);
                CallChecker.varInit(this.collection, "collection", 489, 14773, 14897);
                CallChecker.varInit(this.parent, "parent", 489, 14773, 14897);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.AbstractDualBidiMap.Values.serialVersionUID", 489, 14773, 14897);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 490, 14842, 14847)) {
                    return CallChecker.isCalled(parent, AbstractDualBidiMap.class, 490, 14842, 14847).createValuesIterator(super.iterator());
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1805.methodEnd();
            }
        }

        @Override
        public boolean contains(Object value) {
            MethodContext _bcornu_methode_context1806 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 494, 14908, 15031);
                CallChecker.varInit(value, "value", 494, 14908, 15031);
                CallChecker.varInit(this.collection, "collection", 494, 14908, 15031);
                CallChecker.varInit(this.parent, "parent", 494, 14908, 15031);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.AbstractDualBidiMap.Values.serialVersionUID", 494, 14908, 15031);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 495, 14985, 14990)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 495, 14985, 14990).reverseMap, Map.class, 495, 14985, 15001)) {
                        return CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 495, 14985, 14990).reverseMap, Map.class, 495, 14985, 15001).containsKey(value);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1806.methodEnd();
            }
        }

        @Override
        public boolean remove(Object value) {
            MethodContext _bcornu_methode_context1807 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 499, 15042, 15339);
                CallChecker.varInit(value, "value", 499, 15042, 15339);
                CallChecker.varInit(this.collection, "collection", 499, 15042, 15339);
                CallChecker.varInit(this.parent, "parent", 499, 15042, 15339);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.AbstractDualBidiMap.Values.serialVersionUID", 499, 15042, 15339);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 500, 15114, 15119)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 500, 15114, 15119).reverseMap, Map.class, 500, 15114, 15130)) {
                        if (CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 500, 15114, 15119).reverseMap, Map.class, 500, 15114, 15130).containsKey(value)) {
                            Object key = CallChecker.init(Object.class);
                            if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 501, 15183, 15188)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 501, 15183, 15188).reverseMap, Map.class, 501, 15183, 15199)) {
                                    key = CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 501, 15183, 15188).reverseMap, Map.class, 501, 15183, 15199).remove(value);
                                    CallChecker.varAssign(key, "key", 501, 15183, 15188);
                                }
                            }
                            if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 502, 15232, 15237)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 502, 15232, 15237).normalMap, Map.class, 502, 15232, 15247)) {
                                    CallChecker.isCalled(parent, AbstractDualBidiMap.class, 502, 15232, 15237).normalMap.remove(key);
                                }
                            }
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1807.methodEnd();
            }
        }
    }

    protected static class ValuesIterator<V> extends AbstractIteratorDecorator<V> {
        protected final AbstractDualBidiMap<Object, V> parent;

        protected V lastValue = null;

        protected boolean canRemove = false;

        @SuppressWarnings(value = "unchecked")
        protected ValuesIterator(Iterator<V> iterator, AbstractDualBidiMap<?, V> parent) {
            super(iterator);
            MethodContext _bcornu_methode_context353 = new MethodContext(null);
            try {
                this.parent = ((AbstractDualBidiMap<Object, V>) (parent));
                CallChecker.varAssign(this.parent, "this.parent", 531, 16067, 16120);
            } finally {
                _bcornu_methode_context353.methodEnd();
            }
        }

        @Override
        public V next() {
            lastValue = super.next();
            CallChecker.varAssign(this.lastValue, "this.lastValue", 536, 16189, 16213);
            canRemove = true;
            CallChecker.varAssign(this.canRemove, "this.canRemove", 537, 16227, 16243);
            return lastValue;
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context1809 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 542, 16294, 16664);
                CallChecker.varInit(this.iterator, "iterator", 542, 16294, 16664);
                CallChecker.varInit(this.canRemove, "canRemove", 542, 16294, 16664);
                CallChecker.varInit(this.lastValue, "lastValue", 542, 16294, 16664);
                CallChecker.varInit(this.parent, "parent", 542, 16294, 16664);
                if ((canRemove) == false) {
                    throw new IllegalStateException("Iterator remove() can only be called once after next()");
                }
                super.remove();
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 547, 16558, 16563)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 547, 16558, 16563).reverseMap, Map.class, 547, 16558, 16574)) {
                        CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 547, 16558, 16563).reverseMap, Map.class, 547, 16558, 16574).remove(lastValue);
                    }
                }
                lastValue = null;
                CallChecker.varAssign(this.lastValue, "this.lastValue", 548, 16607, 16623);
                canRemove = false;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 549, 16637, 16654);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1809.methodEnd();
            }
        }
    }

    protected static class EntrySet<K, V> extends AbstractDualBidiMap.View<K, V, Map.Entry<K, V>> implements Set<Map.Entry<K, V>> {
        private static final long serialVersionUID = 4040410962603292348L;

        protected EntrySet(AbstractDualBidiMap<K, V> parent) {
            super(CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 568, 17232, 17237).normalMap, Map.class, 568, 17232, 17247).entrySet(), parent);
            MethodContext _bcornu_methode_context354 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context354.methodEnd();
            }
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            MethodContext _bcornu_methode_context1810 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 572, 17289, 17429);
                CallChecker.varInit(this.collection, "collection", 572, 17289, 17429);
                CallChecker.varInit(this.parent, "parent", 572, 17289, 17429);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.AbstractDualBidiMap.EntrySet.serialVersionUID", 572, 17289, 17429);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 573, 17372, 17377)) {
                    return CallChecker.isCalled(parent, AbstractDualBidiMap.class, 573, 17372, 17377).createEntrySetIterator(super.iterator());
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1810.methodEnd();
            }
        }

        @Override
        public boolean remove(Object obj) {
            MethodContext _bcornu_methode_context1811 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 577, 17440, 18086);
                CallChecker.varInit(obj, "obj", 577, 17440, 18086);
                CallChecker.varInit(this.collection, "collection", 577, 17440, 18086);
                CallChecker.varInit(this.parent, "parent", 577, 17440, 18086);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.AbstractDualBidiMap.EntrySet.serialVersionUID", 577, 17440, 18086);
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                Map.Entry<?, ?> entry = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "entry", 581, 17603, 17648);
                Object key = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 582, 17675, 17679)) {
                    key = entry.getKey();
                    CallChecker.varAssign(key, "key", 582, 17675, 17679);
                }
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 583, 17707, 17712)) {
                    if (CallChecker.isCalled(parent, AbstractDualBidiMap.class, 583, 17707, 17712).containsKey(key)) {
                        V value = CallChecker.init(null);
                        if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 584, 17760, 17765)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 584, 17760, 17765).normalMap, Map.class, 584, 17760, 17775)) {
                                value = CallChecker.isCalled(parent, AbstractDualBidiMap.class, 584, 17760, 17765).normalMap.get(key);
                                CallChecker.varAssign(value, "value", 584, 17760, 17765);
                            }
                        }
                        if (value == null) {
                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 585, 17823, 17827)) {
                                if ((entry.getValue()) == null) {
                                    if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 586, 17904, 17909)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 586, 17904, 17909).normalMap, Map.class, 586, 17904, 17919)) {
                                            CallChecker.isCalled(parent, AbstractDualBidiMap.class, 586, 17904, 17909).normalMap.remove(key);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 587, 17954, 17959)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 587, 17954, 17959).reverseMap, Map.class, 587, 17954, 17970)) {
                                            CallChecker.isCalled(parent, AbstractDualBidiMap.class, 587, 17954, 17959).reverseMap.remove(value);
                                        }
                                    }
                                    return true;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else {
                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 585, 17863, 17867)) {
                                if (value.equals(entry.getValue())) {
                                    if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 586, 17904, 17909)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 586, 17904, 17909).normalMap, Map.class, 586, 17904, 17919)) {
                                            CallChecker.isCalled(parent, AbstractDualBidiMap.class, 586, 17904, 17909).normalMap.remove(key);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 587, 17954, 17959)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 587, 17954, 17959).reverseMap, Map.class, 587, 17954, 17970)) {
                                            CallChecker.isCalled(parent, AbstractDualBidiMap.class, 587, 17954, 17959).reverseMap.remove(value);
                                        }
                                    }
                                    return true;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1811.methodEnd();
            }
        }
    }

    protected static class EntrySetIterator<K, V> extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        protected final AbstractDualBidiMap<K, V> parent;

        protected Map.Entry<K, V> last = null;

        protected boolean canRemove = false;

        protected EntrySetIterator(Iterator<Map.Entry<K, V>> iterator, AbstractDualBidiMap<K, V> parent) {
            super(iterator);
            MethodContext _bcornu_methode_context355 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 616, 18816, 18836);
            } finally {
                _bcornu_methode_context355.methodEnd();
            }
        }

        @Override
        public Map.Entry<K, V> next() {
            MethodContext _bcornu_methode_context1812 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 620, 18857, 19031);
                CallChecker.varInit(this.iterator, "iterator", 620, 18857, 19031);
                CallChecker.varInit(this.canRemove, "canRemove", 620, 18857, 19031);
                CallChecker.varInit(this.last, "last", 620, 18857, 19031);
                CallChecker.varInit(this.parent, "parent", 620, 18857, 19031);
                last = new AbstractDualBidiMap.MapEntry<K, V>(super.next(), parent);
                CallChecker.varAssign(this.last, "this.last", 621, 18919, 18966);
                canRemove = true;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 622, 18980, 18996);
                return last;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1812.methodEnd();
            }
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context1813 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 627, 19042, 19511);
                CallChecker.varInit(this.iterator, "iterator", 627, 19042, 19511);
                CallChecker.varInit(this.canRemove, "canRemove", 627, 19042, 19511);
                CallChecker.varInit(this.last, "last", 627, 19042, 19511);
                CallChecker.varInit(this.parent, "parent", 627, 19042, 19511);
                if ((canRemove) == false) {
                    throw new IllegalStateException("Iterator remove() can only be called once after next()");
                }
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(last, Map.Entry.class, 632, 19357, 19360)) {
                    value = last.getValue();
                    CallChecker.varAssign(value, "value", 632, 19357, 19360);
                }
                super.remove();
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 634, 19414, 19419)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 634, 19414, 19419).reverseMap, Map.class, 634, 19414, 19430)) {
                        CallChecker.isCalled(parent, AbstractDualBidiMap.class, 634, 19414, 19419).reverseMap.remove(value);
                    }
                }
                last = null;
                CallChecker.varAssign(this.last, "this.last", 635, 19459, 19470);
                canRemove = false;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 636, 19484, 19501);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1813.methodEnd();
            }
        }
    }

    protected static class MapEntry<K, V> extends AbstractMapEntryDecorator<K, V> {
        protected final AbstractDualBidiMap<K, V> parent;

        protected MapEntry(Map.Entry<K, V> entry, AbstractDualBidiMap<K, V> parent) {
            super(entry);
            MethodContext _bcornu_methode_context356 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 655, 19999, 20019);
            } finally {
                _bcornu_methode_context356.methodEnd();
            }
        }

        @Override
        public V setValue(V value) {
            K key = CallChecker.varInit(this.getKey(), "key", 660, 20099, 20129);
            if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 661, 20147, 20152)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 661, 20147, 20152).reverseMap, Map.class, 661, 20147, 20163)) {
                    if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 662, 20203, 20208)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 662, 20203, 20208).reverseMap, Map.class, 662, 20203, 20219)) {
                            if ((CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 661, 20147, 20152).reverseMap, Map.class, 661, 20147, 20163).containsKey(value)) && ((CallChecker.isCalled(parent, AbstractDualBidiMap.class, 662, 20203, 20208).reverseMap.get(value)) != key)) {
                                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 665, 20393, 20398)) {
                parent.put(key, value);
            }
            final V oldValue = CallChecker.varInit(super.setValue(value), "oldValue", 666, 20429, 20469);
            return oldValue;
        }
    }

    protected static class BidiMapIterator<K, V> implements MapIterator<K, V> , ResettableIterator<K> {
        protected final AbstractDualBidiMap<K, V> parent;

        protected Iterator<Map.Entry<K, V>> iterator;

        protected Map.Entry<K, V> last = null;

        protected boolean canRemove = false;

        protected BidiMapIterator(AbstractDualBidiMap<K, V> parent) {
            super();
            MethodContext _bcornu_methode_context357 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 694, 21232, 21252);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 695, 21282, 21287)) {
                    parent = CallChecker.beforeCalled(parent, AbstractDualBidiMap.class, 695, 21282, 21287);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 695, 21282, 21287).normalMap, Map.class, 695, 21282, 21297)) {
                        parent = CallChecker.beforeCalled(parent, AbstractDualBidiMap.class, 695, 21282, 21287);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 695, 21282, 21287).normalMap, Map.class, 695, 21282, 21297).entrySet(), Set.class, 695, 21282, 21308)) {
                            parent = CallChecker.beforeCalled(parent, AbstractDualBidiMap.class, 695, 21282, 21287);
                            this.iterator = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 695, 21282, 21287).normalMap, Map.class, 695, 21282, 21297).entrySet(), Set.class, 695, 21282, 21308).iterator();
                            CallChecker.varAssign(this.iterator, "this.iterator", 695, 21266, 21320);
                        }
                    }
                }
            } finally {
                _bcornu_methode_context357.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context1815 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 698, 21341, 21415);
                CallChecker.varInit(this.canRemove, "canRemove", 698, 21341, 21415);
                CallChecker.varInit(this.last, "last", 698, 21341, 21415);
                CallChecker.varInit(this.iterator, "iterator", 698, 21341, 21415);
                CallChecker.varInit(this.parent, "parent", 698, 21341, 21415);
                if (CallChecker.beforeDeref(iterator, Iterator.class, 699, 21387, 21394)) {
                    iterator = CallChecker.beforeCalled(iterator, Iterator.class, 699, 21387, 21394);
                    return CallChecker.isCalled(iterator, Iterator.class, 699, 21387, 21394).hasNext();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1815.methodEnd();
            }
        }

        public K next() {
            if (CallChecker.beforeDeref(iterator, Iterator.class, 703, 21463, 21470)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 703, 21463, 21470);
                last = CallChecker.isCalled(iterator, Iterator.class, 703, 21463, 21470).next();
                CallChecker.varAssign(this.last, "this.last", 703, 21456, 21478);
            }
            canRemove = true;
            CallChecker.varAssign(this.canRemove, "this.canRemove", 704, 21492, 21508);
            if (CallChecker.beforeDeref(last, Map.Entry.class, 705, 21529, 21532)) {
                return last.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public void remove() {
            MethodContext _bcornu_methode_context1817 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 708, 21563, 22012);
                CallChecker.varInit(this.canRemove, "canRemove", 708, 21563, 22012);
                CallChecker.varInit(this.last, "last", 708, 21563, 22012);
                CallChecker.varInit(this.iterator, "iterator", 708, 21563, 22012);
                CallChecker.varInit(this.parent, "parent", 708, 21563, 22012);
                if ((canRemove) == false) {
                    throw new IllegalStateException("Iterator remove() can only be called once after next()");
                }
                V value = CallChecker.init(null);
                if (CallChecker.beforeDeref(last, Map.Entry.class, 713, 21855, 21858)) {
                    value = last.getValue();
                    CallChecker.varAssign(value, "value", 713, 21855, 21858);
                }
                if (CallChecker.beforeDeref(iterator, Iterator.class, 714, 21884, 21891)) {
                    iterator = CallChecker.beforeCalled(iterator, Iterator.class, 714, 21884, 21891);
                    CallChecker.isCalled(iterator, Iterator.class, 714, 21884, 21891).remove();
                }
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 715, 21915, 21920)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 715, 21915, 21920).reverseMap, Map.class, 715, 21915, 21931)) {
                        CallChecker.isCalled(parent, AbstractDualBidiMap.class, 715, 21915, 21920).reverseMap.remove(value);
                    }
                }
                last = null;
                CallChecker.varAssign(this.last, "this.last", 716, 21960, 21971);
                canRemove = false;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 717, 21985, 22002);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1817.methodEnd();
            }
        }

        public K getKey() {
            if ((last) == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            return last.getKey();
        }

        public V getValue() {
            if ((last) == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            return last.getValue();
        }

        public V setValue(V value) {
            if ((last) == null) {
                throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
            }
            if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 738, 22726, 22731)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 738, 22726, 22731).reverseMap, Map.class, 738, 22726, 22742)) {
                    if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 739, 22782, 22787)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 739, 22782, 22787).reverseMap, Map.class, 739, 22782, 22798)) {
                            if ((CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 738, 22726, 22731).reverseMap, Map.class, 738, 22726, 22742).containsKey(value)) && ((CallChecker.isCalled(parent, AbstractDualBidiMap.class, 739, 22782, 22787).reverseMap.get(value)) != (last.getKey()))) {
                                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 742, 22989, 22994)) {
                return parent.put(last.getKey(), value);
            }else
                throw new AbnormalExecutionError();
            
        }

        public void reset() {
            MethodContext _bcornu_methode_context1821 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 745, 23042, 23191);
                CallChecker.varInit(this.canRemove, "canRemove", 745, 23042, 23191);
                CallChecker.varInit(this.last, "last", 745, 23042, 23191);
                CallChecker.varInit(this.iterator, "iterator", 745, 23042, 23191);
                CallChecker.varInit(this.parent, "parent", 745, 23042, 23191);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 746, 23087, 23092)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 746, 23087, 23092).normalMap, Map.class, 746, 23087, 23102)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 746, 23087, 23092).normalMap, Map.class, 746, 23087, 23102).entrySet(), Set.class, 746, 23087, 23113)) {
                            iterator = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 746, 23087, 23092).normalMap, Map.class, 746, 23087, 23102).entrySet(), Set.class, 746, 23087, 23113).iterator();
                            CallChecker.varAssign(this.iterator, "this.iterator", 746, 23076, 23125);
                        }
                    }
                }
                last = null;
                CallChecker.varAssign(this.last, "this.last", 747, 23139, 23150);
                canRemove = false;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 748, 23164, 23181);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1821.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context1822 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 752, 23202, 23412);
                CallChecker.varInit(this.canRemove, "canRemove", 752, 23202, 23412);
                CallChecker.varInit(this.last, "last", 752, 23202, 23412);
                CallChecker.varInit(this.iterator, "iterator", 752, 23202, 23412);
                CallChecker.varInit(this.parent, "parent", 752, 23202, 23412);
                if ((last) != null) {
                    return ((("MapIterator[" + (getKey())) + "=") + (getValue())) + "]";
                }
                return "MapIterator[]";
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1822.methodEnd();
            }
        }
    }
}

