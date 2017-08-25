package org.apache.commons.collections.iterators;

import org.apache.commons.collections.list.UnmodifiableList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.List;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class IteratorChain<E> implements Iterator<E> {
    protected final List<Iterator<? extends E>> iteratorChain = new ArrayList<Iterator<? extends E>>();

    protected int currentIteratorIndex = 0;

    protected Iterator<? extends E> currentIterator = null;

    protected Iterator<? extends E> lastUsedIterator = null;

    protected boolean isLocked = false;

    public IteratorChain() {
        super();
        MethodContext _bcornu_methode_context278 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context278.methodEnd();
        }
    }

    public IteratorChain(Iterator<? extends E> iterator) {
        super();
        MethodContext _bcornu_methode_context279 = new MethodContext(null);
        try {
            addIterator(iterator);
        } finally {
            _bcornu_methode_context279.methodEnd();
        }
    }

    public IteratorChain(Iterator<? extends E> first, Iterator<? extends E> second) {
        super();
        MethodContext _bcornu_methode_context280 = new MethodContext(null);
        try {
            addIterator(first);
            addIterator(second);
        } finally {
            _bcornu_methode_context280.methodEnd();
        }
    }

    public IteratorChain(Iterator<? extends E>[] iteratorChain) {
        super();
        MethodContext _bcornu_methode_context281 = new MethodContext(null);
        try {
            iteratorChain = CallChecker.beforeCalled(iteratorChain, Iterator[].class, 132, 5127, 5139);
            for (int i = 0; i < (CallChecker.isCalled(iteratorChain, Iterator[].class, 132, 5127, 5139).length); i++) {
                if (CallChecker.beforeDeref(iteratorChain, Iterator[].class, 133, 5180, 5192)) {
                    iteratorChain = CallChecker.beforeCalled(iteratorChain, Iterator[].class, 133, 5180, 5192);
                    addIterator(CallChecker.isCalled(iteratorChain, Iterator[].class, 133, 5180, 5192)[i]);
                }
            }
        } finally {
            _bcornu_methode_context281.methodEnd();
        }
    }

    public IteratorChain(Collection<Iterator<? extends E>> iteratorChain) {
        super();
        MethodContext _bcornu_methode_context282 = new MethodContext(null);
        try {
            if (CallChecker.beforeDeref(iteratorChain, null, 151, 5873, 5885)) {
                for (Iterator<? extends E> iterator : iteratorChain) {
                    addIterator(iterator);
                }
            }
        } finally {
            _bcornu_methode_context282.methodEnd();
        }
    }

    public void addIterator(Iterator<? extends E> iterator) {
        MethodContext _bcornu_methode_context1491 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 164, 5946, 6502);
            CallChecker.varInit(iterator, "iterator", 164, 5946, 6502);
            CallChecker.varInit(this.isLocked, "isLocked", 164, 5946, 6502);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 164, 5946, 6502);
            CallChecker.varInit(this.currentIterator, "currentIterator", 164, 5946, 6502);
            CallChecker.varInit(this.currentIteratorIndex, "currentIteratorIndex", 164, 5946, 6502);
            CallChecker.varInit(this.iteratorChain, "iteratorChain", 164, 5946, 6502);
            checkLocked();
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            if (CallChecker.beforeDeref(iteratorChain, List.class, 169, 6469, 6481)) {
                CallChecker.isCalled(iteratorChain, List.class, 169, 6469, 6481).add(iterator);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1491.methodEnd();
        }
    }

    public void setIterator(int index, Iterator<? extends E> iterator) throws IndexOutOfBoundsException {
        MethodContext _bcornu_methode_context1492 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 181, 6509, 7198);
            CallChecker.varInit(iterator, "iterator", 181, 6509, 7198);
            CallChecker.varInit(index, "index", 181, 6509, 7198);
            CallChecker.varInit(this.isLocked, "isLocked", 181, 6509, 7198);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 181, 6509, 7198);
            CallChecker.varInit(this.currentIterator, "currentIterator", 181, 6509, 7198);
            CallChecker.varInit(this.currentIteratorIndex, "currentIteratorIndex", 181, 6509, 7198);
            CallChecker.varInit(this.iteratorChain, "iteratorChain", 181, 6509, 7198);
            checkLocked();
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            if (CallChecker.beforeDeref(iteratorChain, List.class, 187, 7158, 7170)) {
                CallChecker.isCalled(iteratorChain, List.class, 187, 7158, 7170).set(index, iterator);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1492.methodEnd();
        }
    }

    public List<Iterator<? extends E>> getIterators() {
        MethodContext _bcornu_methode_context1493 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 195, 7205, 7446);
            CallChecker.varInit(this.isLocked, "isLocked", 195, 7205, 7446);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 195, 7205, 7446);
            CallChecker.varInit(this.currentIterator, "currentIterator", 195, 7205, 7446);
            CallChecker.varInit(this.currentIteratorIndex, "currentIteratorIndex", 195, 7205, 7446);
            CallChecker.varInit(this.iteratorChain, "iteratorChain", 195, 7205, 7446);
            return UnmodifiableList.decorate(iteratorChain);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Iterator<? extends E>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1493.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context1494 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 204, 7453, 7625);
            CallChecker.varInit(this.isLocked, "isLocked", 204, 7453, 7625);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 204, 7453, 7625);
            CallChecker.varInit(this.currentIterator, "currentIterator", 204, 7453, 7625);
            CallChecker.varInit(this.currentIteratorIndex, "currentIteratorIndex", 204, 7453, 7625);
            CallChecker.varInit(this.iteratorChain, "iteratorChain", 204, 7453, 7625);
            if (CallChecker.beforeDeref(iteratorChain, List.class, 205, 7599, 7611)) {
                return CallChecker.isCalled(iteratorChain, List.class, 205, 7599, 7611).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1494.methodEnd();
        }
    }

    public boolean isLocked() {
        MethodContext _bcornu_methode_context1495 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 215, 7632, 7970);
            CallChecker.varInit(this.isLocked, "isLocked", 215, 7632, 7970);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 215, 7632, 7970);
            CallChecker.varInit(this.currentIterator, "currentIterator", 215, 7632, 7970);
            CallChecker.varInit(this.currentIteratorIndex, "currentIteratorIndex", 215, 7632, 7970);
            CallChecker.varInit(this.iteratorChain, "iteratorChain", 215, 7632, 7970);
            return isLocked;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1495.methodEnd();
        }
    }

    private void checkLocked() {
        MethodContext _bcornu_methode_context1496 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 222, 7977, 8304);
            CallChecker.varInit(this.isLocked, "isLocked", 222, 7977, 8304);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 222, 7977, 8304);
            CallChecker.varInit(this.currentIterator, "currentIterator", 222, 7977, 8304);
            CallChecker.varInit(this.currentIteratorIndex, "currentIteratorIndex", 222, 7977, 8304);
            CallChecker.varInit(this.iteratorChain, "iteratorChain", 222, 7977, 8304);
            if ((isLocked) == true) {
                throw new UnsupportedOperationException("IteratorChain cannot be changed after the first use of a method from the Iterator interface");
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1496.methodEnd();
        }
    }

    private void lockChain() {
        MethodContext _bcornu_methode_context1497 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 233, 8311, 8551);
            CallChecker.varInit(this.isLocked, "isLocked", 233, 8311, 8551);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 233, 8311, 8551);
            CallChecker.varInit(this.currentIterator, "currentIterator", 233, 8311, 8551);
            CallChecker.varInit(this.currentIteratorIndex, "currentIteratorIndex", 233, 8311, 8551);
            CallChecker.varInit(this.iteratorChain, "iteratorChain", 233, 8311, 8551);
            if ((isLocked) == false) {
                isLocked = true;
                CallChecker.varAssign(this.isLocked, "this.isLocked", 235, 8520, 8535);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1497.methodEnd();
        }
    }

    protected void updateCurrentIterator() {
        MethodContext _bcornu_methode_context1498 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 243, 8558, 9407);
            CallChecker.varInit(this.isLocked, "isLocked", 243, 8558, 9407);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 243, 8558, 9407);
            CallChecker.varInit(this.currentIterator, "currentIterator", 243, 8558, 9407);
            CallChecker.varInit(this.currentIteratorIndex, "currentIteratorIndex", 243, 8558, 9407);
            CallChecker.varInit(this.iteratorChain, "iteratorChain", 243, 8558, 9407);
            if ((currentIterator) == null) {
                if (CallChecker.beforeDeref(iteratorChain, List.class, 245, 8772, 8784)) {
                    if (CallChecker.isCalled(iteratorChain, List.class, 245, 8772, 8784).isEmpty()) {
                        currentIterator = EmptyIterator.<E>getInstance();
                        CallChecker.varAssign(this.currentIterator, "this.currentIterator", 246, 8815, 8864);
                    }else {
                        if (CallChecker.beforeDeref(iteratorChain, List.class, 248, 8921, 8933)) {
                            currentIterator = CallChecker.isCalled(iteratorChain, List.class, 248, 8921, 8933).get(0);
                            CallChecker.varAssign(this.currentIterator, "this.currentIterator", 248, 8903, 8941);
                        }
                    }
                }
                lastUsedIterator = currentIterator;
                CallChecker.varAssign(this.lastUsedIterator, "this.lastUsedIterator", 252, 9119, 9153);
            }
            currentIterator = CallChecker.beforeCalled(currentIterator, Iterator.class, 255, 9181, 9195);
            while (((CallChecker.isCalled(currentIterator, Iterator.class, 255, 9181, 9195).hasNext()) == false) && ((currentIteratorIndex) < ((CallChecker.isCalled(iteratorChain, List.class, 256, 9258, 9270).size()) - 1))) {
                (currentIteratorIndex)++;
                if (CallChecker.beforeDeref(iteratorChain, List.class, 258, 9352, 9364)) {
                    currentIterator = CallChecker.isCalled(iteratorChain, List.class, 258, 9352, 9364).get(currentIteratorIndex);
                    CallChecker.varAssign(this.currentIterator, "this.currentIterator", 258, 9334, 9391);
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1498.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1499 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 268, 9414, 9808);
            CallChecker.varInit(this.isLocked, "isLocked", 268, 9414, 9808);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 268, 9414, 9808);
            CallChecker.varInit(this.currentIterator, "currentIterator", 268, 9414, 9808);
            CallChecker.varInit(this.currentIteratorIndex, "currentIteratorIndex", 268, 9414, 9808);
            CallChecker.varInit(this.iteratorChain, "iteratorChain", 268, 9414, 9808);
            lockChain();
            updateCurrentIterator();
            lastUsedIterator = currentIterator;
            CallChecker.varAssign(this.lastUsedIterator, "this.lastUsedIterator", 271, 9725, 9759);
            if (CallChecker.beforeDeref(currentIterator, Iterator.class, 273, 9777, 9791)) {
                currentIterator = CallChecker.beforeCalled(currentIterator, Iterator.class, 273, 9777, 9791);
                return CallChecker.isCalled(currentIterator, Iterator.class, 273, 9777, 9791).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1499.methodEnd();
        }
    }

    public E next() {
        lockChain();
        updateCurrentIterator();
        lastUsedIterator = currentIterator;
        CallChecker.varAssign(this.lastUsedIterator, "this.lastUsedIterator", 286, 10112, 10146);
        if (CallChecker.beforeDeref(currentIterator, Iterator.class, 288, 10164, 10178)) {
            return currentIterator.next();
        }else
            throw new AbnormalExecutionError();
        
    }

    public void remove() {
        MethodContext _bcornu_methode_context1501 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 304, 10199, 11016);
            CallChecker.varInit(this.isLocked, "isLocked", 304, 10199, 11016);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 304, 10199, 11016);
            CallChecker.varInit(this.currentIterator, "currentIterator", 304, 10199, 11016);
            CallChecker.varInit(this.currentIteratorIndex, "currentIteratorIndex", 304, 10199, 11016);
            CallChecker.varInit(this.iteratorChain, "iteratorChain", 304, 10199, 11016);
            lockChain();
            if ((currentIterator) == null) {
                updateCurrentIterator();
            }
            if (CallChecker.beforeDeref(lastUsedIterator, Iterator.class, 309, 10985, 11000)) {
                lastUsedIterator = CallChecker.beforeCalled(lastUsedIterator, Iterator.class, 309, 10985, 11000);
                CallChecker.isCalled(lastUsedIterator, Iterator.class, 309, 10985, 11000).remove();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1501.methodEnd();
        }
    }
}

