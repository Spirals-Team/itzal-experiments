package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public final class MapTransformer<I, O> implements Serializable , Transformer<I, O> {
    private static final long serialVersionUID = 862391807045468939L;

    private final Map<? super I, ? extends O> iMap;

    public static <I, O> Transformer<I, O> getInstance(Map<? super I, ? extends O> map) {
        MethodContext _bcornu_methode_context2429 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(map, "map", 49, 1524, 1985);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.MapTransformer.serialVersionUID", 49, 1524, 1985);
            if (map == null) {
                return ConstantTransformer.<I, O>getNullInstance();
            }
            return new MapTransformer<I, O>(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2429.methodEnd();
        }
    }

    private MapTransformer(Map<? super I, ? extends O> map) {
        super();
        MethodContext _bcornu_methode_context460 = new MethodContext(null);
        try {
            iMap = map;
            CallChecker.varAssign(this.iMap, "this.iMap", 64, 2257, 2267);
        } finally {
            _bcornu_methode_context460.methodEnd();
        }
    }

    public O transform(I input) {
        if (CallChecker.beforeDeref(iMap, Map.class, 74, 2515, 2518)) {
            return iMap.get(input);
        }else
            throw new AbnormalExecutionError();
        
    }

    public Map<? super I, ? extends O> getMap() {
        MethodContext _bcornu_methode_context2431 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 83, 2543, 2732);
            CallChecker.varInit(this.iMap, "iMap", 83, 2543, 2732);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.MapTransformer.serialVersionUID", 83, 2543, 2732);
            return iMap;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<? super I, ? extends O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2431.methodEnd();
        }
    }
}

