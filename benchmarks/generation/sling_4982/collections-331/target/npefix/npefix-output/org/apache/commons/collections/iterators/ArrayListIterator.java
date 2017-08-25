package org.apache.commons.collections.iterators;

import org.apache.commons.collections.ResettableListIterator;
import java.lang.reflect.Array;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;

public class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E> , ResettableListIterator<E> {
    protected int lastItemIndex = -1;

    public ArrayListIterator() {
        super();
        MethodContext _bcornu_methode_context326 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context326.methodEnd();
        }
    }

    public ArrayListIterator(Object array) {
        super(array);
        MethodContext _bcornu_methode_context327 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context327.methodEnd();
        }
    }

    public ArrayListIterator(Object array, int startIndex) {
        super(array, startIndex);
        MethodContext _bcornu_methode_context328 = new MethodContext(null);
        try {
            this.startIndex = startIndex;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 95, 3682, 3710);
        } finally {
            _bcornu_methode_context328.methodEnd();
        }
    }

    public ArrayListIterator(Object array, int startIndex, int endIndex) {
        super(array, startIndex, endIndex);
        MethodContext _bcornu_methode_context329 = new MethodContext(null);
        try {
            this.startIndex = startIndex;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 112, 4469, 4497);
        } finally {
            _bcornu_methode_context329.methodEnd();
        }
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context1702 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 122, 4510, 4861);
            CallChecker.varInit(this.index, "index", 122, 4510, 4861);
            CallChecker.varInit(this.endIndex, "endIndex", 122, 4510, 4861);
            CallChecker.varInit(this.startIndex, "startIndex", 122, 4510, 4861);
            CallChecker.varInit(this.array, "array", 122, 4510, 4861);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 122, 4510, 4861);
            return (this.index) > (this.startIndex);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1702.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public E previous() {
        if ((hasPrevious()) == false) {
            throw new NoSuchElementException();
        }
        this.lastItemIndex = --(this.index);
        CallChecker.varAssign(this.lastItemIndex, "this.lastItemIndex", 137, 5208, 5241);
        return ((E) (Array.get(this.array, this.index)));
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public E next() {
        if ((hasNext()) == false) {
            throw new NoSuchElementException();
        }
        this.lastItemIndex = this.index;
        CallChecker.varAssign(this.lastItemIndex, "this.lastItemIndex", 153, 5642, 5673);
        return ((E) (Array.get(this.array, ((this.index)++))));
    }

    public int nextIndex() {
        MethodContext _bcornu_methode_context1705 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 162, 5742, 5942);
            CallChecker.varInit(this.index, "index", 162, 5742, 5942);
            CallChecker.varInit(this.endIndex, "endIndex", 162, 5742, 5942);
            CallChecker.varInit(this.startIndex, "startIndex", 162, 5742, 5942);
            CallChecker.varInit(this.array, "array", 162, 5742, 5942);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 162, 5742, 5942);
            return (this.index) - (this.startIndex);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1705.methodEnd();
        }
    }

    public int previousIndex() {
        MethodContext _bcornu_methode_context1706 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 171, 5949, 6197);
            CallChecker.varInit(this.index, "index", 171, 5949, 6197);
            CallChecker.varInit(this.endIndex, "endIndex", 171, 5949, 6197);
            CallChecker.varInit(this.startIndex, "startIndex", 171, 5949, 6197);
            CallChecker.varInit(this.array, "array", 171, 5949, 6197);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 171, 5949, 6197);
            return ((this.index) - (this.startIndex)) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1706.methodEnd();
        }
    }

    public void add(Object o) {
        MethodContext _bcornu_methode_context1707 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 182, 6204, 6620);
            CallChecker.varInit(o, "o", 182, 6204, 6620);
            CallChecker.varInit(this.index, "index", 182, 6204, 6620);
            CallChecker.varInit(this.endIndex, "endIndex", 182, 6204, 6620);
            CallChecker.varInit(this.startIndex, "startIndex", 182, 6204, 6620);
            CallChecker.varInit(this.array, "array", 182, 6204, 6620);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 182, 6204, 6620);
            throw new UnsupportedOperationException("add() method is not supported");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1707.methodEnd();
        }
    }

    public void set(Object o) {
        MethodContext _bcornu_methode_context1708 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 201, 6627, 7569);
            CallChecker.varInit(o, "o", 201, 6627, 7569);
            CallChecker.varInit(this.index, "index", 201, 6627, 7569);
            CallChecker.varInit(this.endIndex, "endIndex", 201, 6627, 7569);
            CallChecker.varInit(this.startIndex, "startIndex", 201, 6627, 7569);
            CallChecker.varInit(this.array, "array", 201, 6627, 7569);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 201, 6627, 7569);
            if ((this.lastItemIndex) == (-1)) {
                throw new IllegalStateException("must call next() or previous() before a call to set()");
            }
            Array.set(this.array, this.lastItemIndex, o);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1708.methodEnd();
        }
    }

    @Override
    public void reset() {
        MethodContext _bcornu_methode_context1709 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 213, 7576, 7740);
            CallChecker.varInit(this.index, "index", 213, 7576, 7740);
            CallChecker.varInit(this.endIndex, "endIndex", 213, 7576, 7740);
            CallChecker.varInit(this.startIndex, "startIndex", 213, 7576, 7740);
            CallChecker.varInit(this.array, "array", 213, 7576, 7740);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 213, 7576, 7740);
            super.reset();
            this.lastItemIndex = -1;
            CallChecker.varAssign(this.lastItemIndex, "this.lastItemIndex", 215, 7711, 7734);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1709.methodEnd();
        }
    }
}

