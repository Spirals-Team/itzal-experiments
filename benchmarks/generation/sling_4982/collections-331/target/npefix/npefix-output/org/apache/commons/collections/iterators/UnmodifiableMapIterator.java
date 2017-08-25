package org.apache.commons.collections.iterators;

import org.apache.commons.collections.Unmodifiable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class UnmodifiableMapIterator<K, V> implements MapIterator<K, V> , Unmodifiable {
    private final MapIterator<K, V> iterator;

    public static <K, V> MapIterator<K, V> decorate(MapIterator<K, V> iterator) {
        MethodContext _bcornu_methode_context896 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(iterator, "iterator", 44, 1454, 2092);
            if (iterator == null) {
                throw new IllegalArgumentException("MapIterator must not be null");
            }
            if (iterator instanceof Unmodifiable) {
                return iterator;
            }
            return new UnmodifiableMapIterator<K, V>(iterator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context896.methodEnd();
        }
    }

    private UnmodifiableMapIterator(MapIterator<K, V> iterator) {
        super();
        MethodContext _bcornu_methode_context178 = new MethodContext(null);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 62, 2356, 2380);
        } finally {
            _bcornu_methode_context178.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context897 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 66, 2393, 2537);
            CallChecker.varInit(this.iterator, "iterator", 66, 2393, 2537);
            if (CallChecker.beforeDeref(iterator, MapIterator.class, 67, 2513, 2520)) {
                return CallChecker.isCalled(iterator, MapIterator.class, 67, 2513, 2520).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context897.methodEnd();
        }
    }

    public K next() {
        if (CallChecker.beforeDeref(iterator, MapIterator.class, 71, 2577, 2584)) {
            return iterator.next();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K getKey() {
        if (CallChecker.beforeDeref(iterator, MapIterator.class, 75, 2640, 2647)) {
            return iterator.getKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V getValue() {
        if (CallChecker.beforeDeref(iterator, MapIterator.class, 79, 2707, 2714)) {
            return iterator.getValue();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V setValue(V value) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }

    public void remove() {
        MethodContext _bcornu_methode_context902 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 86, 2859, 2964);
            CallChecker.varInit(this.iterator, "iterator", 86, 2859, 2964);
            throw new UnsupportedOperationException("remove() is not supported");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context902.methodEnd();
        }
    }
}

