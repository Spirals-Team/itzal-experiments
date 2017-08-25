package org.apache.felix.framework.resolver;

import org.osgi.service.resolver.ResolutionException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleRequirement;

public class ResolveException extends ResolutionException {
    private final BundleRevision m_revision;

    private final BundleRequirement m_req;

    public ResolveException(String msg, BundleRevision revision, BundleRequirement req) {
        super(msg);
        MethodContext _bcornu_methode_context85 = new MethodContext(null);
        try {
            m_revision = revision;
            CallChecker.varAssign(this.m_revision, "this.m_revision", 37, 1433, 1454);
            m_req = req;
            CallChecker.varAssign(this.m_req, "this.m_req", 38, 1464, 1475);
        } finally {
            _bcornu_methode_context85.methodEnd();
        }
    }

    public BundleRevision getRevision() {
        MethodContext _bcornu_methode_context892 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 41, 1488, 1561);
            CallChecker.varInit(this.m_req, "m_req", 41, 1488, 1561);
            CallChecker.varInit(this.m_revision, "m_revision", 41, 1488, 1561);
            return m_revision;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context892.methodEnd();
        }
    }

    public BundleRequirement getRequirement() {
        MethodContext _bcornu_methode_context893 = new MethodContext(BundleRequirement.class);
        try {
            CallChecker.varInit(this, "this", 46, 1568, 1642);
            CallChecker.varInit(this.m_req, "m_req", 46, 1568, 1642);
            CallChecker.varInit(this.m_revision, "m_revision", 46, 1568, 1642);
            return m_req;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRequirement) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context893.methodEnd();
        }
    }
}

