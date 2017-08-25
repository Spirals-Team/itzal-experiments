package org.apache.commons.collections.map;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.functors.FactoryTransformer;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class LazyMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable , Map<K, V> {
    private static final long serialVersionUID = 7990956402564206740L;

    protected final Transformer<? super K, ? extends V> factory;

    @Deprecated
    public static <K, V> Map<K, V> decorate(Map<K, V> map, Factory<? extends V> factory) {
        MethodContext _bcornu_methode_context2205 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(factory, "factory", 82, 2872, 3349);
            CallChecker.varInit(map, "map", 82, 2872, 3349);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazyMap.serialVersionUID", 82, 2872, 3349);
            return LazyMap.getLazyMap(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2205.methodEnd();
        }
    }

    public static <K, V> LazyMap<K, V> getLazyMap(Map<K, V> map, Factory<? extends V> factory) {
        MethodContext _bcornu_methode_context2206 = new MethodContext(LazyMap.class);
        try {
            CallChecker.varInit(factory, "factory", 93, 3356, 3767);
            CallChecker.varInit(map, "map", 93, 3356, 3767);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazyMap.serialVersionUID", 93, 3356, 3767);
            return new LazyMap<K, V>(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((LazyMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2206.methodEnd();
        }
    }

    @Deprecated
    public static <K, V> Map<K, V> decorate(Map<K, V> map, Transformer<? super K, ? extends V> factory) {
        MethodContext _bcornu_methode_context2207 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(factory, "factory", 106, 3774, 4270);
            CallChecker.varInit(map, "map", 106, 3774, 4270);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazyMap.serialVersionUID", 106, 3774, 4270);
            return LazyMap.getLazyMap(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2207.methodEnd();
        }
    }

    public static <V, K> LazyMap<K, V> getLazyMap(Map<K, V> map, Transformer<? super K, ? extends V> factory) {
        MethodContext _bcornu_methode_context2208 = new MethodContext(LazyMap.class);
        try {
            CallChecker.varInit(factory, "factory", 117, 4277, 4702);
            CallChecker.varInit(map, "map", 117, 4277, 4702);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazyMap.serialVersionUID", 117, 4277, 4702);
            return new LazyMap<K, V>(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((LazyMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2208.methodEnd();
        }
    }

    protected LazyMap(Map<K, V> map, Factory<? extends V> factory) {
        super(map);
        MethodContext _bcornu_methode_context416 = new MethodContext(null);
        try {
            if (factory == null) {
                throw new IllegalArgumentException("Factory must not be null");
            }
            this.factory = FactoryTransformer.getInstance(factory);
            CallChecker.varAssign(this.factory, "this.factory", 134, 5247, 5301);
        } finally {
            _bcornu_methode_context416.methodEnd();
        }
    }

    protected LazyMap(Map<K, V> map, Transformer<? super K, ? extends V> factory) {
        super(map);
        MethodContext _bcornu_methode_context417 = new MethodContext(null);
        try {
            if (factory == null) {
                throw new IllegalArgumentException("Factory must not be null");
            }
            this.factory = factory;
            CallChecker.varAssign(this.factory, "this.factory", 149, 5789, 5811);
        } finally {
            _bcornu_methode_context417.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2209 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 160, 5824, 6215);
            CallChecker.varInit(out, "out", 160, 5824, 6215);
            CallChecker.varInit(this.map, "map", 160, 5824, 6215);
            CallChecker.varInit(this.factory, "factory", 160, 5824, 6215);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazyMap.serialVersionUID", 160, 5824, 6215);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 161, 6155, 6157)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 161, 6155, 6157);
                CallChecker.isCalled(out, ObjectOutputStream.class, 161, 6155, 6157).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 162, 6189, 6191)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 162, 6189, 6191);
                CallChecker.isCalled(out, ObjectOutputStream.class, 162, 6189, 6191).writeObject(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2209.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2210 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 174, 6222, 6636);
            CallChecker.varInit(in, "in", 174, 6222, 6636);
            CallChecker.varInit(this.map, "map", 174, 6222, 6636);
            CallChecker.varInit(this.factory, "factory", 174, 6222, 6636);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazyMap.serialVersionUID", 174, 6222, 6636);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 175, 6565, 6566)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 175, 6565, 6566);
                CallChecker.isCalled(in, ObjectInputStream.class, 175, 6565, 6566).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 176, 6615, 6616)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 176, 6615, 6616);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 176, 6615, 6616).readObject()));
                CallChecker.varAssign(this.map, "this.map", 176, 6597, 6630);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2210.methodEnd();
        }
    }

    @Override
    public V get(Object key) {
        if (CallChecker.beforeDeref(map, Map.class, 183, 6841, 6843)) {
            map = CallChecker.beforeCalled(map, Map.class, 183, 6841, 6843);
            if ((CallChecker.isCalled(map, Map.class, 183, 6841, 6843).containsKey(key)) == false) {
                K castKey = CallChecker.varInit(cast(key), "castKey", 184, 6886, 6907);
                V value = CallChecker.init(null);
                if (CallChecker.beforeDeref(factory, Transformer.class, 185, 6931, 6937)) {
                    value = factory.transform(castKey);
                    CallChecker.varAssign(value, "value", 185, 6931, 6937);
                }
                if (CallChecker.beforeDeref(map, Map.class, 186, 6971, 6973)) {
                    map.put(castKey, value);
                }
                return value;
            }
        }else
            throw new AbnormalExecutionError();
        
        if (CallChecker.beforeDeref(map, Map.class, 189, 7047, 7049)) {
            return map.get(key);
        }else
            throw new AbnormalExecutionError();
        
    }

    @SuppressWarnings(value = "unchecked")
    private K cast(Object key) {
        return ((K) (key));
    }
}

