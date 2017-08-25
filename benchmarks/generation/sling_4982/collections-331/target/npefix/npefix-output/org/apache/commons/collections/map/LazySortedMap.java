package org.apache.commons.collections.map;

import org.apache.commons.collections.Transformer;
import java.util.SortedMap;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Factory;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class LazySortedMap<K, V> extends LazyMap<K, V> implements SortedMap<K, V> {
    private static final long serialVersionUID = 2715322183617658933L;

    @Deprecated
    public static <K, V> SortedMap<K, V> decorate(SortedMap<K, V> map, Factory<? extends V> factory) {
        MethodContext _bcornu_methode_context984 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(factory, "factory", 77, 2619, 3074);
            CallChecker.varInit(map, "map", 77, 2619, 3074);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazySortedMap.serialVersionUID", 77, 2619, 3074);
            return LazySortedMap.getLazySortedMap(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context984.methodEnd();
        }
    }

    public static <K, V> SortedMap<K, V> getLazySortedMap(SortedMap<K, V> map, Factory<? extends V> factory) {
        MethodContext _bcornu_methode_context985 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(factory, "factory", 88, 3081, 3518);
            CallChecker.varInit(map, "map", 88, 3081, 3518);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazySortedMap.serialVersionUID", 88, 3081, 3518);
            return new LazySortedMap<K, V>(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context985.methodEnd();
        }
    }

    @Deprecated
    public static <K, V> SortedMap<K, V> decorate(SortedMap<K, V> map, Transformer<? super K, ? extends V> factory) {
        MethodContext _bcornu_methode_context986 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(factory, "factory", 101, 3525, 3995);
            CallChecker.varInit(map, "map", 101, 3525, 3995);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazySortedMap.serialVersionUID", 101, 3525, 3995);
            return LazySortedMap.getLazySortedMap(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context986.methodEnd();
        }
    }

    public static <K, V> SortedMap<K, V> getLazySortedMap(SortedMap<K, V> map, Transformer<? super K, ? extends V> factory) {
        MethodContext _bcornu_methode_context987 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(factory, "factory", 112, 4002, 4454);
            CallChecker.varInit(map, "map", 112, 4002, 4454);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazySortedMap.serialVersionUID", 112, 4002, 4454);
            return new LazySortedMap<K, V>(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context987.methodEnd();
        }
    }

    protected LazySortedMap(SortedMap<K, V> map, Factory<? extends V> factory) {
        super(map, factory);
        MethodContext _bcornu_methode_context191 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context191.methodEnd();
        }
    }

    protected LazySortedMap(SortedMap<K, V> map, Transformer<? super K, ? extends V> factory) {
        super(map, factory);
        MethodContext _bcornu_methode_context192 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context192.methodEnd();
        }
    }

    protected SortedMap<K, V> getSortedMap() {
        MethodContext _bcornu_methode_context988 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 145, 5288, 5543);
            CallChecker.varInit(this.map, "map", 145, 5288, 5543);
            CallChecker.varInit(this.factory, "factory", 145, 5288, 5543);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazySortedMap.serialVersionUID", 145, 5288, 5543);
            return ((SortedMap<K, V>) (map));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context988.methodEnd();
        }
    }

    public K firstKey() {
        final SortedMap<K, V> npe_invocation_var208 = getSortedMap();
        if (CallChecker.beforeDeref(npe_invocation_var208, SortedMap.class, 151, 5665, 5678)) {
            return npe_invocation_var208.firstKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public K lastKey() {
        final SortedMap<K, V> npe_invocation_var209 = getSortedMap();
        if (CallChecker.beforeDeref(npe_invocation_var209, SortedMap.class, 155, 5739, 5752)) {
            return npe_invocation_var209.lastKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Comparator<? super K> comparator() {
        MethodContext _bcornu_methode_context991 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 158, 5776, 5868);
            CallChecker.varInit(this.map, "map", 158, 5776, 5868);
            CallChecker.varInit(this.factory, "factory", 158, 5776, 5868);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazySortedMap.serialVersionUID", 158, 5776, 5868);
            final SortedMap<K, V> npe_invocation_var210 = getSortedMap();
            if (CallChecker.beforeDeref(npe_invocation_var210, SortedMap.class, 159, 5835, 5848)) {
                return CallChecker.isCalled(npe_invocation_var210, SortedMap.class, 159, 5835, 5848).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context991.methodEnd();
        }
    }

    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        MethodContext _bcornu_methode_context992 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 162, 5875, 6051);
            CallChecker.varInit(toKey, "toKey", 162, 5875, 6051);
            CallChecker.varInit(fromKey, "fromKey", 162, 5875, 6051);
            CallChecker.varInit(this.map, "map", 162, 5875, 6051);
            CallChecker.varInit(this.factory, "factory", 162, 5875, 6051);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazySortedMap.serialVersionUID", 162, 5875, 6051);
            final SortedMap<K, V> npe_invocation_var211 = getSortedMap();
            SortedMap<K, V> map = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var211, SortedMap.class, 163, 5955, 5968)) {
                map = CallChecker.isCalled(npe_invocation_var211, SortedMap.class, 163, 5955, 5968).subMap(fromKey, toKey);
                CallChecker.varAssign(map, "map", 163, 5955, 5968);
            }
            return new LazySortedMap<K, V>(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context992.methodEnd();
        }
    }

    public SortedMap<K, V> headMap(K toKey) {
        MethodContext _bcornu_methode_context993 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 167, 6058, 6216);
            CallChecker.varInit(toKey, "toKey", 167, 6058, 6216);
            CallChecker.varInit(this.map, "map", 167, 6058, 6216);
            CallChecker.varInit(this.factory, "factory", 167, 6058, 6216);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazySortedMap.serialVersionUID", 167, 6058, 6216);
            final SortedMap<K, V> npe_invocation_var212 = getSortedMap();
            SortedMap<K, V> map = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var212, SortedMap.class, 168, 6128, 6141)) {
                map = CallChecker.isCalled(npe_invocation_var212, SortedMap.class, 168, 6128, 6141).headMap(toKey);
                CallChecker.varAssign(map, "map", 168, 6128, 6141);
            }
            return new LazySortedMap<K, V>(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context993.methodEnd();
        }
    }

    public SortedMap<K, V> tailMap(K fromKey) {
        MethodContext _bcornu_methode_context994 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 172, 6223, 6385);
            CallChecker.varInit(fromKey, "fromKey", 172, 6223, 6385);
            CallChecker.varInit(this.map, "map", 172, 6223, 6385);
            CallChecker.varInit(this.factory, "factory", 172, 6223, 6385);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.LazySortedMap.serialVersionUID", 172, 6223, 6385);
            final SortedMap<K, V> npe_invocation_var213 = getSortedMap();
            SortedMap<K, V> map = CallChecker.init(SortedMap.class);
            if (CallChecker.beforeDeref(npe_invocation_var213, SortedMap.class, 173, 6295, 6308)) {
                map = CallChecker.isCalled(npe_invocation_var213, SortedMap.class, 173, 6295, 6308).tailMap(fromKey);
                CallChecker.varAssign(map, "map", 173, 6295, 6308);
            }
            return new LazySortedMap<K, V>(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context994.methodEnd();
        }
    }
}

