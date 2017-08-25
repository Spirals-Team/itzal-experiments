package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractUntypedIteratorDecorator<I, O> implements Iterator<O> {
    protected final Iterator<I> iterator;

    protected AbstractUntypedIteratorDecorator(Iterator<I> iterator) {
        super();
        MethodContext _bcornu_methode_context464 = new MethodContext(null);
        try {
            if (iterator == null) {
                throw new IllegalArgumentException("Iterator must not be null");
            }
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 47, 1765, 1789);
        } finally {
            _bcornu_methode_context464.methodEnd();
        }
    }

    protected Iterator<I> getIterator() {
        MethodContext _bcornu_methode_context2436 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 55, 1802, 1973);
            CallChecker.varInit(this.iterator, "iterator", 55, 1802, 1973);
            return iterator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<I>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2436.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context2437 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 59, 1980, 2046);
            CallChecker.varInit(this.iterator, "iterator", 59, 1980, 2046);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 60, 2022, 2029)) {
                return CallChecker.isCalled(iterator, Iterator.class, 60, 2022, 2029).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2437.methodEnd();
        }
    }

    public void remove() {
        MethodContext _bcornu_methode_context2438 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 63, 2053, 2107);
            CallChecker.varInit(this.iterator, "iterator", 63, 2053, 2107);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 64, 2084, 2091)) {
                CallChecker.isCalled(iterator, Iterator.class, 64, 2084, 2091).remove();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2438.methodEnd();
        }
    }
}

