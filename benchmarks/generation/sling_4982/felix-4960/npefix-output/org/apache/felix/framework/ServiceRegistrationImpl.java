package org.apache.felix.framework;

import org.apache.felix.framework.util.Util;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.util.StringMap;
import java.util.Set;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceException;
import org.apache.felix.framework.util.SecureAction;
import org.osgi.framework.PrototypeServiceFactory;
import java.security.PrivilegedExceptionAction;
import java.security.PrivilegedActionException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.felix.framework.util.MapToDictionary;
import java.util.Map;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.BundleReference;
import org.apache.felix.framework.wiring.BundleCapabilityImpl;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.Bundle;
import java.security.AccessController;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Collection;
import java.util.Collections;
import org.osgi.framework.Constants;
import java.util.Dictionary;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;

class ServiceRegistrationImpl implements ServiceRegistration {
    private final ServiceRegistry m_registry;

    private final Bundle m_bundle;

    private final String[] m_classes;

    private final Long m_serviceId;

    private volatile Object m_svcObj;

    private volatile ServiceFactory m_factory;

    private volatile Map<String, Object> m_propMap = new StringMap();

    private final ServiceRegistrationImpl.ServiceReferenceImpl m_ref;

    private volatile boolean m_isUnregistering = false;

    private final ThreadLocal<Boolean> m_threadLoopDetection = new ThreadLocal<Boolean>();

    private final Object syncObject = new Object();

