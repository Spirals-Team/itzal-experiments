package org.apache.commons.collections.map;

import static org.apache.commons.collections.map.AbstractReferenceMap.ReferenceStrength.SOFT;
import static org.apache.commons.collections.map.AbstractReferenceMap.ReferenceStrength.HARD;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class ReferenceMap<K, V> extends AbstractReferenceMap<K, V> implements Serializable {
    private static final long serialVersionUID = 1555089888138299607L;

    public ReferenceMap() {
        super(HARD, SOFT, AbstractHashedMap.DEFAULT_CAPACITY, AbstractHashedMap.DEFAULT_LOAD_FACTOR, false);
        MethodContext _bcornu_methode_context473 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context473.methodEnd();
        }
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength keyType, AbstractReferenceMap.ReferenceStrength valueType) {
        super(keyType, valueType, AbstractHashedMap.DEFAULT_CAPACITY, AbstractHashedMap.DEFAULT_LOAD_FACTOR, false);
        MethodContext _bcornu_methode_context474 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context474.methodEnd();
        }
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength keyType, AbstractReferenceMap.ReferenceStrength valueType, boolean purgeValues) {
        super(keyType, valueType, AbstractHashedMap.DEFAULT_CAPACITY, AbstractHashedMap.DEFAULT_LOAD_FACTOR, purgeValues);
        MethodContext _bcornu_methode_context475 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context475.methodEnd();
        }
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength keyType, AbstractReferenceMap.ReferenceStrength valueType, int capacity, float loadFactor) {
        super(keyType, valueType, capacity, loadFactor, false);
        MethodContext _bcornu_methode_context476 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context476.methodEnd();
        }
    }

    public ReferenceMap(AbstractReferenceMap.ReferenceStrength keyType, AbstractReferenceMap.ReferenceStrength valueType, int capacity, float loadFactor, boolean purgeValues) {
        super(keyType, valueType, capacity, loadFactor, purgeValues);
        MethodContext _bcornu_methode_context477 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context477.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2565 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 174, 8195, 8474);
            CallChecker.varInit(out, "out", 174, 8195, 8474);
            CallChecker.varInit(this.values, "values", 174, 8195, 8474);
            CallChecker.varInit(this.keySet, "keySet", 174, 8195, 8474);
            CallChecker.varInit(this.entrySet, "entrySet", 174, 8195, 8474);
            CallChecker.varInit(this.modCount, "modCount", 174, 8195, 8474);
            CallChecker.varInit(this.threshold, "threshold", 174, 8195, 8474);
            CallChecker.varInit(this.data, "data", 174, 8195, 8474);
            CallChecker.varInit(this.size, "size", 174, 8195, 8474);
            CallChecker.varInit(this.loadFactor, "loadFactor", 174, 8195, 8474);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 174, 8195, 8474);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 174, 8195, 8474);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 174, 8195, 8474);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 174, 8195, 8474);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 174, 8195, 8474);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 174, 8195, 8474);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 174, 8195, 8474);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 174, 8195, 8474);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 174, 8195, 8474);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 174, 8195, 8474);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 174, 8195, 8474);
            CallChecker.varInit(this.purgeValues, "purgeValues", 174, 8195, 8474);
            CallChecker.varInit(this.valueType, "valueType", 174, 8195, 8474);
            CallChecker.varInit(this.keyType, "keyType", 174, 8195, 8474);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ReferenceMap.serialVersionUID", 174, 8195, 8474);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 175, 8416, 8418)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 175, 8416, 8418);
                CallChecker.isCalled(out, ObjectOutputStream.class, 175, 8416, 8418).defaultWriteObject();
            }
            doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2565.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2566 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 182, 8481, 8697);
            CallChecker.varInit(in, "in", 182, 8481, 8697);
            CallChecker.varInit(this.values, "values", 182, 8481, 8697);
            CallChecker.varInit(this.keySet, "keySet", 182, 8481, 8697);
            CallChecker.varInit(this.entrySet, "entrySet", 182, 8481, 8697);
            CallChecker.varInit(this.modCount, "modCount", 182, 8481, 8697);
            CallChecker.varInit(this.threshold, "threshold", 182, 8481, 8697);
            CallChecker.varInit(this.data, "data", 182, 8481, 8697);
            CallChecker.varInit(this.size, "size", 182, 8481, 8697);
            CallChecker.varInit(this.loadFactor, "loadFactor", 182, 8481, 8697);
            CallChecker.varInit(AbstractHashedMap.NULL, "org.apache.commons.collections.map.AbstractHashedMap.NULL", 182, 8481, 8697);
            CallChecker.varInit(AbstractHashedMap.MAXIMUM_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.MAXIMUM_CAPACITY", 182, 8481, 8697);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_LOAD_FACTOR, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_LOAD_FACTOR", 182, 8481, 8697);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_THRESHOLD, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_THRESHOLD", 182, 8481, 8697);
            CallChecker.varInit(AbstractHashedMap.DEFAULT_CAPACITY, "org.apache.commons.collections.map.AbstractHashedMap.DEFAULT_CAPACITY", 182, 8481, 8697);
            CallChecker.varInit(AbstractHashedMap.SETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.SETVALUE_INVALID", 182, 8481, 8697);
            CallChecker.varInit(AbstractHashedMap.GETVALUE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETVALUE_INVALID", 182, 8481, 8697);
            CallChecker.varInit(AbstractHashedMap.GETKEY_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.GETKEY_INVALID", 182, 8481, 8697);
            CallChecker.varInit(AbstractHashedMap.REMOVE_INVALID, "org.apache.commons.collections.map.AbstractHashedMap.REMOVE_INVALID", 182, 8481, 8697);
            CallChecker.varInit(AbstractHashedMap.NO_PREVIOUS_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_PREVIOUS_ENTRY", 182, 8481, 8697);
            CallChecker.varInit(AbstractHashedMap.NO_NEXT_ENTRY, "org.apache.commons.collections.map.AbstractHashedMap.NO_NEXT_ENTRY", 182, 8481, 8697);
            CallChecker.varInit(this.purgeValues, "purgeValues", 182, 8481, 8697);
            CallChecker.varInit(this.valueType, "valueType", 182, 8481, 8697);
            CallChecker.varInit(this.keyType, "keyType", 182, 8481, 8697);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.ReferenceMap.serialVersionUID", 182, 8481, 8697);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 183, 8643, 8644)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 183, 8643, 8644);
                CallChecker.isCalled(in, ObjectInputStream.class, 183, 8643, 8644).defaultReadObject();
            }
            doReadObject(in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2566.methodEnd();
        }
    }
}

