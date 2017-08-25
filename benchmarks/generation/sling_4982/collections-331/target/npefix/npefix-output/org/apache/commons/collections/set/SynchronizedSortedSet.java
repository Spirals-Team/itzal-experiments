package org.apache.commons.collections.set;

import org.apache.commons.collections.collection.SynchronizedCollection;
import java.util.SortedSet;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class SynchronizedSortedSet<E> extends SynchronizedCollection<E> implements SortedSet<E> {
    private static final long serialVersionUID = 2775582861954500111L;

    public static <T> SortedSet<T> decorate(SortedSet<T> set) {
        MethodContext _bcornu_methode_context567 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(set, "set", 48, 1605, 1906);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.SynchronizedSortedSet.serialVersionUID", 48, 1605, 1906);
            return new SynchronizedSortedSet<T>(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context567.methodEnd();
        }
    }

    protected SynchronizedSortedSet(SortedSet<E> set) {
        super(set);
        MethodContext _bcornu_methode_context103 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context103.methodEnd();
        }
    }

    protected SynchronizedSortedSet(SortedSet<E> set, Object lock) {
        super(set, lock);
        MethodContext _bcornu_methode_context104 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context104.methodEnd();
        }
    }

    protected SortedSet<E> getSortedSet() {
        MethodContext _bcornu_methode_context568 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 79, 2595, 2768);
            CallChecker.varInit(this.lock, "lock", 79, 2595, 2768);
            CallChecker.varInit(this.collection, "collection", 79, 2595, 2768);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.SynchronizedSortedSet.serialVersionUID", 79, 2595, 2768);
            return ((SortedSet<E>) (collection));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context568.methodEnd();
        }
    }

    public SortedSet<E> subSet(E fromElement, E toElement) {
        MethodContext _bcornu_methode_context569 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 84, 2775, 3240);
            CallChecker.varInit(toElement, "toElement", 84, 2775, 3240);
            CallChecker.varInit(fromElement, "fromElement", 84, 2775, 3240);
            CallChecker.varInit(this.lock, "lock", 84, 2775, 3240);
            CallChecker.varInit(this.collection, "collection", 84, 2775, 3240);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.SynchronizedSortedSet.serialVersionUID", 84, 2775, 3240);
            synchronized(lock) {
                final SortedSet<E> npe_invocation_var140 = getSortedSet();
                SortedSet<E> set = CallChecker.init(SortedSet.class);
                if (CallChecker.beforeDeref(npe_invocation_var140, SortedSet.class, 86, 2971, 2984)) {
                    set = CallChecker.isCalled(npe_invocation_var140, SortedSet.class, 86, 2971, 2984).subSet(fromElement, toElement);
                    CallChecker.varAssign(set, "set", 86, 2971, 2984);
                }
                return new SynchronizedSortedSet<E>(set, lock);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context569.methodEnd();
        }
    }

    public SortedSet<E> headSet(E toElement) {
        MethodContext _bcornu_methode_context570 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 93, 3247, 3609);
            CallChecker.varInit(toElement, "toElement", 93, 3247, 3609);
            CallChecker.varInit(this.lock, "lock", 93, 3247, 3609);
            CallChecker.varInit(this.collection, "collection", 93, 3247, 3609);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.SynchronizedSortedSet.serialVersionUID", 93, 3247, 3609);
            synchronized(lock) {
                final SortedSet<E> npe_invocation_var141 = getSortedSet();
                SortedSet<E> set = CallChecker.init(SortedSet.class);
                if (CallChecker.beforeDeref(npe_invocation_var141, SortedSet.class, 95, 3351, 3364)) {
                    set = CallChecker.isCalled(npe_invocation_var141, SortedSet.class, 95, 3351, 3364).headSet(toElement);
                    CallChecker.varAssign(set, "set", 95, 3351, 3364);
                }
                return new SynchronizedSortedSet<E>(set, lock);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context570.methodEnd();
        }
    }

    public SortedSet<E> tailSet(E fromElement) {
        MethodContext _bcornu_methode_context571 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 102, 3616, 3982);
            CallChecker.varInit(fromElement, "fromElement", 102, 3616, 3982);
            CallChecker.varInit(this.lock, "lock", 102, 3616, 3982);
            CallChecker.varInit(this.collection, "collection", 102, 3616, 3982);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.SynchronizedSortedSet.serialVersionUID", 102, 3616, 3982);
            synchronized(lock) {
                final SortedSet<E> npe_invocation_var142 = getSortedSet();
                SortedSet<E> set = CallChecker.init(SortedSet.class);
                if (CallChecker.beforeDeref(npe_invocation_var142, SortedSet.class, 104, 3722, 3735)) {
                    set = CallChecker.isCalled(npe_invocation_var142, SortedSet.class, 104, 3722, 3735).tailSet(fromElement);
                    CallChecker.varAssign(set, "set", 104, 3722, 3735);
                }
                return new SynchronizedSortedSet<E>(set, lock);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context571.methodEnd();
        }
    }

    public E first() {
        synchronized(lock) {
            final SortedSet<E> npe_invocation_var143 = getSortedSet();
            if (CallChecker.beforeDeref(npe_invocation_var143, SortedSet.class, 113, 4057, 4070)) {
                return npe_invocation_var143.first();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    public E last() {
        synchronized(lock) {
            final SortedSet<E> npe_invocation_var144 = getSortedSet();
            if (CallChecker.beforeDeref(npe_invocation_var144, SortedSet.class, 119, 4169, 4182)) {
                return npe_invocation_var144.last();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    public Comparator<? super E> comparator() {
        MethodContext _bcornu_methode_context574 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 123, 4213, 4349);
            CallChecker.varInit(this.lock, "lock", 123, 4213, 4349);
            CallChecker.varInit(this.collection, "collection", 123, 4213, 4349);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.SynchronizedSortedSet.serialVersionUID", 123, 4213, 4349);
            synchronized(lock) {
                final SortedSet<E> npe_invocation_var145 = getSortedSet();
                if (CallChecker.beforeDeref(npe_invocation_var145, SortedSet.class, 125, 4306, 4319)) {
                    return CallChecker.isCalled(npe_invocation_var145, SortedSet.class, 125, 4306, 4319).comparator();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context574.methodEnd();
        }
    }
}

