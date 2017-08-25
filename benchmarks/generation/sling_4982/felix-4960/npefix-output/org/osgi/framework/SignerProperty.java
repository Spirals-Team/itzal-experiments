package org.osgi.framework;

import java.security.cert.X509Certificate;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.security.Principal;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

final class SignerProperty {
    private final Bundle bundle;

    private final String pattern;

    public SignerProperty(String pattern) {
        MethodContext _bcornu_methode_context165 = new MethodContext(null);
        try {
            this.pattern = pattern;
            CallChecker.varAssign(this.pattern, "this.pattern", 42, 1371, 1393);
            this.bundle = null;
            CallChecker.varAssign(this.bundle, "this.bundle", 43, 1397, 1415);
        } finally {
            _bcornu_methode_context165.methodEnd();
        }
    }

    SignerProperty(Bundle bundle) {
        MethodContext _bcornu_methode_context166 = new MethodContext(null);
        try {
            this.bundle = bundle;
            CallChecker.varAssign(this.bundle, "this.bundle", 53, 1623, 1643);
            this.pattern = null;
            CallChecker.varAssign(this.pattern, "this.pattern", 54, 1647, 1666);
        } finally {
            _bcornu_methode_context166.methodEnd();
        }
    }

    @Override
    public boolean equals(Object o) {
        MethodContext _bcornu_methode_context1705 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 68, 1673, 2955);
            CallChecker.varInit(o, "o", 68, 1673, 2955);
            CallChecker.varInit(this.pattern, "pattern", 68, 1673, 2955);
            CallChecker.varInit(this.bundle, "bundle", 68, 1673, 2955);
            if (!(o instanceof SignerProperty))
                return false;
            
            SignerProperty other = CallChecker.varInit(((SignerProperty) (o)), "other", 71, 2219, 2260);
            Bundle matchBundle = CallChecker.init(Bundle.class);
            if ((bundle) != null) {
                matchBundle = bundle;
                CallChecker.varAssign(matchBundle, "matchBundle", 72, 2285, 2322);
            }else {
                if (CallChecker.beforeDeref(other, SignerProperty.class, 72, 2311, 2315)) {
                    other = CallChecker.beforeCalled(other, SignerProperty.class, 72, 2311, 2315);
                    matchBundle = CallChecker.isCalled(other, SignerProperty.class, 72, 2311, 2315).bundle;
                    CallChecker.varAssign(matchBundle, "matchBundle", 72, 2285, 2322);
                }
            }
            String matchPattern = CallChecker.init(String.class);
            if ((bundle) != null) {
                if (CallChecker.beforeDeref(other, SignerProperty.class, 73, 2366, 2370)) {
                    other = CallChecker.beforeCalled(other, SignerProperty.class, 73, 2366, 2370);
                    matchPattern = CallChecker.isCalled(other, SignerProperty.class, 73, 2366, 2370).pattern;
                    CallChecker.varAssign(matchPattern, "matchPattern", 73, 2349, 2388);
                }
            }else {
                matchPattern = pattern;
                CallChecker.varAssign(matchPattern, "matchPattern", 73, 2349, 2388);
            }
            Map<X509Certificate, List<X509Certificate>> signers = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(matchBundle, Bundle.class, 74, 2447, 2457)) {
                matchBundle = CallChecker.beforeCalled(matchBundle, Bundle.class, 74, 2447, 2457);
                signers = CallChecker.isCalled(matchBundle, Bundle.class, 74, 2447, 2457).getSignerCertificates(Bundle.SIGNERS_TRUSTED);
                CallChecker.varAssign(signers, "signers", 74, 2447, 2457);
            }
            signers = CallChecker.beforeCalled(signers, Map.class, 75, 2549, 2555);
            for (List<X509Certificate> signerCerts : CallChecker.isCalled(signers, Map.class, 75, 2549, 2555).values()) {
                List<String> dnChain = CallChecker.init(List.class);
                if (CallChecker.beforeDeref(signerCerts, List.class, 76, 2617, 2627)) {
                    dnChain = new ArrayList<String>(CallChecker.isCalled(signerCerts, List.class, 76, 2617, 2627).size());
                    CallChecker.varAssign(dnChain, "dnChain", 76, 2617, 2627);
                }
                if (CallChecker.beforeDeref(signerCerts, boolean.class, 77, 2675, 2685)) {
                    for (X509Certificate signerCert : signerCerts) {
                        if (CallChecker.beforeDeref(signerCert, X509Certificate.class, 78, 2706, 2715)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(signerCert, X509Certificate.class, 78, 2706, 2715).getSubjectDN(), Principal.class, 78, 2706, 2730)) {
                                if (CallChecker.beforeDeref(dnChain, List.class, 78, 2694, 2700)) {
                                    dnChain = CallChecker.beforeCalled(dnChain, List.class, 78, 2694, 2700);
                                    CallChecker.isCalled(dnChain, List.class, 78, 2694, 2700).add(CallChecker.isCalled(CallChecker.isCalled(signerCert, X509Certificate.class, 78, 2706, 2715).getSubjectDN(), Principal.class, 78, 2706, 2730).getName());
                                }
                            }
                        }
                    }
                }
                TryContext _bcornu_try_context_451 = new TryContext(451, SignerProperty.class, "java.lang.IllegalArgumentException");
                try {
                    if (FrameworkUtil.matchDistinguishedNameChain(matchPattern, dnChain)) {
                        return true;
                    }
                } catch (IllegalArgumentException e) {
                    _bcornu_try_context_451.catchStart(451);
                    continue;
                } finally {
                    _bcornu_try_context_451.finallyStart(451);
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1705.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1706 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 96, 2959, 3164);
            CallChecker.varInit(this.pattern, "pattern", 96, 2959, 3164);
            CallChecker.varInit(this.bundle, "bundle", 96, 2959, 3164);
            return 31;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1706.methodEnd();
        }
    }

    boolean isBundleSigned() {
        MethodContext _bcornu_methode_context1707 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 105, 3168, 3492);
            CallChecker.varInit(this.pattern, "pattern", 105, 3168, 3492);
            CallChecker.varInit(this.bundle, "bundle", 105, 3168, 3492);
            if ((bundle) == null) {
                return false;
            }
            Map<X509Certificate, List<X509Certificate>> signers = CallChecker.varInit(bundle.getSignerCertificates(Bundle.SIGNERS_TRUSTED), "signers", 109, 3354, 3460);
            if (CallChecker.beforeDeref(signers, Map.class, 110, 3472, 3478)) {
                signers = CallChecker.beforeCalled(signers, Map.class, 110, 3472, 3478);
                return !(CallChecker.isCalled(signers, Map.class, 110, 3472, 3478).isEmpty());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1707.methodEnd();
        }
    }
}

