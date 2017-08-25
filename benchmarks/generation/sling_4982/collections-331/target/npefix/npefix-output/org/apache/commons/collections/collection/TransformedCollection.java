package org.apache.commons.collections.collection;

import org.apache.commons.collections.Transformer;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class TransformedCollection<E> extends AbstractCollectionDecorator<E> {
    private static final long serialVersionUID = 8692300188161871514L;

    protected final Transformer<? super E, ? extends E> transformer;

    public static <E> Collection<E> decorate(Collection<E> coll, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context2514 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(transformer, "transformer", 61, 1906, 2613);
            CallChecker.varInit(coll, "coll", 61, 1906, 2613);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.TransformedCollection.serialVersionUID", 61, 1906, 2613);
            return new TransformedCollection<E>(coll, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2514.methodEnd();
        }
    }

    public static <E> Collection<E> decorateTransform(Collection<E> collection, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context2515 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(transformer, "transformer", 79, 2620, 3956);
            CallChecker.varInit(collection, "collection", 79, 2620, 3956);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.TransformedCollection.serialVersionUID", 79, 2620, 3956);
            TransformedCollection<E> decorated = CallChecker.varInit(new TransformedCollection<E>(collection, transformer), "decorated", 80, 3405, 3495);
            if (CallChecker.beforeDeref(collection, Collection.class, 82, 3596, 3605)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 82, 3596, 3605);
                if ((CallChecker.isCalled(collection, Collection.class, 82, 3596, 3605).size()) > 0) {
                    E[] values = CallChecker.init(null);
                    if (CallChecker.beforeDeref(collection, Collection.class, 84, 3722, 3731)) {
                        collection = CallChecker.beforeCalled(collection, Collection.class, 84, 3722, 3731);
                        values = ((E[]) (CallChecker.isCalled(collection, Collection.class, 84, 3722, 3731).toArray()));
                        CallChecker.varAssign(values, "values", 84, 3722, 3731);
                    }
                    if (CallChecker.beforeDeref(collection, Collection.class, 85, 3756, 3765)) {
                        collection = CallChecker.beforeCalled(collection, Collection.class, 85, 3756, 3765);
                        CallChecker.isCalled(collection, Collection.class, 85, 3756, 3765).clear();
                    }
                    values = CallChecker.beforeCalled(values, null, 86, 3803, 3808);
                    for (int i = 0; i < (CallChecker.isCalled(values, null, 86, 3803, 3808).length); i++) {
                        if (CallChecker.beforeDeref(decorated, TransformedCollection.class, 87, 3841, 3849)) {
                            if (CallChecker.beforeDeref(values, null, 87, 3889, 3894)) {
                                if (CallChecker.beforeDeref(transformer, Transformer.class, 87, 3867, 3877)) {
                                    decorated = CallChecker.beforeCalled(decorated, TransformedCollection.class, 87, 3841, 3849);
                                    final Collection<E> npe_invocation_var444 = CallChecker.isCalled(decorated, TransformedCollection.class, 87, 3841, 3849).decorated();
                                    if (CallChecker.beforeDeref(npe_invocation_var444, Collection.class, 87, 3841, 3861)) {
                                        CallChecker.isCalled(npe_invocation_var444, Collection.class, 87, 3841, 3861).add(transformer.transform(values[i]));
                                    }
                                }
                            }
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return decorated;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2515.methodEnd();
        }
    }

    protected TransformedCollection(Collection<E> coll, Transformer<? super E, ? extends E> transformer) {
        super(coll);
        MethodContext _bcornu_methode_context467 = new MethodContext(null);
        try {
            if (transformer == null) {
                throw new IllegalArgumentException("Transformer must not be null");
            }
            this.transformer = transformer;
            CallChecker.varAssign(this.transformer, "this.transformer", 109, 4711, 4741);
        } finally {
            _bcornu_methode_context467.methodEnd();
        }
    }

    protected E transform(E object) {
        if (CallChecker.beforeDeref(transformer, Transformer.class, 121, 5016, 5026)) {
            return transformer.transform(object);
        }else
            throw new AbnormalExecutionError();
        
    }

    protected Collection<E> transform(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context2517 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 132, 5058, 5500);
            CallChecker.varInit(coll, "coll", 132, 5058, 5500);
            CallChecker.varInit(this.collection, "collection", 132, 5058, 5500);
            CallChecker.varInit(this.transformer, "transformer", 132, 5058, 5500);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.TransformedCollection.serialVersionUID", 132, 5058, 5500);
            List<E> list = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(coll, Collection.class, 133, 5382, 5385)) {
                coll = CallChecker.beforeCalled(coll, Collection.class, 133, 5382, 5385);
                list = new ArrayList<E>(CallChecker.isCalled(coll, Collection.class, 133, 5382, 5385).size());
                CallChecker.varAssign(list, "list", 133, 5382, 5385);
            }
            if (CallChecker.beforeDeref(coll, Collection.class, 134, 5418, 5421)) {
                for (E item : coll) {
                    if (CallChecker.beforeDeref(list, List.class, 135, 5438, 5441)) {
                        list = CallChecker.beforeCalled(list, List.class, 135, 5438, 5441);
                        CallChecker.isCalled(list, List.class, 135, 5438, 5441).add(transform(item));
                    }
                }
            }
            return list;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2517.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context2518 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 142, 5507, 5685);
            CallChecker.varInit(object, "object", 142, 5507, 5685);
            CallChecker.varInit(this.collection, "collection", 142, 5507, 5685);
            CallChecker.varInit(this.transformer, "transformer", 142, 5507, 5685);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.TransformedCollection.serialVersionUID", 142, 5507, 5685);
            final Collection<E> npe_invocation_var445 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var445, Collection.class, 143, 5645, 5655)) {
                return CallChecker.isCalled(npe_invocation_var445, Collection.class, 143, 5645, 5655).add(transform(object));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2518.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context2519 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 147, 5692, 5816);
            CallChecker.varInit(coll, "coll", 147, 5692, 5816);
            CallChecker.varInit(this.collection, "collection", 147, 5692, 5816);
            CallChecker.varInit(this.transformer, "transformer", 147, 5692, 5816);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.TransformedCollection.serialVersionUID", 147, 5692, 5816);
            final Collection<E> npe_invocation_var446 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var446, Collection.class, 148, 5775, 5785)) {
                return CallChecker.isCalled(npe_invocation_var446, Collection.class, 148, 5775, 5785).addAll(transform(coll));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2519.methodEnd();
        }
    }
}

