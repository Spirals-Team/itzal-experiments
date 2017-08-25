package org.apache.commons.collections.bidimap;

import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.OrderedBidiMap;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.map.AbstractMapDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractOrderedBidiMapDecorator<K, V> extends AbstractBidiMapDecorator<K, V> implements OrderedBidiMap<K, V> {
    protected AbstractOrderedBidiMapDecorator(OrderedBidiMap<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context76 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context76.methodEnd();
        }
    }

    @Override
    protected OrderedBidiMap<K, V> decorated() {
        MethodContext _bcornu_methode_context460 = new MethodContext(OrderedBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 59, 2130, 2344);
            CallChecker.varInit(this.map, "map", 59, 2130, 2344);
            return ((OrderedBidiMap<K, V>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedBidiMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context460.methodEnd();
        }
    }

    @Override
    public OrderedMapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context461 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 65, 2351, 2537);
            CallChecker.varInit(this.map, "map", 65, 2351, 2537);
            final OrderedBidiMap<K, V> npe_invocation_var122 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var122, OrderedBidiMap.class, 66, 2506, 2516)) {
                return CallChecker.isCalled(npe_invocation_var122, OrderedBidiMap.class, 66, 2506, 2516).mapIterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context461.methodEnd();
        }
    }

    public K firstKey() {
        final OrderedBidiMap<K, V> npe_invocation_var123 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var123, OrderedBidiMap.class, 70, 2581, 2591)) {
            return npe_invocation_var123.firstKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K lastKey() {
        final OrderedBidiMap<K, V> npe_invocation_var124 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var124, OrderedBidiMap.class, 74, 2652, 2662)) {
            return npe_invocation_var124.lastKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K nextKey(K key) {
        final OrderedBidiMap<K, V> npe_invocation_var125 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var125, OrderedBidiMap.class, 78, 2727, 2737)) {
            return npe_invocation_var125.nextKey(key);
        }else
            throw new AbnormalExecutionError();
        
    }

    public K previousKey(K key) {
        final OrderedBidiMap<K, V> npe_invocation_var126 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var126, OrderedBidiMap.class, 82, 2809, 2819)) {
            return npe_invocation_var126.previousKey(key);
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public OrderedBidiMap<V, K> inverseBidiMap() {
        MethodContext _bcornu_methode_context466 = new MethodContext(OrderedBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 86, 2850, 2960);
            CallChecker.varInit(this.map, "map", 86, 2850, 2960);
            final OrderedBidiMap<K, V> npe_invocation_var127 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var127, OrderedBidiMap.class, 87, 2926, 2936)) {
                return CallChecker.isCalled(npe_invocation_var127, OrderedBidiMap.class, 87, 2926, 2936).inverseBidiMap();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedBidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context466.methodEnd();
        }
    }
}

