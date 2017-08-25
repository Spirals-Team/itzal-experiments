package org.apache.commons.collections.collection;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractUntypedCollectionDecorator<E, D> implements Serializable , Collection<E> {
    private static final long serialVersionUID = -8016691444524268856L;

    protected Collection<D> collection;

    public AbstractUntypedCollectionDecorator() {
        super();
        MethodContext _bcornu_methode_context325 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context325.methodEnd();
        }
    }

    protected Collection<D> decorated() {
        MethodContext _bcornu_methode_context1688 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 69, 2595, 2840);
            CallChecker.varInit(this.collection, "collection", 69, 2595, 2840);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 69, 2595, 2840);
            return collection;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1688.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context1689 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 73, 2847, 2902);
            CallChecker.varInit(this.collection, "collection", 73, 2847, 2902);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 73, 2847, 2902);
            final Collection<D> npe_invocation_var333 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var333, Collection.class, 74, 2877, 2887)) {
                CallChecker.isCalled(npe_invocation_var333, Collection.class, 74, 2877, 2887).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1689.methodEnd();
        }
    }

    public boolean contains(Object object) {
        MethodContext _bcornu_methode_context1690 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 77, 2909, 2999);
            CallChecker.varInit(object, "object", 77, 2909, 2999);
            CallChecker.varInit(this.collection, "collection", 77, 2909, 2999);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 77, 2909, 2999);
            final Collection<D> npe_invocation_var334 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var334, Collection.class, 78, 2965, 2975)) {
                return CallChecker.isCalled(npe_invocation_var334, Collection.class, 78, 2965, 2975).contains(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1690.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1691 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 81, 3006, 3075);
            CallChecker.varInit(this.collection, "collection", 81, 3006, 3075);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 81, 3006, 3075);
            final Collection<D> npe_invocation_var335 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var335, Collection.class, 82, 3048, 3058)) {
                return CallChecker.isCalled(npe_invocation_var335, Collection.class, 82, 3048, 3058).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1691.methodEnd();
        }
    }

    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context1692 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 85, 3082, 3168);
            CallChecker.varInit(object, "object", 85, 3082, 3168);
            CallChecker.varInit(this.collection, "collection", 85, 3082, 3168);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 85, 3082, 3168);
            final Collection<D> npe_invocation_var336 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var336, Collection.class, 86, 3136, 3146)) {
                return CallChecker.isCalled(npe_invocation_var336, Collection.class, 86, 3136, 3146).remove(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1692.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context1693 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 89, 3175, 3234);
            CallChecker.varInit(this.collection, "collection", 89, 3175, 3234);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 89, 3175, 3234);
            final Collection<D> npe_invocation_var337 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var337, Collection.class, 90, 3210, 3220)) {
                return CallChecker.isCalled(npe_invocation_var337, Collection.class, 90, 3210, 3220).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1693.methodEnd();
        }
    }

    public Object[] toArray() {
        MethodContext _bcornu_methode_context1694 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 93, 3241, 3311);
            CallChecker.varInit(this.collection, "collection", 93, 3241, 3311);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 93, 3241, 3311);
            final Collection<D> npe_invocation_var338 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var338, Collection.class, 94, 3284, 3294)) {
                return CallChecker.isCalled(npe_invocation_var338, Collection.class, 94, 3284, 3294).toArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1694.methodEnd();
        }
    }

    public <T> T[] toArray(T[] object) {
        MethodContext _bcornu_methode_context1695 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 97, 3318, 3403);
            CallChecker.varInit(object, "object", 97, 3318, 3403);
            CallChecker.varInit(this.collection, "collection", 97, 3318, 3403);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 97, 3318, 3403);
            final Collection<D> npe_invocation_var339 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var339, Collection.class, 98, 3370, 3380)) {
                return CallChecker.isCalled(npe_invocation_var339, Collection.class, 98, 3370, 3380).toArray(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1695.methodEnd();
        }
    }

    public boolean containsAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1696 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 101, 3410, 3509);
            CallChecker.varInit(coll, "coll", 101, 3410, 3509);
            CallChecker.varInit(this.collection, "collection", 101, 3410, 3509);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 101, 3410, 3509);
            final Collection<D> npe_invocation_var340 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var340, Collection.class, 102, 3474, 3484)) {
                return CallChecker.isCalled(npe_invocation_var340, Collection.class, 102, 3474, 3484).containsAll(coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1696.methodEnd();
        }
    }

    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1697 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 105, 3516, 3611);
            CallChecker.varInit(coll, "coll", 105, 3516, 3611);
            CallChecker.varInit(this.collection, "collection", 105, 3516, 3611);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 105, 3516, 3611);
            final Collection<D> npe_invocation_var341 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var341, Collection.class, 106, 3578, 3588)) {
                return CallChecker.isCalled(npe_invocation_var341, Collection.class, 106, 3578, 3588).removeAll(coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1697.methodEnd();
        }
    }

    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1698 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 109, 3618, 3713);
            CallChecker.varInit(coll, "coll", 109, 3618, 3713);
            CallChecker.varInit(this.collection, "collection", 109, 3618, 3713);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 109, 3618, 3713);
            final Collection<D> npe_invocation_var342 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var342, Collection.class, 110, 3680, 3690)) {
                return CallChecker.isCalled(npe_invocation_var342, Collection.class, 110, 3680, 3690).retainAll(coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1698.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context1699 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 114, 3720, 3838);
            CallChecker.varInit(object, "object", 114, 3720, 3838);
            CallChecker.varInit(this.collection, "collection", 114, 3720, 3838);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 114, 3720, 3838);
            return (object == (this)) || (CallChecker.isCalled(decorated(), Collection.class, 115, 3806, 3816).equals(object));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1699.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1700 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 119, 3845, 3926);
            CallChecker.varInit(this.collection, "collection", 119, 3845, 3926);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 119, 3845, 3926);
            final Collection<D> npe_invocation_var343 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var343, Collection.class, 120, 3898, 3908)) {
                return CallChecker.isCalled(npe_invocation_var343, Collection.class, 120, 3898, 3908).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1700.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1701 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 124, 3933, 4017);
            CallChecker.varInit(this.collection, "collection", 124, 3933, 4017);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractUntypedCollectionDecorator.serialVersionUID", 124, 3933, 4017);
            final Collection<D> npe_invocation_var344 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var344, Collection.class, 125, 3989, 3999)) {
                return CallChecker.isCalled(npe_invocation_var344, Collection.class, 125, 3989, 3999).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1701.methodEnd();
        }
    }
}

