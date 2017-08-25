package org.apache.commons.collections.map;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.Set;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.collections.CollectionUtils;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;
import java.util.AbstractCollection;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.FunctorException;
import java.util.HashMap;
import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.collections.iterators.IteratorChain;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.MultiMap;

public class MultiValueMap<K, V> extends AbstractMapDecorator<K, Object> implements Serializable , MultiMap<K, V> {
    private static final long serialVersionUID = -2214159910087182007L;

    private final Factory<? extends Collection<V>> collectionFactory;

    private transient Collection<V> valuesView;

    @SuppressWarnings(value = "unchecked")
    public static <K, V> MultiValueMap<K, V> decorate(Map<K, ? super Collection<V>> map) {
        MethodContext _bcornu_methode_context2301 = new MethodContext(MultiValueMap.class);
        try {
            CallChecker.varInit(map, "map", 87, 3289, 3663);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 87, 3289, 3663);
            return MultiValueMap.<K, V, ArrayList>decorate(((Map<K, ? super Collection>) (map)), ArrayList.class);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultiValueMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2301.methodEnd();
        }
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> decorate(Map<K, ? super C> map, Class<C> collectionClass) {
        MethodContext _bcornu_methode_context2302 = new MethodContext(MultiValueMap.class);
        try {
            CallChecker.varInit(collectionClass, "collectionClass", 98, 3670, 4148);
            CallChecker.varInit(map, "map", 98, 3670, 4148);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 98, 3670, 4148);
            return new MultiValueMap<K, V>(map, new MultiValueMap.ReflectionFactory<C>(collectionClass));
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultiValueMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2302.methodEnd();
        }
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> decorate(Map<K, ? super C> map, Factory<C> collectionFactory) {
        MethodContext _bcornu_methode_context2303 = new MethodContext(MultiValueMap.class);
        try {
            CallChecker.varInit(collectionFactory, "collectionFactory", 109, 4155, 4662);
            CallChecker.varInit(map, "map", 109, 4155, 4662);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 109, 4155, 4662);
            return new MultiValueMap<K, V>(map, collectionFactory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultiValueMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2303.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public MultiValueMap() {
        this(new HashMap(), new MultiValueMap.ReflectionFactory(ArrayList.class));
        MethodContext _bcornu_methode_context432 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context432.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    protected <C extends Collection<V>> MultiValueMap(Map<K, ? super C> map, Factory<C> collectionFactory) {
        super(((Map<K, Object>) (map)));
        MethodContext _bcornu_methode_context433 = new MethodContext(null);
        try {
            if (collectionFactory == null) {
                throw new IllegalArgumentException("The factory must not be null");
            }
            this.collectionFactory = collectionFactory;
            CallChecker.varAssign(this.collectionFactory, "this.collectionFactory", 136, 5675, 5717);
        } finally {
            _bcornu_methode_context433.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2304 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 147, 5730, 6121);
            CallChecker.varInit(out, "out", 147, 5730, 6121);
            CallChecker.varInit(this.map, "map", 147, 5730, 6121);
            CallChecker.varInit(this.valuesView, "valuesView", 147, 5730, 6121);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 147, 5730, 6121);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 147, 5730, 6121);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 148, 6061, 6063)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 148, 6061, 6063);
                CallChecker.isCalled(out, ObjectOutputStream.class, 148, 6061, 6063).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 149, 6095, 6097)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 149, 6095, 6097);
                CallChecker.isCalled(out, ObjectOutputStream.class, 149, 6095, 6097).writeObject(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2304.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2305 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 161, 6128, 6608);
            CallChecker.varInit(in, "in", 161, 6128, 6608);
            CallChecker.varInit(this.map, "map", 161, 6128, 6608);
            CallChecker.varInit(this.valuesView, "valuesView", 161, 6128, 6608);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 161, 6128, 6608);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 161, 6128, 6608);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 162, 6525, 6526)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 162, 6525, 6526);
                CallChecker.isCalled(in, ObjectInputStream.class, 162, 6525, 6526).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 163, 6580, 6581)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 163, 6580, 6581);
                map = ((Map<K, Object>) (CallChecker.isCalled(in, ObjectInputStream.class, 163, 6580, 6581).readObject()));
                CallChecker.varAssign(this.map, "this.map", 163, 6557, 6595);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2305.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2306 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 171, 6615, 7206);
            CallChecker.varInit(this.map, "map", 171, 6615, 7206);
            CallChecker.varInit(this.valuesView, "valuesView", 171, 6615, 7206);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 171, 6615, 7206);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 171, 6615, 7206);
            final Map<K, Object> npe_invocation_var435 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var435, Map.class, 180, 7181, 7191)) {
                CallChecker.isCalled(npe_invocation_var435, Map.class, 180, 7181, 7191).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2306.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public V remove(Object key, Object value) {
        Collection<V> valuesForKey = CallChecker.varInit(getCollection(key), "valuesForKey", 198, 7812, 7859);
        if (valuesForKey == null) {
            return null;
        }
        boolean removed = CallChecker.varInit(((boolean) (valuesForKey.remove(value))), "removed", 202, 7940, 7984);
        if (removed == false) {
            return null;
        }
        if (valuesForKey.isEmpty()) {
            remove(key);
        }
        return ((V) (value));
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public boolean containsValue(Object value) {
        MethodContext _bcornu_methode_context2308 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 222, 8163, 8862);
            CallChecker.varInit(value, "value", 222, 8163, 8862);
            CallChecker.varInit(this.map, "map", 222, 8163, 8862);
            CallChecker.varInit(this.valuesView, "valuesView", 222, 8163, 8862);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 222, 8163, 8862);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 222, 8163, 8862);
            final Map<K, Object> npe_invocation_var436 = decorated();
            Set<Map.Entry<K, Object>> pairs = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(npe_invocation_var436, Map.class, 223, 8579, 8589)) {
                pairs = CallChecker.isCalled(npe_invocation_var436, Map.class, 223, 8579, 8589).entrySet();
                CallChecker.varAssign(pairs, "pairs", 223, 8579, 8589);
            }
            if (pairs != null) {
                for (Map.Entry<K, Object> entry : pairs) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 226, 8724, 8728)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 226, 8724, 8728).getValue(), Object.class, 226, 8724, 8739)) {
                            if (CallChecker.isCalled(((Collection<V>) (CallChecker.isCalled(entry, Map.Entry.class, 226, 8724, 8728).getValue())), Collection.class, 226, 8724, 8739).contains(value)) {
                                return true;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2308.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public Object put(K key, Object value) {
        MethodContext _bcornu_methode_context2309 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 246, 8869, 9976);
            CallChecker.varInit(value, "value", 246, 8869, 9976);
            CallChecker.varInit(key, "key", 246, 8869, 9976);
            CallChecker.varInit(this.map, "map", 246, 8869, 9976);
            CallChecker.varInit(this.valuesView, "valuesView", 246, 8869, 9976);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 246, 8869, 9976);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 246, 8869, 9976);
            boolean result = CallChecker.varInit(((boolean) (false)), "result", 247, 9428, 9450);
            Collection<V> coll = CallChecker.varInit(getCollection(key), "coll", 248, 9460, 9499);
            if (coll == null) {
                coll = createCollection(1);
                CallChecker.varAssign(coll, "coll", 250, 9541, 9567);
                if (CallChecker.beforeDeref(coll, Collection.class, 251, 9622, 9625)) {
                    coll = CallChecker.beforeCalled(coll, Collection.class, 251, 9622, 9625);
                    CallChecker.isCalled(coll, Collection.class, 251, 9622, 9625).add(((V) (value)));
                }
                if (CallChecker.beforeDeref(coll, Collection.class, 252, 9659, 9662)) {
                    coll = CallChecker.beforeCalled(coll, Collection.class, 252, 9659, 9662);
                    if ((CallChecker.isCalled(coll, Collection.class, 252, 9659, 9662).size()) > 0) {
                        final Map<K, Object> npe_invocation_var437 = decorated();
                        if (CallChecker.beforeDeref(npe_invocation_var437, Map.class, 254, 9763, 9773)) {
                            CallChecker.isCalled(npe_invocation_var437, Map.class, 254, 9763, 9773).put(key, coll);
                        }
                        result = true;
                        CallChecker.varAssign(result, "result", 255, 9807, 9820);
                    }
                }
            }else {
                result = coll.add(((V) (value)));
                CallChecker.varAssign(result, "result", 258, 9892, 9920);
            }
            if (result) {
                return value;
            }else {
                return null;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2309.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public void putAll(Map<? extends K, ?> map) {
        MethodContext _bcornu_methode_context2310 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 276, 9983, 10906);
            CallChecker.varInit(map, "map", 276, 9983, 10906);
            CallChecker.varInit(this.map, "map", 276, 9983, 10906);
            CallChecker.varInit(this.valuesView, "valuesView", 276, 9983, 10906);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 276, 9983, 10906);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 276, 9983, 10906);
            if (map instanceof MultiMap) {
                map = CallChecker.beforeCalled(map, MultiMap.class, 278, 10630, 10632);
                for (Map.Entry<? extends K, Object> entry : CallChecker.isCalled(((MultiMap<? extends K, V>) (map)), MultiMap.class, 278, 10630, 10632).entrySet()) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 279, 10672, 10676)) {
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 279, 10704, 10708)) {
                            putAll(entry.getKey(), ((Collection<V>) (CallChecker.isCalled(entry, Map.Entry.class, 279, 10704, 10708).getValue())));
                        }
                    }
                }
            }else {
                map = CallChecker.beforeCalled(map, Map.class, 282, 10805, 10807);
                for (Map.Entry<? extends K, ?> entry : CallChecker.isCalled(map, Map.class, 282, 10805, 10807).entrySet()) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 283, 10843, 10847)) {
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 283, 10859, 10863)) {
                            put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2310.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public Collection<Object> values() {
        MethodContext _bcornu_methode_context2311 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 297, 10913, 11378);
            CallChecker.varInit(this.map, "map", 297, 10913, 11378);
            CallChecker.varInit(this.valuesView, "valuesView", 297, 10913, 11378);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 297, 10913, 11378);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 297, 10913, 11378);
            Collection<V> vs = CallChecker.varInit(valuesView, "vs", 298, 11258, 11287);
            if (vs != null) {
                return ((Collection<Object>) (vs));
            }else {
                return ((Collection<Object>) (valuesView = new Values()));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<Object>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2311.methodEnd();
        }
    }

    public boolean containsValue(Object key, Object value) {
        MethodContext _bcornu_methode_context2312 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 308, 11385, 11792);
            CallChecker.varInit(value, "value", 308, 11385, 11792);
            CallChecker.varInit(key, "key", 308, 11385, 11792);
            CallChecker.varInit(this.map, "map", 308, 11385, 11792);
            CallChecker.varInit(this.valuesView, "valuesView", 308, 11385, 11792);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 308, 11385, 11792);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 308, 11385, 11792);
            Collection<V> coll = CallChecker.varInit(getCollection(key), "coll", 309, 11646, 11685);
            if (coll == null) {
                return false;
            }
            return coll.contains(value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2312.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public Collection<V> getCollection(Object key) {
        MethodContext _bcornu_methode_context2313 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 324, 11799, 12218);
            CallChecker.varInit(key, "key", 324, 11799, 12218);
            CallChecker.varInit(this.map, "map", 324, 11799, 12218);
            CallChecker.varInit(this.valuesView, "valuesView", 324, 11799, 12218);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 324, 11799, 12218);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 324, 11799, 12218);
            final Map<K, Object> npe_invocation_var438 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var438, Map.class, 325, 12192, 12202)) {
                return ((Collection<V>) (CallChecker.isCalled(npe_invocation_var438, Map.class, 325, 12192, 12202).get(key)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2313.methodEnd();
        }
    }

    public int size(Object key) {
        MethodContext _bcornu_methode_context2314 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 334, 12225, 12607);
            CallChecker.varInit(key, "key", 334, 12225, 12607);
            CallChecker.varInit(this.map, "map", 334, 12225, 12607);
            CallChecker.varInit(this.valuesView, "valuesView", 334, 12225, 12607);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 334, 12225, 12607);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 334, 12225, 12607);
            Collection<V> coll = CallChecker.varInit(getCollection(key), "coll", 335, 12474, 12513);
            if (coll == null) {
                return 0;
            }
            return coll.size();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2314.methodEnd();
        }
    }

    public boolean putAll(K key, Collection<V> values) {
        MethodContext _bcornu_methode_context2315 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 350, 12614, 13591);
            CallChecker.varInit(values, "values", 350, 12614, 13591);
            CallChecker.varInit(key, "key", 350, 12614, 13591);
            CallChecker.varInit(this.map, "map", 350, 12614, 13591);
            CallChecker.varInit(this.valuesView, "valuesView", 350, 12614, 13591);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 350, 12614, 13591);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 350, 12614, 13591);
            if ((values == null) || ((values.size()) == 0)) {
                return false;
            }
            boolean result = CallChecker.varInit(((boolean) (false)), "result", 354, 13048, 13070);
            Collection<V> coll = CallChecker.varInit(getCollection(key), "coll", 355, 13080, 13119);
            if (coll == null) {
                coll = createCollection(values.size());
                CallChecker.varAssign(coll, "coll", 357, 13161, 13199);
                if (CallChecker.beforeDeref(coll, Collection.class, 358, 13254, 13257)) {
                    coll = CallChecker.beforeCalled(coll, Collection.class, 358, 13254, 13257);
                    CallChecker.isCalled(coll, Collection.class, 358, 13254, 13257).addAll(values);
                }
                if (CallChecker.beforeDeref(coll, Collection.class, 359, 13291, 13294)) {
                    coll = CallChecker.beforeCalled(coll, Collection.class, 359, 13291, 13294);
                    if ((CallChecker.isCalled(coll, Collection.class, 359, 13291, 13294).size()) > 0) {
                        final Map<K, Object> npe_invocation_var439 = decorated();
                        if (CallChecker.beforeDeref(npe_invocation_var439, Map.class, 361, 13395, 13405)) {
                            CallChecker.isCalled(npe_invocation_var439, Map.class, 361, 13395, 13405).put(key, coll);
                        }
                        result = true;
                        CallChecker.varAssign(result, "result", 362, 13439, 13452);
                    }
                }
            }else {
                result = coll.addAll(values);
                CallChecker.varAssign(result, "result", 365, 13524, 13552);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2315.methodEnd();
        }
    }

    public Iterator<V> iterator(Object key) {
        MethodContext _bcornu_methode_context2316 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 376, 13598, 14014);
            CallChecker.varInit(key, "key", 376, 13598, 14014);
            CallChecker.varInit(this.map, "map", 376, 13598, 14014);
            CallChecker.varInit(this.valuesView, "valuesView", 376, 13598, 14014);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 376, 13598, 14014);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 376, 13598, 14014);
            if (!(containsKey(key))) {
                return EmptyIterator.<V>getInstance();
            }
            return new ValuesIterator(key);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2316.methodEnd();
        }
    }

    public int totalSize() {
        MethodContext _bcornu_methode_context2317 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 388, 14021, 14349);
            CallChecker.varInit(this.map, "map", 388, 14021, 14349);
            CallChecker.varInit(this.valuesView, "valuesView", 388, 14021, 14349);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 388, 14021, 14349);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 388, 14021, 14349);
            int total = CallChecker.varInit(((int) (0)), "total", 389, 14204, 14217);
            for (Object v : CallChecker.isCalled(decorated(), Map.class, 390, 14243, 14253).values()) {
                total += CollectionUtils.size(v);
                CallChecker.varAssign(total, "total", 391, 14279, 14311);
            }
            return total;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2317.methodEnd();
        }
    }

    protected Collection<V> createCollection(int size) {
        MethodContext _bcornu_methode_context2318 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 406, 14356, 14789);
            CallChecker.varInit(size, "size", 406, 14356, 14789);
            CallChecker.varInit(this.map, "map", 406, 14356, 14789);
            CallChecker.varInit(this.valuesView, "valuesView", 406, 14356, 14789);
            CallChecker.varInit(this.collectionFactory, "collectionFactory", 406, 14356, 14789);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiValueMap.serialVersionUID", 406, 14356, 14789);
            if (CallChecker.beforeDeref(collectionFactory, Factory.class, 407, 14757, 14773)) {
                return collectionFactory.create();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2318.methodEnd();
        }
    }

    private class Values extends AbstractCollection<V> {
        @Override
        public Iterator<V> iterator() {
            MethodContext _bcornu_methode_context2319 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 416, 15001, 15304);
                final IteratorChain<V> chain = CallChecker.varInit(new IteratorChain<V>(), "chain", 417, 15063, 15116);
                for (Iterator<K> it = CallChecker.isCalled(keySet(), Set.class, 418, 15152, 15159).iterator(); CallChecker.isCalled(it, Iterator.class, 418, 15173, 15174).hasNext();) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 419, 15243, 15244)) {
                        if (CallChecker.beforeDeref(chain, IteratorChain.class, 419, 15206, 15210)) {
                            CallChecker.isCalled(chain, IteratorChain.class, 419, 15206, 15210).addIterator(new ValuesIterator(it.next()));
                        }
                    }
                }
                return chain;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2319.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context2320 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 425, 15315, 15393);
                return totalSize();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2320.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context2321 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 430, 15404, 15492);
                MultiValueMap.this.clear();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2321.methodEnd();
            }
        }
    }

    private class ValuesIterator implements Iterator<V> {
        private final Object key;

        private final Collection<V> values;

        private final Iterator<V> iterator;

        public ValuesIterator(Object key) {
            MethodContext _bcornu_methode_context434 = new MethodContext(null);
            try {
                this.key = key;
                CallChecker.varAssign(this.key, "this.key", 444, 15808, 15822);
                this.values = getCollection(key);
                CallChecker.varAssign(this.values, "this.values", 445, 15836, 15868);
                this.iterator = CallChecker.isCalled(values, Collection.class, 446, 15898, 15903).iterator();
                CallChecker.varAssign(this.iterator, "this.iterator", 446, 15882, 15915);
            } finally {
                _bcornu_methode_context434.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context2322 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 449, 15936, 16096);
                CallChecker.varInit(this.iterator, "iterator", 449, 15936, 16096);
                CallChecker.varInit(this.values, "values", 449, 15936, 16096);
                CallChecker.varInit(this.key, "key", 449, 15936, 16096);
                if (CallChecker.beforeDeref(iterator, Iterator.class, 450, 15971, 15978)) {
                    CallChecker.isCalled(iterator, Iterator.class, 450, 15971, 15978).remove();
                }
                if (CallChecker.beforeDeref(values, Collection.class, 451, 16006, 16011)) {
                    if (CallChecker.isCalled(values, Collection.class, 451, 16006, 16011).isEmpty()) {
                        MultiValueMap.this.remove(key);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2322.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context2323 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 456, 16107, 16181);
                CallChecker.varInit(this.iterator, "iterator", 456, 16107, 16181);
                CallChecker.varInit(this.values, "values", 456, 16107, 16181);
                CallChecker.varInit(this.key, "key", 456, 16107, 16181);
                if (CallChecker.beforeDeref(iterator, Iterator.class, 457, 16153, 16160)) {
                    return CallChecker.isCalled(iterator, Iterator.class, 457, 16153, 16160).hasNext();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2323.methodEnd();
            }
        }

        public V next() {
            if (CallChecker.beforeDeref(iterator, Iterator.class, 461, 16229, 16236)) {
                return iterator.next();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    private static class ReflectionFactory<T extends Collection<?>> implements Serializable , Factory<T> {
        private static final long serialVersionUID = 2986114157496788874L;

        private final Class<T> clazz;

        public ReflectionFactory(Class<T> clazz) {
            MethodContext _bcornu_methode_context435 = new MethodContext(null);
            try {
                this.clazz = clazz;
                CallChecker.varAssign(this.clazz, "this.clazz", 476, 16663, 16681);
            } finally {
                _bcornu_methode_context435.methodEnd();
            }
        }

        public T create() {
            TryContext _bcornu_try_context_27 = new TryContext(27, MultiValueMap.class, "java.lang.Exception");
            try {
                if (CallChecker.beforeDeref(clazz, Class.class, 481, 16763, 16767)) {
                    return clazz.newInstance();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (Exception ex) {
                _bcornu_try_context_27.catchStart(27);
                throw new FunctorException(("Cannot instantiate class: " + (clazz)), ex);
            } finally {
                _bcornu_try_context_27.finallyStart(27);
            }
        }
    }
}

