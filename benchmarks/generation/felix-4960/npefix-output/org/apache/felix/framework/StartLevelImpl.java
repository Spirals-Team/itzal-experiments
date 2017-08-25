package org.apache.felix.framework;

import org.osgi.service.startlevel.StartLevel;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.framework.startlevel.FrameworkStartLevel;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.startlevel.BundleStartLevel;
import org.osgi.framework.Bundle;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class StartLevelImpl implements StartLevel {
    private final Felix m_felix;

    StartLevelImpl(Felix felix) {
        MethodContext _bcornu_methode_context18 = new MethodContext(null);
        try {
            m_felix = felix;
            CallChecker.varAssign(this.m_felix, "this.m_felix", 37, 1291, 1306);
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public int getStartLevel() {
        MethodContext _bcornu_methode_context207 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 43, 1319, 1525);
            CallChecker.varInit(this.m_felix, "m_felix", 43, 1319, 1525);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 45, 1463, 1469)) {
                final FrameworkStartLevel npe_invocation_var140 = CallChecker.isCalled(m_felix, Felix.class, 45, 1463, 1469).adapt(FrameworkStartLevel.class);
                if (CallChecker.beforeDeref(npe_invocation_var140, FrameworkStartLevel.class, 45, 1463, 1502)) {
                    return CallChecker.isCalled(npe_invocation_var140, FrameworkStartLevel.class, 45, 1463, 1502).getStartLevel();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context207.methodEnd();
        }
    }

    public void setStartLevel(int startlevel) {
        MethodContext _bcornu_methode_context208 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 51, 1532, 1759);
            CallChecker.varInit(startlevel, "startlevel", 51, 1532, 1759);
            CallChecker.varInit(this.m_felix, "m_felix", 51, 1532, 1759);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 53, 1687, 1693)) {
                final FrameworkStartLevel npe_invocation_var141 = CallChecker.isCalled(m_felix, Felix.class, 53, 1687, 1693).adapt(FrameworkStartLevel.class);
                if (CallChecker.beforeDeref(npe_invocation_var141, FrameworkStartLevel.class, 53, 1687, 1726)) {
                    CallChecker.isCalled(npe_invocation_var141, FrameworkStartLevel.class, 53, 1687, 1726).setStartLevel(startlevel);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context208.methodEnd();
        }
    }

    public int getBundleStartLevel(Bundle bundle) {
        MethodContext _bcornu_methode_context209 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 59, 1766, 2018);
            CallChecker.varInit(bundle, "bundle", 59, 1766, 2018);
            CallChecker.varInit(this.m_felix, "m_felix", 59, 1766, 2018);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 61, 1960, 1965)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 61, 1960, 1965);
                final BundleStartLevel npe_invocation_var142 = CallChecker.isCalled(bundle, Bundle.class, 61, 1960, 1965).adapt(BundleStartLevel.class);
                if (CallChecker.beforeDeref(npe_invocation_var142, BundleStartLevel.class, 61, 1960, 1995)) {
                    return CallChecker.isCalled(npe_invocation_var142, BundleStartLevel.class, 61, 1960, 1995).getStartLevel();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context209.methodEnd();
        }
    }

    public void setBundleStartLevel(Bundle bundle, int startlevel) {
        MethodContext _bcornu_methode_context210 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 67, 2025, 2302);
            CallChecker.varInit(startlevel, "startlevel", 67, 2025, 2302);
            CallChecker.varInit(bundle, "bundle", 67, 2025, 2302);
            CallChecker.varInit(this.m_felix, "m_felix", 67, 2025, 2302);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 69, 2234, 2239)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 69, 2234, 2239);
                final BundleStartLevel npe_invocation_var143 = CallChecker.isCalled(bundle, Bundle.class, 69, 2234, 2239).adapt(BundleStartLevel.class);
                if (CallChecker.beforeDeref(npe_invocation_var143, BundleStartLevel.class, 69, 2234, 2269)) {
                    CallChecker.isCalled(npe_invocation_var143, BundleStartLevel.class, 69, 2234, 2269).setStartLevel(startlevel);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context210.methodEnd();
        }
    }

    public int getInitialBundleStartLevel() {
        MethodContext _bcornu_methode_context211 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 75, 2309, 2554);
            CallChecker.varInit(this.m_felix, "m_felix", 75, 2309, 2554);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 77, 2479, 2485)) {
                final FrameworkStartLevel npe_invocation_var144 = CallChecker.isCalled(m_felix, Felix.class, 77, 2479, 2485).adapt(FrameworkStartLevel.class);
                if (CallChecker.beforeDeref(npe_invocation_var144, FrameworkStartLevel.class, 77, 2479, 2518)) {
                    return CallChecker.isCalled(npe_invocation_var144, FrameworkStartLevel.class, 77, 2479, 2518).getInitialBundleStartLevel();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context211.methodEnd();
        }
    }

    public void setInitialBundleStartLevel(int startlevel) {
        MethodContext _bcornu_methode_context212 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 83, 2561, 2827);
            CallChecker.varInit(startlevel, "startlevel", 83, 2561, 2827);
            CallChecker.varInit(this.m_felix, "m_felix", 83, 2561, 2827);
            if (CallChecker.beforeDeref(m_felix, Felix.class, 85, 2742, 2748)) {
                final FrameworkStartLevel npe_invocation_var145 = CallChecker.isCalled(m_felix, Felix.class, 85, 2742, 2748).adapt(FrameworkStartLevel.class);
                if (CallChecker.beforeDeref(npe_invocation_var145, FrameworkStartLevel.class, 85, 2742, 2781)) {
                    CallChecker.isCalled(npe_invocation_var145, FrameworkStartLevel.class, 85, 2742, 2781).setInitialBundleStartLevel(startlevel);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context212.methodEnd();
        }
    }

    public boolean isBundlePersistentlyStarted(Bundle bundle) {
        MethodContext _bcornu_methode_context213 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 91, 2834, 3114);
            CallChecker.varInit(bundle, "bundle", 91, 2834, 3114);
            CallChecker.varInit(this.m_felix, "m_felix", 91, 2834, 3114);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 93, 3048, 3053)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 93, 3048, 3053);
                final BundleStartLevel npe_invocation_var146 = CallChecker.isCalled(bundle, Bundle.class, 93, 3048, 3053).adapt(BundleStartLevel.class);
                if (CallChecker.beforeDeref(npe_invocation_var146, BundleStartLevel.class, 93, 3048, 3083)) {
                    return CallChecker.isCalled(npe_invocation_var146, BundleStartLevel.class, 93, 3048, 3083).isPersistentlyStarted();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context213.methodEnd();
        }
    }

    public boolean isBundleActivationPolicyUsed(Bundle bundle) {
        MethodContext _bcornu_methode_context214 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 99, 3121, 3401);
            CallChecker.varInit(bundle, "bundle", 99, 3121, 3401);
            CallChecker.varInit(this.m_felix, "m_felix", 99, 3121, 3401);
            if (CallChecker.beforeDeref(bundle, Bundle.class, 101, 3334, 3339)) {
                bundle = CallChecker.beforeCalled(bundle, Bundle.class, 101, 3334, 3339);
                final BundleStartLevel npe_invocation_var147 = CallChecker.isCalled(bundle, Bundle.class, 101, 3334, 3339).adapt(BundleStartLevel.class);
                if (CallChecker.beforeDeref(npe_invocation_var147, BundleStartLevel.class, 101, 3334, 3369)) {
                    return CallChecker.isCalled(npe_invocation_var147, BundleStartLevel.class, 101, 3334, 3369).isActivationPolicyUsed();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context214.methodEnd();
        }
    }
}

