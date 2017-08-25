package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.ResettableListIterator;

public class ReverseListIterator<E> implements ResettableListIterator<E> {
    private final List<E> list;

    private ListIterator<E> iterator;

    private boolean validForUpdate = true;

    public ReverseListIterator(List<E> list) {
        super();
        MethodContext _bcornu_methode_context345 = new MethodContext(null);
        try {
            this.list = list;
            CallChecker.varAssign(this.list, "this.list", 58, 2352, 2368);
            if (CallChecker.beforeDeref(list, List.class, 59, 2407, 2410)) {
                if (CallChecker.beforeDeref(list, List.class, 59, 2389, 2392)) {
                    list = CallChecker.beforeCalled(list, List.class, 59, 2407, 2410);
                    list = CallChecker.beforeCalled(list, List.class, 59, 2389, 2392);
                    iterator = CallChecker.isCalled(list, List.class, 59, 2389, 2392).listIterator(CallChecker.isCalled(list, List.class, 59, 2407, 2410).size());
                    CallChecker.varAssign(this.iterator, "this.iterator", 59, 2378, 2419);
                }
            }
        } finally {
            _bcornu_methode_context345.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1764 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 68, 2432, 2699);
            CallChecker.varInit(this.validForUpdate, "validForUpdate", 68, 2432, 2699);
            CallChecker.varInit(this.iterator, "iterator", 68, 2432, 2699);
            CallChecker.varInit(this.list, "list", 68, 2432, 2699);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 69, 2671, 2678)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 69, 2671, 2678);
                return CallChecker.isCalled(iterator, ListIterator.class, 69, 2671, 2678).hasPrevious();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1764.methodEnd();
        }
    }

    public E next() {
        E obj = CallChecker.init(null);
        if (CallChecker.beforeDeref(iterator, ListIterator.class, 79, 2894, 2901)) {
            obj = iterator.previous();
            CallChecker.varAssign(obj, "obj", 79, 2894, 2901);
        }
        validForUpdate = true;
        CallChecker.varAssign(this.validForUpdate, "this.validForUpdate", 80, 2923, 2944);
        return obj;
    }

    public int nextIndex() {
        MethodContext _bcornu_methode_context1766 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 89, 2977, 3174);
            CallChecker.varInit(this.validForUpdate, "validForUpdate", 89, 2977, 3174);
            CallChecker.varInit(this.iterator, "iterator", 89, 2977, 3174);
            CallChecker.varInit(this.list, "list", 89, 2977, 3174);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 90, 3144, 3151)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 90, 3144, 3151);
                return CallChecker.isCalled(iterator, ListIterator.class, 90, 3144, 3151).previousIndex();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1766.methodEnd();
        }
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context1767 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 98, 3181, 3376);
            CallChecker.varInit(this.validForUpdate, "validForUpdate", 98, 3181, 3376);
            CallChecker.varInit(this.iterator, "iterator", 98, 3181, 3376);
            CallChecker.varInit(this.list, "list", 98, 3181, 3376);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 99, 3352, 3359)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 99, 3352, 3359);
                return CallChecker.isCalled(iterator, ListIterator.class, 99, 3352, 3359).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1767.methodEnd();
        }
    }

    public E previous() {
        E obj = CallChecker.init(null);
        if (CallChecker.beforeDeref(iterator, ListIterator.class, 109, 3583, 3590)) {
            obj = iterator.next();
            CallChecker.varAssign(obj, "obj", 109, 3583, 3590);
        }
        validForUpdate = true;
        CallChecker.varAssign(this.validForUpdate, "this.validForUpdate", 110, 3608, 3629);
        return obj;
    }

    public int previousIndex() {
        MethodContext _bcornu_methode_context1769 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 119, 3662, 3867);
            CallChecker.varInit(this.validForUpdate, "validForUpdate", 119, 3662, 3867);
            CallChecker.varInit(this.iterator, "iterator", 119, 3662, 3867);
            CallChecker.varInit(this.list, "list", 119, 3662, 3867);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 120, 3841, 3848)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 120, 3841, 3848);
                return CallChecker.isCalled(iterator, ListIterator.class, 120, 3841, 3848).nextIndex();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1769.methodEnd();
        }
    }

    public void remove() {
        MethodContext _bcornu_methode_context1770 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 129, 3874, 4291);
            CallChecker.varInit(this.validForUpdate, "validForUpdate", 129, 3874, 4291);
            CallChecker.varInit(this.iterator, "iterator", 129, 3874, 4291);
            CallChecker.varInit(this.list, "list", 129, 3874, 4291);
            if ((validForUpdate) == false) {
                throw new IllegalStateException("Cannot remove from list until next() or previous() called");
            }
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 133, 4268, 4275)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 133, 4268, 4275);
                CallChecker.isCalled(iterator, ListIterator.class, 133, 4268, 4275).remove();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1770.methodEnd();
        }
    }

    public void set(E obj) {
        MethodContext _bcornu_methode_context1771 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 143, 4298, 4765);
            CallChecker.varInit(obj, "obj", 143, 4298, 4765);
            CallChecker.varInit(this.validForUpdate, "validForUpdate", 143, 4298, 4765);
            CallChecker.varInit(this.iterator, "iterator", 143, 4298, 4765);
            CallChecker.varInit(this.list, "list", 143, 4298, 4765);
            if ((validForUpdate) == false) {
                throw new IllegalStateException("Cannot set to list until next() or previous() called");
            }
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 147, 4742, 4749)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 147, 4742, 4749);
                CallChecker.isCalled(iterator, ListIterator.class, 147, 4742, 4749).set(obj);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1771.methodEnd();
        }
    }

    public void add(E obj) {
        MethodContext _bcornu_methode_context1772 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 157, 4772, 5457);
            CallChecker.varInit(obj, "obj", 157, 4772, 5457);
            CallChecker.varInit(this.validForUpdate, "validForUpdate", 157, 4772, 5457);
            CallChecker.varInit(this.iterator, "iterator", 157, 4772, 5457);
            CallChecker.varInit(this.list, "list", 157, 4772, 5457);
            if ((validForUpdate) == false) {
                throw new IllegalStateException("Cannot add to list until next() or previous() called");
            }
            validForUpdate = false;
            CallChecker.varAssign(this.validForUpdate, "this.validForUpdate", 163, 5373, 5395);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 164, 5405, 5412)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 164, 5405, 5412);
                CallChecker.isCalled(iterator, ListIterator.class, 164, 5405, 5412).add(obj);
            }
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 165, 5432, 5439)) {
                iterator.previous();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1772.methodEnd();
        }
    }

    public void reset() {
        MethodContext _bcornu_methode_context1773 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 172, 5464, 5671);
            CallChecker.varInit(this.validForUpdate, "validForUpdate", 172, 5464, 5671);
            CallChecker.varInit(this.iterator, "iterator", 172, 5464, 5671);
            CallChecker.varInit(this.list, "list", 172, 5464, 5671);
            if (CallChecker.beforeDeref(list, List.class, 173, 5653, 5656)) {
                if (CallChecker.beforeDeref(list, List.class, 173, 5635, 5638)) {
                    iterator = CallChecker.isCalled(list, List.class, 173, 5635, 5638).listIterator(CallChecker.isCalled(list, List.class, 173, 5653, 5656).size());
                    CallChecker.varAssign(this.iterator, "this.iterator", 173, 5624, 5665);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1773.methodEnd();
        }
    }
}

