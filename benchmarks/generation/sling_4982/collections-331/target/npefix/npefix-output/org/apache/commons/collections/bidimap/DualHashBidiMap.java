package org.apache.commons.collections.bidimap;

import java.io.Serializable;
import org.apache.commons.collections.BidiMap;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.io.IOException;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DualHashBidiMap<K, V> extends AbstractDualBidiMap<K, V> implements Serializable {
    private static final long serialVersionUID = 721969328361808L;

    public DualHashBidiMap() {
        super(new HashMap<K, V>(), new HashMap<V, K>());
        MethodContext _bcornu_methode_context202 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context202.methodEnd();
        }
    }

    public DualHashBidiMap(Map<K, V> map) {
        super(new HashMap<K, V>(), new HashMap<V, K>());
        MethodContext _bcornu_methode_context203 = new MethodContext(null);
        try {
            putAll(map);
        } finally {
            _bcornu_methode_context203.methodEnd();
        }
    }

    protected DualHashBidiMap(Map<K, V> normalMap, Map<V, K> reverseMap, BidiMap<V, K> inverseBidiMap) {
        super(normalMap, reverseMap, inverseBidiMap);
        MethodContext _bcornu_methode_context204 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context204.methodEnd();
        }
    }

    @Override
    protected BidiMap<V, K> createBidiMap(Map<V, K> normalMap, Map<K, V> reverseMap, BidiMap<K, V> inverseBidiMap) {
        MethodContext _bcornu_methode_context1050 = new MethodContext(BidiMap.class);
        try {
            CallChecker.varInit(this, "this", 88, 2911, 3373);
            CallChecker.varInit(inverseBidiMap, "inverseBidiMap", 88, 2911, 3373);
            CallChecker.varInit(reverseMap, "reverseMap", 88, 2911, 3373);
            CallChecker.varInit(normalMap, "normalMap", 88, 2911, 3373);
            CallChecker.varInit(this.entrySet, "entrySet", 88, 2911, 3373);
            CallChecker.varInit(this.values, "values", 88, 2911, 3373);
            CallChecker.varInit(this.keySet, "keySet", 88, 2911, 3373);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 88, 2911, 3373);
            CallChecker.varInit(this.reverseMap, "reverseMap", 88, 2911, 3373);
            CallChecker.varInit(this.normalMap, "normalMap", 88, 2911, 3373);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualHashBidiMap.serialVersionUID", 88, 2911, 3373);
            return new DualHashBidiMap<V, K>(normalMap, reverseMap, inverseBidiMap);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1050.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1051 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 94, 3380, 3623);
            CallChecker.varInit(out, "out", 94, 3380, 3623);
            CallChecker.varInit(this.entrySet, "entrySet", 94, 3380, 3623);
            CallChecker.varInit(this.values, "values", 94, 3380, 3623);
            CallChecker.varInit(this.keySet, "keySet", 94, 3380, 3623);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 94, 3380, 3623);
            CallChecker.varInit(this.reverseMap, "reverseMap", 94, 3380, 3623);
            CallChecker.varInit(this.normalMap, "normalMap", 94, 3380, 3623);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualHashBidiMap.serialVersionUID", 94, 3380, 3623);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 95, 3557, 3559)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 95, 3557, 3559);
                CallChecker.isCalled(out, ObjectOutputStream.class, 95, 3557, 3559).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 96, 3591, 3593)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 96, 3591, 3593);
                CallChecker.isCalled(out, ObjectOutputStream.class, 96, 3591, 3593).writeObject(normalMap);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1051.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1052 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 99, 3630, 4000);
            CallChecker.varInit(in, "in", 99, 3630, 4000);
            CallChecker.varInit(this.entrySet, "entrySet", 99, 3630, 4000);
            CallChecker.varInit(this.values, "values", 99, 3630, 4000);
            CallChecker.varInit(this.keySet, "keySet", 99, 3630, 4000);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 99, 3630, 4000);
            CallChecker.varInit(this.reverseMap, "reverseMap", 99, 3630, 4000);
            CallChecker.varInit(this.normalMap, "normalMap", 99, 3630, 4000);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualHashBidiMap.serialVersionUID", 99, 3630, 4000);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 100, 3729, 3730)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 100, 3729, 3730);
                CallChecker.isCalled(in, ObjectInputStream.class, 100, 3729, 3730).defaultReadObject();
            }
            normalMap = new HashMap<K, V>();
            CallChecker.varAssign(this.normalMap, "this.normalMap", 101, 3761, 3792);
            reverseMap = new HashMap<V, K>();
            CallChecker.varAssign(this.reverseMap, "this.reverseMap", 102, 3802, 3834);
            Map<K, V> map = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 104, 3958, 3959)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 104, 3958, 3959);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 104, 3958, 3959).readObject()));
                CallChecker.varAssign(map, "map", 104, 3958, 3959);
            }
            putAll(map);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1052.methodEnd();
        }
    }
}

