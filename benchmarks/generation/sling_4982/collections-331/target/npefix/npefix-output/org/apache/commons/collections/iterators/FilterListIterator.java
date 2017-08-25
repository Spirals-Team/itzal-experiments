package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;
import org.apache.commons.collections.Predicate;

public class FilterListIterator<E> implements ListIterator<E> {
    private ListIterator<? extends E> iterator;

    private Predicate<? super E> predicate;

    private E nextObject;

    private boolean nextObjectSet = false;

    private E previousObject;

    private boolean previousObjectSet = false;

    private int nextIndex = 0;

    public FilterListIterator() {
        super();
        MethodContext _bcornu_methode_context163 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context163.methodEnd();
        }
    }

    public FilterListIterator(ListIterator<? extends E> iterator) {
        super();
        MethodContext _bcornu_methode_context164 = new MethodContext(null);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 90, 3040, 3064);
        } finally {
            _bcornu_methode_context164.methodEnd();
        }
    }

    public FilterListIterator(ListIterator<? extends E> iterator, Predicate<? super E> predicate) {
        super();
        MethodContext _bcornu_methode_context165 = new MethodContext(null);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 101, 3368, 3392);
            this.predicate = predicate;
            CallChecker.varAssign(this.predicate, "this.predicate", 102, 3402, 3428);
        } finally {
            _bcornu_methode_context165.methodEnd();
        }
    }

    public FilterListIterator(Predicate<? super E> predicate) {
        super();
        MethodContext _bcornu_methode_context166 = new MethodContext(null);
        try {
            this.predicate = predicate;
            CallChecker.varAssign(this.predicate, "this.predicate", 113, 3755, 3781);
        } finally {
            _bcornu_methode_context166.methodEnd();
        }
    }

    public void add(E o) {
        MethodContext _bcornu_methode_context826 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 118, 3794, 4026);
            CallChecker.varInit(o, "o", 118, 3794, 4026);
            CallChecker.varInit(this.nextIndex, "nextIndex", 118, 3794, 4026);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 118, 3794, 4026);
            CallChecker.varInit(this.previousObject, "previousObject", 118, 3794, 4026);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 118, 3794, 4026);
            CallChecker.varInit(this.nextObject, "nextObject", 118, 3794, 4026);
            CallChecker.varInit(this.predicate, "predicate", 118, 3794, 4026);
            CallChecker.varInit(this.iterator, "iterator", 118, 3794, 4026);
            throw new UnsupportedOperationException("FilterListIterator.add(Object) is not supported.");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context826.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context827 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 122, 4033, 4113);
            CallChecker.varInit(this.nextIndex, "nextIndex", 122, 4033, 4113);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 122, 4033, 4113);
            CallChecker.varInit(this.previousObject, "previousObject", 122, 4033, 4113);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 122, 4033, 4113);
            CallChecker.varInit(this.nextObject, "nextObject", 122, 4033, 4113);
            CallChecker.varInit(this.predicate, "predicate", 122, 4033, 4113);
            CallChecker.varInit(this.iterator, "iterator", 122, 4033, 4113);
            return (nextObjectSet) || (setNextObject());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context827.methodEnd();
        }
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context828 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 126, 4120, 4212);
            CallChecker.varInit(this.nextIndex, "nextIndex", 126, 4120, 4212);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 126, 4120, 4212);
            CallChecker.varInit(this.previousObject, "previousObject", 126, 4120, 4212);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 126, 4120, 4212);
            CallChecker.varInit(this.nextObject, "nextObject", 126, 4120, 4212);
            CallChecker.varInit(this.predicate, "predicate", 126, 4120, 4212);
            CallChecker.varInit(this.iterator, "iterator", 126, 4120, 4212);
            return (previousObjectSet) || (setPreviousObject());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context828.methodEnd();
        }
    }

    public E next() {
        if (!(nextObjectSet)) {
            if (!(setNextObject())) {
                throw new NoSuchElementException();
            }
        }
        (nextIndex)++;
        E temp = CallChecker.varInit(nextObject, "temp", 137, 4408, 4427);
        clearNextObject();
        return temp;
    }

    public int nextIndex() {
        MethodContext _bcornu_methode_context830 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 142, 4488, 4543);
            CallChecker.varInit(this.nextIndex, "nextIndex", 142, 4488, 4543);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 142, 4488, 4543);
            CallChecker.varInit(this.previousObject, "previousObject", 142, 4488, 4543);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 142, 4488, 4543);
            CallChecker.varInit(this.nextObject, "nextObject", 142, 4488, 4543);
            CallChecker.varInit(this.predicate, "predicate", 142, 4488, 4543);
            CallChecker.varInit(this.iterator, "iterator", 142, 4488, 4543);
            return nextIndex;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context830.methodEnd();
        }
    }

    public E previous() {
        if (!(previousObjectSet)) {
            if (!(setPreviousObject())) {
                throw new NoSuchElementException();
            }
        }
        (nextIndex)--;
        E temp = CallChecker.varInit(previousObject, "temp", 153, 4751, 4774);
        clearPreviousObject();
        return temp;
    }

    public int previousIndex() {
        MethodContext _bcornu_methode_context832 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 158, 4839, 4902);
            CallChecker.varInit(this.nextIndex, "nextIndex", 158, 4839, 4902);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 158, 4839, 4902);
            CallChecker.varInit(this.previousObject, "previousObject", 158, 4839, 4902);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 158, 4839, 4902);
            CallChecker.varInit(this.nextObject, "nextObject", 158, 4839, 4902);
            CallChecker.varInit(this.predicate, "predicate", 158, 4839, 4902);
            CallChecker.varInit(this.iterator, "iterator", 158, 4839, 4902);
            return (nextIndex) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context832.methodEnd();
        }
    }

    public void remove() {
        MethodContext _bcornu_methode_context833 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 163, 4909, 5060);
            CallChecker.varInit(this.nextIndex, "nextIndex", 163, 4909, 5060);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 163, 4909, 5060);
            CallChecker.varInit(this.previousObject, "previousObject", 163, 4909, 5060);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 163, 4909, 5060);
            CallChecker.varInit(this.nextObject, "nextObject", 163, 4909, 5060);
            CallChecker.varInit(this.predicate, "predicate", 163, 4909, 5060);
            CallChecker.varInit(this.iterator, "iterator", 163, 4909, 5060);
            throw new UnsupportedOperationException("FilterListIterator.remove() is not supported.");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context833.methodEnd();
        }
    }

    public void set(E o) {
        MethodContext _bcornu_methode_context834 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 168, 5067, 5221);
            CallChecker.varInit(o, "o", 168, 5067, 5221);
            CallChecker.varInit(this.nextIndex, "nextIndex", 168, 5067, 5221);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 168, 5067, 5221);
            CallChecker.varInit(this.previousObject, "previousObject", 168, 5067, 5221);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 168, 5067, 5221);
            CallChecker.varInit(this.nextObject, "nextObject", 168, 5067, 5221);
            CallChecker.varInit(this.predicate, "predicate", 168, 5067, 5221);
            CallChecker.varInit(this.iterator, "iterator", 168, 5067, 5221);
            throw new UnsupportedOperationException("FilterListIterator.set(Object) is not supported.");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context834.methodEnd();
        }
    }

    public ListIterator<? extends E> getListIterator() {
        MethodContext _bcornu_methode_context835 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 178, 5228, 5491);
            CallChecker.varInit(this.nextIndex, "nextIndex", 178, 5228, 5491);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 178, 5228, 5491);
            CallChecker.varInit(this.previousObject, "previousObject", 178, 5228, 5491);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 178, 5228, 5491);
            CallChecker.varInit(this.nextObject, "nextObject", 178, 5228, 5491);
            CallChecker.varInit(this.predicate, "predicate", 178, 5228, 5491);
            CallChecker.varInit(this.iterator, "iterator", 178, 5228, 5491);
            return iterator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<? extends E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context835.methodEnd();
        }
    }

    public void setListIterator(ListIterator<? extends E> iterator) {
        MethodContext _bcornu_methode_context836 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 188, 5498, 5793);
            CallChecker.varInit(iterator, "iterator", 188, 5498, 5793);
            CallChecker.varInit(this.nextIndex, "nextIndex", 188, 5498, 5793);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 188, 5498, 5793);
            CallChecker.varInit(this.previousObject, "previousObject", 188, 5498, 5793);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 188, 5498, 5793);
            CallChecker.varInit(this.nextObject, "nextObject", 188, 5498, 5793);
            CallChecker.varInit(this.predicate, "predicate", 188, 5498, 5793);
            CallChecker.varInit(this.iterator, "iterator", 188, 5498, 5793);
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 189, 5763, 5787);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context836.methodEnd();
        }
    }

    public Predicate<? super E> getPredicate() {
        MethodContext _bcornu_methode_context837 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(this, "this", 198, 5800, 6058);
            CallChecker.varInit(this.nextIndex, "nextIndex", 198, 5800, 6058);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 198, 5800, 6058);
            CallChecker.varInit(this.previousObject, "previousObject", 198, 5800, 6058);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 198, 5800, 6058);
            CallChecker.varInit(this.nextObject, "nextObject", 198, 5800, 6058);
            CallChecker.varInit(this.predicate, "predicate", 198, 5800, 6058);
            CallChecker.varInit(this.iterator, "iterator", 198, 5800, 6058);
            return predicate;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context837.methodEnd();
        }
    }

    public void setPredicate(Predicate<? super E> predicate) {
        MethodContext _bcornu_methode_context838 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 207, 6065, 6289);
            CallChecker.varInit(predicate, "predicate", 207, 6065, 6289);
            CallChecker.varInit(this.nextIndex, "nextIndex", 207, 6065, 6289);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 207, 6065, 6289);
            CallChecker.varInit(this.previousObject, "previousObject", 207, 6065, 6289);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 207, 6065, 6289);
            CallChecker.varInit(this.nextObject, "nextObject", 207, 6065, 6289);
            CallChecker.varInit(this.predicate, "predicate", 207, 6065, 6289);
            CallChecker.varInit(this.iterator, "iterator", 207, 6065, 6289);
            this.predicate = predicate;
            CallChecker.varAssign(this.predicate, "this.predicate", 208, 6257, 6283);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context838.methodEnd();
        }
    }

    private void clearNextObject() {
        MethodContext _bcornu_methode_context839 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 212, 6296, 6469);
            CallChecker.varInit(this.nextIndex, "nextIndex", 212, 6296, 6469);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 212, 6296, 6469);
            CallChecker.varInit(this.previousObject, "previousObject", 212, 6296, 6469);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 212, 6296, 6469);
            CallChecker.varInit(this.nextObject, "nextObject", 212, 6296, 6469);
            CallChecker.varInit(this.predicate, "predicate", 212, 6296, 6469);
            CallChecker.varInit(this.iterator, "iterator", 212, 6296, 6469);
            nextObject = null;
            CallChecker.varAssign(this.nextObject, "this.nextObject", 213, 6415, 6432);
            nextObjectSet = false;
            CallChecker.varAssign(this.nextObjectSet, "this.nextObjectSet", 214, 6442, 6463);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context839.methodEnd();
        }
    }

    private boolean setNextObject() {
        MethodContext _bcornu_methode_context840 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 217, 6476, 7231);
            CallChecker.varInit(this.nextIndex, "nextIndex", 217, 6476, 7231);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 217, 6476, 7231);
            CallChecker.varInit(this.previousObject, "previousObject", 217, 6476, 7231);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 217, 6476, 7231);
            CallChecker.varInit(this.nextObject, "nextObject", 217, 6476, 7231);
            CallChecker.varInit(this.predicate, "predicate", 217, 6476, 7231);
            CallChecker.varInit(this.iterator, "iterator", 217, 6476, 7231);
            if (previousObjectSet) {
                clearPreviousObject();
                if (!(setNextObject())) {
                    return false;
                }
                clearNextObject();
            }
            if ((iterator) == null) {
                return false;
            }
            while (iterator.hasNext()) {
                E object = CallChecker.varInit(iterator.next(), "object", 234, 7003, 7029);
                if (CallChecker.beforeDeref(predicate, Predicate.class, 235, 7047, 7055)) {
                    predicate = CallChecker.beforeCalled(predicate, Predicate.class, 235, 7047, 7055);
                    if (CallChecker.isCalled(predicate, Predicate.class, 235, 7047, 7055).evaluate(object)) {
                        nextObject = object;
                        CallChecker.varAssign(this.nextObject, "this.nextObject", 236, 7093, 7112);
                        nextObjectSet = true;
                        CallChecker.varAssign(this.nextObjectSet, "this.nextObjectSet", 237, 7130, 7150);
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context840.methodEnd();
        }
    }

    private void clearPreviousObject() {
        MethodContext _bcornu_methode_context841 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 244, 7238, 7345);
            CallChecker.varInit(this.nextIndex, "nextIndex", 244, 7238, 7345);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 244, 7238, 7345);
            CallChecker.varInit(this.previousObject, "previousObject", 244, 7238, 7345);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 244, 7238, 7345);
            CallChecker.varInit(this.nextObject, "nextObject", 244, 7238, 7345);
            CallChecker.varInit(this.predicate, "predicate", 244, 7238, 7345);
            CallChecker.varInit(this.iterator, "iterator", 244, 7238, 7345);
            previousObject = null;
            CallChecker.varAssign(this.previousObject, "this.previousObject", 245, 7283, 7304);
            previousObjectSet = false;
            CallChecker.varAssign(this.previousObjectSet, "this.previousObjectSet", 246, 7314, 7339);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context841.methodEnd();
        }
    }

    private boolean setPreviousObject() {
        MethodContext _bcornu_methode_context842 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 249, 7352, 8119);
            CallChecker.varInit(this.nextIndex, "nextIndex", 249, 7352, 8119);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 249, 7352, 8119);
            CallChecker.varInit(this.previousObject, "previousObject", 249, 7352, 8119);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 249, 7352, 8119);
            CallChecker.varInit(this.nextObject, "nextObject", 249, 7352, 8119);
            CallChecker.varInit(this.predicate, "predicate", 249, 7352, 8119);
            CallChecker.varInit(this.iterator, "iterator", 249, 7352, 8119);
            if (nextObjectSet) {
                clearNextObject();
                if (!(setPreviousObject())) {
                    return false;
                }
                clearPreviousObject();
            }
            if ((iterator) == null) {
                return false;
            }
            while (iterator.hasPrevious()) {
                E object = CallChecker.varInit(iterator.previous(), "object", 266, 7879, 7909);
                if (CallChecker.beforeDeref(predicate, Predicate.class, 267, 7927, 7935)) {
                    predicate = CallChecker.beforeCalled(predicate, Predicate.class, 267, 7927, 7935);
                    if (CallChecker.isCalled(predicate, Predicate.class, 267, 7927, 7935).evaluate(object)) {
                        previousObject = object;
                        CallChecker.varAssign(this.previousObject, "this.previousObject", 268, 7973, 7996);
                        previousObjectSet = true;
                        CallChecker.varAssign(this.previousObjectSet, "this.previousObjectSet", 269, 8014, 8038);
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context842.methodEnd();
        }
    }
}

