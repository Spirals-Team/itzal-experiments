package org.apache.commons.collections.bag;

import org.apache.commons.collections.Transformer;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.SortedBag;
import org.apache.commons.collections.collection.TransformedCollection;

public class TransformedSortedBag<E> extends TransformedBag<E> implements SortedBag<E> {
    private static final long serialVersionUID = -251737742649401930L;

    public static <E> SortedBag<E> decorate(SortedBag<E> bag, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context653 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(transformer, "transformer", 57, 1753, 2432);
            CallChecker.varInit(bag, "bag", 57, 1753, 2432);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TransformedSortedBag.serialVersionUID", 57, 1753, 2432);
            return new TransformedSortedBag<E>(bag, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context653.methodEnd();
        }
    }

    public static <E> SortedBag<E> decorateTransform(SortedBag<E> bag, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context654 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(transformer, "transformer", 75, 2443, 3654);
            CallChecker.varInit(bag, "bag", 75, 2443, 3654);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TransformedSortedBag.serialVersionUID", 75, 2443, 3654);
            TransformedSortedBag<E> decorated = CallChecker.varInit(new TransformedSortedBag<E>(bag, transformer), "decorated", 76, 3191, 3273);
            if (((transformer != null) && (bag != null)) && ((bag.size()) > 0)) {
                @SuppressWarnings(value = "unchecked")
                E[] values = CallChecker.varInit(((E[]) (bag.toArray())), "values", 79, 3355, 3447);
                bag.clear();
                values = CallChecker.beforeCalled(values, null, 81, 3501, 3506);
                for (int i = 0; i < (CallChecker.isCalled(values, null, 81, 3501, 3506).length); i++) {
                    if (CallChecker.beforeDeref(decorated, TransformedSortedBag.class, 82, 3539, 3547)) {
                        if (CallChecker.beforeDeref(values, null, 82, 3587, 3592)) {
                            decorated = CallChecker.beforeCalled(decorated, TransformedSortedBag.class, 82, 3539, 3547);
                            final Collection<E> npe_invocation_var150 = CallChecker.isCalled(decorated, TransformedSortedBag.class, 82, 3539, 3547).decorated();
                            if (CallChecker.beforeDeref(npe_invocation_var150, Collection.class, 82, 3539, 3559)) {
                                CallChecker.isCalled(npe_invocation_var150, Collection.class, 82, 3539, 3559).add(transformer.transform(values[i]));
                            }
                        }
                    }
                }
            }
            return decorated;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context654.methodEnd();
        }
    }

    protected TransformedSortedBag(SortedBag<E> bag, Transformer<? super E, ? extends E> transformer) {
        super(bag, transformer);
        MethodContext _bcornu_methode_context118 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context118.methodEnd();
        }
    }

    protected SortedBag<E> getSortedBag() {
        MethodContext _bcornu_methode_context655 = new MethodContext(SortedBag.class);
        try {
            CallChecker.varInit(this, "this", 108, 4274, 4448);
            CallChecker.varInit(this.collection, "collection", 108, 4274, 4448);
            CallChecker.varInit(this.transformer, "transformer", 108, 4274, 4448);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TransformedSortedBag.serialVersionUID", 108, 4274, 4448);
            return ((SortedBag<E>) (collection));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context655.methodEnd();
        }
    }

    public E first() {
        final SortedBag<E> npe_invocation_var151 = getSortedBag();
        if (CallChecker.beforeDeref(npe_invocation_var151, SortedBag.class, 114, 4567, 4580)) {
            return npe_invocation_var151.first();
        }else
            throw new AbnormalExecutionError();
        
    }

    public E last() {
        final SortedBag<E> npe_invocation_var152 = getSortedBag();
        if (CallChecker.beforeDeref(npe_invocation_var152, SortedBag.class, 118, 4635, 4648)) {
            return npe_invocation_var152.last();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Comparator<? super E> comparator() {
        MethodContext _bcornu_methode_context658 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 121, 4669, 4761);
            CallChecker.varInit(this.collection, "collection", 121, 4669, 4761);
            CallChecker.varInit(this.transformer, "transformer", 121, 4669, 4761);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TransformedSortedBag.serialVersionUID", 121, 4669, 4761);
            final SortedBag<E> npe_invocation_var153 = getSortedBag();
            if (CallChecker.beforeDeref(npe_invocation_var153, SortedBag.class, 122, 4728, 4741)) {
                return CallChecker.isCalled(npe_invocation_var153, SortedBag.class, 122, 4728, 4741).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context658.methodEnd();
        }
    }
}

