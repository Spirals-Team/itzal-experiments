package org.apache.commons.collections.splitmap;

import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.commons.collections.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections.map.UnmodifiableEntrySet;
import org.apache.commons.collections.IterableMap;
import org.apache.commons.collections.IterableGet;
import org.apache.commons.collections.Get;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.map.EntrySetToMapIteratorAdapter;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.MapUtils;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.Put;
import java.util.Set;
import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.collection.UnmodifiableCollection;

public class SplitMapUtils {
    public SplitMapUtils() {
        MethodContext _bcornu_methode_context319 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context319.methodEnd();
        }
    }

    private static class WrappedGet<K, V> implements IterableMap<K, V> , Unmodifiable {
        private Get<K, V> get;

        private WrappedGet(Get<K, V> get) {
            MethodContext _bcornu_methode_context320 = new MethodContext(null);
            try {
                this.get = get;
                CallChecker.varAssign(this.get, "this.get", 59, 2258, 2272);
            } finally {
                _bcornu_methode_context320.methodEnd();
            }
        }

        public void clear() {
            MethodContext _bcornu_methode_context1627 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 62, 2293, 2378);
                CallChecker.varInit(this.get, "get", 62, 2293, 2378);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1627.methodEnd();
            }
        }

        public boolean containsKey(Object key) {
            MethodContext _bcornu_methode_context1628 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 66, 2389, 2479);
                CallChecker.varInit(key, "key", 66, 2389, 2479);
                CallChecker.varInit(this.get, "get", 66, 2389, 2479);
                if (CallChecker.beforeDeref(get, Get.class, 67, 2449, 2451)) {
                    get = CallChecker.beforeCalled(get, Get.class, 67, 2449, 2451);
                    return CallChecker.isCalled(get, Get.class, 67, 2449, 2451).containsKey(key);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1628.methodEnd();
            }
        }

        public boolean containsValue(Object value) {
            MethodContext _bcornu_methode_context1629 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 70, 2490, 2588);
                CallChecker.varInit(value, "value", 70, 2490, 2588);
                CallChecker.varInit(this.get, "get", 70, 2490, 2588);
                if (CallChecker.beforeDeref(get, Get.class, 71, 2554, 2556)) {
                    get = CallChecker.beforeCalled(get, Get.class, 71, 2554, 2556);
                    return CallChecker.isCalled(get, Get.class, 71, 2554, 2556).containsValue(value);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1629.methodEnd();
            }
        }

        public Set<Map.Entry<K, V>> entrySet() {
            MethodContext _bcornu_methode_context1630 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 74, 2599, 2724);
                CallChecker.varInit(this.get, "get", 74, 2599, 2724);
                if (CallChecker.beforeDeref(get, Get.class, 75, 2699, 2701)) {
                    get = CallChecker.beforeCalled(get, Get.class, 75, 2699, 2701);
                    return UnmodifiableEntrySet.decorate(CallChecker.isCalled(get, Get.class, 75, 2699, 2701).entrySet());
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1630.methodEnd();
            }
        }

        @Override
        public boolean equals(Object arg0) {
            MethodContext _bcornu_methode_context1631 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 79, 2735, 2970);
                CallChecker.varInit(arg0, "arg0", 79, 2735, 2970);
                CallChecker.varInit(this.get, "get", 79, 2735, 2970);
                if (arg0 == (this)) {
                    return true;
                }
                if (CallChecker.beforeDeref(arg0, Object.class, 83, 2934, 2937)) {
                    arg0 = CallChecker.beforeCalled(arg0, SplitMapUtils.WrappedGet.class, 83, 2934, 2937);
                    return (arg0 instanceof SplitMapUtils.WrappedGet) && (CallChecker.isCalled(CallChecker.isCalled(((SplitMapUtils.WrappedGet<?, ?>) (arg0)), SplitMapUtils.WrappedGet.class, 83, 2934, 2937).get, Get.class, 83, 2914, 2942).equals(this.get));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1631.methodEnd();
            }
        }

        public V get(Object key) {
            if (CallChecker.beforeDeref(get, Get.class, 87, 3027, 3029)) {
                return get.get(key);
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context1633 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 91, 3060, 3178);
                CallChecker.varInit(this.get, "get", 91, 3060, 3178);
                get = CallChecker.beforeCalled(get, Get.class, 92, 3154, 3156);
                return ((CallChecker.isCalled("WrappedGet", String.class, 92, 3122, 3133).hashCode()) << 4) | (CallChecker.isCalled(get, Get.class, 92, 3154, 3156).hashCode());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1633.methodEnd();
            }
        }

        public boolean isEmpty() {
            MethodContext _bcornu_methode_context1634 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 95, 3189, 3258);
                CallChecker.varInit(this.get, "get", 95, 3189, 3258);
                if (CallChecker.beforeDeref(get, Get.class, 96, 3235, 3237)) {
                    get = CallChecker.beforeCalled(get, Get.class, 96, 3235, 3237);
                    return CallChecker.isCalled(get, Get.class, 96, 3235, 3237).isEmpty();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1634.methodEnd();
            }
        }

        public Set<K> keySet() {
            MethodContext _bcornu_methode_context1635 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 99, 3269, 3361);
                CallChecker.varInit(this.get, "get", 99, 3269, 3361);
                if (CallChecker.beforeDeref(get, Get.class, 100, 3338, 3340)) {
                    get = CallChecker.beforeCalled(get, Get.class, 100, 3338, 3340);
                    return UnmodifiableSet.decorate(CallChecker.isCalled(get, Get.class, 100, 3338, 3340).keySet());
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1635.methodEnd();
            }
        }

        public V put(K key, V value) {
            throw new UnsupportedOperationException();
        }

        public void putAll(Map<? extends K, ? extends V> t) {
            MethodContext _bcornu_methode_context1637 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 107, 3477, 3594);
                CallChecker.varInit(t, "t", 107, 3477, 3594);
                CallChecker.varInit(this.get, "get", 107, 3477, 3594);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1637.methodEnd();
            }
        }

        public V remove(Object key) {
            if (CallChecker.beforeDeref(get, Get.class, 112, 3654, 3656)) {
                return get.remove(key);
            }else
                throw new AbnormalExecutionError();
            
        }

        public int size() {
            MethodContext _bcornu_methode_context1639 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 115, 3690, 3749);
                CallChecker.varInit(this.get, "get", 115, 3690, 3749);
                if (CallChecker.beforeDeref(get, Get.class, 116, 3729, 3731)) {
                    get = CallChecker.beforeCalled(get, Get.class, 116, 3729, 3731);
                    return CallChecker.isCalled(get, Get.class, 116, 3729, 3731).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1639.methodEnd();
            }
        }

        public Collection<V> values() {
            MethodContext _bcornu_methode_context1640 = new MethodContext(Collection.class);
            try {
                CallChecker.varInit(this, "this", 119, 3760, 3866);
                CallChecker.varInit(this.get, "get", 119, 3760, 3866);
                if (CallChecker.beforeDeref(get, Get.class, 120, 3843, 3845)) {
                    get = CallChecker.beforeCalled(get, Get.class, 120, 3843, 3845);
                    return UnmodifiableCollection.decorate(CallChecker.isCalled(get, Get.class, 120, 3843, 3845).values());
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1640.methodEnd();
            }
        }

        public MapIterator<K, V> mapIterator() {
            MethodContext _bcornu_methode_context1641 = new MethodContext(MapIterator.class);
            try {
                CallChecker.varInit(this, "this", 123, 3877, 4237);
                CallChecker.varInit(this.get, "get", 123, 3877, 4237);
                MapIterator<K, V> it = CallChecker.init(MapIterator.class);
                if ((get) instanceof IterableGet) {
                    if (CallChecker.beforeDeref(get, Get.class, 126, 4040, 4042)) {
                        get = CallChecker.beforeCalled(get, IterableGet.class, 126, 4040, 4042);
                        it = CallChecker.isCalled(((IterableGet<K, V>) (get)), IterableGet.class, 126, 4040, 4042).mapIterator();
                        CallChecker.varAssign(it, "it", 126, 4014, 4058);
                    }
                }else {
                    if (CallChecker.beforeDeref(get, Get.class, 128, 4141, 4143)) {
                        get = CallChecker.beforeCalled(get, Get.class, 128, 4141, 4143);
                        it = new EntrySetToMapIteratorAdapter<K, V>(CallChecker.isCalled(get, Get.class, 128, 4141, 4143).entrySet());
                        CallChecker.varAssign(it, "it", 128, 4097, 4156);
                    }
                }
                return UnmodifiableMapIterator.decorate(it);
            } catch (ForceReturn _bcornu_return_t) {
                return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1641.methodEnd();
            }
        }
    }

    private static class WrappedPut<K, V> implements Map<K, V> , Put<K, V> {
        private Put<K, V> put;

        private WrappedPut(Put<K, V> put) {
            MethodContext _bcornu_methode_context321 = new MethodContext(null);
            try {
                this.put = put;
                CallChecker.varAssign(this.put, "this.put", 138, 4410, 4424);
            } finally {
                _bcornu_methode_context321.methodEnd();
            }
        }

        public void clear() {
            MethodContext _bcornu_methode_context1642 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 141, 4445, 4500);
                CallChecker.varInit(this.put, "put", 141, 4445, 4500);
                if (CallChecker.beforeDeref(put, Put.class, 142, 4479, 4481)) {
                    put = CallChecker.beforeCalled(put, Put.class, 142, 4479, 4481);
                    CallChecker.isCalled(put, Put.class, 142, 4479, 4481).clear();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1642.methodEnd();
            }
        }

        public boolean containsKey(Object key) {
            MethodContext _bcornu_methode_context1643 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 145, 4511, 4615);
                CallChecker.varInit(key, "key", 145, 4511, 4615);
                CallChecker.varInit(this.put, "put", 145, 4511, 4615);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1643.methodEnd();
            }
        }

        public boolean containsValue(Object value) {
            MethodContext _bcornu_methode_context1644 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 149, 4626, 4734);
                CallChecker.varInit(value, "value", 149, 4626, 4734);
                CallChecker.varInit(this.put, "put", 149, 4626, 4734);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1644.methodEnd();
            }
        }

        public Set<Map.Entry<K, V>> entrySet() {
            MethodContext _bcornu_methode_context1645 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 153, 4745, 4859);
                CallChecker.varInit(this.put, "put", 153, 4745, 4859);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1645.methodEnd();
            }
        }

        @Override
        public boolean equals(Object obj) {
            MethodContext _bcornu_methode_context1646 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 158, 4870, 5101);
                CallChecker.varInit(obj, "obj", 158, 4870, 5101);
                CallChecker.varInit(this.put, "put", 158, 4870, 5101);
                if (obj == (this)) {
                    return true;
                }
                if (CallChecker.beforeDeref(obj, Object.class, 162, 5066, 5068)) {
                    obj = CallChecker.beforeCalled(obj, SplitMapUtils.WrappedPut.class, 162, 5066, 5068);
                    return (obj instanceof SplitMapUtils.WrappedPut) && (CallChecker.isCalled(CallChecker.isCalled(((SplitMapUtils.WrappedPut<?, ?>) (obj)), SplitMapUtils.WrappedPut.class, 162, 5066, 5068).put, Put.class, 162, 5046, 5073).equals(this.put));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1646.methodEnd();
            }
        }

        public V get(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context1648 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 170, 5213, 5331);
                CallChecker.varInit(this.put, "put", 170, 5213, 5331);
                put = CallChecker.beforeCalled(put, Put.class, 171, 5307, 5309);
                return ((CallChecker.isCalled("WrappedPut", String.class, 171, 5275, 5286).hashCode()) << 4) | (CallChecker.isCalled(put, Put.class, 171, 5307, 5309).hashCode());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1648.methodEnd();
            }
        }

        public boolean isEmpty() {
            MethodContext _bcornu_methode_context1649 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 174, 5342, 5432);
                CallChecker.varInit(this.put, "put", 174, 5342, 5432);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1649.methodEnd();
            }
        }

        public Set<K> keySet() {
            MethodContext _bcornu_methode_context1650 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 178, 5443, 5531);
                CallChecker.varInit(this.put, "put", 178, 5443, 5531);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1650.methodEnd();
            }
        }

        @SuppressWarnings(value = "unchecked")
        public V put(K key, V value) {
            if (CallChecker.beforeDeref(put, Put.class, 184, 5635, 5637)) {
                put = CallChecker.beforeCalled(put, Put.class, 184, 5635, 5637);
                return ((V) (CallChecker.isCalled(put, Put.class, 184, 5635, 5637).put(key, value)));
            }else
                throw new AbnormalExecutionError();
            
        }

        public void putAll(Map<? extends K, ? extends V> t) {
            MethodContext _bcornu_methode_context1652 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 187, 5675, 5764);
                CallChecker.varInit(t, "t", 187, 5675, 5764);
                CallChecker.varInit(this.put, "put", 187, 5675, 5764);
                if (CallChecker.beforeDeref(put, Put.class, 188, 5741, 5743)) {
                    put = CallChecker.beforeCalled(put, Put.class, 188, 5741, 5743);
                    CallChecker.isCalled(put, Put.class, 188, 5741, 5743).putAll(t);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1652.methodEnd();
            }
        }

        public V remove(Object key) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            MethodContext _bcornu_methode_context1654 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 195, 5879, 5962);
                CallChecker.varInit(this.put, "put", 195, 5879, 5962);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1654.methodEnd();
            }
        }

        public Collection<V> values() {
            MethodContext _bcornu_methode_context1655 = new MethodContext(Collection.class);
            try {
                CallChecker.varInit(this, "this", 199, 5973, 6068);
                CallChecker.varInit(this.put, "put", 199, 5973, 6068);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1655.methodEnd();
            }
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <K, V> IterableMap<K, V> readableMap(Get<K, V> get) {
        MethodContext _bcornu_methode_context1656 = new MethodContext(IterableMap.class);
        try {
            CallChecker.varInit(get, "get", 215, 6081, 7004);
            if (get == null) {
                throw new IllegalArgumentException("Get must not be null");
            }
            if (get instanceof Map) {
                if (get instanceof IterableMap) {
                    return ((IterableMap<K, V>) (get));
                }else {
                    return MapUtils.iterableMap(((Map<K, V>) (get)));
                }
            }
            return new SplitMapUtils.WrappedGet<K, V>(get);
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1656.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <K, V> Map<K, V> writableMap(Put<K, V> put) {
        MethodContext _bcornu_methode_context1657 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(put, "put", 239, 7011, 7851);
            if (put == null) {
                throw new IllegalArgumentException("Put must not be null");
            }
            if (put instanceof Map) {
                return ((Map<K, V>) (put));
            }
            return new SplitMapUtils.WrappedPut<K, V>(put);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1657.methodEnd();
        }
    }
}

