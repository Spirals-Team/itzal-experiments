package org.apache.felix.framework;

import org.apache.felix.framework.util.VersionRange;
import org.osgi.framework.Version;
import org.apache.felix.framework.util.Util;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.wiring.BundleRevisions;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.Bundle;
import java.util.Arrays;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.Constants;
import org.osgi.service.packageadmin.ExportedPackage;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.framework.wiring.FrameworkWiring;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.service.packageadmin.PackageAdmin;
import org.osgi.service.packageadmin.RequiredBundle;

public class PackageAdminImpl implements PackageAdmin {
    private static final Comparator COMPARATOR = new Comparator() {
        public int compare(Object o1, Object o2) {
            MethodContext _bcornu_methode_context968 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 39, 1555, 1796);
                CallChecker.varInit(o2, "o2", 39, 1555, 1796);
                CallChecker.varInit(o1, "o1", 39, 1555, 1796);
                return CallChecker.isCalled(CallChecker.isCalled(((ExportedPackage) (o2)), ExportedPackage.class, 42, 1706, 1707).getVersion(), Version.class, 42, 1687, 1721).compareTo(CallChecker.isCalled(((ExportedPackage) (o1)), ExportedPackage.class, 43, 1769, 1770).getVersion());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context968.methodEnd();
            }
        }
    };

    private Felix m_felix = null;

    PackageAdminImpl(Felix felix) {
        MethodContext _bcornu_methode_context91 = new MethodContext(null);
        try {
            m_felix = felix;
            CallChecker.varAssign(this.m_felix, "this.m_felix", 51, 1889, 1904);
        } finally {
            _bcornu_methode_context91.methodEnd();
        }
    }

    public Bundle getBundle(Class clazz) {
        MethodContext _bcornu_methode_context969 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 61, 1917, 2306);
            CallChecker.varInit(clazz, "clazz", 61, 1917, 2306);
            CallChecker.varInit(PackageAdmin.BUNDLE_TYPE_FRAGMENT, "org.osgi.service.packageadmin.PackageAdmin.BUNDLE_TYPE_FRAGMENT", 61, 1917, 2306);
            CallChecker.varInit(this.m_felix, "m_felix", 61, 1917, 2306);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.PackageAdminImpl.COMPARATOR", 61, 1917, 2306);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 63, 2276, 2282)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 63, 2276, 2282);
                return CallChecker.isCalled(m_felix, Felix.class, 63, 2276, 2282).getBundle(clazz);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context969.methodEnd();
        }
    }

    public Bundle[] getBundles(String symbolicName, String versionRange) {
        MethodContext _bcornu_methode_context971 = new MethodContext(Bundle[].class);
        try {
            CallChecker.varInit(this, "this", 76, 2313, 4093);
            CallChecker.varInit(versionRange, "versionRange", 76, 2313, 4093);
            CallChecker.varInit(symbolicName, "symbolicName", 76, 2313, 4093);
            CallChecker.varInit(PackageAdmin.BUNDLE_TYPE_FRAGMENT, "org.osgi.service.packageadmin.PackageAdmin.BUNDLE_TYPE_FRAGMENT", 76, 2313, 4093);
            CallChecker.varInit(this.m_felix, "m_felix", 76, 2313, 4093);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.PackageAdminImpl.COMPARATOR", 76, 2313, 4093);
            VersionRange vr = CallChecker.init(VersionRange.class);
            if (versionRange == null) {
                vr = null;
                CallChecker.varAssign(vr, "vr", 78, 2907, 2970);
            }else {
                vr = VersionRange.parse(versionRange);
                CallChecker.varAssign(vr, "vr", 78, 2907, 2970);
            }
            Bundle[] bundles = CallChecker.init(Bundle[].class);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 79, 3000, 3006)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 79, 3000, 3006);
                bundles = CallChecker.isCalled(m_felix, Felix.class, 79, 3000, 3006).getBundles();
                CallChecker.varAssign(bundles, "bundles", 79, 3000, 3006);
            }
            List list = CallChecker.varInit(new ArrayList(), "list", 80, 3030, 3057);
            bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 81, 3109, 3115);
            for (int i = 0; (bundles != null) && (i < (CallChecker.isCalled(bundles, Bundle[].class, 81, 3109, 3115).length)); i++) {
                String sym = CallChecker.init(String.class);
                bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 83, 3166, 3172);
                if (CallChecker.beforeDeref(CallChecker.isCalled(bundles, Bundle[].class, 83, 3166, 3172)[i], Bundle.class, 83, 3166, 3175)) {
                    bundles[i] = CallChecker.beforeCalled(bundles[i], Bundle.class, 83, 3166, 3175);
                    sym = CallChecker.isCalled(bundles[i], Bundle.class, 83, 3166, 3175).getSymbolicName();
                    CallChecker.varAssign(sym, "sym", 83, 3166, 3175);
                }
                if ((sym != null) && (sym.equals(symbolicName))) {
                    Version v = CallChecker.init(Version.class);
                    bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 86, 3297, 3303);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(bundles, Bundle[].class, 86, 3297, 3303)[i], Bundle.class, 86, 3297, 3306)) {
                        bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 86, 3297, 3303);
                        CallChecker.isCalled(bundles, Bundle[].class, 86, 3297, 3303)[i] = CallChecker.beforeCalled(CallChecker.isCalled(bundles, Bundle[].class, 86, 3297, 3303)[i], Bundle.class, 86, 3297, 3306);
                        final BundleRevision npe_invocation_var383 = CallChecker.isCalled(CallChecker.isCalled(bundles, Bundle[].class, 86, 3297, 3303)[i], Bundle.class, 86, 3297, 3306).adapt(BundleRevision.class);
                        if (CallChecker.beforeDeref(npe_invocation_var383, BundleRevision.class, 86, 3297, 3334)) {
                            v = CallChecker.isCalled(npe_invocation_var383, BundleRevision.class, 86, 3297, 3334).getVersion();
                            CallChecker.varAssign(v, "v", 86, 3297, 3306);
                        }
                    }
                    if ((vr == null) || (vr.isInRange(v))) {
                        if (CallChecker.beforeDeref(list, List.class, 89, 3441, 3444)) {
                            list = CallChecker.beforeCalled(list, List.class, 89, 3441, 3444);
                            CallChecker.isCalled(list, List.class, 89, 3441, 3444).add(bundles[i]);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 93, 3517, 3520)) {
                list = CallChecker.beforeCalled(list, List.class, 93, 3517, 3520);
                if (CallChecker.isCalled(list, List.class, 93, 3517, 3520).isEmpty()) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(list, List.class, 97, 3631, 3634)) {
                if (CallChecker.beforeDeref(list, List.class, 97, 3607, 3610)) {
                    list = CallChecker.beforeCalled(list, List.class, 97, 3631, 3634);
                    list = CallChecker.beforeCalled(list, List.class, 97, 3607, 3610);
                    bundles = ((Bundle[]) (CallChecker.isCalled(list, List.class, 97, 3607, 3610).toArray(new Bundle[CallChecker.isCalled(list, List.class, 97, 3631, 3634).size()])));
                    CallChecker.varAssign(bundles, "bundles", 97, 3586, 3644);
                }
            }
            Arrays.sort(bundles, new Comparator() {
                public int compare(Object o1, Object o2) {
                    MethodContext _bcornu_methode_context970 = new MethodContext(int.class);
                    try {
                        CallChecker.varInit(this, "this", 99, 3705, 4051);
                        CallChecker.varInit(o2, "o2", 99, 3705, 4051);
                        CallChecker.varInit(o1, "o1", 99, 3705, 4051);
                        Version v1 = CallChecker.init(Version.class);
                        if (CallChecker.beforeDeref(o1, Object.class, 101, 3799, 3800)) {
                            o1 = CallChecker.beforeCalled(o1, Bundle.class, 101, 3799, 3800);
                            final BundleRevision npe_invocation_var384 = CallChecker.isCalled(((Bundle) (o1)), Bundle.class, 101, 3799, 3800).adapt(BundleRevision.class);
                            if (CallChecker.beforeDeref(npe_invocation_var384, BundleRevision.class, 101, 3789, 3829)) {
                                v1 = CallChecker.isCalled(npe_invocation_var384, BundleRevision.class, 101, 3789, 3829).getVersion();
                                CallChecker.varAssign(v1, "v1", 101, 3799, 3800);
                            }
                        }
                        Version v2 = CallChecker.init(Version.class);
                        if (CallChecker.beforeDeref(o2, Object.class, 102, 3884, 3885)) {
                            o2 = CallChecker.beforeCalled(o2, Bundle.class, 102, 3884, 3885);
                            final BundleRevision npe_invocation_var385 = CallChecker.isCalled(((Bundle) (o2)), Bundle.class, 102, 3884, 3885).adapt(BundleRevision.class);
                            if (CallChecker.beforeDeref(npe_invocation_var385, BundleRevision.class, 102, 3874, 3914)) {
                                v2 = CallChecker.isCalled(npe_invocation_var385, BundleRevision.class, 102, 3874, 3914).getVersion();
                                CallChecker.varAssign(v2, "v2", 102, 3884, 3885);
                            }
                        }
                        if (CallChecker.beforeDeref(v2, Version.class, 104, 4021, 4022)) {
                            v2 = CallChecker.beforeCalled(v2, Version.class, 104, 4021, 4022);
                            return CallChecker.isCalled(v2, Version.class, 104, 4021, 4022).compareTo(v1);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context970.methodEnd();
                    }
                }
            });
            return bundles;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context971.methodEnd();
        }
    }

    public int getBundleType(Bundle bundle) {
        MethodContext _bcornu_methode_context972 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 110, 4100, 4414);
            CallChecker.varInit(bundle, "bundle", 110, 4100, 4414);
            CallChecker.varInit(PackageAdmin.BUNDLE_TYPE_FRAGMENT, "org.osgi.service.packageadmin.PackageAdmin.BUNDLE_TYPE_FRAGMENT", 110, 4100, 4414);
            CallChecker.varInit(this.m_felix, "m_felix", 110, 4100, 4414);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.PackageAdminImpl.COMPARATOR", 110, 4100, 4414);
            Map headerMap = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 113, 4204, 4209)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 113, 4204, 4209);
                final BundleRevisionImpl npe_invocation_var386 = ((BundleRevisionImpl) (CallChecker.isCalled(bundle, Bundle.class, 113, 4204, 4209).adapt(BundleRevisionImpl.class)));
                if (CallChecker.beforeDeref(npe_invocation_var386, BundleRevisionImpl.class, 113, 4204, 4241)) {
                    headerMap = CallChecker.isCalled(npe_invocation_var386, BundleRevisionImpl.class, 113, 4204, 4241).getHeaders();
                    CallChecker.varAssign(headerMap, "headerMap", 113, 4204, 4209);
                }
            }
            if (CallChecker.beforeDeref(headerMap, Map.class, 114, 4270, 4278)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 114, 4270, 4278);
                if (CallChecker.isCalled(headerMap, Map.class, 114, 4270, 4278).containsKey(Constants.FRAGMENT_HOST)) {
                    return PackageAdmin.BUNDLE_TYPE_FRAGMENT;
                }
            }else
                throw new AbnormalExecutionError();
            
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context972.methodEnd();
        }
    }

    public ExportedPackage getExportedPackage(String name) {
        MethodContext _bcornu_methode_context973 = new MethodContext(ExportedPackage.class);
        try {
            CallChecker.varInit(this, "this", 129, 4421, 5267);
            CallChecker.varInit(name, "name", 129, 4421, 5267);
            CallChecker.varInit(PackageAdmin.BUNDLE_TYPE_FRAGMENT, "org.osgi.service.packageadmin.PackageAdmin.BUNDLE_TYPE_FRAGMENT", 129, 4421, 5267);
            CallChecker.varInit(this.m_felix, "m_felix", 129, 4421, 5267);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.PackageAdminImpl.COMPARATOR", 129, 4421, 5267);
            ExportedPackage[] pkgs = CallChecker.init(ExportedPackage[].class);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 132, 4928, 4934)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 132, 4928, 4934);
                pkgs = CallChecker.isCalled(m_felix, Felix.class, 132, 4928, 4934).getExportedPackages(name);
                CallChecker.varAssign(pkgs, "pkgs", 132, 4928, 4934);
            }
            if ((pkgs == null) || ((pkgs.length) == 0)) {
                return null;
            }
            Arrays.sort(pkgs, PackageAdminImpl.COMPARATOR);
            return pkgs[0];
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExportedPackage) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context973.methodEnd();
        }
    }

    public ExportedPackage[] getExportedPackages(String name) {
        MethodContext _bcornu_methode_context974 = new MethodContext(ExportedPackage[].class);
        try {
            CallChecker.varInit(this, "this", 144, 5274, 5477);
            CallChecker.varInit(name, "name", 144, 5274, 5477);
            CallChecker.varInit(PackageAdmin.BUNDLE_TYPE_FRAGMENT, "org.osgi.service.packageadmin.PackageAdmin.BUNDLE_TYPE_FRAGMENT", 144, 5274, 5477);
            CallChecker.varInit(this.m_felix, "m_felix", 144, 5274, 5477);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.PackageAdminImpl.COMPARATOR", 144, 5274, 5477);
            ExportedPackage[] pkgs = CallChecker.init(ExportedPackage[].class);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 146, 5371, 5377)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 146, 5371, 5377);
                pkgs = CallChecker.isCalled(m_felix, Felix.class, 146, 5371, 5377).getExportedPackages(name);
                CallChecker.varAssign(pkgs, "pkgs", 146, 5371, 5377);
            }
            if ((pkgs == null) || ((pkgs.length) == 0)) {
                return null;
            }else {
                return pkgs;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExportedPackage[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context974.methodEnd();
        }
    }

    public ExportedPackage[] getExportedPackages(Bundle bundle) {
        MethodContext _bcornu_methode_context975 = new MethodContext(ExportedPackage[].class);
        try {
            CallChecker.varInit(this, "this", 157, 5484, 5978);
            CallChecker.varInit(bundle, "bundle", 157, 5484, 5978);
            CallChecker.varInit(PackageAdmin.BUNDLE_TYPE_FRAGMENT, "org.osgi.service.packageadmin.PackageAdmin.BUNDLE_TYPE_FRAGMENT", 157, 5484, 5978);
            CallChecker.varInit(this.m_felix, "m_felix", 157, 5484, 5978);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.PackageAdminImpl.COMPARATOR", 157, 5484, 5978);
            ExportedPackage[] pkgs = CallChecker.init(ExportedPackage[].class);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 159, 5870, 5876)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 159, 5870, 5876);
                pkgs = CallChecker.isCalled(m_felix, Felix.class, 159, 5870, 5876).getExportedPackages(bundle);
                CallChecker.varAssign(pkgs, "pkgs", 159, 5870, 5876);
            }
            if ((pkgs == null) || ((pkgs.length) == 0)) {
                return null;
            }else {
                return pkgs;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExportedPackage[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context975.methodEnd();
        }
    }

    public Bundle[] getFragments(Bundle bundle) {
        MethodContext _bcornu_methode_context976 = new MethodContext(Bundle[].class);
        try {
            CallChecker.varInit(this, "this", 163, 5985, 7156);
            CallChecker.varInit(bundle, "bundle", 163, 5985, 7156);
            CallChecker.varInit(PackageAdmin.BUNDLE_TYPE_FRAGMENT, "org.osgi.service.packageadmin.PackageAdmin.BUNDLE_TYPE_FRAGMENT", 163, 5985, 7156);
            CallChecker.varInit(this.m_felix, "m_felix", 163, 5985, 7156);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.PackageAdminImpl.COMPARATOR", 163, 5985, 7156);
            if (((getBundleType(bundle)) & (PackageAdmin.BUNDLE_TYPE_FRAGMENT)) == 0) {
                List<Bundle> list = CallChecker.varInit(new ArrayList<Bundle>(), "list", 168, 6193, 6236);
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 170, 6322, 6327);
                for (BundleRevision revision : CallChecker.isCalled(CallChecker.isCalled(bundle, Bundle.class, 170, 6322, 6327).adapt(BundleRevisions.class), BundleRevisions.class, 170, 6322, 6356).getRevisions()) {
                    if (CallChecker.beforeDeref(revision, BundleRevision.class, 173, 6451, 6458)) {
                        if ((CallChecker.isCalled(revision, BundleRevision.class, 173, 6451, 6458).getWiring()) != null) {
                            List<BundleRevision> fragments = CallChecker.init(List.class);
                            if (CallChecker.beforeDeref(revision, BundleRevision.class, 176, 6594, 6601)) {
                                fragments = Util.getFragments(CallChecker.isCalled(revision, BundleRevision.class, 176, 6594, 6601).getWiring());
                                CallChecker.varAssign(fragments, "fragments", 176, 6594, 6601);
                            }
                            fragments = CallChecker.beforeCalled(fragments, List.class, 177, 6657, 6665);
                            for (int i = 0; i < (CallChecker.isCalled(fragments, List.class, 177, 6657, 6665).size()); i++) {
                                Bundle b = CallChecker.init(Bundle.class);
                                if (CallChecker.beforeDeref(fragments, List.class, 179, 6737, 6745)) {
                                    fragments = CallChecker.beforeCalled(fragments, List.class, 179, 6737, 6745);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(fragments, List.class, 179, 6737, 6745).get(i), BundleRevision.class, 179, 6737, 6752)) {
                                        fragments = CallChecker.beforeCalled(fragments, List.class, 179, 6737, 6745);
                                        b = CallChecker.isCalled(CallChecker.isCalled(fragments, List.class, 179, 6737, 6745).get(i), BundleRevision.class, 179, 6737, 6752).getBundle();
                                        CallChecker.varAssign(b, "b", 179, 6737, 6745);
                                    }
                                }
                                if (b != null) {
                                    if (CallChecker.beforeDeref(list, List.class, 182, 6860, 6863)) {
                                        list = CallChecker.beforeCalled(list, List.class, 182, 6860, 6863);
                                        CallChecker.isCalled(list, List.class, 182, 6860, 6863).add(b);
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (CallChecker.beforeDeref(list, List.class, 188, 7014, 7017)) {
                    list = CallChecker.beforeCalled(list, List.class, 188, 7014, 7017);
                    if (CallChecker.isCalled(list, List.class, 188, 7014, 7017).isEmpty()) {
                        return null;
                    }else {
                        if (CallChecker.beforeDeref(list, List.class, 190, 7106, 7109)) {
                            if (CallChecker.beforeDeref(list, List.class, 190, 7082, 7085)) {
                                list = CallChecker.beforeCalled(list, List.class, 190, 7106, 7109);
                                list = CallChecker.beforeCalled(list, List.class, 190, 7082, 7085);
                                return ((Bundle[]) (CallChecker.isCalled(list, List.class, 190, 7082, 7085).toArray(new Bundle[CallChecker.isCalled(list, List.class, 190, 7106, 7109).size()])));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context976.methodEnd();
        }
    }

    public Bundle[] getHosts(Bundle bundle) {
        MethodContext _bcornu_methode_context977 = new MethodContext(Bundle[].class);
        try {
            CallChecker.varInit(this, "this", 195, 7163, 8323);
            CallChecker.varInit(bundle, "bundle", 195, 7163, 8323);
            CallChecker.varInit(PackageAdmin.BUNDLE_TYPE_FRAGMENT, "org.osgi.service.packageadmin.PackageAdmin.BUNDLE_TYPE_FRAGMENT", 195, 7163, 8323);
            CallChecker.varInit(this.m_felix, "m_felix", 195, 7163, 8323);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.PackageAdminImpl.COMPARATOR", 195, 7163, 8323);
            if (((getBundleType(bundle)) & (PackageAdmin.BUNDLE_TYPE_FRAGMENT)) != 0) {
                List<Bundle> list = CallChecker.varInit(new ArrayList<Bundle>(), "list", 200, 7353, 7396);
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 202, 7482, 7487);
                for (BundleRevision revision : CallChecker.isCalled(CallChecker.isCalled(bundle, Bundle.class, 202, 7482, 7487).adapt(BundleRevisions.class), BundleRevisions.class, 202, 7482, 7516).getRevisions()) {
                    if (CallChecker.beforeDeref(revision, BundleRevision.class, 205, 7597, 7604)) {
                        if ((CallChecker.isCalled(revision, BundleRevision.class, 205, 7597, 7604).getWiring()) != null) {
                            List<BundleWire> hostWires = CallChecker.init(List.class);
                            if (CallChecker.beforeDeref(revision, BundleRevision.class, 207, 7694, 7701)) {
                                hostWires = CallChecker.isCalled(revision, BundleRevision.class, 207, 7694, 7701).getWiring().getRequiredWires(null);
                                CallChecker.varAssign(hostWires, "hostWires", 207, 7694, 7701);
                            }
                            hostWires = CallChecker.beforeCalled(hostWires, List.class, 208, 7803, 7811);
                            for (int i = 0; (hostWires != null) && (i < (CallChecker.isCalled(hostWires, List.class, 208, 7803, 7811).size())); i++) {
                                Bundle b = CallChecker.init(Bundle.class);
                                hostWires = CallChecker.beforeCalled(hostWires, List.class, 210, 7884, 7892);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(hostWires, List.class, 210, 7884, 7892).get(i), BundleWire.class, 210, 7884, 7899)) {
                                    hostWires = CallChecker.beforeCalled(hostWires, List.class, 210, 7884, 7892);
                                    final BundleWiring npe_invocation_var387 = CallChecker.isCalled(CallChecker.isCalled(hostWires, List.class, 210, 7884, 7892).get(i), BundleWire.class, 210, 7884, 7899).getProviderWiring();
                                    if (CallChecker.beforeDeref(npe_invocation_var387, BundleWiring.class, 210, 7884, 7919)) {
                                        b = CallChecker.isCalled(npe_invocation_var387, BundleWiring.class, 210, 7884, 7919).getBundle();
                                        CallChecker.varAssign(b, "b", 210, 7884, 7899);
                                    }
                                }
                                if (b != null) {
                                    if (CallChecker.beforeDeref(list, List.class, 213, 8027, 8030)) {
                                        list = CallChecker.beforeCalled(list, List.class, 213, 8027, 8030);
                                        CallChecker.isCalled(list, List.class, 213, 8027, 8030).add(b);
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (CallChecker.beforeDeref(list, List.class, 219, 8181, 8184)) {
                    list = CallChecker.beforeCalled(list, List.class, 219, 8181, 8184);
                    if (CallChecker.isCalled(list, List.class, 219, 8181, 8184).isEmpty()) {
                        return null;
                    }else {
                        if (CallChecker.beforeDeref(list, List.class, 221, 8273, 8276)) {
                            if (CallChecker.beforeDeref(list, List.class, 221, 8249, 8252)) {
                                list = CallChecker.beforeCalled(list, List.class, 221, 8273, 8276);
                                list = CallChecker.beforeCalled(list, List.class, 221, 8249, 8252);
                                return ((Bundle[]) (CallChecker.isCalled(list, List.class, 221, 8249, 8252).toArray(new Bundle[CallChecker.isCalled(list, List.class, 221, 8273, 8276).size()])));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context977.methodEnd();
        }
    }

    public RequiredBundle[] getRequiredBundles(String symbolicName) {
        MethodContext _bcornu_methode_context978 = new MethodContext(RequiredBundle[].class);
        try {
            CallChecker.varInit(this, "this", 226, 8330, 8858);
            CallChecker.varInit(symbolicName, "symbolicName", 226, 8330, 8858);
            CallChecker.varInit(PackageAdmin.BUNDLE_TYPE_FRAGMENT, "org.osgi.service.packageadmin.PackageAdmin.BUNDLE_TYPE_FRAGMENT", 226, 8330, 8858);
            CallChecker.varInit(this.m_felix, "m_felix", 226, 8330, 8858);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.PackageAdminImpl.COMPARATOR", 226, 8330, 8858);
            List list = CallChecker.varInit(new ArrayList(), "list", 228, 8408, 8435);
            m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 229, 8466, 8472);
            for (Bundle bundle : CallChecker.isCalled(m_felix, Felix.class, 229, 8466, 8472).getBundles()) {
                if (CallChecker.beforeDeref(bundle, Bundle.class, 232, 8577, 8582)) {
                    if ((symbolicName == null) || (symbolicName.equals(CallChecker.isCalled(bundle, Bundle.class, 232, 8577, 8582).getSymbolicName()))) {
                        if (CallChecker.beforeDeref(list, List.class, 234, 8635, 8638)) {
                            list = CallChecker.beforeCalled(list, List.class, 234, 8635, 8638);
                            CallChecker.isCalled(list, List.class, 234, 8635, 8638).add(new RequiredBundleImpl(m_felix, ((BundleImpl) (bundle))));
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 237, 8739, 8742)) {
                list = CallChecker.beforeCalled(list, List.class, 237, 8739, 8742);
                if (CallChecker.isCalled(list, List.class, 237, 8739, 8742).isEmpty()) {
                    return null;
                }else {
                    if (CallChecker.beforeDeref(list, List.class, 239, 8839, 8842)) {
                        if (CallChecker.beforeDeref(list, List.class, 239, 8807, 8810)) {
                            list = CallChecker.beforeCalled(list, List.class, 239, 8839, 8842);
                            list = CallChecker.beforeCalled(list, List.class, 239, 8807, 8810);
                            return ((RequiredBundle[]) (CallChecker.isCalled(list, List.class, 239, 8807, 8810).toArray(new RequiredBundle[CallChecker.isCalled(list, List.class, 239, 8839, 8842).size()])));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RequiredBundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context978.methodEnd();
        }
    }

    public void refreshPackages(Bundle[] bundles) throws SecurityException {
        MethodContext _bcornu_methode_context979 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 249, 8865, 9438);
            CallChecker.varInit(bundles, "bundles", 249, 8865, 9438);
            CallChecker.varInit(PackageAdmin.BUNDLE_TYPE_FRAGMENT, "org.osgi.service.packageadmin.PackageAdmin.BUNDLE_TYPE_FRAGMENT", 249, 8865, 9438);
            CallChecker.varInit(this.m_felix, "m_felix", 249, 8865, 9438);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.PackageAdminImpl.COMPARATOR", 249, 8865, 9438);
            List<Bundle> list = CallChecker.init(List.class);
            if (bundles == null) {
                list = null;
                CallChecker.varAssign(list, "list", 252, 9292, 9364);
            }else {
                list = Arrays.asList(bundles);
                CallChecker.varAssign(list, "list", 252, 9292, 9364);
            }
            if (CallChecker.beforeDeref(m_felix, Felix.class, 255, 9375, 9381)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 255, 9375, 9381);
                final FrameworkWiring npe_invocation_var388 = CallChecker.isCalled(m_felix, Felix.class, 255, 9375, 9381).adapt(FrameworkWiring.class);
                if (CallChecker.beforeDeref(npe_invocation_var388, FrameworkWiring.class, 255, 9375, 9410)) {
                    CallChecker.isCalled(npe_invocation_var388, FrameworkWiring.class, 255, 9375, 9410).refreshBundles(list);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context979.methodEnd();
        }
    }

    public boolean resolveBundles(Bundle[] bundles) {
        MethodContext _bcornu_methode_context980 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 258, 9445, 9680);
            CallChecker.varInit(bundles, "bundles", 258, 9445, 9680);
            CallChecker.varInit(PackageAdmin.BUNDLE_TYPE_FRAGMENT, "org.osgi.service.packageadmin.PackageAdmin.BUNDLE_TYPE_FRAGMENT", 258, 9445, 9680);
            CallChecker.varInit(this.m_felix, "m_felix", 258, 9445, 9680);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.PackageAdminImpl.COMPARATOR", 258, 9445, 9680);
            List<Bundle> list = CallChecker.init(List.class);
            if (bundles == null) {
                list = null;
                CallChecker.varAssign(list, "list", 260, 9527, 9599);
            }else {
                list = Arrays.asList(bundles);
                CallChecker.varAssign(list, "list", 260, 9527, 9599);
            }
            if (CallChecker.beforeDeref(m_felix, Felix.class, 263, 9617, 9623)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 263, 9617, 9623);
                final FrameworkWiring npe_invocation_var389 = CallChecker.isCalled(m_felix, Felix.class, 263, 9617, 9623).adapt(FrameworkWiring.class);
                if (CallChecker.beforeDeref(npe_invocation_var389, FrameworkWiring.class, 263, 9617, 9652)) {
                    return CallChecker.isCalled(npe_invocation_var389, FrameworkWiring.class, 263, 9617, 9652).resolveBundles(list);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context980.methodEnd();
        }
    }
}

