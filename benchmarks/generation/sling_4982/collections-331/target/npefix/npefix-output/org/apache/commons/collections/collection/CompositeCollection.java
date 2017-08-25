package org.apache.commons.collections.collection;

import org.apache.commons.collections.list.UnmodifiableList;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.List;
import org.apache.commons.collections.iterators.IteratorChain;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import org.apache.commons.collections.iterators.EmptyIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;

public class CompositeCollection<E> implements Serializable , Collection<E> {
    private static final long serialVersionUID = 8417515734108306801L;

    protected CompositeCollection.CollectionMutator<E> mutator;

    protected List<Collection<E>> all = new ArrayList<Collection<E>>();

    public CompositeCollection() {
        super();
        MethodContext _bcornu_methode_context46 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context46.methodEnd();
        }
    }

    public CompositeCollection(Collection<E> compositeCollection) {
        super();
        MethodContext _bcornu_methode_context47 = new MethodContext(null);
        try {
            addComposited(compositeCollection);
        } finally {
            _bcornu_methode_context47.methodEnd();
        }
    }

    public CompositeCollection(Collection<E> compositeCollection1, Collection<E> compositeCollection2) {
        super();
        MethodContext _bcornu_methode_context48 = new MethodContext(null);
        try {
            addComposited(compositeCollection1, compositeCollection2);
        } finally {
            _bcornu_methode_context48.methodEnd();
        }
    }

    public CompositeCollection(Collection<E>[] compositeCollections) {
        super();
        MethodContext _bcornu_methode_context49 = new MethodContext(null);
        try {
            addComposited(compositeCollections);
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context298 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 113, 3387, 4182);
            CallChecker.varInit(this.all, "all", 113, 3387, 4182);
            CallChecker.varInit(this.mutator, "mutator", 113, 3387, 4182);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 113, 3387, 4182);
            int size = CallChecker.varInit(((int) (0)), "size", 114, 4059, 4071);
            if (CallChecker.beforeDeref(all, int.class, 115, 4107, 4109)) {
                for (Collection<E> item : all) {
                    if (CallChecker.beforeDeref(item, Collection.class, 116, 4134, 4137)) {
                        size += CallChecker.isCalled(item, Collection.class, 116, 4134, 4137).size();
                        CallChecker.varAssign(size, "size", 116, 4126, 4145);
                    }
                }
            }
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context298.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context299 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 128, 4189, 4623);
            CallChecker.varInit(this.all, "all", 128, 4189, 4623);
            CallChecker.varInit(this.mutator, "mutator", 128, 4189, 4623);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 128, 4189, 4623);
            if (CallChecker.beforeDeref(all, boolean.class, 129, 4494, 4496)) {
                for (Collection<? extends E> item : all) {
                    if (CallChecker.beforeDeref(item, Collection.class, 130, 4517, 4520)) {
                        if ((CallChecker.isCalled(item, Collection.class, 130, 4517, 4520).isEmpty()) == false) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context299.methodEnd();
        }
    }

    public boolean contains(Object obj) {
        MethodContext _bcornu_methode_context300 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 145, 4630, 5136);
            CallChecker.varInit(obj, "obj", 145, 4630, 5136);
            CallChecker.varInit(this.all, "all", 145, 4630, 5136);
            CallChecker.varInit(this.mutator, "mutator", 145, 4630, 5136);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 145, 4630, 5136);
            if (CallChecker.beforeDeref(all, boolean.class, 146, 5012, 5014)) {
                for (Collection<? extends E> item : all) {
                    if (CallChecker.beforeDeref(item, Collection.class, 147, 5035, 5038)) {
                        if (CallChecker.isCalled(item, Collection.class, 147, 5035, 5038).contains(obj)) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context300.methodEnd();
        }
    }

    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context301 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 164, 5143, 5875);
            CallChecker.varInit(this.all, "all", 164, 5143, 5875);
            CallChecker.varInit(this.mutator, "mutator", 164, 5143, 5875);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 164, 5143, 5875);
            if (CallChecker.beforeDeref(all, List.class, 165, 5605, 5607)) {
                all = CallChecker.beforeCalled(all, List.class, 165, 5605, 5607);
                if (CallChecker.isCalled(all, List.class, 165, 5605, 5607).isEmpty()) {
                    return EmptyIterator.<E>getInstance();
                }
            }else
                throw new AbnormalExecutionError();
            
            IteratorChain<E> chain = CallChecker.varInit(new IteratorChain<E>(), "chain", 168, 5691, 5738);
            if (CallChecker.beforeDeref(all, Iterator.class, 169, 5784, 5786)) {
                for (Collection<? extends E> item : all) {
                    if (CallChecker.beforeDeref(item, Collection.class, 170, 5821, 5824)) {
                        if (CallChecker.beforeDeref(chain, IteratorChain.class, 170, 5803, 5807)) {
                            chain = CallChecker.beforeCalled(chain, IteratorChain.class, 170, 5803, 5807);
                            CallChecker.isCalled(chain, IteratorChain.class, 170, 5803, 5807).addIterator(CallChecker.isCalled(item, Collection.class, 170, 5821, 5824).iterator());
                        }
                    }
                }
            }
            return chain;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context301.methodEnd();
        }
    }

    public Object[] toArray() {
        MethodContext _bcornu_methode_context302 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 180, 5882, 6282);
            CallChecker.varInit(this.all, "all", 180, 5882, 6282);
            CallChecker.varInit(this.mutator, "mutator", 180, 5882, 6282);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 180, 5882, 6282);
            final Object[] result = CallChecker.varInit(new Object[size()], "result", 181, 6084, 6126);
            int i = CallChecker.varInit(((int) (0)), "i", 182, 6136, 6145);
            for (Iterator<E> it = iterator(); CallChecker.isCalled(it, Iterator.class, 183, 6189, 6190).hasNext(); i++) {
                if (CallChecker.beforeDeref(result, Object[].class, 184, 6222, 6227)) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 184, 6234, 6235)) {
                        CallChecker.isCalled(result, Object[].class, 184, 6222, 6227)[i] = it.next();
                        CallChecker.varAssign(CallChecker.isCalled(result, Object[].class, 184, 6222, 6227)[i], "CallChecker.isCalled(result, Object[].class, 184, 6222, 6227)[i]", 184, 6222, 6243);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context302.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public <T> T[] toArray(T[] array) {
        MethodContext _bcornu_methode_context303 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 197, 6289, 7170);
            CallChecker.varInit(array, "array", 197, 6289, 7170);
            CallChecker.varInit(this.all, "all", 197, 6289, 7170);
            CallChecker.varInit(this.mutator, "mutator", 197, 6289, 7170);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 197, 6289, 7170);
            int size = CallChecker.varInit(((int) (size())), "size", 198, 6653, 6670);
            Object[] result = CallChecker.varInit(null, "result", 199, 6680, 6702);
            if (CallChecker.beforeDeref(array, null, 200, 6716, 6720)) {
                array = CallChecker.beforeCalled(array, null, 200, 6716, 6720);
                if ((CallChecker.isCalled(array, null, 200, 6716, 6720).length) >= size) {
                    result = array;
                    CallChecker.varAssign(result, "result", 201, 6752, 6766);
                }else {
                    if (CallChecker.beforeDeref(array, null, 203, 6835, 6839)) {
                        array = CallChecker.beforeCalled(array, null, 203, 6835, 6839);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 203, 6835, 6839).getClass(), Class.class, 203, 6835, 6850)) {
                            array = CallChecker.beforeCalled(array, null, 203, 6835, 6839);
                            result = ((Object[]) (Array.newInstance(CallChecker.isCalled(CallChecker.isCalled(array, null, 203, 6835, 6839).getClass(), Class.class, 203, 6835, 6850).getComponentType(), size)));
                            CallChecker.varAssign(result, "result", 203, 6797, 6877);
                        }
                    }
                }
            }
            int offset = CallChecker.varInit(((int) (0)), "offset", 206, 6898, 6912);
            if (CallChecker.beforeDeref(all, null, 207, 6958, 6960)) {
                for (Collection<? extends E> item : all) {
                    if (CallChecker.beforeDeref(item, null, 208, 6988, 6991)) {
                        for (E e : item) {
                            if (CallChecker.beforeDeref(result, Object[].class, 209, 7012, 7017)) {
                                result = CallChecker.beforeCalled(result, Object[].class, 209, 7012, 7017);
                                CallChecker.isCalled(result, Object[].class, 209, 7012, 7017)[(offset++)] = e;
                                CallChecker.varAssign(CallChecker.isCalled(result, Object[].class, 209, 7012, 7017)[(offset - 1)], "CallChecker.isCalled(result, Object[].class, 209, 7012, 7017)[(offset - 1)]", 209, 7012, 7032);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Object[].class, 212, 7070, 7075)) {
                result = CallChecker.beforeCalled(result, Object[].class, 212, 7070, 7075);
                if ((CallChecker.isCalled(result, Object[].class, 212, 7070, 7075).length) > size) {
                    if (CallChecker.beforeDeref(result, Object[].class, 213, 7106, 7111)) {
                        result = CallChecker.beforeCalled(result, Object[].class, 213, 7106, 7111);
                        CallChecker.isCalled(result, Object[].class, 213, 7106, 7111)[size] = null;
                        CallChecker.varAssign(CallChecker.isCalled(result, Object[].class, 213, 7106, 7111)[size], "CallChecker.isCalled(result, Object[].class, 213, 7106, 7111)[size]", 213, 7106, 7125);
                    }
                }
            }
            return ((T[]) (result));
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context303.methodEnd();
        }
    }

    public boolean add(E obj) {
        MethodContext _bcornu_methode_context304 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 230, 7177, 8078);
            CallChecker.varInit(obj, "obj", 230, 7177, 8078);
            CallChecker.varInit(this.all, "all", 230, 7177, 8078);
            CallChecker.varInit(this.mutator, "mutator", 230, 7177, 8078);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 230, 7177, 8078);
            if ((mutator) == null) {
                throw new UnsupportedOperationException("add() is not supported on CompositeCollection without a CollectionMutator strategy");
            }
            return mutator.add(this, all, obj);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context304.methodEnd();
        }
    }

    public boolean remove(Object obj) {
        MethodContext _bcornu_methode_context305 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 249, 8085, 8940);
            CallChecker.varInit(obj, "obj", 249, 8085, 8940);
            CallChecker.varInit(this.all, "all", 249, 8085, 8940);
            CallChecker.varInit(this.mutator, "mutator", 249, 8085, 8940);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 249, 8085, 8940);
            if ((mutator) == null) {
                throw new UnsupportedOperationException("remove() is not supported on CompositeCollection without a CollectionMutator strategy");
            }
            return mutator.remove(this, all, obj);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context305.methodEnd();
        }
    }

    public boolean containsAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context306 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 266, 8947, 9483);
            CallChecker.varInit(coll, "coll", 266, 8947, 9483);
            CallChecker.varInit(this.all, "all", 266, 8947, 9483);
            CallChecker.varInit(this.mutator, "mutator", 266, 8947, 9483);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 266, 8947, 9483);
            if (CallChecker.beforeDeref(coll, boolean.class, 267, 9353, 9356)) {
                for (Object item : coll) {
                    if ((contains(item)) == false) {
                        return false;
                    }
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context306.methodEnd();
        }
    }

    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context307 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 287, 9490, 10447);
            CallChecker.varInit(coll, "coll", 287, 9490, 10447);
            CallChecker.varInit(this.all, "all", 287, 9490, 10447);
            CallChecker.varInit(this.mutator, "mutator", 287, 9490, 10447);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 287, 9490, 10447);
            if ((mutator) == null) {
                throw new UnsupportedOperationException("addAll() is not supported on CompositeCollection without a CollectionMutator strategy");
            }
            return mutator.addAll(this, all, coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context307.methodEnd();
        }
    }

    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context308 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 304, 10454, 11103);
            CallChecker.varInit(coll, "coll", 304, 10454, 11103);
            CallChecker.varInit(this.all, "all", 304, 10454, 11103);
            CallChecker.varInit(this.mutator, "mutator", 304, 10454, 11103);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 304, 10454, 11103);
            if (CallChecker.beforeDeref(coll, Collection.class, 305, 10880, 10883)) {
                coll = CallChecker.beforeCalled(coll, Collection.class, 305, 10880, 10883);
                if ((CallChecker.isCalled(coll, Collection.class, 305, 10880, 10883).size()) == 0) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            boolean changed = CallChecker.varInit(((boolean) (false)), "changed", 308, 10944, 10967);
            if (CallChecker.beforeDeref(all, boolean.class, 309, 11013, 11015)) {
                for (Collection<? extends E> item : all) {
                    if (CallChecker.beforeDeref(item, Collection.class, 310, 11043, 11046)) {
                        changed |= CallChecker.isCalled(item, Collection.class, 310, 11043, 11046).removeAll(coll);
                        CallChecker.varAssign(changed, "changed", 310, 11032, 11063);
                    }
                }
            }
            return changed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context308.methodEnd();
        }
    }

    public boolean retainAll(final Collection<?> coll) {
        MethodContext _bcornu_methode_context309 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 325, 11110, 11729);
            CallChecker.varInit(coll, "coll", 325, 11110, 11729);
            CallChecker.varInit(this.all, "all", 325, 11110, 11729);
            CallChecker.varInit(this.mutator, "mutator", 325, 11110, 11729);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 325, 11110, 11729);
            boolean changed = CallChecker.varInit(((boolean) (false)), "changed", 326, 11570, 11593);
            if (CallChecker.beforeDeref(all, boolean.class, 327, 11639, 11641)) {
                for (Collection<? extends E> item : all) {
                    if (CallChecker.beforeDeref(item, Collection.class, 328, 11669, 11672)) {
                        changed |= CallChecker.isCalled(item, Collection.class, 328, 11669, 11672).retainAll(coll);
                        CallChecker.varAssign(changed, "changed", 328, 11658, 11689);
                    }
                }
            }
            return changed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context309.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context310 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 340, 11736, 12084);
            CallChecker.varInit(this.all, "all", 340, 11736, 12084);
            CallChecker.varInit(this.mutator, "mutator", 340, 11736, 12084);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 340, 11736, 12084);
            if (CallChecker.beforeDeref(all, void.class, 341, 12037, 12039)) {
                for (Collection<? extends E> coll : all) {
                    if (CallChecker.beforeDeref(coll, Collection.class, 342, 12056, 12059)) {
                        CallChecker.isCalled(coll, Collection.class, 342, 12056, 12059).clear();
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context310.methodEnd();
        }
    }

    public void setMutator(CompositeCollection.CollectionMutator<E> mutator) {
        MethodContext _bcornu_methode_context311 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 352, 12091, 12397);
            CallChecker.varInit(mutator, "mutator", 352, 12091, 12397);
            CallChecker.varInit(this.all, "all", 352, 12091, 12397);
            CallChecker.varInit(this.mutator, "mutator", 352, 12091, 12397);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 352, 12091, 12397);
            this.mutator = mutator;
            CallChecker.varAssign(this.mutator, "this.mutator", 353, 12369, 12391);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context311.methodEnd();
        }
    }

    public void addComposited(Collection<E> compositeCollection) {
        MethodContext _bcornu_methode_context312 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 361, 12404, 12688);
            CallChecker.varInit(compositeCollection, "compositeCollection", 361, 12404, 12688);
            CallChecker.varInit(this.all, "all", 361, 12404, 12688);
            CallChecker.varInit(this.mutator, "mutator", 361, 12404, 12688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 361, 12404, 12688);
            if (CallChecker.beforeDeref(all, List.class, 362, 12654, 12656)) {
                all = CallChecker.beforeCalled(all, List.class, 362, 12654, 12656);
                CallChecker.isCalled(all, List.class, 362, 12654, 12656).add(compositeCollection);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context312.methodEnd();
        }
    }

    public void addComposited(Collection<E> compositeCollection1, Collection<E> compositeCollection2) {
        MethodContext _bcornu_methode_context313 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 371, 12695, 13140);
            CallChecker.varInit(compositeCollection2, "compositeCollection2", 371, 12695, 13140);
            CallChecker.varInit(compositeCollection1, "compositeCollection1", 371, 12695, 13140);
            CallChecker.varInit(this.all, "all", 371, 12695, 13140);
            CallChecker.varInit(this.mutator, "mutator", 371, 12695, 13140);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 371, 12695, 13140);
            if (CallChecker.beforeDeref(all, List.class, 372, 13066, 13068)) {
                all = CallChecker.beforeCalled(all, List.class, 372, 13066, 13068);
                CallChecker.isCalled(all, List.class, 372, 13066, 13068).add(compositeCollection1);
            }
            if (CallChecker.beforeDeref(all, List.class, 373, 13105, 13107)) {
                all = CallChecker.beforeCalled(all, List.class, 373, 13105, 13107);
                CallChecker.isCalled(all, List.class, 373, 13105, 13107).add(compositeCollection2);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context313.methodEnd();
        }
    }

    public void addComposited(Collection<E>[] compositeCollections) {
        MethodContext _bcornu_methode_context314 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 381, 13147, 13455);
            CallChecker.varInit(compositeCollections, "compositeCollections", 381, 13147, 13455);
            CallChecker.varInit(this.all, "all", 381, 13147, 13455);
            CallChecker.varInit(this.mutator, "mutator", 381, 13147, 13455);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 381, 13147, 13455);
            if (CallChecker.beforeDeref(all, List.class, 382, 13402, 13404)) {
                all = CallChecker.beforeCalled(all, List.class, 382, 13402, 13404);
                CallChecker.isCalled(all, List.class, 382, 13402, 13404).addAll(Arrays.asList(compositeCollections));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context314.methodEnd();
        }
    }

    public void removeComposited(Collection<E> coll) {
        MethodContext _bcornu_methode_context315 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 401, 13458, 14070);
            CallChecker.varInit(coll, "coll", 401, 13458, 14070);
            CallChecker.varInit(this.all, "all", 401, 13458, 14070);
            CallChecker.varInit(this.mutator, "mutator", 401, 13458, 14070);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 401, 13458, 14070);
            if (CallChecker.beforeDeref(all, List.class, 402, 14048, 14050)) {
                all = CallChecker.beforeCalled(all, List.class, 402, 14048, 14050);
                CallChecker.isCalled(all, List.class, 402, 14048, 14050).remove(coll);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context315.methodEnd();
        }
    }

    public Collection<E> toCollection() {
        MethodContext _bcornu_methode_context316 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 412, 14077, 14477);
            CallChecker.varInit(this.all, "all", 412, 14077, 14477);
            CallChecker.varInit(this.mutator, "mutator", 412, 14077, 14477);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 412, 14077, 14477);
            return new ArrayList<E>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context316.methodEnd();
        }
    }

    public List<? extends Collection<E>> getCollections() {
        MethodContext _bcornu_methode_context317 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 421, 14484, 14730);
            CallChecker.varInit(this.all, "all", 421, 14484, 14730);
            CallChecker.varInit(this.mutator, "mutator", 421, 14484, 14730);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 421, 14484, 14730);
            return UnmodifiableList.decorate(all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<? extends Collection<E>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context317.methodEnd();
        }
    }

    protected CompositeCollection.CollectionMutator<E> getMutator() {
        MethodContext _bcornu_methode_context318 = new MethodContext(CompositeCollection.CollectionMutator.class);
        try {
            CallChecker.varInit(this, "this", 429, 14737, 14938);
            CallChecker.varInit(this.all, "all", 429, 14737, 14938);
            CallChecker.varInit(this.mutator, "mutator", 429, 14737, 14938);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.collection.CompositeCollection.serialVersionUID", 429, 14737, 14938);
            return mutator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((CompositeCollection.CollectionMutator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context318.methodEnd();
        }
    }

    public interface CollectionMutator<E> extends Serializable {
        public boolean add(CompositeCollection<E> composite, List<Collection<E>> collections, E obj);

        public boolean addAll(CompositeCollection<E> composite, List<Collection<E>> collections, Collection<? extends E> coll);

        public boolean remove(CompositeCollection<E> composite, List<Collection<E>> collections, Object obj);
    }
}

