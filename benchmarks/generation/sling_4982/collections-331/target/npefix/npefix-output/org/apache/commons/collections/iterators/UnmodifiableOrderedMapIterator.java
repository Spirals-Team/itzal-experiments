package org.apache.commons.collections.iterators;

import org.apache.commons.collections.Unmodifiable;
import org.apache.commons.collections.OrderedMapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class UnmodifiableOrderedMapIterator<K, V> implements OrderedMapIterator<K, V> , Unmodifiable {
    private OrderedMapIterator<K, V> iterator;

    public static <K, V> OrderedMapIterator<K, V> decorate(OrderedMapIterator<K, V> iterator) {
        MethodContext _bcornu_methode_context1618 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(iterator, "iterator", 45, 1493, 2159);
            if (iterator == null) {
                throw new IllegalArgumentException("OrderedMapIterator must not be null");
            }
            if (iterator instanceof Unmodifiable) {
                return iterator;
            }
            return new UnmodifiableOrderedMapIterator<K, V>(iterator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1618.methodEnd();
        }
    }

    private UnmodifiableOrderedMapIterator(OrderedMapIterator<K, V> iterator) {
        super();
        MethodContext _bcornu_methode_context318 = new MethodContext(null);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 63, 2437, 2461);
        } finally {
            _bcornu_methode_context318.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1619 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 67, 2474, 2618);
            CallChecker.varInit(this.iterator, "iterator", 67, 2474, 2618);
            if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 68, 2594, 2601)) {
                iterator = CallChecker.beforeCalled(iterator, OrderedMapIterator.class, 68, 2594, 2601);
                return CallChecker.isCalled(iterator, OrderedMapIterator.class, 68, 2594, 2601).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1619.methodEnd();
        }
    }

    public K next() {
        if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 72, 2658, 2665)) {
            return iterator.next();
        }else
            throw new AbnormalExecutionError();
        
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context1621 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 75, 2686, 2760);
            CallChecker.varInit(this.iterator, "iterator", 75, 2686, 2760);
            if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 76, 2732, 2739)) {
                iterator = CallChecker.beforeCalled(iterator, OrderedMapIterator.class, 76, 2732, 2739);
                return CallChecker.isCalled(iterator, OrderedMapIterator.class, 76, 2732, 2739).hasPrevious();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1621.methodEnd();
        }
    }

    public K previous() {
        if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 80, 2804, 2811)) {
            return iterator.previous();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K getKey() {
        if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 84, 2871, 2878)) {
            return iterator.getKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V getValue() {
        if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 88, 2938, 2945)) {
            return iterator.getValue();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V setValue(V value) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }

    public void remove() {
        MethodContext _bcornu_methode_context1626 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 95, 3090, 3195);
            CallChecker.varInit(this.iterator, "iterator", 95, 3090, 3195);
            throw new UnsupportedOperationException("remove() is not supported");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1626.methodEnd();
        }
    }
}

