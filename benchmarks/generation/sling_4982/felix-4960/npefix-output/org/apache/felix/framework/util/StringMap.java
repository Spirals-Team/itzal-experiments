package org.apache.felix.framework.util;

import java.util.TreeMap;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import fr.inria.spirals.npefix.resi.CallChecker;

public class StringMap extends TreeMap<String, Object> {
    public StringMap() {
        super(StringComparator.COMPARATOR);
        MethodContext _bcornu_methode_context130 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context130.methodEnd();
        }
    }

    public StringMap(Map<?, ?> map) {
        this();
        MethodContext _bcornu_methode_context131 = new MethodContext(null);
        try {
            map = CallChecker.beforeCalled(map, Map.class, 43, 1470, 1472);
            for (Map.Entry<?, ?> e : CallChecker.isCalled(map, Map.class, 43, 1470, 1472).entrySet()) {
                if (CallChecker.beforeDeref(e, Map.Entry.class, 45, 1512, 1512)) {
                    if (CallChecker.beforeDeref(e.getKey(), null, 45, 1512, 1521)) {
                        if (CallChecker.beforeDeref(e, Map.Entry.class, 45, 1535, 1535)) {
                            put(e.getKey().toString(), e.getValue());
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context131.methodEnd();
        }
    }
}

