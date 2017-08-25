package org.apache.felix.framework;

import org.osgi.framework.hooks.weaving.WovenClassListener;
import org.osgi.framework.hooks.weaving.WeavingHook;
import java.util.WeakHashMap;
import org.osgi.service.url.URLStreamHandlerService;
import java.util.TreeSet;
import org.osgi.framework.hooks.bundle.FindHook;
import org.osgi.framework.hooks.service.EventListenerHook;
import org.osgi.framework.hooks.bundle.EventHook;
import java.net.ContentHandler;
import org.osgi.framework.Constants;
import org.osgi.framework.hooks.bundle.CollisionHook;
import java.util.Collections;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.util.List;
import org.osgi.framework.hooks.service.ListenerHook;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.osgi.framework.hooks.resolver.ResolverHookFactory;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceReference;
import java.util.Set;
import java.util.SortedSet;

public class HookRegistry {
    private static final Map<String, Class<?>> HOOK_CLASSES = new HashMap<String, Class<?>>();

    static {
        HookRegistry.addHookClass(CollisionHook.class);
        HookRegistry.addHookClass(FindHook.class);
        HookRegistry.addHookClass(EventHook.class);
        HookRegistry.addHookClass(org.osgi.framework.hooks.service.EventHook.class);
        HookRegistry.addHookClass(EventListenerHook.class);
        HookRegistry.addHookClass(org.osgi.framework.hooks.service.FindHook.class);
        HookRegistry.addHookClass(ListenerHook.class);
        HookRegistry.addHookClass(WeavingHook.class);
        HookRegistry.addHookClass(WovenClassListener.class);
        HookRegistry.addHookClass(ResolverHookFactory.class);
        HookRegistry.addHookClass(URLStreamHandlerService.class);
        HookRegistry.addHookClass(ContentHandler.class);
    }

