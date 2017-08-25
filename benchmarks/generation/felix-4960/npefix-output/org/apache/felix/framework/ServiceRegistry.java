package org.apache.felix.framework;

import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.capabilityset.SimpleFilter;
import java.util.Set;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceException;
import org.osgi.framework.ServiceEvent;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import java.util.Collection;
import org.apache.felix.framework.capabilityset.CapabilitySet;
import org.osgi.resource.Capability;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.felix.framework.wiring.BundleCapabilityImpl;
import org.osgi.framework.Bundle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.osgi.framework.Constants;
import java.util.concurrent.CountDownLatch;
import java.util.Dictionary;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.List;

public class ServiceRegistry {
    private final Logger m_logger;

    private final AtomicLong m_currentServiceId = new AtomicLong(1);

    private final ConcurrentMap<Bundle, List<ServiceRegistration<?>>> m_regsMap = new ConcurrentHashMap<Bundle, List<ServiceRegistration<?>>>();

    private final CapabilitySet m_regCapSet = new CapabilitySet(Collections.singletonList(Constants.OBJECTCLASS), false);

    private final ConcurrentMap<Bundle, ServiceRegistry.UsageCount[]> m_inUseMap = new ConcurrentHashMap<Bundle, ServiceRegistry.UsageCount[]>();

    private final ServiceRegistry.ServiceRegistryCallbacks m_callbacks;

    private final HookRegistry hookRegistry = new HookRegistry();

