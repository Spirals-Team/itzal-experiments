package org.apache.felix.framework.resolver;

import org.osgi.framework.Version;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.Bundle;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.wiring.BundleRevision;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.resource.Capability;
import java.util.Comparator;
import org.osgi.framework.Constants;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;

public class CandidateComparator implements Comparator<Capability> {
    public int compare(Capability cap1, Capability cap2) {
        MethodContext _bcornu_methode_context122 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 32, 1230, 4657);
            CallChecker.varInit(cap2, "cap2", 32, 1230, 4657);
            CallChecker.varInit(cap1, "cap1", 32, 1230, 4657);
            int c = CallChecker.varInit(((int) (0)), "c", 37, 1490, 1499);
            BundleCapability bcap1 = CallChecker.varInit(null, "bcap1", 39, 1510, 1539);
            BundleCapability bcap2 = CallChecker.varInit(null, "bcap2", 40, 1549, 1578);
            if ((cap1 instanceof BundleCapability) && (cap2 instanceof BundleCapability)) {
                bcap1 = ((BundleCapability) (cap1));
                CallChecker.varAssign(bcap1, "bcap1", 45, 1697, 1728);
                bcap2 = ((BundleCapability) (cap2));
                CallChecker.varAssign(bcap2, "bcap2", 46, 1742, 1773);
                if (CallChecker.beforeDeref(bcap1, BundleCapability.class, 48, 1793, 1797)) {
                    bcap1 = CallChecker.beforeCalled(bcap1, BundleCapability.class, 48, 1793, 1797);
                    final BundleRevision npe_invocation_var49 = CallChecker.isCalled(bcap1, BundleCapability.class, 48, 1793, 1797).getRevision();
                    if (CallChecker.beforeDeref(npe_invocation_var49, BundleRevision.class, 48, 1793, 1811)) {
                        if (CallChecker.beforeDeref(bcap2, BundleCapability.class, 49, 1854, 1858)) {
                            bcap2 = CallChecker.beforeCalled(bcap2, BundleCapability.class, 49, 1854, 1858);
                            final BundleRevision npe_invocation_var50 = CallChecker.isCalled(bcap2, BundleCapability.class, 49, 1854, 1858).getRevision();
                            if (CallChecker.beforeDeref(npe_invocation_var50, BundleRevision.class, 49, 1854, 1872)) {
                                if (((CallChecker.isCalled(npe_invocation_var49, BundleRevision.class, 48, 1793, 1811).getWiring()) != null) && ((CallChecker.isCalled(npe_invocation_var50, BundleRevision.class, 49, 1854, 1872).getWiring()) == null)) {
                                    c = -1;
                                    CallChecker.varAssign(c, "c", 51, 1926, 1932);
                                }else
                                    if (CallChecker.beforeDeref(bcap1, BundleCapability.class, 53, 1970, 1974)) {
                                        bcap1 = CallChecker.beforeCalled(bcap1, BundleCapability.class, 53, 1970, 1974);
                                        final BundleRevision npe_invocation_var51 = CallChecker.isCalled(bcap1, BundleCapability.class, 53, 1970, 1974).getRevision();
                                        if (CallChecker.beforeDeref(npe_invocation_var51, BundleRevision.class, 53, 1970, 1988)) {
                                            if (CallChecker.beforeDeref(bcap2, BundleCapability.class, 54, 2031, 2035)) {
                                                bcap2 = CallChecker.beforeCalled(bcap2, BundleCapability.class, 54, 2031, 2035);
                                                final BundleRevision npe_invocation_var52 = CallChecker.isCalled(bcap2, BundleCapability.class, 54, 2031, 2035).getRevision();
                                                if (CallChecker.beforeDeref(npe_invocation_var52, BundleRevision.class, 54, 2031, 2049)) {
                                                    if (((CallChecker.isCalled(npe_invocation_var51, BundleRevision.class, 53, 1970, 1988).getWiring()) == null) && ((CallChecker.isCalled(npe_invocation_var52, BundleRevision.class, 54, 2031, 2049).getWiring()) != null)) {
                                                        c = 1;
                                                        CallChecker.varAssign(c, "c", 56, 2103, 2108);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cap1, Capability.class, 61, 2201, 2204)) {
                cap1 = CallChecker.beforeCalled(cap1, Capability.class, 61, 2201, 2204);
                final String npe_invocation_var53 = CallChecker.isCalled(cap1, Capability.class, 61, 2201, 2204).getNamespace();
                if (CallChecker.beforeDeref(npe_invocation_var53, String.class, 61, 2201, 2219)) {
                    if ((c == 0) && (CallChecker.isCalled(npe_invocation_var53, String.class, 61, 2201, 2219).equals(BundleRevision.BUNDLE_NAMESPACE))) {
                        if (CallChecker.beforeDeref(cap1, Capability.class, 63, 2302, 2305)) {
                            cap1 = CallChecker.beforeCalled(cap1, Capability.class, 63, 2302, 2305);
                            final Map<String, Object> npe_invocation_var54 = CallChecker.isCalled(cap1, Capability.class, 63, 2302, 2305).getAttributes();
                            if (CallChecker.beforeDeref(npe_invocation_var54, Map.class, 63, 2302, 2321)) {
                                if (CallChecker.beforeDeref(cap2, Capability.class, 64, 2388, 2391)) {
                                    cap2 = CallChecker.beforeCalled(cap2, Capability.class, 64, 2388, 2391);
                                    final Map<String, Object> npe_invocation_var55 = CallChecker.isCalled(cap2, Capability.class, 64, 2388, 2391).getAttributes();
                                    if (CallChecker.beforeDeref(npe_invocation_var55, Map.class, 64, 2388, 2407)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var54, Map.class, 63, 2302, 2321).get(BundleRevision.BUNDLE_NAMESPACE), Object.class, 63, 2302, 2358)) {
                                            c = CallChecker.isCalled(((Comparable) (CallChecker.isCalled(npe_invocation_var54, Map.class, 63, 2302, 2321).get(BundleRevision.BUNDLE_NAMESPACE))), Comparable.class, 63, 2302, 2358).compareTo(CallChecker.isCalled(npe_invocation_var55, Map.class, 64, 2388, 2407).get(BundleRevision.BUNDLE_NAMESPACE));
                                            CallChecker.varAssign(c, "c", 63, 2284, 2446);
                                        }
                                    }
                                }
                            }
                        }
                        if (c == 0) {
                            Version v1 = CallChecker.init(Version.class);
                            if (CallChecker.beforeDeref(cap1, Capability.class, 67, 2517, 2520)) {
                                cap1 = CallChecker.beforeCalled(cap1, Capability.class, 67, 2517, 2520);
                                final Map<String, Object> npe_invocation_var56 = CallChecker.isCalled(cap1, Capability.class, 67, 2517, 2520).getAttributes();
                                if (CallChecker.beforeDeref(npe_invocation_var56, Map.class, 67, 2517, 2536)) {
                                    if (!(CallChecker.isCalled(npe_invocation_var56, Map.class, 67, 2517, 2536).containsKey(Constants.BUNDLE_VERSION_ATTRIBUTE))) {
                                        v1 = Version.emptyVersion;
                                        CallChecker.varAssign(v1, "v1", 67, 2515, 2721);
                                    }else {
                                        if (CallChecker.beforeDeref(cap1, Capability.class, 69, 2662, 2665)) {
                                            cap1 = CallChecker.beforeCalled(cap1, Capability.class, 69, 2662, 2665);
                                            final Map<String, Object> npe_invocation_var57 = CallChecker.isCalled(cap1, Capability.class, 69, 2662, 2665).getAttributes();
                                            if (CallChecker.beforeDeref(npe_invocation_var57, Map.class, 69, 2662, 2681)) {
                                                v1 = ((Version) (CallChecker.isCalled(npe_invocation_var57, Map.class, 69, 2662, 2681).get(Constants.BUNDLE_VERSION_ATTRIBUTE)));
                                                CallChecker.varAssign(v1, "v1", 67, 2515, 2721);
                                            }
                                        }
                                    }
                                }
                            }
                            Version v2 = CallChecker.init(Version.class);
                            if (CallChecker.beforeDeref(cap2, Capability.class, 70, 2755, 2758)) {
                                cap2 = CallChecker.beforeCalled(cap2, Capability.class, 70, 2755, 2758);
                                final Map<String, Object> npe_invocation_var58 = CallChecker.isCalled(cap2, Capability.class, 70, 2755, 2758).getAttributes();
                                if (CallChecker.beforeDeref(npe_invocation_var58, Map.class, 70, 2755, 2774)) {
                                    if (!(CallChecker.isCalled(npe_invocation_var58, Map.class, 70, 2755, 2774).containsKey(Constants.BUNDLE_VERSION_ATTRIBUTE))) {
                                        v2 = Version.emptyVersion;
                                        CallChecker.varAssign(v2, "v2", 70, 2753, 2959);
                                    }else {
                                        if (CallChecker.beforeDeref(cap2, Capability.class, 72, 2900, 2903)) {
                                            cap2 = CallChecker.beforeCalled(cap2, Capability.class, 72, 2900, 2903);
                                            final Map<String, Object> npe_invocation_var59 = CallChecker.isCalled(cap2, Capability.class, 72, 2900, 2903).getAttributes();
                                            if (CallChecker.beforeDeref(npe_invocation_var59, Map.class, 72, 2900, 2919)) {
                                                v2 = ((Version) (CallChecker.isCalled(npe_invocation_var59, Map.class, 72, 2900, 2919).get(Constants.BUNDLE_VERSION_ATTRIBUTE)));
                                                CallChecker.varAssign(v2, "v2", 70, 2753, 2959);
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(v2, Version.class, 75, 3100, 3101)) {
                                v2 = CallChecker.beforeCalled(v2, Version.class, 75, 3100, 3101);
                                c = CallChecker.isCalled(v2, Version.class, 75, 3100, 3101).compareTo(v1);
                                CallChecker.varAssign(c, "c", 75, 3096, 3116);
                            }
                        }
                    }else
                        if (CallChecker.beforeDeref(cap1, Capability.class, 79, 3212, 3215)) {
                            cap1 = CallChecker.beforeCalled(cap1, Capability.class, 79, 3212, 3215);
                            final String npe_invocation_var60 = CallChecker.isCalled(cap1, Capability.class, 79, 3212, 3215).getNamespace();
                            if (CallChecker.beforeDeref(npe_invocation_var60, String.class, 79, 3212, 3230)) {
                                if ((c == 0) && (CallChecker.isCalled(npe_invocation_var60, String.class, 79, 3212, 3230).equals(BundleRevision.PACKAGE_NAMESPACE))) {
                                    if (CallChecker.beforeDeref(cap1, Capability.class, 81, 3314, 3317)) {
                                        cap1 = CallChecker.beforeCalled(cap1, Capability.class, 81, 3314, 3317);
                                        final Map<String, Object> npe_invocation_var61 = CallChecker.isCalled(cap1, Capability.class, 81, 3314, 3317).getAttributes();
                                        if (CallChecker.beforeDeref(npe_invocation_var61, Map.class, 81, 3314, 3333)) {
                                            if (CallChecker.beforeDeref(cap2, Capability.class, 82, 3401, 3404)) {
                                                cap2 = CallChecker.beforeCalled(cap2, Capability.class, 82, 3401, 3404);
                                                final Map<String, Object> npe_invocation_var62 = CallChecker.isCalled(cap2, Capability.class, 82, 3401, 3404).getAttributes();
                                                if (CallChecker.beforeDeref(npe_invocation_var62, Map.class, 82, 3401, 3420)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var61, Map.class, 81, 3314, 3333).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 81, 3314, 3371)) {
                                                        c = CallChecker.isCalled(((Comparable) (CallChecker.isCalled(npe_invocation_var61, Map.class, 81, 3314, 3333).get(BundleRevision.PACKAGE_NAMESPACE))), Comparable.class, 81, 3314, 3371).compareTo(CallChecker.isCalled(npe_invocation_var62, Map.class, 82, 3401, 3420).get(BundleRevision.PACKAGE_NAMESPACE));
                                                        CallChecker.varAssign(c, "c", 81, 3296, 3460);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (c == 0) {
                                        Version v1 = CallChecker.init(Version.class);
                                        if (CallChecker.beforeDeref(cap1, Capability.class, 85, 3531, 3534)) {
                                            cap1 = CallChecker.beforeCalled(cap1, Capability.class, 85, 3531, 3534);
                                            final Map<String, Object> npe_invocation_var63 = CallChecker.isCalled(cap1, Capability.class, 85, 3531, 3534).getAttributes();
                                            if (CallChecker.beforeDeref(npe_invocation_var63, Map.class, 85, 3531, 3550)) {
                                                if (!(CallChecker.isCalled(npe_invocation_var63, Map.class, 85, 3531, 3550).containsKey(org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR))) {
                                                    v1 = Version.emptyVersion;
                                                    CallChecker.varAssign(v1, "v1", 85, 3529, 3733);
                                                }else {
                                                    if (CallChecker.beforeDeref(cap1, Capability.class, 87, 3675, 3678)) {
                                                        cap1 = CallChecker.beforeCalled(cap1, Capability.class, 87, 3675, 3678);
                                                        final Map<String, Object> npe_invocation_var64 = CallChecker.isCalled(cap1, Capability.class, 87, 3675, 3678).getAttributes();
                                                        if (CallChecker.beforeDeref(npe_invocation_var64, Map.class, 87, 3675, 3694)) {
                                                            v1 = ((Version) (CallChecker.isCalled(npe_invocation_var64, Map.class, 87, 3675, 3694).get(org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR)));
                                                            CallChecker.varAssign(v1, "v1", 85, 3529, 3733);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        Version v2 = CallChecker.init(Version.class);
                                        if (CallChecker.beforeDeref(cap2, Capability.class, 88, 3767, 3770)) {
                                            cap2 = CallChecker.beforeCalled(cap2, Capability.class, 88, 3767, 3770);
                                            final Map<String, Object> npe_invocation_var65 = CallChecker.isCalled(cap2, Capability.class, 88, 3767, 3770).getAttributes();
                                            if (CallChecker.beforeDeref(npe_invocation_var65, Map.class, 88, 3767, 3786)) {
                                                if (!(CallChecker.isCalled(npe_invocation_var65, Map.class, 88, 3767, 3786).containsKey(org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR))) {
                                                    v2 = Version.emptyVersion;
                                                    CallChecker.varAssign(v2, "v2", 88, 3765, 3969);
                                                }else {
                                                    if (CallChecker.beforeDeref(cap2, Capability.class, 90, 3911, 3914)) {
                                                        cap2 = CallChecker.beforeCalled(cap2, Capability.class, 90, 3911, 3914);
                                                        final Map<String, Object> npe_invocation_var66 = CallChecker.isCalled(cap2, Capability.class, 90, 3911, 3914).getAttributes();
                                                        if (CallChecker.beforeDeref(npe_invocation_var66, Map.class, 90, 3911, 3930)) {
                                                            v2 = ((Version) (CallChecker.isCalled(npe_invocation_var66, Map.class, 90, 3911, 3930).get(org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR)));
                                                            CallChecker.varAssign(v2, "v2", 88, 3765, 3969);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(v2, Version.class, 93, 4110, 4111)) {
                                            v2 = CallChecker.beforeCalled(v2, Version.class, 93, 4110, 4111);
                                            c = CallChecker.isCalled(v2, Version.class, 93, 4110, 4111).compareTo(v1);
                                            CallChecker.varAssign(c, "c", 93, 4106, 4126);
                                        }
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
            
            if (((c == 0) && (bcap1 != null)) && (bcap2 != null)) {
                bcap1 = CallChecker.beforeCalled(bcap1, BundleCapability.class, 100, 4278, 4282);
                final BundleRevision npe_invocation_var67 = CallChecker.isCalled(bcap1, BundleCapability.class, 100, 4278, 4282).getRevision();
                if (CallChecker.beforeDeref(npe_invocation_var67, BundleRevision.class, 100, 4278, 4296)) {
                    final Bundle npe_invocation_var68 = CallChecker.isCalled(npe_invocation_var67, BundleRevision.class, 100, 4278, 4296).getBundle();
                    if (CallChecker.beforeDeref(npe_invocation_var68, Bundle.class, 100, 4278, 4308)) {
                        bcap2 = CallChecker.beforeCalled(bcap2, BundleCapability.class, 101, 4342, 4346);
                        final BundleRevision npe_invocation_var69 = CallChecker.isCalled(bcap2, BundleCapability.class, 101, 4342, 4346).getRevision();
                        if (CallChecker.beforeDeref(npe_invocation_var69, BundleRevision.class, 101, 4342, 4360)) {
                            final Bundle npe_invocation_var70 = CallChecker.isCalled(npe_invocation_var69, BundleRevision.class, 101, 4342, 4360).getBundle();
                            if (CallChecker.beforeDeref(npe_invocation_var70, Bundle.class, 101, 4342, 4372)) {
                                if ((CallChecker.isCalled(npe_invocation_var68, Bundle.class, 100, 4278, 4308).getBundleId()) < (CallChecker.isCalled(npe_invocation_var70, Bundle.class, 101, 4342, 4372).getBundleId())) {
                                    c = -1;
                                    CallChecker.varAssign(c, "c", 103, 4419, 4425);
                                }else {
                                    bcap1 = CallChecker.beforeCalled(bcap1, BundleCapability.class, 105, 4462, 4466);
                                    final BundleRevision npe_invocation_var71 = CallChecker.isCalled(bcap1, BundleCapability.class, 105, 4462, 4466).getRevision();
                                    if (CallChecker.beforeDeref(npe_invocation_var71, BundleRevision.class, 105, 4462, 4480)) {
                                        final Bundle npe_invocation_var72 = CallChecker.isCalled(npe_invocation_var71, BundleRevision.class, 105, 4462, 4480).getBundle();
                                        if (CallChecker.beforeDeref(npe_invocation_var72, Bundle.class, 105, 4462, 4492)) {
                                            bcap2 = CallChecker.beforeCalled(bcap2, BundleCapability.class, 106, 4526, 4530);
                                            final BundleRevision npe_invocation_var73 = CallChecker.isCalled(bcap2, BundleCapability.class, 106, 4526, 4530).getRevision();
                                            if (CallChecker.beforeDeref(npe_invocation_var73, BundleRevision.class, 106, 4526, 4544)) {
                                                final Bundle npe_invocation_var74 = CallChecker.isCalled(npe_invocation_var73, BundleRevision.class, 106, 4526, 4544).getBundle();
                                                if (CallChecker.beforeDeref(npe_invocation_var74, Bundle.class, 106, 4526, 4556)) {
                                                    if ((CallChecker.isCalled(npe_invocation_var72, Bundle.class, 105, 4462, 4492).getBundleId()) > (CallChecker.isCalled(npe_invocation_var74, Bundle.class, 106, 4526, 4556).getBundleId())) {
                                                        c = 1;
                                                        CallChecker.varAssign(c, "c", 108, 4603, 4608);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return c;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context122.methodEnd();
        }
    }
}

