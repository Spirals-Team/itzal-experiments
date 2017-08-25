package org.apache.commons.collections.bidimap;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.map.AbstractMapDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public abstract class AbstractBidiMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements BidiMap<K, V> {
    protected AbstractBidiMapDecorator(BidiMap<K, V> map) {
        super(map);
        MethodContext _bcornu_methode_context307 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context307.methodEnd();
        }
    }

    @Override
    protected BidiMap<K, V> decorated() {
        MethodContext _bcornu_methode_context1577 = new MethodContext(BidiMap.class);
        try {
            CallChecker.varInit(this, "this", 59, 2139, 2339);
            CallChecker.varInit(this.map, "map", 59, 2139, 2339);
            return ((BidiMap<K, V>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((BidiMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1577.methodEnd();
        }
    }

    @Override
    public MapIterator<K, V> mapIterator() {
        MethodContext _bcornu_methode_context1578 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 65, 2346, 2525);
            CallChecker.varInit(this.map, "map", 65, 2346, 2525);
            final BidiMap<K, V> npe_invocation_var315 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var315, BidiMap.class, 66, 2494, 2504)) {
                return CallChecker.isCalled(npe_invocation_var315, BidiMap.class, 66, 2494, 2504).mapIterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1578.methodEnd();
        }
    }

    public K getKey(Object value) {
        final BidiMap<K, V> npe_invocation_var316 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var316, BidiMap.class, 70, 2579, 2589)) {
            return npe_invocation_var316.getKey(value);
        }else
            throw new AbnormalExecutionError();
        
    }

    public K removeValue(Object value) {
        final BidiMap<K, V> npe_invocation_var317 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var317, BidiMap.class, 74, 2669, 2679)) {
            return npe_invocation_var317.removeValue(value);
        }else
            throw new AbnormalExecutionError();
        
    }

    public BidiMap<V, K> inverseBidiMap() {
        MethodContext _bcornu_methode_context1581 = new MethodContext(BidiMap.class);
        try {
            CallChecker.varInit(this, "this", 77, 2712, 2801);
            CallChecker.varInit(this.map, "map", 77, 2712, 2801);
            final BidiMap<K, V> npe_invocation_var318 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var318, BidiMap.class, 78, 2767, 2777)) {
                return CallChecker.isCalled(npe_invocation_var318, BidiMap.class, 78, 2767, 2777).inverseBidiMap();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BidiMap<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1581.methodEnd();
        }
    }
}

