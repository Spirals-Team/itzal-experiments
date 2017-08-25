package org.apache.commons.collections.bidimap;

import org.apache.commons.collections.keyvalue.UnmodifiableMapEntry;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.Set;
import org.apache.commons.collections.OrderedMapIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.iterators.EmptyOrderedMapIterator;
import java.util.ConcurrentModificationException;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.AbstractSet;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Iterator;
import org.apache.commons.collections.KeyValue;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedIterator;

public class TreeBidiMap<K extends Comparable<K>, V extends Comparable<V>> implements OrderedBidiMap<K, V> {
    static enum DataElement {
KEY("key"), VALUE("value");
        private final String description;

        private DataElement(String description) {
            MethodContext _bcornu_methode_context261 = new MethodContext(null);
            try {
                this.description = description;
                CallChecker.varAssign(this.description, "this.description", 88, 3946, 3976);
            } finally {
                _bcornu_methode_context261.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context1320 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 95, 3997, 4131);
                return description;
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1320.methodEnd();
            }
        }
    }

    private TreeBidiMap.Node<K, V>[] rootNode;

    private int nodeCount = 0;

    private int modifications = 0;

    private Set<K> keySet;

    private Set<V> valuesSet;

    private Set<Map.Entry<K, V>> entrySet;

    private TreeBidiMap<K, V>.Inverse inverse = null;

    @SuppressWarnings(value = "unchecked")
    public TreeBidiMap() {
        super();
        MethodContext _bcornu_methode_context262 = new MethodContext(null);
        try {
            rootNode = new TreeBidiMap.Node[2];
            CallChecker.varAssign(this.rootNode, "this.rootNode", 115, 4602, 4624);
        } finally {
            _bcornu_methode_context262.methodEnd();
        }
    }

    public TreeBidiMap(final Map<K, V> map) {
        this();
        MethodContext _bcornu_methode_context263 = new MethodContext(null);
        try {
            putAll(map);
        } finally {
            _bcornu_methode_context263.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context1321 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 137, 5046, 5318);
            CallChecker.varInit(this.inverse, "inverse", 137, 5046, 5318);
            CallChecker.varInit(this.entrySet, "entrySet", 137, 5046, 5318);
            CallChecker.varInit(this.valuesSet, "valuesSet", 137, 5046, 5318);
            CallChecker.varInit(this.keySet, "keySet", 137, 5046, 5318);
            CallChecker.varInit(this.modifications, "modifications", 137, 5046, 5318);
            CallChecker.varInit(this.nodeCount, "nodeCount", 137, 5046, 5318);
            CallChecker.varInit(this.rootNode, "rootNode", 137, 5046, 5318);
            return nodeCount;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1321.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1322 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 146, 5325, 5499);
            CallChecker.varInit(this.inverse, "inverse", 146, 5325, 5499);
            CallChecker.varInit(this.entrySet, "entrySet", 146, 5325, 5499);
            CallChecker.varInit(this.valuesSet, "valuesSet", 146, 5325, 5499);
            CallChecker.varInit(this.keySet, "keySet", 146, 5325, 5499);
            CallChecker.varInit(this.modifications, "modifications", 146, 5325, 5499);
            CallChecker.varInit(this.nodeCount, "nodeCount", 146, 5325, 5499);
            CallChecker.varInit(this.rootNode, "rootNode", 146, 5325, 5499);
            return (nodeCount) == 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1322.methodEnd();
        }
    }

    public boolean containsKey(final Object key) {
        MethodContext _bcornu_methode_context1323 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 160, 5506, 6054);
            CallChecker.varInit(key, "key", 160, 5506, 6054);
            CallChecker.varInit(this.inverse, "inverse", 160, 5506, 6054);
            CallChecker.varInit(this.entrySet, "entrySet", 160, 5506, 6054);
            CallChecker.varInit(this.valuesSet, "valuesSet", 160, 5506, 6054);
            CallChecker.varInit(this.keySet, "keySet", 160, 5506, 6054);
            CallChecker.varInit(this.modifications, "modifications", 160, 5506, 6054);
            CallChecker.varInit(this.nodeCount, "nodeCount", 160, 5506, 6054);
            CallChecker.varInit(this.rootNode, "rootNode", 160, 5506, 6054);
            TreeBidiMap.checkKey(key);
            return (lookupKey(key)) != null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1323.methodEnd();
        }
    }

    public boolean containsValue(final Object value) {
        MethodContext _bcornu_methode_context1324 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 175, 6061, 6635);
            CallChecker.varInit(value, "value", 175, 6061, 6635);
            CallChecker.varInit(this.inverse, "inverse", 175, 6061, 6635);
            CallChecker.varInit(this.entrySet, "entrySet", 175, 6061, 6635);
            CallChecker.varInit(this.valuesSet, "valuesSet", 175, 6061, 6635);
            CallChecker.varInit(this.keySet, "keySet", 175, 6061, 6635);
            CallChecker.varInit(this.modifications, "modifications", 175, 6061, 6635);
            CallChecker.varInit(this.nodeCount, "nodeCount", 175, 6061, 6635);
            CallChecker.varInit(this.rootNode, "rootNode", 175, 6061, 6635);
            TreeBidiMap.checkValue(value);
            return (lookupValue(value)) != null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1324.methodEnd();
        }
    }

    public V get(final Object key) {
        TreeBidiMap.checkKey(key);
        TreeBidiMap.Node<K, V> node = CallChecker.varInit(lookupKey(key), "node", 194, 7243, 7275);
        if (node == null) {
            return null;
        }else {
            return node.getValue();
        }
    }

    public V put(final K key, final V value) {
        V result = CallChecker.varInit(get(key), "result", 223, 8480, 8499);
        doPut(key, value);
        return result;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context1327 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 235, 8562, 8954);
            CallChecker.varInit(map, "map", 235, 8562, 8954);
            CallChecker.varInit(this.inverse, "inverse", 235, 8562, 8954);
            CallChecker.varInit(this.entrySet, "entrySet", 235, 8562, 8954);
            CallChecker.varInit(this.valuesSet, "valuesSet", 235, 8562, 8954);
            CallChecker.varInit(this.keySet, "keySet", 235, 8562, 8954);
            CallChecker.varInit(this.modifications, "modifications", 235, 8562, 8954);
            CallChecker.varInit(this.nodeCount, "nodeCount", 235, 8562, 8954);
            CallChecker.varInit(this.rootNode, "rootNode", 235, 8562, 8954);
            map = CallChecker.beforeCalled(map, Map.class, 236, 8879, 8881);
            for (Map.Entry<? extends K, ? extends V> e : CallChecker.isCalled(map, Map.class, 236, 8879, 8881).entrySet()) {
                if (CallChecker.beforeDeref(e, Map.Entry.class, 237, 8913, 8913)) {
                    if (CallChecker.beforeDeref(e, Map.Entry.class, 237, 8925, 8925)) {
                        put(e.getKey(), e.getValue());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1327.methodEnd();
        }
    }

    public V remove(final Object key) {
        return doRemoveKey(key);
    }

    public void clear() {
        MethodContext _bcornu_methode_context1329 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 259, 9502, 9711);
            CallChecker.varInit(this.inverse, "inverse", 259, 9502, 9711);
            CallChecker.varInit(this.entrySet, "entrySet", 259, 9502, 9711);
            CallChecker.varInit(this.valuesSet, "valuesSet", 259, 9502, 9711);
            CallChecker.varInit(this.keySet, "keySet", 259, 9502, 9711);
            CallChecker.varInit(this.modifications, "modifications", 259, 9502, 9711);
            CallChecker.varInit(this.nodeCount, "nodeCount", 259, 9502, 9711);
            CallChecker.varInit(this.rootNode, "rootNode", 259, 9502, 9711);
            modify();
            nodeCount = 0;
            CallChecker.varAssign(this.nodeCount, "this.nodeCount", 262, 9610, 9623);
            if (CallChecker.beforeDeref(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 263, 9642, 9644)) {
                if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 263, 9633, 9640)) {
                    rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 263, 9633, 9640);
                    CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 263, 9633, 9640)[CallChecker.isCalled(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 263, 9642, 9644).ordinal()] = null;
                    CallChecker.varAssign(CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 263, 9633, 9640)[CallChecker.isCalled(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 263, 9642, 9644).ordinal()], "CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 263, 9633, 9640)[CallChecker.isCalled(KEY, TreeBidiMap.DataElement.class, 263, 9642, 9644).ordinal()]", 263, 9633, 9663);
                }
            }
            if (CallChecker.beforeDeref(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 264, 9682, 9686)) {
                if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 264, 9673, 9680)) {
                    rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 264, 9673, 9680);
                    CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 264, 9673, 9680)[CallChecker.isCalled(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 264, 9682, 9686).ordinal()] = null;
                    CallChecker.varAssign(CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 264, 9673, 9680)[CallChecker.isCalled(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 264, 9682, 9686).ordinal()], "CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 264, 9673, 9680)[CallChecker.isCalled(VALUE, TreeBidiMap.DataElement.class, 264, 9682, 9686).ordinal()]", 264, 9673, 9705);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1329.methodEnd();
        }
    }

    public K getKey(final Object value) {
        TreeBidiMap.checkValue(value);
        TreeBidiMap.Node<K, V> node = CallChecker.varInit(lookupValue(value), "node", 282, 10423, 10459);
        if (node == null) {
            return null;
        }else {
            return node.getKey();
        }
    }

    public K removeValue(final Object value) {
        return doRemoveValue(value);
    }

    public K firstKey() {
        if ((nodeCount) == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        if (CallChecker.beforeDeref(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 312, 11532, 11534)) {
            if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 312, 11523, 11530)) {
                rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 312, 11523, 11530);
                final TreeBidiMap.Node<K, V> npe_invocation_var275 = leastNode(CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 312, 11523, 11530)[CallChecker.isCalled(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 312, 11532, 11534).ordinal()], TreeBidiMap.DataElement.KEY);
                if (CallChecker.beforeDeref(npe_invocation_var275, TreeBidiMap.Node.class, 312, 11513, 11551)) {
                    return npe_invocation_var275.getKey();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        }else
            throw new AbnormalExecutionError();
        
    }

    public K lastKey() {
        if ((nodeCount) == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        if (CallChecker.beforeDeref(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 325, 11941, 11943)) {
            if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 325, 11932, 11939)) {
                rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 325, 11932, 11939);
                final TreeBidiMap.Node<K, V> npe_invocation_var276 = greatestNode(CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 325, 11932, 11939)[CallChecker.isCalled(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 325, 11941, 11943).ordinal()], TreeBidiMap.DataElement.KEY);
                if (CallChecker.beforeDeref(npe_invocation_var276, TreeBidiMap.Node.class, 325, 11919, 11960)) {
                    return npe_invocation_var276.getKey();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        }else
            throw new AbnormalExecutionError();
        
    }

    public K nextKey(K key) {
        TreeBidiMap.checkKey(key);
        TreeBidiMap.Node<K, V> node = CallChecker.varInit(nextGreater(lookupKey(key), TreeBidiMap.DataElement.KEY), "node", 338, 12285, 12335);
        if (node == null) {
            return null;
        }else {
            return node.getKey();
        }
    }

    public K previousKey(K key) {
        TreeBidiMap.checkKey(key);
        TreeBidiMap.Node<K, V> node = CallChecker.varInit(nextSmaller(lookupKey(key), TreeBidiMap.DataElement.KEY), "node", 352, 12721, 12771);
        if (node == null) {
            return null;
        }else {
            return node.getKey();
        }
    }

    public Set<K> keySet() {
        MethodContext _bcornu_methode_context1336 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 369, 12836, 13607);
            CallChecker.varInit(this.inverse, "inverse", 369, 12836, 13607);
            CallChecker.varInit(this.entrySet, "entrySet", 369, 12836, 13607);
            CallChecker.varInit(this.valuesSet, "valuesSet", 369, 12836, 13607);
            CallChecker.varInit(this.keySet, "keySet", 369, 12836, 13607);
            CallChecker.varInit(this.modifications, "modifications", 369, 12836, 13607);
            CallChecker.varInit(this.nodeCount, "nodeCount", 369, 12836, 13607);
            CallChecker.varInit(this.rootNode, "rootNode", 369, 12836, 13607);
            if ((keySet) == null) {
                keySet = new KeyView(TreeBidiMap.DataElement.KEY);
                CallChecker.varAssign(this.keySet, "this.keySet", 371, 13543, 13568);
            }
            return keySet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1336.methodEnd();
        }
    }

    public Collection<V> values() {
        MethodContext _bcornu_methode_context1337 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 390, 13614, 14456);
            CallChecker.varInit(this.inverse, "inverse", 390, 13614, 14456);
            CallChecker.varInit(this.entrySet, "entrySet", 390, 13614, 14456);
            CallChecker.varInit(this.valuesSet, "valuesSet", 390, 13614, 14456);
            CallChecker.varInit(this.keySet, "keySet", 390, 13614, 14456);
            CallChecker.varInit(this.modifications, "modifications", 390, 13614, 14456);
            CallChecker.varInit(this.nodeCount, "nodeCount", 390, 13614, 14456);
            CallChecker.varInit(this.rootNode, "rootNode", 390, 13614, 14456);
            if ((valuesSet) == null) {
                valuesSet = new ValueView(TreeBidiMap.DataElement.KEY);
                CallChecker.varAssign(this.valuesSet, "this.valuesSet", 392, 14384, 14414);
            }
            return valuesSet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1337.methodEnd();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context1338 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 412, 14463, 15395);
            CallChecker.varInit(this.inverse, "inverse", 412, 14463, 15395);
            CallChecker.varInit(this.entrySet, "entrySet", 412, 14463, 15395);
            CallChecker.varInit(this.valuesSet, "valuesSet", 412, 14463, 15395);
            CallChecker.varInit(this.keySet, "keySet", 412, 14463, 15395);
            CallChecker.varInit(this.modifications, "modifications", 412, 14463, 15395);
            CallChecker.varInit(this.nodeCount, "nodeCount", 412, 14463, 15395);
            CallChecker.varInit(this.rootNode, "rootNode", 412, 14463, 15395);
            if ((entrySet) == null) {
                entrySet = new EntryView();
                CallChecker.varAssign(this.entrySet, "this.entrySet", 414, 15328, 15354);
            }
            return entrySet;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1338.methodEnd();
        }
    }

    public OrderedMapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context1339 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 423, 15402, 15709);
            CallChecker.varInit(this.inverse, "inverse", 423, 15402, 15709);
            CallChecker.varInit(this.entrySet, "entrySet", 423, 15402, 15709);
            CallChecker.varInit(this.valuesSet, "valuesSet", 423, 15402, 15709);
            CallChecker.varInit(this.keySet, "keySet", 423, 15402, 15709);
            CallChecker.varInit(this.modifications, "modifications", 423, 15402, 15709);
            CallChecker.varInit(this.nodeCount, "nodeCount", 423, 15402, 15709);
            CallChecker.varInit(this.rootNode, "rootNode", 423, 15402, 15709);
            if (isEmpty()) {
                return EmptyOrderedMapIterator.<K, V>getInstance();
            }
            return new ViewMapIterator(TreeBidiMap.DataElement.KEY);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1339.methodEnd();
        }
    }

    public OrderedBidiMap<V, K> inverseBidiMap() {
        MethodContext _bcornu_methode_context1340 = new MethodContext(OrderedBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 436, 15716, 16045);
            CallChecker.varInit(this.inverse, "inverse", 436, 15716, 16045);
            CallChecker.varInit(this.entrySet, "entrySet", 436, 15716, 16045);
            CallChecker.varInit(this.valuesSet, "valuesSet", 436, 15716, 16045);
            CallChecker.varInit(this.keySet, "keySet", 436, 15716, 16045);
            CallChecker.varInit(this.modifications, "modifications", 436, 15716, 16045);
            CallChecker.varInit(this.nodeCount, "nodeCount", 436, 15716, 16045);
            CallChecker.varInit(this.rootNode, "rootNode", 436, 15716, 16045);
            if ((inverse) == null) {
                inverse = new Inverse();
                CallChecker.varAssign(this.inverse, "this.inverse", 438, 15982, 16005);
            }
            return inverse;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedBidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1340.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1341 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 451, 16052, 16363);
            CallChecker.varInit(obj, "obj", 451, 16052, 16363);
            CallChecker.varInit(this.inverse, "inverse", 451, 16052, 16363);
            CallChecker.varInit(this.entrySet, "entrySet", 451, 16052, 16363);
            CallChecker.varInit(this.valuesSet, "valuesSet", 451, 16052, 16363);
            CallChecker.varInit(this.keySet, "keySet", 451, 16052, 16363);
            CallChecker.varInit(this.modifications, "modifications", 451, 16052, 16363);
            CallChecker.varInit(this.nodeCount, "nodeCount", 451, 16052, 16363);
            CallChecker.varInit(this.rootNode, "rootNode", 451, 16052, 16363);
            return this.doEquals(obj, TreeBidiMap.DataElement.KEY);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1341.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1342 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 461, 16370, 16581);
            CallChecker.varInit(this.inverse, "inverse", 461, 16370, 16581);
            CallChecker.varInit(this.entrySet, "entrySet", 461, 16370, 16581);
            CallChecker.varInit(this.valuesSet, "valuesSet", 461, 16370, 16581);
            CallChecker.varInit(this.keySet, "keySet", 461, 16370, 16581);
            CallChecker.varInit(this.modifications, "modifications", 461, 16370, 16581);
            CallChecker.varInit(this.nodeCount, "nodeCount", 461, 16370, 16581);
            CallChecker.varInit(this.rootNode, "rootNode", 461, 16370, 16581);
            return this.doHashCode(TreeBidiMap.DataElement.KEY);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1342.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1343 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 471, 16588, 16816);
            CallChecker.varInit(this.inverse, "inverse", 471, 16588, 16816);
            CallChecker.varInit(this.entrySet, "entrySet", 471, 16588, 16816);
            CallChecker.varInit(this.valuesSet, "valuesSet", 471, 16588, 16816);
            CallChecker.varInit(this.keySet, "keySet", 471, 16588, 16816);
            CallChecker.varInit(this.modifications, "modifications", 471, 16588, 16816);
            CallChecker.varInit(this.nodeCount, "nodeCount", 471, 16588, 16816);
            CallChecker.varInit(this.rootNode, "rootNode", 471, 16588, 16816);
            return this.doToString(TreeBidiMap.DataElement.KEY);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1343.methodEnd();
        }
    }

    private void doPut(final K key, final V value) {
        MethodContext _bcornu_methode_context1344 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 482, 16823, 18972);
            CallChecker.varInit(value, "value", 482, 16823, 18972);
            CallChecker.varInit(key, "key", 482, 16823, 18972);
            CallChecker.varInit(this.inverse, "inverse", 482, 16823, 18972);
            CallChecker.varInit(this.entrySet, "entrySet", 482, 16823, 18972);
            CallChecker.varInit(this.valuesSet, "valuesSet", 482, 16823, 18972);
            CallChecker.varInit(this.keySet, "keySet", 482, 16823, 18972);
            CallChecker.varInit(this.modifications, "modifications", 482, 16823, 18972);
            CallChecker.varInit(this.nodeCount, "nodeCount", 482, 16823, 18972);
            CallChecker.varInit(this.rootNode, "rootNode", 482, 16823, 18972);
            TreeBidiMap.checkKeyAndValue(key, value);
            doRemoveKey(key);
            doRemoveValue(value);
            TreeBidiMap.Node<K, V> node = CallChecker.init(TreeBidiMap.Node.class);
            if (CallChecker.beforeDeref(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 489, 17287, 17289)) {
                if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 489, 17278, 17285)) {
                    rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 489, 17278, 17285);
                    node = CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 489, 17278, 17285)[CallChecker.isCalled(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 489, 17287, 17289).ordinal()];
                    CallChecker.varAssign(node, "node", 489, 17287, 17289);
                }
            }
            if (node == null) {
                TreeBidiMap.Node<K, V> root = CallChecker.varInit(new TreeBidiMap.Node<K, V>(key, value), "root", 492, 17371, 17415);
                if (CallChecker.beforeDeref(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 493, 17438, 17440)) {
                    if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 493, 17429, 17436)) {
                        rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 493, 17429, 17436);
                        CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 493, 17429, 17436)[CallChecker.isCalled(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 493, 17438, 17440).ordinal()] = root;
                        CallChecker.varAssign(CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 493, 17429, 17436)[CallChecker.isCalled(TreeBidiMap.DataElement.KEY, TreeBidiMap.DataElement.class, 493, 17438, 17440).ordinal()], "CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 493, 17429, 17436)[CallChecker.isCalled(KEY, TreeBidiMap.DataElement.class, 493, 17438, 17440).ordinal()]", 493, 17429, 17459);
                    }
                }
                if (CallChecker.beforeDeref(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 494, 17482, 17486)) {
                    if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 494, 17473, 17480)) {
                        rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 494, 17473, 17480);
                        CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 494, 17473, 17480)[CallChecker.isCalled(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 494, 17482, 17486).ordinal()] = root;
                        CallChecker.varAssign(CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 494, 17473, 17480)[CallChecker.isCalled(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 494, 17482, 17486).ordinal()], "CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 494, 17473, 17480)[CallChecker.isCalled(VALUE, TreeBidiMap.DataElement.class, 494, 17482, 17486).ordinal()]", 494, 17473, 17505);
                    }
                }
                grow();
            }else {
                while (true) {
                    int cmp = CallChecker.varInit(((int) (TreeBidiMap.compare(key, node.getKey()))), "cmp", 500, 17619, 17656);
                    if (cmp == 0) {
                        throw new IllegalArgumentException((("Cannot store a duplicate key (\"" + key) + "\") in this Map"));
                    }else
                        if (cmp < 0) {
                            if ((node.getLeft(TreeBidiMap.DataElement.KEY)) != null) {
                                node = node.getLeft(TreeBidiMap.DataElement.KEY);
                                CallChecker.varAssign(node, "node", 507, 17964, 17988);
                            }else {
                                TreeBidiMap.Node<K, V> newNode = CallChecker.varInit(new TreeBidiMap.Node<K, V>(key, value), "newNode", 509, 18043, 18090);
                                insertValue(newNode);
                                node.setLeft(newNode, TreeBidiMap.DataElement.KEY);
                                if (CallChecker.beforeDeref(newNode, TreeBidiMap.Node.class, 513, 18215, 18221)) {
                                    newNode = CallChecker.beforeCalled(newNode, TreeBidiMap.Node.class, 513, 18215, 18221);
                                    CallChecker.isCalled(newNode, TreeBidiMap.Node.class, 513, 18215, 18221).setParent(node, TreeBidiMap.DataElement.KEY);
                                }
                                doRedBlackInsert(newNode, TreeBidiMap.DataElement.KEY);
                                grow();
                                break;
                            }
                        }else {
                            if ((node.getRight(TreeBidiMap.DataElement.KEY)) != null) {
                                node = node.getRight(TreeBidiMap.DataElement.KEY);
                                CallChecker.varAssign(node, "node", 521, 18501, 18526);
                            }else {
                                TreeBidiMap.Node<K, V> newNode = CallChecker.varInit(new TreeBidiMap.Node<K, V>(key, value), "newNode", 523, 18581, 18628);
                                insertValue(newNode);
                                node.setRight(newNode, TreeBidiMap.DataElement.KEY);
                                if (CallChecker.beforeDeref(newNode, TreeBidiMap.Node.class, 527, 18754, 18760)) {
                                    newNode = CallChecker.beforeCalled(newNode, TreeBidiMap.Node.class, 527, 18754, 18760);
                                    CallChecker.isCalled(newNode, TreeBidiMap.Node.class, 527, 18754, 18760).setParent(node, TreeBidiMap.DataElement.KEY);
                                }
                                doRedBlackInsert(newNode, TreeBidiMap.DataElement.KEY);
                                grow();
                                break;
                            }
                        }
                    
                } 
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1344.methodEnd();
        }
    }

    private V doRemoveKey(Object key) {
        TreeBidiMap.Node<K, V> node = CallChecker.varInit(lookupKey(key), "node", 539, 19023, 19055);
        if (node == null) {
            return null;
        }
        doRedBlackDelete(node);
        return node.getValue();
    }

    private K doRemoveValue(Object value) {
        TreeBidiMap.Node<K, V> node = CallChecker.varInit(lookupValue(value), "node", 548, 19243, 19279);
        if (node == null) {
            return null;
        }
        doRedBlackDelete(node);
        return node.getKey();
    }

    @SuppressWarnings(value = "unchecked")
    private <T extends Comparable<T>> TreeBidiMap.Node<K, V> lookup(final Object data, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1347 = new MethodContext(TreeBidiMap.Node.class);
        try {
            CallChecker.varInit(this, "this", 565, 19417, 20258);
            CallChecker.varInit(dataElement, "dataElement", 565, 19417, 20258);
            CallChecker.varInit(data, "data", 565, 19417, 20258);
            CallChecker.varInit(this.inverse, "inverse", 565, 19417, 20258);
            CallChecker.varInit(this.entrySet, "entrySet", 565, 19417, 20258);
            CallChecker.varInit(this.valuesSet, "valuesSet", 565, 19417, 20258);
            CallChecker.varInit(this.keySet, "keySet", 565, 19417, 20258);
            CallChecker.varInit(this.modifications, "modifications", 565, 19417, 20258);
            CallChecker.varInit(this.nodeCount, "nodeCount", 565, 19417, 20258);
            CallChecker.varInit(this.rootNode, "rootNode", 565, 19417, 20258);
            TreeBidiMap.Node<K, V> rval = CallChecker.varInit(null, "rval", 566, 19829, 19851);
            TreeBidiMap.Node<K, V> node = CallChecker.init(TreeBidiMap.Node.class);
            if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 567, 19888, 19898)) {
                if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 567, 19879, 19886)) {
                    rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 567, 19879, 19886);
                    node = CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 567, 19879, 19886)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 567, 19888, 19898).ordinal()];
                    CallChecker.varAssign(node, "node", 567, 19888, 19898);
                }
            }
            while (node != null) {
                int cmp = CallChecker.varInit(((int) (TreeBidiMap.compare(((T) (data)), ((T) (node.getData(dataElement)))))), "cmp", 570, 19956, 20014);
                if (cmp == 0) {
                    rval = node;
                    CallChecker.varAssign(rval, "rval", 572, 20060, 20071);
                    break;
                }else {
                    if (cmp < 0) {
                        node = node.getLeft(dataElement);
                        CallChecker.varAssign(node, "node", 575, 20133, 20206);
                    }else {
                        node = node.getRight(dataElement);
                        CallChecker.varAssign(node, "node", 575, 20133, 20206);
                    }
                }
            } 
            return rval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1347.methodEnd();
        }
    }

    private TreeBidiMap.Node<K, V> lookupKey(Object key) {
        MethodContext _bcornu_methode_context1348 = new MethodContext(TreeBidiMap.Node.class);
        try {
            CallChecker.varInit(this, "this", 582, 20265, 20353);
            CallChecker.varInit(key, "key", 582, 20265, 20353);
            CallChecker.varInit(this.inverse, "inverse", 582, 20265, 20353);
            CallChecker.varInit(this.entrySet, "entrySet", 582, 20265, 20353);
            CallChecker.varInit(this.valuesSet, "valuesSet", 582, 20265, 20353);
            CallChecker.varInit(this.keySet, "keySet", 582, 20265, 20353);
            CallChecker.varInit(this.modifications, "modifications", 582, 20265, 20353);
            CallChecker.varInit(this.nodeCount, "nodeCount", 582, 20265, 20353);
            CallChecker.varInit(this.rootNode, "rootNode", 582, 20265, 20353);
            return this.<K>lookup(key, TreeBidiMap.DataElement.KEY);
        } catch (ForceReturn _bcornu_return_t) {
            return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1348.methodEnd();
        }
    }

    private TreeBidiMap.Node<K, V> lookupValue(Object value) {
        MethodContext _bcornu_methode_context1349 = new MethodContext(TreeBidiMap.Node.class);
        try {
            CallChecker.varInit(this, "this", 586, 20360, 20456);
            CallChecker.varInit(value, "value", 586, 20360, 20456);
            CallChecker.varInit(this.inverse, "inverse", 586, 20360, 20456);
            CallChecker.varInit(this.entrySet, "entrySet", 586, 20360, 20456);
            CallChecker.varInit(this.valuesSet, "valuesSet", 586, 20360, 20456);
            CallChecker.varInit(this.keySet, "keySet", 586, 20360, 20456);
            CallChecker.varInit(this.modifications, "modifications", 586, 20360, 20456);
            CallChecker.varInit(this.nodeCount, "nodeCount", 586, 20360, 20456);
            CallChecker.varInit(this.rootNode, "rootNode", 586, 20360, 20456);
            return this.<V>lookup(value, TreeBidiMap.DataElement.VALUE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1349.methodEnd();
        }
    }

    private TreeBidiMap.Node<K, V> nextGreater(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1350 = new MethodContext(TreeBidiMap.Node.class);
        try {
            CallChecker.varInit(this, "this", 597, 20463, 21873);
            CallChecker.varInit(dataElement, "dataElement", 597, 20463, 21873);
            CallChecker.varInit(node, "node", 597, 20463, 21873);
            CallChecker.varInit(this.inverse, "inverse", 597, 20463, 21873);
            CallChecker.varInit(this.entrySet, "entrySet", 597, 20463, 21873);
            CallChecker.varInit(this.valuesSet, "valuesSet", 597, 20463, 21873);
            CallChecker.varInit(this.keySet, "keySet", 597, 20463, 21873);
            CallChecker.varInit(this.modifications, "modifications", 597, 20463, 21873);
            CallChecker.varInit(this.nodeCount, "nodeCount", 597, 20463, 21873);
            CallChecker.varInit(this.rootNode, "rootNode", 597, 20463, 21873);
            TreeBidiMap.Node<K, V> rval = CallChecker.init(TreeBidiMap.Node.class);
            if (node == null) {
                rval = null;
                CallChecker.varAssign(rval, "rval", 600, 20818, 20829);
            }else
                if ((node.getRight(dataElement)) != null) {
                    rval = leastNode(node.getRight(dataElement), dataElement);
                    CallChecker.varAssign(rval, "rval", 604, 21038, 21095);
                }else {
                    TreeBidiMap.Node<K, V> parent = CallChecker.varInit(node.getParent(dataElement), "parent", 612, 21540, 21587);
                    TreeBidiMap.Node<K, V> child = CallChecker.varInit(node, "child", 613, 21601, 21624);
                    parent = CallChecker.beforeCalled(parent, TreeBidiMap.Node.class, 615, 21676, 21681);
                    while ((parent != null) && (child == (CallChecker.isCalled(parent, TreeBidiMap.Node.class, 615, 21676, 21681).getRight(dataElement)))) {
                        child = parent;
                        CallChecker.varAssign(child, "child", 616, 21725, 21739);
                        parent = parent.getParent(dataElement);
                        CallChecker.varAssign(parent, "parent", 617, 21757, 21795);
                    } 
                    rval = parent;
                    CallChecker.varAssign(rval, "rval", 619, 21823, 21836);
                }
            
            return rval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1350.methodEnd();
        }
    }

    private TreeBidiMap.Node<K, V> nextSmaller(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1351 = new MethodContext(TreeBidiMap.Node.class);
        try {
            CallChecker.varInit(this, "this", 631, 21880, 23295);
            CallChecker.varInit(dataElement, "dataElement", 631, 21880, 23295);
            CallChecker.varInit(node, "node", 631, 21880, 23295);
            CallChecker.varInit(this.inverse, "inverse", 631, 21880, 23295);
            CallChecker.varInit(this.entrySet, "entrySet", 631, 21880, 23295);
            CallChecker.varInit(this.valuesSet, "valuesSet", 631, 21880, 23295);
            CallChecker.varInit(this.keySet, "keySet", 631, 21880, 23295);
            CallChecker.varInit(this.modifications, "modifications", 631, 21880, 23295);
            CallChecker.varInit(this.nodeCount, "nodeCount", 631, 21880, 23295);
            CallChecker.varInit(this.rootNode, "rootNode", 631, 21880, 23295);
            TreeBidiMap.Node<K, V> rval = CallChecker.init(TreeBidiMap.Node.class);
            if (node == null) {
                rval = null;
                CallChecker.varAssign(rval, "rval", 634, 22235, 22246);
            }else
                if ((node.getLeft(dataElement)) != null) {
                    rval = greatestNode(node.getLeft(dataElement), dataElement);
                    CallChecker.varAssign(rval, "rval", 638, 22457, 22516);
                }else {
                    TreeBidiMap.Node<K, V> parent = CallChecker.varInit(node.getParent(dataElement), "parent", 646, 22963, 23010);
                    TreeBidiMap.Node<K, V> child = CallChecker.varInit(node, "child", 647, 23024, 23047);
                    parent = CallChecker.beforeCalled(parent, TreeBidiMap.Node.class, 649, 23099, 23104);
                    while ((parent != null) && (child == (CallChecker.isCalled(parent, TreeBidiMap.Node.class, 649, 23099, 23104).getLeft(dataElement)))) {
                        child = parent;
                        CallChecker.varAssign(child, "child", 650, 23147, 23161);
                        parent = parent.getParent(dataElement);
                        CallChecker.varAssign(parent, "parent", 651, 23179, 23217);
                    } 
                    rval = parent;
                    CallChecker.varAssign(rval, "rval", 653, 23245, 23258);
                }
            
            return rval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1351.methodEnd();
        }
    }

    private static <T extends Comparable<T>> int compare(final T o1, final T o2) {
        MethodContext _bcornu_methode_context1352 = new MethodContext(int.class);
        try {
            CallChecker.varInit(o2, "o2", 669, 23302, 23729);
            CallChecker.varInit(o1, "o1", 669, 23302, 23729);
            if (CallChecker.beforeDeref(o1, null, 670, 23707, 23708)) {
                return o1.compareTo(o2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1352.methodEnd();
        }
    }

    private TreeBidiMap.Node<K, V> leastNode(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1353 = new MethodContext(TreeBidiMap.Node.class);
        try {
            CallChecker.varInit(this, "this", 681, 23736, 24310);
            CallChecker.varInit(dataElement, "dataElement", 681, 23736, 24310);
            CallChecker.varInit(node, "node", 681, 23736, 24310);
            CallChecker.varInit(this.inverse, "inverse", 681, 23736, 24310);
            CallChecker.varInit(this.entrySet, "entrySet", 681, 23736, 24310);
            CallChecker.varInit(this.valuesSet, "valuesSet", 681, 23736, 24310);
            CallChecker.varInit(this.keySet, "keySet", 681, 23736, 24310);
            CallChecker.varInit(this.modifications, "modifications", 681, 23736, 24310);
            CallChecker.varInit(this.nodeCount, "nodeCount", 681, 23736, 24310);
            CallChecker.varInit(this.rootNode, "rootNode", 681, 23736, 24310);
            TreeBidiMap.Node<K, V> rval = CallChecker.varInit(node, "rval", 682, 24103, 24125);
            if (rval != null) {
                while ((rval.getLeft(dataElement)) != null) {
                    rval = rval.getLeft(dataElement);
                    CallChecker.varAssign(rval, "rval", 685, 24227, 24259);
                } 
            }
            return rval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1353.methodEnd();
        }
    }

    private TreeBidiMap.Node<K, V> greatestNode(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1354 = new MethodContext(TreeBidiMap.Node.class);
        try {
            CallChecker.varInit(this, "this", 698, 24317, 24858);
            CallChecker.varInit(dataElement, "dataElement", 698, 24317, 24858);
            CallChecker.varInit(node, "node", 698, 24317, 24858);
            CallChecker.varInit(this.inverse, "inverse", 698, 24317, 24858);
            CallChecker.varInit(this.entrySet, "entrySet", 698, 24317, 24858);
            CallChecker.varInit(this.valuesSet, "valuesSet", 698, 24317, 24858);
            CallChecker.varInit(this.keySet, "keySet", 698, 24317, 24858);
            CallChecker.varInit(this.modifications, "modifications", 698, 24317, 24858);
            CallChecker.varInit(this.nodeCount, "nodeCount", 698, 24317, 24858);
            CallChecker.varInit(this.rootNode, "rootNode", 698, 24317, 24858);
            TreeBidiMap.Node<K, V> rval = CallChecker.varInit(node, "rval", 699, 24649, 24671);
            if (rval != null) {
                while ((rval.getRight(dataElement)) != null) {
                    rval = rval.getRight(dataElement);
                    CallChecker.varAssign(rval, "rval", 702, 24774, 24807);
                } 
            }
            return rval;
        } catch (ForceReturn _bcornu_return_t) {
            return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1354.methodEnd();
        }
    }

    private void copyColor(final TreeBidiMap.Node<K, V> from, final TreeBidiMap.Node<K, V> to, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1355 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 716, 24865, 25528);
            CallChecker.varInit(dataElement, "dataElement", 716, 24865, 25528);
            CallChecker.varInit(to, "to", 716, 24865, 25528);
            CallChecker.varInit(from, "from", 716, 24865, 25528);
            CallChecker.varInit(this.inverse, "inverse", 716, 24865, 25528);
            CallChecker.varInit(this.entrySet, "entrySet", 716, 24865, 25528);
            CallChecker.varInit(this.valuesSet, "valuesSet", 716, 24865, 25528);
            CallChecker.varInit(this.keySet, "keySet", 716, 24865, 25528);
            CallChecker.varInit(this.modifications, "modifications", 716, 24865, 25528);
            CallChecker.varInit(this.nodeCount, "nodeCount", 716, 24865, 25528);
            CallChecker.varInit(this.rootNode, "rootNode", 716, 24865, 25528);
            if (to != null) {
                if (from == null) {
                    to.setBlack(dataElement);
                }else {
                    to.copyColor(from, dataElement);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1355.methodEnd();
        }
    }

    private static boolean isRed(final TreeBidiMap.Node<?, ?> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1356 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(dataElement, "dataElement", 734, 25535, 25894);
            CallChecker.varInit(node, "node", 734, 25535, 25894);
            return (node != null) && (CallChecker.isCalled(node, TreeBidiMap.Node.class, 735, 25865, 25868).isRed(dataElement));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1356.methodEnd();
        }
    }

    private static boolean isBlack(final TreeBidiMap.Node<?, ?> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1357 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(dataElement, "dataElement", 745, 25901, 26267);
            CallChecker.varInit(node, "node", 745, 25901, 26267);
            return (node == null) || (CallChecker.isCalled(node, TreeBidiMap.Node.class, 746, 26236, 26239).isBlack(dataElement));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1357.methodEnd();
        }
    }

    private static void makeRed(final TreeBidiMap.Node<?, ?> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1358 = new MethodContext(void.class);
        try {
            CallChecker.varInit(dataElement, "dataElement", 755, 26274, 26596);
            CallChecker.varInit(node, "node", 755, 26274, 26596);
            if (node != null) {
                node.setRed(dataElement);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1358.methodEnd();
        }
    }

    private static void makeBlack(final TreeBidiMap.Node<?, ?> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1359 = new MethodContext(void.class);
        try {
            CallChecker.varInit(dataElement, "dataElement", 767, 26603, 26931);
            CallChecker.varInit(node, "node", 767, 26603, 26931);
            if (node != null) {
                node.setBlack(dataElement);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1359.methodEnd();
        }
    }

    private TreeBidiMap.Node<K, V> getGrandParent(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1360 = new MethodContext(TreeBidiMap.Node.class);
        try {
            CallChecker.varInit(this, "this", 780, 26938, 27337);
            CallChecker.varInit(dataElement, "dataElement", 780, 26938, 27337);
            CallChecker.varInit(node, "node", 780, 26938, 27337);
            CallChecker.varInit(this.inverse, "inverse", 780, 26938, 27337);
            CallChecker.varInit(this.entrySet, "entrySet", 780, 26938, 27337);
            CallChecker.varInit(this.valuesSet, "valuesSet", 780, 26938, 27337);
            CallChecker.varInit(this.keySet, "keySet", 780, 26938, 27337);
            CallChecker.varInit(this.modifications, "modifications", 780, 26938, 27337);
            CallChecker.varInit(this.nodeCount, "nodeCount", 780, 26938, 27337);
            CallChecker.varInit(this.rootNode, "rootNode", 780, 26938, 27337);
            return getParent(getParent(node, dataElement), dataElement);
        } catch (ForceReturn _bcornu_return_t) {
            return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1360.methodEnd();
        }
    }

    private TreeBidiMap.Node<K, V> getParent(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1361 = new MethodContext(TreeBidiMap.Node.class);
        try {
            CallChecker.varInit(this, "this", 791, 27344, 27714);
            CallChecker.varInit(dataElement, "dataElement", 791, 27344, 27714);
            CallChecker.varInit(node, "node", 791, 27344, 27714);
            CallChecker.varInit(this.inverse, "inverse", 791, 27344, 27714);
            CallChecker.varInit(this.entrySet, "entrySet", 791, 27344, 27714);
            CallChecker.varInit(this.valuesSet, "valuesSet", 791, 27344, 27714);
            CallChecker.varInit(this.keySet, "keySet", 791, 27344, 27714);
            CallChecker.varInit(this.modifications, "modifications", 791, 27344, 27714);
            CallChecker.varInit(this.nodeCount, "nodeCount", 791, 27344, 27714);
            CallChecker.varInit(this.rootNode, "rootNode", 791, 27344, 27714);
            if (node == null) {
                return null;
            }else {
                return node.getParent(dataElement);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1361.methodEnd();
        }
    }

    private TreeBidiMap.Node<K, V> getRightChild(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1362 = new MethodContext(TreeBidiMap.Node.class);
        try {
            CallChecker.varInit(this, "this", 802, 27721, 28083);
            CallChecker.varInit(dataElement, "dataElement", 802, 27721, 28083);
            CallChecker.varInit(node, "node", 802, 27721, 28083);
            CallChecker.varInit(this.inverse, "inverse", 802, 27721, 28083);
            CallChecker.varInit(this.entrySet, "entrySet", 802, 27721, 28083);
            CallChecker.varInit(this.valuesSet, "valuesSet", 802, 27721, 28083);
            CallChecker.varInit(this.keySet, "keySet", 802, 27721, 28083);
            CallChecker.varInit(this.modifications, "modifications", 802, 27721, 28083);
            CallChecker.varInit(this.nodeCount, "nodeCount", 802, 27721, 28083);
            CallChecker.varInit(this.rootNode, "rootNode", 802, 27721, 28083);
            if (node == null) {
                return null;
            }else {
                return node.getRight(dataElement);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1362.methodEnd();
        }
    }

    private TreeBidiMap.Node<K, V> getLeftChild(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1363 = new MethodContext(TreeBidiMap.Node.class);
        try {
            CallChecker.varInit(this, "this", 813, 28090, 28449);
            CallChecker.varInit(dataElement, "dataElement", 813, 28090, 28449);
            CallChecker.varInit(node, "node", 813, 28090, 28449);
            CallChecker.varInit(this.inverse, "inverse", 813, 28090, 28449);
            CallChecker.varInit(this.entrySet, "entrySet", 813, 28090, 28449);
            CallChecker.varInit(this.valuesSet, "valuesSet", 813, 28090, 28449);
            CallChecker.varInit(this.keySet, "keySet", 813, 28090, 28449);
            CallChecker.varInit(this.modifications, "modifications", 813, 28090, 28449);
            CallChecker.varInit(this.nodeCount, "nodeCount", 813, 28090, 28449);
            CallChecker.varInit(this.rootNode, "rootNode", 813, 28090, 28449);
            if (node == null) {
                return null;
            }else {
                return node.getLeft(dataElement);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1363.methodEnd();
        }
    }

    private void rotateLeft(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1364 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 823, 28456, 29589);
            CallChecker.varInit(dataElement, "dataElement", 823, 28456, 29589);
            CallChecker.varInit(node, "node", 823, 28456, 29589);
            CallChecker.varInit(this.inverse, "inverse", 823, 28456, 29589);
            CallChecker.varInit(this.entrySet, "entrySet", 823, 28456, 29589);
            CallChecker.varInit(this.valuesSet, "valuesSet", 823, 28456, 29589);
            CallChecker.varInit(this.keySet, "keySet", 823, 28456, 29589);
            CallChecker.varInit(this.modifications, "modifications", 823, 28456, 29589);
            CallChecker.varInit(this.nodeCount, "nodeCount", 823, 28456, 29589);
            CallChecker.varInit(this.rootNode, "rootNode", 823, 28456, 29589);
            TreeBidiMap.Node<K, V> rightChild = CallChecker.init(TreeBidiMap.Node.class);
            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 824, 28745, 28748)) {
                rightChild = CallChecker.isCalled(node, TreeBidiMap.Node.class, 824, 28745, 28748).getRight(dataElement);
                CallChecker.varAssign(rightChild, "rightChild", 824, 28745, 28748);
            }
            if (CallChecker.beforeDeref(rightChild, TreeBidiMap.Node.class, 825, 28795, 28804)) {
                if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 825, 28781, 28784)) {
                    rightChild = CallChecker.beforeCalled(rightChild, TreeBidiMap.Node.class, 825, 28795, 28804);
                    CallChecker.isCalled(node, TreeBidiMap.Node.class, 825, 28781, 28784).setRight(CallChecker.isCalled(rightChild, TreeBidiMap.Node.class, 825, 28795, 28804).getLeft(dataElement), dataElement);
                }
            }
            if (CallChecker.beforeDeref(rightChild, TreeBidiMap.Node.class, 827, 28855, 28864)) {
                rightChild = CallChecker.beforeCalled(rightChild, TreeBidiMap.Node.class, 827, 28855, 28864);
                if ((CallChecker.isCalled(rightChild, TreeBidiMap.Node.class, 827, 28855, 28864).getLeft(dataElement)) != null) {
                    if (CallChecker.beforeDeref(rightChild, TreeBidiMap.Node.class, 828, 28910, 28919)) {
                        rightChild = CallChecker.beforeCalled(rightChild, TreeBidiMap.Node.class, 828, 28910, 28919);
                        CallChecker.isCalled(rightChild, TreeBidiMap.Node.class, 828, 28910, 28919).getLeft(dataElement).setParent(node, dataElement);
                    }
                }
            }
            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 830, 29011, 29014)) {
                if (CallChecker.beforeDeref(rightChild, TreeBidiMap.Node.class, 830, 28990, 28999)) {
                    rightChild = CallChecker.beforeCalled(rightChild, TreeBidiMap.Node.class, 830, 28990, 28999);
                    CallChecker.isCalled(rightChild, TreeBidiMap.Node.class, 830, 28990, 28999).setParent(CallChecker.isCalled(node, TreeBidiMap.Node.class, 830, 29011, 29014).getParent(dataElement), dataElement);
                }
            }
            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 832, 29067, 29070)) {
                if ((CallChecker.isCalled(node, TreeBidiMap.Node.class, 832, 29067, 29070).getParent(dataElement)) == null) {
                    if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 834, 29196, 29206)) {
                        if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 834, 29187, 29194)) {
                            rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 834, 29187, 29194);
                            CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 834, 29187, 29194)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 834, 29196, 29206).ordinal()] = rightChild;
                            CallChecker.varAssign(CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 834, 29187, 29194)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 834, 29196, 29206).ordinal()], "CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 834, 29187, 29194)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 834, 29196, 29206).ordinal()]", 834, 29187, 29231);
                        }
                    }
                }else
                    if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 835, 29252, 29255)) {
                        if ((CallChecker.isCalled(node, TreeBidiMap.Node.class, 835, 29252, 29255).getParent(dataElement).getLeft(dataElement)) == node) {
                            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 836, 29324, 29327)) {
                                CallChecker.isCalled(node, TreeBidiMap.Node.class, 836, 29324, 29327).getParent(dataElement).setLeft(rightChild, dataElement);
                            }
                        }else {
                            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 838, 29415, 29418)) {
                                CallChecker.isCalled(node, TreeBidiMap.Node.class, 838, 29415, 29418).getParent(dataElement).setRight(rightChild, dataElement);
                            }
                        }
                    }
                
            }
            if (CallChecker.beforeDeref(rightChild, TreeBidiMap.Node.class, 841, 29497, 29506)) {
                rightChild = CallChecker.beforeCalled(rightChild, TreeBidiMap.Node.class, 841, 29497, 29506);
                CallChecker.isCalled(rightChild, TreeBidiMap.Node.class, 841, 29497, 29506).setLeft(node, dataElement);
            }
            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 842, 29544, 29547)) {
                CallChecker.isCalled(node, TreeBidiMap.Node.class, 842, 29544, 29547).setParent(rightChild, dataElement);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1364.methodEnd();
        }
    }

    private void rotateRight(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1365 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 851, 29596, 30722);
            CallChecker.varInit(dataElement, "dataElement", 851, 29596, 30722);
            CallChecker.varInit(node, "node", 851, 29596, 30722);
            CallChecker.varInit(this.inverse, "inverse", 851, 29596, 30722);
            CallChecker.varInit(this.entrySet, "entrySet", 851, 29596, 30722);
            CallChecker.varInit(this.valuesSet, "valuesSet", 851, 29596, 30722);
            CallChecker.varInit(this.keySet, "keySet", 851, 29596, 30722);
            CallChecker.varInit(this.modifications, "modifications", 851, 29596, 30722);
            CallChecker.varInit(this.nodeCount, "nodeCount", 851, 29596, 30722);
            CallChecker.varInit(this.rootNode, "rootNode", 851, 29596, 30722);
            TreeBidiMap.Node<K, V> leftChild = CallChecker.init(TreeBidiMap.Node.class);
            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 852, 29886, 29889)) {
                leftChild = CallChecker.isCalled(node, TreeBidiMap.Node.class, 852, 29886, 29889).getLeft(dataElement);
                CallChecker.varAssign(leftChild, "leftChild", 852, 29886, 29889);
            }
            if (CallChecker.beforeDeref(leftChild, TreeBidiMap.Node.class, 853, 29934, 29942)) {
                if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 853, 29921, 29924)) {
                    leftChild = CallChecker.beforeCalled(leftChild, TreeBidiMap.Node.class, 853, 29934, 29942);
                    CallChecker.isCalled(node, TreeBidiMap.Node.class, 853, 29921, 29924).setLeft(CallChecker.isCalled(leftChild, TreeBidiMap.Node.class, 853, 29934, 29942).getRight(dataElement), dataElement);
                }
            }
            if (CallChecker.beforeDeref(leftChild, TreeBidiMap.Node.class, 854, 29993, 30001)) {
                leftChild = CallChecker.beforeCalled(leftChild, TreeBidiMap.Node.class, 854, 29993, 30001);
                if ((CallChecker.isCalled(leftChild, TreeBidiMap.Node.class, 854, 29993, 30001).getRight(dataElement)) != null) {
                    if (CallChecker.beforeDeref(leftChild, TreeBidiMap.Node.class, 855, 30048, 30056)) {
                        leftChild = CallChecker.beforeCalled(leftChild, TreeBidiMap.Node.class, 855, 30048, 30056);
                        CallChecker.isCalled(leftChild, TreeBidiMap.Node.class, 855, 30048, 30056).getRight(dataElement).setParent(node, dataElement);
                    }
                }
            }
            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 857, 30148, 30151)) {
                if (CallChecker.beforeDeref(leftChild, TreeBidiMap.Node.class, 857, 30128, 30136)) {
                    leftChild = CallChecker.beforeCalled(leftChild, TreeBidiMap.Node.class, 857, 30128, 30136);
                    CallChecker.isCalled(leftChild, TreeBidiMap.Node.class, 857, 30128, 30136).setParent(CallChecker.isCalled(node, TreeBidiMap.Node.class, 857, 30148, 30151).getParent(dataElement), dataElement);
                }
            }
            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 859, 30204, 30207)) {
                if ((CallChecker.isCalled(node, TreeBidiMap.Node.class, 859, 30204, 30207).getParent(dataElement)) == null) {
                    if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 861, 30332, 30342)) {
                        if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 861, 30323, 30330)) {
                            rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 861, 30323, 30330);
                            CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 861, 30323, 30330)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 861, 30332, 30342).ordinal()] = leftChild;
                            CallChecker.varAssign(CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 861, 30323, 30330)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 861, 30332, 30342).ordinal()], "CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 861, 30323, 30330)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 861, 30332, 30342).ordinal()]", 861, 30323, 30366);
                        }
                    }
                }else
                    if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 862, 30387, 30390)) {
                        if ((CallChecker.isCalled(node, TreeBidiMap.Node.class, 862, 30387, 30390).getParent(dataElement).getRight(dataElement)) == node) {
                            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 863, 30460, 30463)) {
                                CallChecker.isCalled(node, TreeBidiMap.Node.class, 863, 30460, 30463).getParent(dataElement).setRight(leftChild, dataElement);
                            }
                        }else {
                            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 865, 30551, 30554)) {
                                CallChecker.isCalled(node, TreeBidiMap.Node.class, 865, 30551, 30554).getParent(dataElement).setLeft(leftChild, dataElement);
                            }
                        }
                    }
                
            }
            if (CallChecker.beforeDeref(leftChild, TreeBidiMap.Node.class, 868, 30631, 30639)) {
                leftChild = CallChecker.beforeCalled(leftChild, TreeBidiMap.Node.class, 868, 30631, 30639);
                CallChecker.isCalled(leftChild, TreeBidiMap.Node.class, 868, 30631, 30639).setRight(node, dataElement);
            }
            if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 869, 30678, 30681)) {
                CallChecker.isCalled(node, TreeBidiMap.Node.class, 869, 30678, 30681).setParent(leftChild, dataElement);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1365.methodEnd();
        }
    }

    private void doRedBlackInsert(final TreeBidiMap.Node<K, V> insertedNode, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1366 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 879, 30729, 33770);
            CallChecker.varInit(dataElement, "dataElement", 879, 30729, 33770);
            CallChecker.varInit(insertedNode, "insertedNode", 879, 30729, 33770);
            CallChecker.varInit(this.inverse, "inverse", 879, 30729, 33770);
            CallChecker.varInit(this.entrySet, "entrySet", 879, 30729, 33770);
            CallChecker.varInit(this.valuesSet, "valuesSet", 879, 30729, 33770);
            CallChecker.varInit(this.keySet, "keySet", 879, 30729, 33770);
            CallChecker.varInit(this.modifications, "modifications", 879, 30729, 33770);
            CallChecker.varInit(this.nodeCount, "nodeCount", 879, 30729, 33770);
            CallChecker.varInit(this.rootNode, "rootNode", 879, 30729, 33770);
            TreeBidiMap.Node<K, V> currentNode = CallChecker.varInit(insertedNode, "currentNode", 880, 31083, 31120);
            TreeBidiMap.makeRed(currentNode, dataElement);
            rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 884, 31234, 31241);
            currentNode = CallChecker.beforeCalled(currentNode, TreeBidiMap.Node.class, 885, 31289, 31299);
            while (((currentNode != null) && (currentNode != (CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 884, 31234, 31241)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 884, 31243, 31253).ordinal()]))) && (TreeBidiMap.isRed(CallChecker.isCalled(currentNode, TreeBidiMap.Node.class, 885, 31289, 31299).getParent(dataElement), dataElement))) {
                if (currentNode.isLeftChild(dataElement)) {
                    TreeBidiMap.Node<K, V> y = CallChecker.varInit(getRightChild(getGrandParent(currentNode, dataElement), dataElement), "y", 887, 31414, 31497);
                    if (TreeBidiMap.isRed(y, dataElement)) {
                        TreeBidiMap.makeBlack(getParent(currentNode, dataElement), dataElement);
                        TreeBidiMap.makeBlack(y, dataElement);
                        TreeBidiMap.makeRed(getGrandParent(currentNode, dataElement), dataElement);
                        currentNode = getGrandParent(currentNode, dataElement);
                        CallChecker.varAssign(currentNode, "currentNode", 894, 31778, 31832);
                    }else {
                        if (currentNode.isRightChild(dataElement)) {
                            currentNode = getParent(currentNode, dataElement);
                            CallChecker.varAssign(currentNode, "currentNode", 898, 31981, 32030);
                            rotateLeft(currentNode, dataElement);
                        }
                        TreeBidiMap.makeBlack(getParent(currentNode, dataElement), dataElement);
                        TreeBidiMap.makeRed(getGrandParent(currentNode, dataElement), dataElement);
                        if ((getGrandParent(currentNode, dataElement)) != null) {
                            rotateRight(getGrandParent(currentNode, dataElement), dataElement);
                        }
                    }
                }else {
                    TreeBidiMap.Node<K, V> y = CallChecker.varInit(getLeftChild(getGrandParent(currentNode, dataElement), dataElement), "y", 913, 32600, 32682);
                    if (TreeBidiMap.isRed(y, dataElement)) {
                        TreeBidiMap.makeBlack(getParent(currentNode, dataElement), dataElement);
                        TreeBidiMap.makeBlack(y, dataElement);
                        TreeBidiMap.makeRed(getGrandParent(currentNode, dataElement), dataElement);
                        currentNode = getGrandParent(currentNode, dataElement);
                        CallChecker.varAssign(currentNode, "currentNode", 920, 32963, 33017);
                    }else {
                        if (currentNode.isLeftChild(dataElement)) {
                            currentNode = getParent(currentNode, dataElement);
                            CallChecker.varAssign(currentNode, "currentNode", 924, 33165, 33214);
                            rotateRight(currentNode, dataElement);
                        }
                        TreeBidiMap.makeBlack(getParent(currentNode, dataElement), dataElement);
                        TreeBidiMap.makeRed(getGrandParent(currentNode, dataElement), dataElement);
                        if ((getGrandParent(currentNode, dataElement)) != null) {
                            rotateLeft(getGrandParent(currentNode, dataElement), dataElement);
                        }
                    }
                }
            } 
            if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 939, 33728, 33738)) {
                if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 939, 33719, 33726)) {
                    rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 939, 33719, 33726);
                    TreeBidiMap.makeBlack(CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 939, 33719, 33726)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 939, 33728, 33738).ordinal()], dataElement);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1366.methodEnd();
        }
    }

    private void doRedBlackDelete(final TreeBidiMap.Node<K, V> deletedNode) {
        MethodContext _bcornu_methode_context1367 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 948, 33777, 36527);
            CallChecker.varInit(deletedNode, "deletedNode", 948, 33777, 36527);
            CallChecker.varInit(this.inverse, "inverse", 948, 33777, 36527);
            CallChecker.varInit(this.entrySet, "entrySet", 948, 33777, 36527);
            CallChecker.varInit(this.valuesSet, "valuesSet", 948, 33777, 36527);
            CallChecker.varInit(this.keySet, "keySet", 948, 33777, 36527);
            CallChecker.varInit(this.modifications, "modifications", 948, 33777, 36527);
            CallChecker.varInit(this.nodeCount, "nodeCount", 948, 33777, 36527);
            CallChecker.varInit(this.rootNode, "rootNode", 948, 33777, 36527);
            for (TreeBidiMap.DataElement dataElement : TreeBidiMap.DataElement.values()) {
                if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 952, 34227, 34237)) {
                    if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 952, 34273, 34283)) {
                        if (((CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 952, 34227, 34237).getLeft(dataElement)) != null) && ((CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 952, 34273, 34283).getRight(dataElement)) != null)) {
                            swapPosition(nextGreater(deletedNode, dataElement), deletedNode, dataElement);
                        }
                    }
                }
                TreeBidiMap.Node<K, V> replacement = CallChecker.init(TreeBidiMap.Node.class);
                if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 957, 34484, 34494)) {
                    if ((CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 957, 34484, 34494).getLeft(dataElement)) != null) {
                        if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 957, 34528, 34538)) {
                            replacement = CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 957, 34528, 34538).getLeft(dataElement);
                            CallChecker.varAssign(replacement, "replacement", 957, 34482, 34596);
                        }
                    }else {
                        if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 957, 34563, 34573)) {
                            replacement = CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 957, 34563, 34573).getRight(dataElement);
                            CallChecker.varAssign(replacement, "replacement", 957, 34482, 34596);
                        }
                    }
                }
                if (replacement != null) {
                    if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 960, 34677, 34687)) {
                        replacement.setParent(CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 960, 34677, 34687).getParent(dataElement), dataElement);
                    }
                    if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 962, 34748, 34758)) {
                        if ((CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 962, 34748, 34758).getParent(dataElement)) == null) {
                            if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 963, 34823, 34833)) {
                                if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 963, 34814, 34821)) {
                                    rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 963, 34814, 34821);
                                    CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 963, 34814, 34821)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 963, 34823, 34833).ordinal()] = replacement;
                                    CallChecker.varAssign(CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 963, 34814, 34821)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 963, 34823, 34833).ordinal()], "CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 963, 34814, 34821)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 963, 34823, 34833).ordinal()]", 963, 34814, 34859);
                                }
                            }
                        }else
                            if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 964, 34903, 34913)) {
                                if (deletedNode == (CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 964, 34903, 34913).getParent(dataElement).getLeft(dataElement))) {
                                    if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 965, 34982, 34992)) {
                                        CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 965, 34982, 34992).getParent(dataElement).setLeft(replacement, dataElement);
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 967, 35097, 35107)) {
                                        CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 967, 35097, 35107).getParent(dataElement).setRight(replacement, dataElement);
                                    }
                                }
                            }
                        
                    }
                    if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 970, 35203, 35213)) {
                        CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 970, 35203, 35213).setLeft(null, dataElement);
                    }
                    if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 971, 35259, 35269)) {
                        CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 971, 35259, 35269).setRight(null, dataElement);
                    }
                    if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 972, 35316, 35326)) {
                        CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 972, 35316, 35326).setParent(null, dataElement);
                    }
                    if (TreeBidiMap.isBlack(deletedNode, dataElement)) {
                        doRedBlackDeleteFixup(replacement, dataElement);
                    }
                }else {
                    if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 980, 35584, 35594)) {
                        if ((CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 980, 35584, 35594).getParent(dataElement)) == null) {
                            if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 983, 35694, 35704)) {
                                if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 983, 35685, 35692)) {
                                    rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 983, 35685, 35692);
                                    CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 983, 35685, 35692)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 983, 35694, 35704).ordinal()] = null;
                                    CallChecker.varAssign(CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 983, 35685, 35692)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 983, 35694, 35704).ordinal()], "CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 983, 35685, 35692)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 983, 35694, 35704).ordinal()]", 983, 35685, 35723);
                                }
                            }
                        }else {
                            if (TreeBidiMap.isBlack(deletedNode, dataElement)) {
                                doRedBlackDeleteFixup(deletedNode, dataElement);
                            }
                            if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 991, 35984, 35994)) {
                                if ((CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 991, 35984, 35994).getParent(dataElement)) != null) {
                                    if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 992, 36073, 36083)) {
                                        if (deletedNode == (CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 992, 36073, 36083).getParent(dataElement).getLeft(dataElement))) {
                                            if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 993, 36160, 36170)) {
                                                CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 993, 36160, 36170).getParent(dataElement).setLeft(null, dataElement);
                                            }
                                        }else {
                                            if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 995, 36284, 36294)) {
                                                CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 995, 36284, 36294).getParent(dataElement).setRight(null, dataElement);
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(deletedNode, TreeBidiMap.Node.class, 998, 36399, 36409)) {
                                        CallChecker.isCalled(deletedNode, TreeBidiMap.Node.class, 998, 36399, 36409).setParent(null, dataElement);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            shrink();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1367.methodEnd();
        }
    }

    private void doRedBlackDeleteFixup(final TreeBidiMap.Node<K, V> replacementNode, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1368 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1015, 36534, 40676);
            CallChecker.varInit(dataElement, "dataElement", 1015, 36534, 40676);
            CallChecker.varInit(replacementNode, "replacementNode", 1015, 36534, 40676);
            CallChecker.varInit(this.inverse, "inverse", 1015, 36534, 40676);
            CallChecker.varInit(this.entrySet, "entrySet", 1015, 36534, 40676);
            CallChecker.varInit(this.valuesSet, "valuesSet", 1015, 36534, 40676);
            CallChecker.varInit(this.keySet, "keySet", 1015, 36534, 40676);
            CallChecker.varInit(this.modifications, "modifications", 1015, 36534, 40676);
            CallChecker.varInit(this.nodeCount, "nodeCount", 1015, 36534, 40676);
            CallChecker.varInit(this.rootNode, "rootNode", 1015, 36534, 40676);
            TreeBidiMap.Node<K, V> currentNode = CallChecker.varInit(replacementNode, "currentNode", 1016, 37031, 37071);
            rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 1018, 37105, 37112);
            while ((currentNode != (CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 1018, 37105, 37112)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1018, 37114, 37124).ordinal()])) && (TreeBidiMap.isBlack(currentNode, dataElement))) {
                if (CallChecker.beforeDeref(currentNode, TreeBidiMap.Node.class, 1019, 37196, 37206)) {
                    currentNode = CallChecker.beforeCalled(currentNode, TreeBidiMap.Node.class, 1019, 37196, 37206);
                    if (CallChecker.isCalled(currentNode, TreeBidiMap.Node.class, 1019, 37196, 37206).isLeftChild(dataElement)) {
                        TreeBidiMap.Node<K, V> siblingNode = CallChecker.varInit(getRightChild(getParent(currentNode, dataElement), dataElement), "siblingNode", 1020, 37252, 37340);
                        if (TreeBidiMap.isRed(siblingNode, dataElement)) {
                            TreeBidiMap.makeBlack(siblingNode, dataElement);
                            TreeBidiMap.makeRed(getParent(currentNode, dataElement), dataElement);
                            rotateLeft(getParent(currentNode, dataElement), dataElement);
                            siblingNode = getRightChild(getParent(currentNode, dataElement), dataElement);
                            CallChecker.varAssign(siblingNode, "siblingNode", 1027, 37637, 37714);
                        }
                        if ((TreeBidiMap.isBlack(getLeftChild(siblingNode, dataElement), dataElement)) && (TreeBidiMap.isBlack(getRightChild(siblingNode, dataElement), dataElement))) {
                            TreeBidiMap.makeRed(siblingNode, dataElement);
                            currentNode = getParent(currentNode, dataElement);
                            CallChecker.varAssign(currentNode, "currentNode", 1034, 37980, 38029);
                        }else {
                            if (TreeBidiMap.isBlack(getRightChild(siblingNode, dataElement), dataElement)) {
                                TreeBidiMap.makeBlack(getLeftChild(siblingNode, dataElement), dataElement);
                                TreeBidiMap.makeRed(siblingNode, dataElement);
                                rotateRight(siblingNode, dataElement);
                                siblingNode = getRightChild(getParent(currentNode, dataElement), dataElement);
                                CallChecker.varAssign(siblingNode, "siblingNode", 1041, 38380, 38457);
                            }
                            copyColor(getParent(currentNode, dataElement), siblingNode, dataElement);
                            TreeBidiMap.makeBlack(getParent(currentNode, dataElement), dataElement);
                            TreeBidiMap.makeBlack(getRightChild(siblingNode, dataElement), dataElement);
                            rotateLeft(getParent(currentNode, dataElement), dataElement);
                            if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1049, 38868, 38878)) {
                                if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 1049, 38859, 38866)) {
                                    rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 1049, 38859, 38866);
                                    currentNode = CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 1049, 38859, 38866)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1049, 38868, 38878).ordinal()];
                                    CallChecker.varAssign(currentNode, "currentNode", 1049, 38845, 38890);
                                }
                            }
                        }
                    }else {
                        TreeBidiMap.Node<K, V> siblingNode = CallChecker.varInit(getLeftChild(getParent(currentNode, dataElement), dataElement), "siblingNode", 1052, 38947, 39034);
                        if (TreeBidiMap.isRed(siblingNode, dataElement)) {
                            TreeBidiMap.makeBlack(siblingNode, dataElement);
                            TreeBidiMap.makeRed(getParent(currentNode, dataElement), dataElement);
                            rotateRight(getParent(currentNode, dataElement), dataElement);
                            siblingNode = getLeftChild(getParent(currentNode, dataElement), dataElement);
                            CallChecker.varAssign(siblingNode, "siblingNode", 1059, 39332, 39408);
                        }
                        if ((TreeBidiMap.isBlack(getRightChild(siblingNode, dataElement), dataElement)) && (TreeBidiMap.isBlack(getLeftChild(siblingNode, dataElement), dataElement))) {
                            TreeBidiMap.makeRed(siblingNode, dataElement);
                            currentNode = getParent(currentNode, dataElement);
                            CallChecker.varAssign(currentNode, "currentNode", 1066, 39674, 39723);
                        }else {
                            if (TreeBidiMap.isBlack(getLeftChild(siblingNode, dataElement), dataElement)) {
                                TreeBidiMap.makeBlack(getRightChild(siblingNode, dataElement), dataElement);
                                TreeBidiMap.makeRed(siblingNode, dataElement);
                                rotateLeft(siblingNode, dataElement);
                                siblingNode = getLeftChild(getParent(currentNode, dataElement), dataElement);
                                CallChecker.varAssign(siblingNode, "siblingNode", 1073, 40073, 40149);
                            }
                            copyColor(getParent(currentNode, dataElement), siblingNode, dataElement);
                            TreeBidiMap.makeBlack(getParent(currentNode, dataElement), dataElement);
                            TreeBidiMap.makeBlack(getLeftChild(siblingNode, dataElement), dataElement);
                            rotateRight(getParent(currentNode, dataElement), dataElement);
                            if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1081, 40560, 40570)) {
                                if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 1081, 40551, 40558)) {
                                    rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 1081, 40551, 40558);
                                    currentNode = CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 1081, 40551, 40558)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1081, 40560, 40570).ordinal()];
                                    CallChecker.varAssign(currentNode, "currentNode", 1081, 40537, 40582);
                                }
                            }
                        }
                    }
                }
            } 
            TreeBidiMap.makeBlack(currentNode, dataElement);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1368.methodEnd();
        }
    }

    private void swapPosition(final TreeBidiMap.Node<K, V> x, final TreeBidiMap.Node<K, V> y, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1369 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1098, 40683, 44230);
            CallChecker.varInit(dataElement, "dataElement", 1098, 40683, 44230);
            CallChecker.varInit(y, "y", 1098, 40683, 44230);
            CallChecker.varInit(x, "x", 1098, 40683, 44230);
            CallChecker.varInit(this.inverse, "inverse", 1098, 40683, 44230);
            CallChecker.varInit(this.entrySet, "entrySet", 1098, 40683, 44230);
            CallChecker.varInit(this.valuesSet, "valuesSet", 1098, 40683, 44230);
            CallChecker.varInit(this.keySet, "keySet", 1098, 40683, 44230);
            CallChecker.varInit(this.modifications, "modifications", 1098, 40683, 44230);
            CallChecker.varInit(this.nodeCount, "nodeCount", 1098, 40683, 44230);
            CallChecker.varInit(this.rootNode, "rootNode", 1098, 40683, 44230);
            TreeBidiMap.Node<K, V> xFormerParent = CallChecker.init(TreeBidiMap.Node.class);
            if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1100, 41120, 41120)) {
                xFormerParent = CallChecker.isCalled(x, TreeBidiMap.Node.class, 1100, 41120, 41120).getParent(dataElement);
                CallChecker.varAssign(xFormerParent, "xFormerParent", 1100, 41120, 41120);
            }
            TreeBidiMap.Node<K, V> xFormerLeftChild = CallChecker.init(TreeBidiMap.Node.class);
            if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1101, 41184, 41184)) {
                xFormerLeftChild = CallChecker.isCalled(x, TreeBidiMap.Node.class, 1101, 41184, 41184).getLeft(dataElement);
                CallChecker.varAssign(xFormerLeftChild, "xFormerLeftChild", 1101, 41184, 41184);
            }
            TreeBidiMap.Node<K, V> xFormerRightChild = CallChecker.init(TreeBidiMap.Node.class);
            if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1102, 41247, 41247)) {
                xFormerRightChild = CallChecker.isCalled(x, TreeBidiMap.Node.class, 1102, 41247, 41247).getRight(dataElement);
                CallChecker.varAssign(xFormerRightChild, "xFormerRightChild", 1102, 41247, 41247);
            }
            TreeBidiMap.Node<K, V> yFormerParent = CallChecker.init(TreeBidiMap.Node.class);
            if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1103, 41307, 41307)) {
                yFormerParent = CallChecker.isCalled(y, TreeBidiMap.Node.class, 1103, 41307, 41307).getParent(dataElement);
                CallChecker.varAssign(yFormerParent, "yFormerParent", 1103, 41307, 41307);
            }
            TreeBidiMap.Node<K, V> yFormerLeftChild = CallChecker.init(TreeBidiMap.Node.class);
            if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1104, 41371, 41371)) {
                yFormerLeftChild = CallChecker.isCalled(y, TreeBidiMap.Node.class, 1104, 41371, 41371).getLeft(dataElement);
                CallChecker.varAssign(yFormerLeftChild, "yFormerLeftChild", 1104, 41371, 41371);
            }
            TreeBidiMap.Node<K, V> yFormerRightChild = CallChecker.init(TreeBidiMap.Node.class);
            if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1105, 41434, 41434)) {
                yFormerRightChild = CallChecker.isCalled(y, TreeBidiMap.Node.class, 1105, 41434, 41434).getRight(dataElement);
                CallChecker.varAssign(yFormerRightChild, "yFormerRightChild", 1105, 41434, 41434);
            }
            boolean xWasLeftChild = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1106, 41492, 41492)) {
                if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1106, 41535, 41535)) {
                    final TreeBidiMap.Node<K, V> npe_invocation_var277 = CallChecker.isCalled(x, TreeBidiMap.Node.class, 1106, 41535, 41535).getParent(dataElement);
                    if (CallChecker.beforeDeref(npe_invocation_var277, TreeBidiMap.Node.class, 1106, 41535, 41558)) {
                        xWasLeftChild = ((CallChecker.isCalled(x, TreeBidiMap.Node.class, 1106, 41492, 41492).getParent(dataElement)) != null) && (x == (CallChecker.isCalled(npe_invocation_var277, TreeBidiMap.Node.class, 1106, 41535, 41558).getLeft(dataElement)));
                        CallChecker.varAssign(xWasLeftChild, "xWasLeftChild", 1106, 41492, 41492);
                    }
                }
            }
            boolean yWasLeftChild = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1107, 41616, 41616)) {
                if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1107, 41659, 41659)) {
                    final TreeBidiMap.Node<K, V> npe_invocation_var278 = CallChecker.isCalled(y, TreeBidiMap.Node.class, 1107, 41659, 41659).getParent(dataElement);
                    if (CallChecker.beforeDeref(npe_invocation_var278, TreeBidiMap.Node.class, 1107, 41659, 41682)) {
                        yWasLeftChild = ((CallChecker.isCalled(y, TreeBidiMap.Node.class, 1107, 41616, 41616).getParent(dataElement)) != null) && (y == (CallChecker.isCalled(npe_invocation_var278, TreeBidiMap.Node.class, 1107, 41659, 41682).getLeft(dataElement)));
                        CallChecker.varAssign(yWasLeftChild, "yWasLeftChild", 1107, 41616, 41616);
                    }
                }
            }
            if (x == yFormerParent) {
                if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1111, 41847, 41847)) {
                    CallChecker.isCalled(x, TreeBidiMap.Node.class, 1111, 41847, 41847).setParent(y, dataElement);
                }
                if (yWasLeftChild) {
                    if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1114, 41926, 41926)) {
                        CallChecker.isCalled(y, TreeBidiMap.Node.class, 1114, 41926, 41926).setLeft(x, dataElement);
                    }
                    if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1115, 41969, 41969)) {
                        CallChecker.isCalled(y, TreeBidiMap.Node.class, 1115, 41969, 41969).setRight(xFormerRightChild, dataElement);
                    }
                }else {
                    if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1117, 42050, 42050)) {
                        CallChecker.isCalled(y, TreeBidiMap.Node.class, 1117, 42050, 42050).setRight(x, dataElement);
                    }
                    if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1118, 42094, 42094)) {
                        CallChecker.isCalled(y, TreeBidiMap.Node.class, 1118, 42094, 42094).setLeft(xFormerLeftChild, dataElement);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1121, 42179, 42179)) {
                    CallChecker.isCalled(x, TreeBidiMap.Node.class, 1121, 42179, 42179).setParent(yFormerParent, dataElement);
                }
                if (yFormerParent != null) {
                    if (yWasLeftChild) {
                        yFormerParent.setLeft(x, dataElement);
                    }else {
                        yFormerParent.setRight(x, dataElement);
                    }
                }
                if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1131, 42488, 42488)) {
                    CallChecker.isCalled(y, TreeBidiMap.Node.class, 1131, 42488, 42488).setLeft(xFormerLeftChild, dataElement);
                }
                if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1132, 42542, 42542)) {
                    CallChecker.isCalled(y, TreeBidiMap.Node.class, 1132, 42542, 42542).setRight(xFormerRightChild, dataElement);
                }
            }
            if (y == xFormerParent) {
                if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1136, 42663, 42663)) {
                    CallChecker.isCalled(y, TreeBidiMap.Node.class, 1136, 42663, 42663).setParent(x, dataElement);
                }
                if (xWasLeftChild) {
                    if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1139, 42742, 42742)) {
                        CallChecker.isCalled(x, TreeBidiMap.Node.class, 1139, 42742, 42742).setLeft(y, dataElement);
                    }
                    if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1140, 42785, 42785)) {
                        CallChecker.isCalled(x, TreeBidiMap.Node.class, 1140, 42785, 42785).setRight(yFormerRightChild, dataElement);
                    }
                }else {
                    if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1142, 42866, 42866)) {
                        CallChecker.isCalled(x, TreeBidiMap.Node.class, 1142, 42866, 42866).setRight(y, dataElement);
                    }
                    if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1143, 42910, 42910)) {
                        CallChecker.isCalled(x, TreeBidiMap.Node.class, 1143, 42910, 42910).setLeft(yFormerLeftChild, dataElement);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1146, 42995, 42995)) {
                    CallChecker.isCalled(y, TreeBidiMap.Node.class, 1146, 42995, 42995).setParent(xFormerParent, dataElement);
                }
                if (xFormerParent != null) {
                    if (xWasLeftChild) {
                        xFormerParent.setLeft(y, dataElement);
                    }else {
                        xFormerParent.setRight(y, dataElement);
                    }
                }
                if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1156, 43304, 43304)) {
                    CallChecker.isCalled(x, TreeBidiMap.Node.class, 1156, 43304, 43304).setLeft(yFormerLeftChild, dataElement);
                }
                if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1157, 43358, 43358)) {
                    CallChecker.isCalled(x, TreeBidiMap.Node.class, 1157, 43358, 43358).setRight(yFormerRightChild, dataElement);
                }
            }
            if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1161, 43467, 43467)) {
                if ((CallChecker.isCalled(x, TreeBidiMap.Node.class, 1161, 43467, 43467).getLeft(dataElement)) != null) {
                    if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1162, 43513, 43513)) {
                        CallChecker.isCalled(x, TreeBidiMap.Node.class, 1162, 43513, 43513).getLeft(dataElement).setParent(x, dataElement);
                    }
                }
            }
            if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1165, 43586, 43586)) {
                if ((CallChecker.isCalled(x, TreeBidiMap.Node.class, 1165, 43586, 43586).getRight(dataElement)) != null) {
                    if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1166, 43633, 43633)) {
                        CallChecker.isCalled(x, TreeBidiMap.Node.class, 1166, 43633, 43633).getRight(dataElement).setParent(x, dataElement);
                    }
                }
            }
            if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1169, 43707, 43707)) {
                if ((CallChecker.isCalled(y, TreeBidiMap.Node.class, 1169, 43707, 43707).getLeft(dataElement)) != null) {
                    if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1170, 43753, 43753)) {
                        CallChecker.isCalled(y, TreeBidiMap.Node.class, 1170, 43753, 43753).getLeft(dataElement).setParent(y, dataElement);
                    }
                }
            }
            if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1173, 43826, 43826)) {
                if ((CallChecker.isCalled(y, TreeBidiMap.Node.class, 1173, 43826, 43826).getRight(dataElement)) != null) {
                    if (CallChecker.beforeDeref(y, TreeBidiMap.Node.class, 1174, 43873, 43873)) {
                        CallChecker.isCalled(y, TreeBidiMap.Node.class, 1174, 43873, 43873).getRight(dataElement).setParent(y, dataElement);
                    }
                }
            }
            if (CallChecker.beforeDeref(x, TreeBidiMap.Node.class, 1177, 43943, 43943)) {
                CallChecker.isCalled(x, TreeBidiMap.Node.class, 1177, 43943, 43943).swapColors(y, dataElement);
            }
            if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1180, 44028, 44038)) {
                if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 1180, 44019, 44026)) {
                    rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 1180, 44019, 44026);
                    if ((CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 1180, 44019, 44026)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1180, 44028, 44038).ordinal()]) == x) {
                        if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1181, 44080, 44090)) {
                            if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 1181, 44071, 44078)) {
                                rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 1181, 44071, 44078);
                                CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 1181, 44071, 44078)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1181, 44080, 44090).ordinal()] = y;
                                CallChecker.varAssign(CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 1181, 44071, 44078)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1181, 44080, 44090).ordinal()], "CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 1181, 44071, 44078)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1181, 44080, 44090).ordinal()]", 1181, 44071, 44106);
                            }
                        }
                    }else
                        if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1182, 44136, 44146)) {
                            if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 1182, 44127, 44134)) {
                                rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 1182, 44127, 44134);
                                if ((CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 1182, 44127, 44134)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1182, 44136, 44146).ordinal()]) == y) {
                                    if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1183, 44188, 44198)) {
                                        if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 1183, 44179, 44186)) {
                                            rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 1183, 44179, 44186);
                                            CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 1183, 44179, 44186)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1183, 44188, 44198).ordinal()] = x;
                                            CallChecker.varAssign(CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 1183, 44179, 44186)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1183, 44188, 44198).ordinal()], "CallChecker.isCalled(this.rootNode, TreeBidiMap.Node[].class, 1183, 44179, 44186)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1183, 44188, 44198).ordinal()]", 1183, 44179, 44214);
                                        }
                                    }
                                }
                            }
                        }
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1369.methodEnd();
        }
    }

    private static void checkNonNullComparable(final Object o, final TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1370 = new MethodContext(void.class);
        try {
            CallChecker.varInit(dataElement, "dataElement", 1198, 44237, 44966);
            CallChecker.varInit(o, "o", 1198, 44237, 44966);
            if (o == null) {
                throw new NullPointerException((dataElement + " cannot be null"));
            }
            if (!(o instanceof Comparable)) {
                throw new ClassCastException((dataElement + " must be Comparable"));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1370.methodEnd();
        }
    }

    private static void checkKey(final Object key) {
        MethodContext _bcornu_methode_context1371 = new MethodContext(void.class);
        try {
            CallChecker.varInit(key, "key", 1215, 44973, 45317);
            TreeBidiMap.checkNonNullComparable(key, TreeBidiMap.DataElement.KEY);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1371.methodEnd();
        }
    }

    private static void checkValue(final Object value) {
        MethodContext _bcornu_methode_context1372 = new MethodContext(void.class);
        try {
            CallChecker.varInit(value, "value", 1227, 45324, 45686);
            TreeBidiMap.checkNonNullComparable(value, TreeBidiMap.DataElement.VALUE);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1372.methodEnd();
        }
    }

    private static void checkKeyAndValue(final Object key, final Object value) {
        MethodContext _bcornu_methode_context1373 = new MethodContext(void.class);
        try {
            CallChecker.varInit(value, "value", 1241, 45693, 46154);
            CallChecker.varInit(key, "key", 1241, 45693, 46154);
            TreeBidiMap.checkKey(key);
            TreeBidiMap.checkValue(value);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1373.methodEnd();
        }
    }

    private void modify() {
        MethodContext _bcornu_methode_context1374 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1251, 46161, 46420);
            CallChecker.varInit(this.inverse, "inverse", 1251, 46161, 46420);
            CallChecker.varInit(this.entrySet, "entrySet", 1251, 46161, 46420);
            CallChecker.varInit(this.valuesSet, "valuesSet", 1251, 46161, 46420);
            CallChecker.varInit(this.keySet, "keySet", 1251, 46161, 46420);
            CallChecker.varInit(this.modifications, "modifications", 1251, 46161, 46420);
            CallChecker.varInit(this.nodeCount, "nodeCount", 1251, 46161, 46420);
            CallChecker.varInit(this.rootNode, "rootNode", 1251, 46161, 46420);
            (modifications)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1374.methodEnd();
        }
    }

    private void grow() {
        MethodContext _bcornu_methode_context1375 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1258, 46427, 46566);
            CallChecker.varInit(this.inverse, "inverse", 1258, 46427, 46566);
            CallChecker.varInit(this.entrySet, "entrySet", 1258, 46427, 46566);
            CallChecker.varInit(this.valuesSet, "valuesSet", 1258, 46427, 46566);
            CallChecker.varInit(this.keySet, "keySet", 1258, 46427, 46566);
            CallChecker.varInit(this.modifications, "modifications", 1258, 46427, 46566);
            CallChecker.varInit(this.nodeCount, "nodeCount", 1258, 46427, 46566);
            CallChecker.varInit(this.rootNode, "rootNode", 1258, 46427, 46566);
            modify();
            (nodeCount)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1375.methodEnd();
        }
    }

    private void shrink() {
        MethodContext _bcornu_methode_context1376 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1266, 46573, 46716);
            CallChecker.varInit(this.inverse, "inverse", 1266, 46573, 46716);
            CallChecker.varInit(this.entrySet, "entrySet", 1266, 46573, 46716);
            CallChecker.varInit(this.valuesSet, "valuesSet", 1266, 46573, 46716);
            CallChecker.varInit(this.keySet, "keySet", 1266, 46573, 46716);
            CallChecker.varInit(this.modifications, "modifications", 1266, 46573, 46716);
            CallChecker.varInit(this.nodeCount, "nodeCount", 1266, 46573, 46716);
            CallChecker.varInit(this.rootNode, "rootNode", 1266, 46573, 46716);
            modify();
            (nodeCount)--;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1376.methodEnd();
        }
    }

    private void insertValue(final TreeBidiMap.Node<K, V> newNode) throws IllegalArgumentException {
        MethodContext _bcornu_methode_context1377 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1279, 46723, 48128);
            CallChecker.varInit(newNode, "newNode", 1279, 46723, 48128);
            CallChecker.varInit(this.inverse, "inverse", 1279, 46723, 48128);
            CallChecker.varInit(this.entrySet, "entrySet", 1279, 46723, 48128);
            CallChecker.varInit(this.valuesSet, "valuesSet", 1279, 46723, 48128);
            CallChecker.varInit(this.keySet, "keySet", 1279, 46723, 48128);
            CallChecker.varInit(this.modifications, "modifications", 1279, 46723, 48128);
            CallChecker.varInit(this.nodeCount, "nodeCount", 1279, 46723, 48128);
            CallChecker.varInit(this.rootNode, "rootNode", 1279, 46723, 48128);
            TreeBidiMap.Node<K, V> node = CallChecker.init(TreeBidiMap.Node.class);
            if (CallChecker.beforeDeref(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 1280, 47084, 47088)) {
                if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 1280, 47075, 47082)) {
                    rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 1280, 47075, 47082);
                    node = CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 1280, 47075, 47082)[CallChecker.isCalled(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 1280, 47084, 47088).ordinal()];
                    CallChecker.varAssign(node, "node", 1280, 47084, 47088);
                }
            }
            while (true) {
                int cmp = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(newNode, TreeBidiMap.Node.class, 1283, 47156, 47162)) {
                    if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1283, 47176, 47179)) {
                        cmp = TreeBidiMap.compare(newNode.getValue(), node.getValue());
                        CallChecker.varAssign(cmp, "cmp", 1283, 47156, 47162);
                    }
                }
                if (cmp == 0) {
                    if (CallChecker.beforeDeref(newNode, TreeBidiMap.Node.class, 1287, 47334, 47340)) {
                        throw new IllegalArgumentException((("Cannot store a duplicate value (\"" + (CallChecker.isCalled(newNode, TreeBidiMap.Node.class, 1287, 47334, 47340).getData(TreeBidiMap.DataElement.VALUE))) + "\") in this Map"));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    if (cmp < 0) {
                        if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1289, 47433, 47436)) {
                            node = CallChecker.beforeCalled(node, TreeBidiMap.Node.class, 1289, 47433, 47436);
                            if ((CallChecker.isCalled(node, TreeBidiMap.Node.class, 1289, 47433, 47436).getLeft(TreeBidiMap.DataElement.VALUE)) != null) {
                                if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1290, 47491, 47494)) {
                                    node = CallChecker.beforeCalled(node, TreeBidiMap.Node.class, 1290, 47491, 47494);
                                    node = CallChecker.isCalled(node, TreeBidiMap.Node.class, 1290, 47491, 47494).getLeft(TreeBidiMap.DataElement.VALUE);
                                    CallChecker.varAssign(node, "node", 1290, 47484, 47510);
                                }
                            }else {
                                if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1292, 47557, 47560)) {
                                    node = CallChecker.beforeCalled(node, TreeBidiMap.Node.class, 1292, 47557, 47560);
                                    CallChecker.isCalled(node, TreeBidiMap.Node.class, 1292, 47557, 47560).setLeft(newNode, TreeBidiMap.DataElement.VALUE);
                                }
                                if (CallChecker.beforeDeref(newNode, TreeBidiMap.Node.class, 1293, 47607, 47613)) {
                                    CallChecker.isCalled(newNode, TreeBidiMap.Node.class, 1293, 47607, 47613).setParent(node, TreeBidiMap.DataElement.VALUE);
                                }
                                doRedBlackInsert(newNode, TreeBidiMap.DataElement.VALUE);
                                break;
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1299, 47791, 47794)) {
                            node = CallChecker.beforeCalled(node, TreeBidiMap.Node.class, 1299, 47791, 47794);
                            if ((CallChecker.isCalled(node, TreeBidiMap.Node.class, 1299, 47791, 47794).getRight(TreeBidiMap.DataElement.VALUE)) != null) {
                                if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1300, 47850, 47853)) {
                                    node = CallChecker.beforeCalled(node, TreeBidiMap.Node.class, 1300, 47850, 47853);
                                    node = CallChecker.isCalled(node, TreeBidiMap.Node.class, 1300, 47850, 47853).getRight(TreeBidiMap.DataElement.VALUE);
                                    CallChecker.varAssign(node, "node", 1300, 47843, 47870);
                                }
                            }else {
                                if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1302, 47917, 47920)) {
                                    node = CallChecker.beforeCalled(node, TreeBidiMap.Node.class, 1302, 47917, 47920);
                                    CallChecker.isCalled(node, TreeBidiMap.Node.class, 1302, 47917, 47920).setRight(newNode, TreeBidiMap.DataElement.VALUE);
                                }
                                if (CallChecker.beforeDeref(newNode, TreeBidiMap.Node.class, 1303, 47968, 47974)) {
                                    CallChecker.isCalled(newNode, TreeBidiMap.Node.class, 1303, 47968, 47974).setParent(node, TreeBidiMap.DataElement.VALUE);
                                }
                                doRedBlackInsert(newNode, TreeBidiMap.DataElement.VALUE);
                                break;
                            }
                        }
                    }
                
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1377.methodEnd();
        }
    }

    private boolean doEquals(Object obj, TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1378 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1320, 48135, 49294);
            CallChecker.varInit(dataElement, "dataElement", 1320, 48135, 49294);
            CallChecker.varInit(obj, "obj", 1320, 48135, 49294);
            CallChecker.varInit(this.inverse, "inverse", 1320, 48135, 49294);
            CallChecker.varInit(this.entrySet, "entrySet", 1320, 48135, 49294);
            CallChecker.varInit(this.valuesSet, "valuesSet", 1320, 48135, 49294);
            CallChecker.varInit(this.keySet, "keySet", 1320, 48135, 49294);
            CallChecker.varInit(this.modifications, "modifications", 1320, 48135, 49294);
            CallChecker.varInit(this.nodeCount, "nodeCount", 1320, 48135, 49294);
            CallChecker.varInit(this.rootNode, "rootNode", 1320, 48135, 49294);
            if (obj == (this)) {
                return true;
            }
            if ((obj instanceof Map) == false) {
                return false;
            }
            Map<?, ?> other = CallChecker.varInit(((Map<?, ?>) (obj)), "other", 1327, 48606, 48639);
            if (CallChecker.beforeDeref(other, Map.class, 1328, 48653, 48657)) {
                other = CallChecker.beforeCalled(other, Map.class, 1328, 48653, 48657);
                if ((CallChecker.isCalled(other, Map.class, 1328, 48653, 48657).size()) != (size())) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((nodeCount) > 0) {
                TryContext _bcornu_try_context_19 = new TryContext(19, TreeBidiMap.class, "java.lang.ClassCastException", "java.lang.NullPointerException");
                try {
                    for (MapIterator<?, ?> it = getMapIterator(dataElement); CallChecker.isCalled(it, MapIterator.class, 1334, 48836, 48837).hasNext();) {
                        Object key = CallChecker.init(Object.class);
                        if (CallChecker.beforeDeref(it, MapIterator.class, 1335, 48887, 48888)) {
                            key = it.next();
                            CallChecker.varAssign(key, "key", 1335, 48887, 48888);
                        }
                        Object value = CallChecker.init(Object.class);
                        if (CallChecker.beforeDeref(it, MapIterator.class, 1336, 48933, 48934)) {
                            value = it.getValue();
                            CallChecker.varAssign(value, "value", 1336, 48933, 48934);
                        }
                        if (CallChecker.beforeDeref(other, Map.class, 1337, 48985, 48989)) {
                            if (CallChecker.beforeDeref(value, Object.class, 1337, 48972, 48976)) {
                                value = CallChecker.beforeCalled(value, Object.class, 1337, 48972, 48976);
                                if ((CallChecker.isCalled(value, Object.class, 1337, 48972, 48976).equals(other.get(key))) == false) {
                                    return false;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                } catch (ClassCastException ex) {
                    _bcornu_try_context_19.catchStart(19);
                    return false;
                } catch (NullPointerException ex) {
                    _bcornu_try_context_19.catchStart(19);
                    return false;
                } finally {
                    _bcornu_try_context_19.finallyStart(19);
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1378.methodEnd();
        }
    }

    private int doHashCode(TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1379 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1356, 49301, 49861);
            CallChecker.varInit(dataElement, "dataElement", 1356, 49301, 49861);
            CallChecker.varInit(this.inverse, "inverse", 1356, 49301, 49861);
            CallChecker.varInit(this.entrySet, "entrySet", 1356, 49301, 49861);
            CallChecker.varInit(this.valuesSet, "valuesSet", 1356, 49301, 49861);
            CallChecker.varInit(this.keySet, "keySet", 1356, 49301, 49861);
            CallChecker.varInit(this.modifications, "modifications", 1356, 49301, 49861);
            CallChecker.varInit(this.nodeCount, "nodeCount", 1356, 49301, 49861);
            CallChecker.varInit(this.rootNode, "rootNode", 1356, 49301, 49861);
            int total = CallChecker.varInit(((int) (0)), "total", 1357, 49532, 49545);
            if ((nodeCount) > 0) {
                for (MapIterator<?, ?> it = getMapIterator(dataElement); CallChecker.isCalled(it, MapIterator.class, 1359, 49645, 49646).hasNext();) {
                    Object key = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(it, MapIterator.class, 1360, 49692, 49693)) {
                        key = it.next();
                        CallChecker.varAssign(key, "key", 1360, 49692, 49693);
                    }
                    Object value = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(it, MapIterator.class, 1361, 49734, 49735)) {
                        value = it.getValue();
                        CallChecker.varAssign(value, "value", 1361, 49734, 49735);
                    }
                    if (CallChecker.beforeDeref(key, Object.class, 1362, 49775, 49777)) {
                        if (CallChecker.beforeDeref(value, Object.class, 1362, 49792, 49796)) {
                            key = CallChecker.beforeCalled(key, Object.class, 1362, 49775, 49777);
                            value = CallChecker.beforeCalled(value, Object.class, 1362, 49792, 49796);
                            total += (CallChecker.isCalled(key, Object.class, 1362, 49775, 49777).hashCode()) ^ (CallChecker.isCalled(value, Object.class, 1362, 49792, 49796).hashCode());
                            CallChecker.varAssign(total, "total", 1362, 49765, 49809);
                        }
                    }
                }
            }
            return total;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1379.methodEnd();
        }
    }

    private String doToString(TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1380 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1374, 49868, 50775);
            CallChecker.varInit(dataElement, "dataElement", 1374, 49868, 50775);
            CallChecker.varInit(this.inverse, "inverse", 1374, 49868, 50775);
            CallChecker.varInit(this.entrySet, "entrySet", 1374, 49868, 50775);
            CallChecker.varInit(this.valuesSet, "valuesSet", 1374, 49868, 50775);
            CallChecker.varInit(this.keySet, "keySet", 1374, 49868, 50775);
            CallChecker.varInit(this.modifications, "modifications", 1374, 49868, 50775);
            CallChecker.varInit(this.nodeCount, "nodeCount", 1374, 49868, 50775);
            CallChecker.varInit(this.rootNode, "rootNode", 1374, 49868, 50775);
            if ((nodeCount) == 0) {
                return "{}";
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(((nodeCount) * 32)), "buf", 1378, 50161, 50214);
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 1379, 50224, 50226)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1379, 50224, 50226);
                CallChecker.isCalled(buf, StringBuilder.class, 1379, 50224, 50226).append('{');
            }
            MapIterator<?, ?> it = CallChecker.varInit(getMapIterator(dataElement), "it", 1380, 50249, 50299);
            boolean hasNext = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(it, MapIterator.class, 1381, 50327, 50328)) {
                it = CallChecker.beforeCalled(it, MapIterator.class, 1381, 50327, 50328);
                hasNext = CallChecker.isCalled(it, MapIterator.class, 1381, 50327, 50328).hasNext();
                CallChecker.varAssign(hasNext, "hasNext", 1381, 50327, 50328);
            }
            while (hasNext) {
                Object key = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(it, MapIterator.class, 1383, 50392, 50393)) {
                    key = it.next();
                    CallChecker.varAssign(key, "key", 1383, 50392, 50393);
                }
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(it, MapIterator.class, 1384, 50430, 50431)) {
                    value = it.getValue();
                    CallChecker.varAssign(value, "value", 1384, 50430, 50431);
                }
                if (value == (this)) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 1385, 50457, 50459)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1385, 50457, 50459);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(buf, StringBuilder.class, 1385, 50457, 50459).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1385, 50457, 50500)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1385, 50457, 50459);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 1385, 50457, 50459).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1385, 50457, 50500).append('='), StringBuilder.class, 1385, 50457, 50528)) {
                                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1385, 50457, 50459);
                                CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 1385, 50457, 50459).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1385, 50457, 50500).append('='), StringBuilder.class, 1385, 50457, 50528).append("(this Map)");
                            }
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 1385, 50457, 50459)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1385, 50457, 50459);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(buf, StringBuilder.class, 1385, 50457, 50459).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1385, 50457, 50500)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1385, 50457, 50459);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 1385, 50457, 50459).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1385, 50457, 50500).append('='), StringBuilder.class, 1385, 50457, 50528)) {
                                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1385, 50457, 50459);
                                CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 1385, 50457, 50459).append((key == (this) ? "(this Map)" : key)), StringBuilder.class, 1385, 50457, 50500).append('='), StringBuilder.class, 1385, 50457, 50528).append(value);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(it, MapIterator.class, 1389, 50615, 50616)) {
                    it = CallChecker.beforeCalled(it, MapIterator.class, 1389, 50615, 50616);
                    hasNext = CallChecker.isCalled(it, MapIterator.class, 1389, 50615, 50616).hasNext();
                    CallChecker.varAssign(hasNext, "hasNext", 1389, 50605, 50627);
                }
                if (hasNext) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 1391, 50672, 50674)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1391, 50672, 50674);
                        CallChecker.isCalled(buf, StringBuilder.class, 1391, 50672, 50674).append(", ");
                    }
                }
            } 
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 1395, 50723, 50725)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1395, 50723, 50725);
                CallChecker.isCalled(buf, StringBuilder.class, 1395, 50723, 50725).append('}');
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 1396, 50755, 50757)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1396, 50755, 50757);
                return CallChecker.isCalled(buf, StringBuilder.class, 1396, 50755, 50757).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1380.methodEnd();
        }
    }

    private MapIterator<?, ?> getMapIterator(TreeBidiMap.DataElement dataElement) {
        MethodContext _bcornu_methode_context1381 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 1399, 50782, 51099);
            CallChecker.varInit(dataElement, "dataElement", 1399, 50782, 51099);
            CallChecker.varInit(this.inverse, "inverse", 1399, 50782, 51099);
            CallChecker.varInit(this.entrySet, "entrySet", 1399, 50782, 51099);
            CallChecker.varInit(this.valuesSet, "valuesSet", 1399, 50782, 51099);
            CallChecker.varInit(this.keySet, "keySet", 1399, 50782, 51099);
            CallChecker.varInit(this.modifications, "modifications", 1399, 50782, 51099);
            CallChecker.varInit(this.nodeCount, "nodeCount", 1399, 50782, 51099);
            CallChecker.varInit(this.rootNode, "rootNode", 1399, 50782, 51099);
            switch (dataElement) {
                case KEY :
                    return new ViewMapIterator(TreeBidiMap.DataElement.KEY);
                case VALUE :
                    return new InverseViewMapIterator(TreeBidiMap.DataElement.VALUE);
                default :
                    throw new IllegalArgumentException();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<?, ?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1381.methodEnd();
        }
    }

    abstract class View<E> extends AbstractSet<E> {
        protected final TreeBidiMap.DataElement orderType;

        View(final TreeBidiMap.DataElement orderType) {
            super();
            MethodContext _bcornu_methode_context264 = new MethodContext(null);
            try {
                this.orderType = orderType;
                CallChecker.varAssign(this.orderType, "this.orderType", 1426, 51603, 51629);
            } finally {
                _bcornu_methode_context264.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context1382 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 1430, 51650, 51740);
                CallChecker.varInit(this.orderType, "orderType", 1430, 51650, 51740);
                return TreeBidiMap.this.size();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1382.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context1383 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1435, 51751, 51837);
                CallChecker.varInit(this.orderType, "orderType", 1435, 51751, 51837);
                TreeBidiMap.this.clear();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1383.methodEnd();
            }
        }
    }

    class KeyView extends TreeBidiMap<K, V>.View<K> {
        public KeyView(TreeBidiMap.DataElement orderType) {
            super(orderType);
            MethodContext _bcornu_methode_context265 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context265.methodEnd();
            }
        }

        @Override
        public Iterator<K> iterator() {
            MethodContext _bcornu_methode_context1384 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 1450, 52049, 52158);
                CallChecker.varInit(this.orderType, "orderType", 1450, 52049, 52158);
                return new ViewMapIterator(orderType);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1384.methodEnd();
            }
        }

        @Override
        public boolean contains(final Object obj) {
            MethodContext _bcornu_methode_context1385 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1455, 52169, 52330);
                CallChecker.varInit(obj, "obj", 1455, 52169, 52330);
                CallChecker.varInit(this.orderType, "orderType", 1455, 52169, 52330);
                TreeBidiMap.checkNonNullComparable(obj, TreeBidiMap.DataElement.KEY);
                return (lookupKey(obj)) != null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1385.methodEnd();
            }
        }

        @Override
        public boolean remove(Object o) {
            MethodContext _bcornu_methode_context1386 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1461, 52341, 52444);
                CallChecker.varInit(o, "o", 1461, 52341, 52444);
                CallChecker.varInit(this.orderType, "orderType", 1461, 52341, 52444);
                return (doRemoveKey(o)) != null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1386.methodEnd();
            }
        }
    }

    class ValueView extends TreeBidiMap<K, V>.View<V> {
        public ValueView(TreeBidiMap.DataElement orderType) {
            super(orderType);
            MethodContext _bcornu_methode_context266 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context266.methodEnd();
            }
        }

        @Override
        public Iterator<V> iterator() {
            MethodContext _bcornu_methode_context1387 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 1477, 52663, 52779);
                CallChecker.varInit(this.orderType, "orderType", 1477, 52663, 52779);
                return new InverseViewMapIterator(orderType);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1387.methodEnd();
            }
        }

        @Override
        public boolean contains(final Object obj) {
            MethodContext _bcornu_methode_context1388 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1482, 52790, 52955);
                CallChecker.varInit(obj, "obj", 1482, 52790, 52955);
                CallChecker.varInit(this.orderType, "orderType", 1482, 52790, 52955);
                TreeBidiMap.checkNonNullComparable(obj, TreeBidiMap.DataElement.VALUE);
                return (lookupValue(obj)) != null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1388.methodEnd();
            }
        }

        @Override
        public boolean remove(Object o) {
            MethodContext _bcornu_methode_context1389 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1488, 52966, 53071);
                CallChecker.varInit(o, "o", 1488, 52966, 53071);
                CallChecker.varInit(this.orderType, "orderType", 1488, 52966, 53071);
                return (doRemoveValue(o)) != null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1389.methodEnd();
            }
        }
    }

    class EntryView extends TreeBidiMap<K, V>.View<Map.Entry<K, V>> {
        EntryView() {
            super(TreeBidiMap.DataElement.KEY);
            MethodContext _bcornu_methode_context267 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context267.methodEnd();
            }
        }

        @Override
        public boolean contains(Object obj) {
            MethodContext _bcornu_methode_context1390 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1504, 53242, 53630);
                CallChecker.varInit(obj, "obj", 1504, 53242, 53630);
                CallChecker.varInit(this.orderType, "orderType", 1504, 53242, 53630);
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                Map.Entry<?, ?> entry = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "entry", 1508, 53407, 53452);
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1509, 53481, 53485)) {
                    value = entry.getValue();
                    CallChecker.varAssign(value, "value", 1509, 53481, 53485);
                }
                TreeBidiMap.Node<K, V> node = CallChecker.init(TreeBidiMap.Node.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1510, 53539, 53543)) {
                    node = lookupKey(entry.getKey());
                    CallChecker.varAssign(node, "node", 1510, 53539, 53543);
                }
                if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1511, 53591, 53594)) {
                    return (node != null) && (node.getValue().equals(value));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1390.methodEnd();
            }
        }

        @Override
        public boolean remove(Object obj) {
            MethodContext _bcornu_methode_context1391 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1515, 53641, 54135);
                CallChecker.varInit(obj, "obj", 1515, 53641, 54135);
                CallChecker.varInit(this.orderType, "orderType", 1515, 53641, 54135);
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                Map.Entry<?, ?> entry = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "entry", 1519, 53804, 53849);
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1520, 53878, 53882)) {
                    value = entry.getValue();
                    CallChecker.varAssign(value, "value", 1520, 53878, 53882);
                }
                TreeBidiMap.Node<K, V> node = CallChecker.init(TreeBidiMap.Node.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1521, 53936, 53940)) {
                    node = lookupKey(entry.getKey());
                    CallChecker.varAssign(node, "node", 1521, 53936, 53940);
                }
                final Comparable<V> npe_invocation_var279 = node.getValue();
                if (CallChecker.beforeDeref(npe_invocation_var279, Comparable.class, 1522, 53985, 53999)) {
                    if ((node != null) && (CallChecker.isCalled(npe_invocation_var279, Comparable.class, 1522, 53985, 53999).equals(value))) {
                        doRedBlackDelete(node);
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1391.methodEnd();
            }
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            MethodContext _bcornu_methode_context1392 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 1530, 54146, 54275);
                CallChecker.varInit(this.orderType, "orderType", 1530, 54146, 54275);
                return new ViewMapEntryIterator();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1392.methodEnd();
            }
        }
    }

    class InverseEntryView extends TreeBidiMap<K, V>.View<Map.Entry<V, K>> {
        InverseEntryView() {
            super(TreeBidiMap.DataElement.VALUE);
            MethodContext _bcornu_methode_context268 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context268.methodEnd();
            }
        }

        @Override
        public boolean contains(Object obj) {
            MethodContext _bcornu_methode_context1393 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1545, 54461, 54849);
                CallChecker.varInit(obj, "obj", 1545, 54461, 54849);
                CallChecker.varInit(this.orderType, "orderType", 1545, 54461, 54849);
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                Map.Entry<?, ?> entry = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "entry", 1549, 54626, 54671);
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1550, 54700, 54704)) {
                    value = entry.getValue();
                    CallChecker.varAssign(value, "value", 1550, 54700, 54704);
                }
                TreeBidiMap.Node<K, V> node = CallChecker.init(TreeBidiMap.Node.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1551, 54760, 54764)) {
                    node = lookupValue(entry.getKey());
                    CallChecker.varAssign(node, "node", 1551, 54760, 54764);
                }
                if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1552, 54812, 54815)) {
                    return (node != null) && (node.getKey().equals(value));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1393.methodEnd();
            }
        }

        @Override
        public boolean remove(Object obj) {
            MethodContext _bcornu_methode_context1394 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1556, 54860, 55354);
                CallChecker.varInit(obj, "obj", 1556, 54860, 55354);
                CallChecker.varInit(this.orderType, "orderType", 1556, 54860, 55354);
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                Map.Entry<?, ?> entry = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "entry", 1560, 55023, 55068);
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1561, 55097, 55101)) {
                    value = entry.getValue();
                    CallChecker.varAssign(value, "value", 1561, 55097, 55101);
                }
                TreeBidiMap.Node<K, V> node = CallChecker.init(TreeBidiMap.Node.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1562, 55157, 55161)) {
                    node = lookupValue(entry.getKey());
                    CallChecker.varAssign(node, "node", 1562, 55157, 55161);
                }
                final Comparable<K> npe_invocation_var280 = node.getKey();
                if (CallChecker.beforeDeref(npe_invocation_var280, Comparable.class, 1563, 55206, 55218)) {
                    if ((node != null) && (CallChecker.isCalled(npe_invocation_var280, Comparable.class, 1563, 55206, 55218).equals(value))) {
                        doRedBlackDelete(node);
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1394.methodEnd();
            }
        }

        @Override
        public Iterator<Map.Entry<V, K>> iterator() {
            MethodContext _bcornu_methode_context1395 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 1571, 55365, 55501);
                CallChecker.varInit(this.orderType, "orderType", 1571, 55365, 55501);
                return new InverseViewMapEntryIterator();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<Map.Entry<V, K>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1395.methodEnd();
            }
        }
    }

    abstract class ViewIterator {
        protected final TreeBidiMap.DataElement orderType;

        protected TreeBidiMap.Node<K, V> lastReturnedNode;

        protected TreeBidiMap.Node<K, V> nextNode;

        protected TreeBidiMap.Node<K, V> previousNode;

        private int expectedModifications;

        ViewIterator(final TreeBidiMap.DataElement orderType) {
            super();
            MethodContext _bcornu_methode_context269 = new MethodContext(null);
            try {
                this.orderType = orderType;
                CallChecker.varAssign(this.orderType, "this.orderType", 1600, 56409, 56435);
                expectedModifications = modifications;
                CallChecker.varAssign(this.expectedModifications, "this.expectedModifications", 1601, 56449, 56486);
                if (CallChecker.beforeDeref(orderType, TreeBidiMap.DataElement.class, 1602, 56530, 56538)) {
                    if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 1602, 56521, 56528)) {
                        rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 1602, 56521, 56528);
                        nextNode = leastNode(CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 1602, 56521, 56528)[CallChecker.isCalled(orderType, TreeBidiMap.DataElement.class, 1602, 56530, 56538).ordinal()], orderType);
                        CallChecker.varAssign(this.nextNode, "this.nextNode", 1602, 56500, 56562);
                    }
                }
                lastReturnedNode = null;
                CallChecker.varAssign(this.lastReturnedNode, "this.lastReturnedNode", 1603, 56576, 56599);
                previousNode = null;
                CallChecker.varAssign(this.previousNode, "this.previousNode", 1604, 56613, 56632);
            } finally {
                _bcornu_methode_context269.methodEnd();
            }
        }

        public final boolean hasNext() {
            MethodContext _bcornu_methode_context1396 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1607, 56653, 56731);
                CallChecker.varInit(this.expectedModifications, "expectedModifications", 1607, 56653, 56731);
                CallChecker.varInit(this.previousNode, "previousNode", 1607, 56653, 56731);
                CallChecker.varInit(this.nextNode, "nextNode", 1607, 56653, 56731);
                CallChecker.varInit(this.lastReturnedNode, "lastReturnedNode", 1607, 56653, 56731);
                CallChecker.varInit(this.orderType, "orderType", 1607, 56653, 56731);
                return (nextNode) != null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1396.methodEnd();
            }
        }

        protected TreeBidiMap.Node<K, V> navigateNext() {
            MethodContext _bcornu_methode_context1397 = new MethodContext(TreeBidiMap.Node.class);
            try {
                CallChecker.varInit(this, "this", 1611, 56742, 57195);
                CallChecker.varInit(this.expectedModifications, "expectedModifications", 1611, 56742, 57195);
                CallChecker.varInit(this.previousNode, "previousNode", 1611, 56742, 57195);
                CallChecker.varInit(this.nextNode, "nextNode", 1611, 56742, 57195);
                CallChecker.varInit(this.lastReturnedNode, "lastReturnedNode", 1611, 56742, 57195);
                CallChecker.varInit(this.orderType, "orderType", 1611, 56742, 57195);
                if ((nextNode) == null) {
                    throw new NoSuchElementException();
                }
                if ((modifications) != (expectedModifications)) {
                    throw new ConcurrentModificationException();
                }
                lastReturnedNode = nextNode;
                CallChecker.varAssign(this.lastReturnedNode, "this.lastReturnedNode", 1618, 57027, 57054);
                previousNode = nextNode;
                CallChecker.varAssign(this.previousNode, "this.previousNode", 1619, 57068, 57091);
                nextNode = nextGreater(nextNode, orderType);
                CallChecker.varAssign(this.nextNode, "this.nextNode", 1620, 57105, 57148);
                return lastReturnedNode;
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1397.methodEnd();
            }
        }

        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context1398 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1624, 57206, 57286);
                CallChecker.varInit(this.expectedModifications, "expectedModifications", 1624, 57206, 57286);
                CallChecker.varInit(this.previousNode, "previousNode", 1624, 57206, 57286);
                CallChecker.varInit(this.nextNode, "nextNode", 1624, 57206, 57286);
                CallChecker.varInit(this.lastReturnedNode, "lastReturnedNode", 1624, 57206, 57286);
                CallChecker.varInit(this.orderType, "orderType", 1624, 57206, 57286);
                return (previousNode) != null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1398.methodEnd();
            }
        }

        protected TreeBidiMap.Node<K, V> navigatePrevious() {
            MethodContext _bcornu_methode_context1399 = new MethodContext(TreeBidiMap.Node.class);
            try {
                CallChecker.varInit(this, "this", 1628, 57297, 57889);
                CallChecker.varInit(this.expectedModifications, "expectedModifications", 1628, 57297, 57889);
                CallChecker.varInit(this.previousNode, "previousNode", 1628, 57297, 57889);
                CallChecker.varInit(this.nextNode, "nextNode", 1628, 57297, 57889);
                CallChecker.varInit(this.lastReturnedNode, "lastReturnedNode", 1628, 57297, 57889);
                CallChecker.varInit(this.orderType, "orderType", 1628, 57297, 57889);
                if ((previousNode) == null) {
                    throw new NoSuchElementException();
                }
                if ((modifications) != (expectedModifications)) {
                    throw new ConcurrentModificationException();
                }
                nextNode = lastReturnedNode;
                CallChecker.varAssign(this.nextNode, "this.nextNode", 1635, 57590, 57617);
                if ((nextNode) == null) {
                    nextNode = nextGreater(previousNode, orderType);
                    CallChecker.varAssign(this.nextNode, "this.nextNode", 1637, 57671, 57718);
                }
                lastReturnedNode = previousNode;
                CallChecker.varAssign(this.lastReturnedNode, "this.lastReturnedNode", 1639, 57746, 57777);
                previousNode = nextSmaller(previousNode, orderType);
                CallChecker.varAssign(this.previousNode, "this.previousNode", 1640, 57791, 57842);
                return lastReturnedNode;
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1399.methodEnd();
            }
        }

        public final void remove() {
            MethodContext _bcornu_methode_context1400 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1644, 57900, 58524);
                CallChecker.varInit(this.expectedModifications, "expectedModifications", 1644, 57900, 58524);
                CallChecker.varInit(this.previousNode, "previousNode", 1644, 57900, 58524);
                CallChecker.varInit(this.nextNode, "nextNode", 1644, 57900, 58524);
                CallChecker.varInit(this.lastReturnedNode, "lastReturnedNode", 1644, 57900, 58524);
                CallChecker.varInit(this.orderType, "orderType", 1644, 57900, 58524);
                if ((lastReturnedNode) == null) {
                    throw new IllegalStateException();
                }
                if ((modifications) != (expectedModifications)) {
                    throw new ConcurrentModificationException();
                }
                doRedBlackDelete(lastReturnedNode);
                (expectedModifications)++;
                lastReturnedNode = null;
                CallChecker.varAssign(this.lastReturnedNode, "this.lastReturnedNode", 1653, 58268, 58291);
                if ((nextNode) == null) {
                    if (CallChecker.beforeDeref(orderType, TreeBidiMap.DataElement.class, 1655, 58382, 58390)) {
                        if (CallChecker.beforeDeref(rootNode, TreeBidiMap.Node[].class, 1655, 58373, 58380)) {
                            rootNode = CallChecker.beforeCalled(rootNode, TreeBidiMap.Node[].class, 1655, 58373, 58380);
                            previousNode = greatestNode(CallChecker.isCalled(rootNode, TreeBidiMap.Node[].class, 1655, 58373, 58380)[CallChecker.isCalled(orderType, TreeBidiMap.DataElement.class, 1655, 58382, 58390).ordinal()], orderType);
                            CallChecker.varAssign(this.previousNode, "this.previousNode", 1655, 58345, 58414);
                        }
                    }
                }else {
                    previousNode = nextSmaller(nextNode, orderType);
                    CallChecker.varAssign(this.previousNode, "this.previousNode", 1657, 58453, 58500);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1400.methodEnd();
            }
        }
    }

    class ViewMapIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedMapIterator<K, V> {
        ViewMapIterator(TreeBidiMap.DataElement orderType) {
            super(orderType);
            MethodContext _bcornu_methode_context270 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context270.methodEnd();
            }
        }

        public K getKey() {
            if ((lastReturnedNode) == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            return lastReturnedNode.getKey();
        }

        public V getValue() {
            if ((lastReturnedNode) == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            return lastReturnedNode.getValue();
        }

        public V setValue(final V obj) {
            throw new UnsupportedOperationException();
        }

        public K next() {
            final TreeBidiMap.Node<K, V> npe_invocation_var281 = navigateNext();
            if (CallChecker.beforeDeref(npe_invocation_var281, TreeBidiMap.Node.class, 1694, 59572, 59585)) {
                return npe_invocation_var281.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public K previous() {
            final TreeBidiMap.Node<K, V> npe_invocation_var282 = navigatePrevious();
            if (CallChecker.beforeDeref(npe_invocation_var282, TreeBidiMap.Node.class, 1698, 59657, 59674)) {
                return npe_invocation_var282.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    class InverseViewMapIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedMapIterator<V, K> {
        public InverseViewMapIterator(TreeBidiMap.DataElement orderType) {
            super(orderType);
            MethodContext _bcornu_methode_context271 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context271.methodEnd();
            }
        }

        public V getKey() {
            if ((lastReturnedNode) == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            return lastReturnedNode.getValue();
        }

        public K getValue() {
            if ((lastReturnedNode) == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            return lastReturnedNode.getKey();
        }

        public K setValue(final K obj) {
            throw new UnsupportedOperationException();
        }

        public V next() {
            final TreeBidiMap.Node<K, V> npe_invocation_var283 = navigateNext();
            if (CallChecker.beforeDeref(npe_invocation_var283, TreeBidiMap.Node.class, 1733, 60721, 60734)) {
                return npe_invocation_var283.getValue();
            }else
                throw new AbnormalExecutionError();
            
        }

        public V previous() {
            final TreeBidiMap.Node<K, V> npe_invocation_var284 = navigatePrevious();
            if (CallChecker.beforeDeref(npe_invocation_var284, TreeBidiMap.Node.class, 1737, 60808, 60825)) {
                return npe_invocation_var284.getValue();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    class ViewMapEntryIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedIterator<Map.Entry<K, V>> {
        ViewMapEntryIterator() {
            super(TreeBidiMap.DataElement.KEY);
            MethodContext _bcornu_methode_context272 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context272.methodEnd();
            }
        }

        public Map.Entry<K, V> next() {
            MethodContext _bcornu_methode_context1411 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 1753, 61136, 61211);
                CallChecker.varInit(this.previousNode, "previousNode", 1753, 61136, 61211);
                CallChecker.varInit(this.nextNode, "nextNode", 1753, 61136, 61211);
                CallChecker.varInit(this.lastReturnedNode, "lastReturnedNode", 1753, 61136, 61211);
                CallChecker.varInit(this.orderType, "orderType", 1753, 61136, 61211);
                return navigateNext();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1411.methodEnd();
            }
        }

        public Map.Entry<K, V> previous() {
            MethodContext _bcornu_methode_context1412 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 1757, 61222, 61305);
                CallChecker.varInit(this.previousNode, "previousNode", 1757, 61222, 61305);
                CallChecker.varInit(this.nextNode, "nextNode", 1757, 61222, 61305);
                CallChecker.varInit(this.lastReturnedNode, "lastReturnedNode", 1757, 61222, 61305);
                CallChecker.varInit(this.orderType, "orderType", 1757, 61222, 61305);
                return navigatePrevious();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1412.methodEnd();
            }
        }
    }

    class InverseViewMapEntryIterator extends TreeBidiMap<K, V>.ViewIterator implements OrderedIterator<Map.Entry<V, K>> {
        InverseViewMapEntryIterator() {
            super(TreeBidiMap.DataElement.VALUE);
            MethodContext _bcornu_methode_context273 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context273.methodEnd();
            }
        }

        public Map.Entry<V, K> next() {
            MethodContext _bcornu_methode_context1413 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 1774, 61618, 61706);
                CallChecker.varInit(this.previousNode, "previousNode", 1774, 61618, 61706);
                CallChecker.varInit(this.nextNode, "nextNode", 1774, 61618, 61706);
                CallChecker.varInit(this.lastReturnedNode, "lastReturnedNode", 1774, 61618, 61706);
                CallChecker.varInit(this.orderType, "orderType", 1774, 61618, 61706);
                return createEntry(navigateNext());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<V, K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1413.methodEnd();
            }
        }

        public Map.Entry<V, K> previous() {
            MethodContext _bcornu_methode_context1414 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 1778, 61717, 61813);
                CallChecker.varInit(this.previousNode, "previousNode", 1778, 61717, 61813);
                CallChecker.varInit(this.nextNode, "nextNode", 1778, 61717, 61813);
                CallChecker.varInit(this.lastReturnedNode, "lastReturnedNode", 1778, 61717, 61813);
                CallChecker.varInit(this.orderType, "orderType", 1778, 61717, 61813);
                return createEntry(navigatePrevious());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<V, K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1414.methodEnd();
            }
        }

        private Map.Entry<V, K> createEntry(TreeBidiMap.Node<K, V> node) {
            MethodContext _bcornu_methode_context1415 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 1782, 61824, 61970);
                CallChecker.varInit(node, "node", 1782, 61824, 61970);
                CallChecker.varInit(this.previousNode, "previousNode", 1782, 61824, 61970);
                CallChecker.varInit(this.nextNode, "nextNode", 1782, 61824, 61970);
                CallChecker.varInit(this.lastReturnedNode, "lastReturnedNode", 1782, 61824, 61970);
                CallChecker.varInit(this.orderType, "orderType", 1782, 61824, 61970);
                if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1783, 61929, 61932)) {
                    if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1783, 61946, 61949)) {
                        return new UnmodifiableMapEntry<V, K>(node.getValue(), node.getKey());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<V, K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1415.methodEnd();
            }
        }
    }

    static class Node<K extends Comparable<K>, V extends Comparable<V>> implements Map.Entry<K, V> , KeyValue<K, V> {
        private final K key;

        private final V value;

        private final TreeBidiMap.Node<K, V>[] leftNode;

        private final TreeBidiMap.Node<K, V>[] rightNode;

        private final TreeBidiMap.Node<K, V>[] parentNode;

        private final boolean[] blackColor;

        private int hashcodeValue;

        private boolean calculatedHashCode;

        @SuppressWarnings(value = "unchecked")
        Node(final K key, final V value) {
            super();
            MethodContext _bcornu_methode_context274 = new MethodContext(null);
            try {
                this.key = key;
                CallChecker.varAssign(this.key, "this.key", 1813, 62935, 62949);
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 1814, 62963, 62981);
                leftNode = new TreeBidiMap.Node[2];
                CallChecker.varAssign(this.leftNode, "this.leftNode", 1815, 62995, 63017);
                rightNode = new TreeBidiMap.Node[2];
                CallChecker.varAssign(this.rightNode, "this.rightNode", 1816, 63031, 63054);
                parentNode = new TreeBidiMap.Node[2];
                CallChecker.varAssign(this.parentNode, "this.parentNode", 1817, 63068, 63092);
                blackColor = new boolean[]{ true , true };
                CallChecker.varAssign(this.blackColor, "this.blackColor", 1818, 63106, 63147);
                calculatedHashCode = false;
                CallChecker.varAssign(this.calculatedHashCode, "this.calculatedHashCode", 1819, 63161, 63187);
            } finally {
                _bcornu_methode_context274.methodEnd();
            }
        }

        private Object getData(final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1416 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 1822, 63208, 63510);
                CallChecker.varInit(dataElement, "dataElement", 1822, 63208, 63510);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1822, 63208, 63510);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1822, 63208, 63510);
                CallChecker.varInit(this.blackColor, "blackColor", 1822, 63208, 63510);
                CallChecker.varInit(this.parentNode, "parentNode", 1822, 63208, 63510);
                CallChecker.varInit(this.rightNode, "rightNode", 1822, 63208, 63510);
                CallChecker.varInit(this.leftNode, "leftNode", 1822, 63208, 63510);
                CallChecker.varInit(this.value, "value", 1822, 63208, 63510);
                CallChecker.varInit(this.key, "key", 1822, 63208, 63510);
                switch (dataElement) {
                    case KEY :
                        return getKey();
                    case VALUE :
                        return getValue();
                    default :
                        throw new IllegalArgumentException();
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1416.methodEnd();
            }
        }

        private void setLeft(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1417 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1833, 63521, 63658);
                CallChecker.varInit(dataElement, "dataElement", 1833, 63521, 63658);
                CallChecker.varInit(node, "node", 1833, 63521, 63658);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1833, 63521, 63658);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1833, 63521, 63658);
                CallChecker.varInit(this.blackColor, "blackColor", 1833, 63521, 63658);
                CallChecker.varInit(this.parentNode, "parentNode", 1833, 63521, 63658);
                CallChecker.varInit(this.rightNode, "rightNode", 1833, 63521, 63658);
                CallChecker.varInit(this.leftNode, "leftNode", 1833, 63521, 63658);
                CallChecker.varInit(this.value, "value", 1833, 63521, 63658);
                CallChecker.varInit(this.key, "key", 1833, 63521, 63658);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1834, 63619, 63629)) {
                    if (CallChecker.beforeDeref(leftNode, TreeBidiMap.Node[].class, 1834, 63610, 63617)) {
                        CallChecker.isCalled(leftNode, TreeBidiMap.Node[].class, 1834, 63610, 63617)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1834, 63619, 63629).ordinal()] = node;
                        CallChecker.varAssign(CallChecker.isCalled(this.leftNode, TreeBidiMap.Node[].class, 1834, 63610, 63617)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1834, 63619, 63629).ordinal()], "CallChecker.isCalled(this.leftNode, TreeBidiMap.Node[].class, 1834, 63610, 63617)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1834, 63619, 63629).ordinal()]", 1834, 63610, 63648);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1417.methodEnd();
            }
        }

        private TreeBidiMap.Node<K, V> getLeft(final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1418 = new MethodContext(TreeBidiMap.Node.class);
            try {
                CallChecker.varInit(this, "this", 1837, 63669, 63789);
                CallChecker.varInit(dataElement, "dataElement", 1837, 63669, 63789);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1837, 63669, 63789);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1837, 63669, 63789);
                CallChecker.varInit(this.blackColor, "blackColor", 1837, 63669, 63789);
                CallChecker.varInit(this.parentNode, "parentNode", 1837, 63669, 63789);
                CallChecker.varInit(this.rightNode, "rightNode", 1837, 63669, 63789);
                CallChecker.varInit(this.leftNode, "leftNode", 1837, 63669, 63789);
                CallChecker.varInit(this.value, "value", 1837, 63669, 63789);
                CallChecker.varInit(this.key, "key", 1837, 63669, 63789);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1838, 63757, 63767)) {
                    if (CallChecker.beforeDeref(leftNode, TreeBidiMap.Node[].class, 1838, 63748, 63755)) {
                        return CallChecker.isCalled(leftNode, TreeBidiMap.Node[].class, 1838, 63748, 63755)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1838, 63757, 63767).ordinal()];
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1418.methodEnd();
            }
        }

        private void setRight(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1419 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1841, 63800, 63939);
                CallChecker.varInit(dataElement, "dataElement", 1841, 63800, 63939);
                CallChecker.varInit(node, "node", 1841, 63800, 63939);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1841, 63800, 63939);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1841, 63800, 63939);
                CallChecker.varInit(this.blackColor, "blackColor", 1841, 63800, 63939);
                CallChecker.varInit(this.parentNode, "parentNode", 1841, 63800, 63939);
                CallChecker.varInit(this.rightNode, "rightNode", 1841, 63800, 63939);
                CallChecker.varInit(this.leftNode, "leftNode", 1841, 63800, 63939);
                CallChecker.varInit(this.value, "value", 1841, 63800, 63939);
                CallChecker.varInit(this.key, "key", 1841, 63800, 63939);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1842, 63900, 63910)) {
                    if (CallChecker.beforeDeref(rightNode, TreeBidiMap.Node[].class, 1842, 63890, 63898)) {
                        CallChecker.isCalled(rightNode, TreeBidiMap.Node[].class, 1842, 63890, 63898)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1842, 63900, 63910).ordinal()] = node;
                        CallChecker.varAssign(CallChecker.isCalled(this.rightNode, TreeBidiMap.Node[].class, 1842, 63890, 63898)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1842, 63900, 63910).ordinal()], "CallChecker.isCalled(this.rightNode, TreeBidiMap.Node[].class, 1842, 63890, 63898)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1842, 63900, 63910).ordinal()]", 1842, 63890, 63929);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1419.methodEnd();
            }
        }

        private TreeBidiMap.Node<K, V> getRight(final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1420 = new MethodContext(TreeBidiMap.Node.class);
            try {
                CallChecker.varInit(this, "this", 1845, 63950, 64072);
                CallChecker.varInit(dataElement, "dataElement", 1845, 63950, 64072);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1845, 63950, 64072);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1845, 63950, 64072);
                CallChecker.varInit(this.blackColor, "blackColor", 1845, 63950, 64072);
                CallChecker.varInit(this.parentNode, "parentNode", 1845, 63950, 64072);
                CallChecker.varInit(this.rightNode, "rightNode", 1845, 63950, 64072);
                CallChecker.varInit(this.leftNode, "leftNode", 1845, 63950, 64072);
                CallChecker.varInit(this.value, "value", 1845, 63950, 64072);
                CallChecker.varInit(this.key, "key", 1845, 63950, 64072);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1846, 64040, 64050)) {
                    if (CallChecker.beforeDeref(rightNode, TreeBidiMap.Node[].class, 1846, 64030, 64038)) {
                        return CallChecker.isCalled(rightNode, TreeBidiMap.Node[].class, 1846, 64030, 64038)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1846, 64040, 64050).ordinal()];
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1420.methodEnd();
            }
        }

        private void setParent(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1421 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1855, 64083, 64389);
                CallChecker.varInit(dataElement, "dataElement", 1855, 64083, 64389);
                CallChecker.varInit(node, "node", 1855, 64083, 64389);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1855, 64083, 64389);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1855, 64083, 64389);
                CallChecker.varInit(this.blackColor, "blackColor", 1855, 64083, 64389);
                CallChecker.varInit(this.parentNode, "parentNode", 1855, 64083, 64389);
                CallChecker.varInit(this.rightNode, "rightNode", 1855, 64083, 64389);
                CallChecker.varInit(this.leftNode, "leftNode", 1855, 64083, 64389);
                CallChecker.varInit(this.value, "value", 1855, 64083, 64389);
                CallChecker.varInit(this.key, "key", 1855, 64083, 64389);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1856, 64350, 64360)) {
                    if (CallChecker.beforeDeref(parentNode, TreeBidiMap.Node[].class, 1856, 64339, 64348)) {
                        CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1856, 64339, 64348)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1856, 64350, 64360).ordinal()] = node;
                        CallChecker.varAssign(CallChecker.isCalled(this.parentNode, TreeBidiMap.Node[].class, 1856, 64339, 64348)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1856, 64350, 64360).ordinal()], "CallChecker.isCalled(this.parentNode, TreeBidiMap.Node[].class, 1856, 64339, 64348)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1856, 64350, 64360).ordinal()]", 1856, 64339, 64379);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1421.methodEnd();
            }
        }

        private TreeBidiMap.Node<K, V> getParent(final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1422 = new MethodContext(TreeBidiMap.Node.class);
            try {
                CallChecker.varInit(this, "this", 1865, 64400, 64685);
                CallChecker.varInit(dataElement, "dataElement", 1865, 64400, 64685);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1865, 64400, 64685);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1865, 64400, 64685);
                CallChecker.varInit(this.blackColor, "blackColor", 1865, 64400, 64685);
                CallChecker.varInit(this.parentNode, "parentNode", 1865, 64400, 64685);
                CallChecker.varInit(this.rightNode, "rightNode", 1865, 64400, 64685);
                CallChecker.varInit(this.leftNode, "leftNode", 1865, 64400, 64685);
                CallChecker.varInit(this.value, "value", 1865, 64400, 64685);
                CallChecker.varInit(this.key, "key", 1865, 64400, 64685);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1866, 64653, 64663)) {
                    if (CallChecker.beforeDeref(parentNode, TreeBidiMap.Node[].class, 1866, 64642, 64651)) {
                        return CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1866, 64642, 64651)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1866, 64653, 64663).ordinal()];
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeBidiMap.Node<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1422.methodEnd();
            }
        }

        private void swapColors(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1423 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1875, 64696, 65283);
                CallChecker.varInit(dataElement, "dataElement", 1875, 64696, 65283);
                CallChecker.varInit(node, "node", 1875, 64696, 65283);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1875, 64696, 65283);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1875, 64696, 65283);
                CallChecker.varInit(this.blackColor, "blackColor", 1875, 64696, 65283);
                CallChecker.varInit(this.parentNode, "parentNode", 1875, 64696, 65283);
                CallChecker.varInit(this.rightNode, "rightNode", 1875, 64696, 65283);
                CallChecker.varInit(this.leftNode, "leftNode", 1875, 64696, 65283);
                CallChecker.varInit(this.value, "value", 1875, 64696, 65283);
                CallChecker.varInit(this.key, "key", 1875, 64696, 65283);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1877, 65021, 65031)) {
                    if (CallChecker.beforeDeref(blackColor, boolean[].class, 1877, 65010, 65019)) {
                        if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1877, 65052, 65055)) {
                            if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1877, 65068, 65078)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(node, TreeBidiMap.Node.class, 1877, 65052, 65055).blackColor, boolean[].class, 1877, 65052, 65066)) {
                                    CallChecker.isCalled(blackColor, boolean[].class, 1877, 65010, 65019)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1877, 65021, 65031).ordinal()] ^= CallChecker.isCalled(CallChecker.isCalled(node, TreeBidiMap.Node.class, 1877, 65052, 65055).blackColor, boolean[].class, 1877, 65052, 65066)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1877, 65068, 65078).ordinal()];
                                    CallChecker.varAssign(CallChecker.isCalled(this.blackColor, boolean[].class, 1877, 65010, 65019)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1877, 65021, 65031).ordinal()], "CallChecker.isCalled(this.blackColor, boolean[].class, 1877, 65010, 65019)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1877, 65021, 65031).ordinal()]", 1877, 65010, 65090);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1878, 65104, 65107)) {
                    if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1878, 65120, 65130)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(node, TreeBidiMap.Node.class, 1878, 65104, 65107).blackColor, boolean[].class, 1878, 65104, 65118)) {
                            if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1878, 65157, 65167)) {
                                if (CallChecker.beforeDeref(blackColor, boolean[].class, 1878, 65146, 65155)) {
                                    CallChecker.isCalled(CallChecker.isCalled(node, TreeBidiMap.Node.class, 1878, 65104, 65107).blackColor, boolean[].class, 1878, 65104, 65118)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1878, 65120, 65130).ordinal()] ^= CallChecker.isCalled(blackColor, boolean[].class, 1878, 65146, 65155)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1878, 65157, 65167).ordinal()];
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(node, TreeBidiMap.Node.class, 1878, 65104, 65107).blackColor, boolean[].class, 1878, 65104, 65118)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1878, 65120, 65130).ordinal()], "CallChecker.isCalled(CallChecker.isCalled(node, TreeBidiMap.Node.class, 1878, 65104, 65107).blackColor, boolean[].class, 1878, 65104, 65118)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1878, 65120, 65130).ordinal()]", 1878, 65104, 65179);
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1879, 65204, 65214)) {
                    if (CallChecker.beforeDeref(blackColor, boolean[].class, 1879, 65193, 65202)) {
                        if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1879, 65235, 65238)) {
                            if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1879, 65251, 65261)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(node, TreeBidiMap.Node.class, 1879, 65235, 65238).blackColor, boolean[].class, 1879, 65235, 65249)) {
                                    CallChecker.isCalled(blackColor, boolean[].class, 1879, 65193, 65202)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1879, 65204, 65214).ordinal()] ^= CallChecker.isCalled(CallChecker.isCalled(node, TreeBidiMap.Node.class, 1879, 65235, 65238).blackColor, boolean[].class, 1879, 65235, 65249)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1879, 65251, 65261).ordinal()];
                                    CallChecker.varAssign(CallChecker.isCalled(this.blackColor, boolean[].class, 1879, 65193, 65202)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1879, 65204, 65214).ordinal()], "CallChecker.isCalled(this.blackColor, boolean[].class, 1879, 65193, 65202)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1879, 65204, 65214).ordinal()]", 1879, 65193, 65273);
                                }
                            }
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1423.methodEnd();
            }
        }

        private boolean isBlack(final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1424 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1888, 65294, 65599);
                CallChecker.varInit(dataElement, "dataElement", 1888, 65294, 65599);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1888, 65294, 65599);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1888, 65294, 65599);
                CallChecker.varInit(this.blackColor, "blackColor", 1888, 65294, 65599);
                CallChecker.varInit(this.parentNode, "parentNode", 1888, 65294, 65599);
                CallChecker.varInit(this.rightNode, "rightNode", 1888, 65294, 65599);
                CallChecker.varInit(this.leftNode, "leftNode", 1888, 65294, 65599);
                CallChecker.varInit(this.value, "value", 1888, 65294, 65599);
                CallChecker.varInit(this.key, "key", 1888, 65294, 65599);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1889, 65567, 65577)) {
                    if (CallChecker.beforeDeref(blackColor, boolean[].class, 1889, 65556, 65565)) {
                        return CallChecker.isCalled(blackColor, boolean[].class, 1889, 65556, 65565)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1889, 65567, 65577).ordinal()];
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1424.methodEnd();
            }
        }

        private boolean isRed(final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1425 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1898, 65610, 65875);
                CallChecker.varInit(dataElement, "dataElement", 1898, 65610, 65875);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1898, 65610, 65875);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1898, 65610, 65875);
                CallChecker.varInit(this.blackColor, "blackColor", 1898, 65610, 65875);
                CallChecker.varInit(this.parentNode, "parentNode", 1898, 65610, 65875);
                CallChecker.varInit(this.rightNode, "rightNode", 1898, 65610, 65875);
                CallChecker.varInit(this.leftNode, "leftNode", 1898, 65610, 65875);
                CallChecker.varInit(this.value, "value", 1898, 65610, 65875);
                CallChecker.varInit(this.key, "key", 1898, 65610, 65875);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1899, 65843, 65853)) {
                    if (CallChecker.beforeDeref(blackColor, boolean[].class, 1899, 65832, 65841)) {
                        return !(CallChecker.isCalled(blackColor, boolean[].class, 1899, 65832, 65841)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1899, 65843, 65853).ordinal()]);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1425.methodEnd();
            }
        }

        private void setBlack(final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1426 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1907, 65886, 66117);
                CallChecker.varInit(dataElement, "dataElement", 1907, 65886, 66117);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1907, 65886, 66117);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1907, 65886, 66117);
                CallChecker.varInit(this.blackColor, "blackColor", 1907, 65886, 66117);
                CallChecker.varInit(this.parentNode, "parentNode", 1907, 65886, 66117);
                CallChecker.varInit(this.rightNode, "rightNode", 1907, 65886, 66117);
                CallChecker.varInit(this.leftNode, "leftNode", 1907, 65886, 66117);
                CallChecker.varInit(this.value, "value", 1907, 65886, 66117);
                CallChecker.varInit(this.key, "key", 1907, 65886, 66117);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1908, 66078, 66088)) {
                    if (CallChecker.beforeDeref(blackColor, boolean[].class, 1908, 66067, 66076)) {
                        CallChecker.isCalled(blackColor, boolean[].class, 1908, 66067, 66076)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1908, 66078, 66088).ordinal()] = true;
                        CallChecker.varAssign(CallChecker.isCalled(this.blackColor, boolean[].class, 1908, 66067, 66076)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1908, 66078, 66088).ordinal()], "CallChecker.isCalled(this.blackColor, boolean[].class, 1908, 66067, 66076)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1908, 66078, 66088).ordinal()]", 1908, 66067, 66107);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1426.methodEnd();
            }
        }

        private void setRed(final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1427 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1916, 66128, 66356);
                CallChecker.varInit(dataElement, "dataElement", 1916, 66128, 66356);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1916, 66128, 66356);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1916, 66128, 66356);
                CallChecker.varInit(this.blackColor, "blackColor", 1916, 66128, 66356);
                CallChecker.varInit(this.parentNode, "parentNode", 1916, 66128, 66356);
                CallChecker.varInit(this.rightNode, "rightNode", 1916, 66128, 66356);
                CallChecker.varInit(this.leftNode, "leftNode", 1916, 66128, 66356);
                CallChecker.varInit(this.value, "value", 1916, 66128, 66356);
                CallChecker.varInit(this.key, "key", 1916, 66128, 66356);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1917, 66316, 66326)) {
                    if (CallChecker.beforeDeref(blackColor, boolean[].class, 1917, 66305, 66314)) {
                        CallChecker.isCalled(blackColor, boolean[].class, 1917, 66305, 66314)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1917, 66316, 66326).ordinal()] = false;
                        CallChecker.varAssign(CallChecker.isCalled(this.blackColor, boolean[].class, 1917, 66305, 66314)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1917, 66316, 66326).ordinal()], "CallChecker.isCalled(this.blackColor, boolean[].class, 1917, 66305, 66314)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1917, 66316, 66326).ordinal()]", 1917, 66305, 66346);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1427.methodEnd();
            }
        }

        private void copyColor(final TreeBidiMap.Node<K, V> node, final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1428 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 1926, 66367, 66735);
                CallChecker.varInit(dataElement, "dataElement", 1926, 66367, 66735);
                CallChecker.varInit(node, "node", 1926, 66367, 66735);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1926, 66367, 66735);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1926, 66367, 66735);
                CallChecker.varInit(this.blackColor, "blackColor", 1926, 66367, 66735);
                CallChecker.varInit(this.parentNode, "parentNode", 1926, 66367, 66735);
                CallChecker.varInit(this.rightNode, "rightNode", 1926, 66367, 66735);
                CallChecker.varInit(this.leftNode, "leftNode", 1926, 66367, 66735);
                CallChecker.varInit(this.value, "value", 1926, 66367, 66735);
                CallChecker.varInit(this.key, "key", 1926, 66367, 66735);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1927, 66662, 66672)) {
                    if (CallChecker.beforeDeref(blackColor, boolean[].class, 1927, 66651, 66660)) {
                        if (CallChecker.beforeDeref(node, TreeBidiMap.Node.class, 1927, 66687, 66690)) {
                            if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1927, 66703, 66713)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(node, TreeBidiMap.Node.class, 1927, 66687, 66690).blackColor, boolean[].class, 1927, 66687, 66701)) {
                                    CallChecker.isCalled(blackColor, boolean[].class, 1927, 66651, 66660)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1927, 66662, 66672).ordinal()] = CallChecker.isCalled(CallChecker.isCalled(node, TreeBidiMap.Node.class, 1927, 66687, 66690).blackColor, boolean[].class, 1927, 66687, 66701)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1927, 66703, 66713).ordinal()];
                                    CallChecker.varAssign(CallChecker.isCalled(this.blackColor, boolean[].class, 1927, 66651, 66660)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1927, 66662, 66672).ordinal()], "CallChecker.isCalled(this.blackColor, boolean[].class, 1927, 66651, 66660)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1927, 66662, 66672).ordinal()]", 1927, 66651, 66725);
                                }
                            }
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1428.methodEnd();
            }
        }

        private boolean isLeftChild(final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1429 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1930, 66746, 66974);
                CallChecker.varInit(dataElement, "dataElement", 1930, 66746, 66974);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1930, 66746, 66974);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1930, 66746, 66974);
                CallChecker.varInit(this.blackColor, "blackColor", 1930, 66746, 66974);
                CallChecker.varInit(this.parentNode, "parentNode", 1930, 66746, 66974);
                CallChecker.varInit(this.rightNode, "rightNode", 1930, 66746, 66974);
                CallChecker.varInit(this.leftNode, "leftNode", 1930, 66746, 66974);
                CallChecker.varInit(this.value, "value", 1930, 66746, 66974);
                CallChecker.varInit(this.key, "key", 1930, 66746, 66974);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1931, 66837, 66847)) {
                    if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1932, 66902, 66912)) {
                        if (CallChecker.beforeDeref(parentNode, TreeBidiMap.Node[].class, 1932, 66891, 66900)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1932, 66891, 66900)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1932, 66902, 66912).ordinal()], TreeBidiMap.Node.class, 1932, 66891, 66923)) {
                                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1932, 66934, 66944)) {
                                    CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1932, 66891, 66900)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1932, 66902, 66912).ordinal()] = CallChecker.beforeCalled(CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1932, 66891, 66900)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1932, 66902, 66912).ordinal()], TreeBidiMap.Node.class, 1932, 66891, 66923);
                                    return ((CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1931, 66826, 66835)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1931, 66837, 66847).ordinal()]) != null) && ((CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1932, 66891, 66900)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1932, 66902, 66912).ordinal()], TreeBidiMap.Node.class, 1932, 66891, 66923).leftNode, TreeBidiMap.Node[].class, 1932, 66891, 66932)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1932, 66934, 66944).ordinal()]) == (this));
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
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1429.methodEnd();
            }
        }

        private boolean isRightChild(final TreeBidiMap.DataElement dataElement) {
            MethodContext _bcornu_methode_context1430 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1935, 66985, 67215);
                CallChecker.varInit(dataElement, "dataElement", 1935, 66985, 67215);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1935, 66985, 67215);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1935, 66985, 67215);
                CallChecker.varInit(this.blackColor, "blackColor", 1935, 66985, 67215);
                CallChecker.varInit(this.parentNode, "parentNode", 1935, 66985, 67215);
                CallChecker.varInit(this.rightNode, "rightNode", 1935, 66985, 67215);
                CallChecker.varInit(this.leftNode, "leftNode", 1935, 66985, 67215);
                CallChecker.varInit(this.value, "value", 1935, 66985, 67215);
                CallChecker.varInit(this.key, "key", 1935, 66985, 67215);
                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1936, 67077, 67087)) {
                    if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1937, 67142, 67152)) {
                        if (CallChecker.beforeDeref(parentNode, TreeBidiMap.Node[].class, 1937, 67131, 67140)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1937, 67131, 67140)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1937, 67142, 67152).ordinal()], TreeBidiMap.Node.class, 1937, 67131, 67163)) {
                                if (CallChecker.beforeDeref(dataElement, TreeBidiMap.DataElement.class, 1937, 67175, 67185)) {
                                    CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1937, 67131, 67140)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1937, 67142, 67152).ordinal()] = CallChecker.beforeCalled(CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1937, 67131, 67140)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1937, 67142, 67152).ordinal()], TreeBidiMap.Node.class, 1937, 67131, 67163);
                                    return ((CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1936, 67066, 67075)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1936, 67077, 67087).ordinal()]) != null) && ((CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(parentNode, TreeBidiMap.Node[].class, 1937, 67131, 67140)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1937, 67142, 67152).ordinal()], TreeBidiMap.Node.class, 1937, 67131, 67163).rightNode, TreeBidiMap.Node[].class, 1937, 67131, 67173)[CallChecker.isCalled(dataElement, TreeBidiMap.DataElement.class, 1937, 67175, 67185).ordinal()]) == (this));
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
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1430.methodEnd();
            }
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(final V ignored) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
        }

        @Override
        public boolean equals(final Object obj) {
            MethodContext _bcornu_methode_context1434 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 1979, 68082, 68833);
                CallChecker.varInit(obj, "obj", 1979, 68082, 68833);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1979, 68082, 68833);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1979, 68082, 68833);
                CallChecker.varInit(this.blackColor, "blackColor", 1979, 68082, 68833);
                CallChecker.varInit(this.parentNode, "parentNode", 1979, 68082, 68833);
                CallChecker.varInit(this.rightNode, "rightNode", 1979, 68082, 68833);
                CallChecker.varInit(this.leftNode, "leftNode", 1979, 68082, 68833);
                CallChecker.varInit(this.value, "value", 1979, 68082, 68833);
                CallChecker.varInit(this.key, "key", 1979, 68082, 68833);
                if (obj == (this)) {
                    return true;
                }
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry<?, ?> e = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "e", 1986, 68699, 68740);
                if (CallChecker.beforeDeref(e, Map.Entry.class, 1987, 68777, 68777)) {
                    if (CallChecker.beforeDeref(e, Map.Entry.class, 1987, 68810, 68810)) {
                        return (getKey().equals(e.getKey())) && (getValue().equals(e.getValue()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1434.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context1435 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 1994, 68844, 69184);
                CallChecker.varInit(this.calculatedHashCode, "calculatedHashCode", 1994, 68844, 69184);
                CallChecker.varInit(this.hashcodeValue, "hashcodeValue", 1994, 68844, 69184);
                CallChecker.varInit(this.blackColor, "blackColor", 1994, 68844, 69184);
                CallChecker.varInit(this.parentNode, "parentNode", 1994, 68844, 69184);
                CallChecker.varInit(this.rightNode, "rightNode", 1994, 68844, 69184);
                CallChecker.varInit(this.leftNode, "leftNode", 1994, 68844, 69184);
                CallChecker.varInit(this.value, "value", 1994, 68844, 69184);
                CallChecker.varInit(this.key, "key", 1994, 68844, 69184);
                if (!(calculatedHashCode)) {
                    final Comparable<K> npe_invocation_var285 = getKey();
                    if (CallChecker.beforeDeref(npe_invocation_var285, Comparable.class, 1996, 69040, 69047)) {
                        final Comparable<V> npe_invocation_var286 = getValue();
                        if (CallChecker.beforeDeref(npe_invocation_var286, Comparable.class, 1996, 69062, 69071)) {
                            hashcodeValue = (CallChecker.isCalled(npe_invocation_var285, Comparable.class, 1996, 69040, 69047).hashCode()) ^ (CallChecker.isCalled(npe_invocation_var286, Comparable.class, 1996, 69062, 69071).hashCode());
                            CallChecker.varAssign(this.hashcodeValue, "this.hashcodeValue", 1996, 69024, 69083);
                        }
                    }
                    calculatedHashCode = true;
                    CallChecker.varAssign(this.calculatedHashCode, "this.calculatedHashCode", 1997, 69101, 69126);
                }
                return hashcodeValue;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1435.methodEnd();
            }
        }
    }

    class Inverse implements OrderedBidiMap<V, K> {
        private Set<V> inverseKeySet;

        private Set<K> inverseValuesSet;

        private Set<Map.Entry<V, K>> inverseEntrySet;

        public int size() {
            MethodContext _bcornu_methode_context1436 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 2016, 69664, 69736);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2016, 69664, 69736);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2016, 69664, 69736);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2016, 69664, 69736);
                return TreeBidiMap.this.size();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1436.methodEnd();
            }
        }

        public boolean isEmpty() {
            MethodContext _bcornu_methode_context1437 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 2020, 69747, 69829);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2020, 69747, 69829);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2020, 69747, 69829);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2020, 69747, 69829);
                return TreeBidiMap.this.isEmpty();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1437.methodEnd();
            }
        }

        public K get(final Object key) {
            return TreeBidiMap.this.getKey(key);
        }

        public V getKey(final Object value) {
            return TreeBidiMap.this.get(value);
        }

        public boolean containsKey(final Object key) {
            MethodContext _bcornu_methode_context1440 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 2032, 70046, 70157);
                CallChecker.varInit(key, "key", 2032, 70046, 70157);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2032, 70046, 70157);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2032, 70046, 70157);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2032, 70046, 70157);
                return TreeBidiMap.this.containsValue(key);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1440.methodEnd();
            }
        }

        public boolean containsValue(final Object value) {
            MethodContext _bcornu_methode_context1441 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 2036, 70168, 70283);
                CallChecker.varInit(value, "value", 2036, 70168, 70283);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2036, 70168, 70283);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2036, 70168, 70283);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2036, 70168, 70283);
                return TreeBidiMap.this.containsKey(value);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1441.methodEnd();
            }
        }

        public V firstKey() {
            if ((TreeBidiMap.this.nodeCount) == 0) {
                throw new NoSuchElementException("Map is empty");
            }
            if (CallChecker.beforeDeref(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 2044, 70502, 70506)) {
                if (CallChecker.beforeDeref(TreeBidiMap.this.rootNode, TreeBidiMap.Node[].class, 2044, 70476, 70500)) {
                    TreeBidiMap.this.rootNode = CallChecker.beforeCalled(TreeBidiMap.this.rootNode, TreeBidiMap.Node[].class, 2044, 70476, 70500);
                    final TreeBidiMap.Node<K, V> npe_invocation_var287 = leastNode(CallChecker.isCalled(TreeBidiMap.this.rootNode, TreeBidiMap.Node[].class, 2044, 70476, 70500)[CallChecker.isCalled(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 2044, 70502, 70506).ordinal()], TreeBidiMap.DataElement.VALUE);
                    if (CallChecker.beforeDeref(npe_invocation_var287, TreeBidiMap.Node.class, 2044, 70466, 70525)) {
                        return npe_invocation_var287.getValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        }

        public V lastKey() {
            if ((TreeBidiMap.this.nodeCount) == 0) {
                throw new NoSuchElementException("Map is empty");
            }
            if (CallChecker.beforeDeref(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 2051, 70768, 70772)) {
                if (CallChecker.beforeDeref(TreeBidiMap.this.rootNode, TreeBidiMap.Node[].class, 2051, 70742, 70766)) {
                    TreeBidiMap.this.rootNode = CallChecker.beforeCalled(TreeBidiMap.this.rootNode, TreeBidiMap.Node[].class, 2051, 70742, 70766);
                    final TreeBidiMap.Node<K, V> npe_invocation_var288 = greatestNode(CallChecker.isCalled(TreeBidiMap.this.rootNode, TreeBidiMap.Node[].class, 2051, 70742, 70766)[CallChecker.isCalled(TreeBidiMap.DataElement.VALUE, TreeBidiMap.DataElement.class, 2051, 70768, 70772).ordinal()], TreeBidiMap.DataElement.VALUE);
                    if (CallChecker.beforeDeref(npe_invocation_var288, TreeBidiMap.Node.class, 2051, 70729, 70791)) {
                        return npe_invocation_var288.getValue();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        }

        public V nextKey(V key) {
            TreeBidiMap.checkKey(key);
            TreeBidiMap.Node<K, V> node = CallChecker.varInit(nextGreater(TreeBidiMap.this.<V>lookup(key, TreeBidiMap.DataElement.VALUE), TreeBidiMap.DataElement.VALUE), "node", 2056, 70889, 70965);
            if (node == null) {
                return null;
            }else {
                return node.getValue();
            }
        }

        public V previousKey(V key) {
            TreeBidiMap.checkKey(key);
            TreeBidiMap.Node<K, V> node = CallChecker.varInit(TreeBidiMap.this.nextSmaller(TreeBidiMap.this.<V>lookup(key, TreeBidiMap.DataElement.VALUE), TreeBidiMap.DataElement.VALUE), "node", 2062, 71113, 71206);
            if (node == null) {
                return null;
            }else {
                return node.getValue();
            }
        }

        public K put(final V key, final K value) {
            K result = CallChecker.varInit(get(key), "result", 2067, 71340, 71359);
            TreeBidiMap.this.doPut(value, key);
            return result;
        }

        public void putAll(Map<? extends V, ? extends K> map) {
            MethodContext _bcornu_methode_context1447 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 2072, 71455, 71655);
                CallChecker.varInit(map, "map", 2072, 71455, 71655);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2072, 71455, 71655);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2072, 71455, 71655);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2072, 71455, 71655);
                map = CallChecker.beforeCalled(map, Map.class, 2073, 71568, 71570);
                for (Map.Entry<? extends V, ? extends K> e : CallChecker.isCalled(map, Map.class, 2073, 71568, 71570).entrySet()) {
                    if (CallChecker.beforeDeref(e, Map.Entry.class, 2074, 71606, 71606)) {
                        if (CallChecker.beforeDeref(e, Map.Entry.class, 2074, 71618, 71618)) {
                            put(e.getKey(), e.getValue());
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1447.methodEnd();
            }
        }

        public K remove(final Object key) {
            return TreeBidiMap.this.removeValue(key);
        }

        public V removeValue(final Object value) {
            return TreeBidiMap.this.remove(value);
        }

        public void clear() {
            MethodContext _bcornu_methode_context1450 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 2086, 71888, 71956);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2086, 71888, 71956);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2086, 71888, 71956);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2086, 71888, 71956);
                TreeBidiMap.this.clear();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1450.methodEnd();
            }
        }

        public Set<V> keySet() {
            MethodContext _bcornu_methode_context1451 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 2090, 71967, 72143);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2090, 71967, 72143);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2090, 71967, 72143);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2090, 71967, 72143);
                if ((inverseKeySet) == null) {
                    inverseKeySet = new ValueView(TreeBidiMap.DataElement.VALUE);
                    CallChecker.varAssign(this.inverseKeySet, "this.inverseKeySet", 2092, 72049, 72085);
                }
                return inverseKeySet;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1451.methodEnd();
            }
        }

        public Collection<K> values() {
            MethodContext _bcornu_methode_context1452 = new MethodContext(Collection.class);
            try {
                CallChecker.varInit(this, "this", 2097, 72154, 72344);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2097, 72154, 72344);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2097, 72154, 72344);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2097, 72154, 72344);
                if ((inverseValuesSet) == null) {
                    inverseValuesSet = new KeyView(TreeBidiMap.DataElement.VALUE);
                    CallChecker.varAssign(this.inverseValuesSet, "this.inverseValuesSet", 2099, 72246, 72283);
                }
                return inverseValuesSet;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Collection<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1452.methodEnd();
            }
        }

        public Set<Map.Entry<V, K>> entrySet() {
            MethodContext _bcornu_methode_context1453 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 2104, 72355, 72555);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2104, 72355, 72555);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2104, 72355, 72555);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2104, 72355, 72555);
                if ((inverseEntrySet) == null) {
                    inverseEntrySet = new InverseEntryView();
                    CallChecker.varAssign(this.inverseEntrySet, "this.inverseEntrySet", 2106, 72455, 72495);
                }
                return inverseEntrySet;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Map.Entry<V, K>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1453.methodEnd();
            }
        }

        public OrderedMapIterator<V, K> mapIterator() {
            MethodContext _bcornu_methode_context1454 = new MethodContext(OrderedMapIterator.class);
            try {
                CallChecker.varInit(this, "this", 2111, 72566, 72787);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2111, 72566, 72787);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2111, 72566, 72787);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2111, 72566, 72787);
                if (isEmpty()) {
                    return EmptyOrderedMapIterator.<V, K>getInstance();
                }
                return new InverseViewMapIterator(TreeBidiMap.DataElement.VALUE);
            } catch (ForceReturn _bcornu_return_t) {
                return ((OrderedMapIterator<V, K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1454.methodEnd();
            }
        }

        public OrderedBidiMap<K, V> inverseBidiMap() {
            MethodContext _bcornu_methode_context1455 = new MethodContext(OrderedBidiMap.class);
            try {
                CallChecker.varInit(this, "this", 2118, 72798, 72890);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2118, 72798, 72890);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2118, 72798, 72890);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2118, 72798, 72890);
                return TreeBidiMap.this;
            } catch (ForceReturn _bcornu_return_t) {
                return ((OrderedBidiMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1455.methodEnd();
            }
        }

        @Override
        public boolean equals(Object obj) {
            MethodContext _bcornu_methode_context1456 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 2123, 72901, 73033);
                CallChecker.varInit(obj, "obj", 2123, 72901, 73033);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2123, 72901, 73033);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2123, 72901, 73033);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2123, 72901, 73033);
                return TreeBidiMap.this.doEquals(obj, TreeBidiMap.DataElement.VALUE);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1456.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context1457 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 2128, 73044, 73161);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2128, 73044, 73161);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2128, 73044, 73161);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2128, 73044, 73161);
                return TreeBidiMap.this.doHashCode(TreeBidiMap.DataElement.VALUE);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1457.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context1458 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 2133, 73172, 73292);
                CallChecker.varInit(this.inverseEntrySet, "inverseEntrySet", 2133, 73172, 73292);
                CallChecker.varInit(this.inverseValuesSet, "inverseValuesSet", 2133, 73172, 73292);
                CallChecker.varInit(this.inverseKeySet, "inverseKeySet", 2133, 73172, 73292);
                return TreeBidiMap.this.doToString(TreeBidiMap.DataElement.VALUE);
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1458.methodEnd();
            }
        }
    }
}

