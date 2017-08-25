package org.apache.felix.framework;

import fr.inria.spirals.npefix.resi.context.TryContext;
import org.osgi.framework.SynchronousBundleListener;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServicePermission;
import org.osgi.framework.ServiceObjects;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceFactory;
import java.util.PropertyPermission;
import org.osgi.framework.Constants;
import java.util.Collections;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.BundleListener;
import org.osgi.framework.BundleException;
import org.osgi.framework.Bundle;
import java.util.Arrays;
import org.osgi.framework.AdminPermission;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Dictionary;
import org.apache.felix.framework.ext.FelixBundleContext;
import java.io.File;
import org.osgi.framework.Filter;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.framework.FrameworkListener;
import java.io.InputStream;
import org.osgi.framework.InvalidSyntaxException;
import fr.inria.spirals.npefix.resi.context.MethodContext;

class BundleContextImpl implements FelixBundleContext {
    private Logger m_logger = null;

    private Felix m_felix = null;

    private BundleImpl m_bundle = null;

    private boolean m_valid = true;

    protected BundleContextImpl(Logger logger, Felix felix, BundleImpl bundle) {
        MethodContext _bcornu_methode_context137 = new MethodContext(null);
        try {
            m_logger = logger;
            CallChecker.varAssign(this.m_logger, "this.m_logger", 54, 2007, 2024);
            m_felix = felix;
            CallChecker.varAssign(this.m_felix, "this.m_felix", 55, 2034, 2049);
            m_bundle = bundle;
            CallChecker.varAssign(this.m_bundle, "this.m_bundle", 56, 2059, 2076);
        } finally {
            _bcornu_methode_context137.methodEnd();
        }
    }

