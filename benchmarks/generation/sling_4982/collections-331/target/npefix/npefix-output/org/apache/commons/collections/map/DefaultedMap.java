package org.apache.commons.collections.map;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.functors.FactoryTransformer;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.io.IOException;
import org.apache.commons.collections.IterableMap;

public class DefaultedMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 19698628745827L;

    private final Transformer<? super K, ? extends V> value;

    public static <K, V> Map<K, V> decorate(Map<K, V> map, V defaultValue) {
        MethodContext _bcornu_methode_context58 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 85, 3050, 3643);
            CallChecker.varInit(map, "map", 85, 3050, 3643);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.DefaultedMap.serialVersionUID", 85, 3050, 3643);
            return new DefaultedMap<K, V>(map, ConstantTransformer.getInstance(defaultValue));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context58.methodEnd();
        }
    }

    public static <K, V> IterableMap<K, V> decorate(Map<K, V> map, Factory<? extends V> factory) {
        MethodContext _bcornu_methode_context59 = new MethodContext(IterableMap.class);
        try {
            CallChecker.varInit(factory, "factory", 99, 3650, 4382);
            CallChecker.varInit(map, "map", 99, 3650, 4382);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.DefaultedMap.serialVersionUID", 99, 3650, 4382);
            if (factory == null) {
                throw new IllegalArgumentException("Factory must not be null");
            }
            return new DefaultedMap<K, V>(map, FactoryTransformer.getInstance(factory));
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }

    public static <K, V> Map<K, V> decorate(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        MethodContext _bcornu_methode_context60 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(transformer, "transformer", 117, 4389, 5196);
            CallChecker.varInit(map, "map", 117, 4389, 5196);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.DefaultedMap.serialVersionUID", 117, 4389, 5196);
            if (transformer == null) {
                throw new IllegalArgumentException("Transformer must not be null");
            }
            return new DefaultedMap<K, V>(map, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    public DefaultedMap(V defaultValue) {
        this(ConstantTransformer.getInstance(defaultValue));
        MethodContext _bcornu_methode_context12 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public DefaultedMap(Transformer<? super K, ? extends V> defaultValueTransformer) {
        this(new HashMap<K, V>(), defaultValueTransformer);
        MethodContext _bcornu_methode_context13 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    protected DefaultedMap(Map<K, V> map, Transformer<? super K, ? extends V> defaultValueTransformer) {
        super(map);
        MethodContext _bcornu_methode_context14 = new MethodContext(null);
        try {
            this.value = defaultValueTransformer;
            CallChecker.varAssign(this.value, "this.value", 157, 6441, 6477);
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context61 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 167, 6490, 6843);
            CallChecker.varInit(out, "out", 167, 6490, 6843);
            CallChecker.varInit(this.map, "map", 167, 6490, 6843);
            CallChecker.varInit(this.value, "value", 167, 6490, 6843);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.DefaultedMap.serialVersionUID", 167, 6490, 6843);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 168, 6783, 6785)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 168, 6783, 6785);
                CallChecker.isCalled(out, ObjectOutputStream.class, 168, 6783, 6785).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 169, 6817, 6819)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 169, 6817, 6819);
                CallChecker.isCalled(out, ObjectOutputStream.class, 169, 6817, 6819).writeObject(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context62 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 180, 6850, 7226);
            CallChecker.varInit(in, "in", 180, 6850, 7226);
            CallChecker.varInit(this.map, "map", 180, 6850, 7226);
            CallChecker.varInit(this.value, "value", 180, 6850, 7226);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.DefaultedMap.serialVersionUID", 180, 6850, 7226);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 181, 7155, 7156)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 181, 7155, 7156);
                CallChecker.isCalled(in, ObjectInputStream.class, 181, 7155, 7156).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 182, 7205, 7206)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 182, 7205, 7206);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 182, 7205, 7206).readObject()));
                CallChecker.varAssign(this.map, "this.map", 182, 7187, 7220);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public V get(Object key) {
        if (CallChecker.beforeDeref(map, Map.class, 190, 7466, 7468)) {
            map = CallChecker.beforeCalled(map, Map.class, 190, 7466, 7468);
            if ((CallChecker.isCalled(map, Map.class, 190, 7466, 7468).containsKey(key)) == false) {
                if (CallChecker.beforeDeref(value, Transformer.class, 191, 7518, 7522)) {
                    return value.transform(((K) (key)));
                }else
                    throw new AbnormalExecutionError();
                
            }
        }else
            throw new AbnormalExecutionError();
        
        if (CallChecker.beforeDeref(map, Map.class, 193, 7569, 7571)) {
            return map.get(key);
        }else
            throw new AbnormalExecutionError();
        
    }
}

