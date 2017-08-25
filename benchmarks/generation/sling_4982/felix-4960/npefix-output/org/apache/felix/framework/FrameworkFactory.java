package org.apache.felix.framework;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import org.osgi.framework.launch.Framework;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class FrameworkFactory implements org.osgi.framework.launch.FrameworkFactory {
    public Framework newFramework(Map configuration) {
        MethodContext _bcornu_methode_context1505 = new MethodContext(Framework.class);
        try {
            CallChecker.varInit(this, "this", 26, 1004, 1104);
            CallChecker.varInit(configuration, "configuration", 26, 1004, 1104);
            return new Felix(configuration);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Framework) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1505.methodEnd();
        }
    }
}

