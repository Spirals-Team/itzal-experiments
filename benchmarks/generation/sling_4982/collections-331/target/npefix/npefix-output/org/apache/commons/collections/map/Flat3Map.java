package org.apache.commons.collections.map;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.Set;
import java.io.Serializable;
import org.apache.commons.collections.ResettableIterator;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import org.apache.commons.collections.iterators.EmptyMapIterator;
import org.apache.commons.collections.iterators.EmptyIterator;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.AbstractSet;
import java.util.AbstractCollection;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import org.apache.commons.collections.IterableMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;

public class Flat3Map<K, V> implements Serializable , Cloneable , IterableMap<K, V> {
    private static final long serialVersionUID = -6701087419741928296L;

    private transient int size;

    private transient int hash1;

    private transient int hash2;

    private transient int hash3;

    private transient K key1;

    private transient K key2;

    private transient K key3;

    private transient V value1;

    private transient V value2;

    private transient V value3;

    private transient AbstractHashedMap<K, V> delegateMap;

    public Flat3Map() {
        super();
        MethodContext _bcornu_methode_context243 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context243.methodEnd();
        }
    }

    public Flat3Map(Map<? extends K, ? extends V> map) {
        super();
        MethodContext _bcornu_methode_context244 = new MethodContext(null);
        try {
            putAll(map);
        } finally {
            _bcornu_methode_context244.methodEnd();
        }
    }

    public V get(Object key) {
        if ((delegateMap) != null) {
            return delegateMap.get(key);
        }
        if (key == null) {
            switch (size) {
                case 3 :
                    if ((key3) == null)
                        return value3;
                    
                case 2 :
                    if ((key2) == null)
                        return value2;
                    
                case 1 :
                    if ((key1) == null)
                        return value1;
                    
            }
        }else {
            if ((size) > 0) {
                int hashCode = CallChecker.varInit(((int) (key.hashCode())), "hashCode", 144, 5533, 5562);
                switch (size) {
                    case 3 :
                        if (((hash3) == hashCode) && (key.equals(key3)))
                            return value3;
                        
                    case 2 :
                        if (((hash2) == hashCode) && (key.equals(key2)))
                            return value2;
                        
                    case 1 :
                        if (((hash1) == hashCode) && (key.equals(key1)))
                            return value1;
                        
                }
            }
        }
        return null;
    }

    public int size() {
        MethodContext _bcornu_methode_context1217 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 164, 6036, 6245);
            CallChecker.varInit(this.delegateMap, "delegateMap", 164, 6036, 6245);
            CallChecker.varInit(this.value3, "value3", 164, 6036, 6245);
            CallChecker.varInit(this.value2, "value2", 164, 6036, 6245);
            CallChecker.varInit(this.value1, "value1", 164, 6036, 6245);
            CallChecker.varInit(this.key3, "key3", 164, 6036, 6245);
            CallChecker.varInit(this.key2, "key2", 164, 6036, 6245);
            CallChecker.varInit(this.key1, "key1", 164, 6036, 6245);
            CallChecker.varInit(this.hash3, "hash3", 164, 6036, 6245);
            CallChecker.varInit(this.hash2, "hash2", 164, 6036, 6245);
            CallChecker.varInit(this.hash1, "hash1", 164, 6036, 6245);
            CallChecker.varInit(this.size, "size", 164, 6036, 6245);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 164, 6036, 6245);
            if ((delegateMap) != null) {
                return delegateMap.size();
            }
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1217.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1218 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 176, 6252, 6440);
            CallChecker.varInit(this.delegateMap, "delegateMap", 176, 6252, 6440);
            CallChecker.varInit(this.value3, "value3", 176, 6252, 6440);
            CallChecker.varInit(this.value2, "value2", 176, 6252, 6440);
            CallChecker.varInit(this.value1, "value1", 176, 6252, 6440);
            CallChecker.varInit(this.key3, "key3", 176, 6252, 6440);
            CallChecker.varInit(this.key2, "key2", 176, 6252, 6440);
            CallChecker.varInit(this.key1, "key1", 176, 6252, 6440);
            CallChecker.varInit(this.hash3, "hash3", 176, 6252, 6440);
            CallChecker.varInit(this.hash2, "hash2", 176, 6252, 6440);
            CallChecker.varInit(this.hash1, "hash1", 176, 6252, 6440);
            CallChecker.varInit(this.size, "size", 176, 6252, 6440);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 176, 6252, 6440);
            return (size()) == 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1218.methodEnd();
        }
    }

    public boolean containsKey(Object key) {
        MethodContext _bcornu_methode_context1219 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 187, 6447, 7674);
            CallChecker.varInit(key, "key", 187, 6447, 7674);
            CallChecker.varInit(this.delegateMap, "delegateMap", 187, 6447, 7674);
            CallChecker.varInit(this.value3, "value3", 187, 6447, 7674);
            CallChecker.varInit(this.value2, "value2", 187, 6447, 7674);
            CallChecker.varInit(this.value1, "value1", 187, 6447, 7674);
            CallChecker.varInit(this.key3, "key3", 187, 6447, 7674);
            CallChecker.varInit(this.key2, "key2", 187, 6447, 7674);
            CallChecker.varInit(this.key1, "key1", 187, 6447, 7674);
            CallChecker.varInit(this.hash3, "hash3", 187, 6447, 7674);
            CallChecker.varInit(this.hash2, "hash2", 187, 6447, 7674);
            CallChecker.varInit(this.hash1, "hash1", 187, 6447, 7674);
            CallChecker.varInit(this.size, "size", 187, 6447, 7674);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 187, 6447, 7674);
            if ((delegateMap) != null) {
                return delegateMap.containsKey(key);
            }
            if (key == null) {
                switch (size) {
                    case 3 :
                        if ((key3) == null)
                            return true;
                        
                    case 2 :
                        if ((key2) == null)
                            return true;
                        
                    case 1 :
                        if ((key1) == null)
                            return true;
                        
                }
            }else {
                if ((size) > 0) {
                    int hashCode = CallChecker.varInit(((int) (key.hashCode())), "hashCode", 202, 7202, 7231);
                    switch (size) {
                        case 3 :
                            if (((hash3) == hashCode) && (key.equals(key3)))
                                return true;
                            
                        case 2 :
                            if (((hash2) == hashCode) && (key.equals(key2)))
                                return true;
                            
                        case 1 :
                            if (((hash1) == hashCode) && (key.equals(key1)))
                                return true;
                            
                    }
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1219.methodEnd();
        }
    }

    public boolean containsValue(Object value) {
        MethodContext _bcornu_methode_context1220 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 222, 7681, 8680);
            CallChecker.varInit(value, "value", 222, 7681, 8680);
            CallChecker.varInit(this.delegateMap, "delegateMap", 222, 7681, 8680);
            CallChecker.varInit(this.value3, "value3", 222, 7681, 8680);
            CallChecker.varInit(this.value2, "value2", 222, 7681, 8680);
            CallChecker.varInit(this.value1, "value1", 222, 7681, 8680);
            CallChecker.varInit(this.key3, "key3", 222, 7681, 8680);
            CallChecker.varInit(this.key2, "key2", 222, 7681, 8680);
            CallChecker.varInit(this.key1, "key1", 222, 7681, 8680);
            CallChecker.varInit(this.hash3, "hash3", 222, 7681, 8680);
            CallChecker.varInit(this.hash2, "hash2", 222, 7681, 8680);
            CallChecker.varInit(this.hash1, "hash1", 222, 7681, 8680);
            CallChecker.varInit(this.size, "size", 222, 7681, 8680);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 222, 7681, 8680);
            if ((delegateMap) != null) {
                return delegateMap.containsValue(value);
            }
            if (value == null) {
                switch (size) {
                    case 3 :
                        if ((value3) == null)
                            return true;
                        
                    case 2 :
                        if ((value2) == null)
                            return true;
                        
                    case 1 :
                        if ((value1) == null)
                            return true;
                        
                }
            }else {
                switch (size) {
                    case 3 :
                        if (value.equals(value3))
                            return true;
                        
                    case 2 :
                        if (value.equals(value2))
                            return true;
                        
                    case 1 :
                        if (value.equals(value1))
                            return true;
                        
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1220.methodEnd();
        }
    }

    public V put(K key, V value) {
        if ((delegateMap) != null) {
            return delegateMap.put(key, value);
        }
        if (key == null) {
            switch (size) {
                case 3 :
                    if ((key3) == null) {
                        V old = CallChecker.varInit(value3, "old", 265, 9295, 9309);
                        value3 = value;
                        CallChecker.varAssign(this.value3, "this.value3", 266, 9335, 9349);
                        return old;
                    }
                case 2 :
                    if ((key2) == null) {
                        V old = CallChecker.varInit(value2, "old", 271, 9497, 9511);
                        value2 = value;
                        CallChecker.varAssign(this.value2, "this.value2", 272, 9537, 9551);
                        return old;
                    }
                case 1 :
                    if ((key1) == null) {
                        V old = CallChecker.varInit(value1, "old", 277, 9699, 9713);
                        value1 = value;
                        CallChecker.varAssign(this.value1, "this.value1", 278, 9739, 9753);
                        return old;
                    }
            }
        }else {
            if ((size) > 0) {
                int hashCode = CallChecker.varInit(((int) (key.hashCode())), "hashCode", 284, 9888, 9917);
                switch (size) {
                    case 3 :
                        if (((hash3) == hashCode) && (key.equals(key3))) {
                            V old = CallChecker.varInit(value3, "old", 288, 10093, 10107);
                            value3 = value;
                            CallChecker.varAssign(this.value3, "this.value3", 289, 10137, 10151);
                            return old;
                        }
                    case 2 :
                        if (((hash2) == hashCode) && (key.equals(key2))) {
                            V old = CallChecker.varInit(value2, "old", 294, 10344, 10358);
                            value2 = value;
                            CallChecker.varAssign(this.value2, "this.value2", 295, 10388, 10402);
                            return old;
                        }
                    case 1 :
                        if (((hash1) == hashCode) && (key.equals(key1))) {
                            V old = CallChecker.varInit(value1, "old", 300, 10595, 10609);
                            value1 = value;
                            CallChecker.varAssign(this.value1, "this.value1", 301, 10639, 10653);
                            return old;
                        }
                }
            }
        }
        switch (size) {
            default :
                convertToMap();
                if (CallChecker.beforeDeref(delegateMap, AbstractHashedMap.class, 312, 10884, 10894)) {
                    delegateMap.put(key, value);
                }else
                    throw new AbnormalExecutionError();
                
                return null;
            case 2 :
                if (key == null) {
                    hash3 = 0;
                    CallChecker.varAssign(this.hash3, "this.hash3", 315, 10978, 11020);
                }else {
                    hash3 = key.hashCode();
                    CallChecker.varAssign(this.hash3, "this.hash3", 315, 10978, 11020);
                }
                key3 = key;
                CallChecker.varAssign(this.key3, "this.key3", 316, 11038, 11048);
                value3 = value;
                CallChecker.varAssign(this.value3, "this.value3", 317, 11066, 11080);
                break;
            case 1 :
                if (key == null) {
                    hash2 = 0;
                    CallChecker.varAssign(this.hash2, "this.hash2", 320, 11141, 11183);
                }else {
                    hash2 = key.hashCode();
                    CallChecker.varAssign(this.hash2, "this.hash2", 320, 11141, 11183);
                }
                key2 = key;
                CallChecker.varAssign(this.key2, "this.key2", 321, 11201, 11211);
                value2 = value;
                CallChecker.varAssign(this.value2, "this.value2", 322, 11229, 11243);
                break;
            case 0 :
                if (key == null) {
                    hash1 = 0;
                    CallChecker.varAssign(this.hash1, "this.hash1", 325, 11304, 11346);
                }else {
                    hash1 = key.hashCode();
                    CallChecker.varAssign(this.hash1, "this.hash1", 325, 11304, 11346);
                }
                key1 = key;
                CallChecker.varAssign(this.key1, "this.key1", 326, 11364, 11374);
                value1 = value;
                CallChecker.varAssign(this.value1, "this.value1", 327, 11392, 11406);
                break;
        }
        (size)++;
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context1222 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 340, 11489, 12178);
            CallChecker.varInit(map, "map", 340, 11489, 12178);
            CallChecker.varInit(this.delegateMap, "delegateMap", 340, 11489, 12178);
            CallChecker.varInit(this.value3, "value3", 340, 11489, 12178);
            CallChecker.varInit(this.value2, "value2", 340, 11489, 12178);
            CallChecker.varInit(this.value1, "value1", 340, 11489, 12178);
            CallChecker.varInit(this.key3, "key3", 340, 11489, 12178);
            CallChecker.varInit(this.key2, "key2", 340, 11489, 12178);
            CallChecker.varInit(this.key1, "key1", 340, 11489, 12178);
            CallChecker.varInit(this.hash3, "hash3", 340, 11489, 12178);
            CallChecker.varInit(this.hash2, "hash2", 340, 11489, 12178);
            CallChecker.varInit(this.hash1, "hash1", 340, 11489, 12178);
            CallChecker.varInit(this.size, "size", 340, 11489, 12178);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 340, 11489, 12178);
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(map, Map.class, 341, 11741, 11743)) {
                map = CallChecker.beforeCalled(map, Map.class, 341, 11741, 11743);
                size = CallChecker.isCalled(map, Map.class, 341, 11741, 11743).size();
                CallChecker.varAssign(size, "size", 341, 11741, 11743);
            }
            if (size == 0) {
                return ;
            }
            if ((delegateMap) != null) {
                delegateMap.putAll(map);
                return ;
            }
            if (size < 4) {
                map = CallChecker.beforeCalled(map, Map.class, 350, 11995, 11997);
                for (Map.Entry<? extends K, ? extends V> entry : CallChecker.isCalled(map, Map.class, 350, 11995, 11997).entrySet()) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 351, 12033, 12037)) {
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 351, 12049, 12053)) {
                            put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            }else {
                convertToMap();
                if (CallChecker.beforeDeref(delegateMap, AbstractHashedMap.class, 355, 12139, 12149)) {
                    delegateMap = CallChecker.beforeCalled(delegateMap, AbstractHashedMap.class, 355, 12139, 12149);
                    CallChecker.isCalled(delegateMap, AbstractHashedMap.class, 355, 12139, 12149).putAll(map);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1222.methodEnd();
        }
    }

    private void convertToMap() {
        MethodContext _bcornu_methode_context1223 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 362, 12185, 12704);
            CallChecker.varInit(this.delegateMap, "delegateMap", 362, 12185, 12704);
            CallChecker.varInit(this.value3, "value3", 362, 12185, 12704);
            CallChecker.varInit(this.value2, "value2", 362, 12185, 12704);
            CallChecker.varInit(this.value1, "value1", 362, 12185, 12704);
            CallChecker.varInit(this.key3, "key3", 362, 12185, 12704);
            CallChecker.varInit(this.key2, "key2", 362, 12185, 12704);
            CallChecker.varInit(this.key1, "key1", 362, 12185, 12704);
            CallChecker.varInit(this.hash3, "hash3", 362, 12185, 12704);
            CallChecker.varInit(this.hash2, "hash2", 362, 12185, 12704);
            CallChecker.varInit(this.hash1, "hash1", 362, 12185, 12704);
            CallChecker.varInit(this.size, "size", 362, 12185, 12704);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 362, 12185, 12704);
            delegateMap = createDelegateMap();
            CallChecker.varAssign(this.delegateMap, "this.delegateMap", 363, 12283, 12316);
            switch (size) {
                case 3 :
                    if (CallChecker.beforeDeref(delegateMap, AbstractHashedMap.class, 366, 12395, 12405)) {
                        delegateMap.put(key3, value3);
                    }else
                        throw new AbnormalExecutionError();
                    
                case 2 :
                    if (CallChecker.beforeDeref(delegateMap, AbstractHashedMap.class, 368, 12462, 12472)) {
                        delegateMap.put(key2, value2);
                    }else
                        throw new AbnormalExecutionError();
                    
                case 1 :
                    if (CallChecker.beforeDeref(delegateMap, AbstractHashedMap.class, 370, 12529, 12539)) {
                        delegateMap.put(key1, value1);
                    }else
                        throw new AbnormalExecutionError();
                    
            }
            size = 0;
            CallChecker.varAssign(this.size, "this.size", 373, 12579, 12587);
            hash1 = hash2 = hash3 = 0;
            CallChecker.varAssign(this.hash1, "this.hash1", 374, 12597, 12622);
            CallChecker.varAssign(this.hash2, "this.hash2", 374, 12605, 12621);
            CallChecker.varAssign(this.hash3, "this.hash3", 374, 12613, 12621);
            key1 = key2 = key3 = null;
            CallChecker.varAssign(this.key1, "this.key1", 375, 12632, 12657);
            CallChecker.varAssign(this.key2, "this.key2", 375, 12639, 12656);
            CallChecker.varAssign(this.key3, "this.key3", 375, 12646, 12656);
            value1 = value2 = value3 = null;
            CallChecker.varAssign(this.value1, "this.value1", 376, 12667, 12698);
            CallChecker.varAssign(this.value2, "this.value2", 376, 12676, 12697);
            CallChecker.varAssign(this.value3, "this.value3", 376, 12685, 12697);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1223.methodEnd();
        }
    }

    protected AbstractHashedMap<K, V> createDelegateMap() {
        MethodContext _bcornu_methode_context1224 = new MethodContext(AbstractHashedMap.class);
        try {
            CallChecker.varInit(this, "this", 389, 12711, 13210);
            CallChecker.varInit(this.delegateMap, "delegateMap", 389, 12711, 13210);
            CallChecker.varInit(this.value3, "value3", 389, 12711, 13210);
            CallChecker.varInit(this.value2, "value2", 389, 12711, 13210);
            CallChecker.varInit(this.value1, "value1", 389, 12711, 13210);
            CallChecker.varInit(this.key3, "key3", 389, 12711, 13210);
            CallChecker.varInit(this.key2, "key2", 389, 12711, 13210);
            CallChecker.varInit(this.key1, "key1", 389, 12711, 13210);
            CallChecker.varInit(this.hash3, "hash3", 389, 12711, 13210);
            CallChecker.varInit(this.hash2, "hash2", 389, 12711, 13210);
            CallChecker.varInit(this.hash1, "hash1", 389, 12711, 13210);
            CallChecker.varInit(this.size, "size", 389, 12711, 13210);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 389, 12711, 13210);
            return new HashedMap<K, V>();
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractHashedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1224.methodEnd();
        }
    }

    public V remove(Object key) {
        if ((delegateMap) != null) {
            return delegateMap.remove(key);
        }
        if ((size) == 0) {
            return null;
        }
        if (key == null) {
            switch (size) {
                case 3 :
                    if ((key3) == null) {
                        V old = CallChecker.varInit(value3, "old", 410, 13747, 13761);
                        hash3 = 0;
                        CallChecker.varAssign(this.hash3, "this.hash3", 411, 13787, 13796);
                        key3 = null;
                        CallChecker.varAssign(this.key3, "this.key3", 412, 13822, 13833);
                        value3 = null;
                        CallChecker.varAssign(this.value3, "this.value3", 413, 13859, 13872);
                        size = 2;
                        CallChecker.varAssign(this.size, "this.size", 414, 13898, 13906);
                        return old;
                    }
                    if ((key2) == null) {
                        V old = CallChecker.varInit(value2, "old", 418, 14030, 14044);
                        hash2 = hash3;
                        CallChecker.varAssign(this.hash2, "this.hash2", 419, 14070, 14083);
                        key2 = key3;
                        CallChecker.varAssign(this.key2, "this.key2", 420, 14109, 14120);
                        value2 = value3;
                        CallChecker.varAssign(this.value2, "this.value2", 421, 14146, 14161);
                        hash3 = 0;
                        CallChecker.varAssign(this.hash3, "this.hash3", 422, 14187, 14196);
                        key3 = null;
                        CallChecker.varAssign(this.key3, "this.key3", 423, 14222, 14233);
                        value3 = null;
                        CallChecker.varAssign(this.value3, "this.value3", 424, 14259, 14272);
                        size = 2;
                        CallChecker.varAssign(this.size, "this.size", 425, 14298, 14306);
                        return old;
                    }
                    if ((key1) == null) {
                        V old = CallChecker.varInit(value1, "old", 429, 14430, 14444);
                        hash1 = hash3;
                        CallChecker.varAssign(this.hash1, "this.hash1", 430, 14470, 14483);
                        key1 = key3;
                        CallChecker.varAssign(this.key1, "this.key1", 431, 14509, 14520);
                        value1 = value3;
                        CallChecker.varAssign(this.value1, "this.value1", 432, 14546, 14561);
                        hash3 = 0;
                        CallChecker.varAssign(this.hash3, "this.hash3", 433, 14587, 14596);
                        key3 = null;
                        CallChecker.varAssign(this.key3, "this.key3", 434, 14622, 14633);
                        value3 = null;
                        CallChecker.varAssign(this.value3, "this.value3", 435, 14659, 14672);
                        size = 2;
                        CallChecker.varAssign(this.size, "this.size", 436, 14698, 14706);
                        return old;
                    }
                    return null;
                case 2 :
                    if ((key2) == null) {
                        V old = CallChecker.varInit(value2, "old", 442, 14887, 14901);
                        hash2 = 0;
                        CallChecker.varAssign(this.hash2, "this.hash2", 443, 14927, 14936);
                        key2 = null;
                        CallChecker.varAssign(this.key2, "this.key2", 444, 14962, 14973);
                        value2 = null;
                        CallChecker.varAssign(this.value2, "this.value2", 445, 14999, 15012);
                        size = 1;
                        CallChecker.varAssign(this.size, "this.size", 446, 15038, 15046);
                        return old;
                    }
                    if ((key1) == null) {
                        V old = CallChecker.varInit(value1, "old", 450, 15170, 15184);
                        hash1 = hash2;
                        CallChecker.varAssign(this.hash1, "this.hash1", 451, 15210, 15223);
                        key1 = key2;
                        CallChecker.varAssign(this.key1, "this.key1", 452, 15249, 15260);
                        value1 = value2;
                        CallChecker.varAssign(this.value1, "this.value1", 453, 15286, 15301);
                        hash2 = 0;
                        CallChecker.varAssign(this.hash2, "this.hash2", 454, 15327, 15336);
                        key2 = null;
                        CallChecker.varAssign(this.key2, "this.key2", 455, 15362, 15373);
                        value2 = null;
                        CallChecker.varAssign(this.value2, "this.value2", 456, 15399, 15412);
                        size = 1;
                        CallChecker.varAssign(this.size, "this.size", 457, 15438, 15446);
                        return old;
                    }
                    return null;
                case 1 :
                    if ((key1) == null) {
                        V old = CallChecker.varInit(value1, "old", 463, 15627, 15641);
                        hash1 = 0;
                        CallChecker.varAssign(this.hash1, "this.hash1", 464, 15667, 15676);
                        key1 = null;
                        CallChecker.varAssign(this.key1, "this.key1", 465, 15702, 15713);
                        value1 = null;
                        CallChecker.varAssign(this.value1, "this.value1", 466, 15739, 15752);
                        size = 0;
                        CallChecker.varAssign(this.size, "this.size", 467, 15778, 15786);
                        return old;
                    }
            }
        }else {
            if ((size) > 0) {
                int hashCode = CallChecker.varInit(((int) (key.hashCode())), "hashCode", 473, 15921, 15950);
                switch (size) {
                    case 3 :
                        if (((hash3) == hashCode) && (key.equals(key3))) {
                            V old = CallChecker.varInit(value3, "old", 477, 16126, 16140);
                            hash3 = 0;
                            CallChecker.varAssign(this.hash3, "this.hash3", 478, 16170, 16179);
                            key3 = null;
                            CallChecker.varAssign(this.key3, "this.key3", 479, 16209, 16220);
                            value3 = null;
                            CallChecker.varAssign(this.value3, "this.value3", 480, 16250, 16263);
                            size = 2;
                            CallChecker.varAssign(this.size, "this.size", 481, 16293, 16301);
                            return old;
                        }
                        if (((hash2) == hashCode) && (key.equals(key2))) {
                            V old = CallChecker.varInit(value2, "old", 485, 16466, 16480);
                            hash2 = hash3;
                            CallChecker.varAssign(this.hash2, "this.hash2", 486, 16510, 16523);
                            key2 = key3;
                            CallChecker.varAssign(this.key2, "this.key2", 487, 16553, 16564);
                            value2 = value3;
                            CallChecker.varAssign(this.value2, "this.value2", 488, 16594, 16609);
                            hash3 = 0;
                            CallChecker.varAssign(this.hash3, "this.hash3", 489, 16639, 16648);
                            key3 = null;
                            CallChecker.varAssign(this.key3, "this.key3", 490, 16678, 16689);
                            value3 = null;
                            CallChecker.varAssign(this.value3, "this.value3", 491, 16719, 16732);
                            size = 2;
                            CallChecker.varAssign(this.size, "this.size", 492, 16762, 16770);
                            return old;
                        }
                        if (((hash1) == hashCode) && (key.equals(key1))) {
                            V old = CallChecker.varInit(value1, "old", 496, 16935, 16949);
                            hash1 = hash3;
                            CallChecker.varAssign(this.hash1, "this.hash1", 497, 16979, 16992);
                            key1 = key3;
                            CallChecker.varAssign(this.key1, "this.key1", 498, 17022, 17033);
                            value1 = value3;
                            CallChecker.varAssign(this.value1, "this.value1", 499, 17063, 17078);
                            hash3 = 0;
                            CallChecker.varAssign(this.hash3, "this.hash3", 500, 17108, 17117);
                            key3 = null;
                            CallChecker.varAssign(this.key3, "this.key3", 501, 17147, 17158);
                            value3 = null;
                            CallChecker.varAssign(this.value3, "this.value3", 502, 17188, 17201);
                            size = 2;
                            CallChecker.varAssign(this.size, "this.size", 503, 17231, 17239);
                            return old;
                        }
                        return null;
                    case 2 :
                        if (((hash2) == hashCode) && (key.equals(key2))) {
                            V old = CallChecker.varInit(value2, "old", 509, 17469, 17483);
                            hash2 = 0;
                            CallChecker.varAssign(this.hash2, "this.hash2", 510, 17513, 17522);
                            key2 = null;
                            CallChecker.varAssign(this.key2, "this.key2", 511, 17552, 17563);
                            value2 = null;
                            CallChecker.varAssign(this.value2, "this.value2", 512, 17593, 17606);
                            size = 1;
                            CallChecker.varAssign(this.size, "this.size", 513, 17636, 17644);
                            return old;
                        }
                        if (((hash1) == hashCode) && (key.equals(key1))) {
                            V old = CallChecker.varInit(value1, "old", 517, 17809, 17823);
                            hash1 = hash2;
                            CallChecker.varAssign(this.hash1, "this.hash1", 518, 17853, 17866);
                            key1 = key2;
                            CallChecker.varAssign(this.key1, "this.key1", 519, 17896, 17907);
                            value1 = value2;
                            CallChecker.varAssign(this.value1, "this.value1", 520, 17937, 17952);
                            hash2 = 0;
                            CallChecker.varAssign(this.hash2, "this.hash2", 521, 17982, 17991);
                            key2 = null;
                            CallChecker.varAssign(this.key2, "this.key2", 522, 18021, 18032);
                            value2 = null;
                            CallChecker.varAssign(this.value2, "this.value2", 523, 18062, 18075);
                            size = 1;
                            CallChecker.varAssign(this.size, "this.size", 524, 18105, 18113);
                            return old;
                        }
                        return null;
                    case 1 :
                        if (((hash1) == hashCode) && (key.equals(key1))) {
                            V old = CallChecker.varInit(value1, "old", 530, 18343, 18357);
                            hash1 = 0;
                            CallChecker.varAssign(this.hash1, "this.hash1", 531, 18387, 18396);
                            key1 = null;
                            CallChecker.varAssign(this.key1, "this.key1", 532, 18426, 18437);
                            value1 = null;
                            CallChecker.varAssign(this.value1, "this.value1", 533, 18467, 18480);
                            size = 0;
                            CallChecker.varAssign(this.size, "this.size", 534, 18510, 18518);
                            return old;
                        }
                }
            }
        }
        return null;
    }

    public void clear() {
        MethodContext _bcornu_methode_context1226 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 547, 18660, 19140);
            CallChecker.varInit(this.delegateMap, "delegateMap", 547, 18660, 19140);
            CallChecker.varInit(this.value3, "value3", 547, 18660, 19140);
            CallChecker.varInit(this.value2, "value2", 547, 18660, 19140);
            CallChecker.varInit(this.value1, "value1", 547, 18660, 19140);
            CallChecker.varInit(this.key3, "key3", 547, 18660, 19140);
            CallChecker.varInit(this.key2, "key2", 547, 18660, 19140);
            CallChecker.varInit(this.key1, "key1", 547, 18660, 19140);
            CallChecker.varInit(this.hash3, "hash3", 547, 18660, 19140);
            CallChecker.varInit(this.hash2, "hash2", 547, 18660, 19140);
            CallChecker.varInit(this.hash1, "hash1", 547, 18660, 19140);
            CallChecker.varInit(this.size, "size", 547, 18660, 19140);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 547, 18660, 19140);
            if ((delegateMap) != null) {
                delegateMap.clear();
                delegateMap = null;
                CallChecker.varAssign(this.delegateMap, "this.delegateMap", 550, 18915, 18933);
            }else {
                size = 0;
                CallChecker.varAssign(this.size, "this.size", 552, 18993, 19001);
                hash1 = hash2 = hash3 = 0;
                CallChecker.varAssign(this.hash1, "this.hash1", 553, 19015, 19040);
                CallChecker.varAssign(this.hash2, "this.hash2", 553, 19023, 19039);
                CallChecker.varAssign(this.hash3, "this.hash3", 553, 19031, 19039);
                key1 = key2 = key3 = null;
                CallChecker.varAssign(this.key1, "this.key1", 554, 19054, 19079);
                CallChecker.varAssign(this.key2, "this.key2", 554, 19061, 19078);
                CallChecker.varAssign(this.key3, "this.key3", 554, 19068, 19078);
                value1 = value2 = value3 = null;
                CallChecker.varAssign(this.value1, "this.value1", 555, 19093, 19124);
                CallChecker.varAssign(this.value2, "this.value2", 555, 19102, 19123);
                CallChecker.varAssign(this.value3, "this.value3", 555, 19111, 19123);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1226.methodEnd();
        }
    }

    public MapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context1227 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 571, 19147, 19919);
            CallChecker.varInit(this.delegateMap, "delegateMap", 571, 19147, 19919);
            CallChecker.varInit(this.value3, "value3", 571, 19147, 19919);
            CallChecker.varInit(this.value2, "value2", 571, 19147, 19919);
            CallChecker.varInit(this.value1, "value1", 571, 19147, 19919);
            CallChecker.varInit(this.key3, "key3", 571, 19147, 19919);
            CallChecker.varInit(this.key2, "key2", 571, 19147, 19919);
            CallChecker.varInit(this.key1, "key1", 571, 19147, 19919);
            CallChecker.varInit(this.hash3, "hash3", 571, 19147, 19919);
            CallChecker.varInit(this.hash2, "hash2", 571, 19147, 19919);
            CallChecker.varInit(this.hash1, "hash1", 571, 19147, 19919);
            CallChecker.varInit(this.size, "size", 571, 19147, 19919);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 571, 19147, 19919);
            if ((delegateMap) != null) {
                return delegateMap.mapIterator();
            }
            if ((size) == 0) {
                return EmptyMapIterator.<K, V>getInstance();
            }
            return new Flat3Map.FlatMapIterator<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1227.methodEnd();
        }
    }

    static class FlatMapIterator<K, V> implements MapIterator<K, V> , ResettableIterator<K> {
        private final Flat3Map<K, V> parent;

        private int nextIndex = 0;

        private boolean canRemove = false;

        FlatMapIterator(Flat3Map<K, V> parent) {
            super();
            MethodContext _bcornu_methode_context245 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 591, 20260, 20280);
            } finally {
                _bcornu_methode_context245.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context1228 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 594, 20301, 20382);
                CallChecker.varInit(this.canRemove, "canRemove", 594, 20301, 20382);
                CallChecker.varInit(this.nextIndex, "nextIndex", 594, 20301, 20382);
                CallChecker.varInit(this.parent, "parent", 594, 20301, 20382);
                return (nextIndex) < (CallChecker.isCalled(parent, Flat3Map.class, 595, 20360, 20365).size);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1228.methodEnd();
            }
        }

        public K next() {
            if ((hasNext()) == false) {
                throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
            }
            canRemove = true;
            CallChecker.varAssign(this.canRemove, "this.canRemove", 602, 20558, 20574);
            (nextIndex)++;
            return getKey();
        }

        public void remove() {
            MethodContext _bcornu_methode_context1230 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 607, 20649, 20908);
                CallChecker.varInit(this.canRemove, "canRemove", 607, 20649, 20908);
                CallChecker.varInit(this.nextIndex, "nextIndex", 607, 20649, 20908);
                CallChecker.varInit(this.parent, "parent", 607, 20649, 20908);
                if ((canRemove) == false) {
                    throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
                }
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 611, 20819, 20824)) {
                    parent.remove(getKey());
                }
                (nextIndex)--;
                canRemove = false;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 613, 20881, 20898);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1230.methodEnd();
            }
        }

        public K getKey() {
            if ((canRemove) == false) {
                throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
            }
            switch (nextIndex) {
                case 3 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 622, 21158, 21163)) {
                        return parent.key3;
                    }else
                        throw new AbnormalExecutionError();
                    
                case 2 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 624, 21222, 21227)) {
                        return parent.key2;
                    }else
                        throw new AbnormalExecutionError();
                    
                case 1 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 626, 21286, 21291)) {
                        return parent.key1;
                    }else
                        throw new AbnormalExecutionError();
                    
            }
            throw new IllegalStateException("Invalid map index");
        }

        public V getValue() {
            if ((canRemove) == false) {
                throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
            }
            switch (nextIndex) {
                case 3 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 637, 21641, 21646)) {
                        return parent.value3;
                    }else
                        throw new AbnormalExecutionError();
                    
                case 2 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 639, 21707, 21712)) {
                        return parent.value2;
                    }else
                        throw new AbnormalExecutionError();
                    
                case 1 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 641, 21773, 21778)) {
                        return parent.value1;
                    }else
                        throw new AbnormalExecutionError();
                    
            }
            throw new IllegalStateException("Invalid map index");
        }

        public V setValue(V value) {
            if ((canRemove) == false) {
                throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
            }
            V old = CallChecker.varInit(getValue(), "old", 650, 22065, 22083);
            switch (nextIndex) {
                case 3 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 653, 22162, 22167)) {
                        parent.value3 = value;
                        CallChecker.varAssign(this.parent.value3, "this.parent.value3", 653, 22162, 22183);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                case 2 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 656, 22256, 22261)) {
                        parent.value2 = value;
                        CallChecker.varAssign(this.parent.value2, "this.parent.value2", 656, 22256, 22277);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                case 1 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 659, 22350, 22355)) {
                        parent.value1 = value;
                        CallChecker.varAssign(this.parent.value1, "this.parent.value1", 659, 22350, 22371);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
            }
            return old;
        }

        public void reset() {
            MethodContext _bcornu_methode_context1234 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 665, 22457, 22545);
                CallChecker.varInit(this.canRemove, "canRemove", 665, 22457, 22545);
                CallChecker.varInit(this.nextIndex, "nextIndex", 665, 22457, 22545);
                CallChecker.varInit(this.parent, "parent", 665, 22457, 22545);
                nextIndex = 0;
                CallChecker.varAssign(this.nextIndex, "this.nextIndex", 666, 22491, 22504);
                canRemove = false;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 667, 22518, 22535);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1234.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context1235 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 671, 22556, 22757);
                CallChecker.varInit(this.canRemove, "canRemove", 671, 22556, 22757);
                CallChecker.varInit(this.nextIndex, "nextIndex", 671, 22556, 22757);
                CallChecker.varInit(this.parent, "parent", 671, 22556, 22757);
                if (canRemove) {
                    return ((("Iterator[" + (getKey())) + "=") + (getValue())) + "]";
                }
                return "Iterator[]";
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1235.methodEnd();
            }
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context1236 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 688, 22770, 23262);
            CallChecker.varInit(this.delegateMap, "delegateMap", 688, 22770, 23262);
            CallChecker.varInit(this.value3, "value3", 688, 22770, 23262);
            CallChecker.varInit(this.value2, "value2", 688, 22770, 23262);
            CallChecker.varInit(this.value1, "value1", 688, 22770, 23262);
            CallChecker.varInit(this.key3, "key3", 688, 22770, 23262);
            CallChecker.varInit(this.key2, "key2", 688, 22770, 23262);
            CallChecker.varInit(this.key1, "key1", 688, 22770, 23262);
            CallChecker.varInit(this.hash3, "hash3", 688, 22770, 23262);
            CallChecker.varInit(this.hash2, "hash2", 688, 22770, 23262);
            CallChecker.varInit(this.hash1, "hash1", 688, 22770, 23262);
            CallChecker.varInit(this.size, "size", 688, 22770, 23262);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 688, 22770, 23262);
            if ((delegateMap) != null) {
                return delegateMap.entrySet();
            }
            return new Flat3Map.EntrySet<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1236.methodEnd();
        }
    }

    static class EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private final Flat3Map<K, V> parent;

        EntrySet(Flat3Map<K, V> parent) {
            super();
            MethodContext _bcornu_methode_context246 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 703, 23489, 23509);
            } finally {
                _bcornu_methode_context246.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context1237 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 707, 23530, 23610);
                CallChecker.varInit(this.parent, "parent", 707, 23530, 23610);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 708, 23587, 23592)) {
                    return CallChecker.isCalled(parent, Flat3Map.class, 708, 23587, 23592).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1237.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context1238 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 712, 23621, 23697);
                CallChecker.varInit(this.parent, "parent", 712, 23621, 23697);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 713, 23673, 23678)) {
                    CallChecker.isCalled(parent, Flat3Map.class, 713, 23673, 23678).clear();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1238.methodEnd();
            }
        }

        @Override
        public boolean remove(Object obj) {
            MethodContext _bcornu_methode_context1239 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 717, 23708, 24080);
                CallChecker.varInit(obj, "obj", 717, 23708, 24080);
                CallChecker.varInit(this.parent, "parent", 717, 23708, 24080);
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                Map.Entry<?, ?> entry = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "entry", 721, 23871, 23916);
                Object key = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 722, 23943, 23947)) {
                    key = entry.getKey();
                    CallChecker.varAssign(key, "key", 722, 23943, 23947);
                }
                boolean result = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 723, 23988, 23993)) {
                    result = CallChecker.isCalled(parent, Flat3Map.class, 723, 23988, 23993).containsKey(key);
                    CallChecker.varAssign(result, "result", 723, 23988, 23993);
                }
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 724, 24025, 24030)) {
                    parent.remove(key);
                }
                return result;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1239.methodEnd();
            }
        }

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            MethodContext _bcornu_methode_context1240 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 729, 24091, 24464);
                CallChecker.varInit(this.parent, "parent", 729, 24091, 24464);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 730, 24171, 24176)) {
                    if ((CallChecker.isCalled(parent, Flat3Map.class, 730, 24171, 24176).delegateMap) != null) {
                        if (CallChecker.beforeDeref(parent, Flat3Map.class, 731, 24224, 24229)) {
                            final Set<Map.Entry<K, V>> npe_invocation_var266 = CallChecker.isCalled(CallChecker.isCalled(parent, Flat3Map.class, 731, 24224, 24229).delegateMap, AbstractHashedMap.class, 731, 24224, 24241).entrySet();
                            if (CallChecker.beforeDeref(npe_invocation_var266, Set.class, 731, 24224, 24252)) {
                                return CallChecker.isCalled(npe_invocation_var266, Set.class, 731, 24224, 24252).iterator();
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 733, 24296, 24301)) {
                    if ((CallChecker.isCalled(parent, Flat3Map.class, 733, 24296, 24301).size()) == 0) {
                        return EmptyIterator.<Map.Entry<K, V>>getInstance();
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return new Flat3Map.EntrySetIterator<K, V>(parent);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1240.methodEnd();
            }
        }
    }

    abstract static class EntryIterator<K, V> implements Map.Entry<K, V> {
        private final Flat3Map<K, V> parent;

        private int nextIndex = 0;

        protected boolean canRemove = false;

        public EntryIterator(Flat3Map<K, V> parent) {
            MethodContext _bcornu_methode_context247 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 749, 24812, 24832);
            } finally {
                _bcornu_methode_context247.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context1241 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 752, 24853, 24934);
                CallChecker.varInit(this.canRemove, "canRemove", 752, 24853, 24934);
                CallChecker.varInit(this.nextIndex, "nextIndex", 752, 24853, 24934);
                CallChecker.varInit(this.parent, "parent", 752, 24853, 24934);
                return (nextIndex) < (CallChecker.isCalled(parent, Flat3Map.class, 753, 24912, 24917).size);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1241.methodEnd();
            }
        }

        public Map.Entry<K, V> nextEntry() {
            MethodContext _bcornu_methode_context1242 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 756, 24945, 25205);
                CallChecker.varInit(this.canRemove, "canRemove", 756, 24945, 25205);
                CallChecker.varInit(this.nextIndex, "nextIndex", 756, 24945, 25205);
                CallChecker.varInit(this.parent, "parent", 756, 24945, 25205);
                if ((hasNext()) == false) {
                    throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
                }
                canRemove = true;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 760, 25129, 25145);
                (nextIndex)++;
                return this;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1242.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context1243 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 765, 25216, 25475);
                CallChecker.varInit(this.canRemove, "canRemove", 765, 25216, 25475);
                CallChecker.varInit(this.nextIndex, "nextIndex", 765, 25216, 25475);
                CallChecker.varInit(this.parent, "parent", 765, 25216, 25475);
                if ((canRemove) == false) {
                    throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
                }
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 769, 25386, 25391)) {
                    parent.remove(getKey());
                }
                (nextIndex)--;
                canRemove = false;
                CallChecker.varAssign(this.canRemove, "this.canRemove", 771, 25448, 25465);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1243.methodEnd();
            }
        }

        public K getKey() {
            if ((canRemove) == false) {
                throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
            }
            switch (nextIndex) {
                case 3 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 780, 25725, 25730)) {
                        return parent.key3;
                    }else
                        throw new AbnormalExecutionError();
                    
                case 2 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 782, 25789, 25794)) {
                        return parent.key2;
                    }else
                        throw new AbnormalExecutionError();
                    
                case 1 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 784, 25853, 25858)) {
                        return parent.key1;
                    }else
                        throw new AbnormalExecutionError();
                    
            }
            throw new IllegalStateException("Invalid map index");
        }

        public V getValue() {
            if ((canRemove) == false) {
                throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
            }
            switch (nextIndex) {
                case 3 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 795, 26208, 26213)) {
                        return parent.value3;
                    }else
                        throw new AbnormalExecutionError();
                    
                case 2 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 797, 26274, 26279)) {
                        return parent.value2;
                    }else
                        throw new AbnormalExecutionError();
                    
                case 1 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 799, 26340, 26345)) {
                        return parent.value1;
                    }else
                        throw new AbnormalExecutionError();
                    
            }
            throw new IllegalStateException("Invalid map index");
        }

        public V setValue(V value) {
            if ((canRemove) == false) {
                throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
            }
            V old = CallChecker.varInit(getValue(), "old", 808, 26632, 26650);
            switch (nextIndex) {
                case 3 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 811, 26729, 26734)) {
                        parent.value3 = value;
                        CallChecker.varAssign(this.parent.value3, "this.parent.value3", 811, 26729, 26750);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                case 2 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 814, 26823, 26828)) {
                        parent.value2 = value;
                        CallChecker.varAssign(this.parent.value2, "this.parent.value2", 814, 26823, 26844);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                case 1 :
                    if (CallChecker.beforeDeref(parent, Flat3Map.class, 817, 26917, 26922)) {
                        parent.value1 = value;
                        CallChecker.varAssign(this.parent.value1, "this.parent.value1", 817, 26917, 26938);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
            }
            return old;
        }
    }

    static class EntrySetIterator<K, V> extends Flat3Map.EntryIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        EntrySetIterator(Flat3Map<K, V> parent) {
            super(parent);
            MethodContext _bcornu_methode_context248 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context248.methodEnd();
            }
        }

        public Map.Entry<K, V> next() {
            MethodContext _bcornu_methode_context1247 = new MethodContext(Map.Entry.class);
            try {
                CallChecker.varInit(this, "this", 833, 27279, 27351);
                CallChecker.varInit(this.canRemove, "canRemove", 833, 27279, 27351);
                return nextEntry();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map.Entry<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1247.methodEnd();
            }
        }

        @Override
        public boolean equals(Object obj) {
            MethodContext _bcornu_methode_context1248 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 838, 27362, 27922);
                CallChecker.varInit(obj, "obj", 838, 27362, 27922);
                CallChecker.varInit(this.canRemove, "canRemove", 838, 27362, 27922);
                if ((canRemove) == false) {
                    return false;
                }
                if ((obj instanceof Map.Entry) == false) {
                    return false;
                }
                Map.Entry<?, ?> other = CallChecker.varInit(((Map.Entry<?, ?>) (obj)), "other", 845, 27607, 27652);
                Object key = CallChecker.varInit(getKey(), "key", 846, 27666, 27687);
                Object value = CallChecker.varInit(getValue(), "value", 847, 27701, 27726);
                if (CallChecker.beforeDeref(other, Map.Entry.class, 848, 27798, 27802)) {
                    if ((key == null) || (CallChecker.beforeDeref(key, Object.class, 848, 27787, 27789))) {
                        if (CallChecker.beforeDeref(other, Map.Entry.class, 849, 27894, 27898)) {
                            if ((value == null) || (CallChecker.beforeDeref(value, Object.class, 849, 27881, 27885))) {
                                key = CallChecker.beforeCalled(key, Object.class, 848, 27787, 27789);
                                value = CallChecker.beforeCalled(value, Object.class, 849, 27881, 27885);
                                return ((key == null) ? (other.getKey()) == null : CallChecker.isCalled(key, Object.class, 848, 27787, 27789).equals(other.getKey())) && ((value == null) ? (other.getValue()) == null : CallChecker.isCalled(value, Object.class, 849, 27881, 27885).equals(other.getValue()));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1248.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context1249 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 853, 27933, 28250);
                CallChecker.varInit(this.canRemove, "canRemove", 853, 27933, 28250);
                if ((canRemove) == false) {
                    return 0;
                }
                Object key = CallChecker.varInit(getKey(), "key", 857, 28065, 28086);
                Object value = CallChecker.varInit(getValue(), "value", 858, 28100, 28125);
                if ((key == null) || (CallChecker.beforeDeref(key, Object.class, 859, 28165, 28167))) {
                    if ((value == null) || (CallChecker.beforeDeref(value, Object.class, 860, 28223, 28227))) {
                        key = CallChecker.beforeCalled(key, Object.class, 859, 28165, 28167);
                        value = CallChecker.beforeCalled(value, Object.class, 860, 28223, 28227);
                        return ((key == null) ? 0 : CallChecker.isCalled(key, Object.class, 859, 28165, 28167).hashCode()) ^ ((value == null) ? 0 : CallChecker.isCalled(value, Object.class, 860, 28223, 28227).hashCode());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1249.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context1250 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 864, 28261, 28432);
                CallChecker.varInit(this.canRemove, "canRemove", 864, 28261, 28432);
                if (canRemove) {
                    return ((getKey()) + "=") + (getValue());
                }
                return "";
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1250.methodEnd();
            }
        }
    }

    public Set<K> keySet() {
        MethodContext _bcornu_methode_context1251 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 879, 28445, 28810);
            CallChecker.varInit(this.delegateMap, "delegateMap", 879, 28445, 28810);
            CallChecker.varInit(this.value3, "value3", 879, 28445, 28810);
            CallChecker.varInit(this.value2, "value2", 879, 28445, 28810);
            CallChecker.varInit(this.value1, "value1", 879, 28445, 28810);
            CallChecker.varInit(this.key3, "key3", 879, 28445, 28810);
            CallChecker.varInit(this.key2, "key2", 879, 28445, 28810);
            CallChecker.varInit(this.key1, "key1", 879, 28445, 28810);
            CallChecker.varInit(this.hash3, "hash3", 879, 28445, 28810);
            CallChecker.varInit(this.hash2, "hash2", 879, 28445, 28810);
            CallChecker.varInit(this.hash1, "hash1", 879, 28445, 28810);
            CallChecker.varInit(this.size, "size", 879, 28445, 28810);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 879, 28445, 28810);
            if ((delegateMap) != null) {
                return delegateMap.keySet();
            }
            return new Flat3Map.KeySet<K>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1251.methodEnd();
        }
    }

    static class KeySet<K> extends AbstractSet<K> {
        private final Flat3Map<K, ?> parent;

        KeySet(Flat3Map<K, ?> parent) {
            super();
            MethodContext _bcornu_methode_context249 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 894, 29014, 29034);
            } finally {
                _bcornu_methode_context249.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context1252 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 898, 29055, 29135);
                CallChecker.varInit(this.parent, "parent", 898, 29055, 29135);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 899, 29112, 29117)) {
                    return CallChecker.isCalled(parent, Flat3Map.class, 899, 29112, 29117).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1252.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context1253 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 903, 29146, 29222);
                CallChecker.varInit(this.parent, "parent", 903, 29146, 29222);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 904, 29198, 29203)) {
                    CallChecker.isCalled(parent, Flat3Map.class, 904, 29198, 29203).clear();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1253.methodEnd();
            }
        }

        @Override
        public boolean contains(Object key) {
            MethodContext _bcornu_methode_context1254 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 908, 29233, 29341);
                CallChecker.varInit(key, "key", 908, 29233, 29341);
                CallChecker.varInit(this.parent, "parent", 908, 29233, 29341);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 909, 29308, 29313)) {
                    return CallChecker.isCalled(parent, Flat3Map.class, 909, 29308, 29313).containsKey(key);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1254.methodEnd();
            }
        }

        @Override
        public boolean remove(Object key) {
            MethodContext _bcornu_methode_context1255 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 913, 29352, 29527);
                CallChecker.varInit(key, "key", 913, 29352, 29527);
                CallChecker.varInit(this.parent, "parent", 913, 29352, 29527);
                boolean result = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 914, 29435, 29440)) {
                    result = CallChecker.isCalled(parent, Flat3Map.class, 914, 29435, 29440).containsKey(key);
                    CallChecker.varAssign(result, "result", 914, 29435, 29440);
                }
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 915, 29472, 29477)) {
                    parent.remove(key);
                }
                return result;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1255.methodEnd();
            }
        }

        @Override
        public Iterator<K> iterator() {
            MethodContext _bcornu_methode_context1256 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 920, 29538, 29876);
                CallChecker.varInit(this.parent, "parent", 920, 29538, 29876);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 921, 29604, 29609)) {
                    if ((CallChecker.isCalled(parent, Flat3Map.class, 921, 29604, 29609).delegateMap) != null) {
                        if (CallChecker.beforeDeref(parent, Flat3Map.class, 922, 29657, 29662)) {
                            final Set<K> npe_invocation_var267 = CallChecker.isCalled(CallChecker.isCalled(parent, Flat3Map.class, 922, 29657, 29662).delegateMap, AbstractHashedMap.class, 922, 29657, 29674).keySet();
                            if (CallChecker.beforeDeref(npe_invocation_var267, Set.class, 922, 29657, 29683)) {
                                return CallChecker.isCalled(npe_invocation_var267, Set.class, 922, 29657, 29683).iterator();
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 924, 29727, 29732)) {
                    if ((CallChecker.isCalled(parent, Flat3Map.class, 924, 29727, 29732).size()) == 0) {
                        return EmptyIterator.<K>getInstance();
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return new Flat3Map.KeySetIterator<K>(parent);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<K>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1256.methodEnd();
            }
        }
    }

    static class KeySetIterator<K> extends Flat3Map.EntryIterator<K, Object> implements Iterator<K> {
        @SuppressWarnings(value = "unchecked")
        KeySetIterator(Flat3Map<K, ?> parent) {
            super(((Flat3Map<K, Object>) (parent)));
            MethodContext _bcornu_methode_context250 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context250.methodEnd();
            }
        }

        public K next() {
            nextEntry();
            return getKey();
        }
    }

    public Collection<V> values() {
        MethodContext _bcornu_methode_context1258 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 954, 30264, 30638);
            CallChecker.varInit(this.delegateMap, "delegateMap", 954, 30264, 30638);
            CallChecker.varInit(this.value3, "value3", 954, 30264, 30638);
            CallChecker.varInit(this.value2, "value2", 954, 30264, 30638);
            CallChecker.varInit(this.value1, "value1", 954, 30264, 30638);
            CallChecker.varInit(this.key3, "key3", 954, 30264, 30638);
            CallChecker.varInit(this.key2, "key2", 954, 30264, 30638);
            CallChecker.varInit(this.key1, "key1", 954, 30264, 30638);
            CallChecker.varInit(this.hash3, "hash3", 954, 30264, 30638);
            CallChecker.varInit(this.hash2, "hash2", 954, 30264, 30638);
            CallChecker.varInit(this.hash1, "hash1", 954, 30264, 30638);
            CallChecker.varInit(this.size, "size", 954, 30264, 30638);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 954, 30264, 30638);
            if ((delegateMap) != null) {
                return delegateMap.values();
            }
            return new Flat3Map.Values<V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1258.methodEnd();
        }
    }

    static class Values<V> extends AbstractCollection<V> {
        private final Flat3Map<?, V> parent;

        Values(Flat3Map<?, V> parent) {
            super();
            MethodContext _bcornu_methode_context251 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 969, 30849, 30869);
            } finally {
                _bcornu_methode_context251.methodEnd();
            }
        }

        @Override
        public int size() {
            MethodContext _bcornu_methode_context1259 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 973, 30890, 30970);
                CallChecker.varInit(this.parent, "parent", 973, 30890, 30970);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 974, 30947, 30952)) {
                    return CallChecker.isCalled(parent, Flat3Map.class, 974, 30947, 30952).size();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1259.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context1260 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 978, 30981, 31057);
                CallChecker.varInit(this.parent, "parent", 978, 30981, 31057);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 979, 31033, 31038)) {
                    CallChecker.isCalled(parent, Flat3Map.class, 979, 31033, 31038).clear();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1260.methodEnd();
            }
        }

        @Override
        public boolean contains(Object value) {
            MethodContext _bcornu_methode_context1261 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 983, 31068, 31182);
                CallChecker.varInit(value, "value", 983, 31068, 31182);
                CallChecker.varInit(this.parent, "parent", 983, 31068, 31182);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 984, 31145, 31150)) {
                    return CallChecker.isCalled(parent, Flat3Map.class, 984, 31145, 31150).containsValue(value);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1261.methodEnd();
            }
        }

        @Override
        public Iterator<V> iterator() {
            MethodContext _bcornu_methode_context1262 = new MethodContext(Iterator.class);
            try {
                CallChecker.varInit(this, "this", 988, 31193, 31531);
                CallChecker.varInit(this.parent, "parent", 988, 31193, 31531);
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 989, 31259, 31264)) {
                    if ((CallChecker.isCalled(parent, Flat3Map.class, 989, 31259, 31264).delegateMap) != null) {
                        if (CallChecker.beforeDeref(parent, Flat3Map.class, 990, 31312, 31317)) {
                            final Collection<V> npe_invocation_var268 = CallChecker.isCalled(CallChecker.isCalled(parent, Flat3Map.class, 990, 31312, 31317).delegateMap, AbstractHashedMap.class, 990, 31312, 31329).values();
                            if (CallChecker.beforeDeref(npe_invocation_var268, Collection.class, 990, 31312, 31338)) {
                                return CallChecker.isCalled(npe_invocation_var268, Collection.class, 990, 31312, 31338).iterator();
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(parent, Flat3Map.class, 992, 31382, 31387)) {
                    if ((CallChecker.isCalled(parent, Flat3Map.class, 992, 31382, 31387).size()) == 0) {
                        return EmptyIterator.<V>getInstance();
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return new Flat3Map.ValuesIterator<V>(parent);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Iterator<V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1262.methodEnd();
            }
        }
    }

    static class ValuesIterator<V> extends Flat3Map.EntryIterator<Object, V> implements Iterator<V> {
        @SuppressWarnings(value = "unchecked")
        ValuesIterator(Flat3Map<?, V> parent) {
            super(((Flat3Map<Object, V>) (parent)));
            MethodContext _bcornu_methode_context252 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context252.methodEnd();
            }
        }

        public V next() {
            nextEntry();
            return getValue();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1264 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1019, 31922, 32383);
            CallChecker.varInit(out, "out", 1019, 31922, 32383);
            CallChecker.varInit(this.delegateMap, "delegateMap", 1019, 31922, 32383);
            CallChecker.varInit(this.value3, "value3", 1019, 31922, 32383);
            CallChecker.varInit(this.value2, "value2", 1019, 31922, 32383);
            CallChecker.varInit(this.value1, "value1", 1019, 31922, 32383);
            CallChecker.varInit(this.key3, "key3", 1019, 31922, 32383);
            CallChecker.varInit(this.key2, "key2", 1019, 31922, 32383);
            CallChecker.varInit(this.key1, "key1", 1019, 31922, 32383);
            CallChecker.varInit(this.hash3, "hash3", 1019, 31922, 32383);
            CallChecker.varInit(this.hash2, "hash2", 1019, 31922, 32383);
            CallChecker.varInit(this.hash1, "hash1", 1019, 31922, 32383);
            CallChecker.varInit(this.size, "size", 1019, 31922, 32383);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 1019, 31922, 32383);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 1020, 32143, 32145)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 1020, 32143, 32145);
                CallChecker.isCalled(out, ObjectOutputStream.class, 1020, 32143, 32145).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 1021, 32177, 32179)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 1021, 32177, 32179);
                CallChecker.isCalled(out, ObjectOutputStream.class, 1021, 32177, 32179).writeInt(size());
            }
            for (MapIterator<?, ?> it = mapIterator(); CallChecker.isCalled(it, MapIterator.class, 1022, 32250, 32251).hasNext();) {
                if (CallChecker.beforeDeref(it, MapIterator.class, 1023, 32295, 32296)) {
                    if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 1023, 32279, 32281)) {
                        out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 1023, 32279, 32281);
                        CallChecker.isCalled(out, ObjectOutputStream.class, 1023, 32279, 32281).writeObject(it.next());
                    }
                }
                if (CallChecker.beforeDeref(it, MapIterator.class, 1024, 32343, 32344)) {
                    if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 1024, 32327, 32329)) {
                        out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 1024, 32327, 32329);
                        CallChecker.isCalled(out, ObjectOutputStream.class, 1024, 32327, 32329).writeObject(it.getValue());
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1264.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1265 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1032, 32390, 32842);
            CallChecker.varInit(in, "in", 1032, 32390, 32842);
            CallChecker.varInit(this.delegateMap, "delegateMap", 1032, 32390, 32842);
            CallChecker.varInit(this.value3, "value3", 1032, 32390, 32842);
            CallChecker.varInit(this.value2, "value2", 1032, 32390, 32842);
            CallChecker.varInit(this.value1, "value1", 1032, 32390, 32842);
            CallChecker.varInit(this.key3, "key3", 1032, 32390, 32842);
            CallChecker.varInit(this.key2, "key2", 1032, 32390, 32842);
            CallChecker.varInit(this.key1, "key1", 1032, 32390, 32842);
            CallChecker.varInit(this.hash3, "hash3", 1032, 32390, 32842);
            CallChecker.varInit(this.hash2, "hash2", 1032, 32390, 32842);
            CallChecker.varInit(this.hash1, "hash1", 1032, 32390, 32842);
            CallChecker.varInit(this.size, "size", 1032, 32390, 32842);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 1032, 32390, 32842);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1033, 32587, 32588)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1033, 32587, 32588);
                CallChecker.isCalled(in, ObjectInputStream.class, 1033, 32587, 32588).defaultReadObject();
            }
            int count = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1034, 32631, 32632)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1034, 32631, 32632);
                count = CallChecker.isCalled(in, ObjectInputStream.class, 1034, 32631, 32632).readInt();
                CallChecker.varAssign(count, "count", 1034, 32631, 32632);
            }
            if (count > 3) {
                delegateMap = createDelegateMap();
                CallChecker.varAssign(this.delegateMap, "this.delegateMap", 1036, 32682, 32715);
            }
            for (int i = count; i > 0; i--) {
                if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1039, 32789, 32790)) {
                    if (CallChecker.beforeDeref(in, ObjectInputStream.class, 1039, 32810, 32811)) {
                        in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1039, 32789, 32790);
                        in = CallChecker.beforeCalled(in, ObjectInputStream.class, 1039, 32810, 32811);
                        put(((K) (CallChecker.isCalled(in, ObjectInputStream.class, 1039, 32789, 32790).readObject())), ((V) (CallChecker.isCalled(in, ObjectInputStream.class, 1039, 32810, 32811).readObject())));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1265.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public Flat3Map<K, V> clone() {
        MethodContext _bcornu_methode_context1266 = new MethodContext(Flat3Map.class);
        try {
            CallChecker.varInit(this, "this", 1052, 32849, 33495);
            CallChecker.varInit(this.delegateMap, "delegateMap", 1052, 32849, 33495);
            CallChecker.varInit(this.value3, "value3", 1052, 32849, 33495);
            CallChecker.varInit(this.value2, "value2", 1052, 32849, 33495);
            CallChecker.varInit(this.value1, "value1", 1052, 32849, 33495);
            CallChecker.varInit(this.key3, "key3", 1052, 32849, 33495);
            CallChecker.varInit(this.key2, "key2", 1052, 32849, 33495);
            CallChecker.varInit(this.key1, "key1", 1052, 32849, 33495);
            CallChecker.varInit(this.hash3, "hash3", 1052, 32849, 33495);
            CallChecker.varInit(this.hash2, "hash2", 1052, 32849, 33495);
            CallChecker.varInit(this.hash1, "hash1", 1052, 32849, 33495);
            CallChecker.varInit(this.size, "size", 1052, 32849, 33495);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 1052, 32849, 33495);
            TryContext _bcornu_try_context_18 = new TryContext(18, Flat3Map.class, "java.lang.CloneNotSupportedException");
            try {
                Flat3Map<K, V> cloned = CallChecker.varInit(((Flat3Map<K, V>) (super.clone())), "cloned", 1054, 33184, 33238);
                if (CallChecker.beforeDeref(cloned, Flat3Map.class, 1055, 33256, 33261)) {
                    cloned = CallChecker.beforeCalled(cloned, Flat3Map.class, 1055, 33256, 33261);
                    if ((CallChecker.isCalled(cloned, Flat3Map.class, 1055, 33256, 33261).delegateMap) != null) {
                        if (CallChecker.beforeDeref(cloned, Flat3Map.class, 1056, 33302, 33307)) {
                            if (CallChecker.beforeDeref(cloned, Flat3Map.class, 1056, 33323, 33328)) {
                                cloned = CallChecker.beforeCalled(cloned, Flat3Map.class, 1056, 33302, 33307);
                                cloned = CallChecker.beforeCalled(cloned, Flat3Map.class, 1056, 33323, 33328);
                                CallChecker.isCalled(cloned, Flat3Map.class, 1056, 33302, 33307).delegateMap = CallChecker.isCalled(cloned, Flat3Map.class, 1056, 33323, 33328).delegateMap.clone();
                                CallChecker.varAssign(CallChecker.isCalled(cloned, Flat3Map.class, 1056, 33302, 33307).delegateMap, "CallChecker.isCalled(cloned, Flat3Map.class, 1056, 33302, 33307).delegateMap", 1056, 33302, 33349);
                            }
                        }
                    }
                }
                return cloned;
            } catch (CloneNotSupportedException ex) {
                _bcornu_try_context_18.catchStart(18);
                throw new InternalError();
            } finally {
                _bcornu_try_context_18.finallyStart(18);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Flat3Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1266.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1267 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1071, 33502, 35226);
            CallChecker.varInit(obj, "obj", 1071, 33502, 35226);
            CallChecker.varInit(this.delegateMap, "delegateMap", 1071, 33502, 35226);
            CallChecker.varInit(this.value3, "value3", 1071, 33502, 35226);
            CallChecker.varInit(this.value2, "value2", 1071, 33502, 35226);
            CallChecker.varInit(this.value1, "value1", 1071, 33502, 35226);
            CallChecker.varInit(this.key3, "key3", 1071, 33502, 35226);
            CallChecker.varInit(this.key2, "key2", 1071, 33502, 35226);
            CallChecker.varInit(this.key1, "key1", 1071, 33502, 35226);
            CallChecker.varInit(this.hash3, "hash3", 1071, 33502, 35226);
            CallChecker.varInit(this.hash2, "hash2", 1071, 33502, 35226);
            CallChecker.varInit(this.hash1, "hash1", 1071, 33502, 35226);
            CallChecker.varInit(this.size, "size", 1071, 33502, 35226);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 1071, 33502, 35226);
            if (obj == (this)) {
                return true;
            }
            if ((delegateMap) != null) {
                return delegateMap.equals(obj);
            }
            if ((obj instanceof Map) == false) {
                return false;
            }
            Map<?, ?> other = CallChecker.varInit(((Map<?, ?>) (obj)), "other", 1081, 33925, 33958);
            if (CallChecker.beforeDeref(other, Map.class, 1082, 33980, 33984)) {
                other = CallChecker.beforeCalled(other, Map.class, 1082, 33980, 33984);
                if ((size) != (CallChecker.isCalled(other, Map.class, 1082, 33980, 33984).size())) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((size) > 0) {
                Object otherValue = CallChecker.varInit(null, "otherValue", 1086, 34068, 34092);
                switch (size) {
                    case 3 :
                        if (CallChecker.beforeDeref(other, Map.class, 1089, 34187, 34191)) {
                            other = CallChecker.beforeCalled(other, Map.class, 1089, 34187, 34191);
                            if ((CallChecker.isCalled(other, Map.class, 1089, 34187, 34191).containsKey(key3)) == false) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(other, Map.class, 1092, 34316, 34320)) {
                            otherValue = other.get(key3);
                            CallChecker.varAssign(otherValue, "otherValue", 1092, 34303, 34331);
                        }else
                            throw new AbnormalExecutionError();
                        
                        if ((value3) == null) {
                            if (otherValue != null) {
                                return false;
                            }
                        }else {
                            if (!(value3.equals(otherValue))) {
                                return false;
                            }
                        }
                    case 2 :
                        if (CallChecker.beforeDeref(other, Map.class, 1097, 34533, 34537)) {
                            other = CallChecker.beforeCalled(other, Map.class, 1097, 34533, 34537);
                            if ((CallChecker.isCalled(other, Map.class, 1097, 34533, 34537).containsKey(key2)) == false) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(other, Map.class, 1100, 34662, 34666)) {
                            otherValue = other.get(key2);
                            CallChecker.varAssign(otherValue, "otherValue", 1100, 34649, 34677);
                        }else
                            throw new AbnormalExecutionError();
                        
                        if ((value2) == null) {
                            if (otherValue != null) {
                                return false;
                            }
                        }else {
                            if (!(value2.equals(otherValue))) {
                                return false;
                            }
                        }
                    case 1 :
                        if (CallChecker.beforeDeref(other, Map.class, 1105, 34879, 34883)) {
                            other = CallChecker.beforeCalled(other, Map.class, 1105, 34879, 34883);
                            if ((CallChecker.isCalled(other, Map.class, 1105, 34879, 34883).containsKey(key1)) == false) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(other, Map.class, 1108, 35008, 35012)) {
                            otherValue = other.get(key1);
                            CallChecker.varAssign(otherValue, "otherValue", 1108, 34995, 35023);
                        }else
                            throw new AbnormalExecutionError();
                        
                        if ((value1) == null) {
                            if (otherValue != null) {
                                return false;
                            }
                        }else {
                            if (!(value1.equals(otherValue))) {
                                return false;
                            }
                        }
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1267.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1268 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1123, 35233, 35870);
            CallChecker.varInit(this.delegateMap, "delegateMap", 1123, 35233, 35870);
            CallChecker.varInit(this.value3, "value3", 1123, 35233, 35870);
            CallChecker.varInit(this.value2, "value2", 1123, 35233, 35870);
            CallChecker.varInit(this.value1, "value1", 1123, 35233, 35870);
            CallChecker.varInit(this.key3, "key3", 1123, 35233, 35870);
            CallChecker.varInit(this.key2, "key2", 1123, 35233, 35870);
            CallChecker.varInit(this.key1, "key1", 1123, 35233, 35870);
            CallChecker.varInit(this.hash3, "hash3", 1123, 35233, 35870);
            CallChecker.varInit(this.hash2, "hash2", 1123, 35233, 35870);
            CallChecker.varInit(this.hash1, "hash1", 1123, 35233, 35870);
            CallChecker.varInit(this.size, "size", 1123, 35233, 35870);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 1123, 35233, 35870);
            if ((delegateMap) != null) {
                return delegateMap.hashCode();
            }
            int total = CallChecker.varInit(((int) (0)), "total", 1127, 35487, 35500);
            switch (size) {
                case 3 :
                    if ((value3) == null) {
                        total += (hash3) ^ 0;
                        CallChecker.varAssign(total, "total", 1130, 35579, 35638);
                    }else {
                        total += (hash3) ^ (value3.hashCode());
                        CallChecker.varAssign(total, "total", 1130, 35579, 35638);
                    }
                case 2 :
                    if ((value2) == null) {
                        total += (hash2) ^ 0;
                        CallChecker.varAssign(total, "total", 1132, 35676, 35735);
                    }else {
                        total += (hash2) ^ (value2.hashCode());
                        CallChecker.varAssign(total, "total", 1132, 35676, 35735);
                    }
                case 1 :
                    if ((value1) == null) {
                        total += (hash1) ^ 0;
                        CallChecker.varAssign(total, "total", 1134, 35773, 35832);
                    }else {
                        total += (hash1) ^ (value1.hashCode());
                        CallChecker.varAssign(total, "total", 1134, 35773, 35832);
                    }
            }
            return total;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1268.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1269 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1145, 35877, 36986);
            CallChecker.varInit(this.delegateMap, "delegateMap", 1145, 35877, 36986);
            CallChecker.varInit(this.value3, "value3", 1145, 35877, 36986);
            CallChecker.varInit(this.value2, "value2", 1145, 35877, 36986);
            CallChecker.varInit(this.value1, "value1", 1145, 35877, 36986);
            CallChecker.varInit(this.key3, "key3", 1145, 35877, 36986);
            CallChecker.varInit(this.key2, "key2", 1145, 35877, 36986);
            CallChecker.varInit(this.key1, "key1", 1145, 35877, 36986);
            CallChecker.varInit(this.hash3, "hash3", 1145, 35877, 36986);
            CallChecker.varInit(this.hash2, "hash2", 1145, 35877, 36986);
            CallChecker.varInit(this.hash1, "hash1", 1145, 35877, 36986);
            CallChecker.varInit(this.size, "size", 1145, 35877, 36986);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.Flat3Map.serialVersionUID", 1145, 35877, 36986);
            if ((delegateMap) != null) {
                return delegateMap.toString();
            }
            if ((size) == 0) {
                return "{}";
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(128), "buf", 1152, 36173, 36215);
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 1153, 36225, 36227)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1153, 36225, 36227);
                CallChecker.isCalled(buf, StringBuilder.class, 1153, 36225, 36227).append('{');
            }
            switch (size) {
                case 3 :
                    if ((key3) == (this)) {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1156, 36319, 36321)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1156, 36319, 36321);
                            CallChecker.isCalled(buf, StringBuilder.class, 1156, 36319, 36321).append("(this Map)");
                        }
                    }else {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1156, 36319, 36321)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1156, 36319, 36321);
                            CallChecker.isCalled(buf, StringBuilder.class, 1156, 36319, 36321).append(key3);
                        }
                    }
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 1157, 36385, 36387)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1157, 36385, 36387);
                        CallChecker.isCalled(buf, StringBuilder.class, 1157, 36385, 36387).append('=');
                    }else
                        throw new AbnormalExecutionError();
                    
                    if ((value3) == (this)) {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1158, 36418, 36420)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1158, 36418, 36420);
                            CallChecker.isCalled(buf, StringBuilder.class, 1158, 36418, 36420).append("(this Map)");
                        }
                    }else {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1158, 36418, 36420)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1158, 36418, 36420);
                            CallChecker.isCalled(buf, StringBuilder.class, 1158, 36418, 36420).append(value3);
                        }
                    }
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 1159, 36488, 36490)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1159, 36488, 36490);
                        CallChecker.isCalled(buf, StringBuilder.class, 1159, 36488, 36490).append(',');
                    }else
                        throw new AbnormalExecutionError();
                    
                case 2 :
                    if ((key2) == (this)) {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1161, 36541, 36543)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1161, 36541, 36543);
                            CallChecker.isCalled(buf, StringBuilder.class, 1161, 36541, 36543).append("(this Map)");
                        }
                    }else {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1161, 36541, 36543)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1161, 36541, 36543);
                            CallChecker.isCalled(buf, StringBuilder.class, 1161, 36541, 36543).append(key2);
                        }
                    }
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 1162, 36607, 36609)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1162, 36607, 36609);
                        CallChecker.isCalled(buf, StringBuilder.class, 1162, 36607, 36609).append('=');
                    }else
                        throw new AbnormalExecutionError();
                    
                    if ((value2) == (this)) {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1163, 36640, 36642)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1163, 36640, 36642);
                            CallChecker.isCalled(buf, StringBuilder.class, 1163, 36640, 36642).append("(this Map)");
                        }
                    }else {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1163, 36640, 36642)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1163, 36640, 36642);
                            CallChecker.isCalled(buf, StringBuilder.class, 1163, 36640, 36642).append(value2);
                        }
                    }
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 1164, 36710, 36712)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1164, 36710, 36712);
                        CallChecker.isCalled(buf, StringBuilder.class, 1164, 36710, 36712).append(',');
                    }else
                        throw new AbnormalExecutionError();
                    
                case 1 :
                    if ((key1) == (this)) {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1166, 36763, 36765)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1166, 36763, 36765);
                            CallChecker.isCalled(buf, StringBuilder.class, 1166, 36763, 36765).append("(this Map)");
                        }
                    }else {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1166, 36763, 36765)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1166, 36763, 36765);
                            CallChecker.isCalled(buf, StringBuilder.class, 1166, 36763, 36765).append(key1);
                        }
                    }
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 1167, 36829, 36831)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1167, 36829, 36831);
                        CallChecker.isCalled(buf, StringBuilder.class, 1167, 36829, 36831).append('=');
                    }else
                        throw new AbnormalExecutionError();
                    
                    if ((value1) == (this)) {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1168, 36862, 36864)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1168, 36862, 36864);
                            CallChecker.isCalled(buf, StringBuilder.class, 1168, 36862, 36864).append("(this Map)");
                        }
                    }else {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 1168, 36862, 36864)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1168, 36862, 36864);
                            CallChecker.isCalled(buf, StringBuilder.class, 1168, 36862, 36864).append(value1);
                        }
                    }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 1170, 36934, 36936)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1170, 36934, 36936);
                CallChecker.isCalled(buf, StringBuilder.class, 1170, 36934, 36936).append('}');
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 1171, 36966, 36968)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 1171, 36966, 36968);
                return CallChecker.isCalled(buf, StringBuilder.class, 1171, 36966, 36968).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1269.methodEnd();
        }
    }
}

