package org.apache.commons.collections.list;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public abstract class AbstractListDecorator<E> extends AbstractCollectionDecorator<E> implements List<E> {
    private static final long serialVersionUID = 4500739654952315623L;

    protected AbstractListDecorator() {
        super();
        MethodContext _bcornu_methode_context365 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context365.methodEnd();
        }
    }

    protected AbstractListDecorator(List<E> list) {
        super(list);
        MethodContext _bcornu_methode_context366 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context366.methodEnd();
        }
    }

    @Override
    protected List<E> decorated() {
        MethodContext _bcornu_methode_context1905 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 66, 2076, 2266);
            CallChecker.varInit(this.collection, "collection", 66, 2076, 2266);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.AbstractListDecorator.serialVersionUID", 66, 2076, 2266);
            return ((List<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1905.methodEnd();
        }
    }

    public void add(int index, E object) {
        MethodContext _bcornu_methode_context1906 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 71, 2273, 2434);
            CallChecker.varInit(object, "object", 71, 2273, 2434);
            CallChecker.varInit(index, "index", 71, 2273, 2434);
            CallChecker.varInit(this.collection, "collection", 71, 2273, 2434);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.AbstractListDecorator.serialVersionUID", 71, 2273, 2434);
            final List<E> npe_invocation_var371 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var371, List.class, 72, 2398, 2408)) {
                CallChecker.isCalled(npe_invocation_var371, List.class, 72, 2398, 2408).add(index, object);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1906.methodEnd();
        }
    }

    public boolean addAll(int index, Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context1907 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 75, 2441, 2558);
            CallChecker.varInit(coll, "coll", 75, 2441, 2558);
            CallChecker.varInit(index, "index", 75, 2441, 2558);
            CallChecker.varInit(this.collection, "collection", 75, 2441, 2558);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.AbstractListDecorator.serialVersionUID", 75, 2441, 2558);
            final List<E> npe_invocation_var372 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var372, List.class, 76, 2521, 2531)) {
                return CallChecker.isCalled(npe_invocation_var372, List.class, 76, 2521, 2531).addAll(index, coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1907.methodEnd();
        }
    }

    public E get(int index) {
        final List<E> npe_invocation_var373 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var373, List.class, 80, 2606, 2616)) {
            return npe_invocation_var373.get(index);
        }else
            throw new AbnormalExecutionError();
        
    }

    public int indexOf(Object object) {
        MethodContext _bcornu_methode_context1909 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 83, 2641, 2725);
            CallChecker.varInit(object, "object", 83, 2641, 2725);
            CallChecker.varInit(this.collection, "collection", 83, 2641, 2725);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.AbstractListDecorator.serialVersionUID", 83, 2641, 2725);
            final List<E> npe_invocation_var374 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var374, List.class, 84, 2692, 2702)) {
                return CallChecker.isCalled(npe_invocation_var374, List.class, 84, 2692, 2702).indexOf(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1909.methodEnd();
        }
    }

    public int lastIndexOf(Object object) {
        MethodContext _bcornu_methode_context1910 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 87, 2732, 2824);
            CallChecker.varInit(object, "object", 87, 2732, 2824);
            CallChecker.varInit(this.collection, "collection", 87, 2732, 2824);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.AbstractListDecorator.serialVersionUID", 87, 2732, 2824);
            final List<E> npe_invocation_var375 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var375, List.class, 88, 2787, 2797)) {
                return CallChecker.isCalled(npe_invocation_var375, List.class, 88, 2787, 2797).lastIndexOf(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1910.methodEnd();
        }
    }

    public ListIterator<E> listIterator() {
        MethodContext _bcornu_methode_context1911 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 91, 2831, 2918);
            CallChecker.varInit(this.collection, "collection", 91, 2831, 2918);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.AbstractListDecorator.serialVersionUID", 91, 2831, 2918);
            final List<E> npe_invocation_var376 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var376, List.class, 92, 2886, 2896)) {
                return CallChecker.isCalled(npe_invocation_var376, List.class, 92, 2886, 2896).listIterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1911.methodEnd();
        }
    }

    public ListIterator<E> listIterator(int index) {
        MethodContext _bcornu_methode_context1912 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 95, 2925, 3026);
            CallChecker.varInit(index, "index", 95, 2925, 3026);
            CallChecker.varInit(this.collection, "collection", 95, 2925, 3026);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.AbstractListDecorator.serialVersionUID", 95, 2925, 3026);
            final List<E> npe_invocation_var377 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var377, List.class, 96, 2989, 2999)) {
                return CallChecker.isCalled(npe_invocation_var377, List.class, 96, 2989, 2999).listIterator(index);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1912.methodEnd();
        }
    }

    public E remove(int index) {
        final List<E> npe_invocation_var378 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var378, List.class, 100, 3077, 3087)) {
            return npe_invocation_var378.remove(index);
        }else
            throw new AbnormalExecutionError();
        
    }

    public E set(int index, E object) {
        final List<E> npe_invocation_var379 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var379, List.class, 104, 3166, 3176)) {
            return npe_invocation_var379.set(index, object);
        }else
            throw new AbnormalExecutionError();
        
    }

    public List<E> subList(int fromIndex, int toIndex) {
        MethodContext _bcornu_methode_context1915 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 107, 3209, 3322);
            CallChecker.varInit(toIndex, "toIndex", 107, 3209, 3322);
            CallChecker.varInit(fromIndex, "fromIndex", 107, 3209, 3322);
            CallChecker.varInit(this.collection, "collection", 107, 3209, 3322);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.AbstractListDecorator.serialVersionUID", 107, 3209, 3322);
            final List<E> npe_invocation_var380 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var380, List.class, 108, 3277, 3287)) {
                return CallChecker.isCalled(npe_invocation_var380, List.class, 108, 3277, 3287).subList(fromIndex, toIndex);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1915.methodEnd();
        }
    }
}

