package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.Unmodifiable;

public final class UnmodifiableListIterator<E> implements ListIterator<E> , Unmodifiable {
    private ListIterator<E> iterator;

    public static <E> ListIterator<E> decorate(ListIterator<E> iterator) {
        MethodContext _bcornu_methode_context1088 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(iterator, "iterator", 45, 1425, 2055);
            if (iterator == null) {
                throw new IllegalArgumentException("ListIterator must not be null");
            }
            if (iterator instanceof Unmodifiable) {
                return iterator;
            }
            return new UnmodifiableListIterator<E>(iterator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1088.methodEnd();
        }
    }

    private UnmodifiableListIterator(ListIterator<E> iterator) {
        super();
        MethodContext _bcornu_methode_context216 = new MethodContext(null);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 63, 2322, 2346);
        } finally {
            _bcornu_methode_context216.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1089 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 67, 2359, 2503);
            CallChecker.varInit(this.iterator, "iterator", 67, 2359, 2503);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 68, 2479, 2486)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 68, 2479, 2486);
                return CallChecker.isCalled(iterator, ListIterator.class, 68, 2479, 2486).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1089.methodEnd();
        }
    }

    public E next() {
        if (CallChecker.beforeDeref(iterator, ListIterator.class, 72, 2543, 2550)) {
            return iterator.next();
        }else
            throw new AbnormalExecutionError();
        
    }

    public int nextIndex() {
        MethodContext _bcornu_methode_context1091 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 75, 2571, 2637);
            CallChecker.varInit(this.iterator, "iterator", 75, 2571, 2637);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 76, 2611, 2618)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 76, 2611, 2618);
                return CallChecker.isCalled(iterator, ListIterator.class, 76, 2611, 2618).nextIndex();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1091.methodEnd();
        }
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context1092 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 79, 2644, 2718);
            CallChecker.varInit(this.iterator, "iterator", 79, 2644, 2718);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 80, 2690, 2697)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 80, 2690, 2697);
                return CallChecker.isCalled(iterator, ListIterator.class, 80, 2690, 2697).hasPrevious();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1092.methodEnd();
        }
    }

    public E previous() {
        if (CallChecker.beforeDeref(iterator, ListIterator.class, 84, 2762, 2769)) {
            return iterator.previous();
        }else
            throw new AbnormalExecutionError();
        
    }

    public int previousIndex() {
        MethodContext _bcornu_methode_context1094 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 87, 2794, 2868);
            CallChecker.varInit(this.iterator, "iterator", 87, 2794, 2868);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 88, 2838, 2845)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 88, 2838, 2845);
                return CallChecker.isCalled(iterator, ListIterator.class, 88, 2838, 2845).previousIndex();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1094.methodEnd();
        }
    }

    public void remove() {
        MethodContext _bcornu_methode_context1095 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 91, 2875, 2980);
            CallChecker.varInit(this.iterator, "iterator", 91, 2875, 2980);
            throw new UnsupportedOperationException("remove() is not supported");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1095.methodEnd();
        }
    }

    public void set(E obj) {
        MethodContext _bcornu_methode_context1096 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 95, 2987, 3091);
            CallChecker.varInit(obj, "obj", 95, 2987, 3091);
            CallChecker.varInit(this.iterator, "iterator", 95, 2987, 3091);
            throw new UnsupportedOperationException("set() is not supported");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1096.methodEnd();
        }
    }

    public void add(E obj) {
        MethodContext _bcornu_methode_context1097 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 99, 3098, 3202);
            CallChecker.varInit(obj, "obj", 99, 3098, 3202);
            CallChecker.varInit(this.iterator, "iterator", 99, 3098, 3202);
            throw new UnsupportedOperationException("add() is not supported");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1097.methodEnd();
        }
    }
}

