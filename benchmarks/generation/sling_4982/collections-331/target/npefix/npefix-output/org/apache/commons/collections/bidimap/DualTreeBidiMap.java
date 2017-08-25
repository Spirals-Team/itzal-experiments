package org.apache.commons.collections.bidimap;

import java.util.TreeMap;
import java.util.SortedMap;
import org.apache.commons.collections.SortedBidiMap;
import java.util.Set;
import java.io.Serializable;
import org.apache.commons.collections.ResettableIterator;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.BidiMap;
import java.util.ArrayList;
import org.apache.commons.collections.map.AbstractSortedMapDecorator;
import org.apache.commons.collections.map.AbstractMapDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;

public class DualTreeBidiMap<K, V> extends AbstractDualBidiMap<K, V> implements Serializable , SortedBidiMap<K, V> {
    private static final long serialVersionUID = 721969328361809L;

    protected final Comparator<? super K> comparator;

    protected final Comparator<? super V> valueComparator;

    public DualTreeBidiMap() {
        super(new TreeMap<K, V>(), new TreeMap<V, K>());
        MethodContext _bcornu_methode_context172 = new MethodContext(null);
        try {
            this.comparator = null;
            CallChecker.varAssign(this.comparator, "this.comparator", 75, 2943, 2965);
            this.valueComparator = null;
            CallChecker.varAssign(this.valueComparator, "this.valueComparator", 76, 2975, 3002);
        } finally {
            _bcornu_methode_context172.methodEnd();
        }
    }

    public DualTreeBidiMap(Map<K, V> map) {
        super(new TreeMap<K, V>(), new TreeMap<V, K>());
        MethodContext _bcornu_methode_context173 = new MethodContext(null);
        try {
            putAll(map);
            this.comparator = null;
            CallChecker.varAssign(this.comparator, "this.comparator", 88, 3348, 3370);
            this.valueComparator = null;
            CallChecker.varAssign(this.valueComparator, "this.valueComparator", 89, 3380, 3407);
        } finally {
            _bcornu_methode_context173.methodEnd();
        }
    }

    public DualTreeBidiMap(Comparator<? super K> keyComparator, Comparator<? super V> valueComparator) {
        super(new TreeMap<K, V>(keyComparator), new TreeMap<V, K>(valueComparator));
        MethodContext _bcornu_methode_context174 = new MethodContext(null);
        try {
            this.comparator = keyComparator;
            CallChecker.varAssign(this.comparator, "this.comparator", 99, 3762, 3793);
            this.valueComparator = valueComparator;
            CallChecker.varAssign(this.valueComparator, "this.valueComparator", 100, 3803, 3841);
        } finally {
            _bcornu_methode_context174.methodEnd();
        }
    }

    protected DualTreeBidiMap(Map<K, V> normalMap, Map<V, K> reverseMap, BidiMap<V, K> inverseBidiMap) {
        super(normalMap, reverseMap, inverseBidiMap);
        MethodContext _bcornu_methode_context175 = new MethodContext(null);
        try {
            normalMap = CallChecker.beforeCalled(normalMap, SortedMap.class, 112, 4313, 4321);
            this.comparator = CallChecker.isCalled(((SortedMap<K, V>) (normalMap)), SortedMap.class, 112, 4313, 4321).comparator();
            CallChecker.varAssign(this.comparator, "this.comparator", 112, 4276, 4336);
            reverseMap = CallChecker.beforeCalled(reverseMap, SortedMap.class, 113, 4388, 4397);
            this.valueComparator = CallChecker.isCalled(((SortedMap<V, K>) (reverseMap)), SortedMap.class, 113, 4388, 4397).comparator();
            CallChecker.varAssign(this.valueComparator, "this.valueComparator", 113, 4346, 4412);
        } finally {
            _bcornu_methode_context175.methodEnd();
        }
    }

