package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;

public enum LogLevel {
ALL, TRACE, DEBUG, INFO, WARN, ERROR, OFF;
    public static Collection<String> validValues() {
        MethodContext _bcornu_methode_context179 = new MethodContext(Collection.class);
        try {
            List<String> validValues = CallChecker.varInit(new ArrayList<>(), "validValues", 35, 1099, 1143);
            for (LogLevel level : EnumSet.allOf(LogLevel.class)) {
                if (CallChecker.beforeDeref(level, LogLevel.class, 38, 1244, 1248)) {
                    if (CallChecker.beforeDeref(validValues, List.class, 38, 1228, 1238)) {
                        validValues = CallChecker.beforeCalled(validValues, List.class, 38, 1228, 1238);
                        CallChecker.isCalled(validValues, List.class, 38, 1228, 1238).add(CallChecker.isCalled(level, LogLevel.class, 38, 1244, 1248).name());
                    }
                }
            }
            return validValues;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context179.methodEnd();
        }
    }
}

