package org.apache.felix.framework;

import org.osgi.framework.hooks.weaving.WovenClass;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleRequirement;
import java.util.ArrayList;
import org.osgi.framework.AdminPermission;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.felix.framework.util.ImmutableList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.felix.framework.util.manifestparser.ManifestParser;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.framework.PackagePermission;
import java.security.ProtectionDomain;

class WovenClassImpl implements List<String> , WovenClass {
    private final String m_className;

    private final BundleWiring m_wiring;

    private byte[] m_bytes;

    private List<String> m_imports = new ArrayList<String>();

    private Class m_definedClass = null;

    private boolean m_isComplete = false;

    private int m_state;

    WovenClassImpl(String className, BundleWiring wiring, byte[] bytes) {
        MethodContext _bcornu_methode_context129 = new MethodContext(null);
        try {
            m_className = className;
            CallChecker.varAssign(this.m_className, "this.m_className", 50, 1884, 1907);
            m_wiring = wiring;
            CallChecker.varAssign(this.m_wiring, "this.m_wiring", 51, 1917, 1934);
            m_bytes = bytes;
            CallChecker.varAssign(this.m_bytes, "this.m_bytes", 52, 1944, 1959);
            m_state = WovenClass.TRANSFORMING;
            CallChecker.varAssign(this.m_state, "this.m_state", 53, 1969, 1991);
        } finally {
            _bcornu_methode_context129.methodEnd();
        }
    }

