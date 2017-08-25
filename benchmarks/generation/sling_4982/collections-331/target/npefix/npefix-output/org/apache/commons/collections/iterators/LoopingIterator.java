package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableIterator;

public class LoopingIterator<E> implements ResettableIterator<E> {
    private Collection<? extends E> collection;

    private Iterator<? extends E> iterator;

    public LoopingIterator(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context97 = new MethodContext(null);
        try {
            if (coll == null) {
                throw new NullPointerException("The collection must not be null");
            }
            collection = coll;
            CallChecker.varAssign(this.collection, "this.collection", 61, 2416, 2433);
            reset();
        } finally {
            _bcornu_methode_context97.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context536 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 73, 2463, 2809);
            CallChecker.varInit(this.iterator, "iterator", 73, 2463, 2809);
            CallChecker.varInit(this.collection, "collection", 73, 2463, 2809);
            collection = CallChecker.beforeCalled(collection, Collection.class, 74, 2781, 2790);
            return (CallChecker.isCalled(collection, Collection.class, 74, 2781, 2790).size()) > 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context536.methodEnd();
        }
    }

    public E next() {
        if (CallChecker.beforeDeref(collection, Collection.class, 86, 3126, 3135)) {
            collection = CallChecker.beforeCalled(collection, Collection.class, 86, 3126, 3135);
            if ((CallChecker.isCalled(collection, Collection.class, 86, 3126, 3135).size()) == 0) {
                throw new NoSuchElementException("There are no elements for this iterator to loop on");
            }
        }else
            throw new AbnormalExecutionError();
        
        if (CallChecker.beforeDeref(iterator, Iterator.class, 89, 3274, 3281)) {
            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 89, 3274, 3281);
            if ((CallChecker.isCalled(iterator, Iterator.class, 89, 3274, 3281).hasNext()) == false) {
                reset();
            }
        }
        if (CallChecker.beforeDeref(iterator, Iterator.class, 92, 3351, 3358)) {
            return iterator.next();
        }else
            throw new AbnormalExecutionError();
        
    }

    public void remove() {
        MethodContext _bcornu_methode_context538 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 107, 3379, 4024);
            CallChecker.varInit(this.iterator, "iterator", 107, 3379, 4024);
            CallChecker.varInit(this.collection, "collection", 107, 3379, 4024);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 108, 4001, 4008)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 108, 4001, 4008);
                CallChecker.isCalled(iterator, Iterator.class, 108, 4001, 4008).remove();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context538.methodEnd();
        }
    }

    public void reset() {
        MethodContext _bcornu_methode_context539 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 114, 4031, 4179);
            CallChecker.varInit(this.iterator, "iterator", 114, 4031, 4179);
            CallChecker.varInit(this.collection, "collection", 114, 4031, 4179);
            if (CallChecker.beforeDeref(collection, Collection.class, 115, 4152, 4161)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 115, 4152, 4161);
                iterator = CallChecker.isCalled(collection, Collection.class, 115, 4152, 4161).iterator();
                CallChecker.varAssign(this.iterator, "this.iterator", 115, 4141, 4173);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context539.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context540 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 123, 4186, 4375);
            CallChecker.varInit(this.iterator, "iterator", 123, 4186, 4375);
            CallChecker.varInit(this.collection, "collection", 123, 4186, 4375);
            if (CallChecker.beforeDeref(collection, Collection.class, 124, 4352, 4361)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 124, 4352, 4361);
                return CallChecker.isCalled(collection, Collection.class, 124, 4352, 4361).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context540.methodEnd();
        }
    }
}

