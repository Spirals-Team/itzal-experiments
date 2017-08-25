package org.apache.commons.collections.map;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.BoundedMap;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;

public class LRUMap<K, V> extends AbstractLinkedMap<K, V> implements Serializable , Cloneable , BoundedMap<K, V> {
    private static final long serialVersionUID = -612114643488955218L;

    protected static final int DEFAULT_MAX_SIZE = 100;

    private transient int maxSize;

    private boolean scanUntilRemovable;

    public LRUMap() {
        this(LRUMap.DEFAULT_MAX_SIZE, AbstractHashedMap.DEFAULT_LOAD_FACTOR, false);
        MethodContext _bcornu_methode_context425 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context425.methodEnd();
        }
    }

    public LRUMap(int maxSize) {
        this(maxSize, AbstractHashedMap.DEFAULT_LOAD_FACTOR);
        MethodContext _bcornu_methode_context426 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context426.methodEnd();
        }
    }

    public LRUMap(int maxSize, boolean scanUntilRemovable) {
        this(maxSize, AbstractHashedMap.DEFAULT_LOAD_FACTOR, scanUntilRemovable);
        MethodContext _bcornu_methode_context427 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context427.methodEnd();
        }
    }

    public LRUMap(int maxSize, float loadFactor) {
        this(maxSize, loadFactor, false);
        MethodContext _bcornu_methode_context428 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context428.methodEnd();
        }
    }

    public LRUMap(int maxSize, float loadFactor, boolean scanUntilRemovable) {
        super((maxSize < 1 ? AbstractHashedMap.DEFAULT_CAPACITY : maxSize), loadFactor);
        MethodContext _bcornu_methode_context429 = new MethodContext(null);
        try {
            if (maxSize < 1) {
                throw new IllegalArgumentException("LRUMap max size must be greater than 0");
            }
            this.maxSize = maxSize;
            CallChecker.varAssign(this.maxSize, "this.maxSize", 138, 5725, 5747);
            this.scanUntilRemovable = scanUntilRemovable;
            CallChecker.varAssign(this.scanUntilRemovable, "this.scanUntilRemovable", 139, 5757, 5801);
        } finally {
            _bcornu_methode_context429.methodEnd();
        }
    }

    public LRUMap(Map<K, V> map) {
        this(map, false);
        MethodContext _bcornu_methode_context430 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context430.methodEnd();
        }
    }

    public LRUMap(Map<K, V> map, boolean scanUntilRemovable) {
        this(CallChecker.isCalled(map, Map.class, 167, 6661, 6663).size(), AbstractHashedMap.DEFAULT_LOAD_FACTOR, scanUntilRemovable);
        MethodContext _bcornu_methode_context431 = new MethodContext(null);
        try {
            putAll(map);
        } finally {
            _bcornu_methode_context431.methodEnd();
        }
    }

    @Override
    public V get(Object key) {
        AbstractLinkedMap.LinkEntry<K, V> entry = CallChecker.varInit(getEntry(key), "entry", 183, 7152, 7189);
        if (entry == null) {
            return null;
        }
        moveToMRU(entry);
        return entry.getValue();
    }

    protected void moveToMRU(AbstractLinkedMap.LinkEntry<K, V> entry) {
        MethodContext _bcornu_methode_context2288 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 199, 7325, 8552);
            CallChecker.varInit(entry, "entry", 199, 7325, 8552);
            CallChecker.varInit(this.values, "values", 199, 7325, 8552);
            CallChecker.varInit(this.keySet, "keySet", 199, 7325, 8552);
            CallChecker.varInit(this.entrySet, "entrySet", 199, 7325, 8552);
            CallChecker.varInit(this.modCount, "modCount", 199, 7325, 8552);
            CallChecker.varInit(this.threshold, "threshold", 199, 7325, 8552);
            CallChecker.varInit(this.data, "data", 199, 7325, 8552);
            CallChecker.varInit(this.size, "size", 199, 7325, 8552);
            CallChecker.varInit(this.loadFactor, "loadFactor", 199, 7325, 8552);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 199, 7325, 8552);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 199, 7325, 8552);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 199, 7325, 8552);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 199, 7325, 8552);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 199, 7325, 8552);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 199, 7325, 8552);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 199, 7325, 8552);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 199, 7325, 8552);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 199, 7325, 8552);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 199, 7325, 8552);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 199, 7325, 8552);
            CallChecker.varInit(this.header, "header", 199, 7325, 8552);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 199, 7325, 8552);
            CallChecker.varInit(this.maxSize, "maxSize", 199, 7325, 8552);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 199, 7325, 8552);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 199, 7325, 8552);
            if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 200, 7681, 7685)) {
                entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 200, 7681, 7685);
                if ((CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 200, 7681, 7685).after) != (header)) {
                    (modCount)++;
                    if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 203, 7767, 7771)) {
                        entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 203, 7767, 7771);
                        if ((CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 203, 7767, 7771).before) == null) {
                            throw new IllegalStateException(("Entry.before is null." + (" Please check that your keys are immutable, and that you have used synchronization properly." + " If so, then please report this to dev@commons.apache.org as a bug.")));
                        }
                    }
                    if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 208, 8101, 8105)) {
                        if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 208, 8122, 8126)) {
                            entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 208, 8101, 8105);
                            entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 208, 8122, 8126);
                            CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 208, 8101, 8105).before.after = CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 208, 8122, 8126).after;
                            CallChecker.varAssign(CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 208, 8101, 8105).before.after, "CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 208, 8101, 8105).before.after", 208, 8101, 8133);
                        }
                    }
                    if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 209, 8147, 8151)) {
                        entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 209, 8147, 8151);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 209, 8147, 8151).after, AbstractLinkedMap.LinkEntry.class, 209, 8147, 8157)) {
                            if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 209, 8168, 8172)) {
                                entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 209, 8147, 8151);
                                entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 209, 8168, 8172);
                                CallChecker.isCalled(CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 209, 8147, 8151).after, AbstractLinkedMap.LinkEntry.class, 209, 8147, 8157).before = CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 209, 8168, 8172).before;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 209, 8147, 8151).after, AbstractLinkedMap.LinkEntry.class, 209, 8147, 8157).before, "CallChecker.isCalled(CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 209, 8147, 8151).after, AbstractLinkedMap.LinkEntry.class, 209, 8147, 8157).before", 209, 8147, 8180);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 211, 8219, 8223)) {
                        entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 211, 8219, 8223);
                        CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 211, 8219, 8223).after = header;
                        CallChecker.varAssign(CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 211, 8219, 8223).after, "CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 211, 8219, 8223).after", 211, 8219, 8239);
                    }
                    if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 212, 8253, 8257)) {
                        if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 212, 8268, 8273)) {
                            entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 212, 8253, 8257);
                            header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 212, 8268, 8273);
                            CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 212, 8253, 8257).before = CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 212, 8268, 8273).before;
                            CallChecker.varAssign(CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 212, 8253, 8257).before, "CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 212, 8253, 8257).before", 212, 8253, 8281);
                        }
                    }
                    if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 213, 8295, 8300)) {
                        header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 213, 8295, 8300);
                        CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 213, 8295, 8300).before.after = entry;
                        CallChecker.varAssign(CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 213, 8295, 8300).before.after, "CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 213, 8295, 8300).before.after", 213, 8295, 8322);
                    }
                    if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 214, 8336, 8341)) {
                        header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 214, 8336, 8341);
                        CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 214, 8336, 8341).before = entry;
                        CallChecker.varAssign(CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 214, 8336, 8341).before, "CallChecker.isCalled(this.header, AbstractLinkedMap.LinkEntry.class, 214, 8336, 8341).before", 214, 8336, 8357);
                    }
                }else
                    if (entry == (header)) {
                        throw new IllegalStateException(("Can't move header to MRU" + " (please report this to dev@commons.apache.org)"));
                    }
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2288.methodEnd();
        }
    }

    @Override
    protected void updateEntry(AbstractHashedMap.HashEntry<K, V> entry, V newValue) {
        MethodContext _bcornu_methode_context2289 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 231, 8559, 9044);
            CallChecker.varInit(newValue, "newValue", 231, 8559, 9044);
            CallChecker.varInit(entry, "entry", 231, 8559, 9044);
            CallChecker.varInit(this.values, "values", 231, 8559, 9044);
            CallChecker.varInit(this.keySet, "keySet", 231, 8559, 9044);
            CallChecker.varInit(this.entrySet, "entrySet", 231, 8559, 9044);
            CallChecker.varInit(this.modCount, "modCount", 231, 8559, 9044);
            CallChecker.varInit(this.threshold, "threshold", 231, 8559, 9044);
            CallChecker.varInit(this.data, "data", 231, 8559, 9044);
            CallChecker.varInit(this.size, "size", 231, 8559, 9044);
            CallChecker.varInit(this.loadFactor, "loadFactor", 231, 8559, 9044);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 231, 8559, 9044);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 231, 8559, 9044);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 231, 8559, 9044);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 231, 8559, 9044);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 231, 8559, 9044);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 231, 8559, 9044);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 231, 8559, 9044);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 231, 8559, 9044);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 231, 8559, 9044);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 231, 8559, 9044);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 231, 8559, 9044);
            CallChecker.varInit(this.header, "header", 231, 8559, 9044);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 231, 8559, 9044);
            CallChecker.varInit(this.maxSize, "maxSize", 231, 8559, 9044);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 231, 8559, 9044);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 231, 8559, 9044);
            moveToMRU(((AbstractLinkedMap.LinkEntry<K, V>) (entry)));
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 233, 9014, 9018)) {
                entry.setValue(newValue);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2289.methodEnd();
        }
    }

    @Override
    protected void addMapping(int hashIndex, int hashCode, K key, V value) {
        MethodContext _bcornu_methode_context2290 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 252, 9051, 11674);
            CallChecker.varInit(value, "value", 252, 9051, 11674);
            CallChecker.varInit(key, "key", 252, 9051, 11674);
            CallChecker.varInit(hashCode, "hashCode", 252, 9051, 11674);
            CallChecker.varInit(hashIndex, "hashIndex", 252, 9051, 11674);
            CallChecker.varInit(this.values, "values", 252, 9051, 11674);
            CallChecker.varInit(this.keySet, "keySet", 252, 9051, 11674);
            CallChecker.varInit(this.entrySet, "entrySet", 252, 9051, 11674);
            CallChecker.varInit(this.modCount, "modCount", 252, 9051, 11674);
            CallChecker.varInit(this.threshold, "threshold", 252, 9051, 11674);
            CallChecker.varInit(this.data, "data", 252, 9051, 11674);
            CallChecker.varInit(this.size, "size", 252, 9051, 11674);
            CallChecker.varInit(this.loadFactor, "loadFactor", 252, 9051, 11674);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 252, 9051, 11674);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 252, 9051, 11674);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 252, 9051, 11674);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 252, 9051, 11674);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 252, 9051, 11674);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 252, 9051, 11674);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 252, 9051, 11674);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 252, 9051, 11674);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 252, 9051, 11674);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 252, 9051, 11674);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 252, 9051, 11674);
            CallChecker.varInit(this.header, "header", 252, 9051, 11674);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 252, 9051, 11674);
            CallChecker.varInit(this.maxSize, "maxSize", 252, 9051, 11674);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 252, 9051, 11674);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 252, 9051, 11674);
            if (isFull()) {
                AbstractLinkedMap.LinkEntry<K, V> reuse = CallChecker.init(AbstractLinkedMap.LinkEntry.class);
                if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 254, 9862, 9867)) {
                    header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 254, 9862, 9867);
                    reuse = CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 254, 9862, 9867).after;
                    CallChecker.varAssign(reuse, "reuse", 254, 9862, 9867);
                }
                boolean removeLRUEntry = CallChecker.varInit(((boolean) (false)), "removeLRUEntry", 255, 9888, 9918);
                if (scanUntilRemovable) {
                    while ((reuse != (header)) && (reuse != null)) {
                        if (removeLRU(reuse)) {
                            removeLRUEntry = true;
                            CallChecker.varAssign(removeLRUEntry, "removeLRUEntry", 259, 10085, 10106);
                            break;
                        }
                        reuse = reuse.after;
                        CallChecker.varAssign(reuse, "reuse", 262, 10181, 10200);
                    } 
                    if (reuse == null) {
                        if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 266, 10369, 10374)) {
                            if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 266, 10403, 10408)) {
                                header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 266, 10369, 10374);
                                header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 266, 10403, 10408);
                                throw new IllegalStateException(((((((((((((("Entry.after=null, header.after" + (CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 266, 10369, 10374).after)) + " header.before") + (CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 266, 10403, 10408).before)) + " key=") + key) + " value=") + value) + " size=") + (size)) + " maxSize=") + (maxSize)) + " Please check that your keys are immutable, and that you have used synchronization properly.") + " If so, then please report this to dev@commons.apache.org as a bug."));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else {
                    removeLRUEntry = removeLRU(reuse);
                    CallChecker.varAssign(removeLRUEntry, "removeLRUEntry", 272, 10793, 10826);
                }
                if (removeLRUEntry) {
                    if (reuse == null) {
                        if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 278, 11021, 11026)) {
                            if (CallChecker.beforeDeref(header, AbstractLinkedMap.LinkEntry.class, 278, 11055, 11060)) {
                                header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 278, 11021, 11026);
                                header = CallChecker.beforeCalled(header, AbstractLinkedMap.LinkEntry.class, 278, 11055, 11060);
                                throw new IllegalStateException(((((((((((((("reuse=null, header.after=" + (CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 278, 11021, 11026).after)) + " header.before") + (CallChecker.isCalled(header, AbstractLinkedMap.LinkEntry.class, 278, 11055, 11060).before)) + " key=") + key) + " value=") + value) + " size=") + (size)) + " maxSize=") + (maxSize)) + " Please check that your keys are immutable, and that you have used synchronization properly.") + " If so, then please report this to dev@commons.apache.org as a bug."));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                    reuseMapping(reuse, hashIndex, hashCode, key, value);
                }else {
                    super.addMapping(hashIndex, hashCode, key, value);
                }
            }else {
                super.addMapping(hashIndex, hashCode, key, value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2290.methodEnd();
        }
    }

    protected void reuseMapping(AbstractLinkedMap.LinkEntry<K, V> entry, int hashIndex, int hashCode, K key, V value) {
        MethodContext _bcornu_methode_context2291 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 303, 11681, 14010);
            CallChecker.varInit(value, "value", 303, 11681, 14010);
            CallChecker.varInit(key, "key", 303, 11681, 14010);
            CallChecker.varInit(hashCode, "hashCode", 303, 11681, 14010);
            CallChecker.varInit(hashIndex, "hashIndex", 303, 11681, 14010);
            CallChecker.varInit(entry, "entry", 303, 11681, 14010);
            CallChecker.varInit(this.values, "values", 303, 11681, 14010);
            CallChecker.varInit(this.keySet, "keySet", 303, 11681, 14010);
            CallChecker.varInit(this.entrySet, "entrySet", 303, 11681, 14010);
            CallChecker.varInit(this.modCount, "modCount", 303, 11681, 14010);
            CallChecker.varInit(this.threshold, "threshold", 303, 11681, 14010);
            CallChecker.varInit(this.data, "data", 303, 11681, 14010);
            CallChecker.varInit(this.size, "size", 303, 11681, 14010);
            CallChecker.varInit(this.loadFactor, "loadFactor", 303, 11681, 14010);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 303, 11681, 14010);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 303, 11681, 14010);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 303, 11681, 14010);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 303, 11681, 14010);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 303, 11681, 14010);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 303, 11681, 14010);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 303, 11681, 14010);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 303, 11681, 14010);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 303, 11681, 14010);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 303, 11681, 14010);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 303, 11681, 14010);
            CallChecker.varInit(this.header, "header", 303, 11681, 14010);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 303, 11681, 14010);
            CallChecker.varInit(this.maxSize, "maxSize", 303, 11681, 14010);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 303, 11681, 14010);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 303, 11681, 14010);
            TryContext _bcornu_try_context_26 = new TryContext(26, LRUMap.class, "java.lang.NullPointerException");
            try {
                int removeIndex = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(entry, AbstractLinkedMap.LinkEntry.class, 308, 12451, 12455)) {
                    if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 308, 12467, 12470)) {
                        entry = CallChecker.beforeCalled(entry, AbstractLinkedMap.LinkEntry.class, 308, 12451, 12455);
                        data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 308, 12467, 12470);
                        removeIndex = hashIndex(CallChecker.isCalled(entry, AbstractLinkedMap.LinkEntry.class, 308, 12451, 12455).hashCode, CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 308, 12467, 12470).length);
                        CallChecker.varAssign(removeIndex, "removeIndex", 308, 12451, 12455);
                    }
                }
                AbstractHashedMap.HashEntry<K, V>[] tmp = CallChecker.varInit(data, "tmp", 309, 12493, 12521);
                AbstractHashedMap.HashEntry<K, V> loop = CallChecker.init(AbstractHashedMap.HashEntry.class);
                if (CallChecker.beforeDeref(tmp, AbstractHashedMap.HashEntry[].class, 310, 12599, 12601)) {
                    tmp = CallChecker.beforeCalled(tmp, AbstractHashedMap.HashEntry[].class, 310, 12599, 12601);
                    loop = CallChecker.isCalled(tmp, AbstractHashedMap.HashEntry[].class, 310, 12599, 12601)[removeIndex];
                    CallChecker.varAssign(loop, "loop", 310, 12599, 12601);
                }
                AbstractHashedMap.HashEntry<K, V> previous = CallChecker.varInit(null, "previous", 311, 12629, 12660);
                while ((loop != entry) && (loop != null)) {
                    previous = loop;
                    CallChecker.varAssign(previous, "previous", 313, 12730, 12745);
                    loop = loop.next;
                    CallChecker.varAssign(loop, "loop", 314, 12763, 12779);
                } 
                if (loop == null) {
                    if (CallChecker.beforeDeref(data, AbstractHashedMap.HashEntry[].class, 318, 12936, 12939)) {
                        data = CallChecker.beforeCalled(data, AbstractHashedMap.HashEntry[].class, 318, 12936, 12939);
                        throw new IllegalStateException(((((((((((((("Entry.next=null, data[removeIndex]=" + (CallChecker.isCalled(data, AbstractHashedMap.HashEntry[].class, 318, 12936, 12939)[removeIndex])) + " previous=") + previous) + " key=") + key) + " value=") + value) + " size=") + (size)) + " maxSize=") + (maxSize)) + " Please check that your keys are immutable, and that you have used synchronization properly.") + " If so, then please report this to dev@commons.apache.org as a bug."));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                (modCount)++;
                removeEntry(entry, removeIndex, previous);
                reuseEntry(entry, hashIndex, hashCode, key, value);
                addEntry(entry, hashIndex);
            } catch (NullPointerException ex) {
                _bcornu_try_context_26.catchStart(26);
                throw new IllegalStateException(((((((((((((("NPE, entry=" + entry) + " entryIsHeader=") + (entry == (header))) + " key=") + key) + " value=") + value) + " size=") + (size)) + " maxSize=") + (maxSize)) + " Please check that your keys are immutable, and that you have used synchronization properly.") + " If so, then please report this to dev@commons.apache.org as a bug."));
            } finally {
                _bcornu_try_context_26.finallyStart(26);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2291.methodEnd();
        }
    }

    protected boolean removeLRU(AbstractLinkedMap.LinkEntry<K, V> entry) {
        MethodContext _bcornu_methode_context2292 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 371, 14017, 15543);
            CallChecker.varInit(entry, "entry", 371, 14017, 15543);
            CallChecker.varInit(this.values, "values", 371, 14017, 15543);
            CallChecker.varInit(this.keySet, "keySet", 371, 14017, 15543);
            CallChecker.varInit(this.entrySet, "entrySet", 371, 14017, 15543);
            CallChecker.varInit(this.modCount, "modCount", 371, 14017, 15543);
            CallChecker.varInit(this.threshold, "threshold", 371, 14017, 15543);
            CallChecker.varInit(this.data, "data", 371, 14017, 15543);
            CallChecker.varInit(this.size, "size", 371, 14017, 15543);
            CallChecker.varInit(this.loadFactor, "loadFactor", 371, 14017, 15543);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 371, 14017, 15543);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 371, 14017, 15543);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 371, 14017, 15543);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 371, 14017, 15543);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 371, 14017, 15543);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 371, 14017, 15543);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 371, 14017, 15543);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 371, 14017, 15543);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 371, 14017, 15543);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 371, 14017, 15543);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 371, 14017, 15543);
            CallChecker.varInit(this.header, "header", 371, 14017, 15543);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 371, 14017, 15543);
            CallChecker.varInit(this.maxSize, "maxSize", 371, 14017, 15543);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 371, 14017, 15543);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 371, 14017, 15543);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2292.methodEnd();
        }
    }

    public boolean isFull() {
        MethodContext _bcornu_methode_context2293 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 381, 15550, 15841);
            CallChecker.varInit(this.values, "values", 381, 15550, 15841);
            CallChecker.varInit(this.keySet, "keySet", 381, 15550, 15841);
            CallChecker.varInit(this.entrySet, "entrySet", 381, 15550, 15841);
            CallChecker.varInit(this.modCount, "modCount", 381, 15550, 15841);
            CallChecker.varInit(this.threshold, "threshold", 381, 15550, 15841);
            CallChecker.varInit(this.data, "data", 381, 15550, 15841);
            CallChecker.varInit(this.size, "size", 381, 15550, 15841);
            CallChecker.varInit(this.loadFactor, "loadFactor", 381, 15550, 15841);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 381, 15550, 15841);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 381, 15550, 15841);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 381, 15550, 15841);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 381, 15550, 15841);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 381, 15550, 15841);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 381, 15550, 15841);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 381, 15550, 15841);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 381, 15550, 15841);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 381, 15550, 15841);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 381, 15550, 15841);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 381, 15550, 15841);
            CallChecker.varInit(this.header, "header", 381, 15550, 15841);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 381, 15550, 15841);
            CallChecker.varInit(this.maxSize, "maxSize", 381, 15550, 15841);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 381, 15550, 15841);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 381, 15550, 15841);
            return (size) >= (maxSize);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2293.methodEnd();
        }
    }

    public int maxSize() {
        MethodContext _bcornu_methode_context2294 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 390, 15848, 16038);
            CallChecker.varInit(this.values, "values", 390, 15848, 16038);
            CallChecker.varInit(this.keySet, "keySet", 390, 15848, 16038);
            CallChecker.varInit(this.entrySet, "entrySet", 390, 15848, 16038);
            CallChecker.varInit(this.modCount, "modCount", 390, 15848, 16038);
            CallChecker.varInit(this.threshold, "threshold", 390, 15848, 16038);
            CallChecker.varInit(this.data, "data", 390, 15848, 16038);
            CallChecker.varInit(this.size, "size", 390, 15848, 16038);
            CallChecker.varInit(this.loadFactor, "loadFactor", 390, 15848, 16038);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 390, 15848, 16038);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 390, 15848, 16038);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 390, 15848, 16038);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 390, 15848, 16038);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 390, 15848, 16038);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 390, 15848, 16038);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 390, 15848, 16038);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 390, 15848, 16038);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 390, 15848, 16038);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 390, 15848, 16038);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 390, 15848, 16038);
            CallChecker.varInit(this.header, "header", 390, 15848, 16038);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 390, 15848, 16038);
            CallChecker.varInit(this.maxSize, "maxSize", 390, 15848, 16038);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 390, 15848, 16038);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 390, 15848, 16038);
            return maxSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2294.methodEnd();
        }
    }

    public boolean isScanUntilRemovable() {
        MethodContext _bcornu_methode_context2295 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 401, 16045, 16322);
            CallChecker.varInit(this.values, "values", 401, 16045, 16322);
            CallChecker.varInit(this.keySet, "keySet", 401, 16045, 16322);
            CallChecker.varInit(this.entrySet, "entrySet", 401, 16045, 16322);
            CallChecker.varInit(this.modCount, "modCount", 401, 16045, 16322);
            CallChecker.varInit(this.threshold, "threshold", 401, 16045, 16322);
            CallChecker.varInit(this.data, "data", 401, 16045, 16322);
            CallChecker.varInit(this.size, "size", 401, 16045, 16322);
            CallChecker.varInit(this.loadFactor, "loadFactor", 401, 16045, 16322);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 401, 16045, 16322);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 401, 16045, 16322);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 401, 16045, 16322);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 401, 16045, 16322);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 401, 16045, 16322);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 401, 16045, 16322);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 401, 16045, 16322);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 401, 16045, 16322);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 401, 16045, 16322);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 401, 16045, 16322);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 401, 16045, 16322);
            CallChecker.varInit(this.header, "header", 401, 16045, 16322);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 401, 16045, 16322);
            CallChecker.varInit(this.maxSize, "maxSize", 401, 16045, 16322);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 401, 16045, 16322);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 401, 16045, 16322);
            return scanUntilRemovable;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2295.methodEnd();
        }
    }

    @Override
    public LRUMap<K, V> clone() {
        MethodContext _bcornu_methode_context2296 = new MethodContext(LRUMap.class);
        try {
            CallChecker.varInit(this, "this", 412, 16329, 16612);
            CallChecker.varInit(this.values, "values", 412, 16329, 16612);
            CallChecker.varInit(this.keySet, "keySet", 412, 16329, 16612);
            CallChecker.varInit(this.entrySet, "entrySet", 412, 16329, 16612);
            CallChecker.varInit(this.modCount, "modCount", 412, 16329, 16612);
            CallChecker.varInit(this.threshold, "threshold", 412, 16329, 16612);
            CallChecker.varInit(this.data, "data", 412, 16329, 16612);
            CallChecker.varInit(this.size, "size", 412, 16329, 16612);
            CallChecker.varInit(this.loadFactor, "loadFactor", 412, 16329, 16612);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 412, 16329, 16612);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 412, 16329, 16612);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 412, 16329, 16612);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 412, 16329, 16612);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 412, 16329, 16612);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 412, 16329, 16612);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 412, 16329, 16612);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 412, 16329, 16612);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 412, 16329, 16612);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 412, 16329, 16612);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 412, 16329, 16612);
            CallChecker.varInit(this.header, "header", 412, 16329, 16612);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 412, 16329, 16612);
            CallChecker.varInit(this.maxSize, "maxSize", 412, 16329, 16612);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 412, 16329, 16612);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 412, 16329, 16612);
            return ((LRUMap<K, V>) (super.clone()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((LRUMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2296.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2297 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 419, 16619, 16820);
            CallChecker.varInit(out, "out", 419, 16619, 16820);
            CallChecker.varInit(this.values, "values", 419, 16619, 16820);
            CallChecker.varInit(this.keySet, "keySet", 419, 16619, 16820);
            CallChecker.varInit(this.entrySet, "entrySet", 419, 16619, 16820);
            CallChecker.varInit(this.modCount, "modCount", 419, 16619, 16820);
            CallChecker.varInit(this.threshold, "threshold", 419, 16619, 16820);
            CallChecker.varInit(this.data, "data", 419, 16619, 16820);
            CallChecker.varInit(this.size, "size", 419, 16619, 16820);
            CallChecker.varInit(this.loadFactor, "loadFactor", 419, 16619, 16820);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 419, 16619, 16820);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 419, 16619, 16820);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 419, 16619, 16820);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 419, 16619, 16820);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 419, 16619, 16820);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 419, 16619, 16820);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 419, 16619, 16820);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 419, 16619, 16820);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 419, 16619, 16820);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 419, 16619, 16820);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 419, 16619, 16820);
            CallChecker.varInit(this.header, "header", 419, 16619, 16820);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 419, 16619, 16820);
            CallChecker.varInit(this.maxSize, "maxSize", 419, 16619, 16820);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 419, 16619, 16820);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 419, 16619, 16820);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 420, 16762, 16764)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 420, 16762, 16764);
                CallChecker.isCalled(out, ObjectOutputStream.class, 420, 16762, 16764).defaultWriteObject();
            }
            doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2297.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2298 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 427, 16827, 17043);
            CallChecker.varInit(in, "in", 427, 16827, 17043);
            CallChecker.varInit(this.values, "values", 427, 16827, 17043);
            CallChecker.varInit(this.keySet, "keySet", 427, 16827, 17043);
            CallChecker.varInit(this.entrySet, "entrySet", 427, 16827, 17043);
            CallChecker.varInit(this.modCount, "modCount", 427, 16827, 17043);
            CallChecker.varInit(this.threshold, "threshold", 427, 16827, 17043);
            CallChecker.varInit(this.data, "data", 427, 16827, 17043);
            CallChecker.varInit(this.size, "size", 427, 16827, 17043);
            CallChecker.varInit(this.loadFactor, "loadFactor", 427, 16827, 17043);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 427, 16827, 17043);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 427, 16827, 17043);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 427, 16827, 17043);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 427, 16827, 17043);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 427, 16827, 17043);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 427, 16827, 17043);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 427, 16827, 17043);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 427, 16827, 17043);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 427, 16827, 17043);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 427, 16827, 17043);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 427, 16827, 17043);
            CallChecker.varInit(this.header, "header", 427, 16827, 17043);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 427, 16827, 17043);
            CallChecker.varInit(this.maxSize, "maxSize", 427, 16827, 17043);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 427, 16827, 17043);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 427, 16827, 17043);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 428, 16989, 16990)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 428, 16989, 16990);
                CallChecker.isCalled(in, ObjectInputStream.class, 428, 16989, 16990).defaultReadObject();
            }
            doReadObject(in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2298.methodEnd();
        }
    }

    @Override
    protected void doWriteObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2299 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 436, 17050, 17307);
            CallChecker.varInit(out, "out", 436, 17050, 17307);
            CallChecker.varInit(this.values, "values", 436, 17050, 17307);
            CallChecker.varInit(this.keySet, "keySet", 436, 17050, 17307);
            CallChecker.varInit(this.entrySet, "entrySet", 436, 17050, 17307);
            CallChecker.varInit(this.modCount, "modCount", 436, 17050, 17307);
            CallChecker.varInit(this.threshold, "threshold", 436, 17050, 17307);
            CallChecker.varInit(this.data, "data", 436, 17050, 17307);
            CallChecker.varInit(this.size, "size", 436, 17050, 17307);
            CallChecker.varInit(this.loadFactor, "loadFactor", 436, 17050, 17307);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 436, 17050, 17307);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 436, 17050, 17307);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 436, 17050, 17307);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 436, 17050, 17307);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 436, 17050, 17307);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 436, 17050, 17307);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 436, 17050, 17307);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 436, 17050, 17307);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 436, 17050, 17307);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 436, 17050, 17307);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 436, 17050, 17307);
            CallChecker.varInit(this.header, "header", 436, 17050, 17307);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 436, 17050, 17307);
            CallChecker.varInit(this.maxSize, "maxSize", 436, 17050, 17307);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 436, 17050, 17307);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 436, 17050, 17307);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 437, 17246, 17248)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 437, 17246, 17248);
                CallChecker.isCalled(out, ObjectOutputStream.class, 437, 17246, 17248).writeInt(maxSize);
            }
            super.doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2299.methodEnd();
        }
    }

    @Override
    protected void doReadObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2300 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 445, 17314, 17589);
            CallChecker.varInit(in, "in", 445, 17314, 17589);
            CallChecker.varInit(this.values, "values", 445, 17314, 17589);
            CallChecker.varInit(this.keySet, "keySet", 445, 17314, 17589);
            CallChecker.varInit(this.entrySet, "entrySet", 445, 17314, 17589);
            CallChecker.varInit(this.modCount, "modCount", 445, 17314, 17589);
            CallChecker.varInit(this.threshold, "threshold", 445, 17314, 17589);
            CallChecker.varInit(this.data, "data", 445, 17314, 17589);
            CallChecker.varInit(this.size, "size", 445, 17314, 17589);
            CallChecker.varInit(this.loadFactor, "loadFactor", 445, 17314, 17589);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 445, 17314, 17589);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 445, 17314, 17589);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 445, 17314, 17589);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 445, 17314, 17589);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 445, 17314, 17589);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 445, 17314, 17589);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 445, 17314, 17589);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 445, 17314, 17589);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 445, 17314, 17589);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 445, 17314, 17589);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 445, 17314, 17589);
            CallChecker.varInit(this.header, "header", 445, 17314, 17589);
            CallChecker.varInit(this.scanUntilRemovable, "scanUntilRemovable", 445, 17314, 17589);
            CallChecker.varInit(this.maxSize, "maxSize", 445, 17314, 17589);
            CallChecker.varInit(DEFAULT_MAX_SIZE, "org.apache.commons.collections.map.LRUMap.DEFAULT_MAX_SIZE", 445, 17314, 17589);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LRUMap.serialVersionUID", 445, 17314, 17589);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 446, 17539, 17540)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 446, 17539, 17540);
                maxSize = CallChecker.isCalled(in, ObjectInputStream.class, 446, 17539, 17540).readInt();
                CallChecker.varAssign(this.maxSize, "this.maxSize", 446, 17529, 17551);
            }
            super.doReadObject(in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2300.methodEnd();
        }
    }
}

