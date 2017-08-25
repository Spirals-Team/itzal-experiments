package org.apache.felix.framework.util.manifestparser;

import org.apache.felix.framework.util.VersionRange;
import org.osgi.framework.Version;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.capabilityset.SimpleFilter;
import java.util.Set;
import java.io.PrintStream;
import org.osgi.framework.namespace.NativeNamespace;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import org.apache.felix.framework.Logger;
import java.util.List;
import java.util.LinkedHashMap;
import org.osgi.framework.namespace.IdentityNamespace;
import org.apache.felix.framework.BundleRevisionImpl;
import org.osgi.framework.wiring.BundleRevision;
import org.apache.felix.framework.wiring.BundleRequirementImpl;
import org.osgi.framework.wiring.BundleRequirement;
import org.osgi.framework.namespace.BundleNamespace;
import org.osgi.framework.BundleException;
import org.apache.felix.framework.wiring.BundleCapabilityImpl;
import org.osgi.framework.wiring.BundleCapability;
import java.util.Arrays;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collections;
import org.osgi.framework.Constants;
import org.osgi.framework.namespace.ExecutionEnvironmentNamespace;
import org.apache.felix.framework.util.FelixConstants;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.util.HashSet;

public class ManifestParser {
    private static final String BUNDLE_LICENSE_HEADER = "Bundle-License";

    private final Logger m_logger;

    private final Map m_configMap;

    private final Map m_headerMap;

    private volatile int m_activationPolicy = BundleRevisionImpl.EAGER_ACTIVATION;

    private volatile String m_activationIncludeDir;

    private volatile String m_activationExcludeDir;

    private volatile boolean m_isExtension = false;

    private volatile String m_bundleSymbolicName;

    private volatile Version m_bundleVersion;

    private volatile List<BundleCapability> m_capabilities;

    private volatile List<BundleRequirement> m_requirements;

    private volatile List<NativeLibraryClause> m_libraryClauses;

    private volatile boolean m_libraryHeadersOptional = false;

