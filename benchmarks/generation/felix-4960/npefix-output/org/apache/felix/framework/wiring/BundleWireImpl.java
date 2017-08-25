package org.apache.felix.framework.wiring;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleRequirement;
import org.osgi.framework.wiring.BundleCapability;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class BundleWireImpl implements BundleWire {
    private final BundleRevision m_requirer;

    private final BundleRequirement m_req;

    private final BundleRevision m_provider;

    private final BundleCapability m_cap;

    public BundleWireImpl(BundleRevision requirer, BundleRequirement req, BundleRevision provider, BundleCapability cap) {
        MethodContext _bcornu_methode_context3 = new MethodContext(null);
        try {
            m_requirer = requirer;
            CallChecker.varAssign(this.m_requirer, "this.m_requirer", 37, 1468, 1489);
            m_req = req;
            CallChecker.varAssign(this.m_req, "this.m_req", 38, 1499, 1510);
            m_provider = provider;
            CallChecker.varAssign(this.m_provider, "this.m_provider", 39, 1520, 1541);
            m_cap = cap;
            CallChecker.varAssign(this.m_cap, "this.m_cap", 40, 1551, 1562);
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public BundleRevision getRequirer() {
        MethodContext _bcornu_methode_context44 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 43, 1575, 1648);
            CallChecker.varInit(this.m_cap, "m_cap", 43, 1575, 1648);
            CallChecker.varInit(this.m_provider, "m_provider", 43, 1575, 1648);
            CallChecker.varInit(this.m_req, "m_req", 43, 1575, 1648);
            CallChecker.varInit(this.m_requirer, "m_requirer", 43, 1575, 1648);
            return m_requirer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }

    public BundleWiring getRequirerWiring() {
        MethodContext _bcornu_methode_context45 = new MethodContext(BundleWiring.class);
        try {
            CallChecker.varInit(this, "this", 48, 1655, 1744);
            CallChecker.varInit(this.m_cap, "m_cap", 48, 1655, 1744);
            CallChecker.varInit(this.m_provider, "m_provider", 48, 1655, 1744);
            CallChecker.varInit(this.m_req, "m_req", 48, 1655, 1744);
            CallChecker.varInit(this.m_requirer, "m_requirer", 48, 1655, 1744);
            if (CallChecker.beforeDeref(m_requirer, BundleRevision.class, 50, 1716, 1725)) {
                return CallChecker.isCalled(m_requirer, BundleRevision.class, 50, 1716, 1725).getWiring();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleWiring) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }

    public BundleRequirement getRequirement() {
        MethodContext _bcornu_methode_context46 = new MethodContext(BundleRequirement.class);
        try {
            CallChecker.varInit(this, "this", 53, 1751, 1825);
            CallChecker.varInit(this.m_cap, "m_cap", 53, 1751, 1825);
            CallChecker.varInit(this.m_provider, "m_provider", 53, 1751, 1825);
            CallChecker.varInit(this.m_req, "m_req", 53, 1751, 1825);
            CallChecker.varInit(this.m_requirer, "m_requirer", 53, 1751, 1825);
            return m_req;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRequirement) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context46.methodEnd();
        }
    }

    public BundleRevision getProvider() {
        MethodContext _bcornu_methode_context47 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 58, 1832, 1905);
            CallChecker.varInit(this.m_cap, "m_cap", 58, 1832, 1905);
            CallChecker.varInit(this.m_provider, "m_provider", 58, 1832, 1905);
            CallChecker.varInit(this.m_req, "m_req", 58, 1832, 1905);
            CallChecker.varInit(this.m_requirer, "m_requirer", 58, 1832, 1905);
            return m_provider;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context47.methodEnd();
        }
    }

    public BundleWiring getProviderWiring() {
        MethodContext _bcornu_methode_context48 = new MethodContext(BundleWiring.class);
        try {
            CallChecker.varInit(this, "this", 63, 1912, 2001);
            CallChecker.varInit(this.m_cap, "m_cap", 63, 1912, 2001);
            CallChecker.varInit(this.m_provider, "m_provider", 63, 1912, 2001);
            CallChecker.varInit(this.m_req, "m_req", 63, 1912, 2001);
            CallChecker.varInit(this.m_requirer, "m_requirer", 63, 1912, 2001);
            if (CallChecker.beforeDeref(m_provider, BundleRevision.class, 65, 1973, 1982)) {
                return CallChecker.isCalled(m_provider, BundleRevision.class, 65, 1973, 1982).getWiring();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleWiring) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context48.methodEnd();
        }
    }

    public BundleCapability getCapability() {
        MethodContext _bcornu_methode_context49 = new MethodContext(BundleCapability.class);
        try {
            CallChecker.varInit(this, "this", 68, 2008, 2080);
            CallChecker.varInit(this.m_cap, "m_cap", 68, 2008, 2080);
            CallChecker.varInit(this.m_provider, "m_provider", 68, 2008, 2080);
            CallChecker.varInit(this.m_req, "m_req", 68, 2008, 2080);
            CallChecker.varInit(this.m_requirer, "m_requirer", 68, 2008, 2080);
            return m_cap;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleCapability) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context50 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 73, 2087, 2202);
            CallChecker.varInit(this.m_cap, "m_cap", 73, 2087, 2202);
            CallChecker.varInit(this.m_provider, "m_provider", 73, 2087, 2202);
            CallChecker.varInit(this.m_req, "m_req", 73, 2087, 2202);
            CallChecker.varInit(this.m_requirer, "m_requirer", 73, 2087, 2202);
            return ((((m_req) + " -> ") + "[") + (m_provider)) + "]";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }
}

