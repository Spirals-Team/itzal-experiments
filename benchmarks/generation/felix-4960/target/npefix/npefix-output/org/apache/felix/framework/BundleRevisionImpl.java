package org.apache.felix.framework;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import org.apache.felix.framework.cache.Content;
import org.apache.felix.framework.util.FelixConstants;
import org.apache.felix.framework.util.SecureAction;
import org.apache.felix.framework.util.Util;
import org.apache.felix.framework.util.manifestparser.ManifestParser;
import org.apache.felix.framework.util.manifestparser.NativeLibrary;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.Version;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.wiring.BundleRequirement;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.resource.Capability;
import org.osgi.resource.Requirement;
import org.osgi.resource.Resource;

public class BundleRevisionImpl implements BundleRevision , Resource {
    public static final int EAGER_ACTIVATION = 0;

    public static final int LAZY_ACTIVATION = 1;

    private final String m_id;

    private final Map m_headerMap;

    private final String m_manifestVersion;

    private final boolean m_isExtension;

    private final boolean m_isFragment;

    private final String m_symbolicName;

    private final Version m_version;

    private final List<BundleCapability> m_declaredCaps;

    private final List<BundleRequirement> m_declaredReqs;

    private final List<NativeLibrary> m_declaredNativeLibs;

    private final int m_declaredActivationPolicy;

    private final List<String> m_activationIncludes;

    private final List<String> m_activationExcludes;

    private final Bundle m_bundle;

    private Content m_content;

    private List<Content> m_contentPath;

    private ProtectionDomain m_protectionDomain = null;

    private static final SecureAction m_secureAction = new SecureAction();

    private volatile BundleWiringImpl m_wiring = null;

