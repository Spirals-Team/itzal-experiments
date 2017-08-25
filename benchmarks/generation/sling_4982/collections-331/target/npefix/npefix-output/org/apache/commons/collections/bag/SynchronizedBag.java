package org.apache.commons.collections.bag;

import org.apache.commons.collections.set.SynchronizedSet;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.Bag;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Set;
import org.apache.commons.collections.collection.SynchronizedCollection;

public class SynchronizedBag<E> extends SynchronizedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 8084674570753837109L;

    public static <T> Bag<T> decorate(Bag<T> bag) {
        MethodContext _bcornu_methode_context1079 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(bag, "bag", 52, 1724, 2046);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.SynchronizedBag.serialVersionUID", 52, 1724, 2046);
            return new SynchronizedBag<T>(bag);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1079.methodEnd();
        }
    }

    protected SynchronizedBag(Bag<E> bag) {
        super(bag);
        MethodContext _bcornu_methode_context212 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context212.methodEnd();
        }
    }

    protected SynchronizedBag(Bag<E> bag, Object lock) {
        super(bag, lock);
        MethodContext _bcornu_methode_context213 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context213.methodEnd();
        }
    }

    protected Bag<E> getBag() {
        MethodContext _bcornu_methode_context1080 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(this, "this", 83, 2710, 2872);
            CallChecker.varInit(this.lock, "lock", 83, 2710, 2872);
            CallChecker.varInit(this.collection, "collection", 83, 2710, 2872);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.SynchronizedBag.serialVersionUID", 83, 2710, 2872);
            return ((Bag<E>) (collection));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1080.methodEnd();
        }
    }

    public boolean add(E object, int count) {
        MethodContext _bcornu_methode_context1081 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 88, 2883, 3095);
            CallChecker.varInit(count, "count", 88, 2883, 3095);
            CallChecker.varInit(object, "object", 88, 2883, 3095);
            CallChecker.varInit(this.lock, "lock", 88, 2883, 3095);
            CallChecker.varInit(this.collection, "collection", 88, 2883, 3095);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.SynchronizedBag.serialVersionUID", 88, 2883, 3095);
            synchronized(lock) {
                final Bag<E> npe_invocation_var249 = getBag();
                if (CallChecker.beforeDeref(npe_invocation_var249, Bag.class, 90, 3052, 3059)) {
                    return CallChecker.isCalled(npe_invocation_var249, Bag.class, 90, 3052, 3059).add(object, count);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1081.methodEnd();
        }
    }

    public boolean remove(Object object, int count) {
        MethodContext _bcornu_methode_context1082 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 94, 3102, 3247);
            CallChecker.varInit(count, "count", 94, 3102, 3247);
            CallChecker.varInit(object, "object", 94, 3102, 3247);
            CallChecker.varInit(this.lock, "lock", 94, 3102, 3247);
            CallChecker.varInit(this.collection, "collection", 94, 3102, 3247);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.SynchronizedBag.serialVersionUID", 94, 3102, 3247);
            synchronized(lock) {
                final Bag<E> npe_invocation_var250 = getBag();
                if (CallChecker.beforeDeref(npe_invocation_var250, Bag.class, 96, 3201, 3208)) {
                    return CallChecker.isCalled(npe_invocation_var250, Bag.class, 96, 3201, 3208).remove(object, count);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1082.methodEnd();
        }
    }

    public Set<E> uniqueSet() {
        MethodContext _bcornu_methode_context1083 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 100, 3254, 3427);
            CallChecker.varInit(this.lock, "lock", 100, 3254, 3427);
            CallChecker.varInit(this.collection, "collection", 100, 3254, 3427);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.SynchronizedBag.serialVersionUID", 100, 3254, 3427);
            synchronized(lock) {
                final Bag<E> npe_invocation_var251 = getBag();
                Set<E> set = CallChecker.init(Set.class);
                if (CallChecker.beforeDeref(npe_invocation_var251, Bag.class, 102, 3337, 3344)) {
                    set = CallChecker.isCalled(npe_invocation_var251, Bag.class, 102, 3337, 3344).uniqueSet();
                    CallChecker.varAssign(set, "set", 102, 3337, 3344);
                }
                return new SynchronizedBagSet(set, lock);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1083.methodEnd();
        }
    }

    public int getCount(Object object) {
        MethodContext _bcornu_methode_context1084 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 107, 3434, 3561);
            CallChecker.varInit(object, "object", 107, 3434, 3561);
            CallChecker.varInit(this.lock, "lock", 107, 3434, 3561);
            CallChecker.varInit(this.collection, "collection", 107, 3434, 3561);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.SynchronizedBag.serialVersionUID", 107, 3434, 3561);
            synchronized(lock) {
                final Bag<E> npe_invocation_var252 = getBag();
                if (CallChecker.beforeDeref(npe_invocation_var252, Bag.class, 109, 3520, 3527)) {
                    return CallChecker.isCalled(npe_invocation_var252, Bag.class, 109, 3520, 3527).getCount(object);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1084.methodEnd();
        }
    }

    class SynchronizedBagSet extends SynchronizedSet<E> {
        private static final long serialVersionUID = 2990565892366827855L;

        SynchronizedBagSet(Set<E> set, Object lock) {
            super(set, lock);
            MethodContext _bcornu_methode_context214 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context214.methodEnd();
            }
        }
    }
}

