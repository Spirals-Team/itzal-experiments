package org.apache.felix.framework.util;

import java.net.URLConnection;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.Set;
import org.osgi.framework.ServiceReference;
import java.security.SecureRandom;
import org.osgi.resource.Resource;
import java.util.Properties;
import java.io.OutputStream;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import org.apache.felix.framework.Logger;
import java.util.List;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import org.osgi.framework.wiring.BundleWiring;
import org.osgi.framework.wiring.BundleWire;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleRequirement;
import org.osgi.framework.wiring.BundleCapability;
import org.osgi.framework.Bundle;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Collections;
import org.osgi.framework.Constants;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStream;

public class Util {
    private static final String DEFAULT_PROPERTIES_FILE = "default.properties";

    public static Properties loadDefaultProperties(Logger logger) {
        MethodContext _bcornu_methode_context1 = new MethodContext(Properties.class);
        try {
            CallChecker.varInit(logger, "logger", 55, 1909, 2933);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 55, 1909, 2933);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 55, 1909, 2933);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 55, 1909, 2933);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 55, 1909, 2933);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 55, 1909, 2933);
            Properties defaultProperties = CallChecker.varInit(new Properties(), "defaultProperties", 57, 1985, 2032);
            URL propURL = CallChecker.init(URL.class);
            if (CallChecker.beforeDeref(Util.class.getClassLoader(), ClassLoader.class, 58, 2056, 2082)) {
                propURL = CallChecker.isCalled(Util.class.getClassLoader(), ClassLoader.class, 58, 2056, 2082).getResource(Util.DEFAULT_PROPERTIES_FILE);
                CallChecker.varAssign(propURL, "propURL", 58, 2056, 2082);
            }
            if (propURL != null) {
                InputStream is = CallChecker.varInit(null, "is", 61, 2173, 2194);
                TryContext _bcornu_try_context_2 = new TryContext(2, Util.class, "java.lang.Exception");
                try {
                    propURL = CallChecker.beforeCalled(propURL, URL.class, 65, 2292, 2298);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(propURL, URL.class, 65, 2292, 2298).openConnection(), URLConnection.class, 65, 2292, 2315)) {
                        is = CallChecker.isCalled(propURL.openConnection(), URLConnection.class, 65, 2292, 2315).getInputStream();
                        CallChecker.varAssign(is, "is", 65, 2287, 2333);
                    }
                    if (CallChecker.beforeDeref(defaultProperties, Properties.class, 66, 2351, 2367)) {
                        defaultProperties = CallChecker.beforeCalled(defaultProperties, Properties.class, 66, 2351, 2367);
                        CallChecker.isCalled(defaultProperties, Properties.class, 66, 2351, 2367).load(is);
                    }
                    if (CallChecker.beforeDeref(is, InputStream.class, 67, 2395, 2396)) {
                        is = CallChecker.beforeCalled(is, InputStream.class, 67, 2395, 2396);
                        CallChecker.isCalled(is, InputStream.class, 67, 2395, 2396).close();
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_2.catchStart(2);
                    TryContext _bcornu_try_context_1 = new TryContext(1, Util.class, "java.io.IOException");
                    try {
                        if (is != null)
                            is.close();
                        
                    } catch (IOException ex2) {
                        _bcornu_try_context_1.catchStart(1);
                    } finally {
                        _bcornu_try_context_1.finallyStart(1);
                    }
                    if (CallChecker.beforeDeref(logger, Logger.class, 81, 2768, 2773)) {
                        logger = CallChecker.beforeCalled(logger, Logger.class, 81, 2768, 2773);
                        CallChecker.isCalled(logger, Logger.class, 81, 2768, 2773).log(Logger.LOG_ERROR, "Unable to load any configuration properties.", ex);
                    }
                } finally {
                    _bcornu_try_context_2.finallyStart(2);
                }
            }
            return defaultProperties;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Properties) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static String getDefaultProperty(Logger logger, String name) {
        MethodContext _bcornu_methode_context2 = new MethodContext(String.class);
        try {
            CallChecker.varInit(name, "name", 88, 2940, 3180);
            CallChecker.varInit(logger, "logger", 88, 2940, 3180);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 88, 2940, 3180);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 88, 2940, 3180);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 88, 2940, 3180);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 88, 2940, 3180);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 88, 2940, 3180);
            Properties props = CallChecker.varInit(Util.loadDefaultProperties(logger), "props", 90, 3022, 3070);
            return Util.getPropertyWithSubs(props, name);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public static String getPropertyWithSubs(Properties props, String name) {
        MethodContext _bcornu_methode_context3 = new MethodContext(String.class);
        try {
            CallChecker.varInit(name, "name", 95, 3187, 3488);
            CallChecker.varInit(props, "props", 95, 3187, 3488);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 95, 3187, 3488);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 95, 3187, 3488);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 95, 3187, 3488);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 95, 3187, 3488);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 95, 3187, 3488);
            String value = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(props, Properties.class, 98, 3343, 3347)) {
                props = CallChecker.beforeCalled(props, Properties.class, 98, 3343, 3347);
                value = CallChecker.isCalled(props, Properties.class, 98, 3343, 3347).getProperty(name);
                CallChecker.varAssign(value, "value", 98, 3343, 3347);
            }
            if (value != null) {
                value = Util.substVars(value, name, null, props);
                CallChecker.varAssign(value, "value", 99, 3376, 3460);
            }else {
                value = null;
                CallChecker.varAssign(value, "value", 99, 3376, 3460);
            }
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public static Map<String, String> getDefaultPropertiesWithPrefix(Logger logger, String prefix) {
        MethodContext _bcornu_methode_context4 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(prefix, "prefix", 104, 3495, 3720);
            CallChecker.varInit(logger, "logger", 104, 3495, 3720);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 104, 3495, 3720);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 104, 3495, 3720);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 104, 3495, 3720);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 104, 3495, 3720);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 104, 3495, 3720);
            Properties props = CallChecker.varInit(Util.loadDefaultProperties(logger), "props", 106, 3604, 3652);
            return Util.getDefaultPropertiesWithPrefix(props, prefix);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public static Map<String, String> getDefaultPropertiesWithPrefix(Properties props, String prefix) {
        MethodContext _bcornu_methode_context5 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(prefix, "prefix", 110, 3727, 4457);
            CallChecker.varInit(props, "props", 110, 3727, 4457);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 110, 3727, 4457);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 110, 3727, 4457);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 110, 3727, 4457);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 110, 3727, 4457);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 110, 3727, 4457);
            Map<String, String> result = CallChecker.varInit(new HashMap<String, String>(), "result", 112, 3839, 3897);
            Set<String> propertySet = CallChecker.init(Set.class);
            if (CallChecker.beforeDeref(props, Properties.class, 114, 3934, 3938)) {
                props = CallChecker.beforeCalled(props, Properties.class, 114, 3934, 3938);
                propertySet = CallChecker.isCalled(props, Properties.class, 114, 3934, 3938).stringPropertyNames();
                CallChecker.varAssign(propertySet, "propertySet", 114, 3934, 3938);
            }
            if (CallChecker.beforeDeref(propertySet, Map.class, 116, 4003, 4013)) {
                for (String currentPropertyKey : propertySet) {
                    if (CallChecker.beforeDeref(currentPropertyKey, String.class, 118, 4041, 4058)) {
                        if (CallChecker.isCalled(currentPropertyKey, String.class, 118, 4041, 4058).startsWith(prefix)) {
                            String value = CallChecker.init(String.class);
                            if (CallChecker.beforeDeref(props, Properties.class, 120, 4125, 4129)) {
                                props = CallChecker.beforeCalled(props, Properties.class, 120, 4125, 4129);
                                value = CallChecker.isCalled(props, Properties.class, 120, 4125, 4129).getProperty(currentPropertyKey);
                                CallChecker.varAssign(value, "value", 120, 4125, 4129);
                            }
                            if (value != null) {
                                value = Util.substVars(value, currentPropertyKey, null, props);
                                CallChecker.varAssign(value, "value", 122, 4243, 4349);
                            }else {
                                value = null;
                                CallChecker.varAssign(value, "value", 122, 4243, 4349);
                            }
                            if (CallChecker.beforeDeref(result, Map.class, 124, 4367, 4372)) {
                                result = CallChecker.beforeCalled(result, Map.class, 124, 4367, 4372);
                                CallChecker.isCalled(result, Map.class, 124, 4367, 4372).put(currentPropertyKey, value);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public static long getBundleIdFromRevisionId(String id) {
        MethodContext _bcornu_methode_context6 = new MethodContext(long.class);
        try {
            CallChecker.varInit(id, "id", 135, 4464, 5034);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 135, 4464, 5034);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 135, 4464, 5034);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 135, 4464, 5034);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 135, 4464, 5034);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 135, 4464, 5034);
            TryContext _bcornu_try_context_3 = new TryContext(3, Util.class, "java.lang.NumberFormatException");
            try {
                String bundleId = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(id, String.class, 139, 4812, 4813)) {
                    id = CallChecker.beforeCalled(id, String.class, 139, 4812, 4813);
                    if ((CallChecker.isCalled(id, String.class, 139, 4812, 4813).indexOf('.')) >= 0) {
                        if (CallChecker.beforeDeref(id, String.class, 140, 4868, 4869)) {
                            if (CallChecker.beforeDeref(id, String.class, 140, 4852, 4853)) {
                                id = CallChecker.beforeCalled(id, String.class, 140, 4868, 4869);
                                id = CallChecker.beforeCalled(id, String.class, 140, 4852, 4853);
                                bundleId = CallChecker.isCalled(id, String.class, 140, 4852, 4853).substring(0, CallChecker.isCalled(id, String.class, 140, 4868, 4869).indexOf('.'));
                                CallChecker.varAssign(bundleId, "bundleId", 139, 4811, 4888);
                            }
                        }
                    }else {
                        bundleId = id;
                        CallChecker.varAssign(bundleId, "bundleId", 139, 4811, 4888);
                    }
                }
                return Long.parseLong(bundleId);
            } catch (NumberFormatException ex) {
                _bcornu_try_context_3.catchStart(3);
                return -1;
            } finally {
                _bcornu_try_context_3.finallyStart(3);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public static int getModuleRevisionFromModuleId(String id) {
        MethodContext _bcornu_methode_context7 = new MethodContext(int.class);
        try {
            CallChecker.varInit(id, "id", 154, 5041, 5613);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 154, 5041, 5613);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 154, 5041, 5613);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 154, 5041, 5613);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 154, 5041, 5613);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 154, 5041, 5613);
            TryContext _bcornu_try_context_4 = new TryContext(4, Util.class, "java.lang.NumberFormatException");
            try {
                int index = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(id, String.class, 158, 5380, 5381)) {
                    id = CallChecker.beforeCalled(id, String.class, 158, 5380, 5381);
                    index = CallChecker.isCalled(id, String.class, 158, 5380, 5381).indexOf('.');
                    CallChecker.varAssign(index, "index", 158, 5380, 5381);
                }
                if (index >= 0) {
                    if (CallChecker.beforeDeref(id, String.class, 161, 5479, 5480)) {
                        id = CallChecker.beforeCalled(id, String.class, 161, 5479, 5480);
                        return Integer.parseInt(CallChecker.isCalled(id, String.class, 161, 5479, 5480).substring((index + 1)));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            } catch (NumberFormatException ex) {
                _bcornu_try_context_4.catchStart(4);
            } finally {
                _bcornu_try_context_4.finallyStart(4);
            }
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public static String getClassName(String className) {
        MethodContext _bcornu_methode_context8 = new MethodContext(String.class);
        try {
            CallChecker.varInit(className, "className", 170, 5620, 5881);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 170, 5620, 5881);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 170, 5620, 5881);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 170, 5620, 5881);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 170, 5620, 5881);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 170, 5620, 5881);
            if (className == null) {
                className = "";
                CallChecker.varAssign(className, "className", 174, 5731, 5745);
            }
            if (CallChecker.beforeDeref(className, String.class, 176, 5773, 5781)) {
                className = CallChecker.beforeCalled(className, String.class, 176, 5773, 5781);
                if ((CallChecker.isCalled(className, String.class, 176, 5773, 5781).lastIndexOf('.')) < 0) {
                    return "";
                }else {
                    if (CallChecker.beforeDeref(className, String.class, 177, 5824, 5832)) {
                        className = CallChecker.beforeCalled(className, String.class, 177, 5844, 5852);
                        className = CallChecker.beforeCalled(className, String.class, 177, 5824, 5832);
                        return CallChecker.isCalled(className, String.class, 177, 5824, 5832).substring(((CallChecker.isCalled(className, String.class, 177, 5844, 5852).lastIndexOf('.')) + 1));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public static String getClassPackage(String className) {
        MethodContext _bcornu_methode_context9 = new MethodContext(String.class);
        try {
            CallChecker.varInit(className, "className", 180, 5888, 6151);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 180, 5888, 6151);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 180, 5888, 6151);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 180, 5888, 6151);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 180, 5888, 6151);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 180, 5888, 6151);
            if (className == null) {
                className = "";
                CallChecker.varAssign(className, "className", 184, 6002, 6016);
            }
            if (CallChecker.beforeDeref(className, String.class, 186, 6044, 6052)) {
                className = CallChecker.beforeCalled(className, String.class, 186, 6044, 6052);
                if ((CallChecker.isCalled(className, String.class, 186, 6044, 6052).lastIndexOf('.')) < 0) {
                    return "";
                }else {
                    if (CallChecker.beforeDeref(className, String.class, 187, 6118, 6126)) {
                        if (CallChecker.beforeDeref(className, String.class, 187, 6095, 6103)) {
                            className = CallChecker.beforeCalled(className, String.class, 187, 6118, 6126);
                            className = CallChecker.beforeCalled(className, String.class, 187, 6095, 6103);
                            return CallChecker.isCalled(className, String.class, 187, 6095, 6103).substring(0, CallChecker.isCalled(className, String.class, 187, 6118, 6126).lastIndexOf('.'));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public static String getResourcePackage(String resource) {
        MethodContext _bcornu_methode_context10 = new MethodContext(String.class);
        try {
            CallChecker.varInit(resource, "resource", 190, 6158, 7350);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 190, 6158, 7350);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 190, 6158, 7350);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 190, 6158, 7350);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 190, 6158, 7350);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 190, 6158, 7350);
            if (resource == null) {
                resource = "";
                CallChecker.varAssign(resource, "resource", 194, 6273, 6286);
            }
            String pkgName = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(resource, String.class, 207, 7099, 7106)) {
                resource = CallChecker.beforeCalled(resource, String.class, 207, 7099, 7106);
                if (CallChecker.isCalled(resource, String.class, 207, 7099, 7106).startsWith("/")) {
                    if (CallChecker.beforeDeref(resource, String.class, 207, 7127, 7134)) {
                        resource = CallChecker.beforeCalled(resource, String.class, 207, 7127, 7134);
                        pkgName = CallChecker.isCalled(resource, String.class, 207, 7127, 7134).substring(1);
                        CallChecker.varAssign(pkgName, "pkgName", 207, 7098, 7158);
                    }
                }else {
                    pkgName = resource;
                    CallChecker.varAssign(pkgName, "pkgName", 207, 7098, 7158);
                }
            }
            if (CallChecker.beforeDeref(pkgName, String.class, 208, 7180, 7186)) {
                pkgName = CallChecker.beforeCalled(pkgName, String.class, 208, 7180, 7186);
                if ((CallChecker.isCalled(pkgName, String.class, 208, 7180, 7186).lastIndexOf('/')) < 0) {
                    pkgName = "";
                    CallChecker.varAssign(pkgName, "pkgName", 208, 7169, 7275);
                }else {
                    if (CallChecker.beforeDeref(pkgName, String.class, 209, 7250, 7256)) {
                        if (CallChecker.beforeDeref(pkgName, String.class, 209, 7229, 7235)) {
                            pkgName = CallChecker.beforeCalled(pkgName, String.class, 209, 7250, 7256);
                            pkgName = CallChecker.beforeCalled(pkgName, String.class, 209, 7229, 7235);
                            pkgName = CallChecker.isCalled(pkgName, String.class, 209, 7229, 7235).substring(0, CallChecker.isCalled(pkgName, String.class, 209, 7250, 7256).lastIndexOf('/'));
                            CallChecker.varAssign(pkgName, "pkgName", 208, 7169, 7275);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(pkgName, String.class, 210, 7295, 7301)) {
                pkgName = CallChecker.beforeCalled(pkgName, String.class, 210, 7295, 7301);
                pkgName = CallChecker.isCalled(pkgName, String.class, 210, 7295, 7301).replace('/', '.');
                CallChecker.varAssign(pkgName, "pkgName", 210, 7285, 7320);
            }
            return pkgName;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public static Class loadClassUsingClass(Class clazz, String name, SecureAction action) {
        MethodContext _bcornu_methode_context11 = new MethodContext(Class.class);
        try {
            CallChecker.varInit(action, "action", 254, 7357, 10711);
            CallChecker.varInit(name, "name", 254, 7357, 10711);
            CallChecker.varInit(clazz, "clazz", 254, 7357, 10711);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 254, 7357, 10711);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 254, 7357, 10711);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 254, 7357, 10711);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 254, 7357, 10711);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 254, 7357, 10711);
            Class loadedClass = CallChecker.varInit(null, "loadedClass", 256, 9498, 9522);
            while (clazz != null) {
                ClassLoader loader = CallChecker.init(ClassLoader.class);
                if (CallChecker.beforeDeref(action, SecureAction.class, 261, 9663, 9668)) {
                    action = CallChecker.beforeCalled(action, SecureAction.class, 261, 9663, 9668);
                    loader = CallChecker.isCalled(action, SecureAction.class, 261, 9663, 9668).getClassLoader(clazz);
                    CallChecker.varAssign(loader, "loader", 261, 9663, 9668);
                }
                if (loader == null) {
                    if (CallChecker.beforeDeref(action, SecureAction.class, 263, 9804, 9809)) {
                        action = CallChecker.beforeCalled(action, SecureAction.class, 263, 9804, 9809);
                        loader = CallChecker.isCalled(action, SecureAction.class, 263, 9804, 9809).getSystemClassLoader();
                        CallChecker.varAssign(loader, "loader", 263, 9776, 9842);
                    }
                }else {
                    loader = loader;
                    CallChecker.varAssign(loader, "loader", 263, 9776, 9842);
                }
                TryContext _bcornu_try_context_5 = new TryContext(5, Util.class, "java.lang.ClassNotFoundException");
                try {
                    if (CallChecker.beforeDeref(loader, ClassLoader.class, 266, 9897, 9902)) {
                        loader = CallChecker.beforeCalled(loader, ClassLoader.class, 266, 9897, 9902);
                        return CallChecker.isCalled(loader, ClassLoader.class, 266, 9897, 9902).loadClass(name);
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (ClassNotFoundException ex) {
                    _bcornu_try_context_5.catchStart(5);
                } finally {
                    _bcornu_try_context_5.finallyStart(5);
                }
                Class[] ifcs = CallChecker.varInit(clazz.getInterfaces(), "ifcs", 276, 10223, 10259);
                ifcs = CallChecker.beforeCalled(ifcs, Class[].class, 277, 10293, 10296);
                for (int i = 0; i < (CallChecker.isCalled(ifcs, Class[].class, 277, 10293, 10296).length); i++) {
                    if (CallChecker.beforeDeref(ifcs, Class[].class, 279, 10375, 10378)) {
                        ifcs = CallChecker.beforeCalled(ifcs, Class[].class, 279, 10375, 10378);
                        loadedClass = Util.loadClassUsingClass(CallChecker.isCalled(ifcs, Class[].class, 279, 10375, 10378)[i], name, action);
                        CallChecker.varAssign(loadedClass, "loadedClass", 279, 10341, 10397);
                    }
                    if (loadedClass != null) {
                        return loadedClass;
                    }
                }
                clazz = clazz.getSuperclass();
                CallChecker.varAssign(clazz, "clazz", 288, 10644, 10673);
            } 
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public static boolean isServiceAssignable(Bundle requester, ServiceReference ref) {
        MethodContext _bcornu_methode_context12 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(ref, "ref", 303, 10718, 12012);
            CallChecker.varInit(requester, "requester", 303, 10718, 12012);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 303, 10718, 12012);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 303, 10718, 12012);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 303, 10718, 12012);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 303, 10718, 12012);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 303, 10718, 12012);
            boolean allow = CallChecker.varInit(((boolean) (true)), "allow", 306, 11254, 11274);
            String[] objectClass = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(ref, ServiceReference.class, 308, 11369, 11371)) {
                ref = CallChecker.beforeCalled(ref, ServiceReference.class, 308, 11369, 11371);
                objectClass = ((String[]) (CallChecker.isCalled(ref, ServiceReference.class, 308, 11369, 11371).getProperty(FelixConstants.OBJECTCLASS)));
                CallChecker.varAssign(objectClass, "objectClass", 308, 11369, 11371);
            }
            objectClass = CallChecker.beforeCalled(objectClass, String[].class, 315, 11803, 11813);
            for (int classIdx = 0; allow && (classIdx < (CallChecker.isCalled(objectClass, String[].class, 315, 11803, 11813).length)); classIdx++) {
                if (CallChecker.beforeDeref(objectClass, String[].class, 317, 11893, 11903)) {
                    if (CallChecker.beforeDeref(ref, ServiceReference.class, 317, 11863, 11865)) {
                        objectClass = CallChecker.beforeCalled(objectClass, String[].class, 317, 11893, 11903);
                        ref = CallChecker.beforeCalled(ref, ServiceReference.class, 317, 11863, 11865);
                        if (!(CallChecker.isCalled(ref, ServiceReference.class, 317, 11863, 11865).isAssignableTo(requester, CallChecker.isCalled(objectClass, String[].class, 317, 11893, 11903)[classIdx]))) {
                            allow = false;
                            CallChecker.varAssign(allow, "allow", 319, 11947, 11960);
                        }
                    }
                }
            }
            return allow;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public static List<BundleCapability> getCapabilityByNamespace(BundleRevision br, String namespace) {
        MethodContext _bcornu_methode_context13 = new MethodContext(List.class);
        try {
            CallChecker.varInit(namespace, "namespace", 332, 12019, 12917);
            CallChecker.varInit(br, "br", 332, 12019, 12917);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 332, 12019, 12917);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 332, 12019, 12917);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 332, 12019, 12917);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 332, 12019, 12917);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 332, 12019, 12917);
            final List<BundleCapability> matching = CallChecker.varInit(new ArrayList(), "matching", 335, 12410, 12465);
            List<BundleCapability> caps = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(br, BundleRevision.class, 336, 12512, 12513)) {
                br = CallChecker.beforeCalled(br, BundleRevision.class, 336, 12512, 12513);
                if ((CallChecker.isCalled(br, BundleRevision.class, 336, 12512, 12513).getWiring()) != null) {
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 337, 12550, 12551)) {
                        br = CallChecker.beforeCalled(br, BundleRevision.class, 337, 12550, 12551);
                        caps = CallChecker.isCalled(br, BundleRevision.class, 337, 12550, 12551).getWiring().getCapabilities(null);
                        CallChecker.varAssign(caps, "caps", 336, 12511, 12632);
                    }
                }else {
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 338, 12601, 12602)) {
                        br = CallChecker.beforeCalled(br, BundleRevision.class, 338, 12601, 12602);
                        caps = CallChecker.isCalled(br, BundleRevision.class, 338, 12601, 12602).getDeclaredCapabilities(null);
                        CallChecker.varAssign(caps, "caps", 336, 12511, 12632);
                    }
                }
            }
            if (caps != null) {
                for (BundleCapability cap : caps) {
                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 343, 12751, 12753)) {
                        final String npe_invocation_var0 = CallChecker.isCalled(cap, BundleCapability.class, 343, 12751, 12753).getNamespace();
                        if (CallChecker.beforeDeref(npe_invocation_var0, String.class, 343, 12751, 12768)) {
                            if (CallChecker.isCalled(npe_invocation_var0, String.class, 343, 12751, 12768).equals(namespace)) {
                                if (CallChecker.beforeDeref(matching, List.class, 345, 12827, 12834)) {
                                    CallChecker.isCalled(matching, List.class, 345, 12827, 12834).add(cap);
                                }
                            }
                        }
                    }
                }
            }
            return matching;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleCapability>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public static List<BundleRequirement> getDynamicRequirements(List<BundleRequirement> reqs) {
        MethodContext _bcornu_methode_context14 = new MethodContext(List.class);
        try {
            CallChecker.varInit(reqs, "reqs", 352, 12924, 13495);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 352, 12924, 13495);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 352, 12924, 13495);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 352, 12924, 13495);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 352, 12924, 13495);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 352, 12924, 13495);
            List<BundleRequirement> result = CallChecker.varInit(new ArrayList<BundleRequirement>(), "result", 355, 13038, 13105);
            if (reqs != null) {
                for (BundleRequirement req : reqs) {
                    String resolution = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(req, BundleRequirement.class, 360, 13240, 13242)) {
                        final Map<String, String> npe_invocation_var1 = CallChecker.isCalled(req, BundleRequirement.class, 360, 13240, 13242).getDirectives();
                        if (CallChecker.beforeDeref(npe_invocation_var1, Map.class, 360, 13240, 13258)) {
                            resolution = CallChecker.isCalled(npe_invocation_var1, Map.class, 360, 13240, 13258).get(Constants.RESOLUTION_DIRECTIVE);
                            CallChecker.varAssign(resolution, "resolution", 360, 13240, 13242);
                        }
                    }
                    if ((resolution != null) && (resolution.equals("dynamic"))) {
                        if (CallChecker.beforeDeref(result, List.class, 363, 13409, 13414)) {
                            result = CallChecker.beforeCalled(result, List.class, 363, 13409, 13414);
                            CallChecker.isCalled(result, List.class, 363, 13409, 13414).add(req);
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRequirement>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public static BundleWire getWire(BundleRevision br, String name) {
        MethodContext _bcornu_methode_context15 = new MethodContext(BundleWire.class);
        try {
            CallChecker.varInit(name, "name", 370, 13502, 14227);
            CallChecker.varInit(br, "br", 370, 13502, 14227);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 370, 13502, 14227);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 370, 13502, 14227);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 370, 13502, 14227);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 370, 13502, 14227);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 370, 13502, 14227);
            if (CallChecker.beforeDeref(br, BundleRevision.class, 372, 13585, 13586)) {
                br = CallChecker.beforeCalled(br, BundleRevision.class, 372, 13585, 13586);
                if ((CallChecker.isCalled(br, BundleRevision.class, 372, 13585, 13586).getWiring()) != null) {
                    List<BundleWire> wires = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 374, 13656, 13657)) {
                        br = CallChecker.beforeCalled(br, BundleRevision.class, 374, 13656, 13657);
                        wires = CallChecker.isCalled(br, BundleRevision.class, 374, 13656, 13657).getWiring().getRequiredWires(null);
                        CallChecker.varAssign(wires, "wires", 374, 13656, 13657);
                    }
                    if (wires != null) {
                        for (BundleWire w : wires) {
                            if (CallChecker.beforeDeref(w, BundleWire.class, 379, 13825, 13825)) {
                                final BundleCapability npe_invocation_var2 = CallChecker.isCalled(w, BundleWire.class, 379, 13825, 13825).getCapability();
                                if (CallChecker.beforeDeref(npe_invocation_var2, BundleCapability.class, 379, 13825, 13841)) {
                                    final String npe_invocation_var3 = CallChecker.isCalled(npe_invocation_var2, BundleCapability.class, 379, 13825, 13841).getNamespace();
                                    if (CallChecker.beforeDeref(npe_invocation_var3, String.class, 379, 13825, 13856)) {
                                        if (CallChecker.beforeDeref(w, BundleWire.class, 381, 13959, 13959)) {
                                            final BundleCapability npe_invocation_var4 = CallChecker.isCalled(w, BundleWire.class, 381, 13959, 13959).getCapability();
                                            if (CallChecker.beforeDeref(npe_invocation_var4, BundleCapability.class, 381, 13959, 13975)) {
                                                final Map<String, Object> npe_invocation_var5 = CallChecker.isCalled(npe_invocation_var4, BundleCapability.class, 381, 13959, 13975).getAttributes();
                                                if (CallChecker.beforeDeref(npe_invocation_var5, Map.class, 381, 13959, 13991)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var5, Map.class, 381, 13959, 13991).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 381, 13959, 14066)) {
                                                        if ((CallChecker.isCalled(npe_invocation_var3, String.class, 379, 13825, 13856).equals(BundleRevision.PACKAGE_NAMESPACE)) && (CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var5, Map.class, 381, 13959, 13991).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 381, 13959, 14066).equals(name))) {
                                                            return w;
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
                            
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleWire) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public static BundleCapability getPackageCapability(BundleRevision br, String name) {
        MethodContext _bcornu_methode_context16 = new MethodContext(BundleCapability.class);
        try {
            CallChecker.varInit(name, "name", 392, 14234, 14908);
            CallChecker.varInit(br, "br", 392, 14234, 14908);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 392, 14234, 14908);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 392, 14234, 14908);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 392, 14234, 14908);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 392, 14234, 14908);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 392, 14234, 14908);
            if (CallChecker.beforeDeref(br, BundleRevision.class, 394, 14336, 14337)) {
                br = CallChecker.beforeCalled(br, BundleRevision.class, 394, 14336, 14337);
                if ((CallChecker.isCalled(br, BundleRevision.class, 394, 14336, 14337).getWiring()) != null) {
                    List<BundleCapability> capabilities = CallChecker.init(List.class);
                    if (CallChecker.beforeDeref(br, BundleRevision.class, 396, 14420, 14421)) {
                        br = CallChecker.beforeCalled(br, BundleRevision.class, 396, 14420, 14421);
                        capabilities = CallChecker.isCalled(br, BundleRevision.class, 396, 14420, 14421).getWiring().getCapabilities(null);
                        CallChecker.varAssign(capabilities, "capabilities", 396, 14420, 14421);
                    }
                    if (capabilities != null) {
                        for (BundleCapability c : capabilities) {
                            if (CallChecker.beforeDeref(c, BundleCapability.class, 401, 14608, 14608)) {
                                final String npe_invocation_var6 = CallChecker.isCalled(c, BundleCapability.class, 401, 14608, 14608).getNamespace();
                                if (CallChecker.beforeDeref(npe_invocation_var6, String.class, 401, 14608, 14623)) {
                                    if (CallChecker.beforeDeref(c, BundleCapability.class, 402, 14693, 14693)) {
                                        final Map<String, Object> npe_invocation_var7 = CallChecker.isCalled(c, BundleCapability.class, 402, 14693, 14693).getAttributes();
                                        if (CallChecker.beforeDeref(npe_invocation_var7, Map.class, 402, 14693, 14709)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var7, Map.class, 402, 14693, 14709).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 402, 14693, 14747)) {
                                                if ((CallChecker.isCalled(npe_invocation_var6, String.class, 401, 14608, 14623).equals(BundleRevision.PACKAGE_NAMESPACE)) && (CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var7, Map.class, 402, 14693, 14709).get(BundleRevision.PACKAGE_NAMESPACE), Object.class, 402, 14693, 14747).equals(name))) {
                                                    return c;
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
                            
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleCapability) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    private static final byte[] encTab = new byte[]{ 65 , 66 , 67 , 68 , 69 , 70 , 71 , 72 , 73 , 74 , 75 , 76 , 77 , 78 , 79 , 80 , 81 , 82 , 83 , 84 , 85 , 86 , 87 , 88 , 89 , 90 , 97 , 98 , 99 , 100 , 101 , 102 , 103 , 104 , 105 , 106 , 107 , 108 , 109 , 110 , 111 , 112 , 113 , 114 , 115 , 116 , 117 , 118 , 119 , 120 , 121 , 122 , 48 , 49 , 50 , 51 , 52 , 53 , 54 , 55 , 56 , 57 , 43 , 47 };

    private static final byte[] decTab = new byte[]{ -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , 62 , -1 , -1 , -1 , 63 , 52 , 53 , 54 , 55 , 56 , 57 , 58 , 59 , 60 , 61 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , 0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 , 11 , 12 , 13 , 14 , 15 , 16 , 17 , 18 , 19 , 20 , 21 , 22 , 23 , 24 , 25 , -1 , -1 , -1 , -1 , -1 , -1 , 26 , 27 , 28 , 29 , 30 , 31 , 32 , 33 , 34 , 35 , 36 , 37 , 38 , 39 , 40 , 41 , 42 , 43 , 44 , 45 , 46 , 47 , 48 , 49 , 50 , 51 , -1 , -1 , -1 , -1 , -1 };

    public static String base64Encode(String s) throws IOException {
        MethodContext _bcornu_methode_context17 = new MethodContext(String.class);
        try {
            CallChecker.varInit(s, "s", 428, 15989, 16102);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 428, 15989, 16102);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 428, 15989, 16102);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 428, 15989, 16102);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 428, 15989, 16102);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 428, 15989, 16102);
            if (CallChecker.beforeDeref(s, String.class, 430, 16080, 16080)) {
                s = CallChecker.beforeCalled(s, String.class, 430, 16080, 16080);
                return Util.encode(CallChecker.isCalled(s, String.class, 430, 16080, 16080).getBytes(), 0);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public static String encode(byte[] in, int len) throws IOException {
        MethodContext _bcornu_methode_context18 = new MethodContext(String.class);
        try {
            CallChecker.varInit(len, "len", 439, 16109, 16923);
            CallChecker.varInit(in, "in", 439, 16109, 16923);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 439, 16109, 16923);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 439, 16109, 16923);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 439, 16109, 16923);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 439, 16109, 16923);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 439, 16109, 16923);
            ByteArrayOutputStream baos = CallChecker.varInit(null, "baos", 441, 16369, 16402);
            ByteArrayInputStream bais = CallChecker.varInit(null, "bais", 442, 16412, 16444);
            TryContext _bcornu_try_context_6 = new TryContext(6, Util.class);
            try {
                baos = new ByteArrayOutputStream();
                CallChecker.varAssign(baos, "baos", 445, 16480, 16514);
                bais = new ByteArrayInputStream(in);
                CallChecker.varAssign(bais, "bais", 446, 16528, 16563);
                Util.encode(bais, baos, len);
                if (CallChecker.beforeDeref(baos, ByteArrayOutputStream.class, 449, 16675, 16678)) {
                    baos = CallChecker.beforeCalled(baos, ByteArrayOutputStream.class, 449, 16675, 16678);
                    return new String(CallChecker.isCalled(baos, ByteArrayOutputStream.class, 449, 16675, 16678).toByteArray());
                }else
                    throw new AbnormalExecutionError();
                
            } finally {
                _bcornu_try_context_6.finallyStart(6);
                if (baos != null) {
                    baos.close();
                }
                if (bais != null) {
                    bais.close();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public static void encode(InputStream in, OutputStream out, int len) throws IOException {
        MethodContext _bcornu_methode_context19 = new MethodContext(void.class);
        try {
            CallChecker.varInit(len, "len", 464, 16930, 18439);
            CallChecker.varInit(out, "out", 464, 16930, 18439);
            CallChecker.varInit(in, "in", 464, 16930, 18439);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 464, 16930, 18439);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 464, 16930, 18439);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 464, 16930, 18439);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 464, 16930, 18439);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 464, 16930, 18439);
            if ((len % 4) != 0) {
                throw new IllegalArgumentException("Length must be a multiple of 4");
            }
            int bits = CallChecker.varInit(((int) (0)), "bits", 475, 17271, 17283);
            int nbits = CallChecker.varInit(((int) (0)), "nbits", 476, 17293, 17306);
            int nbytes = CallChecker.varInit(((int) (0)), "nbytes", 477, 17316, 17330);
            int b = CallChecker.init(int.class);
            in = CallChecker.beforeCalled(in, InputStream.class, 480, 17368, 17369);
            while ((b = CallChecker.isCalled(in, InputStream.class, 480, 17368, 17369).read()) != (-1)) {
                CallChecker.varAssign(b, "b", 480, 17363, 17377);
                bits = (bits << 8) | b;
                CallChecker.varAssign(bits, "bits", 482, 17408, 17430);
                nbits += 8;
                CallChecker.varAssign(nbits, "nbits", 483, 17444, 17454);
                while (nbits >= 6) {
                    nbits -= 6;
                    CallChecker.varAssign(nbits, "nbits", 486, 17517, 17527);
                    if (CallChecker.beforeDeref(Util.encTab, byte[].class, 487, 17555, 17560)) {
                        if (CallChecker.beforeDeref(out, OutputStream.class, 487, 17545, 17547)) {
                            out = CallChecker.beforeCalled(out, OutputStream.class, 487, 17545, 17547);
                            CallChecker.isCalled(out, OutputStream.class, 487, 17545, 17547).write(CallChecker.isCalled(Util.encTab, byte[].class, 487, 17555, 17560)[(63 & (bits >> nbits))]);
                        }
                    }
                    nbytes++;
                    if ((len != 0) && (nbytes >= len)) {
                        if (CallChecker.beforeDeref(out, OutputStream.class, 492, 17727, 17729)) {
                            out = CallChecker.beforeCalled(out, OutputStream.class, 492, 17727, 17729);
                            CallChecker.isCalled(out, OutputStream.class, 492, 17727, 17729).write(13);
                        }
                        if (CallChecker.beforeDeref(out, OutputStream.class, 493, 17764, 17766)) {
                            out = CallChecker.beforeCalled(out, OutputStream.class, 493, 17764, 17766);
                            CallChecker.isCalled(out, OutputStream.class, 493, 17764, 17766).write(10);
                        }
                        nbytes -= len;
                        CallChecker.varAssign(nbytes, "nbytes", 494, 17801, 17814);
                    }
                } 
            } 
            switch (nbits) {
                case 2 :
                    if (CallChecker.beforeDeref(Util.encTab, byte[].class, 502, 17938, 17943)) {
                        if (CallChecker.beforeDeref(out, OutputStream.class, 502, 17928, 17930)) {
                            out = CallChecker.beforeCalled(out, OutputStream.class, 502, 17928, 17930);
                            CallChecker.isCalled(out, OutputStream.class, 502, 17928, 17930).write(CallChecker.isCalled(Util.encTab, byte[].class, 502, 17938, 17943)[(63 & (bits << 4))]);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(out, OutputStream.class, 503, 17983, 17985)) {
                        out = CallChecker.beforeCalled(out, OutputStream.class, 503, 17983, 17985);
                        CallChecker.isCalled(out, OutputStream.class, 503, 17983, 17985).write(61);
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(out, OutputStream.class, 504, 18030, 18032)) {
                        out = CallChecker.beforeCalled(out, OutputStream.class, 504, 18030, 18032);
                        CallChecker.isCalled(out, OutputStream.class, 504, 18030, 18032).write(61);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                case 4 :
                    if (CallChecker.beforeDeref(Util.encTab, byte[].class, 507, 18116, 18121)) {
                        if (CallChecker.beforeDeref(out, OutputStream.class, 507, 18106, 18108)) {
                            out = CallChecker.beforeCalled(out, OutputStream.class, 507, 18106, 18108);
                            CallChecker.isCalled(out, OutputStream.class, 507, 18106, 18108).write(CallChecker.isCalled(Util.encTab, byte[].class, 507, 18116, 18121)[(63 & (bits << 2))]);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    if (CallChecker.beforeDeref(out, OutputStream.class, 508, 18161, 18163)) {
                        out = CallChecker.beforeCalled(out, OutputStream.class, 508, 18161, 18163);
                        CallChecker.isCalled(out, OutputStream.class, 508, 18161, 18163).write(61);
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
            }
            if (len != 0) {
                if (nbytes != 0) {
                    if (CallChecker.beforeDeref(out, OutputStream.class, 516, 18303, 18305)) {
                        out = CallChecker.beforeCalled(out, OutputStream.class, 516, 18303, 18305);
                        CallChecker.isCalled(out, OutputStream.class, 516, 18303, 18305).write(13);
                    }
                    if (CallChecker.beforeDeref(out, OutputStream.class, 517, 18336, 18338)) {
                        out = CallChecker.beforeCalled(out, OutputStream.class, 517, 18336, 18338);
                        CallChecker.isCalled(out, OutputStream.class, 517, 18336, 18338).write(10);
                    }
                }
                if (CallChecker.beforeDeref(out, OutputStream.class, 519, 18379, 18381)) {
                    out = CallChecker.beforeCalled(out, OutputStream.class, 519, 18379, 18381);
                    CallChecker.isCalled(out, OutputStream.class, 519, 18379, 18381).write(13);
                }
                if (CallChecker.beforeDeref(out, OutputStream.class, 520, 18408, 18410)) {
                    out = CallChecker.beforeCalled(out, OutputStream.class, 520, 18408, 18410);
                    CallChecker.isCalled(out, OutputStream.class, 520, 18408, 18410).write(10);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    private static final String DELIM_START = "${";

    private static final String DELIM_STOP = "}";

    public static String substVars(String val, String currentKey, Map cycleMap, Properties configProps) throws IllegalArgumentException {
        MethodContext _bcornu_methode_context20 = new MethodContext(String.class);
        try {
            CallChecker.varInit(configProps, "configProps", 549, 18551, 23477);
            CallChecker.varInit(cycleMap, "cycleMap", 549, 18551, 23477);
            CallChecker.varInit(currentKey, "currentKey", 549, 18551, 23477);
            CallChecker.varInit(val, "val", 549, 18551, 23477);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 549, 18551, 23477);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 549, 18551, 23477);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 549, 18551, 23477);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 549, 18551, 23477);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 549, 18551, 23477);
            if (cycleMap == null) {
                cycleMap = new HashMap();
                CallChecker.varAssign(cycleMap, "cycleMap", 557, 20067, 20091);
            }
            if (CallChecker.beforeDeref(cycleMap, Map.class, 561, 20161, 20168)) {
                cycleMap = CallChecker.beforeCalled(cycleMap, Map.class, 561, 20161, 20168);
                CallChecker.isCalled(cycleMap, Map.class, 561, 20161, 20168).put(currentKey, currentKey);
            }
            int stopDelim = CallChecker.varInit(((int) (-1)), "stopDelim", 569, 20476, 20494);
            int startDelim = CallChecker.varInit(((int) (-1)), "startDelim", 570, 20504, 20523);
            do {
                if (CallChecker.beforeDeref(val, String.class, 574, 20571, 20573)) {
                    val = CallChecker.beforeCalled(val, String.class, 574, 20571, 20573);
                    stopDelim = CallChecker.isCalled(val, String.class, 574, 20571, 20573).indexOf(Util.DELIM_STOP, (stopDelim + 1));
                    CallChecker.varAssign(stopDelim, "stopDelim", 574, 20559, 20609);
                }
                if (stopDelim < 0) {
                    return val;
                }
                if (CallChecker.beforeDeref(val, String.class, 584, 21036, 21038)) {
                    val = CallChecker.beforeCalled(val, String.class, 584, 21036, 21038);
                    startDelim = CallChecker.isCalled(val, String.class, 584, 21036, 21038).indexOf(Util.DELIM_START);
                    CallChecker.varAssign(startDelim, "startDelim", 584, 21023, 21060);
                }
                if (startDelim < 0) {
                    return val;
                }
                while (stopDelim >= 0) {
                    int idx = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(Util.DELIM_START, String.class, 593, 21392, 21402)) {
                        if (CallChecker.beforeDeref(val, String.class, 593, 21354, 21356)) {
                            val = CallChecker.beforeCalled(val, String.class, 593, 21354, 21356);
                            idx = CallChecker.isCalled(val, String.class, 593, 21354, 21356).indexOf(Util.DELIM_START, (startDelim + (CallChecker.isCalled(Util.DELIM_START, String.class, 593, 21392, 21402).length())));
                            CallChecker.varAssign(idx, "idx", 593, 21392, 21402);
                        }
                    }
                    if ((idx < 0) || (idx > stopDelim)) {
                        break;
                    }else
                        if (idx < stopDelim) {
                            startDelim = idx;
                            CallChecker.varAssign(startDelim, "startDelim", 600, 21610, 21626);
                        }
                    
                } 
            } while ((startDelim > stopDelim) && (stopDelim >= 0) );
            String variable = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(Util.DELIM_START, String.class, 611, 22044, 22054)) {
                if (CallChecker.beforeDeref(val, String.class, 611, 22017, 22019)) {
                    val = CallChecker.beforeCalled(val, String.class, 611, 22017, 22019);
                    variable = CallChecker.isCalled(val, String.class, 611, 22017, 22019).substring((startDelim + (CallChecker.isCalled(Util.DELIM_START, String.class, 611, 22044, 22054).length())), stopDelim);
                    CallChecker.varAssign(variable, "variable", 611, 22044, 22054);
                }
            }
            if (CallChecker.beforeDeref(cycleMap, Map.class, 614, 22158, 22165)) {
                cycleMap = CallChecker.beforeCalled(cycleMap, Map.class, 614, 22158, 22165);
                if ((CallChecker.isCalled(cycleMap, Map.class, 614, 22158, 22165).get(variable)) != null) {
                    throw new IllegalArgumentException(("recursive variable reference: " + variable));
                }
            }else
                throw new AbnormalExecutionError();
            
            String substValue = CallChecker.init(String.class);
            if (configProps != null) {
                substValue = configProps.getProperty(variable, null);
                CallChecker.varAssign(substValue, "substValue", 622, 22468, 22561);
            }else {
                substValue = null;
                CallChecker.varAssign(substValue, "substValue", 622, 22468, 22561);
            }
            if (substValue == null) {
                substValue = System.getProperty(variable, "");
                CallChecker.varAssign(substValue, "substValue", 628, 22665, 22710);
            }
            if (CallChecker.beforeDeref(cycleMap, Map.class, 634, 22928, 22935)) {
                cycleMap = CallChecker.beforeCalled(cycleMap, Map.class, 634, 22928, 22935);
                CallChecker.isCalled(cycleMap, Map.class, 634, 22928, 22935).remove(variable);
            }
            if (CallChecker.beforeDeref(val, String.class, 639, 23123, 23125)) {
                if (CallChecker.beforeDeref(Util.DELIM_STOP, String.class, 641, 23217, 23226)) {
                    if (CallChecker.beforeDeref(val, String.class, 641, 23238, 23240)) {
                        if (CallChecker.beforeDeref(val, String.class, 641, 23191, 23193)) {
                            val = CallChecker.beforeCalled(val, String.class, 639, 23123, 23125);
                            val = CallChecker.beforeCalled(val, String.class, 641, 23238, 23240);
                            val = CallChecker.beforeCalled(val, String.class, 641, 23191, 23193);
                            val = ((CallChecker.isCalled(val, String.class, 639, 23123, 23125).substring(0, startDelim)) + substValue) + (CallChecker.isCalled(val, String.class, 641, 23191, 23193).substring((stopDelim + (CallChecker.isCalled(Util.DELIM_STOP, String.class, 641, 23217, 23226).length())), CallChecker.isCalled(val, String.class, 641, 23238, 23240).length()));
                            CallChecker.varAssign(val, "val", 639, 23117, 23251);
                        }
                    }
                }
            }
            val = Util.substVars(val, currentKey, cycleMap, configProps);
            CallChecker.varAssign(val, "val", 645, 23366, 23421);
            return val;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public static boolean isSingleton(BundleRevision revision) {
        MethodContext _bcornu_methode_context21 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(revision, "revision", 658, 23484, 24591);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 658, 23484, 24591);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 658, 23484, 24591);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 658, 23484, 24591);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 658, 23484, 24591);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 658, 23484, 24591);
            revision = CallChecker.beforeCalled(revision, BundleRevision.class, 660, 23885, 23892);
            final List<BundleCapability> caps = CallChecker.varInit(CallChecker.isCalled(revision, BundleRevision.class, 660, 23885, 23892).getDeclaredCapabilities(null), "caps", 660, 23849, 23923);
            if (CallChecker.beforeDeref(caps, boolean.class, 661, 23961, 23964)) {
                for (BundleCapability cap : caps) {
                    if (CallChecker.beforeDeref(cap, BundleCapability.class, 664, 24061, 24063)) {
                        final String npe_invocation_var8 = CallChecker.isCalled(cap, BundleCapability.class, 664, 24061, 24063).getNamespace();
                        if (CallChecker.beforeDeref(npe_invocation_var8, String.class, 664, 24061, 24078)) {
                            if (CallChecker.isCalled(npe_invocation_var8, String.class, 664, 24061, 24078).equals(BundleRevision.BUNDLE_NAMESPACE)) {
                                for (Map.Entry<String, String> entry : CallChecker.isCalled(CallChecker.isCalled(cap, BundleCapability.class, 666, 24186, 24188).getDirectives(), Map.class, 666, 24186, 24204).entrySet()) {
                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 668, 24260, 24264)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 668, 24260, 24264).getKey(), String.class, 668, 24260, 24273)) {
                                            if (CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 668, 24260, 24264).getKey(), String.class, 668, 24260, 24273).equalsIgnoreCase(Constants.SINGLETON_DIRECTIVE)) {
                                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 670, 24393, 24397)) {
                                                    return CallChecker.isCalled(((Boolean) (Boolean.valueOf(CallChecker.isCalled(entry, Map.Entry.class, 670, 24393, 24397).getValue()))), boolean.class, 670, 24377, 24409);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                                break;
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
            _bcornu_methode_context21.methodEnd();
        }
    }

    public static boolean isFragment(BundleRevision revision) {
        MethodContext _bcornu_methode_context22 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(revision, "revision", 687, 24598, 24994);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 687, 24598, 24994);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 687, 24598, 24994);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 687, 24598, 24994);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 687, 24598, 24994);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 687, 24598, 24994);
            revision = CallChecker.beforeCalled(revision, BundleRevision.class, 689, 24932, 24939);
            return ((CallChecker.isCalled(revision, BundleRevision.class, 689, 24932, 24939).getTypes()) & (BundleRevision.TYPE_FRAGMENT)) > 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public static boolean isFragment(Resource resource) {
        MethodContext _bcornu_methode_context23 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(resource, "resource", 692, 25001, 25208);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 692, 25001, 25208);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 692, 25001, 25208);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 692, 25001, 25208);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 692, 25001, 25208);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 692, 25001, 25208);
            if (resource instanceof BundleRevision)
                return Util.isFragment(((BundleRevision) (resource)));
            else
                return false;
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public static List<BundleRevision> getFragments(BundleWiring wiring) {
        MethodContext _bcornu_methode_context24 = new MethodContext(List.class);
        try {
            CallChecker.varInit(wiring, "wiring", 700, 25215, 26110);
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 700, 25215, 26110);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 700, 25215, 26110);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 700, 25215, 26110);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 700, 25215, 26110);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 700, 25215, 26110);
            List<BundleRevision> fragments = CallChecker.varInit(Collections.EMPTY_LIST, "fragments", 702, 25298, 25353);
            if (wiring != null) {
                List<BundleWire> wires = CallChecker.varInit(wiring.getProvidedWires(null), "wires", 705, 25405, 25459);
                if (wires != null) {
                    for (BundleWire w : wires) {
                        if (CallChecker.beforeDeref(w, BundleWire.class, 710, 25591, 25591)) {
                            final BundleCapability npe_invocation_var9 = CallChecker.isCalled(w, BundleWire.class, 710, 25591, 25591).getCapability();
                            if (CallChecker.beforeDeref(npe_invocation_var9, BundleCapability.class, 710, 25591, 25607)) {
                                final String npe_invocation_var10 = CallChecker.isCalled(npe_invocation_var9, BundleCapability.class, 710, 25591, 25607).getNamespace();
                                if (CallChecker.beforeDeref(npe_invocation_var10, String.class, 710, 25591, 25622)) {
                                    if (CallChecker.isCalled(npe_invocation_var10, String.class, 710, 25591, 25622).equals(BundleRevision.HOST_NAMESPACE)) {
                                        if (CallChecker.beforeDeref(fragments, List.class, 714, 25794, 25802)) {
                                            fragments = CallChecker.beforeCalled(fragments, List.class, 714, 25794, 25802);
                                            if (CallChecker.isCalled(fragments, List.class, 714, 25794, 25802).isEmpty()) {
                                                fragments = new ArrayList<BundleRevision>();
                                                CallChecker.varAssign(fragments, "fragments", 716, 25869, 25912);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(w, BundleWire.class, 718, 25978, 25978)) {
                                            final BundleWiring npe_invocation_var11 = CallChecker.isCalled(w, BundleWire.class, 718, 25978, 25978).getRequirerWiring();
                                            if (CallChecker.beforeDeref(npe_invocation_var11, BundleWiring.class, 718, 25978, 25998)) {
                                                if (CallChecker.beforeDeref(fragments, List.class, 718, 25964, 25972)) {
                                                    fragments = CallChecker.beforeCalled(fragments, List.class, 718, 25964, 25972);
                                                    CallChecker.isCalled(fragments, List.class, 718, 25964, 25972).add(CallChecker.isCalled(npe_invocation_var11, BundleWiring.class, 718, 25978, 25998).getRevision());
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
            return fragments;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BundleRevision>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public static String randomUUID() {
        MethodContext _bcornu_methode_context25 = new MethodContext(String.class);
        try {
            CallChecker.varInit(DELIM_STOP, "org.apache.felix.framework.util.Util.DELIM_STOP", 737, 26117, 29857);
            CallChecker.varInit(DELIM_START, "org.apache.felix.framework.util.Util.DELIM_START", 737, 26117, 29857);
            CallChecker.varInit(decTab, "org.apache.felix.framework.util.Util.decTab", 737, 26117, 29857);
            CallChecker.varInit(encTab, "org.apache.felix.framework.util.Util.encTab", 737, 26117, 29857);
            CallChecker.varInit(DEFAULT_PROPERTIES_FILE, "org.apache.felix.framework.util.Util.DEFAULT_PROPERTIES_FILE", 737, 26117, 29857);
            byte[] data = CallChecker.init(byte[].class);
            SecureRandom rng = CallChecker.varInit(new SecureRandom(), "rng", 740, 26520, 26557);
            if (CallChecker.beforeDeref(rng, SecureRandom.class, 741, 26567, 26569)) {
                rng = CallChecker.beforeCalled(rng, SecureRandom.class, 741, 26567, 26569);
                CallChecker.isCalled(rng, SecureRandom.class, 741, 26567, 26569).nextBytes((data = new byte[16]));
                CallChecker.varAssign(data, "data", 741, 26581, 26599);
            }
            long mostSigBits = CallChecker.init(long.class);
            if (CallChecker.beforeDeref(data, byte[].class, 742, 26631, 26634)) {
                data = CallChecker.beforeCalled(data, byte[].class, 742, 26631, 26634);
                mostSigBits = ((CallChecker.isCalled(data, byte[].class, 742, 26631, 26634)[0]) & 255L) << 56;
                CallChecker.varAssign(mostSigBits, "mostSigBits", 742, 26631, 26634);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 743, 26679, 26682)) {
                data = CallChecker.beforeCalled(data, byte[].class, 743, 26679, 26682);
                mostSigBits |= ((CallChecker.isCalled(data, byte[].class, 743, 26679, 26682)[1]) & 255L) << 48;
                CallChecker.varAssign(mostSigBits, "mostSigBits", 743, 26663, 26701);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 744, 26727, 26730)) {
                data = CallChecker.beforeCalled(data, byte[].class, 744, 26727, 26730);
                mostSigBits |= ((CallChecker.isCalled(data, byte[].class, 744, 26727, 26730)[2]) & 255L) << 40;
                CallChecker.varAssign(mostSigBits, "mostSigBits", 744, 26711, 26749);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 745, 26775, 26778)) {
                data = CallChecker.beforeCalled(data, byte[].class, 745, 26775, 26778);
                mostSigBits |= ((CallChecker.isCalled(data, byte[].class, 745, 26775, 26778)[3]) & 255L) << 32;
                CallChecker.varAssign(mostSigBits, "mostSigBits", 745, 26759, 26797);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 746, 26823, 26826)) {
                data = CallChecker.beforeCalled(data, byte[].class, 746, 26823, 26826);
                mostSigBits |= ((CallChecker.isCalled(data, byte[].class, 746, 26823, 26826)[4]) & 255L) << 24;
                CallChecker.varAssign(mostSigBits, "mostSigBits", 746, 26807, 26845);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 747, 26871, 26874)) {
                data = CallChecker.beforeCalled(data, byte[].class, 747, 26871, 26874);
                mostSigBits |= ((CallChecker.isCalled(data, byte[].class, 747, 26871, 26874)[5]) & 255L) << 16;
                CallChecker.varAssign(mostSigBits, "mostSigBits", 747, 26855, 26893);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 748, 26919, 26922)) {
                data = CallChecker.beforeCalled(data, byte[].class, 748, 26919, 26922);
                mostSigBits |= ((CallChecker.isCalled(data, byte[].class, 748, 26919, 26922)[6]) & 15L) << 8;
                CallChecker.varAssign(mostSigBits, "mostSigBits", 748, 26903, 26940);
            }
            mostSigBits |= 4L << 12;
            CallChecker.varAssign(mostSigBits, "mostSigBits", 749, 26950, 26977);
            if (CallChecker.beforeDeref(data, byte[].class, 750, 27027, 27030)) {
                data = CallChecker.beforeCalled(data, byte[].class, 750, 27027, 27030);
                mostSigBits |= (CallChecker.isCalled(data, byte[].class, 750, 27027, 27030)[7]) & 255L;
                CallChecker.varAssign(mostSigBits, "mostSigBits", 750, 27011, 27043);
            }
            long leastSigBits = CallChecker.init(long.class);
            if (CallChecker.beforeDeref(data, byte[].class, 752, 27075, 27078)) {
                data = CallChecker.beforeCalled(data, byte[].class, 752, 27075, 27078);
                leastSigBits = ((CallChecker.isCalled(data, byte[].class, 752, 27075, 27078)[8]) & 63L) << 56;
                CallChecker.varAssign(leastSigBits, "leastSigBits", 752, 27075, 27078);
            }
            leastSigBits |= 2L << 62;
            CallChecker.varAssign(leastSigBits, "leastSigBits", 753, 27107, 27135);
            if (CallChecker.beforeDeref(data, byte[].class, 754, 27192, 27195)) {
                data = CallChecker.beforeCalled(data, byte[].class, 754, 27192, 27195);
                leastSigBits |= ((CallChecker.isCalled(data, byte[].class, 754, 27192, 27195)[9]) & 255L) << 48;
                CallChecker.varAssign(leastSigBits, "leastSigBits", 754, 27175, 27214);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 755, 27241, 27244)) {
                data = CallChecker.beforeCalled(data, byte[].class, 755, 27241, 27244);
                leastSigBits |= ((CallChecker.isCalled(data, byte[].class, 755, 27241, 27244)[10]) & 255L) << 40;
                CallChecker.varAssign(leastSigBits, "leastSigBits", 755, 27224, 27264);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 756, 27291, 27294)) {
                data = CallChecker.beforeCalled(data, byte[].class, 756, 27291, 27294);
                leastSigBits |= ((CallChecker.isCalled(data, byte[].class, 756, 27291, 27294)[11]) & 255L) << 32;
                CallChecker.varAssign(leastSigBits, "leastSigBits", 756, 27274, 27314);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 757, 27341, 27344)) {
                data = CallChecker.beforeCalled(data, byte[].class, 757, 27341, 27344);
                leastSigBits |= ((CallChecker.isCalled(data, byte[].class, 757, 27341, 27344)[12]) & 255L) << 24;
                CallChecker.varAssign(leastSigBits, "leastSigBits", 757, 27324, 27364);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 758, 27391, 27394)) {
                data = CallChecker.beforeCalled(data, byte[].class, 758, 27391, 27394);
                leastSigBits |= ((CallChecker.isCalled(data, byte[].class, 758, 27391, 27394)[13]) & 255L) << 16;
                CallChecker.varAssign(leastSigBits, "leastSigBits", 758, 27374, 27414);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 759, 27441, 27444)) {
                data = CallChecker.beforeCalled(data, byte[].class, 759, 27441, 27444);
                leastSigBits |= ((CallChecker.isCalled(data, byte[].class, 759, 27441, 27444)[14]) & 255L) << 8;
                CallChecker.varAssign(leastSigBits, "leastSigBits", 759, 27424, 27463);
            }
            if (CallChecker.beforeDeref(data, byte[].class, 760, 27490, 27493)) {
                data = CallChecker.beforeCalled(data, byte[].class, 760, 27490, 27493);
                leastSigBits |= (CallChecker.isCalled(data, byte[].class, 760, 27490, 27493)[15]) & 255L;
                CallChecker.varAssign(leastSigBits, "leastSigBits", 760, 27473, 27507);
            }
            int variant = CallChecker.init(int.class);
            int version = CallChecker.init(int.class);
            long timestamp = CallChecker.init(long.class);
            int clockSequence = CallChecker.init(int.class);
            long node = CallChecker.init(long.class);
            int hash = CallChecker.init(int.class);
            int msbHash = CallChecker.varInit(((int) ((int) (mostSigBits ^ (mostSigBits >>> 32)))), "msbHash", 774, 27723, 27779);
            int lsbHash = CallChecker.varInit(((int) ((int) (leastSigBits ^ (leastSigBits >>> 32)))), "lsbHash", 775, 27789, 27847);
            hash = msbHash ^ lsbHash;
            CallChecker.varAssign(hash, "hash", 776, 27857, 27881);
            if ((leastSigBits & -9223372036854775808L) == 0) {
                variant = 0;
                CallChecker.varAssign(variant, "variant", 781, 28049, 28060);
            }else
                if ((leastSigBits & 4611686018427387904L) != 0) {
                    variant = ((int) ((leastSigBits & -2305843009213693952L) >>> 61));
                    CallChecker.varAssign(variant, "variant", 784, 28201, 28262);
                }else {
                    variant = 2;
                    CallChecker.varAssign(variant, "variant", 787, 28339, 28350);
                }
            
            version = ((int) ((mostSigBits & 61440) >>> 12));
            CallChecker.varAssign(version, "version", 791, 28402, 28461);
            if (!((variant != 2) && (version != 1))) {
                long timeLow = CallChecker.varInit(((long) ((mostSigBits & -4294967296L) >>> 32)), "timeLow", 795, 28560, 28617);
                long timeMid = CallChecker.varInit(((long) ((mostSigBits & 4294901760L) << 16)), "timeMid", 796, 28631, 28687);
                long timeHigh = CallChecker.varInit(((long) ((mostSigBits & 4095L) << 48)), "timeHigh", 797, 28701, 28758);
                timestamp = (timeLow | timeMid) | timeHigh;
                CallChecker.varAssign(timestamp, "timestamp", 798, 28772, 28812);
                clockSequence = ((int) ((leastSigBits & 4611404543450677248L) >>> 48));
                CallChecker.varAssign(clockSequence, "clockSequence", 801, 28869, 28936);
                node = leastSigBits & 281474976710655L;
                CallChecker.varAssign(node, "node", 804, 28983, 29026);
            }
            StringBuffer builder = CallChecker.varInit(new StringBuffer(36), "builder", 811, 29097, 29140);
            String msbStr = CallChecker.varInit(Long.toHexString(mostSigBits), "msbStr", 812, 29150, 29195);
            if (CallChecker.beforeDeref(msbStr, String.class, 813, 29209, 29214)) {
                msbStr = CallChecker.beforeCalled(msbStr, String.class, 813, 29209, 29214);
                if ((CallChecker.isCalled(msbStr, String.class, 813, 29209, 29214).length()) < 16) {
                    int diff = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(msbStr, String.class, 814, 29261, 29266)) {
                        msbStr = CallChecker.beforeCalled(msbStr, String.class, 814, 29261, 29266);
                        diff = 16 - (CallChecker.isCalled(msbStr, String.class, 814, 29261, 29266).length());
                        CallChecker.varAssign(diff, "diff", 814, 29261, 29266);
                    }
                    for (int i = 0; i < diff; i++) {
                        if (CallChecker.beforeDeref(builder, StringBuffer.class, 816, 29339, 29345)) {
                            builder = CallChecker.beforeCalled(builder, StringBuffer.class, 816, 29339, 29345);
                            CallChecker.isCalled(builder, StringBuffer.class, 816, 29339, 29345).append('0');
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(builder, StringBuffer.class, 819, 29392, 29398)) {
                builder = CallChecker.beforeCalled(builder, StringBuffer.class, 819, 29392, 29398);
                CallChecker.isCalled(builder, StringBuffer.class, 819, 29392, 29398).append(msbStr);
            }
            if (CallChecker.beforeDeref(builder, StringBuffer.class, 820, 29424, 29430)) {
                builder = CallChecker.beforeCalled(builder, StringBuffer.class, 820, 29424, 29430);
                CallChecker.isCalled(builder, StringBuffer.class, 820, 29424, 29430).insert(8, '-');
            }
            if (CallChecker.beforeDeref(builder, StringBuffer.class, 821, 29456, 29462)) {
                builder = CallChecker.beforeCalled(builder, StringBuffer.class, 821, 29456, 29462);
                CallChecker.isCalled(builder, StringBuffer.class, 821, 29456, 29462).insert(13, '-');
            }
            if (CallChecker.beforeDeref(builder, StringBuffer.class, 822, 29489, 29495)) {
                builder = CallChecker.beforeCalled(builder, StringBuffer.class, 822, 29489, 29495);
                CallChecker.isCalled(builder, StringBuffer.class, 822, 29489, 29495).append('-');
            }
            String lsbStr = CallChecker.varInit(Long.toHexString(leastSigBits), "lsbStr", 823, 29518, 29564);
            if (CallChecker.beforeDeref(lsbStr, String.class, 824, 29578, 29583)) {
                lsbStr = CallChecker.beforeCalled(lsbStr, String.class, 824, 29578, 29583);
                if ((CallChecker.isCalled(lsbStr, String.class, 824, 29578, 29583).length()) < 16) {
                    int diff = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(lsbStr, String.class, 825, 29630, 29635)) {
                        lsbStr = CallChecker.beforeCalled(lsbStr, String.class, 825, 29630, 29635);
                        diff = 16 - (CallChecker.isCalled(lsbStr, String.class, 825, 29630, 29635).length());
                        CallChecker.varAssign(diff, "diff", 825, 29630, 29635);
                    }
                    for (int i = 0; i < diff; i++) {
                        if (CallChecker.beforeDeref(builder, StringBuffer.class, 827, 29708, 29714)) {
                            builder = CallChecker.beforeCalled(builder, StringBuffer.class, 827, 29708, 29714);
                            CallChecker.isCalled(builder, StringBuffer.class, 827, 29708, 29714).append('0');
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(builder, StringBuffer.class, 830, 29761, 29767)) {
                builder = CallChecker.beforeCalled(builder, StringBuffer.class, 830, 29761, 29767);
                CallChecker.isCalled(builder, StringBuffer.class, 830, 29761, 29767).append(lsbStr);
            }
            if (CallChecker.beforeDeref(builder, StringBuffer.class, 831, 29793, 29799)) {
                builder = CallChecker.beforeCalled(builder, StringBuffer.class, 831, 29793, 29799);
                CallChecker.isCalled(builder, StringBuffer.class, 831, 29793, 29799).insert(23, '-');
            }
            if (CallChecker.beforeDeref(builder, StringBuffer.class, 832, 29833, 29839)) {
                builder = CallChecker.beforeCalled(builder, StringBuffer.class, 832, 29833, 29839);
                return CallChecker.isCalled(builder, StringBuffer.class, 832, 29833, 29839).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }
}

