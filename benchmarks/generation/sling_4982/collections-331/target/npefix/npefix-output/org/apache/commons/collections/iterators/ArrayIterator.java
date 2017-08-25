package org.apache.commons.collections.iterators;

import java.lang.reflect.Array;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableIterator;

public class ArrayIterator<E> implements ResettableIterator<E> {
    protected Object array;

    protected int startIndex = 0;

    protected int endIndex = 0;

    protected int index = 0;

    public ArrayIterator() {
        super();
        MethodContext _bcornu_methode_context370 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context370.methodEnd();
        }
    }

    public ArrayIterator(final Object array) {
        super();
        MethodContext _bcornu_methode_context371 = new MethodContext(null);
        try {
            setArray(array);
        } finally {
            _bcornu_methode_context371.methodEnd();
        }
    }

    public ArrayIterator(final Object array, final int startIndex) {
        super();
        MethodContext _bcornu_methode_context372 = new MethodContext(null);
        try {
            setArray(array);
            checkBound(startIndex, "start");
            this.startIndex = startIndex;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 94, 3550, 3578);
            this.index = startIndex;
            CallChecker.varAssign(this.index, "this.index", 95, 3588, 3611);
        } finally {
            _bcornu_methode_context372.methodEnd();
        }
    }

    public ArrayIterator(final Object array, final int startIndex, final int endIndex) {
        super();
        MethodContext _bcornu_methode_context373 = new MethodContext(null);
        try {
            setArray(array);
            checkBound(startIndex, "start");
            checkBound(endIndex, "end");
            if (endIndex < startIndex) {
                throw new IllegalArgumentException("End index must not be less than start index.");
            }
            this.startIndex = startIndex;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 117, 4501, 4529);
            this.endIndex = endIndex;
            CallChecker.varAssign(this.endIndex, "this.endIndex", 118, 4539, 4563);
            this.index = startIndex;
            CallChecker.varAssign(this.index, "this.index", 119, 4573, 4596);
        } finally {
            _bcornu_methode_context373.methodEnd();
        }
    }

    protected void checkBound(final int bound, final String type) {
        MethodContext _bcornu_methode_context1929 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 129, 4609, 5358);
            CallChecker.varInit(type, "type", 129, 4609, 5358);
            CallChecker.varInit(bound, "bound", 129, 4609, 5358);
            CallChecker.varInit(this.index, "index", 129, 4609, 5358);
            CallChecker.varInit(this.endIndex, "endIndex", 129, 4609, 5358);
            CallChecker.varInit(this.startIndex, "startIndex", 129, 4609, 5358);
            CallChecker.varInit(this.array, "array", 129, 4609, 5358);
            if (bound > (this.endIndex)) {
                throw new ArrayIndexOutOfBoundsException((("Attempt to make an ArrayIterator that " + type) + "s beyond the end of the array. "));
            }
            if (bound < 0) {
                throw new ArrayIndexOutOfBoundsException((("Attempt to make an ArrayIterator that " + type) + "s before the start of the array. "));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1929.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1930 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 151, 5365, 5688);
            CallChecker.varInit(this.index, "index", 151, 5365, 5688);
            CallChecker.varInit(this.endIndex, "endIndex", 151, 5365, 5688);
            CallChecker.varInit(this.startIndex, "startIndex", 151, 5365, 5688);
            CallChecker.varInit(this.array, "array", 151, 5365, 5688);
            return (index) < (endIndex);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1930.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public E next() {
        if ((hasNext()) == false) {
            throw new NoSuchElementException();
        }
        return ((E) (Array.get(array, ((index)++))));
    }

    public void remove() {
        MethodContext _bcornu_methode_context1932 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 175, 6117, 6357);
            CallChecker.varInit(this.index, "index", 175, 6117, 6357);
            CallChecker.varInit(this.endIndex, "endIndex", 175, 6117, 6357);
            CallChecker.varInit(this.startIndex, "startIndex", 175, 6117, 6357);
            CallChecker.varInit(this.array, "array", 175, 6117, 6357);
            throw new UnsupportedOperationException("remove() method is not supported");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1932.methodEnd();
        }
    }

    public Object getArray() {
        MethodContext _bcornu_methode_context1933 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 188, 6364, 6795);
            CallChecker.varInit(this.index, "index", 188, 6364, 6795);
            CallChecker.varInit(this.endIndex, "endIndex", 188, 6364, 6795);
            CallChecker.varInit(this.startIndex, "startIndex", 188, 6364, 6795);
            CallChecker.varInit(this.array, "array", 188, 6364, 6795);
            return array;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1933.methodEnd();
        }
    }

    public void setArray(final Object array) {
        MethodContext _bcornu_methode_context1934 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 205, 6806, 7986);
            CallChecker.varInit(array, "array", 205, 6806, 7986);
            CallChecker.varInit(this.index, "index", 205, 6806, 7986);
            CallChecker.varInit(this.endIndex, "endIndex", 205, 6806, 7986);
            CallChecker.varInit(this.startIndex, "startIndex", 205, 6806, 7986);
            CallChecker.varInit(this.array, "array", 205, 6806, 7986);
            this.endIndex = Array.getLength(array);
            CallChecker.varAssign(this.endIndex, "this.endIndex", 211, 7861, 7899);
            this.startIndex = 0;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 212, 7909, 7928);
            this.array = array;
            CallChecker.varAssign(this.array, "this.array", 213, 7938, 7956);
            this.index = 0;
            CallChecker.varAssign(this.index, "this.index", 214, 7966, 7980);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1934.methodEnd();
        }
    }

    public void reset() {
        MethodContext _bcornu_methode_context1935 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 220, 7997, 8129);
            CallChecker.varInit(this.index, "index", 220, 7997, 8129);
            CallChecker.varInit(this.endIndex, "endIndex", 220, 7997, 8129);
            CallChecker.varInit(this.startIndex, "startIndex", 220, 7997, 8129);
            CallChecker.varInit(this.array, "array", 220, 7997, 8129);
            this.index = this.startIndex;
            CallChecker.varAssign(this.index, "this.index", 221, 8095, 8123);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1935.methodEnd();
        }
    }
}