    public BundleRevisionImpl(Bundle bundle, String id) {
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(BundleRevisionImpl.class, 91, 3043, 3926);
        try {
            m_bundle = bundle;
            CallChecker.varAssign(this.m_bundle, "this.m_bundle", 93, 3416, 3433);
            m_id = id;
            CallChecker.varAssign(this.m_id, "this.m_id", 94, 3443, 3452);
            m_headerMap = null;
            CallChecker.varAssign(this.m_headerMap, "this.m_headerMap", 95, 3462, 3480);
            m_content = null;
            CallChecker.varAssign(this.m_content, "this.m_content", 96, 3490, 3506);
            m_manifestVersion = "";
            CallChecker.varAssign(this.m_manifestVersion, "this.m_manifestVersion", 97, 3516, 3538);
            m_symbolicName = null;
            CallChecker.varAssign(this.m_symbolicName, "this.m_symbolicName", 98, 3548, 3569);
            m_isExtension = false;
            CallChecker.varAssign(this.m_isExtension, "this.m_isExtension", 99, 3579, 3600);
            m_isFragment = false;
            CallChecker.varAssign(this.m_isFragment, "this.m_isFragment", 100, 3610, 3630);
            m_version = null;
            CallChecker.varAssign(this.m_version, "this.m_version", 101, 3640, 3656);
            m_declaredCaps = Collections.EMPTY_LIST;
            CallChecker.varAssign(this.m_declaredCaps, "this.m_declaredCaps", 102, 3666, 3705);
            m_declaredReqs = Collections.EMPTY_LIST;
            CallChecker.varAssign(this.m_declaredReqs, "this.m_declaredReqs", 103, 3715, 3754);
            m_declaredNativeLibs = null;
            CallChecker.varAssign(this.m_declaredNativeLibs, "this.m_declaredNativeLibs", 104, 3764, 3791);
            m_declaredActivationPolicy = BundleRevisionImpl.EAGER_ACTIVATION;
            CallChecker.varAssign(this.m_declaredActivationPolicy, "this.m_declaredActivationPolicy", 105, 3801, 3846);
            m_activationExcludes = null;
            CallChecker.varAssign(this.m_activationExcludes, "this.m_activationExcludes", 106, 3856, 3883);
            m_activationIncludes = null;
            CallChecker.varAssign(this.m_activationIncludes, "this.m_activationIncludes", 107, 3893, 3920);
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    BundleRevisionImpl(Bundle bundle, String id, Map headerMap, Content content) throws BundleException {
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(BundleRevisionImpl.class, 110, 3933, 5422);
        try {
            m_bundle = bundle;
            CallChecker.varAssign(this.m_bundle, "this.m_bundle", 114, 4064, 4081);
            m_id = id;
            CallChecker.varAssign(this.m_id, "this.m_id", 115, 4091, 4100);
            m_headerMap = headerMap;
            CallChecker.varAssign(this.m_headerMap, "this.m_headerMap", 116, 4110, 4133);
            m_content = content;
            CallChecker.varAssign(this.m_content, "this.m_content", 117, 4143, 4162);
            ManifestParser mp = CallChecker.init(ManifestParser.class);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 120, 4239, 4244)) {
                bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 120, 4239, 4244);
                if (CallChecker.beforeDeref(CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 120, 4239, 4244).getFramework(), Felix.class, 120, 4225, 4260)) {
                    if (CallChecker.beforeDeref(bundle, Bundle.class, 121, 4301, 4306)) {
                        bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 121, 4301, 4306);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 121, 4301, 4306).getFramework(), Felix.class, 121, 4287, 4322)) {
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 120, 4239, 4244);
                            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 121, 4301, 4306);
                            mp = new ManifestParser(CallChecker.isCalled(CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 120, 4239, 4244).getFramework(), Felix.class, 120, 4225, 4260).getLogger(), CallChecker.isCalled(CallChecker.isCalled(((BundleImpl) (bundle)), BundleImpl.class, 121, 4301, 4306).getFramework(), Felix.class, 121, 4287, 4322).getConfig(), this, m_headerMap);
                            CallChecker.varAssign(mp, "mp", 120, 4239, 4244);
                        }
                    }
                }
            }
            mp = CallChecker.beforeCalled(mp, ManifestParser.class, 128, 4607, 4608);
            m_manifestVersion = CallChecker.isCalled(mp, ManifestParser.class, 128, 4607, 4608).getManifestVersion();
            CallChecker.varAssign(this.m_manifestVersion, "this.m_manifestVersion", 128, 4587, 4630);
            mp = CallChecker.beforeCalled(mp, ManifestParser.class, 129, 4652, 4653);
            m_version = CallChecker.isCalled(mp, ManifestParser.class, 129, 4652, 4653).getBundleVersion();
            CallChecker.varAssign(this.m_version, "this.m_version", 129, 4640, 4673);
            mp = CallChecker.beforeCalled(mp, ManifestParser.class, 130, 4700, 4701);
            m_declaredCaps = CallChecker.isCalled(mp, ManifestParser.class, 130, 4700, 4701).getCapabilities();
            CallChecker.varAssign(this.m_declaredCaps, "this.m_declaredCaps", 130, 4683, 4720);
            mp = CallChecker.beforeCalled(mp, ManifestParser.class, 131, 4747, 4748);
            m_declaredReqs = CallChecker.isCalled(mp, ManifestParser.class, 131, 4747, 4748).getRequirements();
            CallChecker.varAssign(this.m_declaredReqs, "this.m_declaredReqs", 131, 4730, 4767);
            mp = CallChecker.beforeCalled(mp, ManifestParser.class, 132, 4800, 4801);
            m_declaredNativeLibs = CallChecker.isCalled(mp, ManifestParser.class, 132, 4800, 4801).getLibraries();
            CallChecker.varAssign(this.m_declaredNativeLibs, "this.m_declaredNativeLibs", 132, 4777, 4817);
            mp = CallChecker.beforeCalled(mp, ManifestParser.class, 133, 4856, 4857);
            m_declaredActivationPolicy = CallChecker.isCalled(mp, ManifestParser.class, 133, 4856, 4857).getActivationPolicy();
            CallChecker.varAssign(this.m_declaredActivationPolicy, "this.m_declaredActivationPolicy", 133, 4827, 4880);
            mp = CallChecker.beforeCalled(mp, ManifestParser.class, 134, 4914, 4915);
            if ((CallChecker.isCalled(mp, ManifestParser.class, 134, 4914, 4915).getActivationExcludeDirective()) == null) {
                m_activationExcludes = null;
                CallChecker.varAssign(this.m_activationExcludes, "this.m_activationExcludes", 134, 4890, 5067);
            }else {
                mp = CallChecker.beforeCalled(mp, ManifestParser.class, 136, 5027, 5028);
                m_activationExcludes = ManifestParser.parseDelimitedString(CallChecker.isCalled(mp, ManifestParser.class, 136, 5027, 5028).getActivationExcludeDirective(), ",");
                CallChecker.varAssign(this.m_activationExcludes, "this.m_activationExcludes", 134, 4890, 5067);
            }
            mp = CallChecker.beforeCalled(mp, ManifestParser.class, 137, 5101, 5102);
            if ((CallChecker.isCalled(mp, ManifestParser.class, 137, 5101, 5102).getActivationIncludeDirective()) == null) {
                m_activationIncludes = null;
                CallChecker.varAssign(this.m_activationIncludes, "this.m_activationIncludes", 137, 5077, 5254);
            }else {
                mp = CallChecker.beforeCalled(mp, ManifestParser.class, 139, 5214, 5215);
                m_activationIncludes = ManifestParser.parseDelimitedString(CallChecker.isCalled(mp, ManifestParser.class, 139, 5214, 5215).getActivationIncludeDirective(), ",");
                CallChecker.varAssign(this.m_activationIncludes, "this.m_activationIncludes", 137, 5077, 5254);
            }
            mp = CallChecker.beforeCalled(mp, ManifestParser.class, 140, 5281, 5282);
            m_symbolicName = CallChecker.isCalled(mp, ManifestParser.class, 140, 5281, 5282).getSymbolicName();
            CallChecker.varAssign(this.m_symbolicName, "this.m_symbolicName", 140, 5264, 5301);
            mp = CallChecker.beforeCalled(mp, ManifestParser.class, 141, 5327, 5328);
            m_isExtension = CallChecker.isCalled(mp, ManifestParser.class, 141, 5327, 5328).isExtension();
            CallChecker.varAssign(this.m_isExtension, "this.m_isExtension", 141, 5311, 5343);
            m_isFragment = CallChecker.isCalled(m_headerMap, Map.class, 142, 5368, 5378).containsKey(Constants.FRAGMENT_HOST);
            CallChecker.varAssign(this.m_isFragment, "this.m_isFragment", 142, 5353, 5416);
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    static SecureAction getSecureAction() {
        MethodContext _bcornu_methode_context1 = new MethodContext(SecureAction.class, 145, 5429, 5508);
        try {
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 145, 5429, 5508);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 145, 5429, 5508);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 145, 5429, 5508);
            return BundleRevisionImpl.m_secureAction;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SecureAction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    int getDeclaredActivationPolicy() {
        MethodContext _bcornu_methode_context2 = new MethodContext(int.class, 150, 5515, 5602);
        try {
            CallChecker.varInit(this, "this", 150, 5515, 5602);
            CallChecker.varInit(this.m_wiring, "m_wiring", 150, 5515, 5602);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 150, 5515, 5602);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 150, 5515, 5602);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 150, 5515, 5602);
            CallChecker.varInit(this.m_content, "m_content", 150, 5515, 5602);
            CallChecker.varInit(this.m_bundle, "m_bundle", 150, 5515, 5602);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 150, 5515, 5602);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 150, 5515, 5602);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 150, 5515, 5602);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 150, 5515, 5602);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 150, 5515, 5602);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 150, 5515, 5602);
            CallChecker.varInit(this.m_version, "m_version", 150, 5515, 5602);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 150, 5515, 5602);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 150, 5515, 5602);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 150, 5515, 5602);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 150, 5515, 5602);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 150, 5515, 5602);
            CallChecker.varInit(this.m_id, "m_id", 150, 5515, 5602);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 150, 5515, 5602);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 150, 5515, 5602);
            return m_declaredActivationPolicy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    boolean isActivationTrigger(String pkgName) {
        MethodContext _bcornu_methode_context3 = new MethodContext(boolean.class, 155, 5609, 6626);
        try {
            CallChecker.varInit(this, "this", 155, 5609, 6626);
            CallChecker.varInit(pkgName, "pkgName", 155, 5609, 6626);
            CallChecker.varInit(this.m_wiring, "m_wiring", 155, 5609, 6626);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 155, 5609, 6626);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 155, 5609, 6626);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 155, 5609, 6626);
            CallChecker.varInit(this.m_content, "m_content", 155, 5609, 6626);
            CallChecker.varInit(this.m_bundle, "m_bundle", 155, 5609, 6626);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 155, 5609, 6626);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 155, 5609, 6626);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 155, 5609, 6626);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 155, 5609, 6626);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 155, 5609, 6626);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 155, 5609, 6626);
            CallChecker.varInit(this.m_version, "m_version", 155, 5609, 6626);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 155, 5609, 6626);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 155, 5609, 6626);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 155, 5609, 6626);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 155, 5609, 6626);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 155, 5609, 6626);
            CallChecker.varInit(this.m_id, "m_id", 155, 5609, 6626);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 155, 5609, 6626);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 155, 5609, 6626);
            if (((m_activationIncludes) == null) && ((m_activationExcludes) == null)) {
                return true;
            }
            boolean included = CallChecker.varInit(((boolean) ((this.m_activationIncludes) == null)), "included", 164, 5920, 5969);
            for (int i = 0; ((!included) && ((m_activationIncludes) != null)) && (i < (m_activationIncludes.size())); i++) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m_activationIncludes, List.class, 169, 6141, 6160).get(i), String.class, 169, 6141, 6167)) {
                    included = CallChecker.isCalled(m_activationIncludes.get(i), String.class, 169, 6141, 6167).equals(pkgName);
                    CallChecker.varAssign(included, "included", 169, 6130, 6184);
                }
            }
            boolean excluded = CallChecker.varInit(((boolean) (false)), "excluded", 174, 6333, 6357);
            for (int i = 0; ((!excluded) && ((m_activationExcludes) != null)) && (i < (m_activationExcludes.size())); i++) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(m_activationExcludes, List.class, 179, 6529, 6548).get(i), String.class, 179, 6529, 6555)) {
                    excluded = CallChecker.isCalled(m_activationExcludes.get(i), String.class, 179, 6529, 6555).equals(pkgName);
                    CallChecker.varAssign(excluded, "excluded", 179, 6518, 6572);
                }
            }
            return included && (!excluded);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public String getSymbolicName() {
        MethodContext _bcornu_methode_context4 = new MethodContext(String.class, 188, 6633, 6752);
        try {
            CallChecker.varInit(this, "this", 188, 6633, 6752);
            CallChecker.varInit(this.m_wiring, "m_wiring", 188, 6633, 6752);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 188, 6633, 6752);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 188, 6633, 6752);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 188, 6633, 6752);
            CallChecker.varInit(this.m_content, "m_content", 188, 6633, 6752);
            CallChecker.varInit(this.m_bundle, "m_bundle", 188, 6633, 6752);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 188, 6633, 6752);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 188, 6633, 6752);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 188, 6633, 6752);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 188, 6633, 6752);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 188, 6633, 6752);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 188, 6633, 6752);
            CallChecker.varInit(this.m_version, "m_version", 188, 6633, 6752);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 188, 6633, 6752);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 188, 6633, 6752);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 188, 6633, 6752);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 188, 6633, 6752);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 188, 6633, 6752);
            CallChecker.varInit(this.m_id, "m_id", 188, 6633, 6752);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 188, 6633, 6752);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 188, 6633, 6752);
            return m_symbolicName;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public Version getVersion() {
        MethodContext _bcornu_methode_context5 = new MethodContext(Version.class, 193, 6759, 6823);
        try {
            CallChecker.varInit(this, "this", 193, 6759, 6823);
            CallChecker.varInit(this.m_wiring, "m_wiring", 193, 6759, 6823);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 193, 6759, 6823);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 193, 6759, 6823);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 193, 6759, 6823);
            CallChecker.varInit(this.m_content, "m_content", 193, 6759, 6823);
            CallChecker.varInit(this.m_bundle, "m_bundle", 193, 6759, 6823);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 193, 6759, 6823);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 193, 6759, 6823);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 193, 6759, 6823);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 193, 6759, 6823);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 193, 6759, 6823);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 193, 6759, 6823);
            CallChecker.varInit(this.m_version, "m_version", 193, 6759, 6823);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 193, 6759, 6823);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 193, 6759, 6823);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 193, 6759, 6823);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 193, 6759, 6823);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 193, 6759, 6823);
            CallChecker.varInit(this.m_id, "m_id", 193, 6759, 6823);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 193, 6759, 6823);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 193, 6759, 6823);
            return m_version;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public List<Capability> getCapabilities(String namespace) {
        MethodContext _bcornu_methode_context6 = new MethodContext(List.class, 198, 6830, 6967);
        try {
            CallChecker.varInit(this, "this", 198, 6830, 6967);
            CallChecker.varInit(namespace, "namespace", 198, 6830, 6967);
            CallChecker.varInit(this.m_wiring, "m_wiring", 198, 6830, 6967);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 198, 6830, 6967);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 198, 6830, 6967);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 198, 6830, 6967);
            CallChecker.varInit(this.m_content, "m_content", 198, 6830, 6967);
            CallChecker.varInit(this.m_bundle, "m_bundle", 198, 6830, 6967);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 198, 6830, 6967);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 198, 6830, 6967);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 198, 6830, 6967);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 198, 6830, 6967);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 198, 6830, 6967);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 198, 6830, 6967);
            CallChecker.varInit(this.m_version, "m_version", 198, 6830, 6967);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 198, 6830, 6967);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 198, 6830, 6967);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 198, 6830, 6967);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 198, 6830, 6967);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 198, 6830, 6967);
            CallChecker.varInit(this.m_id, "m_id", 198, 6830, 6967);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 198, 6830, 6967);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 198, 6830, 6967);
            return BundleRevisionImpl.asCapabilityList(getDeclaredCapabilities(namespace));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Capability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    static List<Capability> asCapabilityList(List reqs) {
        MethodContext _bcornu_methode_context7 = new MethodContext(List.class, 203, 6974, 7057);
        try {
            CallChecker.varInit(reqs, "reqs", 203, 6974, 7057);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 203, 6974, 7057);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 203, 6974, 7057);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 203, 6974, 7057);
            return reqs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Capability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public List<BundleCapability> getDeclaredCapabilities(String namespace) {
        MethodContext _bcornu_methode_context8 = new MethodContext(List.class, 208, 7064, 7547);
        try {
            CallChecker.varInit(this, "this", 208, 7064, 7547);
            CallChecker.varInit(namespace, "namespace", 208, 7064, 7547);
            CallChecker.varInit(this.m_wiring, "m_wiring", 208, 7064, 7547);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 208, 7064, 7547);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 208, 7064, 7547);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 208, 7064, 7547);
            CallChecker.varInit(this.m_content, "m_content", 208, 7064, 7547);
            CallChecker.varInit(this.m_bundle, "m_bundle", 208, 7064, 7547);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 208, 7064, 7547);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 208, 7064, 7547);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 208, 7064, 7547);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 208, 7064, 7547);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 208, 7064, 7547);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 208, 7064, 7547);
            CallChecker.varInit(this.m_version, "m_version", 208, 7064, 7547);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 208, 7064, 7547);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 208, 7064, 7547);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 208, 7064, 7547);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 208, 7064, 7547);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 208, 7064, 7547);
            CallChecker.varInit(this.m_id, "m_id", 208, 7064, 7547);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 208, 7064, 7547);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 208, 7064, 7547);
            List<BundleCapability> result = CallChecker.varInit(m_declaredCaps, "result", 210, 7150, 7196);
            if (namespace != null) {
                result = new ArrayList<BundleCapability>();
                CallChecker.varAssign(result, "result", 213, 7251, 7293);
                if (CallChecker.beforeDeref(m_declaredCaps, List.class, 214, 7335, 7348)) {
                    for (BundleCapability cap : m_declaredCaps) {
                        if (CallChecker.beforeDeref(cap, BundleCapability.class, 216, 7385, 7387)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(cap, BundleCapability.class, 216, 7385, 7387).getNamespace(), String.class, 216, 7385, 7402)) {
                                if (CallChecker.isCalled(CallChecker.isCalled(cap, BundleCapability.class, 216, 7385, 7387).getNamespace(), String.class, 216, 7385, 7402).equals(namespace)) {
                                    if (CallChecker.beforeDeref(result, List.class, 218, 7461, 7466)) {
                                        result = CallChecker.beforeCalled(result, List.class, 218, 7461, 7466);
                                        CallChecker.isCalled(result, List.class, 218, 7461, 7466).add(cap);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public List<Requirement> getRequirements(String namespace) {
        MethodContext _bcornu_methode_context9 = new MethodContext(List.class, 225, 7554, 7693);
        try {
            CallChecker.varInit(this, "this", 225, 7554, 7693);
            CallChecker.varInit(namespace, "namespace", 225, 7554, 7693);
            CallChecker.varInit(this.m_wiring, "m_wiring", 225, 7554, 7693);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 225, 7554, 7693);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 225, 7554, 7693);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 225, 7554, 7693);
            CallChecker.varInit(this.m_content, "m_content", 225, 7554, 7693);
            CallChecker.varInit(this.m_bundle, "m_bundle", 225, 7554, 7693);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 225, 7554, 7693);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 225, 7554, 7693);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 225, 7554, 7693);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 225, 7554, 7693);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 225, 7554, 7693);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 225, 7554, 7693);
            CallChecker.varInit(this.m_version, "m_version", 225, 7554, 7693);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 225, 7554, 7693);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 225, 7554, 7693);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 225, 7554, 7693);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 225, 7554, 7693);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 225, 7554, 7693);
            CallChecker.varInit(this.m_id, "m_id", 225, 7554, 7693);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 225, 7554, 7693);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 225, 7554, 7693);
            return BundleRevisionImpl.asRequirementList(getDeclaredRequirements(namespace));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Requirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    static List<Requirement> asRequirementList(List reqs) {
        MethodContext _bcornu_methode_context10 = new MethodContext(List.class, 230, 7700, 7785);
        try {
            CallChecker.varInit(reqs, "reqs", 230, 7700, 7785);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 230, 7700, 7785);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 230, 7700, 7785);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 230, 7700, 7785);
            return reqs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Requirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public List<BundleRequirement> getDeclaredRequirements(String namespace) {
        MethodContext _bcornu_methode_context11 = new MethodContext(List.class, 235, 7792, 8279);
        try {
            CallChecker.varInit(this, "this", 235, 7792, 8279);
            CallChecker.varInit(namespace, "namespace", 235, 7792, 8279);
            CallChecker.varInit(this.m_wiring, "m_wiring", 235, 7792, 8279);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 235, 7792, 8279);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 235, 7792, 8279);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 235, 7792, 8279);
            CallChecker.varInit(this.m_content, "m_content", 235, 7792, 8279);
            CallChecker.varInit(this.m_bundle, "m_bundle", 235, 7792, 8279);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 235, 7792, 8279);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 235, 7792, 8279);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 235, 7792, 8279);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 235, 7792, 8279);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 235, 7792, 8279);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 235, 7792, 8279);
            CallChecker.varInit(this.m_version, "m_version", 235, 7792, 8279);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 235, 7792, 8279);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 235, 7792, 8279);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 235, 7792, 8279);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 235, 7792, 8279);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 235, 7792, 8279);
            CallChecker.varInit(this.m_id, "m_id", 235, 7792, 8279);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 235, 7792, 8279);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 235, 7792, 8279);
            List<BundleRequirement> result = CallChecker.varInit(m_declaredReqs, "result", 237, 7879, 7926);
            if (namespace != null) {
                result = new ArrayList<BundleRequirement>();
                CallChecker.varAssign(result, "result", 240, 7981, 8024);
                if (CallChecker.beforeDeref(m_declaredReqs, List.class, 241, 8067, 8080)) {
                    for (BundleRequirement req : m_declaredReqs) {
                        if (CallChecker.beforeDeref(req, BundleRequirement.class, 243, 8117, 8119)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(req, BundleRequirement.class, 243, 8117, 8119).getNamespace(), String.class, 243, 8117, 8134)) {
                                if (CallChecker.isCalled(CallChecker.isCalled(req, BundleRequirement.class, 243, 8117, 8119).getNamespace(), String.class, 243, 8117, 8134).equals(namespace)) {
                                    if (CallChecker.beforeDeref(result, List.class, 245, 8193, 8198)) {
                                        result = CallChecker.beforeCalled(result, List.class, 245, 8193, 8198);
                                        CallChecker.isCalled(result, List.class, 245, 8193, 8198).add(req);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRequirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public int getTypes() {
        MethodContext _bcornu_methode_context12 = new MethodContext(int.class, 252, 8286, 8420);
        try {
            CallChecker.varInit(this, "this", 252, 8286, 8420);
            CallChecker.varInit(this.m_wiring, "m_wiring", 252, 8286, 8420);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 252, 8286, 8420);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 252, 8286, 8420);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 252, 8286, 8420);
            CallChecker.varInit(this.m_content, "m_content", 252, 8286, 8420);
            CallChecker.varInit(this.m_bundle, "m_bundle", 252, 8286, 8420);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 252, 8286, 8420);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 252, 8286, 8420);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 252, 8286, 8420);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 252, 8286, 8420);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 252, 8286, 8420);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 252, 8286, 8420);
            CallChecker.varInit(this.m_version, "m_version", 252, 8286, 8420);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 252, 8286, 8420);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 252, 8286, 8420);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 252, 8286, 8420);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 252, 8286, 8420);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 252, 8286, 8420);
            CallChecker.varInit(this.m_id, "m_id", 252, 8286, 8420);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 252, 8286, 8420);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 252, 8286, 8420);
            final String npe_invocation_var0 = getManifestVersion();
            if (CallChecker.beforeDeref(npe_invocation_var0, String.class, 254, 8330, 8349)) {
                if ((CallChecker.isCalled(npe_invocation_var0, String.class, 254, 8330, 8349).equals("2")) && (m_isFragment)) {
                    return BundleRevision.TYPE_FRAGMENT;
                }else {
                    return 0;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public BundleWiring getWiring() {
        MethodContext _bcornu_methode_context13 = new MethodContext(BundleWiring.class, 257, 8427, 8494);
        try {
            CallChecker.varInit(this, "this", 257, 8427, 8494);
            CallChecker.varInit(this.m_wiring, "m_wiring", 257, 8427, 8494);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 257, 8427, 8494);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 257, 8427, 8494);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 257, 8427, 8494);
            CallChecker.varInit(this.m_content, "m_content", 257, 8427, 8494);
            CallChecker.varInit(this.m_bundle, "m_bundle", 257, 8427, 8494);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 257, 8427, 8494);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 257, 8427, 8494);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 257, 8427, 8494);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 257, 8427, 8494);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 257, 8427, 8494);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 257, 8427, 8494);
            CallChecker.varInit(this.m_version, "m_version", 257, 8427, 8494);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 257, 8427, 8494);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 257, 8427, 8494);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 257, 8427, 8494);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 257, 8427, 8494);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 257, 8427, 8494);
            CallChecker.varInit(this.m_id, "m_id", 257, 8427, 8494);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 257, 8427, 8494);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 257, 8427, 8494);
            return m_wiring;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleWiring) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public Bundle getBundle() {
        MethodContext _bcornu_methode_context14 = new MethodContext(Bundle.class, 262, 8501, 8562);
        try {
            CallChecker.varInit(this, "this", 262, 8501, 8562);
            CallChecker.varInit(this.m_wiring, "m_wiring", 262, 8501, 8562);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 262, 8501, 8562);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 262, 8501, 8562);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 262, 8501, 8562);
            CallChecker.varInit(this.m_content, "m_content", 262, 8501, 8562);
            CallChecker.varInit(this.m_bundle, "m_bundle", 262, 8501, 8562);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 262, 8501, 8562);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 262, 8501, 8562);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 262, 8501, 8562);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 262, 8501, 8562);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 262, 8501, 8562);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 262, 8501, 8562);
            CallChecker.varInit(this.m_version, "m_version", 262, 8501, 8562);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 262, 8501, 8562);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 262, 8501, 8562);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 262, 8501, 8562);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 262, 8501, 8562);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 262, 8501, 8562);
            CallChecker.varInit(this.m_id, "m_id", 262, 8501, 8562);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 262, 8501, 8562);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 262, 8501, 8562);
            return m_bundle;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public Map getHeaders() {
        MethodContext _bcornu_methode_context15 = new MethodContext(Map.class, 271, 8569, 8677);
        try {
            CallChecker.varInit(this, "this", 271, 8569, 8677);
            CallChecker.varInit(this.m_wiring, "m_wiring", 271, 8569, 8677);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 271, 8569, 8677);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 271, 8569, 8677);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 271, 8569, 8677);
            CallChecker.varInit(this.m_content, "m_content", 271, 8569, 8677);
            CallChecker.varInit(this.m_bundle, "m_bundle", 271, 8569, 8677);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 271, 8569, 8677);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 271, 8569, 8677);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 271, 8569, 8677);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 271, 8569, 8677);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 271, 8569, 8677);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 271, 8569, 8677);
            CallChecker.varInit(this.m_version, "m_version", 271, 8569, 8677);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 271, 8569, 8677);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 271, 8569, 8677);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 271, 8569, 8677);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 271, 8569, 8677);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 271, 8569, 8677);
            CallChecker.varInit(this.m_id, "m_id", 271, 8569, 8677);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 271, 8569, 8677);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 271, 8569, 8677);
            return m_headerMap;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public boolean isExtension() {
        MethodContext _bcornu_methode_context16 = new MethodContext(boolean.class, 276, 8684, 8753);
        try {
            CallChecker.varInit(this, "this", 276, 8684, 8753);
            CallChecker.varInit(this.m_wiring, "m_wiring", 276, 8684, 8753);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 276, 8684, 8753);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 276, 8684, 8753);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 276, 8684, 8753);
            CallChecker.varInit(this.m_content, "m_content", 276, 8684, 8753);
            CallChecker.varInit(this.m_bundle, "m_bundle", 276, 8684, 8753);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 276, 8684, 8753);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 276, 8684, 8753);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 276, 8684, 8753);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 276, 8684, 8753);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 276, 8684, 8753);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 276, 8684, 8753);
            CallChecker.varInit(this.m_version, "m_version", 276, 8684, 8753);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 276, 8684, 8753);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 276, 8684, 8753);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 276, 8684, 8753);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 276, 8684, 8753);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 276, 8684, 8753);
            CallChecker.varInit(this.m_id, "m_id", 276, 8684, 8753);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 276, 8684, 8753);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 276, 8684, 8753);
            return m_isExtension;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public String getManifestVersion() {
        MethodContext _bcornu_methode_context17 = new MethodContext(String.class, 281, 8760, 8839);
        try {
            CallChecker.varInit(this, "this", 281, 8760, 8839);
            CallChecker.varInit(this.m_wiring, "m_wiring", 281, 8760, 8839);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 281, 8760, 8839);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 281, 8760, 8839);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 281, 8760, 8839);
            CallChecker.varInit(this.m_content, "m_content", 281, 8760, 8839);
            CallChecker.varInit(this.m_bundle, "m_bundle", 281, 8760, 8839);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 281, 8760, 8839);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 281, 8760, 8839);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 281, 8760, 8839);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 281, 8760, 8839);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 281, 8760, 8839);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 281, 8760, 8839);
            CallChecker.varInit(this.m_version, "m_version", 281, 8760, 8839);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 281, 8760, 8839);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 281, 8760, 8839);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 281, 8760, 8839);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 281, 8760, 8839);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 281, 8760, 8839);
            CallChecker.varInit(this.m_id, "m_id", 281, 8760, 8839);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 281, 8760, 8839);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 281, 8760, 8839);
            return m_manifestVersion;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public List<NativeLibrary> getDeclaredNativeLibraries() {
        MethodContext _bcornu_methode_context18 = new MethodContext(List.class, 286, 8846, 8949);
        try {
            CallChecker.varInit(this, "this", 286, 8846, 8949);
            CallChecker.varInit(this.m_wiring, "m_wiring", 286, 8846, 8949);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 286, 8846, 8949);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 286, 8846, 8949);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 286, 8846, 8949);
            CallChecker.varInit(this.m_content, "m_content", 286, 8846, 8949);
            CallChecker.varInit(this.m_bundle, "m_bundle", 286, 8846, 8949);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 286, 8846, 8949);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 286, 8846, 8949);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 286, 8846, 8949);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 286, 8846, 8949);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 286, 8846, 8949);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 286, 8846, 8949);
            CallChecker.varInit(this.m_version, "m_version", 286, 8846, 8949);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 286, 8846, 8949);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 286, 8846, 8949);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 286, 8846, 8949);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 286, 8846, 8949);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 286, 8846, 8949);
            CallChecker.varInit(this.m_id, "m_id", 286, 8846, 8949);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 286, 8846, 8949);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 286, 8846, 8949);
            return m_declaredNativeLibs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<NativeLibrary>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public String getId() {
        MethodContext _bcornu_methode_context19 = new MethodContext(String.class, 291, 8956, 9009);
        try {
            CallChecker.varInit(this, "this", 291, 8956, 9009);
            CallChecker.varInit(this.m_wiring, "m_wiring", 291, 8956, 9009);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 291, 8956, 9009);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 291, 8956, 9009);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 291, 8956, 9009);
            CallChecker.varInit(this.m_content, "m_content", 291, 8956, 9009);
            CallChecker.varInit(this.m_bundle, "m_bundle", 291, 8956, 9009);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 291, 8956, 9009);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 291, 8956, 9009);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 291, 8956, 9009);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 291, 8956, 9009);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 291, 8956, 9009);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 291, 8956, 9009);
            CallChecker.varInit(this.m_version, "m_version", 291, 8956, 9009);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 291, 8956, 9009);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 291, 8956, 9009);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 291, 8956, 9009);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 291, 8956, 9009);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 291, 8956, 9009);
            CallChecker.varInit(this.m_id, "m_id", 291, 8956, 9009);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 291, 8956, 9009);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 291, 8956, 9009);
            return m_id;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public synchronized void resolve(BundleWiringImpl wiring) {
        MethodContext _bcornu_methode_context20 = new MethodContext(void.class, 296, 9016, 9919);
        try {
            CallChecker.varInit(this, "this", 296, 9016, 9919);
            CallChecker.varInit(wiring, "wiring", 296, 9016, 9919);
            CallChecker.varInit(this.m_wiring, "m_wiring", 296, 9016, 9919);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 296, 9016, 9919);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 296, 9016, 9919);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 296, 9016, 9919);
            CallChecker.varInit(this.m_content, "m_content", 296, 9016, 9919);
            CallChecker.varInit(this.m_bundle, "m_bundle", 296, 9016, 9919);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 296, 9016, 9919);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 296, 9016, 9919);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 296, 9016, 9919);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 296, 9016, 9919);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 296, 9016, 9919);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 296, 9016, 9919);
            CallChecker.varInit(this.m_version, "m_version", 296, 9016, 9919);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 296, 9016, 9919);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 296, 9016, 9919);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 296, 9016, 9919);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 296, 9016, 9919);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 296, 9016, 9919);
            CallChecker.varInit(this.m_id, "m_id", 296, 9016, 9919);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 296, 9016, 9919);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 296, 9016, 9919);
            if ((m_wiring) != null) {
                m_wiring.dispose();
                m_wiring = null;
                CallChecker.varAssign(this.m_wiring, "this.m_wiring", 301, 9164, 9179);
            }
            if (wiring != null) {
                if (CallChecker.beforeDeref(Util.getFragments(wiring), List.class, 308, 9397, 9421)) {
                    if (!(CallChecker.isCalled(Util.getFragments(wiring), List.class, 308, 9397, 9421).isEmpty())) {
                        m_contentPath = CallChecker.beforeCalled(m_contentPath, List.class, 310, 9512, 9524);
                        for (int i = 0; ((m_contentPath) != null) && (i < (CallChecker.isCalled(m_contentPath, List.class, 310, 9512, 9524).size())); i++) {
                            if ((m_content) != (m_contentPath.get(i))) {
                                m_contentPath = CallChecker.beforeCalled(m_contentPath, List.class, 315, 9751, 9763);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(m_contentPath, List.class, 315, 9751, 9763).get(i), Content.class, 315, 9751, 9770)) {
                                    CallChecker.isCalled(m_contentPath.get(i), Content.class, 315, 9751, 9770).close();
                                }
                            }
                        }
                        m_contentPath = null;
                        CallChecker.varAssign(this.m_contentPath, "this.m_contentPath", 318, 9837, 9857);
                    }
                }
                m_wiring = wiring;
                CallChecker.varAssign(this.m_wiring, "this.m_wiring", 321, 9886, 9903);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public synchronized void setProtectionDomain(ProtectionDomain pd) {
        MethodContext _bcornu_methode_context21 = new MethodContext(void.class, 325, 9926, 10035);
        try {
            CallChecker.varInit(this, "this", 325, 9926, 10035);
            CallChecker.varInit(pd, "pd", 325, 9926, 10035);
            CallChecker.varInit(this.m_wiring, "m_wiring", 325, 9926, 10035);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 325, 9926, 10035);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 325, 9926, 10035);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 325, 9926, 10035);
            CallChecker.varInit(this.m_content, "m_content", 325, 9926, 10035);
            CallChecker.varInit(this.m_bundle, "m_bundle", 325, 9926, 10035);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 325, 9926, 10035);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 325, 9926, 10035);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 325, 9926, 10035);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 325, 9926, 10035);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 325, 9926, 10035);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 325, 9926, 10035);
            CallChecker.varInit(this.m_version, "m_version", 325, 9926, 10035);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 325, 9926, 10035);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 325, 9926, 10035);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 325, 9926, 10035);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 325, 9926, 10035);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 325, 9926, 10035);
            CallChecker.varInit(this.m_id, "m_id", 325, 9926, 10035);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 325, 9926, 10035);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 325, 9926, 10035);
            m_protectionDomain = pd;
            CallChecker.varAssign(this.m_protectionDomain, "this.m_protectionDomain", 327, 10006, 10029);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public synchronized ProtectionDomain getProtectionDomain() {
        MethodContext _bcornu_methode_context22 = new MethodContext(ProtectionDomain.class, 330, 10042, 10146);
        try {
            CallChecker.varInit(this, "this", 330, 10042, 10146);
            CallChecker.varInit(this.m_wiring, "m_wiring", 330, 10042, 10146);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 330, 10042, 10146);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 330, 10042, 10146);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 330, 10042, 10146);
            CallChecker.varInit(this.m_content, "m_content", 330, 10042, 10146);
            CallChecker.varInit(this.m_bundle, "m_bundle", 330, 10042, 10146);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 330, 10042, 10146);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 330, 10042, 10146);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 330, 10042, 10146);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 330, 10042, 10146);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 330, 10042, 10146);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 330, 10042, 10146);
            CallChecker.varInit(this.m_version, "m_version", 330, 10042, 10146);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 330, 10042, 10146);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 330, 10042, 10146);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 330, 10042, 10146);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 330, 10042, 10146);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 330, 10042, 10146);
            CallChecker.varInit(this.m_id, "m_id", 330, 10042, 10146);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 330, 10042, 10146);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 330, 10042, 10146);
            return m_protectionDomain;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ProtectionDomain) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public synchronized Content getContent() {
        MethodContext _bcornu_methode_context23 = new MethodContext(Content.class, 339, 10153, 10276);
        try {
            CallChecker.varInit(this, "this", 339, 10153, 10276);
            CallChecker.varInit(this.m_wiring, "m_wiring", 339, 10153, 10276);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 339, 10153, 10276);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 339, 10153, 10276);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 339, 10153, 10276);
            CallChecker.varInit(this.m_content, "m_content", 339, 10153, 10276);
            CallChecker.varInit(this.m_bundle, "m_bundle", 339, 10153, 10276);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 339, 10153, 10276);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 339, 10153, 10276);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 339, 10153, 10276);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 339, 10153, 10276);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 339, 10153, 10276);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 339, 10153, 10276);
            CallChecker.varInit(this.m_version, "m_version", 339, 10153, 10276);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 339, 10153, 10276);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 339, 10153, 10276);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 339, 10153, 10276);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 339, 10153, 10276);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 339, 10153, 10276);
            CallChecker.varInit(this.m_id, "m_id", 339, 10153, 10276);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 339, 10153, 10276);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 339, 10153, 10276);
            return m_content;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    synchronized void resetContent(Content content) {
        MethodContext _bcornu_methode_context24 = new MethodContext(void.class, 344, 10283, 10370);
        try {
            CallChecker.varInit(this, "this", 344, 10283, 10370);
            CallChecker.varInit(content, "content", 344, 10283, 10370);
            CallChecker.varInit(this.m_wiring, "m_wiring", 344, 10283, 10370);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 344, 10283, 10370);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 344, 10283, 10370);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 344, 10283, 10370);
            CallChecker.varInit(this.m_content, "m_content", 344, 10283, 10370);
            CallChecker.varInit(this.m_bundle, "m_bundle", 344, 10283, 10370);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 344, 10283, 10370);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 344, 10283, 10370);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 344, 10283, 10370);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 344, 10283, 10370);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 344, 10283, 10370);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 344, 10283, 10370);
            CallChecker.varInit(this.m_version, "m_version", 344, 10283, 10370);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 344, 10283, 10370);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 344, 10283, 10370);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 344, 10283, 10370);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 344, 10283, 10370);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 344, 10283, 10370);
            CallChecker.varInit(this.m_id, "m_id", 344, 10283, 10370);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 344, 10283, 10370);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 344, 10283, 10370);
            m_content = content;
            CallChecker.varAssign(this.m_content, "this.m_content", 346, 10345, 10364);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    synchronized List<Content> getContentPath() {
        MethodContext _bcornu_methode_context25 = new MethodContext(List.class, 349, 10377, 10839);
        try {
            CallChecker.varInit(this, "this", 349, 10377, 10839);
            CallChecker.varInit(this.m_wiring, "m_wiring", 349, 10377, 10839);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 349, 10377, 10839);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 349, 10377, 10839);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 349, 10377, 10839);
            CallChecker.varInit(this.m_content, "m_content", 349, 10377, 10839);
            CallChecker.varInit(this.m_bundle, "m_bundle", 349, 10377, 10839);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 349, 10377, 10839);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 349, 10377, 10839);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 349, 10377, 10839);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 349, 10377, 10839);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 349, 10377, 10839);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 349, 10377, 10839);
            CallChecker.varInit(this.m_version, "m_version", 349, 10377, 10839);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 349, 10377, 10839);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 349, 10377, 10839);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 349, 10377, 10839);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 349, 10377, 10839);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 349, 10377, 10839);
            CallChecker.varInit(this.m_id, "m_id", 349, 10377, 10839);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 349, 10377, 10839);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 349, 10377, 10839);
            if ((m_contentPath) == null) {
                TryContext _bcornu_try_context_1 = new TryContext(1, BundleRevisionImpl.class, "java.lang.Exception");
                try {
                    m_contentPath = initializeContentPath();
                    CallChecker.varAssign(this.m_contentPath, "this.m_contentPath", 355, 10518, 10557);
                } catch (Exception ex) {
                    _bcornu_try_context_1.catchStart(1);
                    if (CallChecker.beforeDeref(m_bundle, Bundle.class, 359, 10650, 10657)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 359, 10650, 10657).getFramework(), Felix.class, 359, 10636, 10673)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 359, 10650, 10657).getFramework(), Felix.class, 359, 10636, 10673).getLogger(), Logger.class, 359, 10636, 10685)) {
                                CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 359, 10650, 10657).getFramework(), Felix.class, 359, 10636, 10673).getLogger(), Logger.class, 359, 10636, 10685).log(m_bundle, Logger.LOG_ERROR, "Unable to get module class path.", ex);
                            }
                        }
                    }
                } finally {
                    _bcornu_try_context_1.finallyStart(1);
                }
            }
            return m_contentPath;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Content>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    private List<Content> initializeContentPath() throws Exception {
        MethodContext _bcornu_methode_context26 = new MethodContext(List.class, 366, 10846, 11852);
        try {
            CallChecker.varInit(this, "this", 366, 10846, 11852);
            CallChecker.varInit(this.m_wiring, "m_wiring", 366, 10846, 11852);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 366, 10846, 11852);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 366, 10846, 11852);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 366, 10846, 11852);
            CallChecker.varInit(this.m_content, "m_content", 366, 10846, 11852);
            CallChecker.varInit(this.m_bundle, "m_bundle", 366, 10846, 11852);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 366, 10846, 11852);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 366, 10846, 11852);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 366, 10846, 11852);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 366, 10846, 11852);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 366, 10846, 11852);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 366, 10846, 11852);
            CallChecker.varInit(this.m_version, "m_version", 366, 10846, 11852);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 366, 10846, 11852);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 366, 10846, 11852);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 366, 10846, 11852);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 366, 10846, 11852);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 366, 10846, 11852);
            CallChecker.varInit(this.m_id, "m_id", 366, 10846, 11852);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 366, 10846, 11852);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 366, 10846, 11852);
            List<Content> contentList = CallChecker.varInit(new ArrayList(), "contentList", 368, 10923, 10966);
            calculateContentPath(this, getContent(), contentList, true);
            List<BundleRevision> fragments = CallChecker.varInit(null, "fragments", 371, 11046, 11083);
            List<Content> fragmentContents = CallChecker.varInit(null, "fragmentContents", 372, 11093, 11130);
            if ((m_wiring) != null) {
                fragments = m_wiring.getFragments();
                CallChecker.varAssign(fragments, "fragments", 379, 11454, 11489);
                fragmentContents = m_wiring.getFragmentContents();
                CallChecker.varAssign(fragmentContents, "fragmentContents", 380, 11503, 11552);
            }
            if (fragments != null) {
                for (int i = 0; i < (fragments.size()); i++) {
                    if (CallChecker.beforeDeref(fragmentContents, List.class, 387, 11750, 11765)) {
                        fragmentContents = CallChecker.beforeCalled(fragmentContents, List.class, 387, 11750, 11765);
                        calculateContentPath(fragments.get(i), CallChecker.isCalled(fragmentContents, List.class, 387, 11750, 11765).get(i), contentList, false);
                    }
                }
            }
            return contentList;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Content>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    private List calculateContentPath(BundleRevision revision, Content content, List<Content> contentList, boolean searchFragments) throws Exception {
        MethodContext _bcornu_methode_context27 = new MethodContext(List.class, 393, 11859, 15604);
        try {
            CallChecker.varInit(this, "this", 393, 11859, 15604);
            CallChecker.varInit(searchFragments, "searchFragments", 393, 11859, 15604);
            CallChecker.varInit(contentList, "contentList", 393, 11859, 15604);
            CallChecker.varInit(content, "content", 393, 11859, 15604);
            CallChecker.varInit(revision, "revision", 393, 11859, 15604);
            CallChecker.varInit(this.m_wiring, "m_wiring", 393, 11859, 15604);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 393, 11859, 15604);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 393, 11859, 15604);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 393, 11859, 15604);
            CallChecker.varInit(this.m_content, "m_content", 393, 11859, 15604);
            CallChecker.varInit(this.m_bundle, "m_bundle", 393, 11859, 15604);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 393, 11859, 15604);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 393, 11859, 15604);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 393, 11859, 15604);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 393, 11859, 15604);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 393, 11859, 15604);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 393, 11859, 15604);
            CallChecker.varInit(this.m_version, "m_version", 393, 11859, 15604);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 393, 11859, 15604);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 393, 11859, 15604);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 393, 11859, 15604);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 393, 11859, 15604);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 393, 11859, 15604);
            CallChecker.varInit(this.m_id, "m_id", 393, 11859, 15604);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 393, 11859, 15604);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 393, 11859, 15604);
            List localContentList = CallChecker.varInit(new ArrayList(), "localContentList", 404, 12382, 12421);
            String classPath = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 407, 12520, 12527)) {
                revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 407, 12520, 12527);
                final Map npe_invocation_var1 = CallChecker.isCalled(((BundleRevisionImpl) (revision)), BundleRevisionImpl.class, 407, 12520, 12527).getHeaders();
                if (CallChecker.beforeDeref(npe_invocation_var1, Map.class, 407, 12498, 12554)) {
                    classPath = ((String) (CallChecker.isCalled(npe_invocation_var1, Map.class, 407, 12498, 12554).get(FelixConstants.BUNDLE_CLASSPATH)));
                    CallChecker.varAssign(classPath, "classPath", 407, 12520, 12527);
                }
            }
            List<String> classPathStrings = CallChecker.varInit(ManifestParser.parseDelimitedString(classPath, FelixConstants.CLASS_PATH_SEPARATOR), "classPathStrings", 410, 12648, 12776);
            if (classPathStrings == null) {
                classPathStrings = new ArrayList<String>(0);
                CallChecker.varAssign(classPathStrings, "classPathStrings", 415, 12839, 12882);
            }
            classPathStrings = CallChecker.beforeCalled(classPathStrings, List.class, 419, 12965, 12980);
            for (int i = 0; i < (CallChecker.isCalled(classPathStrings, List.class, 419, 12965, 12980).size()); i++) {
                if (CallChecker.beforeDeref(classPathStrings, List.class, 423, 13174, 13189)) {
                    classPathStrings = CallChecker.beforeCalled(classPathStrings, List.class, 423, 13174, 13189);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(classPathStrings, List.class, 423, 13174, 13189).get(i), String.class, 423, 13174, 13196)) {
                        classPathStrings = CallChecker.beforeCalled(classPathStrings, List.class, 423, 13174, 13189);
                        if (CallChecker.isCalled(CallChecker.isCalled(classPathStrings, List.class, 423, 13174, 13189).get(i), String.class, 423, 13174, 13196).startsWith("/")) {
                            if (CallChecker.beforeDeref(classPathStrings, List.class, 423, 13149, 13164)) {
                                classPathStrings = CallChecker.beforeCalled(classPathStrings, List.class, 423, 13149, 13164);
                                CallChecker.isCalled(classPathStrings, List.class, 423, 13149, 13164).set(i, CallChecker.isCalled(CallChecker.isCalled(classPathStrings, List.class, 424, 13233, 13248).get(i), String.class, 424, 13233, 13255).substring(1));
                            }
                        }else {
                            if (CallChecker.beforeDeref(classPathStrings, List.class, 423, 13149, 13164)) {
                                classPathStrings = CallChecker.beforeCalled(classPathStrings, List.class, 423, 13149, 13164);
                                CallChecker.isCalled(classPathStrings, List.class, 423, 13149, 13164).set(i, CallChecker.isCalled(classPathStrings, List.class, 425, 13288, 13303).get(i));
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(classPathStrings, List.class, 428, 13393, 13408)) {
                    classPathStrings = CallChecker.beforeCalled(classPathStrings, List.class, 428, 13393, 13408);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(classPathStrings, List.class, 428, 13393, 13408).get(i), String.class, 428, 13393, 13415)) {
                        classPathStrings = CallChecker.beforeCalled(classPathStrings, List.class, 428, 13393, 13408);
                        if (CallChecker.isCalled(CallChecker.isCalled(classPathStrings, List.class, 428, 13393, 13408).get(i), String.class, 428, 13393, 13415).equals(FelixConstants.CLASS_PATH_DOT)) {
                            if (CallChecker.beforeDeref(localContentList, List.class, 430, 13486, 13501)) {
                                localContentList = CallChecker.beforeCalled(localContentList, List.class, 430, 13486, 13501);
                                CallChecker.isCalled(localContentList, List.class, 430, 13486, 13501).add(content);
                            }
                        }else {
                            Content embeddedContent = CallChecker.init(Content.class);
                            if (CallChecker.beforeDeref(classPathStrings, List.class, 436, 13734, 13749)) {
                                if (CallChecker.beforeDeref(content, Content.class, 436, 13708, 13714)) {
                                    classPathStrings = CallChecker.beforeCalled(classPathStrings, List.class, 436, 13734, 13749);
                                    content = CallChecker.beforeCalled(content, Content.class, 436, 13708, 13714);
                                    embeddedContent = CallChecker.isCalled(content, Content.class, 436, 13708, 13714).getEntryAsContent(CallChecker.isCalled(classPathStrings, List.class, 436, 13734, 13749).get(i));
                                    CallChecker.varAssign(embeddedContent, "embeddedContent", 436, 13734, 13749);
                                }
                            }
                            List<Content> fragmentContents = CallChecker.init(List.class);
                            if ((m_wiring) == null) {
                                fragmentContents = null;
                                CallChecker.varAssign(fragmentContents, "fragmentContents", 440, 14033, 14110);
                            }else {
                                fragmentContents = m_wiring.getFragmentContents();
                                CallChecker.varAssign(fragmentContents, "fragmentContents", 440, 14033, 14110);
                            }
                            fragmentContents = CallChecker.beforeCalled(fragmentContents, List.class, 444, 14284, 14299);
                            for (int fragIdx = 0; ((searchFragments && (embeddedContent == null)) && (fragmentContents != null)) && (fragIdx < (CallChecker.isCalled(fragmentContents, List.class, 444, 14284, 14299).size())); fragIdx++) {
                                if (CallChecker.beforeDeref(classPathStrings, List.class, 448, 14469, 14484)) {
                                    fragmentContents = CallChecker.beforeCalled(fragmentContents, List.class, 448, 14421, 14436);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(fragmentContents, List.class, 448, 14421, 14436).get(fragIdx), Content.class, 448, 14421, 14449)) {
                                        classPathStrings = CallChecker.beforeCalled(classPathStrings, List.class, 448, 14469, 14484);
                                        embeddedContent = CallChecker.isCalled(fragmentContents.get(fragIdx), Content.class, 448, 14421, 14449).getEntryAsContent(CallChecker.isCalled(classPathStrings, List.class, 448, 14469, 14484).get(i));
                                        CallChecker.varAssign(embeddedContent, "embeddedContent", 447, 14379, 14493);
                                    }
                                }
                            }
                            if (embeddedContent != null) {
                                if (CallChecker.beforeDeref(localContentList, List.class, 454, 14712, 14727)) {
                                    localContentList = CallChecker.beforeCalled(localContentList, List.class, 454, 14712, 14727);
                                    CallChecker.isCalled(localContentList, List.class, 454, 14712, 14727).add(embeddedContent);
                                }
                            }else {
                                if (CallChecker.beforeDeref(m_bundle, Bundle.class, 460, 14989, 14996)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 460, 14989, 14996).getFramework(), Felix.class, 460, 14975, 15012)) {
                                        if (CallChecker.beforeDeref(classPathStrings, List.class, 463, 15166, 15181)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 460, 14989, 14996).getFramework(), Felix.class, 460, 14975, 15012).getLogger(), Logger.class, 460, 14975, 15024)) {
                                                classPathStrings = CallChecker.beforeCalled(classPathStrings, List.class, 463, 15166, 15181);
                                                CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 460, 14989, 14996).getFramework(), Felix.class, 460, 14975, 15012).getLogger(), Logger.class, 460, 14975, 15024).log(getBundle(), Logger.LOG_INFO, ("Class path entry not found: " + (CallChecker.isCalled(classPathStrings, List.class, 463, 15166, 15181).get(i))));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(localContentList, List.class, 470, 15354, 15369)) {
                localContentList = CallChecker.beforeCalled(localContentList, List.class, 470, 15354, 15369);
                if (CallChecker.isCalled(localContentList, List.class, 470, 15354, 15369).isEmpty()) {
                    if (CallChecker.beforeDeref(localContentList, List.class, 472, 15404, 15419)) {
                        localContentList = CallChecker.beforeCalled(localContentList, List.class, 472, 15404, 15419);
                        CallChecker.isCalled(localContentList, List.class, 472, 15404, 15419).add(content);
                    }
                }
            }
            if (CallChecker.beforeDeref(contentList, List.class, 476, 15534, 15544)) {
                contentList = CallChecker.beforeCalled(contentList, List.class, 476, 15534, 15544);
                CallChecker.isCalled(contentList, List.class, 476, 15534, 15544).addAll(localContentList);
            }
            return contentList;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    URL getResourceLocal(String name) {
        MethodContext _bcornu_methode_context28 = new MethodContext(URL.class, 480, 15611, 16483);
        try {
            CallChecker.varInit(this, "this", 480, 15611, 16483);
            CallChecker.varInit(name, "name", 480, 15611, 16483);
            CallChecker.varInit(this.m_wiring, "m_wiring", 480, 15611, 16483);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 480, 15611, 16483);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 480, 15611, 16483);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 480, 15611, 16483);
            CallChecker.varInit(this.m_content, "m_content", 480, 15611, 16483);
            CallChecker.varInit(this.m_bundle, "m_bundle", 480, 15611, 16483);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 480, 15611, 16483);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 480, 15611, 16483);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 480, 15611, 16483);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 480, 15611, 16483);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 480, 15611, 16483);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 480, 15611, 16483);
            CallChecker.varInit(this.m_version, "m_version", 480, 15611, 16483);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 480, 15611, 16483);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 480, 15611, 16483);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 480, 15611, 16483);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 480, 15611, 16483);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 480, 15611, 16483);
            CallChecker.varInit(this.m_id, "m_id", 480, 15611, 16483);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 480, 15611, 16483);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 480, 15611, 16483);
            URL url = CallChecker.varInit(null, "url", 482, 15659, 15673);
            if (CallChecker.beforeDeref(name, String.class, 487, 15873, 15876)) {
                name = CallChecker.beforeCalled(name, String.class, 487, 15873, 15876);
                if (CallChecker.isCalled(name, String.class, 487, 15873, 15876).equals("/")) {
                    url = createURL(1, name);
                    CallChecker.varAssign(url, "url", 490, 15989, 16013);
                }else
                    if (CallChecker.beforeDeref(name, String.class, 492, 16042, 16045)) {
                        name = CallChecker.beforeCalled(name, String.class, 492, 16042, 16045);
                        if (CallChecker.isCalled(name, String.class, 492, 16042, 16045).startsWith("/")) {
                            if (CallChecker.beforeDeref(name, String.class, 494, 16093, 16096)) {
                                name = CallChecker.beforeCalled(name, String.class, 494, 16093, 16096);
                                name = CallChecker.isCalled(name, String.class, 494, 16093, 16096).substring(1);
                                CallChecker.varAssign(name, "name", 494, 16086, 16110);
                            }
                        }
                    }
                
            }
            List<Content> contentPath = CallChecker.varInit(getContentPath(), "contentPath", 498, 16171, 16215);
            contentPath = CallChecker.beforeCalled(contentPath, List.class, 501, 16287, 16297);
            for (int i = 0; (url == null) && (i < (CallChecker.isCalled(contentPath, List.class, 501, 16287, 16297).size())); i++) {
                if (CallChecker.beforeDeref(contentPath, List.class, 503, 16339, 16349)) {
                    contentPath = CallChecker.beforeCalled(contentPath, List.class, 503, 16339, 16349);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(contentPath, List.class, 503, 16339, 16349).get(i), Content.class, 503, 16339, 16356)) {
                        contentPath = CallChecker.beforeCalled(contentPath, List.class, 503, 16339, 16349);
                        if (CallChecker.isCalled(CallChecker.isCalled(contentPath, List.class, 503, 16339, 16349).get(i), Content.class, 503, 16339, 16356).hasEntry(name)) {
                            url = createURL((i + 1), name);
                            CallChecker.varAssign(url, "url", 505, 16404, 16432);
                        }
                    }
                }
            }
            return url;
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    Enumeration getResourcesLocal(String name) {
        MethodContext _bcornu_methode_context29 = new MethodContext(Enumeration.class, 512, 16490, 17772);
        try {
            CallChecker.varInit(this, "this", 512, 16490, 17772);
            CallChecker.varInit(name, "name", 512, 16490, 17772);
            CallChecker.varInit(this.m_wiring, "m_wiring", 512, 16490, 17772);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 512, 16490, 17772);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 512, 16490, 17772);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 512, 16490, 17772);
            CallChecker.varInit(this.m_content, "m_content", 512, 16490, 17772);
            CallChecker.varInit(this.m_bundle, "m_bundle", 512, 16490, 17772);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 512, 16490, 17772);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 512, 16490, 17772);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 512, 16490, 17772);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 512, 16490, 17772);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 512, 16490, 17772);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 512, 16490, 17772);
            CallChecker.varInit(this.m_version, "m_version", 512, 16490, 17772);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 512, 16490, 17772);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 512, 16490, 17772);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 512, 16490, 17772);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 512, 16490, 17772);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 512, 16490, 17772);
            CallChecker.varInit(this.m_id, "m_id", 512, 16490, 17772);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 512, 16490, 17772);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 512, 16490, 17772);
            List l = CallChecker.varInit(new ArrayList(), "l", 514, 16547, 16571);
            final List<Content> contentPath = CallChecker.varInit(getContentPath(), "contentPath", 519, 16582, 16814);
            if (CallChecker.beforeDeref(name, String.class, 521, 16829, 16832)) {
                name = CallChecker.beforeCalled(name, String.class, 521, 16829, 16832);
                if (CallChecker.isCalled(name, String.class, 521, 16829, 16832).equals("/")) {
                    for (int i = 0; i < (CallChecker.isCalled(contentPath, List.class, 523, 16889, 16899).size()); i++) {
                        if (CallChecker.beforeDeref(l, List.class, 525, 16944, 16944)) {
                            l = CallChecker.beforeCalled(l, List.class, 525, 16944, 16944);
                            CallChecker.isCalled(l, List.class, 525, 16944, 16944).add(createURL((i + 1), name));
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(name, String.class, 531, 17087, 17090)) {
                        name = CallChecker.beforeCalled(name, String.class, 531, 17087, 17090);
                        if (CallChecker.isCalled(name, String.class, 531, 17087, 17090).startsWith("/")) {
                            if (CallChecker.beforeDeref(name, String.class, 533, 17146, 17149)) {
                                name = CallChecker.beforeCalled(name, String.class, 533, 17146, 17149);
                                name = CallChecker.isCalled(name, String.class, 533, 17146, 17149).substring(1);
                                CallChecker.varAssign(name, "name", 533, 17139, 17163);
                            }
                        }
                    }
                    for (int i = 0; i < (CallChecker.isCalled(contentPath, List.class, 537, 17256, 17266).size()); i++) {
                        if (CallChecker.beforeDeref(contentPath, List.class, 539, 17315, 17325)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(contentPath, List.class, 539, 17315, 17325).get(i), Content.class, 539, 17315, 17332)) {
                                if (CallChecker.isCalled(CallChecker.isCalled(contentPath, List.class, 539, 17315, 17325).get(i), Content.class, 539, 17315, 17332).hasEntry(name)) {
                                    if (CallChecker.beforeDeref(l, List.class, 545, 17651, 17651)) {
                                        l = CallChecker.beforeCalled(l, List.class, 545, 17651, 17651);
                                        CallChecker.isCalled(l, List.class, 545, 17651, 17651).add(createURL((i + 1), name));
                                    }
                                }
                            }
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return Collections.enumeration(l);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public URL getEntry(String name) {
        MethodContext _bcornu_methode_context30 = new MethodContext(URL.class, 555, 17779, 18745);
        try {
            CallChecker.varInit(this, "this", 555, 17779, 18745);
            CallChecker.varInit(name, "name", 555, 17779, 18745);
            CallChecker.varInit(this.m_wiring, "m_wiring", 555, 17779, 18745);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 555, 17779, 18745);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 555, 17779, 18745);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 555, 17779, 18745);
            CallChecker.varInit(this.m_content, "m_content", 555, 17779, 18745);
            CallChecker.varInit(this.m_bundle, "m_bundle", 555, 17779, 18745);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 555, 17779, 18745);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 555, 17779, 18745);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 555, 17779, 18745);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 555, 17779, 18745);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 555, 17779, 18745);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 555, 17779, 18745);
            CallChecker.varInit(this.m_version, "m_version", 555, 17779, 18745);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 555, 17779, 18745);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 555, 17779, 18745);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 555, 17779, 18745);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 555, 17779, 18745);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 555, 17779, 18745);
            CallChecker.varInit(this.m_id, "m_id", 555, 17779, 18745);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 555, 17779, 18745);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 555, 17779, 18745);
            URL url = CallChecker.varInit(null, "url", 557, 17968, 17982);
            if (CallChecker.beforeDeref(name, String.class, 561, 18117, 18120)) {
                name = CallChecker.beforeCalled(name, String.class, 561, 18117, 18120);
                if (CallChecker.isCalled(name, String.class, 561, 18117, 18120).equals("/")) {
                    url = createURL(0, "/");
                    CallChecker.varAssign(url, "url", 563, 18157, 18180);
                }
            }
            if (url == null) {
                if (CallChecker.beforeDeref(name, String.class, 569, 18293, 18296)) {
                    name = CallChecker.beforeCalled(name, String.class, 569, 18293, 18296);
                    if (CallChecker.isCalled(name, String.class, 569, 18293, 18296).startsWith("/")) {
                        if (CallChecker.beforeDeref(name, String.class, 571, 18352, 18355)) {
                            name = CallChecker.beforeCalled(name, String.class, 571, 18352, 18355);
                            name = CallChecker.isCalled(name, String.class, 571, 18352, 18355).substring(1);
                            CallChecker.varAssign(name, "name", 571, 18345, 18369);
                        }
                    }
                }
                final Content npe_invocation_var2 = getContent();
                if (CallChecker.beforeDeref(npe_invocation_var2, Content.class, 575, 18443, 18454)) {
                    if (CallChecker.isCalled(npe_invocation_var2, Content.class, 575, 18443, 18454).hasEntry(name)) {
                        url = createURL(0, name);
                        CallChecker.varAssign(url, "url", 580, 18670, 18694);
                    }
                }
            }
            return url;
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public boolean hasInputStream(int index, String urlPath) {
        MethodContext _bcornu_methode_context31 = new MethodContext(boolean.class, 587, 18752, 19081);
        try {
            CallChecker.varInit(this, "this", 587, 18752, 19081);
            CallChecker.varInit(urlPath, "urlPath", 587, 18752, 19081);
            CallChecker.varInit(index, "index", 587, 18752, 19081);
            CallChecker.varInit(this.m_wiring, "m_wiring", 587, 18752, 19081);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 587, 18752, 19081);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 587, 18752, 19081);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 587, 18752, 19081);
            CallChecker.varInit(this.m_content, "m_content", 587, 18752, 19081);
            CallChecker.varInit(this.m_bundle, "m_bundle", 587, 18752, 19081);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 587, 18752, 19081);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 587, 18752, 19081);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 587, 18752, 19081);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 587, 18752, 19081);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 587, 18752, 19081);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 587, 18752, 19081);
            CallChecker.varInit(this.m_version, "m_version", 587, 18752, 19081);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 587, 18752, 19081);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 587, 18752, 19081);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 587, 18752, 19081);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 587, 18752, 19081);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 587, 18752, 19081);
            CallChecker.varInit(this.m_id, "m_id", 587, 18752, 19081);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 587, 18752, 19081);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 587, 18752, 19081);
            if (CallChecker.beforeDeref(urlPath, String.class, 589, 18827, 18833)) {
                urlPath = CallChecker.beforeCalled(urlPath, String.class, 589, 18827, 18833);
                if (CallChecker.isCalled(urlPath, String.class, 589, 18827, 18833).startsWith("/")) {
                    if (CallChecker.beforeDeref(urlPath, String.class, 591, 18884, 18890)) {
                        urlPath = CallChecker.beforeCalled(urlPath, String.class, 591, 18884, 18890);
                        urlPath = CallChecker.isCalled(urlPath, String.class, 591, 18884, 18890).substring(1);
                        CallChecker.varAssign(urlPath, "urlPath", 591, 18874, 18904);
                    }
                }
            }
            if (index == 0) {
                final Content npe_invocation_var3 = getContent();
                if (CallChecker.beforeDeref(npe_invocation_var3, Content.class, 595, 18969, 18980)) {
                    return CallChecker.isCalled(npe_invocation_var3, Content.class, 595, 18969, 18980).hasEntry(urlPath);
                }else
                    throw new AbnormalExecutionError();
                
            }
            final List<Content> npe_invocation_var4 = getContentPath();
            if (CallChecker.beforeDeref(npe_invocation_var4, List.class, 597, 19026, 19041)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var4, List.class, 597, 19026, 19041).get((index - 1)), Content.class, 597, 19026, 19056)) {
                    return CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var4, List.class, 597, 19026, 19041).get((index - 1)), Content.class, 597, 19026, 19056).hasEntry(urlPath);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public InputStream getInputStream(int index, String urlPath) throws IOException {
        MethodContext _bcornu_methode_context32 = new MethodContext(InputStream.class, 600, 19088, 19464);
        try {
            CallChecker.varInit(this, "this", 600, 19088, 19464);
            CallChecker.varInit(urlPath, "urlPath", 600, 19088, 19464);
            CallChecker.varInit(index, "index", 600, 19088, 19464);
            CallChecker.varInit(this.m_wiring, "m_wiring", 600, 19088, 19464);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 600, 19088, 19464);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 600, 19088, 19464);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 600, 19088, 19464);
            CallChecker.varInit(this.m_content, "m_content", 600, 19088, 19464);
            CallChecker.varInit(this.m_bundle, "m_bundle", 600, 19088, 19464);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 600, 19088, 19464);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 600, 19088, 19464);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 600, 19088, 19464);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 600, 19088, 19464);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 600, 19088, 19464);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 600, 19088, 19464);
            CallChecker.varInit(this.m_version, "m_version", 600, 19088, 19464);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 600, 19088, 19464);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 600, 19088, 19464);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 600, 19088, 19464);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 600, 19088, 19464);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 600, 19088, 19464);
            CallChecker.varInit(this.m_id, "m_id", 600, 19088, 19464);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 600, 19088, 19464);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 600, 19088, 19464);
            if (CallChecker.beforeDeref(urlPath, String.class, 603, 19194, 19200)) {
                urlPath = CallChecker.beforeCalled(urlPath, String.class, 603, 19194, 19200);
                if (CallChecker.isCalled(urlPath, String.class, 603, 19194, 19200).startsWith("/")) {
                    if (CallChecker.beforeDeref(urlPath, String.class, 605, 19251, 19257)) {
                        urlPath = CallChecker.beforeCalled(urlPath, String.class, 605, 19251, 19257);
                        urlPath = CallChecker.isCalled(urlPath, String.class, 605, 19251, 19257).substring(1);
                        CallChecker.varAssign(urlPath, "urlPath", 605, 19241, 19271);
                    }
                }
            }
            if (index == 0) {
                final Content npe_invocation_var5 = getContent();
                if (CallChecker.beforeDeref(npe_invocation_var5, Content.class, 609, 19336, 19347)) {
                    return CallChecker.isCalled(npe_invocation_var5, Content.class, 609, 19336, 19347).getEntryAsStream(urlPath);
                }else
                    throw new AbnormalExecutionError();
                
            }
            final List<Content> npe_invocation_var6 = getContentPath();
            if (CallChecker.beforeDeref(npe_invocation_var6, List.class, 611, 19401, 19416)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var6, List.class, 611, 19401, 19416).get((index - 1)), Content.class, 611, 19401, 19431)) {
                    return CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var6, List.class, 611, 19401, 19416).get((index - 1)), Content.class, 611, 19401, 19431).getEntryAsStream(urlPath);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((InputStream) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public URL getLocalURL(int index, String urlPath) {
        MethodContext _bcornu_methode_context33 = new MethodContext(URL.class, 614, 19471, 19803);
        try {
            CallChecker.varInit(this, "this", 614, 19471, 19803);
            CallChecker.varInit(urlPath, "urlPath", 614, 19471, 19803);
            CallChecker.varInit(index, "index", 614, 19471, 19803);
            CallChecker.varInit(this.m_wiring, "m_wiring", 614, 19471, 19803);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 614, 19471, 19803);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 614, 19471, 19803);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 614, 19471, 19803);
            CallChecker.varInit(this.m_content, "m_content", 614, 19471, 19803);
            CallChecker.varInit(this.m_bundle, "m_bundle", 614, 19471, 19803);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 614, 19471, 19803);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 614, 19471, 19803);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 614, 19471, 19803);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 614, 19471, 19803);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 614, 19471, 19803);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 614, 19471, 19803);
            CallChecker.varInit(this.m_version, "m_version", 614, 19471, 19803);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 614, 19471, 19803);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 614, 19471, 19803);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 614, 19471, 19803);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 614, 19471, 19803);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 614, 19471, 19803);
            CallChecker.varInit(this.m_id, "m_id", 614, 19471, 19803);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 614, 19471, 19803);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 614, 19471, 19803);
            if (CallChecker.beforeDeref(urlPath, String.class, 616, 19539, 19545)) {
                urlPath = CallChecker.beforeCalled(urlPath, String.class, 616, 19539, 19545);
                if (CallChecker.isCalled(urlPath, String.class, 616, 19539, 19545).startsWith("/")) {
                    if (CallChecker.beforeDeref(urlPath, String.class, 618, 19596, 19602)) {
                        urlPath = CallChecker.beforeCalled(urlPath, String.class, 618, 19596, 19602);
                        urlPath = CallChecker.isCalled(urlPath, String.class, 618, 19596, 19602).substring(1);
                        CallChecker.varAssign(urlPath, "urlPath", 618, 19586, 19616);
                    }
                }
            }
            if (index == 0) {
                final Content npe_invocation_var7 = getContent();
                if (CallChecker.beforeDeref(npe_invocation_var7, Content.class, 622, 19681, 19692)) {
                    return CallChecker.isCalled(npe_invocation_var7, Content.class, 622, 19681, 19692).getEntryAsURL(urlPath);
                }else
                    throw new AbnormalExecutionError();
                
            }
            final List<Content> npe_invocation_var8 = getContentPath();
            if (CallChecker.beforeDeref(npe_invocation_var8, List.class, 624, 19743, 19758)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var8, List.class, 624, 19743, 19758).get((index - 1)), Content.class, 624, 19743, 19773)) {
                    return CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var8, List.class, 624, 19743, 19758).get((index - 1)), Content.class, 624, 19743, 19773).getEntryAsURL(urlPath);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    private URL createURL(int port, String path) {
        MethodContext _bcornu_methode_context34 = new MethodContext(URL.class, 627, 19810, 20655);
        try {
            CallChecker.varInit(this, "this", 627, 19810, 20655);
            CallChecker.varInit(path, "path", 627, 19810, 20655);
            CallChecker.varInit(port, "port", 627, 19810, 20655);
            CallChecker.varInit(this.m_wiring, "m_wiring", 627, 19810, 20655);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 627, 19810, 20655);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 627, 19810, 20655);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 627, 19810, 20655);
            CallChecker.varInit(this.m_content, "m_content", 627, 19810, 20655);
            CallChecker.varInit(this.m_bundle, "m_bundle", 627, 19810, 20655);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 627, 19810, 20655);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 627, 19810, 20655);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 627, 19810, 20655);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 627, 19810, 20655);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 627, 19810, 20655);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 627, 19810, 20655);
            CallChecker.varInit(this.m_version, "m_version", 627, 19810, 20655);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 627, 19810, 20655);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 627, 19810, 20655);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 627, 19810, 20655);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 627, 19810, 20655);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 627, 19810, 20655);
            CallChecker.varInit(this.m_id, "m_id", 627, 19810, 20655);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 627, 19810, 20655);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 627, 19810, 20655);
            if (CallChecker.beforeDeref(path, String.class, 632, 20026, 20029)) {
                path = CallChecker.beforeCalled(path, String.class, 632, 20026, 20029);
                if (!(CallChecker.isCalled(path, String.class, 632, 20026, 20029).startsWith("/"))) {
                    path = "/" + path;
                    CallChecker.varAssign(path, "path", 634, 20070, 20087);
                }
            }
            TryContext _bcornu_try_context_2 = new TryContext(2, BundleRevisionImpl.class, "java.net.MalformedURLException");
            try {
                final BundleImpl npe_invocation_var9 = ((BundleImpl) (getBundle()));
                if (CallChecker.beforeDeref(npe_invocation_var9, BundleImpl.class, 642, 20305, 20315)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var9, BundleImpl.class, 642, 20305, 20315).getFramework(), Felix.class, 642, 20291, 20331)) {
                        if (CallChecker.beforeDeref(BundleRevisionImpl.m_secureAction, SecureAction.class, 639, 20141, 20154)) {
                            return CallChecker.isCalled(BundleRevisionImpl.m_secureAction, SecureAction.class, 639, 20141, 20154).createURL(null, ((((((FelixConstants.BUNDLE_URL_PROTOCOL) + "://") + (m_id)) + ":") + port) + path), CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var9, BundleImpl.class, 642, 20305, 20315).getFramework(), Felix.class, 642, 20291, 20331).getBundleStreamHandler());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (MalformedURLException ex) {
                _bcornu_try_context_2.catchStart(2);
                if (CallChecker.beforeDeref(m_bundle, Bundle.class, 646, 20447, 20454)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 646, 20447, 20454).getFramework(), Felix.class, 646, 20433, 20470)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 646, 20447, 20454).getFramework(), Felix.class, 646, 20433, 20470).getLogger(), Logger.class, 646, 20433, 20482)) {
                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 646, 20447, 20454).getFramework(), Felix.class, 646, 20433, 20470).getLogger(), Logger.class, 646, 20433, 20482).log(m_bundle, Logger.LOG_ERROR, "Unable to create resource URL.", ex);
                        }
                    }
                }
            } finally {
                _bcornu_try_context_2.finallyStart(2);
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    synchronized void close() {
        MethodContext _bcornu_methode_context35 = new MethodContext(void.class, 655, 20662, 21190);
        try {
            CallChecker.varInit(this, "this", 655, 20662, 21190);
            CallChecker.varInit(this.m_wiring, "m_wiring", 655, 20662, 21190);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 655, 20662, 21190);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 655, 20662, 21190);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 655, 20662, 21190);
            CallChecker.varInit(this.m_content, "m_content", 655, 20662, 21190);
            CallChecker.varInit(this.m_bundle, "m_bundle", 655, 20662, 21190);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 655, 20662, 21190);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 655, 20662, 21190);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 655, 20662, 21190);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 655, 20662, 21190);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 655, 20662, 21190);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 655, 20662, 21190);
            CallChecker.varInit(this.m_version, "m_version", 655, 20662, 21190);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 655, 20662, 21190);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 655, 20662, 21190);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 655, 20662, 21190);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 655, 20662, 21190);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 655, 20662, 21190);
            CallChecker.varInit(this.m_id, "m_id", 655, 20662, 21190);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 655, 20662, 21190);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 655, 20662, 21190);
            TryContext _bcornu_try_context_3 = new TryContext(3, BundleRevisionImpl.class, "java.lang.Exception");
            try {
                resolve(null);
            } catch (Exception ex) {
                _bcornu_try_context_3.catchStart(3);
                if (CallChecker.beforeDeref(m_bundle, Bundle.class, 663, 20818, 20825)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 663, 20818, 20825).getFramework(), Felix.class, 663, 20804, 20841)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 663, 20818, 20825).getFramework(), Felix.class, 663, 20804, 20841).getLogger(), Logger.class, 663, 20804, 20853)) {
                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(((BundleImpl) (m_bundle)), BundleImpl.class, 663, 20818, 20825).getFramework(), Felix.class, 663, 20804, 20841).getLogger(), Logger.class, 663, 20804, 20853).log(Logger.LOG_ERROR, ("Error releasing revision: " + (ex.getMessage())), ex);
                        }
                    }
                }
            } finally {
                _bcornu_try_context_3.finallyStart(3);
            }
            if (CallChecker.beforeDeref(m_content, Content.class, 666, 20965, 20973)) {
                m_content = CallChecker.beforeCalled(m_content, Content.class, 666, 20965, 20973);
                CallChecker.isCalled(m_content, Content.class, 666, 20965, 20973).close();
            }
            m_content = null;
            CallChecker.varAssign(this.m_content, "this.m_content", 667, 20992, 21008);
            m_contentPath = CallChecker.beforeCalled(m_contentPath, List.class, 668, 21066, 21078);
            for (int i = 0; ((m_contentPath) != null) && (i < (CallChecker.isCalled(m_contentPath, List.class, 668, 21066, 21078).size())); i++) {
                m_contentPath = CallChecker.beforeCalled(m_contentPath, List.class, 670, 21116, 21128);
                if (CallChecker.beforeDeref(CallChecker.isCalled(m_contentPath, List.class, 670, 21116, 21128).get(i), Content.class, 670, 21116, 21135)) {
                    CallChecker.isCalled(m_contentPath.get(i), Content.class, 670, 21116, 21135).close();
                }
            }
            m_contentPath = null;
            CallChecker.varAssign(this.m_contentPath, "this.m_contentPath", 672, 21164, 21184);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context36 = new MethodContext(String.class, 676, 21197, 21303);
        try {
            CallChecker.varInit(this, "this", 676, 21197, 21303);
            CallChecker.varInit(this.m_wiring, "m_wiring", 676, 21197, 21303);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.BundleRevisionImpl.m_secureAction", 676, 21197, 21303);
            CallChecker.varInit(this.m_protectionDomain, "m_protectionDomain", 676, 21197, 21303);
            CallChecker.varInit(this.m_contentPath, "m_contentPath", 676, 21197, 21303);
            CallChecker.varInit(this.m_content, "m_content", 676, 21197, 21303);
            CallChecker.varInit(this.m_bundle, "m_bundle", 676, 21197, 21303);
            CallChecker.varInit(this.m_activationExcludes, "m_activationExcludes", 676, 21197, 21303);
            CallChecker.varInit(this.m_activationIncludes, "m_activationIncludes", 676, 21197, 21303);
            CallChecker.varInit(this.m_declaredActivationPolicy, "m_declaredActivationPolicy", 676, 21197, 21303);
            CallChecker.varInit(this.m_declaredNativeLibs, "m_declaredNativeLibs", 676, 21197, 21303);
            CallChecker.varInit(this.m_declaredReqs, "m_declaredReqs", 676, 21197, 21303);
            CallChecker.varInit(this.m_declaredCaps, "m_declaredCaps", 676, 21197, 21303);
            CallChecker.varInit(this.m_version, "m_version", 676, 21197, 21303);
            CallChecker.varInit(this.m_symbolicName, "m_symbolicName", 676, 21197, 21303);
            CallChecker.varInit(this.m_isFragment, "m_isFragment", 676, 21197, 21303);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 676, 21197, 21303);
            CallChecker.varInit(this.m_manifestVersion, "m_manifestVersion", 676, 21197, 21303);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 676, 21197, 21303);
            CallChecker.varInit(this.m_id, "m_id", 676, 21197, 21303);
            CallChecker.varInit(LAZY_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.LAZY_ACTIVATION", 676, 21197, 21303);
            CallChecker.varInit(EAGER_ACTIVATION, "org.apache.felix.framework.BundleRevisionImpl.EAGER_ACTIVATION", 676, 21197, 21303);
            return (((CallChecker.isCalled(m_bundle, Bundle.class, 678, 21257, 21264).toString()) + "(R ") + (m_id)) + ")";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }
}