    private static void addHookClass(final Class<?> c) {
        MethodContext _bcornu_methode_context362 = new MethodContext(void.class);
        try {
            CallChecker.varInit(c, "c", 59, 2387, 2486);
            CallChecker.varInit(HOOK_CLASSES, "org.apache.felix.framework.HookRegistry.HOOK_CLASSES", 59, 2387, 2486);
            if (CallChecker.beforeDeref(c, Class.class, 60, 2465, 2465)) {
                if (CallChecker.beforeDeref(HookRegistry.HOOK_CLASSES, Map.class, 60, 2448, 2459)) {
                    CallChecker.isCalled(HookRegistry.HOOK_CLASSES, Map.class, 60, 2448, 2459).put(CallChecker.isCalled(c, Class.class, 60, 2465, 2465).getName(), c);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context362.methodEnd();
        }
    }

    private final Map<String, Set<ServiceReference<?>>> m_allHooks = new HashMap<String, Set<ServiceReference<?>>>();

    private final WeakHashMap<ServiceReference<?>, ServiceReference<?>> m_blackList = new WeakHashMap<ServiceReference<?>, ServiceReference<?>>();

    static boolean isHook(final String[] classNames, final Class<?> hookClass, final Object svcObj) {
        MethodContext _bcornu_methode_context363 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(svcObj, "svcObj", 70, 2781, 3462);
            CallChecker.varInit(hookClass, "hookClass", 70, 2781, 3462);
            CallChecker.varInit(classNames, "classNames", 70, 2781, 3462);
            CallChecker.varInit(HOOK_CLASSES, "org.apache.felix.framework.HookRegistry.HOOK_CLASSES", 70, 2781, 3462);
            if (CallChecker.beforeDeref(classNames, boolean.class, 72, 2923, 2932)) {
                for (final String serviceName : classNames) {
                    if (CallChecker.beforeDeref(hookClass, Class.class, 74, 2980, 2988)) {
                        if (CallChecker.beforeDeref(serviceName, String.class, 74, 2961, 2971)) {
                            if (CallChecker.isCalled(serviceName, String.class, 74, 2961, 2971).equals(CallChecker.isCalled(hookClass, Class.class, 74, 2980, 2988).getName())) {
                                if (svcObj instanceof ServiceFactory) {
                                    return true;
                                }
                                if (CallChecker.beforeDeref(svcObj, Object.class, 82, 3322, 3327)) {
                                    if (CallChecker.beforeDeref(hookClass, Class.class, 82, 3295, 3303)) {
                                        if (CallChecker.isCalled(hookClass, Class.class, 82, 3295, 3303).isAssignableFrom(CallChecker.isCalled(svcObj, Object.class, 82, 3322, 3327).getClass())) {
                                            return true;
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
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context363.methodEnd();
        }
    }

    private boolean isHook(final String serviceName, final Object svcObj) {
        MethodContext _bcornu_methode_context364 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 92, 3469, 4046);
            CallChecker.varInit(svcObj, "svcObj", 92, 3469, 4046);
            CallChecker.varInit(serviceName, "serviceName", 92, 3469, 4046);
            CallChecker.varInit(this.m_blackList, "m_blackList", 92, 3469, 4046);
            CallChecker.varInit(this.m_allHooks, "m_allHooks", 92, 3469, 4046);
            CallChecker.varInit(HOOK_CLASSES, "org.apache.felix.framework.HookRegistry.HOOK_CLASSES", 92, 3469, 4046);
            final Class<?> hookClass = CallChecker.varInit(CallChecker.isCalled(HookRegistry.HOOK_CLASSES, Map.class, 94, 3580, 3591).get(serviceName), "hookClass", 94, 3553, 3609);
            if (hookClass != null) {
                if (svcObj instanceof ServiceFactory) {
                    return true;
                }
                if (CallChecker.beforeDeref(svcObj, Object.class, 103, 3932, 3937)) {
                    if (hookClass.isAssignableFrom(CallChecker.isCalled(svcObj, Object.class, 103, 3932, 3937).getClass())) {
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context364.methodEnd();
        }
    }

    public void addHooks(final String[] classNames, final Object svcObj, final ServiceReference<?> ref) {
        MethodContext _bcornu_methode_context365 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 112, 4053, 4740);
            CallChecker.varInit(ref, "ref", 112, 4053, 4740);
            CallChecker.varInit(svcObj, "svcObj", 112, 4053, 4740);
            CallChecker.varInit(classNames, "classNames", 112, 4053, 4740);
            CallChecker.varInit(this.m_blackList, "m_blackList", 112, 4053, 4740);
            CallChecker.varInit(this.m_allHooks, "m_allHooks", 112, 4053, 4740);
            CallChecker.varInit(HOOK_CLASSES, "org.apache.felix.framework.HookRegistry.HOOK_CLASSES", 112, 4053, 4740);
            if (CallChecker.beforeDeref(classNames, void.class, 114, 4198, 4207)) {
                for (final String serviceName : classNames) {
                    if (isHook(serviceName, svcObj)) {
                        synchronized(m_allHooks) {
                            Set<ServiceReference<?>> hooks = CallChecker.init(Set.class);
                            if (CallChecker.beforeDeref(m_allHooks, Map.class, 120, 4392, 4401)) {
                                hooks = CallChecker.isCalled(m_allHooks, Map.class, 120, 4392, 4401).get(serviceName);
                                CallChecker.varAssign(hooks, "hooks", 120, 4392, 4401);
                            }
                            if (hooks == null) {
                                hooks = new TreeSet<ServiceReference<?>>(Collections.reverseOrder());
                                CallChecker.varAssign(hooks, "hooks", 123, 4506, 4574);
                                if (CallChecker.beforeDeref(m_allHooks, Map.class, 124, 4600, 4609)) {
                                    CallChecker.isCalled(m_allHooks, Map.class, 124, 4600, 4609).put(serviceName, hooks);
                                }
                            }
                            if (CallChecker.beforeDeref(hooks, Set.class, 126, 4678, 4682)) {
                                hooks = CallChecker.beforeCalled(hooks, Set.class, 126, 4678, 4682);
                                CallChecker.isCalled(hooks, Set.class, 126, 4678, 4682).add(ref);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context365.methodEnd();
        }
    }

    public void updateHooks(final ServiceReference<?> ref) {
        MethodContext _bcornu_methode_context366 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 132, 4747, 5768);
            CallChecker.varInit(ref, "ref", 132, 4747, 5768);
            CallChecker.varInit(this.m_blackList, "m_blackList", 132, 4747, 5768);
            CallChecker.varInit(this.m_allHooks, "m_allHooks", 132, 4747, 5768);
            CallChecker.varInit(HOOK_CLASSES, "org.apache.felix.framework.HookRegistry.HOOK_CLASSES", 132, 4747, 5768);
            final Object svcObj = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(((ServiceRegistrationImpl.ServiceReferenceImpl) (ref)), ServiceRegistrationImpl.ServiceReferenceImpl.class, 136, 5045, 5047).getRegistration(), ServiceRegistrationImpl.class, 136, 4997, 5083).getService(), "svcObj", 136, 4816, 5097);
            final String[] classNames = CallChecker.varInit(((String[]) (CallChecker.isCalled(ref, ServiceReference.class, 138, 5147, 5149).getProperty(Constants.OBJECTCLASS))), "classNames", 138, 5107, 5185);
            if (CallChecker.beforeDeref(classNames, void.class, 140, 5227, 5236)) {
                for (final String serviceName : classNames) {
                    if (isHook(serviceName, svcObj)) {
                        synchronized(m_allHooks) {
                            final Set<ServiceReference<?>> hooks = CallChecker.varInit(CallChecker.isCalled(m_allHooks, Map.class, 146, 5427, 5436).get(serviceName), "hooks", 146, 5388, 5454);
                            if (hooks != null) {
                                List<ServiceReference<?>> refs = CallChecker.varInit(new ArrayList<ServiceReference<?>>(hooks), "refs", 149, 5541, 5615);
                                hooks.clear();
                                hooks.addAll(refs);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context366.methodEnd();
        }
    }

    public void removeHooks(final ServiceReference<?> ref) {
        MethodContext _bcornu_methode_context367 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 158, 5775, 6683);
            CallChecker.varInit(ref, "ref", 158, 5775, 6683);
            CallChecker.varInit(this.m_blackList, "m_blackList", 158, 5775, 6683);
            CallChecker.varInit(this.m_allHooks, "m_allHooks", 158, 5775, 6683);
            CallChecker.varInit(HOOK_CLASSES, "org.apache.felix.framework.HookRegistry.HOOK_CLASSES", 158, 5775, 6683);
            final Object svcObj = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(((ServiceRegistrationImpl.ServiceReferenceImpl) (ref)), ServiceRegistrationImpl.ServiceReferenceImpl.class, 160, 5914, 5916).getRegistration(), ServiceRegistrationImpl.class, 160, 5866, 5948).getService(), "svcObj", 160, 5844, 5962);
            final String[] classNames = CallChecker.varInit(((String[]) (CallChecker.isCalled(ref, ServiceReference.class, 162, 6012, 6014).getProperty(Constants.OBJECTCLASS))), "classNames", 162, 5972, 6050);
            if (CallChecker.beforeDeref(classNames, void.class, 164, 6092, 6101)) {
                for (final String serviceName : classNames) {
                    if (isHook(serviceName, svcObj)) {
                        synchronized(m_allHooks) {
                            final Set<ServiceReference<?>> hooks = CallChecker.varInit(CallChecker.isCalled(m_allHooks, Map.class, 170, 6292, 6301).get(serviceName), "hooks", 170, 6253, 6319);
                            if (hooks != null) {
                                hooks.remove(ref);
                                if (hooks.isEmpty()) {
                                    if (CallChecker.beforeDeref(m_allHooks, Map.class, 176, 6524, 6533)) {
                                        CallChecker.isCalled(m_allHooks, Map.class, 176, 6524, 6533).remove(serviceName);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m_blackList, WeakHashMap.class, 182, 6654, 6664)) {
                CallChecker.isCalled(m_blackList, WeakHashMap.class, 182, 6654, 6664).remove(ref);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context367.methodEnd();
        }
    }

    public <S> Set<ServiceReference<S>> getHooks(final Class<S> hookClass) {
        MethodContext _bcornu_methode_context368 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 185, 6690, 7208);
            CallChecker.varInit(hookClass, "hookClass", 185, 6690, 7208);
            CallChecker.varInit(this.m_blackList, "m_blackList", 185, 6690, 7208);
            CallChecker.varInit(this.m_allHooks, "m_allHooks", 185, 6690, 7208);
            CallChecker.varInit(HOOK_CLASSES, "org.apache.felix.framework.HookRegistry.HOOK_CLASSES", 185, 6690, 7208);
            synchronized(m_allHooks) {
                final Set<ServiceReference<?>> hooks = CallChecker.varInit(CallChecker.isCalled(m_allHooks, Map.class, 189, 6862, 6871).get(CallChecker.isCalled(hookClass, Class.class, 189, 6877, 6885).getName()), "hooks", 189, 6823, 6897);
                if (hooks != null) {
                    SortedSet<ServiceReference<?>> sorted = CallChecker.varInit(new TreeSet<ServiceReference<?>>(Collections.reverseOrder()), "sorted", 192, 6960, 7060);
                    if (CallChecker.beforeDeref(sorted, SortedSet.class, 193, 7078, 7083)) {
                        sorted = CallChecker.beforeCalled(sorted, SortedSet.class, 193, 7078, 7083);
                        CallChecker.isCalled(sorted, SortedSet.class, 193, 7078, 7083).addAll(hooks);
                    }
                    return ((Set) (sorted));
                }
                return Collections.emptySet();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<ServiceReference<S>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context368.methodEnd();
        }
    }

    public boolean isHookBlackListed(final ServiceReference<?> sr) {
        MethodContext _bcornu_methode_context369 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 200, 7215, 7332);
            CallChecker.varInit(sr, "sr", 200, 7215, 7332);
            CallChecker.varInit(this.m_blackList, "m_blackList", 200, 7215, 7332);
            CallChecker.varInit(this.m_allHooks, "m_allHooks", 200, 7215, 7332);
            CallChecker.varInit(HOOK_CLASSES, "org.apache.felix.framework.HookRegistry.HOOK_CLASSES", 200, 7215, 7332);
            if (CallChecker.beforeDeref(m_blackList, WeakHashMap.class, 202, 7299, 7309)) {
                return CallChecker.isCalled(m_blackList, WeakHashMap.class, 202, 7299, 7309).containsKey(sr);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context369.methodEnd();
        }
    }

    public void blackListHook(final ServiceReference<?> sr) {
        MethodContext _bcornu_methode_context370 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 205, 7339, 7438);
            CallChecker.varInit(sr, "sr", 205, 7339, 7438);
            CallChecker.varInit(this.m_blackList, "m_blackList", 205, 7339, 7438);
            CallChecker.varInit(this.m_allHooks, "m_allHooks", 205, 7339, 7438);
            CallChecker.varInit(HOOK_CLASSES, "org.apache.felix.framework.HookRegistry.HOOK_CLASSES", 205, 7339, 7438);
            if (CallChecker.beforeDeref(m_blackList, WeakHashMap.class, 207, 7409, 7419)) {
                CallChecker.isCalled(m_blackList, WeakHashMap.class, 207, 7409, 7419).put(sr, sr);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context370.methodEnd();
        }
    }
}

