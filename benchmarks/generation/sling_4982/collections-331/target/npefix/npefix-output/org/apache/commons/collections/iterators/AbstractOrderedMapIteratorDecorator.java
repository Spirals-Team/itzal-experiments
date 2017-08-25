package org.apache.commons.collections.iterators;

import org.apache.commons.collections.OrderedMapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class AbstractOrderedMapIteratorDecorator<K, V> implements OrderedMapIterator<K, V> {
    protected final OrderedMapIterator<K, V> iterator;

    public AbstractOrderedMapIteratorDecorator(OrderedMapIterator<K, V> iterator) {
        super();
        MethodContext _bcornu_methode_context395 = new MethodContext(null);
        try {
            if (iterator == null) {
                throw new IllegalArgumentException("OrderedMapIterator must not be null");
            }
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 48, 1960, 1984);
        } finally {
            _bcornu_methode_context395.methodEnd();
        }
    }

    protected OrderedMapIterator<K, V> getOrderedMapIterator() {
        MethodContext _bcornu_methode_context2051 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 56, 1997, 2191);
            CallChecker.varInit(this.iterator, "iterator", 56, 1997, 2191);
            return iterator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2051.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context2052 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 61, 2198, 2342);
            CallChecker.varInit(this.iterator, "iterator", 61, 2198, 2342);
            if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 62, 2318, 2325)) {
                return CallChecker.isCalled(iterator, OrderedMapIterator.class, 62, 2318, 2325).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2052.methodEnd();
        }
    }

    public K next() {
        if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 66, 2382, 2389)) {
            return iterator.next();
        }else
            throw new AbnormalExecutionError();
        
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context2054 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 69, 2410, 2484);
            CallChecker.varInit(this.iterator, "iterator", 69, 2410, 2484);
            if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 70, 2456, 2463)) {
                return CallChecker.isCalled(iterator, OrderedMapIterator.class, 70, 2456, 2463).hasPrevious();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2054.methodEnd();
        }
    }

    public K previous() {
        if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 74, 2528, 2535)) {
            return iterator.previous();
        }else
            throw new AbnormalExecutionError();
        
    }

    public void remove() {
        MethodContext _bcornu_methode_context2056 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 77, 2560, 2614);
            CallChecker.varInit(this.iterator, "iterator", 77, 2560, 2614);
            if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 78, 2591, 2598)) {
                CallChecker.isCalled(iterator, OrderedMapIterator.class, 78, 2591, 2598).remove();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2056.methodEnd();
        }
    }

    public K getKey() {
        if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 82, 2660, 2667)) {
            return iterator.getKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V getValue() {
        if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 86, 2727, 2734)) {
            return iterator.getValue();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V setValue(V obj) {
        if (CallChecker.beforeDeref(iterator, OrderedMapIterator.class, 90, 2801, 2808)) {
            return iterator.setValue(obj);
        }else
            throw new AbnormalExecutionError();
        
    }
}

