package org.apache.felix.framework.util;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class SecurityManagerEx extends SecurityManager {
    public Class[] getClassContext() {
        MethodContext _bcornu_methode_context735 = new MethodContext(Class[].class);
        try {
            CallChecker.varInit(this, "this", 29, 1071, 1154);
            return super.getClassContext();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context735.methodEnd();
        }
    }
}

