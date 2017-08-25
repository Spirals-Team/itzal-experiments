package org.apache.commons.collections.map;

import java.util.SortedMap;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class PredicatedSortedMap<K, V> extends PredicatedMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = 3359846175935304332L;

    public static <K, V> SortedMap<K, V> decorate(SortedMap<K, V> map, Predicate<? super K> keyPredicate, Predicate<? super V> valuePredicate) {
        MethodContext _bcornu_methode_context811 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(valuePredicate, "valuePredicate", 65, 2328, 3055);
            CallChecker.varInit(keyPredicate, "keyPredicate", 65, 2328, 3055);
            CallChecker.varInit(map, "map", 65, 2328, 3055);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedSortedMap.serialVersionUID", 65, 2328, 3055);
            return new PredicatedSortedMap<K, V>(map, keyPredicate, valuePredicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context811.methodEnd();
        }
    }

    protected PredicatedSortedMap(SortedMap<K, V> map, Predicate<? super K> keyPredicate, Predicate<? super V> valuePredicate) {
        super(map, keyPredicate, valuePredicate);
        MethodContext _bcornu_methode_context160 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context160.methodEnd();
        }
    }

    protected SortedMap<K, V> getSortedMap() {
        MethodContext _bcornu_methode_context812 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 90, 3693, 3950);
            CallChecker.varInit(this.map, "map", 90, 3693, 3950);
            CallChecker.varInit(this.valuePredicate, "valuePredicate", 90, 3693, 3950);
            CallChecker.varInit(this.keyPredicate, "keyPredicate", 90, 3693, 3950);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedSortedMap.serialVersionUID", 90, 3693, 3950);
            return ((SortedMap<K, V>) (map));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context812.methodEnd();
        }
    }

    public K firstKey() {
        final SortedMap<K, V> npe_invocation_var185 = getSortedMap();
        if (CallChecker.beforeDeref(npe_invocation_var185, SortedMap.class, 96, 4072, 4085)) {
            return npe_invocation_var185.firstKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K lastKey() {
        final SortedMap<K, V> npe_invocation_var186 = getSortedMap();
        if (CallChecker.beforeDeref(npe_invocation_var186, SortedMap.class, 100, 4146, 4159)) {
            return npe_invocation_var186.lastKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Comparator<? super K> comparator() {
        MethodContext _bcornu_methode_context815 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 103, 4183, 4275);
            CallChecker.varInit(this.map, "map", 103, 4183, 4275);
            CallChecker.varInit(this.valuePredicate, "valuePredicate", 103, 4183, 4275);
            CallChecker.varInit(this.keyPredicate, "keyPredicate", 103, 4183, 4275);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedSortedMap.serialVersionUID", 103, 4183, 4275);
            final SortedMap<K, V> npe_invocation_var187 = getSortedMap();
            if (CallChecker.beforeDeref(npe_invocation_var187, SortedMap.class, 104, 4242, 4255)) {
                return CallChecker.isCalled(npe_invocation_var187, SortedMap.class, 104, 4242, 4255).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context815.methodEnd();
        }
    }

    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        MethodContext _bcornu_methode_context816 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 107, 4282, 4488);
            CallChecker.varInit(toKey, "toKey", 107, 4282, 4488);
            CallChecker.varInit(fromKey, "fromKey", 107, 4282, 4488);
            CallChecker.varInit(this.map, "map", 107, 4282, 4488);
            CallChecker.varInit(this.valuePredicate, "valuePredicate", 107, 4282, 4488);
            CallChecker.varInit(this.keyPredicate, "keyPredicate", 107, 4282, 4488);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedSortedMap.serialVersionUID", 107, 4282, 4488);
            final SortedMap<K, V> npe_invocation_var188 = getSortedMap();
            SortedMap<K, V> map = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var188, SortedMap.class, 108, 4364, 4377)) {
                map = CallChecker.isCalled(npe_invocation_var188, SortedMap.class, 108, 4364, 4377).subMap(fromKey, toKey);
                CallChecker.varAssign(map, "map", 108, 4364, 4377);
            }
            return new PredicatedSortedMap<K, V>(map, keyPredicate, valuePredicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context816.methodEnd();
        }
    }

    public SortedMap<K, V> headMap(K toKey) {
        MethodContext _bcornu_methode_context817 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 112, 4495, 4683);
            CallChecker.varInit(toKey, "toKey", 112, 4495, 4683);
            CallChecker.varInit(this.map, "map", 112, 4495, 4683);
            CallChecker.varInit(this.valuePredicate, "valuePredicate", 112, 4495, 4683);
            CallChecker.varInit(this.keyPredicate, "keyPredicate", 112, 4495, 4683);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedSortedMap.serialVersionUID", 112, 4495, 4683);
            final SortedMap<K, V> npe_invocation_var189 = getSortedMap();
            SortedMap<K, V> map = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var189, SortedMap.class, 113, 4567, 4580)) {
                map = CallChecker.isCalled(npe_invocation_var189, SortedMap.class, 113, 4567, 4580).headMap(toKey);
                CallChecker.varAssign(map, "map", 113, 4567, 4580);
            }
            return new PredicatedSortedMap<K, V>(map, keyPredicate, valuePredicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context817.methodEnd();
        }
    }

    public SortedMap<K, V> tailMap(K fromKey) {
        MethodContext _bcornu_methode_context818 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 117, 4690, 4882);
            CallChecker.varInit(fromKey, "fromKey", 117, 4690, 4882);
            CallChecker.varInit(this.map, "map", 117, 4690, 4882);
            CallChecker.varInit(this.valuePredicate, "valuePredicate", 117, 4690, 4882);
            CallChecker.varInit(this.keyPredicate, "keyPredicate", 117, 4690, 4882);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.PredicatedSortedMap.serialVersionUID", 117, 4690, 4882);
            final SortedMap<K, V> npe_invocation_var190 = getSortedMap();
            SortedMap<K, V> map = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var190, SortedMap.class, 118, 4764, 4777)) {
                map = CallChecker.isCalled(npe_invocation_var190, SortedMap.class, 118, 4764, 4777).tailMap(fromKey);
                CallChecker.varAssign(map, "map", 118, 4764, 4777);
            }
            return new PredicatedSortedMap<K, V>(map, keyPredicate, valuePredicate);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context818.methodEnd();
        }
    }
}

