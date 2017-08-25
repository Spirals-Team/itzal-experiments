package org.apache.commons.math3.exception.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;

public class ArgUtils {
    private ArgUtils() {
        ConstructorContext _bcornu_methode_context366 = new ConstructorContext(ArgUtils.class, 32, 1058, 1137);
        try {
        } finally {
            _bcornu_methode_context366.methodEnd();
        }
    }

    public static Object[] flatten(Object[] array) {
        MethodContext _bcornu_methode_context1616 = new MethodContext(Object[].class, 41, 1144, 1862);
        try {
            CallChecker.varInit(array, "array", 41, 1144, 1862);
            final List<Object> list = CallChecker.varInit(new ArrayList<Object>(), "list", 42, 1443, 1492);
            if (array != null) {
                for (Object o : array) {
                    if (o instanceof Object[]) {
                        for (Object oR : ArgUtils.flatten(((Object[]) (o)))) {
                            if (CallChecker.beforeDeref(list, List.class, 47, 1691, 1694)) {
                                CallChecker.isCalled(list, List.class, 47, 1691, 1694).add(oR);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(list, List.class, 50, 1772, 1775)) {
                            CallChecker.isCalled(list, List.class, 50, 1772, 1775).add(o);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 54, 1842, 1845)) {
                return CallChecker.isCalled(list, List.class, 54, 1842, 1845).toArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1616.methodEnd();
        }
    }
}

