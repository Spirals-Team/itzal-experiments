package org.apache.commons.collections.map;

import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.OrderedMap;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractOrderedMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements OrderedMap<K, V> {
    protected AbstractOrderedMapDecorator() {
        super();
        MethodContext _bcornu_methode_context377 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context377.methodEnd();
        }
    }

    public AbstractOrderedMapDecorator(OrderedMap<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context378 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context378.methodEnd();
        }
    }

    @Override
    protected OrderedMap<K, V> decorated() {
        MethodContext _bcornu_methode_context1944 = new MethodContext(OrderedMap.class);
        try {
            CallChecker.varInit(this, "this", 66, 2289, 2495);
            CallChecker.varInit(this.map, "map", 66, 2289, 2495);
            return ((OrderedMap<K, V>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1944.methodEnd();
        }
    }

    public K firstKey() {
        final OrderedMap<K, V> npe_invocation_var381 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var381, OrderedMap.class, 72, 2617, 2627)) {
            return npe_invocation_var381.firstKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K lastKey() {
        final OrderedMap<K, V> npe_invocation_var382 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var382, OrderedMap.class, 76, 2688, 2698)) {
            return npe_invocation_var382.lastKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K nextKey(K key) {
        final OrderedMap<K, V> npe_invocation_var383 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var383, OrderedMap.class, 80, 2763, 2773)) {
            return npe_invocation_var383.nextKey(key);
        }else
            throw new AbnormalExecutionError();
        
    }

    public K previousKey(K key) {
        final OrderedMap<K, V> npe_invocation_var384 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var384, OrderedMap.class, 84, 2845, 2855)) {
            return npe_invocation_var384.previousKey(key);
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public OrderedMapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context1949 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 88, 2886, 2994);
            CallChecker.varInit(this.map, "map", 88, 2886, 2994);
            final OrderedMap<K, V> npe_invocation_var385 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var385, OrderedMap.class, 89, 2963, 2973)) {
                return CallChecker.isCalled(npe_invocation_var385, OrderedMap.class, 89, 2963, 2973).mapIterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1949.methodEnd();
        }
    }
}

