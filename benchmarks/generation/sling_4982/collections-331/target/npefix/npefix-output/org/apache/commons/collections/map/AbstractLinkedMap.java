package org.apache.commons.collections.map;

import org.apache.commons.collections.ResettableIterator;
import org.apache.commons.collections.OrderedMapIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedIterator;
import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ConcurrentModificationException;
import org.apache.commons.collections.iterators.EmptyOrderedIterator;
import org.apache.commons.collections.iterators.EmptyOrderedMapIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.Map;

public abstract class AbstractLinkedMap<K, V> extends AbstractHashedMap<K, V> implements OrderedMap<K, V> {
    protected transient AbstractLinkedMap.LinkEntry<K, V> header;

    protected AbstractLinkedMap() {
        super();
        MethodContext _bcornu_methode_context78 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context78.methodEnd();
        }
    }

    protected AbstractLinkedMap(int initialCapacity, float loadFactor, int threshold) {
        super(initialCapacity, loadFactor, threshold);
        MethodContext _bcornu_methode_context79 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context79.methodEnd();
        }
    }

    protected AbstractLinkedMap(int initialCapacity) {
        super(initialCapacity);
        MethodContext _bcornu_methode_context80 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context80.methodEnd();
        }
    }

    protected AbstractLinkedMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        MethodContext _bcornu_methode_context81 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context81.methodEnd();
        }
    }

    protected AbstractLinkedMap(Map<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context82 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context82.methodEnd();
        }
    }

    @Override
    protected void init() {
        MethodContext _bcornu_methode_context478 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 129, 4848, 5212);
            CallChecker.varInit(this.values, "values", 129, 4848, 5212);
            CallChecker.varInit(this.keySet, "keySet", 129, 4848, 5212);
            CallChecker.varInit(this.entrySet, "entrySet", 129, 4848, 5212);
            CallChecker.varInit(this.modCount, "modCount", 129, 4848, 5212);
            CallChecker.varInit(this.threshold, "threshold", 129, 4848, 5212);
            CallChecker.varInit(this.data, "data", 129, 4848, 5212);
            CallChecker.varInit(this.size, "size", 129, 4848, 5212);
            CallChecker.varInit(this.loadFactor, "loadFactor", 129, 4848, 5212);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 129, 4848, 5212);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 129, 4848, 5212);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 129, 4848, 5212);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 129, 4848, 5212);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 129, 4848, 5212);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 129, 4848, 5212);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 129, 4848, 5212);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 129, 4848, 5212);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 129, 4848, 5212);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 129, 4848, 5212);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 129, 4848, 5212);
            CallChecker.varInit(this.header, "header", 129, 4848, 5212);
            header = createEntry(null, (-1), null, null);
            CallChecker.varAssign(this.header, "this.header", 130, 5117, 5159);
            if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 131, 5169, 5174)) {
                if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 131, 5185, 5190)) {
                    header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 131, 5169, 5174);
                    header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 131, 5185, 5190);
                    CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 131, 5169, 5174).before = CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 131, 5185, 5190).after = header;
                    CallChecker.varAssign(CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 131, 5169, 5174).before, "CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 131, 5169, 5174).before", 131, 5169, 5206);
                    CallChecker.varAssign(CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 131, 5185, 5190).after, "CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 131, 5185, 5190).after", 131, 5185, 5205);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context478.methodEnd();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        MethodContext _bcornu_methode_context479 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 142, 5219, 6087);
            CallChecker.varInit(value, "value", 142, 5219, 6087);
            CallChecker.varInit(this.values, "values", 142, 5219, 6087);
            CallChecker.varInit(this.keySet, "keySet", 142, 5219, 6087);
            CallChecker.varInit(this.entrySet, "entrySet", 142, 5219, 6087);
            CallChecker.varInit(this.modCount, "modCount", 142, 5219, 6087);
            CallChecker.varInit(this.threshold, "threshold", 142, 5219, 6087);
            CallChecker.varInit(this.data, "data", 142, 5219, 6087);
            CallChecker.varInit(this.size, "size", 142, 5219, 6087);
            CallChecker.varInit(this.loadFactor, "loadFactor", 142, 5219, 6087);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 142, 5219, 6087);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 142, 5219, 6087);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 142, 5219, 6087);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 142, 5219, 6087);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 142, 5219, 6087);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 142, 5219, 6087);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 142, 5219, 6087);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 142, 5219, 6087);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 142, 5219, 6087);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 142, 5219, 6087);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 142, 5219, 6087);
            CallChecker.varInit(this.header, "header", 142, 5219, 6087);
            if (value == null) {
                header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 145, 5646, 5651);
                for (AbstractLinkedMap.LinkEntry<K, V> entry = CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 145, 5646, 5651).after; entry != (header); entry = CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 145, 5685, 5689).after) {
                    CallChecker.varAssign(entry, "entry", 145, 5677, 5695);
                    if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 146, 5720, 5724)) {
                        if ((entry.getValue()) == null) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else {
                header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 151, 5871, 5876);
                for (AbstractLinkedMap.LinkEntry<K, V> entry = CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 151, 5871, 5876).after; entry != (header); entry = CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 151, 5910, 5914).after) {
                    CallChecker.varAssign(entry, "entry", 151, 5902, 5920);
                    if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 152, 5965, 5969)) {
                        if (isEqualValue(value, entry.getValue())) {
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
            _bcornu_methode_context479.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context480 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 165, 6094, 6384);
            CallChecker.varInit(this.values, "values", 165, 6094, 6384);
            CallChecker.varInit(this.keySet, "keySet", 165, 6094, 6384);
            CallChecker.varInit(this.entrySet, "entrySet", 165, 6094, 6384);
            CallChecker.varInit(this.modCount, "modCount", 165, 6094, 6384);
            CallChecker.varInit(this.threshold, "threshold", 165, 6094, 6384);
            CallChecker.varInit(this.data, "data", 165, 6094, 6384);
            CallChecker.varInit(this.size, "size", 165, 6094, 6384);
            CallChecker.varInit(this.loadFactor, "loadFactor", 165, 6094, 6384);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 165, 6094, 6384);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 165, 6094, 6384);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 165, 6094, 6384);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 165, 6094, 6384);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 165, 6094, 6384);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 165, 6094, 6384);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 165, 6094, 6384);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 165, 6094, 6384);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 165, 6094, 6384);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 165, 6094, 6384);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 165, 6094, 6384);
            CallChecker.varInit(this.header, "header", 165, 6094, 6384);
            super.clear();
            if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 168, 6341, 6346)) {
                if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 168, 6357, 6362)) {
                    header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 168, 6341, 6346);
                    header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 168, 6357, 6362);
                    CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 168, 6341, 6346).before = CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 168, 6357, 6362).after = header;
                    CallChecker.varAssign(CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 168, 6341, 6346).before, "CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 168, 6341, 6346).before", 168, 6341, 6378);
                    CallChecker.varAssign(CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 168, 6357, 6362).after, "CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 168, 6357, 6362).after", 168, 6357, 6377);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context480.methodEnd();
        }
    }

    public K firstKey() {
        if ((size) == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 181, 6724, 6729)) {
            header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 181, 6724, 6729);
            if (CallChecker.beforeDeref(CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 181, 6724, 6729).after, AbstractLinkedMap.LinkEntry.class, 181, 6724, 6735)) {
                header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 181, 6724, 6729);
                return CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 181, 6724, 6729).after.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }else
            throw new AbnormalExecutionError();
        
    }

    public K lastKey() {
        if ((size) == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 193, 7035, 7040)) {
            header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 193, 7035, 7040);
            if (CallChecker.beforeDeref(CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 193, 7035, 7040).before, AbstractLinkedMap.LinkEntry.class, 193, 7035, 7047)) {
                header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 193, 7035, 7040);
                return CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 193, 7035, 7040).before.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }else
            throw new AbnormalExecutionError();
        
    }

    public K nextKey(Object key) {
        AbstractLinkedMap.LinkEntry<K, V> entry = CallChecker.varInit(getEntry(key), "entry", 203, 7239, 7276);
        if ((entry == null) || ((entry.after) == (header))) {
            return null;
        }else {
            entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 204, 7342, 7346);
            if (CallChecker.beforeDeref(CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 204, 7342, 7346).after, AbstractLinkedMap.LinkEntry.class, 204, 7342, 7352)) {
                return entry.after.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    @Override
    protected AbstractLinkedMap.LinkEntry<K, V> getEntry(Object key) {
        MethodContext _bcornu_methode_context484 = new MethodContext(AbstractLinkedMap.LinkEntry.class);
        try {
            CallChecker.varInit(this, "this", 208, 7376, 7497);
            CallChecker.varInit(key, "key", 208, 7376, 7497);
            CallChecker.varInit(this.values, "values", 208, 7376, 7497);
            CallChecker.varInit(this.keySet, "keySet", 208, 7376, 7497);
            CallChecker.varInit(this.entrySet, "entrySet", 208, 7376, 7497);
            CallChecker.varInit(this.modCount, "modCount", 208, 7376, 7497);
            CallChecker.varInit(this.threshold, "threshold", 208, 7376, 7497);
            CallChecker.varInit(this.data, "data", 208, 7376, 7497);
            CallChecker.varInit(this.size, "size", 208, 7376, 7497);
            CallChecker.varInit(this.loadFactor, "loadFactor", 208, 7376, 7497);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 208, 7376, 7497);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 208, 7376, 7497);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 208, 7376, 7497);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 208, 7376, 7497);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 208, 7376, 7497);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 208, 7376, 7497);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 208, 7376, 7497);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 208, 7376, 7497);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 208, 7376, 7497);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 208, 7376, 7497);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 208, 7376, 7497);
            CallChecker.varInit(this.header, "header", 208, 7376, 7497);
            return ((AbstractLinkedMap.LinkEntry<K, V>) (super.getEntry(key)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractLinkedMap.LinkEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context484.methodEnd();
        }
    }

    public K previousKey(Object key) {
        AbstractLinkedMap.LinkEntry<K, V> entry = CallChecker.varInit(getEntry(key), "entry", 219, 7686, 7723);
        if ((entry == null) || ((entry.before) == (header))) {
            return null;
        }else {
            entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 220, 7790, 7794);
            if (CallChecker.beforeDeref(CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 220, 7790, 7794).before, AbstractLinkedMap.LinkEntry.class, 220, 7790, 7801)) {
                return entry.before.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    protected AbstractLinkedMap.LinkEntry<K, V> getEntry(int index) {
        MethodContext _bcornu_methode_context486 = new MethodContext(AbstractLinkedMap.LinkEntry.class);
        try {
            CallChecker.varInit(this, "this", 231, 7825, 8948);
            CallChecker.varInit(index, "index", 231, 7825, 8948);
            CallChecker.varInit(this.values, "values", 231, 7825, 8948);
            CallChecker.varInit(this.keySet, "keySet", 231, 7825, 8948);
            CallChecker.varInit(this.entrySet, "entrySet", 231, 7825, 8948);
            CallChecker.varInit(this.modCount, "modCount", 231, 7825, 8948);
            CallChecker.varInit(this.threshold, "threshold", 231, 7825, 8948);
            CallChecker.varInit(this.data, "data", 231, 7825, 8948);
            CallChecker.varInit(this.size, "size", 231, 7825, 8948);
            CallChecker.varInit(this.loadFactor, "loadFactor", 231, 7825, 8948);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 231, 7825, 8948);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 231, 7825, 8948);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 231, 7825, 8948);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 231, 7825, 8948);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 231, 7825, 8948);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 231, 7825, 8948);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 231, 7825, 8948);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 231, 7825, 8948);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 231, 7825, 8948);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 231, 7825, 8948);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 231, 7825, 8948);
            CallChecker.varInit(this.header, "header", 231, 7825, 8948);
            if (index < 0) {
                throw new IndexOutOfBoundsException((("Index " + index) + " is less than zero"));
            }
            if (index >= (size)) {
                throw new IndexOutOfBoundsException(((("Index " + index) + " is invalid for size ") + (size)));
            }
            AbstractLinkedMap.LinkEntry<K, V> entry = CallChecker.init(AbstractLinkedMap.LinkEntry.class);
            if (index < ((size) / 2)) {
                if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 241, 8557, 8562)) {
                    header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 241, 8557, 8562);
                    entry = CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 241, 8557, 8562).after;
                    CallChecker.varAssign(entry, "entry", 241, 8549, 8569);
                }
                for (int currentIndex = 0; currentIndex < index; currentIndex++) {
                    if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 243, 8674, 8678)) {
                        entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 243, 8674, 8678);
                        entry = CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 243, 8674, 8678).after;
                        CallChecker.varAssign(entry, "entry", 243, 8666, 8685);
                    }
                }
            }else {
                entry = header;
                CallChecker.varAssign(entry, "entry", 247, 8762, 8776);
                for (int currentIndex = size; currentIndex > index; currentIndex--) {
                    if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 249, 8884, 8888)) {
                        entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 249, 8884, 8888);
                        entry = CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 249, 8884, 8888).before;
                        CallChecker.varAssign(entry, "entry", 249, 8876, 8896);
                    }
                }
            }
            return entry;
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractLinkedMap.LinkEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context486.methodEnd();
        }
    }

    @Override
    protected void addEntry(AbstractHashedMap.HashEntry<K, V> entry, int hashIndex) {
        MethodContext _bcornu_methode_context487 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 265, 8959, 9576);
            CallChecker.varInit(hashIndex, "hashIndex", 265, 8959, 9576);
            CallChecker.varInit(entry, "entry", 265, 8959, 9576);
            CallChecker.varInit(this.values, "values", 265, 8959, 9576);
            CallChecker.varInit(this.keySet, "keySet", 265, 8959, 9576);
            CallChecker.varInit(this.entrySet, "entrySet", 265, 8959, 9576);
            CallChecker.varInit(this.modCount, "modCount", 265, 8959, 9576);
            CallChecker.varInit(this.threshold, "threshold", 265, 8959, 9576);
            CallChecker.varInit(this.data, "data", 265, 8959, 9576);
            CallChecker.varInit(this.size, "size", 265, 8959, 9576);
            CallChecker.varInit(this.loadFactor, "loadFactor", 265, 8959, 9576);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 265, 8959, 9576);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 265, 8959, 9576);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 265, 8959, 9576);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 265, 8959, 9576);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 265, 8959, 9576);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 265, 8959, 9576);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 265, 8959, 9576);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 265, 8959, 9576);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 265, 8959, 9576);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 265, 8959, 9576);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 265, 8959, 9576);
            CallChecker.varInit(this.header, "header", 265, 8959, 9576);
            AbstractLinkedMap.LinkEntry<K, V> link = CallChecker.varInit(((AbstractLinkedMap.LinkEntry<K, V>) (entry)), "link", 266, 9359, 9405);
            if (CallChecker.beforeDeref(link, AbstractLinkedMap.LinkEntry.class, 267, 9415, 9418)) {
                link = CallChecker.beforeCalled(link, AbstractLinkedMap.LinkEntry.class, 267, 9415, 9418);
                CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 267, 9415, 9418).after = header;
                CallChecker.varAssign(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 267, 9415, 9418).after, "CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 267, 9415, 9418).after", 267, 9415, 9435);
            }
            if (CallChecker.beforeDeref(link, AbstractLinkedMap.LinkEntry.class, 268, 9445, 9448)) {
                if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 268, 9459, 9464)) {
                    link = CallChecker.beforeCalled(link, AbstractLinkedMap.LinkEntry.class, 268, 9445, 9448);
                    header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 268, 9459, 9464);
                    CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 268, 9445, 9448).before = CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 268, 9459, 9464).before;
                    CallChecker.varAssign(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 268, 9445, 9448).before, "CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 268, 9445, 9448).before", 268, 9445, 9472);
                }
            }
            if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 269, 9482, 9487)) {
                header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 269, 9482, 9487);
                if (CallChecker.beforeDeref(CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 269, 9482, 9487).before, AbstractLinkedMap.LinkEntry.class, 269, 9482, 9494)) {
                    header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 269, 9482, 9487);
                    CallChecker.isCalled(CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 269, 9482, 9487).before, AbstractLinkedMap.LinkEntry.class, 269, 9482, 9494).after = link;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 269, 9482, 9487).before, AbstractLinkedMap.LinkEntry.class, 269, 9482, 9494).after, "CallChecker.isCalled(CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 269, 9482, 9487).before, AbstractLinkedMap.LinkEntry.class, 269, 9482, 9494).after", 269, 9482, 9508);
                }
            }
            if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 270, 9518, 9523)) {
                header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 270, 9518, 9523);
                CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 270, 9518, 9523).before = link;
                CallChecker.varAssign(CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 270, 9518, 9523).before, "CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 270, 9518, 9523).before", 270, 9518, 9538);
            }
            if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 271, 9548, 9551)) {
                data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 271, 9548, 9551);
                CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 271, 9548, 9551)[hashIndex] = link;
                CallChecker.varAssign(CallChecker.isCalled(this.data, AbstractHashedMap.HashEntry[].class, 271, 9548, 9551)[hashIndex], "CallChecker.isCalled(this.data, AbstractHashedMap.HashEntry[].class, 271, 9548, 9551)[hashIndex]", 271, 9548, 9570);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context487.methodEnd();
        }
    }

    @Override
    protected AbstractLinkedMap.LinkEntry<K, V> createEntry(AbstractHashedMap.HashEntry<K, V> next, int hashCode, K key, V value) {
        MethodContext _bcornu_methode_context488 = new MethodContext(AbstractLinkedMap.LinkEntry.class);
        try {
            CallChecker.varInit(this, "this", 286, 9583, 10115);
            CallChecker.varInit(value, "value", 286, 9583, 10115);
            CallChecker.varInit(key, "key", 286, 9583, 10115);
            CallChecker.varInit(hashCode, "hashCode", 286, 9583, 10115);
            CallChecker.varInit(next, "next", 286, 9583, 10115);
            CallChecker.varInit(this.values, "values", 286, 9583, 10115);
            CallChecker.varInit(this.keySet, "keySet", 286, 9583, 10115);
            CallChecker.varInit(this.entrySet, "entrySet", 286, 9583, 10115);
            CallChecker.varInit(this.modCount, "modCount", 286, 9583, 10115);
            CallChecker.varInit(this.threshold, "threshold", 286, 9583, 10115);
            CallChecker.varInit(this.data, "data", 286, 9583, 10115);
            CallChecker.varInit(this.size, "size", 286, 9583, 10115);
            CallChecker.varInit(this.loadFactor, "loadFactor", 286, 9583, 10115);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 286, 9583, 10115);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 286, 9583, 10115);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 286, 9583, 10115);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 286, 9583, 10115);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 286, 9583, 10115);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 286, 9583, 10115);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 286, 9583, 10115);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 286, 9583, 10115);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 286, 9583, 10115);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 286, 9583, 10115);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 286, 9583, 10115);
            CallChecker.varInit(this.header, "header", 286, 9583, 10115);
            return new AbstractLinkedMap.LinkEntry<K, V>(next, hashCode, convertKey(key), value);
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractLinkedMap.LinkEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context488.methodEnd();
        }
    }

    @Override
    protected void removeEntry(AbstractHashedMap.HashEntry<K, V> entry, int hashIndex, AbstractHashedMap.HashEntry<K, V> previous) {
        MethodContext _bcornu_methode_context489 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 301, 10122, 10851);
            CallChecker.varInit(previous, "previous", 301, 10122, 10851);
            CallChecker.varInit(hashIndex, "hashIndex", 301, 10122, 10851);
            CallChecker.varInit(entry, "entry", 301, 10122, 10851);
            CallChecker.varInit(this.values, "values", 301, 10122, 10851);
            CallChecker.varInit(this.keySet, "keySet", 301, 10122, 10851);
            CallChecker.varInit(this.entrySet, "entrySet", 301, 10122, 10851);
            CallChecker.varInit(this.modCount, "modCount", 301, 10122, 10851);
            CallChecker.varInit(this.threshold, "threshold", 301, 10122, 10851);
            CallChecker.varInit(this.data, "data", 301, 10122, 10851);
            CallChecker.varInit(this.size, "size", 301, 10122, 10851);
            CallChecker.varInit(this.loadFactor, "loadFactor", 301, 10122, 10851);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 301, 10122, 10851);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 301, 10122, 10851);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 301, 10122, 10851);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 301, 10122, 10851);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 301, 10122, 10851);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 301, 10122, 10851);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 301, 10122, 10851);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 301, 10122, 10851);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 301, 10122, 10851);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 301, 10122, 10851);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 301, 10122, 10851);
            CallChecker.varInit(this.header, "header", 301, 10122, 10851);
            AbstractLinkedMap.LinkEntry<K, V> link = CallChecker.varInit(((AbstractLinkedMap.LinkEntry<K, V>) (entry)), "link", 302, 10608, 10654);
            if (CallChecker.beforeDeref(link, AbstractLinkedMap.LinkEntry.class, 303, 10664, 10667)) {
                link = CallChecker.beforeCalled(link, AbstractLinkedMap.LinkEntry.class, 303, 10664, 10667);
                if (CallChecker.beforeDeref(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 303, 10664, 10667).before, AbstractLinkedMap.LinkEntry.class, 303, 10664, 10674)) {
                    if (CallChecker.beforeDeref(link, AbstractLinkedMap.LinkEntry.class, 303, 10684, 10687)) {
                        link = CallChecker.beforeCalled(link, AbstractLinkedMap.LinkEntry.class, 303, 10664, 10667);
                        link = CallChecker.beforeCalled(link, AbstractLinkedMap.LinkEntry.class, 303, 10684, 10687);
                        CallChecker.isCalled(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 303, 10664, 10667).before, AbstractLinkedMap.LinkEntry.class, 303, 10664, 10674).after = CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 303, 10684, 10687).after;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 303, 10664, 10667).before, AbstractLinkedMap.LinkEntry.class, 303, 10664, 10674).after, "CallChecker.isCalled(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 303, 10664, 10667).before, AbstractLinkedMap.LinkEntry.class, 303, 10664, 10674).after", 303, 10664, 10694);
                    }
                }
            }
            if (CallChecker.beforeDeref(link, AbstractLinkedMap.LinkEntry.class, 304, 10704, 10707)) {
                link = CallChecker.beforeCalled(link, AbstractLinkedMap.LinkEntry.class, 304, 10704, 10707);
                if (CallChecker.beforeDeref(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 304, 10704, 10707).after, AbstractLinkedMap.LinkEntry.class, 304, 10704, 10713)) {
                    if (CallChecker.beforeDeref(link, AbstractLinkedMap.LinkEntry.class, 304, 10724, 10727)) {
                        link = CallChecker.beforeCalled(link, AbstractLinkedMap.LinkEntry.class, 304, 10704, 10707);
                        link = CallChecker.beforeCalled(link, AbstractLinkedMap.LinkEntry.class, 304, 10724, 10727);
                        CallChecker.isCalled(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 304, 10704, 10707).after, AbstractLinkedMap.LinkEntry.class, 304, 10704, 10713).before = CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 304, 10724, 10727).before;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 304, 10704, 10707).after, AbstractLinkedMap.LinkEntry.class, 304, 10704, 10713).before, "CallChecker.isCalled(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 304, 10704, 10707).after, AbstractLinkedMap.LinkEntry.class, 304, 10704, 10713).before", 304, 10704, 10735);
                    }
                }
            }
            if (CallChecker.beforeDeref(link, AbstractLinkedMap.LinkEntry.class, 305, 10745, 10748)) {
                link = CallChecker.beforeCalled(link, AbstractLinkedMap.LinkEntry.class, 305, 10745, 10748);
                CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 305, 10745, 10748).after = null;
                CallChecker.varAssign(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 305, 10745, 10748).after, "CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 305, 10745, 10748).after", 305, 10745, 10762);
            }
            if (CallChecker.beforeDeref(link, AbstractLinkedMap.LinkEntry.class, 306, 10772, 10775)) {
                link = CallChecker.beforeCalled(link, AbstractLinkedMap.LinkEntry.class, 306, 10772, 10775);
                CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 306, 10772, 10775).before = null;
                CallChecker.varAssign(CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 306, 10772, 10775).before, "CallChecker.isCalled(link, AbstractLinkedMap.LinkEntry.class, 306, 10772, 10775).before", 306, 10772, 10790);
            }
            super.removeEntry(entry, hashIndex, previous);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context489.methodEnd();
        }
    }

    protected AbstractLinkedMap.LinkEntry<K, V> entryBefore(AbstractLinkedMap.LinkEntry<K, V> entry) {
        MethodContext _bcornu_methode_context490 = new MethodContext(AbstractLinkedMap.LinkEntry.class);
        try {
            CallChecker.varInit(this, "this", 320, 10858, 11404);
            CallChecker.varInit(entry, "entry", 320, 10858, 11404);
            CallChecker.varInit(this.values, "values", 320, 10858, 11404);
            CallChecker.varInit(this.keySet, "keySet", 320, 10858, 11404);
            CallChecker.varInit(this.entrySet, "entrySet", 320, 10858, 11404);
            CallChecker.varInit(this.modCount, "modCount", 320, 10858, 11404);
            CallChecker.varInit(this.threshold, "threshold", 320, 10858, 11404);
            CallChecker.varInit(this.data, "data", 320, 10858, 11404);
            CallChecker.varInit(this.size, "size", 320, 10858, 11404);
            CallChecker.varInit(this.loadFactor, "loadFactor", 320, 10858, 11404);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 320, 10858, 11404);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 320, 10858, 11404);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 320, 10858, 11404);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 320, 10858, 11404);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 320, 10858, 11404);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 320, 10858, 11404);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 320, 10858, 11404);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 320, 10858, 11404);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 320, 10858, 11404);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 320, 10858, 11404);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 320, 10858, 11404);
            CallChecker.varInit(this.header, "header", 320, 10858, 11404);
            if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 321, 11386, 11390)) {
                entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 321, 11386, 11390);
                return CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 321, 11386, 11390).before;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractLinkedMap.LinkEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context490.methodEnd();
        }
    }

    protected AbstractLinkedMap.LinkEntry<K, V> entryAfter(AbstractLinkedMap.LinkEntry<K, V> entry) {
        MethodContext _bcornu_methode_context491 = new MethodContext(AbstractLinkedMap.LinkEntry.class);
        try {
            CallChecker.varInit(this, "this", 333, 11411, 11875);
            CallChecker.varInit(entry, "entry", 333, 11411, 11875);
            CallChecker.varInit(this.values, "values", 333, 11411, 11875);
            CallChecker.varInit(this.keySet, "keySet", 333, 11411, 11875);
            CallChecker.varInit(this.entrySet, "entrySet", 333, 11411, 11875);
            CallChecker.varInit(this.modCount, "modCount", 333, 11411, 11875);
            CallChecker.varInit(this.threshold, "threshold", 333, 11411, 11875);
            CallChecker.varInit(this.data, "data", 333, 11411, 11875);
            CallChecker.varInit(this.size, "size", 333, 11411, 11875);
            CallChecker.varInit(this.loadFactor, "loadFactor", 333, 11411, 11875);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 333, 11411, 11875);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 333, 11411, 11875);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 333, 11411, 11875);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 333, 11411, 11875);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 333, 11411, 11875);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 333, 11411, 11875);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 333, 11411, 11875);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 333, 11411, 11875);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 333, 11411, 11875);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 333, 11411, 11875);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 333, 11411, 11875);
            CallChecker.varInit(this.header, "header", 333, 11411, 11875);
            if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 334, 11858, 11862)) {
                entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 334, 11858, 11862);
                return CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 334, 11858, 11862).after;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractLinkedMap.LinkEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context491.methodEnd();
        }
    }

    @Override
    public OrderedMapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context492 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 342, 11882, 12210);
            CallChecker.varInit(this.values, "values", 342, 11882, 12210);
            CallChecker.varInit(this.keySet, "keySet", 342, 11882, 12210);
            CallChecker.varInit(this.entrySet, "entrySet", 342, 11882, 12210);
            CallChecker.varInit(this.modCount, "modCount", 342, 11882, 12210);
            CallChecker.varInit(this.threshold, "threshold", 342, 11882, 12210);
            CallChecker.varInit(this.data, "data", 342, 11882, 12210);
            CallChecker.varInit(this.size, "size", 342, 11882, 12210);
            CallChecker.varInit(this.loadFactor, "loadFactor", 342, 11882, 12210);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 342, 11882, 12210);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 342, 11882, 12210);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 342, 11882, 12210);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 342, 11882, 12210);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 342, 11882, 12210);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 342, 11882, 12210);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 342, 11882, 12210);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 342, 11882, 12210);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 342, 11882, 12210);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 342, 11882, 12210);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 342, 11882, 12210);
            CallChecker.varInit(this.header, "header", 342, 11882, 12210);
            if ((size) == 0) {
                return EmptyOrderedMapIterator.<K, V>getInstance();
            }
            return new AbstractLinkedMap.LinkMapIterator<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context492.methodEnd();
        }
    }

    protected static class LinkMapIterator<K, V> extends AbstractLinkedMap.LinkIterator<K, V> implements OrderedMapIterator<K, V> , ResettableIterator<K> {
        protected LinkMapIterator(AbstractLinkedMap<K, V> parent) {
            super(parent);
            MethodContext _bcornu_methode_context83 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context83.methodEnd();
            }
        }

        public K next() {
            final AbstractLinkedMap.LinkEntry<K, V> npe_invocation_var128 = super.nextEntry();
            if (CallChecker.beforeDeref(npe_invocation_var128, AbstractLinkedMap.LinkEntry.class, 360, 12565, 12581)) {
                return npe_invocation_var128.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public K previous() {
            final AbstractLinkedMap.LinkEntry<K, V> npe_invocation_var129 = super.previousEntry();
            if (CallChecker.beforeDeref(npe_invocation_var129, AbstractLinkedMap.LinkEntry.class, 364, 12653, 12673)) {
                return npe_invocation_var129.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public K getKey() {
            AbstractLinkedMap.LinkEntry<K, V> current = CallChecker.varInit(currentEntry(), "current", 368, 12736, 12776);
            if (current == null) {
                throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
            }
            return current.getKey();
        }

        public V getValue() {
            AbstractLinkedMap.LinkEntry<K, V> current = CallChecker.varInit(currentEntry(), "current", 376, 13000, 13040);
            if (current == null) {
                throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
            }
            return current.getValue();
        }

        public V setValue(V value) {
            AbstractLinkedMap.LinkEntry<K, V> current = CallChecker.varInit(currentEntry(), "current", 384, 13275, 13315);
            if (current == null) {
                throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
            }
            return current.setValue(value);
        }
    }

    @Override
    protected Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        MethodContext _bcornu_methode_context498 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 400, 13516, 14019);
            CallChecker.varInit(this.values, "values", 400, 13516, 14019);
            CallChecker.varInit(this.keySet, "keySet", 400, 13516, 14019);
            CallChecker.varInit(this.entrySet, "entrySet", 400, 13516, 14019);
            CallChecker.varInit(this.modCount, "modCount", 400, 13516, 14019);
            CallChecker.varInit(this.threshold, "threshold", 400, 13516, 14019);
            CallChecker.varInit(this.data, "data", 400, 13516, 14019);
            CallChecker.varInit(this.size, "size", 400, 13516, 14019);
            CallChecker.varInit(this.loadFactor, "loadFactor", 400, 13516, 14019);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 400, 13516, 14019);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 400, 13516, 14019);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 400, 13516, 14019);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 400, 13516, 14019);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 400, 13516, 14019);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 400, 13516, 14019);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 400, 13516, 14019);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 400, 13516, 14019);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 400, 13516, 14019);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 400, 13516, 14019);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 400, 13516, 14019);
            CallChecker.varInit(this.header, "header", 400, 13516, 14019);
            if ((size()) == 0) {
                return EmptyOrderedIterator.<Map.Entry<K, V>>getInstance();
            }
            return new AbstractLinkedMap.EntrySetIterator<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context498.methodEnd();
        }
    }

    protected static class EntrySetIterator<K, V> extends AbstractLinkedMap.LinkIterator<K, V> implements OrderedIterator<Map.Entry<K, V>> , ResettableIterator<Map.Entry<K, V>> {
        protected EntrySetIterator(AbstractLinkedMap<K, V> parent) {
            super(parent);
            MethodContext _bcornu_methode_context84 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context84.methodEnd();
            }
        }

        public Map.Entry<K, V> next() {
            MethodContext _bcornu_methode_context499 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 417, 14352, 14430);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 417, 14352, 14430);
                CallChecker.varInit(this.next, "next", 417, 14352, 14430);
                CallChecker.varInit(this.last, "last", 417, 14352, 14430);
                CallChecker.varInit(this.parent, "parent", 417, 14352, 14430);
                return super.nextEntry();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context499.methodEnd();
            }
        }

        public Map.Entry<K, V> previous() {
            MethodContext _bcornu_methode_context500 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 421, 14441, 14527);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 421, 14441, 14527);
                CallChecker.varInit(this.next, "next", 421, 14441, 14527);
                CallChecker.varInit(this.last, "last", 421, 14441, 14527);
                CallChecker.varInit(this.parent, "parent", 421, 14441, 14527);
                return super.previousEntry();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context500.methodEnd();
            }
        }
    }

    @Override
    protected Iterator<K> createKeySetIterator() {
        MethodContext _bcornu_methode_context501 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 434, 14540, 15003);
            CallChecker.varInit(this.values, "values", 434, 14540, 15003);
            CallChecker.varInit(this.keySet, "keySet", 434, 14540, 15003);
            CallChecker.varInit(this.entrySet, "entrySet", 434, 14540, 15003);
            CallChecker.varInit(this.modCount, "modCount", 434, 14540, 15003);
            CallChecker.varInit(this.threshold, "threshold", 434, 14540, 15003);
            CallChecker.varInit(this.data, "data", 434, 14540, 15003);
            CallChecker.varInit(this.size, "size", 434, 14540, 15003);
            CallChecker.varInit(this.loadFactor, "loadFactor", 434, 14540, 15003);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 434, 14540, 15003);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 434, 14540, 15003);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 434, 14540, 15003);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 434, 14540, 15003);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 434, 14540, 15003);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 434, 14540, 15003);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 434, 14540, 15003);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 434, 14540, 15003);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 434, 14540, 15003);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 434, 14540, 15003);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 434, 14540, 15003);
            CallChecker.varInit(this.header, "header", 434, 14540, 15003);
            if ((size()) == 0) {
                return EmptyOrderedIterator.<K>getInstance();
            }
            return new AbstractLinkedMap.KeySetIterator<K>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context501.methodEnd();
        }
    }

    protected static class KeySetIterator<K> extends AbstractLinkedMap.LinkIterator<K, Object> implements OrderedIterator<K> , ResettableIterator<K> {
        @SuppressWarnings(value = "unchecked")
        protected KeySetIterator(AbstractLinkedMap<K, ?> parent) {
            super(((AbstractLinkedMap<K, Object>) (parent)));
            MethodContext _bcornu_methode_context85 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context85.methodEnd();
            }
        }

        public K next() {
            final AbstractLinkedMap.LinkEntry<K, Object> npe_invocation_var130 = super.nextEntry();
            if (CallChecker.beforeDeref(npe_invocation_var130, AbstractLinkedMap.LinkEntry.class, 453, 15419, 15435)) {
                return npe_invocation_var130.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public K previous() {
            final AbstractLinkedMap.LinkEntry<K, Object> npe_invocation_var131 = super.previousEntry();
            if (CallChecker.beforeDeref(npe_invocation_var131, AbstractLinkedMap.LinkEntry.class, 457, 15507, 15527)) {
                return npe_invocation_var131.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    @Override
    protected Iterator<V> createValuesIterator() {
        MethodContext _bcornu_methode_context504 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 469, 15560, 16022);
            CallChecker.varInit(this.values, "values", 469, 15560, 16022);
            CallChecker.varInit(this.keySet, "keySet", 469, 15560, 16022);
            CallChecker.varInit(this.entrySet, "entrySet", 469, 15560, 16022);
            CallChecker.varInit(this.modCount, "modCount", 469, 15560, 16022);
            CallChecker.varInit(this.threshold, "threshold", 469, 15560, 16022);
            CallChecker.varInit(this.data, "data", 469, 15560, 16022);
            CallChecker.varInit(this.size, "size", 469, 15560, 16022);
            CallChecker.varInit(this.loadFactor, "loadFactor", 469, 15560, 16022);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 469, 15560, 16022);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 469, 15560, 16022);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 469, 15560, 16022);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 469, 15560, 16022);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 469, 15560, 16022);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 469, 15560, 16022);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 469, 15560, 16022);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 469, 15560, 16022);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 469, 15560, 16022);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 469, 15560, 16022);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 469, 15560, 16022);
            CallChecker.varInit(this.header, "header", 469, 15560, 16022);
            if ((size()) == 0) {
                return EmptyOrderedIterator.<V>getInstance();
            }
            return new AbstractLinkedMap.ValuesIterator<V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context504.methodEnd();
        }
    }

    protected static class ValuesIterator<V> extends AbstractLinkedMap.LinkIterator<Object, V> implements OrderedIterator<V> , ResettableIterator<V> {
        @SuppressWarnings(value = "unchecked")
        protected ValuesIterator(AbstractLinkedMap<?, V> parent) {
            super(((AbstractLinkedMap<Object, V>) (parent)));
            MethodContext _bcornu_methode_context86 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context86.methodEnd();
            }
        }

        public V next() {
            final AbstractLinkedMap.LinkEntry<Object, V> npe_invocation_var132 = super.nextEntry();
            if (CallChecker.beforeDeref(npe_invocation_var132, AbstractLinkedMap.LinkEntry.class, 488, 16430, 16446)) {
                return npe_invocation_var132.getValue();
            }else
                throw new AbnormalExecutionError();
            
        }

        public V previous() {
            final AbstractLinkedMap.LinkEntry<Object, V> npe_invocation_var133 = super.previousEntry();
            if (CallChecker.beforeDeref(npe_invocation_var133, AbstractLinkedMap.LinkEntry.class, 492, 16520, 16540)) {
                return npe_invocation_var133.getValue();
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    protected static class LinkEntry<K, V> extends AbstractHashedMap.HashEntry<K, V> {
        protected AbstractLinkedMap.LinkEntry<K, V> before;

        protected AbstractLinkedMap.LinkEntry<K, V> after;

        protected LinkEntry(AbstractHashedMap.HashEntry<K, V> next, int hashCode, Object key, V value) {
            super(next, hashCode, key, value);
            MethodContext _bcornu_methode_context87 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context87.methodEnd();
            }
        }
    }

    protected abstract static class LinkIterator<K, V> {
        protected final AbstractLinkedMap<K, V> parent;

        protected AbstractLinkedMap.LinkEntry<K, V> last;

        protected AbstractLinkedMap.LinkEntry<K, V> next;

        protected int expectedModCount;

        protected LinkIterator(AbstractLinkedMap<K, V> parent) {
            super();
            MethodContext _bcornu_methode_context88 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 540, 18200, 18220);
                if (CallChecker.beforeDeref(parent, AbstractLinkedMap.class, 541, 18246, 18251)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedMap.class, 541, 18246, 18251);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractLinkedMap.class, 541, 18246, 18251).header, AbstractLinkedMap.LinkEntry.class, 541, 18246, 18258)) {
                        parent = CallChecker.beforeCalled(parent, AbstractLinkedMap.class, 541, 18246, 18251);
                        this.next = CallChecker.isCalled(CallChecker.isCalled(parent, AbstractLinkedMap.class, 541, 18246, 18251).header, AbstractLinkedMap.LinkEntry.class, 541, 18246, 18258).after;
                        CallChecker.varAssign(this.next, "this.next", 541, 18234, 18265);
                    }
                }
                if (CallChecker.beforeDeref(parent, AbstractLinkedMap.class, 542, 18303, 18308)) {
                    parent = CallChecker.beforeCalled(parent, AbstractLinkedMap.class, 542, 18303, 18308);
                    this.expectedModCount = CallChecker.isCalled(parent, AbstractLinkedMap.class, 542, 18303, 18308).modCount;
                    CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 542, 18279, 18318);
                }
            } finally {
                _bcornu_methode_context88.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context507 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 545, 18339, 18418);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 545, 18339, 18418);
                CallChecker.varInit(this.next, "next", 545, 18339, 18418);
                CallChecker.varInit(this.last, "last", 545, 18339, 18418);
                CallChecker.varInit(this.parent, "parent", 545, 18339, 18418);
                return (next) != (CallChecker.isCalled(parent, AbstractLinkedMap.class, 546, 18394, 18399).header);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context507.methodEnd();
            }
        }

        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context508 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 549, 18429, 18519);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 549, 18429, 18519);
                CallChecker.varInit(this.next, "next", 549, 18429, 18519);
                CallChecker.varInit(this.last, "last", 549, 18429, 18519);
                CallChecker.varInit(this.parent, "parent", 549, 18429, 18519);
                next = CallChecker.beforeCalled(next, AbstractLinkedMap.LinkEntry.class, 550, 18480, 18483);
                return (CallChecker.isCalled(next, AbstractLinkedMap.LinkEntry.class, 550, 18480, 18483).before) != (CallChecker.isCalled(parent, AbstractLinkedMap.class, 550, 18495, 18500).header);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context508.methodEnd();
            }
        }

        protected AbstractLinkedMap.LinkEntry<K, V> nextEntry() {
            MethodContext _bcornu_methode_context509 = new MethodContext(AbstractLinkedMap.LinkEntry.class);
            try {
                CallChecker.varInit(this, "this", 553, 18530, 18928);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 553, 18530, 18928);
                CallChecker.varInit(this.next, "next", 553, 18530, 18928);
                CallChecker.varInit(this.last, "last", 553, 18530, 18928);
                CallChecker.varInit(this.parent, "parent", 553, 18530, 18928);
                if (CallChecker.beforeDeref(parent, AbstractLinkedMap.class, 554, 18586, 18591)) {
                    if ((CallChecker.isCalled(parent, AbstractLinkedMap.class, 554, 18586, 18591).modCount) != (expectedModCount)) {
                        throw new ConcurrentModificationException();
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(parent, AbstractLinkedMap.class, 557, 18724, 18729)) {
                    if ((next) == (CallChecker.isCalled(parent, AbstractLinkedMap.class, 557, 18724, 18729).header)) {
                        throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
                    }
                }else
                    throw new AbnormalExecutionError();
                
                last = next;
                CallChecker.varAssign(this.last, "this.last", 560, 18851, 18862);
                if (CallChecker.beforeDeref(next, AbstractLinkedMap.LinkEntry.class, 561, 18883, 18886)) {
                    next = CallChecker.beforeCalled(next, AbstractLinkedMap.LinkEntry.class, 561, 18883, 18886);
                    next = CallChecker.isCalled(next, AbstractLinkedMap.LinkEntry.class, 561, 18883, 18886).after;
                    CallChecker.varAssign(this.next, "this.next", 561, 18876, 18893);
                }
                return last;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractLinkedMap.LinkEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context509.methodEnd();
            }
        }

        protected AbstractLinkedMap.LinkEntry<K, V> previousEntry() {
            MethodContext _bcornu_methode_context510 = new MethodContext(AbstractLinkedMap.LinkEntry.class);
            try {
                CallChecker.varInit(this, "this", 565, 18939, 19403);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 565, 18939, 19403);
                CallChecker.varInit(this.next, "next", 565, 18939, 19403);
                CallChecker.varInit(this.last, "last", 565, 18939, 19403);
                CallChecker.varInit(this.parent, "parent", 565, 18939, 19403);
                if (CallChecker.beforeDeref(parent, AbstractLinkedMap.class, 566, 18999, 19004)) {
                    if ((CallChecker.isCalled(parent, AbstractLinkedMap.class, 566, 18999, 19004).modCount) != (expectedModCount)) {
                        throw new ConcurrentModificationException();
                    }
                }else
                    throw new AbnormalExecutionError();
                
                AbstractLinkedMap.LinkEntry<K, V> previous = CallChecker.init(AbstractLinkedMap.LinkEntry.class);
                if (CallChecker.beforeDeref(next, AbstractLinkedMap.LinkEntry.class, 569, 19152, 19155)) {
                    next = CallChecker.beforeCalled(next, AbstractLinkedMap.LinkEntry.class, 569, 19152, 19155);
                    previous = CallChecker.isCalled(next, AbstractLinkedMap.LinkEntry.class, 569, 19152, 19155).before;
                    CallChecker.varAssign(previous, "previous", 569, 19152, 19155);
                }
                if (CallChecker.beforeDeref(parent, AbstractLinkedMap.class, 570, 19193, 19198)) {
                    if (previous == (CallChecker.isCalled(parent, AbstractLinkedMap.class, 570, 19193, 19198).header)) {
                        throw new NoSuchElementException(AbstractHashedMap.NO_PREVIOUS_ENTRY);
                    }
                }else
                    throw new AbnormalExecutionError();
                
                next = previous;
                CallChecker.varAssign(this.next, "this.next", 573, 19324, 19339);
                last = previous;
                CallChecker.varAssign(this.last, "this.last", 574, 19353, 19368);
                return last;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractLinkedMap.LinkEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context510.methodEnd();
            }
        }

        protected AbstractLinkedMap.LinkEntry<K, V> currentEntry() {
            MethodContext _bcornu_methode_context511 = new MethodContext(AbstractLinkedMap.LinkEntry.class);
            try {
                CallChecker.varInit(this, "this", 578, 19414, 19490);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 578, 19414, 19490);
                CallChecker.varInit(this.next, "next", 578, 19414, 19490);
                CallChecker.varInit(this.last, "last", 578, 19414, 19490);
                CallChecker.varInit(this.parent, "parent", 578, 19414, 19490);
                return last;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AbstractLinkedMap.LinkEntry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context511.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context512 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 582, 19501, 19906);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 582, 19501, 19906);
                CallChecker.varInit(this.next, "next", 582, 19501, 19906);
                CallChecker.varInit(this.last, "last", 582, 19501, 19906);
                CallChecker.varInit(this.parent, "parent", 582, 19501, 19906);
                if ((last) == null) {
                    throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
                }
                if (CallChecker.beforeDeref(parent, AbstractLinkedMap.class, 586, 19669, 19674)) {
                    if ((CallChecker.isCalled(parent, AbstractLinkedMap.class, 586, 19669, 19674).modCount) != (expectedModCount)) {
                        throw new ConcurrentModificationException();
                    }
                }
                if (CallChecker.beforeDeref(parent, AbstractLinkedMap.class, 589, 19795, 19800)) {
                    parent.remove(last.getKey());
                }
                last = null;
                CallChecker.varAssign(this.last, "this.last", 590, 19837, 19848);
                if (CallChecker.beforeDeref(parent, AbstractLinkedMap.class, 591, 19881, 19886)) {
                    expectedModCount = CallChecker.isCalled(parent, AbstractLinkedMap.class, 591, 19881, 19886).modCount;
                    CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 591, 19862, 19896);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context512.methodEnd();
            }
        }

        public void reset() {
            MethodContext _bcornu_methode_context513 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 594, 19917, 20012);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 594, 19917, 20012);
                CallChecker.varInit(this.next, "next", 594, 19917, 20012);
                CallChecker.varInit(this.last, "last", 594, 19917, 20012);
                CallChecker.varInit(this.parent, "parent", 594, 19917, 20012);
                last = null;
                CallChecker.varAssign(this.last, "this.last", 595, 19951, 19962);
                if (CallChecker.beforeDeref(parent, AbstractLinkedMap.class, 596, 19983, 19988)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractLinkedMap.class, 596, 19983, 19988).header, AbstractLinkedMap.LinkEntry.class, 596, 19983, 19995)) {
                        next = CallChecker.isCalled(CallChecker.isCalled(parent, AbstractLinkedMap.class, 596, 19983, 19988).header, AbstractLinkedMap.LinkEntry.class, 596, 19983, 19995).after;
                        CallChecker.varAssign(this.next, "this.next", 596, 19976, 20002);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context513.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context514 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 600, 20023, 20237);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 600, 20023, 20237);
                CallChecker.varInit(this.next, "next", 600, 20023, 20237);
                CallChecker.varInit(this.last, "last", 600, 20023, 20237);
                CallChecker.varInit(this.parent, "parent", 600, 20023, 20237);
                if ((last) != null) {
                    return ((("Iterator[" + (last.getKey())) + "=") + (last.getValue())) + "]";
                }
                return "Iterator[]";
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context514.methodEnd();
            }
        }
    }
}

