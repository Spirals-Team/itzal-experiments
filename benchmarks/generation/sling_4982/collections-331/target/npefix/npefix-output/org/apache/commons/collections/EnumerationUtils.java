package org.apache.commons.collections;

import java.util.StringTokenizer;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.List;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.iterators.EnumerationIterator;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;

public class EnumerationUtils {
    public EnumerationUtils() {
        MethodContext _bcornu_methode_context102 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context102.methodEnd();
        }
    }

    public static <E> List<E> toList(Enumeration<E> enumeration) {
        MethodContext _bcornu_methode_context564 = new MethodContext(List.class);
        try {
            CallChecker.varInit(enumeration, "enumeration", 52, 1455, 1979);
            return IteratorUtils.toList(new EnumerationIterator<E>(enumeration));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context564.methodEnd();
        }
    }

    public static List<String> toList(StringTokenizer stringTokenizer) {
        MethodContext _bcornu_methode_context565 = new MethodContext(List.class);
        try {
            CallChecker.varInit(stringTokenizer, "stringTokenizer", 62, 1986, 2493);
            List<String> result = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(stringTokenizer, StringTokenizer.class, 63, 2321, 2335)) {
                stringTokenizer = CallChecker.beforeCalled(stringTokenizer, StringTokenizer.class, 63, 2321, 2335);
                result = new ArrayList<String>(CallChecker.isCalled(stringTokenizer, StringTokenizer.class, 63, 2321, 2335).countTokens());
                CallChecker.varAssign(result, "result", 63, 2321, 2335);
            }
            stringTokenizer = CallChecker.beforeCalled(stringTokenizer, StringTokenizer.class, 64, 2368, 2382);
            while (CallChecker.isCalled(stringTokenizer, StringTokenizer.class, 64, 2368, 2382).hasMoreTokens()) {
                if (CallChecker.beforeDeref(stringTokenizer, StringTokenizer.class, 65, 2426, 2440)) {
                    if (CallChecker.beforeDeref(result, List.class, 65, 2415, 2420)) {
                        stringTokenizer = CallChecker.beforeCalled(stringTokenizer, StringTokenizer.class, 65, 2426, 2440);
                        result = CallChecker.beforeCalled(result, List.class, 65, 2415, 2420);
                        CallChecker.isCalled(result, List.class, 65, 2415, 2420).add(CallChecker.isCalled(stringTokenizer, StringTokenizer.class, 65, 2426, 2440).nextToken());
                    }
                }
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context565.methodEnd();
        }
    }
}