    @Override
    protected DualTreeBidiMap<V, K> createBidiMap(Map<V, K> normalMap, Map<K, V> reverseMap, BidiMap<K, V> inverseMap) {
        MethodContext _bcornu_methode_context862 = new MethodContext(DualTreeBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 125, 4425, 4882);
            CallChecker.varInit(inverseMap, "inverseMap", 125, 4425, 4882);
            CallChecker.varInit(reverseMap, "reverseMap", 125, 4425, 4882);
            CallChecker.varInit(normalMap, "normalMap", 125, 4425, 4882);
            CallChecker.varInit(this.entrySet, "entrySet", 125, 4425, 4882);
            CallChecker.varInit(this.values, "values", 125, 4425, 4882);
            CallChecker.varInit(this.keySet, "keySet", 125, 4425, 4882);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 125, 4425, 4882);
            CallChecker.varInit(this.reverseMap, "reverseMap", 125, 4425, 4882);
            CallChecker.varInit(this.normalMap, "normalMap", 125, 4425, 4882);
            CallChecker.varInit(this.valueComparator, "valueComparator", 125, 4425, 4882);
            CallChecker.varInit(this.comparator, "comparator", 125, 4425, 4882);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 125, 4425, 4882);
            return new DualTreeBidiMap<V, K>(normalMap, reverseMap, inverseMap);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DualTreeBidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context862.methodEnd();
        }
    }

    public Comparator<? super K> comparator() {
        MethodContext _bcornu_methode_context863 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 130, 4889, 5074);
            CallChecker.varInit(this.entrySet, "entrySet", 130, 4889, 5074);
            CallChecker.varInit(this.values, "values", 130, 4889, 5074);
            CallChecker.varInit(this.keySet, "keySet", 130, 4889, 5074);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 130, 4889, 5074);
            CallChecker.varInit(this.reverseMap, "reverseMap", 130, 4889, 5074);
            CallChecker.varInit(this.normalMap, "normalMap", 130, 4889, 5074);
            CallChecker.varInit(this.valueComparator, "valueComparator", 130, 4889, 5074);
            CallChecker.varInit(this.comparator, "comparator", 130, 4889, 5074);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 130, 4889, 5074);
            if (CallChecker.beforeDeref(normalMap, Map.class, 131, 5045, 5053)) {
                normalMap = CallChecker.beforeCalled(normalMap, SortedMap.class, 131, 5045, 5053);
                return CallChecker.isCalled(((SortedMap<K, V>) (normalMap)), SortedMap.class, 131, 5045, 5053).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context863.methodEnd();
        }
    }

    public Comparator<? super V> valueComparator() {
        MethodContext _bcornu_methode_context864 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 134, 5081, 5203);
            CallChecker.varInit(this.entrySet, "entrySet", 134, 5081, 5203);
            CallChecker.varInit(this.values, "values", 134, 5081, 5203);
            CallChecker.varInit(this.keySet, "keySet", 134, 5081, 5203);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 134, 5081, 5203);
            CallChecker.varInit(this.reverseMap, "reverseMap", 134, 5081, 5203);
            CallChecker.varInit(this.normalMap, "normalMap", 134, 5081, 5203);
            CallChecker.varInit(this.valueComparator, "valueComparator", 134, 5081, 5203);
            CallChecker.varInit(this.comparator, "comparator", 134, 5081, 5203);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 134, 5081, 5203);
            if (CallChecker.beforeDeref(reverseMap, Map.class, 135, 5164, 5173)) {
                reverseMap = CallChecker.beforeCalled(reverseMap, SortedMap.class, 135, 5164, 5173);
                return CallChecker.isCalled(((SortedMap<V, K>) (reverseMap)), SortedMap.class, 135, 5164, 5173).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context864.methodEnd();
        }
    }

    public K firstKey() {
        if (CallChecker.beforeDeref(normalMap, Map.class, 140, 5266, 5274)) {
            return ((SortedMap<K, V>) (normalMap)).firstKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K lastKey() {
        if (CallChecker.beforeDeref(normalMap, Map.class, 144, 5355, 5363)) {
            return ((SortedMap<K, V>) (normalMap)).lastKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K nextKey(K key) {
        if (isEmpty()) {
            return null;
        }
        if ((normalMap) instanceof OrderedMap) {
            if (CallChecker.beforeDeref(normalMap, Map.class, 152, 5560, 5568)) {
                return ((OrderedMap<K, ?>) (normalMap)).nextKey(key);
            }else
                throw new AbnormalExecutionError();
            
        }
        SortedMap<K, V> sm = CallChecker.varInit(((SortedMap<K, V>) (normalMap)), "sm", 154, 5603, 5651);
        Iterator<K> it = CallChecker.init(Iterator.class);
        if (CallChecker.beforeDeref(sm, SortedMap.class, 155, 5678, 5679)) {
            sm = CallChecker.beforeCalled(sm, SortedMap.class, 155, 5678, 5679);
            if (CallChecker.beforeDeref(CallChecker.isCalled(sm, SortedMap.class, 155, 5678, 5679).tailMap(key), SortedMap.class, 155, 5678, 5692)) {
                sm = CallChecker.beforeCalled(sm, SortedMap.class, 155, 5678, 5679);
                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(sm, SortedMap.class, 155, 5678, 5679).tailMap(key), SortedMap.class, 155, 5678, 5692).keySet(), Set.class, 155, 5678, 5701)) {
                    sm = CallChecker.beforeCalled(sm, SortedMap.class, 155, 5678, 5679);
                    it = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(sm, SortedMap.class, 155, 5678, 5679).tailMap(key), SortedMap.class, 155, 5678, 5692).keySet(), Set.class, 155, 5678, 5701).iterator();
                    CallChecker.varAssign(it, "it", 155, 5678, 5679);
                }
            }
        }
        if (CallChecker.beforeDeref(it, Iterator.class, 156, 5723, 5724)) {
            it.next();
        }
        if (CallChecker.beforeDeref(it, Iterator.class, 157, 5746, 5747)) {
            it = CallChecker.beforeCalled(it, Iterator.class, 157, 5746, 5747);
            if (CallChecker.isCalled(it, Iterator.class, 157, 5746, 5747).hasNext()) {
                if (CallChecker.beforeDeref(it, Iterator.class, 158, 5781, 5782)) {
                    return it.next();
                }else
                    throw new AbnormalExecutionError();
                
            }
        }else
            throw new AbnormalExecutionError();
        
        return null;
    }

    public K previousKey(K key) {
        if (isEmpty()) {
            return null;
        }
        if ((normalMap) instanceof OrderedMap) {
            if (CallChecker.beforeDeref(normalMap, Map.class, 168, 6010, 6018)) {
                return ((OrderedMap<K, V>) (normalMap)).previousKey(key);
            }else
                throw new AbnormalExecutionError();
            
        }
        SortedMap<K, V> sm = CallChecker.varInit(((SortedMap<K, V>) (normalMap)), "sm", 170, 6057, 6105);
        SortedMap<K, V> hm = CallChecker.init(SortedMap.class);
        if (CallChecker.beforeDeref(sm, SortedMap.class, 171, 6136, 6137)) {
            sm = CallChecker.beforeCalled(sm, SortedMap.class, 171, 6136, 6137);
            hm = CallChecker.isCalled(sm, SortedMap.class, 171, 6136, 6137).headMap(key);
            CallChecker.varAssign(hm, "hm", 171, 6136, 6137);
        }
        if (CallChecker.beforeDeref(hm, SortedMap.class, 172, 6165, 6166)) {
            hm = CallChecker.beforeCalled(hm, SortedMap.class, 172, 6165, 6166);
            if (CallChecker.isCalled(hm, SortedMap.class, 172, 6165, 6166).isEmpty()) {
                return null;
            }
        }else
            throw new AbnormalExecutionError();
        
        if (CallChecker.beforeDeref(hm, SortedMap.class, 175, 6231, 6232)) {
            return hm.lastKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public OrderedMapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context869 = new MethodContext(OrderedMapIterator.class);
        try {
            CallChecker.varInit(this, "this", 188, 6256, 6693);
            CallChecker.varInit(this.entrySet, "entrySet", 188, 6256, 6693);
            CallChecker.varInit(this.values, "values", 188, 6256, 6693);
            CallChecker.varInit(this.keySet, "keySet", 188, 6256, 6693);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 188, 6256, 6693);
            CallChecker.varInit(this.reverseMap, "reverseMap", 188, 6256, 6693);
            CallChecker.varInit(this.normalMap, "normalMap", 188, 6256, 6693);
            CallChecker.varInit(this.valueComparator, "valueComparator", 188, 6256, 6693);
            CallChecker.varInit(this.comparator, "comparator", 188, 6256, 6693);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 188, 6256, 6693);
            return new DualTreeBidiMap.BidiOrderedMapIterator<K, V>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context869.methodEnd();
        }
    }

    public SortedBidiMap<V, K> inverseSortedBidiMap() {
        MethodContext _bcornu_methode_context870 = new MethodContext(SortedBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 192, 6700, 6789);
            CallChecker.varInit(this.entrySet, "entrySet", 192, 6700, 6789);
            CallChecker.varInit(this.values, "values", 192, 6700, 6789);
            CallChecker.varInit(this.keySet, "keySet", 192, 6700, 6789);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 192, 6700, 6789);
            CallChecker.varInit(this.reverseMap, "reverseMap", 192, 6700, 6789);
            CallChecker.varInit(this.normalMap, "normalMap", 192, 6700, 6789);
            CallChecker.varInit(this.valueComparator, "valueComparator", 192, 6700, 6789);
            CallChecker.varInit(this.comparator, "comparator", 192, 6700, 6789);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 192, 6700, 6789);
            return inverseBidiMap();
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context870.methodEnd();
        }
    }

    public OrderedBidiMap<V, K> inverseOrderedBidiMap() {
        MethodContext _bcornu_methode_context871 = new MethodContext(OrderedBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 196, 6796, 6887);
            CallChecker.varInit(this.entrySet, "entrySet", 196, 6796, 6887);
            CallChecker.varInit(this.values, "values", 196, 6796, 6887);
            CallChecker.varInit(this.keySet, "keySet", 196, 6796, 6887);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 196, 6796, 6887);
            CallChecker.varInit(this.reverseMap, "reverseMap", 196, 6796, 6887);
            CallChecker.varInit(this.normalMap, "normalMap", 196, 6796, 6887);
            CallChecker.varInit(this.valueComparator, "valueComparator", 196, 6796, 6887);
            CallChecker.varInit(this.comparator, "comparator", 196, 6796, 6887);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 196, 6796, 6887);
            return inverseBidiMap();
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedBidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context871.methodEnd();
        }
    }

    public SortedMap<K, V> headMap(K toKey) {
        MethodContext _bcornu_methode_context872 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 201, 6894, 7139);
            CallChecker.varInit(toKey, "toKey", 201, 6894, 7139);
            CallChecker.varInit(this.entrySet, "entrySet", 201, 6894, 7139);
            CallChecker.varInit(this.values, "values", 201, 6894, 7139);
            CallChecker.varInit(this.keySet, "keySet", 201, 6894, 7139);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 201, 6894, 7139);
            CallChecker.varInit(this.reverseMap, "reverseMap", 201, 6894, 7139);
            CallChecker.varInit(this.normalMap, "normalMap", 201, 6894, 7139);
            CallChecker.varInit(this.valueComparator, "valueComparator", 201, 6894, 7139);
            CallChecker.varInit(this.comparator, "comparator", 201, 6894, 7139);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 201, 6894, 7139);
            SortedMap<K, V> sub = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(normalMap, Map.class, 202, 7063, 7071)) {
                normalMap = CallChecker.beforeCalled(normalMap, SortedMap.class, 202, 7063, 7071);
                sub = CallChecker.isCalled(((SortedMap<K, V>) (normalMap)), SortedMap.class, 202, 7063, 7071).headMap(toKey);
                CallChecker.varAssign(sub, "sub", 202, 7063, 7071);
            }
            return new DualTreeBidiMap.ViewMap<K, V>(this, sub);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context872.methodEnd();
        }
    }

    public SortedMap<K, V> tailMap(K fromKey) {
        MethodContext _bcornu_methode_context873 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 206, 7146, 7317);
            CallChecker.varInit(fromKey, "fromKey", 206, 7146, 7317);
            CallChecker.varInit(this.entrySet, "entrySet", 206, 7146, 7317);
            CallChecker.varInit(this.values, "values", 206, 7146, 7317);
            CallChecker.varInit(this.keySet, "keySet", 206, 7146, 7317);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 206, 7146, 7317);
            CallChecker.varInit(this.reverseMap, "reverseMap", 206, 7146, 7317);
            CallChecker.varInit(this.normalMap, "normalMap", 206, 7146, 7317);
            CallChecker.varInit(this.valueComparator, "valueComparator", 206, 7146, 7317);
            CallChecker.varInit(this.comparator, "comparator", 206, 7146, 7317);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 206, 7146, 7317);
            SortedMap<K, V> sub = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(normalMap, Map.class, 207, 7239, 7247)) {
                normalMap = CallChecker.beforeCalled(normalMap, SortedMap.class, 207, 7239, 7247);
                sub = CallChecker.isCalled(((SortedMap<K, V>) (normalMap)), SortedMap.class, 207, 7239, 7247).tailMap(fromKey);
                CallChecker.varAssign(sub, "sub", 207, 7239, 7247);
            }
            return new DualTreeBidiMap.ViewMap<K, V>(this, sub);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context873.methodEnd();
        }
    }

    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        MethodContext _bcornu_methode_context874 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 211, 7324, 7509);
            CallChecker.varInit(toKey, "toKey", 211, 7324, 7509);
            CallChecker.varInit(fromKey, "fromKey", 211, 7324, 7509);
            CallChecker.varInit(this.entrySet, "entrySet", 211, 7324, 7509);
            CallChecker.varInit(this.values, "values", 211, 7324, 7509);
            CallChecker.varInit(this.keySet, "keySet", 211, 7324, 7509);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 211, 7324, 7509);
            CallChecker.varInit(this.reverseMap, "reverseMap", 211, 7324, 7509);
            CallChecker.varInit(this.normalMap, "normalMap", 211, 7324, 7509);
            CallChecker.varInit(this.valueComparator, "valueComparator", 211, 7324, 7509);
            CallChecker.varInit(this.comparator, "comparator", 211, 7324, 7509);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 211, 7324, 7509);
            SortedMap<K, V> sub = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(normalMap, Map.class, 212, 7425, 7433)) {
                normalMap = CallChecker.beforeCalled(normalMap, SortedMap.class, 212, 7425, 7433);
                sub = CallChecker.isCalled(((SortedMap<K, V>) (normalMap)), SortedMap.class, 212, 7425, 7433).subMap(fromKey, toKey);
                CallChecker.varAssign(sub, "sub", 212, 7425, 7433);
            }
            return new DualTreeBidiMap.ViewMap<K, V>(this, sub);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context874.methodEnd();
        }
    }

    @Override
    public SortedBidiMap<V, K> inverseBidiMap() {
        MethodContext _bcornu_methode_context875 = new MethodContext(SortedBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 220, 7516, 7678);
            CallChecker.varInit(this.entrySet, "entrySet", 220, 7516, 7678);
            CallChecker.varInit(this.values, "values", 220, 7516, 7678);
            CallChecker.varInit(this.keySet, "keySet", 220, 7516, 7678);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 220, 7516, 7678);
            CallChecker.varInit(this.reverseMap, "reverseMap", 220, 7516, 7678);
            CallChecker.varInit(this.normalMap, "normalMap", 220, 7516, 7678);
            CallChecker.varInit(this.valueComparator, "valueComparator", 220, 7516, 7678);
            CallChecker.varInit(this.comparator, "comparator", 220, 7516, 7678);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 220, 7516, 7678);
            return ((SortedBidiMap<V, K>) (super.inverseBidiMap()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context875.methodEnd();
        }
    }

    protected static class ViewMap<K, V> extends AbstractSortedMapDecorator<K, V> {
        final DualTreeBidiMap<K, V> bidi;

        protected ViewMap(DualTreeBidiMap<K, V> bidi, SortedMap<K, V> sm) {
            super(new DualTreeBidiMap<K, V>(sm, CallChecker.isCalled(bidi, DualTreeBidiMap.class, 241, 8439, 8442).reverseMap, CallChecker.isCalled(bidi, DualTreeBidiMap.class, 241, 8456, 8459).inverseBidiMap));
            MethodContext _bcornu_methode_context176 = new MethodContext(null);
            try {
                this.bidi = decorated();
                CallChecker.varAssign(this.bidi, "this.bidi", 242, 8491, 8514);
            } finally {
                _bcornu_methode_context176.methodEnd();
            }
        }

        @Override
        public boolean containsValue(Object value) {
            MethodContext _bcornu_methode_context876 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 246, 8535, 8735);
                CallChecker.varInit(value, "value", 246, 8535, 8735);
                CallChecker.varInit(this.map, "map", 246, 8535, 8735);
                CallChecker.varInit(this.bidi, "bidi", 246, 8535, 8735);
                final DualTreeBidiMap<K, V> npe_invocation_var200 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var200, DualTreeBidiMap.class, 248, 8683, 8693)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var200, DualTreeBidiMap.class, 248, 8683, 8693).normalMap, Map.class, 248, 8683, 8703)) {
                        return CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var200, DualTreeBidiMap.class, 248, 8683, 8693).normalMap, Map.class, 248, 8683, 8703).containsValue(value);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context876.methodEnd();
            }
        }

        @Override
        public void clear() {
            MethodContext _bcornu_methode_context877 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 252, 8746, 9002);
                CallChecker.varInit(this.map, "map", 252, 8746, 9002);
                CallChecker.varInit(this.bidi, "bidi", 252, 8746, 9002);
                for (Iterator<K> it = CallChecker.isCalled(keySet(), Set.class, 254, 8886, 8893).iterator(); CallChecker.isCalled(it, Iterator.class, 254, 8907, 8908).hasNext();) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 255, 8940, 8941)) {
                        it.next();
                    }
                    if (CallChecker.beforeDeref(it, Iterator.class, 256, 8967, 8968)) {
                        CallChecker.isCalled(it, Iterator.class, 256, 8967, 8968).remove();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context877.methodEnd();
            }
        }

        @Override
        public SortedMap<K, V> headMap(K toKey) {
            MethodContext _bcornu_methode_context878 = new MethodContext(SortedMap.class);
            try {
                CallChecker.varInit(this, "this", 261, 9013, 9154);
                CallChecker.varInit(toKey, "toKey", 261, 9013, 9154);
                CallChecker.varInit(this.map, "map", 261, 9013, 9154);
                CallChecker.varInit(this.bidi, "bidi", 261, 9013, 9154);
                return new DualTreeBidiMap.ViewMap<K, V>(decorated(), super.headMap(toKey));
            } catch (ForceReturn _bcornu_return_t) {
                return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context878.methodEnd();
            }
        }

        @Override
        public SortedMap<K, V> tailMap(K fromKey) {
            MethodContext _bcornu_methode_context879 = new MethodContext(SortedMap.class);
            try {
                CallChecker.varInit(this, "this", 266, 9165, 9310);
                CallChecker.varInit(fromKey, "fromKey", 266, 9165, 9310);
                CallChecker.varInit(this.map, "map", 266, 9165, 9310);
                CallChecker.varInit(this.bidi, "bidi", 266, 9165, 9310);
                return new DualTreeBidiMap.ViewMap<K, V>(decorated(), super.tailMap(fromKey));
            } catch (ForceReturn _bcornu_return_t) {
                return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context879.methodEnd();
            }
        }

        @Override
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            MethodContext _bcornu_methode_context880 = new MethodContext(SortedMap.class);
            try {
                CallChecker.varInit(this, "this", 271, 9321, 9480);
                CallChecker.varInit(toKey, "toKey", 271, 9321, 9480);
                CallChecker.varInit(fromKey, "fromKey", 271, 9321, 9480);
                CallChecker.varInit(this.map, "map", 271, 9321, 9480);
                CallChecker.varInit(this.bidi, "bidi", 271, 9321, 9480);
                return new DualTreeBidiMap.ViewMap<K, V>(decorated(), super.subMap(fromKey, toKey));
            } catch (ForceReturn _bcornu_return_t) {
                return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context880.methodEnd();
            }
        }

        @Override
        protected DualTreeBidiMap<K, V> decorated() {
            MethodContext _bcornu_methode_context881 = new MethodContext(DualTreeBidiMap.class);
            try {
                CallChecker.varInit(this, "this", 276, 9491, 9625);
                CallChecker.varInit(this.map, "map", 276, 9491, 9625);
                CallChecker.varInit(this.bidi, "bidi", 276, 9491, 9625);
                return ((DualTreeBidiMap<K, V>) (super.decorated()));
            } catch (ForceReturn _bcornu_return_t) {
                return ((DualTreeBidiMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context881.methodEnd();
            }
        }

        @Override
        public K previousKey(K key) {
            final DualTreeBidiMap<K, V> npe_invocation_var201 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var201, DualTreeBidiMap.class, 282, 9703, 9713)) {
                return npe_invocation_var201.previousKey(key);
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        public K nextKey(K key) {
            final DualTreeBidiMap<K, V> npe_invocation_var202 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var202, DualTreeBidiMap.class, 287, 9815, 9825)) {
                return npe_invocation_var202.nextKey(key);
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    protected static class BidiOrderedMapIterator<K, V> implements OrderedMapIterator<K, V> , ResettableIterator<K> {
        protected final AbstractDualBidiMap<K, V> parent;

        protected ListIterator<Map.Entry<K, V>> iterator;

        private Map.Entry<K, V> last = null;

        protected BidiOrderedMapIterator(AbstractDualBidiMap<K, V> parent) {
            super();
            MethodContext _bcornu_methode_context177 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 312, 10578, 10598);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 313, 10654, 10659)) {
                    parent = CallChecker.beforeCalled(parent, AbstractDualBidiMap.class, 313, 10654, 10659);
                    if (CallChecker.beforeDeref(new ArrayList<Map.Entry<K, V>>(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 313, 10654, 10659).entrySet()), ArrayList.class, 313, 10623, 10671)) {
                        parent = CallChecker.beforeCalled(parent, AbstractDualBidiMap.class, 313, 10654, 10659);
                        iterator = CallChecker.isCalled(new ArrayList<Map.Entry<K, V>>(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 313, 10654, 10659).entrySet()), ArrayList.class, 313, 10623, 10671).listIterator();
                        CallChecker.varAssign(this.iterator, "this.iterator", 313, 10612, 10687);
                    }
                }
            } finally {
                _bcornu_methode_context177.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context884 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 316, 10708, 10782);
                CallChecker.varInit(this.last, "last", 316, 10708, 10782);
                CallChecker.varInit(this.iterator, "iterator", 316, 10708, 10782);
                CallChecker.varInit(this.parent, "parent", 316, 10708, 10782);
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 317, 10754, 10761)) {
                    iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 317, 10754, 10761);
                    return CallChecker.isCalled(iterator, ListIterator.class, 317, 10754, 10761).hasNext();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context884.methodEnd();
            }
        }

        public K next() {
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 321, 10830, 10837)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 321, 10830, 10837);
                last = CallChecker.isCalled(iterator, ListIterator.class, 321, 10830, 10837).next();
                CallChecker.varAssign(this.last, "this.last", 321, 10823, 10845);
            }
            if (CallChecker.beforeDeref(last, Map.Entry.class, 322, 10866, 10869)) {
                return last.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context886 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 325, 10900, 10982);
                CallChecker.varInit(this.last, "last", 325, 10900, 10982);
                CallChecker.varInit(this.iterator, "iterator", 325, 10900, 10982);
                CallChecker.varInit(this.parent, "parent", 325, 10900, 10982);
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 326, 10950, 10957)) {
                    iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 326, 10950, 10957);
                    return CallChecker.isCalled(iterator, ListIterator.class, 326, 10950, 10957).hasPrevious();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context886.methodEnd();
            }
        }

        public K previous() {
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 330, 11034, 11041)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 330, 11034, 11041);
                last = CallChecker.isCalled(iterator, ListIterator.class, 330, 11034, 11041).previous();
                CallChecker.varAssign(this.last, "this.last", 330, 11027, 11053);
            }
            if (CallChecker.beforeDeref(last, Map.Entry.class, 331, 11074, 11077)) {
                return last.getKey();
            }else
                throw new AbnormalExecutionError();
            
        }

        public void remove() {
            MethodContext _bcornu_methode_context888 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 334, 11108, 11237);
                CallChecker.varInit(this.last, "last", 334, 11108, 11237);
                CallChecker.varInit(this.iterator, "iterator", 334, 11108, 11237);
                CallChecker.varInit(this.parent, "parent", 334, 11108, 11237);
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 335, 11143, 11150)) {
                    iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 335, 11143, 11150);
                    CallChecker.isCalled(iterator, ListIterator.class, 335, 11143, 11150).remove();
                }
                if (CallChecker.beforeDeref(last, Map.Entry.class, 336, 11188, 11191)) {
                    if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 336, 11174, 11179)) {
                        parent.remove(last.getKey());
                    }
                }
                last = null;
                CallChecker.varAssign(this.last, "this.last", 337, 11216, 11227);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context888.methodEnd();
            }
        }

        public K getKey() {
            if ((last) == null) {
                throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
            }
            return last.getKey();
        }

        public V getValue() {
            if ((last) == null) {
                throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
            }
            return last.getValue();
        }

        public V setValue(V value) {
            if ((last) == null) {
                throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
            }
            if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 358, 11951, 11956)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 358, 11951, 11956).reverseMap, Map.class, 358, 11951, 11967)) {
                    if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 359, 12007, 12012)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 359, 12007, 12012).reverseMap, Map.class, 359, 12007, 12023)) {
                            if ((CallChecker.isCalled(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 358, 11951, 11956).reverseMap, Map.class, 358, 11951, 11967).containsKey(value)) && ((CallChecker.isCalled(parent, AbstractDualBidiMap.class, 359, 12007, 12012).reverseMap.get(value)) != (last.getKey()))) {
                                throw new IllegalArgumentException("Cannot use setValue() when the object being set is already in the map");
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 362, 12214, 12219)) {
                return parent.put(last.getKey(), value);
            }else
                throw new AbnormalExecutionError();
            
        }

        public void reset() {
            MethodContext _bcornu_methode_context892 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 365, 12267, 12411);
                CallChecker.varInit(this.last, "last", 365, 12267, 12411);
                CallChecker.varInit(this.iterator, "iterator", 365, 12267, 12411);
                CallChecker.varInit(this.parent, "parent", 365, 12267, 12411);
                if (CallChecker.beforeDeref(parent, AbstractDualBidiMap.class, 366, 12343, 12348)) {
                    if (CallChecker.beforeDeref(new ArrayList<Map.Entry<K, V>>(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 366, 12343, 12348).entrySet()), ArrayList.class, 366, 12312, 12360)) {
                        iterator = CallChecker.isCalled(new ArrayList<Map.Entry<K, V>>(CallChecker.isCalled(parent, AbstractDualBidiMap.class, 366, 12343, 12348).entrySet()), ArrayList.class, 366, 12312, 12360).listIterator();
                        CallChecker.varAssign(this.iterator, "this.iterator", 366, 12301, 12376);
                    }
                }
                last = null;
                CallChecker.varAssign(this.last, "this.last", 367, 12390, 12401);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context892.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context893 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 371, 12422, 12632);
                CallChecker.varInit(this.last, "last", 371, 12422, 12632);
                CallChecker.varInit(this.iterator, "iterator", 371, 12422, 12632);
                CallChecker.varInit(this.parent, "parent", 371, 12422, 12632);
                if ((last) != null) {
                    return ((("MapIterator[" + (getKey())) + "=") + (getValue())) + "]";
                }
                return "MapIterator[]";
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context893.methodEnd();
            }
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context894 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 381, 12645, 12888);
            CallChecker.varInit(out, "out", 381, 12645, 12888);
            CallChecker.varInit(this.entrySet, "entrySet", 381, 12645, 12888);
            CallChecker.varInit(this.values, "values", 381, 12645, 12888);
            CallChecker.varInit(this.keySet, "keySet", 381, 12645, 12888);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 381, 12645, 12888);
            CallChecker.varInit(this.reverseMap, "reverseMap", 381, 12645, 12888);
            CallChecker.varInit(this.normalMap, "normalMap", 381, 12645, 12888);
            CallChecker.varInit(this.valueComparator, "valueComparator", 381, 12645, 12888);
            CallChecker.varInit(this.comparator, "comparator", 381, 12645, 12888);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 381, 12645, 12888);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 382, 12822, 12824)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 382, 12822, 12824);
                CallChecker.isCalled(out, ObjectOutputStream.class, 382, 12822, 12824).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 383, 12856, 12858)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 383, 12856, 12858);
                CallChecker.isCalled(out, ObjectOutputStream.class, 383, 12856, 12858).writeObject(normalMap);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context894.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context895 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 386, 12895, 13294);
            CallChecker.varInit(in, "in", 386, 12895, 13294);
            CallChecker.varInit(this.entrySet, "entrySet", 386, 12895, 13294);
            CallChecker.varInit(this.values, "values", 386, 12895, 13294);
            CallChecker.varInit(this.keySet, "keySet", 386, 12895, 13294);
            CallChecker.varInit(this.inverseBidiMap, "inverseBidiMap", 386, 12895, 13294);
            CallChecker.varInit(this.reverseMap, "reverseMap", 386, 12895, 13294);
            CallChecker.varInit(this.normalMap, "normalMap", 386, 12895, 13294);
            CallChecker.varInit(this.valueComparator, "valueComparator", 386, 12895, 13294);
            CallChecker.varInit(this.comparator, "comparator", 386, 12895, 13294);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bidimap.DualTreeBidiMap.serialVersionUID", 386, 12895, 13294);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 387, 12994, 12995)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 387, 12994, 12995);
                CallChecker.isCalled(in, ObjectInputStream.class, 387, 12994, 12995).defaultReadObject();
            }
            normalMap = new TreeMap<K, V>(comparator);
            CallChecker.varAssign(this.normalMap, "this.normalMap", 388, 13026, 13067);
            reverseMap = new TreeMap<V, K>(valueComparator);
            CallChecker.varAssign(this.reverseMap, "this.reverseMap", 389, 13077, 13124);
            Map<K, V> map = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 391, 13252, 13253)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 391, 13252, 13253);
                map = ((Map<K, V>) (CallChecker.isCalled(in, ObjectInputStream.class, 391, 13252, 13253).readObject()));
                CallChecker.varAssign(map, "map", 391, 13252, 13253);
            }
            putAll(map);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context895.methodEnd();
        }
    }
}

