package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

public class ObjectArrayListIterator<E> extends ObjectArrayIterator<E> implements ListIterator<E> , ResettableListIterator<E> {
    protected int lastItemIndex = -1;

    public ObjectArrayListIterator() {
        super();
        MethodContext _bcornu_methode_context436 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context436.methodEnd();
        }
    }

    public ObjectArrayListIterator(E[] array) {
        super(array);
        MethodContext _bcornu_methode_context437 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context437.methodEnd();
        }
    }

    public ObjectArrayListIterator(E[] array, int start) {
        super(array, start);
        MethodContext _bcornu_methode_context438 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context438.methodEnd();
        }
    }

    public ObjectArrayListIterator(E[] array, int start, int end) {
        super(array, start, end);
        MethodContext _bcornu_methode_context439 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context439.methodEnd();
        }
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context2326 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 112, 3982, 4336);
            CallChecker.varInit(this.index, "index", 112, 3982, 4336);
            CallChecker.varInit(this.endIndex, "endIndex", 112, 3982, 4336);
            CallChecker.varInit(this.startIndex, "startIndex", 112, 3982, 4336);
            CallChecker.varInit(this.array, "array", 112, 3982, 4336);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 112, 3982, 4336);
            return (this.index) > (this.startIndex);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2326.methodEnd();
        }
    }

    public E previous() {
        if ((hasPrevious()) == false) {
            throw new NoSuchElementException();
        }
        this.lastItemIndex = --(this.index);
        CallChecker.varAssign(this.lastItemIndex, "this.lastItemIndex", 126, 4648, 4681);
        if (CallChecker.beforeDeref(this.array, null, 127, 4698, 4707)) {
            return this.array[this.index];
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public E next() {
        if ((hasNext()) == false) {
            throw new NoSuchElementException();
        }
        this.lastItemIndex = this.index;
        CallChecker.varAssign(this.lastItemIndex, "this.lastItemIndex", 141, 5032, 5063);
        if (CallChecker.beforeDeref(this.array, null, 142, 5080, 5089)) {
            return this.array[((this.index)++)];
        }else
            throw new AbnormalExecutionError();
        
    }

    public int nextIndex() {
        MethodContext _bcornu_methode_context2329 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 150, 5117, 5317);
            CallChecker.varInit(this.index, "index", 150, 5117, 5317);
            CallChecker.varInit(this.endIndex, "endIndex", 150, 5117, 5317);
            CallChecker.varInit(this.startIndex, "startIndex", 150, 5117, 5317);
            CallChecker.varInit(this.array, "array", 150, 5117, 5317);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 150, 5117, 5317);
            return (this.index) - (this.startIndex);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2329.methodEnd();
        }
    }

    public int previousIndex() {
        MethodContext _bcornu_methode_context2330 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 159, 5324, 5572);
            CallChecker.varInit(this.index, "index", 159, 5324, 5572);
            CallChecker.varInit(this.endIndex, "endIndex", 159, 5324, 5572);
            CallChecker.varInit(this.startIndex, "startIndex", 159, 5324, 5572);
            CallChecker.varInit(this.array, "array", 159, 5324, 5572);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 159, 5324, 5572);
            return ((this.index) - (this.startIndex)) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2330.methodEnd();
        }
    }

    public void add(E obj) {
        MethodContext _bcornu_methode_context2331 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 170, 5579, 5992);
            CallChecker.varInit(obj, "obj", 170, 5579, 5992);
            CallChecker.varInit(this.index, "index", 170, 5579, 5992);
            CallChecker.varInit(this.endIndex, "endIndex", 170, 5579, 5992);
            CallChecker.varInit(this.startIndex, "startIndex", 170, 5579, 5992);
            CallChecker.varInit(this.array, "array", 170, 5579, 5992);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 170, 5579, 5992);
            throw new UnsupportedOperationException("add() method is not supported");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2331.methodEnd();
        }
    }

    public void set(E obj) {
        MethodContext _bcornu_methode_context2332 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 191, 5999, 7096);
            CallChecker.varInit(obj, "obj", 191, 5999, 7096);
            CallChecker.varInit(this.index, "index", 191, 5999, 7096);
            CallChecker.varInit(this.endIndex, "endIndex", 191, 5999, 7096);
            CallChecker.varInit(this.startIndex, "startIndex", 191, 5999, 7096);
            CallChecker.varInit(this.array, "array", 191, 5999, 7096);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 191, 5999, 7096);
            if ((this.lastItemIndex) == (-1)) {
                throw new IllegalStateException("must call next() or previous() before a call to set()");
            }
            if (CallChecker.beforeDeref(this.array, null, 196, 7054, 7063)) {
                this.array[this.lastItemIndex] = obj;
                CallChecker.varAssign(this.array[this.lastItemIndex], "this.array[this.lastItemIndex]", 196, 7054, 7090);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2332.methodEnd();
        }
    }

    @Override
    public void reset() {
        MethodContext _bcornu_methode_context2333 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 203, 7103, 7267);
            CallChecker.varInit(this.index, "index", 203, 7103, 7267);
            CallChecker.varInit(this.endIndex, "endIndex", 203, 7103, 7267);
            CallChecker.varInit(this.startIndex, "startIndex", 203, 7103, 7267);
            CallChecker.varInit(this.array, "array", 203, 7103, 7267);
            CallChecker.varInit(this.lastItemIndex, "lastItemIndex", 203, 7103, 7267);
            super.reset();
            this.lastItemIndex = -1;
            CallChecker.varAssign(this.lastItemIndex, "this.lastItemIndex", 205, 7238, 7261);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2333.methodEnd();
        }
    }
}

