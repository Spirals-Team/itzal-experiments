package org.apache.commons.collections.map;

import org.apache.commons.collections.iterators.UnmodifiableListIterator;
import org.apache.commons.collections.list.UnmodifiableList;
import java.util.Iterator;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.AbstractList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Set;
import org.apache.commons.collections.iterators.UnmodifiableIterator;

public class LinkedMap<K, V> extends AbstractLinkedMap<K, V> implements Serializable , Cloneable {
    private static final long serialVersionUID = 9077234323521161066L;

    public LinkedMap() {
        super(AbstractHashedMap.DEFAULT_CAPACITY, AbstractHashedMap.DEFAULT_LOAD_FACTOR, AbstractHashedMap.DEFAULT_THRESHOLD);
        MethodContext _bcornu_methode_context255 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context255.methodEnd();
        }
    }

    public LinkedMap(int initialCapacity) {
        super(initialCapacity);
        MethodContext _bcornu_methode_context256 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context256.methodEnd();
        }
    }

    public LinkedMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        MethodContext _bcornu_methode_context257 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context257.methodEnd();
        }
    }

    public LinkedMap(Map<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context258 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context258.methodEnd();
        }
    }

    @Override
    public LinkedMap<K, V> clone() {
        MethodContext _bcornu_methode_context1289 = new MethodContext(LinkedMap.class);
        try {
            CallChecker.varInit(this, "this", 117, 4318, 4607);
            CallChecker.varInit(this.values, "values", 117, 4318, 4607);
            CallChecker.varInit(this.keySet, "keySet", 117, 4318, 4607);
            CallChecker.varInit(this.entrySet, "entrySet", 117, 4318, 4607);
            CallChecker.varInit(this.modCount, "modCount", 117, 4318, 4607);
            CallChecker.varInit(this.threshold, "threshold", 117, 4318, 4607);
            CallChecker.varInit(this.data, "data", 117, 4318, 4607);
            CallChecker.varInit(this.size, "size", 117, 4318, 4607);
            CallChecker.varInit(this.loadFactor, "loadFactor", 117, 4318, 4607);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 117, 4318, 4607);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 117, 4318, 4607);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 117, 4318, 4607);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 117, 4318, 4607);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 117, 4318, 4607);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 117, 4318, 4607);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 117, 4318, 4607);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 117, 4318, 4607);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 117, 4318, 4607);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 117, 4318, 4607);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 117, 4318, 4607);
            CallChecker.varInit(this.header, "header", 117, 4318, 4607);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LinkedMap.serialVersionUID", 117, 4318, 4607);
            return ((LinkedMap<K, V>) (super.clone()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((LinkedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1289.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1290 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 124, 4618, 4819);
            CallChecker.varInit(out, "out", 124, 4618, 4819);
            CallChecker.varInit(this.values, "values", 124, 4618, 4819);
            CallChecker.varInit(this.keySet, "keySet", 124, 4618, 4819);
            CallChecker.varInit(this.entrySet, "entrySet", 124, 4618, 4819);
            CallChecker.varInit(this.modCount, "modCount", 124, 4618, 4819);
            CallChecker.varInit(this.threshold, "threshold", 124, 4618, 4819);
            CallChecker.varInit(this.data, "data", 124, 4618, 4819);
            CallChecker.varInit(this.size, "size", 124, 4618, 4819);
            CallChecker.varInit(this.loadFactor, "loadFactor", 124, 4618, 4819);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 124, 4618, 4819);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 124, 4618, 4819);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 124, 4618, 4819);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 124, 4618, 4819);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 124, 4618, 4819);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 124, 4618, 4819);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 124, 4618, 4819);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 124, 4618, 4819);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 124, 4618, 4819);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 124, 4618, 4819);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 124, 4618, 4819);
            CallChecker.varInit(this.header, "header", 124, 4618, 4819);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LinkedMap.serialVersionUID", 124, 4618, 4819);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 125, 4761, 4763)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 125, 4761, 4763);
                CallChecker.isCalled(out, ObjectOutputStream.class, 125, 4761, 4763).defaultWriteObject();
            }
            doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1290.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1291 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 132, 4826, 5042);
            CallChecker.varInit(in, "in", 132, 4826, 5042);
            CallChecker.varInit(this.values, "values", 132, 4826, 5042);
            CallChecker.varInit(this.keySet, "keySet", 132, 4826, 5042);
            CallChecker.varInit(this.entrySet, "entrySet", 132, 4826, 5042);
            CallChecker.varInit(this.modCount, "modCount", 132, 4826, 5042);
            CallChecker.varInit(this.threshold, "threshold", 132, 4826, 5042);
            CallChecker.varInit(this.data, "data", 132, 4826, 5042);
            CallChecker.varInit(this.size, "size", 132, 4826, 5042);
            CallChecker.varInit(this.loadFactor, "loadFactor", 132, 4826, 5042);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 132, 4826, 5042);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 132, 4826, 5042);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 132, 4826, 5042);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 132, 4826, 5042);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 132, 4826, 5042);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 132, 4826, 5042);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 132, 4826, 5042);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 132, 4826, 5042);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 132, 4826, 5042);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 132, 4826, 5042);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 132, 4826, 5042);
            CallChecker.varInit(this.header, "header", 132, 4826, 5042);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LinkedMap.serialVersionUID", 132, 4826, 5042);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 133, 4988, 4989)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 133, 4988, 4989);
                CallChecker.isCalled(in, ObjectInputStream.class, 133, 4988, 4989).defaultReadObject();
            }
            doReadObject(in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1291.methodEnd();
        }
    }

    public K get(int index) {
        final AbstractLinkedMap.LinkEntry<K, V> npe_invocation_var269 = getEntry(index);
        if (CallChecker.beforeDeref(npe_invocation_var269, AbstractLinkedMap.LinkEntry.class, 146, 5394, 5408)) {
            return npe_invocation_var269.getKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public V getValue(int index) {
        final AbstractLinkedMap.LinkEntry<K, V> npe_invocation_var270 = getEntry(index);
        if (CallChecker.beforeDeref(npe_invocation_var270, AbstractLinkedMap.LinkEntry.class, 157, 5707, 5721)) {
            return npe_invocation_var270.getValue();
        }else
            throw new AbnormalExecutionError();
        
    }

    public int indexOf(Object key) {
        MethodContext _bcornu_methode_context1294 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 166, 5750, 6209);
            CallChecker.varInit(key, "key", 166, 5750, 6209);
            CallChecker.varInit(this.values, "values", 166, 5750, 6209);
            CallChecker.varInit(this.keySet, "keySet", 166, 5750, 6209);
            CallChecker.varInit(this.entrySet, "entrySet", 166, 5750, 6209);
            CallChecker.varInit(this.modCount, "modCount", 166, 5750, 6209);
            CallChecker.varInit(this.threshold, "threshold", 166, 5750, 6209);
            CallChecker.varInit(this.data, "data", 166, 5750, 6209);
            CallChecker.varInit(this.size, "size", 166, 5750, 6209);
            CallChecker.varInit(this.loadFactor, "loadFactor", 166, 5750, 6209);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 166, 5750, 6209);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 166, 5750, 6209);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 166, 5750, 6209);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 166, 5750, 6209);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 166, 5750, 6209);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 166, 5750, 6209);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 166, 5750, 6209);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 166, 5750, 6209);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 166, 5750, 6209);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 166, 5750, 6209);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 166, 5750, 6209);
            CallChecker.varInit(this.header, "header", 166, 5750, 6209);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LinkedMap.serialVersionUID", 166, 5750, 6209);
            key = convertKey(key);
            CallChecker.varAssign(key, "key", 167, 5952, 5973);
            int i = CallChecker.varInit(((int) (0)), "i", 168, 5983, 5992);
            header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 169, 6031, 6036);
            for (AbstractLinkedMap.LinkEntry<K, V> entry = CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 169, 6031, 6036).after; entry != (header); entry = CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 169, 6070, 6074).after , i++) {
                CallChecker.varAssign(entry, "entry", 169, 6062, 6080);
                if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 170, 6122, 6126)) {
                    if (isEqualKey(key, CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 170, 6122, 6126).key)) {
                        return i;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1294.methodEnd();
        }
    }

    public V remove(int index) {
        return remove(get(index));
    }

    public List<K> asList() {
        MethodContext _bcornu_methode_context1296 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 204, 6600, 7356);
            CallChecker.varInit(this.values, "values", 204, 6600, 7356);
            CallChecker.varInit(this.keySet, "keySet", 204, 6600, 7356);
            CallChecker.varInit(this.entrySet, "entrySet", 204, 6600, 7356);
            CallChecker.varInit(this.modCount, "modCount", 204, 6600, 7356);
            CallChecker.varInit(this.threshold, "threshold", 204, 6600, 7356);
            CallChecker.varInit(this.data, "data", 204, 6600, 7356);
            CallChecker.varInit(this.size, "size", 204, 6600, 7356);
            CallChecker.varInit(this.loadFactor, "loadFactor", 204, 6600, 7356);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 204, 6600, 7356);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 204, 6600, 7356);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 204, 6600, 7356);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 204, 6600, 7356);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 204, 6600, 7356);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 204, 6600, 7356);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 204, 6600, 7356);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 204, 6600, 7356);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 204, 6600, 7356);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 204, 6600, 7356);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 204, 6600, 7356);
            CallChecker.varInit(this.header, "header", 204, 6600, 7356);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LinkedMap.serialVersionUID", 204, 6600, 7356);
            return new LinkedMap.LinkedMapList<K>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1296.methodEnd();
        }
    }

    static class LinkedMapList<K> extends AbstractList<K> {
        final LinkedMap<K, ?> parent;

        LinkedMapList(LinkedMap<K, ?> parent) {
            MethodContext _bcornu_methode_context259 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 216, 7560, 7580);
            } finally {
                _bcornu_methode_context259.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context1297 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 220, 7601, 7681);
                CallChecker.varInit(this.parent, "parent", 220, 7601, 7681);
                if (CallChecker.beforeDeref(parent, LinkedMap.class, 221, 7658, 7663)) {
                    return CallChecker.isCalled(parent, LinkedMap.class, 221, 7658, 7663).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1297.methodEnd();
            }
        }

        @Override
        public K get(int index) {
            if (CallChecker.beforeDeref(parent, LinkedMap.class, 226, 7755, 7760)) {
                return parent.get(index);
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        public boolean contains(Object obj) {
            MethodContext _bcornu_methode_context1299 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 230, 7793, 7901);
                CallChecker.varInit(obj, "obj", 230, 7793, 7901);
                CallChecker.varInit(this.parent, "parent", 230, 7793, 7901);
                if (CallChecker.beforeDeref(parent, LinkedMap.class, 231, 7868, 7873)) {
                    return CallChecker.isCalled(parent, LinkedMap.class, 231, 7868, 7873).containsKey(obj);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1299.methodEnd();
            }
        }

        @Override
        public int indexOf(Object obj) {
            MethodContext _bcornu_methode_context1300 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 235, 7912, 8011);
                CallChecker.varInit(obj, "obj", 235, 7912, 8011);
                CallChecker.varInit(this.parent, "parent", 235, 7912, 8011);
                if (CallChecker.beforeDeref(parent, LinkedMap.class, 236, 7982, 7987)) {
                    return CallChecker.isCalled(parent, LinkedMap.class, 236, 7982, 7987).indexOf(obj);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1300.methodEnd();
            }
        }

        @Override
        public int lastIndexOf(Object obj) {
            MethodContext _bcornu_methode_context1301 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 240, 8022, 8125);
                CallChecker.varInit(obj, "obj", 240, 8022, 8125);
                CallChecker.varInit(this.parent, "parent", 240, 8022, 8125);
                if (CallChecker.beforeDeref(parent, LinkedMap.class, 241, 8096, 8101)) {
                    return CallChecker.isCalled(parent, LinkedMap.class, 241, 8096, 8101).indexOf(obj);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1301.methodEnd();
            }
        }

        @Override
        public boolean containsAll(Collection<?> coll) {
            MethodContext _bcornu_methode_context1302 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 245, 8136, 8265);
                CallChecker.varInit(coll, "coll", 245, 8136, 8265);
                CallChecker.varInit(this.parent, "parent", 245, 8136, 8265);
                if (CallChecker.beforeDeref(parent, LinkedMap.class, 246, 8222, 8227)) {
                    final Set<K> npe_invocation_var271 = CallChecker.isCalled(parent, LinkedMap.class, 246, 8222, 8227).keySet();
                    if (CallChecker.beforeDeref(npe_invocation_var271, Set.class, 246, 8222, 8236)) {
                        return CallChecker.isCalled(npe_invocation_var271, Set.class, 246, 8222, 8236).containsAll(coll);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1302.methodEnd();
            }
        }

        @Override
        public K remove(int index) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object obj) {
            MethodContext _bcornu_methode_context1304 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 255, 8397, 8514);
                CallChecker.varInit(obj, "obj", 255, 8397, 8514);
                CallChecker.varInit(this.parent, "parent", 255, 8397, 8514);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1304.methodEnd();
            }
        }

        @Override
        public boolean removeAll(Collection<?> coll) {
            MethodContext _bcornu_methode_context1305 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 260, 8525, 8653);
                CallChecker.varInit(coll, "coll", 260, 8525, 8653);
                CallChecker.varInit(this.parent, "parent", 260, 8525, 8653);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1305.methodEnd();
            }
        }

        @Override
        public boolean retainAll(Collection<?> coll) {
            MethodContext _bcornu_methode_context1306 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 265, 8664, 8792);
                CallChecker.varInit(coll, "coll", 265, 8664, 8792);
                CallChecker.varInit(this.parent, "parent", 265, 8664, 8792);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1306.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context1307 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 270, 8803, 8906);
                CallChecker.varInit(this.parent, "parent", 270, 8803, 8906);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1307.methodEnd();
            }
        }

        @Override
        public Object[] toArray() {
            MethodContext _bcornu_methode_context1308 = new MethodContext(Object[].class);
            try {
                CallChecker.varInit(this, "this", 275, 8917, 9017);
                CallChecker.varInit(this.parent, "parent", 275, 8917, 9017);
                if (CallChecker.beforeDeref(parent, LinkedMap.class, 276, 8982, 8987)) {
                    final Set<K> npe_invocation_var272 = CallChecker.isCalled(parent, LinkedMap.class, 276, 8982, 8987).keySet();
                    if (CallChecker.beforeDeref(npe_invocation_var272, Set.class, 276, 8982, 8996)) {
                        return CallChecker.isCalled(npe_invocation_var272, Set.class, 276, 8982, 8996).toArray();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1308.methodEnd();
            }
        }

        @Override
        public <T> T[] toArray(T[] array) {
            MethodContext _bcornu_methode_context1309 = new MethodContext(null);
            try {
                CallChecker.varInit(this, "this", 280, 9028, 9141);
                CallChecker.varInit(array, "array", 280, 9028, 9141);
                CallChecker.varInit(this.parent, "parent", 280, 9028, 9141);
                if (CallChecker.beforeDeref(parent, LinkedMap.class, 281, 9101, 9106)) {
                    final Set<K> npe_invocation_var273 = CallChecker.isCalled(parent, LinkedMap.class, 281, 9101, 9106).keySet();
                    if (CallChecker.beforeDeref(npe_invocation_var273, Set.class, 281, 9101, 9115)) {
                        return CallChecker.isCalled(npe_invocation_var273, Set.class, 281, 9101, 9115).toArray(array);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((T[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1309.methodEnd();
            }
        }

        @Override
        public Iterator<K> iterator() {
            MethodContext _bcornu_methode_context1310 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 285, 9152, 9288);
                CallChecker.varInit(this.parent, "parent", 285, 9152, 9288);
                if (CallChecker.beforeDeref(parent, LinkedMap.class, 286, 9251, 9256)) {
                    final Set<K> npe_invocation_var274 = CallChecker.isCalled(parent, LinkedMap.class, 286, 9251, 9256).keySet();
                    if (CallChecker.beforeDeref(npe_invocation_var274, Set.class, 286, 9251, 9265)) {
                        return UnmodifiableIterator.decorate(CallChecker.isCalled(npe_invocation_var274, Set.class, 286, 9251, 9265).iterator());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1310.methodEnd();
            }
        }

        @Override
        public ListIterator<K> listIterator() {
            MethodContext _bcornu_methode_context1311 = new MethodContext(ListIterator.class);
            try {
                CallChecker.varInit(this, "this", 290, 9299, 9441);
                CallChecker.varInit(this.parent, "parent", 290, 9299, 9441);
                return UnmodifiableListIterator.decorate(super.listIterator());
            } catch (ForceReturn _bcornu_return_t) {
                return ((ListIterator<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1311.methodEnd();
            }
        }

        @Override
        public ListIterator<K> listIterator(int fromIndex) {
            MethodContext _bcornu_methode_context1312 = new MethodContext(ListIterator.class);
            try {
                CallChecker.varInit(this, "this", 295, 9452, 9616);
                CallChecker.varInit(fromIndex, "fromIndex", 295, 9452, 9616);
                CallChecker.varInit(this.parent, "parent", 295, 9452, 9616);
                return UnmodifiableListIterator.decorate(super.listIterator(fromIndex));
            } catch (ForceReturn _bcornu_return_t) {
                return ((ListIterator<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1312.methodEnd();
            }
        }

        @Override
        public List<K> subList(int fromIndexInclusive, int toIndexExclusive) {
            MethodContext _bcornu_methode_context1313 = new MethodContext(List.class);
            try {
                CallChecker.varInit(this, "this", 300, 9627, 9823);
                CallChecker.varInit(toIndexExclusive, "toIndexExclusive", 300, 9627, 9823);
                CallChecker.varInit(fromIndexInclusive, "fromIndexInclusive", 300, 9627, 9823);
                CallChecker.varInit(this.parent, "parent", 300, 9627, 9823);
                return UnmodifiableList.decorate(super.subList(fromIndexInclusive, toIndexExclusive));
            } catch (ForceReturn _bcornu_return_t) {
                return ((List<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1313.methodEnd();
            }
        }
    }
}

