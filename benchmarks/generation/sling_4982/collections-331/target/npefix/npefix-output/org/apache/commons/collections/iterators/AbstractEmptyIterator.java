package org.apache.commons.collections.iterators;

import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

abstract class AbstractEmptyIterator<E> {
    protected AbstractEmptyIterator() {
        super();
        MethodContext _bcornu_methode_context275 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context275.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1461 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 38, 1264, 1317);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1461.methodEnd();
        }
    }

    public E next() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context1463 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 46, 1428, 1485);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1463.methodEnd();
        }
    }

    public E previous() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int nextIndex() {
        MethodContext _bcornu_methode_context1465 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 54, 1600, 1647);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1465.methodEnd();
        }
    }

    public int previousIndex() {
        MethodContext _bcornu_methode_context1466 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 58, 1654, 1706);
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1466.methodEnd();
        }
    }

    public void add(E obj) {
        MethodContext _bcornu_methode_context1467 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 62, 1713, 1833);
            CallChecker.varInit(obj, "obj", 62, 1713, 1833);
            throw new UnsupportedOperationException("add() not supported for empty Iterator");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1467.methodEnd();
        }
    }

    public void set(E obj) {
        MethodContext _bcornu_methode_context1468 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 66, 1840, 1943);
            CallChecker.varInit(obj, "obj", 66, 1840, 1943);
            throw new IllegalStateException("Iterator contains no elements");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1468.methodEnd();
        }
    }

    public void remove() {
        MethodContext _bcornu_methode_context1469 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 70, 1950, 2051);
            throw new IllegalStateException("Iterator contains no elements");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1469.methodEnd();
        }
    }

    public void reset() {
        MethodContext _bcornu_methode_context1470 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 74, 2058, 2106);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1470.methodEnd();
        }
    }
}

