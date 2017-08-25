package org.apache.felix.framework;

import org.osgi.framework.Version;
import java.util.Set;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleCapability;
import org.apache.felix.framework.wiring.BundleCapabilityImpl;
import org.osgi.framework.wiring.BundleRevision;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.service.packageadmin.ExportedPackage;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

class ExportedPackageImpl implements ExportedPackage {
    private final Felix m_felix;

    private final BundleImpl m_exportingBundle;

    private final BundleRevision m_exportingRevision;

    private final BundleCapability m_export;

    private final String m_pkgName;

    private final Version m_version;

    public ExportedPackageImpl(Felix felix, BundleImpl exporter, BundleRevision revision, BundleCapability export) {
        MethodContext _bcornu_methode_context84 = new MethodContext(null);
        try {
            m_felix = felix;
            CallChecker.varAssign(this.m_felix, "this.m_felix", 41, 1601, 1616);
            m_exportingBundle = exporter;
            CallChecker.varAssign(this.m_exportingBundle, "this.m_exportingBundle", 42, 1626, 1654);
            m_exportingRevision = revision;
            CallChecker.varAssign(this.m_exportingRevision, "this.m_exportingRevision", 43, 1664, 1694);
            m_export = export;
            CallChecker.varAssign(this.m_export, "this.m_export", 44, 1704, 1721);
            m_pkgName = ((String) (CallChecker.isCalled(CallChecker.isCalled(m_export, BundleCapability.class, 45, 1752, 1759).getAttributes(), Map.class, 45, 1752, 1775).get(BundleRevision.PACKAGE_NAMESPACE)));
            CallChecker.varAssign(this.m_pkgName, "this.m_pkgName", 45, 1731, 1814);
            if (!(CallChecker.isCalled(CallChecker.isCalled(m_export, BundleCapability.class, 46, 1838, 1845).getAttributes(), Map.class, 46, 1838, 1861).containsKey(BundleCapabilityImpl.VERSION_ATTR))) {
                m_version = Version.emptyVersion;
                CallChecker.varAssign(this.m_version, "this.m_version", 46, 1824, 2033);
            }else {
                m_version = ((Version) (CallChecker.isCalled(CallChecker.isCalled(m_export, BundleCapability.class, 48, 1970, 1977).getAttributes(), Map.class, 48, 1970, 1993).get(BundleCapabilityImpl.VERSION_ATTR)));
                CallChecker.varAssign(this.m_version, "this.m_version", 46, 1824, 2033);
            }
        } finally {
            _bcornu_methode_context84.methodEnd();
        }
    }

