package org.apache.commons.collections.splitmap;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import org.apache.commons.collections.Put;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import org.apache.commons.collections.map.LinkedMap;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransformedMap<J, K, U, V> extends AbstractIterableGetMapDecorator<K, V> implements Serializable , Put<J, U> {
    private static final long serialVersionUID = 5966875321133456994L;

    private final Transformer<? super J, ? extends K> keyTransformer;

    private final Transformer<? super U, ? extends V> valueTransformer;

    public static <J, K, U, V> TransformedMap<J, K, U, V> decorate(Map<K, V> map, Transformer<? super J, ? extends K> keyTransformer, Transformer<? super U, ? extends V> valueTransformer) {
        MethodContext _bcornu_methode_context1009 = new MethodContext(TransformedMap.class);
        try {
            CallChecker.varInit(valueTransformer, "valueTransformer", 87, 3333, 4152);
            CallChecker.varInit(keyTransformer, "keyTransformer", 87, 3333, 4152);
            CallChecker.varInit(map, "map", 87, 3333, 4152);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.splitmap.TransformedMap.serialVersionUID", 87, 3333, 4152);
            return new TransformedMap<J, K, U, V>(map, keyTransformer, valueTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((TransformedMap<J, K, U, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1009.methodEnd();
        }
    }

    protected TransformedMap(Map<K, V> map, Transformer<? super J, ? extends K> keyTransformer, Transformer<? super U, ? extends V> valueTransformer) {
        super(map);
        MethodContext _bcornu_methode_context195 = new MethodContext(null);
        try {
            if (keyTransformer == null) {
                throw new IllegalArgumentException("keyTransformer cannot be null");
            }
            this.keyTransformer = keyTransformer;
            CallChecker.varAssign(this.keyTransformer, "this.keyTransformer", 113, 5064, 5100);
            if (valueTransformer == null) {
                throw new IllegalArgumentException("valueTransformer cannot be null");
            }
            this.valueTransformer = valueTransformer;
            CallChecker.varAssign(this.valueTransformer, "this.valueTransformer", 117, 5243, 5283);
        } finally {
            _bcornu_methode_context195.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1010 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 127, 5296, 5655);
            CallChecker.varInit(out, "out", 127, 5296, 5655);
            CallChecker.varInit(this.map, "map", 127, 5296, 5655);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 127, 5296, 5655);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 127, 5296, 5655);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.splitmap.TransformedMap.serialVersionUID", 127, 5296, 5655);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 128, 5587, 5589)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 128, 5587, 5589);
                CallChecker.isCalled(out, ObjectOutputStream.class, 128, 5587, 5589).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 129, 5621, 5623)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 129, 5621, 5623);
                CallChecker.isCalled(out, ObjectOutputStream.class, 129, 5621, 5623).writeObject(decorated());
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1010.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1011 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 141, 5662, 6135);
            CallChecker.varInit(in, "in", 141, 5662, 6135);
            CallChecker.varInit(this.map, "map", 141, 5662, 6135);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 141, 5662, 6135);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 141, 5662, 6135);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.splitmap.TransformedMap.serialVersionUID", 141, 5662, 6135);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 142, 6057, 6058)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 142, 6057, 6058);
                CallChecker.isCalled(in, ObjectInputStream.class, 142, 6057, 6058).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 143, 6107, 6108)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 143, 6107, 6108);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 143, 6107, 6108).readObject()));
                CallChecker.varAssign(this.map, "this.map", 143, 6089, 6122);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1011.methodEnd();
        }
    }

    protected K transformKey(J object) {
        if (CallChecker.beforeDeref(keyTransformer, Transformer.class, 156, 6481, 6494)) {
            return keyTransformer.transform(object);
        }else
            throw new AbnormalExecutionError();
        
    }

    protected V transformValue(U object) {
        if (CallChecker.beforeDeref(valueTransformer, Transformer.class, 168, 6791, 6806)) {
            return valueTransformer.transform(object);
        }else
            throw new AbnormalExecutionError();
        
    }

    @SuppressWarnings(value = "unchecked")
    protected Map<K, V> transformMap(Map<? extends J, ? extends U> map) {
        MethodContext _bcornu_methode_context1014 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 180, 6838, 7482);
            CallChecker.varInit(map, "map", 180, 6838, 7482);
            CallChecker.varInit(this.map, "map", 180, 6838, 7482);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 180, 6838, 7482);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 180, 6838, 7482);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.splitmap.TransformedMap.serialVersionUID", 180, 6838, 7482);
            if (CallChecker.beforeDeref(map, Map.class, 181, 7158, 7160)) {
                map = CallChecker.beforeCalled(map, Map.class, 181, 7158, 7160);
                if (CallChecker.isCalled(map, Map.class, 181, 7158, 7160).isEmpty()) {
                    return ((Map<K, V>) (map));
                }
            }else
                throw new AbnormalExecutionError();
            
            Map<K, V> result = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(map, Map.class, 184, 7268, 7270)) {
                map = CallChecker.beforeCalled(map, Map.class, 184, 7268, 7270);
                result = new LinkedMap<K, V>(CallChecker.isCalled(map, Map.class, 184, 7268, 7270).size());
                CallChecker.varAssign(result, "result", 184, 7268, 7270);
            }
            map = CallChecker.beforeCalled(map, Map.class, 186, 7339, 7341);
            for (Map.Entry<? extends J, ? extends U> entry : CallChecker.isCalled(map, Map.class, 186, 7339, 7341).entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 187, 7393, 7397)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 187, 7425, 7429)) {
                        if (CallChecker.beforeDeref(result, Map.class, 187, 7369, 7374)) {
                            result.put(transformKey(entry.getKey()), transformValue(entry.getValue()));
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1014.methodEnd();
        }
    }

    protected V checkSetValue(U value) {
        if (CallChecker.beforeDeref(valueTransformer, Transformer.class, 199, 7717, 7732)) {
            return valueTransformer.transform(value);
        }else
            throw new AbnormalExecutionError();
        
    }

    public V put(J key, U value) {
        final Map<K, V> npe_invocation_var223 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var223, Map.class, 207, 7924, 7934)) {
            return npe_invocation_var223.put(transformKey(key), transformValue(value));
        }else
            throw new AbnormalExecutionError();
        
    }

    public void putAll(Map<? extends J, ? extends U> mapToCopy) {
        MethodContext _bcornu_methode_context1017 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 213, 7994, 8150);
            CallChecker.varInit(mapToCopy, "mapToCopy", 213, 7994, 8150);
            CallChecker.varInit(this.map, "map", 213, 7994, 8150);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 213, 7994, 8150);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 213, 7994, 8150);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.splitmap.TransformedMap.serialVersionUID", 213, 7994, 8150);
            final Map<K, V> npe_invocation_var224 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var224, Map.class, 214, 8101, 8111)) {
                CallChecker.isCalled(npe_invocation_var224, Map.class, 214, 8101, 8111).putAll(transformMap(mapToCopy));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1017.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context1018 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 220, 8157, 8249);
            CallChecker.varInit(this.map, "map", 220, 8157, 8249);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 220, 8157, 8249);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 220, 8157, 8249);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.splitmap.TransformedMap.serialVersionUID", 220, 8157, 8249);
            final Map<K, V> npe_invocation_var225 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var225, Map.class, 221, 8224, 8234)) {
                CallChecker.isCalled(npe_invocation_var225, Map.class, 221, 8224, 8234).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1018.methodEnd();
        }
    }
}

