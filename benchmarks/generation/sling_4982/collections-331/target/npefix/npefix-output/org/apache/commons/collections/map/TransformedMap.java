package org.apache.commons.collections.map;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import org.apache.commons.collections.IterableMap;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransformedMap<K, V> extends AbstractInputCheckedMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7023152376788900464L;

    protected final Transformer<? super K, ? extends K> keyTransformer;

    protected final Transformer<? super V, ? extends V> valueTransformer;

    public static <K, V> IterableMap<K, V> decorate(Map<K, V> map, Transformer<? super K, ? extends K> keyTransformer, Transformer<? super V, ? extends V> valueTransformer) {
        MethodContext _bcornu_methode_context1019 = new MethodContext(IterableMap.class);
        try {
            CallChecker.varInit(valueTransformer, "valueTransformer", 75, 2646, 3487);
            CallChecker.varInit(keyTransformer, "keyTransformer", 75, 2646, 3487);
            CallChecker.varInit(map, "map", 75, 2646, 3487);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedMap.serialVersionUID", 75, 2646, 3487);
            return new TransformedMap<K, V>(map, keyTransformer, valueTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1019.methodEnd();
        }
    }

    public static <K, V> Map<K, V> decorateTransform(Map<K, V> map, Transformer<? super K, ? extends K> keyTransformer, Transformer<? super V, ? extends V> valueTransformer) {
        MethodContext _bcornu_methode_context1020 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(valueTransformer, "valueTransformer", 95, 3494, 4722);
            CallChecker.varInit(keyTransformer, "keyTransformer", 95, 3494, 4722);
            CallChecker.varInit(map, "map", 95, 3494, 4722);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedMap.serialVersionUID", 95, 3494, 4722);
            TransformedMap<K, V> decorated = CallChecker.varInit(new TransformedMap<K, V>(map, keyTransformer, valueTransformer), "decorated", 98, 4370, 4466);
            if (CallChecker.beforeDeref(map, Map.class, 99, 4480, 4482)) {
                map = CallChecker.beforeCalled(map, Map.class, 99, 4480, 4482);
                if ((CallChecker.isCalled(map, Map.class, 99, 4480, 4482).size()) > 0) {
                    Map<K, V> transformed = CallChecker.init(Map.class);
                    if (CallChecker.beforeDeref(decorated, TransformedMap.class, 100, 4534, 4542)) {
                        decorated = CallChecker.beforeCalled(decorated, TransformedMap.class, 100, 4534, 4542);
                        transformed = CallChecker.isCalled(decorated, TransformedMap.class, 100, 4534, 4542).transformMap(map);
                        CallChecker.varAssign(transformed, "transformed", 100, 4534, 4542);
                    }
                    if (CallChecker.beforeDeref(decorated, TransformedMap.class, 101, 4575, 4583)) {
                        decorated = CallChecker.beforeCalled(decorated, TransformedMap.class, 101, 4575, 4583);
                        CallChecker.isCalled(decorated, TransformedMap.class, 101, 4575, 4583).clear();
                    }
                    if (CallChecker.beforeDeref(decorated, TransformedMap.class, 102, 4606, 4614)) {
                        decorated = CallChecker.beforeCalled(decorated, TransformedMap.class, 102, 4606, 4614);
                        final Map<K, V> npe_invocation_var226 = CallChecker.isCalled(decorated, TransformedMap.class, 102, 4606, 4614).decorated();
                        if (CallChecker.beforeDeref(npe_invocation_var226, Map.class, 102, 4606, 4626)) {
                            CallChecker.isCalled(npe_invocation_var226, Map.class, 102, 4606, 4626).putAll(transformed);
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return decorated;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1020.methodEnd();
        }
    }

    protected TransformedMap(Map<K, V> map, Transformer<? super K, ? extends K> keyTransformer, Transformer<? super V, ? extends V> valueTransformer) {
        super(map);
        MethodContext _bcornu_methode_context196 = new MethodContext(null);
        try {
            this.keyTransformer = keyTransformer;
            CallChecker.varAssign(this.keyTransformer, "this.keyTransformer", 122, 5494, 5530);
            this.valueTransformer = valueTransformer;
            CallChecker.varAssign(this.valueTransformer, "this.valueTransformer", 123, 5540, 5580);
        } finally {
            _bcornu_methode_context196.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1021 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 134, 5593, 5983);
            CallChecker.varInit(out, "out", 134, 5593, 5983);
            CallChecker.varInit(this.map, "map", 134, 5593, 5983);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 134, 5593, 5983);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 134, 5593, 5983);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedMap.serialVersionUID", 134, 5593, 5983);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 135, 5923, 5925)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 135, 5923, 5925);
                CallChecker.isCalled(out, ObjectOutputStream.class, 135, 5923, 5925).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 136, 5957, 5959)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 136, 5957, 5959);
                CallChecker.isCalled(out, ObjectOutputStream.class, 136, 5957, 5959).writeObject(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1021.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1022 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 148, 5990, 6464);
            CallChecker.varInit(in, "in", 148, 5990, 6464);
            CallChecker.varInit(this.map, "map", 148, 5990, 6464);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 148, 5990, 6464);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 148, 5990, 6464);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedMap.serialVersionUID", 148, 5990, 6464);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 149, 6386, 6387)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 149, 6386, 6387);
                CallChecker.isCalled(in, ObjectInputStream.class, 149, 6386, 6387).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 150, 6436, 6437)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 150, 6436, 6437);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 150, 6436, 6437).readObject()));
                CallChecker.varAssign(this.map, "this.map", 150, 6418, 6451);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1022.methodEnd();
        }
    }

    protected K transformKey(K object) {
        if ((keyTransformer) == null) {
            return object;
        }
        return keyTransformer.transform(object);
    }

    protected V transformValue(V object) {
        if ((valueTransformer) == null) {
            return object;
        }
        return valueTransformer.transform(object);
    }

    @SuppressWarnings(value = "unchecked")
    protected Map<K, V> transformMap(Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context1025 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 193, 7321, 7966);
            CallChecker.varInit(map, "map", 193, 7321, 7966);
            CallChecker.varInit(this.map, "map", 193, 7321, 7966);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 193, 7321, 7966);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 193, 7321, 7966);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedMap.serialVersionUID", 193, 7321, 7966);
            if (CallChecker.beforeDeref(map, Map.class, 194, 7642, 7644)) {
                map = CallChecker.beforeCalled(map, Map.class, 194, 7642, 7644);
                if (CallChecker.isCalled(map, Map.class, 194, 7642, 7644).isEmpty()) {
                    return ((Map<K, V>) (map));
                }
            }else
                throw new AbnormalExecutionError();
            
            Map<K, V> result = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(map, Map.class, 197, 7752, 7754)) {
                map = CallChecker.beforeCalled(map, Map.class, 197, 7752, 7754);
                result = new LinkedMap<K, V>(CallChecker.isCalled(map, Map.class, 197, 7752, 7754).size());
                CallChecker.varAssign(result, "result", 197, 7752, 7754);
            }
            map = CallChecker.beforeCalled(map, Map.class, 199, 7823, 7825);
            for (Map.Entry<? extends K, ? extends V> entry : CallChecker.isCalled(map, Map.class, 199, 7823, 7825).entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 200, 7877, 7881)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 200, 7909, 7913)) {
                        if (CallChecker.beforeDeref(result, Map.class, 200, 7853, 7858)) {
                            result.put(transformKey(entry.getKey()), transformValue(entry.getValue()));
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1025.methodEnd();
        }
    }

    @Override
    protected V checkSetValue(V value) {
        if (CallChecker.beforeDeref(valueTransformer, Transformer.class, 214, 8254, 8269)) {
            return valueTransformer.transform(value);
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    protected boolean isSetValueChecking() {
        MethodContext _bcornu_methode_context1027 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 224, 8300, 8587);
            CallChecker.varInit(this.map, "map", 224, 8300, 8587);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 224, 8300, 8587);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 224, 8300, 8587);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedMap.serialVersionUID", 224, 8300, 8587);
            return (valueTransformer) != null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1027.methodEnd();
        }
    }

    @Override
    public V put(K key, V value) {
        key = transformKey(key);
        CallChecker.varAssign(key, "key", 231, 8725, 8748);
        value = transformValue(value);
        CallChecker.varAssign(value, "value", 232, 8758, 8787);
        final Map<K, V> npe_invocation_var227 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var227, Map.class, 233, 8804, 8814)) {
            return npe_invocation_var227.put(key, value);
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context1029 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 237, 8844, 9008);
            CallChecker.varInit(mapToCopy, "mapToCopy", 237, 8844, 9008);
            CallChecker.varInit(this.map, "map", 237, 8844, 9008);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 237, 8844, 9008);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 237, 8844, 9008);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedMap.serialVersionUID", 237, 8844, 9008);
            mapToCopy = transformMap(mapToCopy);
            CallChecker.varAssign(mapToCopy, "mapToCopy", 238, 8928, 8963);
            final Map<K, V> npe_invocation_var228 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var228, Map.class, 239, 8973, 8983)) {
                CallChecker.isCalled(npe_invocation_var228, Map.class, 239, 8973, 8983).putAll(mapToCopy);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1029.methodEnd();
        }
    }
}