    public ServiceRegistry(final Logger logger, final ServiceRegistry.ServiceRegistryCallbacks callbacks) {
        MethodContext _bcornu_methode_context38 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 67, 2684, 2701);
            m_callbacks = callbacks;
            CallChecker.varAssign(this.m_callbacks, "this.m_callbacks", 68, 2711, 2734);
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    public ServiceReference<?>[] getRegisteredServices(final Bundle bundle) {
        MethodContext _bcornu_methode_context487 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 76, 2747, 3845);
            CallChecker.varInit(bundle, "bundle", 76, 2747, 3845);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 76, 2747, 3845);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 76, 2747, 3845);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 76, 2747, 3845);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 76, 2747, 3845);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 76, 2747, 3845);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 76, 2747, 3845);
            CallChecker.varInit(this.m_logger, "m_logger", 76, 2747, 3845);
            final List<ServiceRegistration<?>> regs = CallChecker.varInit(CallChecker.isCalled(m_regsMap, ConcurrentMap.class, 78, 3030, 3038).get(bundle), "regs", 78, 2988, 3051);
            if (regs != null) {
                final List<ServiceReference<?>> refs = CallChecker.varInit(new ArrayList<ServiceReference<?>>(regs.size()), "refs", 81, 3101, 3187);
                synchronized(regs) {
                    for (final ServiceRegistration<?> reg : regs) {
                        TryContext _bcornu_try_context_132 = new TryContext(132, ServiceRegistry.class, "java.lang.IllegalStateException");
                        try {
                            if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 89, 3482, 3484)) {
                                if (CallChecker.beforeDeref(refs, List.class, 89, 3473, 3476)) {
                                    CallChecker.isCalled(refs, List.class, 89, 3473, 3476).add(CallChecker.isCalled(reg, ServiceRegistration.class, 89, 3482, 3484).getReference());
                                }
                            }
                        } catch (final IllegalStateException ex) {
                            _bcornu_try_context_132.catchStart(132);
                        } finally {
                            _bcornu_try_context_132.finallyStart(132);
                        }
                    }
                }
                if (CallChecker.beforeDeref(refs, List.class, 97, 3795, 3798)) {
                    if (CallChecker.beforeDeref(refs, List.class, 97, 3761, 3764)) {
                        return CallChecker.isCalled(refs, List.class, 97, 3761, 3764).toArray(new ServiceReference[CallChecker.isCalled(refs, List.class, 97, 3795, 3798).size()]);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context487.methodEnd();
        }
    }

    public ServiceRegistration<?> registerService(final Bundle bundle, final String[] classNames, final Object svcObj, final Dictionary<?, ?> dict) {
        MethodContext _bcornu_methode_context488 = new MethodContext(ServiceRegistration.class);
        try {
            CallChecker.varInit(this, "this", 113, 3852, 5291);
            CallChecker.varInit(dict, "dict", 113, 3852, 5291);
            CallChecker.varInit(svcObj, "svcObj", 113, 3852, 5291);
            CallChecker.varInit(classNames, "classNames", 113, 3852, 5291);
            CallChecker.varInit(bundle, "bundle", 113, 3852, 5291);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 113, 3852, 5291);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 113, 3852, 5291);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 113, 3852, 5291);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 113, 3852, 5291);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 113, 3852, 5291);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 113, 3852, 5291);
            CallChecker.varInit(this.m_logger, "m_logger", 113, 3852, 5291);
            final ServiceRegistrationImpl reg = CallChecker.varInit(new ServiceRegistrationImpl(this, bundle, classNames, CallChecker.isCalled(m_currentServiceId, AtomicLong.class, 121, 4547, 4564).getAndIncrement(), svcObj, dict), "reg", 120, 4400, 4598);
            if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 124, 4699, 4701)) {
                if (CallChecker.beforeDeref(this.hookRegistry, HookRegistry.class, 124, 4652, 4668)) {
                    CallChecker.isCalled(this.hookRegistry, HookRegistry.class, 124, 4652, 4668).addHooks(classNames, svcObj, CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 124, 4699, 4701).getReference());
                }
            }
            final List<ServiceRegistration<?>> newRegs = CallChecker.varInit(new ArrayList<ServiceRegistration<?>>(), "newRegs", 127, 4729, 4869);
            List<ServiceRegistration<?>> regs = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(m_regsMap, ConcurrentMap.class, 128, 4915, 4923)) {
                regs = CallChecker.isCalled(m_regsMap, ConcurrentMap.class, 128, 4915, 4923).putIfAbsent(bundle, newRegs);
                CallChecker.varAssign(regs, "regs", 128, 4915, 4923);
            }
            if (regs == null) {
                regs = newRegs;
                CallChecker.varAssign(regs, "regs", 131, 5003, 5017);
            }
            synchronized(regs) {
                if (CallChecker.beforeDeref(regs, List.class, 136, 5163, 5166)) {
                    regs = CallChecker.beforeCalled(regs, List.class, 136, 5163, 5166);
                    CallChecker.isCalled(regs, List.class, 136, 5163, 5166).add(reg);
                }
            }
            if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 138, 5245, 5247)) {
                if (CallChecker.beforeDeref(m_regCapSet, CapabilitySet.class, 138, 5196, 5206)) {
                    CallChecker.isCalled(m_regCapSet, CapabilitySet.class, 138, 5196, 5206).addCapability(((BundleCapabilityImpl) (CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 138, 5245, 5247).getReference())));
                }
            }
            return reg;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceRegistration<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context488.methodEnd();
        }
    }

    public void unregisterService(final Bundle bundle, final ServiceRegistration<?> reg) {
        MethodContext _bcornu_methode_context489 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 148, 5298, 6785);
            CallChecker.varInit(reg, "reg", 148, 5298, 6785);
            CallChecker.varInit(bundle, "bundle", 148, 5298, 6785);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 148, 5298, 6785);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 148, 5298, 6785);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 148, 5298, 6785);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 148, 5298, 6785);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 148, 5298, 6785);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 148, 5298, 6785);
            CallChecker.varInit(this.m_logger, "m_logger", 148, 5298, 6785);
            if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 153, 5649, 5651)) {
                if (CallChecker.beforeDeref(this.hookRegistry, HookRegistry.class, 153, 5619, 5635)) {
                    CallChecker.isCalled(this.hookRegistry, HookRegistry.class, 153, 5619, 5635).removeHooks(CallChecker.isCalled(reg, ServiceRegistration.class, 153, 5649, 5651).getReference());
                }
            }
            final List<ServiceRegistration<?>> regs = CallChecker.varInit(CallChecker.isCalled(m_regsMap, ConcurrentMap.class, 156, 5767, 5775).get(bundle), "regs", 156, 5679, 5788);
            if (regs != null) {
                synchronized(regs) {
                    regs.remove(reg);
                }
            }
            if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 165, 6078, 6080)) {
                if (CallChecker.beforeDeref(m_regCapSet, CapabilitySet.class, 165, 6026, 6036)) {
                    CallChecker.isCalled(m_regCapSet, CapabilitySet.class, 165, 6026, 6036).removeCapability(((BundleCapabilityImpl) (CallChecker.isCalled(reg, ServiceRegistration.class, 165, 6078, 6080).getReference())));
                }
            }
            if ((m_callbacks) != null) {
                if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 171, 6308, 6310)) {
                    m_callbacks.serviceChanged(new ServiceEvent(ServiceEvent.UNREGISTERING, CallChecker.isCalled(reg, ServiceRegistration.class, 171, 6308, 6310).getReference()), null);
                }
            }
            final ServiceReference<?> ref = CallChecker.varInit(CallChecker.isCalled(reg, ServiceRegistration.class, 175, 6462, 6464).getReference(), "ref", 175, 6355, 6480);
            ungetServices(ref);
            if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 179, 6581, 6583)) {
                CallChecker.isCalled(((ServiceRegistrationImpl) (reg)), ServiceRegistrationImpl.class, 179, 6581, 6583).invalidate();
            }
            ungetServices(ref);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context489.methodEnd();
        }
    }

    private void ungetServices(final ServiceReference<?> ref) {
        MethodContext _bcornu_methode_context490 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 186, 6792, 7370);
            CallChecker.varInit(ref, "ref", 186, 6792, 7370);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 186, 6792, 7370);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 186, 6792, 7370);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 186, 6792, 7370);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 186, 6792, 7370);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 186, 6792, 7370);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 186, 6792, 7370);
            CallChecker.varInit(this.m_logger, "m_logger", 186, 6792, 7370);
            final Bundle[] clients = CallChecker.varInit(getUsingBundles(ref), "clients", 188, 6864, 6909);
            for (int i = 0; (clients != null) && (i < (CallChecker.isCalled(clients, Bundle[].class, 189, 6961, 6967).length)); i++) {
                final ServiceRegistry.UsageCount[] usages = CallChecker.varInit(CallChecker.isCalled(m_inUseMap, ConcurrentMap.class, 191, 7033, 7042).get(clients[i]), "usages", 191, 7005, 7059);
                for (int x = 0; (usages != null) && (x < (CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 192, 7114, 7119).length)); x++) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 194, 7169, 7174)[x], ServiceRegistry.UsageCount.class, 194, 7169, 7177)) {
                        CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 194, 7169, 7174)[x] = CallChecker.beforeCalled(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 194, 7169, 7174)[x], ServiceRegistry.UsageCount.class, 194, 7169, 7177);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 194, 7169, 7174)[x], ServiceRegistry.UsageCount.class, 194, 7169, 7177).m_ref, ServiceReference.class, 194, 7169, 7183)) {
                            usages[x] = CallChecker.beforeCalled(usages[x], ServiceRegistry.UsageCount.class, 194, 7169, 7177);
                            if (CallChecker.isCalled(CallChecker.isCalled(usages[x], ServiceRegistry.UsageCount.class, 194, 7169, 7177).m_ref, ServiceReference.class, 194, 7169, 7183).equals(ref)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 196, 7267, 7272)[x], ServiceRegistry.UsageCount.class, 196, 7267, 7275)) {
                                    usages[x] = CallChecker.beforeCalled(usages[x], ServiceRegistry.UsageCount.class, 196, 7267, 7275);
                                    if (CallChecker.isCalled(usages[x], ServiceRegistry.UsageCount.class, 196, 7267, 7275).m_prototype) {
                                        ungetService(clients[i], ref, CallChecker.isCalled(usages[x], ServiceRegistry.UsageCount.class, 196, 7291, 7299).getService());
                                    }else {
                                        ungetService(clients[i], ref, null);
                                    }
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
            _bcornu_methode_context490.methodEnd();
        }
    }

    public void unregisterServices(final Bundle bundle) {
        MethodContext _bcornu_methode_context491 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 209, 7377, 9077);
            CallChecker.varInit(bundle, "bundle", 209, 7377, 9077);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 209, 7377, 9077);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 209, 7377, 9077);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 209, 7377, 9077);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 209, 7377, 9077);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 209, 7377, 9077);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 209, 7377, 9077);
            CallChecker.varInit(this.m_logger, "m_logger", 209, 7377, 9077);
            final List<ServiceRegistration<?>> regs = CallChecker.varInit(CallChecker.isCalled(m_regsMap, ConcurrentMap.class, 212, 7889, 7897).remove(bundle), "regs", 212, 7780, 7913);
            if (regs != null) {
                List<ServiceRegistration<?>> copyRefs = CallChecker.init(List.class);
                synchronized(regs) {
                    copyRefs = new ArrayList<ServiceRegistration<?>>(regs);
                    CallChecker.varAssign(copyRefs, "copyRefs", 227, 8503, 8557);
                }
                if (CallChecker.beforeDeref(copyRefs, void.class, 229, 8625, 8632)) {
                    for (final ServiceRegistration<?> reg : copyRefs) {
                        if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 231, 8696, 8698)) {
                            if (CallChecker.isCalled(((ServiceRegistrationImpl) (reg)), ServiceRegistrationImpl.class, 231, 8696, 8698).isValid()) {
                                TryContext _bcornu_try_context_133 = new TryContext(133, ServiceRegistry.class, "java.lang.IllegalStateException");
                                try {
                                    if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 235, 8800, 8802)) {
                                        CallChecker.isCalled(reg, ServiceRegistration.class, 235, 8800, 8802).unregister();
                                    }
                                } catch (final IllegalStateException e) {
                                    _bcornu_try_context_133.catchStart(133);
                                } finally {
                                    _bcornu_try_context_133.finallyStart(133);
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
            _bcornu_methode_context491.methodEnd();
        }
    }

    public Collection<Capability> getServiceReferences(final String className, SimpleFilter filter) {
        MethodContext _bcornu_methode_context492 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 246, 9084, 10118);
            CallChecker.varInit(filter, "filter", 246, 9084, 10118);
            CallChecker.varInit(className, "className", 246, 9084, 10118);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 246, 9084, 10118);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 246, 9084, 10118);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 246, 9084, 10118);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 246, 9084, 10118);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 246, 9084, 10118);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 246, 9084, 10118);
            CallChecker.varInit(this.m_logger, "m_logger", 246, 9084, 10118);
            if ((className == null) && (filter == null)) {
                filter = new SimpleFilter(null, null, SimpleFilter.MATCH_ALL);
                CallChecker.varAssign(filter, "filter", 251, 9297, 9358);
            }else
                if ((className != null) && (filter == null)) {
                    filter = new SimpleFilter(Constants.OBJECTCLASS, className, SimpleFilter.EQ);
                    CallChecker.varAssign(filter, "filter", 256, 9506, 9582);
                }else
                    if ((className != null) && (filter != null)) {
                        final List<SimpleFilter> filters = CallChecker.varInit(new ArrayList<SimpleFilter>(2), "filters", 261, 9674, 9806);
                        if (CallChecker.beforeDeref(filters, List.class, 262, 9820, 9826)) {
                            CallChecker.isCalled(filters, List.class, 262, 9820, 9826).add(new SimpleFilter(Constants.OBJECTCLASS, className, SimpleFilter.EQ));
                        }
                        if (CallChecker.beforeDeref(filters, List.class, 263, 9914, 9920)) {
                            CallChecker.isCalled(filters, List.class, 263, 9914, 9920).add(filter);
                        }
                        filter = new SimpleFilter(null, filters, SimpleFilter.AND);
                        CallChecker.varAssign(filter, "filter", 264, 9947, 10005);
                    }
                
            
            if (CallChecker.beforeDeref(m_regCapSet, CapabilitySet.class, 268, 10080, 10090)) {
                return CallChecker.isCalled(m_regCapSet, CapabilitySet.class, 268, 10080, 10090).match(filter, false);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<Capability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context492.methodEnd();
        }
    }

    public ServiceReference<?>[] getServicesInUse(final Bundle bundle) {
        MethodContext _bcornu_methode_context493 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 271, 10125, 10561);
            CallChecker.varInit(bundle, "bundle", 271, 10125, 10561);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 271, 10125, 10561);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 271, 10125, 10561);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 271, 10125, 10561);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 271, 10125, 10561);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 271, 10125, 10561);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 271, 10125, 10561);
            CallChecker.varInit(this.m_logger, "m_logger", 271, 10125, 10561);
            final ServiceRegistry.UsageCount[] usages = CallChecker.varInit(CallChecker.isCalled(m_inUseMap, ConcurrentMap.class, 273, 10234, 10243).get(bundle), "usages", 273, 10206, 10256);
            if (usages != null) {
                final ServiceReference<?>[] refs = CallChecker.varInit(new ServiceReference[usages.length], "refs", 276, 10308, 10378);
                for (int i = 0; i < (CallChecker.isCalled(refs, ServiceReference[].class, 277, 10412, 10415).length); i++) {
                    if (CallChecker.beforeDeref(refs, ServiceReference[].class, 279, 10460, 10463)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 279, 10470, 10475)[i], ServiceRegistry.UsageCount.class, 279, 10470, 10478)) {
                            usages[i] = CallChecker.beforeCalled(usages[i], ServiceRegistry.UsageCount.class, 279, 10470, 10478);
                            CallChecker.isCalled(refs, ServiceReference[].class, 279, 10460, 10463)[i] = CallChecker.isCalled(usages[i], ServiceRegistry.UsageCount.class, 279, 10470, 10478).m_ref;
                            CallChecker.varAssign(CallChecker.isCalled(refs, ServiceReference[].class, 279, 10460, 10463)[i], "CallChecker.isCalled(refs, ServiceReference[].class, 279, 10460, 10463)[i]", 279, 10460, 10485);
                        }
                    }
                }
                return refs;
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context493.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public <S> S getService(final Bundle bundle, final ServiceReference<S> ref, final boolean isServiceObjects) {
        final boolean isPrototype = CallChecker.varInit(((boolean) (isServiceObjects && ((CallChecker.isCalled(ref, ServiceReference.class, 290, 10841, 10843).getProperty(Constants.SERVICE_SCOPE)) == (Constants.SCOPE_PROTOTYPE)))), "isPrototype", 290, 10722, 10910);
        ServiceRegistry.UsageCount usage = CallChecker.varInit(null, "usage", 291, 10920, 10943);
        Object svcObj = CallChecker.varInit(null, "svcObj", 292, 10953, 10973);
        final ServiceRegistrationImpl reg = CallChecker.varInit(CallChecker.isCalled(((ServiceRegistrationImpl.ServiceReferenceImpl) (ref)), ServiceRegistrationImpl.ServiceReferenceImpl.class, 296, 11121, 11123).getRegistration(), "reg", 295, 10984, 11143);
        if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 299, 11233, 11235)) {
            if (CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 299, 11233, 11235).currentThreadMarked()) {
                throw new ServiceException("ServiceFactory.getService() resulted in a cycle.", ServiceException.FACTORY_ERROR, null);
            }
        }else
            throw new AbnormalExecutionError();
        
        TryContext _bcornu_try_context_135 = new TryContext(135, ServiceRegistry.class);
        try {
            if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 309, 11507, 11509)) {
                CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 309, 11507, 11509).markCurrentThread();
            }
            if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 312, 11615, 11617)) {
                if (CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 312, 11615, 11617).isValid()) {
                    usage = obtainUsageCount(bundle, ref, null, isPrototype);
                    CallChecker.varAssign(usage, "usage", 316, 11798, 11854);
                    if (CallChecker.beforeDeref(usage, ServiceRegistry.UsageCount.class, 320, 12018, 12022)) {
                        usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 320, 12018, 12022);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 320, 12018, 12022).m_count, AtomicLong.class, 320, 12018, 12030)) {
                            usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 320, 12018, 12022);
                            checkCountOverflow(CallChecker.isCalled(CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 320, 12018, 12022).m_count, AtomicLong.class, 320, 12018, 12030).incrementAndGet());
                        }
                    }
                    if (CallChecker.beforeDeref(usage, ServiceRegistry.UsageCount.class, 322, 12078, 12082)) {
                        usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 322, 12078, 12082);
                        svcObj = CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 322, 12078, 12082).getService();
                        CallChecker.varAssign(svcObj, "svcObj", 322, 12069, 12096);
                    }
                    if (isServiceObjects) {
                        if (CallChecker.beforeDeref(usage, ServiceRegistry.UsageCount.class, 325, 12195, 12199)) {
                            usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 325, 12195, 12199);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 325, 12195, 12199).m_serviceObjectsCount, AtomicLong.class, 325, 12195, 12221)) {
                                usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 325, 12195, 12199);
                                checkCountOverflow(CallChecker.isCalled(CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 325, 12195, 12199).m_serviceObjectsCount, AtomicLong.class, 325, 12195, 12221).incrementAndGet());
                            }
                        }
                    }
                    if ((usage != null) && (svcObj == null)) {
                        ServiceRegistry.ServiceHolder holder = CallChecker.varInit(null, "holder", 332, 12517, 12544);
                        while (holder == null) {
                            ServiceRegistry.ServiceHolder h = CallChecker.varInit(new ServiceRegistry.ServiceHolder(), "h", 339, 12918, 12955);
                            usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 340, 12985, 12989);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 340, 12985, 12989).m_svcHolderRef, AtomicReference.class, 340, 12985, 13004)) {
                                if (CallChecker.isCalled(usage.m_svcHolderRef, AtomicReference.class, 340, 12985, 13004).compareAndSet(null, h)) {
                                    holder = h;
                                    CallChecker.varAssign(holder, "holder", 342, 13084, 13094);
                                    if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 343, 13133, 13135)) {
                                        svcObj = CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 343, 13133, 13135).getService(bundle);
                                        CallChecker.varAssign(svcObj, "svcObj", 343, 13124, 13155);
                                    }
                                    if (CallChecker.beforeDeref(holder, ServiceRegistry.ServiceHolder.class, 344, 13185, 13190)) {
                                        holder = CallChecker.beforeCalled(holder, ServiceRegistry.ServiceHolder.class, 344, 13185, 13190);
                                        CallChecker.isCalled(holder, ServiceRegistry.ServiceHolder.class, 344, 13185, 13190).m_service = svcObj;
                                        CallChecker.varAssign(CallChecker.isCalled(holder, ServiceRegistry.ServiceHolder.class, 344, 13185, 13190).m_service, "CallChecker.isCalled(holder, ServiceRegistry.ServiceHolder.class, 344, 13185, 13190).m_service", 344, 13185, 13210);
                                    }
                                    if (CallChecker.beforeDeref(holder, ServiceRegistry.ServiceHolder.class, 345, 13240, 13245)) {
                                        holder = CallChecker.beforeCalled(holder, ServiceRegistry.ServiceHolder.class, 345, 13240, 13245);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(holder, ServiceRegistry.ServiceHolder.class, 345, 13240, 13245).m_latch, CountDownLatch.class, 345, 13240, 13253)) {
                                            holder = CallChecker.beforeCalled(holder, ServiceRegistry.ServiceHolder.class, 345, 13240, 13245);
                                            CallChecker.isCalled(CallChecker.isCalled(holder, ServiceRegistry.ServiceHolder.class, 345, 13240, 13245).m_latch, CountDownLatch.class, 345, 13240, 13253).countDown();
                                        }
                                    }
                                }else {
                                    usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 349, 13386, 13390);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 349, 13386, 13390).m_svcHolderRef, AtomicReference.class, 349, 13386, 13405)) {
                                        holder = CallChecker.isCalled(usage.m_svcHolderRef, AtomicReference.class, 349, 13386, 13405).get();
                                        CallChecker.varAssign(holder, "holder", 349, 13377, 13412);
                                    }
                                    if (holder != null) {
                                        TryContext _bcornu_try_context_134 = new TryContext(134, ServiceRegistry.class, "java.lang.InterruptedException");
                                        try {
                                            holder = CallChecker.beforeCalled(holder, ServiceRegistry.ServiceHolder.class, 356, 13739, 13744);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(holder, ServiceRegistry.ServiceHolder.class, 356, 13739, 13744).m_latch, CountDownLatch.class, 356, 13739, 13752)) {
                                                CallChecker.isCalled(holder.m_latch, CountDownLatch.class, 356, 13739, 13752).await();
                                            }
                                        } catch (InterruptedException e) {
                                            _bcornu_try_context_134.catchStart(134);
                                            throw new RuntimeException(e);
                                        } finally {
                                            _bcornu_try_context_134.finallyStart(134);
                                        }
                                        svcObj = holder.m_service;
                                        CallChecker.varAssign(svcObj, "svcObj", 362, 14027, 14052);
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        } 
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
        } finally {
            _bcornu_try_context_135.finallyStart(135);
            if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 371, 14212, 14214)) {
                CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 371, 14212, 14214).unmarkCurrentThread();
            }
            if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 373, 14257, 14259)) {
                if ((!(CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 373, 14257, 14259).isValid())) || (svcObj == null)) {
                    flushUsageCount(bundle, ref, usage);
                }
            }
        }
        return ((S) (svcObj));
    }

    private void checkCountOverflow(long c) {
        MethodContext _bcornu_methode_context495 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 382, 14422, 14707);
            CallChecker.varInit(c, "c", 382, 14422, 14707);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 382, 14422, 14707);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 382, 14422, 14707);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 382, 14422, 14707);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 382, 14422, 14707);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 382, 14422, 14707);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 382, 14422, 14707);
            CallChecker.varInit(this.m_logger, "m_logger", 382, 14422, 14707);
            if (c == (Long.MAX_VALUE)) {
                throw new ServiceException("The use count for the service overflowed.", ServiceException.UNSPECIFIED, null);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context495.methodEnd();
        }
    }

    public boolean ungetService(final Bundle bundle, final ServiceReference<?> ref, final Object svcObj) {
        MethodContext _bcornu_methode_context496 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 393, 14714, 17268);
            CallChecker.varInit(svcObj, "svcObj", 393, 14714, 17268);
            CallChecker.varInit(ref, "ref", 393, 14714, 17268);
            CallChecker.varInit(bundle, "bundle", 393, 14714, 17268);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 393, 14714, 17268);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 393, 14714, 17268);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 393, 14714, 17268);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 393, 14714, 17268);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 393, 14714, 17268);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 393, 14714, 17268);
            CallChecker.varInit(this.m_logger, "m_logger", 393, 14714, 17268);
            final ServiceRegistrationImpl reg = CallChecker.varInit(CallChecker.isCalled(((ServiceRegistrationImpl.ServiceReferenceImpl) (ref)), ServiceRegistrationImpl.ServiceReferenceImpl.class, 396, 14925, 14927).getRegistration(), "reg", 395, 14829, 14947);
            if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 398, 14963, 14965)) {
                if (CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 398, 14963, 14965).currentThreadMarked()) {
                    throw new IllegalStateException("ServiceFactory.ungetService() resulted in a cycle.");
                }
            }else
                throw new AbnormalExecutionError();
            
            TryContext _bcornu_try_context_137 = new TryContext(137, ServiceRegistry.class);
            try {
                if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 407, 15221, 15223)) {
                    CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 407, 15221, 15223).markCurrentThread();
                }
                ServiceRegistry.UsageCount usage = CallChecker.varInit(obtainUsageCount(bundle, ref, svcObj, null), "usage", 410, 15295, 15357);
                if (usage == null) {
                    return false;
                }
                if (svcObj != null) {
                    usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 420, 15720, 15724);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 420, 15720, 15724).m_serviceObjectsCount, AtomicLong.class, 420, 15720, 15746)) {
                        if ((CallChecker.isCalled(usage.m_serviceObjectsCount, AtomicLong.class, 420, 15720, 15746).decrementAndGet()) < 0) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                long count = CallChecker.init(long.class);
                usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 428, 15989, 15993);
                if (CallChecker.beforeDeref(CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 428, 15989, 15993).m_count, AtomicLong.class, 428, 15989, 16001)) {
                    count = CallChecker.isCalled(usage.m_count, AtomicLong.class, 428, 15989, 16001).decrementAndGet();
                    CallChecker.varAssign(count, "count", 428, 15989, 16001);
                }
                TryContext _bcornu_try_context_136 = new TryContext(136, ServiceRegistry.class);
                try {
                    if (count <= 0) {
                        ServiceRegistry.ServiceHolder holder = CallChecker.init(ServiceRegistry.ServiceHolder.class);
                        usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 433, 16145, 16149);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 433, 16145, 16149).m_svcHolderRef, AtomicReference.class, 433, 16145, 16164)) {
                            holder = CallChecker.isCalled(usage.m_svcHolderRef, AtomicReference.class, 433, 16145, 16164).get();
                            CallChecker.varAssign(holder, "holder", 433, 16145, 16164);
                        }
                        Object svc = CallChecker.init(Object.class);
                        if (holder != null) {
                            svc = holder.m_service;
                            CallChecker.varAssign(svc, "svc", 434, 16206, 16245);
                        }else {
                            svc = null;
                            CallChecker.varAssign(svc, "svc", 434, 16206, 16245);
                        }
                        if (svc != null) {
                            usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 438, 16336, 16340);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 438, 16336, 16340).m_svcHolderRef, AtomicReference.class, 438, 16336, 16355)) {
                                if (CallChecker.isCalled(usage.m_svcHolderRef, AtomicReference.class, 438, 16336, 16355).compareAndSet(holder, null)) {
                                    if (CallChecker.beforeDeref(ref, ServiceReference.class, 441, 16555, 16557)) {
                                        final ServiceRegistrationImpl npe_invocation_var178 = CallChecker.isCalled(((ServiceRegistrationImpl.ServiceReferenceImpl) (ref)), ServiceRegistrationImpl.ServiceReferenceImpl.class, 441, 16555, 16557).getRegistration();
                                        if (CallChecker.beforeDeref(npe_invocation_var178, ServiceRegistrationImpl.class, 441, 16507, 16609)) {
                                            CallChecker.isCalled(npe_invocation_var178, ServiceRegistrationImpl.class, 441, 16507, 16609).ungetService(bundle, svc);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } finally {
                    _bcornu_try_context_136.finallyStart(136);
                    if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 451, 16775, 16777)) {
                        if (!(CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 451, 16775, 16777).isValid())) {
                            usage = CallChecker.beforeCalled(usage, ServiceRegistry.UsageCount.class, 453, 16828, 16832);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(usage, ServiceRegistry.UsageCount.class, 453, 16828, 16832).m_svcHolderRef, AtomicReference.class, 453, 16828, 16847)) {
                                CallChecker.isCalled(usage.m_svcHolderRef, AtomicReference.class, 453, 16828, 16847).set(null);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 458, 17035, 17037)) {
                        if ((count <= 0) || (!(CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 458, 17035, 17037).isValid()))) {
                            flushUsageCount(bundle, ref, usage);
                        }
                    }
                }
            } finally {
                _bcornu_try_context_137.finallyStart(137);
                if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 466, 17205, 17207)) {
                    CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 466, 17205, 17207).unmarkCurrentThread();
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context496.methodEnd();
        }
    }

    public void ungetServices(final Bundle bundle) {
        MethodContext _bcornu_methode_context497 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 478, 17276, 18269);
            CallChecker.varInit(bundle, "bundle", 478, 17276, 18269);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 478, 17276, 18269);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 478, 17276, 18269);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 478, 17276, 18269);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 478, 17276, 18269);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 478, 17276, 18269);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 478, 17276, 18269);
            CallChecker.varInit(this.m_logger, "m_logger", 478, 17276, 18269);
            ServiceRegistry.UsageCount[] usages = CallChecker.init(ServiceRegistry.UsageCount[].class);
            if (CallChecker.beforeDeref(m_inUseMap, ConcurrentMap.class, 480, 17541, 17550)) {
                usages = CallChecker.isCalled(m_inUseMap, ConcurrentMap.class, 480, 17541, 17550).get(bundle);
                CallChecker.varAssign(usages, "usages", 480, 17541, 17550);
            }
            if (usages == null) {
                return ;
            }
            for (int i = 0; i < (usages.length); i++) {
                usages[i] = CallChecker.beforeCalled(usages[i], ServiceRegistry.UsageCount.class, 496, 18118, 18126);
                usages[i] = CallChecker.beforeCalled(usages[i], ServiceRegistry.UsageCount.class, 496, 18135, 18143);
                usages[i] = CallChecker.beforeCalled(usages[i], ServiceRegistry.UsageCount.class, 496, 18159, 18167);
                while (ungetService(bundle, CallChecker.isCalled(usages[i], ServiceRegistry.UsageCount.class, 496, 18118, 18126).m_ref, (CallChecker.isCalled(usages[i], ServiceRegistry.UsageCount.class, 496, 18135, 18143).m_prototype ? CallChecker.isCalled(usages[i], ServiceRegistry.UsageCount.class, 496, 18159, 18167).getService() : null))) {
                } 
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context497.methodEnd();
        }
    }

    public Bundle[] getUsingBundles(ServiceReference<?> ref) {
        MethodContext _bcornu_methode_context498 = new MethodContext(Bundle[].class);
        try {
            CallChecker.varInit(this, "this", 503, 18276, 19402);
            CallChecker.varInit(ref, "ref", 503, 18276, 19402);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 503, 18276, 19402);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 503, 18276, 19402);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 503, 18276, 19402);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 503, 18276, 19402);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 503, 18276, 19402);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 503, 18276, 19402);
            CallChecker.varInit(this.m_logger, "m_logger", 503, 18276, 19402);
            Bundle[] bundles = CallChecker.varInit(null, "bundles", 505, 18347, 18370);
            for (Iterator<Map.Entry<Bundle, ServiceRegistry.UsageCount[]>> iter = CallChecker.isCalled(CallChecker.isCalled(m_inUseMap, ConcurrentMap.class, 506, 18434, 18443).entrySet(), Set.class, 506, 18434, 18454).iterator(); CallChecker.isCalled(iter, Iterator.class, 506, 18468, 18471).hasNext();) {
                Map.Entry<Bundle, ServiceRegistry.UsageCount[]> entry = CallChecker.init(Map.Entry.class);
                if (CallChecker.beforeDeref(iter, Iterator.class, 508, 18548, 18551)) {
                    entry = CallChecker.isCalled(iter, Iterator.class, 508, 18548, 18551).next();
                    CallChecker.varAssign(entry, "entry", 508, 18548, 18551);
                }
                Bundle bundle = CallChecker.init(Bundle.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 509, 18589, 18593)) {
                    entry = CallChecker.beforeCalled(entry, Map.Entry.class, 509, 18589, 18593);
                    bundle = CallChecker.isCalled(entry, Map.Entry.class, 509, 18589, 18593).getKey();
                    CallChecker.varAssign(bundle, "bundle", 509, 18589, 18593);
                }
                ServiceRegistry.UsageCount[] usages = CallChecker.init(ServiceRegistry.UsageCount[].class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 510, 18639, 18643)) {
                    entry = CallChecker.beforeCalled(entry, Map.Entry.class, 510, 18639, 18643);
                    usages = CallChecker.isCalled(entry, Map.Entry.class, 510, 18639, 18643).getValue();
                    CallChecker.varAssign(usages, "usages", 510, 18639, 18643);
                }
                usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 511, 18699, 18704);
                for (int useIdx = 0; useIdx < (CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 511, 18699, 18704).length); useIdx++) {
                    if (CallChecker.beforeDeref(usages, ServiceRegistry.UsageCount[].class, 513, 18758, 18763)) {
                        usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 513, 18758, 18763);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 513, 18758, 18763)[useIdx], ServiceRegistry.UsageCount.class, 513, 18758, 18771)) {
                            usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 513, 18758, 18763);
                            CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 513, 18758, 18763)[useIdx] = CallChecker.beforeCalled(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 513, 18758, 18763)[useIdx], ServiceRegistry.UsageCount.class, 513, 18758, 18771);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 513, 18758, 18763)[useIdx], ServiceRegistry.UsageCount.class, 513, 18758, 18771).m_ref, ServiceReference.class, 513, 18758, 18777)) {
                                usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 513, 18758, 18763);
                                CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 513, 18758, 18763)[useIdx] = CallChecker.beforeCalled(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 513, 18758, 18763)[useIdx], ServiceRegistry.UsageCount.class, 513, 18758, 18771);
                                if (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 513, 18758, 18763)[useIdx], ServiceRegistry.UsageCount.class, 513, 18758, 18771).m_ref, ServiceReference.class, 513, 18758, 18777).equals(ref)) {
                                    if (bundles == null) {
                                        bundles = new Bundle[]{ bundle };
                                        CallChecker.varAssign(bundles, "bundles", 518, 18964, 18997);
                                    }else {
                                        Bundle[] nbs = CallChecker.varInit(new Bundle[(bundles.length) + 1], "nbs", 522, 19092, 19137);
                                        System.arraycopy(bundles, 0, nbs, 0, bundles.length);
                                        if (CallChecker.beforeDeref(nbs, Bundle[].class, 524, 19241, 19243)) {
                                            nbs = CallChecker.beforeCalled(nbs, Bundle[].class, 524, 19241, 19243);
                                            CallChecker.isCalled(nbs, Bundle[].class, 524, 19241, 19243)[bundles.length] = bundle;
                                            CallChecker.varAssign(CallChecker.isCalled(nbs, Bundle[].class, 524, 19241, 19243)[bundles.length], "CallChecker.isCalled(nbs, Bundle[].class, 524, 19241, 19243)[bundles.length]", 524, 19241, 19269);
                                        }
                                        bundles = nbs;
                                        CallChecker.varAssign(bundles, "bundles", 525, 19295, 19308);
                                    }
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return bundles;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context498.methodEnd();
        }
    }

    void servicePropertiesModified(ServiceRegistration<?> reg, Dictionary<?, ?> oldProps) {
        MethodContext _bcornu_methode_context499 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 533, 19409, 19744);
            CallChecker.varInit(oldProps, "oldProps", 533, 19409, 19744);
            CallChecker.varInit(reg, "reg", 533, 19409, 19744);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 533, 19409, 19744);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 533, 19409, 19744);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 533, 19409, 19744);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 533, 19409, 19744);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 533, 19409, 19744);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 533, 19409, 19744);
            CallChecker.varInit(this.m_logger, "m_logger", 533, 19409, 19744);
            if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 535, 19538, 19540)) {
                if (CallChecker.beforeDeref(this.hookRegistry, HookRegistry.class, 535, 19508, 19524)) {
                    reg = CallChecker.beforeCalled(reg, ServiceRegistration.class, 535, 19538, 19540);
                    CallChecker.isCalled(this.hookRegistry, HookRegistry.class, 535, 19508, 19524).updateHooks(CallChecker.isCalled(reg, ServiceRegistration.class, 535, 19538, 19540).getReference());
                }
            }
            if ((m_callbacks) != null) {
                if (CallChecker.beforeDeref(reg, ServiceRegistration.class, 539, 19698, 19700)) {
                    reg = CallChecker.beforeCalled(reg, ServiceRegistration.class, 539, 19698, 19700);
                    m_callbacks.serviceChanged(new ServiceEvent(ServiceEvent.MODIFIED, CallChecker.isCalled(reg, ServiceRegistration.class, 539, 19698, 19700).getReference()), oldProps);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context499.methodEnd();
        }
    }

    public Logger getLogger() {
        MethodContext _bcornu_methode_context500 = new MethodContext(Logger.class);
        try {
            CallChecker.varInit(this, "this", 543, 19751, 19812);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 543, 19751, 19812);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 543, 19751, 19812);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 543, 19751, 19812);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 543, 19751, 19812);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 543, 19751, 19812);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 543, 19751, 19812);
            CallChecker.varInit(this.m_logger, "m_logger", 543, 19751, 19812);
            return m_logger;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Logger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context500.methodEnd();
        }
    }

    ServiceRegistry.UsageCount obtainUsageCount(Bundle bundle, ServiceReference<?> ref, Object svcObj, Boolean isPrototype) {
        MethodContext _bcornu_methode_context501 = new MethodContext(ServiceRegistry.UsageCount.class);
        try {
            CallChecker.varInit(this, "this", 561, 19819, 22806);
            CallChecker.varInit(isPrototype, "isPrototype", 561, 19819, 22806);
            CallChecker.varInit(svcObj, "svcObj", 561, 19819, 22806);
            CallChecker.varInit(ref, "ref", 561, 19819, 22806);
            CallChecker.varInit(bundle, "bundle", 561, 19819, 22806);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 561, 19819, 22806);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 561, 19819, 22806);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 561, 19819, 22806);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 561, 19819, 22806);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 561, 19819, 22806);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 561, 19819, 22806);
            CallChecker.varInit(this.m_logger, "m_logger", 561, 19819, 22806);
            ServiceRegistry.UsageCount usage = CallChecker.varInit(null, "usage", 563, 20864, 20887);
            boolean success = CallChecker.varInit(((boolean) (false)), "success", 568, 21160, 21183);
            while (!success) {
                ServiceRegistry.UsageCount[] usages = CallChecker.init(ServiceRegistry.UsageCount[].class);
                if (CallChecker.beforeDeref(m_inUseMap, ConcurrentMap.class, 571, 21254, 21263)) {
                    usages = CallChecker.isCalled(m_inUseMap, ConcurrentMap.class, 571, 21254, 21263).get(bundle);
                    CallChecker.varAssign(usages, "usages", 571, 21254, 21263);
                }
                if (CallChecker.beforeDeref(Boolean.TRUE, Boolean.class, 574, 21388, 21399)) {
                    if (!(CallChecker.isCalled(Boolean.TRUE, Boolean.class, 574, 21388, 21399).equals(isPrototype))) {
                        usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 576, 21493, 21498);
                        for (int i = 0; (usages != null) && (i < (CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 576, 21493, 21498).length)); i++) {
                            usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 578, 21556, 21561);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 578, 21556, 21561)[i], ServiceRegistry.UsageCount.class, 578, 21556, 21564)) {
                                usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 578, 21556, 21561);
                                CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 578, 21556, 21561)[i] = CallChecker.beforeCalled(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 578, 21556, 21561)[i], ServiceRegistry.UsageCount.class, 578, 21556, 21564);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 578, 21556, 21561)[i], ServiceRegistry.UsageCount.class, 578, 21556, 21564).m_ref, ServiceReference.class, 578, 21556, 21570)) {
                                    usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 579, 21631, 21636);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 579, 21631, 21636)[i], ServiceRegistry.UsageCount.class, 579, 21631, 21639)) {
                                        usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 579, 21657, 21662);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 579, 21657, 21662)[i], ServiceRegistry.UsageCount.class, 579, 21657, 21665)) {
                                            usages[i] = CallChecker.beforeCalled(usages[i], ServiceRegistry.UsageCount.class, 578, 21556, 21564);
                                            usages[i] = CallChecker.beforeCalled(usages[i], ServiceRegistry.UsageCount.class, 579, 21631, 21639);
                                            usages[i] = CallChecker.beforeCalled(usages[i], ServiceRegistry.UsageCount.class, 579, 21657, 21665);
                                            if ((CallChecker.isCalled(CallChecker.isCalled(usages[i], ServiceRegistry.UsageCount.class, 578, 21556, 21564).m_ref, ServiceReference.class, 578, 21556, 21570).equals(ref)) && (((svcObj == null) && (!(CallChecker.isCalled(usages[i], ServiceRegistry.UsageCount.class, 579, 21631, 21639).m_prototype))) || ((CallChecker.isCalled(usages[i], ServiceRegistry.UsageCount.class, 579, 21657, 21665).getService()) == svcObj))) {
                                                return usages[i];
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
                }else
                    throw new AbnormalExecutionError();
                
                if (isPrototype == null) {
                    return null;
                }
                usage = new ServiceRegistry.UsageCount(ref, isPrototype);
                CallChecker.varAssign(usage, "usage", 595, 22204, 22244);
                if (usages == null) {
                    ServiceRegistry.UsageCount[] newUsages = CallChecker.varInit(new ServiceRegistry.UsageCount[]{ usage }, "newUsages", 598, 22308, 22359);
                    if (CallChecker.beforeDeref(m_inUseMap, ConcurrentMap.class, 599, 22387, 22396)) {
                        success = (CallChecker.isCalled(m_inUseMap, ConcurrentMap.class, 599, 22387, 22396).putIfAbsent(bundle, newUsages)) == null;
                        CallChecker.varAssign(success, "success", 599, 22377, 22436);
                    }
                }else {
                    ServiceRegistry.UsageCount[] newUsages = CallChecker.varInit(new ServiceRegistry.UsageCount[(usages.length) + 1], "newUsages", 603, 22499, 22557);
                    System.arraycopy(usages, 0, newUsages, 0, usages.length);
                    if (CallChecker.beforeDeref(newUsages, ServiceRegistry.UsageCount[].class, 605, 22649, 22657)) {
                        newUsages = CallChecker.beforeCalled(newUsages, ServiceRegistry.UsageCount[].class, 605, 22649, 22657);
                        CallChecker.isCalled(newUsages, ServiceRegistry.UsageCount[].class, 605, 22649, 22657)[usages.length] = usage;
                        CallChecker.varAssign(CallChecker.isCalled(newUsages, ServiceRegistry.UsageCount[].class, 605, 22649, 22657)[usages.length], "CallChecker.isCalled(newUsages, ServiceRegistry.UsageCount[].class, 605, 22649, 22657)[usages.length]", 605, 22649, 22681);
                    }
                    if (CallChecker.beforeDeref(m_inUseMap, ConcurrentMap.class, 606, 22709, 22718)) {
                        success = CallChecker.isCalled(m_inUseMap, ConcurrentMap.class, 606, 22709, 22718).replace(bundle, usages, newUsages);
                        CallChecker.varAssign(success, "success", 606, 22699, 22754);
                    }
                }
            } 
            return usage;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceRegistry.UsageCount) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context501.methodEnd();
        }
    }

    void flushUsageCount(Bundle bundle, ServiceReference<?> ref, ServiceRegistry.UsageCount uc) {
        MethodContext _bcornu_methode_context502 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 624, 22813, 25422);
            CallChecker.varInit(uc, "uc", 624, 22813, 25422);
            CallChecker.varInit(ref, "ref", 624, 22813, 25422);
            CallChecker.varInit(bundle, "bundle", 624, 22813, 25422);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 624, 22813, 25422);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 624, 22813, 25422);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 624, 22813, 25422);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 624, 22813, 25422);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 624, 22813, 25422);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 624, 22813, 25422);
            CallChecker.varInit(this.m_logger, "m_logger", 624, 22813, 25422);
            boolean success = CallChecker.varInit(((boolean) (false)), "success", 629, 23862, 23885);
            while (!success) {
                ServiceRegistry.UsageCount[] usages = CallChecker.init(ServiceRegistry.UsageCount[].class);
                if (CallChecker.beforeDeref(m_inUseMap, ConcurrentMap.class, 632, 23956, 23965)) {
                    usages = CallChecker.isCalled(m_inUseMap, ConcurrentMap.class, 632, 23956, 23965).get(bundle);
                    CallChecker.varAssign(usages, "usages", 632, 23956, 23965);
                }
                final ServiceRegistry.UsageCount[] orgUsages = CallChecker.varInit(usages, "orgUsages", 633, 23992, 24029);
                usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 634, 24084, 24089);
                for (int i = 0; (usages != null) && (i < (CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 634, 24084, 24089).length)); i++) {
                    usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 636, 24154, 24159);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 636, 24154, 24159)[i], ServiceRegistry.UsageCount.class, 636, 24154, 24162)) {
                        usages = CallChecker.beforeCalled(usages, ServiceRegistry.UsageCount[].class, 636, 24154, 24159);
                        CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 636, 24154, 24159)[i] = CallChecker.beforeCalled(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 636, 24154, 24159)[i], ServiceRegistry.UsageCount.class, 636, 24154, 24162);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(usages, ServiceRegistry.UsageCount[].class, 636, 24154, 24159)[i], ServiceRegistry.UsageCount.class, 636, 24154, 24162).m_ref, ServiceReference.class, 636, 24154, 24168)) {
                            usages[i] = CallChecker.beforeCalled(usages[i], ServiceRegistry.UsageCount.class, 636, 24154, 24162);
                            if (((uc == null) && (CallChecker.isCalled(CallChecker.isCalled(usages[i], ServiceRegistry.UsageCount.class, 636, 24154, 24162).m_ref, ServiceReference.class, 636, 24154, 24168).equals(ref))) || (uc == (usages[i]))) {
                                if (((usages.length) - 1) == 0) {
                                    usages = null;
                                    CallChecker.varAssign(usages, "usages", 641, 24395, 24408);
                                }else {
                                    ServiceRegistry.UsageCount[] newUsages = CallChecker.varInit(new ServiceRegistry.UsageCount[(usages.length) - 1], "newUsages", 646, 24571, 24629);
                                    System.arraycopy(usages, 0, newUsages, 0, i);
                                    if (CallChecker.beforeDeref(newUsages, ServiceRegistry.UsageCount[].class, 648, 24733, 24741)) {
                                        newUsages = CallChecker.beforeCalled(newUsages, ServiceRegistry.UsageCount[].class, 648, 24733, 24741);
                                        if (i < (CallChecker.isCalled(newUsages, ServiceRegistry.UsageCount[].class, 648, 24733, 24741).length)) {
                                            if (CallChecker.beforeDeref(newUsages, ServiceRegistry.UsageCount[].class, 651, 24884, 24892)) {
                                                newUsages = CallChecker.beforeCalled(newUsages, ServiceRegistry.UsageCount[].class, 651, 24884, 24892);
                                                System.arraycopy(usages, (i + 1), newUsages, i, ((CallChecker.isCalled(newUsages, ServiceRegistry.UsageCount[].class, 651, 24884, 24892).length) - i));
                                            }
                                        }
                                    }
                                    usages = newUsages;
                                    CallChecker.varAssign(usages, "usages", 653, 24957, 24975);
                                    i--;
                                }
                            }
                        }
                    }
                }
                if (usages == orgUsages)
                    return ;
                
                if (orgUsages != null) {
                    if (usages != null)
                        if (CallChecker.beforeDeref(m_inUseMap, ConcurrentMap.class, 665, 25258, 25267)) {
                            success = CallChecker.isCalled(m_inUseMap, ConcurrentMap.class, 665, 25258, 25267).replace(bundle, orgUsages, usages);
                            CallChecker.varAssign(success, "success", 665, 25248, 25303);
                        }
                    else
                        if (CallChecker.beforeDeref(m_inUseMap, ConcurrentMap.class, 667, 25356, 25365)) {
                            success = CallChecker.isCalled(m_inUseMap, ConcurrentMap.class, 667, 25356, 25365).remove(bundle, orgUsages);
                            CallChecker.varAssign(success, "success", 667, 25346, 25392);
                        }
                    
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context502.methodEnd();
        }
    }

    public HookRegistry getHookRegistry() {
        MethodContext _bcornu_methode_context503 = new MethodContext(HookRegistry.class);
        try {
            CallChecker.varInit(this, "this", 672, 25429, 25511);
            CallChecker.varInit(this.hookRegistry, "hookRegistry", 672, 25429, 25511);
            CallChecker.varInit(this.m_callbacks, "m_callbacks", 672, 25429, 25511);
            CallChecker.varInit(this.m_inUseMap, "m_inUseMap", 672, 25429, 25511);
            CallChecker.varInit(this.m_regCapSet, "m_regCapSet", 672, 25429, 25511);
            CallChecker.varInit(this.m_regsMap, "m_regsMap", 672, 25429, 25511);
            CallChecker.varInit(this.m_currentServiceId, "m_currentServiceId", 672, 25429, 25511);
            CallChecker.varInit(this.m_logger, "m_logger", 672, 25429, 25511);
            return this.hookRegistry;
        } catch (ForceReturn _bcornu_return_t) {
            return ((HookRegistry) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context503.methodEnd();
        }
    }

    static class UsageCount {
        final ServiceReference<?> m_ref;

        final boolean m_prototype;

        final AtomicLong m_count = new AtomicLong();

        final AtomicLong m_serviceObjectsCount = new AtomicLong();

        final AtomicReference<ServiceRegistry.ServiceHolder> m_svcHolderRef = new AtomicReference<ServiceRegistry.ServiceHolder>();

        UsageCount(final ServiceReference<?> ref, final boolean isPrototype) {
            MethodContext _bcornu_methode_context39 = new MethodContext(null);
            try {
                m_ref = ref;
                CallChecker.varAssign(this.m_ref, "this.m_ref", 688, 25945, 25956);
                m_prototype = isPrototype;
                CallChecker.varAssign(this.m_prototype, "this.m_prototype", 689, 25970, 25995);
            } finally {
                _bcornu_methode_context39.methodEnd();
            }
        }

        Object getService() {
            MethodContext _bcornu_methode_context504 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 692, 26016, 26160);
                CallChecker.varInit(this.m_svcHolderRef, "m_svcHolderRef", 692, 26016, 26160);
                CallChecker.varInit(this.m_serviceObjectsCount, "m_serviceObjectsCount", 692, 26016, 26160);
                CallChecker.varInit(this.m_count, "m_count", 692, 26016, 26160);
                CallChecker.varInit(this.m_prototype, "m_prototype", 692, 26016, 26160);
                CallChecker.varInit(this.m_ref, "m_ref", 692, 26016, 26160);
                ServiceRegistry.ServiceHolder sh = CallChecker.init(ServiceRegistry.ServiceHolder.class);
                if (CallChecker.beforeDeref(m_svcHolderRef, AtomicReference.class, 694, 26077, 26090)) {
                    sh = CallChecker.isCalled(m_svcHolderRef, AtomicReference.class, 694, 26077, 26090).get();
                    CallChecker.varAssign(sh, "sh", 694, 26077, 26090);
                }
                if (sh == null) {
                    return null;
                }else {
                    return sh.m_service;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context504.methodEnd();
            }
        }
    }

    static class ServiceHolder {
        final CountDownLatch m_latch = new CountDownLatch(1);

        volatile Object m_service;
    }

    public interface ServiceRegistryCallbacks {
        void serviceChanged(ServiceEvent event, Dictionary<?, ?> oldProps);
    }
}

