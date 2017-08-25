package org.apache.commons.collections;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.EmptyStackException;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;

public class ArrayStack<E> extends ArrayList<E> implements Buffer<E> {
    private static final long serialVersionUID = 2130079159931574599L;

    public ArrayStack() {
        super();
        MethodContext _bcornu_methode_context111 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context111.methodEnd();
        }
    }

    public ArrayStack(int initialSize) {
        super(initialSize);
        MethodContext _bcornu_methode_context112 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context112.methodEnd();
        }
    }

    public boolean empty() {
        MethodContext _bcornu_methode_context599 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 77, 2638, 2997);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ArrayStack.serialVersionUID", 77, 2638, 2997);
            return isEmpty();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context599.methodEnd();
        }
    }

    public E peek() throws EmptyStackException {
        int n = CallChecker.varInit(((int) (size())), "n", 88, 3246, 3260);
        if (n <= 0) {
            throw new EmptyStackException();
        }else {
            return get((n - 1));
        }
    }

    public E peek(int n) throws EmptyStackException {
        int m = CallChecker.varInit(((int) (((size()) - n) - 1)), "m", 106, 3800, 3824);
        if (m < 0) {
            throw new EmptyStackException();
        }else {
            return get(m);
        }
    }

    public E pop() throws EmptyStackException {
        int n = CallChecker.varInit(((int) (size())), "n", 121, 4189, 4203);
        if (n <= 0) {
            throw new EmptyStackException();
        }else {
            return remove((n - 1));
        }
    }

    public E push(E item) {
        add(item);
        return item;
    }

    public int search(Object object) {
        MethodContext _bcornu_methode_context604 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 152, 4661, 5628);
            CallChecker.varInit(object, "object", 152, 4661, 5628);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ArrayStack.serialVersionUID", 152, 4661, 5628);
            int i = CallChecker.varInit(((int) ((size()) - 1)), "i", 153, 5243, 5261);
            int n = CallChecker.varInit(((int) (1)), "n", 154, 5295, 5304);
            while (i >= 0) {
                Object current = CallChecker.varInit(get(i), "current", 156, 5379, 5402);
                if (((object == null) && (current == null)) || ((object != null) && (object.equals(current)))) {
                    return n;
                }
                i--;
                n++;
            } 
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context604.methodEnd();
        }
    }

    public E get() {
        int size = CallChecker.varInit(((int) (size())), "size", 174, 5849, 5866);
        if (size == 0) {
            throw new BufferUnderflowException();
        }
        return get((size - 1));
    }

    public E remove() {
        int size = CallChecker.varInit(((int) (size())), "size", 188, 6196, 6213);
        if (size == 0) {
            throw new BufferUnderflowException();
        }
        return remove((size - 1));
    }
}

