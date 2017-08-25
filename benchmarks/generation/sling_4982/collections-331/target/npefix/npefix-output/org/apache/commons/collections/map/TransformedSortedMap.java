package org.apache.commons.collections.map;

import org.apache.commons.collections.Transformer;
import java.util.SortedMap;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class TransformedSortedMap<K, V> extends TransformedMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = -8751771676410385778L;

    public static <K, V> SortedMap<K, V> decorate(SortedMap<K, V> map, Transformer<? super K, ? extends K> keyTransformer, Transformer<? super V, ? extends V> valueTransformer) {
        MethodContext _bcornu_methode_context686 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(valueTransformer, "valueTransformer", 65, 2226, 3075);
            CallChecker.varInit(keyTransformer, "keyTransformer", 65, 2226, 3075);
            CallChecker.varInit(map, "map", 65, 2226, 3075);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedSortedMap.serialVersionUID", 65, 2226, 3075);
            return new TransformedSortedMap<K, V>(map, keyTransformer, valueTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context686.methodEnd();
        }
    }

    public static <K, V> SortedMap<K, V> decorateTransform(SortedMap<K, V> map, Transformer<? super K, ? extends K> keyTransformer, Transformer<? super V, ? extends V> valueTransformer) {
        MethodContext _bcornu_methode_context687 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(valueTransformer, "valueTransformer", 85, 3082, 4343);
            CallChecker.varInit(keyTransformer, "keyTransformer", 85, 3082, 4343);
            CallChecker.varInit(map, "map", 85, 3082, 4343);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedSortedMap.serialVersionUID", 85, 3082, 4343);
            TransformedSortedMap<K, V> decorated = CallChecker.varInit(new TransformedSortedMap<K, V>(map, keyTransformer, valueTransformer), "decorated", 88, 3979, 4087);
            if (CallChecker.beforeDeref(map, SortedMap.class, 89, 4101, 4103)) {
                map = CallChecker.beforeCalled(map, SortedMap.class, 89, 4101, 4103);
                if ((CallChecker.isCalled(map, SortedMap.class, 89, 4101, 4103).size()) > 0) {
                    Map<K, V> transformed = CallChecker.init(Map.class);
                    if (CallChecker.beforeDeref(decorated, TransformedSortedMap.class, 90, 4155, 4163)) {
                        decorated = CallChecker.beforeCalled(decorated, TransformedSortedMap.class, 90, 4155, 4163);
                        transformed = CallChecker.isCalled(decorated, TransformedSortedMap.class, 90, 4155, 4163).transformMap(map);
                        CallChecker.varAssign(transformed, "transformed", 90, 4155, 4163);
                    }
                    if (CallChecker.beforeDeref(decorated, TransformedSortedMap.class, 91, 4196, 4204)) {
                        decorated = CallChecker.beforeCalled(decorated, TransformedSortedMap.class, 91, 4196, 4204);
                        CallChecker.isCalled(decorated, TransformedSortedMap.class, 91, 4196, 4204).clear();
                    }
                    if (CallChecker.beforeDeref(decorated, TransformedSortedMap.class, 92, 4227, 4235)) {
                        decorated = CallChecker.beforeCalled(decorated, TransformedSortedMap.class, 92, 4227, 4235);
                        final Map<K, V> npe_invocation_var170 = CallChecker.isCalled(decorated, TransformedSortedMap.class, 92, 4227, 4235).decorated();
                        if (CallChecker.beforeDeref(npe_invocation_var170, Map.class, 92, 4227, 4247)) {
                            CallChecker.isCalled(npe_invocation_var170, Map.class, 92, 4227, 4247).putAll(transformed);
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return decorated;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context687.methodEnd();
        }
    }

    protected TransformedSortedMap(SortedMap<K, V> map, Transformer<? super K, ? extends K> keyTransformer, Transformer<? super V, ? extends V> valueTransformer) {
        super(map, keyTransformer, valueTransformer);
        MethodContext _bcornu_methode_context121 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context121.methodEnd();
        }
    }

    protected SortedMap<K, V> getSortedMap() {
        MethodContext _bcornu_methode_context688 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 121, 5178, 5435);
            CallChecker.varInit(this.map, "map", 121, 5178, 5435);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 121, 5178, 5435);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 121, 5178, 5435);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedSortedMap.serialVersionUID", 121, 5178, 5435);
            return ((SortedMap<K, V>) (map));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context688.methodEnd();
        }
    }

    public K firstKey() {
        final SortedMap<K, V> npe_invocation_var171 = getSortedMap();
        if (CallChecker.beforeDeref(npe_invocation_var171, SortedMap.class, 127, 5557, 5570)) {
            return npe_invocation_var171.firstKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K lastKey() {
        final SortedMap<K, V> npe_invocation_var172 = getSortedMap();
        if (CallChecker.beforeDeref(npe_invocation_var172, SortedMap.class, 131, 5631, 5644)) {
            return npe_invocation_var172.lastKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Comparator<? super K> comparator() {
        MethodContext _bcornu_methode_context691 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 134, 5668, 5760);
            CallChecker.varInit(this.map, "map", 134, 5668, 5760);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 134, 5668, 5760);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 134, 5668, 5760);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedSortedMap.serialVersionUID", 134, 5668, 5760);
            final SortedMap<K, V> npe_invocation_var173 = getSortedMap();
            if (CallChecker.beforeDeref(npe_invocation_var173, SortedMap.class, 135, 5727, 5740)) {
                return CallChecker.isCalled(npe_invocation_var173, SortedMap.class, 135, 5727, 5740).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context691.methodEnd();
        }
    }

    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        MethodContext _bcornu_methode_context692 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 138, 5767, 5978);
            CallChecker.varInit(toKey, "toKey", 138, 5767, 5978);
            CallChecker.varInit(fromKey, "fromKey", 138, 5767, 5978);
            CallChecker.varInit(this.map, "map", 138, 5767, 5978);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 138, 5767, 5978);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 138, 5767, 5978);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedSortedMap.serialVersionUID", 138, 5767, 5978);
            final SortedMap<K, V> npe_invocation_var174 = getSortedMap();
            SortedMap<K, V> map = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var174, SortedMap.class, 139, 5849, 5862)) {
                map = CallChecker.isCalled(npe_invocation_var174, SortedMap.class, 139, 5849, 5862).subMap(fromKey, toKey);
                CallChecker.varAssign(map, "map", 139, 5849, 5862);
            }
            return new TransformedSortedMap<K, V>(map, keyTransformer, valueTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context692.methodEnd();
        }
    }

    public SortedMap<K, V> headMap(K toKey) {
        MethodContext _bcornu_methode_context693 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 143, 5985, 6178);
            CallChecker.varInit(toKey, "toKey", 143, 5985, 6178);
            CallChecker.varInit(this.map, "map", 143, 5985, 6178);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 143, 5985, 6178);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 143, 5985, 6178);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedSortedMap.serialVersionUID", 143, 5985, 6178);
            final SortedMap<K, V> npe_invocation_var175 = getSortedMap();
            SortedMap<K, V> map = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var175, SortedMap.class, 144, 6057, 6070)) {
                map = CallChecker.isCalled(npe_invocation_var175, SortedMap.class, 144, 6057, 6070).headMap(toKey);
                CallChecker.varAssign(map, "map", 144, 6057, 6070);
            }
            return new TransformedSortedMap<K, V>(map, keyTransformer, valueTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context693.methodEnd();
        }
    }

    public SortedMap<K, V> tailMap(K fromKey) {
        MethodContext _bcornu_methode_context694 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 148, 6185, 6382);
            CallChecker.varInit(fromKey, "fromKey", 148, 6185, 6382);
            CallChecker.varInit(this.map, "map", 148, 6185, 6382);
            CallChecker.varInit(this.valueTransformer, "valueTransformer", 148, 6185, 6382);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 148, 6185, 6382);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.TransformedSortedMap.serialVersionUID", 148, 6185, 6382);
            final SortedMap<K, V> npe_invocation_var176 = getSortedMap();
            SortedMap<K, V> map = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var176, SortedMap.class, 149, 6259, 6272)) {
                map = CallChecker.isCalled(npe_invocation_var176, SortedMap.class, 149, 6259, 6272).tailMap(fromKey);
                CallChecker.varAssign(map, "map", 149, 6259, 6272);
            }
            return new TransformedSortedMap<K, V>(map, keyTransformer, valueTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context694.methodEnd();
        }
    }
}

