package org.apache.commons.collections.map;

import java.util.SortedMap;
import java.util.Set;
import org.apache.commons.collections.OrderedMapIterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.IterableSortedMap;
import java.util.Iterator;
import java.util.ListIterator;
import org.apache.commons.collections.iterators.ListIteratorWrapper;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public abstract class AbstractSortedMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements IterableSortedMap<K, V> {
    protected AbstractSortedMapDecorator() {
        super();
        MethodContext _bcornu_methode_context220 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context220.methodEnd();
        }
    }

    public AbstractSortedMapDecorator(SortedMap<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context221 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context221.methodEnd();
        }
    }

    @Override
    protected SortedMap<K, V> decorated() {
        MethodContext _bcornu_methode_context1109 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 76, 2614, 2818);
            CallChecker.varInit(this.map, "map", 76, 2614, 2818);
            return ((SortedMap<K, V>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1109.methodEnd();
        }
    }

    public Comparator<? super K> comparator() {
        MethodContext _bcornu_methode_context1110 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 81, 2825, 2992);
            CallChecker.varInit(this.map, "map", 81, 2825, 2992);
            final SortedMap<K, V> npe_invocation_var253 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var253, SortedMap.class, 82, 2962, 2972)) {
                return CallChecker.isCalled(npe_invocation_var253, SortedMap.class, 82, 2962, 2972).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1110.methodEnd();
        }
    }

    public K firstKey() {
        final SortedMap<K, V> npe_invocation_var254 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var254, SortedMap.class, 86, 3036, 3046)) {
            return npe_invocation_var254.firstKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K lastKey() {
        final SortedMap<K, V> npe_invocation_var255 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var255, SortedMap.class, 90, 3107, 3117)) {
            return npe_invocation_var255.lastKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        MethodContext _bcornu_methode_context1113 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 93, 3141, 3248);
            CallChecker.varInit(toKey, "toKey", 93, 3141, 3248);
            CallChecker.varInit(fromKey, "fromKey", 93, 3141, 3248);
            CallChecker.varInit(this.map, "map", 93, 3141, 3248);
            final SortedMap<K, V> npe_invocation_var256 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var256, SortedMap.class, 94, 3208, 3218)) {
                return CallChecker.isCalled(npe_invocation_var256, SortedMap.class, 94, 3208, 3218).subMap(fromKey, toKey);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1113.methodEnd();
        }
    }

    public SortedMap<K, V> headMap(K toKey) {
        MethodContext _bcornu_methode_context1114 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 97, 3255, 3344);
            CallChecker.varInit(toKey, "toKey", 97, 3255, 3344);
            CallChecker.varInit(this.map, "map", 97, 3255, 3344);
            final SortedMap<K, V> npe_invocation_var257 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var257, SortedMap.class, 98, 3312, 3322)) {
                return CallChecker.isCalled(npe_invocation_var257, SortedMap.class, 98, 3312, 3322).headMap(toKey);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1114.methodEnd();
        }
    }

    public SortedMap<K, V> tailMap(K fromKey) {
        MethodContext _bcornu_methode_context1115 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 101, 3351, 3444);
            CallChecker.varInit(fromKey, "fromKey", 101, 3351, 3444);
            CallChecker.varInit(this.map, "map", 101, 3351, 3444);
            final SortedMap<K, V> npe_invocation_var258 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var258, SortedMap.class, 102, 3410, 3420)) {
                return CallChecker.isCalled(npe_invocation_var258, SortedMap.class, 102, 3410, 3420).tailMap(fromKey);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1115.methodEnd();
        }
    }

    public K previousKey(K key) {
        SortedMap<K, V> headMap = CallChecker.varInit(headMap(key), "headMap", 106, 3489, 3527);
        if (CallChecker.beforeDeref(headMap, SortedMap.class, 107, 3544, 3550)) {
            headMap = CallChecker.beforeCalled(headMap, SortedMap.class, 107, 3544, 3550);
            if (CallChecker.isCalled(headMap, SortedMap.class, 107, 3544, 3550).isEmpty()) {
                return null;
            }else {
                if (CallChecker.beforeDeref(headMap, SortedMap.class, 107, 3571, 3577)) {
                    return headMap.lastKey();
                }else
                    throw new AbnormalExecutionError();
                
            }
        }else
            throw new AbnormalExecutionError();
        
    }

    public K nextKey(K key) {
        final SortedMap<K, V> npe_invocation_var259 = tailMap(key);
        Iterator<K> it = CallChecker.init(Iterator.class);
        if (CallChecker.beforeDeref(npe_invocation_var259, SortedMap.class, 111, 3652, 3663)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var259, SortedMap.class, 111, 3652, 3663).keySet(), Set.class, 111, 3652, 3672)) {
                it = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var259, SortedMap.class, 111, 3652, 3663).keySet(), Set.class, 111, 3652, 3672).iterator();
                CallChecker.varAssign(it, "it", 111, 3652, 3663);
            }
        }
        if (CallChecker.beforeDeref(it, Iterator.class, 112, 3694, 3695)) {
            it.next();
        }
        if (CallChecker.beforeDeref(it, Iterator.class, 113, 3720, 3721)) {
            it = CallChecker.beforeCalled(it, Iterator.class, 113, 3720, 3721);
            if (CallChecker.isCalled(it, Iterator.class, 113, 3720, 3721).hasNext()) {
                if (CallChecker.beforeDeref(it, Iterator.class, 113, 3735, 3736)) {
                    return it.next();
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                return null;
            }
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public OrderedMapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context1118 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 120, 3764, 3923);
            CallChecker.varInit(this.map, "map", 120, 3764, 3923);
            return new AbstractSortedMapDecorator.SortedMapIterator<K, V>(entrySet());
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1118.methodEnd();
        }
    }

    protected static class SortedMapIterator<K, V> extends EntrySetToMapIteratorAdapter<K, V> implements OrderedMapIterator<K, V> {
        protected SortedMapIterator(Set<Map.Entry<K, V>> entrySet) {
            super(entrySet);
            MethodContext _bcornu_methode_context222 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context222.methodEnd();
            }
        }

        @Override
        public synchronized void reset() {
            MethodContext _bcornu_methode_context1119 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 144, 4383, 4595);
                CallChecker.varInit(this.entry, "entry", 144, 4383, 4595);
                CallChecker.varInit(this.iterator, "iterator", 144, 4383, 4595);
                CallChecker.varInit(this.entrySet, "entrySet", 144, 4383, 4595);
                super.reset();
                iterator = new ListIteratorWrapper<Map.Entry<K, V>>(iterator);
                CallChecker.varAssign(this.iterator, "this.iterator", 146, 4524, 4585);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1119.methodEnd();
            }
        }

        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context1120 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 152, 4606, 4771);
                CallChecker.varInit(this.entry, "entry", 152, 4606, 4771);
                CallChecker.varInit(this.iterator, "iterator", 152, 4606, 4771);
                CallChecker.varInit(this.entrySet, "entrySet", 152, 4606, 4771);
                if (CallChecker.beforeDeref(iterator, Iterator.class, 153, 4738, 4745)) {
                    iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 153, 4738, 4745);
                    return CallChecker.isCalled(((ListIterator<Map.Entry<K, V>>) (iterator)), ListIterator.class, 153, 4738, 4745).hasPrevious();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1120.methodEnd();
            }
        }

        public K previous() {
            if (CallChecker.beforeDeref(iterator, Iterator.class, 160, 4906, 4913)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 160, 4906, 4913);
                entry = CallChecker.isCalled(((ListIterator<Map.Entry<K, V>>) (iterator)), ListIterator.class, 160, 4906, 4913).previous();
                CallChecker.varAssign(this.entry, "this.entry", 160, 4865, 4926);
            }
            return getKey();
        }
    }
}