    public ManifestParser(Logger logger, Map configMap, BundleRevision owner, Map headerMap) throws BundleException {
        MethodContext _bcornu_methode_context163 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 71, 2984, 3001);
            m_configMap = configMap;
            CallChecker.varAssign(this.m_configMap, "this.m_configMap", 72, 3011, 3034);
            m_headerMap = headerMap;
            CallChecker.varAssign(this.m_headerMap, "this.m_headerMap", 73, 3044, 3067);
            String manifestVersion = CallChecker.varInit(ManifestParser.getManifestVersion(m_headerMap), "manifestVersion", 76, 3139, 3195);
            if ((manifestVersion != null) && (!(manifestVersion.equals("2")))) {
                throw new BundleException(("Unknown 'Bundle-ManifestVersion' value: " + manifestVersion));
            }
            List<BundleCapabilityImpl> capList = CallChecker.varInit(new ArrayList(), "capList", 84, 3478, 3530);
            m_bundleVersion = Version.emptyVersion;
            CallChecker.varAssign(this.m_bundleVersion, "this.m_bundleVersion", 90, 3597, 3635);
            if (CallChecker.beforeDeref(headerMap, Map.class, 91, 3649, 3657)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 91, 3649, 3657);
                if ((CallChecker.isCalled(headerMap, Map.class, 91, 3649, 3657).get(Constants.BUNDLE_VERSION)) != null) {
                    TryContext _bcornu_try_context_444 = new TryContext(444, ManifestParser.class, "java.lang.RuntimeException");
                    try {
                        if (CallChecker.beforeDeref(headerMap, Map.class, 96, 3823, 3831)) {
                            headerMap = CallChecker.beforeCalled(headerMap, Map.class, 96, 3823, 3831);
                            m_bundleVersion = Version.parseVersion(((String) (CallChecker.isCalled(headerMap, Map.class, 96, 3823, 3831).get(Constants.BUNDLE_VERSION))));
                            CallChecker.varAssign(this.m_bundleVersion, "this.m_bundleVersion", 95, 3754, 3863);
                        }
                    } catch (RuntimeException ex) {
                        _bcornu_try_context_444.catchStart(444);
                        final String npe_invocation_var542 = getManifestVersion();
                        if (CallChecker.beforeDeref(npe_invocation_var542, String.class, 101, 4030, 4049)) {
                            if (CallChecker.isCalled(npe_invocation_var542, String.class, 101, 4030, 4049).equals("2")) {
                                throw ex;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        m_bundleVersion = Version.emptyVersion;
                        CallChecker.varAssign(this.m_bundleVersion, "this.m_bundleVersion", 105, 4146, 4184);
                    } finally {
                        _bcornu_try_context_444.finallyStart(444);
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            BundleCapabilityImpl bundleCap = CallChecker.varInit(ManifestParser.parseBundleSymbolicName(owner, m_headerMap), "bundleCap", 113, 4281, 4357);
            if (bundleCap != null) {
                bundleCap = CallChecker.beforeCalled(bundleCap, BundleCapabilityImpl.class, 117, 4460, 4468);
                final Map<String, Object> npe_invocation_var543 = CallChecker.isCalled(bundleCap, BundleCapabilityImpl.class, 117, 4460, 4468).getAttributes();
                if (CallChecker.beforeDeref(npe_invocation_var543, Map.class, 117, 4460, 4484)) {
                    m_bundleSymbolicName = ((String) (CallChecker.isCalled(npe_invocation_var543, Map.class, 117, 4460, 4484).get(BundleRevision.BUNDLE_NAMESPACE)));
                    CallChecker.varAssign(this.m_bundleSymbolicName, "this.m_bundleSymbolicName", 116, 4412, 4522);
                }
                if (CallChecker.beforeDeref(headerMap, Map.class, 125, 4922, 4930)) {
                    headerMap = CallChecker.beforeCalled(headerMap, Map.class, 125, 4922, 4930);
                    if ((CallChecker.isCalled(headerMap, Map.class, 125, 4922, 4930).get(Constants.FRAGMENT_HOST)) == null) {
                        if (CallChecker.beforeDeref(capList, List.class, 128, 5068, 5074)) {
                            capList = CallChecker.beforeCalled(capList, List.class, 128, 5068, 5074);
                            CallChecker.isCalled(capList, List.class, 128, 5068, 5074).add(bundleCap);
                        }
                        bundleCap = CallChecker.beforeCalled(bundleCap, BundleCapabilityImpl.class, 131, 5231, 5239);
                        final Map<String, String> npe_invocation_var544 = CallChecker.isCalled(bundleCap, BundleCapabilityImpl.class, 131, 5231, 5239).getDirectives();
                        String attachment = CallChecker.init(String.class);
                        if (CallChecker.beforeDeref(npe_invocation_var544, Map.class, 131, 5231, 5255)) {
                            attachment = CallChecker.isCalled(npe_invocation_var544, Map.class, 131, 5231, 5255).get(Constants.FRAGMENT_ATTACHMENT_DIRECTIVE);
                            CallChecker.varAssign(attachment, "attachment", 131, 5231, 5255);
                        }
                        if (attachment == null) {
                            attachment = Constants.FRAGMENT_ATTACHMENT_RESOLVETIME;
                            CallChecker.varAssign(attachment, "attachment", 132, 5319, 5449);
                        }else {
                            attachment = attachment;
                            CallChecker.varAssign(attachment, "attachment", 132, 5319, 5449);
                        }
                        if (CallChecker.beforeDeref(attachment, String.class, 135, 5472, 5481)) {
                            attachment = CallChecker.beforeCalled(attachment, String.class, 135, 5472, 5481);
                            if (!(CallChecker.isCalled(attachment, String.class, 135, 5472, 5481).equalsIgnoreCase(Constants.FRAGMENT_ATTACHMENT_NEVER))) {
                                Map<String, Object> hostAttrs = CallChecker.varInit(new HashMap<String, Object>(bundleCap.getAttributes()), "hostAttrs", 137, 5576, 5686);
                                Object value = CallChecker.init(Object.class);
                                if (CallChecker.beforeDeref(hostAttrs, Map.class, 139, 5723, 5731)) {
                                    hostAttrs = CallChecker.beforeCalled(hostAttrs, Map.class, 139, 5723, 5731);
                                    value = CallChecker.isCalled(hostAttrs, Map.class, 139, 5723, 5731).remove(BundleRevision.BUNDLE_NAMESPACE);
                                    CallChecker.varAssign(value, "value", 139, 5723, 5731);
                                }
                                if (CallChecker.beforeDeref(hostAttrs, Map.class, 140, 5794, 5802)) {
                                    hostAttrs = CallChecker.beforeCalled(hostAttrs, Map.class, 140, 5794, 5802);
                                    CallChecker.isCalled(hostAttrs, Map.class, 140, 5794, 5802).put(BundleRevision.HOST_NAMESPACE, value);
                                }
                                if (CallChecker.beforeDeref(capList, List.class, 141, 5867, 5873)) {
                                    capList = CallChecker.beforeCalled(capList, List.class, 141, 5867, 5873);
                                    CallChecker.isCalled(capList, List.class, 141, 5867, 5873).add(new BundleCapabilityImpl(owner, BundleRevision.HOST_NAMESPACE, bundleCap.getDirectives(), hostAttrs));
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(capList, List.class, 151, 6179, 6185)) {
                    capList = CallChecker.beforeCalled(capList, List.class, 151, 6179, 6185);
                    CallChecker.isCalled(capList, List.class, 151, 6179, 6185).add(ManifestParser.addIdentityCapability(owner, headerMap, bundleCap));
                }
            }
            final String npe_invocation_var545 = getManifestVersion();
            if (CallChecker.beforeDeref(npe_invocation_var545, String.class, 155, 6325, 6344)) {
                if ((CallChecker.isCalled(npe_invocation_var545, String.class, 155, 6325, 6344).equals("2")) && ((m_bundleSymbolicName) == null)) {
                    throw new BundleException("R4 bundle manifests must include bundle symbolic name.");
                }
            }else
                throw new AbnormalExecutionError();
            
            List<BundleRequirementImpl> hostReqs = CallChecker.varInit(ManifestParser.parseFragmentHost(m_logger, owner, m_headerMap), "hostReqs", 165, 6591, 6677);
            List<ParsedHeaderClause> rbClauses = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 172, 6821, 6829)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 172, 6821, 6829);
                rbClauses = ManifestParser.parseStandardHeader(((String) (CallChecker.isCalled(headerMap, Map.class, 172, 6821, 6829).get(Constants.REQUIRE_BUNDLE))));
                CallChecker.varAssign(rbClauses, "rbClauses", 172, 6821, 6829);
            }
            rbClauses = ManifestParser.normalizeRequireClauses(m_logger, rbClauses, getManifestVersion());
            CallChecker.varAssign(rbClauses, "rbClauses", 173, 6871, 6949);
            List<BundleRequirementImpl> rbReqs = CallChecker.varInit(ManifestParser.convertRequires(rbClauses, owner), "rbReqs", 174, 6959, 7029);
            List<ParsedHeaderClause> importClauses = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 181, 7178, 7186)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 181, 7178, 7186);
                importClauses = ManifestParser.parseStandardHeader(((String) (CallChecker.isCalled(headerMap, Map.class, 181, 7178, 7186).get(Constants.IMPORT_PACKAGE))));
                CallChecker.varAssign(importClauses, "importClauses", 181, 7178, 7186);
            }
            importClauses = ManifestParser.normalizeImportClauses(m_logger, importClauses, getManifestVersion());
            CallChecker.varAssign(importClauses, "importClauses", 182, 7228, 7313);
            List<BundleRequirement> importReqs = CallChecker.varInit(ManifestParser.convertImports(importClauses, owner), "importReqs", 183, 7323, 7396);
            List<ParsedHeaderClause> dynamicClauses = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 190, 7553, 7561)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 190, 7553, 7561);
                dynamicClauses = ManifestParser.parseStandardHeader(((String) (CallChecker.isCalled(headerMap, Map.class, 190, 7553, 7561).get(Constants.DYNAMICIMPORT_PACKAGE))));
                CallChecker.varAssign(dynamicClauses, "dynamicClauses", 190, 7553, 7561);
            }
            dynamicClauses = ManifestParser.normalizeDynamicImportClauses(m_logger, dynamicClauses, getManifestVersion());
            CallChecker.varAssign(dynamicClauses, "dynamicClauses", 191, 7610, 7704);
            List<BundleRequirement> dynamicReqs = CallChecker.varInit(ManifestParser.convertImports(dynamicClauses, owner), "dynamicReqs", 192, 7714, 7789);
            List<ParsedHeaderClause> requireClauses = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 199, 7943, 7951)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 199, 7943, 7951);
                requireClauses = ManifestParser.parseStandardHeader(((String) (CallChecker.isCalled(headerMap, Map.class, 199, 7943, 7951).get(Constants.REQUIRE_CAPABILITY))));
                CallChecker.varAssign(requireClauses, "requireClauses", 199, 7943, 7951);
            }
            importClauses = ManifestParser.normalizeRequireCapabilityClauses(m_logger, requireClauses, getManifestVersion());
            CallChecker.varAssign(importClauses, "importClauses", 200, 7997, 8107);
            List<BundleRequirement> requireReqs = CallChecker.varInit(ManifestParser.convertRequireCapabilities(importClauses, owner), "requireReqs", 202, 8117, 8203);
            List<BundleRequirement> breeReqs = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 208, 8362, 8370)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 208, 8362, 8370);
                breeReqs = ManifestParser.parseBreeHeader(((String) (CallChecker.isCalled(headerMap, Map.class, 208, 8362, 8370).get(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT))), owner);
                CallChecker.varAssign(breeReqs, "breeReqs", 208, 8362, 8370);
            }
            List<ParsedHeaderClause> exportClauses = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 215, 8579, 8587)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 215, 8579, 8587);
                exportClauses = ManifestParser.parseStandardHeader(((String) (CallChecker.isCalled(headerMap, Map.class, 215, 8579, 8587).get(Constants.EXPORT_PACKAGE))));
                CallChecker.varAssign(exportClauses, "exportClauses", 215, 8579, 8587);
            }
            exportClauses = ManifestParser.normalizeExportClauses(logger, exportClauses, getManifestVersion(), m_bundleSymbolicName, m_bundleVersion);
            CallChecker.varAssign(exportClauses, "exportClauses", 216, 8629, 8763);
            List<BundleCapability> exportCaps = CallChecker.varInit(ManifestParser.convertExports(exportClauses, owner), "exportCaps", 218, 8773, 8845);
            List<ParsedHeaderClause> provideClauses = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 225, 8999, 9007)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 225, 8999, 9007);
                provideClauses = ManifestParser.parseStandardHeader(((String) (CallChecker.isCalled(headerMap, Map.class, 225, 8999, 9007).get(Constants.PROVIDE_CAPABILITY))));
                CallChecker.varAssign(provideClauses, "provideClauses", 225, 8999, 9007);
            }
            exportClauses = ManifestParser.normalizeProvideCapabilityClauses(logger, provideClauses, getManifestVersion());
            CallChecker.varAssign(exportClauses, "exportClauses", 226, 9053, 9161);
            List<BundleCapability> provideCaps = CallChecker.varInit(ManifestParser.convertProvideCapabilities(provideClauses, owner), "provideCaps", 228, 9171, 9257);
            final String npe_invocation_var546 = getManifestVersion();
            if (CallChecker.beforeDeref(npe_invocation_var546, String.class, 234, 9335, 9354)) {
                if (!(CallChecker.isCalled(npe_invocation_var546, String.class, 234, 9335, 9354).equals("2"))) {
                    List<ParsedHeaderClause> implicitClauses = CallChecker.varInit(ManifestParser.calculateImplicitImports(exportCaps, importClauses), "implicitClauses", 236, 9391, 9501);
                    if (CallChecker.beforeDeref(importReqs, List.class, 238, 9515, 9524)) {
                        importReqs = CallChecker.beforeCalled(importReqs, List.class, 238, 9515, 9524);
                        CallChecker.isCalled(importReqs, List.class, 238, 9515, 9524).addAll(ManifestParser.convertImports(implicitClauses, owner));
                    }
                    List<ParsedHeaderClause> allImportClauses = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(implicitClauses, List.class, 241, 9681, 9695)) {
                        if (CallChecker.beforeDeref(importClauses, List.class, 241, 9706, 9718)) {
                            implicitClauses = CallChecker.beforeCalled(implicitClauses, List.class, 241, 9681, 9695);
                            importClauses = CallChecker.beforeCalled(importClauses, List.class, 241, 9706, 9718);
                            allImportClauses = new ArrayList<ParsedHeaderClause>(((CallChecker.isCalled(implicitClauses, List.class, 241, 9681, 9695).size()) + (CallChecker.isCalled(importClauses, List.class, 241, 9706, 9718).size())));
                            CallChecker.varAssign(allImportClauses, "allImportClauses", 241, 9681, 9695);
                        }
                    }
                    if (CallChecker.beforeDeref(allImportClauses, List.class, 242, 9741, 9756)) {
                        allImportClauses = CallChecker.beforeCalled(allImportClauses, List.class, 242, 9741, 9756);
                        CallChecker.isCalled(allImportClauses, List.class, 242, 9741, 9756).addAll(importClauses);
                    }
                    if (CallChecker.beforeDeref(allImportClauses, List.class, 243, 9793, 9808)) {
                        allImportClauses = CallChecker.beforeCalled(allImportClauses, List.class, 243, 9793, 9808);
                        CallChecker.isCalled(allImportClauses, List.class, 243, 9793, 9808).addAll(implicitClauses);
                    }
                    exportCaps = ManifestParser.calculateImplicitUses(exportCaps, allImportClauses);
                    CallChecker.varAssign(exportCaps, "exportCaps", 245, 9848, 9912);
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(m_headerMap, Map.class, 256, 10157, 10167)) {
                m_libraryClauses = ManifestParser.parseLibraryStrings(m_logger, ManifestParser.parseDelimitedString(((String) (CallChecker.isCalled(m_headerMap, Map.class, 256, 10157, 10167).get(Constants.BUNDLE_NATIVECODE))), ","));
                CallChecker.varAssign(this.m_libraryClauses, "this.m_libraryClauses", 253, 10033, 10208);
            }
            if (CallChecker.beforeDeref(m_libraryClauses, List.class, 260, 10386, 10401)) {
                if (CallChecker.beforeDeref(m_libraryClauses, List.class, 261, 10450, 10465)) {
                    if (CallChecker.beforeDeref(m_libraryClauses, List.class, 261, 10429, 10444)) {
                        m_libraryClauses = CallChecker.beforeCalled(m_libraryClauses, List.class, 261, 10450, 10465);
                        m_libraryClauses = CallChecker.beforeCalled(m_libraryClauses, List.class, 261, 10429, 10444);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(m_libraryClauses, List.class, 261, 10429, 10444).get(((CallChecker.isCalled(m_libraryClauses, List.class, 261, 10450, 10465).size()) - 1)), NativeLibraryClause.class, 261, 10429, 10477)) {
                            m_libraryClauses = CallChecker.beforeCalled(m_libraryClauses, List.class, 260, 10386, 10401);
                            m_libraryClauses = CallChecker.beforeCalled(m_libraryClauses, List.class, 261, 10450, 10465);
                            m_libraryClauses = CallChecker.beforeCalled(m_libraryClauses, List.class, 261, 10429, 10444);
                            if ((!(CallChecker.isCalled(m_libraryClauses, List.class, 260, 10386, 10401).isEmpty())) && ((CallChecker.isCalled(CallChecker.isCalled(m_libraryClauses, List.class, 261, 10429, 10444).get(((CallChecker.isCalled(m_libraryClauses, List.class, 261, 10450, 10465).size()) - 1)), NativeLibraryClause.class, 261, 10429, 10477).getLibraryEntries()) == null)) {
                                m_libraryHeadersOptional = true;
                                CallChecker.varAssign(this.m_libraryHeadersOptional, "this.m_libraryHeadersOptional", 263, 10531, 10562);
                                if (CallChecker.beforeDeref(m_libraryClauses, List.class, 264, 10600, 10615)) {
                                    if (CallChecker.beforeDeref(m_libraryClauses, List.class, 264, 10576, 10591)) {
                                        m_libraryClauses = CallChecker.beforeCalled(m_libraryClauses, List.class, 264, 10600, 10615);
                                        m_libraryClauses = CallChecker.beforeCalled(m_libraryClauses, List.class, 264, 10576, 10591);
                                        CallChecker.isCalled(m_libraryClauses, List.class, 264, 10576, 10591).remove(((CallChecker.isCalled(m_libraryClauses, List.class, 264, 10600, 10615).size()) - 1));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            List<BundleRequirement> nativeCodeReqs = CallChecker.varInit(ManifestParser.convertNativeCode(owner, m_libraryClauses, m_libraryHeadersOptional), "nativeCodeReqs", 267, 10657, 10766);
            if (CallChecker.beforeDeref(hostReqs, List.class, 271, 10866, 10873)) {
                if (CallChecker.beforeDeref(importReqs, List.class, 271, 10884, 10893)) {
                    if (CallChecker.beforeDeref(rbReqs, List.class, 271, 10904, 10909)) {
                        if (CallChecker.beforeDeref(requireReqs, List.class, 272, 10932, 10942)) {
                            if (CallChecker.beforeDeref(dynamicReqs, List.class, 272, 10953, 10963)) {
                                if (CallChecker.beforeDeref(breeReqs, List.class, 272, 10974, 10981)) {
                                    hostReqs = CallChecker.beforeCalled(hostReqs, List.class, 271, 10866, 10873);
                                    importReqs = CallChecker.beforeCalled(importReqs, List.class, 271, 10884, 10893);
                                    rbReqs = CallChecker.beforeCalled(rbReqs, List.class, 271, 10904, 10909);
                                    requireReqs = CallChecker.beforeCalled(requireReqs, List.class, 272, 10932, 10942);
                                    dynamicReqs = CallChecker.beforeCalled(dynamicReqs, List.class, 272, 10953, 10963);
                                    breeReqs = CallChecker.beforeCalled(breeReqs, List.class, 272, 10974, 10981);
                                    m_requirements = new ArrayList(((((((CallChecker.isCalled(hostReqs, List.class, 271, 10866, 10873).size()) + (CallChecker.isCalled(importReqs, List.class, 271, 10884, 10893).size())) + (CallChecker.isCalled(rbReqs, List.class, 271, 10904, 10909).size())) + (CallChecker.isCalled(requireReqs, List.class, 272, 10932, 10942).size())) + (CallChecker.isCalled(dynamicReqs, List.class, 272, 10953, 10963).size())) + (CallChecker.isCalled(breeReqs, List.class, 272, 10974, 10981).size())));
                                    CallChecker.varAssign(this.m_requirements, "this.m_requirements", 270, 10822, 10990);
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m_requirements, List.class, 273, 11000, 11013)) {
                m_requirements = CallChecker.beforeCalled(m_requirements, List.class, 273, 11000, 11013);
                CallChecker.isCalled(m_requirements, List.class, 273, 11000, 11013).addAll(hostReqs);
            }
            if (CallChecker.beforeDeref(m_requirements, List.class, 274, 11041, 11054)) {
                m_requirements = CallChecker.beforeCalled(m_requirements, List.class, 274, 11041, 11054);
                CallChecker.isCalled(m_requirements, List.class, 274, 11041, 11054).addAll(importReqs);
            }
            if (CallChecker.beforeDeref(m_requirements, List.class, 275, 11084, 11097)) {
                m_requirements = CallChecker.beforeCalled(m_requirements, List.class, 275, 11084, 11097);
                CallChecker.isCalled(m_requirements, List.class, 275, 11084, 11097).addAll(rbReqs);
            }
            if (CallChecker.beforeDeref(m_requirements, List.class, 276, 11123, 11136)) {
                m_requirements = CallChecker.beforeCalled(m_requirements, List.class, 276, 11123, 11136);
                CallChecker.isCalled(m_requirements, List.class, 276, 11123, 11136).addAll(requireReqs);
            }
            if (CallChecker.beforeDeref(m_requirements, List.class, 277, 11167, 11180)) {
                m_requirements = CallChecker.beforeCalled(m_requirements, List.class, 277, 11167, 11180);
                CallChecker.isCalled(m_requirements, List.class, 277, 11167, 11180).addAll(dynamicReqs);
            }
            if (CallChecker.beforeDeref(m_requirements, List.class, 278, 11211, 11224)) {
                m_requirements = CallChecker.beforeCalled(m_requirements, List.class, 278, 11211, 11224);
                CallChecker.isCalled(m_requirements, List.class, 278, 11211, 11224).addAll(breeReqs);
            }
            if (CallChecker.beforeDeref(m_requirements, List.class, 279, 11252, 11265)) {
                m_requirements = CallChecker.beforeCalled(m_requirements, List.class, 279, 11252, 11265);
                CallChecker.isCalled(m_requirements, List.class, 279, 11252, 11265).addAll(nativeCodeReqs);
            }
            if (CallChecker.beforeDeref(capList, List.class, 283, 11390, 11396)) {
                if (CallChecker.beforeDeref(exportCaps, List.class, 283, 11407, 11416)) {
                    if (CallChecker.beforeDeref(provideCaps, List.class, 283, 11427, 11437)) {
                        capList = CallChecker.beforeCalled(capList, List.class, 283, 11390, 11396);
                        exportCaps = CallChecker.beforeCalled(exportCaps, List.class, 283, 11407, 11416);
                        provideCaps = CallChecker.beforeCalled(provideCaps, List.class, 283, 11427, 11437);
                        m_capabilities = new ArrayList((((CallChecker.isCalled(capList, List.class, 283, 11390, 11396).size()) + (CallChecker.isCalled(exportCaps, List.class, 283, 11407, 11416).size())) + (CallChecker.isCalled(provideCaps, List.class, 283, 11427, 11437).size())));
                        CallChecker.varAssign(this.m_capabilities, "this.m_capabilities", 282, 11345, 11446);
                    }
                }
            }
            if (CallChecker.beforeDeref(m_capabilities, List.class, 284, 11456, 11469)) {
                m_capabilities = CallChecker.beforeCalled(m_capabilities, List.class, 284, 11456, 11469);
                CallChecker.isCalled(m_capabilities, List.class, 284, 11456, 11469).addAll(capList);
            }
            if (CallChecker.beforeDeref(m_capabilities, List.class, 285, 11496, 11509)) {
                m_capabilities = CallChecker.beforeCalled(m_capabilities, List.class, 285, 11496, 11509);
                CallChecker.isCalled(m_capabilities, List.class, 285, 11496, 11509).addAll(exportCaps);
            }
            if (CallChecker.beforeDeref(m_capabilities, List.class, 286, 11539, 11552)) {
                m_capabilities = CallChecker.beforeCalled(m_capabilities, List.class, 286, 11539, 11552);
                CallChecker.isCalled(m_capabilities, List.class, 286, 11539, 11552).addAll(provideCaps);
            }
            parseActivationPolicy(headerMap);
            m_isExtension = ManifestParser.checkExtensionBundle(headerMap);
            CallChecker.varAssign(this.m_isExtension, "this.m_isExtension", 296, 11792, 11839);
        } finally {
            _bcornu_methode_context163.methodEnd();
        }
    }

    private static List<ParsedHeaderClause> normalizeImportClauses(Logger logger, List<ParsedHeaderClause> clauses, String mv) throws BundleException {
        MethodContext _bcornu_methode_context1655 = new MethodContext(List.class);
        try {
            CallChecker.varInit(mv, "mv", 299, 11852, 17039);
            CallChecker.varInit(clauses, "clauses", 299, 11852, 17039);
            CallChecker.varInit(logger, "logger", 299, 11852, 17039);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 299, 11852, 17039);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 299, 11852, 17039);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 299, 11852, 17039);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 299, 11852, 17039);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 299, 11852, 17039);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 299, 11852, 17039);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 299, 11852, 17039);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 299, 11852, 17039);
            Set dupeSet = CallChecker.varInit(new HashSet(), "dupeSet", 305, 12161, 12188);
            if (CallChecker.beforeDeref(clauses, List.class, 306, 12231, 12237)) {
                for (ParsedHeaderClause clause : clauses) {
                    Object v = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 310, 12414, 12419)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 310, 12414, 12419).m_attrs, Map.class, 310, 12414, 12427)) {
                            v = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 310, 12414, 12419).m_attrs, Map.class, 310, 12414, 12427).get(Constants.VERSION_ATTRIBUTE);
                            CallChecker.varAssign(v, "v", 310, 12414, 12419);
                        }
                    }
                    Object sv = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 311, 12487, 12492)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 311, 12487, 12492).m_attrs, Map.class, 311, 12487, 12500)) {
                            sv = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 311, 12487, 12492).m_attrs, Map.class, 311, 12487, 12500).get(Constants.PACKAGE_SPECIFICATION_VERSION);
                            CallChecker.varAssign(sv, "sv", 311, 12487, 12492);
                        }
                    }
                    if ((v != null) && (sv != null)) {
                        v = CallChecker.beforeCalled(v, String.class, 315, 12680, 12680);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(((String) (v)), String.class, 315, 12680, 12680).trim(), String.class, 315, 12670, 12688)) {
                            if (!(CallChecker.isCalled(((String) (v)).trim(), String.class, 315, 12670, 12688).equals(((String) (sv)).trim()))) {
                                throw new IllegalArgumentException("Both version and specification-version are specified, but they are not equal.");
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                    if ((v != null) || (sv != null)) {
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 326, 13128, 13133)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 326, 13128, 13133).m_attrs, Map.class, 326, 13128, 13141)) {
                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 326, 13128, 13133).m_attrs, Map.class, 326, 13128, 13141).remove(Constants.PACKAGE_SPECIFICATION_VERSION);
                            }
                        }
                        if (v == null) {
                            v = sv;
                            CallChecker.varAssign(v, "v", 327, 13208, 13232);
                        }else {
                            v = v;
                            CallChecker.varAssign(v, "v", 327, 13208, 13232);
                        }
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 328, 13250, 13255)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 328, 13250, 13255).m_attrs, Map.class, 328, 13250, 13263)) {
                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 328, 13250, 13255).m_attrs, Map.class, 328, 13250, 13263).put(Constants.VERSION_ATTRIBUTE, VersionRange.parse(v.toString()));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 334, 13491, 13496)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 334, 13491, 13496).m_attrs, Map.class, 334, 13491, 13504)) {
                            v = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 334, 13491, 13496).m_attrs, Map.class, 334, 13491, 13504).get(Constants.BUNDLE_VERSION_ATTRIBUTE);
                            CallChecker.varAssign(v, "v", 334, 13487, 13545);
                        }
                    }
                    if (v != null) {
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 337, 13604, 13609)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 337, 13604, 13609).m_attrs, Map.class, 337, 13604, 13617)) {
                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 337, 13604, 13609).m_attrs, Map.class, 337, 13604, 13617).put(Constants.BUNDLE_VERSION_ATTRIBUTE, VersionRange.parse(v.toString()));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 343, 13857, 13862).m_paths, List.class, 343, 13857, 13870)) {
                        for (String pkgName : CallChecker.isCalled(clause, ParsedHeaderClause.class, 343, 13857, 13862).m_paths) {
                            if (CallChecker.beforeDeref(dupeSet, Set.class, 345, 13908, 13914)) {
                                dupeSet = CallChecker.beforeCalled(dupeSet, Set.class, 345, 13908, 13914);
                                if (!(CallChecker.isCalled(dupeSet, Set.class, 345, 13908, 13914).contains(pkgName))) {
                                    if (CallChecker.beforeDeref(pkgName, String.class, 348, 14046, 14052)) {
                                        if (CallChecker.isCalled(pkgName, String.class, 348, 14046, 14052).startsWith("java.")) {
                                            throw new BundleException(("Importing java.* packages not allowed: " + pkgName));
                                        }else
                                            if (CallChecker.beforeDeref(pkgName, String.class, 357, 14599, 14605)) {
                                                if (CallChecker.isCalled(pkgName, String.class, 357, 14599, 14605).equals(".")) {
                                                    throw new BundleException("Imporing '.' is invalid.");
                                                }else
                                                    if (CallChecker.beforeDeref(pkgName, String.class, 362, 14835, 14841)) {
                                                        if ((CallChecker.isCalled(pkgName, String.class, 362, 14835, 14841).length()) == 0) {
                                                            throw new BundleException("Imported package names cannot be zero length.");
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    if (CallChecker.beforeDeref(dupeSet, Set.class, 367, 15051, 15057)) {
                                        dupeSet = CallChecker.beforeCalled(dupeSet, Set.class, 367, 15051, 15057);
                                        CallChecker.isCalled(dupeSet, Set.class, 367, 15051, 15057).add(pkgName);
                                    }
                                }else {
                                    throw new BundleException(("Duplicate import: " + pkgName));
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                    if (CallChecker.beforeDeref(mv, String.class, 375, 15259, 15260)) {
                        mv = CallChecker.beforeCalled(mv, String.class, 375, 15259, 15260);
                        if (!(CallChecker.isCalled(mv, String.class, 375, 15259, 15260).equals("2"))) {
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 378, 15381, 15386)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 378, 15381, 15386).m_dirs, Map.class, 378, 15381, 15393)) {
                                    if (!(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 378, 15381, 15386).m_dirs, Map.class, 378, 15381, 15393).isEmpty())) {
                                        throw new BundleException("R3 imports cannot contain directives.");
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 388, 15920, 15925)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 388, 15920, 15925).m_attrs, Map.class, 388, 15920, 15933)) {
                                    if (!(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 388, 15920, 15925).m_attrs, Map.class, 388, 15920, 15933).isEmpty())) {
                                        Object pkgVersion = CallChecker.init(Object.class);
                                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 391, 16088, 16093)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 391, 16088, 16093).m_attrs, Map.class, 391, 16088, 16101)) {
                                                pkgVersion = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 391, 16088, 16093).m_attrs, Map.class, 391, 16088, 16101).get(BundleCapabilityImpl.VERSION_ATTR);
                                                CallChecker.varAssign(pkgVersion, "pkgVersion", 391, 16088, 16093);
                                            }
                                        }
                                        if (pkgVersion == null) {
                                            pkgVersion = new VersionRange(Version.emptyVersion, true, null, true);
                                            CallChecker.varAssign(pkgVersion, "pkgVersion", 392, 16163, 16316);
                                        }else {
                                            pkgVersion = pkgVersion;
                                            CallChecker.varAssign(pkgVersion, "pkgVersion", 392, 16163, 16316);
                                        }
                                        for (Map.Entry<String, Object> entry : CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 395, 16373, 16378).m_attrs, Map.class, 395, 16373, 16386).entrySet()) {
                                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 397, 16451, 16455)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 397, 16451, 16455).getKey(), String.class, 397, 16451, 16464)) {
                                                    if (!(CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 397, 16451, 16455).getKey(), String.class, 397, 16451, 16464).equals(BundleCapabilityImpl.VERSION_ATTR))) {
                                                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 401, 16696, 16700)) {
                                                            if (CallChecker.beforeDeref(logger, Logger.class, 399, 16563, 16568)) {
                                                                logger = CallChecker.beforeCalled(logger, Logger.class, 399, 16563, 16568);
                                                                CallChecker.isCalled(logger, Logger.class, 399, 16563, 16568).log(Logger.LOG_WARNING, ("Unknown R3 import attribute: " + (CallChecker.isCalled(entry, Map.Entry.class, 401, 16696, 16700).getKey())));
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 406, 16857, 16862)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 406, 16857, 16862).m_attrs, Map.class, 406, 16857, 16870)) {
                                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 406, 16857, 16862).m_attrs, Map.class, 406, 16857, 16870).clear();
                                            }
                                        }
                                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 407, 16901, 16906)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 407, 16901, 16906).m_attrs, Map.class, 407, 16901, 16914)) {
                                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 407, 16901, 16906).m_attrs, Map.class, 407, 16901, 16914).put(BundleCapabilityImpl.VERSION_ATTR, pkgVersion);
                                            }
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return clauses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<ParsedHeaderClause>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1655.methodEnd();
        }
    }

    public static List<BundleRequirement> parseDynamicImportHeader(Logger logger, BundleRevision owner, String header) throws BundleException {
        MethodContext _bcornu_methode_context1656 = new MethodContext(List.class);
        try {
            CallChecker.varInit(header, "header", 415, 17046, 17471);
            CallChecker.varInit(owner, "owner", 415, 17046, 17471);
            CallChecker.varInit(logger, "logger", 415, 17046, 17471);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 415, 17046, 17471);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 415, 17046, 17471);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 415, 17046, 17471);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 415, 17046, 17471);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 415, 17046, 17471);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 415, 17046, 17471);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 415, 17046, 17471);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 415, 17046, 17471);
            List<ParsedHeaderClause> importClauses = CallChecker.varInit(ManifestParser.parseStandardHeader(header), "importClauses", 420, 17216, 17284);
            importClauses = ManifestParser.normalizeDynamicImportClauses(logger, importClauses, "2");
            CallChecker.varAssign(importClauses, "importClauses", 421, 17294, 17367);
            List<BundleRequirement> reqs = CallChecker.varInit(ManifestParser.convertImports(importClauses, owner), "reqs", 422, 17377, 17444);
            return reqs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRequirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1656.methodEnd();
        }
    }

    private static List<BundleRequirement> convertImports(List<ParsedHeaderClause> clauses, BundleRevision owner) {
        MethodContext _bcornu_methode_context1657 = new MethodContext(List.class);
        try {
            CallChecker.varInit(owner, "owner", 426, 17478, 19730);
            CallChecker.varInit(clauses, "clauses", 426, 17478, 19730);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 426, 17478, 19730);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 426, 17478, 19730);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 426, 17478, 19730);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 426, 17478, 19730);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 426, 17478, 19730);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 426, 17478, 19730);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 426, 17478, 19730);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 426, 17478, 19730);
            List reqList = CallChecker.varInit(new ArrayList(), "reqList", 430, 17676, 17706);
            if (CallChecker.beforeDeref(clauses, List.class, 431, 17749, 17755)) {
                for (ParsedHeaderClause clause : clauses) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 433, 17799, 17804).m_paths, List.class, 433, 17799, 17812)) {
                        for (String path : CallChecker.isCalled(clause, ParsedHeaderClause.class, 433, 17799, 17804).m_paths) {
                            Map<String, Object> attrs = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 436, 17945, 17950)) {
                                attrs = CallChecker.isCalled(clause, ParsedHeaderClause.class, 436, 17945, 17950).m_attrs;
                                CallChecker.varAssign(attrs, "attrs", 436, 17945, 17950);
                            }
                            Map<String, Object> newAttrs = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(attrs, Map.class, 442, 18350, 18354)) {
                                attrs = CallChecker.beforeCalled(attrs, Map.class, 442, 18350, 18354);
                                newAttrs = new LinkedHashMap<String, Object>(((CallChecker.isCalled(attrs, Map.class, 442, 18350, 18354).size()) + 1));
                                CallChecker.varAssign(newAttrs, "newAttrs", 442, 18350, 18354);
                            }
                            if (CallChecker.beforeDeref(newAttrs, Map.class, 444, 18453, 18460)) {
                                newAttrs = CallChecker.beforeCalled(newAttrs, Map.class, 444, 18453, 18460);
                                CallChecker.isCalled(newAttrs, Map.class, 444, 18453, 18460).put(BundleRevision.PACKAGE_NAMESPACE, path);
                            }
                            if (CallChecker.beforeDeref(newAttrs, Map.class, 447, 18564, 18571)) {
                                newAttrs = CallChecker.beforeCalled(newAttrs, Map.class, 447, 18564, 18571);
                                CallChecker.isCalled(newAttrs, Map.class, 447, 18564, 18571).putAll(attrs);
                            }
                            if (CallChecker.beforeDeref(newAttrs, Map.class, 449, 18687, 18694)) {
                                newAttrs = CallChecker.beforeCalled(newAttrs, Map.class, 449, 18687, 18694);
                                CallChecker.isCalled(newAttrs, Map.class, 449, 18687, 18694).put(BundleRevision.PACKAGE_NAMESPACE, path);
                            }
                            SimpleFilter sf = CallChecker.varInit(SimpleFilter.convert(newAttrs), "sf", 454, 18871, 18919);
                            Map<String, String> dirs = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 458, 19068, 19073)) {
                                dirs = CallChecker.isCalled(clause, ParsedHeaderClause.class, 458, 19068, 19073).m_dirs;
                                CallChecker.varAssign(dirs, "dirs", 458, 19068, 19073);
                            }
                            Map<String, String> newDirs = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(dirs, Map.class, 459, 19157, 19160)) {
                                dirs = CallChecker.beforeCalled(dirs, Map.class, 459, 19157, 19160);
                                newDirs = new HashMap<String, String>(((CallChecker.isCalled(dirs, Map.class, 459, 19157, 19160).size()) + 1));
                                CallChecker.varAssign(newDirs, "newDirs", 459, 19157, 19160);
                            }
                            if (CallChecker.beforeDeref(newDirs, Map.class, 460, 19191, 19197)) {
                                newDirs = CallChecker.beforeCalled(newDirs, Map.class, 460, 19191, 19197);
                                CallChecker.isCalled(newDirs, Map.class, 460, 19191, 19197).putAll(dirs);
                            }
                            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 463, 19310, 19311)) {
                                if (CallChecker.beforeDeref(newDirs, Map.class, 461, 19229, 19235)) {
                                    sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 463, 19310, 19311);
                                    newDirs = CallChecker.beforeCalled(newDirs, Map.class, 461, 19229, 19235);
                                    CallChecker.isCalled(newDirs, Map.class, 461, 19229, 19235).put(Constants.FILTER_DIRECTIVE, CallChecker.isCalled(sf, SimpleFilter.class, 463, 19310, 19311).toString());
                                }
                            }
                            if (CallChecker.beforeDeref(reqList, List.class, 466, 19418, 19424)) {
                                reqList = CallChecker.beforeCalled(reqList, List.class, 466, 19418, 19424);
                                CallChecker.isCalled(reqList, List.class, 466, 19418, 19424).add(new BundleRequirementImpl(owner, BundleRevision.PACKAGE_NAMESPACE, newDirs, Collections.EMPTY_MAP, sf));
                            }
                        }
                    }
                }
            }
            return reqList;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRequirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1657.methodEnd();
        }
    }

    private static List<ParsedHeaderClause> normalizeDynamicImportClauses(Logger logger, List<ParsedHeaderClause> clauses, String mv) throws BundleException {
        MethodContext _bcornu_methode_context1658 = new MethodContext(List.class);
        try {
            CallChecker.varInit(mv, "mv", 479, 19737, 22852);
            CallChecker.varInit(clauses, "clauses", 479, 19737, 22852);
            CallChecker.varInit(logger, "logger", 479, 19737, 22852);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 479, 19737, 22852);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 479, 19737, 22852);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 479, 19737, 22852);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 479, 19737, 22852);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 479, 19737, 22852);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 479, 19737, 22852);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 479, 19737, 22852);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 479, 19737, 22852);
            if (CallChecker.beforeDeref(clauses, List.class, 485, 20086, 20092)) {
                for (ParsedHeaderClause clause : clauses) {
                    if (CallChecker.beforeDeref(mv, String.class, 487, 20122, 20123)) {
                        mv = CallChecker.beforeCalled(mv, String.class, 487, 20122, 20123);
                        if (!(CallChecker.isCalled(mv, String.class, 487, 20122, 20123).equals("2"))) {
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 490, 20244, 20249)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 490, 20244, 20249).m_dirs, Map.class, 490, 20244, 20256)) {
                                    if (!(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 490, 20244, 20249).m_dirs, Map.class, 490, 20244, 20256).isEmpty())) {
                                        throw new BundleException("R3 imports cannot contain directives.");
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 498, 20523, 20528)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 498, 20523, 20528).m_dirs, Map.class, 498, 20523, 20535)) {
                            CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 498, 20523, 20528).m_dirs, Map.class, 498, 20523, 20535).put(Constants.RESOLUTION_DIRECTIVE, FelixConstants.RESOLUTION_DYNAMIC);
                        }
                    }
                    Object v = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 503, 20790, 20795)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 503, 20790, 20795).m_attrs, Map.class, 503, 20790, 20803)) {
                            v = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 503, 20790, 20795).m_attrs, Map.class, 503, 20790, 20803).get(Constants.VERSION_ATTRIBUTE);
                            CallChecker.varAssign(v, "v", 503, 20790, 20795);
                        }
                    }
                    Object sv = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 504, 20863, 20868)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 504, 20863, 20868).m_attrs, Map.class, 504, 20863, 20876)) {
                            sv = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 504, 20863, 20868).m_attrs, Map.class, 504, 20863, 20876).get(Constants.PACKAGE_SPECIFICATION_VERSION);
                            CallChecker.varAssign(sv, "sv", 504, 20863, 20868);
                        }
                    }
                    if ((v != null) && (sv != null)) {
                        v = CallChecker.beforeCalled(v, String.class, 508, 21056, 21056);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(((String) (v)), String.class, 508, 21056, 21056).trim(), String.class, 508, 21046, 21064)) {
                            if (!(CallChecker.isCalled(((String) (v)).trim(), String.class, 508, 21046, 21064).equals(((String) (sv)).trim()))) {
                                throw new IllegalArgumentException("Both version and specification-version are specified, but they are not equal.");
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                    if ((v != null) || (sv != null)) {
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 519, 21504, 21509)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 519, 21504, 21509).m_attrs, Map.class, 519, 21504, 21517)) {
                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 519, 21504, 21509).m_attrs, Map.class, 519, 21504, 21517).remove(Constants.PACKAGE_SPECIFICATION_VERSION);
                            }
                        }
                        if (v == null) {
                            v = sv;
                            CallChecker.varAssign(v, "v", 520, 21584, 21608);
                        }else {
                            v = v;
                            CallChecker.varAssign(v, "v", 520, 21584, 21608);
                        }
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 521, 21626, 21631)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 521, 21626, 21631).m_attrs, Map.class, 521, 21626, 21639)) {
                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 521, 21626, 21631).m_attrs, Map.class, 521, 21626, 21639).put(Constants.VERSION_ATTRIBUTE, VersionRange.parse(v.toString()));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 527, 21867, 21872)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 527, 21867, 21872).m_attrs, Map.class, 527, 21867, 21880)) {
                            v = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 527, 21867, 21872).m_attrs, Map.class, 527, 21867, 21880).get(Constants.BUNDLE_VERSION_ATTRIBUTE);
                            CallChecker.varAssign(v, "v", 527, 21863, 21921);
                        }
                    }
                    if (v != null) {
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 530, 21980, 21985)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 530, 21980, 21985).m_attrs, Map.class, 530, 21980, 21993)) {
                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 530, 21980, 21985).m_attrs, Map.class, 530, 21980, 21993).put(Constants.BUNDLE_VERSION_ATTRIBUTE, VersionRange.parse(v.toString()));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 537, 22276, 22281).m_paths, List.class, 537, 22276, 22289)) {
                        for (String pkgName : CallChecker.isCalled(clause, ParsedHeaderClause.class, 537, 22276, 22281).m_paths) {
                            if (CallChecker.beforeDeref(pkgName, String.class, 539, 22326, 22332)) {
                                if (CallChecker.isCalled(pkgName, String.class, 539, 22326, 22332).startsWith("java.")) {
                                    throw new BundleException(("Dynamically importing java.* packages not allowed: " + pkgName));
                                }else
                                    if (CallChecker.beforeDeref(pkgName, String.class, 544, 22554, 22560)) {
                                        if (CallChecker.beforeDeref(pkgName, String.class, 544, 22577, 22583)) {
                                            if (CallChecker.beforeDeref(pkgName, String.class, 544, 22603, 22609)) {
                                                if (((!(CallChecker.isCalled(pkgName, String.class, 544, 22554, 22560).equals("*"))) && (CallChecker.isCalled(pkgName, String.class, 544, 22577, 22583).endsWith("*"))) && (!(CallChecker.isCalled(pkgName, String.class, 544, 22603, 22609).endsWith(".*")))) {
                                                    throw new BundleException(("Partial package name wild carding is not allowed: " + pkgName));
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }
            }
            return clauses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<ParsedHeaderClause>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1658.methodEnd();
        }
    }

    private static List<ParsedHeaderClause> normalizeRequireCapabilityClauses(Logger logger, List<ParsedHeaderClause> clauses, String mv) throws BundleException {
        MethodContext _bcornu_methode_context1659 = new MethodContext(List.class);
        try {
            CallChecker.varInit(mv, "mv", 555, 22859, 23204);
            CallChecker.varInit(clauses, "clauses", 555, 22859, 23204);
            CallChecker.varInit(logger, "logger", 555, 22859, 23204);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 555, 22859, 23204);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 555, 22859, 23204);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 555, 22859, 23204);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 555, 22859, 23204);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 555, 22859, 23204);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 555, 22859, 23204);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 555, 22859, 23204);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 555, 22859, 23204);
            if (CallChecker.beforeDeref(mv, String.class, 560, 23053, 23054)) {
                if (CallChecker.beforeDeref(clauses, List.class, 560, 23072, 23078)) {
                    mv = CallChecker.beforeCalled(mv, String.class, 560, 23053, 23054);
                    clauses = CallChecker.beforeCalled(clauses, List.class, 560, 23072, 23078);
                    if ((!(CallChecker.isCalled(mv, String.class, 560, 23053, 23054).equals("2"))) && (!(CallChecker.isCalled(clauses, List.class, 560, 23072, 23078).isEmpty()))) {
                    }
                }
            }
            return clauses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<ParsedHeaderClause>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1659.methodEnd();
        }
    }

    private static List<BundleRequirement> convertRequireCapabilities(List<ParsedHeaderClause> clauses, BundleRevision owner) throws BundleException {
        MethodContext _bcornu_methode_context1660 = new MethodContext(List.class);
        try {
            CallChecker.varInit(owner, "owner", 568, 23211, 24745);
            CallChecker.varInit(clauses, "clauses", 568, 23211, 24745);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 568, 23211, 24745);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 568, 23211, 24745);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 568, 23211, 24745);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 568, 23211, 24745);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 568, 23211, 24745);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 568, 23211, 24745);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 568, 23211, 24745);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 568, 23211, 24745);
            List reqList = CallChecker.varInit(new ArrayList(), "reqList", 573, 23452, 23482);
            if (CallChecker.beforeDeref(clauses, List.class, 574, 23525, 23531)) {
                for (ParsedHeaderClause clause : clauses) {
                    TryContext _bcornu_try_context_445 = new TryContext(445, ManifestParser.class, "java.lang.Exception");
                    try {
                        String filterStr = CallChecker.init(String.class);
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 578, 23609, 23614)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 578, 23609, 23614).m_dirs, Map.class, 578, 23609, 23621)) {
                                filterStr = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 578, 23609, 23614).m_dirs, Map.class, 578, 23609, 23621).get(Constants.FILTER_DIRECTIVE);
                                CallChecker.varAssign(filterStr, "filterStr", 578, 23609, 23614);
                            }
                        }
                        SimpleFilter sf = CallChecker.init(SimpleFilter.class);
                        if (filterStr != null) {
                            sf = SimpleFilter.parse(filterStr);
                            CallChecker.varAssign(sf, "sf", 579, 23690, 23835);
                        }else {
                            sf = new SimpleFilter(null, null, SimpleFilter.MATCH_ALL);
                            CallChecker.varAssign(sf, "sf", 579, 23690, 23835);
                        }
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 582, 23873, 23878).m_paths, List.class, 582, 23873, 23886)) {
                            for (String path : CallChecker.isCalled(clause, ParsedHeaderClause.class, 582, 23873, 23878).m_paths) {
                                if (CallChecker.beforeDeref(path, String.class, 584, 23931, 23934)) {
                                    if (CallChecker.isCalled(path, String.class, 584, 23931, 23934).startsWith("osgi.wiring.")) {
                                        throw new BundleException((("Manifest cannot use Require-Capability for '" + path) + "' namespace."));
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 596, 24440, 24445)) {
                                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 597, 24483, 24488)) {
                                        if (CallChecker.beforeDeref(reqList, List.class, 592, 24279, 24285)) {
                                            reqList = CallChecker.beforeCalled(reqList, List.class, 592, 24279, 24285);
                                            CallChecker.isCalled(reqList, List.class, 592, 24279, 24285).add(new BundleRequirementImpl(owner, path, CallChecker.isCalled(clause, ParsedHeaderClause.class, 596, 24440, 24445).m_dirs, CallChecker.isCalled(clause, ParsedHeaderClause.class, 597, 24483, 24488).m_attrs, sf));
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception ex) {
                        _bcornu_try_context_445.catchStart(445);
                        throw new BundleException(("Error creating requirement: " + ex));
                    } finally {
                        _bcornu_try_context_445.finallyStart(445);
                    }
                }
            }
            return reqList;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRequirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1660.methodEnd();
        }
    }

    static List<BundleRequirement> convertNativeCode(BundleRevision owner, List<NativeLibraryClause> nativeLibraryClauses, boolean hasOptionalLibraryDirective) {
        MethodContext _bcornu_methode_context1661 = new MethodContext(List.class);
        try {
            CallChecker.varInit(hasOptionalLibraryDirective, "hasOptionalLibraryDirective", 610, 24756, 28620);
            CallChecker.varInit(nativeLibraryClauses, "nativeLibraryClauses", 610, 24756, 28620);
            CallChecker.varInit(owner, "owner", 610, 24756, 28620);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 610, 24756, 28620);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 610, 24756, 28620);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 610, 24756, 28620);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 610, 24756, 28620);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 610, 24756, 28620);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 610, 24756, 28620);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 610, 24756, 28620);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 610, 24756, 28620);
            List<BundleRequirement> result = CallChecker.varInit(new ArrayList<BundleRequirement>(), "result", 612, 24926, 24993);
            List<SimpleFilter> nativeFilterClauseList = CallChecker.varInit(new ArrayList<SimpleFilter>(), "nativeFilterClauseList", 614, 25012, 25085);
            if (nativeLibraryClauses != null) {
                for (NativeLibraryClause clause : nativeLibraryClauses) {
                    String[] osNameArray = CallChecker.init(String[].class);
                    if (CallChecker.beforeDeref(clause, NativeLibraryClause.class, 620, 25266, 25271)) {
                        osNameArray = CallChecker.isCalled(clause, NativeLibraryClause.class, 620, 25266, 25271).getOSNames();
                        CallChecker.varAssign(osNameArray, "osNameArray", 620, 25266, 25271);
                    }
                    String[] osVersionArray = CallChecker.init(String[].class);
                    if (CallChecker.beforeDeref(clause, NativeLibraryClause.class, 621, 25329, 25334)) {
                        osVersionArray = CallChecker.isCalled(clause, NativeLibraryClause.class, 621, 25329, 25334).getOSVersions();
                        CallChecker.varAssign(osVersionArray, "osVersionArray", 621, 25329, 25334);
                    }
                    String[] processorArray = CallChecker.init(String[].class);
                    if (CallChecker.beforeDeref(clause, NativeLibraryClause.class, 622, 25395, 25400)) {
                        processorArray = CallChecker.isCalled(clause, NativeLibraryClause.class, 622, 25395, 25400).getProcessors();
                        CallChecker.varAssign(processorArray, "processorArray", 622, 25395, 25400);
                    }
                    String[] languageArray = CallChecker.init(String[].class);
                    if (CallChecker.beforeDeref(clause, NativeLibraryClause.class, 623, 25460, 25465)) {
                        languageArray = CallChecker.isCalled(clause, NativeLibraryClause.class, 623, 25460, 25465).getLanguages();
                        CallChecker.varAssign(languageArray, "languageArray", 623, 25460, 25465);
                    }
                    String currentSelectionFilter = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(clause, NativeLibraryClause.class, 625, 25548, 25553)) {
                        currentSelectionFilter = CallChecker.isCalled(clause, NativeLibraryClause.class, 625, 25548, 25553).getSelectionFilter();
                        CallChecker.varAssign(currentSelectionFilter, "currentSelectionFilter", 625, 25548, 25553);
                    }
                    List<SimpleFilter> nativeFilterList = CallChecker.varInit(new ArrayList<SimpleFilter>(), "nativeFilterList", 627, 25610, 25677);
                    if ((osNameArray != null) && ((osNameArray.length) > 0)) {
                        if (CallChecker.beforeDeref(nativeFilterList, List.class, 630, 25783, 25798)) {
                            nativeFilterList = CallChecker.beforeCalled(nativeFilterList, List.class, 630, 25783, 25798);
                            CallChecker.isCalled(nativeFilterList, List.class, 630, 25783, 25798).add(ManifestParser.buildFilterFromArray(NativeNamespace.CAPABILITY_OSNAME_ATTRIBUTE, osNameArray, SimpleFilter.APPROX));
                        }
                    }
                    if ((osVersionArray != null) && ((osVersionArray.length) > 0)) {
                        if (CallChecker.beforeDeref(nativeFilterList, List.class, 635, 26051, 26066)) {
                            nativeFilterList = CallChecker.beforeCalled(nativeFilterList, List.class, 635, 26051, 26066);
                            CallChecker.isCalled(nativeFilterList, List.class, 635, 26051, 26066).add(ManifestParser.buildFilterFromArray(NativeNamespace.CAPABILITY_OSVERSION_ATTRIBUTE, osVersionArray, SimpleFilter.EQ));
                        }
                    }
                    if ((processorArray != null) && ((processorArray.length) > 0)) {
                        if (CallChecker.beforeDeref(nativeFilterList, List.class, 640, 26321, 26336)) {
                            nativeFilterList = CallChecker.beforeCalled(nativeFilterList, List.class, 640, 26321, 26336);
                            CallChecker.isCalled(nativeFilterList, List.class, 640, 26321, 26336).add(ManifestParser.buildFilterFromArray(NativeNamespace.CAPABILITY_PROCESSOR_ATTRIBUTE, processorArray, SimpleFilter.APPROX));
                        }
                    }
                    if ((languageArray != null) && ((languageArray.length) > 0)) {
                        if (CallChecker.beforeDeref(nativeFilterList, List.class, 645, 26577, 26592)) {
                            nativeFilterList = CallChecker.beforeCalled(nativeFilterList, List.class, 645, 26577, 26592);
                            CallChecker.isCalled(nativeFilterList, List.class, 645, 26577, 26592).add(ManifestParser.buildFilterFromArray(NativeNamespace.CAPABILITY_LANGUAGE_ATTRIBUTE, languageArray, SimpleFilter.APPROX));
                        }
                    }
                    if (currentSelectionFilter != null) {
                        if (CallChecker.beforeDeref(nativeFilterList, List.class, 650, 26828, 26843)) {
                            nativeFilterList = CallChecker.beforeCalled(nativeFilterList, List.class, 650, 26828, 26843);
                            CallChecker.isCalled(nativeFilterList, List.class, 650, 26828, 26843).add(SimpleFilter.parse(currentSelectionFilter));
                        }
                    }
                    if (CallChecker.beforeDeref(nativeFilterList, List.class, 653, 26949, 26964)) {
                        nativeFilterList = CallChecker.beforeCalled(nativeFilterList, List.class, 653, 26949, 26964);
                        if (!(CallChecker.isCalled(nativeFilterList, List.class, 653, 26949, 26964).isEmpty())) {
                            SimpleFilter nativeClauseFilter = CallChecker.varInit(new SimpleFilter(null, nativeFilterList, SimpleFilter.AND), "nativeClauseFilter", 655, 27015, 27107);
                            if (CallChecker.beforeDeref(nativeFilterClauseList, List.class, 656, 27129, 27150)) {
                                nativeFilterClauseList = CallChecker.beforeCalled(nativeFilterClauseList, List.class, 656, 27129, 27150);
                                CallChecker.isCalled(nativeFilterClauseList, List.class, 656, 27129, 27150).add(nativeClauseFilter);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                Map<String, String> requirementDirectives = CallChecker.varInit(new HashMap<String, String>(), "requirementDirectives", 660, 27234, 27307);
                SimpleFilter consolidatedNativeFilter = CallChecker.varInit(null, "consolidatedNativeFilter", 662, 27334, 27378);
                if (hasOptionalLibraryDirective) {
                    if (CallChecker.beforeDeref(requirementDirectives, Map.class, 666, 27467, 27487)) {
                        requirementDirectives = CallChecker.beforeCalled(requirementDirectives, Map.class, 666, 27467, 27487);
                        CallChecker.isCalled(requirementDirectives, Map.class, 666, 27467, 27487).put(NativeNamespace.REQUIREMENT_RESOLUTION_DIRECTIVE, NativeNamespace.RESOLUTION_OPTIONAL);
                    }
                }
                if (CallChecker.beforeDeref(nativeFilterClauseList, List.class, 669, 27623, 27644)) {
                    nativeFilterClauseList = CallChecker.beforeCalled(nativeFilterClauseList, List.class, 669, 27623, 27644);
                    if ((CallChecker.isCalled(nativeFilterClauseList, List.class, 669, 27623, 27644).size()) > 1) {
                        consolidatedNativeFilter = new SimpleFilter(null, nativeFilterClauseList, SimpleFilter.OR);
                        CallChecker.varAssign(consolidatedNativeFilter, "consolidatedNativeFilter", 671, 27688, 27778);
                        if (CallChecker.beforeDeref(consolidatedNativeFilter, SimpleFilter.class, 673, 27885, 27908)) {
                            if (CallChecker.beforeDeref(requirementDirectives, Map.class, 673, 27813, 27833)) {
                                consolidatedNativeFilter = CallChecker.beforeCalled(consolidatedNativeFilter, SimpleFilter.class, 673, 27885, 27908);
                                requirementDirectives = CallChecker.beforeCalled(requirementDirectives, Map.class, 673, 27813, 27833);
                                CallChecker.isCalled(requirementDirectives, Map.class, 673, 27813, 27833).put(NativeNamespace.REQUIREMENT_FILTER_DIRECTIVE, CallChecker.isCalled(consolidatedNativeFilter, SimpleFilter.class, 673, 27885, 27908).toString());
                            }
                        }
                    }else
                        if (CallChecker.beforeDeref(nativeFilterClauseList, List.class, 675, 27957, 27978)) {
                            nativeFilterClauseList = CallChecker.beforeCalled(nativeFilterClauseList, List.class, 675, 27957, 27978);
                            if ((CallChecker.isCalled(nativeFilterClauseList, List.class, 675, 27957, 27978).size()) == 1) {
                                if (CallChecker.beforeDeref(nativeFilterClauseList, List.class, 677, 28050, 28071)) {
                                    nativeFilterClauseList = CallChecker.beforeCalled(nativeFilterClauseList, List.class, 677, 28050, 28071);
                                    consolidatedNativeFilter = CallChecker.isCalled(nativeFilterClauseList, List.class, 677, 28050, 28071).get(0);
                                    CallChecker.varAssign(consolidatedNativeFilter, "consolidatedNativeFilter", 677, 28023, 28079);
                                }
                                if (CallChecker.beforeDeref(consolidatedNativeFilter, SimpleFilter.class, 679, 28186, 28209)) {
                                    if (CallChecker.beforeDeref(requirementDirectives, Map.class, 679, 28114, 28134)) {
                                        consolidatedNativeFilter = CallChecker.beforeCalled(consolidatedNativeFilter, SimpleFilter.class, 679, 28186, 28209);
                                        requirementDirectives = CallChecker.beforeCalled(requirementDirectives, Map.class, 679, 28114, 28134);
                                        CallChecker.isCalled(requirementDirectives, Map.class, 679, 28114, 28134).put(NativeNamespace.REQUIREMENT_FILTER_DIRECTIVE, CallChecker.isCalled(consolidatedNativeFilter, SimpleFilter.class, 679, 28186, 28209).toString());
                                    }
                                }
                            }
                        }
                    
                }
                if (CallChecker.beforeDeref(requirementDirectives, Map.class, 682, 28266, 28286)) {
                    requirementDirectives = CallChecker.beforeCalled(requirementDirectives, Map.class, 682, 28266, 28286);
                    if ((CallChecker.isCalled(requirementDirectives, Map.class, 682, 28266, 28286).size()) > 0) {
                        if (CallChecker.beforeDeref(result, List.class, 684, 28330, 28335)) {
                            result = CallChecker.beforeCalled(result, List.class, 684, 28330, 28335);
                            CallChecker.isCalled(result, List.class, 684, 28330, 28335).add(new BundleRequirementImpl(owner, NativeNamespace.NATIVE_NAMESPACE, requirementDirectives, Collections.<String, Object>emptyMap(), consolidatedNativeFilter));
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRequirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1661.methodEnd();
        }
    }

    private static SimpleFilter buildFilterFromArray(String attributeName, String[] stringArray, int operation) {
        MethodContext _bcornu_methode_context1662 = new MethodContext(SimpleFilter.class);
        try {
            CallChecker.varInit(operation, "operation", 694, 28631, 29374);
            CallChecker.varInit(stringArray, "stringArray", 694, 28631, 29374);
            CallChecker.varInit(attributeName, "attributeName", 694, 28631, 29374);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 694, 28631, 29374);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 694, 28631, 29374);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 694, 28631, 29374);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 694, 28631, 29374);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 694, 28631, 29374);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 694, 28631, 29374);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 694, 28631, 29374);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 694, 28631, 29374);
            SimpleFilter result = CallChecker.varInit(null, "result", 696, 28753, 28779);
            List<SimpleFilter> filterSet = CallChecker.varInit(new ArrayList<SimpleFilter>(), "filterSet", 697, 28789, 28849);
            if (stringArray != null) {
                for (String currentValue : stringArray) {
                    if (CallChecker.beforeDeref(currentValue, String.class, 703, 29029, 29040)) {
                        if (CallChecker.beforeDeref(filterSet, List.class, 703, 28983, 28991)) {
                            filterSet = CallChecker.beforeCalled(filterSet, List.class, 703, 28983, 28991);
                            CallChecker.isCalled(filterSet, List.class, 703, 28983, 28991).add(new SimpleFilter(attributeName, CallChecker.isCalled(currentValue, String.class, 703, 29029, 29040).toLowerCase(), operation));
                        }
                    }
                }
                if (CallChecker.beforeDeref(filterSet, List.class, 706, 29112, 29120)) {
                    filterSet = CallChecker.beforeCalled(filterSet, List.class, 706, 29112, 29120);
                    if ((CallChecker.isCalled(filterSet, List.class, 706, 29112, 29120).size()) == 1) {
                        if (CallChecker.beforeDeref(filterSet, List.class, 708, 29174, 29182)) {
                            filterSet = CallChecker.beforeCalled(filterSet, List.class, 708, 29174, 29182);
                            result = CallChecker.isCalled(filterSet, List.class, 708, 29174, 29182).get(0);
                            CallChecker.varAssign(result, "result", 708, 29165, 29190);
                        }
                    }else {
                        result = new SimpleFilter(null, filterSet, SimpleFilter.OR);
                        CallChecker.varAssign(result, "result", 712, 29253, 29312);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SimpleFilter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1662.methodEnd();
        }
    }

    private static void addStringArrayToSet(String[] array, Set<String> set) {
        MethodContext _bcornu_methode_context1663 = new MethodContext(void.class);
        try {
            CallChecker.varInit(set, "set", 719, 29385, 29560);
            CallChecker.varInit(array, "array", 719, 29385, 29560);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 719, 29385, 29560);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 719, 29385, 29560);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 719, 29385, 29560);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 719, 29385, 29560);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 719, 29385, 29560);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 719, 29385, 29560);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 719, 29385, 29560);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 719, 29385, 29560);
            if (array != null) {
                if (CallChecker.beforeDeref(set, Set.class, 723, 29512, 29514)) {
                    set = CallChecker.beforeCalled(set, Set.class, 723, 29512, 29514);
                    CallChecker.isCalled(set, Set.class, 723, 29512, 29514).addAll(Arrays.asList(array));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1663.methodEnd();
        }
    }

    private static List<ParsedHeaderClause> normalizeProvideCapabilityClauses(Logger logger, List<ParsedHeaderClause> clauses, String mv) throws BundleException {
        MethodContext _bcornu_methode_context1664 = new MethodContext(List.class);
        try {
            CallChecker.varInit(mv, "mv", 727, 29567, 33925);
            CallChecker.varInit(clauses, "clauses", 727, 29567, 33925);
            CallChecker.varInit(logger, "logger", 727, 29567, 33925);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 727, 29567, 33925);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 727, 29567, 33925);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 727, 29567, 33925);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 727, 29567, 33925);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 727, 29567, 33925);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 727, 29567, 33925);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 727, 29567, 33925);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 727, 29567, 33925);
            if (CallChecker.beforeDeref(mv, String.class, 732, 29761, 29762)) {
                if (CallChecker.beforeDeref(clauses, List.class, 732, 29780, 29786)) {
                    mv = CallChecker.beforeCalled(mv, String.class, 732, 29761, 29762);
                    clauses = CallChecker.beforeCalled(clauses, List.class, 732, 29780, 29786);
                    if ((!(CallChecker.isCalled(mv, String.class, 732, 29761, 29762).equals("2"))) && (!(CallChecker.isCalled(clauses, List.class, 732, 29780, 29786).isEmpty()))) {
                    }
                }
            }
            if (CallChecker.beforeDeref(clauses, List.class, 738, 29977, 29983)) {
                for (ParsedHeaderClause clause : clauses) {
                    for (Map.Entry<String, String> entry : CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 740, 30043, 30048).m_types, Map.class, 740, 30043, 30056).entrySet()) {
                        String type = CallChecker.init(String.class);
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 742, 30114, 30118)) {
                            type = CallChecker.isCalled(entry, Map.Entry.class, 742, 30114, 30118).getValue();
                            CallChecker.varAssign(type, "type", 742, 30114, 30118);
                        }
                        if (CallChecker.beforeDeref(type, String.class, 743, 30153, 30156)) {
                            type = CallChecker.beforeCalled(type, String.class, 743, 30153, 30156);
                            if (!(CallChecker.isCalled(type, String.class, 743, 30153, 30156).equals("String"))) {
                                if (CallChecker.beforeDeref(type, String.class, 745, 30218, 30221)) {
                                    type = CallChecker.beforeCalled(type, String.class, 745, 30218, 30221);
                                    if (CallChecker.isCalled(type, String.class, 745, 30218, 30221).equals("Double")) {
                                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 747, 30287, 30292)) {
                                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 748, 30335, 30339)) {
                                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 749, 30390, 30395)) {
                                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 749, 30409, 30413)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 749, 30390, 30395).m_attrs, Map.class, 749, 30390, 30403)) {
                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 749, 30390, 30395).m_attrs, Map.class, 749, 30390, 30403).get(CallChecker.isCalled(entry, Map.Entry.class, 749, 30409, 30413).getKey()), Object.class, 749, 30390, 30423)) {
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 749, 30390, 30395).m_attrs, Map.class, 749, 30390, 30403).get(CallChecker.isCalled(entry, Map.Entry.class, 749, 30409, 30413).getKey()), Object.class, 749, 30390, 30423).toString(), String.class, 749, 30390, 30434)) {
                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 747, 30287, 30292).m_attrs, Map.class, 747, 30287, 30300)) {
                                                                        CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 747, 30287, 30292).m_attrs, Map.class, 747, 30287, 30300).put(CallChecker.isCalled(entry, Map.Entry.class, 748, 30335, 30339).getKey(), new Double(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 749, 30390, 30395).m_attrs, Map.class, 749, 30390, 30403).get(CallChecker.isCalled(entry, Map.Entry.class, 749, 30409, 30413).getKey()), Object.class, 749, 30390, 30423).toString(), String.class, 749, 30390, 30434).trim()));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else
                                        if (CallChecker.beforeDeref(type, String.class, 751, 30497, 30500)) {
                                            type = CallChecker.beforeCalled(type, String.class, 751, 30497, 30500);
                                            if (CallChecker.isCalled(type, String.class, 751, 30497, 30500).equals("Version")) {
                                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 753, 30567, 30572)) {
                                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 754, 30615, 30619)) {
                                                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 755, 30671, 30676)) {
                                                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 755, 30690, 30694)) {
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 755, 30671, 30676).m_attrs, Map.class, 755, 30671, 30684)) {
                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 755, 30671, 30676).m_attrs, Map.class, 755, 30671, 30684).get(CallChecker.isCalled(entry, Map.Entry.class, 755, 30690, 30694).getKey()), Object.class, 755, 30671, 30704)) {
                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 755, 30671, 30676).m_attrs, Map.class, 755, 30671, 30684).get(CallChecker.isCalled(entry, Map.Entry.class, 755, 30690, 30694).getKey()), Object.class, 755, 30671, 30704).toString(), String.class, 755, 30671, 30715)) {
                                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 753, 30567, 30572).m_attrs, Map.class, 753, 30567, 30580)) {
                                                                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 753, 30567, 30572).m_attrs, Map.class, 753, 30567, 30580).put(CallChecker.isCalled(entry, Map.Entry.class, 754, 30615, 30619).getKey(), new Version(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 755, 30671, 30676).m_attrs, Map.class, 755, 30671, 30684).get(CallChecker.isCalled(entry, Map.Entry.class, 755, 30690, 30694).getKey()), Object.class, 755, 30671, 30704).toString(), String.class, 755, 30671, 30715).trim()));
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }else
                                                if (CallChecker.beforeDeref(type, String.class, 757, 30778, 30781)) {
                                                    type = CallChecker.beforeCalled(type, String.class, 757, 30778, 30781);
                                                    if (CallChecker.isCalled(type, String.class, 757, 30778, 30781).equals("Long")) {
                                                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 759, 30845, 30850)) {
                                                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 760, 30893, 30897)) {
                                                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 761, 30946, 30951)) {
                                                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 761, 30965, 30969)) {
                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 761, 30946, 30951).m_attrs, Map.class, 761, 30946, 30959)) {
                                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 761, 30946, 30951).m_attrs, Map.class, 761, 30946, 30959).get(CallChecker.isCalled(entry, Map.Entry.class, 761, 30965, 30969).getKey()), Object.class, 761, 30946, 30979)) {
                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 761, 30946, 30951).m_attrs, Map.class, 761, 30946, 30959).get(CallChecker.isCalled(entry, Map.Entry.class, 761, 30965, 30969).getKey()), Object.class, 761, 30946, 30979).toString(), String.class, 761, 30946, 30990)) {
                                                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 759, 30845, 30850).m_attrs, Map.class, 759, 30845, 30858)) {
                                                                                        CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 759, 30845, 30850).m_attrs, Map.class, 759, 30845, 30858).put(CallChecker.isCalled(entry, Map.Entry.class, 760, 30893, 30897).getKey(), new Long(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 761, 30946, 30951).m_attrs, Map.class, 761, 30946, 30959).get(CallChecker.isCalled(entry, Map.Entry.class, 761, 30965, 30969).getKey()), Object.class, 761, 30946, 30979).toString(), String.class, 761, 30946, 30990).trim()));
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }else
                                                        if (CallChecker.beforeDeref(type, String.class, 763, 31053, 31056)) {
                                                            type = CallChecker.beforeCalled(type, String.class, 763, 31053, 31056);
                                                            if (CallChecker.isCalled(type, String.class, 763, 31053, 31056).startsWith("List")) {
                                                                int startIdx = CallChecker.init(int.class);
                                                                if (CallChecker.beforeDeref(type, String.class, 765, 31139, 31142)) {
                                                                    type = CallChecker.beforeCalled(type, String.class, 765, 31139, 31142);
                                                                    startIdx = CallChecker.isCalled(type, String.class, 765, 31139, 31142).indexOf('<');
                                                                    CallChecker.varAssign(startIdx, "startIdx", 765, 31139, 31142);
                                                                }
                                                                int endIdx = CallChecker.init(int.class);
                                                                if (CallChecker.beforeDeref(type, String.class, 766, 31195, 31198)) {
                                                                    type = CallChecker.beforeCalled(type, String.class, 766, 31195, 31198);
                                                                    endIdx = CallChecker.isCalled(type, String.class, 766, 31195, 31198).indexOf('>');
                                                                    CallChecker.varAssign(endIdx, "endIdx", 766, 31195, 31198);
                                                                }
                                                                if (((startIdx > 0) && (endIdx <= startIdx)) || ((startIdx < 0) && (endIdx > 0))) {
                                                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 772, 31550, 31554)) {
                                                                        throw new BundleException(((("Invalid Provide-Capability attribute list type for '" + (CallChecker.isCalled(entry, Map.Entry.class, 772, 31550, 31554).getKey())) + "' : ") + type));
                                                                    }else
                                                                        throw new AbnormalExecutionError();
                                                                    
                                                                }
                                                                String listType = CallChecker.varInit("String", "listType", 777, 31698, 31724);
                                                                if (endIdx > startIdx) {
                                                                    if (CallChecker.beforeDeref(type, String.class, 780, 31838, 31841)) {
                                                                        type = CallChecker.beforeCalled(type, String.class, 780, 31838, 31841);
                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(type, String.class, 780, 31838, 31841).substring((startIdx + 1), endIdx), String.class, 780, 31838, 31873)) {
                                                                            type = CallChecker.beforeCalled(type, String.class, 780, 31838, 31841);
                                                                            listType = CallChecker.isCalled(CallChecker.isCalled(type, String.class, 780, 31838, 31841).substring((startIdx + 1), endIdx), String.class, 780, 31838, 31873).trim();
                                                                            CallChecker.varAssign(listType, "listType", 780, 31827, 31881);
                                                                        }
                                                                    }
                                                                }
                                                                List<String> tokens = CallChecker.init(List.class);
                                                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 784, 32006, 32011)) {
                                                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 784, 32025, 32029)) {
                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 784, 32006, 32011).m_attrs, Map.class, 784, 32006, 32019)) {
                                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 784, 32006, 32011).m_attrs, Map.class, 784, 32006, 32019).get(CallChecker.isCalled(entry, Map.Entry.class, 784, 32025, 32029).getKey()), Object.class, 784, 32006, 32039)) {
                                                                                tokens = ManifestParser.parseDelimitedString(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 784, 32006, 32011).m_attrs, Map.class, 784, 32006, 32019).get(CallChecker.isCalled(entry, Map.Entry.class, 784, 32025, 32029).getKey()), Object.class, 784, 32006, 32039).toString(), ",", false);
                                                                                CallChecker.varAssign(tokens, "tokens", 784, 32006, 32011);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                List<Object> values = CallChecker.init(List.class);
                                                                if (CallChecker.beforeDeref(tokens, List.class, 785, 32134, 32139)) {
                                                                    tokens = CallChecker.beforeCalled(tokens, List.class, 785, 32134, 32139);
                                                                    values = new ArrayList<Object>(CallChecker.isCalled(tokens, List.class, 785, 32134, 32139).size());
                                                                    CallChecker.varAssign(values, "values", 785, 32134, 32139);
                                                                }
                                                                if (CallChecker.beforeDeref(tokens, List.class, 786, 32194, 32199)) {
                                                                    for (String token : tokens) {
                                                                        if (CallChecker.beforeDeref(listType, String.class, 788, 32260, 32267)) {
                                                                            listType = CallChecker.beforeCalled(listType, String.class, 788, 32260, 32267);
                                                                            if (CallChecker.isCalled(listType, String.class, 788, 32260, 32267).equals("String")) {
                                                                                if (CallChecker.beforeDeref(values, List.class, 790, 32349, 32354)) {
                                                                                    values = CallChecker.beforeCalled(values, List.class, 790, 32349, 32354);
                                                                                    CallChecker.isCalled(values, List.class, 790, 32349, 32354).add(token);
                                                                                }
                                                                            }else
                                                                                if (CallChecker.beforeDeref(listType, String.class, 792, 32435, 32442)) {
                                                                                    listType = CallChecker.beforeCalled(listType, String.class, 792, 32435, 32442);
                                                                                    if (CallChecker.isCalled(listType, String.class, 792, 32435, 32442).equals("Double")) {
                                                                                        if (CallChecker.beforeDeref(token, String.class, 794, 32546, 32550)) {
                                                                                            if (CallChecker.beforeDeref(values, List.class, 794, 32524, 32529)) {
                                                                                                values = CallChecker.beforeCalled(values, List.class, 794, 32524, 32529);
                                                                                                CallChecker.isCalled(values, List.class, 794, 32524, 32529).add(new Double(CallChecker.isCalled(token, String.class, 794, 32546, 32550).trim()));
                                                                                            }
                                                                                        }
                                                                                    }else
                                                                                        if (CallChecker.beforeDeref(listType, String.class, 796, 32629, 32636)) {
                                                                                            listType = CallChecker.beforeCalled(listType, String.class, 796, 32629, 32636);
                                                                                            if (CallChecker.isCalled(listType, String.class, 796, 32629, 32636).equals("Version")) {
                                                                                                if (CallChecker.beforeDeref(token, String.class, 798, 32742, 32746)) {
                                                                                                    if (CallChecker.beforeDeref(values, List.class, 798, 32719, 32724)) {
                                                                                                        values = CallChecker.beforeCalled(values, List.class, 798, 32719, 32724);
                                                                                                        CallChecker.isCalled(values, List.class, 798, 32719, 32724).add(new Version(CallChecker.isCalled(token, String.class, 798, 32742, 32746).trim()));
                                                                                                    }
                                                                                                }
                                                                                            }else
                                                                                                if (CallChecker.beforeDeref(listType, String.class, 800, 32825, 32832)) {
                                                                                                    listType = CallChecker.beforeCalled(listType, String.class, 800, 32825, 32832);
                                                                                                    if (CallChecker.isCalled(listType, String.class, 800, 32825, 32832).equals("Long")) {
                                                                                                        if (CallChecker.beforeDeref(token, String.class, 802, 32932, 32936)) {
                                                                                                            if (CallChecker.beforeDeref(values, List.class, 802, 32912, 32917)) {
                                                                                                                values = CallChecker.beforeCalled(values, List.class, 802, 32912, 32917);
                                                                                                                CallChecker.isCalled(values, List.class, 802, 32912, 32917).add(new Long(CallChecker.isCalled(token, String.class, 802, 32932, 32936).trim()));
                                                                                                            }
                                                                                                        }
                                                                                                    }else {
                                                                                                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 808, 33229, 33233)) {
                                                                                                            throw new BundleException(((("Unknown Provide-Capability attribute list type for '" + (CallChecker.isCalled(entry, Map.Entry.class, 808, 33229, 33233).getKey())) + "' : ") + type));
                                                                                                        }else
                                                                                                            throw new AbnormalExecutionError();
                                                                                                        
                                                                                                    }
                                                                                                }else
                                                                                                    throw new AbnormalExecutionError();
                                                                                                
                                                                                            
                                                                                        }else
                                                                                            throw new AbnormalExecutionError();
                                                                                        
                                                                                    
                                                                                }else
                                                                                    throw new AbnormalExecutionError();
                                                                                
                                                                            
                                                                        }else
                                                                            throw new AbnormalExecutionError();
                                                                        
                                                                    }
                                                                }
                                                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 813, 33414, 33419)) {
                                                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 814, 33462, 33466)) {
                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 813, 33414, 33419).m_attrs, Map.class, 813, 33414, 33427)) {
                                                                            CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 813, 33414, 33419).m_attrs, Map.class, 813, 33414, 33427).put(CallChecker.isCalled(entry, Map.Entry.class, 814, 33462, 33466).getKey(), values);
                                                                        }
                                                                    }
                                                                }
                                                            }else {
                                                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 821, 33743, 33747)) {
                                                                    throw new BundleException(((("Unknown Provide-Capability attribute type for '" + (CallChecker.isCalled(entry, Map.Entry.class, 821, 33743, 33747).getKey())) + "' : ") + type));
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            return clauses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<ParsedHeaderClause>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1664.methodEnd();
        }
    }

    private static List<BundleCapability> convertProvideCapabilities(List<ParsedHeaderClause> clauses, BundleRevision owner) throws BundleException {
        MethodContext _bcornu_methode_context1665 = new MethodContext(List.class);
        try {
            CallChecker.varInit(owner, "owner", 832, 33932, 35336);
            CallChecker.varInit(clauses, "clauses", 832, 33932, 35336);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 832, 33932, 35336);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 832, 33932, 35336);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 832, 33932, 35336);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 832, 33932, 35336);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 832, 33932, 35336);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 832, 33932, 35336);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 832, 33932, 35336);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 832, 33932, 35336);
            List<BundleCapability> capList = CallChecker.varInit(new ArrayList(), "capList", 836, 34107, 34155);
            if (CallChecker.beforeDeref(clauses, List.class, 837, 34198, 34204)) {
                for (ParsedHeaderClause clause : clauses) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 839, 34248, 34253).m_paths, List.class, 839, 34248, 34261)) {
                        for (String path : CallChecker.isCalled(clause, ParsedHeaderClause.class, 839, 34248, 34253).m_paths) {
                            if (CallChecker.beforeDeref(path, String.class, 841, 34298, 34301)) {
                                if (CallChecker.isCalled(path, String.class, 841, 34298, 34301).startsWith("osgi.wiring.")) {
                                    throw new BundleException((("Manifest cannot use Provide-Capability for '" + path) + "' namespace."));
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(path, String.class, 848, 34570, 34573)) {
                                if (CallChecker.beforeDeref(FelixConstants.SYSTEM_BUNDLE_SYMBOLICNAME, String.class, 849, 34666, 34706)) {
                                    if ((CallChecker.isCalled(path, String.class, 848, 34570, 34573).startsWith(NativeNamespace.NATIVE_NAMESPACE)) && ((owner == null) || (!(CallChecker.isCalled(FelixConstants.SYSTEM_BUNDLE_SYMBOLICNAME, String.class, 849, 34666, 34706).equals(owner.getSymbolicName()))))) {
                                        throw new BundleException((("Only System Bundle can use Provide-Capability for '" + path) + "' namespace."), BundleException.MANIFEST_ERROR);
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 861, 35226, 35231)) {
                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 862, 35265, 35270)) {
                                    if (CallChecker.beforeDeref(capList, List.class, 857, 35082, 35088)) {
                                        capList = CallChecker.beforeCalled(capList, List.class, 857, 35082, 35088);
                                        CallChecker.isCalled(capList, List.class, 857, 35082, 35088).add(new BundleCapabilityImpl(owner, path, CallChecker.isCalled(clause, ParsedHeaderClause.class, 861, 35226, 35231).m_dirs, CallChecker.isCalled(clause, ParsedHeaderClause.class, 862, 35265, 35270).m_attrs));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return capList;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1665.methodEnd();
        }
    }

    private static List<ParsedHeaderClause> normalizeExportClauses(Logger logger, List<ParsedHeaderClause> clauses, String mv, String bsn, Version bv) throws BundleException {
        MethodContext _bcornu_methode_context1666 = new MethodContext(List.class);
        try {
            CallChecker.varInit(bv, "bv", 869, 35343, 40975);
            CallChecker.varInit(bsn, "bsn", 869, 35343, 40975);
            CallChecker.varInit(mv, "mv", 869, 35343, 40975);
            CallChecker.varInit(clauses, "clauses", 869, 35343, 40975);
            CallChecker.varInit(logger, "logger", 869, 35343, 40975);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 869, 35343, 40975);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 869, 35343, 40975);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 869, 35343, 40975);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 869, 35343, 40975);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 869, 35343, 40975);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 869, 35343, 40975);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 869, 35343, 40975);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 869, 35343, 40975);
            if (CallChecker.beforeDeref(clauses, List.class, 875, 35644, 35650)) {
                for (ParsedHeaderClause clause : clauses) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 878, 35773, 35778).m_paths, List.class, 878, 35773, 35786)) {
                        for (String pkgName : CallChecker.isCalled(clause, ParsedHeaderClause.class, 878, 35773, 35778).m_paths) {
                            if (CallChecker.beforeDeref(pkgName, String.class, 881, 35888, 35894)) {
                                if (CallChecker.isCalled(pkgName, String.class, 881, 35888, 35894).startsWith("java.")) {
                                    throw new BundleException(("Exporting java.* packages not allowed: " + pkgName));
                                }else
                                    if (CallChecker.beforeDeref(pkgName, String.class, 891, 36429, 36435)) {
                                        if (CallChecker.isCalled(pkgName, String.class, 891, 36429, 36435).equals(".")) {
                                            throw new BundleException("Exporing '.' is invalid.");
                                        }else
                                            if (CallChecker.beforeDeref(pkgName, String.class, 896, 36645, 36651)) {
                                                if ((CallChecker.isCalled(pkgName, String.class, 896, 36645, 36651).length()) == 0) {
                                                    throw new BundleException("Exported package names cannot be zero length.");
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                    Object v = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 905, 37004, 37009)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 905, 37004, 37009).m_attrs, Map.class, 905, 37004, 37017)) {
                            v = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 905, 37004, 37009).m_attrs, Map.class, 905, 37004, 37017).get(Constants.VERSION_ATTRIBUTE);
                            CallChecker.varAssign(v, "v", 905, 37004, 37009);
                        }
                    }
                    Object sv = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 906, 37077, 37082)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 906, 37077, 37082).m_attrs, Map.class, 906, 37077, 37090)) {
                            sv = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 906, 37077, 37082).m_attrs, Map.class, 906, 37077, 37090).get(Constants.PACKAGE_SPECIFICATION_VERSION);
                            CallChecker.varAssign(sv, "sv", 906, 37077, 37082);
                        }
                    }
                    if ((v != null) && (sv != null)) {
                        v = CallChecker.beforeCalled(v, String.class, 910, 37270, 37270);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(((String) (v)), String.class, 910, 37270, 37270).trim(), String.class, 910, 37260, 37278)) {
                            if (!(CallChecker.isCalled(((String) (v)).trim(), String.class, 910, 37260, 37278).equals(((String) (sv)).trim()))) {
                                throw new IllegalArgumentException("Both version and specification-version are specified, but they are not equal.");
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                    if ((v == null) && (sv == null)) {
                        v = Version.emptyVersion;
                        CallChecker.varAssign(v, "v", 920, 37662, 37686);
                    }
                    if ((v != null) || (sv != null)) {
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 928, 37959, 37964)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 928, 37959, 37964).m_attrs, Map.class, 928, 37959, 37972)) {
                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 928, 37959, 37964).m_attrs, Map.class, 928, 37959, 37972).remove(Constants.PACKAGE_SPECIFICATION_VERSION);
                            }
                        }
                        if (v == null) {
                            v = sv;
                            CallChecker.varAssign(v, "v", 929, 38039, 38063);
                        }else {
                            v = v;
                            CallChecker.varAssign(v, "v", 929, 38039, 38063);
                        }
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 930, 38081, 38086)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 930, 38081, 38086).m_attrs, Map.class, 930, 38081, 38094)) {
                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 930, 38081, 38086).m_attrs, Map.class, 930, 38081, 38094).put(Constants.VERSION_ATTRIBUTE, Version.parseVersion(v.toString()));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(mv, String.class, 937, 38378, 38379)) {
                        mv = CallChecker.beforeCalled(mv, String.class, 937, 38378, 38379);
                        if (CallChecker.isCalled(mv, String.class, 937, 38378, 38379).equals("2")) {
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 940, 38501, 38506)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 940, 38501, 38506).m_attrs, Map.class, 940, 38501, 38514)) {
                                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 941, 38587, 38592)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 941, 38587, 38592).m_attrs, Map.class, 941, 38587, 38600)) {
                                            if ((CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 940, 38501, 38506).m_attrs, Map.class, 940, 38501, 38514).containsKey(Constants.BUNDLE_VERSION_ATTRIBUTE)) || (CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 941, 38587, 38592).m_attrs, Map.class, 941, 38587, 38600).containsKey(Constants.BUNDLE_SYMBOLICNAME_ATTRIBUTE))) {
                                                throw new BundleException("Exports must not specify bundle symbolic name or bundle version.");
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 949, 39023, 39028)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 949, 39023, 39028).m_attrs, Map.class, 949, 39023, 39036)) {
                                    CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 949, 39023, 39028).m_attrs, Map.class, 949, 39023, 39036).put(Constants.BUNDLE_SYMBOLICNAME_ATTRIBUTE, bsn);
                                }
                            }
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 950, 39105, 39110)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 950, 39105, 39110).m_attrs, Map.class, 950, 39105, 39118)) {
                                    CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 950, 39105, 39110).m_attrs, Map.class, 950, 39105, 39118).put(Constants.BUNDLE_VERSION_ATTRIBUTE, bv);
                                }
                            }
                        }else
                            if (CallChecker.beforeDeref(mv, String.class, 952, 39201, 39202)) {
                                mv = CallChecker.beforeCalled(mv, String.class, 952, 39201, 39202);
                                if (!(CallChecker.isCalled(mv, String.class, 952, 39201, 39202).equals("2"))) {
                                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 955, 39323, 39328)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 955, 39323, 39328).m_dirs, Map.class, 955, 39323, 39335)) {
                                            if (!(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 955, 39323, 39328).m_dirs, Map.class, 955, 39323, 39335).isEmpty())) {
                                                throw new BundleException("R3 exports cannot contain directives.");
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 965, 39862, 39867)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 965, 39862, 39867).m_attrs, Map.class, 965, 39862, 39875)) {
                                            if (!(CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 965, 39862, 39867).m_attrs, Map.class, 965, 39862, 39875).isEmpty())) {
                                                Object pkgVersion = CallChecker.init(Object.class);
                                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 968, 40031, 40036)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 968, 40031, 40036).m_attrs, Map.class, 968, 40031, 40044)) {
                                                        pkgVersion = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 968, 40031, 40036).m_attrs, Map.class, 968, 40031, 40044).get(BundleCapabilityImpl.VERSION_ATTR);
                                                        CallChecker.varAssign(pkgVersion, "pkgVersion", 968, 40031, 40036);
                                                    }
                                                }
                                                if (pkgVersion == null) {
                                                    pkgVersion = Version.emptyVersion;
                                                    CallChecker.varAssign(pkgVersion, "pkgVersion", 969, 40106, 40223);
                                                }else {
                                                    pkgVersion = pkgVersion;
                                                    CallChecker.varAssign(pkgVersion, "pkgVersion", 969, 40106, 40223);
                                                }
                                                for (Map.Entry<String, Object> entry : CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 972, 40280, 40285).m_attrs, Map.class, 972, 40280, 40293).entrySet()) {
                                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 974, 40358, 40362)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 974, 40358, 40362).getKey(), String.class, 974, 40358, 40371)) {
                                                            if (!(CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 974, 40358, 40362).getKey(), String.class, 974, 40358, 40371).equals(BundleCapabilityImpl.VERSION_ATTR))) {
                                                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 979, 40632, 40636)) {
                                                                    if (CallChecker.beforeDeref(logger, Logger.class, 976, 40470, 40475)) {
                                                                        logger = CallChecker.beforeCalled(logger, Logger.class, 976, 40470, 40475);
                                                                        CallChecker.isCalled(logger, Logger.class, 976, 40470, 40475).log(Logger.LOG_WARNING, ("Unknown R3 export attribute: " + (CallChecker.isCalled(entry, Map.Entry.class, 979, 40632, 40636).getKey())));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 984, 40793, 40798)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 984, 40793, 40798).m_attrs, Map.class, 984, 40793, 40806)) {
                                                        CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 984, 40793, 40798).m_attrs, Map.class, 984, 40793, 40806).clear();
                                                    }
                                                }
                                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 985, 40837, 40842)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 985, 40837, 40842).m_attrs, Map.class, 985, 40837, 40850)) {
                                                        CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 985, 40837, 40842).m_attrs, Map.class, 985, 40837, 40850).put(BundleCapabilityImpl.VERSION_ATTR, pkgVersion);
                                                    }
                                                }
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return clauses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<ParsedHeaderClause>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1666.methodEnd();
        }
    }

    private static List<BundleCapability> convertExports(List<ParsedHeaderClause> clauses, BundleRevision owner) {
        MethodContext _bcornu_methode_context1667 = new MethodContext(List.class);
        try {
            CallChecker.varInit(owner, "owner", 993, 40982, 42034);
            CallChecker.varInit(clauses, "clauses", 993, 40982, 42034);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 993, 40982, 42034);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 993, 40982, 42034);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 993, 40982, 42034);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 993, 40982, 42034);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 993, 40982, 42034);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 993, 40982, 42034);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 993, 40982, 42034);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 993, 40982, 42034);
            List<BundleCapability> capList = CallChecker.varInit(new ArrayList(), "capList", 996, 41114, 41162);
            if (CallChecker.beforeDeref(clauses, List.class, 997, 41205, 41211)) {
                for (ParsedHeaderClause clause : clauses) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 999, 41258, 41263).m_paths, List.class, 999, 41258, 41271)) {
                        for (String pkgName : CallChecker.isCalled(clause, ParsedHeaderClause.class, 999, 41258, 41263).m_paths) {
                            Map<String, Object> attrs = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1002, 41404, 41409)) {
                                attrs = CallChecker.isCalled(clause, ParsedHeaderClause.class, 1002, 41404, 41409).m_attrs;
                                CallChecker.varAssign(attrs, "attrs", 1002, 41404, 41409);
                            }
                            Map<String, Object> newAttrs = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(attrs, Map.class, 1003, 41495, 41499)) {
                                attrs = CallChecker.beforeCalled(attrs, Map.class, 1003, 41495, 41499);
                                newAttrs = new HashMap<String, Object>(((CallChecker.isCalled(attrs, Map.class, 1003, 41495, 41499).size()) + 1));
                                CallChecker.varAssign(newAttrs, "newAttrs", 1003, 41495, 41499);
                            }
                            if (CallChecker.beforeDeref(newAttrs, Map.class, 1004, 41530, 41537)) {
                                newAttrs = CallChecker.beforeCalled(newAttrs, Map.class, 1004, 41530, 41537);
                                CallChecker.isCalled(newAttrs, Map.class, 1004, 41530, 41537).putAll(attrs);
                            }
                            if (CallChecker.beforeDeref(newAttrs, Map.class, 1005, 41570, 41577)) {
                                newAttrs = CallChecker.beforeCalled(newAttrs, Map.class, 1005, 41570, 41577);
                                CallChecker.isCalled(newAttrs, Map.class, 1005, 41570, 41577).put(BundleRevision.PACKAGE_NAMESPACE, pkgName);
                            }
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1014, 41930, 41935)) {
                                if (CallChecker.beforeDeref(capList, List.class, 1010, 41758, 41764)) {
                                    capList = CallChecker.beforeCalled(capList, List.class, 1010, 41758, 41764);
                                    CallChecker.isCalled(capList, List.class, 1010, 41758, 41764).add(new BundleCapabilityImpl(owner, BundleRevision.PACKAGE_NAMESPACE, CallChecker.isCalled(clause, ParsedHeaderClause.class, 1014, 41930, 41935).m_dirs, newAttrs));
                                }
                            }
                        }
                    }
                }
            }
            return capList;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1667.methodEnd();
        }
    }

    public String getManifestVersion() {
        MethodContext _bcornu_methode_context1668 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1022, 42041, 42218);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1022, 42041, 42218);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1022, 42041, 42218);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1022, 42041, 42218);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1022, 42041, 42218);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1022, 42041, 42218);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1022, 42041, 42218);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1022, 42041, 42218);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1022, 42041, 42218);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1022, 42041, 42218);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1022, 42041, 42218);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1022, 42041, 42218);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1022, 42041, 42218);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1022, 42041, 42218);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1022, 42041, 42218);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1022, 42041, 42218);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1022, 42041, 42218);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1022, 42041, 42218);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1022, 42041, 42218);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1022, 42041, 42218);
            CallChecker.varInit(this.m_logger, "m_logger", 1022, 42041, 42218);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1022, 42041, 42218);
            String manifestVersion = CallChecker.varInit(ManifestParser.getManifestVersion(m_headerMap), "manifestVersion", 1024, 42090, 42146);
            if (manifestVersion == null) {
                return "1";
            }else {
                return manifestVersion;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1668.methodEnd();
        }
    }

    private static String getManifestVersion(Map headerMap) {
        MethodContext _bcornu_methode_context1669 = new MethodContext(String.class);
        try {
            CallChecker.varInit(headerMap, "headerMap", 1028, 42225, 42456);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1028, 42225, 42456);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1028, 42225, 42456);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1028, 42225, 42456);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1028, 42225, 42456);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1028, 42225, 42456);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1028, 42225, 42456);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1028, 42225, 42456);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1028, 42225, 42456);
            String manifestVersion = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 1030, 42329, 42337)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1030, 42329, 42337);
                manifestVersion = ((String) (CallChecker.isCalled(headerMap, Map.class, 1030, 42329, 42337).get(Constants.BUNDLE_MANIFESTVERSION)));
                CallChecker.varAssign(manifestVersion, "manifestVersion", 1030, 42329, 42337);
            }
            if (manifestVersion == null) {
                return null;
            }else {
                return manifestVersion.trim();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1669.methodEnd();
        }
    }

    public int getActivationPolicy() {
        MethodContext _bcornu_methode_context1670 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1034, 42463, 42541);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1034, 42463, 42541);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1034, 42463, 42541);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1034, 42463, 42541);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1034, 42463, 42541);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1034, 42463, 42541);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1034, 42463, 42541);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1034, 42463, 42541);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1034, 42463, 42541);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1034, 42463, 42541);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1034, 42463, 42541);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1034, 42463, 42541);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1034, 42463, 42541);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1034, 42463, 42541);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1034, 42463, 42541);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1034, 42463, 42541);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1034, 42463, 42541);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1034, 42463, 42541);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1034, 42463, 42541);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1034, 42463, 42541);
            CallChecker.varInit(this.m_logger, "m_logger", 1034, 42463, 42541);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1034, 42463, 42541);
            return m_activationPolicy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1670.methodEnd();
        }
    }

    public String getActivationIncludeDirective() {
        MethodContext _bcornu_methode_context1671 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1039, 42548, 42643);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1039, 42548, 42643);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1039, 42548, 42643);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1039, 42548, 42643);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1039, 42548, 42643);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1039, 42548, 42643);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1039, 42548, 42643);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1039, 42548, 42643);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1039, 42548, 42643);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1039, 42548, 42643);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1039, 42548, 42643);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1039, 42548, 42643);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1039, 42548, 42643);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1039, 42548, 42643);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1039, 42548, 42643);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1039, 42548, 42643);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1039, 42548, 42643);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1039, 42548, 42643);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1039, 42548, 42643);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1039, 42548, 42643);
            CallChecker.varInit(this.m_logger, "m_logger", 1039, 42548, 42643);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1039, 42548, 42643);
            return m_activationIncludeDir;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1671.methodEnd();
        }
    }

    public String getActivationExcludeDirective() {
        MethodContext _bcornu_methode_context1672 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1044, 42650, 42745);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1044, 42650, 42745);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1044, 42650, 42745);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1044, 42650, 42745);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1044, 42650, 42745);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1044, 42650, 42745);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1044, 42650, 42745);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1044, 42650, 42745);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1044, 42650, 42745);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1044, 42650, 42745);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1044, 42650, 42745);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1044, 42650, 42745);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1044, 42650, 42745);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1044, 42650, 42745);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1044, 42650, 42745);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1044, 42650, 42745);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1044, 42650, 42745);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1044, 42650, 42745);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1044, 42650, 42745);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1044, 42650, 42745);
            CallChecker.varInit(this.m_logger, "m_logger", 1044, 42650, 42745);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1044, 42650, 42745);
            return m_activationExcludeDir;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1672.methodEnd();
        }
    }

    public boolean isExtension() {
        MethodContext _bcornu_methode_context1673 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1049, 42752, 42821);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1049, 42752, 42821);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1049, 42752, 42821);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1049, 42752, 42821);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1049, 42752, 42821);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1049, 42752, 42821);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1049, 42752, 42821);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1049, 42752, 42821);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1049, 42752, 42821);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1049, 42752, 42821);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1049, 42752, 42821);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1049, 42752, 42821);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1049, 42752, 42821);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1049, 42752, 42821);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1049, 42752, 42821);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1049, 42752, 42821);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1049, 42752, 42821);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1049, 42752, 42821);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1049, 42752, 42821);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1049, 42752, 42821);
            CallChecker.varInit(this.m_logger, "m_logger", 1049, 42752, 42821);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1049, 42752, 42821);
            return m_isExtension;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1673.methodEnd();
        }
    }

    public String getSymbolicName() {
        MethodContext _bcornu_methode_context1674 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1054, 42828, 42907);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1054, 42828, 42907);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1054, 42828, 42907);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1054, 42828, 42907);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1054, 42828, 42907);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1054, 42828, 42907);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1054, 42828, 42907);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1054, 42828, 42907);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1054, 42828, 42907);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1054, 42828, 42907);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1054, 42828, 42907);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1054, 42828, 42907);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1054, 42828, 42907);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1054, 42828, 42907);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1054, 42828, 42907);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1054, 42828, 42907);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1054, 42828, 42907);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1054, 42828, 42907);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1054, 42828, 42907);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1054, 42828, 42907);
            CallChecker.varInit(this.m_logger, "m_logger", 1054, 42828, 42907);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1054, 42828, 42907);
            return m_bundleSymbolicName;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1674.methodEnd();
        }
    }

    public Version getBundleVersion() {
        MethodContext _bcornu_methode_context1675 = new MethodContext(Version.class);
        try {
            CallChecker.varInit(this, "this", 1059, 42914, 42990);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1059, 42914, 42990);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1059, 42914, 42990);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1059, 42914, 42990);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1059, 42914, 42990);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1059, 42914, 42990);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1059, 42914, 42990);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1059, 42914, 42990);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1059, 42914, 42990);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1059, 42914, 42990);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1059, 42914, 42990);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1059, 42914, 42990);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1059, 42914, 42990);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1059, 42914, 42990);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1059, 42914, 42990);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1059, 42914, 42990);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1059, 42914, 42990);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1059, 42914, 42990);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1059, 42914, 42990);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1059, 42914, 42990);
            CallChecker.varInit(this.m_logger, "m_logger", 1059, 42914, 42990);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1059, 42914, 42990);
            return m_bundleVersion;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1675.methodEnd();
        }
    }

    public List<BundleCapability> getCapabilities() {
        MethodContext _bcornu_methode_context1676 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 1064, 42997, 43086);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1064, 42997, 43086);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1064, 42997, 43086);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1064, 42997, 43086);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1064, 42997, 43086);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1064, 42997, 43086);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1064, 42997, 43086);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1064, 42997, 43086);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1064, 42997, 43086);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1064, 42997, 43086);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1064, 42997, 43086);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1064, 42997, 43086);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1064, 42997, 43086);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1064, 42997, 43086);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1064, 42997, 43086);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1064, 42997, 43086);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1064, 42997, 43086);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1064, 42997, 43086);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1064, 42997, 43086);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1064, 42997, 43086);
            CallChecker.varInit(this.m_logger, "m_logger", 1064, 42997, 43086);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1064, 42997, 43086);
            return m_capabilities;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1676.methodEnd();
        }
    }

    public List<BundleRequirement> getRequirements() {
        MethodContext _bcornu_methode_context1677 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 1069, 43093, 43183);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1069, 43093, 43183);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1069, 43093, 43183);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1069, 43093, 43183);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1069, 43093, 43183);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1069, 43093, 43183);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1069, 43093, 43183);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1069, 43093, 43183);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1069, 43093, 43183);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1069, 43093, 43183);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1069, 43093, 43183);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1069, 43093, 43183);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1069, 43093, 43183);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1069, 43093, 43183);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1069, 43093, 43183);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1069, 43093, 43183);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1069, 43093, 43183);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1069, 43093, 43183);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1069, 43093, 43183);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1069, 43093, 43183);
            CallChecker.varInit(this.m_logger, "m_logger", 1069, 43093, 43183);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1069, 43093, 43183);
            return m_requirements;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRequirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1677.methodEnd();
        }
    }

    public List<NativeLibraryClause> getLibraryClauses() {
        MethodContext _bcornu_methode_context1678 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 1074, 43190, 43286);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1074, 43190, 43286);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1074, 43190, 43286);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1074, 43190, 43286);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1074, 43190, 43286);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1074, 43190, 43286);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1074, 43190, 43286);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1074, 43190, 43286);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1074, 43190, 43286);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1074, 43190, 43286);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1074, 43190, 43286);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1074, 43190, 43286);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1074, 43190, 43286);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1074, 43190, 43286);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1074, 43190, 43286);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1074, 43190, 43286);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1074, 43190, 43286);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1074, 43190, 43286);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1074, 43190, 43286);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1074, 43190, 43286);
            CallChecker.varInit(this.m_logger, "m_logger", 1074, 43190, 43286);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1074, 43190, 43286);
            return m_libraryClauses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<NativeLibraryClause>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1678.methodEnd();
        }
    }

    public List<NativeLibrary> getLibraries() {
        MethodContext _bcornu_methode_context1679 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 1105, 43293, 45902);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1105, 43293, 45902);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1105, 43293, 45902);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1105, 43293, 45902);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1105, 43293, 45902);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1105, 43293, 45902);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1105, 43293, 45902);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1105, 43293, 45902);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1105, 43293, 45902);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1105, 43293, 45902);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1105, 43293, 45902);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1105, 43293, 45902);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1105, 43293, 45902);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1105, 43293, 45902);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1105, 43293, 45902);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1105, 43293, 45902);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1105, 43293, 45902);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1105, 43293, 45902);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1105, 43293, 45902);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1105, 43293, 45902);
            CallChecker.varInit(this.m_logger, "m_logger", 1105, 43293, 45902);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1105, 43293, 45902);
            ArrayList<NativeLibrary> libs = CallChecker.varInit(null, "libs", 1107, 44644, 44680);
            TryContext _bcornu_try_context_446 = new TryContext(446, ManifestParser.class, "java.lang.Exception");
            try {
                NativeLibraryClause clause = CallChecker.varInit(getSelectedLibraryClause(), "clause", 1110, 44716, 44771);
                if (clause != null) {
                    String[] entries = CallChecker.varInit(clause.getLibraryEntries(), "entries", 1113, 44835, 44880);
                    if (CallChecker.beforeDeref(entries, String[].class, 1114, 44934, 44940)) {
                        entries = CallChecker.beforeCalled(entries, String[].class, 1114, 44934, 44940);
                        libs = new ArrayList<NativeLibrary>(CallChecker.isCalled(entries, String[].class, 1114, 44934, 44940).length);
                        CallChecker.varAssign(libs, "libs", 1114, 44898, 44949);
                    }
                    int current = CallChecker.varInit(((int) (0)), "current", 1115, 44967, 44982);
                    entries = CallChecker.beforeCalled(entries, String[].class, 1116, 45020, 45026);
                    for (int i = 0; i < (CallChecker.isCalled(entries, String[].class, 1116, 45020, 45026).length); i++) {
                        String name = CallChecker.init(String.class);
                        if (CallChecker.beforeDeref(entries, String[].class, 1118, 45101, 45107)) {
                            entries = CallChecker.beforeCalled(entries, String[].class, 1118, 45101, 45107);
                            name = getName(CallChecker.isCalled(entries, String[].class, 1118, 45101, 45107)[i]);
                            CallChecker.varAssign(name, "name", 1118, 45101, 45107);
                        }
                        boolean found = CallChecker.varInit(((boolean) (false)), "found", 1119, 45134, 45155);
                        for (int j = 0; (!found) && (j < current); j++) {
                            if (CallChecker.beforeDeref(entries, String[].class, 1122, 45285, 45291)) {
                                entries = CallChecker.beforeCalled(entries, String[].class, 1122, 45285, 45291);
                                final String npe_invocation_var547 = getName(CallChecker.isCalled(entries, String[].class, 1122, 45285, 45291)[j]);
                                if (CallChecker.beforeDeref(npe_invocation_var547, String.class, 1122, 45277, 45295)) {
                                    found = CallChecker.isCalled(npe_invocation_var547, String.class, 1122, 45277, 45295).equals(name);
                                    CallChecker.varAssign(found, "found", 1122, 45269, 45309);
                                }
                            }
                        }
                        if (!found) {
                            clause = CallChecker.beforeCalled(clause, NativeLibraryClause.class, 1127, 45467, 45472);
                            final String[] npe_invocation_var548 = CallChecker.isCalled(clause, NativeLibraryClause.class, 1127, 45467, 45472).getLibraryEntries();
                            if (CallChecker.beforeDeref(npe_invocation_var548, String[].class, 1127, 45467, 45492)) {
                                if (CallChecker.beforeDeref(libs, ArrayList.class, 1126, 45411, 45414)) {
                                    libs = CallChecker.beforeCalled(libs, ArrayList.class, 1126, 45411, 45414);
                                    CallChecker.isCalled(libs, ArrayList.class, 1126, 45411, 45414).add(new NativeLibrary(CallChecker.isCalled(npe_invocation_var548, String[].class, 1127, 45467, 45492)[i], clause.getOSNames(), clause.getProcessors(), clause.getOSVersions(), clause.getLanguages(), clause.getSelectionFilter()));
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(libs, ArrayList.class, 1132, 45733, 45736)) {
                        libs = CallChecker.beforeCalled(libs, ArrayList.class, 1132, 45733, 45736);
                        CallChecker.isCalled(libs, ArrayList.class, 1132, 45733, 45736).trimToSize();
                    }
                }
            } catch (Exception ex) {
                _bcornu_try_context_446.catchStart(446);
                libs = new ArrayList<NativeLibrary>(0);
                CallChecker.varAssign(libs, "libs", 1137, 45827, 45865);
            } finally {
                _bcornu_try_context_446.finallyStart(446);
            }
            return libs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<NativeLibrary>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1679.methodEnd();
        }
    }

    private String getName(String path) {
        MethodContext _bcornu_methode_context1680 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1142, 45909, 46099);
            CallChecker.varInit(path, "path", 1142, 45909, 46099);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1142, 45909, 46099);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1142, 45909, 46099);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1142, 45909, 46099);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1142, 45909, 46099);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1142, 45909, 46099);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1142, 45909, 46099);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1142, 45909, 46099);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1142, 45909, 46099);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1142, 45909, 46099);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1142, 45909, 46099);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1142, 45909, 46099);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1142, 45909, 46099);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1142, 45909, 46099);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1142, 45909, 46099);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1142, 45909, 46099);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1142, 45909, 46099);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1142, 45909, 46099);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1142, 45909, 46099);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1142, 45909, 46099);
            CallChecker.varInit(this.m_logger, "m_logger", 1142, 45909, 46099);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1142, 45909, 46099);
            int idx = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(path, String.class, 1144, 45969, 45972)) {
                path = CallChecker.beforeCalled(path, String.class, 1144, 45969, 45972);
                idx = CallChecker.isCalled(path, String.class, 1144, 45969, 45972).lastIndexOf('/');
                CallChecker.varAssign(idx, "idx", 1144, 45969, 45972);
            }
            if (idx > (-1)) {
                if (CallChecker.beforeDeref(path, String.class, 1147, 46043, 46046)) {
                    path = CallChecker.beforeCalled(path, String.class, 1147, 46043, 46046);
                    return CallChecker.isCalled(path, String.class, 1147, 46043, 46046).substring(idx);
                }else
                    throw new AbnormalExecutionError();
                
            }
            return path;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1680.methodEnd();
        }
    }

    private NativeLibraryClause getSelectedLibraryClause() throws BundleException {
        MethodContext _bcornu_methode_context1681 = new MethodContext(NativeLibraryClause.class);
        try {
            CallChecker.varInit(this, "this", 1152, 46106, 47424);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1152, 46106, 47424);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1152, 46106, 47424);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1152, 46106, 47424);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1152, 46106, 47424);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1152, 46106, 47424);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1152, 46106, 47424);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1152, 46106, 47424);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1152, 46106, 47424);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1152, 46106, 47424);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1152, 46106, 47424);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1152, 46106, 47424);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1152, 46106, 47424);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1152, 46106, 47424);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1152, 46106, 47424);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1152, 46106, 47424);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1152, 46106, 47424);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1152, 46106, 47424);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1152, 46106, 47424);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1152, 46106, 47424);
            CallChecker.varInit(this.m_logger, "m_logger", 1152, 46106, 47424);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1152, 46106, 47424);
            if (((m_libraryClauses) != null) && ((m_libraryClauses.size()) > 0)) {
                List clauseList = CallChecker.varInit(new ArrayList(), "clauseList", 1156, 46285, 46318);
                for (NativeLibraryClause libraryClause : m_libraryClauses) {
                    if (CallChecker.beforeDeref(libraryClause, NativeLibraryClause.class, 1161, 46477, 46489)) {
                        if (CallChecker.isCalled(libraryClause, NativeLibraryClause.class, 1161, 46477, 46489).match(m_configMap)) {
                            if (CallChecker.beforeDeref(clauseList, List.class, 1163, 46549, 46558)) {
                                clauseList = CallChecker.beforeCalled(clauseList, List.class, 1163, 46549, 46558);
                                CallChecker.isCalled(clauseList, List.class, 1163, 46549, 46558).add(libraryClause);
                            }
                        }
                    }
                }
                int selected = CallChecker.varInit(((int) (0)), "selected", 1168, 46675, 46691);
                if (CallChecker.beforeDeref(clauseList, List.class, 1169, 46709, 46718)) {
                    clauseList = CallChecker.beforeCalled(clauseList, List.class, 1169, 46709, 46718);
                    if (CallChecker.isCalled(clauseList, List.class, 1169, 46709, 46718).isEmpty()) {
                        if (m_libraryHeadersOptional) {
                            return null;
                        }else {
                            throw new BundleException("Unable to select a native library clause.");
                        }
                    }else
                        if (CallChecker.beforeDeref(clauseList, List.class, 1181, 47107, 47116)) {
                            clauseList = CallChecker.beforeCalled(clauseList, List.class, 1181, 47107, 47116);
                            if ((CallChecker.isCalled(clauseList, List.class, 1181, 47107, 47116).size()) == 1) {
                                selected = 0;
                                CallChecker.varAssign(selected, "selected", 1183, 47161, 47173);
                            }else
                                if (CallChecker.beforeDeref(clauseList, List.class, 1185, 47210, 47219)) {
                                    clauseList = CallChecker.beforeCalled(clauseList, List.class, 1185, 47210, 47219);
                                    if ((CallChecker.isCalled(clauseList, List.class, 1185, 47210, 47219).size()) > 1) {
                                        selected = firstSortedClause(clauseList);
                                        CallChecker.varAssign(selected, "selected", 1187, 47263, 47303);
                                    }
                                }
                            
                        }
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(clauseList, List.class, 1189, 47361, 47370)) {
                    clauseList = CallChecker.beforeCalled(clauseList, List.class, 1189, 47361, 47370);
                    return ((NativeLibraryClause) (CallChecker.isCalled(clauseList, List.class, 1189, 47361, 47370).get(selected)));
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NativeLibraryClause) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1681.methodEnd();
        }
    }

    private int firstSortedClause(List<NativeLibraryClause> clauseList) {
        MethodContext _bcornu_methode_context1682 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1195, 47431, 50719);
            CallChecker.varInit(clauseList, "clauseList", 1195, 47431, 50719);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1195, 47431, 50719);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1195, 47431, 50719);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1195, 47431, 50719);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1195, 47431, 50719);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1195, 47431, 50719);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1195, 47431, 50719);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1195, 47431, 50719);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1195, 47431, 50719);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1195, 47431, 50719);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1195, 47431, 50719);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1195, 47431, 50719);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1195, 47431, 50719);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1195, 47431, 50719);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1195, 47431, 50719);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1195, 47431, 50719);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1195, 47431, 50719);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1195, 47431, 50719);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1195, 47431, 50719);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1195, 47431, 50719);
            CallChecker.varInit(this.m_logger, "m_logger", 1195, 47431, 50719);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1195, 47431, 50719);
            ArrayList indexList = CallChecker.varInit(new ArrayList(), "indexList", 1197, 47513, 47550);
            ArrayList selection = CallChecker.varInit(new ArrayList(), "selection", 1198, 47560, 47597);
            clauseList = CallChecker.beforeCalled(clauseList, List.class, 1201, 47655, 47664);
            for (int i = 0; i < (CallChecker.isCalled(clauseList, List.class, 1201, 47655, 47664).size()); i++) {
                if (CallChecker.beforeDeref(indexList, ArrayList.class, 1203, 47701, 47709)) {
                    indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1203, 47701, 47709);
                    CallChecker.isCalled(indexList, ArrayList.class, 1203, 47701, 47709).add(("" + i));
                }
            }
            Version osVersionRangeMaxFloor = CallChecker.varInit(new Version(0, 0, 0), "osVersionRangeMaxFloor", 1208, 47861, 47914);
            indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1209, 47944, 47952);
            for (int i = 0; i < (CallChecker.isCalled(indexList, ArrayList.class, 1209, 47944, 47952).size()); i++) {
                int index = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(indexList, ArrayList.class, 1211, 48018, 48026)) {
                    indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1211, 48018, 48026);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(indexList, ArrayList.class, 1211, 48018, 48026).get(i), Object.class, 1211, 48018, 48033)) {
                        indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1211, 48018, 48026);
                        index = Integer.parseInt(CallChecker.isCalled(CallChecker.isCalled(indexList, ArrayList.class, 1211, 48018, 48026).get(i), Object.class, 1211, 48018, 48033).toString());
                        CallChecker.varAssign(index, "index", 1211, 48018, 48026);
                    }
                }
                String[] osversions = CallChecker.init(String[].class);
                if (CallChecker.beforeDeref(clauseList, List.class, 1212, 48105, 48114)) {
                    clauseList = CallChecker.beforeCalled(clauseList, List.class, 1212, 48105, 48114);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(clauseList, List.class, 1212, 48105, 48114).get(index), NativeLibraryClause.class, 1212, 48105, 48125)) {
                        clauseList = CallChecker.beforeCalled(clauseList, List.class, 1212, 48105, 48114);
                        osversions = CallChecker.isCalled(((NativeLibraryClause) (CallChecker.isCalled(clauseList, List.class, 1212, 48105, 48114).get(index))), NativeLibraryClause.class, 1212, 48105, 48125).getOSVersions();
                        CallChecker.varAssign(osversions, "osversions", 1212, 48105, 48114);
                    }
                }
                if (osversions != null) {
                    if (CallChecker.beforeDeref(indexList, ArrayList.class, 1215, 48230, 48238)) {
                        if (CallChecker.beforeDeref(selection, ArrayList.class, 1215, 48211, 48219)) {
                            indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1215, 48230, 48238);
                            selection = CallChecker.beforeCalled(selection, ArrayList.class, 1215, 48211, 48219);
                            CallChecker.isCalled(selection, ArrayList.class, 1215, 48211, 48219).add(("" + (CallChecker.isCalled(indexList, ArrayList.class, 1215, 48230, 48238).get(i))));
                        }
                    }
                }
                osversions = CallChecker.beforeCalled(osversions, String[].class, 1217, 48320, 48329);
                for (int k = 0; (osversions != null) && (k < (CallChecker.isCalled(osversions, String[].class, 1217, 48320, 48329).length)); k++) {
                    VersionRange range = CallChecker.varInit(VersionRange.parse(osversions[k]), "range", 1219, 48375, 48429);
                    if (CallChecker.beforeDeref(range, VersionRange.class, 1220, 48452, 48456)) {
                        range = CallChecker.beforeCalled(range, VersionRange.class, 1220, 48452, 48456);
                        final Version npe_invocation_var549 = CallChecker.isCalled(range, VersionRange.class, 1220, 48452, 48456).getFloor();
                        if (CallChecker.beforeDeref(npe_invocation_var549, Version.class, 1220, 48451, 48468)) {
                            if ((CallChecker.isCalled(npe_invocation_var549, Version.class, 1220, 48451, 48468).compareTo(osVersionRangeMaxFloor)) >= 0) {
                                if (CallChecker.beforeDeref(range, VersionRange.class, 1222, 48573, 48577)) {
                                    range = CallChecker.beforeCalled(range, VersionRange.class, 1222, 48573, 48577);
                                    osVersionRangeMaxFloor = CallChecker.isCalled(range, VersionRange.class, 1222, 48573, 48577).getFloor();
                                    CallChecker.varAssign(osVersionRangeMaxFloor, "osVersionRangeMaxFloor", 1222, 48548, 48589);
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(selection, ArrayList.class, 1227, 48646, 48654)) {
                selection = CallChecker.beforeCalled(selection, ArrayList.class, 1227, 48646, 48654);
                if ((CallChecker.isCalled(selection, ArrayList.class, 1227, 48646, 48654).size()) == 1) {
                    if (CallChecker.beforeDeref(selection, ArrayList.class, 1229, 48715, 48723)) {
                        selection = CallChecker.beforeCalled(selection, ArrayList.class, 1229, 48715, 48723);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(selection, ArrayList.class, 1229, 48715, 48723).get(0), Object.class, 1229, 48715, 48730)) {
                            selection = CallChecker.beforeCalled(selection, ArrayList.class, 1229, 48715, 48723);
                            return Integer.parseInt(CallChecker.isCalled(CallChecker.isCalled(selection, ArrayList.class, 1229, 48715, 48723).get(0), Object.class, 1229, 48715, 48730).toString());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    if (CallChecker.beforeDeref(selection, ArrayList.class, 1231, 48772, 48780)) {
                        selection = CallChecker.beforeCalled(selection, ArrayList.class, 1231, 48772, 48780);
                        if ((CallChecker.isCalled(selection, ArrayList.class, 1231, 48772, 48780).size()) > 1) {
                            indexList = selection;
                            CallChecker.varAssign(indexList, "indexList", 1235, 48939, 48960);
                            selection = new ArrayList();
                            CallChecker.varAssign(selection, "selection", 1236, 48974, 49001);
                            indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1237, 49035, 49043);
                            for (int i = 0; i < (CallChecker.isCalled(indexList, ArrayList.class, 1237, 49035, 49043).size()); i++) {
                                int index = CallChecker.init(int.class);
                                if (CallChecker.beforeDeref(indexList, ArrayList.class, 1239, 49117, 49125)) {
                                    indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1239, 49117, 49125);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(indexList, ArrayList.class, 1239, 49117, 49125).get(i), Object.class, 1239, 49117, 49132)) {
                                        indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1239, 49117, 49125);
                                        index = Integer.parseInt(CallChecker.isCalled(CallChecker.isCalled(indexList, ArrayList.class, 1239, 49117, 49125).get(i), Object.class, 1239, 49117, 49132).toString());
                                        CallChecker.varAssign(index, "index", 1239, 49117, 49125);
                                    }
                                }
                                String[] osversions = CallChecker.init(String[].class);
                                if (CallChecker.beforeDeref(clauseList, List.class, 1240, 49208, 49217)) {
                                    clauseList = CallChecker.beforeCalled(clauseList, List.class, 1240, 49208, 49217);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(clauseList, List.class, 1240, 49208, 49217).get(index), NativeLibraryClause.class, 1240, 49208, 49228)) {
                                        clauseList = CallChecker.beforeCalled(clauseList, List.class, 1240, 49208, 49217);
                                        osversions = CallChecker.isCalled(((NativeLibraryClause) (CallChecker.isCalled(clauseList, List.class, 1240, 49208, 49217).get(index))), NativeLibraryClause.class, 1240, 49208, 49228).getOSVersions();
                                        CallChecker.varAssign(osversions, "osversions", 1240, 49208, 49217);
                                    }
                                }
                                osversions = CallChecker.beforeCalled(osversions, String[].class, 1241, 49284, 49293);
                                for (int k = 0; k < (CallChecker.isCalled(osversions, String[].class, 1241, 49284, 49293).length); k++) {
                                    VersionRange range = CallChecker.init(VersionRange.class);
                                    if (CallChecker.beforeDeref(osversions, String[].class, 1243, 49386, 49395)) {
                                        osversions = CallChecker.beforeCalled(osversions, String[].class, 1243, 49386, 49395);
                                        range = VersionRange.parse(CallChecker.isCalled(osversions, String[].class, 1243, 49386, 49395)[k]);
                                        CallChecker.varAssign(range, "range", 1243, 49386, 49395);
                                    }
                                    if (CallChecker.beforeDeref(range, VersionRange.class, 1244, 49427, 49431)) {
                                        range = CallChecker.beforeCalled(range, VersionRange.class, 1244, 49427, 49431);
                                        final Version npe_invocation_var550 = CallChecker.isCalled(range, VersionRange.class, 1244, 49427, 49431).getFloor();
                                        if (CallChecker.beforeDeref(npe_invocation_var550, Version.class, 1244, 49426, 49443)) {
                                            if ((CallChecker.isCalled(npe_invocation_var550, Version.class, 1244, 49426, 49443).compareTo(osVersionRangeMaxFloor)) >= 0) {
                                                if (CallChecker.beforeDeref(indexList, ArrayList.class, 1246, 49550, 49558)) {
                                                    if (CallChecker.beforeDeref(selection, ArrayList.class, 1246, 49531, 49539)) {
                                                        indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1246, 49550, 49558);
                                                        selection = CallChecker.beforeCalled(selection, ArrayList.class, 1246, 49531, 49539);
                                                        CallChecker.isCalled(selection, ArrayList.class, 1246, 49531, 49539).add(("" + (CallChecker.isCalled(indexList, ArrayList.class, 1246, 49550, 49558).get(i))));
                                                    }
                                                }
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
            
            if (CallChecker.beforeDeref(selection, ArrayList.class, 1252, 49646, 49654)) {
                selection = CallChecker.beforeCalled(selection, ArrayList.class, 1252, 49646, 49654);
                if (CallChecker.isCalled(selection, ArrayList.class, 1252, 49646, 49654).isEmpty()) {
                    if (CallChecker.beforeDeref(selection, ArrayList.class, 1255, 49724, 49732)) {
                        selection = CallChecker.beforeCalled(selection, ArrayList.class, 1255, 49724, 49732);
                        CallChecker.isCalled(selection, ArrayList.class, 1255, 49724, 49732).clear();
                    }
                    if (CallChecker.beforeDeref(indexList, ArrayList.class, 1256, 49755, 49763)) {
                        indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1256, 49755, 49763);
                        CallChecker.isCalled(indexList, ArrayList.class, 1256, 49755, 49763).clear();
                    }
                    clauseList = CallChecker.beforeCalled(clauseList, List.class, 1257, 49806, 49815);
                    for (int i = 0; i < (CallChecker.isCalled(clauseList, List.class, 1257, 49806, 49815).size()); i++) {
                        if (CallChecker.beforeDeref(indexList, ArrayList.class, 1259, 49860, 49868)) {
                            indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1259, 49860, 49868);
                            CallChecker.isCalled(indexList, ArrayList.class, 1259, 49860, 49868).add(("" + i));
                        }
                    }
                }else
                    if (CallChecker.beforeDeref(selection, ArrayList.class, 1262, 49924, 49932)) {
                        selection = CallChecker.beforeCalled(selection, ArrayList.class, 1262, 49924, 49932);
                        if ((CallChecker.isCalled(selection, ArrayList.class, 1262, 49924, 49932).size()) == 1) {
                            if (CallChecker.beforeDeref(selection, ArrayList.class, 1264, 49993, 50001)) {
                                selection = CallChecker.beforeCalled(selection, ArrayList.class, 1264, 49993, 50001);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(selection, ArrayList.class, 1264, 49993, 50001).get(0), Object.class, 1264, 49993, 50008)) {
                                    selection = CallChecker.beforeCalled(selection, ArrayList.class, 1264, 49993, 50001);
                                    return Integer.parseInt(CallChecker.isCalled(CallChecker.isCalled(selection, ArrayList.class, 1264, 49993, 50001).get(0), Object.class, 1264, 49993, 50008).toString());
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else {
                            indexList = selection;
                            CallChecker.varAssign(indexList, "indexList", 1268, 50068, 50089);
                            if (CallChecker.beforeDeref(selection, ArrayList.class, 1269, 50103, 50111)) {
                                selection = CallChecker.beforeCalled(selection, ArrayList.class, 1269, 50103, 50111);
                                CallChecker.isCalled(selection, ArrayList.class, 1269, 50103, 50111).clear();
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
            indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1273, 50216, 50224);
            for (int i = 0; i < (CallChecker.isCalled(indexList, ArrayList.class, 1273, 50216, 50224).size()); i++) {
                int index = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(indexList, ArrayList.class, 1275, 50290, 50298)) {
                    indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1275, 50290, 50298);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(indexList, ArrayList.class, 1275, 50290, 50298).get(i), Object.class, 1275, 50290, 50305)) {
                        indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1275, 50290, 50298);
                        index = Integer.parseInt(CallChecker.isCalled(CallChecker.isCalled(indexList, ArrayList.class, 1275, 50290, 50298).get(i), Object.class, 1275, 50290, 50305).toString());
                        CallChecker.varAssign(index, "index", 1275, 50290, 50298);
                    }
                }
                if (CallChecker.beforeDeref(clauseList, List.class, 1276, 50359, 50368)) {
                    clauseList = CallChecker.beforeCalled(clauseList, List.class, 1276, 50359, 50368);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(clauseList, List.class, 1276, 50359, 50368).get(index), NativeLibraryClause.class, 1276, 50359, 50379)) {
                        clauseList = CallChecker.beforeCalled(clauseList, List.class, 1276, 50359, 50368);
                        if ((CallChecker.isCalled(((NativeLibraryClause) (CallChecker.isCalled(clauseList, List.class, 1276, 50359, 50368).get(index))), NativeLibraryClause.class, 1276, 50359, 50379).getLanguages()) != null) {
                            if (CallChecker.beforeDeref(indexList, ArrayList.class, 1278, 50455, 50463)) {
                                if (CallChecker.beforeDeref(selection, ArrayList.class, 1278, 50436, 50444)) {
                                    indexList = CallChecker.beforeCalled(indexList, ArrayList.class, 1278, 50455, 50463);
                                    selection = CallChecker.beforeCalled(selection, ArrayList.class, 1278, 50436, 50444);
                                    CallChecker.isCalled(selection, ArrayList.class, 1278, 50436, 50444).add(("" + (CallChecker.isCalled(indexList, ArrayList.class, 1278, 50455, 50463).get(i))));
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(selection, ArrayList.class, 1283, 50553, 50561)) {
                selection = CallChecker.beforeCalled(selection, ArrayList.class, 1283, 50553, 50561);
                if (CallChecker.isCalled(selection, ArrayList.class, 1283, 50553, 50561).isEmpty()) {
                    return 0;
                }else {
                    if (CallChecker.beforeDeref(selection, ArrayList.class, 1289, 50675, 50683)) {
                        selection = CallChecker.beforeCalled(selection, ArrayList.class, 1289, 50675, 50683);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(selection, ArrayList.class, 1289, 50675, 50683).get(0), Object.class, 1289, 50675, 50690)) {
                            selection = CallChecker.beforeCalled(selection, ArrayList.class, 1289, 50675, 50683);
                            return Integer.parseInt(CallChecker.isCalled(CallChecker.isCalled(selection, ArrayList.class, 1289, 50675, 50683).get(0), Object.class, 1289, 50675, 50690).toString());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1682.methodEnd();
        }
    }

    private static List<ParsedHeaderClause> calculateImplicitImports(List<BundleCapability> exports, List<ParsedHeaderClause> imports) throws BundleException {
        MethodContext _bcornu_methode_context1683 = new MethodContext(List.class);
        try {
            CallChecker.varInit(imports, "imports", 1293, 50726, 52654);
            CallChecker.varInit(exports, "exports", 1293, 50726, 52654);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1293, 50726, 52654);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1293, 50726, 52654);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1293, 50726, 52654);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1293, 50726, 52654);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1293, 50726, 52654);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1293, 50726, 52654);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1293, 50726, 52654);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1293, 50726, 52654);
            List<ParsedHeaderClause> clauseList = CallChecker.varInit(new ArrayList(), "clauseList", 1297, 50911, 50964);
            Map map = CallChecker.varInit(new HashMap(), "map", 1302, 51141, 51165);
            imports = CallChecker.beforeCalled(imports, List.class, 1304, 51238, 51244);
            for (int impIdx = 0; impIdx < (CallChecker.isCalled(imports, List.class, 1304, 51238, 51244).size()); impIdx++) {
                imports = CallChecker.beforeCalled(imports, List.class, 1306, 51318, 51324);
                for (int pathIdx = 0; pathIdx < (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(imports, List.class, 1306, 51318, 51324).get(impIdx), ParsedHeaderClause.class, 1306, 51318, 51336).m_paths, List.class, 1306, 51318, 51344).size()); pathIdx++) {
                    if (CallChecker.beforeDeref(imports, List.class, 1309, 51424, 51430)) {
                        imports = CallChecker.beforeCalled(imports, List.class, 1309, 51424, 51430);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(imports, List.class, 1309, 51424, 51430).get(impIdx), ParsedHeaderClause.class, 1309, 51424, 51442)) {
                            imports = CallChecker.beforeCalled(imports, List.class, 1309, 51424, 51430);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(imports, List.class, 1309, 51424, 51430).get(impIdx), ParsedHeaderClause.class, 1309, 51424, 51442).m_paths, List.class, 1309, 51424, 51450)) {
                                if (CallChecker.beforeDeref(imports, List.class, 1310, 51486, 51492)) {
                                    imports = CallChecker.beforeCalled(imports, List.class, 1310, 51486, 51492);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(imports, List.class, 1310, 51486, 51492).get(impIdx), ParsedHeaderClause.class, 1310, 51486, 51504)) {
                                        imports = CallChecker.beforeCalled(imports, List.class, 1310, 51486, 51492);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(imports, List.class, 1310, 51486, 51492).get(impIdx), ParsedHeaderClause.class, 1310, 51486, 51504).m_paths, List.class, 1310, 51486, 51512)) {
                                            if (CallChecker.beforeDeref(map, Map.class, 1308, 51395, 51397)) {
                                                imports = CallChecker.beforeCalled(imports, List.class, 1309, 51424, 51430);
                                                imports = CallChecker.beforeCalled(imports, List.class, 1310, 51486, 51492);
                                                map = CallChecker.beforeCalled(map, Map.class, 1308, 51395, 51397);
                                                CallChecker.isCalled(map, Map.class, 1308, 51395, 51397).put(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(imports, List.class, 1309, 51424, 51430).get(impIdx), ParsedHeaderClause.class, 1309, 51424, 51442).m_paths, List.class, 1309, 51424, 51450).get(pathIdx), CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(imports, List.class, 1310, 51486, 51492).get(impIdx), ParsedHeaderClause.class, 1310, 51486, 51504).m_paths, List.class, 1310, 51486, 51512).get(pathIdx));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            exports = CallChecker.beforeCalled(exports, List.class, 1314, 51643, 51649);
            for (int i = 0; i < (CallChecker.isCalled(exports, List.class, 1314, 51643, 51649).size()); i++) {
                if (CallChecker.beforeDeref(exports, List.class, 1316, 51698, 51704)) {
                    exports = CallChecker.beforeCalled(exports, List.class, 1316, 51698, 51704);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(exports, List.class, 1316, 51698, 51704).get(i), BundleCapability.class, 1316, 51698, 51711)) {
                        exports = CallChecker.beforeCalled(exports, List.class, 1316, 51698, 51704);
                        final Map<String, Object> npe_invocation_var551 = CallChecker.isCalled(CallChecker.isCalled(exports, List.class, 1316, 51698, 51704).get(i), BundleCapability.class, 1316, 51698, 51711).getAttributes();
                        if (CallChecker.beforeDeref(npe_invocation_var551, Map.class, 1316, 51698, 51727)) {
                            if (CallChecker.beforeDeref(map, Map.class, 1316, 51690, 51692)) {
                                map = CallChecker.beforeCalled(map, Map.class, 1316, 51690, 51692);
                                if ((CallChecker.isCalled(map, Map.class, 1316, 51690, 51692).get(CallChecker.isCalled(npe_invocation_var551, Map.class, 1316, 51698, 51727).get(BundleRevision.PACKAGE_NAMESPACE))) == null) {
                                    Map<String, Object> attrs = CallChecker.varInit(new HashMap<String, Object>(), "attrs", 1320, 51876, 51933);
                                    Object version = CallChecker.init(Object.class);
                                    if (CallChecker.beforeDeref(exports, List.class, 1321, 51968, 51974)) {
                                        exports = CallChecker.beforeCalled(exports, List.class, 1321, 51968, 51974);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(exports, List.class, 1321, 51968, 51974).get(i), BundleCapability.class, 1321, 51968, 51981)) {
                                            exports = CallChecker.beforeCalled(exports, List.class, 1321, 51968, 51974);
                                            final Map<String, Object> npe_invocation_var552 = CallChecker.isCalled(CallChecker.isCalled(exports, List.class, 1321, 51968, 51974).get(i), BundleCapability.class, 1321, 51968, 51981).getAttributes();
                                            if (CallChecker.beforeDeref(npe_invocation_var552, Map.class, 1321, 51968, 51997)) {
                                                version = CallChecker.isCalled(npe_invocation_var552, Map.class, 1321, 51968, 51997).get(Constants.VERSION_ATTRIBUTE);
                                                CallChecker.varAssign(version, "version", 1321, 51968, 51974);
                                            }
                                        }
                                    }
                                    if (version != null) {
                                        if (CallChecker.beforeDeref(attrs, Map.class, 1324, 52108, 52112)) {
                                            attrs = CallChecker.beforeCalled(attrs, Map.class, 1324, 52108, 52112);
                                            CallChecker.isCalled(attrs, Map.class, 1324, 52108, 52112).put(Constants.VERSION_ATTRIBUTE, VersionRange.parse(version.toString()));
                                        }
                                    }
                                    List<String> paths = CallChecker.varInit(new ArrayList(), "paths", 1329, 52272, 52308);
                                    if (CallChecker.beforeDeref(exports, List.class, 1331, 52365, 52371)) {
                                        exports = CallChecker.beforeCalled(exports, List.class, 1331, 52365, 52371);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(exports, List.class, 1331, 52365, 52371).get(i), BundleCapability.class, 1331, 52365, 52378)) {
                                            exports = CallChecker.beforeCalled(exports, List.class, 1331, 52365, 52371);
                                            final Map<String, Object> npe_invocation_var553 = CallChecker.isCalled(CallChecker.isCalled(exports, List.class, 1331, 52365, 52371).get(i), BundleCapability.class, 1331, 52365, 52378).getAttributes();
                                            if (CallChecker.beforeDeref(npe_invocation_var553, Map.class, 1331, 52365, 52394)) {
                                                if (CallChecker.beforeDeref(paths, List.class, 1330, 52326, 52330)) {
                                                    paths = CallChecker.beforeCalled(paths, List.class, 1330, 52326, 52330);
                                                    CallChecker.isCalled(paths, List.class, 1330, 52326, 52330).add(((String) (CallChecker.isCalled(npe_invocation_var553, Map.class, 1331, 52365, 52394).get(BundleRevision.PACKAGE_NAMESPACE))));
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(clauseList, List.class, 1332, 52452, 52461)) {
                                        clauseList = CallChecker.beforeCalled(clauseList, List.class, 1332, 52452, 52461);
                                        CallChecker.isCalled(clauseList, List.class, 1332, 52452, 52461).add(new ParsedHeaderClause(paths, Collections.EMPTY_MAP, attrs, Collections.EMPTY_MAP));
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return clauseList;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<ParsedHeaderClause>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1683.methodEnd();
        }
    }

    private static List<BundleCapability> calculateImplicitUses(List<BundleCapability> exports, List<ParsedHeaderClause> imports) throws BundleException {
        MethodContext _bcornu_methode_context1684 = new MethodContext(List.class);
        try {
            CallChecker.varInit(imports, "imports", 1341, 52661, 53962);
            CallChecker.varInit(exports, "exports", 1341, 52661, 53962);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1341, 52661, 53962);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1341, 52661, 53962);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1341, 52661, 53962);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1341, 52661, 53962);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1341, 52661, 53962);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1341, 52661, 53962);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1341, 52661, 53962);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1341, 52661, 53962);
            String usesValue = CallChecker.varInit("", "usesValue", 1350, 53150, 53171);
            imports = CallChecker.beforeCalled(imports, List.class, 1351, 53201, 53207);
            for (int i = 0; i < (CallChecker.isCalled(imports, List.class, 1351, 53201, 53207).size()); i++) {
                imports = CallChecker.beforeCalled(imports, List.class, 1353, 53276, 53282);
                for (int pathIdx = 0; pathIdx < (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(imports, List.class, 1353, 53276, 53282).get(i), ParsedHeaderClause.class, 1353, 53276, 53289).m_paths, List.class, 1353, 53276, 53297).size()); pathIdx++) {
                    if (CallChecker.beforeDeref(usesValue, String.class, 1356, 53394, 53402)) {
                        usesValue = CallChecker.beforeCalled(usesValue, String.class, 1356, 53394, 53402);
                        if ((CallChecker.isCalled(usesValue, String.class, 1356, 53394, 53402).length()) > 0) {
                            if (CallChecker.beforeDeref(usesValue, String.class, 1356, 53394, 53402)) {
                                if (CallChecker.beforeDeref(imports, List.class, 1357, 53452, 53458)) {
                                    imports = CallChecker.beforeCalled(imports, List.class, 1357, 53452, 53458);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(imports, List.class, 1357, 53452, 53458).get(i), ParsedHeaderClause.class, 1357, 53452, 53465)) {
                                        imports = CallChecker.beforeCalled(imports, List.class, 1357, 53452, 53458);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(imports, List.class, 1357, 53452, 53458).get(i), ParsedHeaderClause.class, 1357, 53452, 53465).m_paths, List.class, 1357, 53452, 53473)) {
                                            usesValue = CallChecker.beforeCalled(usesValue, String.class, 1356, 53394, 53402);
                                            imports = CallChecker.beforeCalled(imports, List.class, 1357, 53452, 53458);
                                            usesValue = (usesValue + ((CallChecker.isCalled(usesValue, String.class, 1356, 53394, 53402).length()) > 0 ? "," : "")) + (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(imports, List.class, 1357, 53452, 53458).get(i), ParsedHeaderClause.class, 1357, 53452, 53465).m_paths, List.class, 1357, 53452, 53473).get(pathIdx));
                                            CallChecker.varAssign(usesValue, "usesValue", 1355, 53348, 53487);
                                        }
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(usesValue, String.class, 1356, 53394, 53402)) {
                                if (CallChecker.beforeDeref(imports, List.class, 1357, 53452, 53458)) {
                                    imports = CallChecker.beforeCalled(imports, List.class, 1357, 53452, 53458);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(imports, List.class, 1357, 53452, 53458).get(i), ParsedHeaderClause.class, 1357, 53452, 53465)) {
                                        imports = CallChecker.beforeCalled(imports, List.class, 1357, 53452, 53458);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(imports, List.class, 1357, 53452, 53458).get(i), ParsedHeaderClause.class, 1357, 53452, 53465).m_paths, List.class, 1357, 53452, 53473)) {
                                            usesValue = CallChecker.beforeCalled(usesValue, String.class, 1356, 53394, 53402);
                                            imports = CallChecker.beforeCalled(imports, List.class, 1357, 53452, 53458);
                                            usesValue = (usesValue + ((CallChecker.isCalled(usesValue, String.class, 1356, 53394, 53402).length()) > 0 ? "," : "")) + (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(imports, List.class, 1357, 53452, 53458).get(i), ParsedHeaderClause.class, 1357, 53452, 53465).m_paths, List.class, 1357, 53452, 53473).get(pathIdx));
                                            CallChecker.varAssign(usesValue, "usesValue", 1355, 53348, 53487);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            exports = CallChecker.beforeCalled(exports, List.class, 1360, 53541, 53547);
            for (int i = 0; i < (CallChecker.isCalled(exports, List.class, 1360, 53541, 53547).size()); i++) {
                Map<String, String> dirs = CallChecker.varInit(new HashMap<String, String>(1), "dirs", 1362, 53584, 53641);
                if (CallChecker.beforeDeref(dirs, Map.class, 1363, 53655, 53658)) {
                    dirs = CallChecker.beforeCalled(dirs, Map.class, 1363, 53655, 53658);
                    CallChecker.isCalled(dirs, Map.class, 1363, 53655, 53658).put(Constants.USES_DIRECTIVE, usesValue);
                }
                if (CallChecker.beforeDeref(exports, List.class, 1365, 53771, 53777)) {
                    exports = CallChecker.beforeCalled(exports, List.class, 1365, 53771, 53777);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(exports, List.class, 1365, 53771, 53777).get(i), BundleCapability.class, 1365, 53771, 53784)) {
                        if (CallChecker.beforeDeref(exports, List.class, 1368, 53889, 53895)) {
                            exports = CallChecker.beforeCalled(exports, List.class, 1368, 53889, 53895);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(exports, List.class, 1368, 53889, 53895).get(i), BundleCapability.class, 1368, 53889, 53902)) {
                                if (CallChecker.beforeDeref(exports, List.class, 1364, 53714, 53720)) {
                                    exports = CallChecker.beforeCalled(exports, List.class, 1365, 53771, 53777);
                                    exports = CallChecker.beforeCalled(exports, List.class, 1368, 53889, 53895);
                                    exports = CallChecker.beforeCalled(exports, List.class, 1364, 53714, 53720);
                                    CallChecker.isCalled(exports, List.class, 1364, 53714, 53720).set(i, new BundleCapabilityImpl(CallChecker.isCalled(CallChecker.isCalled(exports, List.class, 1365, 53771, 53777).get(i), BundleCapability.class, 1365, 53771, 53784).getRevision(), BundleRevision.PACKAGE_NAMESPACE, dirs, CallChecker.isCalled(CallChecker.isCalled(exports, List.class, 1368, 53889, 53895).get(i), BundleCapability.class, 1368, 53889, 53902).getAttributes()));
                                }
                            }
                        }
                    }
                }
            }
            return exports;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1684.methodEnd();
        }
    }

    private static boolean checkExtensionBundle(Map headerMap) throws BundleException {
        MethodContext _bcornu_methode_context1685 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(headerMap, "headerMap", 1374, 53969, 55051);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1374, 53969, 55051);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1374, 53969, 55051);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1374, 53969, 55051);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1374, 53969, 55051);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1374, 53969, 55051);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1374, 53969, 55051);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1374, 53969, 55051);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1374, 53969, 55051);
            Object extension = CallChecker.init(Object.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 1377, 54133, 54141)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1377, 54133, 54141);
                extension = ManifestParser.parseExtensionBundleHeader(((String) (CallChecker.isCalled(headerMap, Map.class, 1377, 54133, 54141).get(Constants.FRAGMENT_HOST))));
                CallChecker.varAssign(extension, "extension", 1377, 54133, 54141);
            }
            if (extension != null) {
                if (CallChecker.beforeDeref(Constants.EXTENSION_FRAMEWORK, String.class, 1381, 54234, 54262)) {
                    if (CallChecker.beforeDeref(Constants.EXTENSION_BOOTCLASSPATH, String.class, 1382, 54301, 54333)) {
                        if (!((CallChecker.isCalled(Constants.EXTENSION_FRAMEWORK, String.class, 1381, 54234, 54262).equals(extension)) || (CallChecker.isCalled(Constants.EXTENSION_BOOTCLASSPATH, String.class, 1382, 54301, 54333).equals(extension)))) {
                            throw new BundleException("Extension bundle must have either 'extension:=framework' or 'extension:=bootclasspath'");
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(headerMap, Map.class, 1387, 54553, 54561)) {
                    if (CallChecker.beforeDeref(headerMap, Map.class, 1388, 54620, 54628)) {
                        if (CallChecker.beforeDeref(headerMap, Map.class, 1389, 54687, 54695)) {
                            if (CallChecker.beforeDeref(headerMap, Map.class, 1390, 54757, 54765)) {
                                if (CallChecker.beforeDeref(headerMap, Map.class, 1391, 54831, 54839)) {
                                    headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1387, 54553, 54561);
                                    headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1388, 54620, 54628);
                                    headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1389, 54687, 54695);
                                    headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1390, 54757, 54765);
                                    headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1391, 54831, 54839);
                                    if (((((CallChecker.isCalled(headerMap, Map.class, 1387, 54553, 54561).containsKey(Constants.IMPORT_PACKAGE)) || (CallChecker.isCalled(headerMap, Map.class, 1388, 54620, 54628).containsKey(Constants.REQUIRE_BUNDLE))) || (CallChecker.isCalled(headerMap, Map.class, 1389, 54687, 54695).containsKey(Constants.BUNDLE_NATIVECODE))) || (CallChecker.isCalled(headerMap, Map.class, 1390, 54757, 54765).containsKey(Constants.DYNAMICIMPORT_PACKAGE))) || (CallChecker.isCalled(headerMap, Map.class, 1391, 54831, 54839).containsKey(Constants.BUNDLE_ACTIVATOR))) {
                                        throw new BundleException("Invalid extension bundle manifest");
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                return true;
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1685.methodEnd();
        }
    }

    private static BundleCapabilityImpl parseBundleSymbolicName(BundleRevision owner, Map headerMap) throws BundleException {
        MethodContext _bcornu_methode_context1686 = new MethodContext(BundleCapabilityImpl.class);
        try {
            CallChecker.varInit(headerMap, "headerMap", 1400, 55058, 57181);
            CallChecker.varInit(owner, "owner", 1400, 55058, 57181);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1400, 55058, 57181);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1400, 55058, 57181);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1400, 55058, 57181);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1400, 55058, 57181);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1400, 55058, 57181);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1400, 55058, 57181);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1400, 55058, 57181);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1400, 55058, 57181);
            List<ParsedHeaderClause> clauses = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 1405, 55286, 55294)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1405, 55286, 55294);
                clauses = ManifestParser.parseStandardHeader(((String) (CallChecker.isCalled(headerMap, Map.class, 1405, 55286, 55294).get(Constants.BUNDLE_SYMBOLICNAME))));
                CallChecker.varAssign(clauses, "clauses", 1405, 55286, 55294);
            }
            if (CallChecker.beforeDeref(clauses, List.class, 1406, 55345, 55351)) {
                clauses = CallChecker.beforeCalled(clauses, List.class, 1406, 55345, 55351);
                if ((CallChecker.isCalled(clauses, List.class, 1406, 55345, 55351).size()) > 0) {
                    if (CallChecker.beforeDeref(clauses, List.class, 1408, 55391, 55397)) {
                        clauses = CallChecker.beforeCalled(clauses, List.class, 1408, 55391, 55397);
                        if ((CallChecker.isCalled(clauses, List.class, 1408, 55391, 55397).size()) > 1) {
                            if (CallChecker.beforeDeref(headerMap, Map.class, 1412, 55554, 55562)) {
                                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1412, 55554, 55562);
                                throw new BundleException(("Cannot have multiple symbolic names: " + (CallChecker.isCalled(headerMap, Map.class, 1412, 55554, 55562).get(Constants.BUNDLE_SYMBOLICNAME))));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            if (CallChecker.beforeDeref(clauses, List.class, 1414, 55636, 55642)) {
                                clauses = CallChecker.beforeCalled(clauses, List.class, 1414, 55636, 55642);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1414, 55636, 55642).get(0), ParsedHeaderClause.class, 1414, 55636, 55649)) {
                                    clauses = CallChecker.beforeCalled(clauses, List.class, 1414, 55636, 55642);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1414, 55636, 55642).get(0), ParsedHeaderClause.class, 1414, 55636, 55649).m_paths, List.class, 1414, 55636, 55657)) {
                                        clauses = CallChecker.beforeCalled(clauses, List.class, 1414, 55636, 55642);
                                        if ((CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1414, 55636, 55642).get(0), ParsedHeaderClause.class, 1414, 55636, 55649).m_paths, List.class, 1414, 55636, 55657).size()) > 1) {
                                            if (CallChecker.beforeDeref(headerMap, Map.class, 1418, 55814, 55822)) {
                                                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1418, 55814, 55822);
                                                throw new BundleException(("Cannot have multiple symbolic names: " + (CallChecker.isCalled(headerMap, Map.class, 1418, 55814, 55822).get(Constants.BUNDLE_SYMBOLICNAME))));
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    Version bundleVersion = CallChecker.varInit(Version.emptyVersion, "bundleVersion", 1422, 55923, 55967);
                    if (CallChecker.beforeDeref(headerMap, Map.class, 1423, 55985, 55993)) {
                        headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1423, 55985, 55993);
                        if ((CallChecker.isCalled(headerMap, Map.class, 1423, 55985, 55993).get(Constants.BUNDLE_VERSION)) != null) {
                            TryContext _bcornu_try_context_447 = new TryContext(447, ManifestParser.class, "java.lang.RuntimeException");
                            try {
                                if (CallChecker.beforeDeref(headerMap, Map.class, 1428, 56177, 56185)) {
                                    headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1428, 56177, 56185);
                                    bundleVersion = Version.parseVersion(((String) (CallChecker.isCalled(headerMap, Map.class, 1428, 56177, 56185).get(Constants.BUNDLE_VERSION))));
                                    CallChecker.varAssign(bundleVersion, "bundleVersion", 1427, 56106, 56217);
                                }
                            } catch (RuntimeException ex) {
                                _bcornu_try_context_447.catchStart(447);
                                String mv = CallChecker.varInit(ManifestParser.getManifestVersion(headerMap), "mv", 1433, 56400, 56441);
                                if (mv != null) {
                                    throw ex;
                                }
                                bundleVersion = Version.emptyVersion;
                                CallChecker.varAssign(bundleVersion, "bundleVersion", 1438, 56577, 56613);
                            } finally {
                                _bcornu_try_context_447.finallyStart(447);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    String symName = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(clauses, List.class, 1443, 56744, 56750)) {
                        clauses = CallChecker.beforeCalled(clauses, List.class, 1443, 56744, 56750);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1443, 56744, 56750).get(0), ParsedHeaderClause.class, 1443, 56744, 56757)) {
                            clauses = CallChecker.beforeCalled(clauses, List.class, 1443, 56744, 56750);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1443, 56744, 56750).get(0), ParsedHeaderClause.class, 1443, 56744, 56757).m_paths, List.class, 1443, 56744, 56765)) {
                                clauses = CallChecker.beforeCalled(clauses, List.class, 1443, 56744, 56750);
                                symName = ((String) (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1443, 56744, 56750).get(0), ParsedHeaderClause.class, 1443, 56744, 56757).m_paths, List.class, 1443, 56744, 56765).get(0)));
                                CallChecker.varAssign(symName, "symName", 1443, 56744, 56750);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(clauses, List.class, 1444, 56787, 56793)) {
                        clauses = CallChecker.beforeCalled(clauses, List.class, 1444, 56787, 56793);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1444, 56787, 56793).get(0), ParsedHeaderClause.class, 1444, 56787, 56800)) {
                            clauses = CallChecker.beforeCalled(clauses, List.class, 1444, 56787, 56793);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1444, 56787, 56793).get(0), ParsedHeaderClause.class, 1444, 56787, 56800).m_attrs, Map.class, 1444, 56787, 56808)) {
                                clauses = CallChecker.beforeCalled(clauses, List.class, 1444, 56787, 56793);
                                CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1444, 56787, 56793).get(0), ParsedHeaderClause.class, 1444, 56787, 56800).m_attrs, Map.class, 1444, 56787, 56808).put(BundleRevision.BUNDLE_NAMESPACE, symName);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(clauses, List.class, 1445, 56869, 56875)) {
                        clauses = CallChecker.beforeCalled(clauses, List.class, 1445, 56869, 56875);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1445, 56869, 56875).get(0), ParsedHeaderClause.class, 1445, 56869, 56882)) {
                            clauses = CallChecker.beforeCalled(clauses, List.class, 1445, 56869, 56875);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1445, 56869, 56875).get(0), ParsedHeaderClause.class, 1445, 56869, 56882).m_attrs, Map.class, 1445, 56869, 56890)) {
                                clauses = CallChecker.beforeCalled(clauses, List.class, 1445, 56869, 56875);
                                CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1445, 56869, 56875).get(0), ParsedHeaderClause.class, 1445, 56869, 56882).m_attrs, Map.class, 1445, 56869, 56890).put(Constants.BUNDLE_VERSION_ATTRIBUTE, bundleVersion);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(clauses, List.class, 1449, 57081, 57087)) {
                        clauses = CallChecker.beforeCalled(clauses, List.class, 1449, 57081, 57087);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1449, 57081, 57087).get(0), ParsedHeaderClause.class, 1449, 57081, 57094)) {
                            if (CallChecker.beforeDeref(clauses, List.class, 1450, 57120, 57126)) {
                                clauses = CallChecker.beforeCalled(clauses, List.class, 1450, 57120, 57126);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1450, 57120, 57126).get(0), ParsedHeaderClause.class, 1450, 57120, 57133)) {
                                    clauses = CallChecker.beforeCalled(clauses, List.class, 1449, 57081, 57087);
                                    clauses = CallChecker.beforeCalled(clauses, List.class, 1450, 57120, 57126);
                                    return new BundleCapabilityImpl(owner, BundleRevision.BUNDLE_NAMESPACE, CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1449, 57081, 57087).get(0), ParsedHeaderClause.class, 1449, 57081, 57094).m_dirs, CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1450, 57120, 57126).get(0), ParsedHeaderClause.class, 1450, 57120, 57133).m_attrs);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleCapabilityImpl) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1686.methodEnd();
        }
    }

    private static BundleCapabilityImpl addIdentityCapability(BundleRevision owner, Map headerMap, BundleCapabilityImpl bundleCap) {
        MethodContext _bcornu_methode_context1687 = new MethodContext(BundleCapabilityImpl.class);
        try {
            CallChecker.varInit(bundleCap, "bundleCap", 1456, 57188, 59238);
            CallChecker.varInit(headerMap, "headerMap", 1456, 57188, 59238);
            CallChecker.varInit(owner, "owner", 1456, 57188, 59238);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1456, 57188, 59238);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1456, 57188, 59238);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1456, 57188, 59238);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1456, 57188, 59238);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1456, 57188, 59238);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1456, 57188, 59238);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1456, 57188, 59238);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1456, 57188, 59238);
            Map<String, Object> attrs = CallChecker.varInit(new HashMap<String, Object>(), "attrs", 1459, 57337, 57394);
            if (CallChecker.beforeDeref(bundleCap, BundleCapabilityImpl.class, 1462, 57465, 57473)) {
                bundleCap = CallChecker.beforeCalled(bundleCap, BundleCapabilityImpl.class, 1462, 57465, 57473);
                final Map<String, Object> npe_invocation_var554 = CallChecker.isCalled(bundleCap, BundleCapabilityImpl.class, 1462, 57465, 57473).getAttributes();
                if (CallChecker.beforeDeref(npe_invocation_var554, Map.class, 1462, 57465, 57489)) {
                    if (CallChecker.beforeDeref(attrs, Map.class, 1461, 57405, 57409)) {
                        attrs = CallChecker.beforeCalled(attrs, Map.class, 1461, 57405, 57409);
                        CallChecker.isCalled(attrs, Map.class, 1461, 57405, 57409).put(IdentityNamespace.IDENTITY_NAMESPACE, CallChecker.isCalled(npe_invocation_var554, Map.class, 1462, 57465, 57489).get(BundleNamespace.BUNDLE_NAMESPACE));
                    }
                }
            }
            if (CallChecker.beforeDeref(headerMap, Map.class, 1464, 57606, 57614)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1464, 57606, 57614);
                if ((CallChecker.isCalled(headerMap, Map.class, 1464, 57606, 57614).get(Constants.FRAGMENT_HOST)) == null) {
                    if (CallChecker.beforeDeref(attrs, Map.class, 1463, 57539, 57543)) {
                        attrs = CallChecker.beforeCalled(attrs, Map.class, 1463, 57539, 57543);
                        CallChecker.isCalled(attrs, Map.class, 1463, 57539, 57543).put(IdentityNamespace.CAPABILITY_TYPE_ATTRIBUTE, IdentityNamespace.TYPE_BUNDLE);
                    }
                }else {
                    if (CallChecker.beforeDeref(attrs, Map.class, 1463, 57539, 57543)) {
                        attrs = CallChecker.beforeCalled(attrs, Map.class, 1463, 57539, 57543);
                        CallChecker.isCalled(attrs, Map.class, 1463, 57539, 57543).put(IdentityNamespace.CAPABILITY_TYPE_ATTRIBUTE, IdentityNamespace.TYPE_FRAGMENT);
                    }
                }
            }
            if (CallChecker.beforeDeref(bundleCap, BundleCapabilityImpl.class, 1468, 57823, 57831)) {
                bundleCap = CallChecker.beforeCalled(bundleCap, BundleCapabilityImpl.class, 1468, 57823, 57831);
                final Map<String, Object> npe_invocation_var555 = CallChecker.isCalled(bundleCap, BundleCapabilityImpl.class, 1468, 57823, 57831).getAttributes();
                if (CallChecker.beforeDeref(npe_invocation_var555, Map.class, 1468, 57823, 57847)) {
                    if (CallChecker.beforeDeref(attrs, Map.class, 1467, 57753, 57757)) {
                        attrs = CallChecker.beforeCalled(attrs, Map.class, 1467, 57753, 57757);
                        CallChecker.isCalled(attrs, Map.class, 1467, 57753, 57757).put(IdentityNamespace.CAPABILITY_VERSION_ATTRIBUTE, CallChecker.isCalled(npe_invocation_var555, Map.class, 1468, 57823, 57847).get(Constants.BUNDLE_VERSION_ATTRIBUTE));
                    }
                }
            }
            if (CallChecker.beforeDeref(headerMap, Map.class, 1470, 57904, 57912)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1470, 57904, 57912);
                if ((CallChecker.isCalled(headerMap, Map.class, 1470, 57904, 57912).get(Constants.BUNDLE_COPYRIGHT)) != null) {
                    if (CallChecker.beforeDeref(headerMap, Map.class, 1473, 58053, 58061)) {
                        if (CallChecker.beforeDeref(attrs, Map.class, 1472, 57977, 57981)) {
                            headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1473, 58053, 58061);
                            attrs = CallChecker.beforeCalled(attrs, Map.class, 1472, 57977, 57981);
                            CallChecker.isCalled(attrs, Map.class, 1472, 57977, 57981).put(IdentityNamespace.CAPABILITY_COPYRIGHT_ATTRIBUTE, CallChecker.isCalled(headerMap, Map.class, 1473, 58053, 58061).get(Constants.BUNDLE_COPYRIGHT));
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(headerMap, Map.class, 1476, 58120, 58128)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1476, 58120, 58128);
                if ((CallChecker.isCalled(headerMap, Map.class, 1476, 58120, 58128).get(Constants.BUNDLE_DESCRIPTION)) != null) {
                    if (CallChecker.beforeDeref(headerMap, Map.class, 1479, 58273, 58281)) {
                        if (CallChecker.beforeDeref(attrs, Map.class, 1478, 58195, 58199)) {
                            headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1479, 58273, 58281);
                            attrs = CallChecker.beforeCalled(attrs, Map.class, 1478, 58195, 58199);
                            CallChecker.isCalled(attrs, Map.class, 1478, 58195, 58199).put(IdentityNamespace.CAPABILITY_DESCRIPTION_ATTRIBUTE, CallChecker.isCalled(headerMap, Map.class, 1479, 58273, 58281).get(Constants.BUNDLE_DESCRIPTION));
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(headerMap, Map.class, 1481, 58341, 58349)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1481, 58341, 58349);
                if ((CallChecker.isCalled(headerMap, Map.class, 1481, 58341, 58349).get(Constants.BUNDLE_DOCURL)) != null) {
                    if (CallChecker.beforeDeref(headerMap, Map.class, 1484, 58491, 58499)) {
                        if (CallChecker.beforeDeref(attrs, Map.class, 1483, 58411, 58415)) {
                            headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1484, 58491, 58499);
                            attrs = CallChecker.beforeCalled(attrs, Map.class, 1483, 58411, 58415);
                            CallChecker.isCalled(attrs, Map.class, 1483, 58411, 58415).put(IdentityNamespace.CAPABILITY_DOCUMENTATION_ATTRIBUTE, CallChecker.isCalled(headerMap, Map.class, 1484, 58491, 58499).get(Constants.BUNDLE_DOCURL));
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(headerMap, Map.class, 1486, 58554, 58562)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1486, 58554, 58562);
                if ((CallChecker.isCalled(headerMap, Map.class, 1486, 58554, 58562).get(ManifestParser.BUNDLE_LICENSE_HEADER)) != null) {
                    if (CallChecker.beforeDeref(headerMap, Map.class, 1489, 58696, 58704)) {
                        if (CallChecker.beforeDeref(attrs, Map.class, 1488, 58622, 58626)) {
                            headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1489, 58696, 58704);
                            attrs = CallChecker.beforeCalled(attrs, Map.class, 1488, 58622, 58626);
                            CallChecker.isCalled(attrs, Map.class, 1488, 58622, 58626).put(IdentityNamespace.CAPABILITY_LICENSE_ATTRIBUTE, CallChecker.isCalled(headerMap, Map.class, 1489, 58696, 58704).get(ManifestParser.BUNDLE_LICENSE_HEADER));
                        }
                    }
                }
            }
            Map<String, String> dirs = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(bundleCap, BundleCapabilityImpl.class, 1493, 58792, 58800)) {
                bundleCap = CallChecker.beforeCalled(bundleCap, BundleCapabilityImpl.class, 1493, 58792, 58800);
                final Map<String, String> npe_invocation_var556 = CallChecker.isCalled(bundleCap, BundleCapabilityImpl.class, 1493, 58792, 58800).getDirectives();
                if (CallChecker.beforeDeref(npe_invocation_var556, Map.class, 1493, 58792, 58816)) {
                    if ((CallChecker.isCalled(npe_invocation_var556, Map.class, 1493, 58792, 58816).get(Constants.SINGLETON_DIRECTIVE)) != null) {
                        if (CallChecker.beforeDeref(bundleCap, BundleCapabilityImpl.class, 1496, 58986, 58994)) {
                            bundleCap = CallChecker.beforeCalled(bundleCap, BundleCapabilityImpl.class, 1496, 58986, 58994);
                            final Map<String, String> npe_invocation_var557 = CallChecker.isCalled(bundleCap, BundleCapabilityImpl.class, 1496, 58986, 58994).getDirectives();
                            if (CallChecker.beforeDeref(npe_invocation_var557, Map.class, 1496, 58986, 59010)) {
                                dirs = Collections.singletonMap(IdentityNamespace.CAPABILITY_SINGLETON_DIRECTIVE, CallChecker.isCalled(npe_invocation_var557, Map.class, 1496, 58986, 59010).get(Constants.SINGLETON_DIRECTIVE));
                                CallChecker.varAssign(dirs, "dirs", 1495, 58884, 59047);
                            }
                        }
                    }else {
                        dirs = Collections.emptyMap();
                        CallChecker.varAssign(dirs, "dirs", 1500, 59094, 59123);
                    }
                }
            }
            return new BundleCapabilityImpl(owner, IdentityNamespace.IDENTITY_NAMESPACE, dirs, attrs);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleCapabilityImpl) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1687.methodEnd();
        }
    }

    private static List<BundleRequirementImpl> parseFragmentHost(Logger logger, BundleRevision owner, Map headerMap) throws BundleException {
        MethodContext _bcornu_methode_context1688 = new MethodContext(List.class);
        try {
            CallChecker.varInit(headerMap, "headerMap", 1505, 59245, 63026);
            CallChecker.varInit(owner, "owner", 1505, 59245, 63026);
            CallChecker.varInit(logger, "logger", 1505, 59245, 63026);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1505, 59245, 63026);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1505, 59245, 63026);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1505, 59245, 63026);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1505, 59245, 63026);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1505, 59245, 63026);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1505, 59245, 63026);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1505, 59245, 63026);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1505, 59245, 63026);
            List<BundleRequirementImpl> reqs = CallChecker.varInit(new ArrayList(), "reqs", 1509, 59412, 59462);
            String mv = CallChecker.varInit(ManifestParser.getManifestVersion(headerMap), "mv", 1511, 59473, 59514);
            if ((mv != null) && (mv.equals("2"))) {
                List<ParsedHeaderClause> clauses = CallChecker.init(List.class);
                if (CallChecker.beforeDeref(headerMap, Map.class, 1515, 59663, 59671)) {
                    headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1515, 59663, 59671);
                    clauses = ManifestParser.parseStandardHeader(((String) (CallChecker.isCalled(headerMap, Map.class, 1515, 59663, 59671).get(Constants.FRAGMENT_HOST))));
                    CallChecker.varAssign(clauses, "clauses", 1515, 59663, 59671);
                }
                if (CallChecker.beforeDeref(clauses, List.class, 1516, 59720, 59726)) {
                    clauses = CallChecker.beforeCalled(clauses, List.class, 1516, 59720, 59726);
                    if ((CallChecker.isCalled(clauses, List.class, 1516, 59720, 59726).size()) > 0) {
                        if (CallChecker.beforeDeref(clauses, List.class, 1519, 59859, 59865)) {
                            clauses = CallChecker.beforeCalled(clauses, List.class, 1519, 59859, 59865);
                            if ((CallChecker.isCalled(clauses, List.class, 1519, 59859, 59865).size()) > 1) {
                                if (CallChecker.beforeDeref(headerMap, Map.class, 1523, 60039, 60047)) {
                                    headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1523, 60039, 60047);
                                    throw new BundleException(("Fragments cannot have multiple hosts: " + (CallChecker.isCalled(headerMap, Map.class, 1523, 60039, 60047).get(Constants.FRAGMENT_HOST))));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                if (CallChecker.beforeDeref(clauses, List.class, 1525, 60123, 60129)) {
                                    clauses = CallChecker.beforeCalled(clauses, List.class, 1525, 60123, 60129);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1525, 60123, 60129).get(0), ParsedHeaderClause.class, 1525, 60123, 60136)) {
                                        clauses = CallChecker.beforeCalled(clauses, List.class, 1525, 60123, 60129);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1525, 60123, 60129).get(0), ParsedHeaderClause.class, 1525, 60123, 60136).m_paths, List.class, 1525, 60123, 60144)) {
                                            clauses = CallChecker.beforeCalled(clauses, List.class, 1525, 60123, 60129);
                                            if ((CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1525, 60123, 60129).get(0), ParsedHeaderClause.class, 1525, 60123, 60136).m_paths, List.class, 1525, 60123, 60144).size()) > 1) {
                                                if (CallChecker.beforeDeref(headerMap, Map.class, 1529, 60318, 60326)) {
                                                    headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1529, 60318, 60326);
                                                    throw new BundleException(("Fragments cannot have multiple hosts: " + (CallChecker.isCalled(headerMap, Map.class, 1529, 60318, 60326).get(Constants.FRAGMENT_HOST))));
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                        Object value = CallChecker.init(Object.class);
                        if (CallChecker.beforeDeref(clauses, List.class, 1534, 60529, 60535)) {
                            clauses = CallChecker.beforeCalled(clauses, List.class, 1534, 60529, 60535);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1534, 60529, 60535).get(0), ParsedHeaderClause.class, 1534, 60529, 60542)) {
                                clauses = CallChecker.beforeCalled(clauses, List.class, 1534, 60529, 60535);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1534, 60529, 60535).get(0), ParsedHeaderClause.class, 1534, 60529, 60542).m_attrs, Map.class, 1534, 60529, 60550)) {
                                    clauses = CallChecker.beforeCalled(clauses, List.class, 1534, 60529, 60535);
                                    value = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1534, 60529, 60535).get(0), ParsedHeaderClause.class, 1534, 60529, 60542).m_attrs, Map.class, 1534, 60529, 60550).get(Constants.BUNDLE_VERSION_ATTRIBUTE);
                                    CallChecker.varAssign(value, "value", 1534, 60529, 60535);
                                }
                            }
                        }
                        if (value == null) {
                            value = "0.0.0";
                            CallChecker.varAssign(value, "value", 1535, 60609, 60650);
                        }else {
                            value = value;
                            CallChecker.varAssign(value, "value", 1535, 60609, 60650);
                        }
                        if (value != null) {
                            if (CallChecker.beforeDeref(clauses, List.class, 1538, 60725, 60731)) {
                                clauses = CallChecker.beforeCalled(clauses, List.class, 1538, 60725, 60731);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1538, 60725, 60731).get(0), ParsedHeaderClause.class, 1538, 60725, 60738)) {
                                    clauses = CallChecker.beforeCalled(clauses, List.class, 1538, 60725, 60731);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1538, 60725, 60731).get(0), ParsedHeaderClause.class, 1538, 60725, 60738).m_attrs, Map.class, 1538, 60725, 60746)) {
                                        clauses = CallChecker.beforeCalled(clauses, List.class, 1538, 60725, 60731);
                                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1538, 60725, 60731).get(0), ParsedHeaderClause.class, 1538, 60725, 60738).m_attrs, Map.class, 1538, 60725, 60746).put(Constants.BUNDLE_VERSION_ATTRIBUTE, VersionRange.parse(value.toString()));
                                    }
                                }
                            }
                        }
                        Map<String, Object> attrs = CallChecker.init(Map.class);
                        if (CallChecker.beforeDeref(clauses, List.class, 1548, 61252, 61258)) {
                            clauses = CallChecker.beforeCalled(clauses, List.class, 1548, 61252, 61258);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1548, 61252, 61258).get(0), ParsedHeaderClause.class, 1548, 61252, 61265)) {
                                clauses = CallChecker.beforeCalled(clauses, List.class, 1548, 61252, 61258);
                                attrs = CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1548, 61252, 61258).get(0), ParsedHeaderClause.class, 1548, 61252, 61265).m_attrs;
                                CallChecker.varAssign(attrs, "attrs", 1548, 61252, 61258);
                            }
                        }
                        Map<String, Object> newAttrs = CallChecker.init(Map.class);
                        if (CallChecker.beforeDeref(attrs, Map.class, 1549, 61357, 61361)) {
                            attrs = CallChecker.beforeCalled(attrs, Map.class, 1549, 61357, 61361);
                            newAttrs = new LinkedHashMap<String, Object>(((CallChecker.isCalled(attrs, Map.class, 1549, 61357, 61361).size()) + 1));
                            CallChecker.varAssign(newAttrs, "newAttrs", 1549, 61357, 61361);
                        }
                        if (CallChecker.beforeDeref(clauses, List.class, 1553, 61545, 61551)) {
                            clauses = CallChecker.beforeCalled(clauses, List.class, 1553, 61545, 61551);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1553, 61545, 61551).get(0), ParsedHeaderClause.class, 1553, 61545, 61558)) {
                                clauses = CallChecker.beforeCalled(clauses, List.class, 1553, 61545, 61551);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1553, 61545, 61551).get(0), ParsedHeaderClause.class, 1553, 61545, 61558).m_paths, List.class, 1553, 61545, 61566)) {
                                    if (CallChecker.beforeDeref(newAttrs, Map.class, 1551, 61460, 61467)) {
                                        clauses = CallChecker.beforeCalled(clauses, List.class, 1553, 61545, 61551);
                                        newAttrs = CallChecker.beforeCalled(newAttrs, Map.class, 1551, 61460, 61467);
                                        CallChecker.isCalled(newAttrs, Map.class, 1551, 61460, 61467).put(BundleRevision.HOST_NAMESPACE, CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1553, 61545, 61551).get(0), ParsedHeaderClause.class, 1553, 61545, 61558).m_paths, List.class, 1553, 61545, 61566).get(0));
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(newAttrs, Map.class, 1554, 61593, 61600)) {
                            newAttrs = CallChecker.beforeCalled(newAttrs, Map.class, 1554, 61593, 61600);
                            CallChecker.isCalled(newAttrs, Map.class, 1554, 61593, 61600).putAll(attrs);
                        }
                        if (CallChecker.beforeDeref(clauses, List.class, 1558, 61801, 61807)) {
                            clauses = CallChecker.beforeCalled(clauses, List.class, 1558, 61801, 61807);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1558, 61801, 61807).get(0), ParsedHeaderClause.class, 1558, 61801, 61814)) {
                                clauses = CallChecker.beforeCalled(clauses, List.class, 1558, 61801, 61807);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1558, 61801, 61807).get(0), ParsedHeaderClause.class, 1558, 61801, 61814).m_paths, List.class, 1558, 61801, 61822)) {
                                    if (CallChecker.beforeDeref(newAttrs, Map.class, 1556, 61716, 61723)) {
                                        clauses = CallChecker.beforeCalled(clauses, List.class, 1558, 61801, 61807);
                                        newAttrs = CallChecker.beforeCalled(newAttrs, Map.class, 1556, 61716, 61723);
                                        CallChecker.isCalled(newAttrs, Map.class, 1556, 61716, 61723).put(BundleRevision.HOST_NAMESPACE, CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1558, 61801, 61807).get(0), ParsedHeaderClause.class, 1558, 61801, 61814).m_paths, List.class, 1558, 61801, 61822).get(0));
                                    }
                                }
                            }
                        }
                        SimpleFilter sf = CallChecker.varInit(SimpleFilter.convert(newAttrs), "sf", 1561, 61922, 61970);
                        Map<String, String> dirs = CallChecker.init(Map.class);
                        if (CallChecker.beforeDeref(clauses, List.class, 1565, 62119, 62125)) {
                            clauses = CallChecker.beforeCalled(clauses, List.class, 1565, 62119, 62125);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1565, 62119, 62125).get(0), ParsedHeaderClause.class, 1565, 62119, 62132)) {
                                clauses = CallChecker.beforeCalled(clauses, List.class, 1565, 62119, 62125);
                                dirs = CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1565, 62119, 62125).get(0), ParsedHeaderClause.class, 1565, 62119, 62132).m_dirs;
                                CallChecker.varAssign(dirs, "dirs", 1565, 62119, 62125);
                            }
                        }
                        Map<String, String> newDirs = CallChecker.init(Map.class);
                        if (CallChecker.beforeDeref(dirs, Map.class, 1566, 62216, 62219)) {
                            dirs = CallChecker.beforeCalled(dirs, Map.class, 1566, 62216, 62219);
                            newDirs = new HashMap<String, String>(((CallChecker.isCalled(dirs, Map.class, 1566, 62216, 62219).size()) + 1));
                            CallChecker.varAssign(newDirs, "newDirs", 1566, 62216, 62219);
                        }
                        if (CallChecker.beforeDeref(newDirs, Map.class, 1567, 62250, 62256)) {
                            newDirs = CallChecker.beforeCalled(newDirs, Map.class, 1567, 62250, 62256);
                            CallChecker.isCalled(newDirs, Map.class, 1567, 62250, 62256).putAll(dirs);
                        }
                        if (CallChecker.beforeDeref(sf, SimpleFilter.class, 1570, 62369, 62370)) {
                            if (CallChecker.beforeDeref(newDirs, Map.class, 1568, 62288, 62294)) {
                                sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 1570, 62369, 62370);
                                newDirs = CallChecker.beforeCalled(newDirs, Map.class, 1568, 62288, 62294);
                                CallChecker.isCalled(newDirs, Map.class, 1568, 62288, 62294).put(Constants.FILTER_DIRECTIVE, CallChecker.isCalled(sf, SimpleFilter.class, 1570, 62369, 62370).toString());
                            }
                        }
                        if (CallChecker.beforeDeref(reqs, List.class, 1572, 62402, 62405)) {
                            reqs = CallChecker.beforeCalled(reqs, List.class, 1572, 62402, 62405);
                            CallChecker.isCalled(reqs, List.class, 1572, 62402, 62405).add(new BundleRequirementImpl(owner, BundleRevision.HOST_NAMESPACE, newDirs, newAttrs));
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (CallChecker.beforeDeref(headerMap, Map.class, 1578, 62598, 62606)) {
                    headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1578, 62598, 62606);
                    if ((CallChecker.isCalled(headerMap, Map.class, 1578, 62598, 62606).get(Constants.FRAGMENT_HOST)) != null) {
                        String s = CallChecker.init(String.class);
                        if (CallChecker.beforeDeref(headerMap, Map.class, 1580, 62688, 62696)) {
                            headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1580, 62688, 62696);
                            s = ((String) (CallChecker.isCalled(headerMap, Map.class, 1580, 62688, 62696).get(Constants.BUNDLE_SYMBOLICNAME)));
                            CallChecker.varAssign(s, "s", 1580, 62688, 62696);
                        }
                        if (s == null) {
                            if (CallChecker.beforeDeref(headerMap, Map.class, 1581, 62773, 62781)) {
                                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1581, 62773, 62781);
                                s = ((String) (CallChecker.isCalled(headerMap, Map.class, 1581, 62773, 62781).get(Constants.BUNDLE_NAME)));
                                CallChecker.varAssign(s, "s", 1581, 62746, 62813);
                            }
                        }else {
                            s = s;
                            CallChecker.varAssign(s, "s", 1581, 62746, 62813);
                        }
                        if (s == null) {
                            if (CallChecker.beforeDeref(headerMap, Map.class, 1582, 62845, 62853)) {
                                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1582, 62845, 62853);
                                s = CallChecker.isCalled(headerMap, Map.class, 1582, 62845, 62853).toString();
                                CallChecker.varAssign(s, "s", 1582, 62827, 62869);
                            }
                        }else {
                            s = s;
                            CallChecker.varAssign(s, "s", 1582, 62827, 62869);
                        }
                        if (CallChecker.beforeDeref(logger, Logger.class, 1583, 62883, 62888)) {
                            logger = CallChecker.beforeCalled(logger, Logger.class, 1583, 62883, 62888);
                            CallChecker.isCalled(logger, Logger.class, 1583, 62883, 62888).log(Logger.LOG_WARNING, ("Only R4 bundles can be fragments: " + s));
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            
            return reqs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRequirementImpl>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1688.methodEnd();
        }
    }

    public static List<BundleCapability> parseExportHeader(Logger logger, BundleRevision owner, String header, String bsn, Version bv) {
        MethodContext _bcornu_methode_context1689 = new MethodContext(List.class);
        try {
            CallChecker.varInit(bv, "bv", 1591, 63033, 63589);
            CallChecker.varInit(bsn, "bsn", 1591, 63033, 63589);
            CallChecker.varInit(header, "header", 1591, 63033, 63589);
            CallChecker.varInit(owner, "owner", 1591, 63033, 63589);
            CallChecker.varInit(logger, "logger", 1591, 63033, 63589);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1591, 63033, 63589);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1591, 63033, 63589);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1591, 63033, 63589);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1591, 63033, 63589);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1591, 63033, 63589);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1591, 63033, 63589);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1591, 63033, 63589);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1591, 63033, 63589);
            List<BundleCapability> caps = CallChecker.varInit(null, "caps", 1595, 63188, 63222);
            TryContext _bcornu_try_context_448 = new TryContext(448, ManifestParser.class, "org.osgi.framework.BundleException");
            try {
                List<ParsedHeaderClause> exportClauses = CallChecker.varInit(ManifestParser.parseStandardHeader(header), "exportClauses", 1598, 63258, 63326);
                exportClauses = ManifestParser.normalizeExportClauses(logger, exportClauses, "2", bsn, bv);
                CallChecker.varAssign(exportClauses, "exportClauses", 1599, 63340, 63415);
                caps = ManifestParser.convertExports(exportClauses, owner);
                CallChecker.varAssign(caps, "caps", 1600, 63429, 63472);
            } catch (BundleException ex) {
                _bcornu_try_context_448.catchStart(448);
                caps = null;
                CallChecker.varAssign(caps, "caps", 1604, 63541, 63552);
            } finally {
                _bcornu_try_context_448.finallyStart(448);
            }
            return caps;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1689.methodEnd();
        }
    }

    private static List<BundleRequirement> parseBreeHeader(String header, BundleRevision owner) {
        MethodContext _bcornu_methode_context1690 = new MethodContext(List.class);
        try {
            CallChecker.varInit(owner, "owner", 1609, 63596, 67383);
            CallChecker.varInit(header, "header", 1609, 63596, 67383);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1609, 63596, 67383);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1609, 63596, 67383);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1609, 63596, 67383);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1609, 63596, 67383);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1609, 63596, 67383);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1609, 63596, 67383);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1609, 63596, 67383);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1609, 63596, 67383);
            List<String> filters = CallChecker.varInit(new ArrayList<String>(), "filters", 1611, 63702, 63748);
            for (String entry : ManifestParser.parseDelimitedString(header, ",")) {
                List<String> names = CallChecker.varInit(ManifestParser.parseDelimitedString(entry, "/"), "names", 1614, 63835, 63888);
                List<String> left = CallChecker.init(List.class);
                if (CallChecker.beforeDeref(names, List.class, 1615, 63943, 63947)) {
                    names = CallChecker.beforeCalled(names, List.class, 1615, 63943, 63947);
                    left = ManifestParser.parseDelimitedString(CallChecker.isCalled(names, List.class, 1615, 63943, 63947).get(0), "-");
                    CallChecker.varAssign(left, "left", 1615, 63943, 63947);
                }
                String lName = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(left, List.class, 1617, 63991, 63994)) {
                    left = CallChecker.beforeCalled(left, List.class, 1617, 63991, 63994);
                    lName = CallChecker.isCalled(left, List.class, 1617, 63991, 63994).get(0);
                    CallChecker.varAssign(lName, "lName", 1617, 63991, 63994);
                }
                Version lVer = CallChecker.init(Version.class);
                TryContext _bcornu_try_context_449 = new TryContext(449, ManifestParser.class, "java.lang.Exception");
                try {
                    if (CallChecker.beforeDeref(left, List.class, 1621, 64104, 64107)) {
                        left = CallChecker.beforeCalled(left, List.class, 1621, 64104, 64107);
                        lVer = Version.parseVersion(CallChecker.isCalled(left, List.class, 1621, 64104, 64107).get(1));
                        CallChecker.varAssign(lVer, "lVer", 1621, 64076, 64116);
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_449.catchStart(449);
                    if (CallChecker.beforeDeref(names, List.class, 1626, 64271, 64275)) {
                        names = CallChecker.beforeCalled(names, List.class, 1626, 64271, 64275);
                        lName = CallChecker.isCalled(names, List.class, 1626, 64271, 64275).get(0);
                        CallChecker.varAssign(lName, "lName", 1626, 64263, 64283);
                    }
                    lVer = null;
                    CallChecker.varAssign(lVer, "lVer", 1627, 64301, 64312);
                } finally {
                    _bcornu_try_context_449.finallyStart(449);
                }
                String rName = CallChecker.varInit(null, "rName", 1630, 64341, 64360);
                Version rVer = CallChecker.varInit(null, "rVer", 1631, 64374, 64393);
                if (CallChecker.beforeDeref(names, List.class, 1632, 64411, 64415)) {
                    names = CallChecker.beforeCalled(names, List.class, 1632, 64411, 64415);
                    if ((CallChecker.isCalled(names, List.class, 1632, 64411, 64415).size()) > 1) {
                        List<String> right = CallChecker.init(List.class);
                        if (CallChecker.beforeDeref(names, List.class, 1634, 64501, 64505)) {
                            names = CallChecker.beforeCalled(names, List.class, 1634, 64501, 64505);
                            right = ManifestParser.parseDelimitedString(CallChecker.isCalled(names, List.class, 1634, 64501, 64505).get(1), "-");
                            CallChecker.varAssign(right, "right", 1634, 64501, 64505);
                        }
                        if (CallChecker.beforeDeref(right, List.class, 1635, 64545, 64549)) {
                            right = CallChecker.beforeCalled(right, List.class, 1635, 64545, 64549);
                            rName = CallChecker.isCalled(right, List.class, 1635, 64545, 64549).get(0);
                            CallChecker.varAssign(rName, "rName", 1635, 64537, 64557);
                        }
                        TryContext _bcornu_try_context_450 = new TryContext(450, ManifestParser.class, "java.lang.Exception");
                        try {
                            if (CallChecker.beforeDeref(right, List.class, 1638, 64645, 64649)) {
                                right = CallChecker.beforeCalled(right, List.class, 1638, 64645, 64649);
                                rVer = Version.parseVersion(CallChecker.isCalled(right, List.class, 1638, 64645, 64649).get(1));
                                CallChecker.varAssign(rVer, "rVer", 1638, 64617, 64658);
                            }
                        } catch (Exception ex) {
                            _bcornu_try_context_450.catchStart(450);
                            if (CallChecker.beforeDeref(names, List.class, 1642, 64761, 64765)) {
                                names = CallChecker.beforeCalled(names, List.class, 1642, 64761, 64765);
                                rName = CallChecker.isCalled(names, List.class, 1642, 64761, 64765).get(1);
                                CallChecker.varAssign(rName, "rName", 1642, 64753, 64773);
                            }
                            rVer = null;
                            CallChecker.varAssign(rVer, "rVer", 1643, 64795, 64806);
                        } finally {
                            _bcornu_try_context_450.finallyStart(450);
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                String versionClause = CallChecker.init(String.class);
                if (lVer != null) {
                    if ((rVer != null) && (!(rVer.equals(lVer)))) {
                        if (CallChecker.beforeDeref(names, List.class, 1653, 65125, 65129)) {
                            names = CallChecker.beforeCalled(names, List.class, 1653, 65125, 65129);
                            lName = CallChecker.isCalled(names, List.class, 1653, 65125, 65129).get(0);
                            CallChecker.varAssign(lName, "lName", 1653, 65117, 65137);
                        }
                        if (CallChecker.beforeDeref(names, List.class, 1654, 65167, 65171)) {
                            names = CallChecker.beforeCalled(names, List.class, 1654, 65167, 65171);
                            rName = CallChecker.isCalled(names, List.class, 1654, 65167, 65171).get(1);
                            CallChecker.varAssign(rName, "rName", 1654, 65159, 65179);
                        }
                        versionClause = null;
                        CallChecker.varAssign(versionClause, "versionClause", 1655, 65201, 65221);
                    }else {
                        versionClause = ManifestParser.getBreeVersionClause(lVer);
                        CallChecker.varAssign(versionClause, "versionClause", 1659, 65300, 65342);
                    }
                }else {
                    versionClause = ManifestParser.getBreeVersionClause(rVer);
                    CallChecker.varAssign(versionClause, "versionClause", 1664, 65423, 65465);
                }
                if (CallChecker.beforeDeref("J2SE", String.class, 1667, 65498, 65503)) {
                    if (CallChecker.isCalled("J2SE", String.class, 1667, 65498, 65503).equals(lName)) {
                        lName = "JavaSE";
                        CallChecker.varAssign(lName, "lName", 1671, 65700, 65716);
                    }
                }
                String nameClause = CallChecker.init(String.class);
                if (rName != null) {
                    nameClause = ((((("(" + (ExecutionEnvironmentNamespace.EXECUTION_ENVIRONMENT_NAMESPACE)) + "=") + lName) + "/") + rName) + ")";
                    CallChecker.varAssign(nameClause, "nameClause", 1676, 65811, 65925);
                }else {
                    nameClause = ((("(" + (ExecutionEnvironmentNamespace.EXECUTION_ENVIRONMENT_NAMESPACE)) + "=") + lName) + ")";
                    CallChecker.varAssign(nameClause, "nameClause", 1678, 65960, 66060);
                }
                String filter = CallChecker.init(String.class);
                if (versionClause != null) {
                    filter = (("(&" + nameClause) + versionClause) + ")";
                    CallChecker.varAssign(filter, "filter", 1682, 66145, 66193);
                }else {
                    filter = nameClause;
                    CallChecker.varAssign(filter, "filter", 1684, 66228, 66247);
                }
                if (CallChecker.beforeDeref(filters, List.class, 1686, 66262, 66268)) {
                    filters = CallChecker.beforeCalled(filters, List.class, 1686, 66262, 66268);
                    CallChecker.isCalled(filters, List.class, 1686, 66262, 66268).add(filter);
                }
            }
            if (CallChecker.beforeDeref(filters, List.class, 1689, 66306, 66312)) {
                filters = CallChecker.beforeCalled(filters, List.class, 1689, 66306, 66312);
                if ((CallChecker.isCalled(filters, List.class, 1689, 66306, 66312).size()) == 0) {
                    return Collections.emptyList();
                }else {
                    String reqFilter = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(filters, List.class, 1696, 66460, 66466)) {
                        filters = CallChecker.beforeCalled(filters, List.class, 1696, 66460, 66466);
                        if ((CallChecker.isCalled(filters, List.class, 1696, 66460, 66466).size()) == 1) {
                            if (CallChecker.beforeDeref(filters, List.class, 1698, 66523, 66529)) {
                                filters = CallChecker.beforeCalled(filters, List.class, 1698, 66523, 66529);
                                reqFilter = CallChecker.isCalled(filters, List.class, 1698, 66523, 66529).get(0);
                                CallChecker.varAssign(reqFilter, "reqFilter", 1698, 66511, 66537);
                            }
                        }else {
                            StringBuilder sb = CallChecker.varInit(new StringBuilder("(|"), "sb", 1703, 66679, 66721);
                            if (CallChecker.beforeDeref(filters, List.class, 1704, 66755, 66761)) {
                                for (String f : filters) {
                                    if (CallChecker.beforeDeref(sb, StringBuilder.class, 1706, 66802, 66803)) {
                                        sb = CallChecker.beforeCalled(sb, StringBuilder.class, 1706, 66802, 66803);
                                        CallChecker.isCalled(sb, StringBuilder.class, 1706, 66802, 66803).append(f);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(sb, StringBuilder.class, 1708, 66850, 66851)) {
                                sb = CallChecker.beforeCalled(sb, StringBuilder.class, 1708, 66850, 66851);
                                CallChecker.isCalled(sb, StringBuilder.class, 1708, 66850, 66851).append(")");
                            }
                            if (CallChecker.beforeDeref(sb, StringBuilder.class, 1709, 66894, 66895)) {
                                sb = CallChecker.beforeCalled(sb, StringBuilder.class, 1709, 66894, 66895);
                                reqFilter = CallChecker.isCalled(sb, StringBuilder.class, 1709, 66894, 66895).toString();
                                CallChecker.varAssign(reqFilter, "reqFilter", 1709, 66882, 66907);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    SimpleFilter sf = CallChecker.varInit(SimpleFilter.parse(reqFilter), "sf", 1712, 66936, 66983);
                    return Collections.<BundleRequirement>singletonList(new BundleRequirementImpl(owner, ExecutionEnvironmentNamespace.EXECUTION_ENVIRONMENT_NAMESPACE, Collections.singletonMap(ExecutionEnvironmentNamespace.REQUIREMENT_FILTER_DIRECTIVE, reqFilter), Collections.<String, Object>emptyMap(), sf));
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRequirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1690.methodEnd();
        }
    }

    private static String getBreeVersionClause(Version ver) {
        MethodContext _bcornu_methode_context1691 = new MethodContext(String.class);
        try {
            CallChecker.varInit(ver, "ver", 1722, 67390, 67602);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1722, 67390, 67602);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1722, 67390, 67602);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1722, 67390, 67602);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1722, 67390, 67602);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1722, 67390, 67602);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1722, 67390, 67602);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1722, 67390, 67602);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1722, 67390, 67602);
            if (ver == null)
                return null;
            
            return ((("(" + (ExecutionEnvironmentNamespace.CAPABILITY_VERSION_ATTRIBUTE)) + "=") + ver) + ")";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1691.methodEnd();
        }
    }

    private static List<ParsedHeaderClause> normalizeRequireClauses(Logger logger, List<ParsedHeaderClause> clauses, String mv) {
        MethodContext _bcornu_methode_context1692 = new MethodContext(List.class);
        try {
            CallChecker.varInit(mv, "mv", 1729, 67609, 68413);
            CallChecker.varInit(clauses, "clauses", 1729, 67609, 68413);
            CallChecker.varInit(logger, "logger", 1729, 67609, 68413);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1729, 67609, 68413);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1729, 67609, 68413);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1729, 67609, 68413);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1729, 67609, 68413);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1729, 67609, 68413);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1729, 67609, 68413);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1729, 67609, 68413);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1729, 67609, 68413);
            if (CallChecker.beforeDeref(mv, String.class, 1733, 67813, 67814)) {
                mv = CallChecker.beforeCalled(mv, String.class, 1733, 67813, 67814);
                if (!(CallChecker.isCalled(mv, String.class, 1733, 67813, 67814).equals("2"))) {
                    if (CallChecker.beforeDeref(clauses, List.class, 1735, 67851, 67857)) {
                        clauses = CallChecker.beforeCalled(clauses, List.class, 1735, 67851, 67857);
                        CallChecker.isCalled(clauses, List.class, 1735, 67851, 67857).clear();
                    }
                }else {
                    if (CallChecker.beforeDeref(clauses, List.class, 1740, 68016, 68022)) {
                        for (ParsedHeaderClause clause : clauses) {
                            Object value = CallChecker.init(Object.class);
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1742, 68070, 68075)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 1742, 68070, 68075).m_attrs, Map.class, 1742, 68070, 68083)) {
                                    value = CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 1742, 68070, 68075).m_attrs, Map.class, 1742, 68070, 68083).get(Constants.BUNDLE_VERSION_ATTRIBUTE);
                                    CallChecker.varAssign(value, "value", 1742, 68070, 68075);
                                }
                            }
                            if (value != null) {
                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1745, 68199, 68204)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 1745, 68199, 68204).m_attrs, Map.class, 1745, 68199, 68212)) {
                                        CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 1745, 68199, 68204).m_attrs, Map.class, 1745, 68199, 68212).put(Constants.BUNDLE_VERSION_ATTRIBUTE, VersionRange.parse(value.toString()));
                                    }
                                }
                            }
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return clauses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<ParsedHeaderClause>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1692.methodEnd();
        }
    }

    private static List<BundleRequirementImpl> convertRequires(List<ParsedHeaderClause> clauses, BundleRevision owner) {
        MethodContext _bcornu_methode_context1693 = new MethodContext(List.class);
        try {
            CallChecker.varInit(owner, "owner", 1755, 68420, 70606);
            CallChecker.varInit(clauses, "clauses", 1755, 68420, 70606);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1755, 68420, 70606);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1755, 68420, 70606);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1755, 68420, 70606);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1755, 68420, 70606);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1755, 68420, 70606);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1755, 68420, 70606);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1755, 68420, 70606);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1755, 68420, 70606);
            List<BundleRequirementImpl> reqList = CallChecker.varInit(new ArrayList(), "reqList", 1758, 68558, 68611);
            if (CallChecker.beforeDeref(clauses, List.class, 1759, 68654, 68660)) {
                for (ParsedHeaderClause clause : clauses) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 1761, 68704, 68709).m_paths, List.class, 1761, 68704, 68717)) {
                        for (String path : CallChecker.isCalled(clause, ParsedHeaderClause.class, 1761, 68704, 68709).m_paths) {
                            Map<String, Object> attrs = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1764, 68858, 68863)) {
                                attrs = CallChecker.isCalled(clause, ParsedHeaderClause.class, 1764, 68858, 68863).m_attrs;
                                CallChecker.varAssign(attrs, "attrs", 1764, 68858, 68863);
                            }
                            Map<String, Object> newAttrs = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(attrs, Map.class, 1770, 69270, 69274)) {
                                attrs = CallChecker.beforeCalled(attrs, Map.class, 1770, 69270, 69274);
                                newAttrs = new LinkedHashMap<String, Object>(((CallChecker.isCalled(attrs, Map.class, 1770, 69270, 69274).size()) + 1));
                                CallChecker.varAssign(newAttrs, "newAttrs", 1770, 69270, 69274);
                            }
                            if (CallChecker.beforeDeref(newAttrs, Map.class, 1772, 69373, 69380)) {
                                newAttrs = CallChecker.beforeCalled(newAttrs, Map.class, 1772, 69373, 69380);
                                CallChecker.isCalled(newAttrs, Map.class, 1772, 69373, 69380).put(BundleRevision.BUNDLE_NAMESPACE, path);
                            }
                            if (CallChecker.beforeDeref(newAttrs, Map.class, 1775, 69483, 69490)) {
                                newAttrs = CallChecker.beforeCalled(newAttrs, Map.class, 1775, 69483, 69490);
                                CallChecker.isCalled(newAttrs, Map.class, 1775, 69483, 69490).putAll(attrs);
                            }
                            if (CallChecker.beforeDeref(newAttrs, Map.class, 1777, 69606, 69613)) {
                                newAttrs = CallChecker.beforeCalled(newAttrs, Map.class, 1777, 69606, 69613);
                                CallChecker.isCalled(newAttrs, Map.class, 1777, 69606, 69613).put(BundleRevision.BUNDLE_NAMESPACE, path);
                            }
                            SimpleFilter sf = CallChecker.varInit(SimpleFilter.convert(newAttrs), "sf", 1782, 69789, 69837);
                            Map<String, String> dirs = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1786, 69986, 69991)) {
                                dirs = CallChecker.isCalled(clause, ParsedHeaderClause.class, 1786, 69986, 69991).m_dirs;
                                CallChecker.varAssign(dirs, "dirs", 1786, 69986, 69991);
                            }
                            Map<String, String> newDirs = CallChecker.init(Map.class);
                            if (CallChecker.beforeDeref(dirs, Map.class, 1787, 70075, 70078)) {
                                dirs = CallChecker.beforeCalled(dirs, Map.class, 1787, 70075, 70078);
                                newDirs = new HashMap<String, String>(((CallChecker.isCalled(dirs, Map.class, 1787, 70075, 70078).size()) + 1));
                                CallChecker.varAssign(newDirs, "newDirs", 1787, 70075, 70078);
                            }
                            if (CallChecker.beforeDeref(newDirs, Map.class, 1788, 70109, 70115)) {
                                newDirs = CallChecker.beforeCalled(newDirs, Map.class, 1788, 70109, 70115);
                                CallChecker.isCalled(newDirs, Map.class, 1788, 70109, 70115).putAll(dirs);
                            }
                            if (CallChecker.beforeDeref(sf, SimpleFilter.class, 1791, 70228, 70229)) {
                                if (CallChecker.beforeDeref(newDirs, Map.class, 1789, 70147, 70153)) {
                                    sf = CallChecker.beforeCalled(sf, SimpleFilter.class, 1791, 70228, 70229);
                                    newDirs = CallChecker.beforeCalled(newDirs, Map.class, 1789, 70147, 70153);
                                    CallChecker.isCalled(newDirs, Map.class, 1789, 70147, 70153).put(Constants.FILTER_DIRECTIVE, CallChecker.isCalled(sf, SimpleFilter.class, 1791, 70228, 70229).toString());
                                }
                            }
                            if (CallChecker.beforeDeref(reqList, List.class, 1794, 70336, 70342)) {
                                reqList = CallChecker.beforeCalled(reqList, List.class, 1794, 70336, 70342);
                                CallChecker.isCalled(reqList, List.class, 1794, 70336, 70342).add(new BundleRequirementImpl(owner, BundleRevision.BUNDLE_NAMESPACE, newDirs, newAttrs));
                            }
                        }
                    }
                }
            }
            return reqList;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRequirementImpl>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1693.methodEnd();
        }
    }

    public static String parseExtensionBundleHeader(String header) throws BundleException {
        MethodContext _bcornu_methode_context1694 = new MethodContext(String.class);
        try {
            CallChecker.varInit(header, "header", 1806, 70613, 71651);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1806, 70613, 71651);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1806, 70613, 71651);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1806, 70613, 71651);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1806, 70613, 71651);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1806, 70613, 71651);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1806, 70613, 71651);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1806, 70613, 71651);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1806, 70613, 71651);
            List<ParsedHeaderClause> clauses = CallChecker.varInit(ManifestParser.parseStandardHeader(header), "clauses", 1809, 70721, 70783);
            String result = CallChecker.varInit(null, "result", 1811, 70794, 70814);
            if (CallChecker.beforeDeref(clauses, List.class, 1813, 70829, 70835)) {
                clauses = CallChecker.beforeCalled(clauses, List.class, 1813, 70829, 70835);
                if ((CallChecker.isCalled(clauses, List.class, 1813, 70829, 70835).size()) == 1) {
                    clauses = CallChecker.beforeCalled(clauses, List.class, 1815, 70907, 70913);
                    for (Map.Entry<String, String> entry : CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1815, 70907, 70913).get(0), ParsedHeaderClause.class, 1815, 70907, 70920).m_dirs, Map.class, 1815, 70907, 70927).entrySet()) {
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 1817, 71012, 71016)) {
                            if (CallChecker.beforeDeref(Constants.EXTENSION_DIRECTIVE, String.class, 1817, 70975, 71003)) {
                                if (CallChecker.isCalled(Constants.EXTENSION_DIRECTIVE, String.class, 1817, 70975, 71003).equals(CallChecker.isCalled(entry, Map.Entry.class, 1817, 71012, 71016).getKey())) {
                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1819, 71076, 71080)) {
                                        result = CallChecker.isCalled(entry, Map.Entry.class, 1819, 71076, 71080).getValue();
                                        CallChecker.varAssign(result, "result", 1819, 71067, 71092);
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(clauses, List.class, 1823, 71192, 71198)) {
                        clauses = CallChecker.beforeCalled(clauses, List.class, 1823, 71192, 71198);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1823, 71192, 71198).get(0), ParsedHeaderClause.class, 1823, 71192, 71205)) {
                            clauses = CallChecker.beforeCalled(clauses, List.class, 1823, 71192, 71198);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1823, 71192, 71198).get(0), ParsedHeaderClause.class, 1823, 71192, 71205).m_paths, List.class, 1823, 71192, 71213)) {
                                if (CallChecker.beforeDeref(FelixConstants.SYSTEM_BUNDLE_SYMBOLICNAME, String.class, 1823, 71143, 71183)) {
                                    if (CallChecker.beforeDeref(clauses, List.class, 1824, 71286, 71292)) {
                                        clauses = CallChecker.beforeCalled(clauses, List.class, 1824, 71286, 71292);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(clauses, List.class, 1824, 71286, 71292).get(0), ParsedHeaderClause.class, 1824, 71286, 71299)) {
                                            clauses = CallChecker.beforeCalled(clauses, List.class, 1824, 71286, 71292);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1824, 71286, 71292).get(0), ParsedHeaderClause.class, 1824, 71286, 71299).m_paths, List.class, 1824, 71286, 71307)) {
                                                if (CallChecker.beforeDeref(Constants.SYSTEM_BUNDLE_SYMBOLICNAME, String.class, 1824, 71242, 71277)) {
                                                    clauses = CallChecker.beforeCalled(clauses, List.class, 1823, 71192, 71198);
                                                    clauses = CallChecker.beforeCalled(clauses, List.class, 1824, 71286, 71292);
                                                    if ((CallChecker.isCalled(FelixConstants.SYSTEM_BUNDLE_SYMBOLICNAME, String.class, 1823, 71143, 71183).equals(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1823, 71192, 71198).get(0), ParsedHeaderClause.class, 1823, 71192, 71205).m_paths, List.class, 1823, 71192, 71213).get(0))) || (CallChecker.isCalled(Constants.SYSTEM_BUNDLE_SYMBOLICNAME, String.class, 1824, 71242, 71277).equals(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1824, 71286, 71292).get(0), ParsedHeaderClause.class, 1824, 71286, 71299).m_paths, List.class, 1824, 71286, 71307).get(0)))) {
                                                        if (result == null) {
                                                            result = Constants.EXTENSION_FRAMEWORK;
                                                            CallChecker.varAssign(result, "result", 1826, 71348, 71414);
                                                        }else {
                                                            result = result;
                                                            CallChecker.varAssign(result, "result", 1826, 71348, 71414);
                                                        }
                                                    }else
                                                        if (result != null) {
                                                            throw new BundleException("Only the system bundle can have extension bundles.");
                                                        }
                                                    
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1694.methodEnd();
        }
    }

    private void parseActivationPolicy(Map headerMap) {
        MethodContext _bcornu_methode_context1695 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1838, 71658, 72924);
            CallChecker.varInit(headerMap, "headerMap", 1838, 71658, 72924);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1838, 71658, 72924);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1838, 71658, 72924);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1838, 71658, 72924);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1838, 71658, 72924);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1838, 71658, 72924);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1838, 71658, 72924);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1838, 71658, 72924);
            CallChecker.varInit(this.m_libraryHeadersOptional, "m_libraryHeadersOptional", 1838, 71658, 72924);
            CallChecker.varInit(this.m_libraryClauses, "m_libraryClauses", 1838, 71658, 72924);
            CallChecker.varInit(this.m_requirements, "m_requirements", 1838, 71658, 72924);
            CallChecker.varInit(this.m_capabilities, "m_capabilities", 1838, 71658, 72924);
            CallChecker.varInit(this.m_bundleVersion, "m_bundleVersion", 1838, 71658, 72924);
            CallChecker.varInit(this.m_bundleSymbolicName, "m_bundleSymbolicName", 1838, 71658, 72924);
            CallChecker.varInit(this.m_isExtension, "m_isExtension", 1838, 71658, 72924);
            CallChecker.varInit(this.m_activationExcludeDir, "m_activationExcludeDir", 1838, 71658, 72924);
            CallChecker.varInit(this.m_activationIncludeDir, "m_activationIncludeDir", 1838, 71658, 72924);
            CallChecker.varInit(this.m_activationPolicy, "m_activationPolicy", 1838, 71658, 72924);
            CallChecker.varInit(this.m_headerMap, "m_headerMap", 1838, 71658, 72924);
            CallChecker.varInit(this.m_configMap, "m_configMap", 1838, 71658, 72924);
            CallChecker.varInit(this.m_logger, "m_logger", 1838, 71658, 72924);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1838, 71658, 72924);
            m_activationPolicy = BundleRevisionImpl.EAGER_ACTIVATION;
            CallChecker.varAssign(this.m_activationPolicy, "this.m_activationPolicy", 1840, 71722, 71778);
            List<ParsedHeaderClause> clauses = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(headerMap, Map.class, 1843, 71866, 71874)) {
                headerMap = CallChecker.beforeCalled(headerMap, Map.class, 1843, 71866, 71874);
                clauses = ManifestParser.parseStandardHeader(((String) (CallChecker.isCalled(headerMap, Map.class, 1843, 71866, 71874).get(Constants.BUNDLE_ACTIVATIONPOLICY))));
                CallChecker.varAssign(clauses, "clauses", 1843, 71866, 71874);
            }
            if (CallChecker.beforeDeref(clauses, List.class, 1845, 71930, 71936)) {
                clauses = CallChecker.beforeCalled(clauses, List.class, 1845, 71930, 71936);
                if ((CallChecker.isCalled(clauses, List.class, 1845, 71930, 71936).size()) > 0) {
                    clauses = CallChecker.beforeCalled(clauses, List.class, 1849, 72094, 72100);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1849, 72094, 72100).get(0), ParsedHeaderClause.class, 1849, 72094, 72107).m_paths, void.class, 1849, 72094, 72115)) {
                        for (String path : CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1849, 72094, 72100).get(0), ParsedHeaderClause.class, 1849, 72094, 72107).m_paths) {
                            if (CallChecker.beforeDeref(path, String.class, 1851, 72152, 72155)) {
                                if (CallChecker.isCalled(path, String.class, 1851, 72152, 72155).equals(Constants.ACTIVATION_LAZY)) {
                                    m_activationPolicy = BundleRevisionImpl.LAZY_ACTIVATION;
                                    CallChecker.varAssign(this.m_activationPolicy, "this.m_activationPolicy", 1853, 72230, 72285);
                                    clauses = CallChecker.beforeCalled(clauses, List.class, 1854, 72342, 72348);
                                    for (Map.Entry<String, String> entry : CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(clauses, List.class, 1854, 72342, 72348).get(0), ParsedHeaderClause.class, 1854, 72342, 72355).m_dirs, Map.class, 1854, 72342, 72362).entrySet()) {
                                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 1856, 72426, 72430)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 1856, 72426, 72430).getKey(), String.class, 1856, 72426, 72439)) {
                                                if (CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 1856, 72426, 72430).getKey(), String.class, 1856, 72426, 72439).equalsIgnoreCase(Constants.INCLUDE_DIRECTIVE)) {
                                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1858, 72567, 72571)) {
                                                        m_activationIncludeDir = CallChecker.isCalled(entry, Map.Entry.class, 1858, 72567, 72571).getValue();
                                                        CallChecker.varAssign(this.m_activationIncludeDir, "this.m_activationIncludeDir", 1858, 72542, 72583);
                                                    }
                                                }else
                                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1860, 72644, 72648)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 1860, 72644, 72648).getKey(), String.class, 1860, 72644, 72657)) {
                                                            if (CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 1860, 72644, 72648).getKey(), String.class, 1860, 72644, 72657).equalsIgnoreCase(Constants.EXCLUDE_DIRECTIVE)) {
                                                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1862, 72785, 72789)) {
                                                                    m_activationExcludeDir = CallChecker.isCalled(entry, Map.Entry.class, 1862, 72785, 72789).getValue();
                                                                    CallChecker.varAssign(this.m_activationExcludeDir, "this.m_activationExcludeDir", 1862, 72760, 72801);
                                                                }
                                                            }
                                                        }
                                                    }
                                                
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1695.methodEnd();
        }
    }

    public static void main(String[] headers) {
        MethodContext _bcornu_methode_context1696 = new MethodContext(void.class);
        try {
            CallChecker.varInit(headers, "headers", 1873, 72931, 73851);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1873, 72931, 73851);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1873, 72931, 73851);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1873, 72931, 73851);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1873, 72931, 73851);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1873, 72931, 73851);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1873, 72931, 73851);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1873, 72931, 73851);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1873, 72931, 73851);
            String header = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(headers, String[].class, 1875, 73186, 73192)) {
                headers = CallChecker.beforeCalled(headers, String[].class, 1875, 73186, 73192);
                header = CallChecker.isCalled(headers, String[].class, 1875, 73186, 73192)[0];
                CallChecker.varAssign(header, "header", 1875, 73186, 73192);
            }
            if (header != null) {
                if ((header.length()) == 0) {
                    throw new IllegalArgumentException("A header cannot be an empty string.");
                }
                List<ParsedHeaderClause> clauses = CallChecker.varInit(ManifestParser.parseStandardHeader(header), "clauses", 1883, 73426, 73488);
                if (CallChecker.beforeDeref(clauses, void.class, 1885, 73536, 73542)) {
                    for (ParsedHeaderClause clause : clauses) {
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1887, 73605, 73610)) {
                            if (CallChecker.beforeDeref(System.out, PrintStream.class, 1887, 73575, 73584)) {
                                CallChecker.isCalled(System.out, PrintStream.class, 1887, 73575, 73584).println(("PATHS " + (CallChecker.isCalled(clause, ParsedHeaderClause.class, 1887, 73605, 73610).m_paths)));
                            }
                        }
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1888, 73672, 73677)) {
                            if (CallChecker.beforeDeref(System.out, PrintStream.class, 1888, 73638, 73647)) {
                                CallChecker.isCalled(System.out, PrintStream.class, 1888, 73638, 73647).println(("    DIRS  " + (CallChecker.isCalled(clause, ParsedHeaderClause.class, 1888, 73672, 73677).m_dirs)));
                            }
                        }
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1889, 73738, 73743)) {
                            if (CallChecker.beforeDeref(System.out, PrintStream.class, 1889, 73704, 73713)) {
                                CallChecker.isCalled(System.out, PrintStream.class, 1889, 73704, 73713).println(("    ATTRS " + (CallChecker.isCalled(clause, ParsedHeaderClause.class, 1889, 73738, 73743).m_attrs)));
                            }
                        }
                        if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1890, 73805, 73810)) {
                            if (CallChecker.beforeDeref(System.out, PrintStream.class, 1890, 73771, 73780)) {
                                CallChecker.isCalled(System.out, PrintStream.class, 1890, 73771, 73780).println(("    TYPES " + (CallChecker.isCalled(clause, ParsedHeaderClause.class, 1890, 73805, 73810).m_types)));
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1696.methodEnd();
        }
    }

    private static final char EOF = ((char) (-1));

    private static char charAt(int pos, String headers, int length) {
        MethodContext _bcornu_methode_context1697 = new MethodContext(char.class);
        try {
            CallChecker.varInit(length, "length", 1898, 73906, 74087);
            CallChecker.varInit(headers, "headers", 1898, 73906, 74087);
            CallChecker.varInit(pos, "pos", 1898, 73906, 74087);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1898, 73906, 74087);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1898, 73906, 74087);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1898, 73906, 74087);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1898, 73906, 74087);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1898, 73906, 74087);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1898, 73906, 74087);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1898, 73906, 74087);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1898, 73906, 74087);
            if (pos >= length) {
                return ManifestParser.EOF;
            }
            if (CallChecker.beforeDeref(headers, String.class, 1904, 74062, 74068)) {
                headers = CallChecker.beforeCalled(headers, String.class, 1904, 74062, 74068);
                return CallChecker.isCalled(headers, String.class, 1904, 74062, 74068).charAt(pos);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Character) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1697.methodEnd();
        }
    }

    private static final int CLAUSE_START = 0;

    private static final int PARAMETER_START = 1;

    private static final int KEY = 2;

    private static final int DIRECTIVE_OR_TYPEDATTRIBUTE = 4;

    private static final int ARGUMENT = 8;

    private static final int VALUE = 16;

    @SuppressWarnings(value = { "unchecked" , "rawtypes" })
    private static List<ParsedHeaderClause> parseStandardHeader(String header) {
        MethodContext _bcornu_methode_context1698 = new MethodContext(List.class);
        try {
            CallChecker.varInit(header, "header", 1915, 74376, 80166);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 1915, 74376, 80166);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 1915, 74376, 80166);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 1915, 74376, 80166);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 1915, 74376, 80166);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 1915, 74376, 80166);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 1915, 74376, 80166);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 1915, 74376, 80166);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 1915, 74376, 80166);
            List<ParsedHeaderClause> clauses = CallChecker.varInit(new ArrayList<ParsedHeaderClause>(), "clauses", 1917, 74516, 74586);
            if (header == null) {
                return clauses;
            }
            ParsedHeaderClause clause = CallChecker.varInit(null, "clause", 1922, 74672, 74704);
            String key = CallChecker.varInit(null, "key", 1923, 74714, 74731);
            Map targetMap = CallChecker.varInit(null, "targetMap", 1924, 74741, 74761);
            int state = CallChecker.varInit(((int) (ManifestParser.CLAUSE_START)), "state", 1925, 74771, 74795);
            int currentPosition = CallChecker.varInit(((int) (0)), "currentPosition", 1926, 74805, 74828);
            int startPosition = CallChecker.varInit(((int) (0)), "startPosition", 1927, 74838, 74859);
            int length = CallChecker.varInit(((int) (header.length())), "length", 1928, 74869, 74897);
            boolean quoted = CallChecker.varInit(((boolean) (false)), "quoted", 1929, 74907, 74929);
            boolean escaped = CallChecker.varInit(((boolean) (false)), "escaped", 1930, 74939, 74962);
            char currentChar = CallChecker.varInit(((char) (ManifestParser.EOF)), "currentChar", 1932, 74973, 74995);
            do {
                currentChar = ManifestParser.charAt(currentPosition, header, length);
                CallChecker.varAssign(currentChar, "currentChar", 1935, 75030, 75083);
                switch (state) {
                    case ManifestParser.CLAUSE_START :
                        clause = new ParsedHeaderClause(new ArrayList<String>(), new HashMap<String, String>(), new HashMap<String, Object>(), new HashMap<String, String>());
                        CallChecker.varAssign(clause, "clause", 1939, 75181, 75443);
                        if (CallChecker.beforeDeref(clauses, List.class, 1944, 75465, 75471)) {
                            clauses = CallChecker.beforeCalled(clauses, List.class, 1944, 75465, 75471);
                            CallChecker.isCalled(clauses, List.class, 1944, 75465, 75471).add(clause);
                        }else
                            throw new AbnormalExecutionError();
                        
                        state = ManifestParser.PARAMETER_START;
                        CallChecker.varAssign(state, "state", 1945, 75506, 75529);
                    case ManifestParser.PARAMETER_START :
                        startPosition = currentPosition;
                        CallChecker.varAssign(startPosition, "startPosition", 1947, 75589, 75620);
                        state = ManifestParser.KEY;
                        CallChecker.varAssign(state, "state", 1948, 75642, 75653);
                    case ManifestParser.KEY :
                        switch (currentChar) {
                            case ':' :
                            case '=' :
                                header = CallChecker.beforeCalled(header, String.class, 1954, 75846, 75851);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(header, String.class, 1954, 75846, 75851).substring(startPosition, currentPosition), String.class, 1954, 75846, 75893)) {
                                    key = CallChecker.isCalled(header.substring(startPosition, currentPosition), String.class, 1954, 75846, 75893).trim();
                                    CallChecker.varAssign(key, "key", 1954, 75840, 75901);
                                }else
                                    throw new AbnormalExecutionError();
                                
                                startPosition = currentPosition + 1;
                                CallChecker.varAssign(startPosition, "startPosition", 1955, 75931, 75966);
                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1956, 76008, 76013)) {
                                    clause = CallChecker.beforeCalled(clause, ParsedHeaderClause.class, 1956, 76008, 76013);
                                    targetMap = CallChecker.isCalled(clause, ParsedHeaderClause.class, 1956, 76008, 76013).m_attrs;
                                    CallChecker.varAssign(targetMap, "targetMap", 1956, 75996, 76022);
                                }else
                                    throw new AbnormalExecutionError();
                                
                                if (currentChar == ':') {
                                    state = ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE;
                                    CallChecker.varAssign(state, "state", 1957, 76052, 76119);
                                }else {
                                    state = ManifestParser.ARGUMENT;
                                    CallChecker.varAssign(state, "state", 1957, 76052, 76119);
                                }
                                break;
                            case ManifestParser.EOF :
                            case ',' :
                            case ';' :
                                if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1962, 76286, 76291)) {
                                    header = CallChecker.beforeCalled(header, String.class, 1962, 76305, 76310);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(header, String.class, 1962, 76305, 76310).substring(startPosition, currentPosition), String.class, 1962, 76305, 76352)) {
                                        clause = CallChecker.beforeCalled(clause, ParsedHeaderClause.class, 1962, 76286, 76291);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 1962, 76286, 76291).m_paths, List.class, 1962, 76286, 76299)) {
                                            clause = CallChecker.beforeCalled(clause, ParsedHeaderClause.class, 1962, 76286, 76291);
                                            CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 1962, 76286, 76291).m_paths, List.class, 1962, 76286, 76299).add(CallChecker.isCalled(header.substring(startPosition, currentPosition), String.class, 1962, 76305, 76352).trim());
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                                if (currentChar == ',') {
                                    state = ManifestParser.CLAUSE_START;
                                    CallChecker.varAssign(state, "state", 1963, 76391, 76450);
                                }else {
                                    state = ManifestParser.PARAMETER_START;
                                    CallChecker.varAssign(state, "state", 1963, 76391, 76450);
                                }
                                break;
                            default :
                                break;
                        }
                        currentPosition++;
                        break;
                    case ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE :
                        switch (currentChar) {
                            case '=' :
                                if (startPosition != currentPosition) {
                                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1976, 76917, 76922)) {
                                        header = CallChecker.beforeCalled(header, String.class, 1976, 76941, 76946);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(header, String.class, 1976, 76941, 76946).substring(startPosition, currentPosition), String.class, 1976, 76941, 76988)) {
                                            clause = CallChecker.beforeCalled(clause, ParsedHeaderClause.class, 1976, 76917, 76922);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(clause, ParsedHeaderClause.class, 1976, 76917, 76922).m_types, Map.class, 1976, 76917, 76930)) {
                                                clause = CallChecker.beforeCalled(clause, ParsedHeaderClause.class, 1976, 76917, 76922);
                                                CallChecker.isCalled(CallChecker.isCalled(clause, ParsedHeaderClause.class, 1976, 76917, 76922).m_types, Map.class, 1976, 76917, 76930).put(key, CallChecker.isCalled(header.substring(startPosition, currentPosition), String.class, 1976, 76941, 76988).trim());
                                            }
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(clause, ParsedHeaderClause.class, 1980, 77136, 77141)) {
                                        clause = CallChecker.beforeCalled(clause, ParsedHeaderClause.class, 1980, 77136, 77141);
                                        targetMap = CallChecker.isCalled(clause, ParsedHeaderClause.class, 1980, 77136, 77141).m_dirs;
                                        CallChecker.varAssign(targetMap, "targetMap", 1980, 77124, 77149);
                                    }
                                }
                                state = ManifestParser.ARGUMENT;
                                CallChecker.varAssign(state, "state", 1982, 77209, 77225);
                                startPosition = currentPosition + 1;
                                CallChecker.varAssign(startPosition, "startPosition", 1983, 77255, 77290);
                                break;
                            default :
                                break;
                        }
                        currentPosition++;
                        break;
                    case ManifestParser.ARGUMENT :
                        if (currentChar == '\"') {
                            quoted = true;
                            CallChecker.varAssign(quoted, "quoted", 1993, 77605, 77618);
                            currentPosition++;
                        }else {
                            quoted = false;
                            CallChecker.varAssign(quoted, "quoted", 1998, 77756, 77770);
                        }
                        if (!(Character.isWhitespace(currentChar))) {
                            state = ManifestParser.VALUE;
                            CallChecker.varAssign(state, "state", 2001, 77879, 77892);
                        }else {
                            currentPosition++;
                        }
                        break;
                    case ManifestParser.VALUE :
                        if (escaped) {
                            escaped = false;
                            CallChecker.varAssign(escaped, "escaped", 2010, 78139, 78154);
                        }else {
                            if (currentChar == '\\') {
                                escaped = true;
                                CallChecker.varAssign(escaped, "escaped", 2016, 78329, 78343);
                            }else
                                if (quoted && (currentChar == '\"')) {
                                    quoted = false;
                                    CallChecker.varAssign(quoted, "quoted", 2020, 78489, 78503);
                                }else
                                    if (!quoted) {
                                        String value = CallChecker.varInit(null, "value", 2024, 78627, 78646);
                                        switch (currentChar) {
                                            case ManifestParser.EOF :
                                            case ';' :
                                            case ',' :
                                                header = CallChecker.beforeCalled(header, String.class, 2030, 78896, 78901);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(header, String.class, 2030, 78896, 78901).substring(startPosition, currentPosition), String.class, 2030, 78896, 78943)) {
                                                    value = CallChecker.isCalled(header.substring(startPosition, currentPosition), String.class, 2030, 78896, 78943).trim();
                                                    CallChecker.varAssign(value, "value", 2030, 78888, 78951);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                if (CallChecker.beforeDeref(value, String.class, 2031, 78993, 78997)) {
                                                    if (CallChecker.beforeDeref(value, String.class, 2031, 79019, 79023)) {
                                                        value = CallChecker.beforeCalled(value, String.class, 2031, 78993, 78997);
                                                        value = CallChecker.beforeCalled(value, String.class, 2031, 79019, 79023);
                                                        if ((CallChecker.isCalled(value, String.class, 2031, 78993, 78997).startsWith("\"")) && (CallChecker.isCalled(value, String.class, 2031, 79019, 79023).endsWith("\""))) {
                                                            if (CallChecker.beforeDeref(value, String.class, 2033, 79146, 79150)) {
                                                                if (CallChecker.beforeDeref(value, String.class, 2033, 79127, 79131)) {
                                                                    value = CallChecker.beforeCalled(value, String.class, 2033, 79146, 79150);
                                                                    value = CallChecker.beforeCalled(value, String.class, 2033, 79127, 79131);
                                                                    value = CallChecker.isCalled(value, String.class, 2033, 79127, 79131).substring(1, ((CallChecker.isCalled(value, String.class, 2033, 79146, 79150).length()) - 1));
                                                                    CallChecker.varAssign(value, "value", 2033, 79119, 79165);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (CallChecker.beforeDeref(targetMap, Map.class, 2035, 79245, 79253)) {
                                                    targetMap = CallChecker.beforeCalled(targetMap, Map.class, 2035, 79245, 79253);
                                                    if ((CallChecker.isCalled(targetMap, Map.class, 2035, 79245, 79253).put(key, value)) != null) {
                                                        throw new IllegalArgumentException(((("Duplicate '" + key) + "' in: ") + header));
                                                    }
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                if (currentChar == ';') {
                                                    state = ManifestParser.PARAMETER_START;
                                                    CallChecker.varAssign(state, "state", 2040, 79558, 79617);
                                                }else {
                                                    state = ManifestParser.CLAUSE_START;
                                                    CallChecker.varAssign(state, "state", 2040, 79558, 79617);
                                                }
                                                break;
                                            default :
                                                break;
                                        }
                                    }
                                
                            
                        }
                        currentPosition++;
                        break;
                    default :
                        break;
                }
            } while (currentChar != (ManifestParser.EOF) );
            if (state > (ManifestParser.PARAMETER_START)) {
                throw new IllegalArgumentException(("Unable to parse header: " + header));
            }
            return clauses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<ParsedHeaderClause>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1698.methodEnd();
        }
    }

    public static List<String> parseDelimitedString(String value, String delim) {
        MethodContext _bcornu_methode_context1699 = new MethodContext(List.class);
        try {
            CallChecker.varInit(delim, "delim", 2061, 80173, 80316);
            CallChecker.varInit(value, "value", 2061, 80173, 80316);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 2061, 80173, 80316);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 2061, 80173, 80316);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 2061, 80173, 80316);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 2061, 80173, 80316);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 2061, 80173, 80316);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 2061, 80173, 80316);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 2061, 80173, 80316);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 2061, 80173, 80316);
            return ManifestParser.parseDelimitedString(value, delim, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1699.methodEnd();
        }
    }

    public static List<String> parseDelimitedString(String value, String delim, boolean trim) {
        MethodContext _bcornu_methode_context1700 = new MethodContext(List.class);
        try {
            CallChecker.varInit(trim, "trim", 2075, 80323, 82947);
            CallChecker.varInit(delim, "delim", 2075, 80323, 82947);
            CallChecker.varInit(value, "value", 2075, 80323, 82947);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 2075, 80323, 82947);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 2075, 80323, 82947);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 2075, 80323, 82947);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 2075, 80323, 82947);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 2075, 80323, 82947);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 2075, 80323, 82947);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 2075, 80323, 82947);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 2075, 80323, 82947);
            if (value == null) {
                value = "";
                CallChecker.varAssign(value, "value", 2079, 80950, 80960);
            }
            List<String> list = CallChecker.varInit(new ArrayList(), "list", 2082, 80981, 81016);
            int CHAR = CallChecker.varInit(((int) (1)), "CHAR", 2084, 81027, 81039);
            int DELIMITER = CallChecker.varInit(((int) (2)), "DELIMITER", 2085, 81049, 81066);
            int STARTQUOTE = CallChecker.varInit(((int) (4)), "STARTQUOTE", 2086, 81076, 81094);
            int ENDQUOTE = CallChecker.varInit(((int) (8)), "ENDQUOTE", 2087, 81104, 81120);
            StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 2089, 81131, 81167);
            int expecting = CallChecker.varInit(((int) ((CHAR | DELIMITER) | STARTQUOTE)), "expecting", 2091, 81178, 81225);
            boolean isEscaped = CallChecker.varInit(((boolean) (false)), "isEscaped", 2093, 81236, 81261);
            value = CallChecker.beforeCalled(value, String.class, 2094, 81291, 81295);
            for (int i = 0; i < (CallChecker.isCalled(value, String.class, 2094, 81291, 81295).length()); i++) {
                char c = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(value, String.class, 2096, 81343, 81347)) {
                    value = CallChecker.beforeCalled(value, String.class, 2096, 81343, 81347);
                    c = CallChecker.isCalled(value, String.class, 2096, 81343, 81347).charAt(i);
                    CallChecker.varAssign(c, "c", 2096, 81343, 81347);
                }
                boolean isDelimiter = CallChecker.init(boolean.class);
                if (CallChecker.beforeDeref(delim, String.class, 2098, 81396, 81400)) {
                    delim = CallChecker.beforeCalled(delim, String.class, 2098, 81396, 81400);
                    isDelimiter = (CallChecker.isCalled(delim, String.class, 2098, 81396, 81400).indexOf(c)) >= 0;
                    CallChecker.varAssign(isDelimiter, "isDelimiter", 2098, 81396, 81400);
                }
                if ((!isEscaped) && (c == '\\')) {
                    isEscaped = true;
                    CallChecker.varAssign(isEscaped, "isEscaped", 2102, 81494, 81510);
                    continue;
                }
                if (isEscaped) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2108, 81610, 81611)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2108, 81610, 81611);
                        CallChecker.isCalled(sb, StringBuffer.class, 2108, 81610, 81611).append(c);
                    }
                }else
                    if (isDelimiter && ((expecting & DELIMITER) > 0)) {
                        if (trim) {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2114, 81792, 81793)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2114, 81792, 81793);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(sb, StringBuffer.class, 2114, 81792, 81793).toString(), String.class, 2114, 81792, 81804)) {
                                    if (CallChecker.beforeDeref(list, List.class, 2114, 81783, 81786)) {
                                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2114, 81792, 81793);
                                        list = CallChecker.beforeCalled(list, List.class, 2114, 81783, 81786);
                                        CallChecker.isCalled(list, List.class, 2114, 81783, 81786).add(CallChecker.isCalled(CallChecker.isCalled(sb, StringBuffer.class, 2114, 81792, 81793).toString(), String.class, 2114, 81792, 81804).trim());
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2118, 81901, 81902)) {
                                if (CallChecker.beforeDeref(list, List.class, 2118, 81892, 81895)) {
                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2118, 81901, 81902);
                                    list = CallChecker.beforeCalled(list, List.class, 2118, 81892, 81895);
                                    CallChecker.isCalled(list, List.class, 2118, 81892, 81895).add(CallChecker.isCalled(sb, StringBuffer.class, 2118, 81901, 81902).toString());
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2120, 81964, 81965)) {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2120, 81951, 81952)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2120, 81964, 81965);
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2120, 81951, 81952);
                                CallChecker.isCalled(sb, StringBuffer.class, 2120, 81951, 81952).delete(0, CallChecker.isCalled(sb, StringBuffer.class, 2120, 81964, 81965).length());
                            }
                        }
                        expecting = (CHAR | DELIMITER) | STARTQUOTE;
                        CallChecker.varAssign(expecting, "expecting", 2121, 81994, 82037);
                    }else
                        if ((c == '"') && ((expecting & STARTQUOTE) > 0)) {
                            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2125, 82150, 82151)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2125, 82150, 82151);
                                CallChecker.isCalled(sb, StringBuffer.class, 2125, 82150, 82151).append(c);
                            }
                            expecting = CHAR | ENDQUOTE;
                            CallChecker.varAssign(expecting, "expecting", 2126, 82180, 82207);
                        }else
                            if ((c == '"') && ((expecting & ENDQUOTE) > 0)) {
                                if (CallChecker.beforeDeref(sb, StringBuffer.class, 2130, 82318, 82319)) {
                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2130, 82318, 82319);
                                    CallChecker.isCalled(sb, StringBuffer.class, 2130, 82318, 82319).append(c);
                                }
                                expecting = (CHAR | STARTQUOTE) | DELIMITER;
                                CallChecker.varAssign(expecting, "expecting", 2131, 82348, 82391);
                            }else
                                if ((expecting & CHAR) > 0) {
                                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 2135, 82482, 82483)) {
                                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2135, 82482, 82483);
                                        CallChecker.isCalled(sb, StringBuffer.class, 2135, 82482, 82483).append(c);
                                    }
                                }else {
                                    throw new IllegalArgumentException(("Invalid delimited string: " + value));
                                }
                            
                        
                    
                
                isEscaped = false;
                CallChecker.varAssign(isEscaped, "isEscaped", 2142, 82658, 82675);
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 2145, 82700, 82701)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2145, 82700, 82701);
                if ((CallChecker.isCalled(sb, StringBuffer.class, 2145, 82700, 82701).length()) > 0) {
                    if (trim) {
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2149, 82788, 82789)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2149, 82788, 82789);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(sb, StringBuffer.class, 2149, 82788, 82789).toString(), String.class, 2149, 82788, 82800)) {
                                if (CallChecker.beforeDeref(list, List.class, 2149, 82779, 82782)) {
                                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2149, 82788, 82789);
                                    list = CallChecker.beforeCalled(list, List.class, 2149, 82779, 82782);
                                    CallChecker.isCalled(list, List.class, 2149, 82779, 82782).add(CallChecker.isCalled(CallChecker.isCalled(sb, StringBuffer.class, 2149, 82788, 82789).toString(), String.class, 2149, 82788, 82800).trim());
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 2153, 82881, 82882)) {
                            if (CallChecker.beforeDeref(list, List.class, 2153, 82872, 82875)) {
                                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 2153, 82881, 82882);
                                list = CallChecker.beforeCalled(list, List.class, 2153, 82872, 82875);
                                CallChecker.isCalled(list, List.class, 2153, 82872, 82875).add(CallChecker.isCalled(sb, StringBuffer.class, 2153, 82881, 82882).toString());
                            }
                        }
                    }
                }
            }
            return list;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1700.methodEnd();
        }
    }

    private static List<NativeLibraryClause> parseLibraryStrings(Logger logger, List<String> libStrs) throws IllegalArgumentException {
        MethodContext _bcornu_methode_context1701 = new MethodContext(List.class);
        try {
            CallChecker.varInit(libStrs, "libStrs", 2167, 82954, 83785);
            CallChecker.varInit(logger, "logger", 2167, 82954, 83785);
            CallChecker.varInit(VALUE, "org.apache.felix.framework.util.manifestparser.ManifestParser.VALUE", 2167, 82954, 83785);
            CallChecker.varInit(ARGUMENT, "org.apache.felix.framework.util.manifestparser.ManifestParser.ARGUMENT", 2167, 82954, 83785);
            CallChecker.varInit(DIRECTIVE_OR_TYPEDATTRIBUTE, "org.apache.felix.framework.util.manifestparser.ManifestParser.DIRECTIVE_OR_TYPEDATTRIBUTE", 2167, 82954, 83785);
            CallChecker.varInit(KEY, "org.apache.felix.framework.util.manifestparser.ManifestParser.KEY", 2167, 82954, 83785);
            CallChecker.varInit(PARAMETER_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.PARAMETER_START", 2167, 82954, 83785);
            CallChecker.varInit(CLAUSE_START, "org.apache.felix.framework.util.manifestparser.ManifestParser.CLAUSE_START", 2167, 82954, 83785);
            CallChecker.varInit(EOF, "org.apache.felix.framework.util.manifestparser.ManifestParser.EOF", 2167, 82954, 83785);
            CallChecker.varInit(BUNDLE_LICENSE_HEADER, "org.apache.felix.framework.util.manifestparser.ManifestParser.BUNDLE_LICENSE_HEADER", 2167, 82954, 83785);
            if (libStrs == null) {
                return new ArrayList<NativeLibraryClause>(0);
            }
            List<NativeLibraryClause> libList = CallChecker.varInit(new ArrayList(libStrs.size()), "libList", 2176, 83494, 83559);
            for (int i = 0; i < (libStrs.size()); i++) {
                NativeLibraryClause clause = CallChecker.varInit(NativeLibraryClause.parse(logger, libStrs.get(i)), "clause", 2180, 83633, 83711);
                if (CallChecker.beforeDeref(libList, List.class, 2181, 83725, 83731)) {
                    libList = CallChecker.beforeCalled(libList, List.class, 2181, 83725, 83731);
                    CallChecker.isCalled(libList, List.class, 2181, 83725, 83731).add(clause);
                }
            }
            return libList;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<NativeLibraryClause>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1701.methodEnd();
        }
    }
}

