package org.apache.felix.framework;

import org.osgi.framework.Version;
import java.util.Set;
import org.osgi.service.packageadmin.RequiredBundle;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.Bundle;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

class RequiredBundleImpl implements RequiredBundle {
    private final Felix m_felix;

    private final BundleImpl m_bundle;

    private volatile String m_toString = null;

    private volatile String m_versionString = null;

    public RequiredBundleImpl(Felix felix, BundleImpl bundle) {
        MethodContext _bcornu_methode_context41 = new MethodContext(null);
        try {
            m_felix = felix;
            CallChecker.varAssign(this.m_felix, "this.m_felix", 35, 1293, 1308);
            m_bundle = bundle;
            CallChecker.varAssign(this.m_bundle, "this.m_bundle", 36, 1318, 1335);
        } finally {
            _bcornu_methode_context41.methodEnd();
        }
    }

    public String getSymbolicName() {
        MethodContext _bcornu_methode_context517 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 39, 1348, 1433);
            CallChecker.varInit(this.m_versionString, "m_versionString", 39, 1348, 1433);
            CallChecker.varInit(this.m_toString, "m_toString", 39, 1348, 1433);
            CallChecker.varInit(this.m_bundle, "m_bundle", 39, 1348, 1433);
            CallChecker.varInit(this.m_felix, "m_felix", 39, 1348, 1433);
            if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 41, 1401, 1408)) {
                return CallChecker.isCalled(m_bundle, BundleImpl.class, 41, 1401, 1408).getSymbolicName();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context517.methodEnd();
        }
    }

    public Bundle getBundle() {
        MethodContext _bcornu_methode_context518 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 44, 1440, 1501);
            CallChecker.varInit(this.m_versionString, "m_versionString", 44, 1440, 1501);
            CallChecker.varInit(this.m_toString, "m_toString", 44, 1440, 1501);
            CallChecker.varInit(this.m_bundle, "m_bundle", 44, 1440, 1501);
            CallChecker.varInit(this.m_felix, "m_felix", 44, 1440, 1501);
            return m_bundle;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context518.methodEnd();
        }
    }

    public Bundle[] getRequiringBundles() {
        MethodContext _bcornu_methode_context519 = new MethodContext(Bundle[].class);
        try {
            CallChecker.varInit(this, "this", 49, 1508, 1817);
            CallChecker.varInit(this.m_versionString, "m_versionString", 49, 1508, 1817);
            CallChecker.varInit(this.m_toString, "m_toString", 49, 1508, 1817);
            CallChecker.varInit(this.m_bundle, "m_bundle", 49, 1508, 1817);
            CallChecker.varInit(this.m_felix, "m_felix", 49, 1508, 1817);
            if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 52, 1631, 1638)) {
                if (CallChecker.isCalled(m_bundle, BundleImpl.class, 52, 1631, 1638).isStale()) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            Set<Bundle> set = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 56, 1722, 1728)) {
                set = CallChecker.isCalled(m_felix, Felix.class, 56, 1722, 1728).getRequiringBundles(m_bundle);
                CallChecker.varAssign(set, "set", 56, 1722, 1728);
            }
            if (CallChecker.beforeDeref(set, Set.class, 57, 1799, 1801)) {
                if (CallChecker.beforeDeref(set, Set.class, 57, 1776, 1778)) {
                    set = CallChecker.beforeCalled(set, Set.class, 57, 1799, 1801);
                    set = CallChecker.beforeCalled(set, Set.class, 57, 1776, 1778);
                    return CallChecker.isCalled(set, Set.class, 57, 1776, 1778).toArray(new Bundle[CallChecker.isCalled(set, Set.class, 57, 1799, 1801).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context519.methodEnd();
        }
    }

    public Version getVersion() {
        MethodContext _bcornu_methode_context520 = new MethodContext(Version.class);
        try {
            CallChecker.varInit(this, "this", 60, 1824, 1900);
            CallChecker.varInit(this.m_versionString, "m_versionString", 60, 1824, 1900);
            CallChecker.varInit(this.m_toString, "m_toString", 60, 1824, 1900);
            CallChecker.varInit(this.m_bundle, "m_bundle", 60, 1824, 1900);
            CallChecker.varInit(this.m_felix, "m_felix", 60, 1824, 1900);
            if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 62, 1873, 1880)) {
                return CallChecker.isCalled(m_bundle, BundleImpl.class, 62, 1873, 1880).getVersion();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context520.methodEnd();
        }
    }

    public boolean isRemovalPending() {
        MethodContext _bcornu_methode_context521 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 65, 1907, 1995);
            CallChecker.varInit(this.m_versionString, "m_versionString", 65, 1907, 1995);
            CallChecker.varInit(this.m_toString, "m_toString", 65, 1907, 1995);
            CallChecker.varInit(this.m_bundle, "m_bundle", 65, 1907, 1995);
            CallChecker.varInit(this.m_felix, "m_felix", 65, 1907, 1995);
            if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 67, 1962, 1969)) {
                return CallChecker.isCalled(m_bundle, BundleImpl.class, 67, 1962, 1969).isRemovalPending();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context521.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context522 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 70, 2002, 2224);
            CallChecker.varInit(this.m_versionString, "m_versionString", 70, 2002, 2224);
            CallChecker.varInit(this.m_toString, "m_toString", 70, 2002, 2224);
            CallChecker.varInit(this.m_bundle, "m_bundle", 70, 2002, 2224);
            CallChecker.varInit(this.m_felix, "m_felix", 70, 2002, 2224);
            if ((m_toString) == null) {
                if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 74, 2100, 2107)) {
                    if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 75, 2160, 2167)) {
                        m_toString = ((CallChecker.isCalled(m_bundle, BundleImpl.class, 74, 2100, 2107).getSymbolicName()) + "; version=") + (CallChecker.isCalled(m_bundle, BundleImpl.class, 75, 2160, 2167).getVersion());
                        CallChecker.varAssign(this.m_toString, "this.m_toString", 74, 2087, 2181);
                    }
                }
            }
            return m_toString;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context522.methodEnd();
        }
    }
}