    protected void invalidate() {
        MethodContext _bcornu_methode_context1387 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 59, 2089, 2152);
            CallChecker.varInit(this.m_valid, "m_valid", 59, 2089, 2152);
            CallChecker.varInit(this.m_bundle, "m_bundle", 59, 2089, 2152);
            CallChecker.varInit(this.m_felix, "m_felix", 59, 2089, 2152);
            CallChecker.varInit(this.m_logger, "m_logger", 59, 2089, 2152);
            m_valid = false;
            CallChecker.varAssign(this.m_valid, "this.m_valid", 61, 2131, 2146);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1387.methodEnd();
        }
    }

    public void addRequirement(String s) throws BundleException {
        MethodContext _bcornu_methode_context1388 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 64, 2159, 2288);
            CallChecker.varInit(s, "s", 64, 2159, 2288);
            CallChecker.varInit(this.m_valid, "m_valid", 64, 2159, 2288);
            CallChecker.varInit(this.m_bundle, "m_bundle", 64, 2159, 2288);
            CallChecker.varInit(this.m_felix, "m_felix", 64, 2159, 2288);
            CallChecker.varInit(this.m_logger, "m_logger", 64, 2159, 2288);
            throw new BundleException("Not implemented yet.");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1388.methodEnd();
        }
    }

    public void removeRequirement() throws BundleException {
        MethodContext _bcornu_methode_context1389 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 69, 2295, 2419);
            CallChecker.varInit(this.m_valid, "m_valid", 69, 2295, 2419);
            CallChecker.varInit(this.m_bundle, "m_bundle", 69, 2295, 2419);
            CallChecker.varInit(this.m_felix, "m_felix", 69, 2295, 2419);
            CallChecker.varInit(this.m_logger, "m_logger", 69, 2295, 2419);
            throw new BundleException("Not implemented yet.");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1389.methodEnd();
        }
    }

    public void addCapability() throws BundleException {
        MethodContext _bcornu_methode_context1390 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 74, 2426, 2546);
            CallChecker.varInit(this.m_valid, "m_valid", 74, 2426, 2546);
            CallChecker.varInit(this.m_bundle, "m_bundle", 74, 2426, 2546);
            CallChecker.varInit(this.m_felix, "m_felix", 74, 2426, 2546);
            CallChecker.varInit(this.m_logger, "m_logger", 74, 2426, 2546);
            throw new BundleException("Not implemented yet.");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1390.methodEnd();
        }
    }

    public void removeCapability() throws BundleException {
        MethodContext _bcornu_methode_context1391 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 79, 2553, 2676);
            CallChecker.varInit(this.m_valid, "m_valid", 79, 2553, 2676);
            CallChecker.varInit(this.m_bundle, "m_bundle", 79, 2553, 2676);
            CallChecker.varInit(this.m_felix, "m_felix", 79, 2553, 2676);
            CallChecker.varInit(this.m_logger, "m_logger", 79, 2553, 2676);
            throw new BundleException("Not implemented yet.");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1391.methodEnd();
        }
    }

    public String getProperty(String name) {
        MethodContext _bcornu_methode_context1392 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 84, 2683, 3640);
            CallChecker.varInit(name, "name", 84, 2683, 3640);
            CallChecker.varInit(this.m_valid, "m_valid", 84, 2683, 3640);
            CallChecker.varInit(this.m_bundle, "m_bundle", 84, 2683, 3640);
            CallChecker.varInit(this.m_felix, "m_felix", 84, 2683, 3640);
            CallChecker.varInit(this.m_logger, "m_logger", 84, 2683, 3640);
            checkValidity();
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 93, 2989, 3028);
            if (sm != null) {
                if (CallChecker.beforeDeref(Constants.FRAMEWORK_VERSION, String.class, 97, 3083, 3109)) {
                    if (CallChecker.beforeDeref(Constants.FRAMEWORK_VENDOR, String.class, 98, 3143, 3168)) {
                        if (CallChecker.beforeDeref(Constants.FRAMEWORK_LANGUAGE, String.class, 99, 3202, 3229)) {
                            if (CallChecker.beforeDeref(Constants.FRAMEWORK_OS_NAME, String.class, 100, 3262, 3288)) {
                                if (CallChecker.beforeDeref(Constants.FRAMEWORK_OS_VERSION, String.class, 101, 3322, 3351)) {
                                    if (CallChecker.beforeDeref(Constants.FRAMEWORK_PROCESSOR, String.class, 102, 3385, 3413)) {
                                        if (!((((((CallChecker.isCalled(Constants.FRAMEWORK_VERSION, String.class, 97, 3083, 3109).equals(name)) || (CallChecker.isCalled(Constants.FRAMEWORK_VENDOR, String.class, 98, 3143, 3168).equals(name))) || (CallChecker.isCalled(Constants.FRAMEWORK_LANGUAGE, String.class, 99, 3202, 3229).equals(name))) || (CallChecker.isCalled(Constants.FRAMEWORK_OS_NAME, String.class, 100, 3262, 3288).equals(name))) || (CallChecker.isCalled(Constants.FRAMEWORK_OS_VERSION, String.class, 101, 3322, 3351).equals(name))) || (CallChecker.isCalled(Constants.FRAMEWORK_PROCESSOR, String.class, 102, 3385, 3413).equals(name)))) {
                                            ((SecurityManager) (sm)).checkPermission(new PropertyPermission(name, "read"));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m_felix, Felix.class, 109, 3609, 3615)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 109, 3609, 3615);
                return CallChecker.isCalled(m_felix, Felix.class, 109, 3609, 3615).getProperty(name);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1392.methodEnd();
        }
    }

    public Bundle getBundle() {
        MethodContext _bcornu_methode_context1393 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 112, 3647, 3961);
            CallChecker.varInit(this.m_valid, "m_valid", 112, 3647, 3961);
            CallChecker.varInit(this.m_bundle, "m_bundle", 112, 3647, 3961);
            CallChecker.varInit(this.m_felix, "m_felix", 112, 3647, 3961);
            CallChecker.varInit(this.m_logger, "m_logger", 112, 3647, 3961);
            checkValidity();
            return m_bundle;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1393.methodEnd();
        }
    }

    public Filter createFilter(String expr) throws InvalidSyntaxException {
        MethodContext _bcornu_methode_context1394 = new MethodContext(Filter.class);
        try {
            CallChecker.varInit(this, "this", 124, 3968, 4346);
            CallChecker.varInit(expr, "expr", 124, 3968, 4346);
            CallChecker.varInit(this.m_valid, "m_valid", 124, 3968, 4346);
            CallChecker.varInit(this.m_bundle, "m_bundle", 124, 3968, 4346);
            CallChecker.varInit(this.m_felix, "m_felix", 124, 3968, 4346);
            CallChecker.varInit(this.m_logger, "m_logger", 124, 3968, 4346);
            checkValidity();
            return new FilterImpl(expr);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Filter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1394.methodEnd();
        }
    }

    public Bundle installBundle(String location) throws BundleException {
        MethodContext _bcornu_methode_context1395 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 137, 4353, 4485);
            CallChecker.varInit(location, "location", 137, 4353, 4485);
            CallChecker.varInit(this.m_valid, "m_valid", 137, 4353, 4485);
            CallChecker.varInit(this.m_bundle, "m_bundle", 137, 4353, 4485);
            CallChecker.varInit(this.m_felix, "m_felix", 137, 4353, 4485);
            CallChecker.varInit(this.m_logger, "m_logger", 137, 4353, 4485);
            return installBundle(location, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1395.methodEnd();
        }
    }

    public Bundle installBundle(String location, InputStream is) throws BundleException {
        MethodContext _bcornu_methode_context1396 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 143, 4492, 5385);
            CallChecker.varInit(is, "is", 143, 4492, 5385);
            CallChecker.varInit(location, "location", 143, 4492, 5385);
            CallChecker.varInit(this.m_valid, "m_valid", 143, 4492, 5385);
            CallChecker.varInit(this.m_bundle, "m_bundle", 143, 4492, 5385);
            CallChecker.varInit(this.m_felix, "m_felix", 143, 4492, 5385);
            CallChecker.varInit(this.m_logger, "m_logger", 143, 4492, 5385);
            checkValidity();
            Bundle result = CallChecker.varInit(null, "result", 153, 4851, 4871);
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 155, 4882, 4921);
            if (sm != null) {
                if (CallChecker.beforeDeref(m_felix, Felix.class, 159, 4979, 4985)) {
                    m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 159, 4979, 4985);
                    result = CallChecker.isCalled(m_felix, Felix.class, 159, 4979, 4985).installBundle(m_bundle, location, is);
                    CallChecker.varAssign(result, "result", 159, 4970, 5024);
                }
                ((SecurityManager) (sm)).checkPermission(new AdminPermission(result, AdminPermission.LIFECYCLE));
            }else {
                if (CallChecker.beforeDeref(m_felix, Felix.class, 167, 5300, 5306)) {
                    m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 167, 5300, 5306);
                    result = CallChecker.isCalled(m_felix, Felix.class, 167, 5300, 5306).installBundle(m_bundle, location, is);
                    CallChecker.varAssign(result, "result", 167, 5291, 5345);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1396.methodEnd();
        }
    }

    public Bundle getBundle(long id) {
        MethodContext _bcornu_methode_context1397 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 173, 5392, 5732);
            CallChecker.varInit(id, "id", 173, 5392, 5732);
            CallChecker.varInit(this.m_valid, "m_valid", 173, 5392, 5732);
            CallChecker.varInit(this.m_bundle, "m_bundle", 173, 5392, 5732);
            CallChecker.varInit(this.m_felix, "m_felix", 173, 5392, 5732);
            CallChecker.varInit(this.m_logger, "m_logger", 173, 5392, 5732);
            checkValidity();
            if (CallChecker.beforeDeref(m_felix, Felix.class, 182, 5699, 5705)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 182, 5699, 5705);
                return CallChecker.isCalled(m_felix, Felix.class, 182, 5699, 5705).getBundle(this, id);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1397.methodEnd();
        }
    }

    public Bundle getBundle(String location) {
        MethodContext _bcornu_methode_context1398 = new MethodContext(Bundle.class);
        try {
            CallChecker.varInit(this, "this", 185, 5739, 6087);
            CallChecker.varInit(location, "location", 185, 5739, 6087);
            CallChecker.varInit(this.m_valid, "m_valid", 185, 5739, 6087);
            CallChecker.varInit(this.m_bundle, "m_bundle", 185, 5739, 6087);
            CallChecker.varInit(this.m_felix, "m_felix", 185, 5739, 6087);
            CallChecker.varInit(this.m_logger, "m_logger", 185, 5739, 6087);
            checkValidity();
            if (CallChecker.beforeDeref(m_felix, Felix.class, 194, 6054, 6060)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 194, 6054, 6060);
                return CallChecker.isCalled(m_felix, Felix.class, 194, 6054, 6060).getBundle(location);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1398.methodEnd();
        }
    }

    public Bundle[] getBundles() {
        MethodContext _bcornu_methode_context1399 = new MethodContext(Bundle[].class);
        try {
            CallChecker.varInit(this, "this", 197, 6094, 6427);
            CallChecker.varInit(this.m_valid, "m_valid", 197, 6094, 6427);
            CallChecker.varInit(this.m_bundle, "m_bundle", 197, 6094, 6427);
            CallChecker.varInit(this.m_felix, "m_felix", 197, 6094, 6427);
            CallChecker.varInit(this.m_logger, "m_logger", 197, 6094, 6427);
            checkValidity();
            if (CallChecker.beforeDeref(m_felix, Felix.class, 206, 6397, 6403)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 206, 6397, 6403);
                return CallChecker.isCalled(m_felix, Felix.class, 206, 6397, 6403).getBundles(this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1399.methodEnd();
        }
    }

    public void addBundleListener(BundleListener l) {
        MethodContext _bcornu_methode_context1400 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 209, 6434, 7187);
            CallChecker.varInit(l, "l", 209, 6434, 7187);
            CallChecker.varInit(this.m_valid, "m_valid", 209, 6434, 7187);
            CallChecker.varInit(this.m_bundle, "m_bundle", 209, 6434, 7187);
            CallChecker.varInit(this.m_felix, "m_felix", 209, 6434, 7187);
            CallChecker.varInit(this.m_logger, "m_logger", 209, 6434, 7187);
            checkValidity();
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 219, 6831, 6870);
            if (sm != null) {
                if (l instanceof SynchronousBundleListener) {
                    ((SecurityManager) (sm)).checkPermission(new AdminPermission(m_bundle, AdminPermission.LISTENER));
                }
            }
            if (CallChecker.beforeDeref(m_felix, Felix.class, 230, 7143, 7149)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 230, 7143, 7149);
                CallChecker.isCalled(m_felix, Felix.class, 230, 7143, 7149).addBundleListener(m_bundle, l);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1400.methodEnd();
        }
    }

    public void removeBundleListener(BundleListener l) {
        MethodContext _bcornu_methode_context1401 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 233, 7194, 7871);
            CallChecker.varInit(l, "l", 233, 7194, 7871);
            CallChecker.varInit(this.m_valid, "m_valid", 233, 7194, 7871);
            CallChecker.varInit(this.m_bundle, "m_bundle", 233, 7194, 7871);
            CallChecker.varInit(this.m_felix, "m_felix", 233, 7194, 7871);
            CallChecker.varInit(this.m_logger, "m_logger", 233, 7194, 7871);
            checkValidity();
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 242, 7512, 7551);
            if (sm != null) {
                if (l instanceof SynchronousBundleListener) {
                    ((SecurityManager) (sm)).checkPermission(new AdminPermission(m_bundle, AdminPermission.LISTENER));
                }
            }
            if (CallChecker.beforeDeref(m_felix, Felix.class, 253, 7824, 7830)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 253, 7824, 7830);
                CallChecker.isCalled(m_felix, Felix.class, 253, 7824, 7830).removeBundleListener(m_bundle, l);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1401.methodEnd();
        }
    }

    public void addServiceListener(ServiceListener l) {
        MethodContext _bcornu_methode_context1402 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 256, 7878, 8135);
            CallChecker.varInit(l, "l", 256, 7878, 8135);
            CallChecker.varInit(this.m_valid, "m_valid", 256, 7878, 8135);
            CallChecker.varInit(this.m_bundle, "m_bundle", 256, 7878, 8135);
            CallChecker.varInit(this.m_felix, "m_felix", 256, 7878, 8135);
            CallChecker.varInit(this.m_logger, "m_logger", 256, 7878, 8135);
            TryContext _bcornu_try_context_394 = new TryContext(394, BundleContextImpl.class, "org.osgi.framework.InvalidSyntaxException");
            try {
                addServiceListener(l, null);
            } catch (InvalidSyntaxException ex) {
                _bcornu_try_context_394.catchStart(394);
            } finally {
                _bcornu_try_context_394.finallyStart(394);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1402.methodEnd();
        }
    }

    public void addServiceListener(ServiceListener l, String s) throws InvalidSyntaxException {
        MethodContext _bcornu_methode_context1403 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 268, 8142, 8637);
            CallChecker.varInit(s, "s", 268, 8142, 8637);
            CallChecker.varInit(l, "l", 268, 8142, 8637);
            CallChecker.varInit(this.m_valid, "m_valid", 268, 8142, 8637);
            CallChecker.varInit(this.m_bundle, "m_bundle", 268, 8142, 8637);
            CallChecker.varInit(this.m_felix, "m_felix", 268, 8142, 8637);
            CallChecker.varInit(this.m_logger, "m_logger", 268, 8142, 8637);
            checkValidity();
            if (CallChecker.beforeDeref(m_felix, Felix.class, 279, 8589, 8595)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 279, 8589, 8595);
                CallChecker.isCalled(m_felix, Felix.class, 279, 8589, 8595).addServiceListener(m_bundle, l, s);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1403.methodEnd();
        }
    }

    public void removeServiceListener(ServiceListener l) {
        MethodContext _bcornu_methode_context1404 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 282, 8644, 9012);
            CallChecker.varInit(l, "l", 282, 8644, 9012);
            CallChecker.varInit(this.m_valid, "m_valid", 282, 8644, 9012);
            CallChecker.varInit(this.m_bundle, "m_bundle", 282, 8644, 9012);
            CallChecker.varInit(this.m_felix, "m_felix", 282, 8644, 9012);
            CallChecker.varInit(this.m_logger, "m_logger", 282, 8644, 9012);
            checkValidity();
            if (CallChecker.beforeDeref(m_felix, Felix.class, 291, 8964, 8970)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 291, 8964, 8970);
                CallChecker.isCalled(m_felix, Felix.class, 291, 8964, 8970).removeServiceListener(m_bundle, l);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1404.methodEnd();
        }
    }

    public void addFrameworkListener(FrameworkListener l) {
        MethodContext _bcornu_methode_context1405 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 294, 9019, 9469);
            CallChecker.varInit(l, "l", 294, 9019, 9469);
            CallChecker.varInit(this.m_valid, "m_valid", 294, 9019, 9469);
            CallChecker.varInit(this.m_bundle, "m_bundle", 294, 9019, 9469);
            CallChecker.varInit(this.m_felix, "m_felix", 294, 9019, 9469);
            CallChecker.varInit(this.m_logger, "m_logger", 294, 9019, 9469);
            checkValidity();
            if (CallChecker.beforeDeref(m_felix, Felix.class, 304, 9422, 9428)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 304, 9422, 9428);
                CallChecker.isCalled(m_felix, Felix.class, 304, 9422, 9428).addFrameworkListener(m_bundle, l);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1405.methodEnd();
        }
    }

    public void removeFrameworkListener(FrameworkListener l) {
        MethodContext _bcornu_methode_context1406 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 307, 9476, 9850);
            CallChecker.varInit(l, "l", 307, 9476, 9850);
            CallChecker.varInit(this.m_valid, "m_valid", 307, 9476, 9850);
            CallChecker.varInit(this.m_bundle, "m_bundle", 307, 9476, 9850);
            CallChecker.varInit(this.m_felix, "m_felix", 307, 9476, 9850);
            CallChecker.varInit(this.m_logger, "m_logger", 307, 9476, 9850);
            checkValidity();
            if (CallChecker.beforeDeref(m_felix, Felix.class, 316, 9800, 9806)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 316, 9800, 9806);
                CallChecker.isCalled(m_felix, Felix.class, 316, 9800, 9806).removeFrameworkListener(m_bundle, l);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1406.methodEnd();
        }
    }

    public ServiceRegistration<?> registerService(String clazz, Object svcObj, Dictionary<String, ?> dict) {
        MethodContext _bcornu_methode_context1407 = new MethodContext(ServiceRegistration.class);
        try {
            CallChecker.varInit(this, "this", 319, 9857, 10050);
            CallChecker.varInit(dict, "dict", 319, 9857, 10050);
            CallChecker.varInit(svcObj, "svcObj", 319, 9857, 10050);
            CallChecker.varInit(clazz, "clazz", 319, 9857, 10050);
            CallChecker.varInit(this.m_valid, "m_valid", 319, 9857, 10050);
            CallChecker.varInit(this.m_bundle, "m_bundle", 319, 9857, 10050);
            CallChecker.varInit(this.m_felix, "m_felix", 319, 9857, 10050);
            CallChecker.varInit(this.m_logger, "m_logger", 319, 9857, 10050);
            return registerService(new String[]{ clazz }, svcObj, dict);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceRegistration<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1407.methodEnd();
        }
    }

    public ServiceRegistration<?> registerService(String[] clazzes, Object svcObj, Dictionary<String, ?> dict) {
        MethodContext _bcornu_methode_context1408 = new MethodContext(ServiceRegistration.class);
        try {
            CallChecker.varInit(this, "this", 325, 10057, 10861);
            CallChecker.varInit(dict, "dict", 325, 10057, 10861);
            CallChecker.varInit(svcObj, "svcObj", 325, 10057, 10861);
            CallChecker.varInit(clazzes, "clazzes", 325, 10057, 10861);
            CallChecker.varInit(this.m_valid, "m_valid", 325, 10057, 10861);
            CallChecker.varInit(this.m_bundle, "m_bundle", 325, 10057, 10861);
            CallChecker.varInit(this.m_felix, "m_felix", 325, 10057, 10861);
            CallChecker.varInit(this.m_logger, "m_logger", 325, 10057, 10861);
            checkValidity();
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 334, 10401, 10440);
            if (sm != null) {
                if (clazzes != null) {
                    for (int i = 0; i < (clazzes.length); i++) {
                        ((SecurityManager) (sm)).checkPermission(new ServicePermission(clazzes[i], ServicePermission.REGISTER));
                    }
                }
            }
            if (CallChecker.beforeDeref(m_felix, Felix.class, 348, 10803, 10809)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 348, 10803, 10809);
                return CallChecker.isCalled(m_felix, Felix.class, 348, 10803, 10809).registerService(this, clazzes, svcObj, dict);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceRegistration<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1408.methodEnd();
        }
    }

    public <S> ServiceRegistration<S> registerService(Class<S> clazz, S svcObj, Dictionary<String, ?> dict) {
        MethodContext _bcornu_methode_context1409 = new MethodContext(ServiceRegistration.class);
        try {
            CallChecker.varInit(this, "this", 351, 10868, 11109);
            CallChecker.varInit(dict, "dict", 351, 10868, 11109);
            CallChecker.varInit(svcObj, "svcObj", 351, 10868, 11109);
            CallChecker.varInit(clazz, "clazz", 351, 10868, 11109);
            CallChecker.varInit(this.m_valid, "m_valid", 351, 10868, 11109);
            CallChecker.varInit(this.m_bundle, "m_bundle", 351, 10868, 11109);
            CallChecker.varInit(this.m_felix, "m_felix", 351, 10868, 11109);
            CallChecker.varInit(this.m_logger, "m_logger", 351, 10868, 11109);
            if (CallChecker.beforeDeref(clazz, Class.class, 355, 11071, 11075)) {
                clazz = CallChecker.beforeCalled(clazz, Class.class, 355, 11071, 11075);
                return ((ServiceRegistration<S>) (registerService(new String[]{ CallChecker.isCalled(clazz, Class.class, 355, 11071, 11075).getName() }, svcObj, dict)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceRegistration<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1409.methodEnd();
        }
    }

    public ServiceReference<?> getServiceReference(String clazz) {
        MethodContext _bcornu_methode_context1410 = new MethodContext(ServiceReference.class);
        try {
            CallChecker.varInit(this, "this", 358, 11116, 11760);
            CallChecker.varInit(clazz, "clazz", 358, 11116, 11760);
            CallChecker.varInit(this.m_valid, "m_valid", 358, 11116, 11760);
            CallChecker.varInit(this.m_bundle, "m_bundle", 358, 11116, 11760);
            CallChecker.varInit(this.m_felix, "m_felix", 358, 11116, 11760);
            CallChecker.varInit(this.m_logger, "m_logger", 358, 11116, 11760);
            checkValidity();
            TryContext _bcornu_try_context_395 = new TryContext(395, BundleContextImpl.class, "org.osgi.framework.InvalidSyntaxException");
            try {
                ServiceReference[] refs = CallChecker.varInit(getServiceReferences(clazz, null), "refs", 369, 11470, 11529);
                return getBestServiceReference(refs);
            } catch (InvalidSyntaxException ex) {
                _bcornu_try_context_395.catchStart(395);
                if (CallChecker.beforeDeref(m_logger, Logger.class, 374, 11655, 11662)) {
                    m_logger = CallChecker.beforeCalled(m_logger, Logger.class, 374, 11655, 11662);
                    CallChecker.isCalled(m_logger, Logger.class, 374, 11655, 11662).log(m_bundle, Logger.LOG_ERROR, ("BundleContextImpl: " + ex));
                }
            } finally {
                _bcornu_try_context_395.finallyStart(395);
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1410.methodEnd();
        }
    }

    public <S> ServiceReference<S> getServiceReference(Class<S> clazz) {
        MethodContext _bcornu_methode_context1411 = new MethodContext(ServiceReference.class);
        try {
            CallChecker.varInit(this, "this", 379, 11767, 11919);
            CallChecker.varInit(clazz, "clazz", 379, 11767, 11919);
            CallChecker.varInit(this.m_valid, "m_valid", 379, 11767, 11919);
            CallChecker.varInit(this.m_bundle, "m_bundle", 379, 11767, 11919);
            CallChecker.varInit(this.m_felix, "m_felix", 379, 11767, 11919);
            CallChecker.varInit(this.m_logger, "m_logger", 379, 11767, 11919);
            if (CallChecker.beforeDeref(clazz, Class.class, 381, 11897, 11901)) {
                clazz = CallChecker.beforeCalled(clazz, Class.class, 381, 11897, 11901);
                return ((ServiceReference<S>) (getServiceReference(CallChecker.isCalled(clazz, Class.class, 381, 11897, 11901).getName())));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1411.methodEnd();
        }
    }

    private ServiceReference getBestServiceReference(ServiceReference[] refs) {
        MethodContext _bcornu_methode_context1412 = new MethodContext(ServiceReference.class);
        try {
            CallChecker.varInit(this, "this", 384, 11926, 12521);
            CallChecker.varInit(refs, "refs", 384, 11926, 12521);
            CallChecker.varInit(this.m_valid, "m_valid", 384, 11926, 12521);
            CallChecker.varInit(this.m_bundle, "m_bundle", 384, 11926, 12521);
            CallChecker.varInit(this.m_felix, "m_felix", 384, 11926, 12521);
            CallChecker.varInit(this.m_logger, "m_logger", 384, 11926, 12521);
            if (refs == null) {
                return null;
            }
            if ((refs.length) == 1) {
                return refs[0];
            }
            ServiceReference bestRef = CallChecker.varInit(refs[0], "bestRef", 398, 12279, 12313);
            for (int i = 1; i < (refs.length); i++) {
                if (CallChecker.beforeDeref(bestRef, ServiceReference.class, 401, 12387, 12393)) {
                    bestRef = CallChecker.beforeCalled(bestRef, ServiceReference.class, 401, 12387, 12393);
                    if ((CallChecker.isCalled(bestRef, ServiceReference.class, 401, 12387, 12393).compareTo(refs[i])) < 0) {
                        bestRef = refs[i];
                        CallChecker.varAssign(bestRef, "bestRef", 403, 12449, 12466);
                    }
                }
            }
            return bestRef;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1412.methodEnd();
        }
    }

    public ServiceReference<?>[] getAllServiceReferences(String clazz, String filter) throws InvalidSyntaxException {
        MethodContext _bcornu_methode_context1413 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 410, 12528, 12996);
            CallChecker.varInit(filter, "filter", 410, 12528, 12996);
            CallChecker.varInit(clazz, "clazz", 410, 12528, 12996);
            CallChecker.varInit(this.m_valid, "m_valid", 410, 12528, 12996);
            CallChecker.varInit(this.m_bundle, "m_bundle", 410, 12528, 12996);
            CallChecker.varInit(this.m_felix, "m_felix", 410, 12528, 12996);
            CallChecker.varInit(this.m_logger, "m_logger", 410, 12528, 12996);
            checkValidity();
            if (CallChecker.beforeDeref(m_felix, Felix.class, 420, 12922, 12928)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 420, 12922, 12928);
                return CallChecker.isCalled(m_felix, Felix.class, 420, 12922, 12928).getAllowedServiceReferences(m_bundle, clazz, filter, false);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1413.methodEnd();
        }
    }

    public ServiceReference<?>[] getServiceReferences(String clazz, String filter) throws InvalidSyntaxException {
        MethodContext _bcornu_methode_context1414 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 424, 13003, 13467);
            CallChecker.varInit(filter, "filter", 424, 13003, 13467);
            CallChecker.varInit(clazz, "clazz", 424, 13003, 13467);
            CallChecker.varInit(this.m_valid, "m_valid", 424, 13003, 13467);
            CallChecker.varInit(this.m_bundle, "m_bundle", 424, 13003, 13467);
            CallChecker.varInit(this.m_felix, "m_felix", 424, 13003, 13467);
            CallChecker.varInit(this.m_logger, "m_logger", 424, 13003, 13467);
            checkValidity();
            if (CallChecker.beforeDeref(m_felix, Felix.class, 434, 13394, 13400)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 434, 13394, 13400);
                return CallChecker.isCalled(m_felix, Felix.class, 434, 13394, 13400).getAllowedServiceReferences(m_bundle, clazz, filter, true);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1414.methodEnd();
        }
    }

    public <S> Collection<ServiceReference<S>> getServiceReferences(Class<S> clazz, String filter) throws InvalidSyntaxException {
        MethodContext _bcornu_methode_context1415 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 438, 13474, 13882);
            CallChecker.varInit(filter, "filter", 438, 13474, 13882);
            CallChecker.varInit(clazz, "clazz", 438, 13474, 13882);
            CallChecker.varInit(this.m_valid, "m_valid", 438, 13474, 13882);
            CallChecker.varInit(this.m_bundle, "m_bundle", 438, 13474, 13882);
            CallChecker.varInit(this.m_felix, "m_felix", 438, 13474, 13882);
            CallChecker.varInit(this.m_logger, "m_logger", 438, 13474, 13882);
            ServiceReference<S>[] refs = CallChecker.init(ServiceReference[].class);
            if (CallChecker.beforeDeref(clazz, Class.class, 443, 13716, 13720)) {
                clazz = CallChecker.beforeCalled(clazz, Class.class, 443, 13716, 13720);
                refs = ((ServiceReference<S>[]) (getServiceReferences(CallChecker.isCalled(clazz, Class.class, 443, 13716, 13720).getName(), filter)));
                CallChecker.varAssign(refs, "refs", 443, 13716, 13720);
            }
            if (refs == null) {
                return Collections.EMPTY_LIST;
            }else {
                return ((Collection<ServiceReference<S>>) (Arrays.asList(refs)));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<ServiceReference<S>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1415.methodEnd();
        }
    }

    public <S> S getService(ServiceReference<S> ref) {
        checkValidity();
        if (ref == null) {
            throw new NullPointerException("Specified service reference cannot be null.");
        }
        Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 463, 14342, 14381);
        if (sm != null) {
            ((SecurityManager) (sm)).checkPermission(new ServicePermission(ref, ServicePermission.GET));
        }
        if (CallChecker.beforeDeref(m_felix, Felix.class, 470, 14546, 14552)) {
            return m_felix.getService(m_bundle, ref, false);
        }else
            throw new AbnormalExecutionError();
        
    }

    public boolean ungetService(ServiceReference<?> ref) {
        MethodContext _bcornu_methode_context1417 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 473, 14599, 14923);
            CallChecker.varInit(ref, "ref", 473, 14599, 14923);
            CallChecker.varInit(this.m_valid, "m_valid", 473, 14599, 14923);
            CallChecker.varInit(this.m_bundle, "m_bundle", 473, 14599, 14923);
            CallChecker.varInit(this.m_felix, "m_felix", 473, 14599, 14923);
            CallChecker.varInit(this.m_logger, "m_logger", 473, 14599, 14923);
            checkValidity();
            if (ref == null) {
                throw new NullPointerException("Specified service reference cannot be null.");
            }
            if (CallChecker.beforeDeref(m_felix, Felix.class, 483, 14876, 14882)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 483, 14876, 14882);
                return CallChecker.isCalled(m_felix, Felix.class, 483, 14876, 14882).ungetService(m_bundle, ref, null);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1417.methodEnd();
        }
    }

    public File getDataFile(String s) {
        MethodContext _bcornu_methode_context1418 = new MethodContext(File.class);
        try {
            CallChecker.varInit(this, "this", 486, 14930, 15276);
            CallChecker.varInit(s, "s", 486, 14930, 15276);
            CallChecker.varInit(this.m_valid, "m_valid", 486, 14930, 15276);
            CallChecker.varInit(this.m_bundle, "m_bundle", 486, 14930, 15276);
            CallChecker.varInit(this.m_felix, "m_felix", 486, 14930, 15276);
            CallChecker.varInit(this.m_logger, "m_logger", 486, 14930, 15276);
            checkValidity();
            if (CallChecker.beforeDeref(m_felix, Felix.class, 495, 15238, 15244)) {
                m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 495, 15238, 15244);
                return CallChecker.isCalled(m_felix, Felix.class, 495, 15238, 15244).getDataFile(m_bundle, s);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((File) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1418.methodEnd();
        }
    }

    private void checkValidity() {
        MethodContext _bcornu_methode_context1419 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 498, 15283, 15640);
            CallChecker.varInit(this.m_valid, "m_valid", 498, 15283, 15640);
            CallChecker.varInit(this.m_bundle, "m_bundle", 498, 15283, 15640);
            CallChecker.varInit(this.m_felix, "m_felix", 498, 15283, 15640);
            CallChecker.varInit(this.m_logger, "m_logger", 498, 15283, 15640);
            if (m_valid) {
                if (CallChecker.beforeDeref(m_bundle, BundleImpl.class, 502, 15369, 15376)) {
                    m_bundle = CallChecker.beforeCalled(m_bundle, BundleImpl.class, 502, 15369, 15376);
                    switch (CallChecker.isCalled(m_bundle, BundleImpl.class, 502, 15369, 15376).getState()) {
                        case Bundle.ACTIVE :
                        case Bundle.STARTING :
                        case Bundle.STOPPING :
                            return ;
                    }
                }
            }
            throw new IllegalStateException("Invalid BundleContext.");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1419.methodEnd();
        }
    }

    public <S> ServiceRegistration<S> registerService(Class<S> clazz, ServiceFactory<S> factory, Dictionary<String, ?> properties) {
        MethodContext _bcornu_methode_context1420 = new MethodContext(ServiceRegistration.class);
        try {
            CallChecker.varInit(this, "this", 517, 15647, 16075);
            CallChecker.varInit(properties, "properties", 517, 15647, 16075);
            CallChecker.varInit(factory, "factory", 517, 15647, 16075);
            CallChecker.varInit(clazz, "clazz", 517, 15647, 16075);
            CallChecker.varInit(this.m_valid, "m_valid", 517, 15647, 16075);
            CallChecker.varInit(this.m_bundle, "m_bundle", 517, 15647, 16075);
            CallChecker.varInit(this.m_felix, "m_felix", 517, 15647, 16075);
            CallChecker.varInit(this.m_logger, "m_logger", 517, 15647, 16075);
            if (CallChecker.beforeDeref(clazz, Class.class, 521, 16030, 16034)) {
                clazz = CallChecker.beforeCalled(clazz, Class.class, 521, 16030, 16034);
                return ((ServiceRegistration<S>) (registerService(new String[]{ CallChecker.isCalled(clazz, Class.class, 521, 16030, 16034).getName() }, factory, properties)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceRegistration<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1420.methodEnd();
        }
    }

    public <S> ServiceObjects<S> getServiceObjects(final ServiceReference<S> ref) {
        MethodContext _bcornu_methode_context1421 = new MethodContext(ServiceObjects.class);
        try {
            CallChecker.varInit(this, "this", 527, 16082, 16747);
            CallChecker.varInit(ref, "ref", 527, 16082, 16747);
            CallChecker.varInit(this.m_valid, "m_valid", 527, 16082, 16747);
            CallChecker.varInit(this.m_bundle, "m_bundle", 527, 16082, 16747);
            CallChecker.varInit(this.m_felix, "m_felix", 527, 16082, 16747);
            CallChecker.varInit(this.m_logger, "m_logger", 527, 16082, 16747);
            checkValidity();
            Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 531, 16313, 16352);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new ServicePermission(ref, ServicePermission.GET));
            }
            ServiceRegistrationImpl reg = CallChecker.init(ServiceRegistrationImpl.class);
            if (CallChecker.beforeDeref(ref, ServiceReference.class, 539, 16604, 16606)) {
                reg = CallChecker.isCalled(((ServiceRegistrationImpl.ServiceReferenceImpl) (ref)), ServiceRegistrationImpl.ServiceReferenceImpl.class, 539, 16604, 16606).getRegistration();
                CallChecker.varAssign(reg, "reg", 539, 16604, 16606);
            }
            if (CallChecker.beforeDeref(reg, ServiceRegistrationImpl.class, 540, 16641, 16643)) {
                reg = CallChecker.beforeCalled(reg, ServiceRegistrationImpl.class, 540, 16641, 16643);
                if (CallChecker.isCalled(reg, ServiceRegistrationImpl.class, 540, 16641, 16643).isValid()) {
                    return new BundleContextImpl.ServiceObjectsImpl(ref);
                }
            }else
                throw new AbnormalExecutionError();
            
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceObjects<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1421.methodEnd();
        }
    }

    class ServiceObjectsImpl<S> implements ServiceObjects<S> {
        private final ServiceReference<S> m_ref;

        public ServiceObjectsImpl(final ServiceReference<S> ref) {
            MethodContext _bcornu_methode_context138 = new MethodContext(null);
            try {
                this.m_ref = ref;
                CallChecker.varAssign(this.m_ref, "this.m_ref", 556, 17005, 17021);
            } finally {
                _bcornu_methode_context138.methodEnd();
            }
        }

        public S getService() {
            checkValidity();
            final Object sm = CallChecker.varInit(System.getSecurityManager(), "sm", 567, 17108, 17396);
            if (sm != null) {
                ((SecurityManager) (sm)).checkPermission(new ServicePermission(m_ref, ServicePermission.GET));
            }
            if (CallChecker.beforeDeref(m_felix, Felix.class, 574, 17583, 17589)) {
                return m_felix.getService(m_bundle, m_ref, true);
            }else
                throw new AbnormalExecutionError();
            
        }

        public void ungetService(final S srvObj) {
            MethodContext _bcornu_methode_context1423 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 577, 17645, 17923);
                CallChecker.varInit(srvObj, "srvObj", 577, 17645, 17923);
                CallChecker.varInit(this.m_ref, "m_ref", 577, 17645, 17923);
                checkValidity();
                if (CallChecker.beforeDeref(m_felix, Felix.class, 582, 17788, 17794)) {
                    m_felix = CallChecker.beforeCalled(m_felix, Felix.class, 582, 17788, 17794);
                    if (!(CallChecker.isCalled(m_felix, Felix.class, 582, 17788, 17794).ungetService(m_bundle, m_ref, srvObj))) {
                        throw new IllegalArgumentException();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1423.methodEnd();
            }
        }

        public ServiceReference<S> getServiceReference() {
            MethodContext _bcornu_methode_context1424 = new MethodContext(ServiceReference.class);
            try {
                CallChecker.varInit(this, "this", 588, 17934, 18027);
                CallChecker.varInit(this.m_ref, "m_ref", 588, 17934, 18027);
                return m_ref;
            } catch (ForceReturn _bcornu_return_t) {
                return ((ServiceReference<S>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1424.methodEnd();
            }
        }
    }
}

