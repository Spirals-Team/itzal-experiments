package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class AbstractListIteratorDecorator<E> implements ListIterator<E> {
    protected final ListIterator<E> iterator;

    public AbstractListIteratorDecorator(ListIterator<E> iterator) {
        super();
        MethodContext _bcornu_methode_context361 = new MethodContext(null);
        try {
            if (iterator == null) {
                throw new IllegalArgumentException("ListIterator must not be null");
            }
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 49, 1905, 1929);
        } finally {
            _bcornu_methode_context361.methodEnd();
        }
    }

    protected ListIterator<E> getListIterator() {
        MethodContext _bcornu_methode_context1842 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 57, 1942, 2121);
            CallChecker.varInit(this.iterator, "iterator", 57, 1942, 2121);
            return iterator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1842.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1843 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 62, 2128, 2272);
            CallChecker.varInit(this.iterator, "iterator", 62, 2128, 2272);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 63, 2248, 2255)) {
                return CallChecker.isCalled(iterator, ListIterator.class, 63, 2248, 2255).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1843.methodEnd();
        }
    }

    public E next() {
        if (CallChecker.beforeDeref(iterator, ListIterator.class, 67, 2312, 2319)) {
            return iterator.next();
        }else
            throw new AbnormalExecutionError();
        
    }

    public int nextIndex() {
        MethodContext _bcornu_methode_context1845 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 70, 2340, 2406);
            CallChecker.varInit(this.iterator, "iterator", 70, 2340, 2406);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 71, 2380, 2387)) {
                return CallChecker.isCalled(iterator, ListIterator.class, 71, 2380, 2387).nextIndex();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1845.methodEnd();
        }
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context1846 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 74, 2413, 2487);
            CallChecker.varInit(this.iterator, "iterator", 74, 2413, 2487);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 75, 2459, 2466)) {
                return CallChecker.isCalled(iterator, ListIterator.class, 75, 2459, 2466).hasPrevious();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1846.methodEnd();
        }
    }

    public E previous() {
        if (CallChecker.beforeDeref(iterator, ListIterator.class, 79, 2531, 2538)) {
            return iterator.previous();
        }else
            throw new AbnormalExecutionError();
        
    }

    public int previousIndex() {
        MethodContext _bcornu_methode_context1848 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 82, 2563, 2637);
            CallChecker.varInit(this.iterator, "iterator", 82, 2563, 2637);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 83, 2607, 2614)) {
                return CallChecker.isCalled(iterator, ListIterator.class, 83, 2607, 2614).previousIndex();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1848.methodEnd();
        }
    }

    public void remove() {
        MethodContext _bcornu_methode_context1849 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 86, 2644, 2698);
            CallChecker.varInit(this.iterator, "iterator", 86, 2644, 2698);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 87, 2675, 2682)) {
                CallChecker.isCalled(iterator, ListIterator.class, 87, 2675, 2682).remove();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1849.methodEnd();
        }
    }

    public void set(E obj) {
        MethodContext _bcornu_methode_context1850 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 90, 2705, 2761);
            CallChecker.varInit(obj, "obj", 90, 2705, 2761);
            CallChecker.varInit(this.iterator, "iterator", 90, 2705, 2761);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 91, 2738, 2745)) {
                CallChecker.isCalled(iterator, ListIterator.class, 91, 2738, 2745).set(obj);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1850.methodEnd();
        }
    }

    public void add(E obj) {
        MethodContext _bcornu_methode_context1851 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 94, 2768, 2824);
            CallChecker.varInit(obj, "obj", 94, 2768, 2824);
            CallChecker.varInit(this.iterator, "iterator", 94, 2768, 2824);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 95, 2801, 2808)) {
                CallChecker.isCalled(iterator, ListIterator.class, 95, 2801, 2808).add(obj);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1851.methodEnd();
        }
    }
}

