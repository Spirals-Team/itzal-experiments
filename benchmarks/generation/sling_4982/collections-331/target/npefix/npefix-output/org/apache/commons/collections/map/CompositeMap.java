package org.apache.commons.collections.map;

import java.util.Set;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.collection.CompositeCollection;
import org.apache.commons.collections.set.CompositeSet;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;

public class CompositeMap<K, V> extends AbstractIterableMap<K, V> implements Serializable {
    private static final long serialVersionUID = -6096931280583808322L;

    private Map<K, V>[] composite;

    private CompositeMap.MapMutator<K, V> mutator;

    @SuppressWarnings(value = "unchecked")
    public CompositeMap() {
        this(new Map[]{  }, null);
        MethodContext _bcornu_methode_context197 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context197.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public CompositeMap(Map<K, V> one, Map<K, V> two) {
        this(new Map[]{ one , two }, null);
        MethodContext _bcornu_methode_context198 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context198.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public CompositeMap(Map<K, V> one, Map<K, V> two, CompositeMap.MapMutator<K, V> mutator) {
        this(new Map[]{ one , two }, mutator);
        MethodContext _bcornu_methode_context199 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context199.methodEnd();
        }
    }

    public CompositeMap(Map<K, V>[] composite) {
        this(composite, null);
        MethodContext _bcornu_methode_context200 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context200.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public CompositeMap(Map<K, V>[] composite, CompositeMap.MapMutator<K, V> mutator) {
        MethodContext _bcornu_methode_context201 = new MethodContext(null);
        try {
            this.mutator = mutator;
            CallChecker.varAssign(this.mutator, "this.mutator", 110, 4144, 4166);
            this.composite = new Map[0];
            CallChecker.varAssign(this.composite, "this.composite", 111, 4176, 4203);
            composite = CallChecker.beforeCalled(composite, Map[].class, 112, 4226, 4234);
            for (int i = (CallChecker.isCalled(composite, Map[].class, 112, 4226, 4234).length) - 1; i >= 0; --i) {
                if (CallChecker.beforeDeref(composite, Map[].class, 113, 4294, 4302)) {
                    composite = CallChecker.beforeCalled(composite, Map[].class, 113, 4294, 4302);
                    this.addComposited(CallChecker.isCalled(composite, Map[].class, 113, 4294, 4302)[i]);
                }
            }
        } finally {
            _bcornu_methode_context201.methodEnd();
        }
    }

    public void setMutator(CompositeMap.MapMutator<K, V> mutator) {
        MethodContext _bcornu_methode_context1030 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 123, 4330, 4656);
            CallChecker.varInit(mutator, "mutator", 123, 4330, 4656);
            CallChecker.varInit(this.mutator, "mutator", 123, 4330, 4656);
            CallChecker.varInit(this.composite, "composite", 123, 4330, 4656);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 123, 4330, 4656);
            this.mutator = mutator;
            CallChecker.varAssign(this.mutator, "this.mutator", 124, 4628, 4650);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1030.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public synchronized void addComposited(Map<K, V> map) throws IllegalArgumentException {
        MethodContext _bcornu_methode_context1031 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 135, 4663, 5735);
            CallChecker.varInit(map, "map", 135, 4663, 5735);
            CallChecker.varInit(this.mutator, "mutator", 135, 4663, 5735);
            CallChecker.varInit(this.composite, "composite", 135, 4663, 5735);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 135, 4663, 5735);
            composite = CallChecker.beforeCalled(composite, Map[].class, 136, 5061, 5069);
            for (int i = (CallChecker.isCalled(composite, Map[].class, 136, 5061, 5069).length) - 1; i >= 0; --i) {
                Collection<K> intersect = CallChecker.init(Collection.class);
                if (CallChecker.beforeDeref(this.composite, Map[].class, 137, 5165, 5178)) {
                    this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 137, 5165, 5178);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 137, 5165, 5178)[i], Map.class, 137, 5165, 5181)) {
                        if (CallChecker.beforeDeref(map, Map.class, 137, 5193, 5195)) {
                            this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 137, 5165, 5178);
                            CallChecker.isCalled(this.composite, Map[].class, 137, 5165, 5178)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.composite, Map[].class, 137, 5165, 5178)[i], Map.class, 137, 5165, 5181);
                            map = CallChecker.beforeCalled(map, Map.class, 137, 5193, 5195);
                            intersect = CollectionUtils.intersection(CallChecker.isCalled(CallChecker.isCalled(this.composite, Map[].class, 137, 5165, 5178)[i], Map.class, 137, 5165, 5181).keySet(), CallChecker.isCalled(map, Map.class, 137, 5193, 5195).keySet());
                            CallChecker.varAssign(intersect, "intersect", 137, 5165, 5178);
                        }
                    }
                }
                if (CallChecker.beforeDeref(intersect, Collection.class, 138, 5224, 5232)) {
                    intersect = CallChecker.beforeCalled(intersect, Collection.class, 138, 5224, 5232);
                    if ((CallChecker.isCalled(intersect, Collection.class, 138, 5224, 5232).size()) != 0) {
                        if ((this.mutator) == null) {
                            throw new IllegalArgumentException("Key collision adding Map to CompositeMap");
                        }
                        if (CallChecker.beforeDeref(this.composite, Map[].class, 142, 5463, 5476)) {
                            this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 142, 5463, 5476);
                            this.mutator.resolveCollision(this, CallChecker.isCalled(this.composite, Map[].class, 142, 5463, 5476)[i], map, intersect);
                        }
                    }
                }
            }
            Map<K, V>[] temp = CallChecker.init(Map[].class);
            if (CallChecker.beforeDeref(this.composite, Map[].class, 145, 5558, 5571)) {
                this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 145, 5558, 5571);
                temp = new Map[(CallChecker.isCalled(this.composite, Map[].class, 145, 5558, 5571).length) + 1];
                CallChecker.varAssign(temp, "temp", 145, 5558, 5571);
            }
            if (CallChecker.beforeDeref(this.composite, Map[].class, 146, 5639, 5652)) {
                this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 146, 5639, 5652);
                System.arraycopy(this.composite, 0, temp, 0, CallChecker.isCalled(this.composite, Map[].class, 146, 5639, 5652).length);
            }
            if (CallChecker.beforeDeref(temp, Map[].class, 147, 5676, 5679)) {
                if (CallChecker.beforeDeref(temp, Map[].class, 147, 5671, 5674)) {
                    temp = CallChecker.beforeCalled(temp, Map[].class, 147, 5676, 5679);
                    temp = CallChecker.beforeCalled(temp, Map[].class, 147, 5671, 5674);
                    CallChecker.isCalled(temp, Map[].class, 147, 5671, 5674)[((CallChecker.isCalled(temp, Map[].class, 147, 5676, 5679).length) - 1)] = map;
                    CallChecker.varAssign(CallChecker.isCalled(temp, Map[].class, 147, 5671, 5674)[((CallChecker.isCalled(temp, Map[].class, 147, 5676, 5679).length) - 1)], "CallChecker.isCalled(temp, Map[].class, 147, 5671, 5674)[((CallChecker.isCalled(temp, Map[].class, 147, 5676, 5679).length) - 1)]", 147, 5671, 5698);
                }
            }
            this.composite = temp;
            CallChecker.varAssign(this.composite, "this.composite", 148, 5708, 5729);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1031.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public synchronized Map<K, V> removeComposited(Map<K, V> map) {
        MethodContext _bcornu_methode_context1032 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 158, 5742, 6494);
            CallChecker.varInit(map, "map", 158, 5742, 6494);
            CallChecker.varInit(this.mutator, "mutator", 158, 5742, 6494);
            CallChecker.varInit(this.composite, "composite", 158, 5742, 6494);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 158, 5742, 6494);
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(this.composite, Map[].class, 159, 6066, 6079)) {
                this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 159, 6066, 6079);
                size = CallChecker.isCalled(this.composite, Map[].class, 159, 6066, 6079).length;
                CallChecker.varAssign(size, "size", 159, 6066, 6079);
            }
            for (int i = 0; i < size; ++i) {
                if (CallChecker.beforeDeref(this.composite, Map[].class, 161, 6146, 6159)) {
                    this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 161, 6146, 6159);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 161, 6146, 6159)[i], Map.class, 161, 6146, 6162)) {
                        this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 161, 6146, 6159);
                        CallChecker.isCalled(this.composite, Map[].class, 161, 6146, 6159)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.composite, Map[].class, 161, 6146, 6159)[i], Map.class, 161, 6146, 6162);
                        if (CallChecker.isCalled(CallChecker.isCalled(this.composite, Map[].class, 161, 6146, 6159)[i], Map.class, 161, 6146, 6162).equals(map)) {
                            Map<K, V>[] temp = CallChecker.varInit(new Map[size - 1], "temp", 162, 6195, 6231);
                            System.arraycopy(this.composite, 0, temp, 0, i);
                            System.arraycopy(this.composite, (i + 1), temp, i, ((size - i) - 1));
                            this.composite = temp;
                            CallChecker.varAssign(this.composite, "this.composite", 165, 6394, 6415);
                            return map;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1032.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context1033 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 178, 6501, 6896);
            CallChecker.varInit(this.mutator, "mutator", 178, 6501, 6896);
            CallChecker.varInit(this.composite, "composite", 178, 6501, 6896);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 178, 6501, 6896);
            this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 179, 6801, 6814);
            for (int i = (CallChecker.isCalled(this.composite, Map[].class, 179, 6801, 6814).length) - 1; i >= 0; --i) {
                if (CallChecker.beforeDeref(this.composite, Map[].class, 180, 6855, 6868)) {
                    this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 180, 6855, 6868);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 180, 6855, 6868)[i], Map.class, 180, 6855, 6871)) {
                        this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 180, 6855, 6868);
                        CallChecker.isCalled(this.composite, Map[].class, 180, 6855, 6868)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.composite, Map[].class, 180, 6855, 6868)[i], Map.class, 180, 6855, 6871);
                        CallChecker.isCalled(CallChecker.isCalled(this.composite, Map[].class, 180, 6855, 6868)[i], Map.class, 180, 6855, 6871).clear();
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1033.methodEnd();
        }
    }

    public boolean containsKey(Object key) {
        MethodContext _bcornu_methode_context1034 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 200, 6903, 7910);
            CallChecker.varInit(key, "key", 200, 6903, 7910);
            CallChecker.varInit(this.mutator, "mutator", 200, 6903, 7910);
            CallChecker.varInit(this.composite, "composite", 200, 6903, 7910);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 200, 6903, 7910);
            this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 201, 7735, 7748);
            for (int i = (CallChecker.isCalled(this.composite, Map[].class, 201, 7735, 7748).length) - 1; i >= 0; --i) {
                if (CallChecker.beforeDeref(this.composite, Map[].class, 202, 7793, 7806)) {
                    this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 202, 7793, 7806);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 202, 7793, 7806)[i], Map.class, 202, 7793, 7809)) {
                        this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 202, 7793, 7806);
                        CallChecker.isCalled(this.composite, Map[].class, 202, 7793, 7806)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.composite, Map[].class, 202, 7793, 7806)[i], Map.class, 202, 7793, 7809);
                        if (CallChecker.isCalled(CallChecker.isCalled(this.composite, Map[].class, 202, 7793, 7806)[i], Map.class, 202, 7793, 7809).containsKey(key)) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1034.methodEnd();
        }
    }

    public boolean containsValue(Object value) {
        MethodContext _bcornu_methode_context1035 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 225, 7917, 9042);
            CallChecker.varInit(value, "value", 225, 7917, 9042);
            CallChecker.varInit(this.mutator, "mutator", 225, 7917, 9042);
            CallChecker.varInit(this.composite, "composite", 225, 7917, 9042);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 225, 7917, 9042);
            this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 226, 8863, 8876);
            for (int i = (CallChecker.isCalled(this.composite, Map[].class, 226, 8863, 8876).length) - 1; i >= 0; --i) {
                if (CallChecker.beforeDeref(this.composite, Map[].class, 227, 8921, 8934)) {
                    this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 227, 8921, 8934);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 227, 8921, 8934)[i], Map.class, 227, 8921, 8937)) {
                        this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 227, 8921, 8934);
                        CallChecker.isCalled(this.composite, Map[].class, 227, 8921, 8934)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.composite, Map[].class, 227, 8921, 8934)[i], Map.class, 227, 8921, 8937);
                        if (CallChecker.isCalled(CallChecker.isCalled(this.composite, Map[].class, 227, 8921, 8934)[i], Map.class, 227, 8921, 8937).containsValue(value)) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1035.methodEnd();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        MethodContext _bcornu_methode_context1036 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 251, 9049, 10266);
            CallChecker.varInit(this.mutator, "mutator", 251, 9049, 10266);
            CallChecker.varInit(this.composite, "composite", 251, 9049, 10266);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 251, 9049, 10266);
            CompositeSet<Map.Entry<K, V>> entries = CallChecker.varInit(new CompositeSet<Map.Entry<K, V>>(), "entries", 252, 10034, 10108);
            composite = CallChecker.beforeCalled(composite, Map[].class, 253, 10131, 10139);
            for (int i = (CallChecker.isCalled(composite, Map[].class, 253, 10131, 10139).length) - 1; i >= 0; --i) {
                if (CallChecker.beforeDeref(composite, Map[].class, 254, 10202, 10210)) {
                    composite = CallChecker.beforeCalled(composite, Map[].class, 254, 10202, 10210);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(composite, Map[].class, 254, 10202, 10210)[i], Map.class, 254, 10202, 10213)) {
                        if (CallChecker.beforeDeref(entries, CompositeSet.class, 254, 10180, 10186)) {
                            composite = CallChecker.beforeCalled(composite, Map[].class, 254, 10202, 10210);
                            CallChecker.isCalled(composite, Map[].class, 254, 10202, 10210)[i] = CallChecker.beforeCalled(CallChecker.isCalled(composite, Map[].class, 254, 10202, 10210)[i], Map.class, 254, 10202, 10213);
                            entries = CallChecker.beforeCalled(entries, CompositeSet.class, 254, 10180, 10186);
                            CallChecker.isCalled(entries, CompositeSet.class, 254, 10180, 10186).addComposited(CallChecker.isCalled(CallChecker.isCalled(composite, Map[].class, 254, 10202, 10210)[i], Map.class, 254, 10202, 10213).entrySet());
                        }
                    }
                }
            }
            return entries;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Map.Entry<K, V>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1036.methodEnd();
        }
    }

    public V get(Object key) {
        this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 284, 11589, 11602);
        for (int i = (CallChecker.isCalled(this.composite, Map[].class, 284, 11589, 11602).length) - 1; i >= 0; --i) {
            if (CallChecker.beforeDeref(this.composite, Map[].class, 285, 11647, 11660)) {
                this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 285, 11647, 11660);
                if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 285, 11647, 11660)[i], Map.class, 285, 11647, 11663)) {
                    this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 285, 11647, 11660);
                    CallChecker.isCalled(this.composite, Map[].class, 285, 11647, 11660)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.composite, Map[].class, 285, 11647, 11660)[i], Map.class, 285, 11647, 11663);
                    if (CallChecker.isCalled(CallChecker.isCalled(this.composite, Map[].class, 285, 11647, 11660)[i], Map.class, 285, 11647, 11663).containsKey(key)) {
                        if (CallChecker.beforeDeref(this.composite, Map[].class, 286, 11708, 11721)) {
                            this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 286, 11708, 11721);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 286, 11708, 11721)[i], Map.class, 286, 11708, 11724)) {
                                this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 286, 11708, 11721);
                                return CallChecker.isCalled(this.composite, Map[].class, 286, 11708, 11721)[i].get(key);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        }
        return null;
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1038 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 297, 11792, 12178);
            CallChecker.varInit(this.mutator, "mutator", 297, 11792, 12178);
            CallChecker.varInit(this.composite, "composite", 297, 11792, 12178);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 297, 11792, 12178);
            this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 298, 12009, 12022);
            for (int i = (CallChecker.isCalled(this.composite, Map[].class, 298, 12009, 12022).length) - 1; i >= 0; --i) {
                if (CallChecker.beforeDeref(this.composite, Map[].class, 299, 12068, 12081)) {
                    this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 299, 12068, 12081);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 299, 12068, 12081)[i], Map.class, 299, 12068, 12084)) {
                        this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 299, 12068, 12081);
                        CallChecker.isCalled(this.composite, Map[].class, 299, 12068, 12081)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.composite, Map[].class, 299, 12068, 12081)[i], Map.class, 299, 12068, 12084);
                        if (!(CallChecker.isCalled(CallChecker.isCalled(this.composite, Map[].class, 299, 12068, 12081)[i], Map.class, 299, 12068, 12084).isEmpty())) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1038.methodEnd();
        }
    }

    public Set<K> keySet() {
        MethodContext _bcornu_methode_context1039 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 321, 12185, 13244);
            CallChecker.varInit(this.mutator, "mutator", 321, 12185, 13244);
            CallChecker.varInit(this.composite, "composite", 321, 12185, 13244);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 321, 12185, 13244);
            CompositeSet<K> keys = CallChecker.varInit(new CompositeSet<K>(), "keys", 322, 13040, 13084);
            this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 323, 13107, 13120);
            for (int i = (CallChecker.isCalled(this.composite, Map[].class, 323, 13107, 13120).length) - 1; i >= 0; --i) {
                if (CallChecker.beforeDeref(this.composite, Map[].class, 324, 13180, 13193)) {
                    this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 324, 13180, 13193);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 324, 13180, 13193)[i], Map.class, 324, 13180, 13196)) {
                        if (CallChecker.beforeDeref(keys, CompositeSet.class, 324, 13161, 13164)) {
                            this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 324, 13180, 13193);
                            CallChecker.isCalled(this.composite, Map[].class, 324, 13180, 13193)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.composite, Map[].class, 324, 13180, 13193)[i], Map.class, 324, 13180, 13196);
                            keys = CallChecker.beforeCalled(keys, CompositeSet.class, 324, 13161, 13164);
                            CallChecker.isCalled(keys, CompositeSet.class, 324, 13161, 13164).addComposited(CallChecker.isCalled(CallChecker.isCalled(this.composite, Map[].class, 324, 13180, 13193)[i], Map.class, 324, 13180, 13196).keySet());
                        }
                    }
                }
            }
            return keys;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1039.methodEnd();
        }
    }

    public V put(K key, V value) {
        if ((this.mutator) == null) {
            throw new UnsupportedOperationException("No mutator specified");
        }
        return this.mutator.put(this, this.composite, key, value);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        MethodContext _bcornu_methode_context1041 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 383, 14922, 16329);
            CallChecker.varInit(map, "map", 383, 14922, 16329);
            CallChecker.varInit(this.mutator, "mutator", 383, 14922, 16329);
            CallChecker.varInit(this.composite, "composite", 383, 14922, 16329);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 383, 14922, 16329);
            if ((this.mutator) == null) {
                throw new UnsupportedOperationException("No mutator specified");
            }
            this.mutator.putAll(this, this.composite, map);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1041.methodEnd();
        }
    }

    public V remove(Object key) {
        this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 416, 17815, 17828);
        for (int i = (CallChecker.isCalled(this.composite, Map[].class, 416, 17815, 17828).length) - 1; i >= 0; --i) {
            if (CallChecker.beforeDeref(this.composite, Map[].class, 417, 17873, 17886)) {
                this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 417, 17873, 17886);
                if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 417, 17873, 17886)[i], Map.class, 417, 17873, 17889)) {
                    this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 417, 17873, 17886);
                    CallChecker.isCalled(this.composite, Map[].class, 417, 17873, 17886)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.composite, Map[].class, 417, 17873, 17886)[i], Map.class, 417, 17873, 17889);
                    if (CallChecker.isCalled(CallChecker.isCalled(this.composite, Map[].class, 417, 17873, 17886)[i], Map.class, 417, 17873, 17889).containsKey(key)) {
                        if (CallChecker.beforeDeref(this.composite, Map[].class, 418, 17934, 17947)) {
                            this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 418, 17934, 17947);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 418, 17934, 17947)[i], Map.class, 418, 17934, 17950)) {
                                this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 418, 17934, 17947);
                                return CallChecker.isCalled(this.composite, Map[].class, 418, 17934, 17947)[i].remove(key);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        }
        return null;
    }

    public int size() {
        MethodContext _bcornu_methode_context1043 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 431, 18021, 18470);
            CallChecker.varInit(this.mutator, "mutator", 431, 18021, 18470);
            CallChecker.varInit(this.composite, "composite", 431, 18021, 18470);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 431, 18021, 18470);
            int size = CallChecker.varInit(((int) (0)), "size", 432, 18312, 18324);
            this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 433, 18347, 18360);
            for (int i = (CallChecker.isCalled(this.composite, Map[].class, 433, 18347, 18360).length) - 1; i >= 0; --i) {
                if (CallChecker.beforeDeref(this.composite, Map[].class, 434, 18409, 18422)) {
                    this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 434, 18409, 18422);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(this.composite, Map[].class, 434, 18409, 18422)[i], Map.class, 434, 18409, 18425)) {
                        this.composite = CallChecker.beforeCalled(this.composite, Map[].class, 434, 18409, 18422);
                        CallChecker.isCalled(this.composite, Map[].class, 434, 18409, 18422)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.composite, Map[].class, 434, 18409, 18422)[i], Map.class, 434, 18409, 18425);
                        size += CallChecker.isCalled(CallChecker.isCalled(this.composite, Map[].class, 434, 18409, 18422)[i], Map.class, 434, 18409, 18425).size();
                        CallChecker.varAssign(size, "size", 434, 18401, 18433);
                    }
                }
            }
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1043.methodEnd();
        }
    }

    public Collection<V> values() {
        MethodContext _bcornu_methode_context1044 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 452, 18477, 19469);
            CallChecker.varInit(this.mutator, "mutator", 452, 18477, 19469);
            CallChecker.varInit(this.composite, "composite", 452, 18477, 19469);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 452, 18477, 19469);
            CompositeCollection<V> values = CallChecker.varInit(new CompositeCollection<V>(), "values", 453, 19255, 19315);
            composite = CallChecker.beforeCalled(composite, Map[].class, 454, 19338, 19346);
            for (int i = (CallChecker.isCalled(composite, Map[].class, 454, 19338, 19346).length) - 1; i >= 0; --i) {
                if (CallChecker.beforeDeref(composite, Map[].class, 455, 19408, 19416)) {
                    composite = CallChecker.beforeCalled(composite, Map[].class, 455, 19408, 19416);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(composite, Map[].class, 455, 19408, 19416)[i], Map.class, 455, 19408, 19419)) {
                        if (CallChecker.beforeDeref(values, CompositeCollection.class, 455, 19387, 19392)) {
                            composite = CallChecker.beforeCalled(composite, Map[].class, 455, 19408, 19416);
                            CallChecker.isCalled(composite, Map[].class, 455, 19408, 19416)[i] = CallChecker.beforeCalled(CallChecker.isCalled(composite, Map[].class, 455, 19408, 19416)[i], Map.class, 455, 19408, 19419);
                            values = CallChecker.beforeCalled(values, CompositeCollection.class, 455, 19387, 19392);
                            CallChecker.isCalled(values, CompositeCollection.class, 455, 19387, 19392).addComposited(CallChecker.isCalled(CallChecker.isCalled(composite, Map[].class, 455, 19408, 19416)[i], Map.class, 455, 19408, 19419).values());
                        }
                    }
                }
            }
            return values;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1044.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1045 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 467, 19476, 19882);
            CallChecker.varInit(obj, "obj", 467, 19476, 19882);
            CallChecker.varInit(this.mutator, "mutator", 467, 19476, 19882);
            CallChecker.varInit(this.composite, "composite", 467, 19476, 19882);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 467, 19476, 19882);
            if (obj instanceof Map) {
                Map<?, ?> map = CallChecker.varInit(((Map<?, ?>) (obj)), "map", 469, 19752, 19783);
                if (CallChecker.beforeDeref(map, Map.class, 470, 19828, 19830)) {
                    final Set<Map.Entry<K, V>> npe_invocation_var229 = this.entrySet();
                    if (CallChecker.beforeDeref(npe_invocation_var229, Set.class, 470, 19805, 19819)) {
                        map = CallChecker.beforeCalled(map, Map.class, 470, 19828, 19830);
                        return CallChecker.isCalled(npe_invocation_var229, Set.class, 470, 19805, 19819).equals(CallChecker.isCalled(map, Map.class, 470, 19828, 19830).entrySet());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1045.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1046 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 479, 19889, 20155);
            CallChecker.varInit(this.mutator, "mutator", 479, 19889, 20155);
            CallChecker.varInit(this.composite, "composite", 479, 19889, 20155);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.CompositeMap.serialVersionUID", 479, 19889, 20155);
            int code = CallChecker.varInit(((int) (0)), "code", 480, 20017, 20029);
            for (Map.Entry<K, V> entry : entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 482, 20102, 20106)) {
                    code += CallChecker.isCalled(entry, Map.Entry.class, 482, 20102, 20106).hashCode();
                    CallChecker.varAssign(code, "code", 482, 20094, 20118);
                }
            }
            return code;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1046.methodEnd();
        }
    }

    public static interface MapMutator<K, V> extends Serializable {
        public void resolveCollision(CompositeMap<K, V> composite, Map<K, V> existing, Map<K, V> added, Collection<K> intersect);

        public V put(CompositeMap<K, V> map, Map<K, V>[] composited, K key, V value);

        public void putAll(CompositeMap<K, V> map, Map<K, V>[] composited, Map<? extends K, ? extends V> mapToAdd);
    }
}

