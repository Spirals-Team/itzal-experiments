package org.apache.commons.collections.list;

import org.apache.commons.collections.collection.PredicatedCollection;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class PredicatedList<E> extends PredicatedCollection<E> implements List<E> {
    private static final long serialVersionUID = -5722039223898659102L;

    public static <T> List<T> decorate(List<T> list, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context995 = new MethodContext(List.class);
        try {
            CallChecker.varInit(predicate, "predicate", 63, 2073, 2730);
            CallChecker.varInit(list, "list", 63, 2073, 2730);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.PredicatedList.serialVersionUID", 63, 2073, 2730);
            return new PredicatedList<T>(list, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context995.methodEnd();
        }
    }

    protected PredicatedList(List<E> list, Predicate<? super E> predicate) {
        super(list, predicate);
        MethodContext _bcornu_methode_context193 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context193.methodEnd();
        }
    }

    @Override
    protected List<E> decorated() {
        MethodContext _bcornu_methode_context996 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 89, 3392, 3582);
            CallChecker.varInit(this.collection, "collection", 89, 3392, 3582);
            CallChecker.varInit(this.predicate, "predicate", 89, 3392, 3582);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.PredicatedList.serialVersionUID", 89, 3392, 3582);
            return ((List<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context996.methodEnd();
        }
    }

    public E get(int index) {
        final List<E> npe_invocation_var214 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var214, List.class, 95, 3708, 3718)) {
            return npe_invocation_var214.get(index);
        }else
            throw new AbnormalExecutionError();
        
    }

    public int indexOf(Object object) {
        MethodContext _bcornu_methode_context998 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 98, 3743, 3827);
            CallChecker.varInit(object, "object", 98, 3743, 3827);
            CallChecker.varInit(this.collection, "collection", 98, 3743, 3827);
            CallChecker.varInit(this.predicate, "predicate", 98, 3743, 3827);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.PredicatedList.serialVersionUID", 98, 3743, 3827);
            final List<E> npe_invocation_var215 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var215, List.class, 99, 3794, 3804)) {
                return CallChecker.isCalled(npe_invocation_var215, List.class, 99, 3794, 3804).indexOf(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context998.methodEnd();
        }
    }

    public int lastIndexOf(Object object) {
        MethodContext _bcornu_methode_context999 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 102, 3834, 3926);
            CallChecker.varInit(object, "object", 102, 3834, 3926);
            CallChecker.varInit(this.collection, "collection", 102, 3834, 3926);
            CallChecker.varInit(this.predicate, "predicate", 102, 3834, 3926);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.PredicatedList.serialVersionUID", 102, 3834, 3926);
            final List<E> npe_invocation_var216 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var216, List.class, 103, 3889, 3899)) {
                return CallChecker.isCalled(npe_invocation_var216, List.class, 103, 3889, 3899).lastIndexOf(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context999.methodEnd();
        }
    }

    public E remove(int index) {
        final List<E> npe_invocation_var217 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var217, List.class, 107, 3977, 3987)) {
            return npe_invocation_var217.remove(index);
        }else
            throw new AbnormalExecutionError();
        
    }

    public void add(int index, E object) {
        MethodContext _bcornu_methode_context1001 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 111, 4015, 4202);
            CallChecker.varInit(object, "object", 111, 4015, 4202);
            CallChecker.varInit(index, "index", 111, 4015, 4202);
            CallChecker.varInit(this.collection, "collection", 111, 4015, 4202);
            CallChecker.varInit(this.predicate, "predicate", 111, 4015, 4202);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.PredicatedList.serialVersionUID", 111, 4015, 4202);
            validate(object);
            final List<E> npe_invocation_var218 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var218, List.class, 113, 4166, 4176)) {
                CallChecker.isCalled(npe_invocation_var218, List.class, 113, 4166, 4176).add(index, object);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1001.methodEnd();
        }
    }

    public boolean addAll(int index, Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context1002 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 116, 4209, 4396);
            CallChecker.varInit(coll, "coll", 116, 4209, 4396);
            CallChecker.varInit(index, "index", 116, 4209, 4396);
            CallChecker.varInit(this.collection, "collection", 116, 4209, 4396);
            CallChecker.varInit(this.predicate, "predicate", 116, 4209, 4396);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.PredicatedList.serialVersionUID", 116, 4209, 4396);
            if (CallChecker.beforeDeref(coll, boolean.class, 117, 4297, 4300)) {
                for (E aColl : coll) {
                    validate(aColl);
                }
            }
            final List<E> npe_invocation_var219 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var219, List.class, 120, 4359, 4369)) {
                return CallChecker.isCalled(npe_invocation_var219, List.class, 120, 4359, 4369).addAll(index, coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1002.methodEnd();
        }
    }

    public ListIterator<E> listIterator() {
        MethodContext _bcornu_methode_context1003 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 123, 4403, 4479);
            CallChecker.varInit(this.collection, "collection", 123, 4403, 4479);
            CallChecker.varInit(this.predicate, "predicate", 123, 4403, 4479);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.PredicatedList.serialVersionUID", 123, 4403, 4479);
            return listIterator(0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1003.methodEnd();
        }
    }

    public ListIterator<E> listIterator(int i) {
        MethodContext _bcornu_methode_context1004 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 127, 4486, 4607);
            CallChecker.varInit(i, "i", 127, 4486, 4607);
            CallChecker.varInit(this.collection, "collection", 127, 4486, 4607);
            CallChecker.varInit(this.predicate, "predicate", 127, 4486, 4607);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.PredicatedList.serialVersionUID", 127, 4486, 4607);
            final List<E> npe_invocation_var220 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var220, List.class, 128, 4573, 4583)) {
                return new PredicatedListIterator(CallChecker.isCalled(npe_invocation_var220, List.class, 128, 4573, 4583).listIterator(i));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1004.methodEnd();
        }
    }

    public E set(int index, E object) {
        validate(object);
        final List<E> npe_invocation_var221 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var221, List.class, 133, 4691, 4701)) {
            return npe_invocation_var221.set(index, object);
        }else
            throw new AbnormalExecutionError();
        
    }

    public List<E> subList(int fromIndex, int toIndex) {
        MethodContext _bcornu_methode_context1006 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 136, 4734, 4908);
            CallChecker.varInit(toIndex, "toIndex", 136, 4734, 4908);
            CallChecker.varInit(fromIndex, "fromIndex", 136, 4734, 4908);
            CallChecker.varInit(this.collection, "collection", 136, 4734, 4908);
            CallChecker.varInit(this.predicate, "predicate", 136, 4734, 4908);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.PredicatedList.serialVersionUID", 136, 4734, 4908);
            final List<E> npe_invocation_var222 = decorated();
            List<E> sub = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(npe_invocation_var222, List.class, 137, 4809, 4819)) {
                sub = CallChecker.isCalled(npe_invocation_var222, List.class, 137, 4809, 4819).subList(fromIndex, toIndex);
                CallChecker.varAssign(sub, "sub", 137, 4809, 4819);
            }
            return new PredicatedList<E>(sub, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1006.methodEnd();
        }
    }

    protected class PredicatedListIterator extends AbstractListIteratorDecorator<E> {
        protected PredicatedListIterator(ListIterator<E> iterator) {
            super(iterator);
            MethodContext _bcornu_methode_context194 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context194.methodEnd();
            }
        }

        @Override
        public void add(E object) {
            MethodContext _bcornu_methode_context1007 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 151, 5198, 5316);
                CallChecker.varInit(object, "object", 151, 5198, 5316);
                CallChecker.varInit(this.iterator, "iterator", 151, 5198, 5316);
                validate(object);
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 153, 5286, 5293)) {
                    CallChecker.isCalled(iterator, ListIterator.class, 153, 5286, 5293).add(object);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1007.methodEnd();
            }
        }

        @Override
        public void set(E object) {
            MethodContext _bcornu_methode_context1008 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 157, 5335, 5453);
                CallChecker.varInit(object, "object", 157, 5335, 5453);
                CallChecker.varInit(this.iterator, "iterator", 157, 5335, 5453);
                validate(object);
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 159, 5423, 5430)) {
                    CallChecker.isCalled(iterator, ListIterator.class, 159, 5423, 5430).set(object);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1008.methodEnd();
            }
        }
    }
}

