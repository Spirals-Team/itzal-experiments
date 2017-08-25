package org.apache.commons.collections.map;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CaseInsensitiveMap<K, V> extends AbstractHashedMap<K, V> implements Serializable , Cloneable {
    private static final long serialVersionUID = -7074655917369299456L;

    public CaseInsensitiveMap() {
        super(AbstractHashedMap.DEFAULT_CAPACITY, AbstractHashedMap.DEFAULT_LOAD_FACTOR, AbstractHashedMap.DEFAULT_THRESHOLD);
        MethodContext _bcornu_methode_context186 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context186.methodEnd();
        }
    }

    public CaseInsensitiveMap(int initialCapacity) {
        super(initialCapacity);
        MethodContext _bcornu_methode_context187 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context187.methodEnd();
        }
    }

    public CaseInsensitiveMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        MethodContext _bcornu_methode_context188 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context188.methodEnd();
        }
    }

    public CaseInsensitiveMap(Map<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context189 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context189.methodEnd();
        }
    }

    @Override
    protected Object convertKey(Object key) {
        MethodContext _bcornu_methode_context974 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 125, 4391, 5120);
            CallChecker.varInit(key, "key", 125, 4391, 5120);
            CallChecker.varInit(this.values, "values", 125, 4391, 5120);
            CallChecker.varInit(this.keySet, "keySet", 125, 4391, 5120);
            CallChecker.varInit(this.entrySet, "entrySet", 125, 4391, 5120);
            CallChecker.varInit(this.modCount, "modCount", 125, 4391, 5120);
            CallChecker.varInit(this.threshold, "threshold", 125, 4391, 5120);
            CallChecker.varInit(this.data, "data", 125, 4391, 5120);
            CallChecker.varInit(this.size, "size", 125, 4391, 5120);
            CallChecker.varInit(this.loadFactor, "loadFactor", 125, 4391, 5120);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 125, 4391, 5120);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 125, 4391, 5120);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 125, 4391, 5120);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 125, 4391, 5120);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 125, 4391, 5120);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 125, 4391, 5120);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 125, 4391, 5120);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 125, 4391, 5120);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 125, 4391, 5120);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 125, 4391, 5120);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 125, 4391, 5120);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CaseInsensitiveMap.serialVersionUID", 125, 4391, 5120);
            if (key != null) {
                char[] chars = CallChecker.init(char[].class);
                key = CallChecker.beforeCalled(key, Object.class, 127, 4844, 4846);
                if (CallChecker.beforeDeref(CallChecker.isCalled(key, Object.class, 127, 4844, 4846).toString(), String.class, 127, 4844, 4857)) {
                    chars = CallChecker.isCalled(key.toString(), String.class, 127, 4844, 4857).toCharArray();
                    CallChecker.varAssign(chars, "chars", 127, 4844, 4857);
                }
                chars = CallChecker.beforeCalled(chars, char[].class, 128, 4899, 4903);
                for (int i = (CallChecker.isCalled(chars, char[].class, 128, 4899, 4903).length) - 1; i >= 0; i--) {
                    if (CallChecker.beforeDeref(chars, char[].class, 129, 4948, 4952)) {
                        if (CallChecker.beforeDeref(chars, char[].class, 129, 5003, 5007)) {
                            chars = CallChecker.beforeCalled(chars, char[].class, 129, 4948, 4952);
                            chars = CallChecker.beforeCalled(chars, char[].class, 129, 5003, 5007);
                            CallChecker.isCalled(chars, char[].class, 129, 4948, 4952)[i] = Character.toLowerCase(Character.toUpperCase(CallChecker.isCalled(chars, char[].class, 129, 5003, 5007)[i]));
                            CallChecker.varAssign(CallChecker.isCalled(chars, char[].class, 129, 4948, 4952)[i], "CallChecker.isCalled(chars, char[].class, 129, 4948, 4952)[i]", 129, 4948, 5013);
                        }
                    }
                }
                return new String(chars);
            }
            return AbstractHashedMap.NULL;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context974.methodEnd();
        }
    }

    @Override
    public CaseInsensitiveMap<K, V> clone() {
        MethodContext _bcornu_methode_context975 = new MethodContext(CaseInsensitiveMap.class);
        try {
            CallChecker.varInit(this, "this", 143, 5130, 5437);
            CallChecker.varInit(this.values, "values", 143, 5130, 5437);
            CallChecker.varInit(this.keySet, "keySet", 143, 5130, 5437);
            CallChecker.varInit(this.entrySet, "entrySet", 143, 5130, 5437);
            CallChecker.varInit(this.modCount, "modCount", 143, 5130, 5437);
            CallChecker.varInit(this.threshold, "threshold", 143, 5130, 5437);
            CallChecker.varInit(this.data, "data", 143, 5130, 5437);
            CallChecker.varInit(this.size, "size", 143, 5130, 5437);
            CallChecker.varInit(this.loadFactor, "loadFactor", 143, 5130, 5437);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 143, 5130, 5437);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 143, 5130, 5437);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 143, 5130, 5437);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 143, 5130, 5437);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 143, 5130, 5437);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 143, 5130, 5437);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 143, 5130, 5437);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 143, 5130, 5437);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 143, 5130, 5437);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 143, 5130, 5437);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 143, 5130, 5437);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CaseInsensitiveMap.serialVersionUID", 143, 5130, 5437);
            return ((CaseInsensitiveMap<K, V>) (super.clone()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((CaseInsensitiveMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context975.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context976 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 150, 5444, 5645);
            CallChecker.varInit(out, "out", 150, 5444, 5645);
            CallChecker.varInit(this.values, "values", 150, 5444, 5645);
            CallChecker.varInit(this.keySet, "keySet", 150, 5444, 5645);
            CallChecker.varInit(this.entrySet, "entrySet", 150, 5444, 5645);
            CallChecker.varInit(this.modCount, "modCount", 150, 5444, 5645);
            CallChecker.varInit(this.threshold, "threshold", 150, 5444, 5645);
            CallChecker.varInit(this.data, "data", 150, 5444, 5645);
            CallChecker.varInit(this.size, "size", 150, 5444, 5645);
            CallChecker.varInit(this.loadFactor, "loadFactor", 150, 5444, 5645);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 150, 5444, 5645);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 150, 5444, 5645);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 150, 5444, 5645);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 150, 5444, 5645);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 150, 5444, 5645);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 150, 5444, 5645);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 150, 5444, 5645);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 150, 5444, 5645);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 150, 5444, 5645);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 150, 5444, 5645);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 150, 5444, 5645);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CaseInsensitiveMap.serialVersionUID", 150, 5444, 5645);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 151, 5587, 5589)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 151, 5587, 5589);
                CallChecker.isCalled(out, ObjectOutputStream.class, 151, 5587, 5589).defaultWriteObject();
            }
            doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context976.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context977 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 158, 5652, 5868);
            CallChecker.varInit(in, "in", 158, 5652, 5868);
            CallChecker.varInit(this.values, "values", 158, 5652, 5868);
            CallChecker.varInit(this.keySet, "keySet", 158, 5652, 5868);
            CallChecker.varInit(this.entrySet, "entrySet", 158, 5652, 5868);
            CallChecker.varInit(this.modCount, "modCount", 158, 5652, 5868);
            CallChecker.varInit(this.threshold, "threshold", 158, 5652, 5868);
            CallChecker.varInit(this.data, "data", 158, 5652, 5868);
            CallChecker.varInit(this.size, "size", 158, 5652, 5868);
            CallChecker.varInit(this.loadFactor, "loadFactor", 158, 5652, 5868);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 158, 5652, 5868);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 158, 5652, 5868);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 158, 5652, 5868);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 158, 5652, 5868);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 158, 5652, 5868);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 158, 5652, 5868);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 158, 5652, 5868);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 158, 5652, 5868);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 158, 5652, 5868);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 158, 5652, 5868);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 158, 5652, 5868);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CaseInsensitiveMap.serialVersionUID", 158, 5652, 5868);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 159, 5814, 5815)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 159, 5814, 5815);
                CallChecker.isCalled(in, ObjectInputStream.class, 159, 5814, 5815).defaultReadObject();
            }
            doReadObject(in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context977.methodEnd();
        }
    }
}

