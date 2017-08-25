package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class AbstractMapIteratorDecorator<K, V> implements MapIterator<K, V> {
    protected final MapIterator<K, V> iterator;

    public AbstractMapIteratorDecorator(MapIterator<K, V> iterator) {
        super();
        MethodContext _bcornu_methode_context394 = new MethodContext(null);
        try {
            if (iterator == null) {
                throw new IllegalArgumentException("MapIterator must not be null");
            }
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 48, 1902, 1926);
        } finally {
            _bcornu_methode_context394.methodEnd();
        }
    }

    protected MapIterator<K, V> getMapIterator() {
        MethodContext _bcornu_methode_context2044 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 56, 1939, 2119);
            CallChecker.varInit(this.iterator, "iterator", 56, 1939, 2119);
            return iterator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2044.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context2045 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 61, 2126, 2270);
            CallChecker.varInit(this.iterator, "iterator", 61, 2126, 2270);
            if (CallChecker.beforeDeref(iterator, MapIterator.class, 62, 2246, 2253)) {
                return CallChecker.isCalled(iterator, MapIterator.class, 62, 2246, 2253).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2045.methodEnd();
        }
    }

    public K next() {
        if (CallChecker.beforeDeref(iterator, MapIterator.class, 66, 2310, 2317)) {
            return iterator.next();
        }else
            throw new AbnormalExecutionError();
        
    }

    public void remove() {
        MethodContext _bcornu_methode_context2047 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 69, 2338, 2392);
            CallChecker.varInit(this.iterator, "iterator", 69, 2338, 2392);
            if (CallChecker.beforeDeref(iterator, MapIterator.class, 70, 2369, 2376)) {
                CallChecker.isCalled(iterator, MapIterator.class, 70, 2369, 2376).remove();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2047.methodEnd();
        }
    }

    public K getKey() {
        if (CallChecker.beforeDeref(iterator, MapIterator.class, 74, 2438, 2445)) {
            return iterator.getKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V getValue() {
        if (CallChecker.beforeDeref(iterator, MapIterator.class, 78, 2505, 2512)) {
            return iterator.getValue();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V setValue(V obj) {
        if (CallChecker.beforeDeref(iterator, MapIterator.class, 82, 2579, 2586)) {
            return iterator.setValue(obj);
        }else
            throw new AbnormalExecutionError();
        
    }
}

