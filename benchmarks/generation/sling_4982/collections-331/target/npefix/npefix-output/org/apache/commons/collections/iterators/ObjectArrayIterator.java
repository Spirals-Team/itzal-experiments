package org.apache.commons.collections.iterators;

import org.apache.commons.collections.ResettableIterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;

public class ObjectArrayIterator<E> implements Iterator<E> , ResettableIterator<E> {
    protected E[] array = null;

    protected int startIndex = 0;

    protected int endIndex = 0;

    protected int index = 0;

    public ObjectArrayIterator() {
        super();
        MethodContext _bcornu_methode_context155 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context155.methodEnd();
        }
    }

    public ObjectArrayIterator(E[] array) {
        this(array, 0, CallChecker.isCalled(array, null, 73, 2550, 2554).length);
        MethodContext _bcornu_methode_context156 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context156.methodEnd();
        }
    }

    public ObjectArrayIterator(E[] array, int start) {
        this(array, start, CallChecker.isCalled(array, null, 86, 3067, 3071).length);
        MethodContext _bcornu_methode_context157 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context157.methodEnd();
        }
    }

    public ObjectArrayIterator(E[] array, int start, int end) {
        super();
        MethodContext _bcornu_methode_context158 = new MethodContext(null);
        try {
            if (start < 0) {
                throw new ArrayIndexOutOfBoundsException("Start index must not be less than zero");
            }
            if (CallChecker.beforeDeref(array, null, 105, 3855, 3859)) {
                array = CallChecker.beforeCalled(array, null, 105, 3855, 3859);
                if (end > (CallChecker.isCalled(array, null, 105, 3855, 3859).length)) {
                    throw new ArrayIndexOutOfBoundsException("End index must not be greater than the array length");
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(array, null, 108, 4010, 4014)) {
                array = CallChecker.beforeCalled(array, null, 108, 4010, 4014);
                if (start > (CallChecker.isCalled(array, null, 108, 4010, 4014).length)) {
                    throw new ArrayIndexOutOfBoundsException("Start index must not be greater than the array length");
                }
            }else
                throw new AbnormalExecutionError();
            
            if (end < start) {
                throw new IllegalArgumentException("End index must not be less than start index");
            }
            this.array = array;
            CallChecker.varAssign(this.array, "this.array", 114, 4287, 4305);
            this.startIndex = start;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 115, 4315, 4338);
            this.endIndex = end;
            CallChecker.varAssign(this.endIndex, "this.endIndex", 116, 4348, 4367);
            this.index = start;
            CallChecker.varAssign(this.index, "this.index", 117, 4377, 4395);
        } finally {
            _bcornu_methode_context158.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context798 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 128, 4408, 4744);
            CallChecker.varInit(this.index, "index", 128, 4408, 4744);
            CallChecker.varInit(this.endIndex, "endIndex", 128, 4408, 4744);
            CallChecker.varInit(this.startIndex, "startIndex", 128, 4408, 4744);
            CallChecker.varInit(this.array, "array", 128, 4408, 4744);
            return (this.index) < (this.endIndex);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context798.methodEnd();
        }
    }

    public E next() {
        if ((hasNext()) == false) {
            throw new NoSuchElementException();
        }
        if (CallChecker.beforeDeref(this.array, null, 143, 5098, 5107)) {
            return this.array[((this.index)++)];
        }else
            throw new AbnormalExecutionError();
        
    }

    public void remove() {
        MethodContext _bcornu_methode_context800 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 151, 5135, 5402);
            CallChecker.varInit(this.index, "index", 151, 5135, 5402);
            CallChecker.varInit(this.endIndex, "endIndex", 151, 5135, 5402);
            CallChecker.varInit(this.startIndex, "startIndex", 151, 5135, 5402);
            CallChecker.varInit(this.array, "array", 151, 5135, 5402);
            throw new UnsupportedOperationException("remove() method is not supported for an ObjectArrayIterator");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context800.methodEnd();
        }
    }

    public E[] getArray() {
        MethodContext _bcornu_methode_context801 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 165, 5409, 5835);
            CallChecker.varInit(this.index, "index", 165, 5409, 5835);
            CallChecker.varInit(this.endIndex, "endIndex", 165, 5409, 5835);
            CallChecker.varInit(this.startIndex, "startIndex", 165, 5409, 5835);
            CallChecker.varInit(this.array, "array", 165, 5409, 5835);
            return this.array;
        } catch (ForceReturn _bcornu_return_t) {
            return ((E[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context801.methodEnd();
        }
    }

    public void setArray(E[] array) {
        MethodContext _bcornu_methode_context802 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 181, 5842, 6665);
            CallChecker.varInit(array, "array", 181, 5842, 6665);
            CallChecker.varInit(this.index, "index", 181, 5842, 6665);
            CallChecker.varInit(this.endIndex, "endIndex", 181, 5842, 6665);
            CallChecker.varInit(this.startIndex, "startIndex", 181, 5842, 6665);
            CallChecker.varInit(this.array, "array", 181, 5842, 6665);
            if ((this.array) != null) {
                throw new IllegalStateException("The array to iterate over has already been set");
            }
            this.array = array;
            CallChecker.varAssign(this.array, "this.array", 185, 6550, 6568);
            this.startIndex = 0;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 186, 6578, 6597);
            if (CallChecker.beforeDeref(array, null, 187, 6623, 6627)) {
                array = CallChecker.beforeCalled(array, null, 187, 6623, 6627);
                this.endIndex = CallChecker.isCalled(array, null, 187, 6623, 6627).length;
                CallChecker.varAssign(this.endIndex, "this.endIndex", 187, 6607, 6635);
            }
            this.index = 0;
            CallChecker.varAssign(this.index, "this.index", 188, 6645, 6659);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context802.methodEnd();
        }
    }

    public int getStartIndex() {
        MethodContext _bcornu_methode_context803 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 196, 6672, 6834);
            CallChecker.varInit(this.index, "index", 196, 6672, 6834);
            CallChecker.varInit(this.endIndex, "endIndex", 196, 6672, 6834);
            CallChecker.varInit(this.startIndex, "startIndex", 196, 6672, 6834);
            CallChecker.varInit(this.array, "array", 196, 6672, 6834);
            return this.startIndex;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context803.methodEnd();
        }
    }

    public int getEndIndex() {
        MethodContext _bcornu_methode_context804 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 205, 6841, 6993);
            CallChecker.varInit(this.index, "index", 205, 6841, 6993);
            CallChecker.varInit(this.endIndex, "endIndex", 205, 6841, 6993);
            CallChecker.varInit(this.startIndex, "startIndex", 205, 6841, 6993);
            CallChecker.varInit(this.array, "array", 205, 6841, 6993);
            return this.endIndex;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context804.methodEnd();
        }
    }

    public void reset() {
        MethodContext _bcornu_methode_context805 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 212, 7000, 7132);
            CallChecker.varInit(this.index, "index", 212, 7000, 7132);
            CallChecker.varInit(this.endIndex, "endIndex", 212, 7000, 7132);
            CallChecker.varInit(this.startIndex, "startIndex", 212, 7000, 7132);
            CallChecker.varInit(this.array, "array", 212, 7000, 7132);
            this.index = this.startIndex;
            CallChecker.varAssign(this.index, "this.index", 213, 7098, 7126);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context805.methodEnd();
        }
    }
}

