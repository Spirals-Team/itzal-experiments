package org.apache.commons.collections.map;

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

abstract class AbstractInputCheckedMapDecorator<K, V> extends AbstractMapDecorator<K, V> {
    protected AbstractInputCheckedMapDecorator() {
        super();
        MethodContext _bcornu_methode_context505 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context505.methodEnd();
        }
    }

    protected AbstractInputCheckedMapDecorator(Map<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context506 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context506.methodEnd();
        }
    }

    protected abstract V checkSetValue(V value);

    protected boolean isSetValueChecking() {
        MethodContext _bcornu_methode_context2698 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 94, 3340, 3763);
            CallChecker.varInit(this.map, "map", 94, 3340, 3763);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2698.methodEnd();
        }
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context2699 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 100, 3770, 4039);
            CallChecker.varInit(this.map, "map", 100, 3770, 4039);
            if (isSetValueChecking()) {
                if (CallChecker.beforeDeref(map, Map.class, 102, 3971, 3973)) {
                    map = CallChecker.beforeCalled(map, Map.class, 102, 3971, 3973);
                    return new EntrySet(CallChecker.isCalled(map, Map.class, 102, 3971, 3973).entrySet(), this);
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(map, Map.class, 104, 4019, 4021)) {
                map = CallChecker.beforeCalled(map, Map.class, 104, 4019, 4021);
                return CallChecker.isCalled(map, Map.class, 104, 4019, 4021).entrySet();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2699.methodEnd();
        }
    }

    @SuppressWarnings(value = "serial")
    private class EntrySet extends AbstractSetDecorator<Map.Entry<K, V>> {
        private final AbstractInputCheckedMapDecorator<K, V> parent;

        protected EntrySet(Set<Map.Entry<K, V>> set, AbstractInputCheckedMapDecorator<K, V> parent) {
            super(set);
            MethodContext _bcornu_methode_context507 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 119, 4564, 4584);
            } finally {
                _bcornu_methode_context507.methodEnd();
            }
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            MethodContext _bcornu_methode_context2700 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 123, 4605, 4749);
                CallChecker.varInit(this.collection, "collection", 123, 4605, 4749);
                CallChecker.varInit(this.parent, "parent", 123, 4605, 4749);
                if (CallChecker.beforeDeref(collection, Collection.class, 124, 4709, 4718)) {
                    collection = CallChecker.beforeCalled(collection, Collection.class, 124, 4709, 4718);
                    return new EntrySetIterator(CallChecker.isCalled(collection, Collection.class, 124, 4709, 4718).iterator(), parent);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2700.methodEnd();
            }
        }

        @Override
        @SuppressWarnings(value = "unchecked")
        public Object[] toArray() {
            MethodContext _bcornu_methode_context2701 = new MethodContext(Object[].class);
            try {
                CallChecker.varInit(this, "this", 129, 4768, 5082);
                CallChecker.varInit(this.collection, "collection", 129, 4768, 5082);
                CallChecker.varInit(this.parent, "parent", 129, 4768, 5082);
                Object[] array = CallChecker.init(Object[].class);
                if (CallChecker.beforeDeref(collection, Collection.class, 130, 4882, 4891)) {
                    collection = CallChecker.beforeCalled(collection, Collection.class, 130, 4882, 4891);
                    array = CallChecker.isCalled(collection, Collection.class, 130, 4882, 4891).toArray();
                    CallChecker.varAssign(array, "array", 130, 4882, 4891);
                }
                array = CallChecker.beforeCalled(array, Object[].class, 131, 4936, 4940);
                for (int i = 0; i < (CallChecker.isCalled(array, Object[].class, 131, 4936, 4940).length); i++) {
                    if (CallChecker.beforeDeref(array, Object[].class, 132, 4973, 4977)) {
                        if (CallChecker.beforeDeref(array, Object[].class, 132, 5015, 5019)) {
                            array = CallChecker.beforeCalled(array, Object[].class, 132, 4973, 4977);
                            array = CallChecker.beforeCalled(array, Object[].class, 132, 5015, 5019);
                            CallChecker.isCalled(array, Object[].class, 132, 4973, 4977)[i] = new MapEntry(((Map.Entry<K, V>) (CallChecker.isCalled(array, Object[].class, 132, 5015, 5019)[i])), parent);
                            CallChecker.varAssign(CallChecker.isCalled(array, Object[].class, 132, 4973, 4977)[i], "CallChecker.isCalled(array, Object[].class, 132, 4973, 4977)[i]", 132, 4973, 5032);
                        }
                    }
                }
                return array;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2701.methodEnd();
            }
        }

        @Override
        @SuppressWarnings(value = "unchecked")
        public <T> T[] toArray(T[] array) {
            MethodContext _bcornu_methode_context2702 = new MethodContext(null);
            try {
                CallChecker.varInit(this, "this", 139, 5101, 6180);
                CallChecker.varInit(array, "array", 139, 5101, 6180);
                CallChecker.varInit(this.collection, "collection", 139, 5101, 6180);
                CallChecker.varInit(this.parent, "parent", 139, 5101, 6180);
                Object[] result = CallChecker.varInit(array, "result", 140, 5206, 5229);
                if (CallChecker.beforeDeref(array, null, 141, 5247, 5251)) {
                    array = CallChecker.beforeCalled(array, null, 141, 5247, 5251);
                    if ((CallChecker.isCalled(array, null, 141, 5247, 5251).length) > 0) {
                        if (CallChecker.beforeDeref(array, null, 144, 5483, 5487)) {
                            array = CallChecker.beforeCalled(array, null, 144, 5483, 5487);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 144, 5483, 5487).getClass(), Class.class, 144, 5483, 5498)) {
                                array = CallChecker.beforeCalled(array, null, 144, 5483, 5487);
                                result = ((Object[]) (Array.newInstance(CallChecker.isCalled(CallChecker.isCalled(array, null, 144, 5483, 5487).getClass(), Class.class, 144, 5483, 5498).getComponentType(), 0)));
                                CallChecker.varAssign(result, "result", 144, 5445, 5522);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(collection, Collection.class, 146, 5559, 5568)) {
                    collection = CallChecker.beforeCalled(collection, Collection.class, 146, 5559, 5568);
                    result = CallChecker.isCalled(collection, Collection.class, 146, 5559, 5568).toArray(result);
                    CallChecker.varAssign(result, "result", 146, 5550, 5585);
                }
                result = CallChecker.beforeCalled(result, Object[].class, 147, 5619, 5624);
                for (int i = 0; i < (CallChecker.isCalled(result, Object[].class, 147, 5619, 5624).length); i++) {
                    if (CallChecker.beforeDeref(result, Object[].class, 148, 5657, 5662)) {
                        if (CallChecker.beforeDeref(result, Object[].class, 148, 5700, 5705)) {
                            result = CallChecker.beforeCalled(result, Object[].class, 148, 5657, 5662);
                            result = CallChecker.beforeCalled(result, Object[].class, 148, 5700, 5705);
                            CallChecker.isCalled(result, Object[].class, 148, 5657, 5662)[i] = new MapEntry(((Map.Entry<K, V>) (CallChecker.isCalled(result, Object[].class, 148, 5700, 5705)[i])), parent);
                            CallChecker.varAssign(CallChecker.isCalled(result, Object[].class, 148, 5657, 5662)[i], "CallChecker.isCalled(result, Object[].class, 148, 5657, 5662)[i]", 148, 5657, 5718);
                        }
                    }
                }
                if (CallChecker.beforeDeref(result, Object[].class, 152, 5817, 5822)) {
                    if (CallChecker.beforeDeref(array, null, 152, 5833, 5837)) {
                        result = CallChecker.beforeCalled(result, Object[].class, 152, 5817, 5822);
                        array = CallChecker.beforeCalled(array, null, 152, 5833, 5837);
                        if ((CallChecker.isCalled(result, Object[].class, 152, 5817, 5822).length) > (CallChecker.isCalled(array, null, 152, 5833, 5837).length)) {
                            return ((T[]) (result));
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(result, Object[].class, 157, 6023, 6028)) {
                    result = CallChecker.beforeCalled(result, Object[].class, 157, 6023, 6028);
                    System.arraycopy(result, 0, array, 0, CallChecker.isCalled(result, Object[].class, 157, 6023, 6028).length);
                }
                if (CallChecker.beforeDeref(array, null, 158, 6055, 6059)) {
                    if (CallChecker.beforeDeref(result, Object[].class, 158, 6070, 6075)) {
                        array = CallChecker.beforeCalled(array, null, 158, 6055, 6059);
                        result = CallChecker.beforeCalled(result, Object[].class, 158, 6070, 6075);
                        if ((CallChecker.isCalled(array, null, 158, 6055, 6059).length) > (CallChecker.isCalled(result, Object[].class, 158, 6070, 6075).length)) {
                            if (CallChecker.beforeDeref(result, Object[].class, 159, 6109, 6114)) {
                                if (CallChecker.beforeDeref(array, null, 159, 6103, 6107)) {
                                    result = CallChecker.beforeCalled(result, Object[].class, 159, 6109, 6114);
                                    array[CallChecker.isCalled(result, Object[].class, 159, 6109, 6114).length] = null;
                                    CallChecker.varAssign(array[CallChecker.isCalled(result, Object[].class, 159, 6109, 6114).length], "array[CallChecker.isCalled(result, Object[].class, 159, 6109, 6114).length]", 159, 6103, 6130);
                                }
                            }
                        }
                    }
                }
                return array;
            } catch (ForceReturn _bcornu_return_t) {
                return ((T[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2702.methodEnd();
            }
        }
    }

    private class EntrySetIterator extends AbstractIteratorDecorator<Map.Entry<K, V>> {
        private final AbstractInputCheckedMapDecorator<K, V> parent;

        protected EntrySetIterator(Iterator<Map.Entry<K, V>> iterator, AbstractInputCheckedMapDecorator<K, V> parent) {
            super(iterator);
            MethodContext _bcornu_methode_context508 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 175, 6638, 6658);
            } finally {
                _bcornu_methode_context508.methodEnd();
            }
        }

        @Override
        public Map.Entry<K, V> next() {
            MethodContext _bcornu_methode_context2703 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 179, 6679, 6838);
                CallChecker.varInit(this.iterator, "iterator", 179, 6679, 6838);
                CallChecker.varInit(this.parent, "parent", 179, 6679, 6838);
                Map.Entry<K, V> entry = CallChecker.init(Map.Entry.class);
                if (CallChecker.beforeDeref(iterator, Iterator.class, 180, 6765, 6772)) {
                    entry = CallChecker.isCalled(iterator, Iterator.class, 180, 6765, 6772).next();
                    CallChecker.varAssign(entry, "entry", 180, 6765, 6772);
                }
                return new MapEntry(entry, parent);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2703.methodEnd();
            }
        }
    }

    private class MapEntry extends AbstractMapEntryDecorator<K, V> {
        private final AbstractInputCheckedMapDecorator<K, V> parent;

        protected MapEntry(Map.Entry<K, V> entry, AbstractInputCheckedMapDecorator<K, V> parent) {
            super(entry);
            MethodContext _bcornu_methode_context509 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 195, 7243, 7263);
            } finally {
                _bcornu_methode_context509.methodEnd();
            }
        }

        @Override
        public V setValue(V value) {
            if (CallChecker.beforeDeref(parent, AbstractInputCheckedMapDecorator.class, 200, 7351, 7356)) {
                value = parent.checkSetValue(value);
                CallChecker.varAssign(value, "value", 200, 7343, 7378);
            }
            if (CallChecker.beforeDeref(entry, Map.Entry.class, 201, 7399, 7403)) {
                return entry.setValue(value);
            }else
                throw new AbnormalExecutionError();
            
        }
    }
}

