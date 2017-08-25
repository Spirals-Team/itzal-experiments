package org.apache.commons.collections.bag;

import org.apache.commons.collections.collection.SynchronizedCollection;
import org.apache.commons.collections.SortedBag;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.Bag;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class SynchronizedSortedBag<E> extends SynchronizedBag<E> implements SortedBag<E> {
    private static final long serialVersionUID = 722374056718497858L;

    public static <E> SortedBag<E> decorate(SortedBag<E> bag) {
        MethodContext _bcornu_methode_context1759 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(bag, "bag", 51, 1658, 2011);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.SynchronizedSortedBag.serialVersionUID", 51, 1658, 2011);
            return new SynchronizedSortedBag<E>(bag);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1759.methodEnd();
        }
    }

    protected SynchronizedSortedBag(SortedBag<E> bag) {
        super(bag);
        MethodContext _bcornu_methode_context343 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context343.methodEnd();
        }
    }

    protected SynchronizedSortedBag(Bag<E> bag, Object lock) {
        super(bag, lock);
        MethodContext _bcornu_methode_context344 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context344.methodEnd();
        }
    }

    protected SortedBag<E> getSortedBag() {
        MethodContext _bcornu_methode_context1760 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(this, "this", 82, 2693, 2873);
            CallChecker.varInit(this.lock, "lock", 82, 2693, 2873);
            CallChecker.varInit(this.collection, "collection", 82, 2693, 2873);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.SynchronizedSortedBag.serialVersionUID", 82, 2693, 2873);
            return ((SortedBag<E>) (collection));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1760.methodEnd();
        }
    }

    public synchronized E first() {
        synchronized(lock) {
            final SortedBag<E> npe_invocation_var365 = getSortedBag();
            if (CallChecker.beforeDeref(npe_invocation_var365, SortedBag.class, 89, 3043, 3056)) {
                return npe_invocation_var365.first();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    public synchronized E last() {
        synchronized(lock) {
            final SortedBag<E> npe_invocation_var366 = getSortedBag();
            if (CallChecker.beforeDeref(npe_invocation_var366, SortedBag.class, 95, 3168, 3181)) {
                return npe_invocation_var366.last();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    public synchronized Comparator<? super E> comparator() {
        MethodContext _bcornu_methode_context1763 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 99, 3212, 3361);
            CallChecker.varInit(this.lock, "lock", 99, 3212, 3361);
            CallChecker.varInit(this.collection, "collection", 99, 3212, 3361);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.SynchronizedSortedBag.serialVersionUID", 99, 3212, 3361);
            synchronized(lock) {
                final SortedBag<E> npe_invocation_var367 = getSortedBag();
                if (CallChecker.beforeDeref(npe_invocation_var367, SortedBag.class, 101, 3318, 3331)) {
                    return CallChecker.isCalled(npe_invocation_var367, SortedBag.class, 101, 3318, 3331).comparator();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1763.methodEnd();
        }
    }
}

