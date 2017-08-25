package org.apache.commons.collections.bag;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.set.TransformedSet;
import org.apache.commons.collections.collection.TransformedCollection;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.Bag;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Set;

public class TransformedBag<E> extends TransformedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 5421170911299074185L;

    public static <E> Bag<E> decorate(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context764 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(transformer, "transformer", 59, 1859, 2507);
            CallChecker.varInit(bag, "bag", 59, 1859, 2507);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TransformedBag.serialVersionUID", 59, 1859, 2507);
            return new TransformedBag<E>(bag, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context764.methodEnd();
        }
    }

    public static <E> Bag<E> decorateTransform(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context765 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(transformer, "transformer", 77, 2518, 3686);
            CallChecker.varInit(bag, "bag", 77, 2518, 3686);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TransformedBag.serialVersionUID", 77, 2518, 3686);
            TransformedBag<E> decorated = CallChecker.varInit(new TransformedBag<E>(bag, transformer), "decorated", 78, 3233, 3302);
            if (((transformer != null) && (bag != null)) && ((bag.size()) > 0)) {
                @SuppressWarnings(value = "unchecked")
                E[] values = CallChecker.varInit(((E[]) (bag.toArray())), "values", 81, 3384, 3479);
                bag.clear();
                values = CallChecker.beforeCalled(values, null, 83, 3533, 3538);
                for (int i = 0; i < (CallChecker.isCalled(values, null, 83, 3533, 3538).length); i++) {
                    if (CallChecker.beforeDeref(decorated, TransformedBag.class, 84, 3571, 3579)) {
                        if (CallChecker.beforeDeref(values, null, 84, 3619, 3624)) {
                            decorated = CallChecker.beforeCalled(decorated, TransformedBag.class, 84, 3571, 3579);
                            final Collection<E> npe_invocation_var180 = CallChecker.isCalled(decorated, TransformedBag.class, 84, 3571, 3579).decorated();
                            if (CallChecker.beforeDeref(npe_invocation_var180, Collection.class, 84, 3571, 3591)) {
                                CallChecker.isCalled(npe_invocation_var180, Collection.class, 84, 3571, 3591).add(transformer.transform(values[i]));
                            }
                        }
                    }
                }
            }
            return decorated;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context765.methodEnd();
        }
    }

    protected TransformedBag(Bag<E> bag, Transformer<? super E, ? extends E> transformer) {
        super(bag, transformer);
        MethodContext _bcornu_methode_context142 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context142.methodEnd();
        }
    }

    protected Bag<E> getBag() {
        MethodContext _bcornu_methode_context766 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(this, "this", 110, 4294, 4450);
            CallChecker.varInit(this.collection, "collection", 110, 4294, 4450);
            CallChecker.varInit(this.transformer, "transformer", 110, 4294, 4450);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TransformedBag.serialVersionUID", 110, 4294, 4450);
            return ((Bag<E>) (collection));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context766.methodEnd();
        }
    }

    public int getCount(Object object) {
        MethodContext _bcornu_methode_context767 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 115, 4457, 4618);
            CallChecker.varInit(object, "object", 115, 4457, 4618);
            CallChecker.varInit(this.collection, "collection", 115, 4457, 4618);
            CallChecker.varInit(this.transformer, "transformer", 115, 4457, 4618);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TransformedBag.serialVersionUID", 115, 4457, 4618);
            final Bag<E> npe_invocation_var181 = getBag();
            if (CallChecker.beforeDeref(npe_invocation_var181, Bag.class, 116, 4587, 4594)) {
                return CallChecker.isCalled(npe_invocation_var181, Bag.class, 116, 4587, 4594).getCount(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context767.methodEnd();
        }
    }

    public boolean remove(Object object, int nCopies) {
        MethodContext _bcornu_methode_context768 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 119, 4625, 4730);
            CallChecker.varInit(nCopies, "nCopies", 119, 4625, 4730);
            CallChecker.varInit(object, "object", 119, 4625, 4730);
            CallChecker.varInit(this.collection, "collection", 119, 4625, 4730);
            CallChecker.varInit(this.transformer, "transformer", 119, 4625, 4730);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TransformedBag.serialVersionUID", 119, 4625, 4730);
            final Bag<E> npe_invocation_var182 = getBag();
            if (CallChecker.beforeDeref(npe_invocation_var182, Bag.class, 120, 4692, 4699)) {
                return CallChecker.isCalled(npe_invocation_var182, Bag.class, 120, 4692, 4699).remove(object, nCopies);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context768.methodEnd();
        }
    }

    public boolean add(E object, int nCopies) {
        MethodContext _bcornu_methode_context769 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 124, 4737, 4920);
            CallChecker.varInit(nCopies, "nCopies", 124, 4737, 4920);
            CallChecker.varInit(object, "object", 124, 4737, 4920);
            CallChecker.varInit(this.collection, "collection", 124, 4737, 4920);
            CallChecker.varInit(this.transformer, "transformer", 124, 4737, 4920);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TransformedBag.serialVersionUID", 124, 4737, 4920);
            final Bag<E> npe_invocation_var183 = getBag();
            if (CallChecker.beforeDeref(npe_invocation_var183, Bag.class, 125, 4874, 4881)) {
                return CallChecker.isCalled(npe_invocation_var183, Bag.class, 125, 4874, 4881).add(transform(object), nCopies);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context769.methodEnd();
        }
    }

    public Set<E> uniqueSet() {
        MethodContext _bcornu_methode_context770 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 128, 4927, 5063);
            CallChecker.varInit(this.collection, "collection", 128, 4927, 5063);
            CallChecker.varInit(this.transformer, "transformer", 128, 4927, 5063);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TransformedBag.serialVersionUID", 128, 4927, 5063);
            final Bag<E> npe_invocation_var184 = getBag();
            Set<E> set = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(npe_invocation_var184, Bag.class, 129, 4976, 4983)) {
                set = CallChecker.isCalled(npe_invocation_var184, Bag.class, 129, 4976, 4983).uniqueSet();
                CallChecker.varAssign(set, "set", 129, 4976, 4983);
            }
            return TransformedSet.<E>decorate(set, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context770.methodEnd();
        }
    }
}

