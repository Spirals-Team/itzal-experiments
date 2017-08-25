package org.apache.commons.collections.iterators;

import org.apache.commons.collections.ResettableIterator;
import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class SingletonIterator<E> implements Iterator<E> , ResettableIterator<E> {
    private final boolean removeAllowed;

    private boolean beforeFirst = true;

    private boolean removed = false;

    private E object;

    public SingletonIterator(E object) {
        this(object, true);
        MethodContext _bcornu_methode_context341 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context341.methodEnd();
        }
    }

    public SingletonIterator(E object, boolean removeAllowed) {
        super();
        MethodContext _bcornu_methode_context342 = new MethodContext(null);
        try {
            this.object = object;
            CallChecker.varAssign(this.object, "this.object", 67, 2361, 2381);
            this.removeAllowed = removeAllowed;
            CallChecker.varAssign(this.removeAllowed, "this.removeAllowed", 68, 2391, 2425);
        } finally {
            _bcornu_methode_context342.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1755 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 79, 2438, 2816);
            CallChecker.varInit(this.object, "object", 79, 2438, 2816);
            CallChecker.varInit(this.removed, "removed", 79, 2438, 2816);
            CallChecker.varInit(this.beforeFirst, "beforeFirst", 79, 2438, 2816);
            CallChecker.varInit(this.removeAllowed, "removeAllowed", 79, 2438, 2816);
            return (beforeFirst) && (!(removed));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1755.methodEnd();
        }
    }

    public E next() {
        if ((!(beforeFirst)) || (removed)) {
            throw new NoSuchElementException();
        }
        beforeFirst = false;
        CallChecker.varAssign(this.beforeFirst, "this.beforeFirst", 96, 3225, 3244);
        return object;
    }

    public void remove() {
        MethodContext _bcornu_methode_context1757 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 109, 3280, 3985);
            CallChecker.varInit(this.object, "object", 109, 3280, 3985);
            CallChecker.varInit(this.removed, "removed", 109, 3280, 3985);
            CallChecker.varInit(this.beforeFirst, "beforeFirst", 109, 3280, 3985);
            CallChecker.varInit(this.removeAllowed, "removeAllowed", 109, 3280, 3985);
            if (removeAllowed) {
                if ((removed) || (beforeFirst)) {
                    throw new IllegalStateException();
                }else {
                    object = null;
                    CallChecker.varAssign(this.object, "this.object", 114, 3838, 3851);
                    removed = true;
                    CallChecker.varAssign(this.removed, "this.removed", 115, 3869, 3883);
                }
            }else {
                throw new UnsupportedOperationException();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1757.methodEnd();
        }
    }

    public void reset() {
        MethodContext _bcornu_methode_context1758 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 125, 3996, 4106);
            CallChecker.varInit(this.object, "object", 125, 3996, 4106);
            CallChecker.varInit(this.removed, "removed", 125, 3996, 4106);
            CallChecker.varInit(this.beforeFirst, "beforeFirst", 125, 3996, 4106);
            CallChecker.varInit(this.removeAllowed, "removeAllowed", 125, 3996, 4106);
            beforeFirst = true;
            CallChecker.varAssign(this.beforeFirst, "this.beforeFirst", 126, 4082, 4100);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1758.methodEnd();
        }
    }
}

