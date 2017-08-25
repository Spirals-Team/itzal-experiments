package org.apache.commons.collections.map;

import java.util.Set;
import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import org.apache.commons.collections.IterableMap;
import java.util.Iterator;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class PredicatedMap<K, V> extends AbstractInputCheckedMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 7412622456128415156L;

    protected final Predicate<? super K> keyPredicate;

    protected final Predicate<? super V> valuePredicate;

    public static <K, V> IterableMap<K, V> decorate(Map<K, V> map, Predicate<? super K> keyPredicate, Predicate<? super V> valuePredicate) {
        MethodContext _bcornu_methode_context1100 = new MethodContext(IterableMap.class);
        try {
            CallChecker.varInit(valuePredicate, "valuePredicate", 78, 2685, 3383);
            CallChecker.varInit(keyPredicate, "keyPredicate", 78, 2685, 3383);
            CallChecker.varInit(map, "map", 78, 2685, 3383);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedMap.serialVersionUID", 78, 2685, 3383);
            return new PredicatedMap<K, V>(map, keyPredicate, valuePredicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1100.methodEnd();
        }
    }

    protected PredicatedMap(Map<K, V> map, Predicate<? super K> keyPredicate, Predicate<? super V> valuePredicate) {
        super(map);
        MethodContext _bcornu_methode_context219 = new MethodContext(null);
        try {
            this.keyPredicate = keyPredicate;
            CallChecker.varAssign(this.keyPredicate, "this.keyPredicate", 93, 3964, 3996);
            this.valuePredicate = valuePredicate;
            CallChecker.varAssign(this.valuePredicate, "this.valuePredicate", 94, 4006, 4042);
            Iterator<Map.Entry<K, V>> it = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(map, Map.class, 96, 4092, 4094)) {
                map = CallChecker.beforeCalled(map, Map.class, 96, 4092, 4094);
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 96, 4092, 4094).entrySet(), Set.class, 96, 4092, 4105)) {
                    map = CallChecker.beforeCalled(map, Map.class, 96, 4092, 4094);
                    it = CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 96, 4092, 4094).entrySet(), Set.class, 96, 4092, 4105).iterator();
                    CallChecker.varAssign(it, "it", 96, 4092, 4094);
                }
            }
            it = CallChecker.beforeCalled(it, Iterator.class, 97, 4134, 4135);
            while (CallChecker.isCalled(it, Iterator.class, 97, 4134, 4135).hasNext()) {
                Map.Entry<K, V> entry = CallChecker.init(Map.Entry.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 98, 4186, 4187)) {
                    it = CallChecker.beforeCalled(it, Iterator.class, 98, 4186, 4187);
                    entry = CallChecker.isCalled(it, Iterator.class, 98, 4186, 4187).next();
                    CallChecker.varAssign(entry, "entry", 98, 4186, 4187);
                }
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 99, 4218, 4222)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 99, 4234, 4238)) {
                        validate(entry.getKey(), entry.getValue());
                    }
                }
            } 
        } finally {
            _bcornu_methode_context219.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1101 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 111, 4274, 4665);
            CallChecker.varInit(out, "out", 111, 4274, 4665);
            CallChecker.varInit(this.map, "map", 111, 4274, 4665);
            CallChecker.varInit(this.valuePredicate, "valuePredicate", 111, 4274, 4665);
            CallChecker.varInit(this.keyPredicate, "keyPredicate", 111, 4274, 4665);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedMap.serialVersionUID", 111, 4274, 4665);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 112, 4605, 4607)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 112, 4605, 4607);
                CallChecker.isCalled(out, ObjectOutputStream.class, 112, 4605, 4607).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 113, 4639, 4641)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 113, 4639, 4641);
                CallChecker.isCalled(out, ObjectOutputStream.class, 113, 4639, 4641).writeObject(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1101.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1102 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 125, 4672, 5147);
            CallChecker.varInit(in, "in", 125, 4672, 5147);
            CallChecker.varInit(this.map, "map", 125, 4672, 5147);
            CallChecker.varInit(this.valuePredicate, "valuePredicate", 125, 4672, 5147);
            CallChecker.varInit(this.keyPredicate, "keyPredicate", 125, 4672, 5147);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedMap.serialVersionUID", 125, 4672, 5147);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 126, 5069, 5070)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 126, 5069, 5070);
                CallChecker.isCalled(in, ObjectInputStream.class, 126, 5069, 5070).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 127, 5119, 5120)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 127, 5119, 5120);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 127, 5119, 5120).readObject()));
                CallChecker.varAssign(this.map, "this.map", 127, 5101, 5134);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1102.methodEnd();
        }
    }

    protected void validate(K key, V value) {
        MethodContext _bcornu_methode_context1103 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 138, 5154, 5828);
            CallChecker.varInit(value, "value", 138, 5154, 5828);
            CallChecker.varInit(key, "key", 138, 5154, 5828);
            CallChecker.varInit(this.map, "map", 138, 5154, 5828);
            CallChecker.varInit(this.valuePredicate, "valuePredicate", 138, 5154, 5828);
            CallChecker.varInit(this.keyPredicate, "keyPredicate", 138, 5154, 5828);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedMap.serialVersionUID", 138, 5154, 5828);
            if (((keyPredicate) != null) && ((keyPredicate.evaluate(key)) == false)) {
                throw new IllegalArgumentException("Cannot add key - Predicate rejected it");
            }
            if (((valuePredicate) != null) && ((valuePredicate.evaluate(value)) == false)) {
                throw new IllegalArgumentException("Cannot add value - Predicate rejected it");
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1103.methodEnd();
        }
    }

    @Override
    protected V checkSetValue(V value) {
        if (CallChecker.beforeDeref(valuePredicate, Predicate.class, 156, 6136, 6149)) {
            if ((CallChecker.isCalled(valuePredicate, Predicate.class, 156, 6136, 6149).evaluate(value)) == false) {
                throw new IllegalArgumentException("Cannot set value - Predicate rejected it");
            }
        }else
            throw new AbnormalExecutionError();
        
        return value;
    }

    @Override
    protected boolean isSetValueChecking() {
        MethodContext _bcornu_methode_context1105 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 169, 6314, 6598);
            CallChecker.varInit(this.map, "map", 169, 6314, 6598);
            CallChecker.varInit(this.valuePredicate, "valuePredicate", 169, 6314, 6598);
            CallChecker.varInit(this.keyPredicate, "keyPredicate", 169, 6314, 6598);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedMap.serialVersionUID", 169, 6314, 6598);
            return (valuePredicate) != null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1105.methodEnd();
        }
    }

    @Override
    public V put(K key, V value) {
        validate(key, value);
        if (CallChecker.beforeDeref(map, Map.class, 177, 6773, 6775)) {
            return map.put(key, value);
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context1107 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 181, 6805, 7065);
            CallChecker.varInit(mapToCopy, "mapToCopy", 181, 6805, 7065);
            CallChecker.varInit(this.map, "map", 181, 6805, 7065);
            CallChecker.varInit(this.valuePredicate, "valuePredicate", 181, 6805, 7065);
            CallChecker.varInit(this.keyPredicate, "keyPredicate", 181, 6805, 7065);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedMap.serialVersionUID", 181, 6805, 7065);
            mapToCopy = CallChecker.beforeCalled(mapToCopy, Map.class, 182, 6938, 6946);
            for (Map.Entry<? extends K, ? extends V> entry : CallChecker.isCalled(mapToCopy, Map.class, 182, 6938, 6946).entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 183, 6983, 6987)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 183, 6999, 7003)) {
                        validate(entry.getKey(), entry.getValue());
                    }
                }
            }
            super.putAll(mapToCopy);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1107.methodEnd();
        }
    }
}

