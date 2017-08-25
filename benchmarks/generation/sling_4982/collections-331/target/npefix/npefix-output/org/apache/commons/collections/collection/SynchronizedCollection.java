package org.apache.commons.collections.collection;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class SynchronizedCollection<E> implements Serializable , Collection<E> {
    private static final long serialVersionUID = 2412805092710877986L;

    protected final Collection<E> collection;

    protected final Object lock;

    public static <T> Collection<T> decorate(Collection<T> coll) {
        MethodContext _bcornu_methode_context659 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(coll, "coll", 61, 1884, 2319);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 61, 1884, 2319);
            return new SynchronizedCollection<T>(coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context659.methodEnd();
        }
    }

    protected SynchronizedCollection(Collection<E> collection) {
        MethodContext _bcornu_methode_context119 = new MethodContext(null);
        try {
            if (collection == null) {
                throw new IllegalArgumentException("Collection must not be null");
            }
            this.collection = collection;
            CallChecker.varAssign(this.collection, "this.collection", 76, 2801, 2829);
            this.lock = this;
            CallChecker.varAssign(this.lock, "this.lock", 77, 2839, 2855);
        } finally {
            _bcornu_methode_context119.methodEnd();
        }
    }

    protected SynchronizedCollection(Collection<E> collection, Object lock) {
        MethodContext _bcornu_methode_context120 = new MethodContext(null);
        try {
            if (collection == null) {
                throw new IllegalArgumentException("Collection must not be null");
            }
            this.collection = collection;
            CallChecker.varAssign(this.collection, "this.collection", 91, 3339, 3367);
            this.lock = lock;
            CallChecker.varAssign(this.lock, "this.lock", 92, 3377, 3393);
        } finally {
            _bcornu_methode_context120.methodEnd();
        }
    }

    protected Collection<E> decorated() {
        MethodContext _bcornu_methode_context660 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 100, 3406, 3583);
            CallChecker.varInit(this.lock, "lock", 100, 3406, 3583);
            CallChecker.varInit(this.collection, "collection", 100, 3406, 3583);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 100, 3406, 3583);
            return collection;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context660.methodEnd();
        }
    }

    public boolean add(E object) {
        MethodContext _bcornu_methode_context661 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 105, 3590, 3787);
            CallChecker.varInit(object, "object", 105, 3590, 3787);
            CallChecker.varInit(this.lock, "lock", 105, 3590, 3787);
            CallChecker.varInit(this.collection, "collection", 105, 3590, 3787);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 105, 3590, 3787);
            synchronized(lock) {
                final Collection<E> npe_invocation_var154 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var154, Collection.class, 107, 3748, 3758)) {
                    return CallChecker.isCalled(npe_invocation_var154, Collection.class, 107, 3748, 3758).add(object);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context661.methodEnd();
        }
    }

    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context662 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 111, 3794, 3937);
            CallChecker.varInit(coll, "coll", 111, 3794, 3937);
            CallChecker.varInit(this.lock, "lock", 111, 3794, 3937);
            CallChecker.varInit(this.collection, "collection", 111, 3794, 3937);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 111, 3794, 3937);
            synchronized(lock) {
                final Collection<E> npe_invocation_var155 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var155, Collection.class, 113, 3897, 3907)) {
                    return CallChecker.isCalled(npe_invocation_var155, Collection.class, 113, 3897, 3907).addAll(coll);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context662.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context663 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 117, 3944, 4043);
            CallChecker.varInit(this.lock, "lock", 117, 3944, 4043);
            CallChecker.varInit(this.collection, "collection", 117, 3944, 4043);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 117, 3944, 4043);
            synchronized(lock) {
                final Collection<E> npe_invocation_var156 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var156, Collection.class, 119, 4008, 4018)) {
                    CallChecker.isCalled(npe_invocation_var156, Collection.class, 119, 4008, 4018).clear();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context663.methodEnd();
        }
    }

    public boolean contains(Object object) {
        MethodContext _bcornu_methode_context664 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 123, 4050, 4184);
            CallChecker.varInit(object, "object", 123, 4050, 4184);
            CallChecker.varInit(this.lock, "lock", 123, 4050, 4184);
            CallChecker.varInit(this.collection, "collection", 123, 4050, 4184);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 123, 4050, 4184);
            synchronized(lock) {
                final Collection<E> npe_invocation_var157 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var157, Collection.class, 125, 4140, 4150)) {
                    return CallChecker.isCalled(npe_invocation_var157, Collection.class, 125, 4140, 4150).contains(object);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context664.methodEnd();
        }
    }

    public boolean containsAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context665 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 129, 4191, 4334);
            CallChecker.varInit(coll, "coll", 129, 4191, 4334);
            CallChecker.varInit(this.lock, "lock", 129, 4191, 4334);
            CallChecker.varInit(this.collection, "collection", 129, 4191, 4334);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 129, 4191, 4334);
            synchronized(lock) {
                final Collection<E> npe_invocation_var158 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var158, Collection.class, 131, 4289, 4299)) {
                    return CallChecker.isCalled(npe_invocation_var158, Collection.class, 131, 4289, 4299).containsAll(coll);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context665.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context666 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 135, 4341, 4454);
            CallChecker.varInit(this.lock, "lock", 135, 4341, 4454);
            CallChecker.varInit(this.collection, "collection", 135, 4341, 4454);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 135, 4341, 4454);
            synchronized(lock) {
                final Collection<E> npe_invocation_var159 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var159, Collection.class, 137, 4417, 4427)) {
                    return CallChecker.isCalled(npe_invocation_var159, Collection.class, 137, 4417, 4427).isEmpty();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context666.methodEnd();
        }
    }

    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context667 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 151, 4461, 4814);
            CallChecker.varInit(this.lock, "lock", 151, 4461, 4814);
            CallChecker.varInit(this.collection, "collection", 151, 4461, 4814);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 151, 4461, 4814);
            final Collection<E> npe_invocation_var160 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var160, Collection.class, 152, 4786, 4796)) {
                return CallChecker.isCalled(npe_invocation_var160, Collection.class, 152, 4786, 4796).iterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context667.methodEnd();
        }
    }

    public Object[] toArray() {
        MethodContext _bcornu_methode_context668 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 155, 4821, 4935);
            CallChecker.varInit(this.lock, "lock", 155, 4821, 4935);
            CallChecker.varInit(this.collection, "collection", 155, 4821, 4935);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 155, 4821, 4935);
            synchronized(lock) {
                final Collection<E> npe_invocation_var161 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var161, Collection.class, 157, 4898, 4908)) {
                    return CallChecker.isCalled(npe_invocation_var161, Collection.class, 157, 4898, 4908).toArray();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context668.methodEnd();
        }
    }

    public <T> T[] toArray(T[] object) {
        MethodContext _bcornu_methode_context669 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 161, 4942, 5071);
            CallChecker.varInit(object, "object", 161, 4942, 5071);
            CallChecker.varInit(this.lock, "lock", 161, 4942, 5071);
            CallChecker.varInit(this.collection, "collection", 161, 4942, 5071);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 161, 4942, 5071);
            synchronized(lock) {
                final Collection<E> npe_invocation_var162 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var162, Collection.class, 163, 5028, 5038)) {
                    return CallChecker.isCalled(npe_invocation_var162, Collection.class, 163, 5028, 5038).toArray(object);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context669.methodEnd();
        }
    }

    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context670 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 167, 5078, 5208);
            CallChecker.varInit(object, "object", 167, 5078, 5208);
            CallChecker.varInit(this.lock, "lock", 167, 5078, 5208);
            CallChecker.varInit(this.collection, "collection", 167, 5078, 5208);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 167, 5078, 5208);
            synchronized(lock) {
                final Collection<E> npe_invocation_var163 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var163, Collection.class, 169, 5166, 5176)) {
                    return CallChecker.isCalled(npe_invocation_var163, Collection.class, 169, 5166, 5176).remove(object);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context670.methodEnd();
        }
    }

    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context671 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 173, 5215, 5354);
            CallChecker.varInit(coll, "coll", 173, 5215, 5354);
            CallChecker.varInit(this.lock, "lock", 173, 5215, 5354);
            CallChecker.varInit(this.collection, "collection", 173, 5215, 5354);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 173, 5215, 5354);
            synchronized(lock) {
                final Collection<E> npe_invocation_var164 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var164, Collection.class, 175, 5311, 5321)) {
                    return CallChecker.isCalled(npe_invocation_var164, Collection.class, 175, 5311, 5321).removeAll(coll);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context671.methodEnd();
        }
    }

    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context672 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 179, 5361, 5500);
            CallChecker.varInit(coll, "coll", 179, 5361, 5500);
            CallChecker.varInit(this.lock, "lock", 179, 5361, 5500);
            CallChecker.varInit(this.collection, "collection", 179, 5361, 5500);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 179, 5361, 5500);
            synchronized(lock) {
                final Collection<E> npe_invocation_var165 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var165, Collection.class, 181, 5457, 5467)) {
                    return CallChecker.isCalled(npe_invocation_var165, Collection.class, 181, 5457, 5467).retainAll(coll);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context672.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context673 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 185, 5507, 5610);
            CallChecker.varInit(this.lock, "lock", 185, 5507, 5610);
            CallChecker.varInit(this.collection, "collection", 185, 5507, 5610);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 185, 5507, 5610);
            synchronized(lock) {
                final Collection<E> npe_invocation_var166 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var166, Collection.class, 187, 5576, 5586)) {
                    return CallChecker.isCalled(npe_invocation_var166, Collection.class, 187, 5576, 5586).size();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context673.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context674 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 192, 5617, 5838);
            CallChecker.varInit(object, "object", 192, 5617, 5838);
            CallChecker.varInit(this.lock, "lock", 192, 5617, 5838);
            CallChecker.varInit(this.collection, "collection", 192, 5617, 5838);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 192, 5617, 5838);
            synchronized(lock) {
                if (object == (this)) {
                    return true;
                }
                final Collection<E> npe_invocation_var167 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var167, Collection.class, 197, 5796, 5806)) {
                    return CallChecker.isCalled(npe_invocation_var167, Collection.class, 197, 5796, 5806).equals(object);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context674.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context675 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 202, 5845, 5970);
            CallChecker.varInit(this.lock, "lock", 202, 5845, 5970);
            CallChecker.varInit(this.collection, "collection", 202, 5845, 5970);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 202, 5845, 5970);
            synchronized(lock) {
                final Collection<E> npe_invocation_var168 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var168, Collection.class, 204, 5932, 5942)) {
                    return CallChecker.isCalled(npe_invocation_var168, Collection.class, 204, 5932, 5942).hashCode();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context675.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context676 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 209, 5977, 6105);
            CallChecker.varInit(this.lock, "lock", 209, 5977, 6105);
            CallChecker.varInit(this.collection, "collection", 209, 5977, 6105);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.SynchronizedCollection.serialVersionUID", 209, 5977, 6105);
            synchronized(lock) {
                final Collection<E> npe_invocation_var169 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var169, Collection.class, 211, 6067, 6077)) {
                    return CallChecker.isCalled(npe_invocation_var169, Collection.class, 211, 6067, 6077).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context676.methodEnd();
        }
    }
}

