package org.apache.commons.collections.list;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class TransformedList<E> extends TransformedCollection<E> implements List<E> {
    private static final long serialVersionUID = 1077193035000013141L;

    public static <E> List<E> decorate(List<E> list, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context169 = new MethodContext(List.class);
        try {
            CallChecker.varInit(transformer, "transformer", 58, 1902, 2523);
            CallChecker.varInit(list, "list", 58, 1902, 2523);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.TransformedList.serialVersionUID", 58, 1902, 2523);
            return new TransformedList<E>(list, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context169.methodEnd();
        }
    }

    public static <E> List<E> decorateTransform(List<E> list, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context170 = new MethodContext(List.class);
        try {
            CallChecker.varInit(transformer, "transformer", 76, 2534, 3720);
            CallChecker.varInit(list, "list", 76, 2534, 3720);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.TransformedList.serialVersionUID", 76, 2534, 3720);
            TransformedList<E> decorated = CallChecker.varInit(new TransformedList<E>(list, transformer), "decorated", 77, 3259, 3331);
            if (((transformer != null) && (list != null)) && ((list.size()) > 0)) {
                @SuppressWarnings(value = "unchecked")
                E[] values = CallChecker.varInit(((E[]) (list.toArray())), "values", 80, 3415, 3512);
                list.clear();
                values = CallChecker.beforeCalled(values, null, 82, 3567, 3572);
                for (int i = 0; i < (CallChecker.isCalled(values, null, 82, 3567, 3572).length); i++) {
                    if (CallChecker.beforeDeref(decorated, TransformedList.class, 83, 3605, 3613)) {
                        if (CallChecker.beforeDeref(values, null, 83, 3653, 3658)) {
                            decorated = CallChecker.beforeCalled(decorated, TransformedList.class, 83, 3605, 3613);
                            final Collection<E> npe_invocation_var33 = CallChecker.isCalled(decorated, TransformedList.class, 83, 3605, 3613).decorated();
                            if (CallChecker.beforeDeref(npe_invocation_var33, Collection.class, 83, 3605, 3625)) {
                                CallChecker.isCalled(npe_invocation_var33, Collection.class, 83, 3605, 3625).add(transformer.transform(values[i]));
                            }
                        }
                    }
                }
            }
            return decorated;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context170.methodEnd();
        }
    }

    protected TransformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        super(list, transformer);
        MethodContext _bcornu_methode_context29 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    protected List<E> getList() {
        MethodContext _bcornu_methode_context171 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 109, 4336, 4497);
            CallChecker.varInit(this.collection, "collection", 109, 4336, 4497);
            CallChecker.varInit(this.transformer, "transformer", 109, 4336, 4497);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.TransformedList.serialVersionUID", 109, 4336, 4497);
            return ((List<E>) (collection));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context171.methodEnd();
        }
    }

    public E get(int index) {
        final List<E> npe_invocation_var34 = getList();
        if (CallChecker.beforeDeref(npe_invocation_var34, List.class, 115, 4623, 4631)) {
            return npe_invocation_var34.get(index);
        }else
            throw new AbnormalExecutionError();
        
    }

    public int indexOf(Object object) {
        MethodContext _bcornu_methode_context173 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 118, 4656, 4738);
            CallChecker.varInit(object, "object", 118, 4656, 4738);
            CallChecker.varInit(this.collection, "collection", 118, 4656, 4738);
            CallChecker.varInit(this.transformer, "transformer", 118, 4656, 4738);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.TransformedList.serialVersionUID", 118, 4656, 4738);
            final List<E> npe_invocation_var35 = getList();
            if (CallChecker.beforeDeref(npe_invocation_var35, List.class, 119, 4707, 4715)) {
                return CallChecker.isCalled(npe_invocation_var35, List.class, 119, 4707, 4715).indexOf(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context173.methodEnd();
        }
    }

    public int lastIndexOf(Object object) {
        MethodContext _bcornu_methode_context174 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 122, 4745, 4835);
            CallChecker.varInit(object, "object", 122, 4745, 4835);
            CallChecker.varInit(this.collection, "collection", 122, 4745, 4835);
            CallChecker.varInit(this.transformer, "transformer", 122, 4745, 4835);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.TransformedList.serialVersionUID", 122, 4745, 4835);
            final List<E> npe_invocation_var36 = getList();
            if (CallChecker.beforeDeref(npe_invocation_var36, List.class, 123, 4800, 4808)) {
                return CallChecker.isCalled(npe_invocation_var36, List.class, 123, 4800, 4808).lastIndexOf(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context174.methodEnd();
        }
    }

    public E remove(int index) {
        final List<E> npe_invocation_var37 = getList();
        if (CallChecker.beforeDeref(npe_invocation_var37, List.class, 127, 4886, 4894)) {
            return npe_invocation_var37.remove(index);
        }else
            throw new AbnormalExecutionError();
        
    }

    public void add(int index, E object) {
        MethodContext _bcornu_methode_context176 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 131, 4922, 5117);
            CallChecker.varInit(object, "object", 131, 4922, 5117);
            CallChecker.varInit(index, "index", 131, 4922, 5117);
            CallChecker.varInit(this.collection, "collection", 131, 4922, 5117);
            CallChecker.varInit(this.transformer, "transformer", 131, 4922, 5117);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.TransformedList.serialVersionUID", 131, 4922, 5117);
            object = transform(object);
            CallChecker.varAssign(object, "object", 132, 5047, 5073);
            final List<E> npe_invocation_var38 = getList();
            if (CallChecker.beforeDeref(npe_invocation_var38, List.class, 133, 5083, 5091)) {
                CallChecker.isCalled(npe_invocation_var38, List.class, 133, 5083, 5091).add(index, object);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context176.methodEnd();
        }
    }

    public boolean addAll(int index, Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context177 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 136, 5124, 5271);
            CallChecker.varInit(coll, "coll", 136, 5124, 5271);
            CallChecker.varInit(index, "index", 136, 5124, 5271);
            CallChecker.varInit(this.collection, "collection", 136, 5124, 5271);
            CallChecker.varInit(this.transformer, "transformer", 136, 5124, 5271);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.TransformedList.serialVersionUID", 136, 5124, 5271);
            coll = transform(coll);
            CallChecker.varAssign(coll, "coll", 137, 5197, 5219);
            final List<E> npe_invocation_var39 = getList();
            if (CallChecker.beforeDeref(npe_invocation_var39, List.class, 138, 5236, 5244)) {
                return CallChecker.isCalled(npe_invocation_var39, List.class, 138, 5236, 5244).addAll(index, coll);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context177.methodEnd();
        }
    }

    public ListIterator<E> listIterator() {
        MethodContext _bcornu_methode_context178 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 141, 5278, 5354);
            CallChecker.varInit(this.collection, "collection", 141, 5278, 5354);
            CallChecker.varInit(this.transformer, "transformer", 141, 5278, 5354);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.TransformedList.serialVersionUID", 141, 5278, 5354);
            return listIterator(0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context178.methodEnd();
        }
    }

    public ListIterator<E> listIterator(int i) {
        MethodContext _bcornu_methode_context179 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 145, 5361, 5481);
            CallChecker.varInit(i, "i", 145, 5361, 5481);
            CallChecker.varInit(this.collection, "collection", 145, 5361, 5481);
            CallChecker.varInit(this.transformer, "transformer", 145, 5361, 5481);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.TransformedList.serialVersionUID", 145, 5361, 5481);
            final List<E> npe_invocation_var40 = getList();
            if (CallChecker.beforeDeref(npe_invocation_var40, List.class, 146, 5449, 5457)) {
                return new TransformedListIterator(CallChecker.isCalled(npe_invocation_var40, List.class, 146, 5449, 5457).listIterator(i));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context179.methodEnd();
        }
    }

    public E set(int index, E object) {
        object = transform(object);
        CallChecker.varAssign(object, "object", 150, 5532, 5558);
        final List<E> npe_invocation_var41 = getList();
        if (CallChecker.beforeDeref(npe_invocation_var41, List.class, 151, 5575, 5583)) {
            return npe_invocation_var41.set(index, object);
        }else
            throw new AbnormalExecutionError();
        
    }

    public List<E> subList(int fromIndex, int toIndex) {
        MethodContext _bcornu_methode_context181 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 154, 5616, 5791);
            CallChecker.varInit(toIndex, "toIndex", 154, 5616, 5791);
            CallChecker.varInit(fromIndex, "fromIndex", 154, 5616, 5791);
            CallChecker.varInit(this.collection, "collection", 154, 5616, 5791);
            CallChecker.varInit(this.transformer, "transformer", 154, 5616, 5791);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.TransformedList.serialVersionUID", 154, 5616, 5791);
            final List<E> npe_invocation_var42 = getList();
            List<E> sub = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(npe_invocation_var42, List.class, 155, 5691, 5699)) {
                sub = CallChecker.isCalled(npe_invocation_var42, List.class, 155, 5691, 5699).subList(fromIndex, toIndex);
                CallChecker.varAssign(sub, "sub", 155, 5691, 5699);
            }
            return new TransformedList<E>(sub, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context181.methodEnd();
        }
    }

    protected class TransformedListIterator extends AbstractListIteratorDecorator<E> {
        protected TransformedListIterator(ListIterator<E> iterator) {
            super(iterator);
            MethodContext _bcornu_methode_context30 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context30.methodEnd();
            }
        }

        @Override
        public void add(E object) {
            MethodContext _bcornu_methode_context182 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 169, 6068, 6196);
                CallChecker.varInit(object, "object", 169, 6068, 6196);
                CallChecker.varInit(this.iterator, "iterator", 169, 6068, 6196);
                object = transform(object);
                CallChecker.varAssign(object, "object", 170, 6126, 6152);
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 171, 6166, 6173)) {
                    CallChecker.isCalled(iterator, ListIterator.class, 171, 6166, 6173).add(object);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context182.methodEnd();
            }
        }

        @Override
        public void set(E object) {
            MethodContext _bcornu_methode_context183 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 175, 6207, 6335);
                CallChecker.varInit(object, "object", 175, 6207, 6335);
                CallChecker.varInit(this.iterator, "iterator", 175, 6207, 6335);
                object = transform(object);
                CallChecker.varAssign(object, "object", 176, 6265, 6291);
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 177, 6305, 6312)) {
                    CallChecker.isCalled(iterator, ListIterator.class, 177, 6305, 6312).set(object);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context183.methodEnd();
            }
        }
    }
}