    public Bundle getExportingBundle() {
        MethodContext _bcornu_methode_context879 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 51, 2046, 2278);
            CallChecker.varInit(this.m_version, "m_version", 51, 2046, 2278);
            CallChecker.varInit(this.m_pkgName, "m_pkgName", 51, 2046, 2278);
            CallChecker.varInit(this.m_export, "m_export", 51, 2046, 2278);
            CallChecker.varInit(this.m_exportingRevision, "m_exportingRevision", 51, 2046, 2278);
            CallChecker.varInit(this.m_exportingBundle, "m_exportingBundle", 51, 2046, 2278);
            CallChecker.varInit(this.m_felix, "m_felix", 51, 2046, 2278);
            if (CallChecker.beforeDeref(m_exportingBundle, BundleImpl.class, 54, 2166, 2182)) {
                if (CallChecker.isCalled(m_exportingBundle, BundleImpl.class, 54, 2166, 2182).isStale()) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            return m_exportingBundle;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context879.methodEnd();
        }
    }

    public Bundle[] getImportingBundles() {
        MethodContext _bcornu_methode_context880 = new MethodContext(Bundle[].class);
        try {
            CallChecker.varInit(this, "this", 61, 2285, 2622);
            CallChecker.varInit(this.m_version, "m_version", 61, 2285, 2622);
            CallChecker.varInit(this.m_pkgName, "m_pkgName", 61, 2285, 2622);
            CallChecker.varInit(this.m_export, "m_export", 61, 2285, 2622);
            CallChecker.varInit(this.m_exportingRevision, "m_exportingRevision", 61, 2285, 2622);
            CallChecker.varInit(this.m_exportingBundle, "m_exportingBundle", 61, 2285, 2622);
            CallChecker.varInit(this.m_felix, "m_felix", 61, 2285, 2622);
            if (CallChecker.beforeDeref(m_exportingBundle, BundleImpl.class, 64, 2408, 2424)) {
                if (CallChecker.isCalled(m_exportingBundle, BundleImpl.class, 64, 2408, 2424).isStale()) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            Set<Bundle> set = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 68, 2508, 2514)) {
                set = CallChecker.isCalled(m_felix, Felix.class, 68, 2508, 2514).getImportingBundles(m_exportingBundle, m_export);
                CallChecker.varAssign(set, "set", 68, 2508, 2514);
            }
            if (CallChecker.beforeDeref(set, Set.class, 69, 2604, 2606)) {
                if (CallChecker.beforeDeref(set, Set.class, 69, 2581, 2583)) {
                    set = CallChecker.beforeCalled(set, Set.class, 69, 2604, 2606);
                    set = CallChecker.beforeCalled(set, Set.class, 69, 2581, 2583);
                    return CallChecker.isCalled(set, Set.class, 69, 2581, 2583).toArray(new Bundle[CallChecker.isCalled(set, Set.class, 69, 2604, 2606).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context880.methodEnd();
        }
    }

    public String getName() {
        MethodContext _bcornu_methode_context881 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 72, 2629, 2689);
            CallChecker.varInit(this.m_version, "m_version", 72, 2629, 2689);
            CallChecker.varInit(this.m_pkgName, "m_pkgName", 72, 2629, 2689);
            CallChecker.varInit(this.m_export, "m_export", 72, 2629, 2689);
            CallChecker.varInit(this.m_exportingRevision, "m_exportingRevision", 72, 2629, 2689);
            CallChecker.varInit(this.m_exportingBundle, "m_exportingBundle", 72, 2629, 2689);
            CallChecker.varInit(this.m_felix, "m_felix", 72, 2629, 2689);
            return m_pkgName;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context881.methodEnd();
        }
    }

    public String getSpecificationVersion() {
        MethodContext _bcornu_methode_context882 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 77, 2696, 2783);
            CallChecker.varInit(this.m_version, "m_version", 77, 2696, 2783);
            CallChecker.varInit(this.m_pkgName, "m_pkgName", 77, 2696, 2783);
            CallChecker.varInit(this.m_export, "m_export", 77, 2696, 2783);
            CallChecker.varInit(this.m_exportingRevision, "m_exportingRevision", 77, 2696, 2783);
            CallChecker.varInit(this.m_exportingBundle, "m_exportingBundle", 77, 2696, 2783);
            CallChecker.varInit(this.m_felix, "m_felix", 77, 2696, 2783);
            if (CallChecker.beforeDeref(m_version, Version.class, 79, 2757, 2765)) {
                return CallChecker.isCalled(m_version, Version.class, 79, 2757, 2765).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context882.methodEnd();
        }
    }

    public Version getVersion() {
        MethodContext _bcornu_methode_context883 = new MethodContext(Version.class);
        try {
            CallChecker.varInit(this, "this", 82, 2790, 2854);
            CallChecker.varInit(this.m_version, "m_version", 82, 2790, 2854);
            CallChecker.varInit(this.m_pkgName, "m_pkgName", 82, 2790, 2854);
            CallChecker.varInit(this.m_export, "m_export", 82, 2790, 2854);
            CallChecker.varInit(this.m_exportingRevision, "m_exportingRevision", 82, 2790, 2854);
            CallChecker.varInit(this.m_exportingBundle, "m_exportingBundle", 82, 2790, 2854);
            CallChecker.varInit(this.m_felix, "m_felix", 82, 2790, 2854);
            return m_version;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context883.methodEnd();
        }
    }

    public boolean isRemovalPending() {
        MethodContext _bcornu_methode_context884 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 87, 2861, 2958);
            CallChecker.varInit(this.m_version, "m_version", 87, 2861, 2958);
            CallChecker.varInit(this.m_pkgName, "m_pkgName", 87, 2861, 2958);
            CallChecker.varInit(this.m_export, "m_export", 87, 2861, 2958);
            CallChecker.varInit(this.m_exportingRevision, "m_exportingRevision", 87, 2861, 2958);
            CallChecker.varInit(this.m_exportingBundle, "m_exportingBundle", 87, 2861, 2958);
            CallChecker.varInit(this.m_felix, "m_felix", 87, 2861, 2958);
            if (CallChecker.beforeDeref(m_exportingBundle, BundleImpl.class, 89, 2916, 2932)) {
                return CallChecker.isCalled(m_exportingBundle, BundleImpl.class, 89, 2916, 2932).isRemovalPending();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context884.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context885 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 92, 2965, 3053);
            CallChecker.varInit(this.m_version, "m_version", 92, 2965, 3053);
            CallChecker.varInit(this.m_pkgName, "m_pkgName", 92, 2965, 3053);
            CallChecker.varInit(this.m_export, "m_export", 92, 2965, 3053);
            CallChecker.varInit(this.m_exportingRevision, "m_exportingRevision", 92, 2965, 3053);
            CallChecker.varInit(this.m_exportingBundle, "m_exportingBundle", 92, 2965, 3053);
            CallChecker.varInit(this.m_felix, "m_felix", 92, 2965, 3053);
            return ((m_pkgName) + "; version=") + (m_version);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context885.methodEnd();
        }
    }
}