    synchronized void complete(Class definedClass, byte[] bytes, List<String> imports) {
        MethodContext _bcornu_methode_context1257 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 56, 2004, 2234);
            CallChecker.varInit(imports, "imports", 56, 2004, 2234);
            CallChecker.varInit(bytes, "bytes", 56, 2004, 2234);
            CallChecker.varInit(definedClass, "definedClass", 56, 2004, 2234);
            CallChecker.varInit(this.m_state, "m_state", 56, 2004, 2234);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 56, 2004, 2234);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 56, 2004, 2234);
            CallChecker.varInit(this.m_imports, "m_imports", 56, 2004, 2234);
            CallChecker.varInit(this.m_bytes, "m_bytes", 56, 2004, 2234);
            CallChecker.varInit(this.m_wiring, "m_wiring", 56, 2004, 2234);
            CallChecker.varInit(this.m_className, "m_className", 56, 2004, 2234);
            completeDefine(definedClass);
            if (bytes == null) {
                m_bytes = m_bytes;
                CallChecker.varAssign(this.m_bytes, "this.m_bytes", 60, 2151, 2194);
            }else {
                m_bytes = bytes;
                CallChecker.varAssign(this.m_bytes, "this.m_bytes", 60, 2151, 2194);
            }
            completeImports(imports);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1257.methodEnd();
        }
    }

    synchronized void completeImports(List<String> imports) {
        MethodContext _bcornu_methode_context1258 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 64, 2241, 2438);
            CallChecker.varInit(imports, "imports", 64, 2241, 2438);
            CallChecker.varInit(this.m_state, "m_state", 64, 2241, 2438);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 64, 2241, 2438);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 64, 2241, 2438);
            CallChecker.varInit(this.m_imports, "m_imports", 64, 2241, 2438);
            CallChecker.varInit(this.m_bytes, "m_bytes", 64, 2241, 2438);
            CallChecker.varInit(this.m_wiring, "m_wiring", 64, 2241, 2438);
            CallChecker.varInit(this.m_className, "m_className", 64, 2241, 2438);
            if (imports == null) {
                m_imports = ImmutableList.newInstance(m_imports);
                CallChecker.varAssign(this.m_imports, "this.m_imports", 66, 2311, 2432);
            }else {
                m_imports = ImmutableList.newInstance(imports);
                CallChecker.varAssign(this.m_imports, "this.m_imports", 66, 2311, 2432);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1258.methodEnd();
        }
    }

    synchronized void completeDefine(Class definedClass) {
        MethodContext _bcornu_methode_context1259 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 70, 2445, 2547);
            CallChecker.varInit(definedClass, "definedClass", 70, 2445, 2547);
            CallChecker.varInit(this.m_state, "m_state", 70, 2445, 2547);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 70, 2445, 2547);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 70, 2445, 2547);
            CallChecker.varInit(this.m_imports, "m_imports", 70, 2445, 2547);
            CallChecker.varInit(this.m_bytes, "m_bytes", 70, 2445, 2547);
            CallChecker.varInit(this.m_wiring, "m_wiring", 70, 2445, 2547);
            CallChecker.varInit(this.m_className, "m_className", 70, 2445, 2547);
            m_definedClass = definedClass;
            CallChecker.varAssign(this.m_definedClass, "this.m_definedClass", 72, 2512, 2541);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1259.methodEnd();
        }
    }

    public synchronized byte[] getBytes() {
        MethodContext _bcornu_methode_context1260 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 75, 2554, 3036);
            CallChecker.varInit(this.m_state, "m_state", 75, 2554, 3036);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 75, 2554, 3036);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 75, 2554, 3036);
            CallChecker.varInit(this.m_imports, "m_imports", 75, 2554, 3036);
            CallChecker.varInit(this.m_bytes, "m_bytes", 75, 2554, 3036);
            CallChecker.varInit(this.m_wiring, "m_wiring", 75, 2554, 3036);
            CallChecker.varInit(this.m_className, "m_className", 75, 2554, 3036);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 77, 2606, 2654);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 80, 2741, 2748)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 80, 2741, 2748).getBundle(), AdminPermission.WEAVE));
                }
            }
            byte[] bytes = CallChecker.varInit(m_bytes, "bytes", 83, 2826, 2848);
            if (m_isComplete) {
                if (CallChecker.beforeDeref(m_bytes, byte[].class, 86, 2915, 2921)) {
                    m_bytes = CallChecker.beforeCalled(m_bytes, byte[].class, 86, 2915, 2921);
                    bytes = new byte[CallChecker.isCalled(m_bytes, byte[].class, 86, 2915, 2921).length];
                    CallChecker.varAssign(bytes, "bytes", 86, 2898, 2930);
                }
                if (CallChecker.beforeDeref(m_bytes, byte[].class, 87, 2983, 2989)) {
                    m_bytes = CallChecker.beforeCalled(m_bytes, byte[].class, 87, 2983, 2989);
                    System.arraycopy(m_bytes, 0, bytes, 0, CallChecker.isCalled(m_bytes, byte[].class, 87, 2983, 2989).length);
                }
            }
            return bytes;
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1260.methodEnd();
        }
    }

    public synchronized void setBytes(byte[] bytes) {
        MethodContext _bcornu_methode_context1261 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 92, 3043, 3554);
            CallChecker.varInit(bytes, "bytes", 92, 3043, 3554);
            CallChecker.varInit(this.m_state, "m_state", 92, 3043, 3554);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 92, 3043, 3554);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 92, 3043, 3554);
            CallChecker.varInit(this.m_imports, "m_imports", 92, 3043, 3554);
            CallChecker.varInit(this.m_bytes, "m_bytes", 92, 3043, 3554);
            CallChecker.varInit(this.m_wiring, "m_wiring", 92, 3043, 3554);
            CallChecker.varInit(this.m_className, "m_className", 92, 3043, 3554);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 94, 3105, 3153);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 97, 3240, 3247)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 97, 3240, 3247).getBundle(), AdminPermission.WEAVE));
                }
            }
            if ((m_state) >= (WovenClass.TRANSFORMED)) {
                throw new IllegalStateException("Cannot change bytes after class weaving is completed.");
            }else {
                m_bytes = bytes;
                CallChecker.varAssign(this.m_bytes, "this.m_bytes", 106, 3523, 3538);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1261.methodEnd();
        }
    }

    synchronized List<String> getDynamicImportsInternal() {
        MethodContext _bcornu_methode_context1262 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 110, 3561, 3651);
            CallChecker.varInit(this.m_state, "m_state", 110, 3561, 3651);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 110, 3561, 3651);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 110, 3561, 3651);
            CallChecker.varInit(this.m_imports, "m_imports", 110, 3561, 3651);
            CallChecker.varInit(this.m_bytes, "m_bytes", 110, 3561, 3651);
            CallChecker.varInit(this.m_wiring, "m_wiring", 110, 3561, 3651);
            CallChecker.varInit(this.m_className, "m_className", 110, 3561, 3651);
            return m_imports;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1262.methodEnd();
        }
    }

    public synchronized List<String> getDynamicImports() {
        MethodContext _bcornu_methode_context1263 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 115, 3658, 3742);
            CallChecker.varInit(this.m_state, "m_state", 115, 3658, 3742);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 115, 3658, 3742);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 115, 3658, 3742);
            CallChecker.varInit(this.m_imports, "m_imports", 115, 3658, 3742);
            CallChecker.varInit(this.m_bytes, "m_bytes", 115, 3658, 3742);
            CallChecker.varInit(this.m_wiring, "m_wiring", 115, 3658, 3742);
            CallChecker.varInit(this.m_className, "m_className", 115, 3658, 3742);
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1263.methodEnd();
        }
    }

    public synchronized boolean isWeavingComplete() {
        MethodContext _bcornu_methode_context1264 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 120, 3749, 3836);
            CallChecker.varInit(this.m_state, "m_state", 120, 3749, 3836);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 120, 3749, 3836);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 120, 3749, 3836);
            CallChecker.varInit(this.m_imports, "m_imports", 120, 3749, 3836);
            CallChecker.varInit(this.m_bytes, "m_bytes", 120, 3749, 3836);
            CallChecker.varInit(this.m_wiring, "m_wiring", 120, 3749, 3836);
            CallChecker.varInit(this.m_className, "m_className", 120, 3749, 3836);
            return m_isComplete;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1264.methodEnd();
        }
    }

    public String getClassName() {
        MethodContext _bcornu_methode_context1265 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 125, 3843, 3910);
            CallChecker.varInit(this.m_state, "m_state", 125, 3843, 3910);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 125, 3843, 3910);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 125, 3843, 3910);
            CallChecker.varInit(this.m_imports, "m_imports", 125, 3843, 3910);
            CallChecker.varInit(this.m_bytes, "m_bytes", 125, 3843, 3910);
            CallChecker.varInit(this.m_wiring, "m_wiring", 125, 3843, 3910);
            CallChecker.varInit(this.m_className, "m_className", 125, 3843, 3910);
            return m_className;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1265.methodEnd();
        }
    }

    public ProtectionDomain getProtectionDomain() {
        MethodContext _bcornu_methode_context1266 = new MethodContext(ProtectionDomain.class);
        try {
            CallChecker.varInit(this, "this", 130, 3917, 4078);
            CallChecker.varInit(this.m_state, "m_state", 130, 3917, 4078);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 130, 3917, 4078);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 130, 3917, 4078);
            CallChecker.varInit(this.m_imports, "m_imports", 130, 3917, 4078);
            CallChecker.varInit(this.m_bytes, "m_bytes", 130, 3917, 4078);
            CallChecker.varInit(this.m_wiring, "m_wiring", 130, 3917, 4078);
            CallChecker.varInit(this.m_className, "m_className", 130, 3917, 4078);
            if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 132, 3998, 4005)) {
                final BundleRevision npe_invocation_var445 = CallChecker.isCalled(m_wiring, BundleWiring.class, 132, 3998, 4005).getRevision();
                if (CallChecker.beforeDeref(npe_invocation_var445, BundleRevision.class, 132, 3998, 4019)) {
                    final BundleImpl npe_invocation_var446 = ((BundleImpl) (CallChecker.isCalled(npe_invocation_var445, BundleRevision.class, 132, 3998, 4019).getBundle()));
                    if (CallChecker.beforeDeref(npe_invocation_var446, BundleImpl.class, 132, 3998, 4031)) {
                        return CallChecker.isCalled(npe_invocation_var446, BundleImpl.class, 132, 3998, 4031).getProtectionDomain();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ProtectionDomain) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1266.methodEnd();
        }
    }

    public synchronized Class<?> getDefinedClass() {
        MethodContext _bcornu_methode_context1267 = new MethodContext(Class.class);
        try {
            CallChecker.varInit(this, "this", 136, 4085, 4173);
            CallChecker.varInit(this.m_state, "m_state", 136, 4085, 4173);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 136, 4085, 4173);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 136, 4085, 4173);
            CallChecker.varInit(this.m_imports, "m_imports", 136, 4085, 4173);
            CallChecker.varInit(this.m_bytes, "m_bytes", 136, 4085, 4173);
            CallChecker.varInit(this.m_wiring, "m_wiring", 136, 4085, 4173);
            CallChecker.varInit(this.m_className, "m_className", 136, 4085, 4173);
            return m_definedClass;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1267.methodEnd();
        }
    }

    public BundleWiring getBundleWiring() {
        MethodContext _bcornu_methode_context1268 = new MethodContext(BundleWiring.class);
        try {
            CallChecker.varInit(this, "this", 141, 4180, 4253);
            CallChecker.varInit(this.m_state, "m_state", 141, 4180, 4253);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 141, 4180, 4253);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 141, 4180, 4253);
            CallChecker.varInit(this.m_imports, "m_imports", 141, 4180, 4253);
            CallChecker.varInit(this.m_bytes, "m_bytes", 141, 4180, 4253);
            CallChecker.varInit(this.m_wiring, "m_wiring", 141, 4180, 4253);
            CallChecker.varInit(this.m_className, "m_className", 141, 4180, 4253);
            return m_wiring;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleWiring) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1268.methodEnd();
        }
    }

    public synchronized int size() {
        MethodContext _bcornu_methode_context1269 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 153, 4260, 4611);
            CallChecker.varInit(this.m_state, "m_state", 153, 4260, 4611);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 153, 4260, 4611);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 153, 4260, 4611);
            CallChecker.varInit(this.m_imports, "m_imports", 153, 4260, 4611);
            CallChecker.varInit(this.m_bytes, "m_bytes", 153, 4260, 4611);
            CallChecker.varInit(this.m_wiring, "m_wiring", 153, 4260, 4611);
            CallChecker.varInit(this.m_className, "m_className", 153, 4260, 4611);
            if (CallChecker.beforeDeref(m_imports, List.class, 155, 4589, 4597)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 155, 4589, 4597);
                return CallChecker.isCalled(m_imports, List.class, 155, 4589, 4597).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1269.methodEnd();
        }
    }

    public synchronized boolean isEmpty() {
        MethodContext _bcornu_methode_context1270 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 158, 4618, 4702);
            CallChecker.varInit(this.m_state, "m_state", 158, 4618, 4702);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 158, 4618, 4702);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 158, 4618, 4702);
            CallChecker.varInit(this.m_imports, "m_imports", 158, 4618, 4702);
            CallChecker.varInit(this.m_bytes, "m_bytes", 158, 4618, 4702);
            CallChecker.varInit(this.m_wiring, "m_wiring", 158, 4618, 4702);
            CallChecker.varInit(this.m_className, "m_className", 158, 4618, 4702);
            if (CallChecker.beforeDeref(m_imports, List.class, 160, 4677, 4685)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 160, 4677, 4685);
                return CallChecker.isCalled(m_imports, List.class, 160, 4677, 4685).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1270.methodEnd();
        }
    }

    public synchronized boolean contains(Object o) {
        MethodContext _bcornu_methode_context1271 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 163, 4709, 4804);
            CallChecker.varInit(o, "o", 163, 4709, 4804);
            CallChecker.varInit(this.m_state, "m_state", 163, 4709, 4804);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 163, 4709, 4804);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 163, 4709, 4804);
            CallChecker.varInit(this.m_imports, "m_imports", 163, 4709, 4804);
            CallChecker.varInit(this.m_bytes, "m_bytes", 163, 4709, 4804);
            CallChecker.varInit(this.m_wiring, "m_wiring", 163, 4709, 4804);
            CallChecker.varInit(this.m_className, "m_className", 163, 4709, 4804);
            if (CallChecker.beforeDeref(m_imports, List.class, 165, 4777, 4785)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 165, 4777, 4785);
                return CallChecker.isCalled(m_imports, List.class, 165, 4777, 4785).contains(o);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1271.methodEnd();
        }
    }

    public synchronized Iterator<String> iterator() {
        MethodContext _bcornu_methode_context1272 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 168, 4811, 4906);
            CallChecker.varInit(this.m_state, "m_state", 168, 4811, 4906);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 168, 4811, 4906);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 168, 4811, 4906);
            CallChecker.varInit(this.m_imports, "m_imports", 168, 4811, 4906);
            CallChecker.varInit(this.m_bytes, "m_bytes", 168, 4811, 4906);
            CallChecker.varInit(this.m_wiring, "m_wiring", 168, 4811, 4906);
            CallChecker.varInit(this.m_className, "m_className", 168, 4811, 4906);
            if (CallChecker.beforeDeref(m_imports, List.class, 170, 4880, 4888)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 170, 4880, 4888);
                return CallChecker.isCalled(m_imports, List.class, 170, 4880, 4888).iterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1272.methodEnd();
        }
    }

    public synchronized Object[] toArray() {
        MethodContext _bcornu_methode_context1273 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 173, 4913, 4998);
            CallChecker.varInit(this.m_state, "m_state", 173, 4913, 4998);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 173, 4913, 4998);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 173, 4913, 4998);
            CallChecker.varInit(this.m_imports, "m_imports", 173, 4913, 4998);
            CallChecker.varInit(this.m_bytes, "m_bytes", 173, 4913, 4998);
            CallChecker.varInit(this.m_wiring, "m_wiring", 173, 4913, 4998);
            CallChecker.varInit(this.m_className, "m_className", 173, 4913, 4998);
            if (CallChecker.beforeDeref(m_imports, List.class, 175, 4973, 4981)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 175, 4973, 4981);
                return CallChecker.isCalled(m_imports, List.class, 175, 4973, 4981).toArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1273.methodEnd();
        }
    }

    public synchronized <T> T[] toArray(T[] ts) {
        MethodContext _bcornu_methode_context1274 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 178, 5005, 5097);
            CallChecker.varInit(ts, "ts", 178, 5005, 5097);
            CallChecker.varInit(this.m_state, "m_state", 178, 5005, 5097);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 178, 5005, 5097);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 178, 5005, 5097);
            CallChecker.varInit(this.m_imports, "m_imports", 178, 5005, 5097);
            CallChecker.varInit(this.m_bytes, "m_bytes", 178, 5005, 5097);
            CallChecker.varInit(this.m_wiring, "m_wiring", 178, 5005, 5097);
            CallChecker.varInit(this.m_className, "m_className", 178, 5005, 5097);
            if (CallChecker.beforeDeref(m_imports, List.class, 180, 5070, 5078)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 180, 5070, 5078);
                return CallChecker.isCalled(m_imports, List.class, 180, 5070, 5078).toArray(ts);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1274.methodEnd();
        }
    }

    public synchronized boolean add(String s) {
        MethodContext _bcornu_methode_context1275 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 183, 5104, 5915);
            CallChecker.varInit(s, "s", 183, 5104, 5915);
            CallChecker.varInit(this.m_state, "m_state", 183, 5104, 5915);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 183, 5104, 5915);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 183, 5104, 5915);
            CallChecker.varInit(this.m_imports, "m_imports", 183, 5104, 5915);
            CallChecker.varInit(this.m_bytes, "m_bytes", 183, 5104, 5915);
            CallChecker.varInit(this.m_wiring, "m_wiring", 183, 5104, 5915);
            CallChecker.varInit(this.m_className, "m_className", 183, 5104, 5915);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 185, 5160, 5208);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 188, 5295, 5302)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 188, 5295, 5302).getBundle(), AdminPermission.WEAVE));
                }
            }
            if (s != null) {
                TryContext _bcornu_try_context_352 = new TryContext(352, WovenClassImpl.class, "java.lang.Exception");
                try {
                    List<BundleRequirement> reqs = CallChecker.varInit(ManifestParser.parseDynamicImportHeader(null, null, s), "reqs", 195, 5451, 5561);
                } catch (Exception ex) {
                    _bcornu_try_context_352.catchStart(352);
                    RuntimeException re = CallChecker.varInit(new IllegalArgumentException("Unable to parse dynamic import."), "re", 199, 5628, 5738);
                    if (CallChecker.beforeDeref(re, RuntimeException.class, 201, 5756, 5757)) {
                        re = CallChecker.beforeCalled(re, RuntimeException.class, 201, 5756, 5757);
                        CallChecker.isCalled(re, RuntimeException.class, 201, 5756, 5757).initCause(ex);
                    }
                    throw re;
                } finally {
                    _bcornu_try_context_352.finallyStart(352);
                }
                checkImport(s);
                if (CallChecker.beforeDeref(m_imports, List.class, 205, 5861, 5869)) {
                    m_imports = CallChecker.beforeCalled(m_imports, List.class, 205, 5861, 5869);
                    return CallChecker.isCalled(m_imports, List.class, 205, 5861, 5869).add(s);
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1275.methodEnd();
        }
    }

    private void checkImport(String s) {
        MethodContext _bcornu_methode_context1276 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 210, 5922, 6154);
            CallChecker.varInit(s, "s", 210, 5922, 6154);
            CallChecker.varInit(this.m_state, "m_state", 210, 5922, 6154);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 210, 5922, 6154);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 210, 5922, 6154);
            CallChecker.varInit(this.m_imports, "m_imports", 210, 5922, 6154);
            CallChecker.varInit(this.m_bytes, "m_bytes", 210, 5922, 6154);
            CallChecker.varInit(this.m_wiring, "m_wiring", 210, 5922, 6154);
            CallChecker.varInit(this.m_className, "m_className", 210, 5922, 6154);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 212, 5971, 6019);
            if (sm != null) {
                sm.checkPermission(new PackagePermission(s, PackagePermission.IMPORT));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1276.methodEnd();
        }
    }

    public synchronized boolean remove(Object o) {
        MethodContext _bcornu_methode_context1277 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 220, 6161, 6472);
            CallChecker.varInit(o, "o", 220, 6161, 6472);
            CallChecker.varInit(this.m_state, "m_state", 220, 6161, 6472);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 220, 6161, 6472);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 220, 6161, 6472);
            CallChecker.varInit(this.m_imports, "m_imports", 220, 6161, 6472);
            CallChecker.varInit(this.m_bytes, "m_bytes", 220, 6161, 6472);
            CallChecker.varInit(this.m_wiring, "m_wiring", 220, 6161, 6472);
            CallChecker.varInit(this.m_className, "m_className", 220, 6161, 6472);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 222, 6220, 6268);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 225, 6355, 6362)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 225, 6355, 6362).getBundle(), AdminPermission.WEAVE));
                }
            }
            if (CallChecker.beforeDeref(m_imports, List.class, 228, 6447, 6455)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 228, 6447, 6455);
                return CallChecker.isCalled(m_imports, List.class, 228, 6447, 6455).remove(o);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1277.methodEnd();
        }
    }

    public synchronized boolean containsAll(Collection<?> collection) {
        MethodContext _bcornu_methode_context1278 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 231, 6479, 6605);
            CallChecker.varInit(collection, "collection", 231, 6479, 6605);
            CallChecker.varInit(this.m_state, "m_state", 231, 6479, 6605);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 231, 6479, 6605);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 231, 6479, 6605);
            CallChecker.varInit(this.m_imports, "m_imports", 231, 6479, 6605);
            CallChecker.varInit(this.m_bytes, "m_bytes", 231, 6479, 6605);
            CallChecker.varInit(this.m_wiring, "m_wiring", 231, 6479, 6605);
            CallChecker.varInit(this.m_className, "m_className", 231, 6479, 6605);
            if (CallChecker.beforeDeref(m_imports, List.class, 233, 6566, 6574)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 233, 6566, 6574);
                return CallChecker.isCalled(m_imports, List.class, 233, 6566, 6574).containsAll(collection);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1278.methodEnd();
        }
    }

    public synchronized boolean addAll(Collection<? extends String> collection) {
        MethodContext _bcornu_methode_context1279 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 236, 6612, 7456);
            CallChecker.varInit(collection, "collection", 236, 6612, 7456);
            CallChecker.varInit(this.m_state, "m_state", 236, 6612, 7456);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 236, 6612, 7456);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 236, 6612, 7456);
            CallChecker.varInit(this.m_imports, "m_imports", 236, 6612, 7456);
            CallChecker.varInit(this.m_bytes, "m_bytes", 236, 6612, 7456);
            CallChecker.varInit(this.m_wiring, "m_wiring", 236, 6612, 7456);
            CallChecker.varInit(this.m_className, "m_className", 236, 6612, 7456);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 238, 6702, 6750);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 241, 6837, 6844)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 241, 6837, 6844).getBundle(), AdminPermission.WEAVE));
                }
            }
            if (CallChecker.beforeDeref(collection, boolean.class, 244, 6938, 6947)) {
                for (String s : collection) {
                    TryContext _bcornu_try_context_353 = new TryContext(353, WovenClassImpl.class, "java.lang.Exception");
                    try {
                        List<BundleRequirement> reqs = CallChecker.varInit(ManifestParser.parseDynamicImportHeader(null, null, s), "reqs", 248, 7006, 7116);
                    } catch (Exception ex) {
                        _bcornu_try_context_353.catchStart(353);
                        RuntimeException re = CallChecker.varInit(new IllegalArgumentException("Unable to parse dynamic import."), "re", 252, 7183, 7293);
                        if (CallChecker.beforeDeref(re, RuntimeException.class, 254, 7311, 7312)) {
                            re = CallChecker.beforeCalled(re, RuntimeException.class, 254, 7311, 7312);
                            CallChecker.isCalled(re, RuntimeException.class, 254, 7311, 7312).initCause(ex);
                        }
                        throw re;
                    } finally {
                        _bcornu_try_context_353.finallyStart(353);
                    }
                    checkImport(s);
                }
            }
            if (CallChecker.beforeDeref(m_imports, List.class, 259, 7422, 7430)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 259, 7422, 7430);
                return CallChecker.isCalled(m_imports, List.class, 259, 7422, 7430).addAll(collection);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1279.methodEnd();
        }
    }

    public synchronized boolean addAll(int i, Collection<? extends String> collection) {
        MethodContext _bcornu_methode_context1280 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 262, 7463, 8329);
            CallChecker.varInit(collection, "collection", 262, 7463, 8329);
            CallChecker.varInit(i, "i", 262, 7463, 8329);
            CallChecker.varInit(this.m_state, "m_state", 262, 7463, 8329);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 262, 7463, 8329);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 262, 7463, 8329);
            CallChecker.varInit(this.m_imports, "m_imports", 262, 7463, 8329);
            CallChecker.varInit(this.m_bytes, "m_bytes", 262, 7463, 8329);
            CallChecker.varInit(this.m_wiring, "m_wiring", 262, 7463, 8329);
            CallChecker.varInit(this.m_className, "m_className", 262, 7463, 8329);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 265, 7572, 7620);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 268, 7707, 7714)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 268, 7707, 7714).getBundle(), AdminPermission.WEAVE));
                }
            }
            if (CallChecker.beforeDeref(collection, boolean.class, 271, 7808, 7817)) {
                for (String s : collection) {
                    TryContext _bcornu_try_context_354 = new TryContext(354, WovenClassImpl.class, "java.lang.Exception");
                    try {
                        List<BundleRequirement> reqs = CallChecker.varInit(ManifestParser.parseDynamicImportHeader(null, null, s), "reqs", 275, 7876, 7986);
                    } catch (Exception ex) {
                        _bcornu_try_context_354.catchStart(354);
                        RuntimeException re = CallChecker.varInit(new IllegalArgumentException("Unable to parse dynamic import."), "re", 279, 8053, 8163);
                        if (CallChecker.beforeDeref(re, RuntimeException.class, 281, 8181, 8182)) {
                            re = CallChecker.beforeCalled(re, RuntimeException.class, 281, 8181, 8182);
                            CallChecker.isCalled(re, RuntimeException.class, 281, 8181, 8182).initCause(ex);
                        }
                        throw re;
                    } finally {
                        _bcornu_try_context_354.finallyStart(354);
                    }
                    checkImport(s);
                }
            }
            if (CallChecker.beforeDeref(m_imports, List.class, 286, 8292, 8300)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 286, 8292, 8300);
                return CallChecker.isCalled(m_imports, List.class, 286, 8292, 8300).addAll(i, collection);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1280.methodEnd();
        }
    }

    public synchronized boolean removeAll(Collection<?> collection) {
        MethodContext _bcornu_methode_context1281 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 289, 8336, 8678);
            CallChecker.varInit(collection, "collection", 289, 8336, 8678);
            CallChecker.varInit(this.m_state, "m_state", 289, 8336, 8678);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 289, 8336, 8678);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 289, 8336, 8678);
            CallChecker.varInit(this.m_imports, "m_imports", 289, 8336, 8678);
            CallChecker.varInit(this.m_bytes, "m_bytes", 289, 8336, 8678);
            CallChecker.varInit(this.m_wiring, "m_wiring", 289, 8336, 8678);
            CallChecker.varInit(this.m_className, "m_className", 289, 8336, 8678);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 291, 8414, 8462);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 294, 8549, 8556)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 294, 8549, 8556).getBundle(), AdminPermission.WEAVE));
                }
            }
            if (CallChecker.beforeDeref(m_imports, List.class, 297, 8641, 8649)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 297, 8641, 8649);
                return CallChecker.isCalled(m_imports, List.class, 297, 8641, 8649).removeAll(collection);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1281.methodEnd();
        }
    }

    public synchronized boolean retainAll(Collection<?> collection) {
        MethodContext _bcornu_methode_context1282 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 300, 8685, 9027);
            CallChecker.varInit(collection, "collection", 300, 8685, 9027);
            CallChecker.varInit(this.m_state, "m_state", 300, 8685, 9027);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 300, 8685, 9027);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 300, 8685, 9027);
            CallChecker.varInit(this.m_imports, "m_imports", 300, 8685, 9027);
            CallChecker.varInit(this.m_bytes, "m_bytes", 300, 8685, 9027);
            CallChecker.varInit(this.m_wiring, "m_wiring", 300, 8685, 9027);
            CallChecker.varInit(this.m_className, "m_className", 300, 8685, 9027);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 302, 8763, 8811);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 305, 8898, 8905)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 305, 8898, 8905).getBundle(), AdminPermission.WEAVE));
                }
            }
            if (CallChecker.beforeDeref(m_imports, List.class, 308, 8990, 8998)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 308, 8990, 8998);
                return CallChecker.isCalled(m_imports, List.class, 308, 8990, 8998).retainAll(collection);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1282.methodEnd();
        }
    }

    public synchronized void clear() {
        MethodContext _bcornu_methode_context1283 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 311, 9034, 9324);
            CallChecker.varInit(this.m_state, "m_state", 311, 9034, 9324);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 311, 9034, 9324);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 311, 9034, 9324);
            CallChecker.varInit(this.m_imports, "m_imports", 311, 9034, 9324);
            CallChecker.varInit(this.m_bytes, "m_bytes", 311, 9034, 9324);
            CallChecker.varInit(this.m_wiring, "m_wiring", 311, 9034, 9324);
            CallChecker.varInit(this.m_className, "m_className", 311, 9034, 9324);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 313, 9081, 9129);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 316, 9216, 9223)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 316, 9216, 9223).getBundle(), AdminPermission.WEAVE));
                }
            }
            if (CallChecker.beforeDeref(m_imports, List.class, 319, 9301, 9309)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 319, 9301, 9309);
                CallChecker.isCalled(m_imports, List.class, 319, 9301, 9309).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1283.methodEnd();
        }
    }

    public synchronized String get(int i) {
        MethodContext _bcornu_methode_context1284 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 322, 9331, 9412);
            CallChecker.varInit(i, "i", 322, 9331, 9412);
            CallChecker.varInit(this.m_state, "m_state", 322, 9331, 9412);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 322, 9331, 9412);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 322, 9331, 9412);
            CallChecker.varInit(this.m_imports, "m_imports", 322, 9331, 9412);
            CallChecker.varInit(this.m_bytes, "m_bytes", 322, 9331, 9412);
            CallChecker.varInit(this.m_wiring, "m_wiring", 322, 9331, 9412);
            CallChecker.varInit(this.m_className, "m_className", 322, 9331, 9412);
            if (CallChecker.beforeDeref(m_imports, List.class, 324, 9390, 9398)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 324, 9390, 9398);
                return CallChecker.isCalled(m_imports, List.class, 324, 9390, 9398).get(i);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1284.methodEnd();
        }
    }

    public synchronized String set(int i, String s) {
        MethodContext _bcornu_methode_context1285 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 327, 9419, 10122);
            CallChecker.varInit(s, "s", 327, 9419, 10122);
            CallChecker.varInit(i, "i", 327, 9419, 10122);
            CallChecker.varInit(this.m_state, "m_state", 327, 9419, 10122);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 327, 9419, 10122);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 327, 9419, 10122);
            CallChecker.varInit(this.m_imports, "m_imports", 327, 9419, 10122);
            CallChecker.varInit(this.m_bytes, "m_bytes", 327, 9419, 10122);
            CallChecker.varInit(this.m_wiring, "m_wiring", 327, 9419, 10122);
            CallChecker.varInit(this.m_className, "m_className", 327, 9419, 10122);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 329, 9481, 9529);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 332, 9616, 9623)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 332, 9616, 9623).getBundle(), AdminPermission.WEAVE));
                }
            }
            TryContext _bcornu_try_context_355 = new TryContext(355, WovenClassImpl.class, "java.lang.Exception");
            try {
                List<BundleRequirement> reqs = CallChecker.varInit(ManifestParser.parseDynamicImportHeader(null, null, s), "reqs", 337, 9727, 9833);
            } catch (Exception ex) {
                _bcornu_try_context_355.catchStart(355);
                RuntimeException re = CallChecker.varInit(new IllegalArgumentException("Unable to parse dynamic import."), "re", 341, 9888, 9994);
                if (CallChecker.beforeDeref(re, RuntimeException.class, 343, 10008, 10009)) {
                    re = CallChecker.beforeCalled(re, RuntimeException.class, 343, 10008, 10009);
                    CallChecker.isCalled(re, RuntimeException.class, 343, 10008, 10009).initCause(ex);
                }
                throw re;
            } finally {
                _bcornu_try_context_355.finallyStart(355);
            }
            checkImport(s);
            if (CallChecker.beforeDeref(m_imports, List.class, 347, 10097, 10105)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 347, 10097, 10105);
                return CallChecker.isCalled(m_imports, List.class, 347, 10097, 10105).set(i, s);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1285.methodEnd();
        }
    }

    public synchronized void add(int i, String s) {
        MethodContext _bcornu_methode_context1286 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 350, 10129, 10823);
            CallChecker.varInit(s, "s", 350, 10129, 10823);
            CallChecker.varInit(i, "i", 350, 10129, 10823);
            CallChecker.varInit(this.m_state, "m_state", 350, 10129, 10823);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 350, 10129, 10823);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 350, 10129, 10823);
            CallChecker.varInit(this.m_imports, "m_imports", 350, 10129, 10823);
            CallChecker.varInit(this.m_bytes, "m_bytes", 350, 10129, 10823);
            CallChecker.varInit(this.m_wiring, "m_wiring", 350, 10129, 10823);
            CallChecker.varInit(this.m_className, "m_className", 350, 10129, 10823);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 352, 10189, 10237);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 355, 10324, 10331)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 355, 10324, 10331).getBundle(), AdminPermission.WEAVE));
                }
            }
            TryContext _bcornu_try_context_356 = new TryContext(356, WovenClassImpl.class, "java.lang.Exception");
            try {
                List<BundleRequirement> reqs = CallChecker.varInit(ManifestParser.parseDynamicImportHeader(null, null, s), "reqs", 360, 10435, 10541);
            } catch (Exception ex) {
                _bcornu_try_context_356.catchStart(356);
                RuntimeException re = CallChecker.varInit(new IllegalArgumentException("Unable to parse dynamic import."), "re", 364, 10596, 10702);
                if (CallChecker.beforeDeref(re, RuntimeException.class, 366, 10716, 10717)) {
                    re = CallChecker.beforeCalled(re, RuntimeException.class, 366, 10716, 10717);
                    CallChecker.isCalled(re, RuntimeException.class, 366, 10716, 10717).initCause(ex);
                }
                throw re;
            } finally {
                _bcornu_try_context_356.finallyStart(356);
            }
            checkImport(s);
            if (CallChecker.beforeDeref(m_imports, List.class, 370, 10798, 10806)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 370, 10798, 10806);
                CallChecker.isCalled(m_imports, List.class, 370, 10798, 10806).add(i, s);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1286.methodEnd();
        }
    }

    public synchronized String remove(int i) {
        MethodContext _bcornu_methode_context1287 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 373, 10830, 11137);
            CallChecker.varInit(i, "i", 373, 10830, 11137);
            CallChecker.varInit(this.m_state, "m_state", 373, 10830, 11137);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 373, 10830, 11137);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 373, 10830, 11137);
            CallChecker.varInit(this.m_imports, "m_imports", 373, 10830, 11137);
            CallChecker.varInit(this.m_bytes, "m_bytes", 373, 10830, 11137);
            CallChecker.varInit(this.m_wiring, "m_wiring", 373, 10830, 11137);
            CallChecker.varInit(this.m_className, "m_className", 373, 10830, 11137);
            SecurityManager sm = CallChecker.varInit(System.getSecurityManager(), "sm", 375, 10885, 10933);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 378, 11020, 11027)) {
                    sm.checkPermission(new AdminPermission(CallChecker.isCalled(m_wiring, BundleWiring.class, 378, 11020, 11027).getBundle(), AdminPermission.WEAVE));
                }
            }
            if (CallChecker.beforeDeref(m_imports, List.class, 381, 11112, 11120)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 381, 11112, 11120);
                return CallChecker.isCalled(m_imports, List.class, 381, 11112, 11120).remove(i);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1287.methodEnd();
        }
    }

    public synchronized int indexOf(Object o) {
        MethodContext _bcornu_methode_context1288 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 384, 11144, 11233);
            CallChecker.varInit(o, "o", 384, 11144, 11233);
            CallChecker.varInit(this.m_state, "m_state", 384, 11144, 11233);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 384, 11144, 11233);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 384, 11144, 11233);
            CallChecker.varInit(this.m_imports, "m_imports", 384, 11144, 11233);
            CallChecker.varInit(this.m_bytes, "m_bytes", 384, 11144, 11233);
            CallChecker.varInit(this.m_wiring, "m_wiring", 384, 11144, 11233);
            CallChecker.varInit(this.m_className, "m_className", 384, 11144, 11233);
            if (CallChecker.beforeDeref(m_imports, List.class, 386, 11207, 11215)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 386, 11207, 11215);
                return CallChecker.isCalled(m_imports, List.class, 386, 11207, 11215).indexOf(o);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1288.methodEnd();
        }
    }

    public synchronized int lastIndexOf(Object o) {
        MethodContext _bcornu_methode_context1289 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 389, 11240, 11337);
            CallChecker.varInit(o, "o", 389, 11240, 11337);
            CallChecker.varInit(this.m_state, "m_state", 389, 11240, 11337);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 389, 11240, 11337);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 389, 11240, 11337);
            CallChecker.varInit(this.m_imports, "m_imports", 389, 11240, 11337);
            CallChecker.varInit(this.m_bytes, "m_bytes", 389, 11240, 11337);
            CallChecker.varInit(this.m_wiring, "m_wiring", 389, 11240, 11337);
            CallChecker.varInit(this.m_className, "m_className", 389, 11240, 11337);
            if (CallChecker.beforeDeref(m_imports, List.class, 391, 11307, 11315)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 391, 11307, 11315);
                return CallChecker.isCalled(m_imports, List.class, 391, 11307, 11315).lastIndexOf(o);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1289.methodEnd();
        }
    }

    public synchronized ListIterator<String> listIterator() {
        MethodContext _bcornu_methode_context1290 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 394, 11344, 11451);
            CallChecker.varInit(this.m_state, "m_state", 394, 11344, 11451);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 394, 11344, 11451);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 394, 11344, 11451);
            CallChecker.varInit(this.m_imports, "m_imports", 394, 11344, 11451);
            CallChecker.varInit(this.m_bytes, "m_bytes", 394, 11344, 11451);
            CallChecker.varInit(this.m_wiring, "m_wiring", 394, 11344, 11451);
            CallChecker.varInit(this.m_className, "m_className", 394, 11344, 11451);
            if (CallChecker.beforeDeref(m_imports, List.class, 396, 11421, 11429)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 396, 11421, 11429);
                return CallChecker.isCalled(m_imports, List.class, 396, 11421, 11429).listIterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1290.methodEnd();
        }
    }

    public synchronized ListIterator<String> listIterator(int i) {
        MethodContext _bcornu_methode_context1291 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 399, 11458, 11571);
            CallChecker.varInit(i, "i", 399, 11458, 11571);
            CallChecker.varInit(this.m_state, "m_state", 399, 11458, 11571);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 399, 11458, 11571);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 399, 11458, 11571);
            CallChecker.varInit(this.m_imports, "m_imports", 399, 11458, 11571);
            CallChecker.varInit(this.m_bytes, "m_bytes", 399, 11458, 11571);
            CallChecker.varInit(this.m_wiring, "m_wiring", 399, 11458, 11571);
            CallChecker.varInit(this.m_className, "m_className", 399, 11458, 11571);
            if (CallChecker.beforeDeref(m_imports, List.class, 401, 11540, 11548)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 401, 11540, 11548);
                return CallChecker.isCalled(m_imports, List.class, 401, 11540, 11548).listIterator(i);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1291.methodEnd();
        }
    }

    public synchronized List<String> subList(int i, int i1) {
        MethodContext _bcornu_methode_context1292 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 404, 11578, 11685);
            CallChecker.varInit(i1, "i1", 404, 11578, 11685);
            CallChecker.varInit(i, "i", 404, 11578, 11685);
            CallChecker.varInit(this.m_state, "m_state", 404, 11578, 11685);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 404, 11578, 11685);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 404, 11578, 11685);
            CallChecker.varInit(this.m_imports, "m_imports", 404, 11578, 11685);
            CallChecker.varInit(this.m_bytes, "m_bytes", 404, 11578, 11685);
            CallChecker.varInit(this.m_wiring, "m_wiring", 404, 11578, 11685);
            CallChecker.varInit(this.m_className, "m_className", 404, 11578, 11685);
            if (CallChecker.beforeDeref(m_imports, List.class, 406, 11655, 11663)) {
                m_imports = CallChecker.beforeCalled(m_imports, List.class, 406, 11655, 11663);
                return CallChecker.isCalled(m_imports, List.class, 406, 11655, 11663).subList(i, i1);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1292.methodEnd();
        }
    }

    byte[] _getBytes() {
        MethodContext _bcornu_methode_context1293 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 409, 11692, 11935);
            CallChecker.varInit(this.m_state, "m_state", 409, 11692, 11935);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 409, 11692, 11935);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 409, 11692, 11935);
            CallChecker.varInit(this.m_imports, "m_imports", 409, 11692, 11935);
            CallChecker.varInit(this.m_bytes, "m_bytes", 409, 11692, 11935);
            CallChecker.varInit(this.m_wiring, "m_wiring", 409, 11692, 11935);
            CallChecker.varInit(this.m_className, "m_className", 409, 11692, 11935);
            byte[] bytes = CallChecker.varInit(m_bytes, "bytes", 411, 11725, 11747);
            if (m_isComplete) {
                if (CallChecker.beforeDeref(m_bytes, byte[].class, 414, 11814, 11820)) {
                    m_bytes = CallChecker.beforeCalled(m_bytes, byte[].class, 414, 11814, 11820);
                    bytes = new byte[CallChecker.isCalled(m_bytes, byte[].class, 414, 11814, 11820).length];
                    CallChecker.varAssign(bytes, "bytes", 414, 11797, 11829);
                }
                if (CallChecker.beforeDeref(m_bytes, byte[].class, 415, 11882, 11888)) {
                    m_bytes = CallChecker.beforeCalled(m_bytes, byte[].class, 415, 11882, 11888);
                    System.arraycopy(m_bytes, 0, bytes, 0, CallChecker.isCalled(m_bytes, byte[].class, 415, 11882, 11888).length);
                }
            }
            return bytes;
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1293.methodEnd();
        }
    }

    public synchronized int getState() {
        MethodContext _bcornu_methode_context1294 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 425, 11942, 12121);
            CallChecker.varInit(this.m_state, "m_state", 425, 11942, 12121);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 425, 11942, 12121);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 425, 11942, 12121);
            CallChecker.varInit(this.m_imports, "m_imports", 425, 11942, 12121);
            CallChecker.varInit(this.m_bytes, "m_bytes", 425, 11942, 12121);
            CallChecker.varInit(this.m_wiring, "m_wiring", 425, 11942, 12121);
            CallChecker.varInit(this.m_className, "m_className", 425, 11942, 12121);
            return m_state;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1294.methodEnd();
        }
    }

    public synchronized void setState(int state) {
        MethodContext _bcornu_methode_context1295 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 430, 12128, 12945);
            CallChecker.varInit(state, "state", 430, 12128, 12945);
            CallChecker.varInit(this.m_state, "m_state", 430, 12128, 12945);
            CallChecker.varInit(this.m_isComplete, "m_isComplete", 430, 12128, 12945);
            CallChecker.varInit(this.m_definedClass, "m_definedClass", 430, 12128, 12945);
            CallChecker.varInit(this.m_imports, "m_imports", 430, 12128, 12945);
            CallChecker.varInit(this.m_bytes, "m_bytes", 430, 12128, 12945);
            CallChecker.varInit(this.m_wiring, "m_wiring", 430, 12128, 12945);
            CallChecker.varInit(this.m_className, "m_className", 430, 12128, 12945);
            if ((!(m_isComplete)) && (((state == (WovenClass.DEFINED)) || (state == (WovenClass.DEFINE_FAILED))) || (state == (WovenClass.TRANSFORMING_FAILED)))) {
                m_isComplete = true;
                CallChecker.varAssign(this.m_isComplete, "this.m_isComplete", 437, 12436, 12455);
                if ((state == (WovenClass.DEFINED)) || (state == (WovenClass.DEFINE_FAILED))) {
                    BundleProtectionDomain pd = CallChecker.init(BundleProtectionDomain.class);
                    if (CallChecker.beforeDeref(m_wiring, BundleWiring.class, 441, 12642, 12649)) {
                        final BundleRevisionImpl npe_invocation_var447 = ((BundleRevisionImpl) (CallChecker.isCalled(m_wiring, BundleWiring.class, 441, 12642, 12649).getRevision()));
                        if (CallChecker.beforeDeref(npe_invocation_var447, BundleRevisionImpl.class, 441, 12642, 12663)) {
                            pd = ((BundleProtectionDomain) (CallChecker.isCalled(npe_invocation_var447, BundleRevisionImpl.class, 441, 12642, 12663).getProtectionDomain()));
                            CallChecker.varAssign(pd, "pd", 441, 12642, 12649);
                        }
                    }
                    if (CallChecker.beforeDeref(m_imports, void.class, 442, 12721, 12729)) {
                        for (String s : m_imports) {
                            if (CallChecker.beforeDeref(pd, BundleProtectionDomain.class, 444, 12770, 12771)) {
                                pd = CallChecker.beforeCalled(pd, BundleProtectionDomain.class, 444, 12770, 12771);
                                CallChecker.isCalled(pd, BundleProtectionDomain.class, 444, 12770, 12771).addWoven(s);
                            }
                        }
                    }
                }
            }
            if (state == (WovenClass.TRANSFORMED)) {
                completeImports(null);
            }
            m_state = state;
            CallChecker.varAssign(this.m_state, "this.m_state", 452, 12924, 12939);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1295.methodEnd();
        }
    }
}

