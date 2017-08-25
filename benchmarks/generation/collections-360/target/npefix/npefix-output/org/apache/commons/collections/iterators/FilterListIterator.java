package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ListIterator;
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
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(FilterListIterator.class, 78, 2363, 2725);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public FilterListIterator(ListIterator<? extends E> iterator) {
        super();
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(FilterListIterator.class, 88, 2732, 3070);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 90, 3040, 3064);
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public FilterListIterator(ListIterator<? extends E> iterator, Predicate<? super E> predicate) {
        super();
        ConstructorContext _bcornu_methode_context3 = new ConstructorContext(FilterListIterator.class, 99, 3077, 3434);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 101, 3368, 3392);
            this.predicate = predicate;
            CallChecker.varAssign(this.predicate, "this.predicate", 102, 3402, 3428);
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public FilterListIterator(Predicate<? super E> predicate) {
        super();
        ConstructorContext _bcornu_methode_context4 = new ConstructorContext(FilterListIterator.class, 111, 3441, 3787);
        try {
            this.predicate = predicate;
            CallChecker.varAssign(this.predicate, "this.predicate", 113, 3755, 3781);
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public void add(E o) {
        MethodContext _bcornu_methode_context1 = new MethodContext(void.class, 118, 3794, 4026);
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
            _bcornu_methode_context1.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context2 = new MethodContext(boolean.class, 122, 4033, 4113);
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
            _bcornu_methode_context2.methodEnd();
        }
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context3 = new MethodContext(boolean.class, 126, 4120, 4212);
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
            _bcornu_methode_context3.methodEnd();
        }
    }

    public E next() {
        MethodContext _bcornu_methode_context4 = new MethodContext(null, 130, 4219, 4481);
        try {
            CallChecker.varInit(this, "this", 130, 4219, 4481);
            CallChecker.varInit(this.nextIndex, "nextIndex", 130, 4219, 4481);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 130, 4219, 4481);
            CallChecker.varInit(this.previousObject, "previousObject", 130, 4219, 4481);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 130, 4219, 4481);
            CallChecker.varInit(this.nextObject, "nextObject", 130, 4219, 4481);
            CallChecker.varInit(this.predicate, "predicate", 130, 4219, 4481);
            CallChecker.varInit(this.iterator, "iterator", 130, 4219, 4481);
            if (!(nextObjectSet)) {
                if (!(setNextObject())) {
                    throw new NoSuchElementException();
                }
            }
            (nextIndex)++;
            E temp = CallChecker.varInit(nextObject, "temp", 137, 4408, 4427);
            clearNextObject();
            return temp;
        } catch (ForceReturn _bcornu_return_t) {
            return ((E) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public int nextIndex() {
        MethodContext _bcornu_methode_context5 = new MethodContext(int.class, 142, 4488, 4543);
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
            _bcornu_methode_context5.methodEnd();
        }
    }

    public E previous() {
        MethodContext _bcornu_methode_context6 = new MethodContext(null, 146, 4550, 4832);
        try {
            CallChecker.varInit(this, "this", 146, 4550, 4832);
            CallChecker.varInit(this.nextIndex, "nextIndex", 146, 4550, 4832);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 146, 4550, 4832);
            CallChecker.varInit(this.previousObject, "previousObject", 146, 4550, 4832);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 146, 4550, 4832);
            CallChecker.varInit(this.nextObject, "nextObject", 146, 4550, 4832);
            CallChecker.varInit(this.predicate, "predicate", 146, 4550, 4832);
            CallChecker.varInit(this.iterator, "iterator", 146, 4550, 4832);
            if (!(previousObjectSet)) {
                if (!(setPreviousObject())) {
                    throw new NoSuchElementException();
                }
            }
            (nextIndex)--;
            E temp = CallChecker.varInit(previousObject, "temp", 153, 4751, 4774);
            clearPreviousObject();
            return temp;
        } catch (ForceReturn _bcornu_return_t) {
            return ((E) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public int previousIndex() {
        MethodContext _bcornu_methode_context7 = new MethodContext(int.class, 158, 4839, 4902);
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
            _bcornu_methode_context7.methodEnd();
        }
    }

    public void remove() {
        MethodContext _bcornu_methode_context8 = new MethodContext(void.class, 163, 4909, 5060);
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
            _bcornu_methode_context8.methodEnd();
        }
    }

    public void set(E o) {
        MethodContext _bcornu_methode_context9 = new MethodContext(void.class, 168, 5067, 5221);
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
            _bcornu_methode_context9.methodEnd();
        }
    }

    public ListIterator<? extends E> getListIterator() {
        MethodContext _bcornu_methode_context10 = new MethodContext(ListIterator.class, 178, 5228, 5491);
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
            _bcornu_methode_context10.methodEnd();
        }
    }

    public void setListIterator(ListIterator<? extends E> iterator) {
        MethodContext _bcornu_methode_context11 = new MethodContext(void.class, 188, 5498, 5793);
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
            _bcornu_methode_context11.methodEnd();
        }
    }

    public Predicate<? super E> getPredicate() {
        MethodContext _bcornu_methode_context12 = new MethodContext(Predicate.class, 198, 5800, 6058);
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
            _bcornu_methode_context12.methodEnd();
        }
    }

    public void setPredicate(Predicate<? super E> predicate) {
        MethodContext _bcornu_methode_context13 = new MethodContext(void.class, 207, 6065, 6289);
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
            _bcornu_methode_context13.methodEnd();
        }
    }

    private void clearNextObject() {
        MethodContext _bcornu_methode_context14 = new MethodContext(void.class, 212, 6296, 6469);
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
            _bcornu_methode_context14.methodEnd();
        }
    }

    private boolean setNextObject() {
        MethodContext _bcornu_methode_context15 = new MethodContext(boolean.class, 217, 6476, 7163);
        try {
            CallChecker.varInit(this, "this", 217, 6476, 7163);
            CallChecker.varInit(this.nextIndex, "nextIndex", 217, 6476, 7163);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 217, 6476, 7163);
            CallChecker.varInit(this.previousObject, "previousObject", 217, 6476, 7163);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 217, 6476, 7163);
            CallChecker.varInit(this.nextObject, "nextObject", 217, 6476, 7163);
            CallChecker.varInit(this.predicate, "predicate", 217, 6476, 7163);
            CallChecker.varInit(this.iterator, "iterator", 217, 6476, 7163);
            if (previousObjectSet) {
                clearPreviousObject();
                if (!(setNextObject())) {
                    return false;
                }
                clearNextObject();
            }
            iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 230, 6901, 6908);
            while (CallChecker.isCalled(iterator, ListIterator.class, 230, 6901, 6908).hasNext()) {
                E object = CallChecker.init(null);
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 231, 6946, 6953)) {
                    object = iterator.next();
                    CallChecker.varAssign(object, "object", 231, 6946, 6953);
                }
                if (CallChecker.beforeDeref(predicate, Predicate.class, 232, 6979, 6987)) {
                    predicate = CallChecker.beforeCalled(predicate, Predicate.class, 232, 6979, 6987);
                    if (CallChecker.isCalled(predicate, Predicate.class, 232, 6979, 6987).evaluate(object)) {
                        nextObject = object;
                        CallChecker.varAssign(this.nextObject, "this.nextObject", 233, 7025, 7044);
                        nextObjectSet = true;
                        CallChecker.varAssign(this.nextObjectSet, "this.nextObjectSet", 234, 7062, 7082);
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    private void clearPreviousObject() {
        MethodContext _bcornu_methode_context16 = new MethodContext(void.class, 241, 7170, 7277);
        try {
            CallChecker.varInit(this, "this", 241, 7170, 7277);
            CallChecker.varInit(this.nextIndex, "nextIndex", 241, 7170, 7277);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 241, 7170, 7277);
            CallChecker.varInit(this.previousObject, "previousObject", 241, 7170, 7277);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 241, 7170, 7277);
            CallChecker.varInit(this.nextObject, "nextObject", 241, 7170, 7277);
            CallChecker.varInit(this.predicate, "predicate", 241, 7170, 7277);
            CallChecker.varInit(this.iterator, "iterator", 241, 7170, 7277);
            previousObject = null;
            CallChecker.varAssign(this.previousObject, "this.previousObject", 242, 7215, 7236);
            previousObjectSet = false;
            CallChecker.varAssign(this.previousObjectSet, "this.previousObjectSet", 243, 7246, 7271);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    private boolean setPreviousObject() {
        MethodContext _bcornu_methode_context17 = new MethodContext(boolean.class, 246, 7284, 7983);
        try {
            CallChecker.varInit(this, "this", 246, 7284, 7983);
            CallChecker.varInit(this.nextIndex, "nextIndex", 246, 7284, 7983);
            CallChecker.varInit(this.previousObjectSet, "previousObjectSet", 246, 7284, 7983);
            CallChecker.varInit(this.previousObject, "previousObject", 246, 7284, 7983);
            CallChecker.varInit(this.nextObjectSet, "nextObjectSet", 246, 7284, 7983);
            CallChecker.varInit(this.nextObject, "nextObject", 246, 7284, 7983);
            CallChecker.varInit(this.predicate, "predicate", 246, 7284, 7983);
            CallChecker.varInit(this.iterator, "iterator", 246, 7284, 7983);
            if (nextObjectSet) {
                clearNextObject();
                if (!(setPreviousObject())) {
                    return false;
                }
                clearPreviousObject();
            }
            iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 259, 7705, 7712);
            while (CallChecker.isCalled(iterator, ListIterator.class, 259, 7705, 7712).hasPrevious()) {
                E object = CallChecker.init(null);
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 260, 7754, 7761)) {
                    object = iterator.previous();
                    CallChecker.varAssign(object, "object", 260, 7754, 7761);
                }
                if (CallChecker.beforeDeref(predicate, Predicate.class, 261, 7791, 7799)) {
                    predicate = CallChecker.beforeCalled(predicate, Predicate.class, 261, 7791, 7799);
                    if (CallChecker.isCalled(predicate, Predicate.class, 261, 7791, 7799).evaluate(object)) {
                        previousObject = object;
                        CallChecker.varAssign(this.previousObject, "this.previousObject", 262, 7837, 7860);
                        previousObjectSet = true;
                        CallChecker.varAssign(this.previousObjectSet, "this.previousObjectSet", 263, 7878, 7902);
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }
}

