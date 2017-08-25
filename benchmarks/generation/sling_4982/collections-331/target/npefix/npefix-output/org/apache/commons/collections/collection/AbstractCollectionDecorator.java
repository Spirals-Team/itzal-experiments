package org.apache.commons.collections.collection;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public abstract class AbstractCollectionDecorator<E> implements Serializable , Collection<E> {
    private static final long serialVersionUID = 6249888059822088500L;

    protected Collection<E> collection;

    protected AbstractCollectionDecorator() {
        super();
        MethodContext _bcornu_methode_context4 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    protected AbstractCollectionDecorator(Collection<E> coll) {
        MethodContext _bcornu_methode_context5 = new MethodContext(null);
        try {
            if (coll == null) {
                throw new IllegalArgumentException("Collection must not be null");
            }
            this.collection = coll;
            CallChecker.varAssign(this.collection, "this.collection", 72, 2874, 2896);
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    protected Collection<E> decorated() {
        MethodContext _bcornu_methode_context8 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 81, 2909, 3154);
            CallChecker.varInit(this.collection, "collection", 81, 2909, 3154);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 81, 2909, 3154);
            return collection;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public boolean add(E object) {
        MethodContext _bcornu_methode_context9 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 86, 3161, 3314);
            CallChecker.varInit(object, "object", 86, 3161, 3314);
            CallChecker.varInit(this.collection, "collection", 86, 3161, 3314);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 86, 3161, 3314);
            final Collection<E> npe_invocation_var3 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var3, Collection.class, 87, 3285, 3295)) {
                return CallChecker.isCalled(npe_invocation_var3, Collection.class, 87, 3285, 3295).add(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context10 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 90, 3321, 3420);
            CallChecker.varInit(coll, "coll", 90, 3321, 3420);
            CallChecker.varInit(this.collection, "collection", 90, 3321, 3420);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 90, 3321, 3420);
            final Collection<E> npe_invocation_var4 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var4, Collection.class, 91, 3390, 3400)) {
                return CallChecker.isCalled(npe_invocation_var4, Collection.class, 91, 3390, 3400).addAll(coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context11 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 94, 3427, 3482);
            CallChecker.varInit(this.collection, "collection", 94, 3427, 3482);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 94, 3427, 3482);
            final Collection<E> npe_invocation_var5 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var5, Collection.class, 95, 3457, 3467)) {
                CallChecker.isCalled(npe_invocation_var5, Collection.class, 95, 3457, 3467).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public boolean contains(Object object) {
        MethodContext _bcornu_methode_context12 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 98, 3489, 3579);
            CallChecker.varInit(object, "object", 98, 3489, 3579);
            CallChecker.varInit(this.collection, "collection", 98, 3489, 3579);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 98, 3489, 3579);
            final Collection<E> npe_invocation_var6 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var6, Collection.class, 99, 3545, 3555)) {
                return CallChecker.isCalled(npe_invocation_var6, Collection.class, 99, 3545, 3555).contains(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context13 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 102, 3586, 3655);
            CallChecker.varInit(this.collection, "collection", 102, 3586, 3655);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 102, 3586, 3655);
            final Collection<E> npe_invocation_var7 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var7, Collection.class, 103, 3628, 3638)) {
                return CallChecker.isCalled(npe_invocation_var7, Collection.class, 103, 3628, 3638).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context14 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 106, 3662, 3737);
            CallChecker.varInit(this.collection, "collection", 106, 3662, 3737);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 106, 3662, 3737);
            final Collection<E> npe_invocation_var8 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var8, Collection.class, 107, 3709, 3719)) {
                return CallChecker.isCalled(npe_invocation_var8, Collection.class, 107, 3709, 3719).iterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context15 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 110, 3744, 3830);
            CallChecker.varInit(object, "object", 110, 3744, 3830);
            CallChecker.varInit(this.collection, "collection", 110, 3744, 3830);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 110, 3744, 3830);
            final Collection<E> npe_invocation_var9 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var9, Collection.class, 111, 3798, 3808)) {
                return CallChecker.isCalled(npe_invocation_var9, Collection.class, 111, 3798, 3808).remove(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context16 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 114, 3837, 3896);
            CallChecker.varInit(this.collection, "collection", 114, 3837, 3896);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 114, 3837, 3896);
            final Collection<E> npe_invocation_var10 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var10, Collection.class, 115, 3872, 3882)) {
                return CallChecker.isCalled(npe_invocation_var10, Collection.class, 115, 3872, 3882).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public Object[] toArray() {
        MethodContext _bcornu_methode_context17 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 118, 3903, 3973);
            CallChecker.varInit(this.collection, "collection", 118, 3903, 3973);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 118, 3903, 3973);
            final Collection<E> npe_invocation_var11 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var11, Collection.class, 119, 3946, 3956)) {
                return CallChecker.isCalled(npe_invocation_var11, Collection.class, 119, 3946, 3956).toArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public <T> T[] toArray(T[] object) {
        MethodContext _bcornu_methode_context18 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 122, 3980, 4065);
            CallChecker.varInit(object, "object", 122, 3980, 4065);
            CallChecker.varInit(this.collection, "collection", 122, 3980, 4065);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 122, 3980, 4065);
            final Collection<E> npe_invocation_var12 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var12, Collection.class, 123, 4032, 4042)) {
                return CallChecker.isCalled(npe_invocation_var12, Collection.class, 123, 4032, 4042).toArray(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public boolean containsAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context19 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 126, 4072, 4171);
            CallChecker.varInit(coll, "coll", 126, 4072, 4171);
            CallChecker.varInit(this.collection, "collection", 126, 4072, 4171);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 126, 4072, 4171);
            final Collection<E> npe_invocation_var13 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var13, Collection.class, 127, 4136, 4146)) {
                return CallChecker.isCalled(npe_invocation_var13, Collection.class, 127, 4136, 4146).containsAll(coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context20 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 130, 4178, 4273);
            CallChecker.varInit(coll, "coll", 130, 4178, 4273);
            CallChecker.varInit(this.collection, "collection", 130, 4178, 4273);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 130, 4178, 4273);
            final Collection<E> npe_invocation_var14 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var14, Collection.class, 131, 4240, 4250)) {
                return CallChecker.isCalled(npe_invocation_var14, Collection.class, 131, 4240, 4250).removeAll(coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context21 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 134, 4280, 4375);
            CallChecker.varInit(coll, "coll", 134, 4280, 4375);
            CallChecker.varInit(this.collection, "collection", 134, 4280, 4375);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 134, 4280, 4375);
            final Collection<E> npe_invocation_var15 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var15, Collection.class, 135, 4342, 4352)) {
                return CallChecker.isCalled(npe_invocation_var15, Collection.class, 135, 4342, 4352).retainAll(coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context22 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 139, 4382, 4500);
            CallChecker.varInit(object, "object", 139, 4382, 4500);
            CallChecker.varInit(this.collection, "collection", 139, 4382, 4500);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 139, 4382, 4500);
            return (object == (this)) || (CallChecker.isCalled(decorated(), Collection.class, 140, 4468, 4478).equals(object));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context23 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 144, 4507, 4588);
            CallChecker.varInit(this.collection, "collection", 144, 4507, 4588);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 144, 4507, 4588);
            final Collection<E> npe_invocation_var16 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var16, Collection.class, 145, 4560, 4570)) {
                return CallChecker.isCalled(npe_invocation_var16, Collection.class, 145, 4560, 4570).hashCode();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context24 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 149, 4595, 4679);
            CallChecker.varInit(this.collection, "collection", 149, 4595, 4679);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.AbstractCollectionDecorator.serialVersionUID", 149, 4595, 4679);
            final Collection<E> npe_invocation_var17 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var17, Collection.class, 150, 4651, 4661)) {
                return CallChecker.isCalled(npe_invocation_var17, Collection.class, 150, 4651, 4661).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }
}

