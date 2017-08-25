package org.apache.commons.collections.set;

import org.apache.commons.collections.Transformer;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.SortedSet;
import org.apache.commons.collections.collection.TransformedCollection;

public class TransformedSortedSet<E> extends TransformedSet<E> implements SortedSet<E> {
    private static final long serialVersionUID = -1675486811351124386L;

    public static <E> SortedSet<E> decorate(SortedSet<E> set, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context273 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(transformer, "transformer", 55, 1725, 2361);
            CallChecker.varInit(set, "set", 55, 1725, 2361);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.TransformedSortedSet.serialVersionUID", 55, 1725, 2361);
            return new TransformedSortedSet<E>(set, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context273.methodEnd();
        }
    }

    public static <E> SortedSet<E> decorateTransform(SortedSet<E> set, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context274 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(transformer, "transformer", 73, 2372, 3581);
            CallChecker.varInit(set, "set", 73, 2372, 3581);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.TransformedSortedSet.serialVersionUID", 73, 2372, 3581);
            TransformedSortedSet<E> decorated = CallChecker.varInit(new TransformedSortedSet<E>(set, transformer), "decorated", 74, 3119, 3200);
            if (((transformer != null) && (set != null)) && ((set.size()) > 0)) {
                @SuppressWarnings(value = "unchecked")
                E[] values = CallChecker.varInit(((E[]) (set.toArray())), "values", 77, 3282, 3374);
                set.clear();
                values = CallChecker.beforeCalled(values, null, 79, 3428, 3433);
                for (int i = 0; i < (CallChecker.isCalled(values, null, 79, 3428, 3433).length); i++) {
                    if (CallChecker.beforeDeref(decorated, TransformedSortedSet.class, 80, 3466, 3474)) {
                        if (CallChecker.beforeDeref(values, null, 80, 3514, 3519)) {
                            decorated = CallChecker.beforeCalled(decorated, TransformedSortedSet.class, 80, 3466, 3474);
                            final Collection<E> npe_invocation_var105 = CallChecker.isCalled(decorated, TransformedSortedSet.class, 80, 3466, 3474).decorated();
                            if (CallChecker.beforeDeref(npe_invocation_var105, Collection.class, 80, 3466, 3486)) {
                                CallChecker.isCalled(npe_invocation_var105, Collection.class, 80, 3466, 3486).add(transformer.transform(values[i]));
                            }
                        }
                    }
                }
            }
            return decorated;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context274.methodEnd();
        }
    }

    protected TransformedSortedSet(SortedSet<E> set, Transformer<? super E, ? extends E> transformer) {
        super(set, transformer);
        MethodContext _bcornu_methode_context39 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }

    protected SortedSet<E> getSortedSet() {
        MethodContext _bcornu_methode_context275 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 106, 4201, 4375);
            CallChecker.varInit(this.collection, "collection", 106, 4201, 4375);
            CallChecker.varInit(this.transformer, "transformer", 106, 4201, 4375);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.TransformedSortedSet.serialVersionUID", 106, 4201, 4375);
            return ((SortedSet<E>) (collection));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context275.methodEnd();
        }
    }

    public E first() {
        final SortedSet<E> npe_invocation_var106 = getSortedSet();
        if (CallChecker.beforeDeref(npe_invocation_var106, SortedSet.class, 112, 4494, 4507)) {
            return npe_invocation_var106.first();
        }else
            throw new AbnormalExecutionError();
        
    }

    public E last() {
        final SortedSet<E> npe_invocation_var107 = getSortedSet();
        if (CallChecker.beforeDeref(npe_invocation_var107, SortedSet.class, 116, 4562, 4575)) {
            return npe_invocation_var107.last();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Comparator<? super E> comparator() {
        MethodContext _bcornu_methode_context278 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 119, 4596, 4688);
            CallChecker.varInit(this.collection, "collection", 119, 4596, 4688);
            CallChecker.varInit(this.transformer, "transformer", 119, 4596, 4688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.TransformedSortedSet.serialVersionUID", 119, 4596, 4688);
            final SortedSet<E> npe_invocation_var108 = getSortedSet();
            if (CallChecker.beforeDeref(npe_invocation_var108, SortedSet.class, 120, 4655, 4668)) {
                return CallChecker.isCalled(npe_invocation_var108, SortedSet.class, 120, 4655, 4668).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context278.methodEnd();
        }
    }

    public SortedSet<E> subSet(E fromElement, E toElement) {
        MethodContext _bcornu_methode_context279 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 124, 4695, 4970);
            CallChecker.varInit(toElement, "toElement", 124, 4695, 4970);
            CallChecker.varInit(fromElement, "fromElement", 124, 4695, 4970);
            CallChecker.varInit(this.collection, "collection", 124, 4695, 4970);
            CallChecker.varInit(this.transformer, "transformer", 124, 4695, 4970);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.TransformedSortedSet.serialVersionUID", 124, 4695, 4970);
            final SortedSet<E> npe_invocation_var109 = getSortedSet();
            SortedSet<E> set = CallChecker.init(SortedSet.class);
            if (CallChecker.beforeDeref(npe_invocation_var109, SortedSet.class, 125, 4857, 4870)) {
                set = CallChecker.isCalled(npe_invocation_var109, SortedSet.class, 125, 4857, 4870).subSet(fromElement, toElement);
                CallChecker.varAssign(set, "set", 125, 4857, 4870);
            }
            return new TransformedSortedSet<E>(set, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context279.methodEnd();
        }
    }

    public SortedSet<E> headSet(E toElement) {
        MethodContext _bcornu_methode_context280 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 129, 4977, 5148);
            CallChecker.varInit(toElement, "toElement", 129, 4977, 5148);
            CallChecker.varInit(this.collection, "collection", 129, 4977, 5148);
            CallChecker.varInit(this.transformer, "transformer", 129, 4977, 5148);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.TransformedSortedSet.serialVersionUID", 129, 4977, 5148);
            final SortedSet<E> npe_invocation_var110 = getSortedSet();
            SortedSet<E> set = CallChecker.init(SortedSet.class);
            if (CallChecker.beforeDeref(npe_invocation_var110, SortedSet.class, 130, 5047, 5060)) {
                set = CallChecker.isCalled(npe_invocation_var110, SortedSet.class, 130, 5047, 5060).headSet(toElement);
                CallChecker.varAssign(set, "set", 130, 5047, 5060);
            }
            return new TransformedSortedSet<E>(set, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context280.methodEnd();
        }
    }

    public SortedSet<E> tailSet(E fromElement) {
        MethodContext _bcornu_methode_context281 = new MethodContext(SortedSet.class);
        try {
            CallChecker.varInit(this, "this", 134, 5155, 5330);
            CallChecker.varInit(fromElement, "fromElement", 134, 5155, 5330);
            CallChecker.varInit(this.collection, "collection", 134, 5155, 5330);
            CallChecker.varInit(this.transformer, "transformer", 134, 5155, 5330);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.TransformedSortedSet.serialVersionUID", 134, 5155, 5330);
            final SortedSet<E> npe_invocation_var111 = getSortedSet();
            SortedSet<E> set = CallChecker.init(SortedSet.class);
            if (CallChecker.beforeDeref(npe_invocation_var111, SortedSet.class, 135, 5227, 5240)) {
                set = CallChecker.isCalled(npe_invocation_var111, SortedSet.class, 135, 5227, 5240).tailSet(fromElement);
                CallChecker.varAssign(set, "set", 135, 5227, 5240);
            }
            return new TransformedSortedSet<E>(set, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedSet<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context281.methodEnd();
        }
    }
}

