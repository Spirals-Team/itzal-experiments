package org.apache.commons.collections.bag;

import org.apache.commons.collections.SortedBag;
import org.apache.commons.collections.collection.PredicatedCollection;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class PredicatedSortedBag<E> extends PredicatedBag<E> implements SortedBag<E> {
    private static final long serialVersionUID = 3448581314086406616L;

    public static <T> SortedBag<T> decorate(SortedBag<T> bag, Predicate<? super T> predicate) {
        MethodContext _bcornu_methode_context1061 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(predicate, "predicate", 61, 1930, 2602);
            CallChecker.varInit(bag, "bag", 61, 1930, 2602);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.PredicatedSortedBag.serialVersionUID", 61, 1930, 2602);
            return new PredicatedSortedBag<T>(bag, predicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1061.methodEnd();
        }
    }

    protected PredicatedSortedBag(SortedBag<E> bag, Predicate<? super E> predicate) {
        super(bag, predicate);
        MethodContext _bcornu_methode_context207 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context207.methodEnd();
        }
    }

    @Override
    protected SortedBag<E> decorated() {
        MethodContext _bcornu_methode_context1062 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(this, "this", 87, 3267, 3466);
            CallChecker.varInit(this.collection, "collection", 87, 3267, 3466);
            CallChecker.varInit(this.predicate, "predicate", 87, 3267, 3466);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.PredicatedSortedBag.serialVersionUID", 87, 3267, 3466);
            return ((SortedBag<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1062.methodEnd();
        }
    }

    public E first() {
        final SortedBag<E> npe_invocation_var234 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var234, SortedBag.class, 93, 3589, 3599)) {
            return npe_invocation_var234.first();
        }else
            throw new AbnormalExecutionError();
        
    }

    public E last() {
        final SortedBag<E> npe_invocation_var235 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var235, SortedBag.class, 97, 3654, 3664)) {
            return npe_invocation_var235.last();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Comparator<? super E> comparator() {
        MethodContext _bcornu_methode_context1065 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 100, 3685, 3774);
            CallChecker.varInit(this.collection, "collection", 100, 3685, 3774);
            CallChecker.varInit(this.predicate, "predicate", 100, 3685, 3774);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.PredicatedSortedBag.serialVersionUID", 100, 3685, 3774);
            final SortedBag<E> npe_invocation_var236 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var236, SortedBag.class, 101, 3744, 3754)) {
                return CallChecker.isCalled(npe_invocation_var236, SortedBag.class, 101, 3744, 3754).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1065.methodEnd();
        }
    }
}

