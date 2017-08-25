package org.apache.commons.collections.iterators;

import org.apache.commons.collections.ResettableListIterator;
import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.text.MessageFormat;

public class ListIteratorWrapper<E> implements ResettableListIterator<E> {
    private static final String UNSUPPORTED_OPERATION_MESSAGE = "ListIteratorWrapper does not support optional operations of ListIterator.";

    private static final String CANNOT_REMOVE_MESSAGE = "Cannot remove element at index {0}.";

    private final Iterator<? extends E> iterator;

    private final List<E> list = new ArrayList<E>();

    private int currentIndex = 0;

    private int wrappedIteratorIndex = 0;

    private boolean removeState;

    public ListIteratorWrapper(Iterator<? extends E> iterator) {
        super();
        MethodContext _bcornu_methode_context100 = new MethodContext(null);
        try {
            if (iterator == null) {
                throw new NullPointerException("Iterator must not be null");
            }
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 87, 3690, 3714);
        } finally {
            _bcornu_methode_context100.methodEnd();
        }
    }

    public void add(E obj) throws UnsupportedOperationException {
        MethodContext _bcornu_methode_context550 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 99, 3727, 4430);
            CallChecker.varInit(obj, "obj", 99, 3727, 4430);
            CallChecker.varInit(this.removeState, "removeState", 99, 3727, 4430);
            CallChecker.varInit(this.wrappedIteratorIndex, "wrappedIteratorIndex", 99, 3727, 4430);
            CallChecker.varInit(this.currentIndex, "currentIndex", 99, 3727, 4430);
            CallChecker.varInit(this.list, "list", 99, 3727, 4430);
            CallChecker.varInit(this.iterator, "iterator", 99, 3727, 4430);
            CallChecker.varInit(CANNOT_REMOVE_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.CANNOT_REMOVE_MESSAGE", 99, 3727, 4430);
            CallChecker.varInit(UNSUPPORTED_OPERATION_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.UNSUPPORTED_OPERATION_MESSAGE", 99, 3727, 4430);
            if ((iterator) instanceof ListIterator) {
                @SuppressWarnings(value = "unchecked")
                ListIterator<E> li = CallChecker.varInit(((ListIterator<E>) (iterator)), "li", 102, 4199, 4289);
                if (CallChecker.beforeDeref(li, ListIterator.class, 103, 4303, 4304)) {
                    li = CallChecker.beforeCalled(li, ListIterator.class, 103, 4303, 4304);
                    CallChecker.isCalled(li, ListIterator.class, 103, 4303, 4304).add(obj);
                }
                return ;
            }
            throw new UnsupportedOperationException(ListIteratorWrapper.UNSUPPORTED_OPERATION_MESSAGE);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context550.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context551 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 114, 4437, 4760);
            CallChecker.varInit(this.removeState, "removeState", 114, 4437, 4760);
            CallChecker.varInit(this.wrappedIteratorIndex, "wrappedIteratorIndex", 114, 4437, 4760);
            CallChecker.varInit(this.currentIndex, "currentIndex", 114, 4437, 4760);
            CallChecker.varInit(this.list, "list", 114, 4437, 4760);
            CallChecker.varInit(this.iterator, "iterator", 114, 4437, 4760);
            CallChecker.varInit(CANNOT_REMOVE_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.CANNOT_REMOVE_MESSAGE", 114, 4437, 4760);
            CallChecker.varInit(UNSUPPORTED_OPERATION_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.UNSUPPORTED_OPERATION_MESSAGE", 114, 4437, 4760);
            if (((currentIndex) == (wrappedIteratorIndex)) || ((iterator) instanceof ListIterator)) {
                if (CallChecker.beforeDeref(iterator, Iterator.class, 116, 4705, 4712)) {
                    return CallChecker.isCalled(iterator, Iterator.class, 116, 4705, 4712).hasNext();
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context551.methodEnd();
        }
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context552 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 126, 4767, 5133);
            CallChecker.varInit(this.removeState, "removeState", 126, 4767, 5133);
            CallChecker.varInit(this.wrappedIteratorIndex, "wrappedIteratorIndex", 126, 4767, 5133);
            CallChecker.varInit(this.currentIndex, "currentIndex", 126, 4767, 5133);
            CallChecker.varInit(this.list, "list", 126, 4767, 5133);
            CallChecker.varInit(this.iterator, "iterator", 126, 4767, 5133);
            CallChecker.varInit(CANNOT_REMOVE_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.CANNOT_REMOVE_MESSAGE", 126, 4767, 5133);
            CallChecker.varInit(UNSUPPORTED_OPERATION_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.UNSUPPORTED_OPERATION_MESSAGE", 126, 4767, 5133);
            if ((iterator) instanceof ListIterator) {
                ListIterator<?> li = CallChecker.varInit(((ListIterator<?>) (iterator)), "li", 128, 5000, 5047);
                if (CallChecker.beforeDeref(li, ListIterator.class, 129, 5068, 5069)) {
                    li = CallChecker.beforeCalled(li, ListIterator.class, 129, 5068, 5069);
                    return CallChecker.isCalled(li, ListIterator.class, 129, 5068, 5069).hasPrevious();
                }else
                    throw new AbnormalExecutionError();
                
            }
            return (currentIndex) > 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context552.methodEnd();
        }
    }

    public E next() throws NoSuchElementException {
        if ((iterator) instanceof ListIterator) {
            if (CallChecker.beforeDeref(iterator, Iterator.class, 142, 5447, 5454)) {
                return iterator.next();
            }else
                throw new AbnormalExecutionError();
            
        }
        if ((currentIndex) < (wrappedIteratorIndex)) {
            ++(currentIndex);
            if (CallChecker.beforeDeref(list, List.class, 147, 5573, 5576)) {
                return list.get(((currentIndex) - 1));
            }else
                throw new AbnormalExecutionError();
            
        }
        E retval = CallChecker.init(null);
        if (CallChecker.beforeDeref(iterator, Iterator.class, 150, 5631, 5638)) {
            retval = iterator.next();
            CallChecker.varAssign(retval, "retval", 150, 5631, 5638);
        }
        if (CallChecker.beforeDeref(list, List.class, 151, 5656, 5659)) {
            CallChecker.isCalled(list, List.class, 151, 5656, 5659).add(retval);
        }
        ++(currentIndex);
        ++(wrappedIteratorIndex);
        removeState = true;
        CallChecker.varAssign(this.removeState, "this.removeState", 154, 5738, 5756);
        return retval;
    }

    public int nextIndex() {
        MethodContext _bcornu_methode_context554 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 163, 5792, 6118);
            CallChecker.varInit(this.removeState, "removeState", 163, 5792, 6118);
            CallChecker.varInit(this.wrappedIteratorIndex, "wrappedIteratorIndex", 163, 5792, 6118);
            CallChecker.varInit(this.currentIndex, "currentIndex", 163, 5792, 6118);
            CallChecker.varInit(this.list, "list", 163, 5792, 6118);
            CallChecker.varInit(this.iterator, "iterator", 163, 5792, 6118);
            CallChecker.varInit(CANNOT_REMOVE_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.CANNOT_REMOVE_MESSAGE", 163, 5792, 6118);
            CallChecker.varInit(UNSUPPORTED_OPERATION_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.UNSUPPORTED_OPERATION_MESSAGE", 163, 5792, 6118);
            if ((iterator) instanceof ListIterator) {
                ListIterator<?> li = CallChecker.varInit(((ListIterator<?>) (iterator)), "li", 165, 5991, 6038);
                if (CallChecker.beforeDeref(li, ListIterator.class, 166, 6059, 6060)) {
                    li = CallChecker.beforeCalled(li, ListIterator.class, 166, 6059, 6060);
                    return CallChecker.isCalled(li, ListIterator.class, 166, 6059, 6060).nextIndex();
                }else
                    throw new AbnormalExecutionError();
                
            }
            return currentIndex;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context554.methodEnd();
        }
    }

    public E previous() throws NoSuchElementException {
        if ((iterator) instanceof ListIterator) {
            @SuppressWarnings(value = "unchecked")
            ListIterator<E> li = CallChecker.varInit(((ListIterator<E>) (iterator)), "li", 180, 6410, 6500);
            if (CallChecker.beforeDeref(li, ListIterator.class, 181, 6521, 6522)) {
                return li.previous();
            }else
                throw new AbnormalExecutionError();
            
        }
        if ((currentIndex) == 0) {
            throw new NoSuchElementException();
        }
        removeState = (wrappedIteratorIndex) == (currentIndex);
        CallChecker.varAssign(this.removeState, "this.removeState", 187, 6646, 6696);
        if (CallChecker.beforeDeref(list, List.class, 188, 6713, 6716)) {
            return list.get((--(currentIndex)));
        }else
            throw new AbnormalExecutionError();
        
    }

    public int previousIndex() {
        MethodContext _bcornu_methode_context556 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 196, 6750, 7097);
            CallChecker.varInit(this.removeState, "removeState", 196, 6750, 7097);
            CallChecker.varInit(this.wrappedIteratorIndex, "wrappedIteratorIndex", 196, 6750, 7097);
            CallChecker.varInit(this.currentIndex, "currentIndex", 196, 6750, 7097);
            CallChecker.varInit(this.list, "list", 196, 6750, 7097);
            CallChecker.varInit(this.iterator, "iterator", 196, 6750, 7097);
            CallChecker.varInit(CANNOT_REMOVE_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.CANNOT_REMOVE_MESSAGE", 196, 6750, 7097);
            CallChecker.varInit(UNSUPPORTED_OPERATION_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.UNSUPPORTED_OPERATION_MESSAGE", 196, 6750, 7097);
            if ((iterator) instanceof ListIterator) {
                ListIterator<?> li = CallChecker.varInit(((ListIterator<?>) (iterator)), "li", 198, 6962, 7009);
                if (CallChecker.beforeDeref(li, ListIterator.class, 199, 7030, 7031)) {
                    li = CallChecker.beforeCalled(li, ListIterator.class, 199, 7030, 7031);
                    return CallChecker.isCalled(li, ListIterator.class, 199, 7030, 7031).previousIndex();
                }else
                    throw new AbnormalExecutionError();
                
            }
            return (currentIndex) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context556.methodEnd();
        }
    }

    public void remove() throws UnsupportedOperationException {
        MethodContext _bcornu_methode_context557 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 209, 7104, 7920);
            CallChecker.varInit(this.removeState, "removeState", 209, 7104, 7920);
            CallChecker.varInit(this.wrappedIteratorIndex, "wrappedIteratorIndex", 209, 7104, 7920);
            CallChecker.varInit(this.currentIndex, "currentIndex", 209, 7104, 7920);
            CallChecker.varInit(this.list, "list", 209, 7104, 7920);
            CallChecker.varInit(this.iterator, "iterator", 209, 7104, 7920);
            CallChecker.varInit(CANNOT_REMOVE_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.CANNOT_REMOVE_MESSAGE", 209, 7104, 7920);
            CallChecker.varInit(UNSUPPORTED_OPERATION_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.UNSUPPORTED_OPERATION_MESSAGE", 209, 7104, 7920);
            if ((iterator) instanceof ListIterator) {
                if (CallChecker.beforeDeref(iterator, Iterator.class, 211, 7396, 7403)) {
                    CallChecker.isCalled(iterator, Iterator.class, 211, 7396, 7403).remove();
                }
                return ;
            }
            int removeIndex = CallChecker.varInit(((int) (this.currentIndex)), "removeIndex", 214, 7453, 7483);
            if ((currentIndex) == (wrappedIteratorIndex)) {
                --removeIndex;
            }
            if ((!(removeState)) || (((wrappedIteratorIndex) - (currentIndex)) > 1)) {
                throw new IllegalStateException(MessageFormat.format(ListIteratorWrapper.CANNOT_REMOVE_MESSAGE, removeIndex));
            }
            if (CallChecker.beforeDeref(iterator, Iterator.class, 221, 7766, 7773)) {
                CallChecker.isCalled(iterator, Iterator.class, 221, 7766, 7773).remove();
            }
            if (CallChecker.beforeDeref(list, List.class, 222, 7793, 7796)) {
                list.remove(removeIndex);
            }
            currentIndex = removeIndex;
            CallChecker.varAssign(this.currentIndex, "this.currentIndex", 223, 7827, 7853);
            (wrappedIteratorIndex)--;
            removeState = false;
            CallChecker.varAssign(this.removeState, "this.removeState", 225, 7895, 7914);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context557.methodEnd();
        }
    }

    public void set(E obj) throws UnsupportedOperationException {
        MethodContext _bcornu_methode_context558 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 235, 7927, 8520);
            CallChecker.varInit(obj, "obj", 235, 7927, 8520);
            CallChecker.varInit(this.removeState, "removeState", 235, 7927, 8520);
            CallChecker.varInit(this.wrappedIteratorIndex, "wrappedIteratorIndex", 235, 7927, 8520);
            CallChecker.varInit(this.currentIndex, "currentIndex", 235, 7927, 8520);
            CallChecker.varInit(this.list, "list", 235, 7927, 8520);
            CallChecker.varInit(this.iterator, "iterator", 235, 7927, 8520);
            CallChecker.varInit(CANNOT_REMOVE_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.CANNOT_REMOVE_MESSAGE", 235, 7927, 8520);
            CallChecker.varInit(UNSUPPORTED_OPERATION_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.UNSUPPORTED_OPERATION_MESSAGE", 235, 7927, 8520);
            if ((iterator) instanceof ListIterator) {
                @SuppressWarnings(value = "unchecked")
                ListIterator<E> li = CallChecker.varInit(((ListIterator<E>) (iterator)), "li", 238, 8289, 8379);
                if (CallChecker.beforeDeref(li, ListIterator.class, 239, 8393, 8394)) {
                    li = CallChecker.beforeCalled(li, ListIterator.class, 239, 8393, 8394);
                    CallChecker.isCalled(li, ListIterator.class, 239, 8393, 8394).set(obj);
                }
                return ;
            }
            throw new UnsupportedOperationException(ListIteratorWrapper.UNSUPPORTED_OPERATION_MESSAGE);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context558.methodEnd();
        }
    }

    public void reset() {
        MethodContext _bcornu_methode_context559 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 253, 8527, 9078);
            CallChecker.varInit(this.removeState, "removeState", 253, 8527, 9078);
            CallChecker.varInit(this.wrappedIteratorIndex, "wrappedIteratorIndex", 253, 8527, 9078);
            CallChecker.varInit(this.currentIndex, "currentIndex", 253, 8527, 9078);
            CallChecker.varInit(this.list, "list", 253, 8527, 9078);
            CallChecker.varInit(this.iterator, "iterator", 253, 8527, 9078);
            CallChecker.varInit(CANNOT_REMOVE_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.CANNOT_REMOVE_MESSAGE", 253, 8527, 9078);
            CallChecker.varInit(UNSUPPORTED_OPERATION_MESSAGE, "org.apache.commons.collections.iterators.ListIteratorWrapper.UNSUPPORTED_OPERATION_MESSAGE", 253, 8527, 9078);
            if ((iterator) instanceof ListIterator) {
                ListIterator<?> li = CallChecker.varInit(((ListIterator<?>) (iterator)), "li", 255, 8878, 8925);
                li = CallChecker.beforeCalled(li, ListIterator.class, 256, 8946, 8947);
                while ((CallChecker.isCalled(li, ListIterator.class, 256, 8946, 8947).previousIndex()) >= 0) {
                    if (CallChecker.beforeDeref(li, ListIterator.class, 257, 8989, 8990)) {
                        li.previous();
                    }
                } 
                return ;
            }
            currentIndex = 0;
            CallChecker.varAssign(this.currentIndex, "this.currentIndex", 261, 9056, 9072);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context559.methodEnd();
        }
    }
}

