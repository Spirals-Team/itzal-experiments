package org.apache.commons.collections.map;

import org.apache.commons.collections.Unmodifiable;
import java.util.Set;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.keyvalue.AbstractMapEntryDecorator;
import org.apache.commons.collections.set.AbstractSetDecorator;
import org.apache.commons.collections.iterators.AbstractUntypedIteratorDecorator;
import java.lang.reflect.Array;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public final class UnmodifiableEntrySet<K, V> extends AbstractSetDecorator<Map.Entry<K, V>> implements Unmodifiable {
    private static final long serialVersionUID = 1678353579659253473L;

    public static <K, V> Set<Map.Entry<K, V>> decorate(Set<Map.Entry<K, V>> set) {
        MethodContext _bcornu_methode_context1588 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(set, "set", 52, 1805, 2227);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableEntrySet.serialVersionUID", 52, 1805, 2227);
            if (set instanceof Unmodifiable) {
                return set;
            }
            return new UnmodifiableEntrySet<K, V>(set);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1588.methodEnd();
        }
    }

    private UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
        super(set);
        MethodContext _bcornu_methode_context310 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context310.methodEnd();
        }
    }

    @Override
    public boolean add(Map.Entry<K, V> object) {
        MethodContext _bcornu_methode_context1589 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 72, 2580, 2772);
            CallChecker.varInit(object, "object", 72, 2580, 2772);
            CallChecker.varInit(this.collection, "collection", 72, 2580, 2772);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableEntrySet.serialVersionUID", 72, 2580, 2772);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1589.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends Map.Entry<K, V>> coll) {
        MethodContext _bcornu_methode_context1590 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 77, 2779, 2916);
            CallChecker.varInit(coll, "coll", 77, 2779, 2916);
            CallChecker.varInit(this.collection, "collection", 77, 2779, 2916);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableEntrySet.serialVersionUID", 77, 2779, 2916);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1590.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1591 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 82, 2923, 3014);
            CallChecker.varInit(this.collection, "collection", 82, 2923, 3014);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableEntrySet.serialVersionUID", 82, 2923, 3014);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1591.methodEnd();
        }
    }

    @Override
    public boolean remove(Object object) {
        MethodContext _bcornu_methode_context1592 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 87, 3021, 3129);
            CallChecker.varInit(object, "object", 87, 3021, 3129);
            CallChecker.varInit(this.collection, "collection", 87, 3021, 3129);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableEntrySet.serialVersionUID", 87, 3021, 3129);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1592.methodEnd();
        }
    }

    @Override
    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1593 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 92, 3136, 3252);
            CallChecker.varInit(coll, "coll", 92, 3136, 3252);
            CallChecker.varInit(this.collection, "collection", 92, 3136, 3252);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableEntrySet.serialVersionUID", 92, 3136, 3252);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1593.methodEnd();
        }
    }

    @Override
    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context1594 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 97, 3259, 3375);
            CallChecker.varInit(coll, "coll", 97, 3259, 3375);
            CallChecker.varInit(this.collection, "collection", 97, 3259, 3375);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableEntrySet.serialVersionUID", 97, 3259, 3375);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1594.methodEnd();
        }
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        MethodContext _bcornu_methode_context1595 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 103, 3382, 3596);
            CallChecker.varInit(this.collection, "collection", 103, 3382, 3596);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableEntrySet.serialVersionUID", 103, 3382, 3596);
            if (CallChecker.beforeDeref(collection, Collection.class, 104, 3568, 3577)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 104, 3568, 3577);
                return new UnmodifiableEntrySetIterator(CallChecker.isCalled(collection, Collection.class, 104, 3568, 3577).iterator());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1595.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public Object[] toArray() {
        MethodContext _bcornu_methode_context1596 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 109, 3607, 3890);
            CallChecker.varInit(this.collection, "collection", 109, 3607, 3890);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableEntrySet.serialVersionUID", 109, 3607, 3890);
            Object[] array = CallChecker.init(Object[].class);
            if (CallChecker.beforeDeref(collection, Collection.class, 110, 3709, 3718)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 110, 3709, 3718);
                array = CallChecker.isCalled(collection, Collection.class, 110, 3709, 3718).toArray();
                CallChecker.varAssign(array, "array", 110, 3709, 3718);
            }
            array = CallChecker.beforeCalled(array, Object[].class, 111, 3759, 3763);
            for (int i = 0; i < (CallChecker.isCalled(array, Object[].class, 111, 3759, 3763).length); i++) {
                if (CallChecker.beforeDeref(array, Object[].class, 112, 3792, 3796)) {
                    if (CallChecker.beforeDeref(array, Object[].class, 112, 3843, 3847)) {
                        array = CallChecker.beforeCalled(array, Object[].class, 112, 3792, 3796);
                        array = CallChecker.beforeCalled(array, Object[].class, 112, 3843, 3847);
                        CallChecker.isCalled(array, Object[].class, 112, 3792, 3796)[i] = new UnmodifiableEntry(((Map.Entry<K, V>) (CallChecker.isCalled(array, Object[].class, 112, 3843, 3847)[i])));
                        CallChecker.varAssign(CallChecker.isCalled(array, Object[].class, 112, 3792, 3796)[i], "CallChecker.isCalled(array, Object[].class, 112, 3792, 3796)[i]", 112, 3792, 3852);
                    }
                }
            }
            return array;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1596.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public <T> T[] toArray(T[] array) {
        MethodContext _bcornu_methode_context1597 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 119, 3901, 4890);
            CallChecker.varInit(array, "array", 119, 3901, 4890);
            CallChecker.varInit(this.collection, "collection", 119, 3901, 4890);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.UnmodifiableEntrySet.serialVersionUID", 119, 3901, 4890);
            Object[] result = CallChecker.varInit(array, "result", 120, 3994, 4017);
            if (CallChecker.beforeDeref(array, null, 121, 4031, 4035)) {
                array = CallChecker.beforeCalled(array, null, 121, 4031, 4035);
                if ((CallChecker.isCalled(array, null, 121, 4031, 4035).length) > 0) {
                    if (CallChecker.beforeDeref(array, null, 124, 4255, 4259)) {
                        array = CallChecker.beforeCalled(array, null, 124, 4255, 4259);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 124, 4255, 4259).getClass(), Class.class, 124, 4255, 4270)) {
                            array = CallChecker.beforeCalled(array, null, 124, 4255, 4259);
                            result = ((Object[]) (Array.newInstance(CallChecker.isCalled(CallChecker.isCalled(array, null, 124, 4255, 4259).getClass(), Class.class, 124, 4255, 4270).getComponentType(), 0)));
                            CallChecker.varAssign(result, "result", 124, 4217, 4294);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(collection, Collection.class, 126, 4323, 4332)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 126, 4323, 4332);
                result = CallChecker.isCalled(collection, Collection.class, 126, 4323, 4332).toArray(result);
                CallChecker.varAssign(result, "result", 126, 4314, 4349);
            }
            result = CallChecker.beforeCalled(result, Object[].class, 127, 4379, 4384);
            for (int i = 0; i < (CallChecker.isCalled(result, Object[].class, 127, 4379, 4384).length); i++) {
                if (CallChecker.beforeDeref(result, Object[].class, 128, 4413, 4418)) {
                    if (CallChecker.beforeDeref(result, Object[].class, 128, 4465, 4470)) {
                        result = CallChecker.beforeCalled(result, Object[].class, 128, 4413, 4418);
                        result = CallChecker.beforeCalled(result, Object[].class, 128, 4465, 4470);
                        CallChecker.isCalled(result, Object[].class, 128, 4413, 4418)[i] = new UnmodifiableEntry(((Map.Entry<K, V>) (CallChecker.isCalled(result, Object[].class, 128, 4465, 4470)[i])));
                        CallChecker.varAssign(CallChecker.isCalled(result, Object[].class, 128, 4413, 4418)[i], "CallChecker.isCalled(result, Object[].class, 128, 4413, 4418)[i]", 128, 4413, 4475);
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Object[].class, 132, 4562, 4567)) {
                if (CallChecker.beforeDeref(array, null, 132, 4578, 4582)) {
                    result = CallChecker.beforeCalled(result, Object[].class, 132, 4562, 4567);
                    array = CallChecker.beforeCalled(array, null, 132, 4578, 4582);
                    if ((CallChecker.isCalled(result, Object[].class, 132, 4562, 4567).length) > (CallChecker.isCalled(array, null, 132, 4578, 4582).length)) {
                        return ((T[]) (result));
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(result, Object[].class, 137, 4753, 4758)) {
                result = CallChecker.beforeCalled(result, Object[].class, 137, 4753, 4758);
                System.arraycopy(result, 0, array, 0, CallChecker.isCalled(result, Object[].class, 137, 4753, 4758).length);
            }
            if (CallChecker.beforeDeref(array, null, 138, 4781, 4785)) {
                if (CallChecker.beforeDeref(result, Object[].class, 138, 4796, 4801)) {
                    array = CallChecker.beforeCalled(array, null, 138, 4781, 4785);
                    result = CallChecker.beforeCalled(result, Object[].class, 138, 4796, 4801);
                    if ((CallChecker.isCalled(array, null, 138, 4781, 4785).length) > (CallChecker.isCalled(result, Object[].class, 138, 4796, 4801).length)) {
                        if (CallChecker.beforeDeref(result, Object[].class, 139, 4831, 4836)) {
                            if (CallChecker.beforeDeref(array, null, 139, 4825, 4829)) {
                                result = CallChecker.beforeCalled(result, Object[].class, 139, 4831, 4836);
                                array[CallChecker.isCalled(result, Object[].class, 139, 4831, 4836).length] = null;
                                CallChecker.varAssign(array[CallChecker.isCalled(result, Object[].class, 139, 4831, 4836).length], "array[CallChecker.isCalled(result, Object[].class, 139, 4831, 4836).length]", 139, 4825, 4852);
                            }
                        }
                    }
                }
            }
            return array;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1597.methodEnd();
        }
    }

    private class UnmodifiableEntrySetIterator extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        protected UnmodifiableEntrySetIterator(Iterator<Map.Entry<K, V>> iterator) {
            super(iterator);
            MethodContext _bcornu_methode_context311 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context311.methodEnd();
            }
        }

        @Override
        public Map.Entry<K, V> next() {
            MethodContext _bcornu_methode_context1598 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 155, 5273, 5390);
                CallChecker.varInit(this.iterator, "iterator", 155, 5273, 5390);
                if (CallChecker.beforeDeref(iterator, Iterator.class, 156, 5364, 5371)) {
                    return new UnmodifiableEntry(CallChecker.isCalled(iterator, Iterator.class, 156, 5364, 5371).next());
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1598.methodEnd();
            }
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context1599 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 160, 5401, 5505);
                CallChecker.varInit(this.iterator, "iterator", 160, 5401, 5505);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1599.methodEnd();
            }
        }
    }

    private class UnmodifiableEntry extends AbstractMapEntryDecorator<K, V> {
        protected UnmodifiableEntry(Map.Entry<K, V> entry) {
            super(entry);
            MethodContext _bcornu_methode_context312 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context312.methodEnd();
            }
        }

        @Override
        public V setValue(V obj) {
            throw new UnsupportedOperationException();
        }
    }
}

