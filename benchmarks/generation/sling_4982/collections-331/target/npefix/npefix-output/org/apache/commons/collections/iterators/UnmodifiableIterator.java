package org.apache.commons.collections.iterators;

import org.apache.commons.collections.Unmodifiable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class UnmodifiableIterator<E> implements Iterator<E> , Unmodifiable {
    private final Iterator<E> iterator;

    public static <E> Iterator<E> decorate(Iterator<E> iterator) {
        MethodContext _bcornu_methode_context269 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(iterator, "iterator", 47, 1410, 2107);
            if (iterator == null) {
                throw new IllegalArgumentException("Iterator must not be null");
            }
            if (iterator instanceof Unmodifiable) {
                return iterator;
            }
            return new UnmodifiableIterator<E>(iterator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context269.methodEnd();
        }
    }

    private UnmodifiableIterator(Iterator<E> iterator) {
        super();
        MethodContext _bcornu_methode_context38 = new MethodContext(null);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 65, 2362, 2386);
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context270 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 69, 2399, 2543);
            CallChecker.varInit(this.iterator, "iterator", 69, 2399, 2543);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 70, 2519, 2526)) {
                return CallChecker.isCalled(iterator, Iterator.class, 70, 2519, 2526).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context270.methodEnd();
        }
    }

    public E next() {
        if (CallChecker.beforeDeref(iterator, Iterator.class, 74, 2583, 2590)) {
            return iterator.next();
        }else
            throw new AbnormalExecutionError();
        
    }

    public void remove() {
        MethodContext _bcornu_methode_context272 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 77, 2611, 2716);
            CallChecker.varInit(this.iterator, "iterator", 77, 2611, 2716);
            throw new UnsupportedOperationException("remove() is not supported");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context272.methodEnd();
        }
    }
}