    public ServiceRegistrationImpl(ServiceRegistry registry, Bundle bundle, String[] classes, Long serviceId, Object svcObj, Dictionary dict) {
        MethodContext _bcornu_methode_context25 = new MethodContext(null);
        try {
            m_registry = registry;
            CallChecker.varAssign(this.m_registry, "this.m_registry", 78, 3071, 3092);
            m_bundle = bundle;
            CallChecker.varAssign(this.m_bundle, "this.m_bundle", 79, 3102, 3119);
            m_classes = classes;
            CallChecker.varAssign(this.m_classes, "this.m_classes", 80, 3129, 3148);
            m_serviceId = serviceId;
            CallChecker.varAssign(this.m_serviceId, "this.m_serviceId", 81, 3158, 3181);
            m_svcObj = svcObj;
            CallChecker.varAssign(this.m_svcObj, "this.m_svcObj", 82, 3191, 3208);
            if ((m_svcObj) instanceof ServiceFactory) {
                m_factory = ((ServiceFactory) (m_svcObj));
                CallChecker.varAssign(this.m_factory, "this.m_factory", 83, 3218, 3313);
            }else {
                m_factory = null;
                CallChecker.varAssign(this.m_factory, "this.m_factory", 83, 3218, 3313);
            }
            initializeProperties(dict);
            m_ref = new ServiceRegistrationImpl.ServiceReferenceImpl();
            CallChecker.varAssign(this.m_ref, "this.m_ref", 90, 3490, 3524);
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    protected boolean isValid() {
        MethodContext _bcornu_methode_context371 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 93, 3537, 3610);
            CallChecker.varInit(this.syncObject, "syncObject", 93, 3537, 3610);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 93, 3537, 3610);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 93, 3537, 3610);
            CallChecker.varInit(this.m_ref, "m_ref", 93, 3537, 3610);
            CallChecker.varInit(this.m_propMap, "m_propMap", 93, 3537, 3610);
            CallChecker.varInit(this.m_factory, "m_factory", 93, 3537, 3610);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 93, 3537, 3610);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 93, 3537, 3610);
            CallChecker.varInit(this.m_classes, "m_classes", 93, 3537, 3610);
            CallChecker.varInit(this.m_bundle, "m_bundle", 93, 3537, 3610);
            CallChecker.varInit(this.m_registry, "m_registry", 93, 3537, 3610);
            return (m_svcObj) != null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context371.methodEnd();
        }
    }

    protected synchronized void invalidate() {
        MethodContext _bcornu_methode_context372 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 98, 3617, 3693);
            CallChecker.varInit(this.syncObject, "syncObject", 98, 3617, 3693);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 98, 3617, 3693);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 98, 3617, 3693);
            CallChecker.varInit(this.m_ref, "m_ref", 98, 3617, 3693);
            CallChecker.varInit(this.m_propMap, "m_propMap", 98, 3617, 3693);
            CallChecker.varInit(this.m_factory, "m_factory", 98, 3617, 3693);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 98, 3617, 3693);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 98, 3617, 3693);
            CallChecker.varInit(this.m_classes, "m_classes", 98, 3617, 3693);
            CallChecker.varInit(this.m_bundle, "m_bundle", 98, 3617, 3693);
            CallChecker.varInit(this.m_registry, "m_registry", 98, 3617, 3693);
            m_svcObj = null;
            CallChecker.varAssign(this.m_svcObj, "this.m_svcObj", 100, 3672, 3687);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context372.methodEnd();
        }
    }

    public synchronized ServiceReference getReference() {
        MethodContext _bcornu_methode_context373 = new MethodContext(ServiceReference.class);
        try {
            CallChecker.varInit(this, "this", 103, 3700, 3982);
            CallChecker.varInit(this.syncObject, "syncObject", 103, 3700, 3982);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 103, 3700, 3982);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 103, 3700, 3982);
            CallChecker.varInit(this.m_ref, "m_ref", 103, 3700, 3982);
            CallChecker.varInit(this.m_propMap, "m_propMap", 103, 3700, 3982);
            CallChecker.varInit(this.m_factory, "m_factory", 103, 3700, 3982);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 103, 3700, 3982);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 103, 3700, 3982);
            CallChecker.varInit(this.m_classes, "m_classes", 103, 3700, 3982);
            CallChecker.varInit(this.m_bundle, "m_bundle", 103, 3700, 3982);
            CallChecker.varInit(this.m_registry, "m_registry", 103, 3700, 3982);
            if (!(isValid())) {
                throw new IllegalStateException("The service registration is no longer valid.");
            }
            return m_ref;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context373.methodEnd();
        }
    }

    public void setProperties(Dictionary dict) {
        MethodContext _bcornu_methode_context374 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 114, 3989, 4601);
            CallChecker.varInit(dict, "dict", 114, 3989, 4601);
            CallChecker.varInit(this.syncObject, "syncObject", 114, 3989, 4601);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 114, 3989, 4601);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 114, 3989, 4601);
            CallChecker.varInit(this.m_ref, "m_ref", 114, 3989, 4601);
            CallChecker.varInit(this.m_propMap, "m_propMap", 114, 3989, 4601);
            CallChecker.varInit(this.m_factory, "m_factory", 114, 3989, 4601);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 114, 3989, 4601);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 114, 3989, 4601);
            CallChecker.varInit(this.m_classes, "m_classes", 114, 3989, 4601);
            CallChecker.varInit(this.m_bundle, "m_bundle", 114, 3989, 4601);
            CallChecker.varInit(this.m_registry, "m_registry", 114, 3989, 4601);
            Map oldProps = CallChecker.init(Map.class);
            synchronized(this) {
                if (!(isValid())) {
                    throw new IllegalStateException("The service registration is no longer valid.");
                }
                oldProps = m_propMap;
                CallChecker.varAssign(oldProps, "oldProps", 126, 4372, 4392);
                initializeProperties(dict);
            }
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 131, 4522, 4531)) {
                CallChecker.isCalled(m_registry, ServiceRegistry.class, 131, 4522, 4531).servicePropertiesModified(this, new MapToDictionary(oldProps));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context374.methodEnd();
        }
    }

    public void unregister() {
        MethodContext _bcornu_methode_context375 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 134, 4608, 5049);
            CallChecker.varInit(this.syncObject, "syncObject", 134, 4608, 5049);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 134, 4608, 5049);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 134, 4608, 5049);
            CallChecker.varInit(this.m_ref, "m_ref", 134, 4608, 5049);
            CallChecker.varInit(this.m_propMap, "m_propMap", 134, 4608, 5049);
            CallChecker.varInit(this.m_factory, "m_factory", 134, 4608, 5049);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 134, 4608, 5049);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 134, 4608, 5049);
            CallChecker.varInit(this.m_classes, "m_classes", 134, 4608, 5049);
            CallChecker.varInit(this.m_bundle, "m_bundle", 134, 4608, 5049);
            CallChecker.varInit(this.m_registry, "m_registry", 134, 4608, 5049);
            synchronized(this) {
                if ((!(isValid())) || (m_isUnregistering)) {
                    throw new IllegalStateException("Service already unregistered.");
                }
                m_isUnregistering = true;
                CallChecker.varAssign(this.m_isUnregistering, "this.m_isUnregistering", 142, 4848, 4872);
            }
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 144, 4892, 4901)) {
                CallChecker.isCalled(m_registry, ServiceRegistry.class, 144, 4892, 4901).unregisterService(m_bundle, this);
            }
            synchronized(this) {
                m_svcObj = null;
                CallChecker.varAssign(this.m_svcObj, "this.m_svcObj", 147, 4988, 5003);
                m_factory = null;
                CallChecker.varAssign(this.m_factory, "this.m_factory", 148, 5017, 5033);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context375.methodEnd();
        }
    }

    private boolean isClassAccessible(Class clazz) {
        MethodContext _bcornu_methode_context376 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 163, 5056, 7241);
            CallChecker.varInit(clazz, "clazz", 163, 5056, 7241);
            CallChecker.varInit(this.syncObject, "syncObject", 163, 5056, 7241);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 163, 5056, 7241);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 163, 5056, 7241);
            CallChecker.varInit(this.m_ref, "m_ref", 163, 5056, 7241);
            CallChecker.varInit(this.m_propMap, "m_propMap", 163, 5056, 7241);
            CallChecker.varInit(this.m_factory, "m_factory", 163, 5056, 7241);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 163, 5056, 7241);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 163, 5056, 7241);
            CallChecker.varInit(this.m_classes, "m_classes", 163, 5056, 7241);
            CallChecker.varInit(this.m_bundle, "m_bundle", 163, 5056, 7241);
            CallChecker.varInit(this.m_registry, "m_registry", 163, 5056, 7241);
            if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 181, 6384, 6403)) {
                if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 182, 6505, 6524)) {
                    m_factory = CallChecker.beforeCalled(m_factory, ServiceFactory.class, 182, 6541, 6549);
                    final BundleReference npe_invocation_var148 = ((BundleReference) (CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 182, 6505, 6524).getClassLoader(CallChecker.isCalled(m_factory, ServiceFactory.class, 182, 6541, 6549).getClass())));
                    if (CallChecker.beforeDeref(npe_invocation_var148, BundleReference.class, 182, 6505, 6561)) {
                        final Bundle npe_invocation_var149 = CallChecker.isCalled(npe_invocation_var148, BundleReference.class, 182, 6505, 6561).getBundle();
                        if (CallChecker.beforeDeref(npe_invocation_var149, Bundle.class, 182, 6486, 6574)) {
                            if ((((m_factory) != null) && ((CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 181, 6384, 6403).getClassLoader(m_factory.getClass())) instanceof BundleReference)) && (!(CallChecker.isCalled(npe_invocation_var149, Bundle.class, 182, 6486, 6574).equals(m_bundle)))) {
                                TryContext _bcornu_try_context_117 = new TryContext(117, ServiceRegistrationImpl.class, "java.lang.ClassNotFoundException");
                                try {
                                    Class providedClazz = CallChecker.init(Class.class);
                                    if (CallChecker.beforeDeref(clazz, Class.class, 186, 6691, 6695)) {
                                        if (CallChecker.beforeDeref(m_bundle, Bundle.class, 186, 6672, 6679)) {
                                            clazz = CallChecker.beforeCalled(clazz, Class.class, 186, 6691, 6695);
                                            providedClazz = CallChecker.isCalled(m_bundle, Bundle.class, 186, 6672, 6679).loadClass(CallChecker.isCalled(clazz, Class.class, 186, 6691, 6695).getName());
                                            CallChecker.varAssign(providedClazz, "providedClazz", 186, 6691, 6695);
                                        }
                                    }
                                    if (providedClazz != null) {
                                        return providedClazz == clazz;
                                    }
                                } catch (ClassNotFoundException ex) {
                                    _bcornu_try_context_117.catchStart(117);
                                } finally {
                                    _bcornu_try_context_117.finallyStart(117);
                                }
                                return true;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            Class sourceClass = CallChecker.init(Class.class);
            if ((m_factory) != null) {
                sourceClass = m_factory.getClass();
                CallChecker.varAssign(sourceClass, "sourceClass", 200, 7069, 7132);
            }else {
                if (CallChecker.beforeDeref(m_svcObj, Object.class, 200, 7114, 7121)) {
                    m_svcObj = CallChecker.beforeCalled(m_svcObj, Object.class, 200, 7114, 7121);
                    sourceClass = CallChecker.isCalled(m_svcObj, Object.class, 200, 7114, 7121).getClass();
                    CallChecker.varAssign(sourceClass, "sourceClass", 200, 7069, 7132);
                }
            }
            if (CallChecker.beforeDeref(clazz, Class.class, 201, 7188, 7192)) {
                clazz = CallChecker.beforeCalled(clazz, Class.class, 201, 7188, 7192);
                return (Util.loadClassUsingClass(sourceClass, CallChecker.isCalled(clazz, Class.class, 201, 7188, 7192).getName(), Felix.m_secureAction)) == clazz;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context376.methodEnd();
        }
    }

    Object getProperty(String key) {
        MethodContext _bcornu_methode_context377 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 204, 7248, 7324);
            CallChecker.varInit(key, "key", 204, 7248, 7324);
            CallChecker.varInit(this.syncObject, "syncObject", 204, 7248, 7324);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 204, 7248, 7324);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 204, 7248, 7324);
            CallChecker.varInit(this.m_ref, "m_ref", 204, 7248, 7324);
            CallChecker.varInit(this.m_propMap, "m_propMap", 204, 7248, 7324);
            CallChecker.varInit(this.m_factory, "m_factory", 204, 7248, 7324);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 204, 7248, 7324);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 204, 7248, 7324);
            CallChecker.varInit(this.m_classes, "m_classes", 204, 7248, 7324);
            CallChecker.varInit(this.m_bundle, "m_bundle", 204, 7248, 7324);
            CallChecker.varInit(this.m_registry, "m_registry", 204, 7248, 7324);
            if (CallChecker.beforeDeref(m_propMap, Map.class, 206, 7300, 7308)) {
                m_propMap = CallChecker.beforeCalled(m_propMap, Map.class, 206, 7300, 7308);
                return CallChecker.isCalled(m_propMap, Map.class, 206, 7300, 7308).get(key);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context377.methodEnd();
        }
    }

    private String[] getPropertyKeys() {
        MethodContext _bcornu_methode_context378 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 209, 7331, 7471);
            CallChecker.varInit(this.syncObject, "syncObject", 209, 7331, 7471);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 209, 7331, 7471);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 209, 7331, 7471);
            CallChecker.varInit(this.m_ref, "m_ref", 209, 7331, 7471);
            CallChecker.varInit(this.m_propMap, "m_propMap", 209, 7331, 7471);
            CallChecker.varInit(this.m_factory, "m_factory", 209, 7331, 7471);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 209, 7331, 7471);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 209, 7331, 7471);
            CallChecker.varInit(this.m_classes, "m_classes", 209, 7331, 7471);
            CallChecker.varInit(this.m_bundle, "m_bundle", 209, 7331, 7471);
            CallChecker.varInit(this.m_registry, "m_registry", 209, 7331, 7471);
            Set s = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(m_propMap, Map.class, 211, 7388, 7396)) {
                m_propMap = CallChecker.beforeCalled(m_propMap, Map.class, 211, 7388, 7396);
                s = CallChecker.isCalled(m_propMap, Map.class, 211, 7388, 7396).keySet();
                CallChecker.varAssign(s, "s", 211, 7388, 7396);
            }
            if (CallChecker.beforeDeref(s, Set.class, 212, 7455, 7455)) {
                if (CallChecker.beforeDeref(s, Set.class, 212, 7434, 7434)) {
                    s = CallChecker.beforeCalled(s, Set.class, 212, 7455, 7455);
                    s = CallChecker.beforeCalled(s, Set.class, 212, 7434, 7434);
                    return ((String[]) (CallChecker.isCalled(s, Set.class, 212, 7434, 7434).toArray(new String[CallChecker.isCalled(s, Set.class, 212, 7455, 7455).size()])));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context378.methodEnd();
        }
    }

    private Bundle[] getUsingBundles() {
        MethodContext _bcornu_methode_context379 = new MethodContext(Bundle[].class);
        try {
            CallChecker.varInit(this, "this", 215, 7478, 7573);
            CallChecker.varInit(this.syncObject, "syncObject", 215, 7478, 7573);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 215, 7478, 7573);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 215, 7478, 7573);
            CallChecker.varInit(this.m_ref, "m_ref", 215, 7478, 7573);
            CallChecker.varInit(this.m_propMap, "m_propMap", 215, 7478, 7573);
            CallChecker.varInit(this.m_factory, "m_factory", 215, 7478, 7573);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 215, 7478, 7573);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 215, 7478, 7573);
            CallChecker.varInit(this.m_classes, "m_classes", 215, 7478, 7573);
            CallChecker.varInit(this.m_bundle, "m_bundle", 215, 7478, 7573);
            CallChecker.varInit(this.m_registry, "m_registry", 215, 7478, 7573);
            if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 217, 7534, 7543)) {
                return CallChecker.isCalled(m_registry, ServiceRegistry.class, 217, 7534, 7543).getUsingBundles(m_ref);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context379.methodEnd();
        }
    }

    Object getService() {
        MethodContext _bcornu_methode_context380 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 226, 7580, 7891);
            CallChecker.varInit(this.syncObject, "syncObject", 226, 7580, 7891);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 226, 7580, 7891);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 226, 7580, 7891);
            CallChecker.varInit(this.m_ref, "m_ref", 226, 7580, 7891);
            CallChecker.varInit(this.m_propMap, "m_propMap", 226, 7580, 7891);
            CallChecker.varInit(this.m_factory, "m_factory", 226, 7580, 7891);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 226, 7580, 7891);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 226, 7580, 7891);
            CallChecker.varInit(this.m_classes, "m_classes", 226, 7580, 7891);
            CallChecker.varInit(this.m_bundle, "m_bundle", 226, 7580, 7891);
            CallChecker.varInit(this.m_registry, "m_registry", 226, 7580, 7891);
            return m_svcObj;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context380.methodEnd();
        }
    }

    Object getService(Bundle acqBundle) {
        MethodContext _bcornu_methode_context381 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 231, 7898, 9127);
            CallChecker.varInit(acqBundle, "acqBundle", 231, 7898, 9127);
            CallChecker.varInit(this.syncObject, "syncObject", 231, 7898, 9127);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 231, 7898, 9127);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 231, 7898, 9127);
            CallChecker.varInit(this.m_ref, "m_ref", 231, 7898, 9127);
            CallChecker.varInit(this.m_propMap, "m_propMap", 231, 7898, 9127);
            CallChecker.varInit(this.m_factory, "m_factory", 231, 7898, 9127);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 231, 7898, 9127);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 231, 7898, 9127);
            CallChecker.varInit(this.m_classes, "m_classes", 231, 7898, 9127);
            CallChecker.varInit(this.m_bundle, "m_bundle", 231, 7898, 9127);
            CallChecker.varInit(this.m_registry, "m_registry", 231, 7898, 9127);
            if ((m_factory) != null) {
                Object svcObj = CallChecker.varInit(null, "svcObj", 237, 8098, 8118);
                TryContext _bcornu_try_context_118 = new TryContext(118, ServiceRegistrationImpl.class, "java.security.PrivilegedActionException");
                try {
                    if ((System.getSecurityManager()) != null) {
                        svcObj = AccessController.doPrivileged(new ServiceRegistrationImpl.ServiceFactoryPrivileged(acqBundle, null));
                        CallChecker.varAssign(svcObj, "svcObj", 242, 8245, 8355);
                    }else {
                        svcObj = getFactoryUnchecked(acqBundle);
                        CallChecker.varAssign(svcObj, "svcObj", 247, 8434, 8473);
                    }
                } catch (PrivilegedActionException ex) {
                    _bcornu_try_context_118.catchStart(118);
                    if ((ex.getException()) instanceof ServiceException) {
                        throw ((ServiceException) (ex.getException()));
                    }else {
                        if (CallChecker.beforeDeref(ex.getException(), Exception.class, 259, 8880, 8896)) {
                            throw new ServiceException(("Service factory exception: " + (CallChecker.isCalled(ex.getException(), Exception.class, 259, 8880, 8896).getMessage())), ServiceException.FACTORY_EXCEPTION, ex.getException());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                } finally {
                    _bcornu_try_context_118.finallyStart(118);
                }
                return svcObj;
            }else {
                return m_svcObj;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context381.methodEnd();
        }
    }

    void ungetService(Bundle relBundle, Object svcObj) {
        MethodContext _bcornu_methode_context382 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 271, 9134, 10004);
            CallChecker.varInit(svcObj, "svcObj", 271, 9134, 10004);
            CallChecker.varInit(relBundle, "relBundle", 271, 9134, 10004);
            CallChecker.varInit(this.syncObject, "syncObject", 271, 9134, 10004);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 271, 9134, 10004);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 271, 9134, 10004);
            CallChecker.varInit(this.m_ref, "m_ref", 271, 9134, 10004);
            CallChecker.varInit(this.m_propMap, "m_propMap", 271, 9134, 10004);
            CallChecker.varInit(this.m_factory, "m_factory", 271, 9134, 10004);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 271, 9134, 10004);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 271, 9134, 10004);
            CallChecker.varInit(this.m_classes, "m_classes", 271, 9134, 10004);
            CallChecker.varInit(this.m_bundle, "m_bundle", 271, 9134, 10004);
            CallChecker.varInit(this.m_registry, "m_registry", 271, 9134, 10004);
            if ((m_factory) != null) {
                TryContext _bcornu_try_context_119 = new TryContext(119, ServiceRegistrationImpl.class, "java.lang.Exception");
                try {
                    if ((System.getSecurityManager()) != null) {
                        AccessController.doPrivileged(new ServiceRegistrationImpl.ServiceFactoryPrivileged(relBundle, svcObj));
                    }else {
                        ungetFactoryUnchecked(relBundle, svcObj);
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_119.catchStart(119);
                    if (CallChecker.beforeDeref(m_registry, ServiceRegistry.class, 291, 9782, 9791)) {
                        final Logger npe_invocation_var150 = CallChecker.isCalled(m_registry, ServiceRegistry.class, 291, 9782, 9791).getLogger();
                        if (CallChecker.beforeDeref(npe_invocation_var150, Logger.class, 291, 9782, 9803)) {
                            CallChecker.isCalled(npe_invocation_var150, Logger.class, 291, 9782, 9803).log(m_bundle, Logger.LOG_ERROR, "ServiceRegistrationImpl: Error ungetting service.", ex);
                        }
                    }
                } finally {
                    _bcornu_try_context_119.finallyStart(119);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context382.methodEnd();
        }
    }

    private void initializeProperties(Dictionary<String, Object> dict) {
        MethodContext _bcornu_methode_context383 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 300, 10011, 11413);
            CallChecker.varInit(dict, "dict", 300, 10011, 11413);
            CallChecker.varInit(this.syncObject, "syncObject", 300, 10011, 11413);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 300, 10011, 11413);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 300, 10011, 11413);
            CallChecker.varInit(this.m_ref, "m_ref", 300, 10011, 11413);
            CallChecker.varInit(this.m_propMap, "m_propMap", 300, 10011, 11413);
            CallChecker.varInit(this.m_factory, "m_factory", 300, 10011, 11413);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 300, 10011, 11413);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 300, 10011, 11413);
            CallChecker.varInit(this.m_classes, "m_classes", 300, 10011, 11413);
            CallChecker.varInit(this.m_bundle, "m_bundle", 300, 10011, 11413);
            CallChecker.varInit(this.m_registry, "m_registry", 300, 10011, 11413);
            Map<String, Object> props = CallChecker.varInit(new StringMap(), "props", 303, 10153, 10196);
            if (dict != null) {
                Enumeration<String> keys = CallChecker.varInit(dict.keys(), "keys", 308, 10301, 10339);
                keys = CallChecker.beforeCalled(keys, Enumeration.class, 309, 10360, 10363);
                while (CallChecker.isCalled(keys, Enumeration.class, 309, 10360, 10363).hasMoreElements()) {
                    String key = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(keys, Enumeration.class, 311, 10427, 10430)) {
                        keys = CallChecker.beforeCalled(keys, Enumeration.class, 311, 10427, 10430);
                        key = CallChecker.isCalled(keys, Enumeration.class, 311, 10427, 10430).nextElement();
                        CallChecker.varAssign(key, "key", 311, 10427, 10430);
                    }
                    if (CallChecker.beforeDeref(props, Map.class, 312, 10467, 10471)) {
                        props = CallChecker.beforeCalled(props, Map.class, 312, 10467, 10471);
                        if ((CallChecker.isCalled(props, Map.class, 312, 10467, 10471).get(key)) == null) {
                            if (CallChecker.beforeDeref(props, Map.class, 314, 10529, 10533)) {
                                props = CallChecker.beforeCalled(props, Map.class, 314, 10529, 10533);
                                CallChecker.isCalled(props, Map.class, 314, 10529, 10533).put(key, dict.get(key));
                            }
                        }else {
                            throw new IllegalArgumentException(("Duplicate service property: " + key));
                        }
                    }
                } 
            }
            if (CallChecker.beforeDeref(props, Map.class, 324, 10812, 10816)) {
                props = CallChecker.beforeCalled(props, Map.class, 324, 10812, 10816);
                CallChecker.isCalled(props, Map.class, 324, 10812, 10816).put(Constants.OBJECTCLASS, m_classes);
            }
            if (CallChecker.beforeDeref(props, Map.class, 325, 10865, 10869)) {
                props = CallChecker.beforeCalled(props, Map.class, 325, 10865, 10869);
                CallChecker.isCalled(props, Map.class, 325, 10865, 10869).put(Constants.SERVICE_ID, m_serviceId);
            }
            if (CallChecker.beforeDeref(m_bundle, Bundle.class, 326, 10957, 10964)) {
                if (CallChecker.beforeDeref(props, Map.class, 326, 10919, 10923)) {
                    props = CallChecker.beforeCalled(props, Map.class, 326, 10919, 10923);
                    CallChecker.isCalled(props, Map.class, 326, 10919, 10923).put(Constants.SERVICE_BUNDLEID, CallChecker.isCalled(m_bundle, Bundle.class, 326, 10957, 10964).getBundleId());
                }
            }
            if ((m_factory) != null) {
                if ((m_factory) instanceof PrototypeServiceFactory) {
                    if (CallChecker.beforeDeref(props, Map.class, 329, 11037, 11041)) {
                        props = CallChecker.beforeCalled(props, Map.class, 329, 11037, 11041);
                        CallChecker.isCalled(props, Map.class, 329, 11037, 11041).put(Constants.SERVICE_SCOPE, Constants.SCOPE_PROTOTYPE);
                    }
                }else {
                    if (CallChecker.beforeDeref(props, Map.class, 329, 11037, 11041)) {
                        props = CallChecker.beforeCalled(props, Map.class, 329, 11037, 11041);
                        CallChecker.isCalled(props, Map.class, 329, 11037, 11041).put(Constants.SERVICE_SCOPE, Constants.SCOPE_BUNDLE);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(props, Map.class, 335, 11264, 11268)) {
                    props = CallChecker.beforeCalled(props, Map.class, 335, 11264, 11268);
                    CallChecker.isCalled(props, Map.class, 335, 11264, 11268).put(Constants.SERVICE_SCOPE, Constants.SCOPE_SINGLETON);
                }
            }
            m_propMap = props;
            CallChecker.varAssign(this.m_propMap, "this.m_propMap", 339, 11390, 11407);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context383.methodEnd();
        }
    }

    private Object getFactoryUnchecked(Bundle bundle) {
        MethodContext _bcornu_methode_context384 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 342, 11420, 12912);
            CallChecker.varInit(bundle, "bundle", 342, 11420, 12912);
            CallChecker.varInit(this.syncObject, "syncObject", 342, 11420, 12912);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 342, 11420, 12912);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 342, 11420, 12912);
            CallChecker.varInit(this.m_ref, "m_ref", 342, 11420, 12912);
            CallChecker.varInit(this.m_propMap, "m_propMap", 342, 11420, 12912);
            CallChecker.varInit(this.m_factory, "m_factory", 342, 11420, 12912);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 342, 11420, 12912);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 342, 11420, 12912);
            CallChecker.varInit(this.m_classes, "m_classes", 342, 11420, 12912);
            CallChecker.varInit(this.m_bundle, "m_bundle", 342, 11420, 12912);
            CallChecker.varInit(this.m_registry, "m_registry", 342, 11420, 12912);
            Object svcObj = CallChecker.varInit(null, "svcObj", 344, 11484, 11504);
            TryContext _bcornu_try_context_120 = new TryContext(120, ServiceRegistrationImpl.class, "java.lang.Throwable");
            try {
                if (CallChecker.beforeDeref(m_factory, ServiceFactory.class, 347, 11549, 11557)) {
                    m_factory = CallChecker.beforeCalled(m_factory, ServiceFactory.class, 347, 11549, 11557);
                    svcObj = CallChecker.isCalled(m_factory, ServiceFactory.class, 347, 11549, 11557).getService(bundle, this);
                    CallChecker.varAssign(svcObj, "svcObj", 347, 11540, 11583);
                }
            } catch (Throwable th) {
                _bcornu_try_context_120.catchStart(120);
                throw new ServiceException(("Service factory exception: " + (th.getMessage())), ServiceException.FACTORY_EXCEPTION, th);
            } finally {
                _bcornu_try_context_120.finallyStart(120);
            }
            if (svcObj != null) {
                for (int i = 0; i < (CallChecker.isCalled(m_classes, String[].class, 357, 11876, 11884).length); i++) {
                    Class clazz = CallChecker.init(Class.class);
                    if (CallChecker.beforeDeref(m_classes, String[].class, 360, 12008, 12016)) {
                        clazz = Util.loadClassUsingClass(svcObj.getClass(), CallChecker.isCalled(m_classes, String[].class, 360, 12008, 12016)[i], Felix.m_secureAction);
                        CallChecker.varAssign(clazz, "clazz", 360, 12008, 12016);
                    }
                    if ((clazz == null) || (!(clazz.isAssignableFrom(svcObj.getClass())))) {
                        if (clazz == null) {
                            if (CallChecker.beforeDeref(m_classes, String[].class, 366, 12337, 12345)) {
                                throw new ServiceException(("Service cannot be cast due to missing class: " + (CallChecker.isCalled(m_classes, String[].class, 366, 12337, 12345)[i])), ServiceException.FACTORY_ERROR);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else {
                            if (CallChecker.beforeDeref(m_classes, String[].class, 372, 12590, 12598)) {
                                throw new ServiceException(("Service cannot be cast: " + (CallChecker.isCalled(m_classes, String[].class, 372, 12590, 12598)[i])), ServiceException.FACTORY_ERROR);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }
            }else {
                throw new ServiceException("Service factory returned null.", ServiceException.FACTORY_ERROR);
            }
            return svcObj;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context384.methodEnd();
        }
    }

    private void ungetFactoryUnchecked(Bundle bundle, Object svcObj) {
        MethodContext _bcornu_methode_context385 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 386, 12919, 13048);
            CallChecker.varInit(svcObj, "svcObj", 386, 12919, 13048);
            CallChecker.varInit(bundle, "bundle", 386, 12919, 13048);
            CallChecker.varInit(this.syncObject, "syncObject", 386, 12919, 13048);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 386, 12919, 13048);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 386, 12919, 13048);
            CallChecker.varInit(this.m_ref, "m_ref", 386, 12919, 13048);
            CallChecker.varInit(this.m_propMap, "m_propMap", 386, 12919, 13048);
            CallChecker.varInit(this.m_factory, "m_factory", 386, 12919, 13048);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 386, 12919, 13048);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 386, 12919, 13048);
            CallChecker.varInit(this.m_classes, "m_classes", 386, 12919, 13048);
            CallChecker.varInit(this.m_bundle, "m_bundle", 386, 12919, 13048);
            CallChecker.varInit(this.m_registry, "m_registry", 386, 12919, 13048);
            if (CallChecker.beforeDeref(m_factory, ServiceFactory.class, 388, 12998, 13006)) {
                m_factory = CallChecker.beforeCalled(m_factory, ServiceFactory.class, 388, 12998, 13006);
                CallChecker.isCalled(m_factory, ServiceFactory.class, 388, 12998, 13006).ungetService(bundle, this, svcObj);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context385.methodEnd();
        }
    }

    private class ServiceFactoryPrivileged implements PrivilegedExceptionAction {
        private Bundle m_bundle = null;

        private Object m_svcObj = null;

        public ServiceFactoryPrivileged(Bundle bundle, Object svcObj) {
            MethodContext _bcornu_methode_context26 = new MethodContext(null);
            try {
                m_bundle = bundle;
                CallChecker.varAssign(this.m_bundle, "this.m_bundle", 403, 13517, 13534);
                m_svcObj = svcObj;
                CallChecker.varAssign(this.m_svcObj, "this.m_svcObj", 404, 13548, 13565);
            } finally {
                _bcornu_methode_context26.methodEnd();
            }
        }

        public Object run() throws Exception {
            MethodContext _bcornu_methode_context386 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 407, 13586, 13886);
                CallChecker.varInit(this.m_svcObj, "m_svcObj", 407, 13586, 13886);
                CallChecker.varInit(this.m_bundle, "m_bundle", 407, 13586, 13886);
                if ((m_svcObj) == null) {
                    return getFactoryUnchecked(m_bundle);
                }else {
                    ungetFactoryUnchecked(m_bundle, m_svcObj);
                }
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context386.methodEnd();
            }
        }
    }

    class ServiceReferenceImpl extends BundleCapabilityImpl implements ServiceReference {
        private final ServiceRegistrationImpl.ServiceReferenceMap m_map;

        private ServiceReferenceImpl() {
            super(null, null, Collections.EMPTY_MAP, Collections.EMPTY_MAP);
            MethodContext _bcornu_methode_context27 = new MethodContext(null);
            try {
                m_map = new ServiceRegistrationImpl.ServiceReferenceMap();
                CallChecker.varAssign(this.m_map, "this.m_map", 432, 14231, 14264);
            } finally {
                _bcornu_methode_context27.methodEnd();
            }
        }

        ServiceRegistrationImpl getRegistration() {
            MethodContext _bcornu_methode_context387 = new MethodContext(ServiceRegistrationImpl.class);
            try {
                CallChecker.varInit(this, "this", 435, 14285, 14394);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 435, 14285, 14394);
                CallChecker.varInit(this.m_map, "m_map", 435, 14285, 14394);
                return ServiceRegistrationImpl.this;
            } catch (ForceReturn _bcornu_return_t) {
                return ((ServiceRegistrationImpl) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context387.methodEnd();
            }
        }

        @Override
        public BundleRevision getRevision() {
            MethodContext _bcornu_methode_context388 = new MethodContext(BundleRevision.class);
            try {
                CallChecker.varInit(this, "this", 445, 14405, 14606);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 445, 14405, 14606);
                CallChecker.varInit(this.m_map, "m_map", 445, 14405, 14606);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context388.methodEnd();
            }
        }

        @Override
        public String getNamespace() {
            MethodContext _bcornu_methode_context389 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 451, 14617, 14722);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 451, 14617, 14722);
                CallChecker.varInit(this.m_map, "m_map", 451, 14617, 14722);
                return "service-reference";
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context389.methodEnd();
            }
        }

        @Override
        public Map<String, String> getDirectives() {
            MethodContext _bcornu_methode_context390 = new MethodContext(Map.class);
            try {
                CallChecker.varInit(this, "this", 457, 14733, 14854);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 457, 14733, 14854);
                CallChecker.varInit(this.m_map, "m_map", 457, 14733, 14854);
                return Collections.EMPTY_MAP;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map<String, String>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context390.methodEnd();
            }
        }

        @Override
        public Map<String, Object> getAttributes() {
            MethodContext _bcornu_methode_context391 = new MethodContext(Map.class);
            try {
                CallChecker.varInit(this, "this", 463, 14865, 14970);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 463, 14865, 14970);
                CallChecker.varInit(this.m_map, "m_map", 463, 14865, 14970);
                return m_map;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Map<String, Object>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context391.methodEnd();
            }
        }

        @Override
        public List<String> getUses() {
            MethodContext _bcornu_methode_context392 = new MethodContext(List.class);
            try {
                CallChecker.varInit(this, "this", 469, 14981, 15090);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 469, 14981, 15090);
                CallChecker.varInit(this.m_map, "m_map", 469, 14981, 15090);
                return Collections.EMPTY_LIST;
            } catch (ForceReturn _bcornu_return_t) {
                return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context392.methodEnd();
            }
        }

        public Object getProperty(String s) {
            MethodContext _bcornu_methode_context393 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 478, 15101, 15279);
                CallChecker.varInit(s, "s", 478, 15101, 15279);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 478, 15101, 15279);
                CallChecker.varInit(this.m_map, "m_map", 478, 15101, 15279);
                return ServiceRegistrationImpl.this.getProperty(s);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context393.methodEnd();
            }
        }

        public String[] getPropertyKeys() {
            MethodContext _bcornu_methode_context394 = new MethodContext(String[].class);
            try {
                CallChecker.varInit(this, "this", 483, 15290, 15409);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 483, 15290, 15409);
                CallChecker.varInit(this.m_map, "m_map", 483, 15290, 15409);
                return ServiceRegistrationImpl.this.getPropertyKeys();
            } catch (ForceReturn _bcornu_return_t) {
                return ((String[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context394.methodEnd();
            }
        }

        public Bundle getBundle() {
            MethodContext _bcornu_methode_context395 = new MethodContext(Bundle.class);
            try {
                CallChecker.varInit(this, "this", 488, 15420, 15619);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 488, 15420, 15619);
                CallChecker.varInit(this.m_map, "m_map", 488, 15420, 15619);
                if (isValid()) {
                    return m_bundle;
                }else {
                    return null;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context395.methodEnd();
            }
        }

        public Bundle[] getUsingBundles() {
            MethodContext _bcornu_methode_context396 = new MethodContext(Bundle[].class);
            try {
                CallChecker.varInit(this, "this", 495, 15630, 15749);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 495, 15630, 15749);
                CallChecker.varInit(this.m_map, "m_map", 495, 15630, 15749);
                return ServiceRegistrationImpl.this.getUsingBundles();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context396.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context397 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 501, 15760, 16152);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 501, 15760, 16152);
                CallChecker.varInit(this.m_map, "m_map", 501, 15760, 16152);
                String[] ocs = CallChecker.varInit(((String[]) (getProperty("objectClass"))), "ocs", 503, 15825, 15877);
                String oc = CallChecker.varInit("[", "oc", 504, 15891, 15906);
                ocs = CallChecker.beforeCalled(ocs, String[].class, 505, 15939, 15941);
                for (int i = 0; i < (CallChecker.isCalled(ocs, String[].class, 505, 15939, 15941).length); i++) {
                    if (CallChecker.beforeDeref(ocs, String[].class, 507, 15996, 15998)) {
                        ocs = CallChecker.beforeCalled(ocs, String[].class, 507, 15996, 15998);
                        oc = oc + (CallChecker.isCalled(ocs, String[].class, 507, 15996, 15998)[i]);
                        CallChecker.varAssign(oc, "oc", 507, 15986, 16002);
                    }
                    if (CallChecker.beforeDeref(ocs, String[].class, 508, 16028, 16030)) {
                        ocs = CallChecker.beforeCalled(ocs, String[].class, 508, 16028, 16030);
                        if (i < ((CallChecker.isCalled(ocs, String[].class, 508, 16028, 16030).length) - 1)) {
                            oc = oc + ", ";
                            CallChecker.varAssign(oc, "oc", 509, 16064, 16078);
                        }
                    }
                }
                oc = oc + "]";
                CallChecker.varAssign(oc, "oc", 511, 16106, 16119);
                return oc;
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context397.methodEnd();
            }
        }

        public boolean isAssignableTo(Bundle requester, String className) {
            MethodContext _bcornu_methode_context398 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 515, 16163, 23222);
                CallChecker.varInit(className, "className", 515, 16163, 23222);
                CallChecker.varInit(requester, "requester", 515, 16163, 23222);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 515, 16163, 23222);
                CallChecker.varInit(this.m_map, "m_map", 515, 16163, 23222);
                if (requester == (m_bundle)) {
                    return true;
                }
                boolean allow = CallChecker.varInit(((boolean) (true)), "allow", 524, 16457, 16477);
                String pkgName = CallChecker.varInit(Util.getClassPackage(className), "pkgName", 526, 16523, 16587);
                BundleRevision requesterRevision = CallChecker.init(BundleRevision.class);
                if (CallChecker.beforeDeref(requester, Bundle.class, 529, 16694, 16702)) {
                    requester = CallChecker.beforeCalled(requester, Bundle.class, 529, 16694, 16702);
                    requesterRevision = CallChecker.isCalled(requester, Bundle.class, 529, 16694, 16702).adapt(BundleRevision.class);
                    CallChecker.varAssign(requesterRevision, "requesterRevision", 529, 16694, 16702);
                }
                BundleWire requesterWire = CallChecker.varInit(Util.getWire(requesterRevision, pkgName), "requesterWire", 530, 16745, 16812);
                BundleCapability requesterCap = CallChecker.varInit(Util.getPackageCapability(requesterRevision, pkgName), "requesterCap", 531, 16826, 16911);
                BundleRevision providerRevision = CallChecker.init(BundleRevision.class);
                if (CallChecker.beforeDeref(m_bundle, Bundle.class, 533, 17016, 17023)) {
                    providerRevision = CallChecker.isCalled(m_bundle, Bundle.class, 533, 17016, 17023).adapt(BundleRevision.class);
                    CallChecker.varAssign(providerRevision, "providerRevision", 533, 17016, 17023);
                }
                BundleWire providerWire = CallChecker.varInit(Util.getWire(providerRevision, pkgName), "providerWire", 534, 17066, 17131);
                BundleCapability providerCap = CallChecker.varInit(Util.getPackageCapability(providerRevision, pkgName), "providerCap", 535, 17145, 17228);
                if ((requesterWire == null) && (providerWire == null)) {
                    TryContext _bcornu_try_context_121 = new TryContext(121, ServiceRegistrationImpl.class, "java.lang.Exception");
                    try {
                        Class requestClass = CallChecker.init(Class.class);
                        if (CallChecker.beforeDeref(requesterRevision, BundleRevision.class, 564, 19052, 19068)) {
                            requesterRevision = CallChecker.beforeCalled(requesterRevision, BundleRevision.class, 564, 19052, 19068);
                            final BundleWiringImpl npe_invocation_var151 = ((BundleWiringImpl) (CallChecker.isCalled(requesterRevision, BundleRevision.class, 564, 19052, 19068).getWiring()));
                            if (CallChecker.beforeDeref(npe_invocation_var151, BundleWiringImpl.class, 564, 19052, 19080)) {
                                requestClass = CallChecker.isCalled(npe_invocation_var151, BundleWiringImpl.class, 564, 19052, 19080).getClassByDelegation(className);
                                CallChecker.varAssign(requestClass, "requestClass", 564, 19052, 19068);
                            }
                        }
                        final ServiceRegistrationImpl npe_invocation_var152 = getRegistration();
                        if (CallChecker.beforeDeref(npe_invocation_var152, ServiceRegistrationImpl.class, 566, 19173, 19189)) {
                            allow = CallChecker.isCalled(npe_invocation_var152, ServiceRegistrationImpl.class, 566, 19173, 19189).isClassAccessible(requestClass);
                            CallChecker.varAssign(allow, "allow", 566, 19165, 19222);
                        }
                    } catch (Exception ex) {
                        _bcornu_try_context_121.catchStart(121);
                        allow = true;
                        CallChecker.varAssign(allow, "allow", 572, 19465, 19477);
                    } finally {
                        _bcornu_try_context_121.finallyStart(121);
                    }
                }else
                    if ((requesterWire == null) && (providerWire != null)) {
                        if (requesterCap != null) {
                            providerWire = CallChecker.beforeCalled(providerWire, BundleWire.class, 582, 19865, 19876);
                            final org.osgi.framework.wiring.BundleWiring npe_invocation_var153 = CallChecker.isCalled(providerWire, BundleWire.class, 582, 19865, 19876).getProviderWiring();
                            if (CallChecker.beforeDeref(npe_invocation_var153, org.osgi.framework.wiring.BundleWiring.class, 582, 19865, 19896)) {
                                final BundleRevision npe_invocation_var154 = CallChecker.isCalled(npe_invocation_var153, org.osgi.framework.wiring.BundleWiring.class, 582, 19865, 19896).getRevision();
                                if (CallChecker.beforeDeref(npe_invocation_var154, BundleRevision.class, 582, 19865, 19910)) {
                                    allow = CallChecker.isCalled(npe_invocation_var154, BundleRevision.class, 582, 19865, 19910).equals(requesterRevision);
                                    CallChecker.varAssign(allow, "allow", 582, 19857, 19937);
                                }
                            }
                        }else {
                            TryContext _bcornu_try_context_123 = new TryContext(123, ServiceRegistrationImpl.class, "java.lang.Exception");
                            try {
                                Class requestClass = CallChecker.init(Class.class);
                                if (CallChecker.beforeDeref(requesterRevision, BundleRevision.class, 592, 20344, 20360)) {
                                    requesterRevision = CallChecker.beforeCalled(requesterRevision, BundleRevision.class, 592, 20344, 20360);
                                    final BundleWiringImpl npe_invocation_var155 = ((BundleWiringImpl) (CallChecker.isCalled(requesterRevision, BundleRevision.class, 592, 20344, 20360).getWiring()));
                                    if (CallChecker.beforeDeref(npe_invocation_var155, BundleWiringImpl.class, 592, 20344, 20372)) {
                                        requestClass = CallChecker.isCalled(npe_invocation_var155, BundleWiringImpl.class, 592, 20344, 20372).getClassByDelegation(className);
                                        CallChecker.varAssign(requestClass, "requestClass", 592, 20344, 20360);
                                    }
                                }
                                TryContext _bcornu_try_context_122 = new TryContext(122, ServiceRegistrationImpl.class, "java.lang.Exception");
                                try {
                                    if (CallChecker.beforeDeref(providerRevision, BundleRevision.class, 598, 20696, 20711)) {
                                        providerRevision = CallChecker.beforeCalled(providerRevision, BundleRevision.class, 598, 20696, 20711);
                                        final BundleWiringImpl npe_invocation_var156 = ((BundleWiringImpl) (CallChecker.isCalled(providerRevision, BundleRevision.class, 598, 20696, 20711).getWiring()));
                                        if (CallChecker.beforeDeref(npe_invocation_var156, BundleWiringImpl.class, 598, 20696, 20723)) {
                                            allow = (CallChecker.isCalled(npe_invocation_var156, BundleWiringImpl.class, 598, 20696, 20723).getClassByDelegation(className)) == requestClass;
                                            CallChecker.varAssign(allow, "allow", 597, 20635, 20811);
                                        }
                                    }
                                } catch (Exception ex) {
                                    _bcornu_try_context_122.catchStart(122);
                                    allow = false;
                                    CallChecker.varAssign(allow, "allow", 603, 20938, 20951);
                                } finally {
                                    _bcornu_try_context_122.finallyStart(122);
                                }
                            } catch (Exception ex) {
                                _bcornu_try_context_123.catchStart(123);
                                allow = true;
                                CallChecker.varAssign(allow, "allow", 610, 21244, 21256);
                            } finally {
                                _bcornu_try_context_123.finallyStart(123);
                            }
                        }
                    }else
                        if ((requesterWire != null) && (providerWire == null)) {
                            if (providerCap != null) {
                                requesterWire = CallChecker.beforeCalled(requesterWire, BundleWire.class, 621, 21668, 21680);
                                final org.osgi.framework.wiring.BundleWiring npe_invocation_var157 = CallChecker.isCalled(requesterWire, BundleWire.class, 621, 21668, 21680).getProviderWiring();
                                if (CallChecker.beforeDeref(npe_invocation_var157, org.osgi.framework.wiring.BundleWiring.class, 621, 21668, 21700)) {
                                    final BundleRevision npe_invocation_var158 = CallChecker.isCalled(npe_invocation_var157, org.osgi.framework.wiring.BundleWiring.class, 621, 21668, 21700).getRevision();
                                    if (CallChecker.beforeDeref(npe_invocation_var158, BundleRevision.class, 621, 21668, 21714)) {
                                        allow = CallChecker.isCalled(npe_invocation_var158, BundleRevision.class, 621, 21668, 21714).equals(providerRevision);
                                        CallChecker.varAssign(allow, "allow", 621, 21660, 21740);
                                    }
                                }
                            }else {
                                TryContext _bcornu_try_context_124 = new TryContext(124, ServiceRegistrationImpl.class, "java.lang.Exception");
                                try {
                                    Class requestClass = CallChecker.init(Class.class);
                                    if (CallChecker.beforeDeref(requesterRevision, BundleRevision.class, 632, 22217, 22233)) {
                                        requesterRevision = CallChecker.beforeCalled(requesterRevision, BundleRevision.class, 632, 22217, 22233);
                                        final BundleWiringImpl npe_invocation_var159 = ((BundleWiringImpl) (CallChecker.isCalled(requesterRevision, BundleRevision.class, 632, 22217, 22233).getWiring()));
                                        if (CallChecker.beforeDeref(npe_invocation_var159, BundleWiringImpl.class, 632, 22217, 22245)) {
                                            requestClass = CallChecker.isCalled(npe_invocation_var159, BundleWiringImpl.class, 632, 22217, 22245).getClassByDelegation(className);
                                            CallChecker.varAssign(requestClass, "requestClass", 632, 22217, 22233);
                                        }
                                    }
                                    final ServiceRegistrationImpl npe_invocation_var160 = getRegistration();
                                    if (CallChecker.beforeDeref(npe_invocation_var160, ServiceRegistrationImpl.class, 637, 22546, 22562)) {
                                        allow = CallChecker.isCalled(npe_invocation_var160, ServiceRegistrationImpl.class, 637, 22546, 22562).isClassAccessible(requestClass);
                                        CallChecker.varAssign(allow, "allow", 637, 22538, 22595);
                                    }
                                } catch (Exception ex) {
                                    _bcornu_try_context_124.catchStart(124);
                                    allow = false;
                                    CallChecker.varAssign(allow, "allow", 642, 22752, 22765);
                                } finally {
                                    _bcornu_try_context_124.finallyStart(124);
                                }
                            }
                        }else {
                            providerWire = CallChecker.beforeCalled(providerWire, BundleWire.class, 651, 23048, 23059);
                            final org.osgi.framework.wiring.BundleWiring npe_invocation_var161 = CallChecker.isCalled(providerWire, BundleWire.class, 651, 23048, 23059).getProviderWiring();
                            if (CallChecker.beforeDeref(npe_invocation_var161, org.osgi.framework.wiring.BundleWiring.class, 651, 23048, 23079)) {
                                requesterWire = CallChecker.beforeCalled(requesterWire, BundleWire.class, 652, 23123, 23135);
                                final org.osgi.framework.wiring.BundleWiring npe_invocation_var162 = CallChecker.isCalled(requesterWire, BundleWire.class, 652, 23123, 23135).getProviderWiring();
                                if (CallChecker.beforeDeref(npe_invocation_var162, org.osgi.framework.wiring.BundleWiring.class, 652, 23123, 23155)) {
                                    final BundleRevision npe_invocation_var163 = CallChecker.isCalled(npe_invocation_var161, org.osgi.framework.wiring.BundleWiring.class, 651, 23048, 23079).getRevision();
                                    if (CallChecker.beforeDeref(npe_invocation_var163, BundleRevision.class, 651, 23048, 23093)) {
                                        allow = CallChecker.isCalled(npe_invocation_var163, BundleRevision.class, 651, 23048, 23093).equals(CallChecker.isCalled(npe_invocation_var162, org.osgi.framework.wiring.BundleWiring.class, 652, 23123, 23155).getRevision());
                                        CallChecker.varAssign(allow, "allow", 651, 23040, 23171);
                                    }
                                }
                            }
                        }
                    
                
                return allow;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context398.methodEnd();
            }
        }

        public int compareTo(Object reference) {
            MethodContext _bcornu_methode_context399 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 658, 23233, 24704);
                CallChecker.varInit(reference, "reference", 658, 23233, 24704);
                CallChecker.varInit(BundleCapabilityImpl.VERSION_ATTR, "org.apache.felix.framework.wiring.BundleCapabilityImpl.VERSION_ATTR", 658, 23233, 24704);
                CallChecker.varInit(this.m_map, "m_map", 658, 23233, 24704);
                ServiceReference other = CallChecker.varInit(((ServiceReference) (reference)), "other", 660, 23294, 23347);
                Long id = CallChecker.varInit(((Long) (getProperty(Constants.SERVICE_ID))), "id", 662, 23362, 23412);
                Long otherId = CallChecker.init(Long.class);
                if (CallChecker.beforeDeref(other, ServiceReference.class, 663, 23448, 23452)) {
                    other = CallChecker.beforeCalled(other, ServiceReference.class, 663, 23448, 23452);
                    otherId = ((Long) (CallChecker.isCalled(other, ServiceReference.class, 663, 23448, 23452).getProperty(Constants.SERVICE_ID)));
                    CallChecker.varAssign(otherId, "otherId", 663, 23448, 23452);
                }
                if (CallChecker.beforeDeref(id, Long.class, 665, 23506, 23507)) {
                    id = CallChecker.beforeCalled(id, Long.class, 665, 23506, 23507);
                    if (CallChecker.isCalled(id, Long.class, 665, 23506, 23507).equals(otherId)) {
                        return 0;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                Object rankObj = CallChecker.varInit(getProperty(Constants.SERVICE_RANKING), "rankObj", 670, 23609, 23664);
                Object otherRankObj = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(other, ServiceReference.class, 671, 23700, 23704)) {
                    other = CallChecker.beforeCalled(other, ServiceReference.class, 671, 23700, 23704);
                    otherRankObj = CallChecker.isCalled(other, ServiceReference.class, 671, 23700, 23704).getProperty(Constants.SERVICE_RANKING);
                    CallChecker.varAssign(otherRankObj, "otherRankObj", 671, 23700, 23704);
                }
                if (rankObj == null) {
                    rankObj = new Integer(0);
                    CallChecker.varAssign(rankObj, "rankObj", 674, 23822, 23876);
                }else {
                    rankObj = rankObj;
                    CallChecker.varAssign(rankObj, "rankObj", 674, 23822, 23876);
                }
                if (otherRankObj == null) {
                    otherRankObj = new Integer(0);
                    CallChecker.varAssign(otherRankObj, "otherRankObj", 675, 23890, 23959);
                }else {
                    otherRankObj = otherRankObj;
                    CallChecker.varAssign(otherRankObj, "otherRankObj", 675, 23890, 23959);
                }
                Integer rank = CallChecker.init(Integer.class);
                if (rankObj instanceof Integer) {
                    rank = ((Integer) (rankObj));
                    CallChecker.varAssign(rank, "rank", 678, 24064, 24144);
                }else {
                    rank = new Integer(0);
                    CallChecker.varAssign(rank, "rank", 678, 24064, 24144);
                }
                Integer otherRank = CallChecker.init(Integer.class);
                if (otherRankObj instanceof Integer) {
                    otherRank = ((Integer) (otherRankObj));
                    CallChecker.varAssign(otherRank, "otherRank", 680, 24179, 24269);
                }else {
                    otherRank = new Integer(0);
                    CallChecker.varAssign(otherRank, "otherRank", 680, 24179, 24269);
                }
                if (CallChecker.beforeDeref(rank, Integer.class, 684, 24337, 24340)) {
                    rank = CallChecker.beforeCalled(rank, Integer.class, 684, 24337, 24340);
                    if ((CallChecker.isCalled(rank, Integer.class, 684, 24337, 24340).compareTo(otherRank)) < 0) {
                        return -1;
                    }else
                        if (CallChecker.beforeDeref(rank, Integer.class, 688, 24458, 24461)) {
                            rank = CallChecker.beforeCalled(rank, Integer.class, 688, 24458, 24461);
                            if ((CallChecker.isCalled(rank, Integer.class, 688, 24458, 24461).compareTo(otherRank)) > 0) {
                                return 1;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(id, Long.class, 694, 24659, 24660)) {
                    id = CallChecker.beforeCalled(id, Long.class, 694, 24659, 24660);
                    if ((CallChecker.isCalled(id, Long.class, 694, 24659, 24660).compareTo(otherId)) < 0) {
                        return 1;
                    }else {
                        return -1;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context399.methodEnd();
            }
        }
    }

    private class ServiceReferenceMap implements Map {
        public int size() {
            MethodContext _bcornu_methode_context400 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 700, 24780, 24891);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context400.methodEnd();
            }
        }

        public boolean isEmpty() {
            MethodContext _bcornu_methode_context401 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 705, 24902, 25020);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context401.methodEnd();
            }
        }

        public boolean containsKey(Object o) {
            MethodContext _bcornu_methode_context402 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 710, 25031, 25161);
                CallChecker.varInit(o, "o", 710, 25031, 25161);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context402.methodEnd();
            }
        }

        public boolean containsValue(Object o) {
            MethodContext _bcornu_methode_context403 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 715, 25172, 25304);
                CallChecker.varInit(o, "o", 715, 25172, 25304);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context403.methodEnd();
            }
        }

        public Object get(Object o) {
            MethodContext _bcornu_methode_context404 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 720, 25315, 25434);
                CallChecker.varInit(o, "o", 720, 25315, 25434);
                return ServiceRegistrationImpl.this.getProperty(((String) (o)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context404.methodEnd();
            }
        }

        public Object put(Object k, Object v) {
            MethodContext _bcornu_methode_context405 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 725, 25445, 25576);
                CallChecker.varInit(v, "v", 725, 25445, 25576);
                CallChecker.varInit(k, "k", 725, 25445, 25576);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context405.methodEnd();
            }
        }

        public Object remove(Object o) {
            MethodContext _bcornu_methode_context406 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 730, 25587, 25711);
                CallChecker.varInit(o, "o", 730, 25587, 25711);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context406.methodEnd();
            }
        }

        public void putAll(Map map) {
            MethodContext _bcornu_methode_context407 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 735, 25722, 25843);
                CallChecker.varInit(map, "map", 735, 25722, 25843);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context407.methodEnd();
            }
        }

        public void clear() {
            MethodContext _bcornu_methode_context408 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 740, 25854, 25967);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context408.methodEnd();
            }
        }

        public Set<Object> keySet() {
            MethodContext _bcornu_methode_context409 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 745, 25978, 26099);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Object>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context409.methodEnd();
            }
        }

        public Collection<Object> values() {
            MethodContext _bcornu_methode_context410 = new MethodContext(Collection.class);
            try {
                CallChecker.varInit(this, "this", 750, 26110, 26238);
                throw new UnsupportedOperationException("Not supported yet.");
            } catch (ForceReturn _bcornu_return_t) {
                return ((Collection<Object>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context410.methodEnd();
            }
        }

        public Set<Map.Entry<Object, Object>> entrySet() {
            MethodContext _bcornu_methode_context411 = new MethodContext(Set.class);
            try {
                CallChecker.varInit(this, "this", 755, 26249, 26354);
                return Collections.EMPTY_SET;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Set<Map.Entry<Object, Object>>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context411.methodEnd();
            }
        }
    }

    boolean currentThreadMarked() {
        MethodContext _bcornu_methode_context412 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 761, 26367, 26459);
            CallChecker.varInit(this.syncObject, "syncObject", 761, 26367, 26459);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 761, 26367, 26459);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 761, 26367, 26459);
            CallChecker.varInit(this.m_ref, "m_ref", 761, 26367, 26459);
            CallChecker.varInit(this.m_propMap, "m_propMap", 761, 26367, 26459);
            CallChecker.varInit(this.m_factory, "m_factory", 761, 26367, 26459);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 761, 26367, 26459);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 761, 26367, 26459);
            CallChecker.varInit(this.m_classes, "m_classes", 761, 26367, 26459);
            CallChecker.varInit(this.m_bundle, "m_bundle", 761, 26367, 26459);
            CallChecker.varInit(this.m_registry, "m_registry", 761, 26367, 26459);
            return (CallChecker.isCalled(m_threadLoopDetection, ThreadLocal.class, 763, 26418, 26438).get()) != null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context412.methodEnd();
        }
    }

    void markCurrentThread() {
        MethodContext _bcornu_methode_context413 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 766, 26466, 26550);
            CallChecker.varInit(this.syncObject, "syncObject", 766, 26466, 26550);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 766, 26466, 26550);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 766, 26466, 26550);
            CallChecker.varInit(this.m_ref, "m_ref", 766, 26466, 26550);
            CallChecker.varInit(this.m_propMap, "m_propMap", 766, 26466, 26550);
            CallChecker.varInit(this.m_factory, "m_factory", 766, 26466, 26550);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 766, 26466, 26550);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 766, 26466, 26550);
            CallChecker.varInit(this.m_classes, "m_classes", 766, 26466, 26550);
            CallChecker.varInit(this.m_bundle, "m_bundle", 766, 26466, 26550);
            CallChecker.varInit(this.m_registry, "m_registry", 766, 26466, 26550);
            if (CallChecker.beforeDeref(m_threadLoopDetection, ThreadLocal.class, 768, 26505, 26525)) {
                CallChecker.isCalled(m_threadLoopDetection, ThreadLocal.class, 768, 26505, 26525).set(Boolean.TRUE);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context413.methodEnd();
        }
    }

    void unmarkCurrentThread() {
        MethodContext _bcornu_methode_context414 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 771, 26557, 26635);
            CallChecker.varInit(this.syncObject, "syncObject", 771, 26557, 26635);
            CallChecker.varInit(this.m_threadLoopDetection, "m_threadLoopDetection", 771, 26557, 26635);
            CallChecker.varInit(this.m_isUnregistering, "m_isUnregistering", 771, 26557, 26635);
            CallChecker.varInit(this.m_ref, "m_ref", 771, 26557, 26635);
            CallChecker.varInit(this.m_propMap, "m_propMap", 771, 26557, 26635);
            CallChecker.varInit(this.m_factory, "m_factory", 771, 26557, 26635);
            CallChecker.varInit(this.m_svcObj, "m_svcObj", 771, 26557, 26635);
            CallChecker.varInit(this.m_serviceId, "m_serviceId", 771, 26557, 26635);
            CallChecker.varInit(this.m_classes, "m_classes", 771, 26557, 26635);
            CallChecker.varInit(this.m_bundle, "m_bundle", 771, 26557, 26635);
            CallChecker.varInit(this.m_registry, "m_registry", 771, 26557, 26635);
            if (CallChecker.beforeDeref(m_threadLoopDetection, ThreadLocal.class, 773, 26598, 26618)) {
                CallChecker.isCalled(m_threadLoopDetection, ThreadLocal.class, 773, 26598, 26618).set(null);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context414.methodEnd();
        }
    }
}

