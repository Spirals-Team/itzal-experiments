package org.osgi.framework;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.EventObject;
import fr.inria.spirals.npefix.resi.CallChecker;

public class ServiceEvent extends EventObject {
    static final long serialVersionUID = 8792901483909409299L;

    private final ServiceReference<?> reference;

    private final int type;

    public static final int REGISTERED = 1;

    public static final int MODIFIED = 2;

    public static final int UNREGISTERING = 4;

    public static final int MODIFIED_ENDMATCH = 8;

    public ServiceEvent(int type, ServiceReference<?> reference) {
        super(reference);
        MethodContext _bcornu_methode_context164 = new MethodContext(null);
        try {
            this.reference = reference;
            CallChecker.varAssign(this.reference, "this.reference", 112, 3823, 3849);
            this.type = type;
            CallChecker.varAssign(this.type, "this.type", 113, 3853, 3869);
        } finally {
            _bcornu_methode_context164.methodEnd();
        }
    }

    public ServiceReference<?> getServiceReference() {
        MethodContext _bcornu_methode_context1702 = new MethodContext(ServiceReference.class);
        try {
            CallChecker.varInit(this, "this", 124, 3876, 4169);
            CallChecker.varInit(MODIFIED_ENDMATCH, "org.osgi.framework.ServiceEvent.MODIFIED_ENDMATCH", 124, 3876, 4169);
            CallChecker.varInit(UNREGISTERING, "org.osgi.framework.ServiceEvent.UNREGISTERING", 124, 3876, 4169);
            CallChecker.varInit(MODIFIED, "org.osgi.framework.ServiceEvent.MODIFIED", 124, 3876, 4169);
            CallChecker.varInit(REGISTERED, "org.osgi.framework.ServiceEvent.REGISTERED", 124, 3876, 4169);
            CallChecker.varInit(this.type, "type", 124, 3876, 4169);
            CallChecker.varInit(this.reference, "reference", 124, 3876, 4169);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServiceEvent.serialVersionUID", 124, 3876, 4169);
            return reference;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1702.methodEnd();
        }
    }

    public int getType() {
        MethodContext _bcornu_methode_context1703 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 140, 4173, 4491);
            CallChecker.varInit(MODIFIED_ENDMATCH, "org.osgi.framework.ServiceEvent.MODIFIED_ENDMATCH", 140, 4173, 4491);
            CallChecker.varInit(UNREGISTERING, "org.osgi.framework.ServiceEvent.UNREGISTERING", 140, 4173, 4491);
            CallChecker.varInit(MODIFIED, "org.osgi.framework.ServiceEvent.MODIFIED", 140, 4173, 4491);
            CallChecker.varInit(REGISTERED, "org.osgi.framework.ServiceEvent.REGISTERED", 140, 4173, 4491);
            CallChecker.varInit(this.type, "type", 140, 4173, 4491);
            CallChecker.varInit(this.reference, "reference", 140, 4173, 4491);
            CallChecker.varInit(serialVersionUID, "org.osgi.framework.ServiceEvent.serialVersionUID", 140, 4173, 4491);
            return type;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1703.methodEnd();
        }
    }
}

