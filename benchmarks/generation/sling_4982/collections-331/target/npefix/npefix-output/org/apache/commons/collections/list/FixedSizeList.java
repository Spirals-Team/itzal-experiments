package org.apache.commons.collections.list;

import org.apache.commons.collections.iterators.UnmodifiableIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections.BoundedCollection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.List;

public class FixedSizeList<E> extends AbstractSerializableListDecorator<E> implements BoundedCollection<E> {
    private static final long serialVersionUID = -2218010673611160319L;

    public static <E> List<E> decorate(List<E> list) {
        MethodContext _bcornu_methode_context2659 = new MethodContext(List.class);
        try {
            CallChecker.varInit(list, "list", 55, 1875, 2163);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 55, 1875, 2163);
            return new FixedSizeList<E>(list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2659.methodEnd();
        }
    }

    protected FixedSizeList(List<E> list) {
        super(list);
        MethodContext _bcornu_methode_context501 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context501.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context2660 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 72, 2503, 2701);
            CallChecker.varInit(object, "object", 72, 2503, 2701);
            CallChecker.varInit(this.collection, "collection", 72, 2503, 2701);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 72, 2503, 2701);
            throw new UnsupportedOperationException("List is fixed size");
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2660.methodEnd();
        }
    }

    @Override
    public void add(int index, E object) {
        MethodContext _bcornu_methode_context2661 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 77, 2708, 2836);
            CallChecker.varInit(object, "object", 77, 2708, 2836);
            CallChecker.varInit(index, "index", 77, 2708, 2836);
            CallChecker.varInit(this.collection, "collection", 77, 2708, 2836);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 77, 2708, 2836);
            throw new UnsupportedOperationException("List is fixed size");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2661.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context2662 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 82, 2843, 2986);
            CallChecker.varInit(coll, "coll", 82, 2843, 2986);
            CallChecker.varInit(this.collection, "collection", 82, 2843, 2986);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 82, 2843, 2986);
            throw new UnsupportedOperationException("List is fixed size");
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2662.methodEnd();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context2663 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 87, 2993, 3147);
            CallChecker.varInit(coll, "coll", 87, 2993, 3147);
            CallChecker.varInit(index, "index", 87, 2993, 3147);
            CallChecker.varInit(this.collection, "collection", 87, 2993, 3147);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 87, 2993, 3147);
            throw new UnsupportedOperationException("List is fixed size");
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2663.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2664 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 92, 3154, 3265);
            CallChecker.varInit(this.collection, "collection", 92, 3154, 3265);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 92, 3154, 3265);
            throw new UnsupportedOperationException("List is fixed size");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2664.methodEnd();
        }
    }

    @Override
    public E get(int index) {
        final List<E> npe_invocation_var457 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var457, List.class, 98, 3327, 3337)) {
            return npe_invocation_var457.get(index);
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public int indexOf(Object object) {
        MethodContext _bcornu_methode_context2666 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 102, 3362, 3460);
            CallChecker.varInit(object, "object", 102, 3362, 3460);
            CallChecker.varInit(this.collection, "collection", 102, 3362, 3460);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 102, 3362, 3460);
            final List<E> npe_invocation_var458 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var458, List.class, 103, 3427, 3437)) {
                return CallChecker.isCalled(npe_invocation_var458, List.class, 103, 3427, 3437).indexOf(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2666.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context2667 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 107, 3467, 3587);
            CallChecker.varInit(this.collection, "collection", 107, 3467, 3587);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 107, 3467, 3587);
            final List<E> npe_invocation_var459 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var459, List.class, 108, 3558, 3568)) {
                return UnmodifiableIterator.decorate(CallChecker.isCalled(npe_invocation_var459, List.class, 108, 3558, 3568).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2667.methodEnd();
        }
    }

    @Override
    public int lastIndexOf(Object object) {
        MethodContext _bcornu_methode_context2668 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 112, 3594, 3700);
            CallChecker.varInit(object, "object", 112, 3594, 3700);
            CallChecker.varInit(this.collection, "collection", 112, 3594, 3700);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 112, 3594, 3700);
            final List<E> npe_invocation_var460 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var460, List.class, 113, 3663, 3673)) {
                return CallChecker.isCalled(npe_invocation_var460, List.class, 113, 3663, 3673).lastIndexOf(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2668.methodEnd();
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        MethodContext _bcornu_methode_context2669 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 117, 3707, 3836);
            CallChecker.varInit(this.collection, "collection", 117, 3707, 3836);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 117, 3707, 3836);
            final List<E> npe_invocation_var461 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var461, List.class, 118, 3802, 3812)) {
                return new FixedSizeListIterator(CallChecker.isCalled(npe_invocation_var461, List.class, 118, 3802, 3812).listIterator(0));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2669.methodEnd();
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        MethodContext _bcornu_methode_context2670 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 122, 3843, 3985);
            CallChecker.varInit(index, "index", 122, 3843, 3985);
            CallChecker.varInit(this.collection, "collection", 122, 3843, 3985);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 122, 3843, 3985);
            final List<E> npe_invocation_var462 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var462, List.class, 123, 3947, 3957)) {
                return new FixedSizeListIterator(CallChecker.isCalled(npe_invocation_var462, List.class, 123, 3947, 3957).listIterator(index));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2670.methodEnd();
        }
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("List is fixed size");
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context2672 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 132, 4117, 4245);
            CallChecker.varInit(object, "object", 132, 4117, 4245);
            CallChecker.varInit(this.collection, "collection", 132, 4117, 4245);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 132, 4117, 4245);
            throw new UnsupportedOperationException("List is fixed size");
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2672.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context2673 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 137, 4252, 4388);
            CallChecker.varInit(coll, "coll", 137, 4252, 4388);
            CallChecker.varInit(this.collection, "collection", 137, 4252, 4388);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 137, 4252, 4388);
            throw new UnsupportedOperationException("List is fixed size");
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2673.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context2674 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 142, 4395, 4531);
            CallChecker.varInit(coll, "coll", 142, 4395, 4531);
            CallChecker.varInit(this.collection, "collection", 142, 4395, 4531);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 142, 4395, 4531);
            throw new UnsupportedOperationException("List is fixed size");
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2674.methodEnd();
        }
    }

    @Override
    public E set(int index, E object) {
        final List<E> npe_invocation_var463 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var463, List.class, 148, 4603, 4613)) {
            return npe_invocation_var463.set(index, object);
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        MethodContext _bcornu_methode_context2676 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 152, 4646, 4822);
            CallChecker.varInit(toIndex, "toIndex", 152, 4646, 4822);
            CallChecker.varInit(fromIndex, "fromIndex", 152, 4646, 4822);
            CallChecker.varInit(this.collection, "collection", 152, 4646, 4822);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 152, 4646, 4822);
            final List<E> npe_invocation_var464 = decorated();
            List<E> sub = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(npe_invocation_var464, List.class, 153, 4735, 4745)) {
                sub = CallChecker.isCalled(npe_invocation_var464, List.class, 153, 4735, 4745).subList(fromIndex, toIndex);
                CallChecker.varAssign(sub, "sub", 153, 4735, 4745);
            }
            return new FixedSizeList<E>(sub);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2676.methodEnd();
        }
    }

    private class FixedSizeListIterator extends AbstractListIteratorDecorator<E> {
        protected FixedSizeListIterator(ListIterator<E> iterator) {
            super(iterator);
            MethodContext _bcornu_methode_context502 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context502.methodEnd();
            }
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context2677 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 165, 5096, 5220);
                CallChecker.varInit(this.iterator, "iterator", 165, 5096, 5220);
                throw new UnsupportedOperationException("List is fixed size");
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2677.methodEnd();
            }
        }

        @Override
        public void add(Object object) {
            MethodContext _bcornu_methode_context2678 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 169, 5230, 5364);
                CallChecker.varInit(object, "object", 169, 5230, 5364);
                CallChecker.varInit(this.iterator, "iterator", 169, 5230, 5364);
                throw new UnsupportedOperationException("List is fixed size");
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2678.methodEnd();
            }
        }
    }

    public boolean isFull() {
        MethodContext _bcornu_methode_context2679 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 174, 5377, 5428);
            CallChecker.varInit(this.collection, "collection", 174, 5377, 5428);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 174, 5377, 5428);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2679.methodEnd();
        }
    }

    public int maxSize() {
        MethodContext _bcornu_methode_context2680 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 178, 5435, 5485);
            CallChecker.varInit(this.collection, "collection", 178, 5435, 5485);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.FixedSizeList.serialVersionUID", 178, 5435, 5485);
            return size();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2680.methodEnd();
        }
    }
}

