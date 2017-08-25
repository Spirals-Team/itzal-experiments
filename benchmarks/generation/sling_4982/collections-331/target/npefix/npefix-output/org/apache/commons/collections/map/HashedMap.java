package org.apache.commons.collections.map;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HashedMap<K, V> extends AbstractHashedMap<K, V> implements Serializable , Cloneable {
    private static final long serialVersionUID = -1788199231038721040L;

    public HashedMap() {
        super(AbstractHashedMap.DEFAULT_CAPACITY, AbstractHashedMap.DEFAULT_LOAD_FACTOR, AbstractHashedMap.DEFAULT_THRESHOLD);
        MethodContext _bcornu_methode_context293 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context293.methodEnd();
        }
    }

    public HashedMap(int initialCapacity) {
        super(initialCapacity);
        MethodContext _bcornu_methode_context294 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context294.methodEnd();
        }
    }

    public HashedMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        MethodContext _bcornu_methode_context295 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context295.methodEnd();
        }
    }

    public HashedMap(Map<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context296 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context296.methodEnd();
        }
    }

    @Override
    public HashedMap<K, V> clone() {
        MethodContext _bcornu_methode_context1552 = new MethodContext(HashedMap.class);
        try {
            CallChecker.varInit(this, "this", 97, 3294, 3583);
            CallChecker.varInit(this.values, "values", 97, 3294, 3583);
            CallChecker.varInit(this.keySet, "keySet", 97, 3294, 3583);
            CallChecker.varInit(this.entrySet, "entrySet", 97, 3294, 3583);
            CallChecker.varInit(this.modCount, "modCount", 97, 3294, 3583);
            CallChecker.varInit(this.threshold, "threshold", 97, 3294, 3583);
            CallChecker.varInit(this.data, "data", 97, 3294, 3583);
            CallChecker.varInit(this.size, "size", 97, 3294, 3583);
            CallChecker.varInit(this.loadFactor, "loadFactor", 97, 3294, 3583);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 97, 3294, 3583);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 97, 3294, 3583);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 97, 3294, 3583);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 97, 3294, 3583);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 97, 3294, 3583);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 97, 3294, 3583);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 97, 3294, 3583);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 97, 3294, 3583);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 97, 3294, 3583);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 97, 3294, 3583);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 97, 3294, 3583);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.HashedMap.serialVersionUID", 97, 3294, 3583);
            return ((HashedMap<K, V>) (super.clone()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((HashedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1552.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1553 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 104, 3590, 3791);
            CallChecker.varInit(out, "out", 104, 3590, 3791);
            CallChecker.varInit(this.values, "values", 104, 3590, 3791);
            CallChecker.varInit(this.keySet, "keySet", 104, 3590, 3791);
            CallChecker.varInit(this.entrySet, "entrySet", 104, 3590, 3791);
            CallChecker.varInit(this.modCount, "modCount", 104, 3590, 3791);
            CallChecker.varInit(this.threshold, "threshold", 104, 3590, 3791);
            CallChecker.varInit(this.data, "data", 104, 3590, 3791);
            CallChecker.varInit(this.size, "size", 104, 3590, 3791);
            CallChecker.varInit(this.loadFactor, "loadFactor", 104, 3590, 3791);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 104, 3590, 3791);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 104, 3590, 3791);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 104, 3590, 3791);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 104, 3590, 3791);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 104, 3590, 3791);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 104, 3590, 3791);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 104, 3590, 3791);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 104, 3590, 3791);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 104, 3590, 3791);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 104, 3590, 3791);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 104, 3590, 3791);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.HashedMap.serialVersionUID", 104, 3590, 3791);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 105, 3733, 3735)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 105, 3733, 3735);
                CallChecker.isCalled(out, ObjectOutputStream.class, 105, 3733, 3735).defaultWriteObject();
            }
            doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1553.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1554 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 112, 3798, 4014);
            CallChecker.varInit(in, "in", 112, 3798, 4014);
            CallChecker.varInit(this.values, "values", 112, 3798, 4014);
            CallChecker.varInit(this.keySet, "keySet", 112, 3798, 4014);
            CallChecker.varInit(this.entrySet, "entrySet", 112, 3798, 4014);
            CallChecker.varInit(this.modCount, "modCount", 112, 3798, 4014);
            CallChecker.varInit(this.threshold, "threshold", 112, 3798, 4014);
            CallChecker.varInit(this.data, "data", 112, 3798, 4014);
            CallChecker.varInit(this.size, "size", 112, 3798, 4014);
            CallChecker.varInit(this.loadFactor, "loadFactor", 112, 3798, 4014);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 112, 3798, 4014);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 112, 3798, 4014);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 112, 3798, 4014);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 112, 3798, 4014);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 112, 3798, 4014);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 112, 3798, 4014);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 112, 3798, 4014);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 112, 3798, 4014);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 112, 3798, 4014);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 112, 3798, 4014);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 112, 3798, 4014);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.HashedMap.serialVersionUID", 112, 3798, 4014);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 113, 3960, 3961)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 113, 3960, 3961);
                CallChecker.isCalled(in, ObjectInputStream.class, 113, 3960, 3961).defaultReadObject();
            }
            doReadObject(in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1554.methodEnd();
        }
    }
}

