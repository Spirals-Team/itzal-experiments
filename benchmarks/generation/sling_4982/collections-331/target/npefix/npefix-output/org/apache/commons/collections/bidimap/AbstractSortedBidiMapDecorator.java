package org.apache.commons.collections.bidimap;

import java.util.SortedMap;
import org.apache.commons.collections.SortedBidiMap;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.map.AbstractMapDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractSortedBidiMapDecorator<K, V> extends AbstractOrderedBidiMapDecorator<K, V> implements SortedBidiMap<K, V> {
    public AbstractSortedBidiMapDecorator(SortedBidiMap<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context418 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context418.methodEnd();
        }
    }

    @Override
    protected SortedBidiMap<K, V> decorated() {
        MethodContext _bcornu_methode_context2213 = new MethodContext(SortedBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 60, 2119, 2331);
            CallChecker.varInit(this.map, "map", 60, 2119, 2331);
            return ((SortedBidiMap<K, V>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBidiMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2213.methodEnd();
        }
    }

    @Override
    public SortedBidiMap<V, K> inverseBidiMap() {
        MethodContext _bcornu_methode_context2214 = new MethodContext(SortedBidiMap.class);
        try {
            CallChecker.varInit(this, "this", 66, 2338, 2525);
            CallChecker.varInit(this.map, "map", 66, 2338, 2525);
            final SortedBidiMap<K, V> npe_invocation_var423 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var423, SortedBidiMap.class, 67, 2491, 2501)) {
                return CallChecker.isCalled(npe_invocation_var423, SortedBidiMap.class, 67, 2491, 2501).inverseBidiMap();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedBidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2214.methodEnd();
        }
    }

    public Comparator<? super K> comparator() {
        MethodContext _bcornu_methode_context2215 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 70, 2532, 2621);
            CallChecker.varInit(this.map, "map", 70, 2532, 2621);
            final SortedBidiMap<K, V> npe_invocation_var424 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var424, SortedBidiMap.class, 71, 2591, 2601)) {
                return CallChecker.isCalled(npe_invocation_var424, SortedBidiMap.class, 71, 2591, 2601).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2215.methodEnd();
        }
    }

    public Comparator<? super V> valueComparator() {
        MethodContext _bcornu_methode_context2216 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 74, 2628, 2727);
            CallChecker.varInit(this.map, "map", 74, 2628, 2727);
            final SortedBidiMap<K, V> npe_invocation_var425 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var425, SortedBidiMap.class, 75, 2692, 2702)) {
                return CallChecker.isCalled(npe_invocation_var425, SortedBidiMap.class, 75, 2692, 2702).valueComparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2216.methodEnd();
        }
    }

    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        MethodContext _bcornu_methode_context2217 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 78, 2734, 2841);
            CallChecker.varInit(toKey, "toKey", 78, 2734, 2841);
            CallChecker.varInit(fromKey, "fromKey", 78, 2734, 2841);
            CallChecker.varInit(this.map, "map", 78, 2734, 2841);
            final SortedBidiMap<K, V> npe_invocation_var426 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var426, SortedBidiMap.class, 79, 2801, 2811)) {
                return CallChecker.isCalled(npe_invocation_var426, SortedBidiMap.class, 79, 2801, 2811).subMap(fromKey, toKey);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2217.methodEnd();
        }
    }

    public SortedMap<K, V> headMap(K toKey) {
        MethodContext _bcornu_methode_context2218 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 82, 2848, 2937);
            CallChecker.varInit(toKey, "toKey", 82, 2848, 2937);
            CallChecker.varInit(this.map, "map", 82, 2848, 2937);
            final SortedBidiMap<K, V> npe_invocation_var427 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var427, SortedBidiMap.class, 83, 2905, 2915)) {
                return CallChecker.isCalled(npe_invocation_var427, SortedBidiMap.class, 83, 2905, 2915).headMap(toKey);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2218.methodEnd();
        }
    }

    public SortedMap<K, V> tailMap(K fromKey) {
        MethodContext _bcornu_methode_context2219 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 86, 2944, 3037);
            CallChecker.varInit(fromKey, "fromKey", 86, 2944, 3037);
            CallChecker.varInit(this.map, "map", 86, 2944, 3037);
            final SortedBidiMap<K, V> npe_invocation_var428 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var428, SortedBidiMap.class, 87, 3003, 3013)) {
                return CallChecker.isCalled(npe_invocation_var428, SortedBidiMap.class, 87, 3003, 3013).tailMap(fromKey);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2219.methodEnd();
        }
    }
}

